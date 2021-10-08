/**
 * Author Ma veasna
 * Date: Oct 6 2021, 
 * * Prototype Design Pattern - Properties
 * * Creational Design pattern
 * * Used when you want to avoid multiple Object creation of same instance; instead you copy the object to new object 
 * * & then we can modify as per our need
 * ! Prototype Design pattern - Implemenation 
 * ! Object which we're copying should provide
 * ! copying feature by implementing Clonable interface
 * ! We can override clone() method to implement as per our need
 */
package com.koompi;

import java.util.ArrayList;

class Prototype implements Cloneable {
    private ArrayList<String> listName;

    public Prototype() {
        listName = new ArrayList<>();
    }

    public Prototype(ArrayList<String> new_list) {
        listName = new_list;
    }

    public void insert_data(String data) {
        listName.add(data);
    }

    public ArrayList<String> getListName() {
        return this.listName;
    }

    public void insert_once() {

        listName.add("Apple");
        listName.add("Tesla");
        listName.add("SpaceX");
        listName.add("Acer");
        listName.add("TSMC");
        listName.add("Google");
        listName.add("Facebook");
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        ArrayList<String> tempList = new ArrayList<>();
        for (String product : listName) {
            tempList.add(product);
        }
        return new Prototype(tempList);
    }
}

public class PrototypePattern {
    public static void execute() {
        Prototype proto = new Prototype();
        proto.insert_once();
        try {

            Prototype clone_obj = proto.clone();

            System.out.println("Original object: " + proto);
            System.out.println("Cloned object: " + clone_obj);
            ArrayList<String> willmodify = clone_obj.getListName();
            willmodify.add("Amazon");
            System.out.println("Original data: " + proto.getListName());
            System.out.println("Modified Date: " + clone_obj.getListName());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
