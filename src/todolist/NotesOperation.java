/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author arkan481
 */
public class NotesOperation {

    private List<NotesModel> notesModels = new ArrayList<>();

    public void start() {
        Scanner sc1 = new Scanner(System.in);
        boolean stop = false;
        int option;
        System.out.println("----- Hello Welcome to To Do List App -----\n");
        while (stop == false) {
            showNotes();
            System.out.println("\nEnter Your Option By Number\n");
            System.out.println("1. Add Task\n2. Edit Task\n3. Delete Task\n4. Set Task Done\n5. Exit");
            System.out.print("Your Option: ");
            option = sc1.nextInt();
            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    setTaskDone();
                    break;
                case 5:
                    stop = true;
                    break;
                default:
                    System.out.println("Option Not Found");
                    break;
            }
        }

    }

    private void showNotes() {
        System.out.println("You Currently have " + notesModels.size() + " Task/s\n");
        System.out.format("%2s%15s%15s%15s%15s%15s", "No", "Task Name", "Task Desc", "Due Date", "is Done", "Done On");
        System.out.println("");
        if (notesModels.size() != 0) {
            for (int i = 0; i < notesModels.size(); i++) {
                System.out.format("%2d%15s%15s%15s%15s%15s", i + 1, notesModels.get(i).getTaskName(), notesModels.get(i).getTaskDesc(), notesModels.get(i).getDueDate(), notesModels.get(i).isDone(), notesModels.get(i).getDoneOn());
                System.out.println("");
            }
        }
    }

    private void addTask() {
        boolean stop = false;
        char option;
        NotesModel note;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        while (stop == false) {
            note = new NotesModel();
            System.out.print("The Task Name: ");
            note.setTaskName(sc1.nextLine());
            System.out.print("The Task Desc: ");
            note.setTaskDesc(sc1.nextLine());
            System.out.println("The due date: ");
            note.setDueDate(sc1.nextLine());
            note.setIsDone(false);
            note.setDoneOn("N/A");
            System.out.println("Task Inserted Would You Like to Insert Task Again? (Y\\N)");
            option = sc2.next().charAt(0);
            switch (Character.toUpperCase(option)) {
                case 'Y':
                    stop = false;
                    System.out.println("");
                    notesModels.add(note);
                    note = null;
                    break;
                case 'N':
                    stop = true;
                    notesModels.add(note);
                    break;
                default:
                    System.out.println("Option Not Found");
                    break;

            }
        }

    }

    private void editTask() {
        int index;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        showNotes();
        if (notesModels.size() == 0) {
            System.out.println("You Don't Have Any Notes to be Edited");
        } else {
            System.out.print("Enter the task number: ");
            index = sc1.nextInt();
            index = index - 1;
            NotesModel editedNotes = notesModels.get(index);
            System.out.print("The Task Name: ");
            editedNotes.setTaskName(sc2.nextLine());
            System.out.print("The Task Desc: ");
            editedNotes.setTaskDesc(sc2.nextLine());
            System.out.println("The due date: ");
            editedNotes.setDueDate(sc2.nextLine());
            notesModels.set(index, editedNotes);
        }

    }

    private void deleteTask() {
        int index;
        Scanner sc1 = new Scanner(System.in);
        showNotes();
        if (notesModels.size() == 0) {
            System.out.println("You Don't Have Any Notes to be Deleted");
        } else {
            System.out.print("Enter The Task Number: ");
            index = sc1.nextInt();
            index = index - 1;
            notesModels.remove(index);
        }

    }

    private void setTaskDone() {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int index;
        NotesModel toBeDoneTask;
        showNotes();
        if (notesModels.size() == 0) {
            System.out.println("You Don't Have Any Notes to Set Done!");
        } else {
            System.out.print("Enter The Task Number: ");
            index = sc1.nextInt();
            index = index - 1;
            toBeDoneTask = notesModels.get(index);
            System.out.println("When Did You Done " + notesModels.get(index).getTaskName() + ": ");
            toBeDoneTask.setDoneOn(sc2.nextLine());
            toBeDoneTask.setIsDone(true);
            notesModels.set(index, toBeDoneTask);
        }

    }

}
