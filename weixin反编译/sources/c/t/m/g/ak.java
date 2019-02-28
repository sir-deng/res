package c.t.m.g;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;

public final class ak extends ae {
    boolean A = false;
    private HttpURLConnection B;
    private DataOutputStream C;
    private DataInputStream D;
    private String E;
    private ai F;
    aj o;
    boolean p;
    boolean q;
    String r = "";
    int s;
    long t = 0;
    String u;
    a v = new a();
    long w;
    boolean x = false;
    boolean y = false;
    int z = 0;

    static class a {
        long a;
        long b;
        long c;
        long d;
        long e;
        long f;
        long g;
        long h;
        long i;
        long j;
        long k;

        private a() {
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a() {
            long j = -1;
            this.g = this.b - this.a;
            this.h = this.c - this.b;
            this.i = this.d - this.c;
            this.j = this.e - this.d;
            this.k = this.f - this.e;
            long j2 = this.g;
            if (j2 < 0) {
                j2 = -1;
            }
            this.g = j2;
            j2 = this.h;
            if (j2 < 0) {
                j2 = -1;
            }
            this.h = j2;
            j2 = this.i;
            if (j2 < 0) {
                j2 = -1;
            }
            this.i = j2;
            j2 = this.j;
            if (j2 < 0) {
                j2 = -1;
            }
            this.j = j2;
            j2 = this.k;
            if (j2 >= 0) {
                j = j2;
            }
            this.k = j;
        }

        public final String toString() {
            return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
        }
    }

