package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.bi;

public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new Creator<LocationIntent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LocationIntent locationIntent = new LocationIntent();
            locationIntent.lat = parcel.readDouble();
            locationIntent.lng = parcel.readDouble();
            locationIntent.fAq = parcel.readInt();
            locationIntent.label = parcel.readString();
            locationIntent.nYL = bi.aD(parcel.readString(), "");
            locationIntent.vjB = bi.aD(parcel.readString(), "");
            locationIntent.nWi = bi.aD(parcel.readString(), "");
            locationIntent.vjC = parcel.readInt();
            locationIntent.hzy = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
            return locationIntent;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationIntent[i];
        }
    };
    public int fAq = 0;
    public Addr hzy = null;
    public String label = "";
    public double lat;
    public double lng;
    public String nWi;
    public String nYL = "";
    public String vjB = "";
    public int vjC = 0;

    public final String bEs() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.fAq + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.nYL + ";");
        stringBuffer.append("infourl " + this.vjB + ";");
        stringBuffer.append("locTypeId " + this.nWi + ";");
        stringBuffer.append("poiType " + this.vjC + ";");
        if (this.hzy != null) {
            stringBuffer.append("addr " + this.hzy.toString() + ";");
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.fAq);
        parcel.writeString(this.label);
        parcel.writeString(this.nYL);
        parcel.writeString(this.vjB);
        parcel.writeString(this.nWi);
        parcel.writeInt(this.vjC);
        parcel.writeParcelable(this.hzy, i);
    }
}
