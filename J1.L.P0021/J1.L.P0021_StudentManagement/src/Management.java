
import java.util.ArrayList;
import java.util.Collections;
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
public class Management {

    public static void menu() {
        System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.print("Enter the choice: ");
    }

    public static void create(ArrayList<Student> listStudent, int count) {
        if (count > 10) {
            System.out.print("Do U want to continue?: ");
            if (!Validition.checkYN()) {
                return;
            }
        }
        while (true) {
            System.out.print("Enter ID: ");
            String id = Validition.checkInputString();

            String studentName;
            if (Validition.checkExistID(id, listStudent)) {
                studentName = findName(id, listStudent);
                System.err.println("Student Name: " + studentName);
            } else {
                System.out.print("Enter Student Name: ");
                studentName = Validition.checkInputString();
            }
            System.out.print("Enter Semester: ");
            String semester = Validition.checkInputString();
            System.out.print("Enter Course Name: ");
            String courseName = Validition.checkInputCourse();

            if (Validition.checkExistStudent(id, semester, courseName, listStudent)) {
                System.err.println("Student has exist! Please enter other student!");
                continue;
            }

            listStudent.add(new Student(id, studentName, semester, courseName));
            count++;
            System.out.println("Added successfully !!!");
            return;

        }
    }

    public static void findAndSort(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        System.out.print("Enter a name search: ");
        String name = Validition.checkInputString();
        ArrayList<Student> listFind = new ArrayList<>();

        listStudent.stream().filter((student) -> (student.getStudentName().contains(name))).forEachOrdered((student) -> {
            listFind.add(student);
        });

        Collections.sort(listFind);

        System.out.printf("\t%-15s  %-13s  %-10s\n", "Student Name", "Semester", "Course Name");
        listFind.forEach((student) -> {
            System.out.printf("\t%-15s | %-10s | %-10s\n", student.getStudentName(), student.getSemester(), student.getCourseName());
        });

    }

    //Allow user update and delete   
    public static void updateDelete(ArrayList<Student> ls, int count) {
        //if list empty 
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = Validition.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(ls, id);
        //check list empty
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found student.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            //check user want to update or delete
            Scanner in = new Scanner(System.in);
            if (Validition.checkUD()) {
//                System.out.print("Enter name student: ");
//                String name = in.nextLine();
//                if(name.isEmpty()){
//                    name = student.getStudentName();
//                    System.err.println("Student name: " + name);
//                }
//                
//                System.out.print("Enter semester: ");
//                String semester = in.nextLine();
//                if(semester.isEmpty()){
//                    semester = student.getSemester();
//                    System.err.println("Semester is: " + semester);
//                }
//                
//                System.out.print("Enter name course: ");
//                String course = in.nextLine();
//                if(course.isEmpty()){
//                    course = student.getCourseName();
//                    System.err.println("Course name is: " + course);
//                }
//                //check student exist or not
//                if (!Validition.checkExistStudent(id, semester, course, ls)) {
//                    if(!name.equalsIgnoreCase(student.getStudentName())){
//                        for (int i = 0; i < ls.size(); i++) {
//                            if(ls.get(i).getId().equalsIgnoreCase(id)){
//                                ls.get(i).setStudentName(name);
//                            }
//                        }
//                    }
//                    student.setSemester(semester);
//                    student.setCourseName(course);
//                    System.err.println("Update successfully!");
//                } else{
//                    System.err.println("Student has exist!");
//                }

                boolean ok = false;

                System.out.print("Enter name student: ");
                String name = in.nextLine();
                boolean okName = false;
                if (name.isEmpty() && name.equals(student.getStudentName())) {
                    System.err.println("Student name: " + student.getStudentName());
                } else {
                    ok = true;
                    okName = true;
                }

                System.out.print("Enter semester: ");
                String semester = in.nextLine();
                boolean okSemester = false;
                if (semester.isEmpty() && semester.equals(student.getSemester())) {
                    System.err.println("Semester: " + student.getSemester());
                } else {
                    ok = true;
                    okName = true;
                }

                System.out.print("Enter name course: ");
                String course = in.nextLine();
                boolean okCourse = false;
                if (course.isEmpty() && course.equals(student.getCourseName())) {
                    System.err.println("Course name is: " + student.getCourseName());
                } else {
                    ok = true;
                    okCourse = true;
                }

                if (!ok) {
                    System.out.println("Not update");
                } else {
                    if (!Validition.checkExistStudent(id, semester, course, ls)) {
                        if (okName) {
                            for (int i = 0; i < ls.size(); i++) {
                                if (ls.get(i).getId().equalsIgnoreCase(id)) {
                                    ls.get(i).setStudentName(name);
                                }
                            }
                        }                        
                        if(okSemester){
                            student.setSemester(semester);
                        }                       
                        if(okCourse){
                            student.setCourseName(course);
                        }                        
                        System.err.println("Update successfully!");
                    } else {
                        System.err.println("Student has exist!");
                    }
                }

                return;
            } else {
                ls.remove(student);
                count--;
                System.err.println("Delete successfully!");
                return;
            }
        }
    }

    //Get student user want to update/delete in list found
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validition.checkInputChoice(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    //Get list student find by id
    public static ArrayList<Student> getListStudentById(ArrayList<Student> ls, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public static void report(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty!");
            return;
        }

        ArrayList<Student> listStudentClone = (ArrayList<Student>) listStudent.clone();
        ArrayList<Report> listRp = new ArrayList<>();

        while (!listStudentClone.isEmpty()) {
            Student student = listStudentClone.get(0);
            int totalCourse = 1;
            for (int i = 1; i < listStudentClone.size(); i++) {
                if (student.getId().equalsIgnoreCase(listStudentClone.get(i).getId())
                        && student.getStudentName().equalsIgnoreCase(listStudentClone.get(i).getStudentName())
                        && student.getCourseName().equalsIgnoreCase(listStudentClone.get(i).getCourseName())) {
                    totalCourse++;
                    listStudentClone.remove(i);
                    i--;
                }
            }
            listRp.add(new Report(student.getStudentName(), student.getCourseName(), totalCourse));
            listStudentClone.remove(0);
        }

        System.out.printf("\t%-15s  %-10s  %-5s\n", "Student Name", "Course Name", "Total course");
        for (int i = 0; i < listRp.size(); i++) {
            System.out.printf("\t%-15s | %-10s | %-5s\n", listRp.get(i).getStudentName(),
                    listRp.get(i).getCourseName(), listRp.get(i).getTotalCourse());
        }
    }

    private static String findName(String id, ArrayList<Student> listStudent) {
        String name = null;
        for (int i = 0; i < listStudent.size(); i++) {
            if (id.equalsIgnoreCase(listStudent.get(i).getId())) {
                name = listStudent.get(i).getStudentName();
            }
        }
        return name;
    }

}
