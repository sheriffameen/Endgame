package com.example.endgame.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {
    private String name;
    private String quote;
    private String gender;
    private String height;
    private String weight;
    private String history;
    private String occupation;
    private String comicImage;
    private String realImage;

    protected Character(Parcel in) {
        name = in.readString();
        quote = in.readString();
        gender = in.readString();
        height = in.readString();
        weight = in.readString();
        history = in.readString();
        occupation = in.readString();
        comicImage = in.readString();
        realImage = in.readString();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getQuote() {
        return quote;
    }

    public String getGender() {
        return gender;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getHistory() {
        return history;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getComicImage() {
        return comicImage;
    }

    public String getRealImage() {
        return realImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(quote);
        dest.writeString(gender);
        dest.writeString(height);
        dest.writeString(weight);
        dest.writeString(history);
        dest.writeString(occupation);
        dest.writeString(comicImage);
        dest.writeString(realImage);
    }
}
