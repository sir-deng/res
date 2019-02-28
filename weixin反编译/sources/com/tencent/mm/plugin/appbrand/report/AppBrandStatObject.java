package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new Creator<AppBrandStatObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandStatObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandStatObject[i];
        }
    };
    public int fJm;
    public int fJn;
    public String fJo;
    public String foi;
    public int jMN;
    public int scene;

    public final String toString() {
        return "AppBrandStatObject{preScene=" + this.fJn + ", preSceneNote='" + this.fJo + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.foi + '\'' + ", usedState=" + this.jMN + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fJn);
        parcel.writeString(this.fJo);
        parcel.writeInt(this.scene);
        parcel.writeString(this.foi);
        parcel.writeInt(this.jMN);
        parcel.writeInt(this.fJm);
    }

    protected AppBrandStatObject(Parcel parcel) {
        this.fJn = parcel.readInt();
        this.fJo = parcel.readString();
        this.scene = parcel.readInt();
        this.foi = parcel.readString();
        this.jMN = parcel.readInt();
        this.fJm = parcel.readInt();
    }
}
