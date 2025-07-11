package com.example.gymapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    private List<Workout> workoutList;

    public WorkoutAdapter(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.dateTextView.setText(workout.getDate());
        holder.exerciseNameTextView.setText(workout.getExerciseName());
        holder.repsTextView.setText("Reps: " + workout.getReps());
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    // ViewHolder class to hold the views for each item
    public static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView exerciseNameTextView;
        TextView repsTextView;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            exerciseNameTextView = itemView.findViewById(R.id.exerciseNameTextView);
            repsTextView = itemView.findViewById(R.id.repsTextView);
        }
    }
}
