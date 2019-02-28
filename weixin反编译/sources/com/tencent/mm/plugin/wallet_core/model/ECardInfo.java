package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ECardInfo implements Parcelable {
    public static final Creator<ECardInfo> CREATOR = new Creator<ECardInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ECardInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ECardInfo[i];
        }
    };
    public String fLO;
    public String frA;
    public int sSn;
    public int sSo;
    public int sSp;
    public String sSq;
    public String sSr;
    public String sSs;
    public int sSt;
    public ArrayList<String> sSu = new ArrayList();
    public String sSv;
    public String sSw;
    public String sSx;
    public String sSy;
    public String title;

    public ECardInfo(Parcel parcel) {
        this.sSn = parcel.readInt();
        this.frA = parcel.readString();
        this.sSo = parcel.readInt();
        this.sSp = parcel.readInt();
        this.sSq = parcel.readString();
        this.sSr = parcel.readString();
        this.sSs = parcel.readString();
        this.sSt = parcel.readInt();
        this.title = parcel.readString();
        parcel.readStringList(this.sSu);
        this.sSv = parcel.readString();
        this.sSw = parcel.readString();
        this.sSx = parcel.readString();
        this.sSy = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sSn);
        parcel.writeString(this.frA);
        parcel.writeInt(this.sSo);
        parcel.writeInt(this.sSp);
        parcel.writeString(this.sSq);
        parcel.writeString(this.sSr);
        parcel.writeString(this.sSs);
        parcel.writeInt(this.sSt);
        parcel.writeString(this.title);
        parcel.writeStringList(this.sSu);
        parcel.writeString(this.sSv);
        parcel.writeString(this.sSw);
        parcel.writeString(this.sSx);
        parcel.writeString(this.sSy);
    }
}
