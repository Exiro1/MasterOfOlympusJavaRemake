package com.exiro.Object;

import com.exiro.BuildingList.Building;
import com.exiro.BuildingList.BuildingType;
import com.exiro.ConstructionList.Construction;
import com.exiro.ConstructionList.Road;
import com.exiro.Sprite.Sprite;
import com.exiro.SystemCore.BuildingManager;
import com.exiro.SystemCore.PathManager;

import java.util.ArrayList;

public class City {

    private String name;
    private Player owner;
    private CityMap map;
    private ArrayList<Construction> constructions;
    private ArrayList<ObjectClass> inActives = new ArrayList<>();
    private ArrayList<ObjectClass> obj = new ArrayList<>();
    private ArrayList<Sprite> sprites;

    private ArrayList<Building> buildings;
    private int population, popInArrvial;
    private PathManager pathManager;
    private BuildingManager buildingManager;

    public City(String name, Player owner) {
        this.name = name;
        this.owner = owner;
        this.buildings = new ArrayList<>();
        this.population = 0;
        this.sprites = new ArrayList<>();
        this.buildingManager = new BuildingManager(this);
        Road start = new Road(this);
        this.constructions = new ArrayList<>();
        this.map = new CityMap(60, 60, new Case(0, 0, BuildingType.ROAD, start), this);
        this.pathManager = new PathManager(owner, this.map);
        start.build(0, 0);
        start.setActive(true);
        start.setStart(true);


    }

    public City(String name, Player owner, CityMap map, ArrayList<Construction> constructions, ArrayList<Building> buildings, int population) {
        this.name = name;
        this.owner = owner;
        this.map = map;
        this.constructions = constructions;
        this.buildings = buildings;
        this.population = population;
    }

    public ArrayList<ObjectClass> getObj() {
        return obj;
    }

    public void setObj(ArrayList<ObjectClass> obj) {
        this.obj = obj;
    }

    public void addObj(ObjectClass o) {
        synchronized (obj) {
            obj.add(o);
        }
    }

    public void removeObj(ObjectClass o) {
        synchronized (obj) {
            obj.remove(o);
        }
    }

    public void addBuilding(Building o) {
        synchronized (buildings) {
            buildings.add(o);
        }
    }

    public void removeBuildingj(Building o) {
        synchronized (buildings) {
            buildings.remove(o);
        }
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void addSprite(Sprite s) {
        synchronized (sprites) {
            sprites.add(s);
        }
    }

    public void removeSprite(Sprite s) {
        synchronized (sprites) {
            sprites.remove(s);
        }
    }

    public void removeSpriteAll(ArrayList<Sprite> s) {
        synchronized (sprites) {
            sprites.removeAll(s);
        }
    }

    public ArrayList<ObjectClass> getInActives() {
        return inActives;
    }

    public void setInActives(ArrayList<ObjectClass> inActives) {
        this.inActives = inActives;
    }

    public int getPopInArrvial() {
        return popInArrvial;
    }

    public void setPopInArrvial(int popInArrvial) {
        this.popInArrvial = popInArrvial;
    }

    public BuildingManager getBuildingManager() {
        return buildingManager;
    }

    public void setBuildingManager(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public PathManager getPathManager() {
        return pathManager;
    }

    public void setPathManager(PathManager pathManager) {
        this.pathManager = pathManager;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Construction> getConstructions() {
        return constructions;
    }

    public void setConstructions(ArrayList<Construction> constructions) {
        this.constructions = constructions;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public CityMap getMap() {
        synchronized (map) {
            return map;
        }
    }

    public void setMap(CityMap map) {
        this.map = map;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
}
