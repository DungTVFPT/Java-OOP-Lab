package Model;


import java.util.Properties;
import java.util.ResourceBundle;
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
class Validition {

    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private static final Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Please enter in range 1 - 3(Vui lòng nhập từ 1 - 3)!");
                System.out.print("Enter again(Nhập lại): ");
            }
        }
    }

    public static void checkInputAccount(ResourceBundle err) {
        while (true) {
            String result = checkInputString(err);
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return;
            }
            System.err.println(err.getString("errCheckInputAccount"));
            System.out.print(err.getString("enterAccountNumber"));
        }
    }

    public static String checkInputPassword(ResourceBundle err) {
        String passWord;
        while (true) {
            passWord = checkInputString(err);
            if (!passWord.matches("^[a-zA-Z0-9]{8,31}$")
                    || passWord.matches("^[0-9]{8,31}$")
                    || passWord.matches("^[a-zA-Z]{8,31}")) {
                System.err.println(err.getString("errPassWord"));
                System.out.print(err.getString("enterPassword"));
                continue;
            }
            return passWord;
        }
    }

    public static boolean checkInputCaptcha(String captchaInput, String captchaGenerated) {
        return captchaInput.equals(captchaGenerated);
    }

    public static String checkInputString(ResourceBundle err) {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println(err.getString("errInputString"));
                System.out.print(err.getString("enterAgain"));
                
            } else {
                return result.trim();
            }
        }
    }

}
