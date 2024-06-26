/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10434057_project_part_1;
 
/**
 *
 * @author Vivi
// */
import javax.swing.JOptionPane;

public class TaskDetails {

    private static String taskDescription;

    public static void promptTaskDetails() {
        while (true) {
            String taskName = promptInput("Enter Task Name:", "Task Details");
            if (taskName == null) continue;

            boolean validDescription = checkTaskDescription();
            if (!validDescription) continue;

            String developerDetails = promptDeveloperDetails();
            if (developerDetails == null) continue;

            Double taskDuration = returnTotalHours();
            if (taskDuration == null) continue;

            int taskNumber = TaskArray.taskNumberCounter++;
            String taskId = createTaskId(taskName, taskNumber, developerDetails);

            String taskStatus = promptStatus();
            if (taskStatus == null) continue;

            TaskArray task = new TaskArray(taskName, taskNumber, taskDescription, developerDetails, taskDuration, taskId, taskStatus);
            TaskArray.addNewTask(task);

            printTaskDetails(taskName, taskDescription, developerDetails, taskDuration, taskId, taskStatus);
            break;
        }
    }

    private static String promptInput(String message, String title) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
            if (input != null) {
                return input.trim();
            }
            int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                return null;
            }
        }
    }

    private static boolean checkTaskDescription() {
        while (true) {
            String description = JOptionPane.showInputDialog(null, "Enter Task Description (max 50 characters):", "Task Details", JOptionPane.QUESTION_MESSAGE);
            if (description != null && description.length() <= 50) {
                JOptionPane.showMessageDialog(null, "Task successfully captured", "Success", JOptionPane.INFORMATION_MESSAGE);
                taskDescription = description.trim();
                return true;
            } else if (description != null && description.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    return false;
                }
            }
        }
    }

    private static String promptDeveloperDetails() {
        while (true) {
            String details = JOptionPane.showInputDialog(null, "Enter Developer Details (at least 3 characters):", "Task Details", JOptionPane.QUESTION_MESSAGE);
            if (details != null) {
                details = details.trim();
                if (details.length() >= 3) {
                    return details;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter at least 3 characters", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    return null;
                }
            }
        }
    }

    private static Double returnTotalHours() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Enter Task Duration (hours):", "Task Details", JOptionPane.QUESTION_MESSAGE);
            if (input != null) {
                try {
                    return Double.parseDouble(input.trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid duration format", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    return null;
                }
            }
        }
    }

    private static String promptStatus() {
        while (true) {
            String[] statusOptions = {"To Do", "Done", "Doing"};
            String status = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Details", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            if (status != null) {
                return status;
            } else {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    return null;
                }
            }
        }
    }

    private static void printTaskDetails(String taskName, String taskDescription, String developerDetails, double taskDuration, String taskId, String taskStatus) {
        StringBuilder taskDetails = new StringBuilder();
        taskDetails.append("Task ID: ").append(taskId.toUpperCase()).append("\n");
        taskDetails.append("Task Name: ").append(taskName).append("\n");
        taskDetails.append("Task Description: ").append(taskDescription).append("\n");
        taskDetails.append("Developer Details: ").append(developerDetails).append("\n");
        taskDetails.append("Task Duration: ").append(taskDuration).append(" hours\n");
        taskDetails.append("Task Status: ").append(taskStatus).append("\n");
        JOptionPane.showMessageDialog(null, taskDetails.toString(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String createTaskId(String taskName, int taskNumber, String developerDetails) {
        String[] developerNames = developerDetails.split(" ");
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails;
    }
}