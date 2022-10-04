package pocket.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * A parser tree.
 * @author James Chan
 */
public class ParseTree {
    final ParseUnit item;

    final List<ParseTree> children = new ArrayList<>();

    ParseTree(ParseUnit item) {
        this.item = item;
    }

    void add(ParseTree parseTree) {
        this.children.add(parseTree);
    }

    boolean isLeaf() {
        return children.size() == 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
