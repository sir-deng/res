package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast implements Parcelable {
    public static final Creator<LaunchBroadCast> CREATOR = new Creator<LaunchBroadCast>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchBroadCast(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchBroadCast[i];
        }
    };
    public String appId;
    public boolean fKR;
    public int iNi;
    public int jCV;
    public String username;

    /* synthetic */ LaunchBroadCast(Parcel parcel, byte b) {
        this(parcel);
    }

    static void a(String str, int i, int i2, boolean z) {
        Parcelable launchBroadCast = new LaunchBroadCast();
        launchBroadCast.username = null;
        launchBroadCast.appId = str;
        launchBroadCast.iNi = i;
        launchBroadCast.jCV = i2;
        launchBroadCast.fKR = z;
        d.a(launchBroadCast);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iNi);
        parcel.writeInt(this.jCV);
        parcel.writeByte(this.fKR ? (byte) 1 : (byte) 0);
    }

    private LaunchBroadCast() {
    }

    private LaunchBroadCast(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.iNi = parcel.readInt();
        this.jCV = parcel.readInt();
        this.fKR = parcel.readByte() != (byte) 0;
    }
}
