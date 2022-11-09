package pocket.parser;

import org.junit.Test;
import pocket.ast.Ast;
import pocket.vm.Pvm;

public class VmTest {
    @Test
    public void runAST() {
        final Ast ast = AstTest.getAst();

        // run it
        new Pvm(ast).run();
    }
}
