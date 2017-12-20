package CS512SA;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bhakti on 12/12/17.
 */
public class DataStack extends Person {


    public DataStack(String name, int age, String adress) {
        super(name, age, adress);

    }

    public void push(Person person){
        if (counter >= max) 1222 else {
            ++counter;
            Data.add( person);

        }
    }

}



/*
package StackProgram;
        import java.util.*;

public class DataStack {
    static final int max = 100;
    int counter;
    ArrayList<Person> Data = new ArrayList<Person>(100);

    DataStack() {
        counter = -1;
    }
    public void push(Person person) {
        if (counter >= max) {
            System.out.println("Stack Overflow");
        } else {
            ++counter;
            Data.add( person);

        }
    }
    public void pop() {
        if (counter < 0) {
            System.out.println("Stack Underflow");
        } else {

            Data.remove(counter--);
        }

    }
    public void PrintStack() {

        int i;
        for (i = counter; i >= 0; i--) {
            System.out.println( Data.get(i).name + " " + "is of age " +
                    " " + Data.get(i).age + " lives in " +

                    Data.get(i).address );

        }
        System.out.println("\n");
    }

}

// Person class

package StackProgram;
*Created by Ravali on 12/11/2017


public class Person {
    public String name;
    public int age;
    public String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

}

// Main class

package StackProgram;
public class Main {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        DataStack mystack = new DataStack();
        mystack.push( new Person( "Tom" , 24, "London") );
        mystack.PrintStack();

        mystack.push( new Person( "Jack" , 50, "SFO") );
        mystack.PrintStack();
        mystack.push( new Person( "Harry" , 30, "Newjersy") );
        mystack.PrintStack();
        mystack.pop();
        mystack.PrintStack();
        mystack.push( new Person( "Jhonson" , 55, "Newyork") );
        mystack.PrintStack();

        mystack.pop();
        mystack.PrintStack();
        mystack.push( new Person( "Hank" , 34, "LasVegas" ) );
        mystack.PrintStack();
        mystack.push( new Person ( "Henry" , 15, "Chicago") );
        mystack.PrintStack();

        mystack.pop();
        mystack.PrintStack();

    }
}
*/
