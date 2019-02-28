package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.hk;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment extends a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private GetIsEnrolledTask jkK = null;

    private static class GetIsEnrolledTask extends MainProcessTask {
        public static final Creator<GetIsEnrolledTask> CREATOR = new Creator<GetIsEnrolledTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetIsEnrolledTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsEnrolledTask[i];
            }
        };
        private j isW = null;
        private int jfG = -1;
        private JsApiCheckBioEnrollment jkL;
        private int jkM = -1;
        private int jkN = -1;

        public final void YB() {
            boolean z = false;
            super.YB();
            x.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.jkN));
            Map hashMap = new HashMap(2);
            String str = "isEnrolled";
            if (this.jkN == 1) {
                z = true;
            }
            hashMap.put(str, Boolean.valueOf(z));
            if (this.jkN == 0) {
                this.isW.E(this.jfG, this.jkL.e("ok", hashMap));
            } else if (this.jkN == -1) {
                this.isW.E(this.jfG, this.jkL.e("fail not support", hashMap));
            } else if (this.jkN == 1) {
                this.isW.E(this.jfG, this.jkL.e("ok", hashMap));
            } else {
                this.isW.E(this.jfG, this.jkL.e("fail unknown error", hashMap));
            }
            c.bl(this);
        }

        public final void YA() {
            b hkVar = new hk();
            hkVar.fyz.fyB = this.jkM;
            com.tencent.mm.sdk.b.a.xmy.m(hkVar);
            this.jkN = hkVar.fyA.fyC;
            x.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.jkN));
            afF();
        }

        public GetIsEnrolledTask(j jVar, int i, int i2, JsApiCheckBioEnrollment jsApiCheckBioEnrollment) {
            this.isW = jVar;
            this.jfG = i;
            this.jkL = jsApiCheckBioEnrollment;
            this.jkM = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.jkN);
            parcel.writeInt(this.jkM);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            f(parcel);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.jkN = parcel.readInt();
            this.jkM = parcel.readInt();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.jkK = new GetIsEnrolledTask(jVar, i, a.sF(jSONObject.optString("checkAuthMode")), this);
        c.bk(this.jkK);
        AppBrandMainProcessService.a(this.jkK);
    }
}
