package com.mycompany.st10434057_project_part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskDetailsTest {



    @Test
    public void testTaskDescriptionLength_Success() {
        TaskArray taskArray = new TaskArray("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "AD:1:BYN", "To Do");
        TaskArray.addNewTask(taskArray);
        assertEquals("Create Login to authenticate users", TaskArray.taskarray[0]._taskDescription);
    }

    @Test
    public void testTaskDescriptionLength_Failure() {
        String longDescription = "This description is definitely longer than fifty characters, so it should fail";
        assertTrue(longDescription.length() > 50);
    }

    @Test
    public void testTaskID_Correctness() {
        TaskArray taskArray = new TaskArray("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "AD:1:BYN", "To Do");
        TaskArray.addNewTask(taskArray);
        assertEquals("AD:1:BYN", TaskArray.taskarray[0]._taskId);
    }

    @Test
    public void testTotalHoursAccumulated() {
        TaskArray.addNewTask(new TaskArray("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "AD:1:BYN", "To Do"));
        TaskArray.addNewTask(new TaskArray("Add Task Feature", 2, "Create Add Task feature to add task users", "Mike Smith", 10, "CR:0:IKE", "Doing"));

        double totalHours = 0;
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            totalHours += TaskArray.taskarray[i]._taskDuration;
        }
        assertEquals(18, totalHours);
    }

    }