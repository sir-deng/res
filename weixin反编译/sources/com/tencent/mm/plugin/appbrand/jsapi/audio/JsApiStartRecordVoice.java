package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f;
import com.tencent.mm.plugin.appbrand.media.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartRecordVoice extends a {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String jiU = null;
    private StartRecordVoice jiV;
    private p jiu;
    private int jiv;

    private static class StartRecordVoice extends MainProcessTask {
        public static final Creator<StartRecordVoice> CREATOR = new Creator<StartRecordVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartRecordVoice(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartRecordVoice[i];
            }
        };
        private String appId;
        private int duration;
        private String filePath;
        private j jga;
        private int jgb;
        private JsApiStartRecordVoice jiX;
        private boolean jiY = false;
        private boolean jiZ = false;
        private boolean jja = false;
        private int result;

        static /* synthetic */ void b(StartRecordVoice startRecordVoice) {
            if (startRecordVoice.jiZ) {
                if (com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.bw(startRecordVoice.filePath + ".originpcm", startRecordVoice.filePath + ".wav")) {
                    x.i("MicroMsg.JsApiStartRecordVoice", "alvinluo startRecord savePcmAsWav success");
                    return;
                }
                x.e("MicroMsg.JsApiStartRecordVoice", "alvinluo startRecord savePcmAsWav failed");
                startRecordVoice.result = -1;
            }
        }

        StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, j jVar, int i, int i2) {
            this.jiX = jsApiStartRecordVoice;
            this.jga = jVar;
            this.duration = i;
            this.jgb = i2;
            this.appId = jVar.mAppId;
            this.filePath = AppBrandLocalMediaObjectManager.genMediaFilePath(this.appId, u.oi(this.appId));
        }

        StartRecordVoice(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            c.Dt().F(new Runnable() {
                public final void run() {
                    StartRecordVoice.this.jiY = b.a(StartRecordVoice.this.filePath, new b.a() {
                        public final void kt(int i) {
                            StartRecordVoice.this.result = i;
                            StartRecordVoice.b(StartRecordVoice.this);
                            StartRecordVoice.this.afF();
                        }
                    }, StartRecordVoice.this.duration * 1000, StartRecordVoice.this.jiZ);
                    if (!StartRecordVoice.this.jiY) {
                        StartRecordVoice.this.afF();
                    }
                }
            });
        }

        public final void YB() {
            if (this.result == -1) {
                x.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
                this.jga.E(this.jgb, this.jiX.e("fail:record_error", null));
                if (this.jiZ) {
                    int i = f.jzB;
                    f.ahV();
                }
            } else if (bi.oN(this.filePath)) {
                x.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
                this.jga.E(this.jgb, this.jiX.e("fail:record_error", null));
            } else {
                if (this.jiZ) {
                    try {
                        Map hashMap = new HashMap(1);
                        String str = this.filePath + ".originpcm";
                        String str2 = this.filePath + ".denoisepcm";
                        String str3 = this.filePath + ".wav";
                        AppBrandLocalMediaObject attachTmpVoice = AppBrandLocalMediaObjectManager.attachTmpVoice(this.jga.mAppId, str, "originpcm", true);
                        AppBrandLocalMediaObject attachTmpVoice2 = AppBrandLocalMediaObjectManager.attachTmpVoice(this.jga.mAppId, str3, "wav", true);
                        if (attachTmpVoice == null || attachTmpVoice2 == null) {
                            this.jga.E(this.jgb, this.jiX.e("fail export wav failed", null));
                        } else {
                            x.d("MicroMsg.JsApiStartRecordVoice", "alvinluo startRecord originPcm localId: %s, full: %s", attachTmpVoice.fvn, attachTmpVoice.hjJ);
                            hashMap.put("pcmFilePath", attachTmpVoice.fvn);
                            hashMap.put("tempFilePath", attachTmpVoice2.fvn);
                            File file = new File(str2);
                            str = attachTmpVoice.hjJ + ".denoisepcm";
                            if (file.exists()) {
                                e.x(str2, str);
                                com.tencent.mm.loader.stub.b.deleteFile(str2);
                            } else {
                                x.e("MicroMsg.JsApiStartRecordVoice", "alvinluo startRecord denoisePcmFile not exist");
                            }
                            this.jga.E(this.jgb, this.jiX.e("ok", hashMap));
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiStartRecordVoice", e, "alvinluo startRecord exportWav exception", new Object[0]);
                        this.jga.E(this.jgb, this.jiX.e("fail export wav failed", null));
                    }
                } else {
                    AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.jga.mAppId, this.filePath, "silk", true);
                    if (!this.jiY || attach == null) {
                        this.jga.E(this.jgb, this.jiX.e("fail", null));
                    } else {
                        Map hashMap2 = new HashMap(1);
                        hashMap2.put("tempFilePath", attach.fvn);
                        this.jga.E(this.jgb, this.jiX.e("ok", hashMap2));
                    }
                }
                x.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.jiY));
                this.jiX.cK(false);
            }
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.jgb = parcel.readInt();
            this.appId = parcel.readString();
            this.filePath = parcel.readString();
            this.jiY = parcel.readByte() != (byte) 0;
            this.duration = parcel.readInt();
            this.result = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jiZ = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.jja = z2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeInt(this.jgb);
            parcel.writeString(this.appId);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.jiY ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.result);
            if (this.jiZ) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.jja) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }
    }

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        boolean z;
        int i2 = 60;
        int i3 = 600;
        x.d("MicroMsg.JsApiStartRecordVoice", "alvinluo startRecord data: %s", jSONObject);
        com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 116) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        jVar.E(i, JsApiStartRecordVoice.this.e("fail:system permission denied", null));
                    } else {
                        JsApiStartRecordVoice.this.a(jVar, jSONObject, i);
                    }
                }
            }
        });
        Activity a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.g.a.a(a, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.pj(jVar.mAppId);
            }
        }
        if (z) {
            this.jiu = com.tencent.mm.plugin.appbrand.jsapi.e.b(jVar);
            if (this.jiu == null) {
                jVar.E(i, e("fail", null));
                return;
            }
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
            if (optInt <= 0) {
                x.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
            } else {
                i2 = optInt;
            }
            if (i2 > 600) {
                x.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", Integer.valueOf(600));
            } else {
                i3 = i2;
            }
            boolean optBoolean = jSONObject.optBoolean("exportWav", false);
            this.jiu.a(new d() {
                public final void afQ() {
                    JsApiStopRecordVoice.d(jVar);
                    JsApiStartRecordVoice.this.jiu.b((d) this);
                }
            });
            this.jiu.a(new p.e() {
                public final void onDestroy() {
                    JsApiStopRecordVoice.d(jVar);
                    JsApiStartRecordVoice.this.jiu.b((p.e) this);
                }
            });
            this.jiV = new StartRecordVoice(this, jVar, i3, i);
            this.jiV.jiZ = optBoolean;
            jiU = this.jiV.filePath;
            AppBrandMainProcessService.a(this.jiV);
            cK(true);
            return;
        }
        jVar.E(i, e("fail", null));
    }

    private void cK(final boolean z) {
        if (this.jiu != null) {
            if (!ah.isMainThread()) {
                ah.y(new Runnable() {
                    public final void run() {
                        JsApiStartRecordVoice.this.cK(z);
                    }
                });
            } else if (z) {
                this.jiv = com.tencent.mm.plugin.appbrand.page.a.q(this.jiu.iuk).a(com.tencent.mm.plugin.appbrand.page.a.a.VOICE);
                i.pF(this.jiu.mAppId).iug = this.jiv;
            } else {
                com.tencent.mm.plugin.appbrand.page.a.q(this.jiu.iuk).ls(this.jiv);
            }
        }
    }
}
