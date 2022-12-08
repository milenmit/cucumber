package Enums;

public enum Sorting {

    A_TO_Z("Name (A to Z)", "az"),
    Z_TO_A("Name (Z to A)", "za"),
    PRICE_LOW_TO_HIGH("Price (low to high)", "lohi"),
    PRICE_HIGH_TO_LOW("Price (high to low)", "hilo");

    private final String option;
    private final String value;

    Sorting(String option, String value) {
        this.option = option;
        this.value = value;
    }
}
