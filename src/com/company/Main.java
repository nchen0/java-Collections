package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("*** Arrays ***");
        // Arrays in java have a fixed length. They also have fixed data types, so when you create an array,  you have to tell java what it will contain, and that's all it can have.
        Dogs[] dogArr = new Dogs[5]; // So index will be 0 - 4.

        dogArr[0] = new Dogs("Springer",50, false);
        dogArr[1] = new Dogs("Bulldog", 50, true);
        dogArr[2] = new Dogs("Collie", 50, false);

        System.out.println("For loop: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(dogArr[i]);
        }

        // Array list

    }
}
