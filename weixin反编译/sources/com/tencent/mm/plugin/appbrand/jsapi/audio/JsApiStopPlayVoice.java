package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends a {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    private static class StopPlayVoice extends MainProcessTask {
        public static final Creator<StopPlayVoice> CREATOR = new Creator<StopPlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopPlayVoice();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopPlayVoice[i];
            }
        };

        private StopPlayVoice() {
        }

        /* synthetic */ StopPlayVoice(byte b) {
            this();
        }

        public final void YA() {
            ah.y(new Runnable() {
                public final void run() {
                    ((d) g.h(d.class)).stop();
                }
            });
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("localId");
        x.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", jVar.mAppId, optString);
        AppBrandMainProcessService.a(new StopPlayVoice());
        jVar.E(i, e("ok", null));
        JsApiStartPlayVoice.jiN = null;
    }

    public static void afR() {
        if (!bi.oN(JsApiStartPlayVoice.jiN)) {
            AppBrandMainProcessService.a(new StopPlayVoice());
            JsApiStartPlayVoice.jiN = null;
        }
    }
}
