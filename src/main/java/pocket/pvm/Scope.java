package pocket.pvm;

import pocket.pvm.lang.type.PocketClass;
import pocket.pvm.lang.type.PocketObject;

import java.util.Optional;

public class Scope {
    private final SymbolTable symbolTable = new SymbolTable();

    private final Scope outerScope;

    public Scope(Scope outerScope) {
        this.outerScope = outerScope;
    }

    /**
     * Gets a symbol from this scope by a specified name.
     * @param name a specified name
     * @return a symbol from this scope by a specified name
     */
    public Optional<Symbol> getSymbol(String name) {
        Scope curScope = this;
        while (curScope != null) {
            final Optional<Symbol> symbol = curScope.symbolTable.getObject(name);
            if (symbol.isPresent())
                return symbol;

            curScope = curScope.outerScope;
        }

        return Optional.empty();
    }

    public Optional<Symbol> getSymbolFromCurrentScope(String name) {
        return symbolTable.getObject(name);
    }

    /**
     * Puts a symbol to the symbol table of this scope.
     */
    public void putObject(String name, PocketObject pocketObject, PocketClass type) {
        pocketObject.bindClass(type);

        final Optional<Symbol> curSymbol = symbolTable.getObject(name);
        if (curSymbol.isPresent()) {
            final PocketClass pocketClass = curSymbol.get().getType();
            if (pocketClass != type) {
                throw new RuntimeException("Cannot change the type of variable.");
            } else {
                curSymbol.get().setPocketObject(pocketObject);
            }
        } else {
            symbolTable.putObject(name, pocketObject);
        }

        System.out.printf("[Assignment] %s := %s %n", name, pocketObject);
    }

    public void putObject(String name, PocketObject pocketObject) {
        final Optional<Symbol> curSymbol = symbolTable.getObject(name);
        if (curSymbol.isPresent()) {
            // update value
            if (!curSymbol.get().setPocketObject(pocketObject)) {
                throw new RuntimeException("Cannot update the value of a constant variable.");
            }
        } else {
            symbolTable.putObject(name, pocketObject);
        }

        System.out.printf("[Assignment] %s := %s %n", name, pocketObject);
    }
}
