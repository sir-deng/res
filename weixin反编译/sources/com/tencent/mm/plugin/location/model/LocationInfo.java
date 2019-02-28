package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bi;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new Creator<LocationInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.nWd = parcel.readString();
            locationInfo.nWe = parcel.readDouble();
            locationInfo.nWf = parcel.readDouble();
            locationInfo.zoom = parcel.readInt();
            locationInfo.nWg = parcel.readString();
            locationInfo.nWh = parcel.readString();
            locationInfo.fEp = parcel.readString();
            locationInfo.nWi = parcel.readString();
            locationInfo.nWj = parcel.readInt();
            return locationInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationInfo[i];
        }
    };
    public String fEp;
    public String nWd;
    public double nWe;
    public double nWf;
    public String nWg;
    public String nWh;
    String nWi;
    public int nWj;
    public int zoom;

    public LocationInfo() {
        this.nWd = "";
        this.nWe = -85.0d;
        this.nWf = -1000.0d;
        this.nWg = "";
        this.nWh = "zh-cn";
        this.nWi = "";
        this.nWj = 0;
    }

    public LocationInfo(byte b) {
        this.nWd = "";
        this.nWe = -85.0d;
        this.nWf = -1000.0d;
        this.nWg = "";
        this.nWh = "zh-cn";
        this.nWi = "";
        this.nWj = 0;
        this.nWd = toString() + " " + System.nanoTime();
        this.zoom = d.gq(false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nWd);
        parcel.writeDouble(this.nWe);
        parcel.writeDouble(this.nWf);
        parcel.writeInt(this.zoom);
        parcel.writeString(this.nWg);
        parcel.writeString(this.nWh);
        parcel.writeString(this.fEp);
        parcel.writeString(this.nWi);
        parcel.writeInt(this.nWj);
    }

    public final boolean aVQ() {
        if (this.nWe == -85.0d || this.nWf == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean aVR() {
        if (bi.oN(this.nWg) && bi.oN(this.fEp)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.nWe + " " + this.nWf + " " + this.nWg + " " + this.fEp + "  " + this.nWd;
    }

    public int describeContents() {
        return 0;
    }
}
