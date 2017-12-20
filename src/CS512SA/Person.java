package CS512SA;

/**
 * Created by bhakti on 12/12/17.
 */
public class Person {

    private String name;
    private int age;
    private String adress;

    public Person(String name , int age, String adress) {
        this.name = name;
        this.age= age;
        this.adress=adress;
    }

    public static void main(String args[]){

        Person person1= new Person("Bhakti" , 27 ,"SanJose");
        Person person2 = new Person("Vineet" , 27 , "VillaTorino");
        Person person3 = new Person("Shruti" , 27 , " Sunnyvale");
        Person person4 = new Person("Sonali" , 27 , "Sanfernando");
        Person person5 = new Person("Rask" , 27 , "101SanFer");

        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());
        System.out.println(person4.toString());
        System.out.println(person5.toString());

    }

}
