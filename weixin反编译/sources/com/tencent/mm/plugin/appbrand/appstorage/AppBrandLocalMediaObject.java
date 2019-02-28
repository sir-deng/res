package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandLocalMediaObject implements Parcelable {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new Creator<AppBrandLocalMediaObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandLocalMediaObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalMediaObject[i];
        }
    };
    public String fvn;
    public String hjJ;
    public String iKK;
    public boolean iKL;
    public long iKM;
    public long igZ;
    public String mimeType;

    public String toString() {
        return "AppBrandLocalMediaObject{localId='" + this.fvn + '\'' + ", fileFullPath='" + this.hjJ + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.iKK + '\'' + '}';
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fvn);
        parcel.writeString(this.hjJ);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.iKK);
        parcel.writeByte(this.iKL ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.igZ);
        parcel.writeLong(this.iKM);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        this.fvn = parcel.readString();
        this.hjJ = parcel.readString();
        this.mimeType = parcel.readString();
        this.iKK = parcel.readString();
        this.iKL = parcel.readByte() != (byte) 0;
        this.igZ = parcel.readLong();
        this.iKM = parcel.readLong();
    }
}
