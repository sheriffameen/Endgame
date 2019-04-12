package com.example.endgame.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Thanos implements Parcelable {
    private String name;
    private String quote;
    private String gender;
    private String height;
    private String weight;
    private String history;
    private String occupation;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    private String fourthImage;

    protected Thanos(Parcel in) {
        name = in.readString();
        quote = in.readString();
        gender = in.readString();
        height = in.readString();
        weight = in.readString();
        history = in.readString();
        occupation = in.readString();
        firstImage = in.readString();
        secondImage = in.readString();
        thirdImage = in.readString();
        fourthImage = in.readString();
    }

    public static final Creator<Thanos> CREATOR = new Creator<Thanos>() {
        @Override
        public Thanos createFromParcel(Parcel in) {
            return new Thanos(in);
        }

        @Override
        public Thanos[] newArray(int size) {
            return new Thanos[size];
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

    public String getFirstImage() {
        return firstImage;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public String getFourthImage() {
        return fourthImage;
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
        dest.writeString(firstImage);
        dest.writeString(secondImage);
        dest.writeString(thirdImage);
        dest.writeString(fourthImage);
    }
}
