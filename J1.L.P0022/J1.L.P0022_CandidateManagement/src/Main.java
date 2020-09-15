
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
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Candidate> candidates = new ArrayList<>();
        
        while(true){
            int choice = Management.menu();
            switch(choice){
                case 1:
                    Management.createExperience(candidates);
                    break;
                case 2:
                    Management.createFresher(candidates);
                    break;
                case 3:
                    Management.createInternship(candidates);
                    break;
                case 4:
                    Management.searching(candidates);
                case 5:
                    return;
            }
        }
        
    }
    
}
