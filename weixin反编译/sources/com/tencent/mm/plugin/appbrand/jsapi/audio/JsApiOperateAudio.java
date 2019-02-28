package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.f.a.s;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState.AudioPlayerEventListenerTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiOperateAudio extends a {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";
    private AudioPlayerEventListenerTask jhX;

    private static final class OperateAudioTask extends MainProcessTask {
        public static final Creator<OperateAudioTask> CREATOR = new Creator<OperateAudioTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateAudioTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateAudioTask[i];
            }
        };
        public String appId = "";
        public String foy = "";
        public int foz = 0;
        public String hmn = "";
        public String iGz;
        private e jfZ;
        public j jga;
        public int jgb;
        public String jhM;
        public boolean jhO = false;
        public String jhY = "";
        public String jhZ;
        public String processName = "";

        public OperateAudioTask(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public OperateAudioTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            boolean z = false;
            x.i("MicroMsg.Audio.JsApiOperateAudio", "runInMainProcess");
            x.i("MicroMsg.Audio.JsApiOperateAudio", "operationType;%s, currentTime:%d", this.jhY, Integer.valueOf(this.foz));
            this.jhO = false;
            String str = this.jhY;
            boolean iN;
            if (str.equalsIgnoreCase("play")) {
                com.tencent.mm.ab.a iQ = b.iQ(this.foy);
                if (iQ == null) {
                    x.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                    iQ = com.tencent.mm.plugin.appbrand.media.e.b(this.appId, this.foy, this.hmn, this.jhZ, this.iGz, this.processName);
                }
                String str2 = this.foy;
                if (!b.iP(str2)) {
                    z = b.a(str2, iQ);
                } else if (b.iP(str2) && !b.iO(str2)) {
                    z = b.a(str2, iQ);
                }
                if (z) {
                    x.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
                } else if (b.iO(this.foy)) {
                    this.jhO = true;
                    this.jhM = "audio is playing, don't play again";
                } else {
                    this.jhO = true;
                    this.jhM = "play audio fail";
                }
            } else if (str.equalsIgnoreCase("pause")) {
                str = this.foy;
                if (b.iO(str)) {
                    iN = b.iN(str);
                } else {
                    b.iN(str);
                    iN = false;
                }
                if (iN) {
                    x.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
                } else {
                    this.jhO = true;
                    this.jhM = "pause audio fail";
                }
            } else if (str.equalsIgnoreCase("seek")) {
                if (this.foz < 0) {
                    x.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", Integer.valueOf(this.foz));
                    this.jhO = true;
                    this.jhM = "currentTime is invalid";
                } else {
                    x.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", this.foy, Integer.valueOf(this.foz));
                    com.tencent.mm.sdk.b.b sVar = new s();
                    sVar.fow.action = 4;
                    sVar.fow.foy = str;
                    sVar.fow.foz = r1;
                    com.tencent.mm.sdk.b.a.xmy.m(sVar);
                    if (sVar.fox.foB) {
                        x.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                    } else {
                        this.jhO = true;
                        this.jhM = "seek audio fail";
                    }
                }
            } else if (str.equalsIgnoreCase("stop")) {
                str = this.foy;
                com.tencent.mm.sdk.b.b sVar2 = new s();
                sVar2.fow.action = 13;
                sVar2.fow.foy = str;
                com.tencent.mm.sdk.b.a.xmy.m(sVar2);
                if (sVar2.fox.foB) {
                    x.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", str);
                    sVar2 = new s();
                    sVar2.fow.action = 14;
                    sVar2.fow.foy = str;
                    com.tencent.mm.sdk.b.a.xmy.m(sVar2);
                    iN = sVar2.fox.foB;
                } else {
                    sVar2 = new s();
                    sVar2.fow.action = 17;
                    sVar2.fow.foy = str;
                    com.tencent.mm.sdk.b.a.xmy.m(sVar2);
                    if (sVar2.fox.foB) {
                        iN = true;
                    } else {
                        x.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", str);
                        sVar2 = new s();
                        sVar2.fow.action = 3;
                        sVar2.fow.foy = str;
                        com.tencent.mm.sdk.b.a.xmy.m(sVar2);
                        iN = sVar2.fox.foB;
                    }
                }
                if (iN) {
                    x.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
                } else {
                    this.jhO = true;
                    this.jhM = "stop audio fail";
                }
            } else {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
                this.jhO = true;
                this.jhM = "operationType is invalid";
            }
            if (this.jhO) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", this.jhM);
            }
            afF();
        }

        public final void YB() {
            if (this.jga == null) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
            } else if (this.jhO) {
                this.jga.E(this.jgb, this.jfZ.e("fail:" + this.jhM, null));
            } else {
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.appId = parcel.readString();
            this.foy = parcel.readString();
            this.jhY = parcel.readString();
            this.foz = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jhO = z;
            this.jhM = parcel.readString();
            this.jhZ = parcel.readString();
            this.iGz = parcel.readString();
            this.processName = parcel.readString();
            this.hmn = parcel.readString();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.foy);
            parcel.writeString(this.jhY);
            parcel.writeInt(this.foz);
            parcel.writeInt(this.jhO ? 1 : 0);
            parcel.writeString(this.jhM);
            parcel.writeString(this.jhZ);
            parcel.writeString(this.iGz);
            parcel.writeString(this.processName);
            parcel.writeString(this.hmn);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (!JsApiCreateAudioInstance.jhK) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            jVar.E(i, e("fail:App is paused or background", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            jVar.E(i, e("fail:data is null", null));
        } else {
            x.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", jVar.mAppId, jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("currentTime", 0);
            Object optString2 = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
                jVar.E(i, e("fail:audioId is empty", null));
            } else if (TextUtils.isEmpty(optString2)) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
                jVar.E(i, e("fail:operationType is empty", null));
            } else {
                if (this.jhX == null) {
                    this.jhX = new AudioPlayerEventListenerTask(this, jVar, i);
                }
                this.jhX.appId = jVar.mAppId;
                AppBrandMainProcessService.a(this.jhX);
                MainProcessTask operateAudioTask = new OperateAudioTask(this, jVar, i);
                operateAudioTask.appId = jVar.mAppId;
                operateAudioTask.foy = optString;
                operateAudioTask.foz = optInt;
                operateAudioTask.jhY = optString2;
                h tJ = com.tencent.mm.plugin.appbrand.media.a.tJ(optString);
                if (tJ != null) {
                    operateAudioTask.jhZ = tJ.jhZ;
                    operateAudioTask.iGz = tJ.iGz;
                    operateAudioTask.hmn = tJ.hmn;
                }
                operateAudioTask.processName = ad.By();
                AppBrandMainProcessService.a(operateAudioTask);
            }
        }
    }
}
