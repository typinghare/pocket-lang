package twig;

import java.util.Map;

@FunctionalInterface
public interface PropertyFetcher<N> {
    /**
     * @param node a node on the tree
     * @return properties map
     */
    Map<String, Object> fetch(N node);
}
