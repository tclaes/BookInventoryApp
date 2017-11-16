package be.tcla.bookinventory.model;

public enum Language {
    DUTCH("NL"),ENGLISH("ENG");

    private String abbreviation;

    Language(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
