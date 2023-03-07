package com.example.superherov3.Model;

public class SuperheroModel {
    private String name;
    private String superPower;
    private String form;
    private int yearIntroduced;
    private double strength;
    //public Message() {}



    public SuperheroModel(String name, String superPower, String form, int yearIntroduced, double strength) {
            this.name = name;
            this.superPower = superPower;
            this.form = form;
            this.yearIntroduced = yearIntroduced;
            this.strength = strength;
        }

        public String getName() {
            return this.name;
        }
        public String getForm() {
            return this.form;
        }
        public String getSuperPower() {
            return this.superPower;
        }
        public double getStrength() {
            return this.strength;
        }
        public int getYearIntroduced() {
            return this.yearIntroduced;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSuperPower(String superPower) {
            this.superPower = superPower;
        }

        public void setForm(String form) {
            this.form = form;
        }

        public void setYearIntroduced(int yearIntroduced) {
            this.yearIntroduced = yearIntroduced;
        }

        public void setStrength(double strength) {
            this.strength = strength;
        }

    @Override
    public String toString() {
        return "SuperheroModel{" +
                "name='" + name + '\'' +
                ", superPower='" + superPower + '\'' +
                ", form='" + form + '\'' +
                ", yearIntroduced=" + yearIntroduced +
                ", strength=" + strength +
                '}';
    }


}
