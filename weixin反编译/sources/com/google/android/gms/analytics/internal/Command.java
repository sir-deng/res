package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new Creator<Command>() {
        @Deprecated
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }

        @Deprecated
        public final /* synthetic */ Object[] newArray(int i) {
            return new Command[i];
        }
    };
    String aEO;
    private String aEP;
    String mValue;

    @Deprecated
    Command(Parcel parcel) {
        this.aEO = parcel.readString();
        this.aEP = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aEO);
        parcel.writeString(this.aEP);
        parcel.writeString(this.mValue);
    }
}
