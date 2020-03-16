package com.taskmanager.taskmanager.domain;

public class SubTask {
    private String titel, beschrijving;

    public SubTask(String title, String desciption){
        this.setTitel(title);
        this.setBeschrijving(desciption);
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
}
