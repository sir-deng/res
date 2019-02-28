package com.tencent.mm.plugin.appbrand.j;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    private SSLSocketFactory iUm;
    private int jGH;
    private final String jGK;
    protected final ArrayList<com.tencent.mm.plugin.appbrand.s.a.a> jHv = new ArrayList();
    private String mAppId;

    public interface a {
        void C(int i, String str);

        void a(h hVar);

        void e(ByteBuffer byteBuffer);

        void rA(String str);

        void rB(String str);

        void rC(String str);
    }

    public j(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        SSLContext uc = i.uc(str);
        if (uc != null) {
            this.iUm = uc.getSocketFactory();
        }
        this.jGK = str2;
        this.jGH = appBrandSysConfig.iRF;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, int r10, org.json.JSONObject r11, java.util.Map<java.lang.String, java.lang.String> r12, final com.tencent.mm.plugin.appbrand.j.j.a r13) {
        /*
        r8 = this;
        r1 = r8.jHv;
        monitor-enter(r1);
        r0 = r8.jHv;	 Catch:{ all -> 0x0100 }
        r0 = r0.size();	 Catch:{ all -> 0x0100 }
        r2 = r8.jGH;	 Catch:{ all -> 0x0100 }
        if (r0 < r2) goto L_0x001e;
    L_0x000d:
        r0 = "max connected";
        r13.rC(r0);	 Catch:{ all -> 0x0100 }
        r0 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "max connected";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0100 }
        monitor-exit(r1);	 Catch:{ all -> 0x0100 }
    L_0x001d:
        return;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0100 }
        r0 = "url";
        r6 = r11.optString(r0);
        r2 = new java.net.URI;	 Catch:{ Exception -> 0x0103 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0103 }
        r0 = "MicroMsg.AppBrandNetworkWebSocket";
        r1 = "connectSocket, url= %s, timeout = %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r6;
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r10);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        r0 = "User-Agent";
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = r8.jGK;
        r1 = com.tencent.mm.pluginsdk.ui.tools.s.aL(r1, r3);
        r12.put(r0, r1);
        r0 = x(r11);
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 != 0) goto L_0x0070;
    L_0x005b:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r3 = "protocols %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
        r1 = "Sec-WebSocket-Protocol";
        r12.put(r1, r0);
    L_0x0070:
        r0 = r2.getScheme();
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x011f;
    L_0x007a:
        r0 = 0;
    L_0x007b:
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 != 0) goto L_0x0096;
    L_0x0081:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r3 = "Origin %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
        r1 = "Origin";
        r12.put(r1, r0);
    L_0x0096:
        r0 = new com.tencent.mm.plugin.appbrand.j.j$1;	 Catch:{ Exception -> 0x00e0 }
        r3 = new com.tencent.mm.plugin.appbrand.s.b.d;	 Catch:{ Exception -> 0x00e0 }
        r3.<init>();	 Catch:{ Exception -> 0x00e0 }
        r1 = r8;
        r4 = r12;
        r5 = r10;
        r7 = r13;
        r0.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00e0 }
        r0.jeC = r9;	 Catch:{ Exception -> 0x00e0 }
        r1 = "ws://";
        r1 = com.tencent.mm.pluginsdk.ui.tools.s.eL(r6, r1);	 Catch:{ Exception -> 0x00e0 }
        if (r1 == 0) goto L_0x0183;
    L_0x00af:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "url is %s ,user ws connect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e0 }
        r4 = 0;
        r3[r4] = r6;	 Catch:{ Exception -> 0x00e0 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e0 }
        r1 = new java.net.Socket;	 Catch:{ Exception -> 0x00e0 }
        r2 = java.net.Proxy.NO_PROXY;	 Catch:{ Exception -> 0x00e0 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00e0 }
        r0.a(r1);	 Catch:{ Exception -> 0x00e0 }
        r0.connect();	 Catch:{ Exception -> 0x00e0 }
        r8.a(r0);	 Catch:{ Exception -> 0x00e0 }
        r1 = new java.util.Timer;	 Catch:{ Exception -> 0x00e0 }
        r1.<init>();	 Catch:{ Exception -> 0x00e0 }
        r2 = new com.tencent.mm.plugin.appbrand.j.j$2;	 Catch:{ Exception -> 0x00e0 }
        r2.<init>(r13, r0, r1);	 Catch:{ Exception -> 0x00e0 }
        r0.bnp = r1;	 Catch:{ Exception -> 0x00e0 }
        r4 = (long) r10;	 Catch:{ Exception -> 0x00e0 }
        r1.schedule(r2, r4);	 Catch:{ Exception -> 0x00e0 }
        goto L_0x001d;
    L_0x00e0:
        r0 = move-exception;
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "url %s exception %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r6;
        r4 = 1;
        r5 = r0.toString();
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        r0 = r0.getMessage();
        r13.rA(r0);
        goto L_0x001d;
    L_0x0100:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0100 }
        throw r0;
    L_0x0103:
        r0 = move-exception;
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "connect fail : %s ";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r0.toString();
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        r0 = "url not well format";
        r13.rC(r0);
        goto L_0x001d;
    L_0x011f:
        r1 = "wss";
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x0174;
    L_0x0128:
        r0 = "https";
    L_0x012b:
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r3 = "://";
        r1.append(r3);
        r3 = r2.getHost();
        r1.append(r3);
        r3 = r2.getPort();
        r4 = -1;
        if (r3 == r4) goto L_0x015e;
    L_0x0144:
        r4 = "http";
        r4 = r0.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x0151;
    L_0x014d:
        r4 = 80;
        if (r3 == r4) goto L_0x015e;
    L_0x0151:
        r4 = "https";
        r0 = r0.equalsIgnoreCase(r4);
        if (r0 == 0) goto L_0x0181;
    L_0x015a:
        r0 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        if (r3 != r0) goto L_0x0181;
    L_0x015e:
        r0 = 1;
    L_0x015f:
        if (r0 != 0) goto L_0x016e;
    L_0x0161:
        r0 = ":";
        r1.append(r0);
        r0 = r2.getPort();
        r1.append(r0);
    L_0x016e:
        r0 = r1.toString();
        goto L_0x007b;
    L_0x0174:
        r1 = "ws";
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x012b;
    L_0x017d:
        r0 = "http";
        goto L_0x012b;
    L_0x0181:
        r0 = 0;
        goto L_0x015f;
    L_0x0183:
        r1 = "wss://";
        r1 = com.tencent.mm.pluginsdk.ui.tools.s.eL(r6, r1);	 Catch:{ Exception -> 0x00e0 }
        if (r1 == 0) goto L_0x01c7;
    L_0x018c:
        r1 = "MicroMsg.AppBrandNetworkWebSocket";
        r2 = "url is %s ,user wss connect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e0 }
        r4 = 0;
        r3[r4] = r6;	 Catch:{ Exception -> 0x00e0 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e0 }
        r1 = r8.iUm;	 Catch:{ Exception -> 0x00e0 }
        if (r1 == 0) goto L_0x01c0;
    L_0x019f:
        r1 = r8.iUm;	 Catch:{ Exception -> 0x00e0 }
    L_0x01a1:
        r1 = r1.createSocket();	 Catch:{ Exception -> 0x00e0 }
        r0.a(r1);	 Catch:{ Exception -> 0x00e0 }
        r0.connect();	 Catch:{ Exception -> 0x00e0 }
        r8.a(r0);	 Catch:{ Exception -> 0x00e0 }
        r1 = new java.util.Timer;	 Catch:{ Exception -> 0x00e0 }
        r1.<init>();	 Catch:{ Exception -> 0x00e0 }
        r2 = new com.tencent.mm.plugin.appbrand.j.j$3;	 Catch:{ Exception -> 0x00e0 }
        r2.<init>(r13, r0, r1);	 Catch:{ Exception -> 0x00e0 }
        r0.bnp = r1;	 Catch:{ Exception -> 0x00e0 }
        r4 = (long) r10;	 Catch:{ Exception -> 0x00e0 }
        r1.schedule(r2, r4);	 Catch:{ Exception -> 0x00e0 }
        goto L_0x001d;
    L_0x01c0:
        r1 = javax.net.ssl.SSLSocketFactory.getDefault();	 Catch:{ Exception -> 0x00e0 }
        r1 = (javax.net.ssl.SSLSocketFactory) r1;	 Catch:{ Exception -> 0x00e0 }
        goto L_0x01a1;
    L_0x01c7:
        r0 = "MicroMsg.AppBrandNetworkWebSocket";
        r1 = "url error: %s not ws:// or wss://";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00e0 }
        r3 = 0;
        r2[r3] = r6;	 Catch:{ Exception -> 0x00e0 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x00e0 }
        r0 = "url not ws or wss";
        r13.rC(r0);	 Catch:{ Exception -> 0x00e0 }
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.j.j.a(java.lang.String, int, org.json.JSONObject, java.util.Map, com.tencent.mm.plugin.appbrand.j.j$a):void");
    }

    private void a(com.tencent.mm.plugin.appbrand.s.a.a aVar) {
        synchronized (this.jHv) {
            if ("0".equals(aVar.jeC)) {
                this.jHv.clear();
            }
            this.jHv.add(aVar);
        }
    }

    public final synchronized void b(com.tencent.mm.plugin.appbrand.s.a.a aVar) {
        if (aVar != null) {
            synchronized (this.jHv) {
                this.jHv.remove(aVar);
            }
        }
    }

    public static void c(com.tencent.mm.plugin.appbrand.s.a.a aVar) {
        if (aVar != null) {
            Timer timer = aVar.bnp;
            x.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
            if (timer != null) {
                timer.cancel();
                aVar.bnp = null;
            }
        }
    }

    private static String x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterable linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                linkedList.add(optJSONArray.optString(i));
            }
        }
        return !bi.cC(linkedList) ? TextUtils.join(", ", linkedList) : null;
    }

    public final com.tencent.mm.plugin.appbrand.s.a.a uf(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jHv) {
            Iterator it = this.jHv.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.appbrand.s.a.a aVar = (com.tencent.mm.plugin.appbrand.s.a.a) it.next();
                if (str.equals(aVar.jeC)) {
                    return aVar;
                }
            }
            return null;
        }
    }
}
