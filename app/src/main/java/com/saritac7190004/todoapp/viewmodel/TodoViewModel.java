package com.saritac7190004.todoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.saritac7190004.todoapp.model.Todo;
import com.saritac7190004.todoapp.repo.TodoRepository;

import java.util.List;

/**
 * Created by Sarita on 6/12/2020.
 */
public class TodoViewModel extends AndroidViewModel {

    private TodoRepository todoRepository;
    private LiveData<List<Todo>> todo;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        todoRepository = new TodoRepository(application);
        todo = todoRepository.getAllTodo();
    }

    public void insert(Todo todo) {
        todoRepository.insert(todo);
    }

    public void update(Todo todo) {
        todoRepository.update(todo);
    }

    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }

    public LiveData<List<Todo>> getAllTodo() {
        return todo ;
    }

}