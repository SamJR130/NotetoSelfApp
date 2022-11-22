package com.hfad.notetoselfapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogueShowNote extends DialogFragment {

    private Note note;

    public DialogueShowNote(Note n)
    {
        note = n;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialogue_show_note, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        TextView tvTitle = dialogView.findViewById(R.id.tvTitle);
        TextView tvStatus = dialogView.findViewById(R.id.tvStatus);
        TextView tvDescr = dialogView.findViewById(R.id.tvDescription);
        Button btnDone = dialogView.findViewById(R.id.btnDoneShowingNote);

        tvTitle.setText(note.getTitleNote());
        tvStatus.setText(note.getStatusNote());
        tvDescr.setText(note.getDescriptionNote());

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        builder.setView(dialogView);

        return builder.create();

    }
}
