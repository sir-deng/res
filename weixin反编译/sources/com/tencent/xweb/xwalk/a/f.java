package com.tencent.xweb.xwalk.a;

import android.os.AsyncTask;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.xwalk.core.XWalkInitializer;

public final class f extends AsyncTask<a, b, c> {
    b ADd = null;
    a ADe = null;
    int ADf = 0;
    long ADg = 0;
    private Timer bnp = null;

    public static class a {
        public boolean ADi;
        public String mFilePath;
        public String mUrl;
    }

    public static class c {
        public int ADk;
        public long ADl;
        public int ADm;
        public String jfR;
        public String mFilePath;
        public int mNetWorkType;
        public int mRetryTimes;
        public long mTotalSize;
        public String mUrl;
    }

    public static class b {
        public long ADj;
        public long mTotalSize;
        public String mUrl;
    }

    static class d {
        private static TrustManager ADn = new X509TrustManager() {
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        public static final HostnameVerifier ADo = new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                if (str.contains("dldir1.qq.com")) {
                    return true;
                }
                return false;
            }
        };

        public static SSLContext cKf() {
            SSLContext sSLContext = null;
            try {
                sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{ADn}, new SecureRandom());
                return sSLContext;
            } catch (Exception e) {
                return sSLContext;
            }
        }
    }

    static /* synthetic */ void a(a aVar, b bVar, int i) {
        f fVar = new f();
        fVar.ADd = bVar;
        fVar.ADe = aVar;
        fVar.ADf = i;
        fVar.ADg = System.currentTimeMillis();
        fVar.execute(new a[]{fVar.ADe});
    }

    static /* synthetic */ void d(f fVar) {
        if (fVar.bnp != null) {
            fVar.bnp.cancel();
            fVar.bnp = null;
        }
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((a[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Object obj2 = null;
        c cVar = (c) obj;
        if (cVar == null) {
            cVar = new c();
            cVar.ADk = -10004;
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
        }
        if (cVar.ADk == 0) {
            XWalkInitializer.addXWalkInitializeLog("task succeed! ");
            this.ADd.a(cVar);
            return;
        }
        XWalkInitializer.addXWalkInitializeLog("task failed! retcode = " + cVar.ADk + " mRetrytimes = " + this.ADf);
        if (!(this.ADf >= 2 || cVar.ADk == -10001 || cVar.ADk == -10004)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            this.ADf++;
            XWalkInitializer.addXWalkInitializeLog("task retry!  mRetrytimes = " + this.ADf);
            this.bnp = new Timer();
            this.bnp.schedule(new TimerTask() {
                public final void run() {
                    XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + f.this.ADf);
                    f.a(f.this.ADe, f.this.ADd, f.this.ADf);
                    f.d(f.this);
                }
            }, 3000 * ((long) this.ADf));
            return;
        }
        this.ADd.b(cVar);
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    protected final void onPreExecute() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.xweb.xwalk.a.f.c a(com.tencent.xweb.xwalk.a.f.a... r16) {
        /*
        r15 = this;
        if (r16 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
    L_0x0003:
        return r2;
    L_0x0004:
        r0 = r16;
        r2 = r0.length;
        r3 = 1;
        if (r2 == r3) goto L_0x000c;
    L_0x000a:
        r2 = 0;
        goto L_0x0003;
    L_0x000c:
        r2 = 0;
        r10 = r16[r2];
        if (r10 != 0) goto L_0x0013;
    L_0x0011:
        r2 = 0;
        goto L_0x0003;
    L_0x0013:
        r4 = new com.tencent.xweb.xwalk.a.f$c;
        r4.<init>();
        r2 = r10.mUrl;
        r4.mUrl = r2;
        r2 = r10.mFilePath;
        r4.mFilePath = r2;
        r2 = 0;
        r4.ADk = r2;
        r2 = "";
        r4.jfR = r2;
        r2 = r15.ADf;
        r4.mRetryTimes = r2;
        r2 = 0;
        r4.ADl = r2;
        r2 = 0;
        r4.mTotalSize = r2;
        r2 = 0;
        r4.ADm = r2;
        r2 = org.xwalk.core.XWalkEnvironment.getApplicationContext();
        r2 = org.xwalk.core.NetworkUtil.getCurrentNetWorkStatus(r2);
        r4.mNetWorkType = r2;
        r2 = r10.mUrl;
        if (r2 == 0) goto L_0x005d;
    L_0x0045:
        r2 = r10.mFilePath;
        if (r2 == 0) goto L_0x005d;
    L_0x0049:
        r2 = r10.mUrl;
        r2 = r2.length();
        if (r2 == 0) goto L_0x005d;
    L_0x0051:
        r2 = r10.mFilePath;
        r2 = r2.length();
        if (r2 == 0) goto L_0x005d;
    L_0x0059:
        r2 = r15.ADd;
        if (r2 != 0) goto L_0x0069;
    L_0x005d:
        r2 = "XWebHttpTask invalid params para";
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10001; // 0xffffffffffffd8ef float:NaN double:NaN;
        r4.ADk = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x0069:
        r6 = 0;
        r5 = 0;
        r3 = 0;
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x0201 }
        r7 = r10.mUrl;	 Catch:{ Exception -> 0x0201 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x0201 }
        r2 = r2.openConnection();	 Catch:{ Exception -> 0x0201 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0201 }
        r3 = "GET";
        r2.setRequestMethod(r3);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3 = r10.ADi;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        if (r3 == 0) goto L_0x00a1;
    L_0x0083:
        r3 = r2 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        if (r3 == 0) goto L_0x00a1;
    L_0x0087:
        r3 = com.tencent.xweb.xwalk.a.f.d.cKf();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        if (r3 == 0) goto L_0x00a1;
    L_0x008d:
        r7 = r3.getSocketFactory();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3 = r0;
        r3.setSSLSocketFactory(r7);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3 = r0;
        r7 = com.tencent.xweb.xwalk.a.f.d.ADo;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3.setHostnameVerifier(r7);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
    L_0x00a1:
        r3 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r7) goto L_0x0173;
    L_0x00b3:
        r5 = r2.getInputStream();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r3 = r2.getContentLength();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r8 = r10.mFilePath;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r9 = r7.exists();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        if (r9 == 0) goto L_0x00cb;
    L_0x00c8:
        r7.delete();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
    L_0x00cb:
        r7 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r6 = new byte[r6];	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r8 = 0;
        r11 = new com.tencent.xweb.xwalk.a.f$b;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r11.<init>();	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r10 = r10.mUrl;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r11.mUrl = r10;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r12 = (long) r3;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r11.mTotalSize = r12;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
    L_0x00e2:
        r10 = r5.read(r6);	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r12 = -1;
        if (r10 == r12) goto L_0x0167;
    L_0x00e9:
        r12 = r15.isCancelled();	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        if (r12 == 0) goto L_0x0121;
    L_0x00ef:
        r5.close();	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r7.close();	 Catch:{ IOException -> 0x0102 }
        if (r5 == 0) goto L_0x00fa;
    L_0x00f7:
        r5.close();	 Catch:{ IOException -> 0x0102 }
    L_0x00fa:
        if (r2 == 0) goto L_0x00ff;
    L_0x00fc:
        r2.disconnect();
    L_0x00ff:
        r2 = 0;
        goto L_0x0003;
    L_0x0102:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.ADk = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x0121:
        r12 = (long) r10;
        r8 = r8 + r12;
        r12 = 0;
        r7.write(r6, r12, r10);	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r11.ADj = r8;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        if (r3 <= 0) goto L_0x00e2;
    L_0x012b:
        r10 = 1;
        r10 = new com.tencent.xweb.xwalk.a.f.b[r10];	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r12 = 0;
        r10[r12] = r11;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r15.publishProgress(r10);	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        goto L_0x00e2;
    L_0x0135:
        r3 = move-exception;
        r6 = r7;
        r14 = r2;
        r2 = r3;
        r3 = r14;
    L_0x013a:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c6 }
        r8 = "task failed excetion =  ";
        r7.<init>(r8);	 Catch:{ all -> 0x01c6 }
        r2 = r2.toString();	 Catch:{ all -> 0x01c6 }
        r2 = r7.append(r2);	 Catch:{ all -> 0x01c6 }
        r2 = r2.toString();	 Catch:{ all -> 0x01c6 }
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);	 Catch:{ all -> 0x01c6 }
        r2 = -10002; // 0xffffffffffffd8ee float:NaN double:NaN;
        r4.ADk = r2;	 Catch:{ all -> 0x01c6 }
        if (r6 == 0) goto L_0x015a;
    L_0x0157:
        r6.close();	 Catch:{ IOException -> 0x01a7 }
    L_0x015a:
        if (r5 == 0) goto L_0x015f;
    L_0x015c:
        r5.close();	 Catch:{ IOException -> 0x01a7 }
    L_0x015f:
        if (r3 == 0) goto L_0x0164;
    L_0x0161:
        r3.disconnect();
    L_0x0164:
        r2 = r4;
        goto L_0x0003;
    L_0x0167:
        r4.mTotalSize = r8;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r10 = r15.ADg;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r8 = r8 - r10;
        r4.ADl = r8;	 Catch:{ Exception -> 0x0135, all -> 0x01fb }
        r6 = r7;
    L_0x0173:
        r2.disconnect();	 Catch:{ Exception -> 0x0204, all -> 0x01f6 }
        if (r6 == 0) goto L_0x017b;
    L_0x0178:
        r6.close();	 Catch:{ IOException -> 0x0188 }
    L_0x017b:
        if (r5 == 0) goto L_0x0180;
    L_0x017d:
        r5.close();	 Catch:{ IOException -> 0x0188 }
    L_0x0180:
        if (r2 == 0) goto L_0x0185;
    L_0x0182:
        r2.disconnect();
    L_0x0185:
        r2 = r4;
        goto L_0x0003;
    L_0x0188:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.ADk = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x01a7:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.ADk = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x01c6:
        r2 = move-exception;
    L_0x01c7:
        if (r6 == 0) goto L_0x01cc;
    L_0x01c9:
        r6.close();	 Catch:{ IOException -> 0x01d7 }
    L_0x01cc:
        if (r5 == 0) goto L_0x01d1;
    L_0x01ce:
        r5.close();	 Catch:{ IOException -> 0x01d7 }
    L_0x01d1:
        if (r3 == 0) goto L_0x01d6;
    L_0x01d3:
        r3.disconnect();
    L_0x01d6:
        throw r2;
    L_0x01d7:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.ADk = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x01f6:
        r3 = move-exception;
        r14 = r3;
        r3 = r2;
        r2 = r14;
        goto L_0x01c7;
    L_0x01fb:
        r3 = move-exception;
        r6 = r7;
        r14 = r2;
        r2 = r3;
        r3 = r14;
        goto L_0x01c7;
    L_0x0201:
        r2 = move-exception;
        goto L_0x013a;
    L_0x0204:
        r3 = move-exception;
        r14 = r3;
        r3 = r2;
        r2 = r14;
        goto L_0x013a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.f.a(com.tencent.xweb.xwalk.a.f$a[]):com.tencent.xweb.xwalk.a.f$c");
    }
}
