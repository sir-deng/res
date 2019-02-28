package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;

public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new Creator<Authen>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Authen(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Authen[i];
        }
    };
    public String country;
    public int fEo;
    public String fXd;
    public String fXk;
    public String fXl;
    public String hzf;
    public String iot;
    public String nHv;
    public PayInfo pHW = new PayInfo();
    public String pff;
    public String pfg;
    public String sHU;
    public String sOP;
    public int sQB = 0;
    public String sQC;
    public String sQD;
    public String sQE;
    public int sQF;
    public String sQG;
    public String sQH;
    public String sQI;
    public String sQJ;
    public String sQK;
    public String sQL;
    public String sQM;
    public String sQN;
    public String sQO;
    public String sQP;
    public String sQQ;
    public String sQR;
    public String sQS;
    public String token;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fEo);
        parcel.writeString(bi.aD(this.sQC, ""));
        parcel.writeString(bi.aD(this.pff, ""));
        parcel.writeString(bi.aD(this.pfg, ""));
        parcel.writeString(bi.aD(this.sQD, ""));
        parcel.writeString(bi.aD(this.sQE, ""));
        parcel.writeInt(this.sQF);
        parcel.writeString(bi.aD(this.sOP, ""));
        parcel.writeString(bi.aD(this.sQG, ""));
        parcel.writeString(bi.aD(this.sQH, ""));
        parcel.writeString(bi.aD(this.sQI, ""));
        parcel.writeString(bi.aD(this.token, ""));
        parcel.writeString(bi.aD(this.sQL, ""));
        parcel.writeString(bi.aD(this.sQM, ""));
        parcel.writeString(bi.aD(this.country, ""));
        parcel.writeString(bi.aD(this.fXk, ""));
        parcel.writeString(bi.aD(this.fXl, ""));
        parcel.writeString(bi.aD(this.hzf, ""));
        parcel.writeString(bi.aD(this.nHv, ""));
        parcel.writeString(bi.aD(this.iot, ""));
        parcel.writeString(bi.aD(this.fXd, ""));
        parcel.writeString(bi.aD(this.sHU, ""));
        parcel.writeString(bi.aD(this.sQN, ""));
        parcel.writeString(bi.aD(this.sQO, ""));
        parcel.writeString(bi.aD(this.sQK, ""));
        parcel.writeString(bi.aD(this.sQP, ""));
        parcel.writeString(bi.aD(this.sQQ, ""));
        parcel.writeString(bi.aD(this.sQR, ""));
        parcel.writeString(bi.aD(this.sQS, ""));
    }

    public Authen(Parcel parcel) {
        this.fEo = parcel.readInt();
        this.sQC = parcel.readString();
        this.pff = parcel.readString();
        this.pfg = parcel.readString();
        this.sQD = parcel.readString();
        this.sQE = parcel.readString();
        this.sQF = parcel.readInt();
        this.sOP = parcel.readString();
        this.sQG = parcel.readString();
        this.sQH = parcel.readString();
        this.sQI = parcel.readString();
        this.token = parcel.readString();
        this.sQL = parcel.readString();
        this.sQM = parcel.readString();
        this.country = parcel.readString();
        this.fXk = parcel.readString();
        this.fXl = parcel.readString();
        this.hzf = parcel.readString();
        this.nHv = parcel.readString();
        this.iot = parcel.readString();
        this.fXd = parcel.readString();
        this.sHU = parcel.readString();
        this.sQN = parcel.readString();
        this.sQO = parcel.readString();
        this.sQK = parcel.readString();
        this.sQP = parcel.readString();
        this.sQQ = parcel.readString();
        this.sQR = parcel.readString();
        this.sQS = parcel.readString();
    }
}
