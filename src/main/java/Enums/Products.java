package Enums;

public enum Products {

    SAUCE_BACKPACK("Sauce Backpack"),
    SAUCE_BIKE("Sauce Bike");


    Products(String name) {
        this.name = name;
    }

    private String name;


    public String getName() {
        return name;
    }


}

