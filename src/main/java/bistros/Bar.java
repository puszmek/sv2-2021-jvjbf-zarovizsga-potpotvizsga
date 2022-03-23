package bistros;

public class Bar extends Bistro {

    public Bar(String name, Address address) {
        super(name, address);
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        validateType(menuItem);
        super.addMenuItem(menuItem);
    }

    private void validateType(MenuItem menuItem) {
        if (menuItem.getType() != MenuItemType.DRINK) {
            throw new IllegalArgumentException("Only drink can be added to menu!");
        }
    }

    @Override
    public String getName() {
        return new StringBuilder(super.getName()).append(" (Only Drinks)").toString();
    }
}
