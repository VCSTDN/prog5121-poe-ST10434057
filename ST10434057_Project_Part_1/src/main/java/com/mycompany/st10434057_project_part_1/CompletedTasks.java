package com.mycompany.st10434057_project_part_1;

import javax.swing.JOptionPane;

public class CompletedTasks {

    public static void displayCompletedTasks() {
        StringBuilder message = new StringBuilder();
        boolean found = false;

        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.taskStatusArray[i].equalsIgnoreCase("Done")) {
                message.append("Developer: ").append(TaskArray.developerArray[i]).append("\n")
                        .append("Task Name: ").append(TaskArray.taskNamesArray[i]).append("\n")
                        .append("Task Duration: ").append(TaskArray.taskDurationArray[i]).append(" hours\n")
                        .append("------------------------------------\n");
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, message.toString(), "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks with status 'Done' found.", "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
        }

        Menu.promptMenu();
    }
}
