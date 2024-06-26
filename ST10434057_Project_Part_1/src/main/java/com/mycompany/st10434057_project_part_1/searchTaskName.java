package com.mycompany.st10434057_project_part_1;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class searchTaskName {

    public static void searchTaskByNameAndDisplay() {
        while (true) {
            String selectedTaskName = selectTaskName();
            if (selectedTaskName != null) {
                displayTaskDetails(selectedTaskName);
            } else {
                Menu.promptMenu();
                break;
            }
        }
    }

    private static String selectTaskName() {
        String[] taskNames = TaskArray.taskNamesArray;
        JComboBox<String> taskList = new JComboBox<>(taskNames);
        int option = JOptionPane.showOptionDialog(null, taskList, "Select a Task Name",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.CLOSED_OPTION || option == JOptionPane.CANCEL_OPTION) {
            return null;
        } else {
            return taskNames[option];
        }
    }

    private static void displayTaskDetails(String taskName) {
        boolean found = false;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.taskNamesArray[i].equalsIgnoreCase(taskName)) {
                message.append("Task Name: ").append(TaskArray.taskNamesArray[i]).append("\n")
                        .append("Task ID: ").append(TaskArray.taskIDArray[i]).append("\n")
                        .append("Task Description: ").append(TaskArray.taskarray[i]._taskDescription).append("\n")
                        .append("Developer: ").append(TaskArray.developerArray[i]).append("\n")
                        .append("Task Duration: ").append(TaskArray.taskDurationArray[i]).append(" hours\n")
                        .append("Task Status: ").append(TaskArray.taskStatusArray[i]).append("\n");
                found = true;
                break;
            }
        }
        if (found) {
            int option = JOptionPane.showConfirmDialog(null, message.toString(), "Task Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
            } else {
                Menu.promptMenu();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.", "Task Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
}
