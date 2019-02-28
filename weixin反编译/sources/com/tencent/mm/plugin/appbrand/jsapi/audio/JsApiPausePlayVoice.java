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
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends a {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice jiF;

    private static class PausePlayVoice extends MainProcessTask {
        public static final Creator<PausePlayVoice> CREATOR = new Creator<PausePlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                PausePlayVoice pausePlayVoice = new PausePlayVoice();
                pausePlayVoice.f(parcel);
                return pausePlayVoice;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PausePlayVoice[i];
            }
        };

        private PausePlayVoice() {
        }

        /* synthetic */ PausePlayVoice(byte b) {
            this();
        }

        public final void YA() {
            ah.y(new Runnable() {
                public final void run() {
                    ((d) g.h(d.class)).pause();
                }
            });
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.jiF = new PausePlayVoice();
        AppBrandMainProcessService.a(this.jiF);
        jVar.E(i, e("ok", null));
    }
}
