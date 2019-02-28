package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.f.a.s;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiDestroyInstanceAudio extends a {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    private static class DestroyAudioTask extends MainProcessTask {
        public static final Creator<DestroyAudioTask> CREATOR = new Creator<DestroyAudioTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DestroyAudioTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DestroyAudioTask[i];
            }
        };
        public String appId = "";
        public String foy = "";
        private e jfZ;
        public j jga;
        public int jgb;
        public boolean jhO = false;

        public DestroyAudioTask(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public DestroyAudioTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runInMainProcess");
            x.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", this.foy);
            b sVar = new s();
            sVar.fow.action = 5;
            sVar.fow.foy = r0;
            com.tencent.mm.sdk.b.a.xmy.m(sVar);
            this.jhO = sVar.fox.foB;
            afF();
        }

        public final void YB() {
            x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runInClientProcess");
            if (this.jga == null) {
                x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
            } else if (this.jhO) {
                this.jga.E(this.jgb, this.jfZ.e("fail", null));
            } else {
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
            }
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.foy = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.foy);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", jSONObject.toString());
        Object optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            jVar.E(i, e("fail:audioId is empty", null));
            return;
        }
        MainProcessTask destroyAudioTask = new DestroyAudioTask(this, jVar, i);
        destroyAudioTask.appId = jVar.mAppId;
        destroyAudioTask.foy = optString;
        AppBrandMainProcessService.a(destroyAudioTask);
    }
}
