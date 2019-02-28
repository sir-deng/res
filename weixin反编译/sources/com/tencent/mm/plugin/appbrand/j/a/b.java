package com.tencent.mm.plugin.appbrand.j.a;

import com.tencent.mm.plugin.appbrand.b.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.SSLContext;

public final class b implements Runnable {
    private String appId;
    public volatile boolean bgH = false;
    private String filename;
    public int gLT = 60000;
    public SSLContext jGJ;
    private final String jGK;
    private final a jHF;
    public Map<String, String> jHG;
    public volatile int jHH;
    private long jHI;
    private HttpURLConnection jHJ;
    public ArrayList<String> jHe;
    private int jHf = 15;
    public String jHi;
    public String jeC;
    private long startTime;
    private String uri;

    /* renamed from: com.tencent.mm.plugin.appbrand.j.a.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iKf = new int[a.values().length];

        static {
            try {
                iKf[a.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iKf[a.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public b(String str, String str2, String str3, String str4, a aVar) {
        this.appId = str;
        this.uri = str2;
        this.filename = str3;
        this.jHF = aVar;
        this.startTime = System.currentTimeMillis();
        this.jGK = str4;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unknown predecessor block by arg (r21_0 java.io.InputStream) in PHI: PHI: (r21_3 java.io.InputStream) = (r21_0 java.io.InputStream), (r21_1 java.io.InputStream), (r21_2 java.io.InputStream), (r21_4 java.io.InputStream), (r21_5 java.io.InputStream), (r21_6 java.io.InputStream) binds: {(r21_0 java.io.InputStream)=B:114:0x0517, (r21_1 java.io.InputStream)=B:129:0x05d5, (r21_2 java.io.InputStream)=B:142:?, (r21_4 java.io.InputStream)=B:136:0x060d, (r21_5 java.io.InputStream)=B:144:?, (r21_6 java.io.InputStream)=B:140:0x0632}
	at jadx.core.dex.instructions.PhiInsn.replaceArg(PhiInsn.java:78)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:222)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r27 = this;
        r0 = r27;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpsUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x000a:
        r0 = r27;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x0014:
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r5 = "downloadFile protocol must be http or https";
        r2.D(r3, r4, r5);
    L_0x0026:
        return;
    L_0x0027:
        r0 = r27;
        r2 = r0.jHe;
        if (r2 == 0) goto L_0x0061;
    L_0x002d:
        r0 = r27;
        r2 = r0.jHe;
        r0 = r27;
        r3 = r0.uri;
        r2 = com.tencent.mm.plugin.appbrand.j.i.a(r2, r3);
        if (r2 != 0) goto L_0x0061;
    L_0x003b:
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r5 = "url not in domain list";
        r2.D(r3, r4, r5);
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r27;
        r6 = r0.uri;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        goto L_0x0026;
    L_0x0061:
        r25 = 0;
        r11 = 0;
        r22 = 0;
        r0 = r27;
        r2 = r0.bgH;
        if (r2 != 0) goto L_0x009b;
    L_0x006c:
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r5 = "force stop";
        r2.D(r3, r4, r5);
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r27.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x0026;
    L_0x009b:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r0.jHI = r2;
        r20 = 0;
        r19 = 0;
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.filename;
        r0 = r27;
        r4 = r0.uri;
        r2.bC(r3, r4);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r8 = 1;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r10 = 0;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r5 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r5.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = "url is %s ,filename is %s , start download";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = 2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r6 = 1;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r5.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0.jHJ = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r2 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r2 == 0) goto L_0x0119;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x00f7:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r2 == 0) goto L_0x0119;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x00fd:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r0.jGJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r3.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setSSLSocketFactory(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r0.jHe;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        com.tencent.mm.plugin.appbrand.j.i.a(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x0119:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = 1;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setDoInput(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r0.gLT;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setConnectTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r0.gLT;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setReadTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = 0;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setInstanceFollowRedirects(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = "Accept-Encoding";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = "gzip";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHG;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r2 == 0) goto L_0x024e;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x0152:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = "url %s : set header ";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = 1;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4[r6] = r5;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHG;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r2.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r6 = r2.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x016d:
        r2 = r6.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r2 == 0) goto L_0x024e;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x0173:
        r2 = r6.next();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = "filename %s : key:%s ,value %s ";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7 = 3;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r8 = 0;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r9 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r8 = 1;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r9 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r8 = 2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r7[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        goto L_0x016d;
    L_0x01ae:
        r2 = move-exception;
        r13 = r19;
        r14 = r20;
        r16 = r22;
        r15 = r11;
        r11 = r25;
    L_0x01b8:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x10e2 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ all -> 0x10e2 }
        r6 = 1;	 Catch:{ all -> 0x10e2 }
        r8 = 1;	 Catch:{ all -> 0x10e2 }
        r10 = 0;	 Catch:{ all -> 0x10e2 }
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x10e2 }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ all -> 0x10e2 }
        r4 = "url is %s ,filename is %s , error is %s";	 Catch:{ all -> 0x10e2 }
        r5 = 3;	 Catch:{ all -> 0x10e2 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x10e2 }
        r6 = 0;	 Catch:{ all -> 0x10e2 }
        r0 = r27;	 Catch:{ all -> 0x10e2 }
        r7 = r0.uri;	 Catch:{ all -> 0x10e2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10e2 }
        r6 = 1;	 Catch:{ all -> 0x10e2 }
        r0 = r27;	 Catch:{ all -> 0x10e2 }
        r7 = r0.filename;	 Catch:{ all -> 0x10e2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10e2 }
        r6 = 2;	 Catch:{ all -> 0x10e2 }
        r2 = r2.toString();	 Catch:{ all -> 0x10e2 }
        r5[r6] = r2;	 Catch:{ all -> 0x10e2 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x10e2 }
        r0 = r27;	 Catch:{ all -> 0x10e2 }
        r2 = r0.jHF;	 Catch:{ all -> 0x10e2 }
        r0 = r27;	 Catch:{ all -> 0x10e2 }
        r3 = r0.filename;	 Catch:{ all -> 0x10e2 }
        r0 = r27;	 Catch:{ all -> 0x10e2 }
        r4 = r0.uri;	 Catch:{ all -> 0x10e2 }
        r5 = "unsupport encoding error";	 Catch:{ all -> 0x10e2 }
        r2.D(r3, r4, r5);	 Catch:{ all -> 0x10e2 }
        if (r11 == 0) goto L_0x0b12;
    L_0x01f9:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r8 = r16;
        r10 = r15;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0234:
        if (r13 == 0) goto L_0x0239;
    L_0x0236:
        r13.close();	 Catch:{ IOException -> 0x0b4f }
    L_0x0239:
        if (r14 == 0) goto L_0x023e;
    L_0x023b:
        r14.close();	 Catch:{ IOException -> 0x0b5e, ArrayIndexOutOfBoundsException -> 0x0b6d, Throwable -> 0x0b7c }
    L_0x023e:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x024e:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = "User-Agent";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r6 = r0.jGK;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.aL(r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r8 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = "Content-Type";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r2.getHeaderField(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.a.TD(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r4 != 0) goto L_0x0391;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x0282:
        r2 = com.tencent.mm.pluginsdk.ui.tools.s.TB(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r26 = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x0288:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r24 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x02a0;
    L_0x0296:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 16;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r10 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x02a0:
        r2 = 28;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = 100;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r24;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r0 < r3) goto L_0x03b0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x02a8:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r24;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r0 >= r3) goto L_0x03b0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x02ae:
        r2 = 20;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x02b0:
        r11 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r12 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r14 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r16 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r18 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r11.a(r12, r14, r16, r18);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = "reportStatusCode:%d, key:%d";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r7 = java.lang.Integer.valueOf(r24);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r24;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r0 == r2) goto L_0x047c;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x02dc:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = "statusCode %s, url is %s ,filename is %s ";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = 3;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = java.lang.Integer.valueOf(r24);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = com.tencent.mm.plugin.appbrand.j.i.lr(r24);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r2 == 0) goto L_0x047c;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x0303:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = com.tencent.mm.plugin.appbrand.j.i.d(r2);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r3 != 0) goto L_0x047c;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x0311:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = r0.jHf;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = r3 + -1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0.jHf = r4;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r3 > 0) goto L_0x0408;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x031d:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = "reach the max redirect count(%d)";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 15;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r26;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r1 = r24;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2.a(r3, r0, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0391:
        r2 = r4.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r5 = "application/octet-stream";	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r2 = r2.contains(r5);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r2 == 0) goto L_0x03aa;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x039c:
        r2 = com.tencent.mm.pluginsdk.ui.tools.s.TB(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        if (r3 != 0) goto L_0x03aa;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x03a6:
        r26 = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        goto L_0x0288;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
    L_0x03aa:
        r2 = r4.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x01ae, FileNotFoundException -> 0x0b8b, SSLHandshakeException -> 0x0c9b, SocketTimeoutException -> 0x0dab, Exception -> 0x0ebb, all -> 0x0fd9 }
        r26 = r2;
        goto L_0x0288;
    L_0x03b0:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        if (r3 != r0) goto L_0x03ba;
    L_0x03b6:
        r2 = 21;
        goto L_0x02b0;
    L_0x03ba:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        if (r0 <= r3) goto L_0x03ca;
    L_0x03c0:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = r24;
        if (r0 >= r3) goto L_0x03ca;
    L_0x03c6:
        r2 = 22;
        goto L_0x02b0;
    L_0x03ca:
        r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r0 = r24;
        if (r3 != r0) goto L_0x03d4;
    L_0x03d0:
        r2 = 23;
        goto L_0x02b0;
    L_0x03d4:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = r24;
        if (r0 < r3) goto L_0x03e4;
    L_0x03da:
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r0 = r24;
        if (r0 >= r3) goto L_0x03e4;
    L_0x03e0:
        r2 = 24;
        goto L_0x02b0;
    L_0x03e4:
        r3 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        r0 = r24;
        if (r3 != r0) goto L_0x03ee;
    L_0x03ea:
        r2 = 25;
        goto L_0x02b0;
    L_0x03ee:
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r0 = r24;
        if (r0 < r3) goto L_0x03fe;
    L_0x03f4:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0 = r24;
        if (r0 >= r3) goto L_0x03fe;
    L_0x03fa:
        r2 = 26;
        goto L_0x02b0;
    L_0x03fe:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0 = r24;
        if (r0 < r3) goto L_0x02b0;
    L_0x0404:
        r2 = 27;
        goto L_0x02b0;
    L_0x0408:
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = "redirect(%d) URL(%s) to URL(%s)";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 3;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r7 = r0.jHf;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0.uri = r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r27.run();	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x047c:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r2 <= 0) goto L_0x0506;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x0486:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = r0.jHH;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r3 <= 0) goto L_0x0506;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x048c:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = r0.jHH;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = r3 * r4;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        if (r2 < r3) goto L_0x0506;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
    L_0x0495:
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = "before actually read stream, contentLength %d exceed limit";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = "exceed max file size";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2.D(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0506:
        r2 = "gzip";	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r27;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = r0.jHJ;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        if (r2 == 0) goto L_0x05c4;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
    L_0x0517:
        r21 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r27;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r0.jHJ;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r21;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
    L_0x0526:
        r3 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r3.exists();	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 == 0) goto L_0x0677;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0535:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = "exists temp file ,filename is %s ";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r3.delete();	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 != 0) goto L_0x0677;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x054e:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = "exists temp file delete failed, filename is %s ";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = 1;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = "exists temp file delete failed";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2.D(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        if (r21 == 0) goto L_0x05b4;
    L_0x05b1:
        r21.close();	 Catch:{ IOException -> 0x064a, ArrayIndexOutOfBoundsException -> 0x0659, Throwable -> 0x0668 }
    L_0x05b4:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x05c4:
        r2 = "deflate";	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r27;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = r0.jHJ;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        if (r2 == 0) goto L_0x0636;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
    L_0x05d5:
        r21 = new java.util.zip.InflaterInputStream;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r27;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r0.jHJ;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = new java.util.zip.Inflater;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r4 = 1;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r21;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        goto L_0x0526;
    L_0x05ec:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = "getInputStream error : %s";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = "gzip";	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r27;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = r0.jHJ;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        if (r2 == 0) goto L_0x0640;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
    L_0x060d:
        r21 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r27;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r0.jHJ;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r2.getErrorStream();	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0 = r21;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        goto L_0x0526;
    L_0x061e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r4 = "read err stream failed : %s";	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117, Exception -> 0x10ef }
        r21 = r20;
        goto L_0x0526;
    L_0x0636:
        r0 = r27;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r0.jHJ;	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r21 = r2.getInputStream();	 Catch:{ Exception -> 0x05ec, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        goto L_0x0526;
    L_0x0640:
        r0 = r27;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r2 = r0.jHJ;	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        r21 = r2.getErrorStream();	 Catch:{ Exception -> 0x061e, UnsupportedEncodingException -> 0x118f, FileNotFoundException -> 0x1167, SSLHandshakeException -> 0x113f, SocketTimeoutException -> 0x1117 }
        goto L_0x0526;
    L_0x064a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x05b4;
    L_0x0659:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x05b4;
    L_0x0668:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x05b4;
    L_0x0677:
        r2 = r3.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r2.exists();	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 != 0) goto L_0x073e;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0681:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = "create file ,filename is %s ";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r3.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r2.mkdirs();	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 != 0) goto L_0x073e;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x069e:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = "create file  getParentFile failed, filename is %s ";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = 1;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = "getParentFile failed";	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2.D(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        if (r21 == 0) goto L_0x0704;
    L_0x0701:
        r21.close();	 Catch:{ IOException -> 0x0714, ArrayIndexOutOfBoundsException -> 0x0722, Throwable -> 0x0730 }
    L_0x0704:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0714:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0704;
    L_0x0722:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0704;
    L_0x0730:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0704;
    L_0x073e:
        if (r21 == 0) goto L_0x093d;
    L_0x0740:
        r20 = new java.io.FileOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r20;	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x119c, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r10 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x11a9, FileNotFoundException -> 0x116f, SSLHandshakeException -> 0x1147, SocketTimeoutException -> 0x111f, Exception -> 0x10f7, all -> 0x10b4 }
        r14 = r22;
    L_0x074d:
        r0 = r21;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r4 = r0.read(r10);	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = -1;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        if (r4 == r2) goto L_0x0936;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
    L_0x0756:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        if (r2 == 0) goto L_0x0936;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
    L_0x075c:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r0.appId;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = com.tencent.mm.plugin.appbrand.a.pi(r2);	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        if (r2 != 0) goto L_0x07ce;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
    L_0x0766:
        r2 = 1;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
    L_0x0767:
        if (r2 == 0) goto L_0x081d;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
    L_0x0769:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r5 = "interrupted";	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2.D(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r14;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r20.close();	 Catch:{ IOException -> 0x07e5 }
    L_0x07b9:
        if (r21 == 0) goto L_0x07be;
    L_0x07bb:
        r21.close();	 Catch:{ IOException -> 0x07f3, ArrayIndexOutOfBoundsException -> 0x0801, Throwable -> 0x080f }
    L_0x07be:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x07ce:
        r5 = com.tencent.mm.plugin.appbrand.j.a.b.AnonymousClass1.iKf;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r2.itj;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r2.iKb;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r2.aaI();	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r2.ordinal();	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r2 = r5[r2];	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        switch(r2) {
            case 1: goto L_0x07e3;
            case 2: goto L_0x07e3;
            default: goto L_0x07e1;
        };
    L_0x07e1:
        r2 = 0;
        goto L_0x0767;
    L_0x07e3:
        r2 = 1;
        goto L_0x0767;
    L_0x07e5:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07b9;
    L_0x07f3:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07be;
    L_0x0801:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07be;
    L_0x080f:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07be;
    L_0x081d:
        r2 = 0;
        r0 = r20;	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r0.write(r10, r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r4 = (long) r4;
        r6 = r14 + r4;
        r4 = 0;
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x085f;
    L_0x082c:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        if (r2 == 0) goto L_0x085f;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
    L_0x0832:
        r4 = 100;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = r4 * r6;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = r4 / r8;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r5 = (int) r4;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4.g(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = "download size %d, totalSize %d, percent = %d";	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r11 = 3;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r12 = 0;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r13 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r11[r12] = r13;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r12 = 1;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r13 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r11[r12] = r13;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r12 = 2;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r11[r12] = r5;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        com.tencent.mm.sdk.platformtools.x.v(r2, r4, r11);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
    L_0x085f:
        r4 = 0;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        if (r2 <= 0) goto L_0x11dc;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
    L_0x0865:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = r0.jHH;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        if (r2 <= 0) goto L_0x11dc;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
    L_0x086b:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = r0.jHH;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r12 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = r4 * r12;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        if (r2 < 0) goto L_0x11dc;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
    L_0x0878:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = "after read stream, downloadSize %d exceed limit";	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r8 = 0;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r9 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r5[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r4 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r5 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r8 = "exceed max file size";	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2.D(r4, r5, r8);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        com.tencent.mm.sdk.platformtools.bi.d(r20);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        com.tencent.mm.sdk.platformtools.bi.d(r21);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r2 = r3.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        com.tencent.mm.loader.stub.b.deleteFile(r2);	 Catch:{ UnsupportedEncodingException -> 0x11c3, FileNotFoundException -> 0x117f, SSLHandshakeException -> 0x1157, SocketTimeoutException -> 0x112f, Exception -> 0x1107, all -> 0x10cb }
        r0 = r27;
        r8 = r0.appId;
        r0 = r27;
        r9 = r0.jHi;
        r10 = "GET";
        r0 = r27;
        r11 = r0.uri;
        r12 = 0;
        r17 = 2;
        r18 = r27.ajf();
        r14 = r6;
        r16 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r8, r9, r10, r11, r12, r14, r16, r17, r18);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r20.close();	 Catch:{ IOException -> 0x08fe }
    L_0x08e9:
        if (r21 == 0) goto L_0x08ee;
    L_0x08eb:
        r21.close();	 Catch:{ IOException -> 0x090c, ArrayIndexOutOfBoundsException -> 0x091a, Throwable -> 0x0928 }
    L_0x08ee:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x08fe:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08e9;
    L_0x090c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08ee;
    L_0x091a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08ee;
    L_0x0928:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x08ee;
    L_0x0936:
        r20.flush();	 Catch:{ UnsupportedEncodingException -> 0x11b6, FileNotFoundException -> 0x1176, SSLHandshakeException -> 0x114e, SocketTimeoutException -> 0x1126, Exception -> 0x10fe, all -> 0x10c0 }
        r19 = r20;
        r22 = r14;
    L_0x093d:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r0.bgH;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 == 0) goto L_0x0a82;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0943:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r26;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r1 = r24;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2.a(r3, r0, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = r0.jHI;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = r2 - r4;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 <= 0) goto L_0x096c;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0966:
        r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r2 > 0) goto L_0x0a00;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x096c:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = "reportSpeed len:%d, time:%d return";	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r7 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r7 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0986:
        r3 = 1;
    L_0x0987:
        r2 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r4 = "finished filename = %s , url = %s ";	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r5 = 2;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r6 = 0;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r6 = 1;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        com.tencent.mm.sdk.platformtools.x.v(r2, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r2 = r0.jHJ;	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        r2.disconnect();	 Catch:{ UnsupportedEncodingException -> 0x11d0, FileNotFoundException -> 0x1188, SSLHandshakeException -> 0x1160, SocketTimeoutException -> 0x1138, Exception -> 0x1110, all -> 0x10d6 }
        if (r3 == 0) goto L_0x0a98;
    L_0x09aa:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x09e6:
        if (r19 == 0) goto L_0x09eb;
    L_0x09e8:
        r19.close();	 Catch:{ IOException -> 0x0ad6 }
    L_0x09eb:
        if (r21 == 0) goto L_0x09f0;
    L_0x09ed:
        r21.close();	 Catch:{ IOException -> 0x0ae5, ArrayIndexOutOfBoundsException -> 0x0af4, Throwable -> 0x0b03 }
    L_0x09f0:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0a00:
        r2 = 34;
        r6 = (double) r8;
        r10 = (double) r4;
        r6 = r6 / r10;
        r10 = 4606971312567484416; // 0x3fef400000000000 float:0.0 double:0.9765625;
        r6 = r6 * r10;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = com.tencent.mm.sdk.platformtools.ao.is2G(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r3 == 0) goto L_0x0a5b;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a15:
        r2 = 30;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a17:
        r11 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r12 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r14 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = (long) r6;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r16 = r0;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r18 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11.a(r12, r14, r16, r18);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r10 = "reportSpeed len:%d, time:%d, speed:%f, key:%d";	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11 = 4;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r12 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11[r12] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r8 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11[r8] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = java.lang.Double.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11[r4] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = 3;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11[r4] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        com.tencent.mm.sdk.platformtools.x.i(r3, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        goto L_0x0986;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a4e:
        r2 = move-exception;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r13 = r19;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r14 = r21;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r16 = r22;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r15 = r24;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r11 = r25;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        goto L_0x01b8;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a5b:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = com.tencent.mm.sdk.platformtools.ao.is3G(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r3 == 0) goto L_0x0a68;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a65:
        r2 = 31;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        goto L_0x0a17;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a68:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = com.tencent.mm.sdk.platformtools.ao.is4G(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r3 == 0) goto L_0x0a75;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a72:
        r2 = 32;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        goto L_0x0a17;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a75:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = com.tencent.mm.sdk.platformtools.ao.isWifi(r3);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        if (r3 == 0) goto L_0x0a17;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a7f:
        r2 = 33;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        goto L_0x0a17;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
    L_0x0a82:
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2 = r0.jHF;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r0 = r27;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r5 = "force stop";	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r2.D(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0a4e, FileNotFoundException -> 0x116a, SSLHandshakeException -> 0x1142, SocketTimeoutException -> 0x111a, Exception -> 0x10f2, all -> 0x10aa }
        r3 = r25;
        goto L_0x0987;
    L_0x0a98:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x09e6;
    L_0x0ad6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09eb;
    L_0x0ae5:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09f0;
    L_0x0af4:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09f0;
    L_0x0b03:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09f0;
    L_0x0b12:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r16;
        r10 = r15;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0234;
    L_0x0b4f:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0239;
    L_0x0b5e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x023e;
    L_0x0b6d:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x023e;
    L_0x0b7c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x023e;
    L_0x0b8b:
        r2 = move-exception;
        r24 = r11;
    L_0x0b8e:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x10a2 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ all -> 0x10a2 }
        r6 = 3;	 Catch:{ all -> 0x10a2 }
        r8 = 1;	 Catch:{ all -> 0x10a2 }
        r10 = 0;	 Catch:{ all -> 0x10a2 }
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x10a2 }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ all -> 0x10a2 }
        r4 = "url is %s ,filename is %s , error is %s";	 Catch:{ all -> 0x10a2 }
        r5 = 3;	 Catch:{ all -> 0x10a2 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x10a2 }
        r6 = 0;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 1;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 2;	 Catch:{ all -> 0x10a2 }
        r2 = r2.toString();	 Catch:{ all -> 0x10a2 }
        r5[r6] = r2;	 Catch:{ all -> 0x10a2 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r2 = r0.jHF;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r3 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r4 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5 = "file not found error";	 Catch:{ all -> 0x10a2 }
        r2.D(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        if (r25 == 0) goto L_0x0c25;
    L_0x0bcf:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0c0b:
        if (r19 == 0) goto L_0x0c10;
    L_0x0c0d:
        r19.close();	 Catch:{ IOException -> 0x0c62 }
    L_0x0c10:
        if (r20 == 0) goto L_0x0c15;
    L_0x0c12:
        r20.close();	 Catch:{ IOException -> 0x0c70, ArrayIndexOutOfBoundsException -> 0x0c7e, Throwable -> 0x0c8c }
    L_0x0c15:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0c25:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0c0b;
    L_0x0c62:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c10;
    L_0x0c70:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c15;
    L_0x0c7e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c15;
    L_0x0c8c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0c15;
    L_0x0c9b:
        r2 = move-exception;
        r24 = r11;
    L_0x0c9e:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x10a2 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ all -> 0x10a2 }
        r6 = 2;	 Catch:{ all -> 0x10a2 }
        r8 = 1;	 Catch:{ all -> 0x10a2 }
        r10 = 0;	 Catch:{ all -> 0x10a2 }
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x10a2 }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ all -> 0x10a2 }
        r4 = "url is %s ,filename is %s , error is %s";	 Catch:{ all -> 0x10a2 }
        r5 = 3;	 Catch:{ all -> 0x10a2 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x10a2 }
        r6 = 0;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 1;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 2;	 Catch:{ all -> 0x10a2 }
        r2 = r2.toString();	 Catch:{ all -> 0x10a2 }
        r5[r6] = r2;	 Catch:{ all -> 0x10a2 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r2 = r0.jHF;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r3 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r4 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5 = "ssl handshake error";	 Catch:{ all -> 0x10a2 }
        r2.D(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        if (r25 == 0) goto L_0x0d35;
    L_0x0cdf:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0d1b:
        if (r19 == 0) goto L_0x0d20;
    L_0x0d1d:
        r19.close();	 Catch:{ IOException -> 0x0d72 }
    L_0x0d20:
        if (r20 == 0) goto L_0x0d25;
    L_0x0d22:
        r20.close();	 Catch:{ IOException -> 0x0d80, ArrayIndexOutOfBoundsException -> 0x0d8e, Throwable -> 0x0d9c }
    L_0x0d25:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0d35:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0d1b;
    L_0x0d72:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d20;
    L_0x0d80:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d25;
    L_0x0d8e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d25;
    L_0x0d9c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0d25;
    L_0x0dab:
        r2 = move-exception;
        r24 = r11;
    L_0x0dae:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x10a2 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ all -> 0x10a2 }
        r6 = 4;	 Catch:{ all -> 0x10a2 }
        r8 = 1;	 Catch:{ all -> 0x10a2 }
        r10 = 0;	 Catch:{ all -> 0x10a2 }
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x10a2 }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ all -> 0x10a2 }
        r4 = "url is %s ,filename is %s , error is %s";	 Catch:{ all -> 0x10a2 }
        r5 = 3;	 Catch:{ all -> 0x10a2 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x10a2 }
        r6 = 0;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 1;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 2;	 Catch:{ all -> 0x10a2 }
        r2 = r2.toString();	 Catch:{ all -> 0x10a2 }
        r5[r6] = r2;	 Catch:{ all -> 0x10a2 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r2 = r0.jHF;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r3 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r4 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5 = "socket timeout";	 Catch:{ all -> 0x10a2 }
        r2.D(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        if (r25 == 0) goto L_0x0e45;
    L_0x0def:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0e2b:
        if (r19 == 0) goto L_0x0e30;
    L_0x0e2d:
        r19.close();	 Catch:{ IOException -> 0x0e82 }
    L_0x0e30:
        if (r20 == 0) goto L_0x0e35;
    L_0x0e32:
        r20.close();	 Catch:{ IOException -> 0x0e90, ArrayIndexOutOfBoundsException -> 0x0e9e, Throwable -> 0x0eac }
    L_0x0e35:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0e45:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0e2b;
    L_0x0e82:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e30;
    L_0x0e90:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e35;
    L_0x0e9e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e35;
    L_0x0eac:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0e35;
    L_0x0ebb:
        r2 = move-exception;
        r24 = r11;
    L_0x0ebe:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x10a2 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;	 Catch:{ all -> 0x10a2 }
        r6 = 5;	 Catch:{ all -> 0x10a2 }
        r8 = 1;	 Catch:{ all -> 0x10a2 }
        r10 = 0;	 Catch:{ all -> 0x10a2 }
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x10a2 }
        r3 = "MicroMsg.AppBrandDownloadWorker";	 Catch:{ all -> 0x10a2 }
        r4 = "url is %s ,filename is %s , error is %s";	 Catch:{ all -> 0x10a2 }
        r5 = 3;	 Catch:{ all -> 0x10a2 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x10a2 }
        r6 = 0;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 1;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r7 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        r6 = 2;	 Catch:{ all -> 0x10a2 }
        r7 = r2.toString();	 Catch:{ all -> 0x10a2 }
        r5[r6] = r7;	 Catch:{ all -> 0x10a2 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r3 = r0.jHF;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r4 = r0.filename;	 Catch:{ all -> 0x10a2 }
        r0 = r27;	 Catch:{ all -> 0x10a2 }
        r5 = r0.uri;	 Catch:{ all -> 0x10a2 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x10a2 }
        r6.<init>();	 Catch:{ all -> 0x10a2 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x10a2 }
        r2 = r6.append(r2);	 Catch:{ all -> 0x10a2 }
        r2 = r2.toString();	 Catch:{ all -> 0x10a2 }
        r3.D(r4, r5, r2);	 Catch:{ all -> 0x10a2 }
        if (r25 == 0) goto L_0x0f63;
    L_0x0f0d:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x0f49:
        if (r19 == 0) goto L_0x0f4e;
    L_0x0f4b:
        r19.close();	 Catch:{ IOException -> 0x0fa0 }
    L_0x0f4e:
        if (r20 == 0) goto L_0x0f53;
    L_0x0f50:
        r20.close();	 Catch:{ IOException -> 0x0fae, ArrayIndexOutOfBoundsException -> 0x0fbc, Throwable -> 0x0fca }
    L_0x0f53:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        goto L_0x0026;
    L_0x0f63:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        r8 = r22;
        r10 = r24;
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x0f49;
    L_0x0fa0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f4e;
    L_0x0fae:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f53;
    L_0x0fbc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f53;
    L_0x0fca:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0f53;
    L_0x0fd9:
        r2 = move-exception;
        r13 = r2;
        r8 = r22;
        r10 = r11;
    L_0x0fde:
        if (r25 == 0) goto L_0x1031;
    L_0x0fe0:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r27.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 10;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 12;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
    L_0x1018:
        if (r19 == 0) goto L_0x101d;
    L_0x101a:
        r19.close();	 Catch:{ IOException -> 0x106a }
    L_0x101d:
        if (r20 == 0) goto L_0x1022;
    L_0x101f:
        r20.close();	 Catch:{ IOException -> 0x1078, ArrayIndexOutOfBoundsException -> 0x1086, Throwable -> 0x1094 }
    L_0x1022:
        r27.ajo();
        r0 = r27;
        r2 = r0.jHF;
        r0 = r27;
        r3 = r0.jeC;
        r2.tU(r3);
        throw r13;
    L_0x1031:
        r0 = r27;
        r2 = r0.appId;
        r0 = r27;
        r3 = r0.jHi;
        r4 = "GET";
        r0 = r27;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r27.ajf();
        com.tencent.mm.plugin.appbrand.report.a.j.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 11;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 13;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r27;
        r10 = r0.jHI;
        r8 = r8 - r10;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        goto L_0x1018;
    L_0x106a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x101d;
    L_0x1078:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1022;
    L_0x1086:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1022;
    L_0x1094:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x1022;
    L_0x10a2:
        r2 = move-exception;
        r13 = r2;
        r8 = r22;
        r10 = r24;
        goto L_0x0fde;
    L_0x10aa:
        r2 = move-exception;
        r13 = r2;
        r20 = r21;
        r8 = r22;
        r10 = r24;
        goto L_0x0fde;
    L_0x10b4:
        r2 = move-exception;
        r13 = r2;
        r19 = r20;
        r8 = r22;
        r10 = r24;
        r20 = r21;
        goto L_0x0fde;
    L_0x10c0:
        r2 = move-exception;
        r13 = r2;
        r19 = r20;
        r8 = r14;
        r10 = r24;
        r20 = r21;
        goto L_0x0fde;
    L_0x10cb:
        r2 = move-exception;
        r13 = r2;
        r19 = r20;
        r8 = r6;
        r10 = r24;
        r20 = r21;
        goto L_0x0fde;
    L_0x10d6:
        r2 = move-exception;
        r13 = r2;
        r20 = r21;
        r8 = r22;
        r10 = r24;
        r25 = r3;
        goto L_0x0fde;
    L_0x10e2:
        r2 = move-exception;
        r19 = r13;
        r20 = r14;
        r8 = r16;
        r10 = r15;
        r25 = r11;
        r13 = r2;
        goto L_0x0fde;
    L_0x10ef:
        r2 = move-exception;
        goto L_0x0ebe;
    L_0x10f2:
        r2 = move-exception;
        r20 = r21;
        goto L_0x0ebe;
    L_0x10f7:
        r2 = move-exception;
        r19 = r20;
        r20 = r21;
        goto L_0x0ebe;
    L_0x10fe:
        r2 = move-exception;
        r19 = r20;
        r22 = r14;
        r20 = r21;
        goto L_0x0ebe;
    L_0x1107:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        r20 = r21;
        goto L_0x0ebe;
    L_0x1110:
        r2 = move-exception;
        r20 = r21;
        r25 = r3;
        goto L_0x0ebe;
    L_0x1117:
        r2 = move-exception;
        goto L_0x0dae;
    L_0x111a:
        r2 = move-exception;
        r20 = r21;
        goto L_0x0dae;
    L_0x111f:
        r2 = move-exception;
        r19 = r20;
        r20 = r21;
        goto L_0x0dae;
    L_0x1126:
        r2 = move-exception;
        r19 = r20;
        r22 = r14;
        r20 = r21;
        goto L_0x0dae;
    L_0x112f:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        r20 = r21;
        goto L_0x0dae;
    L_0x1138:
        r2 = move-exception;
        r20 = r21;
        r25 = r3;
        goto L_0x0dae;
    L_0x113f:
        r2 = move-exception;
        goto L_0x0c9e;
    L_0x1142:
        r2 = move-exception;
        r20 = r21;
        goto L_0x0c9e;
    L_0x1147:
        r2 = move-exception;
        r19 = r20;
        r20 = r21;
        goto L_0x0c9e;
    L_0x114e:
        r2 = move-exception;
        r19 = r20;
        r22 = r14;
        r20 = r21;
        goto L_0x0c9e;
    L_0x1157:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        r20 = r21;
        goto L_0x0c9e;
    L_0x1160:
        r2 = move-exception;
        r20 = r21;
        r25 = r3;
        goto L_0x0c9e;
    L_0x1167:
        r2 = move-exception;
        goto L_0x0b8e;
    L_0x116a:
        r2 = move-exception;
        r20 = r21;
        goto L_0x0b8e;
    L_0x116f:
        r2 = move-exception;
        r19 = r20;
        r20 = r21;
        goto L_0x0b8e;
    L_0x1176:
        r2 = move-exception;
        r19 = r20;
        r22 = r14;
        r20 = r21;
        goto L_0x0b8e;
    L_0x117f:
        r2 = move-exception;
        r19 = r20;
        r22 = r6;
        r20 = r21;
        goto L_0x0b8e;
    L_0x1188:
        r2 = move-exception;
        r20 = r21;
        r25 = r3;
        goto L_0x0b8e;
    L_0x118f:
        r2 = move-exception;
        r13 = r19;
        r14 = r20;
        r16 = r22;
        r15 = r24;
        r11 = r25;
        goto L_0x01b8;
    L_0x119c:
        r2 = move-exception;
        r13 = r19;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r11 = r25;
        goto L_0x01b8;
    L_0x11a9:
        r2 = move-exception;
        r13 = r20;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r11 = r25;
        goto L_0x01b8;
    L_0x11b6:
        r2 = move-exception;
        r13 = r20;
        r16 = r14;
        r11 = r25;
        r15 = r24;
        r14 = r21;
        goto L_0x01b8;
    L_0x11c3:
        r2 = move-exception;
        r13 = r20;
        r14 = r21;
        r16 = r6;
        r15 = r24;
        r11 = r25;
        goto L_0x01b8;
    L_0x11d0:
        r2 = move-exception;
        r13 = r19;
        r14 = r21;
        r16 = r22;
        r15 = r24;
        r11 = r3;
        goto L_0x01b8;
    L_0x11dc:
        r14 = r6;
        goto L_0x074d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.j.a.b.run():void");
    }

    public final void ajo() {
        this.bgH = false;
        if (this.jHJ != null) {
            try {
                this.jHJ.disconnect();
            } catch (Exception e) {
            }
        }
    }

    private int ajf() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
