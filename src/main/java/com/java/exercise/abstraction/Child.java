package com.java.exercise.abstraction;

/**
 * Java ensure single inheritance in compilation time
 */
public class Child implements FatherI, MotherI {
    /**
     * Must override, since parent has default impl to avoid the error: inherits unrelated defaults
     */
    @Override
    public void breathe() {
        System.out.println("Child's breathing");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.breathe();
    }
}
