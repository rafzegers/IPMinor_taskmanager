package com.taskmanager.taskmanager.dto;

import com.taskmanager.taskmanager.domain.SubTask;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {

    @NotNull(message = "Titel mag niet null zijn.")
    @NotEmpty(message = "Titel mag niet leeg zijn.")
    private String titel;

    @NotNull(message = "Beschrijving mag niet null zijn.")
    @NotEmpty(message = "Beschrijving mag niet leeg zijn.")
    private String beschrijving;

    @NotNull(message = "datum mag niet leeg zijn")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datum;

    @Min(value = 0, message = "negatieve id kan niet")
    private int id;

    private List<SubTaskDTO> subTasks;

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


    public void setSubTasks(List<SubTaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

    public List<SubTaskDTO> getSubTasks() {
        return subTasks;
    }
}
