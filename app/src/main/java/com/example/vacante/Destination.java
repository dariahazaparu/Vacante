package com.example.vacante;

import android.os.Parcel;
import android.os.Parcelable;

public class Destination implements Parcelable {

    private String Name;
    private String Location;
    private Float Review;
    private Integer ImageId;

    public Destination(String name, String location, Float review, Integer imageId) {
        Name = name;
        Location = location;
        Review = review;
        ImageId = imageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Float getReview() {
        return Review;
    }

    public void setReview(Float review) {
        Review = review;
    }

    public Integer getImageId() {
        return ImageId;
    }

    public void setImageId(Integer imageId) {
        ImageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.Name, this.Location, this.Review.toString(), this.ImageId.toString()});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Destination createFromParcel(Parcel in) {
            return new Destination(in);
        }

        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };

    public Destination(Parcel in) {
        String[] data = new String[4];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.Name = data[0];
        this.Location = data[1];
        this.Review = Float.valueOf(data[2]);
        this.ImageId = Integer.valueOf(data[3]);
    }
}
