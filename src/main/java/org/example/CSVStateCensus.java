package org.example;

public class CSVStateCensus {
    private String state;
    private Long population;
    private Long areaInSqKm;
    private Long densityPerSqKm;

    public CSVStateCensus() {

    }

    public CSVStateCensus(String state, Long population, Long areaInSqKm, Long densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(Long areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public Long getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(Long densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }
}
