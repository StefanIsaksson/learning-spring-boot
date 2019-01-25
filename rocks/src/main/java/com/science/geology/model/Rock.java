package com.science.geology.model;

import javax.persistence.*;

@Entity
public class Rock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long uniquekey;

    String name;

    @Column(name="ROCK_TYPE")
    String rockType;

    @Column(name="VISUAL_DESCRIPTION")
    String visualDescription;

    @Column(name="PICTURE_URL")
    String pictureUrl;

    @Column(name="ROCK_FORMATION")
    String rockFormation;

    @Column(name="MINERAL_COMPOSITION")
    String mineralComposition;

    String location;

    @Column(name="MOHS_SCALE")
    Integer mohsScale;

    public Rock() {};

    public Rock(Long uniquekey, String name, String rockType, String visualDescription, String pictureUrl, String rockFormation, String mineralComposition, String location, Integer mohsScale) {
        this.uniquekey = uniquekey;
        this.name = name;
        this.rockType = rockType;
        this.visualDescription = visualDescription;
        this.pictureUrl = pictureUrl;
        this.rockFormation = rockFormation;
        this.mineralComposition = mineralComposition;
        this.location = location;
        this.mohsScale = mohsScale;
    }

    public Long getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(Long uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRockType() {
        return rockType;
    }

    public void setRockType(String rockType) {
        this.rockType = rockType;
    }

    public String getVisualDescription() {
        return visualDescription;
    }

    public void setVisualDescription(String visualDescription) {
        this.visualDescription = visualDescription;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getRockFormation() {
        return rockFormation;
    }

    public void setRockFormation(String rockFormation) {
        this.rockFormation = rockFormation;
    }

    public String getMineralComposition() {
        return mineralComposition;
    }

    public void setMineralComposition(String mineralComposition) {
        this.mineralComposition = mineralComposition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMohsScale() {
        return mohsScale;
    }

    public void setMohsScale(Integer mohsScale) {
        this.mohsScale = mohsScale;
    }
}
