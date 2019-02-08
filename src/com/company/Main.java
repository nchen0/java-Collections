package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("*** Arrays ***");
        // Arrays in java have a fixed length. They also have fixed data types, so when you create an array,  you have to tell java what it will contain, and that's all it can have.
        Dogs[] dogArr = new Dogs[5]; // So index will be 0 - 4.

        dogArr[0] = new Dogs("Springer",50, false);
        dogArr[1] = new Dogs("Bulldog", 50, true);
        dogArr[2] = new Dogs("Collie", 50, false);
        dogArr[3] = new Dogs("Samoyed", 30, false);
        dogArr[4] = new Dogs("Terrier", 40, false);


        System.out.println("For loop: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(dogArr[i]);
        }

        System.out.println("\n*** ArrayList ***");
        // Array list
        // Array lists have a fix datatype as well
        ArrayList<Dogs>dogsArrayList = new ArrayList<Dogs>();
        System.out.println("\nTesting array list right here");
        for (Dogs e : dogsArrayList) {
            System.out.println(e);
        }

        // Add array we made to array list.
        dogsArrayList.addAll(Arrays.asList(dogArr));
        dogsArrayList.add(new Dogs ("Mutt", 15, true));

        // Array lists keep the order you add them into.
        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println("***");
        // Add adds to it, set does a replace.
        dogsArrayList.set(2, new Dogs("Labrador", 75, false));
        dogsArrayList.forEach(d -> System.out.println(d));

        System.out.println(dogsArrayList.get(3));
        System.out.println("Sort");
        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare (Dogs o1, Dogs o2) {
                return o1.getBreed().compareToIgnoreCase(o2.getBreed());
            }
        });
        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println("***Hash Maps");
        // Hash maps do NOT maintain order. They are essentially dictionaries. We like to do our work on the key as that's optimized the best.
        // key, value, our keys and value have to be of an object, it can't be a base type. int is a base type, Integer is the class integer.
        HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();

        int hashCount = 0;
        for (Dogs d : dogsArrayList) {
            dogsHashMap.put(hashCount, d);
            hashCount++;
            // This takes the array list we created before and puts all of its values into a hash map.
        }

        // If we want to free the memory of the array if we don't need it anymore:
        dogsArrayList.clear();
        System.out.println(dogsHashMap.get(3)); // This searches the key, and finds whatever has the value of 3 and returns the value and prints it out.
        System.out.println(dogsHashMap.size());
        System.out.println(dogsHashMap.remove(3));
        System.out.println(dogsHashMap.get(3));

        System.out.println("****");
        for(Integer i: dogsHashMap.keySet()) {
            System.out.println("Key: " + i + ", Value: " + dogsHashMap.get(i));
        }

        // Ways to sort a hash map: we know we can sort an array list, so we want to put our hash map INTO an array list, and then sort it by the average weight of the dog.
        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>(); // Will create the array list for us, so now we need to add all.
        sortedMap.addAll(dogsHashMap.entrySet());

        Collections.sort(sortedMap, new Comparator<HashMap.Entry<Integer, Dogs>>()
        {
            public int compare(HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2)
            {
                return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
            }
        });

        System.out.println("***");
        for (HashMap.Entry<Integer, Dogs> d : sortedMap)
        {
            System.out.println("Key: " + d.getKey() + " value: " + d.getValue());
        }

        // Hashsets can't have duplicates. If you tried to add a value and it's already in the list, it just ignores it.

        String myStr = "John Mitchell";
        // What if we want to print myStr without vowels.
        System.out.println(myStr.toLowerCase().replaceAll("[aeiou]", ""));
        System.out.println(myStr.charAt(3)); // A string is basically an array of these characters that we can access.
    }
}
