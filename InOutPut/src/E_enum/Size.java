package E_enum;

public enum  Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL"), EXTRA2_LARGE("2XL"), EXTRA3_LARGE("3XL");

    private String abbreviation;
    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
