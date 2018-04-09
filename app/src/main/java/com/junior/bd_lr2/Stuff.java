package com.junior.bd_lr2;



public class Stuff {

    private int intStuff;
    private String stuff;
    private String anotherStuff;
    private float floatStuff;

    @Override
    public String toString() {
        return intStuff + " " + stuff + " " + anotherStuff + " " + floatStuff;
    }

    public int getIntStuff() {
        return intStuff;
    }

    public void setIntStuff(int intStuff) {
        this.intStuff = intStuff;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public String getAnotherStuff() {
        return anotherStuff;
    }

    public void setAnotherStuff(String anotherStuff) {
        this.anotherStuff = anotherStuff;
    }

    public float getFloatStuff() {
        return floatStuff;
    }

    public void setFloatStuff(float floatStuff) {
        this.floatStuff = floatStuff;
    }

    public Stuff(int id, String stuff, String anotherStuff, float floatStuff) {
        this.intStuff = id;
        this.stuff = stuff;
        this.anotherStuff = anotherStuff;
        this.floatStuff = floatStuff;
    }
}
