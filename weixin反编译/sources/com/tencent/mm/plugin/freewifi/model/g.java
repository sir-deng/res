package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    int mJZ = 5;

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String mJn;
        final /* synthetic */ String mKc;
        final /* synthetic */ a mKd = null;
        final /* synthetic */ Intent val$intent;

        AnonymousClass2(String str, String str2, Intent intent, a aVar) {
            this.mKc = str;
            this.mJn = str2;
            this.val$intent = intent;
        }

        public final void run() {
            String Bs = g.Bs(this.mKc);
            x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", Bs, this.mKc);
            if (!bi.oN(Bs)) {
                String cI = g.cI(Bs, "res=");
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", cI, Bs);
                if (!bi.oN(cI) && (cI.startsWith("success") || cI.startsWith("already"))) {
                    g.b(this.mJn, 2, this.val$intent);
                    j.aMv().Bx(this.mJn);
                    return;
                }
            }
            g.b(this.mJn, 3, this.val$intent);
        }
    }

    public interface a {
    }

    public interface b {
        void bp(String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int mJc;
        final /* synthetic */ String mJn;
        final /* synthetic */ b mKa;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(String str, Intent intent, b bVar, int i) {
            this.mJn = str;
            this.val$intent = intent;
            this.mKa = bVar;
            this.mJc = i;
        }

        public final void run() {
            int i = g.this.mJZ;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", Integer.valueOf(i2));
                    g.b(this.mJn, 1, this.val$intent);
                    String zS = com.tencent.mm.j.g.Ag().zS();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", zS);
                    if (bi.oN(zS)) {
                        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                        zS = "http://10.1.0.6/redirect";
                    }
                    String Bs = g.Bs(zS);
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", zS, Bs);
                    if (bi.oN(Bs)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", zS, Bs);
                        try {
                            Thread.sleep(500);
                            i = i2;
                        } catch (Exception e) {
                            i = i2;
                        }
                    } else {
                        zS = g.cI(Bs, "auth=");
                        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", zS, Bs);
                        if (bi.oN(zS)) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", Bs);
                            g.b(this.mJn, 3, this.val$intent);
                        }
                        if (this.mKa != null) {
                            this.mKa.bp(zS, this.mJc);
                            return;
                        }
                        return;
                    }
                }
                if (this.mKa != null) {
                    this.mKa.bp(null, this.mJc);
                }
                g.b(this.mJn, 3, this.val$intent);
                return;
            }
        }
    }

    static /* synthetic */ void b(String str, int i, Intent intent) {
        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", str, Integer.valueOf(i));
        if (i == 3) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c Bv = j.aMv().Bv(str);
            if (Bv != null) {
                Bv.field_expiredTime = bi.Wx() - 10;
                boolean c = j.aMv().c(Bv, new String[0]);
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", str, Long.valueOf(Bv.field_expiredTime), Boolean.valueOf(c));
            }
        }
        d.a(str, i, intent);
    }

    static /* synthetic */ String cI(String str, String str2) {
        if (bi.oN(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
        } else {
            String[] split = str.split("\\?");
            String[] split2 = str2.length() > 0 ? split[1].split("&") : split;
            if (split2 != null && split2.length > 0) {
                for (String str3 : split2) {
                    if (str3.startsWith(str2)) {
                        return str3.substring(str2.length());
                    }
                }
            }
        }
        return null;
    }

    static String Bs(String str) {
        HttpURLConnection httpURLConnection;
        Exception e;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e2) {
                    Exception exception = e2;
                    httpURLConnection = httpURLConnection2;
                    e = exception;
                    try {
                        x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
