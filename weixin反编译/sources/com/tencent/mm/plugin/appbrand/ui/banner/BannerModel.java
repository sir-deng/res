package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;

final class BannerModel implements Parcelable {
    public static final Creator<BannerModel> CREATOR = new Creator<BannerModel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BannerModel(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BannerModel[i];
        }
    };
    private static volatile BannerModel jUr;
    String appId;
    String appName;
    int iNi;
    String iNr;
    String jUq;

    /* synthetic */ BannerModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.iNi);
        parcel.writeString(this.appName);
        parcel.writeString(this.iNr);
        parcel.writeString(this.jUq);
    }

    BannerModel() {
    }

    private BannerModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.iNi = parcel.readInt();
        this.appName = parcel.readString();
        this.iNr = parcel.readString();
        this.jUq = parcel.readString();
    }

    static BannerModel alS() {
        BannerModel alJ;
        synchronized (BannerModel.class) {
            alJ = ((e) g.h(e.class)).alJ();
            jUr = alJ;
        }
        return alJ;
    }

    static BannerModel alT() {
        BannerModel bannerModel;
        synchronized (BannerModel.class) {
            bannerModel = jUr;
        }
        return bannerModel;
    }
}
