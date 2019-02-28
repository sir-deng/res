package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetRuntimeConfig implements Parcelable {
    public static final Creator<WidgetRuntimeConfig> CREATOR = new Creator<WidgetRuntimeConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
            widgetRuntimeConfig.appId = parcel.readString();
            widgetRuntimeConfig.iXt = parcel.readInt();
            widgetRuntimeConfig.iXJ = parcel.readInt();
            widgetRuntimeConfig.iXK = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            widgetRuntimeConfig.iXL = z;
            return widgetRuntimeConfig;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetRuntimeConfig[i];
        }
    };
    public String appId;
    public int iXJ = 32;
    public boolean iXK = false;
    public boolean iXL = true;
    public int iXt;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.iXt);
        parcel.writeInt(this.iXJ);
        if (this.iXK) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.iXL) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
