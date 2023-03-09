package com.example.superherov3.DTO;

import java.util.List;

public class HeroPowerDTO {

    private String heroName;
    private String realName;
    private List<String> powerlist;

    public HeroPowerDTO(String heroName, String realName, List<String> powerlist) {
        this.heroName = heroName;
        this.realName = realName;
        this.powerlist = powerlist;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<String> getPowerlist() {
        return powerlist;
    }

    public void setPowerlist(List<String> powerlist) {
        this.powerlist = powerlist;
    }
}
