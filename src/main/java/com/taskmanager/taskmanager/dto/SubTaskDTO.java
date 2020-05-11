package com.taskmanager.taskmanager.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubTaskDTO {

    @NotNull(message = "Titel mag niet null zijn.")
    @NotEmpty(message = "Titel mag niet leeg zijn.")
    private String titel;

    @NotNull(message = "Beschrijving mag niet null zijn.")
    @NotEmpty(message = "Beschrijving mag niet leeg zijn.")
    private  String beschrijving;

    @Min(value = 0, message = "negatieve id kan niet")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
