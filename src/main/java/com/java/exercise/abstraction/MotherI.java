package com.java.exercise.abstraction;

public interface MotherI extends GrandInterface{
    @Override
    default void breathe(){
        System.out.println("Mother's breathing");
    }
}
