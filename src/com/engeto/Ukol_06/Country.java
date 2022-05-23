package com.engeto.Ukol_06;

public class Country {
    private String shortCountryName;
    private String longCountryName;
    private double basicDph;
    private double reducedDph;
    private boolean useSpecialDph;

    public Country(String shortCountryName, String longCountryName, double basicDph, double reducedDph) {
        this.shortCountryName = shortCountryName;
        this.longCountryName = longCountryName;
        this.basicDph = basicDph;
        this.reducedDph = reducedDph;
        useSpecialDph = false;
    }

    @Override
    public String toString() {
        return longCountryName + "("+shortCountryName+"): " + basicDph + " %";
    }
}
