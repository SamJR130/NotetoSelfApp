package com.hfad.notetoselfapp;

import java.util.ArrayList;

public class Database {

    private static ArrayList<Note> allNotes;

    public static ArrayList<Note> getNotes()
    {
        if (allNotes ==  null)
        {
            loadData();
        }

        return allNotes;
    }

    public static void addNote(String title, String status, String description)
    {
        allNotes.add(new Note(title, status, description));
    }

    private static void loadData() {
        allNotes = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();

        title.add("Study for Chemistry");
        title.add("Take out Trash");
        title.add("Call Bank");
        title.add("Write Christmas List");
        title.add("Update Spending Log");
        title.add("Study for Math");
        title.add("Walk Dog");
        title.add("Drink Water");
        title.add("Take Medication");
        title.add("Study for Theology");

        ArrayList<String> status = new ArrayList<>();

        status.add("Important");
        status.add("To-Do");
        status.add("To-Do");
        status.add("Idea");
        status.add("Important");
        status.add("Important");
        status.add("To-Do");
        status.add("Idea");
        status.add("Important");
        status.add("Idea");

        ArrayList<String> description = new ArrayList<>();

        description.add("Chemistry test tomorrow");
        description.add("Take out trash before trash day");
        description.add("Call bank sometime this week");
        description.add("Grandma wants Christmas List");
        description.add("Update Spending Log for this week");
        description.add("Math test in two days");
        description.add("Walk dog daily");
        description.add("Remember to stay hydrated!");
        description.add("Take medication daily");
        description.add("Theology test next week");

        //LOOP
        for (int i = 0; i < title.size(); i++) {
            allNotes.add(new Note(title.get(i), status.get(i), description.get(i)));
        }
    }
    }
