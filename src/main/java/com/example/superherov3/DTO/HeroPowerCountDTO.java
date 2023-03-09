package com.example.superherov3.DTO;

public class HeroPowerCountDTO {

    private String heroName;
    private String realName;
    private int num_powers;

    public HeroPowerCountDTO(String heroName, String realName, int num_powers) {
        this.heroName = heroName;
        this.realName = realName;
        this.num_powers = num_powers;
    }


    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getNum_powers() {
        return num_powers;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setNum_powers(int num_powers) {
        this.num_powers = num_powers;
    }
}
