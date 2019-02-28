package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Creator<MallFunction> CREATOR = new Creator<MallFunction>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallFunction(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallFunction[i];
        }
    };
    public String fJD;
    public String fMx;
    public String nAW;
    public String orf;
    public String org;
    public String pHt;
    public String sWA;
    public ArrayList<String> sWB;
    public MallNews sWC;
    public String sWD;
    public int sWE = 0;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        this.pHt = parcel.readString();
        this.fJD = parcel.readString();
        this.sWA = parcel.readString();
        this.orf = parcel.readString();
        this.org = parcel.readString();
        this.fMx = parcel.readString();
        this.nAW = parcel.readString();
        this.sWB = new ArrayList();
        parcel.readStringList(this.sWB);
        this.sWC = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.sWD = parcel.readString();
        this.sWE = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pHt);
        parcel.writeString(this.fJD);
        parcel.writeString(this.sWA);
        parcel.writeString(this.orf);
        parcel.writeString(this.org);
        parcel.writeString(this.fMx);
        parcel.writeString(this.nAW);
        parcel.writeStringList(this.sWB);
        parcel.writeParcelable(this.sWC, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.sWD);
        parcel.writeInt(this.sWE);
    }
}
