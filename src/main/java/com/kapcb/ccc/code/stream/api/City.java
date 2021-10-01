package com.kapcb.ccc.code.stream.api;

/**
 * <a>Title: City </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-11:12
 */
public class City {

    private String name;
    private String state;
    private int population;

    public City() {
    }

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City = [ name: " + name + ", state=" + state + ", population=" + population + " ]";
    }
}
