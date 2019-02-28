package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends a {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String jiN = null;
    private StartPlayVoice jiO;

    private static class StartPlayVoice extends MainProcessTask {
        public static final Creator<StartPlayVoice> CREATOR = new Creator<StartPlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartPlayVoice(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartPlayVoice[i];
            }
        };
        public String filePath;
        public String fvn;
        private e jfZ;
        private j jga;
        private int jgb;
        public boolean jhO = false;
        public boolean jiR = false;

        public StartPlayVoice(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public StartPlayVoice(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            ah.y(new Runnable() {
                public final void run() {
                    ((d) g.h(d.class)).a(StartPlayVoice.this.filePath, new com.tencent.mm.ad.g.a() {
                        public final void vi() {
                            StartPlayVoice.this.jhO = false;
                            StartPlayVoice.this.afF();
                            com.tencent.mm.sdk.f.e.post(new Runnable() {
                                public final void run() {
                                    if (StartPlayVoice.this.jiR) {
                                        x.i("MicroMsg.JsApiStartPlayVoice", "alvinluo remove %s after play", StartPlayVoice.this.filePath);
                                        b.deleteFile(StartPlayVoice.this.filePath);
                                    }
                                }
                            }, "PlayEndRelease");
                        }
                    }, new com.tencent.mm.ad.g.b() {
                        public final void onError() {
                            StartPlayVoice.this.jhO = true;
                            StartPlayVoice.this.afF();
                            com.tencent.mm.sdk.f.e.post(/* anonymous class already generated */, "PlayEndRelease");
                        }
                    });
                }
            });
        }

        public final void YB() {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.fvn);
            this.jga.E(this.jgb, this.jfZ.e(this.jhO ? "fail" : "ok", hashMap));
            JsApiStartPlayVoice.jiN = null;
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.fvn = parcel.readString();
            this.filePath = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jhO = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.jiR = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.fvn);
            parcel.writeString(this.filePath);
            if (this.jhO) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.jiR) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String aD = bi.aD(jSONObject.optString(DownloadInfoColumns.FILEPATH, null), jSONObject.optString("localId"));
        x.d("MicroMsg.JsApiStartPlayVoice", "alvinluo playVoice data: %s", jSONObject.toString());
        if (bi.oN(aD)) {
            jVar.E(i, e("fail_missing arguments", null));
            return;
        }
        String str;
        boolean z;
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(jVar.mAppId, aD);
        final p b = e.b(jVar);
        String str2 = "";
        if (com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.tt(aD)) {
            str2 = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.ts(String.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.f(jVar, aD, str2);
            str = str2;
            z = true;
        } else if (itemByLocalId == null || bi.oN(itemByLocalId.hjJ) || b == null) {
            jVar.E(i, e("fail", null));
            return;
        } else {
            str = str2;
            z = false;
        }
        u.b t = u.GQ().t("JsApi@" + b.hashCode(), true);
        p.d dVar = (p.d) t.get("onBackgroundListener", null);
        if (dVar == null) {
            dVar = new p.d() {
                public final void afQ() {
                    JsApiStopPlayVoice.afR();
                    b.b((p.d) this);
                }
            };
            t.o("onBackgroundListener", dVar);
        }
        b.a(dVar);
        if (((p.e) t.get("onDestroyListener", null)) == null) {
            p.e anonymousClass2 = new p.e() {
                public final void onDestroy() {
                    JsApiStopPlayVoice.afR();
                    b.b((p.e) this);
                    u.b hB = u.GQ().hB("JsApi@" + b.hashCode());
                    if (hB != null) {
                        hB.recycle();
                    }
                }
            };
            t.o("onDestroyListener", anonymousClass2);
            b.a(anonymousClass2);
        }
        if (this.jiO == null) {
            this.jiO = new StartPlayVoice(this, jVar, i);
        }
        if (jiN != null) {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.jiO.fvn);
            jVar.E(this.jiO.jgb, e("fail", hashMap));
            return;
        }
        StartPlayVoice startPlayVoice;
        x.d("MicroMsg.JsApiStartPlayVoice", "alvinluo isPkgFile: %b", Boolean.valueOf(z));
        if (z) {
            startPlayVoice = this.jiO;
        } else {
            startPlayVoice = this.jiO;
            str = itemByLocalId != null ? itemByLocalId.hjJ : "";
        }
        startPlayVoice.filePath = str;
        this.jiO.jfZ = this;
        this.jiO.jga = jVar;
        this.jiO.jgb = i;
        this.jiO.fvn = aD;
        this.jiO.jiR = z;
        AppBrandMainProcessService.a(this.jiO);
        jiN = aD;
    }
}
