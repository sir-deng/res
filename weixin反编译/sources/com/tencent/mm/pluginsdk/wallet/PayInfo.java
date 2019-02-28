package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayInfo implements Parcelable {
    public static final Creator<PayInfo> CREATOR = new Creator<PayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayInfo[i];
        }
    };
    public String appId;
    public int fDM;
    public int fDQ = 0;
    public int fDR = -1;
    public String fDw = "";
    public String fLs;
    public String foE;
    public String frQ;
    public String fvC;
    public int fxS;
    public String fxU;
    public String fxV;
    public String iLo;
    public String kPP;
    public boolean niF = false;
    public String njL;
    public int pQV = 0;
    public String partnerId;
    public int tcd = 0;
    public int tce = 0;
    public String tgP;
    public int vGi = 0;
    public boolean vGj = true;
    public String vGk;
    public Bundle vGl;
    public int vGm;
    public long vGn = 0;
    public int vGo = -1;
    public String vGp;
    public String vGq;
    public int vGr = 1;
    public double vGs = 0.0d;

    public PayInfo(Parcel parcel) {
        boolean z = true;
        this.fDQ = parcel.readInt();
        this.vGi = parcel.readInt();
        this.fvC = parcel.readString();
        this.njL = parcel.readString();
        this.appId = parcel.readString();
        this.tgP = parcel.readString();
        this.partnerId = parcel.readString();
        this.fLs = parcel.readString();
        this.frQ = parcel.readString();
        this.foE = parcel.readString();
        this.fDM = parcel.readInt();
        this.fDR = parcel.readInt();
        this.niF = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.vGj = z;
        this.vGl = parcel.readBundle();
        this.tcd = parcel.readInt();
        this.fxU = parcel.readString();
        this.fxV = parcel.readString();
        this.fxS = parcel.readInt();
        this.vGn = parcel.readLong();
        this.fDw = parcel.readString();
        this.vGp = parcel.readString();
        this.vGq = parcel.readString();
        this.vGr = parcel.readInt();
        this.kPP = parcel.readString();
        this.iLo = parcel.readString();
        this.pQV = parcel.readInt();
        this.vGs = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.fDQ);
        parcel.writeInt(this.vGi);
        parcel.writeString(this.fvC);
        parcel.writeString(this.njL);
        parcel.writeString(this.appId);
        parcel.writeString(this.tgP);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.fLs);
        parcel.writeString(this.frQ);
        parcel.writeString(this.foE);
        parcel.writeInt(this.fDM);
        parcel.writeInt(this.fDR);
        parcel.writeInt(this.niF ? 1 : 0);
        if (!this.vGj) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.vGl);
        parcel.writeInt(this.tcd);
        parcel.writeString(this.fxU);
        parcel.writeString(this.fxV);
        parcel.writeInt(this.fxS);
        parcel.writeLong(this.vGn);
        parcel.writeString(this.fDw);
        parcel.writeString(this.vGp);
        parcel.writeString(this.vGq);
        parcel.writeInt(this.vGr);
        parcel.writeString(this.kPP);
        parcel.writeString(this.iLo);
        parcel.writeInt(this.pQV);
        parcel.writeDouble(this.vGs);
    }

    public String toString() {
        return String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[]{Integer.valueOf(this.fDQ), this.fvC, this.njL, this.appId, this.tgP, this.partnerId, this.fLs, this.frQ, this.fDw});
    }
}