    public ak(String str, String str2, boolean z, Map<String, String> map, byte[] bArr, int i, String str3) {
        this.E = str;
        this.b = str2;
        this.c = z;
        this.d = map;
        this.e = bArr;
        int a = p.g() == 2 ? v.a("direct_access_time_out", 1000, 60000, 15000) : v.a("direct_access_time_out", 1000, 60000, 10000);
        if (i >= a) {
            i = a;
        }
        this.f = cg.a(i, 200, 60000, 10000);
        this.g = str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r9) {
        /*
        r8 = this;
        r1 = 0;
        r3 = new java.io.BufferedInputStream;	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r0 = r8.B;	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r0 = r0.getInputStream();	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r3.<init>(r0);	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r4.<init>();	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = new byte[r0];	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r2 = 1;
        r0 = r1;
    L_0x0017:
        r6 = r3.read(r5);	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r7 = -1;
        if (r6 == r7) goto L_0x0078;
    L_0x001e:
        r7 = 0;
        r4.write(r5, r7, r6);	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r0 = r0 + r6;
        if (r0 <= r9) goto L_0x0017;
    L_0x0025:
        r2 = r8.o;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r3 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        r2.a = r3;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r2 = r8.o;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r3 = "no-content-length";
        r2.b = r3;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
    L_0x0032:
        if (r1 == 0) goto L_0x0044;
    L_0x0034:
        r1 = r8.o;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r2 = r4.toByteArray();	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r1.d = r2;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r1 = r8.v;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r1.f = r2;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
    L_0x0044:
        r4.close();	 Catch:{ Exception -> 0x0074, OutOfMemoryError -> 0x0076 }
    L_0x0047:
        return;
    L_0x0048:
        r0 = move-exception;
        r0 = r1;
    L_0x004a:
        r1 = r8.o;
        r2 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r1.a = r2;
        r1 = r8.o;
        r2 = new java.lang.StringBuilder;
        r3 = "no-content-length:";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.b = r0;
        goto L_0x0047;
    L_0x0065:
        r0 = move-exception;
        r0 = r8.o;
        r1 = -287; // 0xfffffffffffffee1 float:NaN double:NaN;
        r0.a = r1;
        r0 = r8.o;
        r1 = "read without content-length error";
        r0.b = r1;
        goto L_0x0047;
    L_0x0074:
        r0 = move-exception;
        goto L_0x0047;
    L_0x0076:
        r1 = move-exception;
        goto L_0x004a;
    L_0x0078:
        r1 = r2;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ak.a(int):void");
    }

    private void b() {
        Object obj = null;
        if (this.d != null && this.d.size() > 0) {
            Object obj2;
            Iterator it = this.d.keySet().iterator();
            while (true) {
                obj2 = obj;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                this.B.addRequestProperty(str, (String) this.d.get(str));
                obj = str.toLowerCase().contains("host") ? 1 : obj2;
            }
            obj = obj2;
        }
        if (obj == null) {
            this.B.setRequestProperty("Host", this.E);
        }
        this.B.setRequestProperty("Halley", this.g + "-" + this.z + "-" + System.currentTimeMillis());
        if (this.y) {
            this.B.setRequestProperty("Connection", "close");
        }
        if (this.x) {
            this.B.setRequestProperty("X-Online-Host", this.E);
            this.B.setRequestProperty("x-tx-host", this.E);
        }
    }

    private void c() {
        try {
            if (this.B != null) {
                this.B.disconnect();
            }
            if (this.C != null) {
                this.C.close();
            }
            if (this.D != null) {
                this.D.close();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.t.m.g.aj a() {
        /*
        r8 = this;
        r7 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r1 = 1;
        r2 = 0;
        r4 = java.lang.System.currentTimeMillis();
        r8.m = r4;
        r4 = android.os.SystemClock.elapsedRealtime();
        r8.w = r4;
        r0 = r8.v;
        r4 = r8.w;
        r0.a = r4;
        r0 = new c.t.m.g.aj;
        r3 = "";
        r0.<init>(r2, r3);
        r8.o = r0;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.b;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r0.getProtocol();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r3.toLowerCase();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = "https";
        r3 = r3.startsWith(r4);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.p = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r0.getHost();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = c.t.m.g.cg.d(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.q = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.p;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 == 0) goto L_0x0178;
    L_0x0046:
        r3 = r8.x;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 == 0) goto L_0x016e;
    L_0x004a:
        r3 = c.t.m.g.p.k();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 == 0) goto L_0x016e;
    L_0x0050:
        r3 = c.t.m.g.p.k();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.openConnection(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
    L_0x005a:
        r3 = r8.q;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 == 0) goto L_0x0076;
    L_0x005e:
        r3 = new c.t.m.g.ai;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = r8.E;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.F = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.F;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.setSSLSocketFactory(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = new c.t.m.g.ah;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = r8.E;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.setHostnameVerifier(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
    L_0x0076:
        r8.B = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 == 0) goto L_0x0198;
    L_0x007e:
        r0 = "GET";
    L_0x0081:
        r3.setRequestMethod(r0);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.f;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.setConnectTimeout(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.f;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.setReadTimeout(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 0;
        r0.setUseCaches(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 1;
        r0.setDoInput(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 0;
        r0.setInstanceFollowRedirects(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.b();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 != 0) goto L_0x00bf;
    L_0x00ab:
        r0 = r8.e;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = c.t.m.g.cg.a(r0);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 != 0) goto L_0x00bf;
    L_0x00b3:
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 1;
        r0.setDoOutput(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.e;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.length;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = (long) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.t = r4;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
    L_0x00bf:
        r0 = r8.v;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.b = r4;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.connect();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.v;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.c = r4;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 != 0) goto L_0x00f9;
    L_0x00d8:
        r0 = r8.e;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = c.t.m.g.cg.a(r0);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 != 0) goto L_0x00f9;
    L_0x00e0:
        r0 = new java.io.DataOutputStream;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r3.getOutputStream();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.C = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.C;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.e;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.write(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.C;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.flush();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
    L_0x00f9:
        r0 = r8.v;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.d = r4;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.getResponseCode();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.v;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.e = r4;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.c = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.getContentType();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.r = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = new java.util.HashMap;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.<init>();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.getHeaderFields();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.entrySet();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = r0.iterator();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
    L_0x012e:
        r0 = r4.hasNext();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 == 0) goto L_0x019d;
    L_0x0134:
        r0 = r4.next();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r5 = r0.getKey();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r5 == 0) goto L_0x012e;
    L_0x0140:
        r5 = r0.getKey();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.getValue();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = (java.util.List) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r6 = 0;
        r0 = r0.get(r6);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.put(r5, r0);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x012e;
    L_0x0153:
        r0 = move-exception;
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -300; // 0xfffffffffffffed4 float:NaN double:NaN;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        r8.c();
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = r8.w;
        r0 = r0 - r2;
        r8.w = r0;
        r0 = r8.v;
        r0.a();
    L_0x016b:
        r0 = r8.o;
        return r0;
    L_0x016e:
        r3 = java.net.Proxy.NO_PROXY;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.openConnection(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x005a;
    L_0x0178:
        r3 = r8.x;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 == 0) goto L_0x018e;
    L_0x017c:
        r3 = c.t.m.g.p.k();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 == 0) goto L_0x018e;
    L_0x0182:
        r3 = c.t.m.g.p.k();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.openConnection(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x0076;
    L_0x018e:
        r3 = java.net.Proxy.NO_PROXY;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.openConnection(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x0076;
    L_0x0198:
        r0 = "POST";
        goto L_0x0081;
    L_0x019d:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.a(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 < r3) goto L_0x02ea;
    L_0x01aa:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 >= r7) goto L_0x02ea;
    L_0x01b0:
        r0 = r8.B;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.getContentLength();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.s = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = "app_receive_pack_size";
        r3 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        r4 = 10485760; // 0xa00000 float:1.469368E-38 double:5.180654E-317;
        r5 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r0 = c.t.m.g.v.a(r0, r3, r4, r5);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r8.s;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 >= 0) goto L_0x01de;
    L_0x01c9:
        r8.a(r0);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
    L_0x01cc:
        r8.c();
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = r8.w;
        r0 = r0 - r2;
        r8.w = r0;
        r0 = r8.v;
        r0.a();
        goto L_0x016b;
    L_0x01de:
        r3 = r8.s;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 != 0) goto L_0x0278;
    L_0x01e2:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 0;
        r0.d = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.v;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.f = r4;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x01cc;
    L_0x01f0:
        r0 = move-exception;
        r3 = r8.o;	 Catch:{ all -> 0x0297 }
        r4 = -287; // 0xfffffffffffffee1 float:NaN double:NaN;
        r3.a = r4;	 Catch:{ all -> 0x0297 }
        r3 = r8.o;	 Catch:{ all -> 0x0297 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0297 }
        r4.<init>();	 Catch:{ all -> 0x0297 }
        r5 = r0.getClass();	 Catch:{ all -> 0x0297 }
        r5 = r5.getSimpleName();	 Catch:{ all -> 0x0297 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0297 }
        r5 = "(";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0297 }
        r5 = r0.getLocalizedMessage();	 Catch:{ all -> 0x0297 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0297 }
        r5 = ")";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0297 }
        r4 = r4.toString();	 Catch:{ all -> 0x0297 }
        r3.b = r4;	 Catch:{ all -> 0x0297 }
        r3 = r8.F;	 Catch:{ all -> 0x0297 }
        if (r3 == 0) goto L_0x0230;
    L_0x022a:
        r3 = r8.F;	 Catch:{ all -> 0x0297 }
        r3 = r3.a;	 Catch:{ all -> 0x0297 }
        if (r3 != 0) goto L_0x025a;
    L_0x0230:
        r3 = r8.p;	 Catch:{ all -> 0x0297 }
        if (r3 == 0) goto L_0x0245;
    L_0x0234:
        r3 = r8.o;	 Catch:{ all -> 0x0297 }
        r3 = r3.b;	 Catch:{ all -> 0x0297 }
        r3 = r3.toLowerCase();	 Catch:{ all -> 0x0297 }
        r4 = "cannot verify hostname";
        r3 = r3.contains(r4);	 Catch:{ all -> 0x0297 }
        if (r3 != 0) goto L_0x025a;
    L_0x0245:
        r3 = r8.p;	 Catch:{ all -> 0x0297 }
        if (r3 == 0) goto L_0x030f;
    L_0x0249:
        r3 = r8.o;	 Catch:{ all -> 0x0297 }
        r3 = r3.b;	 Catch:{ all -> 0x0297 }
        r3 = r3.toLowerCase();	 Catch:{ all -> 0x0297 }
        r4 = "not verified";
        r3 = r3.contains(r4);	 Catch:{ all -> 0x0297 }
        if (r3 == 0) goto L_0x030f;
    L_0x025a:
        r2 = c.t.m.g.p.h();	 Catch:{ all -> 0x0297 }
        if (r2 != 0) goto L_0x0312;
    L_0x0260:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -4;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
    L_0x0265:
        r8.c();
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = r8.w;
        r0 = r0 - r2;
        r8.w = r0;
        r0 = r8.v;
        r0.a();
        goto L_0x016b;
    L_0x0278:
        r3 = r8.s;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r3 <= r0) goto L_0x02aa;
    L_0x027c:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        r0.a = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.<init>();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = r8.s;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r3.append(r4);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r3.toString();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.b = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x01cc;
    L_0x0297:
        r0 = move-exception;
        r8.c();
        r2 = android.os.SystemClock.elapsedRealtime();
        r4 = r8.w;
        r2 = r2 - r4;
        r8.w = r2;
        r1 = r8.v;
        r1.a();
        throw r0;
    L_0x02aa:
        r0 = r8.s;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r0 = new byte[r0];	 Catch:{ OutOfMemoryError -> 0x02ce }
        r3 = new java.io.DataInputStream;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r4 = r8.B;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r4 = r4.getInputStream();	 Catch:{ OutOfMemoryError -> 0x02ce }
        r3.<init>(r4);	 Catch:{ OutOfMemoryError -> 0x02ce }
        r8.D = r3;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r3 = r8.D;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r3.readFully(r0);	 Catch:{ OutOfMemoryError -> 0x02ce }
        r3 = r8.o;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r3.d = r0;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r0 = r8.v;	 Catch:{ OutOfMemoryError -> 0x02ce }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ OutOfMemoryError -> 0x02ce }
        r0.f = r4;	 Catch:{ OutOfMemoryError -> 0x02ce }
        goto L_0x01cc;
    L_0x02ce:
        r0 = move-exception;
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r0.a = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3.<init>();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r4 = r8.s;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r3.append(r4);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = r3.toString();	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0.b = r3;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x01cc;
    L_0x02ea:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        if (r0 < r7) goto L_0x0305;
    L_0x02f0:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = r0.c;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 >= r3) goto L_0x0305;
    L_0x02f8:
        r0 = r8.o;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r3 = "location";
        r0 = r0.a(r3);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.h = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x01cc;
    L_0x0305:
        r0 = r8.E;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r0 = c.t.m.g.cg.c(r0);	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        r8.u = r0;	 Catch:{ MalformedURLException -> 0x0153, Throwable -> 0x01f0 }
        goto L_0x01cc;
    L_0x030f:
        r1 = r2;
        goto L_0x025a;
    L_0x0312:
        if (r1 == 0) goto L_0x031c;
    L_0x0314:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -289; // 0xfffffffffffffedf float:NaN double:NaN;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x031c:
        r1 = 1;
        r8.i = r1;	 Catch:{ all -> 0x0297 }
        r1 = r8.v;	 Catch:{ all -> 0x0297 }
        r2 = r1.e;	 Catch:{ all -> 0x0297 }
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0331;
    L_0x0329:
        r1 = r8.E;	 Catch:{ all -> 0x0297 }
        r1 = c.t.m.g.cg.c(r1);	 Catch:{ all -> 0x0297 }
        r8.u = r1;	 Catch:{ all -> 0x0297 }
    L_0x0331:
        r1 = r0.getMessage();	 Catch:{ all -> 0x0297 }
        if (r1 == 0) goto L_0x0357;
    L_0x0337:
        r1 = r0.getMessage();	 Catch:{ all -> 0x0297 }
        r1 = r1.toLowerCase();	 Catch:{ all -> 0x0297 }
        r2 = "permission";
        r1 = r1.contains(r2);	 Catch:{ all -> 0x0297 }
        if (r1 == 0) goto L_0x0357;
    L_0x0348:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -281; // 0xfffffffffffffee7 float:NaN double:NaN;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = "no permission";
        r0.b = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x0357:
        r1 = r0 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x0297 }
        if (r1 == 0) goto L_0x0363;
    L_0x035b:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -284; // 0xfffffffffffffee4 float:NaN double:NaN;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x0363:
        r1 = r0 instanceof java.net.ConnectException;	 Catch:{ all -> 0x0297 }
        if (r1 == 0) goto L_0x036f;
    L_0x0367:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -42;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x036f:
        r1 = r0 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0297 }
        if (r1 == 0) goto L_0x03a3;
    L_0x0373:
        r0 = r0.getLocalizedMessage();	 Catch:{ all -> 0x0297 }
        if (r0 == 0) goto L_0x039b;
    L_0x0379:
        r1 = r0.toLowerCase();	 Catch:{ all -> 0x0297 }
        r2 = "connect";
        r1 = r1.contains(r2);	 Catch:{ all -> 0x0297 }
        if (r1 != 0) goto L_0x0393;
    L_0x0386:
        r0 = r0.toLowerCase();	 Catch:{ all -> 0x0297 }
        r1 = "connection";
        r0 = r0.contains(r1);	 Catch:{ all -> 0x0297 }
        if (r0 == 0) goto L_0x039b;
    L_0x0393:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -10;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x039b:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -13;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x03a3:
        r1 = r0 instanceof java.net.SocketException;	 Catch:{ all -> 0x0297 }
        if (r1 == 0) goto L_0x03af;
    L_0x03a7:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -41;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
    L_0x03af:
        r0 = r0 instanceof java.io.IOException;	 Catch:{ all -> 0x0297 }
        if (r0 == 0) goto L_0x0265;
    L_0x03b3:
        r0 = r8.o;	 Catch:{ all -> 0x0297 }
        r1 = -286; // 0xfffffffffffffee2 float:NaN double:NaN;
        r0.a = r1;	 Catch:{ all -> 0x0297 }
        goto L_0x0265;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ak.a():c.t.m.g.aj");
    }

    public final void a(boolean z) {
    }
}
