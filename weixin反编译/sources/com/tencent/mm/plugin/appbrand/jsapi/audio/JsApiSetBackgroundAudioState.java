package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.au.b;
import com.tencent.mm.au.c;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.d;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    public static int jiJ = 0;
    private SetBackgroundAudioListenerTask jia;

    private static class SetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioStateTask> CREATOR = new Creator<SetBackgroundAudioStateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SetBackgroundAudioStateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioStateTask[i];
            }
        };
        public String appId;
        private e jfZ;
        public j jga;
        public int jgb;
        public String jhM = "";
        public boolean jhO = false;
        public String jif;

        public SetBackgroundAudioStateTask(a aVar, j jVar, int i) {
            this.jfZ = aVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public SetBackgroundAudioStateTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
            try {
                JSONObject jSONObject = new JSONObject(this.jif);
                String optString = jSONObject.optString("src");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("epname");
                String optString4 = jSONObject.optString("singer");
                String optString5 = jSONObject.optString("coverImgUrl");
                String optString6 = jSONObject.optString("webUrl");
                String optString7 = jSONObject.optString("protocol");
                int optInt = jSONObject.optInt("startTime", 0);
                String optString8 = jSONObject.optString("operationType");
                if (!TextUtils.isEmpty(optString8)) {
                    x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                    String str = a.jFe.jFc;
                    if (bi.oN(str) || str.equals(this.appId)) {
                        this.jhO = false;
                        if (optString8.equalsIgnoreCase("pause")) {
                            if (c.QC()) {
                                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                                return;
                            } else {
                                this.jhO = true;
                                this.jhM = "pause music fail";
                            }
                        } else if (optString8.equalsIgnoreCase("stop")) {
                            if (c.QD()) {
                                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                                return;
                            } else {
                                this.jhO = true;
                                this.jhM = "stop music fail";
                            }
                        }
                        afF();
                        return;
                    }
                    x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
                } else if (TextUtils.isEmpty(optString)) {
                    x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                    this.jhO = true;
                    this.jhM = "src is null";
                    afF();
                } else {
                    x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d", optString, optString2, optString3, optString4, optString5, optString7, optString6, Integer.valueOf(optInt));
                    if (optString5 == null) {
                        optString5 = "";
                    }
                    String str2 = optString;
                    ati a = ((com.tencent.mm.au.a.a) g.h(com.tencent.mm.au.a.a.class)).a(11, optString5, optString2, optString4, optString6, optString, str2, (this.appId + optString + optString5).hashCode(), com.tencent.mm.compatible.util.e.bnF, com.tencent.mm.plugin.n.c.Fp() + optString5.hashCode(), optString3, "");
                    a.hmd = optInt * 1000;
                    a.protocol = optString7;
                    a.jFe.jFd = a.wdd;
                    b.b(a);
                    x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                    x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                    this.jhO = false;
                    afF();
                }
            } catch (JSONException e) {
                x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
                this.jhO = true;
                this.jhM = "parser data fail, data is invalid";
                x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e.getMessage());
                afF();
            }
        }

        public final void YB() {
            if (this.jga == null) {
                x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
            } else if (this.jhO) {
                x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", this.jhM);
                this.jga.E(this.jgb, this.jfZ.e("fail:" + this.jhM, null));
            } else {
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.appId = parcel.readString();
            this.jif = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jhO = z;
            this.jhM = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.jif);
            parcel.writeInt(this.jhO ? 1 : 0);
            parcel.writeString(this.jhM);
        }
    }

    public static class SetBackgroundAudioListenerTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioListenerTask> CREATOR = new Creator<SetBackgroundAudioListenerTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SetBackgroundAudioListenerTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioListenerTask[i];
            }
        };
        public int action;
        public String appId;
        public String fsi;
        public String fwG;
        public int fwH;
        u.b iWz;
        private e jfZ;
        public j jga;
        public int jgb;
        private boolean jiL = false;
        f jii;
        com.tencent.mm.plugin.appbrand.c.b jij;
        public String jik;
        private final com.tencent.mm.sdk.b.c jil = new com.tencent.mm.sdk.b.c<jt>() {
            {
                this.xmG = jt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jt jtVar = (jt) bVar;
                x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", Integer.valueOf(jtVar.fBu.action));
                Map hashMap = new HashMap();
                String str = jtVar.fBu.state;
                if (jtVar.fBu.action == 10) {
                    if (jtVar.fBu.appId.equals(SetBackgroundAudioListenerTask.this.appId)) {
                        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                        return false;
                    }
                    x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", jtVar.fBu.appId, SetBackgroundAudioListenerTask.this.appId);
                    hashMap.put("state", str);
                    SetBackgroundAudioListenerTask.this.jik = new JSONObject(hashMap).toString();
                    SetBackgroundAudioListenerTask.this.action = jtVar.fBu.action;
                    SetBackgroundAudioListenerTask.this.afF();
                    return true;
                }
                ati ati = jtVar.fBu.fBq;
                if (ati == null) {
                    x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
                    return false;
                } else if (jtVar.fBu.fBw) {
                    int i;
                    if (jtVar.fBu.action == 2 && jtVar.fBu.fBx) {
                        i = 1;
                    } else {
                        boolean i2 = false;
                    }
                    if (i2 != 0) {
                        x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                        return false;
                    }
                    if (SetBackgroundAudioListenerTask.this.appId.equals(a.jFe.jFc)) {
                        hashMap.put("src", ati.wHz);
                        hashMap.put("state", str);
                        hashMap.put("errCode", Integer.valueOf(jtVar.fBu.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(jtVar.fBu.foE)) {
                            obj = jtVar.fBu.foE;
                        }
                        hashMap.put("errMsg", obj);
                        SetBackgroundAudioListenerTask.this.jik = new JSONObject(hashMap).toString();
                        SetBackgroundAudioListenerTask.this.action = jtVar.fBu.action;
                        SetBackgroundAudioListenerTask.this.afF();
                        return true;
                    }
                    x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", SetBackgroundAudioListenerTask.this.appId, a.jFe.jFc);
                    return false;
                } else {
                    x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
                    return false;
                }
            }
        };

        public SetBackgroundAudioListenerTask(a aVar, j jVar, int i) {
            this.jfZ = aVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public SetBackgroundAudioListenerTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
            if (this.jiL) {
                x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
                this.jiL = false;
                com.tencent.mm.sdk.b.b jtVar = new jt();
                jtVar.fBu.action = 10;
                jtVar.fBu.state = "preempted";
                jtVar.fBu.appId = this.appId;
                jtVar.fBu.fBw = true;
                com.tencent.mm.sdk.b.a.xmy.m(jtVar);
            }
            String str = a.jFe.jFc;
            if (!bi.oN(str)) {
                x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", str, this.appId);
                a.jFe.sB(str);
            }
            a.jFe.a(this.jil, this.appId);
            d aiU = a.jFe;
            String str2 = this.appId;
            int i = this.fwH;
            String str3 = this.fsi;
            String str4 = this.fwG;
            aiU.jFc = str2;
            aiU.fwH = i;
            aiU.fsi = str3;
            aiU.fwG = str4;
        }

        public final void YB() {
            if (this.jga == null) {
                x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
                return;
            }
            switch (this.action) {
                case 0:
                case 1:
                    this.iWz.o("setBackgroundAudioState#isPlaying", Boolean.valueOf(true));
                    AppBrandStickyBannerLogic.a.d(this.jii);
                    com.tencent.mm.plugin.appbrand.c.a(this.appId, this.jij);
                    AppBrandMusicClientService.jFa.jFb = this.appId;
                    if (JsApiSetBackgroundAudioState.jiJ > 0) {
                        JsApiSetBackgroundAudioState.jiJ--;
                        this.jga.iuk.YN();
                    }
                    if (JsApiSetBackgroundAudioState.jiJ == 0) {
                        JsApiSetBackgroundAudioState.jiJ++;
                        this.jga.iuk.YM();
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    this.iWz.o("setBackgroundAudioState#isPlaying", Boolean.valueOf(false));
                    AppBrandStickyBannerLogic.a.c(this.jii);
                    com.tencent.mm.plugin.appbrand.c.b(this.appId, this.jij);
                    if (JsApiSetBackgroundAudioState.jiJ > 0) {
                        JsApiSetBackgroundAudioState.jiJ--;
                        this.jga.iuk.YN();
                    }
                    AppBrandMusicClientService.jFa.ll(this.action);
                    break;
                case 10:
                    AppBrandMusicClientService.jFa.ll(this.action);
                    break;
                case 13:
                    JsApiOperateBackgroundAudio.b.c(this.jga);
                    return;
                case 14:
                    JsApiOperateBackgroundAudio.a.c(this.jga);
                    return;
            }
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s, lockCount:%d", Integer.valueOf(this.action), this.jik, Integer.valueOf(JsApiSetBackgroundAudioState.jiJ));
            com.tencent.mm.plugin.appbrand.jsapi.f a = new JsApiOperateBackgroundAudio.c().a(this.jga);
            a.mData = this.jik;
            a.afI();
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.appId = parcel.readString();
            this.jik = parcel.readString();
            this.action = parcel.readInt();
            this.fwH = parcel.readInt();
            this.fsi = parcel.readString();
            this.fwG = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jiL = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.jik);
            parcel.writeInt(this.action);
            parcel.writeInt(this.fwH);
            parcel.writeString(this.fsi);
            parcel.writeString(this.fwG);
            parcel.writeInt(this.jiL ? 1 : 0);
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            return;
        }
        String str = jVar.mAppId;
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", str, jSONObject.toString());
        if (this.jia == null) {
            this.jia = new SetBackgroundAudioListenerTask(this, jVar, i);
        }
        this.jia.jgb = i;
        this.jia.appId = str;
        this.jia.jiL = true;
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        this.jia.fwH = appBrandSysConfig.iRU.iJa;
        this.jia.fsi = appBrandSysConfig.fsi;
        this.jia.fwG = appBrandSysConfig.foe;
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", Integer.valueOf(this.jia.fwH), this.jia.fsi, this.jia.fwG);
        final u.b t = u.GQ().t(u.hC("AppBrandService#" + jVar.hashCode()), true);
        synchronized (t) {
            f fVar;
            f fVar2 = (f) t.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                AnonymousClass1 anonymousClass1 = new f() {
                    public final void al(String str, int i) {
                        String string = t.getString("appId", "");
                        int i2 = t.getInt("pkgType", 0);
                        if ((!string.equals(str) || i2 != i) && t.hD("setBackgroundAudioState#isPlaying") && com.tencent.mm.plugin.appbrand.c.py(string) != com.tencent.mm.plugin.appbrand.c.a.ON_RESUME) {
                            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (JSONException e) {
                            }
                            MainProcessTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, jVar, i);
                            setBackgroundAudioStateTask.jif = jSONObject.toString();
                            setBackgroundAudioStateTask.appId = string;
                            AppBrandMainProcessService.a(setBackgroundAudioStateTask);
                        }
                    }
                };
                t.o("pkgType", Integer.valueOf(appBrandSysConfig.iRU.iJa));
                t.o("StickyBannerChangeListener", anonymousClass1);
                t.o("appId", jVar.mAppId);
                fVar = anonymousClass1;
            } else {
                fVar = fVar2;
            }
            if (((com.tencent.mm.plugin.appbrand.c.b) t.get("AppBrandLifeCycle.Listener", null)) == null) {
                com.tencent.mm.plugin.appbrand.c.b anonymousClass2 = new com.tencent.mm.plugin.appbrand.c.b() {
                    public final void onDestroy() {
                        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", t.getString("appId", ""));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                        }
                        MainProcessTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, jVar, i);
                        setBackgroundAudioStateTask.jif = jSONObject.toString();
                        setBackgroundAudioStateTask.appId = r0;
                        AppBrandMainProcessService.b(setBackgroundAudioStateTask);
                    }
                };
                t.o("AppBrandLifeCycle.Listener", anonymousClass2);
                this.jia.jij = anonymousClass2;
            }
            this.jia.jii = fVar;
            this.jia.iWz = t;
        }
        AppBrandMainProcessService.a(this.jia);
        MainProcessTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this, jVar, i);
        setBackgroundAudioStateTask.jgb = i;
        setBackgroundAudioStateTask.appId = str;
        setBackgroundAudioStateTask.jif = jSONObject.toString();
        AppBrandMainProcessService.a(setBackgroundAudioStateTask);
    }
}
