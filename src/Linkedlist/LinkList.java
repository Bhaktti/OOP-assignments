package Linkedlist;

/**
 * Created by bhakti on 11/27/17.
 */

public class LinkList {
    private Person first;
    private Person last;

    LinkList() {
        first = null;
        last = null;
    }

    public void accept(Person person) {
        Person tempLast = last;
        person.next = null;
        last = person;
        if(first==null){
            first = person;
        }else{
            tempLast.next = person;
        }
    }

    public void display() {
        Person person = first;
        while (person != null)
        {
            person.display();
            person = person.next;
            System.out.println();
        }

    }

}

