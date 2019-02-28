package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel implements Parcelable {
    public static final Creator<LaunchParcel> CREATOR = new Creator<LaunchParcel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchParcel(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParcel[i];
        }
    };
    public String appId;
    public int iNi;
    public String iRi;
    public AppBrandLaunchReferrer iRl;
    public AppBrandStatObject jEr;
    public LaunchParamsOptional jEs;
    public String username;
    public int version;

    /* synthetic */ LaunchParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.version);
        parcel.writeInt(this.iNi);
        parcel.writeString(this.iRi);
        parcel.writeParcelable(this.jEr, i);
        parcel.writeParcelable(this.iRl, i);
        parcel.writeParcelable(this.jEs, i);
    }

    private LaunchParcel(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readInt();
        this.iNi = parcel.readInt();
        this.iRi = parcel.readString();
        this.jEr = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.iRl = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.jEs = (LaunchParamsOptional) parcel.readParcelable(LaunchParamsOptional.class.getClassLoader());
    }

    public final void b(AppBrandInitConfig appBrandInitConfig) {
        String str = null;
        if (appBrandInitConfig != null) {
            appBrandInitConfig.username = this.username;
            appBrandInitConfig.iRi = a.pP(this.iRi);
            appBrandInitConfig.iRl.a(this.iRl);
            appBrandInitConfig.hlj = this.jEs == null ? null : this.jEs.hlj;
            if (this.jEs != null) {
                str = this.jEs.hlk;
            }
            appBrandInitConfig.hlk = str;
        }
    }
}
