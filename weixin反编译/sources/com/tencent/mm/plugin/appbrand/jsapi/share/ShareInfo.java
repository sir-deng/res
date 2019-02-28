package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ShareInfo implements Parcelable {
    public static final Creator<ShareInfo> CREATOR = new Creator<ShareInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ShareInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareInfo[i];
        }
    };
    public String hlj;
    public String hlk;

    /* synthetic */ ShareInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hlk);
        parcel.writeString(this.hlj);
    }

    public ShareInfo(String str, String str2) {
        this.hlk = str;
        this.hlj = str2;
    }

    private ShareInfo(Parcel parcel) {
        this.hlk = parcel.readString();
        this.hlj = parcel.readString();
    }
}
