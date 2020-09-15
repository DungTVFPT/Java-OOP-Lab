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
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while(true){
            int choice = Management.menu();
            switch(choice){
                case 1:
                    Management.convertFromBinary();
                    break;
                case 2:
                    Management.converFromDecimal();
                    break;
                case 3:
                    Management.converFromHexa();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
