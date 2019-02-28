package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Creator<AppBrandPreInitTask> CREATOR = new Creator<AppBrandPreInitTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandPreInitTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPreInitTask[i];
        }
    };
    private String appId;
    private int iNi;
    private transient a jCl;
    private AppBrandInitConfig jCm;
    private AppBrandStatObject jCn;

    public interface a {
        void a(AppBrandInitConfig appBrandInitConfig);
    }

    /* synthetic */ AppBrandPreInitTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public AppBrandPreInitTask(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.appId = str;
        this.iNi = i;
        this.jCn = appBrandStatObject;
        this.jCl = aVar;
    }

    public final void YB() {
        if (this.jCl != null) {
            this.jCl.a(this.jCm);
        }
        afz();
    }

    public final void YA() {
        c.Dt().F(new c(this.appId, this.iNi, this.jCn, new com.tencent.mm.plugin.appbrand.launching.c.a() {
            public final void c(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
                AppBrandPreInitTask.this.jCm = appBrandInitConfig;
                AppBrandPreInitTask.this.jCn = appBrandStatObject;
                if (appBrandInitConfig != null) {
                    b.b(appBrandInitConfig, appBrandStatObject);
                }
                AppBrandPreInitTask.this.afF();
            }
        }));
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.iNi);
        parcel.writeParcelable(this.jCm, i);
        parcel.writeParcelable(this.jCn, i);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.iNi = parcel.readInt();
        this.jCm = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.jCn = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
    }

    private AppBrandPreInitTask(Parcel parcel) {
        f(parcel);
    }
}
