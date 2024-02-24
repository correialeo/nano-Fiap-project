package br.com.fiap.project.view;

public enum Option {
    REGISTER_CATEGORY(1, "Register category"),
    REGISTER_PRODUCT(2, "Register product"),
    MODIFY_PRODUCT(3, "Modify product"),
    VIEW_PRODUCT_BY_ID(4, "View product by ID"),
    VIEW_PRODUCT_BY_CATEGORY(5, "View product by category"),
    END_SYSTEM(6, "Finish the system");

    int id;
    String name;

    Option(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Option setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Option setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
