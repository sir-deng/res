package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.ags;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";
    public static int jiJ = 0;
    private p jjI;
    private String jmc;
    private String jmd;
    private String jme;
    private String jmf;
    private boolean jmg;
    private int jmh = 1;
    private String sessionFrom;

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            pVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiEnterContact", "data is null");
            return;
        }
        x.i("MicroMsg.JsApiEnterContact", "enterContact appId:%s, data:%s", pVar.mAppId, jSONObject.toString());
        this.jjI = pVar;
        this.sessionFrom = jSONObject.optString("sessionFrom");
        this.jmc = jSONObject.optString("businessId");
        this.jmd = jSONObject.optString("sendMessageTitle");
        this.jme = jSONObject.optString("sendMessagePath");
        this.jmf = jSONObject.optString("sendMessageImg");
        this.jmg = jSONObject.optBoolean("showMessageCard", false);
        this.jmh = 1;
        if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            x.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        if (this.jmg) {
            if (s.eL(this.jmf, "http://") || s.eL(this.jmf, "https://")) {
                this.jmh = 4;
            } else if (!bi.oN(this.jmf) && this.jmf.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, this.jmf);
                if (!(itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hjJ))) {
                    this.jmf = itemByLocalId.hjJ;
                    this.jmh = 2;
                }
            } else if (!bi.oN(this.jmf)) {
                Bitmap j = o.j(pVar.iuk, this.jmf);
                if (j != null) {
                    this.jmf = AppBrandLocalMediaObjectManager.genMediaFilePath(pVar.mAppId, "share_" + System.currentTimeMillis());
                    try {
                        d.a(j, 100, CompressFormat.PNG, this.jmf, true);
                        this.jmh = 3;
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    } catch (IOException e) {
                        x.w("MicroMsg.JsApiEnterContact", "save temp bitmap to file failed, . exception : %s", e);
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    } catch (Exception e2) {
                        x.w("MicroMsg.JsApiEnterContact", "save temp bitmap to file failed, . exception : %s", e2);
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    } catch (Throwable th) {
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    }
                }
            }
            if (this.jmg && this.jmh == 1) {
                this.jmf = AppBrandLocalMediaObjectManager.genMediaFilePath(pVar.mAppId, "share_" + System.currentTimeMillis());
                com.tencent.mm.plugin.appbrand.c.a(pVar.mAppId, new b() {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void a(com.tencent.mm.plugin.appbrand.c.c r7) {
                        /*
                        r6 = this;
                        r0 = r9;
                        r0 = r0.mAppId;
                        com.tencent.mm.plugin.appbrand.c.b(r0, r6);
                        r0 = r9;
                        r1 = com.tencent.mm.plugin.appbrand.jsapi.share.j.b(r0);
                        if (r1 == 0) goto L_0x001d;
                    L_0x000f:
                        r0 = 100;
                        r2 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x0029, Exception -> 0x0045 }
                        r3 = com.tencent.mm.plugin.appbrand.jsapi.contact.c.this;	 Catch:{ IOException -> 0x0029, Exception -> 0x0045 }
                        r3 = r3.jmf;	 Catch:{ IOException -> 0x0029, Exception -> 0x0045 }
                        r4 = 1;
                        com.tencent.mm.sdk.platformtools.d.a(r1, r0, r2, r3, r4);	 Catch:{ IOException -> 0x0029, Exception -> 0x0045 }
                    L_0x001d:
                        if (r1 == 0) goto L_0x0028;
                    L_0x001f:
                        r0 = r1.isRecycled();
                        if (r0 != 0) goto L_0x0028;
                    L_0x0025:
                        r1.recycle();
                    L_0x0028:
                        return;
                    L_0x0029:
                        r0 = move-exception;
                        r2 = "MicroMsg.JsApiEnterContact";
                        r3 = "save temp bitmap to file failed, . exception : %s";
                        r4 = 1;
                        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0061 }
                        r5 = 0;
                        r4[r5] = r0;	 Catch:{ all -> 0x0061 }
                        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x0061 }
                        if (r1 == 0) goto L_0x0028;
                    L_0x003b:
                        r0 = r1.isRecycled();
                        if (r0 != 0) goto L_0x0028;
                    L_0x0041:
                        r1.recycle();
                        goto L_0x0028;
                    L_0x0045:
                        r0 = move-exception;
                        r2 = "MicroMsg.JsApiEnterContact";
                        r3 = "save temp bitmap to file failed, . exception : %s";
                        r4 = 1;
                        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0061 }
                        r5 = 0;
                        r4[r5] = r0;	 Catch:{ all -> 0x0061 }
                        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x0061 }
                        if (r1 == 0) goto L_0x0028;
                    L_0x0057:
                        r0 = r1.isRecycled();
                        if (r0 != 0) goto L_0x0028;
                    L_0x005d:
                        r1.recycle();
                        goto L_0x0028;
                    L_0x0061:
                        r0 = move-exception;
                        if (r1 == 0) goto L_0x006d;
                    L_0x0064:
                        r2 = r1.isRecycled();
                        if (r2 != 0) goto L_0x006d;
                    L_0x006a:
                        r1.recycle();
                    L_0x006d:
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.contact.c.1.a(com.tencent.mm.plugin.appbrand.c$c):void");
                    }
                });
            }
        }
        if (TextUtils.isEmpty(this.jmc)) {
            x.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            aB("", i);
            return;
        }
        x.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ags();
        aVar.hnU = new agt();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        aVar.hnS = 1303;
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        ags ags = (ags) Kf.hnQ.hnY;
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        if (appBrandSysConfig != null) {
            ags.username = appBrandSysConfig.foe;
            x.i("MicroMsg.JsApiEnterContact", "req.username:%s", ags.username);
        } else {
            x.e("MicroMsg.JsApiEnterContact", "getSysConfig is null, username is empty");
        }
        ags.wuP = this.jmc;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    final agt agt = (agt) bVar.hnR.hnY;
                    x.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", agt.wuQ);
                    pVar.getContentView().post(new Runnable() {
                        public final void run() {
                            c.this.aB(agt.wuQ, i);
                        }
                    });
                    return;
                }
                x.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                pVar.E(i, c.this.e("fail:cgi fail", null));
            }
        });
    }

    private void aB(String str, final int i) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        final WxaExposedParams.a aVar = new WxaExposedParams.a();
        if (this.jjI.jJw != null) {
            str4 = this.jjI.jJw.jKx;
        }
        AppBrandSysConfig appBrandSysConfig = this.jjI.iuk.isS;
        if (appBrandSysConfig != null) {
            str2 = appBrandSysConfig.foe;
            str3 = appBrandSysConfig.fsi;
            aVar.appId = this.jjI.mAppId;
            aVar.username = appBrandSysConfig.foe;
            aVar.fqG = appBrandSysConfig.fsi;
            aVar.iconUrl = appBrandSysConfig.iRs;
            aVar.iJa = appBrandSysConfig.iRU.iJa;
            aVar.iJb = appBrandSysConfig.iRU.iJb;
            aVar.iSX = appBrandSysConfig.iRU.frM;
            aVar.fqZ = 5;
            aVar.fDk = str4;
            aVar.iSY = l.pK(this.jjI.mAppId);
        }
        str4 = str3;
        str3 = str2;
        if (bi.oN(str3)) {
            x.e("MicroMsg.JsApiEnterContact", "onInsertView username is empty!!!");
        }
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        if (TextUtils.isEmpty(str)) {
            jsApiChattingTask.username = str3;
            jsApiChattingTask.fqG = str4;
        } else {
            jsApiChattingTask.username = str;
            jsApiChattingTask.fqG = "";
        }
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        jsApiChattingTask.jfW = new Runnable() {
            public final void run() {
                x.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_expose_params", aVar.acv());
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                if (c.this.jmg) {
                    intent.putExtra("sendMessageTitle", c.this.jmd);
                    intent.putExtra("sendMessagePath", c.this.jme);
                    intent.putExtra("sendMessageImg", c.this.jmf);
                    intent.putExtra("isBitmapFrom", c.this.jmh);
                }
                intent.putExtra("showMessageCard", c.this.jmg);
                MMActivity mMActivity = (MMActivity) c.this.jjI.mContext;
                if (mMActivity == null) {
                    c.this.jjI.E(i, c.this.e("fail", null));
                    x.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
                    return;
                }
                mMActivity.jCj = new MMActivity.a() {
                    public final void b(int i, int i2, Intent intent) {
                        if (i == 1) {
                            if (c.jiJ > 0) {
                                c.jiJ--;
                                c.this.jjI.iuk.YN();
                            }
                            x.i("MicroMsg.JsApiEnterContact", "mmOnActivityResult lockCount:%d", Integer.valueOf(c.jiJ));
                            jsApiChattingTask.afz();
                            Map hashMap = new HashMap();
                            Object obj = "";
                            Object hashMap2 = new HashMap();
                            if (i2 == -1 && intent != null) {
                                String aD = bi.aD(intent.getStringExtra("keyOutPagePath"), "");
                                obj = com.tencent.mm.plugin.appbrand.q.l.vh(aD);
                                hashMap2 = com.tencent.mm.plugin.appbrand.q.l.vi(aD);
                            }
                            hashMap.put("path", obj);
                            hashMap.put("query", hashMap2);
                            x.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", obj, hashMap2.toString());
                            c.this.jjI.E(i, c.this.e("ok", hashMap));
                        }
                    }
                };
                com.tencent.mm.bl.d.a(c.this.jjI.mContext, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                if (c.jiJ > 0) {
                    c.jiJ--;
                    c.this.jjI.iuk.YN();
                }
                if (c.jiJ == 0) {
                    c.jiJ++;
                    c.this.jjI.iuk.YM();
                }
                com.tencent.mm.plugin.appbrand.c.a(c.this.jjI.mAppId, new b() {
                    public final void onDestroy() {
                        x.i("MicroMsg.JsApiEnterContact", "onDestroy");
                        if (c.jiJ > 0) {
                            c.jiJ--;
                            c.this.jjI.iuk.YN();
                        }
                        jsApiChattingTask.afz();
                        com.tencent.mm.plugin.appbrand.c.b(c.this.jjI.mAppId, this);
                    }
                });
                x.i("MicroMsg.JsApiEnterContact", "doEnterChatting lockCount:%d", Integer.valueOf(c.jiJ));
            }
        };
        jsApiChattingTask.afy();
        AppBrandMainProcessService.a(jsApiChattingTask);
    }
}
