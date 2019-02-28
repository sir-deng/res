package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.Base64;
import android.view.View;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.utils.NativeLogic;
import com.tencent.mm.plugin.normsg.utils.c;
import com.tencent.mm.plugin.normsg.utils.d;
import com.tencent.mm.plugin.normsg.utils.e;
import com.tencent.mm.plugin.normsg.utils.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import org.xwalk.core.R;

enum b implements com.tencent.mm.plugin.normsg.a.b {
    ;
    
    private static final ah oXS = null;

    private b(String str) {
    }

    static {
        oXS = new ah("NormsgWorker");
    }

    public final String t(boolean z, boolean z2) {
        Context applicationContext = ad.getContext().getApplicationContext();
        String str = applicationContext.getApplicationInfo().sourceDir;
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        int versionCode = getVersionCode();
        int i = bgi() ? 1 : 0;
        int i2 = NativeLogic.bgo() ? 1 : 0;
        int i3 = Debug.isDebuggerConnected() ? 1 : 0;
        g.Do();
        byte[] bR = NativeLogic.bR(str, a.Cn());
        g.Do();
        byte[] i4 = NativeLogic.i(applicationContext, str, a.Cn());
        byte[] dl = NativeLogic.dl(applicationContext);
        String q = c.q(bR, 0, bR.length);
        String q2 = c.q(i4, 0, i4.length);
        String q3 = c.q(dl, 0, dl.length);
        int i5 = (e.oZj || e.oZk || e.oZl) ? 1 : 0;
        String charSequence = applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString();
        String str2 = "";
        if (z) {
            Bundle aZ = com.tencent.mm.lib.riskscanner.a.a.aZ(applicationContext);
            if (aZ != null && aZ.getInt("errCode", -100) == 0) {
                dl = aZ.getByteArray("reqBufferBase64");
                if (dl != null) {
                    str2 = Base64.encodeToString(dl, 2);
                }
            }
        }
        String str3 = "";
        if (z2) {
            str3 = ar(applicationContext, ",");
        }
        Map yY = q.yY();
        long bgr = com.tencent.mm.plugin.normsg.utils.a.bgq().bgr();
        com.tencent.mm.plugin.normsg.utils.a.bgq().bgs();
        Object[][] objArr = new Object[49][];
        objArr[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", Integer.valueOf(i)};
        objArr[1] = new Object[]{"\u001c!4\u00180 24", Integer.valueOf(i2)};
        objArr[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", Integer.valueOf(i3)};
        objArr[3] = new Object[]{"\u000194\u001c4%?i", q};
        objArr[4] = new Object[]{"\u000194\u001c4%?j", q2};
        objArr[5] = new Object[]{"\u000194\u001c4%?k", q3};
        objArr[6] = new Object[]{"\u0013#'\u0006 %?7?", E(yY)};
        objArr[7] = new Object[]{"\u00011%?8\u0012\"\f>*", q.yT()};
        objArr[8] = new Object[]{"\u001e!\u000119\u00002*", q.yU()};
        objArr[9] = new Object[]{"\u0014\u0013\u001a\u0011", q.yL()};
        objArr[10] = new Object[]{"\u0011=6';>2\u0010\u001c", q.getAndroidId()};
        objArr[11] = new Object[]{"\u00029?93\u00061)384", q.yX()};
        objArr[12] = new Object[]{"\u00038>82\u0019:>>4", q.yQ()};
        objArr[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", Integer.valueOf(q.yZ())};
        objArr[14] = new Object[]{"\u001f/+\u0011\u000f", G(yY)};
        objArr[15] = new Object[]{"\u001c,(\b>.", H(yY)};
        objArr[16] = new Object[]{"\u0013#'\u00061%?84", I(yY)};
        objArr[17] = new Object[]{"\r80=\u0017\u0018\u001b", q.yN()};
        objArr[18] = new Object[]{"\u0011!%\u001134 .(<+", F(yY)};
        objArr[19] = new Object[]{"\u000e\r\u0016\u001c", ssid};
        objArr[20] = new Object[]{"\f,\u00144=7", q.aJ(applicationContext)};
        objArr[21] = new Object[]{"\u001e\f\r\u0010\u001c", bssid};
        objArr[22] = new Object[]{"\u001f\r\u0012\u00124?7", bgj()};
        objArr[23] = new Object[]{"\u000e6;\u0015;4=", ad.getPackageName()};
        objArr[24] = new Object[]{"\u001c(57>\u001f\b", y.get("ro.build.fingerprint")};
        objArr[25] = new Object[]{"\u0011%8:3\u0016:;)<", Build.BOARD};
        objArr[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", Build.BOOTLOADER};
        objArr[27] = new Object[]{"\u0011%8:3\u0016';5<", Build.BRAND};
        objArr[28] = new Object[]{"\u0010$9;2\u00111-3:=", Build.DEVICE};
        objArr[29] = new Object[]{"\u001c(57>\u0011\u000f", Build.HARDWARE};
        objArr[30] = new Object[]{"\u0017#><5\u0002!39+<,", Build.PRODUCT};
        objArr[31] = new Object[]{"\u0019 \u000309\"\u00137.", Integer.valueOf(i5)};
        objArr[32] = new Object[]{"\u001879%730((,:*", y.get("ro.product.manufacturer")};
        objArr[33] = new Object[]{"\u0001:<:0\u0018\"5", bgk()};
        objArr[34] = new Object[]{"\u00108(\u000f#)=", bgl()};
        objArr[35] = new Object[]{"\u00153'5\u000798,", com.tencent.mm.compatible.util.e.hbu};
        Object[] objArr2 = new Object[2];
        objArr2[0] = "\u00182!\u0011!'\u00062?";
        objArr2[1] = Integer.valueOf(d.oZd ? 1 : 0);
        objArr[36] = objArr2;
        objArr2 = new Object[2];
        objArr2[0] = "\u001c6%\u000098'\u000e4>:6/";
        objArr2[1] = Integer.valueOf(f.oZm ? 1 : 0);
        objArr[37] = objArr2;
        objArr[38] = new Object[]{"\u00044\"$?::\u00185==", Integer.valueOf(versionCode)};
        objArr[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", ad.getContext().getClassLoader().getClass().getName()};
        objArr[40] = new Object[]{"\u001f-,\u0015;4=", charSequence};
        objArr[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", hg(false)};
        objArr[42] = new Object[]{"\u001a\"9&\u001f,//\u0012&3\u00071! <*", str2};
        objArr[43] = new Object[]{"\u001b3*\u00193-+", Long.valueOf(NativeLogic.bgM())};
        objArr[44] = new Object[]{"\u0002*$ /%%\u000f,/(98!+?;=!+\u00005#(6?8\u0013?+", NativeLogic.Ho(",")};
        objArr[45] = new Object[]{"\u0005!==)'&  \u0017'\"+\"%8\u0015186+", str3};
        objArr[46] = new Object[]{"\u000f./.9:!%/)-7;\u0002,6=6\u001f4/7,", Long.valueOf(bgr)};
        objArr[47] = new Object[]{"\u0015\u0007\u001d\u001d526428\u0013\u001dm", bgm()};
        objArr[48] = new Object[]{"\u0017;?4>'\u00048.,766", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION};
        return a(objArr);
    }

    public final void T(int i, int i2, int i3) {
        Context context = ad.getContext();
        if (i2 <= 0 || i2 > 4) {
            throw new IllegalArgumentException("action invalid: " + i2);
        }
        com.tencent.c.e.a.d.a aVar = new com.tencent.c.e.a.d.a(context, i, i2, (byte) 0);
        long j = (long) (i3 * 1000);
        if (j < com.tencent.c.e.a.a.f.Adk) {
            aVar.AcP = com.tencent.c.e.a.a.f.Adk;
        } else if (j > com.tencent.c.e.a.a.f.Adh * 12) {
            aVar.AcP = com.tencent.c.e.a.a.f.Adh * 12;
        }
        aVar.AcP = j;
        com.tencent.c.e.a.e.cEr().a(new com.tencent.c.e.a.d(aVar, (byte) 0));
    }

    public final String a(Object[][] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st>");
        for (Object[] objArr2 : objArr) {
            String Hm = Hm(Hl((String) objArr2[0]));
            stringBuilder.append('<').append(Hm).append('>').append(Hm(String.valueOf(objArr2[1]))).append('<').append('/').append(Hm).append('>');
        }
        stringBuilder.append("</st>");
        CRC32 crc32 = new CRC32();
        crc32.update(stringBuilder.toString().getBytes());
        stringBuilder.append("<ccdcc>").append(crc32.getValue()).append("</ccdcc>");
        stringBuilder.append("<ccdts>").append(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).append("</ccdts>");
        return stringBuilder.toString();
    }

    public final String Hl(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        return stringBuilder.toString();
    }

    private static String Hm(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    if (charAt <= '~') {
                        stringBuilder.append(charAt);
                        break;
                    }
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public final String up(int i) {
        String str;
        String str2;
        String str3 = "";
        if (g.Do().CF()) {
            str = (String) g.Dq().Db().get(79, (Object) "");
        } else {
            str = str3;
        }
        g.Dt().g(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r10 = this;
                r9 = 0;
                r0 = com.tencent.mm.kernel.g.Do();
                r0 = r0.CF();
                if (r0 != 0) goto L_0x000c;
            L_0x000b:
                return;
            L_0x000c:
                r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0111 }
                r2 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x0111 }
                r3 = r2.getApplicationInfo();	 Catch:{ Exception -> 0x0111 }
                r3 = r3.sourceDir;	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.kernel.g.Do();	 Catch:{ Exception -> 0x0111 }
                r4 = com.tencent.mm.kernel.a.Cn();	 Catch:{ Exception -> 0x0111 }
                r4 = com.tencent.mm.plugin.normsg.utils.NativeLogic.bR(r3, r4);	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.kernel.g.Do();	 Catch:{ Exception -> 0x0111 }
                r5 = com.tencent.mm.kernel.a.Cn();	 Catch:{ Exception -> 0x0111 }
                r2 = com.tencent.mm.plugin.normsg.utils.NativeLogic.i(r2, r3, r5);	 Catch:{ Exception -> 0x0111 }
                r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0111 }
                r6 = r6 - r0;
                r0 = "<k25>%s</k25>";
                r1 = 1;
                r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0111 }
                r3 = 0;
                r5 = 0;
                r8 = r4.length;	 Catch:{ Exception -> 0x0111 }
                r4 = com.tencent.mm.plugin.normsg.utils.c.q(r4, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r1[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r1 = java.lang.String.format(r0, r1);	 Catch:{ Exception -> 0x0111 }
                if (r2 == 0) goto L_0x00ad;
            L_0x004a:
                r0 = r2.length;	 Catch:{ Exception -> 0x0111 }
                r3 = 8;
                if (r0 != r3) goto L_0x011f;
            L_0x004f:
                r0 = 0;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 0;
                r4 = 3;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 3;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = 1;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 1;
                r4 = 2;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 2;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = 4;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 4;
                r4 = 7;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 7;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = 5;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0111 }
                r3 = 5;
                r4 = 6;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0111 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0111 }
                r3 = 6;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0111 }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
                r0.<init>();	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = "<k28>%s</k28><k29>%s</k29>";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0111 }
                r4 = 0;
                r5 = 0;
                r8 = 4;
                r5 = com.tencent.mm.plugin.normsg.utils.c.q(r2, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0111 }
                r4 = 1;
                r5 = 4;
                r8 = 8;
                r2 = com.tencent.mm.plugin.normsg.utils.c.q(r2, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r3[r4] = r2;	 Catch:{ Exception -> 0x0111 }
                r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = r0.toString();	 Catch:{ Exception -> 0x0111 }
            L_0x00ad:
                r0 = "mp.weixin.qq.com";
                r0 = java.net.Inet4Address.getByName(r0);	 Catch:{ Exception -> 0x0145 }
                r0 = r0.getHostAddress();	 Catch:{ Exception -> 0x0145 }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0145 }
                r2.<init>();	 Catch:{ Exception -> 0x0145 }
                r2 = r2.append(r1);	 Catch:{ Exception -> 0x0145 }
                r3 = "<k32>%s</k32>";
                r4 = 1;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0145 }
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bi.oM(r0);	 Catch:{ Exception -> 0x0145 }
                r4[r5] = r0;	 Catch:{ Exception -> 0x0145 }
                r0 = java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x0145 }
                r0 = r2.append(r0);	 Catch:{ Exception -> 0x0145 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0145 }
            L_0x00da:
                r1 = "MicroMsg.NormsgSourceImpl";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
                r3 = "checkSoftType2 [time: ";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0111 }
                r2 = r2.append(r6);	 Catch:{ Exception -> 0x0111 }
                r3 = ", value: ";
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0111 }
                r2 = r2.append(r0);	 Catch:{ Exception -> 0x0111 }
                r3 = "]";
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0111 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.sdk.platformtools.x.i(r1, r2);	 Catch:{ Exception -> 0x0111 }
                r1 = com.tencent.mm.kernel.g.Dq();	 Catch:{ Exception -> 0x0111 }
                r1 = r1.Db();	 Catch:{ Exception -> 0x0111 }
                r2 = 79;
                r1.set(r2, r0);	 Catch:{ Exception -> 0x0111 }
                goto L_0x000b;
            L_0x0111:
                r0 = move-exception;
                r1 = "MicroMsg.NormsgSourceImpl";
                r2 = "Failed checkSoftType2.";
                r3 = new java.lang.Object[r9];
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
                goto L_0x000b;
            L_0x011f:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
                r0.<init>();	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = "<k27>%s</k27>";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0111 }
                r4 = 0;
                r5 = 0;
                r8 = r2.length;	 Catch:{ Exception -> 0x0111 }
                r2 = com.tencent.mm.plugin.normsg.utils.c.q(r2, r5, r8);	 Catch:{ Exception -> 0x0111 }
                r3[r4] = r2;	 Catch:{ Exception -> 0x0111 }
                r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0111 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
                r1 = r0.toString();	 Catch:{ Exception -> 0x0111 }
                goto L_0x00ad;
            L_0x0145:
                r0 = move-exception;
                r2 = "MicroMsg.NormsgSourceImpl";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0111 }
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ Exception -> 0x0111 }
                r4[r5] = r0;	 Catch:{ Exception -> 0x0111 }
                com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ Exception -> 0x0111 }
                r0 = r1;
                goto L_0x00da;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.b.1.run():void");
            }

            public final String toString() {
                return super.toString() + "|checkSoftTypeExtra";
            }
        }, 5000);
        str3 = "";
        if (g.Do().CF()) {
            str2 = g.Dq().gRU.xJQ.xJp ? "1" : "0";
        } else {
            str2 = str3;
        }
        Context applicationContext = ad.getContext().getApplicationContext();
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        int i2 = bgi() ? 1 : 0;
        int i3 = NativeLogic.bgo() ? 1 : 0;
        int i4 = Debug.isDebuggerConnected() ? 1 : 0;
        int i5 = (e.oZj || e.oZk || e.oZl) ? 1 : 0;
        int i6 = d.oZd ? 1 : 0;
        int i7 = f.oZm ? 1 : 0;
        byte[] dl = NativeLogic.dl(applicationContext);
        String q = dl != null ? c.q(dl, 0, dl.length) : "";
        int versionCode = getVersionCode();
        String dc = dc(versionCode, i);
        Map yY = q.yY();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>").append(E(yY)).append("</k1><k2>").append(q.yT()).append("</k2><k3>").append(q.yU()).append("</k3><k4>").append(q.yL()).append("</k4><k5>").append(q.yV()).append("</k5><k6>").append(q.yW()).append("</k6><k7>").append(q.getAndroidId()).append("</k7><k8>").append(q.yX()).append("</k8><k9>").append(q.yQ()).append("</k9><k10>").append(q.yZ()).append("</k10><k11>").append(bi.oM(G(yY))).append("</k11><k12>").append(bi.oM(H(yY))).append("</k12><k13>").append(bi.oM(I(yY))).append("</k13><k14>").append(q.yN()).append("</k14><k15>").append(q.yS()).append("</k15><k16>").append(bi.oM(F(yY))).append("</k16><k18>").append(q).append("</k18><k21>").append(bi.oM(ssid)).append("</k21><k22>").append(bi.oM(q.aJ(applicationContext))).append("</k22><k24>").append(bi.oM(bssid)).append("</k24><k26>").append(i4).append("</k26><k30>").append(bi.oM(bgj())).append("</k30><k33>").append(ad.getPackageName()).append("</k33><k34>").append(bi.oM(y.get("ro.build.fingerprint"))).append("</k34><k35>").append(bi.oM(Build.BOARD)).append("</k35><k36>").append(bi.oM(Build.BOOTLOADER)).append("</k36><k37>").append(bi.oM(Build.BRAND)).append("</k37><k38>").append(bi.oM(Build.DEVICE)).append("</k38><k39>").append(bi.oM(Build.HARDWARE)).append("</k39><k40>").append(bi.oM(Build.PRODUCT)).append("</k40><k41>").append(i5).append("</k41><k42>").append(bi.oM(y.get("ro.product.manufacturer"))).append("</k42><k43>").append(System.getString(ad.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0").append("</k44><k45>").append(bgk()).append("</k45><k46>").append(str2).append("</k46><k47>").append(bgl()).append("</k47><k48>").append(q.yL()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.hbu).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bi.oM(dc)).append("</k58><k59>").append(i).append("</k59></softtype>");
        return stringBuilder.toString();
    }

    private static boolean bgi() {
        Context context = ad.getContext();
        if (context == null) {
            x.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
            return false;
        } else if (Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static String E(Map<String, String> map) {
        String str = (String) map.get("model name");
        if (str == null) {
            return q.yR()[0];
        }
        return str;
    }

    private static String F(Map<String, String> map) {
        String str = (String) map.get("features");
        if (str == null) {
            return (String) map.get("flags");
        }
        return str;
    }

    private static String G(Map<String, String> map) {
        return (String) map.get("hardware");
    }

    private static String H(Map<String, String> map) {
        return (String) map.get("revision");
    }

    private static String I(Map<String, String> map) {
        return (String) map.get("serial");
    }

    private static String bgj() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getExtraInfo();
        }
        return null;
    }

    private static String bgk() {
        String oM = bi.oM(bi.fa(ad.getContext()));
        if (oM.length() > 0) {
            return com.tencent.mm.a.g.s(oM.getBytes());
        }
        return oM;
    }

    private static String dc(int i, int i2) {
        PackageInfo packageInfo;
        String str = "";
        try {
            packageInfo = ad.getContext().getPackageManager().getPackageInfo(ad.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            x.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ad.getPackageName());
        }
        if (packageInfo == null) {
            return str;
        }
        com.tencent.mm.plugin.report.d dVar;
        Object[] objArr;
        try {
            str = com.tencent.mm.c.c.k(new File(packageInfo.applicationInfo.sourceDir));
            if (!bi.oN(str)) {
                return str;
            }
            com.tencent.mm.plugin.report.d.pVE.a(322, 13, 1, true);
            dVar = com.tencent.mm.plugin.report.d.pVE;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4013);
            objArr[1] = String.format("%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            dVar.h(11098, objArr);
            return str;
        } catch (Exception e2) {
            x.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e2.getMessage());
            str = "0";
            com.tencent.mm.plugin.report.d.pVE.a(322, 12, 1, true);
            dVar = com.tencent.mm.plugin.report.d.pVE;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4012);
            objArr[1] = String.format("%s|%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r9.getMessage()});
            dVar.h(11098, objArr);
            return str;
        }
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        try {
            packageInfo = ad.getContext().getPackageManager().getPackageInfo(ad.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            x.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ad.getPackageName());
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    private static String bgl() {
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            return activeNetworkInfo.getSubtype();
        } catch (Throwable e) {
            x.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", bi.i(e));
            return str;
        }
    }

    private static String bgm() {
        Throwable th;
        Closeable bufferedInputStream;
        String s;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(ad.getContext().getPackageCodePath()));
            try {
                byte[] bArr = new byte[102400];
                int i = 0;
                do {
                    int read = bufferedInputStream.read(bArr, i, 102400 - i);
                    if (read < 0) {
                        break;
                    }
                    i += read;
                } while (i < 102400);
                s = com.tencent.mm.a.g.s(bArr);
                bi.d(bufferedInputStream);
                return s;
            } catch (Throwable th2) {
                th = th2;
                bi.d(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = null;
            th = th4;
            bi.d(bufferedInputStream);
            throw th;
        }
    }

    public final String hg(boolean z) {
        Object treeSet = new TreeSet();
        NativeLogic.a(ad.getContext(), treeSet, z);
        StringBuilder stringBuilder = new StringBuilder(8192);
        Iterator it = treeSet.iterator();
        treeSet = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (treeSet != null) {
                treeSet = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public final String bgn() {
        List<PackageInfo> installedPackages = ad.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(8192);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append(10);
        }
        return stringBuilder.toString();
    }

    private String ar(Context context, String str) {
        int i = 1;
        Context context2 = context;
        while (context2 != null) {
            try {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected exception.", new Object[0]);
                return "";
            }
        }
        Method declaredMethod = Class.forName(Hl("\u001c\u0013\u0010T\u001a\u0016\u001d\u0004\u0018\u001d\u0011\\\u001a\u001e\u0005\u000b\u001d\u0002\f\u0006E\u0007\u001aH%\r\u000b\u0006\u0006\u0012(0+9/4:4")).getDeclaredMethod(Hl("./?\u000f\" ;%96\f&/#$,"), new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[0]);
        Class cls = Class.forName(Hl("'+ 1-($a!>b\u0018/;>>50\u00192<07:,\u0013=/3/="));
        Class cls2 = Class.forName(Hl("*&-< %)l,3o\u000f\u0005-+>>*"));
        Method declaredMethod2 = cls.getDeclaredMethod(Hl("3\"\u00199\"0&=;:="), new Class[]{cls2});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(null, new Object[]{invoke});
        cls = Class.forName(Hl("#+=-c\"..&l\u001007/)?"));
        declaredMethod2 = invoke.getClass().getDeclaredMethod(Hl("45%\u00052&#38="), new Class[]{cls});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(invoke, new Object[]{Hl(".<?0;>=")});
        declaredMethod2 = Class.forName(Hl("\u001f\u0013\u0018\t\u0015\u0010\u001cY\u0015\u001a\u001a\u0007\u0017\u001f\u0004A\u001e\u0000B\":\b\u000b\f\u0007\u0002\u0001.\u0003\u000f\u00018;/x\b.,:")).getDeclaredMethod(Hl("3\"\u00199\"0&=;:="), new Class[]{cls2});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(null, new Object[]{invoke});
        cls = Class.forName(Hl("\u001d\u0011\u001a\u000b\u0017\u0012\u001e[\u0015\u0007\u0006_1\u0003\u0002\u0001\u0005\f\u000f\u001d\u0001\u0004\u00045\u0005\u0004\r\u0000\u0007\u0006/<2>9<*"));
        cls2 = Class.forName(Hl("/#(9% ,i'54m\u0001..+;%(\u00127)4"));
        Class cls3 = Class.forName(Hl("\u001a\u0016\u001d\f\u0010\u0015\u0019\\\u0010\u001f\u001f\u0002\u0012\u001a\u0001D\u001b\u0005G'?\r\u000e\t\u0002\u0007\u0004+\u0006\n\u0004=>*"));
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{cls2, cls3});
        declaredConstructor.setAccessible(true);
        invoke = declaredConstructor.newInstance(new Object[]{context2, invoke});
        Method declaredMethod3 = cls.getDeclaredMethod(Hl("*+;\u0001'9?%)*\"$\u0011# 7<9:+"), new Class[]{Integer.TYPE});
        declaredMethod3.setAccessible(true);
        List list = (List) declaredMethod3.invoke(invoke, new Object[]{Integer.valueOf(0)});
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            Object next = it.next();
            if (i2 != 0) {
                i = 0;
            } else {
                stringBuilder.append(str);
                i = i2;
            }
            String str2 = (String) next.getClass().getDeclaredField(Hl("\"03<721\u0015;4=")).get(next);
            next = next.getClass().getDeclaredField(Hl("7%$?;21+722\u00124?7")).get(next);
            Class cls4 = Class.forName(Hl("\u001a\u0016\u001d\f\u0010\u0015\u0019\\\u0010\u001f\u001f\u0002\u0012\u001a\u0001D\u001b\u0005G>\u000e\u000f\u0006\u0003\u0004\u0005(\u0012\u0002\t,4=7"));
            Class cls5 = Class.forName(Hl("\u0019\u0015\u001e\u000f\u0013\u0016\u001a_\u0013\u001c\u001c\u0001\u0011\u0019\u0002G\u0018\u0006D=\r\f\u0005\u0000\u0007\u0006/\u0004\n\u0006\u0001<*"));
            Method declaredMethod4 = cls4.getDeclaredMethod(Hl("<<31\u001864<4"), new Class[]{cls5});
            declaredMethod4.setAccessible(true);
            stringBuilder.append(str2).append('#').append(declaredMethod4.invoke(next, new Object[]{invoke}).toString());
        }
    }

    public final boolean bgo() {
        return NativeLogic.bgo();
    }

    public final boolean b(Object obj, Class cls) {
        return NativeLogic.b(obj, cls);
    }

    public final byte[] bgp() {
        try {
            Context applicationContext = ad.getContext().getApplicationContext();
            String str = applicationContext.getApplicationInfo().sourceDir;
            WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            int versionCode = getVersionCode();
            int i = bgi() ? 1 : 0;
            int i2 = NativeLogic.bgo() ? 1 : 0;
            int i3 = Debug.isDebuggerConnected() ? 1 : 0;
            g.Do();
            byte[] bR = NativeLogic.bR(str, a.Cn());
            g.Do();
            byte[] i4 = NativeLogic.i(applicationContext, str, a.Cn());
            byte[] dl = NativeLogic.dl(applicationContext);
            String q = c.q(bR, 0, bR.length);
            str = c.q(i4, 0, i4.length);
            String q2 = c.q(dl, 0, dl.length);
            int i5 = (e.oZj || e.oZk || e.oZl) ? 1 : 0;
            String charSequence = applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString();
            Map yY = q.yY();
            long bgr = com.tencent.mm.plugin.normsg.utils.a.bgq().bgr();
            com.tencent.mm.plugin.normsg.utils.a.bgq().bgs();
            r15 = new Object[47][];
            r15[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", Integer.valueOf(i)};
            r15[1] = new Object[]{"\u001c!4\u00180 24", Integer.valueOf(i2)};
            r15[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", Integer.valueOf(i3)};
            r15[3] = new Object[]{"\u000194\u001c4%?i", q};
            r15[4] = new Object[]{"\u000194\u001c4%?j", str};
            r15[5] = new Object[]{"\u000194\u001c4%?k", q2};
            r15[6] = new Object[]{"\u0013#'\u0006 %?7?", E(yY)};
            r15[7] = new Object[]{"\u00011%?8\u0012\"\f>*", q.yT()};
            r15[8] = new Object[]{"\u001e!\u000119\u00002*", q.yU()};
            r15[9] = new Object[]{"\u0014\u0013\u001a\u0011", q.yL()};
            r15[10] = new Object[]{"\u0011=6';>2\u0010\u001c", q.getAndroidId()};
            r15[11] = new Object[]{"\u00029?93\u00061)384", q.yX()};
            r15[12] = new Object[]{"\u00038>82\u0019:>>4", q.yQ()};
            r15[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", Integer.valueOf(q.yZ())};
            r15[14] = new Object[]{"\u001f/+\u0011\u000f", G(yY)};
            r15[15] = new Object[]{"\u001c,(\b>.", H(yY)};
            r15[16] = new Object[]{"\u0013#'\u00061%?84", I(yY)};
            r15[17] = new Object[]{"\r80=\u0017\u0018\u001b", q.yN()};
            r15[18] = new Object[]{"\u0011!%\u001134 .(<+", F(yY)};
            r15[19] = new Object[]{"\u000e\r\u0016\u001c", ssid};
            r15[20] = new Object[]{"\f,\u00144=7", q.aJ(applicationContext)};
            r15[21] = new Object[]{"\u001e\f\r\u0010\u001c", bssid};
            r15[22] = new Object[]{"\u001f\r\u0012\u00124?7", bgj()};
            r15[23] = new Object[]{"\u000e6;\u0015;4=", ad.getPackageName()};
            r15[24] = new Object[]{"\u001c(57>\u001f\b", y.get("ro.build.fingerprint")};
            r15[25] = new Object[]{"\u0011%8:3\u0016:;)<", Build.BOARD};
            r15[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", Build.BOOTLOADER};
            r15[27] = new Object[]{"\u0011%8:3\u0016';5<", Build.BRAND};
            r15[28] = new Object[]{"\u0010$9;2\u00111-3:=", Build.DEVICE};
            r15[29] = new Object[]{"\u001c(57>\u0011\u000f", Build.HARDWARE};
            r15[30] = new Object[]{"\u0017#><5\u0002!39+<,", Build.PRODUCT};
            r15[31] = new Object[]{"\u0019 \u000309\"\u00137.", Integer.valueOf(i5)};
            r15[32] = new Object[]{"\u001879%730((,:*", y.get("ro.product.manufacturer")};
            r15[33] = new Object[]{"\u0001:<:0\u0018\"5", bgk()};
            r15[34] = new Object[]{"\u00108(\u000f#)=", bgl()};
            r15[35] = new Object[]{"\u00153'5\u000798,", com.tencent.mm.compatible.util.e.hbu};
            Object[] objArr = new Object[2];
            objArr[0] = "\u00182!\u0011!'\u00062?";
            objArr[1] = Integer.valueOf(d.oZd ? 1 : 0);
            r15[36] = objArr;
            objArr = new Object[2];
            objArr[0] = "\u001c6%\u000098'\u000e4>:6/";
            objArr[1] = Integer.valueOf(f.oZm ? 1 : 0);
            r15[37] = objArr;
            r15[38] = new Object[]{"\u00044\"$?::\u00185==", Integer.valueOf(versionCode)};
            r15[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", ad.getContext().getClassLoader().getClass().getName()};
            r15[40] = new Object[]{"\u001f-,\u0015;4=", charSequence};
            r15[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", hg(true)};
            r15[42] = new Object[]{"\u001b3*\u00193-+", Long.valueOf(NativeLogic.bgM())};
            r15[43] = new Object[]{"\u0002*$ /%%\u000f,/(98!+?;=!+\u00005#(6?8\u0013?+", NativeLogic.Ho(",")};
            r15[44] = new Object[]{"\u000f./.9:!%/)-7;\u0002,6=6\u001f4/7,", Long.valueOf(bgr)};
            r15[45] = new Object[]{"\u0015\u0007\u001d\u001d526428\u0013\u001dm", bgm()};
            r15[46] = new Object[]{"\u0017;?4>'\u00048.,766", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION};
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<st>");
            i5 = 0;
            while (true) {
                i3 = i5;
                if (i3 < 47) {
                    Object[] objArr2 = r15[i3];
                    String Hm = Hm(Hl((String) objArr2[0]));
                    stringBuilder.append('<').append(Hm).append('>').append(Hm(String.valueOf(objArr2[1]))).append('<').append('/').append(Hm).append('>');
                    i5 = i3 + 1;
                } else {
                    stringBuilder.append("</st>");
                    return stringBuilder.toString().getBytes();
                }
            }
        } catch (Throwable th) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            com.tencent.mm.plugin.report.service.g.pWK.c("BriefSecInfoCrash", stringWriter.toString(), null);
            printWriter.close();
            return new byte[0];
        }
    }

    public final boolean bB(Object obj) {
        return NativeLogic.bB(obj);
    }

    public final void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
        NativeLogic.c(view, cls);
    }

    public final void uq(int i) {
        com.tencent.mm.plugin.normsg.utils.a.bgq().uq(i);
    }
}
