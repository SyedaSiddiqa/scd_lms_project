import java.util.ArrayList;
import java.util.List;

public class CatalogueB {

    public static List<String> addItem(List<String> catalogue, String title) {
        catalogue.add(title);
        return catalogue;
    }

    public static int itemCount(List<String> catalogue) {
        return catalogue.size();
    }

    public static void main(String[] args) {
        // Version A: result depends on hidden shared static state
        CatalogueA.addItem("Dune");
        CatalogueA.addItem("Emma");
        System.out.println("Version A count (shared static): "
                + CatalogueA.catalogueCount);

        // Version B: each test supplies its own list, no hidden state
        List<String> first = new ArrayList<>();
        addItem(first, "Dune");
        addItem(first, "Emma");
        List<String> second = new ArrayList<>();
        addItem(second, "Hamlet");
        System.out.println("Version B first list : " + itemCount(first));
        System.out.println("Version B second list: " + itemCount(second));
    }
}
