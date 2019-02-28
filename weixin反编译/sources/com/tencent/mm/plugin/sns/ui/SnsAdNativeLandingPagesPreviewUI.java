package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("SnsAdNativeLandingPagesPreviewUI", "setFullScreen");
        getWindow().getAttributes();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getWindow().getDecorView().setSystemUiVisibility(5126);
        final Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Object stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        final int i = intent.hasExtra("sns_landing_pages_canvasid") ? 1 : 0;
        final long longExtra = intent.getLongExtra("sns_landing_pages_pageid", 0);
        final String stringExtra2 = intent.getStringExtra("sns_landing_pages_canvasid");
        final String stringExtra3 = intent.getStringExtra("sns_landing_pages_canvas_ext");
        if (TextUtils.isEmpty(stringExtra)) {
            if (intent.getIntExtra("sns_landing_pages_no_store", 0) != 1) {
                if (i == 1) {
                    stringExtra = i.byA().m(stringExtra2, stringExtra3, 0, 0);
                } else {
                    stringExtra = i.byA().h(longExtra, 0, 0);
                }
                intent.putExtra("sns_landing_pages_xml", stringExtra);
            }
        } else if (!f(intent, stringExtra)) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            b bVar;
            final View findViewById = findViewById(f.cEk);
            findViewById.setVisibility(0);
            b.a aVar = new b.a();
            b Kf;
            if (i == 0 && longExtra > 0) {
                x.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", Long.valueOf(longExtra));
                aVar.hnT = new xx();
                aVar.hnU = new xy();
                aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
                aVar.hnS = 1286;
                Kf = aVar.Kf();
                ((xx) Kf.hnQ.hnY).wpl = longExtra;
                bVar = Kf;
            } else if (i != 1 || bi.oN(stringExtra2)) {
                x.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
                finish();
                return;
            } else {
                x.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", stringExtra2);
                aVar.hnT = new aec();
                aVar.hnU = new aed();
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
                aVar.hnS = 1890;
                Kf = aVar.Kf();
                aec aec = (aec) Kf.hnQ.hnY;
                aec.wtp = stringExtra2;
                aec.wtq = stringExtra3;
                bVar = Kf;
            }
            u.a(bVar, new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    findViewById.setVisibility(8);
                    if (i == 0 && i2 == 0) {
                        if (i == 1) {
                            Object cec = ((aed) bVar.hnR.hnY).wtr.cec();
                            x.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", stringExtra2, stringExtra3, cec);
                            if (!TextUtils.isEmpty(cec)) {
                                intent.putExtra("sns_landing_pages_xml", cec);
                                if (SnsAdNativeLandingPagesPreviewUI.f(intent, cec)) {
                                    SnsAdNativeLandingPagesPreviewUI.this.g(intent, cec);
                                    i byA = i.byA();
                                    String str2 = stringExtra2;
                                    String str3 = stringExtra3;
                                    if (!(TextUtils.isEmpty(cec) || TextUtils.isEmpty(str2))) {
                                        Object obj;
                                        if (bi.oN(str3)) {
                                            String obj2 = str2;
                                        } else {
                                            obj2 = str2 + str3;
                                        }
                                        byA.ruE.put(obj2, cec);
                                        w wVar = new w();
                                        wVar.field_canvasId = str2;
                                        wVar.field_canvasXml = cec;
                                        wVar.field_canvasExt = str3;
                                        byA.ruD.a(wVar);
                                    }
                                } else {
                                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                                    return 0;
                                }
                            }
                        }
                        xy xyVar = (xy) bVar.hnR.hnY;
                        x.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(longExtra), xyVar.wpm);
                        if (!TextUtils.isEmpty(xyVar.wpm)) {
                            intent.putExtra("sns_landing_pages_xml", xyVar.wpm);
                            if (SnsAdNativeLandingPagesPreviewUI.f(intent, xyVar.wpm)) {
                                SnsAdNativeLandingPagesPreviewUI.this.g(intent, xyVar.wpm);
                                i.byA().o(longExtra, xyVar.wpm);
                            } else {
                                SnsAdNativeLandingPagesPreviewUI.this.finish();
                                return 0;
                            }
                        }
                    } else if (i == 1) {
                        x.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", stringExtra2, stringExtra3, Integer.valueOf(i), Integer.valueOf(i2));
                    } else {
                        x.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", Long.valueOf(longExtra), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                    return 0;
                }
            });
        } else if (!g(intent, stringExtra)) {
            finish();
        }
    }

    private static boolean f(Intent intent, String str) {
        if (!bi.oN(str) && ac.LH(str)) {
            String LI = ac.LI(str);
            if (bi.oN(LI)) {
                return false;
            }
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_too_large_xml_path", LI);
        }
        return true;
    }

    private boolean g(Intent intent, String str) {
        if (e.LL(str)) {
            intent.setClass(this, SnsAdNativeLandingPagesUI.class);
            startActivity(intent);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
                return true;
            }
            overridePendingTransition(com.tencent.mm.plugin.sns.i.a.bqB, com.tencent.mm.plugin.sns.i.a.bqA);
            return true;
        }
        x.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, " + str);
        int indexOf = str.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = str.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(com.tencent.mm.plugin.sns.i.a.bqB, com.tencent.mm.plugin.sns.i.a.bqA);
                return true;
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.qNa;
    }
}
