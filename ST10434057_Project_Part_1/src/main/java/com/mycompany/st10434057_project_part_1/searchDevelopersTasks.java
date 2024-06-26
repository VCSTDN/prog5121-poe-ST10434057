package com.mycompany.st10434057_project_part_1;

import javax.swing.*;

public class searchDevelopersTasks {

    public static void searchTasksByDeveloperAndDisplay() {
        StringBuilder message = new StringBuilder();
        boolean found = false;


        String developerName = selectDeveloper();
        if (developerName == null) {
            Menu.promptMenu();
            return;
        }

        String[] tasksForDeveloper = new String[TaskArray.taskArrayCount];
        int count = 0;
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.developerArray[i].equalsIgnoreCase(developerName)) {
                tasksForDeveloper[count++] = TaskArray.taskNamesArray[i];
            }
        }

        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No tasks assigned to " + developerName + ".", "Tasks Not Found", JOptionPane.ERROR_MESSAGE);
        } else {
            String selectedTaskName = (String) JOptionPane.showInputDialog(null,
                    "Select a Task for " + developerName + ":",
                    "Tasks Assigned to " + developerName,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    tasksForDeveloper,
                    tasksForDeveloper[0]);

            if (selectedTaskName != null) {
                for (int i = 0; i < TaskArray.taskArrayCount; i++) {
                    if (TaskArray.taskNamesArray[i].equalsIgnoreCase(selectedTaskName)) {
                        message.append("Task Name: ").append(TaskArray.taskNamesArray[i]).append("\n")
                                .append("Task ID: ").append(TaskArray.taskIDArray[i]).append("\n")
                                .append("Task Description: ").append(TaskArray.taskarray[i]._taskDescription).append("\n")
                                .append("Task Duration: ").append(TaskArray.taskDurationArray[i]).append(" hours\n")
                                .append("Task Status: ").append(TaskArray.taskStatusArray[i]).append("\n")
                                .append("------------------------------------\n");
                        found = true;
                        break;
                    }
                }

                if (found) {
                    JOptionPane.showMessageDialog(null, message.toString(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Task details not found for " + selectedTaskName, "Task Details Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        Menu.promptMenu();
    }

    private static String selectDeveloper() {
        String[] developers = new String[TaskArray.taskArrayCount];
        int count = 0;

        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            boolean exists = false;
            for (int j = 0; j < count; j++) {
                if (TaskArray.developerArray[i].equalsIgnoreCase(developers[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                developers[count++] = TaskArray.developerArray[i];
            }
        }

        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No developers found.", "Developers Not Found", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return (String) JOptionPane.showInputDialog(null,
                "Select a Developer:",
                "Developers",
                JOptionPane.PLAIN_MESSAGE,
                null,
                developers,
                developers[0]);
    }
}
