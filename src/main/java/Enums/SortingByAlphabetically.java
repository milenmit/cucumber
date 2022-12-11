package Enums;

    public enum SortingByAlphabetically {
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

        SortingByAlphabetically(String option, String value) {
            this.option = option;
            this.value = value;
        }
}
