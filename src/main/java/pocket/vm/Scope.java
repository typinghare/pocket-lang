package pocket.vm;

import java.util.Optional;

public class Scope {
    private final SymbolTable symbolTable = new SymbolTable();

    private final Scope outerScope;

    Scope(Scope outerScope) {
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

    public void putSymbol(String name, Symbol symbol) {
        symbolTable.putObject(name, symbol);
    }
}
