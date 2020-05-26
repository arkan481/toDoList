/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.Date;

/**
 *
 * @author arkan481
 */
public class NotesModel {
    
    private String taskName;
    private String taskDesc;
    private String dueDate;
    private boolean isDone;
    private String doneOn;

    public void setDoneOn(String doneOn) {
        this.doneOn = doneOn;
    }

    public String getDoneOn() {
        return doneOn;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public String getTaskName() {
        return taskName;
    }
    
    
    
}
