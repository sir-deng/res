package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new Creator<FavorPayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FavorPayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavorPayInfo[i];
        }
    };
    public String sTc;
    public int sTd;
    public String sTe;
    public String sTf;
    public String sTg;
    public List<String> sTh = new LinkedList();

    public FavorPayInfo(Parcel parcel) {
        this.sTc = parcel.readString();
        this.sTd = parcel.readInt();
        this.sTe = parcel.readString();
        this.sTf = parcel.readString();
        this.sTg = parcel.readString();
        this.sTh = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sTc);
        parcel.writeInt(this.sTd);
        parcel.writeString(this.sTe);
        parcel.writeString(this.sTf);
        parcel.writeString(this.sTg);
        parcel.writeStringList(this.sTh);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[]{this.sTc, Integer.valueOf(this.sTd), this.sTe, this.sTf, this.sTg}));
        if (this.sTh != null) {
            stringBuffer.append("bind_serial_list :");
            for (String str : this.sTh) {
                stringBuffer.append(str + ",");
            }
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }
}
