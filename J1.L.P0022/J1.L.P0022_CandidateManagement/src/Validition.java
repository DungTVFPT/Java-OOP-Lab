
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThinkPro
 */
public class Validition {

    public static Scanner in = new Scanner(System.in);
    private static String Phone_Valid = "^\\d{10}\\d*$";
    private static String Email_Valid = "^[A-za-z][A-Za-z0-9_]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    
    public static int checkInputChoice(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result;
                result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            //check user input phone valid
            if (result.matches(Phone_Valid)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputEmail() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input email valid
            if (result.matches(Email_Valid)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIdExist(String id, ArrayList<Candidate> candidates) {
        for (Candidate candidate : candidates) {
            if(id.equalsIgnoreCase(candidate.getId())){
                return true;
            }
        }
        return false;
    }

    public static int checkInputExperience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputChoice(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    public static boolean checkYN() {
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }
            if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please enter Y or N!");
            System.out.print("Enter again: ");
        }
    }
    
}
