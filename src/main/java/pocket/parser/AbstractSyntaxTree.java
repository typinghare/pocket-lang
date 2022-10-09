package pocket.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract syntax tree.
 * @author James Chan
 */
public class AbstractSyntaxTree {
    private final Object item;

    private final List<AbstractSyntaxTree> children = new ArrayList<>();

    public AbstractSyntaxTree(Object item) {
        this.item = item;
    }

    public List<AbstractSyntaxTree> getChildren() {
        return children;
    }

    public Object getItem() {
        return item;
    }
}
