//package pocket.vm;
//
//import pocket.types.PocketFloat;
//import pocket.types.PocketInt;
//import pocket.types.PocketObject;
//
//import java.util.List;
//
//public class VirtualMachine {
//    /**
//     * The outermost environment.
//     */
//    private final Environment environment = new Environment(null);
//
//    /**
//     * Execute an AST.
//     * @param abstractSyntaxTree the ast
//     */
//    public PocketObject execute(AbstractSyntaxTree abstractSyntaxTree) {
//        LogicUnit logicUnit = abstractSyntaxTree.getLogicUnit();
//        List<AbstractSyntaxTree> children = abstractSyntaxTree.getChildren();
//
//        if (logicUnit instanceof Value) {
//            return parseValue((Value) logicUnit);
//        }
//
//        return null;
//    }
//
//    /**
//     * Convert a raw value to a pocket object.
//     * @param value a raw value
//     * @return a pocket object
//     */
//    public PocketObject parseValue(Value value) {
//        if (value instanceof IdValue) {
//            return new PocketObject();
//        } else if (value instanceof IntValue) {
//            return new PocketInt(value.getValue());
//        } else if (value instanceof FloatValue) {
//            return new PocketFloat(value.getValue());
//        }
//
//        return null;
//    }
//}
