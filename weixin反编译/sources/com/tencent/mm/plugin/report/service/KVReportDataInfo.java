package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class KVReportDataInfo implements Parcelable {
    public static final Creator<KVReportDataInfo> CREATOR = new Creator<KVReportDataInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KVReportDataInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KVReportDataInfo[i];
        }
    };
    public boolean pWe;
    public long pWw;
    public boolean pWx;
    public String value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.pWw);
        parcel.writeString(this.value);
        if (this.pWx) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pWe) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    protected KVReportDataInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.pWw = parcel.readLong();
        this.value = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pWx = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.pWe = z2;
    }
}
