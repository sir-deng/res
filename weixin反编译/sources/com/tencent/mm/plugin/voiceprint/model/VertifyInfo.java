package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;

public class VertifyInfo implements Parcelable {
    public static final Creator<VertifyInfo> CREATOR = new Creator<VertifyInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            VertifyInfo vertifyInfo = new VertifyInfo();
            vertifyInfo.smZ = parcel.readInt();
            vertifyInfo.jxX = parcel.readInt();
            vertifyInfo.sna = parcel.readInt();
            vertifyInfo.smQ = parcel.readInt();
            vertifyInfo.kav = parcel.readString();
            vertifyInfo.smJ = parcel.readString();
            vertifyInfo.mFileName = parcel.readString();
            vertifyInfo.snb = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            vertifyInfo.snc = z;
            vertifyInfo.smQ = vertifyInfo.smZ;
            return vertifyInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VertifyInfo[i];
        }
    };
    public int jxX;
    public String kav = "";
    public String mFileName = "";
    public String smJ = "";
    public int smQ = 0;
    public String smV = "";
    public int smZ;
    public int sna = 0;
    public boolean snb = false;
    public boolean snc = false;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.smZ);
        parcel.writeInt(this.jxX);
        parcel.writeInt(this.sna);
        parcel.writeInt(this.smQ);
        parcel.writeString(bi.aD(this.kav, ""));
        parcel.writeString(bi.aD(this.smJ, ""));
        parcel.writeString(bi.aD(this.mFileName, ""));
        if (this.snb) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.snc) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
