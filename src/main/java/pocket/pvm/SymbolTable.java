package pocket.pvm;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Symbol table.
 */
public class SymbolTable {
    private final Map<String, Symbol> table = new HashMap<>();

    /**
     * Returns a pocket object of a specified name.
     * @param name a specified name.
     * @return a pocket object of a specified name
     */
    Optional<Symbol> getObject(String name) {
        return Optional.ofNullable(table.get(name));
    }

    /**
     * Puts a symbol in this symbol table.
     * @param name   name of the symbol
     * @param symbol symbol to put
     */
    void putObject(String name, Symbol symbol) {
        table.put(name, symbol);
    }
}
