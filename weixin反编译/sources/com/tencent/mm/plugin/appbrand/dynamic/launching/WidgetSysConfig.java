package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetSysConfig implements Parcelable {
    public static final Creator<WidgetSysConfig> CREATOR = new Creator<WidgetSysConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.iQE = parcel.readInt();
            widgetSysConfig.iQF = parcel.readInt();
            widgetSysConfig.iQG = parcel.readInt();
            return widgetSysConfig;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetSysConfig[i];
        }
    };
    public int iQE;
    public int iQF;
    public int iQG;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iQE);
        parcel.writeInt(this.iQF);
        parcel.writeInt(this.iQG);
    }
}
