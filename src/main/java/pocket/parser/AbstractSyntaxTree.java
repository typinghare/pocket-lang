package pocket.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract syntax tree.
 * @author James Chan
 */
public class AbstractSyntaxTree {
    final List<AbstractSyntaxTree> children = new ArrayList<>();
}
