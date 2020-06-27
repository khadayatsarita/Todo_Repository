package com.saritac7190004.todoapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Sarita on 6/12/2020.
 */

@Entity(tableName = "todo")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    int id;

    String title;

    String description;

    int priority;

    public Todo(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
