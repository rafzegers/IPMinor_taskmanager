package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.domain.SubTask;
import com.taskmanager.taskmanager.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private List<Task> tasks;

    public TaskRepository(){
        tasks = new ArrayList<>();
        tasks.add(new Task("task1","tast1 beschrijving",LocalDateTime.of(2020,2,27,12,30), 1));
        tasks.add(new Task("task2","tast2 beschrijving",LocalDateTime.of(2020,2,27,12,30), 2));
        tasks.add(new Task("task3","tast3 beschrijving",LocalDateTime.of(2020,2,27,12,30), 3));
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void updateTask(Task task){

        for(int i = 0 ; i < tasks.size() ; i++){
            if( tasks.get(i).getId() == task.getId() ){
                this.tasks.set(i,task);
            }
        }

    }


    public Task getTask(int id){
        for(Task t : tasks){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void addSubTask(SubTask subTask, int taskId){
        for(Task task : tasks){
            if(task.getId() == taskId){
                task.addSubTask(subTask);
            }
        }
    }



}
