package com.tencent.mm.plugin.appbrand.jsapi.voicejoint;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.JointVoiceUploader;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.JointVoiceUploader.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiDownloadSilkVoice extends a {
    public static final int CTRL_INDEX = 438;
    public static final String NAME = "downloadSilkVoice";
    private String fAM;
    private String hda;
    private j isW = null;
    private int jfG = -1;

    private static class DownloadSilkVoiceTask extends MainProcessTask {
        public static final Creator<DownloadSilkVoiceTask> CREATOR = new Creator<DownloadSilkVoiceTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DownloadSilkVoiceTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DownloadSilkVoiceTask[0];
            }
        };
        private String appId;
        private int errCode;
        private String fAM;
        private String foE;
        private String hda;
        private String jxU;
        private JsApiDownloadSilkVoice jxV = null;

        public DownloadSilkVoiceTask(String str, JsApiDownloadSilkVoice jsApiDownloadSilkVoice) {
            this.appId = str;
            this.jxV = jsApiDownloadSilkVoice;
        }

        public DownloadSilkVoiceTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            this.jxU = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.aid() + ac.VF(this.fAM) + "." + "silk";
            JointVoiceUploader.a(this.appId, this.jxU, this.fAM, this.hda, new b() {
                public final void a(com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.b bVar) {
                    if (bVar != null) {
                        x.d("MicroMsg.JsApiDownloadSilkVoice", "alvinluo downloadSilkVoice success donwloadFilePath: %s, fileId: %s, aesKey: %s", DownloadSilkVoiceTask.this.jxU, DownloadSilkVoiceTask.this.fAM, bi.Wz(DownloadSilkVoiceTask.this.hda));
                        AppBrandLocalMediaObject attachTmpVoice = AppBrandLocalMediaObjectManager.attachTmpVoice(DownloadSilkVoiceTask.this.appId, DownloadSilkVoiceTask.this.jxU, "silk", true);
                        if (attachTmpVoice != null) {
                            DownloadSilkVoiceTask.this.jxU = attachTmpVoice.fvn;
                            DownloadSilkVoiceTask.this.errCode = 0;
                            DownloadSilkVoiceTask.this.foE = "ok";
                        } else {
                            x.e("MicroMsg.JsApiDownloadSilkVoice", "alvinluo download attach failed");
                            DownloadSilkVoiceTask.this.errCode = 8001;
                            DownloadSilkVoiceTask.this.foE = "downloadSilkVoice local fileSystem error";
                        }
                    } else {
                        x.e("MicroMsg.JsApiDownloadSilkVoice", "alvinluo downloadSilkVoice unknown error: onSuccess but result is null");
                        DownloadSilkVoiceTask.this.errCode = 8100;
                        DownloadSilkVoiceTask.this.foE = "downloadSilkVoice unknown error";
                    }
                    DownloadSilkVoiceTask.this.afF();
                }

                public final void L(int i, String str) {
                    x.e("MicroMsg.JsApiDownloadSilkVoice", "alvinluo downloadSilkVoice callback onFailed errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                    DownloadSilkVoiceTask.this.errCode = i;
                    DownloadSilkVoiceTask.this.foE = str;
                    DownloadSilkVoiceTask.this.afF();
                }

                public final void bK(int i, int i2) {
                    x.d("MicroMsg.JsApiDownloadSilkVoice", "alvinluo downloadSilkVoice callback onProgress finishedLength: %d, totalLength: %s", Integer.valueOf(i), Integer.valueOf(i2));
                }
            });
        }

        public final void YB() {
            super.YB();
            Map hashMap = new HashMap(2);
            if (this.errCode == 0) {
                hashMap.put(DownloadInfoColumns.FILEPATH, this.jxU);
                if (this.jxV != null) {
                    this.jxV.sE(this.jxV.e("ok", hashMap));
                }
            } else {
                hashMap.put("errCode", Integer.valueOf(this.errCode));
                this.foE = "unknown error";
                if (this.jxV != null) {
                    this.jxV.sE(this.jxV.e("fail " + this.foE, hashMap));
                }
            }
            c.bl(this);
        }

        public int describeContents() {
            return super.describeContents();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.appId);
            parcel.writeString(this.fAM);
            parcel.writeString(this.hda);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.foE);
            parcel.writeString(this.jxU);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.appId = parcel.readString();
            this.fAM = parcel.readString();
            this.hda = parcel.readString();
            this.errCode = parcel.readInt();
            this.foE = parcel.readString();
            this.jxU = parcel.readString();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        this.isW = jVar;
        this.jfG = i;
        this.fAM = jSONObject.optString("fileId");
        this.hda = jSONObject.optString("aesKey");
        if (bi.oN(this.fAM) || bi.oN(this.hda)) {
            x.e("MicroMsg.JsApiDownloadSilkVoice", "alvinluo invalid fileId or aesKey");
            sE(e("fail download failed", null));
            return;
        }
        MainProcessTask downloadSilkVoiceTask = new DownloadSilkVoiceTask(this.isW.mAppId, this);
        downloadSilkVoiceTask.fAM = this.fAM;
        downloadSilkVoiceTask.hda = this.hda;
        c.bk(downloadSilkVoiceTask);
        AppBrandMainProcessService.a(downloadSilkVoiceTask);
    }

    final void sE(String str) {
        x.i("MicroMsg.JsApiDownloadSilkVoice", "alvinluo downloadSilkVoice callback result: %s", str);
        if (this.isW != null) {
            this.isW.E(this.jfG, str);
        }
    }
}
