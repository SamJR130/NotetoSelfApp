package com.hfad.notetoselfapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;



public class DialogueNewNote extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        TextView tvNewNote = dialogView.findViewById(R.id.tvNewNote);
        TextView tvNewDescr = dialogView.findViewById(R.id.tvnewDescrip);
        Button btnCancel = dialogView.findViewById(R.id.btnCancel);
        Button btnOk = dialogView.findViewById(R.id.btnOk);
        Spinner spStatus = dialogView.findViewById(R.id.spinnerStatus);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add to notes;
                String newNote = tvNewNote.getText().toString();
                String newDescript = tvNewDescr.getText().toString();
                String newStatus = spStatus.getSelectedItem().toString();
                Database.addNote(newNote, newStatus, newDescript);
                dismiss();
            }
        });

        builder.setView(dialogView);
        return builder.create();
    }
}





