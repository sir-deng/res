package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    OperateMusicPlayer jig;

    private static final class c extends f {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static class OperateMusicPlayer extends MainProcessTask {
        public static final Creator<OperateMusicPlayer> CREATOR = new Creator<OperateMusicPlayer>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateMusicPlayer(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateMusicPlayer[i];
            }
        };
        public int action;
        public String errorMsg;
        public String fCU;
        public String fGh;
        com.tencent.mm.y.u.b iWz;
        private e jfZ;
        private j jga;
        private int jgb;
        public boolean jhO = false;
        com.tencent.mm.plugin.appbrand.ui.banner.f jii;
        com.tencent.mm.plugin.appbrand.c.b jij;
        public String jik;
        private final com.tencent.mm.sdk.b.c jil = new com.tencent.mm.sdk.b.c<jt>() {
            {
                this.xmG = jt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jt jtVar = (jt) bVar;
                x.i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", Integer.valueOf(jtVar.fBu.action));
                ati ati = jtVar.fBu.fBq;
                if (ati != null) {
                    String str = ati.wHz;
                    Map hashMap = new HashMap();
                    hashMap.put("dataUrl", str);
                    OperateMusicPlayer.this.jik = new JSONObject(hashMap).toString();
                    OperateMusicPlayer.this.action = jtVar.fBu.action;
                    OperateMusicPlayer.this.afF();
                }
                return false;
            }
        };

        public OperateMusicPlayer(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public OperateMusicPlayer(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            try {
                JSONObject jSONObject = new JSONObject(this.fCU);
                String optString = jSONObject.optString("operationType");
                final String optString2 = jSONObject.optString("dataUrl");
                if (bi.oN(optString)) {
                    this.action = -1;
                    this.jhO = true;
                    this.errorMsg = "operationType is null or nil";
                    afF();
                } else if (a.jFe.by(this.fGh, optString)) {
                    if (com.tencent.mm.au.b.Qy() && !com.tencent.mm.au.b.Qx() && optString.equalsIgnoreCase("play")) {
                        ati Qz = com.tencent.mm.au.b.Qz();
                        if (Qz == null || !(bi.oN(optString2) || optString2.equals(Qz.wHz))) {
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                        } else if (a.jFe.by(this.fGh, "resume")) {
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", this.fGh);
                            optString = "resume";
                        } else {
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        }
                    }
                    if (optString.equalsIgnoreCase("play")) {
                        final String optString3 = jSONObject.optString("title");
                        final String optString4 = jSONObject.optString("singer");
                        final String optString5 = jSONObject.optString("epname");
                        final String optString6 = jSONObject.optString("coverImgUrl");
                        if (bi.oN(optString2)) {
                            this.action = -1;
                            this.jhO = true;
                            this.errorMsg = "dataUrl is null or nil";
                            afF();
                            return;
                        }
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", optString3, optString4, optString5, optString6, optString2, optString2, optString2);
                        com.tencent.mm.au.b.Qv();
                        optString = a.jFe.jFc;
                        if (!bi.oN(optString)) {
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", optString, this.fGh);
                            a.jFe.sB(optString);
                        }
                        final String str = optString2;
                        final String str2 = optString2;
                        ah.h(new Runnable() {
                            public final void run() {
                                ati a = ((com.tencent.mm.au.a.a) g.h(com.tencent.mm.au.a.a.class)).a(optString6, optString6, optString3, optString4, str, str2, optString2, (OperateMusicPlayer.this.fGh + optString2 + optString6).hashCode(), com.tencent.mm.compatible.util.e.bnF, com.tencent.mm.plugin.n.c.Fp() + optString6.hashCode(), optString5, "");
                                a.wHM = true;
                                com.tencent.mm.au.b.b(a);
                                a.jFe.a(OperateMusicPlayer.this.jil, OperateMusicPlayer.this.fGh);
                                a.jFe.jFc = OperateMusicPlayer.this.fGh;
                                a.jFe.jFd = a.wdd;
                                x.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.this.jhO = false;
                                OperateMusicPlayer.this.afF();
                            }
                        }, 500);
                    } else if (optString.equalsIgnoreCase("resume")) {
                        optString = a.jFe.jFc;
                        if (!bi.oN(optString)) {
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", optString, this.fGh);
                            a.jFe.sB(optString);
                        }
                        a.jFe.a(this.jil, this.fGh);
                        a.jFe.jFc = this.fGh;
                        ati Qz2 = com.tencent.mm.au.b.Qz();
                        if (Qz2 != null) {
                            a.jFe.jFd = Qz2.wdd;
                        }
                        if (com.tencent.mm.au.c.QB()) {
                            ah.h(new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.this.jhO = false;
                                    OperateMusicPlayer.this.afF();
                                }
                            }, 500);
                            return;
                        }
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                        this.action = -1;
                        this.jhO = true;
                        this.errorMsg = "resume play fail";
                        afF();
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.au.c.QC()) {
                            ah.h(new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.jhO = false;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.this.afF();
                                }
                            }, 500);
                            return;
                        }
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                        this.action = -1;
                        this.jhO = true;
                        this.errorMsg = "pause play fail";
                        afF();
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (com.tencent.mm.au.b.ii(bi.getInt(bi.bZ(jSONObject.optString("position")), -1) * 1000)) {
                            ah.h(new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.jhO = false;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.this.afF();
                                }
                            }, 500);
                            return;
                        }
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                        this.action = -1;
                        this.jhO = true;
                        this.errorMsg = "seek fail";
                        afF();
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        this.action = -1;
                        this.jhO = true;
                        afF();
                    } else if (com.tencent.mm.au.c.QD()) {
                        ah.h(new Runnable() {
                            public final void run() {
                                x.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.jhO = false;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.this.afF();
                            }
                        }, 500);
                    } else {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                        this.action = -1;
                        this.jhO = false;
                        this.errorMsg = "stop play fail";
                        afF();
                    }
                } else {
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.action = -1;
                    this.jhO = true;
                    this.errorMsg = "appid not match cannot operate";
                    afF();
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
                this.action = -1;
                this.jhO = true;
                this.errorMsg = "data is null";
                afF();
            }
        }

        public final void YB() {
            String str;
            x.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", Integer.valueOf(this.action));
            j jVar = this.jga;
            int i = this.jgb;
            e eVar = this.jfZ;
            if (this.jhO) {
                str = "fail" + (TextUtils.isEmpty(this.errorMsg) ? "" : ":" + this.errorMsg);
            } else {
                str = "ok";
            }
            jVar.E(i, eVar.e(str, null));
            f a;
            switch (this.action) {
                case 0:
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                    a = new c().a(this.jga);
                    a.mData = this.jik;
                    a.afI();
                    this.iWz.o("Music#isPlaying", Boolean.valueOf(true));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.d(this.jii);
                    com.tencent.mm.plugin.appbrand.c.a(this.jga.mAppId, this.jij);
                    return;
                case 1:
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                    this.iWz.o("Music#isPlaying", Boolean.valueOf(true));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.d(this.jii);
                    com.tencent.mm.plugin.appbrand.c.a(this.jga.mAppId, this.jij);
                    return;
                case 2:
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                    a = new a().a(this.jga);
                    a.mData = this.jik;
                    a.afI();
                    break;
                case 3:
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                    a = new b().a(this.jga);
                    a.mData = this.jik;
                    a.afI();
                    this.iWz.o("Music#isPlaying", Boolean.valueOf(false));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.c(this.jii);
                    com.tencent.mm.plugin.appbrand.c.b(this.jga.mAppId, this.jij);
                    return;
                case 4:
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                    this.jga.j("onMusicError", this.jik, 0);
                    this.iWz.o("Music#isPlaying", Boolean.valueOf(false));
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.c(this.jii);
                    com.tencent.mm.plugin.appbrand.c.b(this.jga.mAppId, this.jij);
                    return;
                case 7:
                    break;
                default:
                    return;
            }
            x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
            this.iWz.o("Music#isPlaying", Boolean.valueOf(false));
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.c(this.jii);
            com.tencent.mm.plugin.appbrand.c.b(this.jga.mAppId, this.jij);
        }

        public final void f(Parcel parcel) {
            this.fCU = parcel.readString();
            this.fGh = parcel.readString();
            this.jhO = parcel.readByte() != (byte) 0;
            this.jik = parcel.readString();
            this.action = parcel.readInt();
            this.errorMsg = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.fCU);
            parcel.writeString(this.fGh);
            parcel.writeByte(this.jhO ? (byte) 1 : (byte) 0);
            parcel.writeString(this.jik);
            parcel.writeInt(this.action);
            parcel.writeString(this.errorMsg);
        }
    }

    private static final class a extends f {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b extends f {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        this.jig = new OperateMusicPlayer(this, jVar, i);
        final com.tencent.mm.y.u.b t = u.GQ().t(u.hC("AppBrandService#" + jVar.hashCode()), true);
        synchronized (t) {
            com.tencent.mm.plugin.appbrand.ui.banner.f fVar;
            com.tencent.mm.plugin.appbrand.ui.banner.f fVar2 = (com.tencent.mm.plugin.appbrand.ui.banner.f) t.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.ui.banner.f() {
                    public final void al(String str, int i) {
                        String string = t.getString("appId", "");
                        int i2 = t.getInt("pkgType", 0);
                        if ((!string.equals(str) || i2 != i) && t.hD("Music#isPlaying") && com.tencent.mm.plugin.appbrand.c.py(string) != com.tencent.mm.plugin.appbrand.c.a.ON_RESUME) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (JSONException e) {
                            }
                            MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, jVar, JsApiOperateMusicPlayer.this.jig.jgb);
                            operateMusicPlayer.fCU = jSONObject.toString();
                            operateMusicPlayer.fGh = string;
                            operateMusicPlayer.iWz = t;
                            AppBrandMainProcessService.a(operateMusicPlayer);
                        }
                    }
                };
                AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
                if (appBrandSysConfig != null) {
                    t.o("pkgType", Integer.valueOf(appBrandSysConfig.iRU.iJa));
                }
                t.o("StickyBannerChangeListener", anonymousClass1);
                t.o("appId", jVar.mAppId);
                fVar = anonymousClass1;
            } else {
                fVar = fVar2;
            }
            if (((com.tencent.mm.plugin.appbrand.c.b) t.get("AppBrandLifeCycle.Listener", null)) == null) {
                com.tencent.mm.plugin.appbrand.c.b anonymousClass2 = new com.tencent.mm.plugin.appbrand.c.b() {
                    public final void a(com.tencent.mm.plugin.appbrand.c.c cVar) {
                        String string = t.getString("appId", "");
                        int i = t.getInt("pkgType", 0);
                        switch (cVar) {
                            case BACK:
                            case CLOSE:
                                int i2 = com.tencent.mm.plugin.appbrand.a.pl(string).scene;
                                if (!com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.aO(string, i) && i2 != 1023) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e) {
                                    }
                                    MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, jVar, JsApiOperateMusicPlayer.this.jig.jgb);
                                    operateMusicPlayer.fCU = jSONObject.toString();
                                    operateMusicPlayer.fGh = string;
                                    operateMusicPlayer.iWz = t;
                                    AppBrandMainProcessService.a(operateMusicPlayer);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }

                    public final void onDestroy() {
                        x.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
                        String string = t.getString("appId", "");
                        t.getInt("pkgType", 0);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                        }
                        MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, jVar, JsApiOperateMusicPlayer.this.jig.jgb);
                        operateMusicPlayer.fCU = jSONObject.toString();
                        operateMusicPlayer.fGh = string;
                        operateMusicPlayer.action = -1;
                        operateMusicPlayer.iWz = t;
                        AppBrandMainProcessService.b(operateMusicPlayer);
                    }
                };
                t.o("AppBrandLifeCycle.Listener", anonymousClass2);
                this.jig.jij = anonymousClass2;
            }
            this.jig.jii = fVar;
            this.jig.iWz = t;
        }
        this.jig.fCU = jSONObject.toString();
        this.jig.fGh = jVar.mAppId;
        AppBrandMainProcessService.a(this.jig);
    }
}
