package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallNews implements Parcelable {
    public static final Creator<MallNews> CREATOR = new Creator<MallNews>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallNews(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallNews[i];
        }
    };
    public String fsK;
    public int sUJ;
    public String sWI = "0";
    public String sWJ = "0";
    public String sWK;
    public String sWL;
    public String sWM;
    public String sWN;
    public int sWO;
    public String sWP;
    public int sWQ;
    public String sWR;
    public String sWS;
    public String sbN;
    public int showType;
    public String type;

    public MallNews(String str) {
        this.sWK = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MallNews)) {
            return false;
        }
        MallNews mallNews = (MallNews) obj;
        if (this.sWK == null || !this.sWK.equals(mallNews.sWK) || this.sbN == null || !this.sbN.equals(mallNews.sbN)) {
            return false;
        }
        return true;
    }

    public MallNews(Parcel parcel) {
        this.sWK = parcel.readString();
        this.sbN = parcel.readString();
        this.fsK = parcel.readString();
        this.sWL = parcel.readString();
        this.sWM = parcel.readString();
        this.sWN = parcel.readString();
        this.sWO = parcel.readInt();
        this.sWP = parcel.readString();
        this.sWI = parcel.readString();
        this.sWJ = parcel.readString();
        this.showType = parcel.readInt();
        this.sWR = parcel.readString();
        this.sUJ = parcel.readInt();
        this.sWS = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sWK);
        parcel.writeString(this.sbN);
        parcel.writeString(this.fsK);
        parcel.writeString(this.sWL);
        parcel.writeString(this.sWM);
        parcel.writeString(this.sWN);
        parcel.writeInt(this.sWO);
        parcel.writeString(this.sWP);
        parcel.writeString(this.sWI);
        parcel.writeString(this.sWJ);
        parcel.writeInt(this.showType);
        parcel.writeString(this.sWR);
        parcel.writeInt(this.sUJ);
        parcel.writeString(this.sWS);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[]{this.sWK, this.sbN, this.fsK, this.sWL, this.sWM, this.sWN, this.sWI, this.sWR, this.sWP, Integer.valueOf(this.sUJ), this.sWS});
    }
}
