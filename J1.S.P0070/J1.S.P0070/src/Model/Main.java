package Model;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
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
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ResourceBundle getBundle;
        String base = "Model.Language";
        Locale locale;

        while (true) {
            int choice = Management.menu();
            switch (choice) {
                case 1:                   
                    locale = new Locale("vi", "VN");
                    getBundle = ResourceBundle.getBundle(base, locale);
                    Management.login(getBundle);
                    break;
                case 2:
                    locale = new Locale("en", "US");
                    getBundle = ResourceBundle.getBundle(base, locale);
                    Management.login(getBundle);
                    break;
                case 3:
                    return;
            }
        }
    }

}
