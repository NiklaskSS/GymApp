package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Workout implements Parcelable {
    private String exerciseName;
    private String reps;
    private String weight;
    private String date;

    public Workout(String exerciseName, String reps, String weight, String date) {
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    protected Workout(Parcel in) {
        exerciseName = in.readString();
        reps = in.readString();
        weight = in.readString(); // ADDED
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(exerciseName);
        dest.writeString(reps);
        dest.writeString(weight); // ADDED
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    // --- Getters ---

    public String getExerciseName() {
        return exerciseName;
    }

    public String getReps() {
        return reps;
    }

    public String getWeight() { // ADDED
        return weight;
    }

    public String getDate() {
        return date;
    }
}
