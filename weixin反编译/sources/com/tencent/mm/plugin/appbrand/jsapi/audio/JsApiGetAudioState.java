package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ab.c;
import com.tencent.mm.f.a.s;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetAudioState extends a {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    private static class GetAudioStateTask extends MainProcessTask {
        public static final Creator<GetAudioStateTask> CREATOR = new Creator<GetAudioStateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetAudioStateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetAudioStateTask[i];
            }
        };
        public String appId = "";
        public int duration = 0;
        public String foy = "";
        public int foz;
        public int hSr;
        public int hmd;
        public int hmm;
        public String hmn;
        private e jfZ;
        public j jga;
        public int jgb;
        public String jhM;
        public boolean jhO = false;

        public GetAudioStateTask(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public GetAudioStateTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            String str = this.foy;
            b sVar = new s();
            sVar.fow.action = 6;
            sVar.fow.foy = str;
            com.tencent.mm.sdk.b.a.xmy.m(sVar);
            c cVar = sVar.fox.foC;
            if (cVar == null) {
                x.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null");
                this.jhO = true;
                this.jhM = "return parameter is invalid";
                afF();
            } else if (cVar.duration < 0 || cVar.foz < 0) {
                x.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", Integer.valueOf(cVar.duration), Integer.valueOf(cVar.foz));
                this.jhO = true;
                this.jhM = "return parameter is invalid";
                afF();
            } else {
                this.duration = cVar.duration;
                this.foz = cVar.foz;
                this.hSr = cVar.hmk ? 1 : 0;
                this.hmn = cVar.hmn;
                this.hmm = cVar.hmm;
                this.hmd = cVar.hmd;
                x.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", Integer.valueOf(this.duration), Integer.valueOf(this.foz), Integer.valueOf(this.hSr), Integer.valueOf(this.hmm), this.hmn, Integer.valueOf(this.hmd));
                afF();
            }
        }

        public final void YB() {
            if (this.jga == null) {
                x.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
            hashMap.put("currentTime", Integer.valueOf(this.foz));
            hashMap.put("paused", Boolean.valueOf(this.hSr == 1));
            hashMap.put("buffered", Integer.valueOf(this.hmm));
            hashMap.put("src", this.hmn);
            hashMap.put("startTime", Integer.valueOf(this.hmd));
            String str = TextUtils.isEmpty(this.jhM) ? "" : this.jhM;
            if (this.jhO) {
                x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", str);
                this.jga.E(this.jgb, this.jfZ.e("fail:" + str, null));
                return;
            }
            this.jga.E(this.jgb, this.jfZ.e("ok", hashMap));
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.foy = parcel.readString();
            this.duration = parcel.readInt();
            this.foz = parcel.readInt();
            this.hSr = parcel.readInt();
            this.hmm = parcel.readInt();
            this.hmn = parcel.readString();
            this.hmd = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.foy);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.foz);
            parcel.writeInt(this.hSr);
            parcel.writeInt(this.hmm);
            parcel.writeString(this.hmn);
            parcel.writeInt(this.hmd);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        Object optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            jVar.E(i, e("fail:audioId is empty", null));
            return;
        }
        MainProcessTask getAudioStateTask = new GetAudioStateTask(this, jVar, i);
        getAudioStateTask.appId = jVar.mAppId;
        getAudioStateTask.foy = optString;
        AppBrandMainProcessService.a(getAudioStateTask);
    }
}
