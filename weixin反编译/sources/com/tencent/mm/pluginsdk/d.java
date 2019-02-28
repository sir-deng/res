package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.bt;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.u;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    public static String viN = "";
    private static final Map<String, Long> viO;

    public interface a {
        void a(int i, int i2, String str, k kVar, boolean z);
    }

    static {
        Map hashMap = new HashMap();
        viO = hashMap;
        hashMap.put("weixin://", Long.valueOf(0));
        viO.put("weixin://dl/stickers", Long.valueOf(1));
        viO.put("weixin://dl/games", Long.valueOf(2));
        viO.put("weixin://dl/moments", Long.valueOf(4));
        viO.put("weixin://dl/add", Long.valueOf(8));
        viO.put("weixin://dl/shopping", Long.valueOf(16));
        viO.put("weixin://dl/groupchat", Long.valueOf(32));
        viO.put("weixin://dl/scan", Long.valueOf(64));
        viO.put("weixin://dl/profile", Long.valueOf(128));
        viO.put("weixin://dl/settings", Long.valueOf(256));
        viO.put("weixin://dl/general", Long.valueOf(512));
        viO.put("weixin://dl/help", Long.valueOf(1024));
        viO.put("weixin://dl/notifications", Long.valueOf(2048));
        viO.put("weixin://dl/terms", Long.valueOf(4096));
        viO.put("weixin://dl/chat", Long.valueOf(8192));
        viO.put("weixin://dl/features", Long.valueOf(16384));
        viO.put("weixin://dl/clear", Long.valueOf(32768));
        viO.put("weixin://dl/feedback", Long.valueOf(HardCoderJNI.ACTION_ALLOC_MEMORY));
        viO.put("weixin://dl/faq", Long.valueOf(HardCoderJNI.ACTION_NET_RX));
        viO.put("weixin://dl/recommendation", Long.valueOf(HardCoderJNI.ACTION_NET_TX));
        viO.put("weixin://dl/groups", Long.valueOf(524288));
        viO.put("weixin://dl/tags", Long.valueOf(1048576));
        viO.put("weixin://dl/officialaccounts", Long.valueOf(2097152));
        viO.put("weixin://dl/posts", Long.valueOf(4194304));
        viO.put("weixin://dl/favorites", Long.valueOf(8388608));
        viO.put("weixin://dl/privacy", Long.valueOf(16777216));
        viO.put("weixin://dl/security", Long.valueOf(33554432));
        viO.put("weixin://dl/wallet", Long.valueOf(67108864));
        viO.put("weixin://dl/businessPay", Long.valueOf(134217728));
        viO.put("weixin://dl/businessPay/", Long.valueOf(134217728));
        viO.put("weixin://dl/wechatout", Long.valueOf(268435456));
        viO.put("weixin://dl/protection", Long.valueOf(1073741824));
        viO.put("weixin://dl/card", Long.valueOf(2147483648L));
        viO.put("weixin://dl/about", Long.valueOf(1125899906842624L));
        viO.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
        viO.put("weixin://dl/textsize", Long.valueOf(8589934592L));
        viO.put("weixin://dl/sight", Long.valueOf(17179869184L));
        viO.put("weixin://dl/languages", Long.valueOf(34359738368L));
        viO.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
        viO.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
        viO.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
        viO.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
        viO.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
        viO.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
        viO.put("weixin://dl/setname", Long.valueOf(4398046511104L));
        viO.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
        viO.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
        viO.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
        viO.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
        viO.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
        viO.put("weixin://dl/log", Long.valueOf(281474976710656L));
        viO.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
        viO.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
        viO.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
        viO.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
        viO.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
        viO.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    }

    public static boolean ai(String str, long j) {
        if (!bi.oN(str)) {
            long longValue;
            String RN = RN(str);
            if (viO.containsKey(RN)) {
                longValue = ((Long) viO.get(RN)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                return true;
            }
        }
        return false;
    }

    public static boolean RJ(String str) {
        String RN = RN(str);
        return viO.containsKey(RN) || RK(RN);
    }

    public static boolean RK(String str) {
        return !bi.oN(str) && str.startsWith("weixin://dl/business");
    }

    public static boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (bi.oN(uri.getQueryParameter("ticket"))) {
            return k(uri);
        }
        return true;
    }

    public static boolean k(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            return true;
        }
        return false;
    }

    private static boolean RL(String str) {
        if ((!str.equals("weixin://dl/wechatout") && !str.equals("weixin://dl/wechatoutcoupon") && !str.equals("weixin://dl/wechatoutshare")) || Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.aTK()).booleanValue()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        ad.getContext().startActivity(intent);
        return true;
    }

    public static void a(Context context, String str, String str2, int i, String str3, a aVar) {
        String str4 = bi.oN(str) ? str3 : str;
        if (!RL(str4)) {
            k lVar = new l(str4, str2, i, (int) System.currentTimeMillis(), new byte[0]);
            final Context context2 = context;
            final int i2 = i;
            final String str5 = str2;
            final String str6 = str4;
            final a aVar2 = aVar;
            as.CN().a(233, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    as.CN().b(233, (e) this);
                    x.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    boolean z = false;
                    if (kVar != null && (kVar instanceof l)) {
                        l lVar = (l) kVar;
                        x.d("MicroMsg.DeepLinkHelper", "bitset:" + lVar.RR());
                        long RR = lVar.RR();
                        String RL = lVar.RL();
                        if (d.ai(RL, RR)) {
                            try {
                                x.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", RL);
                                z = d.a(context2, lVar.RT(), lVar.RU(), RL);
                                g.pWK.h(11405, RL, Integer.valueOf(1), Integer.valueOf(i2), str5, bi.oM(str6));
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                g.pWK.h(11405, RL, Integer.valueOf(0), Integer.valueOf(i2), str5, bi.oM(str6));
                            }
                        } else {
                            x.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                            Intent intent = new Intent();
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                            intent.putExtra("geta8key_session_id", lVar.RT());
                            intent.putExtra("geta8key_cookie", lVar.RU());
                            ad.getContext().startActivity(intent);
                            g.pWK.h(11405, RL, Integer.valueOf(0), Integer.valueOf(i2), str5, bi.oM(str6));
                            z = true;
                        }
                    }
                    if (aVar2 != null) {
                        aVar2.a(i, i2, str, kVar, z);
                    }
                }
            });
            as.CN().a(lVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar, String str2, String str3) {
        a(context, str, i, null, aVar, str2, str3);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar, String str2, String str3) {
        LinkedList linkedList = new LinkedList();
        co coVar = new co();
        if (!(bi.oN(str2) || bi.oN(str3))) {
            x.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", str2, str3);
            coVar.vOq = str2;
            coVar.signature = str3;
            linkedList.add(coVar);
        }
        if (!RL(str)) {
            k akVar = new ak(str, i, linkedList);
            final Bundle bundle2 = bundle;
            final Context context2 = context;
            final int i2 = i;
            final String str4 = str;
            final a aVar2 = aVar;
            as.CN().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    as.CN().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
                    x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    boolean z = false;
                    if (kVar != null && (kVar instanceof ak)) {
                        String Sw = ((ak) kVar).Sw();
                        if (d.RJ(Sw)) {
                            try {
                                x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", Sw);
                                x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", bundle2);
                                z = d.a(context2, Sw, i2, bundle2, str4);
                                g.pWK.h(11405, str4, Integer.valueOf(i2), Integer.valueOf(1), Sw);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                g.pWK.h(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), Sw);
                            }
                        } else {
                            x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                            Intent intent = new Intent();
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                            intent.putExtra("showShare", false);
                            x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", bundle2);
                            if (bundle2 != null) {
                                intent.putExtras(bundle2);
                            }
                            ad.getContext().startActivity(intent);
                            g.pWK.h(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), Sw);
                            z = true;
                        }
                    }
                    if (aVar2 != null) {
                        aVar2.a(i, i2, str, kVar, z);
                    }
                }
            });
            as.CN().a(akVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar) {
        a(context, str, i, null, aVar, null, null);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar) {
        a(context, str, i, bundle, aVar, null, null);
    }

    public static boolean RM(String str) {
        return a(null, str, 0, null, (int) System.currentTimeMillis(), new byte[0], null);
    }

    public static boolean a(Context context, int i, byte[] bArr, String str) {
        return a(context, str, 0, null, i, bArr, null);
    }

    public static boolean a(Context context, String str, int i, Bundle bundle, String str2) {
        return a(context, str, i, bundle, (int) System.currentTimeMillis(), new byte[0], str2);
    }

    private static boolean a(Context context, String str, int i, Bundle bundle, int i2, byte[] bArr, String str2) {
        String RN = RN(str);
        if (bi.oN(RN)) {
            return false;
        }
        String substring;
        String encode;
        Uri parse;
        String queryParameter;
        final Intent intent;
        if (viO.containsKey(RN)) {
            long longValue = ((Long) viO.get(RN)).longValue();
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", Long.valueOf(longValue));
            RN = null;
            Intent intent2 = new Intent();
            intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            String str3;
            int Cn;
            String encode2;
            String encode3;
            int e;
            if (longValue == 0) {
                RN = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                RN = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.pWK.h(12065, Integer.valueOf(7));
            } else if (longValue == 2) {
                intent2.putExtra("from_deeplink", true);
                intent2.putExtra("game_report_from_scene", 6);
                RN = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((q.Gj() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0 ? 1 : null) != null) {
                    RN = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                    intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                RN = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                b hnVar = new hn();
                com.tencent.mm.sdk.b.a.xmy.m(hnVar);
                str3 = hnVar.fyK.url;
                if (!bi.oN(str3)) {
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    RN = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent2.putExtra("titile", ad.getContext().getString(R.l.dDy));
                intent2.putExtra("list_type", 0);
                intent2.putExtra("list_attr", s.p(s.zcA, 256, WXMediaMessage.TITLE_LENGTH_LIMIT));
                RN = "com.tencent.mm.ui.contact.SelectContactUI";
            } else if (longValue == 64) {
                RN = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
                intent2.putExtra("animation_pop_in", true);
            } else if (longValue == 128) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            } else if (longValue == 256) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            } else if (longValue == 512) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 1024) {
                Q(ad.getContext(), i2);
            } else if (longValue == 2048) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == 4096) {
                intent2.putExtra("title", ad.getContext().getResources().getString(R.l.eBl));
                intent2.putExtra("rawUrl", ad.getContext().getResources().getString(R.l.eSB));
                intent2.putExtra("showShare", false);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                RN = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 8192) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            } else if (longValue == 16384) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            } else if (longValue == 32768) {
                RN = "com.tencent.mm.plugin.clean.ui.CleanUI";
            } else if (longValue == HardCoderJNI.ACTION_ALLOC_MEMORY) {
                try {
                    str3 = "";
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        substring = str.substring(indexOf + 1);
                    } else {
                        substring = str3;
                    }
                    com.tencent.mm.kernel.g.Do();
                    Cn = com.tencent.mm.kernel.a.Cn();
                    encode = URLEncoder.encode(com.tencent.mm.protocal.d.vHj, ProtocolPackage.ServerEncoding);
                    String encode4 = URLEncoder.encode(bi.che(), ProtocolPackage.ServerEncoding);
                    encode2 = URLEncoder.encode(com.tencent.mm.compatible.e.q.yL(), ProtocolPackage.ServerEncoding);
                    String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.vHe, ProtocolPackage.ServerEncoding);
                    encode3 = URLEncoder.encode(com.tencent.mm.protocal.d.vHf, ProtocolPackage.ServerEncoding);
                    str3 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.vHl + "&lang=" + w.eM(ad.getContext()) + "&" + bi.oM(substring) + ("&uin=" + Cn + "&deviceName=" + encode + "&timeZone=" + encode4 + "&imei=" + encode2 + "&deviceBrand=" + encode5 + "&deviceModel=" + encode3 + "&ostype=" + URLEncoder.encode(com.tencent.mm.protocal.d.vHg, ProtocolPackage.ServerEncoding) + "&clientSeqID=" + URLEncoder.encode(as.CI(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bi.fb(ad.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bi.oN(substring) ? 0 : 1));
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("neverGetA8Key", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    RN = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e2) {
                    x.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", e2.getMessage());
                }
            } else if (longValue == HardCoderJNI.ACTION_NET_RX) {
                com.tencent.mm.kernel.g.Do();
                Cn = com.tencent.mm.kernel.a.Cn();
                as.Hm();
                e = bi.e((Integer) c.Db().get(12304, null));
                RN = ad.getContext().getString(R.l.eNF, new Object[]{Integer.valueOf(Cn), Integer.valueOf(e)});
                intent2.putExtra("showShare", false);
                intent2.putExtra("rawUrl", RN);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                RN = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == HardCoderJNI.ACTION_NET_TX) {
                RN = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == 524288) {
                RN = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                RN = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                RN = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bl.d.b(ad.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                return true;
            } else if (longValue == 4194304) {
                as.Hm();
                intent2.putExtra("sns_userName", (String) c.Db().get(2, null));
                intent2.addFlags(67108864);
                as.Hm();
                e = bi.a((Integer) c.Db().get(68389, null), 0);
                as.Hm();
                c.Db().set(68389, Integer.valueOf(e + 1));
                RN = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
            } else if (longValue == 8388608) {
                RN = "com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI";
            } else if (longValue == 16777216) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
            } else if (longValue == 33554432) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
            } else if (longValue == 67108864) {
                RN = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
            } else if (longValue == 134217728) {
                if (!(context == null || bi.oN(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            str3 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (bi.oN(str3)) {
                                x.w("MicroMsg.DeepLinkHelper", "reqkey null");
                            } else {
                                Parcelable payInfo = new PayInfo();
                                payInfo.fvC = str3;
                                payInfo.appId = queryParameter;
                                payInfo.fDQ = 36;
                                payInfo.niF = false;
                                intent2 = new Intent();
                                intent2.putExtra("key_pay_info", payInfo);
                                if (q.Gl()) {
                                    com.tencent.mm.bl.d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent2, 1);
                                } else {
                                    com.tencent.mm.bl.d.b(context, "wallet", ".pay.ui.WalletPayUI", intent2, 1);
                                }
                            }
                        } else {
                            x.w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent2 = null;
            } else if (longValue == 1073741824) {
                RN = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                x.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
                RN = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (longValue == 4294967296L) {
                intent2.putExtra("filter_type", com.tencent.mm.y.x.hE(ad.getContext().getString(R.l.enS)).getType());
                intent2.putExtra("titile", ad.getContext().getString(R.l.eMW));
                intent2.putExtra("list_attr", WXMediaMessage.THUMB_LENGTH_LIMIT);
                RN = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
            } else if (longValue == 8589934592L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
            } else if (longValue == 17179869184L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 34359738368L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
            } else if (longValue == 68719476736L) {
                RN = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
            } else if (longValue == 137438953472L) {
                intent2.setClassName(ad.getContext(), "com.tencent.mm.ui.bindqq.BindQQUI");
                MMWizardActivity.A(context, intent2);
                return true;
            } else if (longValue == 274877906944L) {
                intent2.setClassName(ad.getContext(), "com.tencent.mm.ui.bindmobile.BindMContactIntroUI");
                MMWizardActivity.A(context, intent2);
                return true;
            } else if (longValue == 549755813888L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                com.tencent.mm.bl.d.b(ad.getContext(), "profile", ".ui.ContactInfoUI", intent2.putExtra("Contact_User", "qqsync"));
                return true;
            } else if (longValue == 2199023255552L) {
                RN = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent2.putExtra("launch_from_webview", false);
                com.tencent.mm.bl.d.a(ad.getContext(), "address", ".ui.WalletSelectAddrUI", intent2, true);
                return true;
            } else if (longValue == 35184372088832L) {
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.bl.d.b(ad.getContext(), "sns", ".ui.SnsBlackDetailUI", intent2);
                return true;
            } else if (longValue == 70368744177664L) {
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.bl.d.b(ad.getContext(), "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (longValue == 140737488355328L) {
                RN = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                b btVar = new bt();
                btVar.fqO.fqQ = "//uplog";
                btVar.fqO.context = ad.getContext();
                com.tencent.mm.sdk.b.a.xmy.m(btVar);
                return true;
            } else if (longValue == 562949953421312L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bl.d.b(ad.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                com.tencent.mm.bl.d.b(ad.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bl.d.b(ad.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                com.tencent.mm.bl.d.b(ad.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                com.tencent.mm.bl.d.b(ad.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent2);
            } else if (longValue == 576460752303423488L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                intent2.setClassName(ad.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
                ad.getContext().startActivity(intent2);
            } else if (longValue == 1125899906842624L) {
                RN = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent2.putExtra("emoji_tab", 1);
                RN = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.pWK.h(12065, Integer.valueOf(7));
            } else if (longValue == 9007199254740992L) {
                RN = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            } else if (longValue == 576460752303423489L) {
                Uri parse2 = Uri.parse(str);
                encode3 = parse2.getQueryParameter("appid");
                str3 = parse2.getQueryParameter("userName");
                encode2 = parse2.getQueryParameter("path");
                int i3 = 0;
                u.b t = u.GQ().t("key_data_center_session_id", false);
                if (t != null) {
                    i3 = ((Integer) t.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                }
                x.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", encode3, str3, encode2, Integer.valueOf(i), Integer.valueOf(i3));
                u.GQ().hB("key_data_center_session_id");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.foi = URLEncoder.encode(str2);
                if (i == 2) {
                    appBrandStatObject.scene = 1065;
                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode2, appBrandStatObject);
                } else if (i == 1) {
                    appBrandStatObject.scene = 1069;
                    appBrandStatObject.foi = encode3;
                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode2, appBrandStatObject, encode3);
                } else if (i == 6) {
                    appBrandStatObject.scene = 1007;
                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode2, appBrandStatObject);
                } else if (i == 7) {
                    appBrandStatObject.scene = 1008;
                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode2, appBrandStatObject);
                } else {
                    appBrandStatObject.scene = 1000;
                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, 0, 0, encode2, appBrandStatObject);
                }
                return true;
            }
            if (bi.oN(RN)) {
                return false;
            }
            intent2.setClassName(ad.getContext(), RN);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e3, "", "");
                }
            } else {
                ad.getContext().startActivity(intent2);
                com.tencent.mm.ui.base.b.B(ad.getContext(), intent2);
            }
            return true;
        } else if (RN.startsWith("weixin://dl/businessTempSession/")) {
            intent = new Intent();
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            parse = Uri.parse(str);
            if (parse == null) {
                x.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                return false;
            }
            substring = parse.getQueryParameter("sessionFrom");
            encode = parse.getQueryParameter("showtype");
            RN = parse.getQueryParameter("username");
            if (bi.oN(RN)) {
                RN = parse.getQueryParameter("userName");
            }
            if (bi.oN(RN)) {
                x.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                return false;
            }
            int i4 = bi.getInt(bi.oM(parse.getQueryParameter("scene")), 0);
            if (i4 != 0 && i == 4) {
                x.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i4);
                i = i4;
            }
            x.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", RN, substring, Integer.valueOf(i), str, encode);
            intent.setClassName(ad.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
            intent.putExtra("Chat_User", RN);
            intent.putExtra("finish_direct", true);
            intent.putExtra("key_is_temp_session", true);
            intent.putExtra("key_temp_session_from", substring);
            intent.putExtra("key_temp_session_scene", i);
            intent.putExtra("key_temp_session_show_type", bi.getInt(encode, 0));
            as.Hm();
            com.tencent.mm.k.a Xv = c.Ff().Xv(RN);
            if (Xv == null || ((int) Xv.gKO) <= 0) {
                final Context context2 = context;
                com.tencent.mm.y.ak.a.hhv.a(RN, "", new com.tencent.mm.y.ak.b.a() {
                    public final void v(String str, boolean z) {
                        if (z) {
                            intent.putExtra("Chat_User", str);
                            try {
                                if (context2 != null) {
                                    context2.startActivity(intent);
                                    return;
                                } else {
                                    ad.getContext().startActivity(intent);
                                    return;
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                return;
                            }
                        }
                        x.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", str);
                    }
                });
            } else {
                context.startActivity(intent);
            }
            return true;
        } else if (RN.startsWith("weixin://dl/businessGame/detail/") || RN.startsWith("weixin://dl/businessGame/detail")) {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
            parse = Uri.parse(str);
            RN = null;
            intent = new Intent();
            if (parse != null) {
                RN = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                intent.putExtra("game_app_id", parse.getQueryParameter("appid"));
                intent.putExtra("game_report_from_scene", 6);
            }
            if (bi.oN(RN)) {
                return false;
            }
            intent.setClassName(ad.getContext(), RN);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e32, "", "");
                }
            } else {
                ad.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.B(ad.getContext(), intent);
            }
            return true;
        } else if (RN.startsWith("weixin://dl/businessGame/library/") || RN.startsWith("weixin://dl/businessGame/library")) {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
            Intent intent3 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (bi.oN(queryParameter)) {
                return false;
            }
            intent3.putExtra("game_report_from_scene", 6);
            intent3.setClassName(ad.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent3);
                } catch (Throwable e322) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e322, "", "");
                }
            } else {
                ad.getContext().startActivity(intent3);
                com.tencent.mm.ui.base.b.B(ad.getContext(), intent3);
            }
            return true;
        } else if (!RN.startsWith("weixin://dl/businessWebview/link/") && !RN.startsWith("weixin://dl/businessWebview/link")) {
            return false;
        } else {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
            parse = Uri.parse(str);
            intent = new Intent();
            RN = null;
            if (parse != null) {
                x.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, translateLinkScene: %s", parse.getQueryParameter(SlookSmartClipMetaTag.TAG_TYPE_URL), Integer.valueOf(i));
                RN = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                intent.putExtra("rawUrl", queryParameter);
                intent.putExtra("geta8key_session_id", i2);
                intent.putExtra("geta8key_cookie", bArr);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (i == 1) {
                    intent.putExtra("show_openapp_dialog", false);
                    intent.putExtra("pay_channel", 40);
                    i.CU(39);
                } else if (i == 2) {
                    intent.putExtra("pay_channel", 39);
                    i.CU(39);
                }
                intent.putExtra("transaction_for_openapi_openwebview", viN);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
            }
            if (bi.oN(RN)) {
                return false;
            }
            intent.setClassName(ad.getContext(), RN);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e3222) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e3222, "", "");
                }
            } else {
                ad.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.B(ad.getContext(), intent);
            }
            return true;
        }
    }

    public static void ea(Context context) {
        Q(context, (int) System.currentTimeMillis());
    }

    private static void Q(Context context, int i) {
        String string;
        if (!f.xmW && w.cfV().equals("zh_CN")) {
            string = context.getString(R.l.eXJ);
        } else if (w.cfV().equals("zh_HK")) {
            string = context.getString(R.l.eXK);
        } else if (w.cfV().equals("zh_TW")) {
            string = context.getString(R.l.eXL);
        } else {
            string = context.getString(R.l.eXM);
        }
        x.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("geta8key_session_id", i);
        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    private static String RN(String str) {
        if (bi.oN(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() + "://" + parse.getHost() + parse.getPath();
    }

    public static void v(final Context context, String str, String str2) {
        if (!RL(str2)) {
            final ProgressDialog a = h.a(context, "", true, null);
            int i = 6;
            if (!bi.oN(str)) {
                if (com.tencent.mm.y.s.eX(str)) {
                    i = 7;
                } else if (com.tencent.mm.y.s.gI(str)) {
                    i = 9;
                }
            }
            a(context, str2, i, new a() {
                public final void a(int i, int i2, String str, k kVar, boolean z) {
                    x.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                    if (a != null && a.isShowing()) {
                        a.dismiss();
                    }
                    if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof ak)) {
                        bqb Sx = ((ak) kVar).Sx();
                        if (Sx != null && context != null) {
                            com.tencent.mm.ui.base.u.makeText(context, context.getString(R.l.dGZ) + " : " + bi.oM(Sx.wYS), 0).show();
                        }
                    }
                }
            });
        }
    }

    public static void aT(Context context, String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            x.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", parse.getQueryParameter("cc"), parse.getQueryParameter("num"));
            Intent intent = new Intent();
            intent.putExtra("input_country_code", r1);
            intent.putExtra("input_mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bl.d.b(context, "accountsync", "com.tencent.mm.ui.account.mobile.MobileInputUI", intent);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            x.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", Uri.parse(str).getQueryParameter("username"));
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bl.d.b(context, "accountsync", "com.tencent.mm.ui.account.LoginUI", intent2);
        } else {
            x.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", str);
        }
    }
}
