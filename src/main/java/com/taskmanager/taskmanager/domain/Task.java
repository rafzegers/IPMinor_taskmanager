package com.taskmanager.taskmanager.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

//@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @NotNull
    private String titel,beschrijving;

    @NotEmpty
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datum;

    @OneToMany
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
