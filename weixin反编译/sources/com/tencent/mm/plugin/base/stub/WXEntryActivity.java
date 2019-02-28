package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.u;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXEntryActivity extends AutoLoginActivity implements e {
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog inI;
    private int kAB;
    private String uC;
    private Uri uri;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class EntryReceiver extends BroadcastReceiver {
        private static ag handler;
        private String appId;
        private String appName;
        private Context context;
        private int kAB;
        private long kBb;
        private String uC;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver r9, android.content.Context r10, android.content.Intent r11) {
            /*
            r8 = 4;
            r2 = 1;
            r3 = 0;
            r9.context = r10;
            r0 = "_mmessage_content";
            r0 = com.tencent.mm.sdk.platformtools.t.j(r11, r0);
            r1 = "_mmessage_support_content_type";
            r4 = com.tencent.mm.sdk.platformtools.t.i(r11, r1);
            r9.kBb = r4;
            r1 = "_mmessage_sdkVersion";
            r1 = com.tencent.mm.sdk.platformtools.t.a(r11, r1, r3);
            r9.kAB = r1;
            r1 = r9.kAB;
            r1 = com.tencent.mm.plugin.base.stub.WXEntryActivity.nr(r1);
            if (r1 != 0) goto L_0x003f;
        L_0x0026:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "sdk version is not supported, sdkVersion = ";
            r1.<init>(r2);
            r2 = r9.kAB;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        L_0x003e:
            return;
        L_0x003f:
            r1 = "_mmessage_appPackage";
            r1 = com.tencent.mm.sdk.platformtools.t.j(r11, r1);
            r9.uC = r1;
            r1 = r9.uC;
            if (r1 == 0) goto L_0x0054;
        L_0x004c:
            r1 = r9.uC;
            r1 = r1.length();
            if (r1 > 0) goto L_0x005e;
        L_0x0054:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "unknown package, ignore";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x005e:
            r1 = "_mmessage_checksum";
            r1 = com.tencent.mm.sdk.platformtools.t.k(r11, r1);
            r4 = r9.kAB;
            r5 = r9.uC;
            r4 = com.tencent.mm.plugin.base.stub.WXEntryActivity.r(r0, r4, r5);
            r1 = com.tencent.mm.plugin.base.stub.WXEntryActivity.checkSumConsistent(r1, r4);
            if (r1 != 0) goto L_0x007d;
        L_0x0073:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "checksum fail";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x007d:
            if (r0 != 0) goto L_0x0089;
        L_0x007f:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "check appid failed, null content";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x0089:
            r0 = android.net.Uri.parse(r0);
            r1 = r0.getAuthority();
            r4 = "appid";
            r0 = r0.getQueryParameter(r4);	 Catch:{ Exception -> 0x00c9 }
            r9.appId = r0;	 Catch:{ Exception -> 0x00c9 }
            r0 = "MicroMsg.WXEntryActivity";
            r4 = new java.lang.StringBuilder;
            r5 = "onReceive, appId = ";
            r4.<init>(r5);
            r5 = r9.appId;
            r4 = r4.append(r5);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.x.i(r0, r4);
            r0 = r9.appId;
            if (r0 == 0) goto L_0x00be;
        L_0x00b6:
            r0 = r9.appId;
            r0 = r0.length();
            if (r0 > 0) goto L_0x00dd;
        L_0x00be:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "invalid appid, ignore";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x00c9:
            r0 = move-exception;
            r1 = "MicroMsg.WXEntryActivity";
            r4 = "init: %s";
            r2 = new java.lang.Object[r2];
            r0 = r0.toString();
            r2[r3] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r1, r4, r2);
            goto L_0x003e;
        L_0x00dd:
            r0 = com.tencent.mm.y.as.Hp();
            if (r0 == 0) goto L_0x00e9;
        L_0x00e3:
            r0 = com.tencent.mm.y.as.Cz();
            if (r0 == 0) goto L_0x00ff;
        L_0x00e9:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "not login, just save the appid : %s";
            r2 = new java.lang.Object[r2];
            r4 = r9.appId;
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.model.app.p.Sq(r0);
            goto L_0x003e;
        L_0x00ff:
            r0 = com.tencent.mm.kernel.g.Do();
            r0 = r0.gRj;
            if (r0 != 0) goto L_0x011d;
        L_0x0107:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "not login accInitializing, just save the appid : %s";
            r2 = new java.lang.Object[r2];
            r4 = r9.appId;
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.model.app.p.Sq(r0);
            goto L_0x003e;
        L_0x011d:
            r0 = "registerapp";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0305;
        L_0x0126:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r4 = "handle app registeration: ";
            r1.<init>(r4);
            r4 = r9.uC;
            r1 = r1.append(r4);
            r4 = ", sdkver=";
            r1 = r1.append(r4);
            r4 = r9.kAB;
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            r0 = com.tencent.mm.y.as.Hp();
            if (r0 != 0) goto L_0x015c;
        L_0x0151:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "no available account";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x015c:
            r0 = r9.appId;
            r4 = com.tencent.mm.pluginsdk.model.app.g.aZ(r0, r2);
            r0 = r9.context;
            r1 = r9.uC;
            r0 = com.tencent.mm.pluginsdk.model.app.p.b(r0, r4, r1);
            if (r0 != 0) goto L_0x0180;
        L_0x016c:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "reg fail, check app fail";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            r0 = com.tencent.mm.pluginsdk.model.app.an.biS();
            r1 = r9.appId;
            r0.Si(r1);
            goto L_0x003e;
        L_0x0180:
            if (r4 == 0) goto L_0x0195;
        L_0x0182:
            r0 = r4.YI();
            if (r0 == 0) goto L_0x0195;
        L_0x0188:
            r0 = com.tencent.mm.pluginsdk.q.a.vjc;
            if (r0 == 0) goto L_0x0195;
        L_0x018c:
            r1 = r9.context;
            r5 = r9.appId;
            r6 = r9.uC;
            r0.o(r1, r5, r6);
        L_0x0195:
            r1 = 0;
            r0 = r9.context;	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r0 = r0.getPackageManager();	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r5 = r9.uC;	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r6 = 0;
            r5 = r0.getApplicationInfo(r5, r6);	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            if (r5 != 0) goto L_0x01cd;
        L_0x01a5:
            r0 = "MicroMsg.WXEntryActivity";
            r5 = "package not installed";
            com.tencent.mm.sdk.platformtools.x.e(r0, r5);	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            goto L_0x003e;
        L_0x01b0:
            r0 = move-exception;
            r1 = "MicroMsg.Crash";
            r2 = "May cause dvmFindCatchBlock crash!";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
            r1 = new java.lang.IncompatibleClassChangeError;
            r2 = "May cause dvmFindCatchBlock crash!";
            r1.<init>(r2);
            r0 = r1.initCause(r0);
            r0 = (java.lang.IncompatibleClassChangeError) r0;
            r0 = (java.lang.IncompatibleClassChangeError) r0;
            throw r0;
        L_0x01cd:
            r6 = r5.loadLabel(r0);	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r6 = r6.toString();	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r9.appName = r6;	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r0 = r5.loadIcon(r0);	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r5 = r0 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            if (r5 == 0) goto L_0x037b;
        L_0x01df:
            r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
            r0 = r0.getBitmap();	 Catch:{ IncompatibleClassChangeError -> 0x01b0, Throwable -> 0x0270 }
        L_0x01e5:
            r1 = r0;
        L_0x01e6:
            if (r4 == 0) goto L_0x0201;
        L_0x01e8:
            com.tencent.mm.pluginsdk.model.app.an.biT();
            r0 = r9.appId;
            if (r0 == 0) goto L_0x01f5;
        L_0x01ef:
            r5 = r0.length();
            if (r5 != 0) goto L_0x027e;
        L_0x01f5:
            r0 = "MicroMsg.AppInfoStorage";
            r5 = "hasIcon, appId is null";
            com.tencent.mm.sdk.platformtools.x.e(r0, r5);
            r0 = r3;
        L_0x01ff:
            if (r0 != 0) goto L_0x020a;
        L_0x0201:
            r0 = com.tencent.mm.pluginsdk.model.app.an.biT();
            r5 = r9.appId;
            r0.t(r5, r1);
        L_0x020a:
            if (r4 != 0) goto L_0x0288;
        L_0x020c:
            r0 = new com.tencent.mm.pluginsdk.model.app.f;
            r0.<init>();
            r1 = r9.appId;
            r0.field_appId = r1;
            r1 = "";
            r0.field_appName = r1;
            r1 = r9.uC;
            r0.field_packageName = r1;
            r0.field_status = r3;
            r1 = r9.context;
            r2 = r9.uC;
            r1 = com.tencent.mm.pluginsdk.model.app.p.aW(r1, r2);
            if (r1 == 0) goto L_0x022c;
        L_0x022a:
            r0.field_signature = r1;
        L_0x022c:
            r2 = java.lang.System.currentTimeMillis();
            r0.field_modifyTime = r2;
            r2 = r9.kBb;
            r0.field_appSupportContentType = r2;
            r1 = com.tencent.mm.pluginsdk.model.app.an.biT();
            r1 = r1.l(r0);
            r2 = r9.appId;
            com.tencent.mm.pluginsdk.ui.tools.b.Tp(r2);
            if (r1 == 0) goto L_0x003e;
        L_0x0245:
            r0 = r0.field_openId;
            r0 = com.tencent.mm.platformtools.t.oN(r0);
            if (r0 == 0) goto L_0x003e;
        L_0x024d:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "handleAppRegisteration, trigger getAppSetting, appId = ";
            r1.<init>(r2);
            r2 = r9.appId;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.d(r0, r1);
            r0 = com.tencent.mm.pluginsdk.model.app.an.biV();
            r1 = r9.appId;
            r0.Pm(r1);
            goto L_0x003e;
        L_0x0270:
            r0 = move-exception;
            r5 = "MicroMsg.WXEntryActivity";
            r6 = "package not installed";
            r7 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r0, r6, r7);
            goto L_0x01e6;
        L_0x027e:
            r0 = com.tencent.mm.pluginsdk.model.app.i.cU(r0, r2);
            r0 = com.tencent.mm.a.e.bO(r0);
            goto L_0x01ff;
        L_0x0288:
            r0 = r4.field_appInfoFlag;
            r0 = r0 & 8192;
            if (r0 == 0) goto L_0x0378;
        L_0x028e:
            r0 = r9.kBb;
            r6 = r4.field_appSupportContentType;
            r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
            if (r0 == 0) goto L_0x0303;
        L_0x0296:
            r0 = r2;
        L_0x0297:
            r6 = r9.kBb;
            r4.field_appSupportContentType = r6;
        L_0x029b:
            r1 = r4.field_status;
            r2 = 2;
            if (r1 == r2) goto L_0x02ab;
        L_0x02a0:
            r1 = r4.field_status;
            r2 = 3;
            if (r1 == r2) goto L_0x02ab;
        L_0x02a5:
            r1 = r4.field_status;
            if (r1 == r8) goto L_0x02ab;
        L_0x02a9:
            if (r0 == 0) goto L_0x02d8;
        L_0x02ab:
            r0 = r4.YI();
            if (r0 != 0) goto L_0x02b6;
        L_0x02b1:
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.ui.tools.b.Tp(r0);
        L_0x02b6:
            r4.field_status = r3;
            r0 = com.tencent.mm.pluginsdk.model.app.an.biT();
            r1 = new java.lang.String[r3];
            r0 = r0.a(r4, r1);
            r1 = "MicroMsg.WXEntryActivity";
            r2 = new java.lang.StringBuilder;
            r3 = "handleAppRegisteration, updateRet = ";
            r2.<init>(r3);
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.x.d(r1, r0);
        L_0x02d8:
            r0 = r4.field_openId;
            r0 = com.tencent.mm.platformtools.t.oN(r0);
            if (r0 == 0) goto L_0x003e;
        L_0x02e0:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "handleAppRegisteration, trigger getAppSetting, appId = ";
            r1.<init>(r2);
            r2 = r9.appId;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.d(r0, r1);
            r0 = com.tencent.mm.pluginsdk.model.app.an.biV();
            r1 = r9.appId;
            r0.Pm(r1);
            goto L_0x003e;
        L_0x0303:
            r0 = r3;
            goto L_0x0297;
        L_0x0305:
            r0 = "unregisterapp";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x003e;
        L_0x030e:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "handle app unregisteration: ";
            r1.<init>(r2);
            r2 = r9.uC;
            r1 = r1.append(r2);
            r2 = ", sdkver=";
            r1 = r1.append(r2);
            r2 = r9.kAB;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.d(r0, r1);
            r0 = com.tencent.mm.y.as.Hp();
            if (r0 != 0) goto L_0x0344;
        L_0x0339:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "no available account";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x0344:
            r0 = r9.appId;
            r0 = com.tencent.mm.pluginsdk.model.app.g.aZ(r0, r3);
            r1 = r9.context;
            r2 = r9.uC;
            r1 = com.tencent.mm.pluginsdk.model.app.p.b(r1, r0, r2);
            if (r1 != 0) goto L_0x035f;
        L_0x0354:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "unreg fail, check app fail";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
            goto L_0x003e;
        L_0x035f:
            if (r0 == 0) goto L_0x003e;
        L_0x0361:
            r1 = r0.field_status;
            r2 = 5;
            if (r1 == r2) goto L_0x003e;
        L_0x0366:
            r0.field_status = r8;
            r1 = com.tencent.mm.pluginsdk.model.app.an.biT();
            r2 = new java.lang.String[r3];
            r1.a(r0, r2);
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.ui.tools.b.Tq(r0);
            goto L_0x003e;
        L_0x0378:
            r0 = r3;
            goto L_0x029b;
        L_0x037b:
            r0 = r1;
            goto L_0x01e5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.a(com.tencent.mm.plugin.base.stub.WXEntryActivity$EntryReceiver, android.content.Context, android.content.Intent):void");
        }

        public void onReceive(final Context context, final Intent intent) {
            if (context != null && intent != null) {
                d.cdJ();
                if (handler == null) {
                    HandlerThread WL = com.tencent.mm.sdk.f.e.WL("WXEntryReceiver");
                    WL.start();
                    handler = new ag(WL.getLooper());
                }
                if (g.Dr().gSp.gSI) {
                    handler.post(new Runnable() {
                        public final void run() {
                            long currentTimeMillis = System.currentTimeMillis();
                            EntryReceiver.a(EntryReceiver.this, context, intent);
                            x.i("MicroMsg.WXEntryActivity", "cost:%s", (System.currentTimeMillis() - currentTimeMillis));
                        }
                    });
                } else {
                    g.Dr().a(new com.tencent.mm.kernel.api.g() {
                        public final void um() {
                            g.Dr().b((com.tencent.mm.kernel.api.g) this);
                            EntryReceiver.a(EntryReceiver.this, context, intent);
                        }

                        public final void aI(boolean z) {
                        }
                    });
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        t.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WXEntryActivity.this.goBack();
                return false;
            }
        });
    }

    private boolean A(Intent intent) {
        this.kAB = t.a(intent, ConstantsAPI.SDK_VERSION, 0);
        this.content = t.j(intent, ConstantsAPI.CONTENT);
        if (this.content == null) {
            return false;
        }
        this.uri = Uri.parse(this.content);
        this.authority = this.uri.getAuthority();
        try {
            this.appId = this.uri.getQueryParameter("appid");
            this.uC = t.j(intent, ConstantsAPI.APP_PACKAGE);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WXEntryActivity", "init: %s", e.toString());
            return false;
        }
    }

    protected final boolean z(Intent intent) {
        if (A(intent)) {
            if (!as.Hp() || as.Cz()) {
                x.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", this.appId);
                p.Sq(this.appId);
            }
            if (!nr(this.kAB)) {
                x.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.kAB);
                finish();
                return false;
            } else if (this.uri == null) {
                x.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                finish();
                return false;
            } else {
                x.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
                if (com.tencent.mm.platformtools.t.oN(this.appId)) {
                    x.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                    finish();
                    return false;
                }
                x.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.uC);
                if (com.tencent.mm.platformtools.t.oN(this.uC)) {
                    x.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    finish();
                    return false;
                } else if (checkSumConsistent(t.k(intent, ConstantsAPI.CHECK_SUM), r(this.content, this.kAB, this.uC))) {
                    return true;
                } else {
                    x.e("MicroMsg.WXEntryActivity", "checksum fail");
                    finish();
                    return false;
                }
            }
        }
        x.e("MicroMsg.WXEntryActivity", "Init failed");
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        x.d("MicroMsg.WXEntryActivity", "postLogin, loginResult = " + aVar);
        A(intent);
        switch (aVar) {
            case LOGIN_OK:
                if (getIntent() == null || getIntent().getExtras() == null) {
                    x.e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
                    finish();
                    return;
                }
                x.i("MicroMsg.WXEntryActivity", "checkCanShare, cmd = %d", Integer.valueOf(t.h(getIntent().getExtras(), "_wxapi_command_type")));
                if (t.h(getIntent().getExtras(), "_wxapi_command_type") == 1) {
                    x.i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
                    h(null);
                    finish();
                    return;
                }
                Req req = new Req(getIntent().getExtras());
                WXMediaMessage wXMediaMessage = req.message;
                if (wXMediaMessage == null) {
                    x.e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
                    h(null);
                    finish();
                    return;
                }
                String format;
                if (wXMediaMessage.getType() == 36) {
                    req.scene = 0;
                }
                int i = req.scene == 2 ? 3 : req.scene == 1 ? 2 : req.scene == 0 ? 1 : 0;
                if (wXMediaMessage.getType() == 1) {
                    WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), wo(wXTextObject.text), "", wXMediaMessage.getType()});
                } else if (wXMediaMessage.getType() == 5) {
                    WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), wo(wXMediaMessage.description), wo(wXWebpageObject.webpageUrl), wXMediaMessage.getType()});
                } else if (wXMediaMessage.getType() == 36) {
                    ((c) g.h(c.class)).a(((WXMiniProgramObject) wXMediaMessage.mediaObject).userName, null);
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&appbrandusername=%s&appbrandpath=%s", new Object[]{this.appId, Integer.valueOf(i), wo(wXMediaMessage.description), wo(r0.webpageUrl), wXMediaMessage.getType(), r0.userName, wo(r0.path)});
                } else {
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), wo(wXMediaMessage.description), "", wXMediaMessage.getType()});
                }
                this.inI = h.a(this.mController.xRr, getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        WXEntryActivity.this.arH();
                        WXEntryActivity.this.finish();
                    }
                });
                as.CN().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
                as.CN().a(new ak(format, 1, new LinkedList()), 0);
                return;
            case LOGIN_CANCEL:
                arH();
                x.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            case LOGIN_FAIL:
                ReportUtil.a(this, ReportUtil.b(t.ah(getIntent()), -1));
                finish();
                x.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                x.e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }

    private static String wo(String str) {
        if (com.tencent.mm.platformtools.t.oN(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str);
        } catch (Exception e) {
            x.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", str, e.getMessage());
            return str;
        }
    }

    private boolean h(k kVar) {
        Intent intent = getIntent();
        x.i("MicroMsg.WXEntryActivity", "dealRequest, cmd = %d, authority = %s", Integer.valueOf(t.h(getIntent().getExtras(), "_wxapi_command_type")), this.authority);
        if (!"sendreq".equals(this.authority) && !"sendresp".equals(this.authority)) {
            x.e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
            return false;
        } else if (as.Hp()) {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.appId, true);
            if (aZ == null) {
                x.w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
                return false;
            } else if (p.b(this, aZ, this.uC)) {
                Req req = new Req(intent.getExtras());
                if (req.scene == 2) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                    intent2.putExtras(intent.getExtras());
                    if (req.message != null && req.message.getType() == 5) {
                        x.d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", aZ.field_appId);
                        String hC = u.hC("app_" + aZ.field_appId);
                        u.GQ().t(hC, true).o("prePublishId", "app_" + aZ.field_appId);
                        intent2.putExtra("reportSessionId", hC);
                    }
                    d.b(this, "favorite", ".ui.FavOpenApiEntry", intent2);
                    return true;
                }
                if (!(kVar == null || req.message == null || req.message.getType() != 7)) {
                    bqb Sx = ((ak) kVar).Sx();
                    if (!(Sx == null || Sx.wYT == null || com.tencent.mm.platformtools.t.oN(Sx.wYT.url))) {
                        x.i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", Sx.wYT.url);
                        req.message.mediaObject = new WXWebpageObject(Sx.wYT.url);
                        Bundle bundle = new Bundle();
                        req.toBundle(bundle);
                        intent.putExtras(bundle);
                    }
                }
                startActivity(new Intent(this, UIEntryStub.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).putExtras(intent.getExtras()));
                return true;
            } else {
                x.e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", this.appId);
                an.biS().Si(this.appId);
                arI();
                AutoLoginActivity.a(this, aZ, this.uC, r3);
                return false;
            }
        } else {
            x.w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dry;
    }

    private static boolean nr(int i) {
        return i >= Build.MIN_SDK_INT;
    }

    private static byte[] r(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.a.g.s(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            x.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            x.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        as.CN().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3;
            ak akVar = (ak) kVar;
            if (akVar.Sx() != null) {
                i3 = akVar.Sx().version;
            } else {
                i3 = 0;
            }
            x.i("MicroMsg.WXEntryActivity", "server appversion = %d", Integer.valueOf(i3));
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.appId, false);
            if (aZ == null) {
                x.e("MicroMsg.WXEntryActivity", "null appinfo");
                com.tencent.mm.plugin.y.a.a.a.biY().HM(this.appId);
            } else {
                x.i("MicroMsg.WXEntryActivity", "local appversion = %d", Integer.valueOf(aZ.field_appVersion));
                if (aZ.field_appVersion < i3) {
                    com.tencent.mm.plugin.y.a.a.a.biY().HM(this.appId);
                }
            }
            h(kVar);
            finish();
        } else if (com.tencent.mm.ui.t.a.a(this, i, i2, null, 4)) {
            x.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
        } else if (com.tencent.mm.kernel.a.Cz()) {
            x.w("MicroMsg.WXEntryActivity", "account is hold, do finish");
            finish();
        } else {
            findViewById(R.h.cJr).setVisibility(0);
            setMMTitle(R.l.ePB);
            TextView textView = (TextView) findViewById(R.h.cNW);
            if (!com.tencent.mm.platformtools.t.oN(str)) {
                if (str.startsWith("autoauth_errmsg_")) {
                    str = str.substring(16);
                }
                if (str.startsWith("<e>")) {
                    Map y = bj.y(str, "e");
                    if (!(y == null || com.tencent.mm.platformtools.t.oN((String) y.get(".e.Content")))) {
                        str = (String) y.get(".e.Content");
                    }
                }
                textView.setText(getString(R.l.ePC, new Object[]{str}));
            }
            Button button = (Button) findViewById(R.h.bLV);
            String l = com.tencent.mm.pluginsdk.model.app.g.l(this, this.appId);
            x.i("MicroMsg.WXEntryActivity", "appName = %s", l);
            if (com.tencent.mm.platformtools.t.oN(l)) {
                button.setText(R.l.ePz);
            } else {
                button.setText(getString(R.l.ePz) + l);
            }
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WXEntryActivity.this.arI();
                    WXEntryActivity.this.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0 || keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        x.i("MicroMsg.WXEntryActivity", "user click back button");
        goBack();
        return true;
    }

    private void goBack() {
        View findViewById = findViewById(R.h.cJr);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            arH();
        } else {
            arI();
        }
    }

    private void arH() {
        ReportUtil.a(this, ReportUtil.b(t.ah(getIntent()), -2));
        finish();
    }

    private void arI() {
        ReportUtil.a(this, ReportUtil.b(t.ah(getIntent()), -6));
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
    }
}
