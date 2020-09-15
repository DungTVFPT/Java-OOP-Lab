/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThinkPro
 */
public class Management {
    public static final String hexDigits = "0123456789ABCDEF";
    
    private static final String BINARY_VALID = "[0-1]*";
    private static final String DECIMAL_VALID = "[0-9]*";
    private static final String HEXADECIMAL_VALID = "[0-9A-F]*";

    public static int menu() {
        System.out.println("\n=========================");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validatition.checkInputIntLimit(1, 4);
        return choice;
    }

    //display choose conver
    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validatition.checkInputIntLimit(1, 2);
        return result;
    }
    
    public static void convertFromBinary() {
        int choice = displayConvert("Binary", "Decimal", "Hexa");
        String err = "Must be enter 0 or 1";
        String binary = Validatition.checkInput("binary", BINARY_VALID, err);
        switch(choice){
            case 1:
                System.out.println("Decimal: " + convertToDecimal(binary, 2));
                break;
            case 2:
                System.out.println("Hexa: " + convertToHexaOrBinary(Integer.toString(convertToDecimal(binary, 2)), 16));
        }
    }

    public static void converFromDecimal() {
        int choice = displayConvert("Decimal", "Binary", "Hexa");
        String err = "Must be enter 0-9 A-F";
        String decimal = Validatition.checkInput("decimal", DECIMAL_VALID, err);
        switch(choice){
            case 1:
                System.out.println("Binary: " + convertToHexaOrBinary(decimal, 2));
                break;
            case 2:
                System.out.println("Hexa: " + convertToHexaOrBinary(decimal, 16));
        }
    }

    public static void converFromHexa() {
        int choice = displayConvert("Decimal", "Binary", "Hexa");
        String err = "Must be enter 0-9 A-F";
        String hexa = Validatition.checkInput("hexa", HEXADECIMAL_VALID, err);
        switch(choice){
            case 1:
                System.out.println("Binary: " + convertToHexaOrBinary(Integer.toString(convertToDecimal(hexa, 16)), 2));
                break;
            case 2:
                System.out.println("Decimal: " + convertToDecimal(hexa, 16));
        }
    }

    public static String convertToHexaOrBinary(String decimal, int base) {
        String result = "";
        int dec = Integer.parseInt(decimal);
        while (dec != 0) {
            result = hexDigits.charAt(dec % base) + result;
            dec /= base;
        }
        return result;
    }

    public static int convertToDecimal(String key, int base) {
        int dec = 0;
        int length = key.length();
        for (int i = 0; i < length; i++) {
            dec += hexDigits.indexOf(key.charAt(length - 1 - i))*Math.pow(base, i);
        }
        return dec;
    }
}
