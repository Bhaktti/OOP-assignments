package Linkedlist;

/**
 * Created by bhakti on 11/28/17.
 */
public class Main {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        linkList.accept(new Person("Adam",54));
        linkList.accept(new Person("John",19));
        linkList.accept(new Person("Julie",23));
        linkList.accept(new Person("Kelly",34));
        linkList.accept(new Person("Peter",22));

        linkList.display();

    }
}