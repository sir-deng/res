package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.media.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class JsApiStopRecordVoice extends a {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    private static class StopRecordVoice extends MainProcessTask {
        public static final Creator<StopRecordVoice> CREATOR = new Creator<StopRecordVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopRecordVoice();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopRecordVoice[i];
            }
        };

        private StopRecordVoice() {
        }

        /* synthetic */ StopRecordVoice(byte b) {
            this();
        }

        public final void YA() {
            c.Dt().F(new Runnable() {
                public final void run() {
                    b.lk(1);
                }
            });
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        d(jVar);
        jVar.E(i, e("ok", null));
    }

    static void d(j jVar) {
        if (!bi.oN(JsApiStartRecordVoice.jiU)) {
            com.tencent.mm.plugin.appbrand.page.a.q(jVar.iuk).ls(i.pE(jVar.mAppId).iug);
            AppBrandMainProcessService.a(new StopRecordVoice());
            JsApiStartRecordVoice.jiU = null;
        }
    }
}
