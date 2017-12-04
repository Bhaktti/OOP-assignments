package Linkedlist;

/**
 * Created by bhakti on 11/27/17.
 */


public class Person {
    public String name;
    public int age;

    public Person next;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println(name + " " + "is" + " " + age + " " + "Years old");
    }

    public String toString() {
        return name;
    }


}

