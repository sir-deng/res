package com.tencent.mm.plugin.appbrand.j;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class c {
    int jGH;
    private SSLContext jGJ;
    private final String jGK;
    protected final ArrayList<String> jGL = new ArrayList();
    protected final ArrayList<d> jGR = new ArrayList();
    private String mAppId;

    public interface a {
        void a(String str, Object obj, int i, JSONObject jSONObject);

        void sX(String str);
    }

    public c(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.jGH = appBrandSysConfig.iRC;
        this.jGK = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.appbrand.j.d r20) {
        /*
        r19 = this;
        r13 = 0;
        r15 = 0;
        r14 = 0;
        r0 = r20;
        r0 = r0.jHc;
        r17 = r0;
        r0 = r20;
        r0 = r0.jHd;
        r16 = r0;
        r12 = 0;
        r11 = 0;
        r0 = r20;
        r0 = r0.jHe;
        r18 = r0;
        if (r18 == 0) goto L_0x005e;
    L_0x0019:
        r0 = r20;
        r2 = r0.mUrl;
        r0 = r18;
        r2 = com.tencent.mm.plugin.appbrand.j.i.a(r0, r2);
        if (r2 != 0) goto L_0x005e;
    L_0x0025:
        r2 = "url not in domain list";
        r0 = r17;
        r0.sX(r2);
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
    L_0x005d:
        return;
    L_0x005e:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "prepare to send https request url is %s method is %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;
        r4[r5] = r6;
        r5 = 1;
        r0 = r20;
        r6 = r0.jHb;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x09b7, SSLHandshakeException -> 0x05ea, FileNotFoundException -> 0x0694, SocketTimeoutException -> 0x073e, Exception -> 0x07f6, all -> 0x08ae }
        r0 = r20;
        r3 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x09b7, SSLHandshakeException -> 0x05ea, FileNotFoundException -> 0x0694, SocketTimeoutException -> 0x073e, Exception -> 0x07f6, all -> 0x08ae }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x09b7, SSLHandshakeException -> 0x05ea, FileNotFoundException -> 0x0694, SocketTimeoutException -> 0x073e, Exception -> 0x07f6, all -> 0x08ae }
        r2 = r2.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x09b7, SSLHandshakeException -> 0x05ea, FileNotFoundException -> 0x0694, SocketTimeoutException -> 0x073e, Exception -> 0x07f6, all -> 0x08ae }
        r0 = r2;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x09b7, SSLHandshakeException -> 0x05ea, FileNotFoundException -> 0x0694, SocketTimeoutException -> 0x073e, Exception -> 0x07f6, all -> 0x08ae }
        r13 = r0;
        r0 = r20;
        r2 = r0.jeC;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r2 != 0) goto L_0x00a3;
    L_0x009f:
        r0 = r20;
        r0.jHh = r13;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
    L_0x00a3:
        if (r13 != 0) goto L_0x00d9;
    L_0x00a5:
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r0.a(r2, r13);
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x00d9:
        r2 = r13 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r2 == 0) goto L_0x0121;
    L_0x00dd:
        r0 = r19;
        r2 = r0.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r2 != 0) goto L_0x00ef;
    L_0x00e3:
        r0 = r19;
        r2 = r0.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = com.tencent.mm.plugin.appbrand.j.i.uc(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r19;
        r0.jGJ = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
    L_0x00ef:
        r0 = r19;
        r2 = r0.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r2 == 0) goto L_0x0104;
    L_0x00f5:
        r0 = r13;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = r0;
        r0 = r19;
        r3 = r0.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = r3.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2.setSSLSocketFactory(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
    L_0x0104:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r4 = "DomainList: ";
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r18;
        com.tencent.mm.plugin.appbrand.j.i.a(r13, r0);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
    L_0x0121:
        r0 = r20;
        r2 = r0.jGZ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r13.setConnectTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r20;
        r2 = r0.jGZ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r13.setReadTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = "charset";
        r3 = "utf-8";
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = 0;
        r13.setInstanceFollowRedirects(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r20;
        r2 = r0.jHb;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r13.setRequestMethod(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = 1;
        r13.setUseCaches(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = "Accept-Encoding";
        r3 = "gzip";
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r16 == 0) goto L_0x021f;
    L_0x0152:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url %s : set header ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = r16.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r5 = r2.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
    L_0x016d:
        r2 = r5.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r2 == 0) goto L_0x021f;
    L_0x0173:
        r2 = r5.next();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r2;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r4 = r0;
        r2 = r4.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = (java.lang.String) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url %s : key:%s ,value %s ";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r7 = 0;
        r0 = r20;
        r8 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r7 = 1;
        r8 = r4.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r7 = 2;
        r4 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        goto L_0x016d;
    L_0x01ac:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        r11 = r12;
    L_0x01b1:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0944 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0944 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "UnsupportedEncodingException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0944 }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0944 }
        r5[r6] = r7;	 Catch:{ all -> 0x0944 }
        r6 = 1;
        r2 = r2.toString();	 Catch:{ all -> 0x0944 }
        r5[r6] = r2;	 Catch:{ all -> 0x0944 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x0944 }
        r2 = "UTF-8 decode error";
        r0 = r17;
        r0.sX(r2);	 Catch:{ all -> 0x0944 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r11;
        r11 = 2;
        r12 = r20.ajf();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x020d;
    L_0x020a:
        r15.close();	 Catch:{ IOException -> 0x05ae, ArrayIndexOutOfBoundsException -> 0x05bd, Throwable -> 0x05cc }
    L_0x020d:
        if (r14 == 0) goto L_0x0212;
    L_0x020f:
        r14.close();	 Catch:{ IOException -> 0x05db }
    L_0x0212:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x021f:
        r2 = "User-Agent";
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r19;
        r4 = r0.jGK;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = com.tencent.mm.pluginsdk.ui.tools.s.aL(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r20;
        r2 = r0.jHb;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = tW(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        if (r2 == 0) goto L_0x026e;
    L_0x023b:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "set post or put";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = "Content-Length";
        r0 = r20;
        r3 = r0.jHa;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = 1;
        r13.setDoOutput(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r2 = r13.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r3.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        r0 = r20;
        r2 = r0.jHa;	 Catch:{ UnsupportedEncodingException -> 0x09be, SSLHandshakeException -> 0x09a3, FileNotFoundException -> 0x0989, SocketTimeoutException -> 0x096f, Exception -> 0x0955, all -> 0x092f }
        r3.write(r2);	 Catch:{ UnsupportedEncodingException -> 0x09be, SSLHandshakeException -> 0x09a3, FileNotFoundException -> 0x0989, SocketTimeoutException -> 0x096f, Exception -> 0x0955, all -> 0x092f }
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x09be, SSLHandshakeException -> 0x09a3, FileNotFoundException -> 0x0989, SocketTimeoutException -> 0x096f, Exception -> 0x0955, all -> 0x092f }
        r3.close();	 Catch:{ UnsupportedEncodingException -> 0x09be, SSLHandshakeException -> 0x09a3, FileNotFoundException -> 0x0989, SocketTimeoutException -> 0x096f, Exception -> 0x0955, all -> 0x092f }
        r14 = r3;
    L_0x026e:
        r10 = r13.getResponseCode();	 Catch:{ IOException -> 0x031d }
    L_0x0272:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "responseCode = %d, url = %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r5 = 1;
        r0 = r20;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 == r2) goto L_0x03ba;
    L_0x0290:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url is %s, failed code: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r5 = 0;
        r0 = r20;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = com.tencent.mm.plugin.appbrand.j.i.lr(r10);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        if (r2 == 0) goto L_0x03ba;
    L_0x02b0:
        r2 = com.tencent.mm.plugin.appbrand.j.i.d(r13);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r0 = r20;
        r3 = r0.jHf;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        if (r4 != 0) goto L_0x03ba;
    L_0x02be:
        if (r3 > 0) goto L_0x0332;
    L_0x02c0:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "reach the max redirect count(%d)";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r5 = 0;
        r6 = 15;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = "ok";
        r3 = "reach the max redirect count 15";
        r4 = c(r13);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r0 = r17;
        r0.a(r2, r3, r10, r4);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = 0;
        r11 = 1;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r0.a(r2, r13);
        if (r14 == 0) goto L_0x0310;
    L_0x030d:
        r14.close();	 Catch:{ IOException -> 0x0324 }
    L_0x0310:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x031d:
        r2 = move-exception;
        r10 = r13.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x099d, FileNotFoundException -> 0x0983, SocketTimeoutException -> 0x0969, Exception -> 0x094f, all -> 0x0929 }
        goto L_0x0272;
    L_0x0324:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0310;
    L_0x0332:
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "redirect(%d) URL(%s) to URL(%s)";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r7 = 1;
        r0 = r20;
        r8 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r7 = 2;
        r6[r7] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r0 = r20;
        r0.mUrl = r2;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = r3 + -1;
        r0 = r20;
        r0.jHf = r2;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "now redirect count = %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r5 = 0;
        r0 = r20;
        r6 = r0.jHf;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r19.a(r20);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = 0;
        r11 = 2;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r0.a(r2, r13);
        if (r14 == 0) goto L_0x039f;
    L_0x039c:
        r14.close();	 Catch:{ IOException -> 0x03ac }
    L_0x039f:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x03ac:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x039f;
    L_0x03ba:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = "gzip";
        r4 = r13.getContentEncoding();	 Catch:{ Exception -> 0x043c, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x043c, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        if (r2 == 0) goto L_0x0437;
    L_0x03cc:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x043c, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r4 = r13.getInputStream();	 Catch:{ Exception -> 0x043c, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x043c, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r15 = r2;
    L_0x03d6:
        r2 = 0;
        if (r15 == 0) goto L_0x09cd;
    L_0x03d9:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r8 = r12;
    L_0x03de:
        r5 = r15.read(r4);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = -1;
        if (r5 == r2) goto L_0x04e8;
    L_0x03e5:
        r0 = r19;
        r2 = r0.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = com.tencent.mm.plugin.appbrand.a.pi(r2);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        if (r2 != 0) goto L_0x048c;
    L_0x03ef:
        r2 = 1;
    L_0x03f0:
        if (r2 == 0) goto L_0x04e1;
    L_0x03f2:
        r2 = "interrupted";
        r0 = r17;
        r0.sX(r2);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r8;
        r11 = 2;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r0.a(r2, r13);
        if (r15 == 0) goto L_0x0425;
    L_0x0422:
        r15.close();	 Catch:{ IOException -> 0x04a5, ArrayIndexOutOfBoundsException -> 0x04b4, Throwable -> 0x04c3 }
    L_0x0425:
        if (r14 == 0) goto L_0x042a;
    L_0x0427:
        r14.close();	 Catch:{ IOException -> 0x04d2 }
    L_0x042a:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x0437:
        r15 = r13.getInputStream();	 Catch:{ Exception -> 0x043c, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        goto L_0x03d6;
    L_0x043c:
        r2 = move-exception;
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "read input stream failed : %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r7 = 0;
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r6[r7] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r2 = "gzip";
        r4 = r13.getContentEncoding();	 Catch:{ Exception -> 0x046f, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x046f, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        if (r2 == 0) goto L_0x0469;
    L_0x045d:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x046f, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r4 = r13.getErrorStream();	 Catch:{ Exception -> 0x046f, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x046f, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        r15 = r2;
        goto L_0x03d6;
    L_0x0469:
        r15 = r13.getErrorStream();	 Catch:{ Exception -> 0x046f, UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, all -> 0x0937 }
        goto L_0x03d6;
    L_0x046f:
        r2 = move-exception;
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "read err stream failed : %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r7 = 0;
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        r6[r7] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0485, SSLHandshakeException -> 0x09aa, FileNotFoundException -> 0x0990, SocketTimeoutException -> 0x0976, Exception -> 0x095c, all -> 0x0937 }
        goto L_0x03d6;
    L_0x0485:
        r2 = move-exception;
        r11 = r12;
        r16 = r13;
        r13 = r10;
        goto L_0x01b1;
    L_0x048c:
        r6 = com.tencent.mm.plugin.appbrand.j.c.AnonymousClass2.iKf;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = r2.itj;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = r2.iKb;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = r2.aaI();	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = r2.ordinal();	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = r6[r2];	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        switch(r2) {
            case 1: goto L_0x04a2;
            case 2: goto L_0x04a2;
            default: goto L_0x049f;
        };
    L_0x049f:
        r2 = 0;
        goto L_0x03f0;
    L_0x04a2:
        r2 = 1;
        goto L_0x03f0;
    L_0x04a5:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0425;
    L_0x04b4:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0425;
    L_0x04c3:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0425;
    L_0x04d2:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x042a;
    L_0x04e1:
        r2 = 0;
        r3.write(r4, r2, r5);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r8 = r8 + r5;
        goto L_0x03de;
    L_0x04e8:
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r15.close();	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = "arraybuffer";
        r0 = r20;
        r4 = r0.jHg;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = r2.equals(r4);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        if (r2 == 0) goto L_0x056a;
    L_0x04fb:
        r2 = r3.toByteArray();	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = java.nio.ByteBuffer.wrap(r2);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
    L_0x0503:
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "url %s : buffer size %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r7 = 0;
        r0 = r20;
        r9 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r6[r7] = r9;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r7 = 1;
        r3 = r3.size();	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r6[r7] = r3;	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        com.tencent.mm.sdk.platformtools.x.v(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
    L_0x0521:
        r3 = "ok";
        r4 = c(r13);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r0 = r17;
        r0.a(r3, r2, r10, r4);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r8;
        r11 = 1;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r0.a(r2, r13);
        if (r15 == 0) goto L_0x0558;
    L_0x0555:
        r15.close();	 Catch:{ IOException -> 0x0576, ArrayIndexOutOfBoundsException -> 0x0584, Throwable -> 0x0592 }
    L_0x0558:
        if (r14 == 0) goto L_0x055d;
    L_0x055a:
        r14.close();	 Catch:{ IOException -> 0x05a0 }
    L_0x055d:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x056a:
        r2 = "UTF-8";
        r2 = r3.toString(r2);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        r2 = com.tencent.mm.plugin.appbrand.r.c.vl(r2);	 Catch:{ UnsupportedEncodingException -> 0x09c6, SSLHandshakeException -> 0x09b0, FileNotFoundException -> 0x0996, SocketTimeoutException -> 0x097c, Exception -> 0x0962, all -> 0x093d }
        goto L_0x0503;
    L_0x0576:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0558;
    L_0x0584:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0558;
    L_0x0592:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0558;
    L_0x05a0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x055d;
    L_0x05ae:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x020d;
    L_0x05bd:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x020d;
    L_0x05cc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x020d;
    L_0x05db:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0212;
    L_0x05ea:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x05ee:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x094a }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x094a }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "SSLHandshakeException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x094a }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x094a }
        r5[r6] = r7;	 Catch:{ all -> 0x094a }
        r6 = 1;
        r2 = r2.toString();	 Catch:{ all -> 0x094a }
        r5[r6] = r2;	 Catch:{ all -> 0x094a }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x094a }
        r2 = "ssl hand shake error";
        r0 = r17;
        r0.sX(r2);	 Catch:{ all -> 0x094a }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.ajf();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x064a;
    L_0x0647:
        r15.close();	 Catch:{ IOException -> 0x065c, ArrayIndexOutOfBoundsException -> 0x066a, Throwable -> 0x0678 }
    L_0x064a:
        if (r14 == 0) goto L_0x064f;
    L_0x064c:
        r14.close();	 Catch:{ IOException -> 0x0686 }
    L_0x064f:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x065c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x064a;
    L_0x066a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x064a;
    L_0x0678:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x064a;
    L_0x0686:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x064f;
    L_0x0694:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x0698:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x094a }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x094a }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "FileNotFoundException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x094a }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x094a }
        r5[r6] = r7;	 Catch:{ all -> 0x094a }
        r6 = 1;
        r2 = r2.toString();	 Catch:{ all -> 0x094a }
        r5[r6] = r2;	 Catch:{ all -> 0x094a }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x094a }
        r2 = "file not exist error";
        r0 = r17;
        r0.sX(r2);	 Catch:{ all -> 0x094a }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.ajf();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x06f4;
    L_0x06f1:
        r15.close();	 Catch:{ IOException -> 0x0706, ArrayIndexOutOfBoundsException -> 0x0714, Throwable -> 0x0722 }
    L_0x06f4:
        if (r14 == 0) goto L_0x06f9;
    L_0x06f6:
        r14.close();	 Catch:{ IOException -> 0x0730 }
    L_0x06f9:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x0706:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06f4;
    L_0x0714:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06f4;
    L_0x0722:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06f4;
    L_0x0730:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06f9;
    L_0x073e:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x0742:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x094a }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x094a }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s, failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x094a }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x094a }
        r5[r6] = r7;	 Catch:{ all -> 0x094a }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x094a }
        r5[r6] = r7;	 Catch:{ all -> 0x094a }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x094a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x094a }
        r3.<init>();	 Catch:{ all -> 0x094a }
        r2 = r2.getMessage();	 Catch:{ all -> 0x094a }
        r2 = r3.append(r2);	 Catch:{ all -> 0x094a }
        r2 = r2.toString();	 Catch:{ all -> 0x094a }
        r0 = r17;
        r0.sX(r2);	 Catch:{ all -> 0x094a }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.ajf();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x07ac;
    L_0x07a9:
        r15.close();	 Catch:{ IOException -> 0x07be, ArrayIndexOutOfBoundsException -> 0x07cc, Throwable -> 0x07da }
    L_0x07ac:
        if (r14 == 0) goto L_0x07b1;
    L_0x07ae:
        r14.close();	 Catch:{ IOException -> 0x07e8 }
    L_0x07b1:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x07be:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07ac;
    L_0x07cc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07ac;
    L_0x07da:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07ac;
    L_0x07e8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07b1;
    L_0x07f6:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x07fa:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x094a }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x094a }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s,failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x094a }
        r6 = 0;
        r0 = r20;
        r7 = r0.mUrl;	 Catch:{ all -> 0x094a }
        r5[r6] = r7;	 Catch:{ all -> 0x094a }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x094a }
        r5[r6] = r7;	 Catch:{ all -> 0x094a }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x094a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x094a }
        r3.<init>();	 Catch:{ all -> 0x094a }
        r2 = r2.getMessage();	 Catch:{ all -> 0x094a }
        r2 = r3.append(r2);	 Catch:{ all -> 0x094a }
        r2 = r2.toString();	 Catch:{ all -> 0x094a }
        r0 = r17;
        r0.sX(r2);	 Catch:{ all -> 0x094a }
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.ajf();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x0864;
    L_0x0861:
        r15.close();	 Catch:{ IOException -> 0x0876, ArrayIndexOutOfBoundsException -> 0x0884, Throwable -> 0x0892 }
    L_0x0864:
        if (r14 == 0) goto L_0x0869;
    L_0x0866:
        r14.close();	 Catch:{ IOException -> 0x08a0 }
    L_0x0869:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        goto L_0x005d;
    L_0x0876:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0864;
    L_0x0884:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0864;
    L_0x0892:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0864;
    L_0x08a0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0869;
    L_0x08ae:
        r2 = move-exception;
        r10 = r11;
        r16 = r13;
        r13 = r2;
    L_0x08b3:
        r0 = r19;
        r2 = r0.mAppId;
        r0 = r20;
        r3 = r0.jHi;
        r0 = r20;
        r4 = r0.jHb;
        r0 = r20;
        r5 = r0.mUrl;
        r6 = r20.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r20.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r20;
        r2 = r0.jeC;
        r0 = r19;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x08e0;
    L_0x08dd:
        r15.close();	 Catch:{ IOException -> 0x08f1, ArrayIndexOutOfBoundsException -> 0x08ff, Throwable -> 0x090d }
    L_0x08e0:
        if (r14 == 0) goto L_0x08e5;
    L_0x08e2:
        r14.close();	 Catch:{ IOException -> 0x091b }
    L_0x08e5:
        r0 = r19;
        r2 = r0.jGL;
        r0 = r20;
        r3 = r0.jeC;
        r2.remove(r3);
        throw r13;
    L_0x08f1:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08e0;
    L_0x08ff:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08e0;
    L_0x090d:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08e0;
    L_0x091b:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08e5;
    L_0x0929:
        r2 = move-exception;
        r10 = r11;
        r16 = r13;
        r13 = r2;
        goto L_0x08b3;
    L_0x092f:
        r2 = move-exception;
        r10 = r11;
        r14 = r3;
        r16 = r13;
        r13 = r2;
        goto L_0x08b3;
    L_0x0937:
        r2 = move-exception;
        r16 = r13;
        r13 = r2;
        goto L_0x08b3;
    L_0x093d:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r2;
        goto L_0x08b3;
    L_0x0944:
        r2 = move-exception;
        r10 = r13;
        r12 = r11;
        r13 = r2;
        goto L_0x08b3;
    L_0x094a:
        r2 = move-exception;
        r10 = r13;
        r13 = r2;
        goto L_0x08b3;
    L_0x094f:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x07fa;
    L_0x0955:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x07fa;
    L_0x095c:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x07fa;
    L_0x0962:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x07fa;
    L_0x0969:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x0742;
    L_0x096f:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x0742;
    L_0x0976:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x0742;
    L_0x097c:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x0742;
    L_0x0983:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x0698;
    L_0x0989:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x0698;
    L_0x0990:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x0698;
    L_0x0996:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x0698;
    L_0x099d:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x05ee;
    L_0x09a3:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x05ee;
    L_0x09aa:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x05ee;
    L_0x09b0:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x05ee;
    L_0x09b7:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        r11 = r12;
        goto L_0x01b1;
    L_0x09be:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        r11 = r12;
        goto L_0x01b1;
    L_0x09c6:
        r2 = move-exception;
        r11 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x01b1;
    L_0x09cd:
        r8 = r12;
        goto L_0x0521;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.j.c.a(com.tencent.mm.plugin.appbrand.j.d):void");
    }

    public final void b(d dVar) {
        x.d("MicroMsg.AppBrandNetworkRequest", "try to abortTask");
        this.jGL.add(dVar.jeC);
        a(dVar.jeC, dVar.jHh);
    }

    public final boolean tT(String str) {
        return this.jGL.contains(str);
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        tR(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    static boolean tW(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE");
    }

    public final void a(j jVar, e eVar, int i, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str, String str2) {
        final j jVar2 = jVar;
        final JSONObject jSONObject2 = jSONObject;
        final e eVar2 = eVar;
        final a aVar2 = aVar;
        final int i2 = i;
        final Map<String, String> map2 = map;
        final ArrayList<String> arrayList2 = arrayList;
        final String str3 = str2;
        final String str4 = str;
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                if (l.a(jVar2, jSONObject2, eVar2)) {
                    String optString = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    Object opt = jSONObject2.opt(SlookAirButtonFrequentContactAdapter.DATA);
                    String optString2 = jSONObject2.optString("method");
                    if (bi.oN(optString2)) {
                        optString2 = "GET";
                    }
                    if (TextUtils.isEmpty(optString)) {
                        aVar2.sX("url is null");
                        return;
                    } else if (URLUtil.isHttpsUrl(optString) || URLUtil.isHttpUrl(optString)) {
                        byte[] bArr = new byte[0];
                        if (opt != null && c.tW(optString2)) {
                            if (opt instanceof String) {
                                bArr = ((String) opt).getBytes(Charset.forName("UTF-8"));
                            } else if (opt instanceof ByteBuffer) {
                                bArr = com.tencent.mm.plugin.appbrand.q.c.j((ByteBuffer) opt);
                            }
                        }
                        synchronized (c.this.jGR) {
                            if (c.this.jGR.size() >= c.this.jGH) {
                                aVar2.sX("max connected");
                                x.i("MicroMsg.AppBrandNetworkRequest", "max connected");
                                return;
                            }
                            x.i("MicroMsg.AppBrandNetworkRequest", "method %s ,url %s timeout %s", optString2, optString, Integer.valueOf(i2));
                            d dVar = new d(optString, bArr, i2, aVar2, optString2);
                            dVar.jHd = map2;
                            dVar.jHe = arrayList2;
                            dVar.jHi = str3;
                            dVar.jHg = jSONObject2.optString("responseType", "text");
                            synchronized (c.this.jGR) {
                                c.this.jGR.add(dVar);
                            }
                            dVar.jeC = str4;
                            c.this.a(dVar);
                            return;
                        }
                    } else {
                        aVar2.sX("request protocol must be http or https");
                        return;
                    }
                }
                aVar2.sX(eVar2.jfn);
            }
        }, "appbrand_request_thread");
    }

    private synchronized void tR(String str) {
        if (str != null) {
            synchronized (this.jGR) {
                Iterator it = this.jGR.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (str.equals(dVar.jeC)) {
                        this.jGR.remove(dVar);
                        break;
                    }
                }
            }
        }
    }

    private static JSONObject c(HttpURLConnection httpURLConnection) {
        JSONObject jSONObject = new JSONObject();
        if (httpURLConnection == null) {
            return jSONObject;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return jSONObject;
        }
        for (Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bi.oN(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (Throwable e) {
                    x.e("MicroMsg.AppBrandNetworkRequest", "put header error : %s", Log.getStackTraceString(e));
                }
            }
        }
        return jSONObject;
    }

    public final d tX(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jGR) {
            Iterator it = this.jGR.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (str.equals(dVar.jeC)) {
                    return dVar;
                }
            }
            return null;
        }
    }
}
