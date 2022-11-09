package twig;

import com.google.gson.Gson;

import java.io.*;
import java.util.Map;

/**
 * Tree printer.
 * @param <T> type of nodes
 * @author James Chan
 */
public class TreePrinter<T> {
    public final static String NAME = "$name$";

    private final String title;

    private final LambdaWrapper<PropertyFetcher<T>> propertyFetcher;

    private final Gson gson = new Gson();

    /**
     * Creates a tree printer.
     * @param title           title of exported file
     * @param propertyFetcher property fetcher
     */
    public TreePrinter(String title, LambdaWrapper<PropertyFetcher<T>> propertyFetcher) {
        this.title = title;
        this.propertyFetcher = propertyFetcher;
    }

    /**
     * Print a tree.
     * @param root the root node of a tree
     */
    public void print(T root) {
        Map<String, Object> propertyMap = propertyFetcher.lambda.fetch(root);
        String jsonString = gson.toJson(propertyMap);
        System.out.println(jsonString);

        String templatePath = getPackageDir() + "/template.html";
        String outputPath = getTargetPackageDir() + "/index.html";
        try (BufferedReader reader = new BufferedReader(new FileReader(templatePath))) {
            StringBuilder builder = new StringBuilder();
            reader.lines().forEach(line -> {
                String _line = line
                        .replace("{{ name }}", title)
                        .replace("{{ jsonString }}", jsonString);
                builder.append(_line).append("\n");
            });

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
                writer.write(builder.toString());
            }

            openFile(outputPath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("IO exception encountered.");
        }
    }

    private String getTargetPackageDir() {
        return TreePrinter.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

    private String getPackageDir() {
        return System.getProperty("user.dir") + "/src/main/java/twig";
    }

    private void openFile(String filepath) throws IOException {
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        Runtime runtime = Runtime.getRuntime();

        if (isWindows) {
            // Windows
            runtime.exec(filepath);
        } else {
            // Mac
            runtime.exec("open " + filepath);
        }
    }
}
