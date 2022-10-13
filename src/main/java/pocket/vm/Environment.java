package pocket.vm;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    /**
     * The symbol table.
     */
    private final Map<String, Symbol> symbolTable = new HashMap<>();

    /**
     * The outer environment.
     */
    private final Environment outer;

    /**
     * Creates an environment.
     * @param outer the outer environment
     */
    public Environment(Environment outer) {
        this.outer = outer;
    }

    /**
     * Declare a variable.
     * @param name   the name (or identifier) of the variable
     * @param symbol the corresponding symbol
     */
    public void declare(String name, Symbol symbol) {
        symbolTable.put(name, symbol);
    }

    /**
     * Get the symbol by a specified name.
     * @param name a specified name
     * @return the corresponding symbol
     */
    public Symbol getSymbol(String name) {
        if (symbolTable.containsKey(name)) {
            return symbolTable.get(name);
        }

        if (outer != null) {
            return outer.getSymbol(name);
        } else {
            return null;
        }
    }
}
