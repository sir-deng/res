package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class i {

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.i$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a vEM;

        AnonymousClass2(a aVar) {
            this.vEM = aVar;
        }

        public final void run() {
            this.vEM.ahO();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.i$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ a vEM;

        AnonymousClass4(a aVar) {
            this.vEM = aVar;
        }

        public final void run() {
            this.vEM.ahO();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.i$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ a vEM;
        final /* synthetic */ int vEN;

        AnonymousClass5(a aVar, int i) {
            this.vEM = aVar;
            this.vEN = i;
        }

        public final void run() {
            this.vEM.vt(this.vEN);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.i$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ a vEM;

        AnonymousClass3(a aVar) {
            this.vEM = aVar;
        }

        public final void run() {
            this.vEM.ahO();
        }
    }

    public interface a {
        void ahO();

        void vt(int i);
    }

    public static void a(final a aVar) {
        as.Dt().F(new Runnable() {
            public final void run() {
                try {
                    a aVar = aVar;
                    x.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
                    as.Hm();
                    String str = (String) c.Db().get(-1535680990, (Object) "");
                    as.Hm();
                    long longValue = new o(bi.e((Integer) c.Db().get(9, null))).longValue();
                    if (bi.oN(str) || longValue == 0) {
                        as.Hm();
                        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
                        x.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
                        ah.y(new AnonymousClass2(aVar));
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                    httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
                    if (httpURLConnection.getResponseCode() >= 300) {
                        httpURLConnection.disconnect();
                        x.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
                        ah.y(new AnonymousClass3(aVar));
                        return;
                    }
                    Map y = bj.y(bi.convertStreamToString(httpURLConnection.getInputStream()), "Response");
                    int i = (y == null || bi.getInt((String) y.get(".Response.error.code"), -1) != 0) ? -1 : bi.getInt((String) y.get(".Response.result.UnreadCount"), -1);
                    if (i < 0) {
                        ah.y(new AnonymousClass4(aVar));
                        return;
                    }
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i));
                    ah.y(new AnonymousClass5(aVar, i));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e, "", new Object[0]);
                    x.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                }
            }
        });
    }
}
