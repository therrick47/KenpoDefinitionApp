package com.example.therr.kenpodefinitionapp;

import java.io.Serializable;

/**
 * Created by therr on 7/13/2017.
 */

public class Terminology implements Serializable {
    private String name;
    private String def;
    private String belt;

    public Terminology(String newName, String newDef, String newBelt){
        name=newName;
        def=newDef;
        belt=newBelt;
    }

    public String getDef() {
        return def;
    }

    public String getName() {
        return name;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getBelt() {
        return belt;
    }

    @Override
    public String toString(){
        return getName();
    }
}
