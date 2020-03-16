package com.taskmanager.taskmanager.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDTO {

    private String titel,beschrijving;
    private LocalDateTime datum;
    private int id;

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

    public void setDatum(String datum) {
        this.datum = LocalDateTime.parse(datum);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
