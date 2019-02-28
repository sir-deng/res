package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Location location = new Location();
            location.hzq = parcel.readFloat();
            location.hzr = parcel.readFloat();
            location.accuracy = parcel.readInt();
            location.fBZ = parcel.readInt();
            location.mac = parcel.readString();
            location.fCb = parcel.readString();
            return location;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Location[i];
        }
    };
    public int accuracy;
    public int fBZ;
    public String fCb;
    public float hzq;
    public float hzr;
    public String mac;

    public Location(float f, float f2, int i, int i2, String str, String str2) {
        this.hzq = f;
        this.hzr = f2;
        this.accuracy = i;
        this.fBZ = i2;
        this.mac = str;
        this.fCb = str2;
    }

    public final boolean bZJ() {
        if (this.hzq != -85.0f && this.hzr != -1000.0f) {
            return false;
        }
        x.d("MicroMsg.Radar.Location", "mac and cellId is null");
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.hzq);
        parcel.writeFloat(this.hzr);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.fBZ);
        parcel.writeString(this.mac);
        parcel.writeString(this.fCb);
    }
}
