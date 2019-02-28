package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Locale;

public final class a {
    public p fhH;
    public com.tencent.mm.plugin.wallet.a pRC = null;
    public am yHi = null;
    public final com.tencent.mm.sdk.e.j.a yHj = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            x.v("MicroMsg.ChattingUI.AppImp", "app attach info watcher notify");
            a.this.fhH.ctm().a(null, null);
        }
    };
    public final com.tencent.mm.sdk.e.j.a yHk = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            x.v("MicroMsg.ChattingUI.AppImp", "app info watcher notify");
            a.this.fhH.ctm().a(null, null);
        }
    };

    public a(p pVar) {
        this.fhH = pVar;
    }

    public final void n(f fVar) {
        if (fVar == null || bi.oN(fVar.field_appId)) {
            x.e("MicroMsg.ChattingUI.AppImp", "jumpServiceH5 error args");
        } else if (bi.oN(fVar.fRR)) {
            x.e("MicroMsg.ChattingUI.AppImp", "ForwardUrl is null");
        } else {
            int size;
            Intent intent;
            Bundle bundle;
            SharedPreferences sharedPreferences = this.fhH.cte().getSharedPreferences(ad.cgf(), 0);
            this.fhH.cte().getContext();
            String d = w.d(sharedPreferences);
            if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                d = Locale.getDefault().toString();
            }
            if (s.eX(this.fhH.csn())) {
                as.Hm();
                q hG = c.Fo().hG(this.fhH.csn());
                if (hG != null) {
                    size = hG.My().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    intent.putExtra("forceHideShare", true);
                    bundle.putString("sendAppMsgToUserName", this.fhH.csW().field_username);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.fRR, Integer.valueOf(size), d}));
                    d.b(this.fhH.cte().getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            intent.putExtra("forceHideShare", true);
            bundle.putString("sendAppMsgToUserName", this.fhH.csW().field_username);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.fRR, Integer.valueOf(size), d}));
            d.b(this.fhH.cte().getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void aM(au auVar) {
        String str = auVar.field_content;
        if (auVar.field_isSend == 0) {
            p pVar = this.fhH;
            int i = auVar.field_isSend;
            if (!pVar.csU() && pVar.csR() && str != null && i == 0) {
                str = bb.hT(str);
            }
        }
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
        f aZ = g.aZ(fV.appId, true);
        if (aZ == null || !p.m(this.fhH.cte().getContext(), aZ.field_packageName)) {
            str = p.w(this.fhH.cte().getContext(), fV.appId, "message");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.fhH.cte().getContext(), "webview", ".ui.tools.WebViewUI", intent);
        } else if (aZ.field_status == 3) {
            x.e("MicroMsg.ChattingUI.AppImp", "requestAppShow fail, app is in blacklist, packageName = " + aZ.field_packageName);
        } else if (!p.b(this.fhH.cte().getContext(), aZ)) {
            x.e("MicroMsg.ChattingUI.AppImp", "The app %s signature is incorrect.", aZ.field_appName);
            Toast.makeText(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.emB, g.a(this.fhH.cte().getContext(), aZ, null)), 1).show();
        } else if (!a(auVar, aZ)) {
            IMediaObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = fV.extInfo;
            if (fV.for != null && fV.for.length() > 0) {
                b Se = an.aqK().Se(fV.for);
                wXAppExtendObject.filePath = Se == null ? null : Se.field_fileFullPath;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = 620823552;
            wXMediaMessage.mediaObject = wXAppExtendObject;
            wXMediaMessage.title = fV.title;
            wXMediaMessage.description = fV.description;
            wXMediaMessage.messageAction = fV.messageAction;
            wXMediaMessage.messageExt = fV.messageExt;
            wXMediaMessage.thumbData = e.d(o.PC().lp(auVar.field_imgPath), 0, -1);
            new com.tencent.mm.ui.chatting.an(this.fhH.cte().getContext()).a(aZ.field_packageName, wXMediaMessage, aZ.field_appId, aZ.field_openId);
        }
    }

    private boolean a(au auVar, f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.ChattingUI.AppImp", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", av(this.fhH.cte().getContext(), "com.tencent.mobileqq"));
        intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        as.Hm();
        Object obj = c.Db().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingUI.AppImp", e, "", new Object[0]);
            }
        }
        try {
            this.fhH.cte().startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String av(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingUI.AppImp", e, "", new Object[0]);
        }
        return null;
    }

    public final void a(com.tencent.mm.pluginsdk.ui.tools.l lVar) {
        bp.HY().c(38, Integer.valueOf(1));
        String str = lVar.filePath;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
        wXMediaMessage.title = new File(str).getName();
        wXMediaMessage.description = bi.by((long) e.bN(str));
        com.tencent.mm.sdk.e.c fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        an.biT().b(fVar, new String[0]);
        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.fhH.csn(), 2, null);
    }
}
