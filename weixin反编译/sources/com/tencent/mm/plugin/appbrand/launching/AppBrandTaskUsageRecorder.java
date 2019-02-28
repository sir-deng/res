package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.ccc;
import com.tencent.mm.protocal.c.cdc;
import com.tencent.mm.protocal.c.cds;

public final class AppBrandTaskUsageRecorder {

    private static final class LaunchCheckParams implements Parcelable {
        public static final Creator<LaunchCheckParams> CREATOR = new Creator<LaunchCheckParams>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchCheckParams(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchCheckParams[i];
            }
        };
        final int iJb;
        final boolean iXB = true;
        final String iub;
        final AppBrandInitConfig jCO;
        final AppBrandStatObject jCP;
        final int jkI;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.jCO, i);
            parcel.writeParcelable(this.jCP, i);
            parcel.writeInt(this.iJb);
            parcel.writeInt(this.jkI);
            parcel.writeString(this.iub);
        }

        public LaunchCheckParams(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject, int i, int i2, String str) {
            this.jCO = appBrandInitConfig;
            this.jCP = appBrandStatObject;
            this.iJb = i;
            this.jkI = i2;
            this.iub = str;
        }

        LaunchCheckParams(Parcel parcel) {
            this.jCO = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
            this.jCP = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.iJb = parcel.readInt();
            this.jkI = parcel.readInt();
            this.iub = parcel.readString();
        }
    }

    private static final class UpdateTask extends MainProcessTask {
        public static final Creator<UpdateTask> CREATOR = new Creator<UpdateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new UpdateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UpdateTask[i];
            }
        };
        LaunchCheckParams jCQ;

        public final void YA() {
            cds cds = null;
            if (g.Do().gRj && !a.Cz()) {
                cdc cdc;
                this.jCQ.getClass();
                AppBrandLaunchReferrer appBrandLaunchReferrer = this.jCQ.jCO.iRl;
                if (appBrandLaunchReferrer == null || 1 != appBrandLaunchReferrer.iRp) {
                    cdc = null;
                } else {
                    cdc = new cdc();
                    cdc.wAh = appBrandLaunchReferrer.appId;
                    cdc.wAb = appBrandLaunchReferrer.fqY;
                }
                if (appBrandLaunchReferrer != null && 2 == appBrandLaunchReferrer.iRp) {
                    cds = new cds();
                    cds.nqc = appBrandLaunchReferrer.appId;
                    cds.nlE = appBrandLaunchReferrer.url;
                }
                ccc ccc = new ccc();
                ccc.wAn = this.jCQ.jCO.iIZ;
                ccc.vTR = this.jCQ.iJb;
                ccc.sfa = this.jCQ.jCP.scene;
                ccc.wDN = this.jCQ.jCO.iRi;
                ccc.wDM = 1;
                ccc.wDL = this.jCQ.jCP.fJn;
                new e(this.jCQ.jCO.appId, false, ccc, cds, cdc, this.jCQ.iub, this.jCQ.jkI).aiA();
            }
        }

        public UpdateTask(LaunchCheckParams launchCheckParams) {
            this.jCQ = launchCheckParams;
        }

        UpdateTask(Parcel parcel) {
            f(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void f(Parcel parcel) {
            this.jCQ = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.jCQ, i);
        }
    }
}
