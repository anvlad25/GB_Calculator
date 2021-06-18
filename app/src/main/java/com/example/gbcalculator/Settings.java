package com.example.gbcalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Settings implements Parcelable {
    protected static final String V_SETTINGS = "Switch_settings";

    private boolean switchState;

    protected Settings() {
    }


    protected Settings(Parcel in) {
        switchState = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (switchState ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };

    public boolean isSwitchState() {
        return switchState;
    }

    public void setSwitchState(boolean switchState) {
        this.switchState = switchState;
    }
}
