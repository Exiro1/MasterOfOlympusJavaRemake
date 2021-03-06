package com.exiro.BuildingList;

import com.exiro.Object.Case;
import com.exiro.Object.City;
import com.exiro.SystemCore.GameManager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class WaterWell extends Building {


    public WaterWell(boolean isActive, int pop, int xPos, int yPos, ArrayList<Case> cases, boolean built, City city) {
        super(isActive, BuildingType.WATERWELL, "Assets/Building/Waterfall/DefaultWaterfall.png", 118, 94, 2, BuildingCategory.FOOD, pop, 2, 50, 10, xPos, yPos, 2, 2, cases, built, city, 0);
    }

    public static WaterWell DEFAULT() {
        return new WaterWell(false, 0, 0, 0, null, false, GameManager.currentCity);
    }

    @Override
    public void process(double deltaTime) {

    }

    @Override
    public void populate(double deltaTime) {

    }

    @Override
    void addPopulation() {

    }


    @Override
    public BufferedImage getRender() {
        return getImg();
    }
}
