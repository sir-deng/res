package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.u.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        final p b = e.b(jVar);
        if (b == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, pageView is null");
            jVar.E(i, e("fail:current page do not exist", null));
            return;
        }
        l lw = b.lw(m.jGj);
        if (lw == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, menuInfo is null.");
            jVar.E(i, e("fail:menu is null", null));
            return;
        }
        b bVar = lw.iWz;
        if (bVar.hD("user_clicked_share_btn")) {
            x.i("MicroMsg.JsApiShareAppMessage", "invoke share app message");
            bVar.u("user_clicked_share_btn", false);
            final MMActivity a = a(jVar);
            if (a == null) {
                x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                jVar.E(i, e("fail: page context is null", null));
                return;
            }
            boolean optBoolean;
            final AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
            final boolean z = bVar.getBoolean("enable_share_with_share_ticket", false);
            final int i2 = z ? 3 : 2;
            final String optString = jSONObject.optString("title");
            final String optString2 = jSONObject.optString("desc", "");
            final String optString3 = jSONObject.optString("path");
            final String optString4 = jSONObject.optString("imageUrl");
            final String optString5 = jSONObject.optString("cacheKey");
            if (jVar.iuk.YI()) {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
            } else {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
            }
            final boolean hD = bVar.hD("enable_share_dynamic");
            final String str = jVar.mAppId;
            final String str2 = appBrandSysConfig.foe;
            int i3 = appBrandSysConfig.iRU.iJa;
            int i4 = appBrandSysConfig.iRU.iJb;
            int i5 = 0;
            if (!bi.oN(str)) {
                com.tencent.mm.plugin.appbrand.e pi = com.tencent.mm.plugin.appbrand.a.pi(str);
                AppBrandInitConfig appBrandInitConfig = pi == null ? null : pi.isR;
                if (appBrandInitConfig != null) {
                    i5 = appBrandInitConfig.foo;
                } else {
                    x.i("MicroMsg.JsApiShareAppMessage", "null = initConfig!");
                }
            }
            final String pK = com.tencent.mm.plugin.appbrand.l.pK(jVar.mAppId);
            final boolean te = j.te(optString4);
            final String a2 = j.a(b, optString4, optBoolean);
            Serializable hashMap = new HashMap();
            hashMap.put("desc", optString2);
            hashMap.put(Columns.TYPE, Integer.valueOf(i2));
            hashMap.put("title", optString);
            hashMap.put("app_id", str);
            hashMap.put("pkg_type", Integer.valueOf(i3));
            hashMap.put("pkg_version", Integer.valueOf(i4));
            hashMap.put("img_url", optString4);
            hashMap.put("is_dynamic", Boolean.valueOf(hD));
            hashMap.put("cache_key", optString5);
            hashMap.put("path", optString3);
            if (!bi.oN(a2)) {
                hashMap.put("delay_load_img_path", a2);
            }
            x.i("MicroMsg.JsApiShareAppMessage", "msgParams:%s", hashMap);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", !z);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            final j jVar2 = jVar;
            i4 = i;
            d.a(a, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
                public final void b(int i, final int i2, Intent intent) {
                    int i3 = 16;
                    String str;
                    String str2;
                    if (i != 1) {
                        x.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", Integer.valueOf(i));
                    } else if (i2 != -1) {
                        x.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
                        jVar2.E(i4, c.this.e("cancel", null));
                        str = str;
                        str2 = optString3;
                        if (!z) {
                            i3 = 2;
                        }
                        com.tencent.mm.plugin.appbrand.report.a.a(str, str2, i3, "", bi.Wx(), 3, i2);
                    } else {
                        str2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (str2 == null || str2.length() == 0) {
                            x.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                            jVar2.E(i4, c.this.e("fail:selected user is nil", null));
                            if (!z) {
                                i3 = 2;
                            }
                            com.tencent.mm.plugin.appbrand.report.a.a(str, optString3, i3, "", bi.Wx(), 2, i2);
                            return;
                        }
                        x.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", str2);
                        str = intent.getStringExtra("custom_send_text");
                        final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                        sendAppMessageTask.jum = str;
                        sendAppMessageTask.toUser = str2;
                        sendAppMessageTask.appId = str;
                        sendAppMessageTask.userName = str2;
                        sendAppMessageTask.title = optString;
                        sendAppMessageTask.description = optString2;
                        sendAppMessageTask.url = pK;
                        sendAppMessageTask.path = optString3;
                        sendAppMessageTask.type = i2;
                        sendAppMessageTask.jun = optString4;
                        sendAppMessageTask.iconUrl = appBrandSysConfig.iRs;
                        sendAppMessageTask.fwH = appBrandSysConfig.iRU.iJa;
                        sendAppMessageTask.iSX = appBrandSysConfig.iRU.frM;
                        sendAppMessageTask.version = appBrandSysConfig.iRU.iJb;
                        sendAppMessageTask.fqG = appBrandSysConfig.fsi;
                        sendAppMessageTask.juq = i.pF(str).iue.getAndIncrement();
                        sendAppMessageTask.jus = b.getURL();
                        sendAppMessageTask.jut = b.aeY();
                        AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(str);
                        if (pl != null) {
                            sendAppMessageTask.scene = pl.scene == 0 ? 1000 : pl.scene;
                            sendAppMessageTask.foi = bi.oM(pl.foi);
                            sendAppMessageTask.jur = bi.oM(h.e(jVar2.iuk).iub);
                        }
                        sendAppMessageTask.jup = te;
                        sendAppMessageTask.juo = j.tf(a2);
                        sendAppMessageTask.withShareTicket = z;
                        sendAppMessageTask.juu = hD;
                        sendAppMessageTask.iXq = optString5;
                        sendAppMessageTask.hqv = i5;
                        com.tencent.mm.plugin.appbrand.jsapi.n.a ajG = b.ajG();
                        if (ajG == null) {
                            str = "";
                        } else {
                            str = ajG.jAa.getUrl();
                        }
                        sendAppMessageTask.juv = str;
                        if (z) {
                            sendAppMessageTask.jfW = new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.JsApiShareAppMessage", "task callback");
                                    sendAppMessageTask.afz();
                                    Map hashMap = new HashMap();
                                    JSONArray jSONArray = new JSONArray();
                                    try {
                                        if (!bi.cC(sendAppMessageTask.juw)) {
                                            Iterator it = sendAppMessageTask.juw.iterator();
                                            while (it.hasNext()) {
                                                ShareInfo shareInfo = (ShareInfo) it.next();
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put("shareKey", shareInfo.hlk);
                                                jSONObject.put("shareName", shareInfo.hlj);
                                                jSONArray.put(jSONObject);
                                            }
                                        }
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(e));
                                    }
                                    hashMap.put("shareInfos", jSONArray);
                                    jVar2.E(i4, c.this.e("ok", hashMap));
                                    int i = 16;
                                    String str = str2 + ":";
                                    if (str2.toLowerCase().endsWith("@chatroom")) {
                                        i = 15;
                                    }
                                    com.tencent.mm.plugin.appbrand.report.a.a(str, optString3, i, str, bi.Wx(), 1, i2);
                                }
                            };
                            sendAppMessageTask.afy();
                            AppBrandMainProcessService.a(sendAppMessageTask);
                        } else {
                            AppBrandMainProcessService.a(sendAppMessageTask);
                            jVar2.E(i4, c.this.e("ok", null));
                            if (str2.toLowerCase().endsWith("@chatroom")) {
                                i3 = 9;
                            } else {
                                i3 = 2;
                            }
                            com.tencent.mm.plugin.appbrand.report.a.a(str, optString3, i3, "", bi.Wx(), 1, i2);
                        }
                        if (a != null) {
                            com.tencent.mm.ui.base.h.bu(a, a.getResources().getString(q.j.iAM));
                        }
                    }
                }
            });
            return;
        }
        x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        jVar.E(i, e("fail:not allow to share", null));
    }
}
