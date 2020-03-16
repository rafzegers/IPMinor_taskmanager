package com.taskmanager.taskmanager.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {

    private String titel,beschrijving;
    private LocalDateTime datum;
    private int id;
    private ArrayList<SubTask> subTasks;

    public Task(String titel, String beschrijving, LocalDateTime datum, int id){
        setTitel(titel);
        setBeschrijving(beschrijving);
        setDatum(datum);
        setId(id);
        subTasks = new ArrayList<>();
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void addSubTask(SubTask subTask){
        this.subTasks.add(subTask);
    }
    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }
}
