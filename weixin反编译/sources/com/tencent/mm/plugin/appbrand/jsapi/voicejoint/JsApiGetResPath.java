package com.tencent.mm.plugin.appbrand.jsapi.voicejoint;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.bd;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalTmpVoiceObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.d;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.pluginsdk.i.a.b.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetResPath extends a {
    public static final int CTRL_INDEX = 450;
    public static final String NAME = "getResPath";
    private j isW;
    private int jfG;
    private int jxX;
    private int jxY;
    private int jxZ;
    private String jya;
    private String jyb;

    private static class GetResPathTask extends MainProcessTask {
        public static final Creator<GetResPathTask> CREATOR = new Creator<GetResPathTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetResPathTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetResPathTask[0];
            }
        };
        private String appId;
        private int errCode;
        private String fAM;
        private String foE;
        private int fqg;
        private int fqh;
        private int jyc;
        private String jyd;
        private String jye;
        private JsApiGetResPath jyf = null;

        public GetResPathTask(String str, JsApiGetResPath jsApiGetResPath) {
            this.appId = str;
            this.jyf = jsApiGetResPath;
        }

        public GetResPathTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            int i = f.jzB;
            f.kV(1);
            final String P = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.P(this.fqh, this.fAM);
            x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath middleFilePath: %s", P);
            if (new File(P).exists()) {
                x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath res exist in the middle directory");
                tl(P);
                return;
            }
            d dVar = d.jzN;
            if (d.bN(this.fqg, this.fqh)) {
                x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath res downloaded and try to decrypt");
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.a() {
                    public final void a(bc bcVar) {
                        if (GetResPathTask.this.fqg == bcVar.fqf.fqg && GetResPathTask.this.fqh == bcVar.fqf.fqh) {
                            x.i("MicroMsg.JsApiGetResPath", "alvinluo onResDecryptSuccess resType: %d, subType: %d", Integer.valueOf(bcVar.fqf.fqg), Integer.valueOf(bcVar.fqf.fqh));
                            int i = f.jzB;
                            f.kX(2);
                            GetResPathTask.this.tl(P);
                            d dVar = d.jzN;
                            GetResPathTask.this.fqg;
                            GetResPathTask.this.fqh;
                            dVar.a(this);
                        }
                    }

                    public final void a(bd bdVar) {
                        if (GetResPathTask.this.fqg == bdVar.fqk.fqg && GetResPathTask.this.fqh == bdVar.fqk.fqh) {
                            x.e("MicroMsg.JsApiGetResPath", "alvinluo onResDecryptFailed resType: %d, subType: %d", Integer.valueOf(bdVar.fqk.fqg), Integer.valueOf(bdVar.fqk.fqh));
                            GetResPathTask.this.errCode = 8013;
                            GetResPathTask.this.foE = "getResPath res decrypt failed";
                            int i = f.jzB;
                            f.kX(3);
                            GetResPathTask.this.afF();
                            d dVar = d.jzN;
                            GetResPathTask.this.fqg;
                            GetResPathTask.this.fqh;
                            dVar.a(this);
                        }
                    }
                };
                d dVar2 = d.jzN;
                if (dVar2.jzO != null) {
                    dVar2.jzO.add(anonymousClass1);
                }
                i = f.jzB;
                f.kX(1);
                dVar = d.jzN;
                int i2 = this.fqg;
                int i3 = this.fqh;
                P = this.jyd;
                x.i("MicroMsg.ResDownloadManager", "alvinluo decryptRes resType: %d, subType: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                try {
                    P = P.trim();
                    if (!P.startsWith("<sysmsg")) {
                        x.i("MicroMsg.ResDownloadManager", "alvinluo decryptRes add header");
                        P = "<sysmsg type=\"resourcemgr\">" + P + "</sysmsg>";
                    }
                    x.d("MicroMsg.ResDownloadManager", "alvinluo decryptRes content: %s", P);
                    e.ba(P, false);
                    c.vnr;
                    if (bi.oN(b.eA(i2, i3))) {
                        x.e("MicroMsg.ResDownloadManager", "alvinluo decryptRes failed");
                        dVar.bM(i2, i3);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ResDownloadManager", e, "alvinluo decryptRes exception", new Object[0]);
                    return;
                }
            }
            x.e("MicroMsg.JsApiGetResPath", "alvinluo res not downloaded resType: %d, subType: %d", Integer.valueOf(this.fqg), Integer.valueOf(this.fqh));
            this.errCode = 8012;
            this.foE = "getResPath res not downloaded";
            i = f.jzB;
            f.kW(8012);
            afF();
        }

        private void tl(String str) {
            int i = 1;
            try {
                if (new File(str).exists()) {
                    AppBrandLocalTmpVoiceObject attachTmpVoice;
                    String Q;
                    AppBrandLocalTmpVoiceObject attachTmpVoiceFullPath = AppBrandLocalMediaObjectManager.attachTmpVoiceFullPath(this.appId, str, "silk");
                    if (attachTmpVoiceFullPath != null) {
                        x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath localFullPath %s", attachTmpVoiceFullPath.hjJ);
                        if (new File(attachTmpVoiceFullPath.hjJ).exists()) {
                            x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath already exist pcm in the appbrand directory");
                            this.jye = attachTmpVoiceFullPath.fvn;
                            if (i == 0) {
                                i = f.jzB;
                                f.kU(1);
                                attachTmpVoice = AppBrandLocalMediaObjectManager.attachTmpVoice(this.appId, str, "silk", false);
                                if (attachTmpVoice == null) {
                                    this.jye = attachTmpVoice.fvn;
                                    i = f.jzB;
                                    f.kU(2);
                                } else {
                                    x.e("MicroMsg.JsApiGetResPath", "alvinluo getResPath attach failed");
                                    this.errCode = 8100;
                                    this.foE = "attach tmp voice error";
                                    i = f.jzB;
                                    f.kU(2);
                                    afF();
                                    return;
                                }
                            }
                            Q = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.Q(this.jyc, this.appId);
                            x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath silk to pcm, pcmFilePath: %s", Q);
                            if (new File(Q).exists()) {
                                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.a(str, Q, new com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.b() {
                                    public final void onSuccess() {
                                        x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath silk to pcm success");
                                        GetResPathTask.this.errCode = 0;
                                        GetResPathTask.this.foE = "ok";
                                        GetResPathTask.this.afF();
                                    }

                                    public final void ahO() {
                                        x.e("MicroMsg.JsApiGetResPath", "alvinluo getResPath silk to pcm failed");
                                        GetResPathTask.this.errCode = 8006;
                                        GetResPathTask.this.foE = "silk to pcm failed";
                                        GetResPathTask.this.afF();
                                        int i = f.jzB;
                                        f.kR(8026);
                                    }
                                });
                                return;
                            }
                            x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath pcm file exist");
                            this.errCode = 0;
                            this.foE = "ok";
                            afF();
                            return;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        i = f.jzB;
                        f.kU(1);
                        attachTmpVoice = AppBrandLocalMediaObjectManager.attachTmpVoice(this.appId, str, "silk", false);
                        if (attachTmpVoice == null) {
                            x.e("MicroMsg.JsApiGetResPath", "alvinluo getResPath attach failed");
                            this.errCode = 8100;
                            this.foE = "attach tmp voice error";
                            i = f.jzB;
                            f.kU(2);
                            afF();
                            return;
                        }
                        this.jye = attachTmpVoice.fvn;
                        i = f.jzB;
                        f.kU(2);
                    }
                    Q = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.Q(this.jyc, this.appId);
                    x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath silk to pcm, pcmFilePath: %s", Q);
                    if (new File(Q).exists()) {
                        com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.a(str, Q, /* anonymous class already generated */);
                        return;
                    }
                    x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath pcm file exist");
                    this.errCode = 0;
                    this.foE = "ok";
                    afF();
                    return;
                }
                x.e("MicroMsg.JsApiGetResPath", "alvinluo getResPath silk not exist after decrypt");
                this.errCode = 8015;
                this.foE = "res not exist after decrypt";
                afF();
                i = f.jzB;
                f.kW(8015);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiGetResPath", e, "alvinluo copy midlle file to appbrand directory exception", new Object[0]);
                this.errCode = 8011;
                this.foE = "getResPath copy middle file to appbrand directory error";
                afF();
            }
        }

        public final void YB() {
            super.YB();
            Map hashMap = new HashMap(1);
            int i;
            if (this.errCode == 0) {
                i = f.jzB;
                f.kV(2);
                i = f.jzB;
                f.kZ(0);
                hashMap.put("resPath", this.jye);
                if (this.jyf != null) {
                    this.jyf.sE(this.jyf.e("ok", hashMap));
                }
            } else {
                i = f.jzB;
                f.kV(3);
                i = f.jzB;
                f.kZ(this.errCode);
                hashMap.put("errCode", Integer.valueOf(this.errCode));
                this.foE = "unknown error";
                if (this.jyf != null) {
                    this.jyf.sE(this.jyf.e("fail " + this.foE, hashMap));
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
            parcel.writeInt(this.jyc);
            parcel.writeInt(this.fqg);
            parcel.writeInt(this.fqh);
            parcel.writeString(this.fAM);
            parcel.writeString(this.jyd);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.foE);
            parcel.writeString(this.jye);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.appId = parcel.readString();
            this.jyc = parcel.readInt();
            this.fqg = parcel.readInt();
            this.fqh = parcel.readInt();
            this.fAM = parcel.readString();
            this.jyd = parcel.readString();
            this.errCode = parcel.readInt();
            this.foE = parcel.readString();
            this.jye = parcel.readString();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        x.d("MicroMsg.JsApiGetResPath", "alvinluo getResPath data: %s", jSONObject.toString());
        this.isW = jVar;
        this.jfG = i;
        this.jxX = jSONObject.optInt("resId");
        this.jxY = 48;
        this.jxZ = jSONObject.optInt("subType");
        this.jya = jSONObject.optString("fileId");
        this.jyb = jSONObject.optString("keyInfo");
        x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath resId: %d, resType: %d, subType: %d, fileId: %s", Integer.valueOf(this.jxX), Integer.valueOf(this.jxY), Integer.valueOf(this.jxZ), this.jya);
        if (bi.oN(this.jya) || bi.oN(this.jyb)) {
            x.e("MicroMsg.JsApiGetResPath", "alvinluo getResPath fileId or keyInfo invalid");
            sE(e("fail get failed", null));
            int i2 = f.jzB;
            f.kZ(8027);
            return;
        }
        MainProcessTask getResPathTask = new GetResPathTask(this.isW.mAppId, this);
        getResPathTask.jyc = this.jxX;
        getResPathTask.fqg = this.jxY;
        getResPathTask.fqh = this.jxZ;
        getResPathTask.fAM = this.jya;
        getResPathTask.jyd = this.jyb;
        c.bk(getResPathTask);
        AppBrandMainProcessService.a(getResPathTask);
    }

    final void sE(String str) {
        x.i("MicroMsg.JsApiGetResPath", "alvinluo getResPath callback result: %s", str);
        if (this.isW != null) {
            this.isW.E(this.jfG, str);
        }
    }
}
