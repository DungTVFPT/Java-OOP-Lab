
import java.util.ArrayList;
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

    private static final Scanner in = new Scanner(System.in);

    public static int checkInputChoice(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid value! Please enter number from [" + min + "-" + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please enetr Y or N!");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputString() {
        while (true) {
            String rerult = in.nextLine().trim();
            if (rerult.isEmpty()) {
                System.err.println("Input empty!");
                System.out.print("Enter again: ");
            } else {
                return rerult;
            }
        }
    }

    public static boolean checkExistID(String id, ArrayList<Student> listStudent) {
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUD() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please enetr U or D!");
            System.out.print("Enter again: ");
        }
    }

    public static int checkIdUD(String id, ArrayList<Student> listStudent) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (id.equalsIgnoreCase(listStudent.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public static String checkInputCourse() {
        while (true) {
            String result = checkInputString();
            if (result.equals("Java")
                    || result.equals(".Net")
                    || result.equals("C/C++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }

    }

    public static boolean checkAO() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("A")) {
                return true;
            }
            if (result.equalsIgnoreCase("O")) {
                return false;
            }
            System.err.println("Please enetr A or O!");
            System.out.print("Enter again: ");
        }
    }


    public static boolean checkExistStudent(String id, String semester, String courseName, ArrayList<Student> listStudent) {
        if (listStudent.stream().anyMatch((student) -> (id.equalsIgnoreCase(student.getId())
                && semester.equalsIgnoreCase(student.getSemester())
                && courseName.equalsIgnoreCase(student.getCourseName())))) {
            return true;
        }
        return false;
    }

    public static String checkInputNewCourse(String idUpdate, String semester, int index, ArrayList<Student> listStudent) {
        while (true) {
            String oldCourseName = listStudent.get(index).getCourseName();
            String newCourseName = checkInputCourse();

            if (idUpdate.equals(listStudent.get(index).getId())
                    && semester.equals(listStudent.get(index).getSemester())
                    && oldCourseName.equals(newCourseName)) {
                System.err.println("Course name has exist, please enter other course name!");
                System.out.print("Enter again: ");
            } else {
                return newCourseName;
            }

        }
    }

}
