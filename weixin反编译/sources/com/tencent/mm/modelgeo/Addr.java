package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;

public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new Creator<Addr>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Addr addr = new Addr();
            addr.hzf = parcel.readString();
            addr.country = parcel.readString();
            addr.hzg = parcel.readString();
            addr.hzh = parcel.readString();
            addr.hzi = parcel.readString();
            addr.hzj = parcel.readString();
            addr.hzk = parcel.readString();
            addr.hzl = parcel.readString();
            addr.hzm = parcel.readString();
            addr.hzn = parcel.readString();
            addr.hzo = parcel.readString();
            addr.hzq = parcel.readFloat();
            addr.hzr = parcel.readFloat();
            return addr;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Addr[i];
        }
    };
    public String country;
    public String hzf;
    public String hzg;
    public String hzh;
    public String hzi;
    public String hzj;
    public String hzk;
    public String hzl;
    public String hzm;
    public String hzn;
    public String hzo;
    public String hzp;
    public float hzq;
    public float hzr;
    public Object tag = "";

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("address='" + this.hzf + '\'');
        stringBuilder.append(", country='" + this.country + '\'');
        stringBuilder.append(", administrative_area_level_1='" + this.hzg + '\'');
        stringBuilder.append(", locality='" + this.hzh + '\'');
        stringBuilder.append(", locality_shi='" + this.hzi + '\'');
        stringBuilder.append(", sublocality='" + this.hzj + '\'');
        stringBuilder.append(", neighborhood='" + this.hzk + '\'');
        stringBuilder.append(", route='" + this.hzl + '\'');
        stringBuilder.append(", streetNum='" + this.hzm + '\'');
        stringBuilder.append(", roughAddr='" + this.hzn + '\'');
        stringBuilder.append(", poi_name='" + this.hzo + '\'');
        stringBuilder.append(", lat=" + this.hzq);
        stringBuilder.append(", lng=" + this.hzr);
        stringBuilder.append(", tag=" + this.tag);
        return stringBuilder.toString();
    }

    public final String OS() {
        return bi.aD(this.hzi, "") + bi.aD(this.hzj, "") + bi.aD(this.hzk, "") + bi.aD(this.hzl, "") + bi.aD(this.hzm, "");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bi.aD(this.hzf, ""));
        parcel.writeString(bi.aD(this.country, ""));
        parcel.writeString(bi.aD(this.hzg, ""));
        parcel.writeString(bi.aD(this.hzh, ""));
        parcel.writeString(bi.aD(this.hzi, ""));
        parcel.writeString(bi.aD(this.hzj, ""));
        parcel.writeString(bi.aD(this.hzk, ""));
        parcel.writeString(bi.aD(this.hzl, ""));
        parcel.writeString(bi.aD(this.hzm, ""));
        parcel.writeString(bi.aD(this.hzn, ""));
        parcel.writeString(bi.aD(this.hzo, ""));
        parcel.writeFloat(this.hzq);
        parcel.writeFloat(this.hzr);
    }
}
