package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiAdDataReport extends a {
    public static final int CTRL_INDEX = 435;
    public static final String NAME = "adDataReport";

    private static class AdDataReportTask extends MainProcessTask {
        public static final Creator<AdDataReportTask> CREATOR = new Creator<AdDataReportTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AdDataReportTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AdDataReportTask[i];
            }
        };
        private e jfE;
        private p jfF;
        private int jfG;
        private String jfH;

        public AdDataReportTask(e eVar, p pVar, int i, JSONObject jSONObject) {
            this.jfE = eVar;
            this.jfF = pVar;
            this.jfG = i;
            AppBrandStatObject pl = a.pl(pVar.mAppId);
            this.jfH = pl.scene + "," + pl.foi + "," + pl.fJn + "," + pl.fJo + "," + jSONObject.optString("adInfo");
        }

        public AdDataReportTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.JsApiAdDataReport", "mReportStr : %s", this.jfH);
            ((com.tencent.mm.plugin.sns.b.a) g.h(com.tencent.mm.plugin.sns.b.a.class)).e(15175, this.jfH, (int) bi.Wx());
            afF();
        }

        public final void YB() {
            this.jfF.E(this.jfG, this.jfE.e("ok", null));
        }

        public final void f(Parcel parcel) {
            this.jfH = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jfH);
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new AdDataReportTask(this, pVar, i, jSONObject));
    }
}
