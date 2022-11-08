package com.hfad.notetoselfapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private ArrayList<Note> allNotes;

    public Adapter()
    {
        allNotes = Database.getNotes();
    }

    //Creates an empty view of a single row - inflate a vacation row item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_note_row, parent, false);

        System.out.println("DONE CREATING A SINGLE ROWS VIEW");
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    //BINDS data to an empty row view
    //Position is the index in the list you want to show
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Note n = allNotes.get(position);
        holder.setData(n, position);

        System.out.println("DONE CREATING POPULATING A ROW: " + position + " " + n.getTitleNote());
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        private TextView tvTitle;
        private TextView tvStatus;
        private TextView tvDescription;
        private ImageView imvDelete;

        private int currentPositionInList = -1;
        private Note currentNote = null;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            imvDelete = itemView.findViewById(R.id.imvDelete);
            tvDescription = itemView.findViewById(R.id.tvDescription);

            imvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    allNotes.remove(currentPositionInList);
                    notifyItemRemoved(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, allNotes.size());
                }
            });
        }

        public void setData(Note n, int pos)
        {
            tvTitle.setText(n.getTitleNote());
            tvStatus.setText(n.getStatusNote());
            tvDescription.setText(n.getDescriptionNote());
            currentPositionInList = pos;
            currentNote = n;

        }
    }
}
