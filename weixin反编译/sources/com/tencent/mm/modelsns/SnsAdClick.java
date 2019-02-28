package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.nf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;

public class SnsAdClick implements Parcelable {
    public static final Creator<SnsAdClick> CREATOR = new Creator<SnsAdClick>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SnsAdClick snsAdClick = new SnsAdClick();
            snsAdClick.hQh = parcel.readString();
            snsAdClick.scene = parcel.readInt();
            snsAdClick.hQl = parcel.readInt();
            snsAdClick.hQi = parcel.readLong();
            snsAdClick.hQj = parcel.readString();
            snsAdClick.hQm = parcel.readLong();
            snsAdClick.hQo = parcel.readInt();
            snsAdClick.hQn = parcel.readInt();
            snsAdClick.hQp = parcel.readInt();
            snsAdClick.hQk = parcel.readString();
            snsAdClick.hQr = parcel.readLong();
            return snsAdClick;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsAdClick[i];
        }
    };
    public String hQh;
    public long hQi;
    public String hQj;
    public String hQk;
    public int hQl;
    public long hQm;
    public int hQn;
    public int hQo;
    public int hQp;
    public long hQq;
    public long hQr;
    public int scene;

    public SnsAdClick() {
        this.hQh = "";
        this.scene = 0;
        this.hQi = 0;
        this.hQj = "";
        this.hQk = "";
        this.hQl = 0;
        this.hQm = 0;
        this.hQn = 0;
        this.hQo = 0;
        this.hQp = 0;
        this.hQq = 0;
        this.hQr = 0;
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2) {
        this.hQh = "";
        this.scene = 0;
        this.hQi = 0;
        this.hQj = "";
        this.hQk = "";
        this.hQl = 0;
        this.hQm = 0;
        this.hQn = 0;
        this.hQo = 0;
        this.hQp = 0;
        this.hQq = 0;
        this.hQr = 0;
        this.hQh = str;
        this.scene = i;
        this.hQi = j;
        this.hQj = str2;
        this.hQn = i2;
        this.hQo = 1;
        this.hQm = System.currentTimeMillis();
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2, byte b) {
        this.hQh = "";
        this.scene = 0;
        this.hQi = 0;
        this.hQj = "";
        this.hQk = "";
        this.hQl = 0;
        this.hQm = 0;
        this.hQn = 0;
        this.hQo = 0;
        this.hQp = 0;
        this.hQq = 0;
        this.hQr = 0;
        this.hQh = str;
        this.scene = i;
        this.hQi = j;
        this.hQj = str2;
        this.hQn = i2;
        this.hQo = 0;
        this.hQm = System.currentTimeMillis();
    }

    public SnsAdClick(String str, String str2, int i, int i2) {
        this.hQh = "";
        this.scene = 0;
        this.hQi = 0;
        this.hQj = "";
        this.hQk = "";
        this.hQl = 0;
        this.hQm = 0;
        this.hQn = 0;
        this.hQo = 0;
        this.hQp = 0;
        this.hQq = 0;
        this.hQr = 0;
        this.hQh = "";
        this.scene = 7;
        this.hQk = str;
        this.hQj = str2;
        this.hQn = i;
        this.hQo = 0;
        this.hQp = i2;
        this.hQm = System.currentTimeMillis();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hQh);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.hQl);
        parcel.writeLong(this.hQi);
        parcel.writeString(bi.aD(this.hQj, ""));
        parcel.writeLong(this.hQm);
        parcel.writeInt(this.hQo);
        parcel.writeInt(this.hQn);
        parcel.writeInt(this.hQp);
        parcel.writeString(this.hQk);
        parcel.writeLong(this.hQr);
    }

    public final void iw(int i) {
        Sz();
        b nfVar = new nf();
        this.hQl = i;
        nfVar.fFY.fFZ = this;
        a.xmy.m(nfVar);
    }

    public final void Sz() {
        if (this.hQq > 0) {
            this.hQr += bi.bB(this.hQq);
            this.hQq = 0;
        }
    }
}
