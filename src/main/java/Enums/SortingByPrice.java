package Enums;

    public enum SortingByPrice {
        PRICE_LOW_TO_HIGH("Price (low to high)", "lohi"),
        PRICE_HIGH_TO_LOW("Price (high to low)", "hilo");

        public String getOption() {
            return option;
        }

        public String getValue() {
            return value;
        }

        private final String option;
        private final String value;

        SortingByPrice(String option, String value) {
            this.option = option;
            this.value = value;
        }

    }

