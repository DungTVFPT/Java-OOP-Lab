package Model;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ThinkPro
 */
class Management {

    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    public static int menu() {
        System.out.println("\n-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option(Vui lòng nhập lựa chọn): ");
        int choice = Validition.checkInputIntLimit(1, 3);
        return choice;
    }

    public static void login(ResourceBundle getMesseage) throws FileNotFoundException, IOException {

        System.out.print(getMesseage.getString("enterAccountNumber"));
        Validition.checkInputAccount(getMesseage);
        
        System.out.print(getMesseage.getString("enterPassword"));
        Validition.checkInputPassword(getMesseage);
        
        String captchaGenerated = generateCaptchaText();
        System.out.println("Captcha: " + captchaGenerated);
        System.out.print(getMesseage.getString("enterCaptcha"));
        while (true) {
            String captchaInput = Validition.checkInputString(getMesseage);
            if (Validition.checkInputCaptcha(captchaInput, captchaGenerated)) {
                System.out.println(getMesseage.getString("loginSuccess"));
                return;
            } else {
                System.err.println(getMesseage.getString("errCaptchaIncorrect"));
                System.out.print(getMesseage.getString("enterCaptcha"));
            }
        }
    }

    private static String generateCaptchaText() {
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString().trim();
    }

   

}
