
import java.util.ArrayList;

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
        ArrayList<Task> list = new ArrayList<>();
        while(true){
            int choice = Management.menu();
            switch(choice){
                case 1:
                    Management.addTask(list);
                    break;
                case 2:
                    Management.deleteTask(list);
                    break;
                case 3:
                    Management.displayTask(list);
                    break;
                case 4:
                    return;
            }
        }
        
    }
    
}
