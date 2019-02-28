package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

public final class f {
    private int jGH;
    SSLContext jGJ;
    final String jGK;
    protected final ArrayList<String> jGL = new ArrayList();
    private final ArrayList<g> jHk = new ArrayList();
    String mAppId;

    public interface a {
        void c(int i, String str, int i2);

        void g(int i, long j, long j2);

        void sY(String str);
    }

    public class b implements Runnable {
        private g jHl;

        public b(g gVar) {
            this.jHl = gVar;
        }

        public final void run() {
            b(this.jHl);
        }

        private void b(com.tencent.mm.plugin.appbrand.j.g r40) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unknown predecessor block by arg (r16_0 java.io.FileInputStream) in PHI: PHI: (r16_12 java.io.FileInputStream) = (r16_0 java.io.FileInputStream), (r16_0 java.io.FileInputStream), (r16_0 java.io.FileInputStream), (r16_0 java.io.FileInputStream), (r16_0 java.io.FileInputStream), (r16_0 java.io.FileInputStream), (r16_0 java.io.FileInputStream), (r16_22 java.io.FileInputStream) binds: {(r16_0 java.io.FileInputStream)=B:422:0x0f28, (r16_0 java.io.FileInputStream)=B:426:0x0f3a, (r16_0 java.io.FileInputStream)=B:428:0x0f46, (r16_0 java.io.FileInputStream)=B:424:0x0f30, (r16_0 java.io.FileInputStream)=B:420:0x0f20, (r16_0 java.io.FileInputStream)=B:418:0x0f1a, (r16_0 java.io.FileInputStream)=B:66:0x02f3, (r16_22 java.io.FileInputStream)=B:416:0x0f14}
	at jadx.core.dex.instructions.PhiInsn.replaceArg(PhiInsn.java:78)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:222)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r39 = this;
            r0 = r40;
            r0 = r0.mUrl;
            r26 = r0;
            r0 = r40;
            r0 = r0.jHn;
            r27 = r0;
            r0 = r40;
            r0 = r0.mName;
            r19 = r0;
            r0 = r40;
            r5 = r0.mMimeType;
            r4 = "application/octet-stream";
            r6 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
            if (r6 == 0) goto L_0x0093;
        L_0x001f:
            r13 = r4;
        L_0x0020:
            r0 = r40;
            r0 = r0.mFileName;
            r28 = r0;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "uploadFile filename %s";
            r6 = 1;
            r6 = new java.lang.Object[r6];
            r7 = 0;
            r6[r7] = r28;
            com.tencent.mm.sdk.platformtools.x.v(r4, r5, r6);
            r0 = r40;
            r0 = r0.jHo;
            r29 = r0;
            r0 = r40;
            r0 = r0.jHd;
            r30 = r0;
            r23 = 0;
            r24 = 0;
            r22 = 0;
            r20 = 0;
            r0 = r40;
            r4 = r0.jHp;
            r0 = r40;
            r0 = r0.jHe;
            r31 = r0;
            if (r31 == 0) goto L_0x0095;
        L_0x0055:
            r0 = r31;
            r1 = r26;
            r5 = com.tencent.mm.plugin.appbrand.j.i.a(r0, r1);
            if (r5 != 0) goto L_0x0095;
        L_0x005f:
            r5 = "fail:url not in domain list";
            r4.sY(r5);
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r8 = 0;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "not in domain url %s";
            r6 = 1;
            r6 = new java.lang.Object[r6];
            r7 = 0;
            r6[r7] = r26;
            com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        L_0x0092:
            return;
        L_0x0093:
            r13 = r5;
            goto L_0x0020;
        L_0x0095:
            r15 = 0;
            r18 = 0;
            r17 = 0;
            r14 = 0;
            r0 = r40;
            r5 = r0.bgH;
            if (r5 != 0) goto L_0x00cf;
        L_0x00a1:
            r5 = "force_stop!";
            r4.sY(r5);
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r8 = 0;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "force stop!";
            com.tencent.mm.sdk.platformtools.x.e(r4, r5);
            goto L_0x0092;
        L_0x00cf:
            r0 = r40;
            r5 = r0.mUrl;
            r5 = android.webkit.URLUtil.isHttpsUrl(r5);
            if (r5 != 0) goto L_0x0108;
        L_0x00d9:
            r0 = r40;
            r5 = r0.mUrl;
            r5 = android.webkit.URLUtil.isHttpUrl(r5);
            if (r5 != 0) goto L_0x0108;
        L_0x00e3:
            r5 = "uploadFile protocol must be http or https";
            r4.sY(r5);
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r8 = 0;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            goto L_0x0092;
        L_0x0108:
            r32 = "--";
            r6 = java.lang.System.currentTimeMillis();
            r33 = java.lang.Long.toString(r6);
            r34 = "\r\n";
            r25 = "";
            r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r8 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r10 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r12 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r5.a(r6, r8, r10, r12);	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r7 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r7.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r16 = new java.io.FileInputStream;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r0 = r16;	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r0.<init>(r7);	 Catch:{ UnsupportedEncodingException -> 0x0f51, FileNotFoundException -> 0x0f13, SSLHandshakeException -> 0x0ed5, SocketTimeoutException -> 0x0b50, Exception -> 0x0c3d, all -> 0x0d38 }
            r11 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r0 = r26;	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r11.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r5 = r11.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r0 = r5;	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r15 = r0;	 Catch:{ UnsupportedEncodingException -> 0x0f60, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d, all -> 0x0dfa }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r0.jeC;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = com.tencent.mm.sdk.platformtools.bi.oN(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r5 != 0) goto L_0x0150;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x014c:
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0.jHh = r15;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0150:
            r5 = r15 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r5 == 0) goto L_0x018a;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0154:
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r5 != 0) goto L_0x016c;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x015c:
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.plugin.appbrand.j.i.uc(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5.jGJ = r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x016c:
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r5 == 0) goto L_0x018a;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0174:
            r0 = r15;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5.setSSLSocketFactory(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r31;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.plugin.appbrand.j.i.a(r15, r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x018a:
            r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setDoInput(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setDoOutput(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setUseCaches(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r0.jGZ;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setConnectTimeout(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r0.jGZ;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setReadTimeout(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = "POST";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestMethod(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = "Connection";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "Keep-Alive";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = "Accept-Encoding";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "gzip";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "file path = %s, length = %d";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r9 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = r7.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r9 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r36 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = java.lang.Long.valueOf(r36);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.sdk.platformtools.x.i(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setInstanceFollowRedirects(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r30 == 0) goto L_0x0370;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x01e0:
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "url %s : set header ";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r9 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8[r9] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.sdk.platformtools.x.i(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r30.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = r5.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x01f7:
            r5 = r8.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r5 == 0) goto L_0x0370;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x01fd:
            r5 = r8.next();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = (java.util.Map.Entry) r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r9 = "set header for : url %s : key:%s ,value %s ";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = 3;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10[r12] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r14 = r5.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10[r12] = r14;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r14 = r5.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10[r12] = r14;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.sdk.platformtools.x.i(r6, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r5.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r6 != 0) goto L_0x01f7;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x022c:
            r6 = r5.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r6 != 0) goto L_0x01f7;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0238:
            r6 = r5.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.toLowerCase();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r9 = "content-length";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.contains(r9);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r6 == 0) goto L_0x02e1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x024b:
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "not allow to set Content-Length";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            goto L_0x01f7;
        L_0x0255:
            r5 = move-exception;
            r13 = r5;
            r19 = r22;
            r14 = r23;
            r38 = r18;
            r18 = r15;
            r15 = r16;
            r16 = r17;
            r17 = r38;
        L_0x0265:
            r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0e4b }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;	 Catch:{ all -> 0x0e4b }
            r8 = 1;	 Catch:{ all -> 0x0e4b }
            r10 = 1;	 Catch:{ all -> 0x0e4b }
            r12 = 0;	 Catch:{ all -> 0x0e4b }
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0e4b }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ all -> 0x0e4b }
            r6 = "UnsupportEncodingException : %s ,url is %s filepath %s ";	 Catch:{ all -> 0x0e4b }
            r7 = 3;	 Catch:{ all -> 0x0e4b }
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0e4b }
            r8 = 0;	 Catch:{ all -> 0x0e4b }
            r9 = r13.toString();	 Catch:{ all -> 0x0e4b }
            r7[r8] = r9;	 Catch:{ all -> 0x0e4b }
            r8 = 1;	 Catch:{ all -> 0x0e4b }
            r7[r8] = r26;	 Catch:{ all -> 0x0e4b }
            r8 = 2;	 Catch:{ all -> 0x0e4b }
            r7[r8] = r27;	 Catch:{ all -> 0x0e4b }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ all -> 0x0e4b }
            r5 = -1;	 Catch:{ all -> 0x0e4b }
            r6 = "unsupported encoding";	 Catch:{ all -> 0x0e4b }
            r0 = r19;	 Catch:{ all -> 0x0e4b }
            r4.c(r5, r6, r0);	 Catch:{ all -> 0x0e4b }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = (long) r14;
            r13 = 2;
            r14 = r40.ajf();
            r8 = r20;
            r12 = r19;
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r0 = r18;
            r4.a(r5, r0);
            if (r15 == 0) goto L_0x02c8;
        L_0x02c5:
            r15.close();	 Catch:{ Exception -> 0x09fa }
        L_0x02c8:
            if (r16 == 0) goto L_0x02cd;
        L_0x02ca:
            r16.close();	 Catch:{ IOException -> 0x0a16, ArrayIndexOutOfBoundsException -> 0x0a32, Throwable -> 0x0a41 }
        L_0x02cd:
            if (r17 == 0) goto L_0x02d2;
        L_0x02cf:
            r17.close();	 Catch:{ IOException -> 0x0a50 }
        L_0x02d2:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x02e1:
            r6 = r5.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestProperty(r6, r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            goto L_0x01f7;
        L_0x02f2:
            r5 = move-exception;
            r13 = r5;
        L_0x02f4:
            r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0e04 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;	 Catch:{ all -> 0x0e04 }
            r8 = 3;	 Catch:{ all -> 0x0e04 }
            r10 = 1;	 Catch:{ all -> 0x0e04 }
            r12 = 0;	 Catch:{ all -> 0x0e04 }
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0e04 }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ all -> 0x0e04 }
            r6 = "FileNotFoundException : %s ,url is %s filepath %s ";	 Catch:{ all -> 0x0e04 }
            r7 = 3;	 Catch:{ all -> 0x0e04 }
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0e04 }
            r8 = 0;	 Catch:{ all -> 0x0e04 }
            r9 = r13.toString();	 Catch:{ all -> 0x0e04 }
            r7[r8] = r9;	 Catch:{ all -> 0x0e04 }
            r8 = 1;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r26;	 Catch:{ all -> 0x0e04 }
            r8 = 2;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r27;	 Catch:{ all -> 0x0e04 }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ all -> 0x0e04 }
            r5 = -1;	 Catch:{ all -> 0x0e04 }
            r6 = "file not exist";	 Catch:{ all -> 0x0e04 }
            r0 = r22;	 Catch:{ all -> 0x0e04 }
            r4.c(r5, r6, r0);	 Catch:{ all -> 0x0e04 }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r23;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.ajf();
            r8 = r20;
            r12 = r22;
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            if (r16 == 0) goto L_0x0357;
        L_0x0354:
            r16.close();	 Catch:{ Exception -> 0x0a6c }
        L_0x0357:
            if (r17 == 0) goto L_0x035c;
        L_0x0359:
            r17.close();	 Catch:{ IOException -> 0x0a88, ArrayIndexOutOfBoundsException -> 0x0aa4, Throwable -> 0x0ab3 }
        L_0x035c:
            if (r18 == 0) goto L_0x0361;
        L_0x035e:
            r18.close();	 Catch:{ IOException -> 0x0ac2 }
        L_0x0361:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x0370:
            r5 = "User-Agent";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = r8.jGK;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = com.tencent.mm.pluginsdk.ui.tools.s.aL(r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r29 == 0) goto L_0x0551;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0394:
            r5 = "Content-Type";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r14 = "multipart/form-data; boundary=";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6.<init>(r14);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r33;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r29.keySet();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r14 = r5.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x03b4:
            r5 = r14.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r5 == 0) goto L_0x04bd;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x03ba:
            r5 = r14.next();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r29;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r0.get(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r31 = "append form data: key = %s, value = %s";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r35 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r35;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = new java.lang.Object[r0];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r35 = r0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r36 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r35[r36] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r36 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r35[r36] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r1 = r31;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r2 = r35;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r1 = r32;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r1 = r33;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r1 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = r30.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r31 = "Content-Disposition: form-data; name=\"";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30.<init>(r31);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r0.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r30 = "\"";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r30;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            goto L_0x03b4;
        L_0x043f:
            r5 = move-exception;
            r13 = r5;
        L_0x0441:
            r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0e04 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;	 Catch:{ all -> 0x0e04 }
            r8 = 2;	 Catch:{ all -> 0x0e04 }
            r10 = 1;	 Catch:{ all -> 0x0e04 }
            r12 = 0;	 Catch:{ all -> 0x0e04 }
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0e04 }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ all -> 0x0e04 }
            r6 = "SSLHandshakeException : %s ,url is %s filepath %s ";	 Catch:{ all -> 0x0e04 }
            r7 = 3;	 Catch:{ all -> 0x0e04 }
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0e04 }
            r8 = 0;	 Catch:{ all -> 0x0e04 }
            r9 = r13.toString();	 Catch:{ all -> 0x0e04 }
            r7[r8] = r9;	 Catch:{ all -> 0x0e04 }
            r8 = 1;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r26;	 Catch:{ all -> 0x0e04 }
            r8 = 2;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r27;	 Catch:{ all -> 0x0e04 }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ all -> 0x0e04 }
            r5 = -1;	 Catch:{ all -> 0x0e04 }
            r6 = "ssl hand shake error";	 Catch:{ all -> 0x0e04 }
            r0 = r22;	 Catch:{ all -> 0x0e04 }
            r4.c(r5, r6, r0);	 Catch:{ all -> 0x0e04 }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r23;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.ajf();
            r8 = r20;
            r12 = r22;
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            if (r16 == 0) goto L_0x04a4;
        L_0x04a1:
            r16.close();	 Catch:{ Exception -> 0x0ade }
        L_0x04a4:
            if (r17 == 0) goto L_0x04a9;
        L_0x04a6:
            r17.close();	 Catch:{ IOException -> 0x0afa, ArrayIndexOutOfBoundsException -> 0x0b16, Throwable -> 0x0b25 }
        L_0x04a9:
            if (r18 == 0) goto L_0x04ae;
        L_0x04ab:
            r18.close();	 Catch:{ IOException -> 0x0b34 }
        L_0x04ae:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x04bd:
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r32;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r33;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "Content-Disposition: form-data; name=\"";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r19;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "\"; filename=\"";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r28;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "\"";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "Content-Type: ";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r13);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r32;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r33;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r32;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r34;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0551:
            r5 = r10.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = r5.getBytes(r6);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r12.toString();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r5.getBytes(r10);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            if (r6 != 0) goto L_0x056c;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0569:
            r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r6 = new byte[r6];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x056c:
            if (r5 != 0) goto L_0x0fd1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x056e:
            r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r10 = r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
        L_0x0572:
            r5 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = (long) r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = r8 + r12;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r10.length;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = (long) r5;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = r8 + r12;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r12 = "contentLenght = %d";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r13 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r14 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r19 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r13[r14] = r19;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            com.tencent.mm.sdk.platformtools.x.i(r5, r12, r13);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = "Content-Length";	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r8 = java.lang.String.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r15.setRequestProperty(r5, r8);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r19 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r5 = r15.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r19;	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x0255, FileNotFoundException -> 0x02f2, SSLHandshakeException -> 0x043f, SocketTimeoutException -> 0x0e99, Exception -> 0x0e5d }
            r0 = r19;	 Catch:{ UnsupportedEncodingException -> 0x0f72, FileNotFoundException -> 0x0f19, SSLHandshakeException -> 0x0edb, SocketTimeoutException -> 0x0e9d, Exception -> 0x0e61, all -> 0x0e0e }
            r0.write(r6);	 Catch:{ UnsupportedEncodingException -> 0x0f72, FileNotFoundException -> 0x0f19, SSLHandshakeException -> 0x0edb, SocketTimeoutException -> 0x0e9d, Exception -> 0x0e61, all -> 0x0e0e }
            r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ UnsupportedEncodingException -> 0x0f72, FileNotFoundException -> 0x0f19, SSLHandshakeException -> 0x0edb, SocketTimeoutException -> 0x0e9d, Exception -> 0x0e61, all -> 0x0e0e }
            r12 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x0f72, FileNotFoundException -> 0x0f19, SSLHandshakeException -> 0x0edb, SocketTimeoutException -> 0x0e9d, Exception -> 0x0e61, all -> 0x0e0e }
            r28 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0f72, FileNotFoundException -> 0x0f19, SSLHandshakeException -> 0x0edb, SocketTimeoutException -> 0x0e9d, Exception -> 0x0e61, all -> 0x0e0e }
            r8 = r20;
        L_0x05af:
            r0 = r16;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r6 = r0.read(r12);	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = -1;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            if (r6 == r5) goto L_0x06a4;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
        L_0x05b8:
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            if (r5 == 0) goto L_0x06a4;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
        L_0x05be:
            r0 = r39;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = com.tencent.mm.plugin.appbrand.j.f.this;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r5.mAppId;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = com.tencent.mm.plugin.appbrand.a.pi(r5);	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            if (r5 != 0) goto L_0x0614;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
        L_0x05ca:
            r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
        L_0x05cb:
            if (r5 == 0) goto L_0x0661;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
        L_0x05cd:
            r5 = "interrupted";	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r4.sY(r5);	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            r16.close();	 Catch:{ Exception -> 0x062b }
        L_0x0602:
            r19.close();	 Catch:{ IOException -> 0x0646 }
        L_0x0605:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x0614:
            r7 = com.tencent.mm.plugin.appbrand.j.f.AnonymousClass1.iKf;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r5.itj;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r5.iKb;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r5.aaI();	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r5.ordinal();	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = r7[r5];	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            switch(r5) {
                case 1: goto L_0x0629;
                case 2: goto L_0x0629;
                default: goto L_0x0627;
            };
        L_0x0627:
            r5 = 0;
            goto L_0x05cb;
        L_0x0629:
            r5 = 1;
            goto L_0x05cb;
        L_0x062b:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0602;
        L_0x0646:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0605;
        L_0x0661:
            r5 = 0;
            r0 = r19;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r0.write(r12, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r6 = (long) r6;
            r6 = r6 + r8;
            r8 = 0;
            r5 = (r28 > r8 ? 1 : (r28 == r8 ? 0 : -1));
            if (r5 <= 0) goto L_0x0fce;
        L_0x066f:
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r5 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            if (r5 == 0) goto L_0x0fce;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
        L_0x0675:
            r8 = 100;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r8 = r8 * r6;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r8 = r8 / r28;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r5 = (int) r8;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r8 = r28;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r4.g(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r8 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r9 = "uploadSize %d, totalSize %d, percent = %d";	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r13 = 3;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r14 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r18 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r13[r14] = r18;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r14 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r18 = java.lang.Long.valueOf(r28);	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r13[r14] = r18;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r14 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r13[r14] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            com.tencent.mm.sdk.platformtools.x.v(r8, r9, r13);	 Catch:{ UnsupportedEncodingException -> 0x0f94, FileNotFoundException -> 0x0f27, SSLHandshakeException -> 0x0ee9, SocketTimeoutException -> 0x0eab, Exception -> 0x0e6f, all -> 0x0e24 }
            r8 = r6;
            goto L_0x05af;
        L_0x06a4:
            r0 = r19;	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r0.write(r10);	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r19.flush();	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r12 = r15.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0f82, FileNotFoundException -> 0x0f1f, SSLHandshakeException -> 0x0ee1, SocketTimeoutException -> 0x0ea3, Exception -> 0x0e67, all -> 0x0e1a }
            r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r5 == r12) goto L_0x0819;
        L_0x06b4:
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = "code %d  url is %s filepath %s ";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = 3;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = r15.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = java.lang.Integer.valueOf(r13);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7[r10] = r13;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7[r10] = r26;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 2;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7[r10] = r27;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5 = com.tencent.mm.plugin.appbrand.j.i.lr(r12);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            if (r5 == 0) goto L_0x0819;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
        L_0x06d7:
            r5 = com.tencent.mm.plugin.appbrand.j.i.d(r15);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = r0.jHf;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = android.text.TextUtils.isEmpty(r5);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            if (r7 != 0) goto L_0x0819;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
        L_0x06e5:
            if (r6 > 0) goto L_0x0779;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
        L_0x06e7:
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = "reach the max redirect count(%d)";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = 1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11 = 15;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7[r10] = r11;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            com.tencent.mm.sdk.platformtools.x.w(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = "reach the max redirect count 15";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r4.c(r5, r6, r12);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = 0;
            r13 = 1;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            r16.close();	 Catch:{ Exception -> 0x0743 }
        L_0x0731:
            r19.close();	 Catch:{ IOException -> 0x075e }
        L_0x0734:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x0743:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0731;
        L_0x075e:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0734;
        L_0x0779:
            r7 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = "redirect(%d) URL(%s) to URL(%s)";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11 = 3;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r14 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = 1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r14 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = 2;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r11[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            com.tencent.mm.sdk.platformtools.x.i(r7, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0.mUrl = r5;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5 = r6 + -1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0.jHf = r5;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r39.b(r40);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = 0;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            r16.close();	 Catch:{ Exception -> 0x07e3 }
        L_0x07d1:
            r19.close();	 Catch:{ IOException -> 0x07fe }
        L_0x07d4:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x07e3:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x07d1;
        L_0x07fe:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x07d4;
        L_0x0819:
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = "url %s ,start to read response ";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = 1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7[r10] = r26;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5 = "gzip";	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r6 = r15.getContentEncoding();	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            if (r5 == 0) goto L_0x0875;	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
        L_0x0835:
            r5 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r6 = r15.getInputStream();	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r5.<init>(r6);	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r17 = r5;
        L_0x0840:
            if (r17 == 0) goto L_0x0fc8;
        L_0x0842:
            r5 = new java.io.BufferedReader;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r0 = r17;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
        L_0x0853:
            r7 = r5.readLine();	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            if (r7 == 0) goto L_0x08cf;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
        L_0x0859:
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            if (r10 == 0) goto L_0x08cf;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
        L_0x085f:
            r6.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            goto L_0x0853;
        L_0x0863:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r20 = r8;
            r14 = r23;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r12;
            goto L_0x0265;
        L_0x0875:
            r17 = r15.getInputStream();	 Catch:{ Exception -> 0x087a, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            goto L_0x0840;
        L_0x087a:
            r5 = move-exception;
            r6 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = "getInputStream error : %s";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            com.tencent.mm.sdk.platformtools.x.e(r6, r7, r10);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5 = "gzip";	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r6 = r15.getContentEncoding();	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            if (r5 == 0) goto L_0x08a3;	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
        L_0x0897:
            r5 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r6 = r15.getErrorStream();	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r5.<init>(r6);	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            r17 = r5;	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            goto L_0x0840;	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
        L_0x08a3:
            r17 = r15.getErrorStream();	 Catch:{ Exception -> 0x08a8, UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, all -> 0x0e2f }
            goto L_0x0840;
        L_0x08a8:
            r5 = move-exception;
            r6 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = "read err stream failed : %s";	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = 1;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r13 = 0;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r10[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            com.tencent.mm.sdk.platformtools.x.e(r6, r7, r10);	 Catch:{ UnsupportedEncodingException -> 0x08bd, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            goto L_0x0840;
        L_0x08bd:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r20 = r8;
            r14 = r23;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r12;
            goto L_0x0265;
        L_0x08cf:
            r5 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = java.nio.charset.Charset.forName(r6);	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = r5.getBytes(r6);	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r6 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x0863, FileNotFoundException -> 0x0f2f, SSLHandshakeException -> 0x0ef1, SocketTimeoutException -> 0x0eb3, Exception -> 0x0e77, all -> 0x0e2f }
            r7 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r10 = "upload for url : %s, result = %s, statecode = %s";	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r13 = 3;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r14 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r13[r14] = r11;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r11 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r13[r11] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r11 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r14 = java.lang.Integer.valueOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r13[r11] = r14;	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            com.tencent.mm.sdk.platformtools.x.i(r7, r10, r13);	 Catch:{ UnsupportedEncodingException -> 0x0fa6, FileNotFoundException -> 0x0f39, SSLHandshakeException -> 0x0efb, SocketTimeoutException -> 0x0ebd, Exception -> 0x0e81, all -> 0x0e37 }
            r10 = r6;
        L_0x08f9:
            r0 = r40;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r6 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            if (r6 == 0) goto L_0x095c;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
        L_0x08ff:
            r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r4.c(r6, r5, r12);	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r6 = "success : url = %s, filePath = %s";	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r7 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r11 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r7[r11] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r11 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r7[r11] = r27;	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r4 = 1;
        L_0x0916:
            if (r4 == 0) goto L_0x096f;
        L_0x0918:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = (long) r10;
            r13 = 1;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        L_0x0932:
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            r16.close();	 Catch:{ Exception -> 0x098a }
        L_0x0945:
            if (r17 == 0) goto L_0x094a;
        L_0x0947:
            r17.close();	 Catch:{ IOException -> 0x09a5, ArrayIndexOutOfBoundsException -> 0x09c0, Throwable -> 0x09cf }
        L_0x094a:
            r19.close();	 Catch:{ IOException -> 0x09de }
        L_0x094d:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x095c:
            r5 = 0;
            r6 = "force_stop!";	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r4.c(r5, r6, r12);	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r6 = "force stop!";	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0fb7, FileNotFoundException -> 0x0f45, SSLHandshakeException -> 0x0f07, SocketTimeoutException -> 0x0ec9, Exception -> 0x0e8d, all -> 0x0e41 }
            r4 = r24;
            goto L_0x0916;
        L_0x096f:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = (long) r10;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            goto L_0x0932;
        L_0x098a:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0945;
        L_0x09a5:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x094a;
        L_0x09c0:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x094a;
        L_0x09cf:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x094a;
        L_0x09de:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x094d;
        L_0x09fa:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x02c8;
        L_0x0a16:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x02cd;
        L_0x0a32:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x02cd;
        L_0x0a41:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x02cd;
        L_0x0a50:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x02d2;
        L_0x0a6c:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0357;
        L_0x0a88:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x035c;
        L_0x0aa4:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x035c;
        L_0x0ab3:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x035c;
        L_0x0ac2:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0361;
        L_0x0ade:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x04a4;
        L_0x0afa:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x04a9;
        L_0x0b16:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x04a9;
        L_0x0b25:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x04a9;
        L_0x0b34:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x04ae;
        L_0x0b50:
            r5 = move-exception;
            r13 = r5;
            r16 = r14;
        L_0x0b54:
            r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0e04 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;	 Catch:{ all -> 0x0e04 }
            r8 = 4;	 Catch:{ all -> 0x0e04 }
            r10 = 1;	 Catch:{ all -> 0x0e04 }
            r12 = 0;	 Catch:{ all -> 0x0e04 }
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0e04 }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ all -> 0x0e04 }
            r6 = "SocketTimeoutException : %s ,url is %s filepath %s ";	 Catch:{ all -> 0x0e04 }
            r7 = 3;	 Catch:{ all -> 0x0e04 }
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0e04 }
            r8 = 0;	 Catch:{ all -> 0x0e04 }
            r9 = r13.toString();	 Catch:{ all -> 0x0e04 }
            r7[r8] = r9;	 Catch:{ all -> 0x0e04 }
            r8 = 1;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r26;	 Catch:{ all -> 0x0e04 }
            r8 = 2;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r27;	 Catch:{ all -> 0x0e04 }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ all -> 0x0e04 }
            r5 = -1;	 Catch:{ all -> 0x0e04 }
            r6 = "socket timeout error";	 Catch:{ all -> 0x0e04 }
            r0 = r22;	 Catch:{ all -> 0x0e04 }
            r4.c(r5, r6, r0);	 Catch:{ all -> 0x0e04 }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r23;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.ajf();
            r8 = r20;
            r12 = r22;
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            if (r16 == 0) goto L_0x0bb7;
        L_0x0bb4:
            r16.close();	 Catch:{ Exception -> 0x0bd0 }
        L_0x0bb7:
            if (r17 == 0) goto L_0x0bbc;
        L_0x0bb9:
            r17.close();	 Catch:{ IOException -> 0x0beb, ArrayIndexOutOfBoundsException -> 0x0c06, Throwable -> 0x0c14 }
        L_0x0bbc:
            if (r18 == 0) goto L_0x0bc1;
        L_0x0bbe:
            r18.close();	 Catch:{ IOException -> 0x0c22 }
        L_0x0bc1:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x0bd0:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0bb7;
        L_0x0beb:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0bbc;
        L_0x0c06:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x0bbc;
        L_0x0c14:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x0bbc;
        L_0x0c22:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0bc1;
        L_0x0c3d:
            r5 = move-exception;
            r13 = r5;
            r16 = r14;
        L_0x0c41:
            r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x0e04 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;	 Catch:{ all -> 0x0e04 }
            r8 = 5;	 Catch:{ all -> 0x0e04 }
            r10 = 1;	 Catch:{ all -> 0x0e04 }
            r12 = 0;	 Catch:{ all -> 0x0e04 }
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0e04 }
            r5 = "MicroMsg.AppBrandNetworkUpload";	 Catch:{ all -> 0x0e04 }
            r6 = "exception : %s ,url is %s filepath %s ";	 Catch:{ all -> 0x0e04 }
            r7 = 3;	 Catch:{ all -> 0x0e04 }
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0e04 }
            r8 = 0;	 Catch:{ all -> 0x0e04 }
            r9 = r13.toString();	 Catch:{ all -> 0x0e04 }
            r7[r8] = r9;	 Catch:{ all -> 0x0e04 }
            r8 = 1;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r26;	 Catch:{ all -> 0x0e04 }
            r8 = 2;	 Catch:{ all -> 0x0e04 }
            r7[r8] = r27;	 Catch:{ all -> 0x0e04 }
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ all -> 0x0e04 }
            r5 = -1;	 Catch:{ all -> 0x0e04 }
            r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0e04 }
            r6.<init>();	 Catch:{ all -> 0x0e04 }
            r7 = r13.getMessage();	 Catch:{ all -> 0x0e04 }
            r6 = r6.append(r7);	 Catch:{ all -> 0x0e04 }
            r6 = r6.toString();	 Catch:{ all -> 0x0e04 }
            r0 = r22;	 Catch:{ all -> 0x0e04 }
            r4.c(r5, r6, r0);	 Catch:{ all -> 0x0e04 }
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r23;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.ajf();
            r8 = r20;
            r12 = r22;
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r4.a(r5, r15);
            if (r16 == 0) goto L_0x0cb2;
        L_0x0caf:
            r16.close();	 Catch:{ Exception -> 0x0ccb }
        L_0x0cb2:
            if (r17 == 0) goto L_0x0cb7;
        L_0x0cb4:
            r17.close();	 Catch:{ IOException -> 0x0ce6, ArrayIndexOutOfBoundsException -> 0x0d01, Throwable -> 0x0d0f }
        L_0x0cb7:
            if (r18 == 0) goto L_0x0cbc;
        L_0x0cb9:
            r18.close();	 Catch:{ IOException -> 0x0d1d }
        L_0x0cbc:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            goto L_0x0092;
        L_0x0ccb:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0cb2;
        L_0x0ce6:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0cb7;
        L_0x0d01:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x0cb7;
        L_0x0d0f:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x0cb7;
        L_0x0d1d:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0cbc;
        L_0x0d38:
            r4 = move-exception;
            r16 = r14;
            r19 = r15;
            r8 = r20;
            r12 = r22;
            r15 = r4;
        L_0x0d42:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.mAppId;
            r0 = r40;
            r5 = r0.jHi;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r23;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.ajf();
            com.tencent.mm.plugin.appbrand.report.a.j.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.bgH = r4;
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r0 = r40;
            r5 = r0.jeC;
            r0 = r19;
            r4.a(r5, r0);
            if (r16 == 0) goto L_0x0d75;
        L_0x0d72:
            r16.close();	 Catch:{ Exception -> 0x0d8d }
        L_0x0d75:
            if (r17 == 0) goto L_0x0d7a;
        L_0x0d77:
            r17.close();	 Catch:{ IOException -> 0x0da8, ArrayIndexOutOfBoundsException -> 0x0dc3, Throwable -> 0x0dd1 }
        L_0x0d7a:
            if (r18 == 0) goto L_0x0d7f;
        L_0x0d7c:
            r18.close();	 Catch:{ IOException -> 0x0ddf }
        L_0x0d7f:
            r0 = r39;
            r4 = com.tencent.mm.plugin.appbrand.j.f.this;
            r4 = r4.jGL;
            r0 = r40;
            r5 = r0.jeC;
            r4.remove(r5);
            throw r15;
        L_0x0d8d:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0d75;
        L_0x0da8:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0d7a;
        L_0x0dc3:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x0d7a;
        L_0x0dd1:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "";
            r7 = 0;
            r7 = new java.lang.Object[r7];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
            goto L_0x0d7a;
        L_0x0ddf:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x0d7f;
        L_0x0dfa:
            r4 = move-exception;
            r19 = r15;
            r8 = r20;
            r12 = r22;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e04:
            r4 = move-exception;
            r19 = r15;
            r8 = r20;
            r12 = r22;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e0e:
            r4 = move-exception;
            r18 = r19;
            r8 = r20;
            r12 = r22;
            r19 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e1a:
            r4 = move-exception;
            r18 = r19;
            r12 = r22;
            r19 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e24:
            r4 = move-exception;
            r18 = r19;
            r8 = r6;
            r12 = r22;
            r19 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e2f:
            r4 = move-exception;
            r18 = r19;
            r19 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e37:
            r4 = move-exception;
            r18 = r19;
            r23 = r6;
            r19 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e41:
            r4 = move-exception;
            r18 = r19;
            r23 = r10;
            r19 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e4b:
            r4 = move-exception;
            r8 = r20;
            r12 = r19;
            r23 = r14;
            r19 = r18;
            r18 = r17;
            r17 = r16;
            r16 = r15;
            r15 = r4;
            goto L_0x0d42;
        L_0x0e5d:
            r5 = move-exception;
            r13 = r5;
            goto L_0x0c41;
        L_0x0e61:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            goto L_0x0c41;
        L_0x0e67:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            goto L_0x0c41;
        L_0x0e6f:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r6;
            goto L_0x0c41;
        L_0x0e77:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            goto L_0x0c41;
        L_0x0e81:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r6;
            goto L_0x0c41;
        L_0x0e8d:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r10;
            goto L_0x0c41;
        L_0x0e99:
            r5 = move-exception;
            r13 = r5;
            goto L_0x0b54;
        L_0x0e9d:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            goto L_0x0b54;
        L_0x0ea3:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            goto L_0x0b54;
        L_0x0eab:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r6;
            goto L_0x0b54;
        L_0x0eb3:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            goto L_0x0b54;
        L_0x0ebd:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r6;
            goto L_0x0b54;
        L_0x0ec9:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r10;
            goto L_0x0b54;
        L_0x0ed5:
            r5 = move-exception;
            r13 = r5;
            r16 = r14;
            goto L_0x0441;
        L_0x0edb:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            goto L_0x0441;
        L_0x0ee1:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            goto L_0x0441;
        L_0x0ee9:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r6;
            goto L_0x0441;
        L_0x0ef1:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            goto L_0x0441;
        L_0x0efb:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r6;
            goto L_0x0441;
        L_0x0f07:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r10;
            goto L_0x0441;
        L_0x0f13:
            r5 = move-exception;
            r13 = r5;
            r16 = r14;
            goto L_0x02f4;
        L_0x0f19:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            goto L_0x02f4;
        L_0x0f1f:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            goto L_0x02f4;
        L_0x0f27:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r6;
            goto L_0x02f4;
        L_0x0f2f:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            goto L_0x02f4;
        L_0x0f39:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r6;
            goto L_0x02f4;
        L_0x0f45:
            r5 = move-exception;
            r13 = r5;
            r18 = r19;
            r20 = r8;
            r22 = r12;
            r23 = r10;
            goto L_0x02f4;
        L_0x0f51:
            r5 = move-exception;
            r13 = r5;
            r16 = r17;
            r19 = r22;
            r17 = r18;
            r18 = r15;
            r15 = r14;
            r14 = r23;
            goto L_0x0265;
        L_0x0f60:
            r5 = move-exception;
            r13 = r5;
            r19 = r22;
            r14 = r23;
            r38 = r18;
            r18 = r15;
            r15 = r16;
            r16 = r17;
            r17 = r38;
            goto L_0x0265;
        L_0x0f72:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r14 = r23;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r22;
            goto L_0x0265;
        L_0x0f82:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r20 = r8;
            r14 = r23;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r22;
            goto L_0x0265;
        L_0x0f94:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r20 = r6;
            r14 = r23;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r22;
            goto L_0x0265;
        L_0x0fa6:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r20 = r8;
            r14 = r6;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r12;
            goto L_0x0265;
        L_0x0fb7:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r20 = r8;
            r14 = r10;
            r15 = r16;
            r16 = r17;
            r17 = r19;
            r19 = r12;
            goto L_0x0265;
        L_0x0fc8:
            r5 = r25;
            r10 = r23;
            goto L_0x08f9;
        L_0x0fce:
            r8 = r6;
            goto L_0x05af;
        L_0x0fd1:
            r10 = r5;
            goto L_0x0572;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.j.f.b.b(com.tencent.mm.plugin.appbrand.j.g):void");
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.j.f$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iKf = new int[com.tencent.mm.plugin.appbrand.b.a.values().length];

        static {
            try {
                iKf[com.tencent.mm.plugin.appbrand.b.a.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iKf[com.tencent.mm.plugin.appbrand.b.a.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public f(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.jGH = appBrandSysConfig.iRD;
        this.jGK = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, java.lang.String r12, java.lang.String r13, org.json.JSONObject r14, java.util.Map<java.lang.String, java.lang.String> r15, java.util.ArrayList<java.lang.String> r16, com.tencent.mm.plugin.appbrand.j.f.a r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        r10 = this;
        r1 = "url";
        r3 = r14.optString(r1);
        r1 = "name";
        r4 = r14.optString(r1);
        r9 = com.tencent.mm.plugin.appbrand.j.i.w(r14);
        r2 = r10.jHk;
        monitor-enter(r2);
        r1 = r10.jHk;	 Catch:{ all -> 0x004b }
        r1 = r1.size();	 Catch:{ all -> 0x004b }
        r5 = r10.jGH;	 Catch:{ all -> 0x004b }
        if (r1 < r5) goto L_0x0032;
    L_0x001f:
        r1 = "tasked refused max connected";
        r0 = r17;
        r0.sY(r1);	 Catch:{ all -> 0x004b }
        r1 = "MicroMsg.AppBrandNetworkUpload";
        r3 = "max connected";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);	 Catch:{ all -> 0x004b }
        monitor-exit(r2);	 Catch:{ all -> 0x004b }
    L_0x0031:
        return;
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x004b }
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 == 0) goto L_0x004e;
    L_0x0039:
        r1 = "fileName error";
        r0 = r17;
        r0.sY(r1);
        r1 = "MicroMsg.AppBrandNetworkUpload";
        r2 = "fileName error";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        goto L_0x0031;
    L_0x004b:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x004b }
        throw r1;
    L_0x004e:
        r1 = new com.tencent.mm.plugin.appbrand.j.g;
        r2 = r13;
        r5 = r20;
        r6 = r11;
        r7 = r12;
        r8 = r17;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r1.jHo = r9;
        r1.jHd = r15;
        r0 = r16;
        r1.jHe = r0;
        r2 = 1;
        r1.bgH = r2;
        r0 = r18;
        r1.jeC = r0;
        r0 = r19;
        r1.jHi = r0;
        r2 = r10.jHk;
        monitor-enter(r2);
        r3 = r10.jHk;	 Catch:{ all -> 0x0082 }
        r3.add(r1);	 Catch:{ all -> 0x0082 }
        monitor-exit(r2);	 Catch:{ all -> 0x0082 }
        r2 = new com.tencent.mm.plugin.appbrand.j.f$b;
        r2.<init>(r1);
        r1 = "appbrand_upload_thread";
        com.tencent.mm.sdk.f.e.post(r2, r1);
        goto L_0x0031;
    L_0x0082:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0082 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.j.f.a(int, java.lang.String, java.lang.String, org.json.JSONObject, java.util.Map, java.util.ArrayList, com.tencent.mm.plugin.appbrand.j.f$a, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final g tZ(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jHk) {
            Iterator it = this.jHk.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (str.equals(gVar.jeC)) {
                    return gVar;
                }
            }
            return null;
        }
    }

    public final void a(g gVar) {
        if (gVar != null) {
            this.jGL.add(gVar.jeC);
            gVar.bgH = false;
            a(gVar.jeC, gVar.jHh);
        }
    }

    public final boolean tT(String str) {
        return this.jGL.contains(str);
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        if (str != null) {
            synchronized (this.jHk) {
                Iterator it = this.jHk.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (str.equals(gVar.jeC)) {
                        this.jHk.remove(gVar);
                        break;
                    }
                }
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }
}
