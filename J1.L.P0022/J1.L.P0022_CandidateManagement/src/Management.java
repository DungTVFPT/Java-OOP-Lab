
import java.util.ArrayList;
import java.util.Calendar;
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

    Scanner in = new Scanner(System.in);

    public static int menu() {
        System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validition.checkInputChoice(1, 5);
        return choice;
    }

    public static void createExperience(ArrayList<Candidate> candidates) {
        while (true) {
            Candidate infoCandidate = getInfoCandidate(candidates);
            System.out.print("Enter year of experience: ");
            int yearExperience = Validition.checkInputExperience(infoCandidate.getBirthDate());
            System.out.print("Enter professional skill: ");
            String proSkill = Validition.checkInputString();

            candidates.add(new Experience(yearExperience, proSkill, infoCandidate.getId(),
                    infoCandidate.getFirstName(), infoCandidate.getLastName(), infoCandidate.getBirthDate(),
                    infoCandidate.getAddress(), infoCandidate.getPhone(), infoCandidate.getEmail(), 0));
            System.out.println("Create successfull!");
            if (!Validition.checkYN()) {
                return;
            }
        }
    }

    public static void createFresher(ArrayList<Candidate> candidates) {
        while (true) {
            Candidate infoCandidate = getInfoCandidate(candidates);
            System.out.print("Enter graduation date: ");
            String graduationDate = Validition.checkInputString();
            System.out.print("Enter graduation rank: ");
            String rank = Validition.checkInputString();
            System.out.print("Enter education: ");
            String education = Validition.checkInputString();

            candidates.add(new Fresher(graduationDate, rank, education, infoCandidate.getId(),
                    infoCandidate.getFirstName(), infoCandidate.getLastName(), infoCandidate.getBirthDate(),
                    infoCandidate.getAddress(), infoCandidate.getPhone(), infoCandidate.getEmail(), 1));
            System.out.println("Create successfull!");
            if (!Validition.checkYN()) {
                return;
            }
        }
    }

    public static void createInternship(ArrayList<Candidate> candidates) {
        while (true) {
            Candidate infoCandidate = getInfoCandidate(candidates);
            System.out.print("Enter majors: ");
            String major = Validition.checkInputString();
            System.out.print("Enter graduation rank: ");
            String semester = Validition.checkInputString();
            System.out.print("Enter education: ");
            String university = Validition.checkInputString();

            candidates.add(new Internship(major, semester, university, infoCandidate.getId(),
                    infoCandidate.getFirstName(), infoCandidate.getLastName(), infoCandidate.getBirthDate(),
                    infoCandidate.getAddress(), infoCandidate.getPhone(), infoCandidate.getEmail(), 1));
            System.out.println("Create successfull!");
            if (!Validition.checkYN()) {
                return;
            }
        }
    }

    private static Candidate getInfoCandidate(ArrayList<Candidate> candidates) {
        while (true) {
            System.out.print("Enter ID: ");
            String id = Validition.checkInputString();
            System.out.print("Enter fisrt name: ");
            String firstName = Validition.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validition.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validition.checkInputChoice(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validition.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validition.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validition.checkInputEmail();

            if (Validition.checkIdExist(id, candidates)) {
                System.out.println("ID has exist!");
                continue;
            }
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, birthDate);
            return candidate;
        }
    }

    public static void searching(ArrayList<Candidate> candidates) {
        printListCandidates(candidates);
        System.out.print("Input Candidate name (First name or Last name): ");
        String name = Validition.checkInputString();
        System.out.println("Input type of candidate: ");
        int type = Validition.checkInputChoice(0, 2);
        System.err.println("The candidates found:");
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateType() == type
                    && candidate.getFirstName().contains(name)
                    || candidate.getLastName().contains(name)) {
                System.out.println(candidate.toString());
            }

        }
    }

    private static void printListCandidates(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }

}
