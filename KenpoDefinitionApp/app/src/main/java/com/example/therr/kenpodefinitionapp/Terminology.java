package com.example.therr.kenpodefinitionapp;

import java.io.Serializable;

/**
 * Created by therr on 7/13/2017.
 */

public class Terminology implements Serializable {
    private String name;
    private String def;

    public Terminology(String newName, String newDef){
        name=newName;
        def=newDef;
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

    @Override
    public String toString(){
        return getName();
    }
}
