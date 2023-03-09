package com.example.superherov3.Model;

public class SuperheroModel {
    private String heroName;
    private String realName;
    private int yearIntroduced;






    public SuperheroModel(String heroName, String realName, int yearIntroduced) {
        this.heroName = heroName;
        this.realName = realName;
        this.yearIntroduced = yearIntroduced;
    }



    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getYearIntroduced() {
            return this.yearIntroduced;
        }

        public void setName(String name) {
            this.heroName = name;
        }



        public void setYearIntroduced(int yearIntroduced) {
            this.yearIntroduced = yearIntroduced;
        }


    @Override
    public String toString() {
        return "SuperheroModel{" +
                "heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", yearIntroduced=" + yearIntroduced +
                '}';
    }
}
