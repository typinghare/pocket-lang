package pocket.ast;

import pocket.ast.stmt.Stmt;

public class Ast {
    private final Stmt root;

    public Ast(Stmt root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
