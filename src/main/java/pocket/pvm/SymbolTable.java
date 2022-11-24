package pocket.pvm;

import pocket.pvm.lang.type.PocketObject;

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
     * Puts a pocket object in this symbol table.
     * @param name         name to assign
     * @param pocketObject pocket object to put
     */
    void putObject(String name, PocketObject pocketObject) {
        final Symbol symbol = table.get(name);

        if (symbol == null) {
            // create one
            table.put(name, new Symbol(pocketObject));
        } else {
            if (!symbol.isConst()) {
                symbol.setPocketObject(pocketObject);
            } else {
                throw new RuntimeException();
            }
        }
    }
}
