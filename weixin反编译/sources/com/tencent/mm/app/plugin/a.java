package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.q.v;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Iterator;

public final class a implements v {
    public final boolean a(Context context, String str, boolean z) {
        return a(context, str, z, null);
    }

    public final boolean a(Context context, String str, boolean z, t tVar) {
        if (context == null) {
            x.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            return false;
        } else if (str.startsWith("http")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", e.getMessage());
            }
            return true;
        } else if (b(context, str, z, tVar)) {
            return false;
        } else {
            x.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", str);
            return false;
        }
    }

    public final boolean a(Context context, String str, boolean z, Bundle bundle) {
        return a(context, str, z, null, bundle);
    }

    public final boolean b(Context context, String str, boolean z, t tVar) {
        return a(context, str, z, tVar, null);
    }

    private boolean a(Context context, String str, boolean z, t tVar, Bundle bundle) {
        if (context == null) {
            x.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            return false;
        } else if (str == null) {
            x.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            return b(context, str, new Object[0]);
        } else {
            d uC = d.uC();
            String str2 = "MicroMsg.URISpanHandler";
            String str3 = "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(tVar == null);
            objArr[3] = Integer.valueOf(uC.fhr.size());
            objArr[4] = Integer.valueOf(uC.fhs.size());
            objArr[5] = Integer.valueOf(uC.fht.size());
            x.d(str2, str3, objArr);
            if (context == null) {
                x.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
                uC.fhq.mContext = null;
                return false;
            }
            uC.mContext = context;
            uC.fhq.mContext = uC.mContext;
            if (bi.oN(str)) {
                x.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
                uC.mContext = null;
                uC.fhq.mContext = null;
                return false;
            }
            Iterator it = uC.fhr.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, tVar, bundle)) {
                    x.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    uC.mContext = null;
                    uC.fhq.mContext = null;
                    return true;
                }
            }
            it = uC.fhs.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, tVar, bundle)) {
                    x.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    uC.mContext = null;
                    uC.fhq.mContext = null;
                    return true;
                }
            }
            it = uC.fht.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, tVar, bundle)) {
                    x.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    uC.mContext = null;
                    uC.fhq.mContext = null;
                    return true;
                }
            }
            uC.mContext = null;
            uC.fhq.mContext = null;
            x.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
            return false;
        }
    }

    public final boolean b(Context context, String str, Object... objArr) {
        if (str == null) {
            x.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            return false;
        } else if (context == null) {
            x.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            String replace = str.replace("weixin://openSpecificView/", "");
            Bundle bundle = null;
            if (objArr != null && objArr.length > 0) {
                bundle = (Bundle) objArr[0];
            }
            String string;
            if (replace.equalsIgnoreCase("contacts")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 2);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("newfriend")) {
                d.b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                d.b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                d.b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("timeline")) {
                d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                d.b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                d.b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.A(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase("privacy")) {
                d.b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                d.b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.fS(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                } else {
                    string = replace;
                }
                intent.putExtra("k_expose_url", string);
                intent.putExtra("k_username", q.FY());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)}));
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (replace.equalsIgnoreCase("shakecard")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString("extinfo");
                } else {
                    string = replace;
                }
                intent.putExtra("key_shake_card_from_scene", 3);
                intent.putExtra("shake_card", true);
                intent.putExtra("key_shake_card_ext_info", string);
                d.b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                x.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
                d.b(context, "card", ".ui.CardHomePageUI", intent);
            } else if (!replace.equalsIgnoreCase("uploadlog")) {
                return false;
            } else {
                int i;
                String str2;
                String str3;
                Object[] objArr2;
                boolean z;
                Intent intent3;
                replace = q.FY();
                if (bi.oN(replace)) {
                    replace = "weixin";
                }
                if (bundle != null) {
                    try {
                        i = bi.getInt(bundle.getString("extinfo"), 0);
                    } catch (Exception e) {
                    }
                    str2 = "MicroMsg.MMURIJumpHandler";
                    str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                    objArr2 = new Object[2];
                    z = as.Hp() && !as.Cz();
                    objArr2[0] = Boolean.valueOf(z);
                    objArr2[1] = Integer.valueOf(i);
                    x.i(str2, str3, objArr2);
                    intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                    intent3.putExtra("key_user", replace);
                    intent3.putExtra("key_time", i);
                    context.startActivity(intent3);
                }
                i = 0;
                str2 = "MicroMsg.MMURIJumpHandler";
                str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                objArr2 = new Object[2];
                if (!as.Hp()) {
                }
                objArr2[0] = Boolean.valueOf(z);
                objArr2[1] = Integer.valueOf(i);
                x.i(str2, str3, objArr2);
                intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent3.putExtra("key_user", replace);
                intent3.putExtra("key_time", i);
                context.startActivity(intent3);
            }
            return true;
        }
    }
}
