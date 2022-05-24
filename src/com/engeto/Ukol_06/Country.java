package com.engeto.Ukol_06;

public class Country implements Comparable<Country> {
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

    public Double getBasicDph() {
        return basicDph;
    }

    public String getShortCountryName() {
        return shortCountryName;
    }

    public String getLongCountryName() {
        return longCountryName;
    }

    public Double getReducedDph() {
        return reducedDph;
    }

    public Boolean getUseSpecialDph() {
        return useSpecialDph;
    }

    @Override
    public String toString() {
        return longCountryName + " ("+shortCountryName+"): " + basicDph + " %";
    }


    @Override
    public int compareTo(Country other) {
        int compareDPH = basicDph.compareTo(other.basicDph);
        return compareDPH;
    }
}
