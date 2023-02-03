package com.java.exercise.abstraction;

public interface FatherI extends GrandInterface{
    @Override
    default void breathe(){
        System.out.println("Father's breathing");
    }
}
