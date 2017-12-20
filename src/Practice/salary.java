package Practice;

/**
 * Created by bhakti on 12/3/17.
 */
import java.util.Scanner;
public class salary {

    public static void main (String []args){

        double sum=0;
        int count=0;
        double salary1= 0;
        System.out.println("Enter Salaries, -1 to finish:");
        Scanner in =new Scanner(System.in);
        while (salary1 != -1){

            salary1= in.nextDouble();
            if (salary1 != -1){

              sum =sum+ salary1;
                count++;

            }
        }
    }
}
