package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask extends a {
    public static final int CTRL_INDEX = 443;
    public static final String NAME = "pauseDownloadTask";

    private static class PauseDownloadTask extends MainProcessTask {
        public static final Creator<PauseDownloadTask> CREATOR = new Creator<PauseDownloadTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new PauseDownloadTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PauseDownloadTask[i];
            }
        };
        private j isW;
        private e jfE;
        private int jfG;
        private boolean jfQ;
        private String jfR;
        private long jfS;

        public PauseDownloadTask(e eVar, j jVar, int i, JSONObject jSONObject) {
            this.jfE = eVar;
            this.isW = jVar;
            this.jfG = i;
            this.jfS = jSONObject.optLong("downloadId");
            this.jfQ = true;
        }

        public PauseDownloadTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            boolean z = true;
            x.i("MicroMsg.JsApiPauseDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.jfS));
            if (this.jfS <= 0) {
                this.jfR = "downloadId invalid";
            } else {
                if (f.aAK().ca(this.jfS)) {
                    z = false;
                }
                this.jfQ = z;
            }
            afF();
        }

        public final void YB() {
            if (this.jfQ) {
                String str;
                if (bi.oN(this.jfR)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.jfR});
                }
                this.isW.E(this.jfG, this.jfE.e(str, null));
                return;
            }
            this.isW.E(this.jfG, this.jfE.e("ok", null));
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.jfS = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jfQ = z;
            this.jfR = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.jfS);
            parcel.writeInt(this.jfQ ? 1 : 0);
            parcel.writeString(this.jfR);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new PauseDownloadTask(this, jVar, i, jSONObject));
    }
}
