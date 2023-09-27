package patterns.example.commands;

public class ViewCatalogCommand implements Command {
    private final Catalog catalog;

    public ViewCatalogCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        catalog.viewCatalog();
    }
}