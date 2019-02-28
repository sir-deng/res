package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class AppBrandLocalVideoObject extends AppBrandLocalMediaObject {
    public static final Creator<AppBrandLocalVideoObject> CREATOR = new Creator<AppBrandLocalVideoObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandLocalVideoObject(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalVideoObject[i];
        }
    };
    public int duration;
    public int height;
    public int size;
    public int width;

    /* synthetic */ AppBrandLocalVideoObject(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    private AppBrandLocalVideoObject(Parcel parcel) {
        super(parcel);
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public String toString() {
        return "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
    }
}
