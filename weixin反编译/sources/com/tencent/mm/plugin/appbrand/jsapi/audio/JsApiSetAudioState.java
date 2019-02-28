package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ab.d;
import com.tencent.mm.f.a.s;
import com.tencent.mm.f.a.t;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.media.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiSetAudioState extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";
    private AudioPlayerEventListenerTask jhX;

    public static class AudioPlayerEventListenerTask extends MainProcessTask {
        public static final Creator<AudioPlayerEventListenerTask> CREATOR = new Creator<AudioPlayerEventListenerTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AudioPlayerEventListenerTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AudioPlayerEventListenerTask[i];
            }
        };
        public int action;
        public String appId = "";
        private e jfZ;
        public j jga;
        public int jgb;
        private c jiH = new c<t>() {
            {
                this.xmG = t.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                t tVar = (t) bVar;
                if (AudioPlayerEventListenerTask.this.appId.equals(tVar.foD.appId)) {
                    Map hashMap = new HashMap();
                    String str = tVar.foD.state;
                    x.i("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", Integer.valueOf(tVar.foD.action), tVar.foD.foy, str);
                    hashMap.put("state", str);
                    hashMap.put("audioId", r4);
                    AudioPlayerEventListenerTask.this.action = tVar.foD.action;
                    if (AudioPlayerEventListenerTask.this.action == 4) {
                        hashMap.put("errMsg", tVar.foD.foE);
                        hashMap.put("errCode", Integer.valueOf(tVar.foD.errCode));
                    }
                    AudioPlayerEventListenerTask.this.jik = new JSONObject(hashMap).toString();
                    AudioPlayerEventListenerTask.this.afF();
                    return true;
                }
                x.i("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", AudioPlayerEventListenerTask.this.appId, tVar.foD.appId, Integer.valueOf(tVar.foD.action));
                return false;
            }
        };
        public String jik;

        public AudioPlayerEventListenerTask(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public AudioPlayerEventListenerTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.Audio.JsApiSetAudioState", "AudioPlayerEventListenerTask, runInMainProcess");
            com.tencent.mm.plugin.appbrand.media.c.tM(this.appId);
            com.tencent.mm.plugin.appbrand.media.c.tK(this.appId);
            com.tencent.mm.plugin.appbrand.media.c.b(this.appId, this.jiH);
            com.tencent.mm.plugin.appbrand.media.c.aiS();
        }

        public final void YB() {
            if (this.jga == null) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                return;
            }
            x.i("MicroMsg.Audio.JsApiSetAudioState", "AudioPlayerEventListenerTask action:%d, retJson:%s", Integer.valueOf(this.action), this.jik);
            if (bi.oN(this.jik)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
                return;
            }
            f a = new a().a(this.jga);
            a.mData = this.jik;
            a.afI();
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.jik = parcel.readString();
            this.action = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.jik);
            parcel.writeInt(this.action);
        }
    }

    public static final class a extends f {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAudioStateChange";
    }

    private static class SetAudioTask extends MainProcessTask {
        public static final Creator<SetAudioTask> CREATOR = new Creator<SetAudioTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SetAudioTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAudioTask[i];
            }
        };
        public String appId = "";
        public String foy = "";
        public int hmd = 0;
        public boolean hmf = false;
        public boolean hmg = false;
        public double hmi;
        public String hmn = "";
        public String iGz;
        private e jfZ;
        public j jga;
        public int jgb;
        public String jhM;
        public boolean jhO = false;
        public String processName = "";

        public SetAudioTask(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public SetAudioTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.Audio.JsApiSetAudioState", "runInMainProcess");
            this.jhO = false;
            this.jhM = "";
            com.tencent.mm.ab.a iQ = com.tencent.mm.ab.b.iQ(this.foy);
            com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a();
            aVar.foy = this.foy;
            aVar.hmc = this.hmn;
            aVar.hmd = this.hmd;
            aVar.hme = this.hmd;
            aVar.hmf = this.hmf;
            aVar.hmg = this.hmg;
            aVar.processName = this.processName;
            aVar.hmi = this.hmi;
            aVar.appId = this.appId;
            aVar.fromScene = 0;
            b sVar;
            if (iQ != null && this.hmn.equalsIgnoreCase(iQ.hmc) && com.tencent.mm.ab.b.iO(this.foy)) {
                x.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
                x.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", aVar.foy, aVar.hmc);
                sVar = new s();
                sVar.fow.action = 18;
                sVar.fow.foy = aVar.foy;
                sVar.fow.foA = aVar;
                com.tencent.mm.sdk.b.a.xmy.m(sVar);
                if (!sVar.fox.foB) {
                    this.jhO = true;
                    this.jhM = "not to set audio param, the audioId is err";
                    x.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
                }
                afF();
                return;
            }
            x.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", this.appId, this.foy, this.hmn, Integer.valueOf(this.hmd));
            if (this.hmn.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                aVar.filePath = this.hmn.substring(9);
                x.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", aVar.filePath);
            } else if (!(this.hmn.startsWith("http://") || this.hmn.startsWith("https://"))) {
                d bB = com.tencent.mm.plugin.appbrand.media.a.c.bB(this.hmn, this.iGz);
                if (bB.isOpen()) {
                    aVar.filePath = this.hmn;
                    aVar.hmj = bB;
                } else {
                    this.jhO = true;
                    this.jhM = "the file not exist for src";
                    x.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", this.hmn);
                    try {
                        bB.close();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Audio.JsApiSetAudioState", e, "", new Object[0]);
                    }
                    afF();
                    return;
                }
            }
            afF();
            if (!this.jhO) {
                x.i("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s, src:%s, startTime:%d, fromScene:%d", aVar.foy, aVar.hmc, Integer.valueOf(aVar.hmd), Integer.valueOf(aVar.fromScene));
                sVar = new s();
                sVar.fow.action = 0;
                sVar.fow.foy = aVar.foy;
                sVar.fow.foA = aVar;
                com.tencent.mm.sdk.b.a.xmy.m(sVar);
            }
        }

        public final void YB() {
            if (this.jga == null) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
            } else if (this.jhO) {
                this.jga.E(this.jgb, this.jfZ.e("fail:" + this.jhM, null));
            } else {
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
            }
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.foy = parcel.readString();
            this.hmn = parcel.readString();
            this.hmd = parcel.readInt();
            this.hmf = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.hmg = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.jhO = z2;
            this.jhM = parcel.readString();
            this.iGz = parcel.readString();
            this.processName = parcel.readString();
            this.hmi = parcel.readDouble();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeString(this.appId);
            parcel.writeString(this.foy);
            parcel.writeString(this.hmn);
            parcel.writeInt(this.hmd);
            parcel.writeInt(this.hmf ? 1 : 0);
            if (this.hmg) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.jhO) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.jhM);
            parcel.writeString(this.iGz);
            parcel.writeString(this.processName);
            parcel.writeDouble(this.hmi);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (!JsApiCreateAudioInstance.jhK) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            jVar.E(i, e("fail:App is paused or background", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            jVar.E(i, e("fail:data is null", null));
        } else {
            x.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("startTime", 0);
            String optString2 = jSONObject.optString("src");
            if (bi.oN(optString2)) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
                optString2 = "";
            } else if (!optString2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                x.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", optString2);
            } else if (jVar.iuk == null) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime() is null");
                optString2 = "";
            } else if (jVar.iuk.isU == null) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
                optString2 = "";
            } else {
                File ql = jVar.iuk.isU.ql(optString2);
                if (ql == null || !ql.exists()) {
                    x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
                    optString2 = "";
                } else {
                    optString2 = ql.getAbsolutePath();
                    if (!(optString2 == null || optString2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX))) {
                        optString2 = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(optString2).toString();
                    }
                    x.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", optString2);
                }
            }
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
                jVar.E(i, e("fail:audioId is empty", null));
            } else if (TextUtils.isEmpty(optString2)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
                jVar.E(i, e("fail:src is empty", null));
            } else {
                String str;
                if (this.jhX == null) {
                    this.jhX = new AudioPlayerEventListenerTask(this, jVar, i);
                }
                this.jhX.appId = jVar.mAppId;
                AppBrandMainProcessService.a(this.jhX);
                MainProcessTask setAudioTask = new SetAudioTask(this, jVar, i);
                setAudioTask.appId = jVar.mAppId;
                setAudioTask.foy = optString;
                setAudioTask.hmn = optString2;
                setAudioTask.hmd = optInt;
                setAudioTask.hmf = optBoolean;
                setAudioTask.hmg = optBoolean2;
                if (jVar.iuk == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime() is null");
                    str = "";
                } else if (jVar.iuk.isS == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
                    str = "";
                } else if (jVar.iuk.isS.iRU == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
                    str = "";
                } else {
                    x.d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", jVar.iuk.isS.iRU.iGz);
                    str = jVar.iuk.isS.iRU.iGz;
                }
                setAudioTask.iGz = str;
                setAudioTask.hmi = optDouble;
                setAudioTask.processName = ad.By();
                AppBrandMainProcessService.a(setAudioTask);
                h hVar = new h();
                hVar.iGz = setAudioTask.iGz;
                hVar.jhZ = jSONObject.toString();
                hVar.hmn = optString2;
                com.tencent.mm.plugin.appbrand.media.a.a(optString, hVar);
            }
        }
    }
}
