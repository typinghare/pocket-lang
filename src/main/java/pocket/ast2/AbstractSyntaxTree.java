package pocket.ast2;

import java.util.ArrayList;
import java.util.List;

public class AbstractSyntaxTree {
    private final LogicUnit logicUnit;

    private final List<AbstractSyntaxTree> children = new ArrayList<>();

    public AbstractSyntaxTree(LogicUnit logicUnit) {
        this.logicUnit = logicUnit;
    }

    public List<AbstractSyntaxTree> getChildren() {
        return children;
    }

    public LogicUnit getLogicUnit() {
        return logicUnit;
    }
}
