package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";
    Timer bnp;
    MMActivity isO = null;
    j isW = null;
    private int jfG = -1;
    private JSONObject jlh;
    boolean jsh = false;
    final Object mLock = new Object();
    long mStartTime = -1;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", jSONObject.toString());
        this.isW = jVar;
        this.jfG = i;
        this.jlh = jSONObject;
        this.jsh = false;
        a(new a() {
            public final void K(int i, String str) {
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    e eVar = d.this;
                    eVar.isO = eVar.a(eVar.isW);
                    if (eVar.isO == null) {
                        eVar.sE(eVar.e("fail: unknown error", null));
                        return;
                    }
                    Intent intent = new Intent();
                    eVar.isO.jCj = new MMActivity.a() {
                        public final void b(int i, int i2, Intent intent) {
                            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mmOnActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
                            if (intent != null) {
                                int intExtra = intent.getIntExtra("errCode", -1);
                                String stringExtra = intent.getStringExtra("errMsg");
                                if (i == 1) {
                                    d dVar = d.this;
                                    x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", Integer.valueOf(intExtra), stringExtra);
                                    Map hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(intExtra));
                                    if (intExtra == 0) {
                                        dVar.onSuccess();
                                        return;
                                    }
                                    c.Q(dVar.isW.mAppId, intExtra, -1);
                                    dVar.sE(dVar.e("fail: " + stringExtra, hashMap));
                                }
                            }
                        }
                    };
                    com.tencent.mm.bl.d.b(eVar.isO, "nfc", "com.tencent.mm.plugin.hce.ui.HCETransparentUI", intent, 1);
                    return;
                }
                c.Q(d.this.isW.mAppId, i, -1);
                d.this.sE(d.this.e("fail: " + str, hashMap));
            }
        });
    }

    final void sE(String str) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", str);
        if (this.isW != null) {
            this.isW.E(this.jfG, str);
        }
    }

    final void onSuccess() {
        Map hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.jlh.getJSONArray("aid_list");
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", this.jlh.toString(), jSONArray.toString(), Integer.valueOf(jSONArray.length()));
            for (int i = 0; i < r4; i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            HCEEventLogic.a.agT();
            Intent intent = new Intent(this.isO, HCEService.class);
            intent.putExtra("key_appid", this.isW.mAppId);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            HCEEventLogic.a(new b() {
                public final void m(String str, int i, String str2) {
                    boolean z;
                    d dVar = d.this;
                    synchronized (dVar.mLock) {
                        z = dVar.jsh;
                        if (!z) {
                            dVar.jsh = true;
                        }
                    }
                    if (z) {
                        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
                        return;
                    }
                    Map hashMap = new HashMap();
                    int currentTimeMillis = (int) (System.currentTimeMillis() - dVar.mStartTime);
                    if (dVar.bnp != null) {
                        x.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
                        dVar.bnp.cancel();
                    }
                    if (str == null || str.equals(dVar.isW.mAppId)) {
                        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", Integer.valueOf(i), str2);
                        if (i == 0) {
                            HCEEventLogic.sZ(dVar.isW.mAppId);
                            hashMap.put("errCode", Integer.valueOf(0));
                            dVar.sE(dVar.e("ok", hashMap));
                        } else {
                            hashMap.put("errCode", Integer.valueOf(i));
                            dVar.sE(dVar.e("fail: " + str2, hashMap));
                        }
                        c.Q(dVar.isW.mAppId, i, currentTimeMillis);
                        HCEEventLogic.a(null);
                        return;
                    }
                    x.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", str);
                    hashMap.put("errCode", Integer.valueOf(13010));
                    c.Q(dVar.isW.mAppId, 13010, currentTimeMillis);
                    dVar.sE(dVar.e("fail: unknown error", hashMap));
                    HCEEventLogic.a(null);
                }
            });
            this.isO.startService(intent);
            this.mStartTime = System.currentTimeMillis();
            TimerTask anonymousClass4 = new TimerTask() {
                public final void run() {
                    boolean z;
                    d dVar = d.this;
                    synchronized (dVar.mLock) {
                        z = dVar.jsh;
                        if (!z) {
                            dVar.jsh = true;
                        }
                    }
                    if (z) {
                        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
                        return;
                    }
                    x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", Integer.valueOf(10));
                    HCEEventLogic.a(null);
                    if (dVar.isW != null) {
                        c.Q(dVar.isW.mAppId, 13007, -2);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(13007));
                    dVar.sE(dVar.e("fail: start HCEService failed", hashMap));
                }
            };
            this.bnp = new Timer();
            this.bnp.schedule(anonymousClass4, 10000);
        } catch (Exception e) {
            hashMap.put("errCode", Integer.valueOf(13003));
            sE(e("fail: aid_list invalid", hashMap));
            c.Q(this.isW.mAppId, 13003, -1);
        }
    }
}
