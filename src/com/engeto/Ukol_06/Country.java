package com.engeto.Ukol_06;

public class Country {
    private String shortCountryName;
    private String longCountryName;
    private Double basicDph;
    private Double reducedDph;
    private Boolean useSpecialDph;

    public Country(String shortCountryName, String longCountryName, Double basicDph, Double reducedDph, Boolean useSpecialDph) {
        this.shortCountryName = shortCountryName;
        this.longCountryName = longCountryName;
        this.basicDph = basicDph;
        this.reducedDph = reducedDph;
        this.useSpecialDph = useSpecialDph;
    }

    @Override
    public String toString() {
        return longCountryName + " ("+shortCountryName+"): " + basicDph + " %";
    }
}
