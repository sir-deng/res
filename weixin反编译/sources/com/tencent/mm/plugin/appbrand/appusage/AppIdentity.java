package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppIdentity implements Parcelable {
    public static final Creator<AppIdentity> CREATOR = new Creator<AppIdentity>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppIdentity(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppIdentity[i];
        }
    };
    public final int iNi;
    public final String username;

    public AppIdentity(String str, int i) {
        this.username = str;
        this.iNi = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.iNi);
    }

    protected AppIdentity(Parcel parcel) {
        this.username = parcel.readString();
        this.iNi = parcel.readInt();
    }
}
