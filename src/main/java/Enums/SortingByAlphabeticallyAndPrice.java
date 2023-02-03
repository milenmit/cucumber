package Enums;

    public enum SortingByAlphabeticallyAndPrice {
        PRICE_LOW_TO_HIGH("Price (low to high)", "lohi"),
        PRICE_HIGH_TO_LOW("Price (high to low)", "hilo"),
        NAME_A_TO_Z("Name (A to Z)", "az"),
        NAME_Z_TO_A("Name (Z to A)", "za");
        public String getOption() {
            return option;
        }

        public String getValue() {
            return value;
        }

        private final String option;
        private final String value;

        SortingByAlphabeticallyAndPrice(String option, String value) {
            this.option = option;
            this.value = value;
        }

    }

