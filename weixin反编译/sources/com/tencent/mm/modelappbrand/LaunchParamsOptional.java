package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LaunchParamsOptional implements Parcelable {
    public static final Creator<LaunchParamsOptional> CREATOR = new Creator<LaunchParamsOptional>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchParamsOptional(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParamsOptional[i];
        }
    };
    public String hlj;
    public String hlk;
    public String hll;

    /* synthetic */ LaunchParamsOptional(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hlj);
        parcel.writeString(this.hlk);
    }

    private LaunchParamsOptional(Parcel parcel) {
        this.hlj = parcel.readString();
        this.hlk = parcel.readString();
    }
}
