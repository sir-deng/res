package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.ic;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class JsApiAppBrandNFCBase extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a jsc = null;

    public interface a {
        void K(int i, String str);
    }

    private static class CheckIsSupportHCETask extends MainProcessTask {
        public static final Creator<CheckIsSupportHCETask> CREATOR = new Creator<CheckIsSupportHCETask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CheckIsSupportHCETask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckIsSupportHCETask[0];
            }
        };
        private int errCode;
        private String foE;
        private JsApiAppBrandNFCBase jsd = null;

        public CheckIsSupportHCETask(JsApiAppBrandNFCBase jsApiAppBrandNFCBase) {
            this.jsd = jsApiAppBrandNFCBase;
        }

        public CheckIsSupportHCETask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            b icVar = new ic();
            com.tencent.mm.sdk.b.a.xmy.m(icVar);
            this.errCode = icVar.fzu.errCode;
            this.foE = icVar.fzu.foE;
            afF();
        }

        public final void YB() {
            super.YB();
            c.bl(this);
            if (this.jsd != null) {
                JsApiAppBrandNFCBase jsApiAppBrandNFCBase = this.jsd;
                int i = this.errCode;
                String str = this.foE;
                x.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                if (i != 0) {
                    if (bi.oN(str)) {
                        str = "unknown error";
                    }
                    if (jsApiAppBrandNFCBase.jsc != null) {
                        jsApiAppBrandNFCBase.jsc.K(i, str);
                    }
                } else if (jsApiAppBrandNFCBase.jsc != null) {
                    jsApiAppBrandNFCBase.jsc.K(i, str);
                }
            }
        }

        public int describeContents() {
            return super.describeContents();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.foE);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.errCode = parcel.readInt();
            this.foE = parcel.readString();
        }
    }

    protected final void a(a aVar) {
        this.jsc = aVar;
        MainProcessTask checkIsSupportHCETask = new CheckIsSupportHCETask(this);
        c.bk(checkIsSupportHCETask);
        AppBrandMainProcessService.a(checkIsSupportHCETask);
    }
}
