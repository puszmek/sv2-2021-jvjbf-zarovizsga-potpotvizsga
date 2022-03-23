package bistros;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class City {

    private Set<Bistro> bistros = new LinkedHashSet<>();

    public void addBistro(Bistro bistro) {
        bistros.add(bistro);
    }

    public Bistro findBistroByAddress(Address address) {
        return bistros.stream()
                .filter(bistro -> bistro.getAddress().equals(address))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Bistro!"));
    }

    public Bistro findLongestMenu() {
        return bistros.stream()
                .sorted(Comparator.comparingInt((Bistro bistros) -> bistros.getMenu().size())
                        .reversed())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Bistro!"));

    }

    public List<Bistro> findBistroWithMenuItem(String menuItemName) {
        return bistros.stream()
                .filter(bistro -> bistro.menuContainsItemByName(menuItemName))
                .toList();
    }

    public Set<Bistro> getBistros() {
        return bistros;
    }
}
