
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
public class Management {

    public static int menu() {
        System.out.println("\n========= Task program =========");
        System.out.println("\t1. Add Task");
        System.out.println("\t2. Delete Task");
        System.out.println("\t3. Display Task");
        System.out.println("\t4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Valadition.checkInputLimit(1, 4);
        return choice;
    }

    public static void addTask(ArrayList<Task> list) {
        System.out.println("------------Add Task---------------");

        System.out.print("Requirement Name: ");
        String requirementName = Valadition.checkInputString();

        System.out.print("Task Type: ");
        String taskType = Valadition.checkInputTaskType();

        System.out.print("Date: ");
        String date = Valadition.checkInputDate();

        System.out.print("From: ");
        String errPlanFrom = "Plan From must be 8.0, 8.5, ..., 17.0";
        double planFrom = Valadition.checkInputPlan(8.0, 17.0, errPlanFrom);

        System.out.print("To: ");
        String errPlanTo = "Plan To must be more than plan from " + planFrom + " and must be less than or equal 17.5";
        double planTo = Valadition.checkInputPlan(planFrom + 0.5, 17.5, errPlanTo);

        System.out.print("Assignee: ");
        String assignee = Valadition.checkInputString();

        System.out.print("Reviewer: ");
        String reviewer = Valadition.checkInputString();

        int id = list.size() + 1;
        list.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer));

        System.out.println("Add Task Successfully!");
    }

    public static void deleteTask(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.err.println("List empty!!!");
            return;
        }
        System.out.println("---------Del Task------");
        System.out.print("Enter id: ");
        int findIdDel = Valadition.checkInputLimit(1, list.size()) - 1;
        list.remove(findIdDel);
        for (int i = findIdDel; i < list.size(); i++) {
            int newId = list.get(i).getId() - 1;
            list.get(i).setId(newId);
        }
        System.out.println("Delete Task Successdully!");
    }

    public static void displayTask(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    list.get(i).getId(),
                    list.get(i).getRequirementName(),
                    list.get(i).getTaskTypeId(),
                    list.get(i).getDate(),
                    list.get(i).getPlanTo() - list.get(i).getPlanFrom(),
                    list.get(i).getAssignee(),
                    list.get(i).getReviewer()
            );

        }
    }

}
