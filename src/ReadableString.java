import java.util.Scanner;

/**
 * Created by bhakti on 11/4/17.
 */
public class ReadableString {

    public static void main (String[] args){
        //Enter the phone number
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter the phone number");
        String input = scanner.nextLine();
        String number = null;
        String formatted = null;

        if (number != null && number.length() == 10) {

            input = input.substring(0, 0) + "(" + input.substring(0,3) + ")" + input.substring(3,6) + "-" + input.substring(6, input.length());
            System.out.println(input);
        }



    }
}
