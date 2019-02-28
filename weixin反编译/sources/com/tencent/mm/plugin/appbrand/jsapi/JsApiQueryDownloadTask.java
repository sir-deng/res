package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask extends a {
    public static final int CTRL_INDEX = 441;
    public static final String NAME = "queryDownloadTask";

    private static class QueryDownloadTask extends MainProcessTask {
        public static final Creator<QueryDownloadTask> CREATOR = new Creator<QueryDownloadTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new QueryDownloadTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueryDownloadTask[i];
            }
        };
        private j isW;
        private e jfE;
        private int jfG;
        private boolean jfQ;
        private String jfR;
        private long jfS;
        private String jhc;
        private long jhd;

        public QueryDownloadTask(e eVar, j jVar, int i, JSONObject jSONObject) {
            this.jfE = eVar;
            this.isW = jVar;
            this.jfG = i;
            this.jfS = jSONObject.optLong("downloadId");
            this.jfQ = true;
        }

        public QueryDownloadTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.jfS));
            if (this.jfS <= 0) {
                this.jfR = "downloadId invalid";
            } else {
                FileDownloadTaskInfo bZ = f.aAK().bZ(this.jfS);
                switch (bZ.status) {
                    case -1:
                        this.jfR = "fail_apilevel_too_low";
                        break;
                    case 1:
                        this.jhc = "downloading";
                        break;
                    case 2:
                        this.jhc = "download_pause";
                        break;
                    case 3:
                        if (!e.bO(bZ.path)) {
                            this.jhc = "default";
                            break;
                        } else {
                            this.jhc = "download_succ";
                            break;
                        }
                    case 4:
                        this.jhc = "download_fail";
                        break;
                    default:
                        this.jhc = "default";
                        break;
                }
                x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.jhc);
                if (this.jhc == "downloading" && bZ.fxb != 0) {
                    this.jhd = (long) ((((float) bZ.fxa) / ((float) bZ.fxb)) * 100.0f);
                }
                this.jfQ = false;
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
            Map hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.jfS));
            hashMap.put("state", this.jhc);
            hashMap.put("progress", Long.valueOf(this.jhd));
            this.isW.E(this.jfG, this.jfE.e("ok", hashMap));
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.jfS = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jfQ = z;
            this.jfR = parcel.readString();
            this.jhc = parcel.readString();
            this.jhd = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.jfS);
            parcel.writeInt(this.jfQ ? 1 : 0);
            parcel.writeString(this.jfR);
            parcel.writeString(this.jhc);
            parcel.writeLong(this.jhd);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new QueryDownloadTask(this, jVar, i, jSONObject));
    }
}
