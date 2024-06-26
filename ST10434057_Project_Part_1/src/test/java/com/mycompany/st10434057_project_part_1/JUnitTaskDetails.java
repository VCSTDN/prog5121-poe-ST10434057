package com.mycompany.st10434057_project_part_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitTaskDetails {

    @Test
    public void testDeveloperArrayPopulation() {
        TaskArray.populateArrays();
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] actualDevelopers = new String[TaskArray.taskArrayCount];
        System.arraycopy(TaskArray.developerArray, 0, actualDevelopers, 0, TaskArray.taskArrayCount);
        assertArrayEquals(expectedDevelopers, actualDevelopers, "Developer array does not match the expected values.");
    }

    @Test
    public void testLongestTaskDuration() {
        TaskArray.populateArrays();
        double maxDuration = -1;
        String developer = "";
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.taskDurationArray[i] > maxDuration) {
                maxDuration = TaskArray.taskDurationArray[i];
                developer = TaskArray.developerArray[i];
            }
        }
        assertEquals("Glenda Oberholzer", developer);
        assertEquals(11, maxDuration);
    }

    @Test
    public void testSearchTaskByName() {
        TaskArray.populateArrays();
        String taskName = "Create Login";
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.taskNamesArray[i].equalsIgnoreCase(taskName)) {
                assertEquals("Mike Smith", TaskArray.developerArray[i]);
                assertEquals("Create Login", TaskArray.taskNamesArray[i]);
                assertEquals("To Do", TaskArray.taskStatusArray[i]);
                return;
            }
        }
        fail("Task not found");
    }

    @Test
    public void testSearchTasksByDeveloper() {
        TaskArray.populateArrays();
        String developer = "Samantha Paulson";
        boolean found = false;
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.developerArray[i].equalsIgnoreCase(developer)) {
                assertEquals("Create Reports", TaskArray.taskNamesArray[i]);
                assertEquals("Done", TaskArray.taskStatusArray[i]);
                found = true;
            }
        }
        assertTrue(found, "No tasks found for developer: " + developer);
    }

    @Test
    public void testDeleteTaskByName() {
        TaskArray.populateArrays();
        String taskNameToDelete = "Create Reports";
        TaskArray.deleteTaskByName(taskNameToDelete);

        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            assertNotEquals(taskNameToDelete, TaskArray.taskNamesArray[i]);
        }

        assertEquals(3, TaskArray.taskArrayCount);
    }
}

