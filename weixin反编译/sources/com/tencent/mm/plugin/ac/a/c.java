package com.tencent.mm.plugin.ac.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.f.a.op;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.scanner.a.p;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {

    public interface a {
        Context getContext();

        void hw(boolean z);
    }

    public static boolean a(final a aVar, l lVar, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable, Bundle bundle) {
        if (aVar == null || aVar.getContext() == null) {
            x.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            return false;
        }
        int RN = lVar.RN();
        int i3 = ((xp) lVar.gLB.hnQ.hnY).wcr;
        x.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", Integer.valueOf(RN), Integer.valueOf(i3));
        x.i("MicroMsg.scanner.GetA8KeyRedirect", "source=" + i);
        final Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        i.CU(vy(i));
        String RL;
        String string;
        String RL2;
        Intent z;
        switch (RN) {
            case 1:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + lVar.wl());
                intent.putExtra(SlookAirButtonFrequentContactAdapter.DATA, lVar.wl());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", vy(i));
                intent.putExtra("geta8key_session_id", lVar.RT());
                b.ihN.j(intent, aVar.getContext());
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 2:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + lVar.RL());
                Context context = aVar.getContext();
                Context context2 = aVar.getContext();
                RN = R.l.eBD;
                Object[] objArr = new Object[1];
                if (bi.oN(str)) {
                    str = lVar.RL();
                }
                objArr[0] = str;
                final l lVar2 = lVar;
                final int i4 = i2;
                final int i5 = i;
                final a aVar2 = aVar;
                h.a(context, context2.getString(RN, objArr), aVar.getContext().getString(R.l.dGZ), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        intent.putExtra("title", lVar2.getTitle());
                        intent.putExtra("rawUrl", lVar2.RL());
                        if (i4 == 2) {
                            intent.putExtra("stastic_scene", 13);
                        } else if (i4 == 1) {
                            intent.putExtra("stastic_scene", 14);
                        } else {
                            intent.putExtra("stastic_scene", 11);
                        }
                        intent.putExtra("pay_channel", c.vy(i5));
                        intent.putExtra("geta8key_session_id", lVar2.RT());
                        intent.putExtra("geta8key_cookie", lVar2.RU());
                        b.ihN.j(intent, aVar2.getContext());
                    }
                }, onClickListener);
                return true;
            case 3:
                RL = lVar.RL();
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: " + RL);
                if (RL == null || RL.length() == 0) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    return false;
                }
                string = aVar.getContext().getString(R.l.eBC);
                if (RL.startsWith("http")) {
                    string = aVar.getContext().getString(R.l.eBD, new Object[]{RL});
                }
                Uri parse = Uri.parse(RL);
                if (parse != null) {
                    final Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (bi.k(aVar.getContext(), intent2)) {
                        h.a(aVar.getContext(), string, aVar.getContext().getString(R.l.dGZ), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.getContext().startActivity(intent2);
                            }
                        }, onClickListener);
                        return true;
                    }
                }
                return false;
            case 4:
                return false;
            case 6:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + lVar.RL());
                intent.putExtra("rawUrl", lVar.RL());
                intent.putExtra("pay_channel", vy(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                intent.putExtra("geta8key_session_id", lVar.RT());
                intent.putExtra("geta8key_cookie", lVar.RU());
                b.ihN.j(intent, aVar.getContext());
                return true;
            case 7:
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", lVar.RM(), lVar.RL(), lVar.RP());
                intent.putExtra("title", lVar.getTitle());
                intent.putExtra("rawUrl", lVar.RL());
                intent.putExtra("k_share_url", lVar.RP());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + vy(i));
                intent.putExtra("pay_channel", vy(i));
                intent.putExtra("geta8key_session_id", lVar.RT());
                intent.putExtra("geta8key_cookie", lVar.RU());
                List<akw> RS = lVar.RS();
                if (!bi.cC(RS)) {
                    akw akw;
                    Object obj;
                    String[] strArr;
                    String[] strArr2;
                    for (akw akw2 : RS) {
                        if (akw2 == null || bi.oN(akw2.vUa)) {
                            x.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                strArr = new String[RS.size()];
                                strArr2 = new String[RS.size()];
                                i3 = 0;
                                while (true) {
                                    RN = i3;
                                    if (RN < RS.size()) {
                                        akw2 = (akw) RS.get(RN);
                                        x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", Integer.valueOf(RN), akw2.vUa, akw2.pWq);
                                        strArr[RN] = r8;
                                        strArr2[RN] = RL;
                                        i3 = RN + 1;
                                    } else {
                                        intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                        intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                        intent.putExtra("k_has_http_header", true);
                                    }
                                }
                            }
                        } else if (bi.oN(akw2.pWq)) {
                            x.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                strArr = new String[RS.size()];
                                strArr2 = new String[RS.size()];
                                i3 = 0;
                                while (true) {
                                    RN = i3;
                                    if (RN < RS.size()) {
                                        intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                        intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                        intent.putExtra("k_has_http_header", true);
                                    } else {
                                        akw2 = (akw) RS.get(RN);
                                        x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", Integer.valueOf(RN), akw2.vUa, akw2.pWq);
                                        strArr[RN] = r8;
                                        strArr2[RN] = RL;
                                        i3 = RN + 1;
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        strArr = new String[RS.size()];
                        strArr2 = new String[RS.size()];
                        i3 = 0;
                        while (true) {
                            RN = i3;
                            if (RN < RS.size()) {
                                akw2 = (akw) RS.get(RN);
                                x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", Integer.valueOf(RN), akw2.vUa, akw2.pWq);
                                strArr[RN] = r8;
                                strArr2[RN] = RL;
                                i3 = RN + 1;
                            } else {
                                intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                intent.putExtra("k_has_http_header", true);
                            }
                        }
                    }
                }
                b.ihN.j(intent, aVar.getContext());
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 8:
                string = lVar.wl();
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: " + string);
                if (!bi.oN(string)) {
                    try {
                        new p().Jh(string);
                        aVar.getContext().startActivity(new Intent(aVar.getContext(), VcardContactUI.class));
                        aVar.hw(false);
                        return true;
                    } catch (Throwable e) {
                        x.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        x.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        x.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                h.a(aVar.getContext(), aVar.getContext().getString(R.l.eBK), aVar.getContext().getString(R.l.dGZ), false, onClickListener);
                return true;
            case 9:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_scene", 5);
                return b.ihN.a(aVar.getContext(), lVar.RL(), bundle2);
            case 10:
            case 11:
                a(aVar, RN, lVar.RL(), vy(i));
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 12:
            case 15:
                a(aVar, RN, lVar.RL(), vy(i));
                return true;
            case 14:
                RL = lVar.RL();
                if (RL != null) {
                    RL = RL.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", RL);
                intent.putExtra("key_product_scene", 7);
                d.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                return true;
            case 16:
                RL2 = lVar.RL();
                intent = new Intent().setClassName(ad.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
                z = bi.z(ad.getContext(), intent);
                if (z == null) {
                    z = intent;
                }
                ad.getContext().startService(z.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, RL2).putExtra("isFromWifi", true));
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                return true;
            case 17:
                final Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", lVar.RL());
                string = "free_wifi_mid";
                xq xqVar = (xq) lVar.gLB.hnR.hnY;
                if (xqVar == null || xqVar.vKF == null) {
                    x.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    RL = null;
                } else {
                    RL = xqVar.vKF;
                }
                intent3.putExtra(string, RL);
                string = "free_wifi_ssid";
                xqVar = (xq) lVar.gLB.hnR.hnY;
                if (xqVar == null || xqVar.SSID == null) {
                    x.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    RL = null;
                } else {
                    RL = xqVar.SSID;
                }
                intent3.putExtra(string, RL);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", lVar.RL());
                as.Hm();
                if (com.tencent.mm.y.c.Db().get(303104, null) != null) {
                    h.a(aVar.getContext(), R.l.ejP, R.l.dGZ, R.l.eke, R.l.dEy, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                            aVar.hw(false);
                        }
                    }, onClickListener);
                } else {
                    d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    aVar.hw(false);
                }
                return true;
            case 18:
                com.tencent.mm.plugin.scanner.util.p.a Jt = com.tencent.mm.plugin.scanner.util.p.Jt(lVar.RL());
                if (Jt == null) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (com.tencent.mm.plugin.scanner.util.p.nY(Jt.kPz)) {
                    intent = new Intent();
                    intent.putExtra("key_card_id", Jt.kPy);
                    intent.putExtra("key_card_ext", Jt.fHQ);
                    intent.putExtra("key_from_scene", 0);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    x.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    com.tencent.mm.plugin.scanner.util.p.aw(aVar.getContext(), aVar.getContext().getString(R.l.dPc));
                }
                return false;
            case 20:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + lVar.RL());
                as.CN().a(new aa(lVar.RL()), 0);
                return true;
            case 21:
                z = new Intent();
                z.setClass(aVar.getContext(), ProductUI.class);
                z.putExtra("key_ProductUI_getProductInfoScene", 5);
                z.putExtra("key_Qrcode_Url", lVar.RL());
                aVar.getContext().startActivity(z);
                return true;
            case 22:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + lVar.RL());
                com.tencent.mm.pluginsdk.wallet.h.a(aVar.getContext(), 1, lVar.RL(), vy(i), null);
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 23:
                RL = lVar.RL();
                if (bi.oN(RL)) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
                    return true;
                }
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", RL);
                com.tencent.mm.sdk.b.b xVar = new com.tencent.mm.f.a.x();
                xVar.foI.url = RL;
                com.tencent.mm.sdk.b.a.xmy.m(xVar);
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
                return true;
            case 24:
                com.tencent.mm.sdk.b.b opVar = new op();
                opVar.fHq.fHr = str;
                com.tencent.mm.sdk.b.a.xmy.m(opVar);
                return true;
            case 25:
                RL = lVar.RL();
                ArrayList Ju = com.tencent.mm.plugin.scanner.util.p.Ju(RL);
                if (Ju == null || Ju.size() == 0) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (com.tencent.mm.plugin.scanner.util.p.N(Ju)) {
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 0);
                    intent.putExtra("src_username", "");
                    intent.putExtra("js_url", "");
                    intent.putExtra("key_in_card_list", RL);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    x.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    com.tencent.mm.plugin.scanner.util.p.aw(aVar.getContext(), aVar.getContext().getString(R.l.dPc));
                }
                return false;
            case 26:
                RL2 = lVar.RL();
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: " + RL2);
                Context context3 = aVar.getContext();
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: " + RL2);
                Uri parse2 = Uri.parse(RL2);
                int i6;
                if (parse2.getQueryParameter("search_query") == null || parse2.getQueryParameter("search_query").length() <= 0) {
                    if (i2 == 2) {
                        i6 = i3 == 22 ? 1048 : HardCoderJNI.FUNC_TERMINATE_APP;
                    } else if (i2 == 1) {
                        i6 = i3 == 22 ? 1049 : HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE;
                    } else {
                        i6 = i3 == 22 ? 1047 : HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE;
                    }
                    ((e) g.h(e.class)).b(context3, RL2, i6, bundle);
                } else {
                    RL = parse2.getQueryParameter("search_query");
                    String queryParameter = parse2.getQueryParameter("appid");
                    String queryParameter2 = parse2.getQueryParameter("search_extInfo");
                    int i7 = bi.getInt(parse2.getQueryParameter("debug"), 0);
                    i6 = bi.getInt(parse2.getQueryParameter("version"), 0);
                    com.tencent.mm.sdk.b.b kxVar = new kx();
                    kxVar.fCZ.scene = 1;
                    kxVar.fCZ.appId = queryParameter;
                    kxVar.fCZ.type = i7;
                    kxVar.fCZ.version = i6;
                    kxVar.fCZ.fDa = RL;
                    kxVar.fCZ.url = RL2;
                    kxVar.fCZ.fDb = queryParameter2;
                    com.tencent.mm.sdk.b.a.xmy.m(kxVar);
                    intent = com.tencent.mm.bb.b.QT();
                    intent.putExtra("ftsbizscene", 99999);
                    intent.putExtra("ftsQuery", RL);
                    intent.putExtra("ftsqrcodestring", RL2);
                    Map b = com.tencent.mm.bb.b.b(300, false, 262144);
                    b.put("query", RL);
                    RL = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) b.get("scene")));
                    b.put("sessionid", RL);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                    intent.putExtra("key_session_id", RL);
                    d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", intent);
                }
                aVar.hw(false);
                return true;
            default:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + lVar.RN());
                return false;
        }
    }

    private static void a(final a aVar, int i, String str, int i2) {
        x.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", Integer.valueOf(i), str);
        final com.tencent.mm.sdk.b.b gxVar = new gx();
        gxVar.fxW.actionCode = i;
        gxVar.fxW.result = str;
        gxVar.fxW.context = aVar.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        gxVar.fxW.fxY = bundle;
        gxVar.frD = new Runnable() {
            public final void run() {
                if (aVar != null && gxVar != null && gxVar.fxX != null) {
                    if (gxVar.fxX.ret == 1) {
                        aVar.hw(true);
                    } else if (gxVar.fxX.ret == 2) {
                        aVar.hw(false);
                    }
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(gxVar, Looper.myLooper());
    }

    protected static int vy(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }
}
