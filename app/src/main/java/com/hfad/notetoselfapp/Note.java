package com.hfad.notetoselfapp;

public class Note {

    private String titleNote;
    private String statusNote;
    private String descriptionNote;


    public String getTitleNote() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public String getStatusNote() {
        return statusNote;
    }

    public void setStatusNote(String statusNote) {
        this.statusNote = statusNote;
    }

    public String getDescriptionNote() {
        return descriptionNote;
    }

    public void setDescriptionNote(String descriptionNote) {
        this.descriptionNote = descriptionNote;
    }

    public Note(String t, String s, String d)
    {
        titleNote = t;
        statusNote =  s;
        descriptionNote = d;

    }
}
