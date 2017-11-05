import java.util.Scanner;

public class PhoneNumberFormatter {

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phone number");
        String input = scanner.nextLine();
        try {
            PhoneNumberFormatter numberFormatter = new PhoneNumberFormatter();
            String format = numberFormatter.format(input);
            System.out.println("Formatted Number => " + format);
        }catch (Exception ex){
            System.out.println("Error Occurred => "+ex.getMessage());
        }
    }

    public String format(String phoneNumber) throws Exception {
        if (isValidNumber(phoneNumber))
        {
            String toPrint = "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
            return toPrint;
        }
        throw new Exception("Invalid Phone Number => " + " " + phoneNumber);
    }

    private boolean isValidNumber(String phoneNumber) {
        return (phoneNumber != null) && (phoneNumber.length() == 10) && (!phoneNumber.matches("[a-zA-Z_]+"));
    }

}
