package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new Creator<PeriodicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PeriodicTask(parcel, (byte) 0);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new PeriodicTask[i];
        }
    };
    protected long aQL;
    protected long aQM;

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.aQL = -1;
        this.aQM = -1;
        this.aQL = parcel.readLong();
        this.aQM = parcel.readLong();
    }

    /* synthetic */ PeriodicTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public String toString() {
        return super.toString() + " period=" + this.aQL + " flex=" + this.aQM;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.aQL);
        parcel.writeLong(this.aQM);
    }
}
