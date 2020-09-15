
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
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("3", "Nguyen Van A", "3", "Java"));
        listStudent.add(new Student("1", "Nguyen Van B", "3", ".Net"));
        listStudent.add(new Student("3", "Nguyen Van A", "4", "C/C++"));
        listStudent.add(new Student("7", "Nguyen Van D", "3", ".Net"));
        listStudent.add(new Student("2", "Nguyen Van C", "3", "Java"));
        listStudent.add(new Student("3", "Nguyen Van A", "3", ".Net"));
        listStudent.add(new Student("3", "Nguyen Van A", "3", "Java"));
        
        
        
        int count = 6;
        while (true) {
            Management.menu();
            int choice = Validition.checkInputChoice(1, 5);
            
            switch (choice) {
                case 1:
                    Management.create(listStudent, count);
                    break;
                case 2:
                    Management.findAndSort(listStudent);
                    break;
                case 3:
                    Management.updateDelete(listStudent, count);
                    break;
                case 4:
                    Management.report(listStudent);
                    break;
                case 5:
                    return;
            }
        }
    }
}
