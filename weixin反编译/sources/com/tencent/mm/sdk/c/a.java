package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.b;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;

public final class a extends b {
    private HttpURLConnection jHJ = null;

    public a(HttpURLConnection httpURLConnection) {
        this.jHJ = httpURLConnection;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.sdk.c.b.b r14, com.tencent.mm.sdk.c.b.c r15) {
        /*
        r13 = this;
        r1 = "MicroMsg.HttpURLConnectionWrapper";
        r2 = "request : %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r14;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = r14.gLT;	 Catch:{ Exception -> 0x027d }
        r1.setConnectTimeout(r5);	 Catch:{ Exception -> 0x027d }
        r5 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r1 = r14.puf;	 Catch:{ Exception -> 0x027d }
        if (r1 != 0) goto L_0x0149;
    L_0x001f:
        r1 = "GET";
    L_0x0022:
        r5.setRequestMethod(r1);	 Catch:{ Exception -> 0x027d }
        r1 = r14.puf;	 Catch:{ Exception -> 0x027d }
        r5 = 1;
        if (r1 != r5) goto L_0x0036;
    L_0x002a:
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = 1;
        r1.setDoInput(r5);	 Catch:{ Exception -> 0x027d }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = 1;
        r1.setDoOutput(r5);	 Catch:{ Exception -> 0x027d }
    L_0x0036:
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = 0;
        r1.setUseCaches(r5);	 Catch:{ Exception -> 0x027d }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = "User-Agent";
        r6 = "weixin/android";
        r1.setRequestProperty(r5, r6);	 Catch:{ Exception -> 0x027d }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = "Host";
        r6 = r14.host;	 Catch:{ Exception -> 0x027d }
        r1.setRequestProperty(r5, r6);	 Catch:{ Exception -> 0x027d }
        r1 = "http.keepAlive";
        r5 = "false";
        java.lang.System.setProperty(r1, r5);	 Catch:{ Exception -> 0x027d }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = "Accept-Charset";
        r6 = "utf-8";
        r1.setRequestProperty(r5, r6);	 Catch:{ Exception -> 0x027d }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r5 = "Accept-Encoding";
        r6 = "compress;q=0.5, gzip;q=1.0";
        r1.setRequestProperty(r5, r6);	 Catch:{ Exception -> 0x027d }
        r6 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r7 = "Cookie";
        r8 = r14.puh;	 Catch:{ Exception -> 0x027d }
        if (r8 == 0) goto L_0x007f;
    L_0x0079:
        r1 = r8.size();	 Catch:{ Exception -> 0x027d }
        if (r1 != 0) goto L_0x014e;
    L_0x007f:
        r1 = "";
    L_0x0082:
        r6.setRequestProperty(r7, r1);	 Catch:{ Exception -> 0x027d }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r1.connect();	 Catch:{ Exception -> 0x027d }
        r1 = r14.puf;	 Catch:{ Exception -> 0x027d }
        r5 = 1;
        if (r1 != r5) goto L_0x028d;
    L_0x008f:
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x027d }
        r4 = r1.getOutputStream();	 Catch:{ Exception -> 0x027d }
        a(r14, r4);	 Catch:{ Exception -> 0x027d }
        r4.flush();	 Catch:{ Exception -> 0x027d }
        r5 = r4;
    L_0x009c:
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x0280, all -> 0x0208 }
        r4 = r1.getResponseCode();	 Catch:{ Exception -> 0x0280, all -> 0x0208 }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = "set-cookie";
        r6 = r1.getHeaderField(r2);	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r1 = r13.jHJ;	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = "Content-Encoding";
        r1 = r1.getHeaderField(r2);	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = r13.jHJ;	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r7 = "Content-Disposition";
        r2.getHeaderField(r7);	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = r13.jHJ;	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        if (r1 == 0) goto L_0x028a;
    L_0x00c4:
        r3 = "gzip";
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x0284, all -> 0x0279 }
        if (r1 == 0) goto L_0x028a;
    L_0x00cd:
        r1 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0284, all -> 0x0279 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0284, all -> 0x0279 }
        r3 = r1;
    L_0x00d3:
        r2 = 0;
        r1 = r15.xmN;	 Catch:{ Exception -> 0x0104 }
        if (r1 == 0) goto L_0x01a0;
    L_0x00d8:
        r1 = r15.xmN;	 Catch:{ Exception -> 0x0104 }
        r1 = r1.filePath;	 Catch:{ Exception -> 0x0104 }
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);	 Catch:{ Exception -> 0x0104 }
        if (r1 == 0) goto L_0x01a0;
    L_0x00e2:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0104 }
        r1 = r15.xmN;	 Catch:{ Exception -> 0x0104 }
        r1 = r1.filePath;	 Catch:{ Exception -> 0x0104 }
        r7.<init>(r1);	 Catch:{ Exception -> 0x0104 }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0104 }
        r8 = 1;
        r1.<init>(r7, r8);	 Catch:{ Exception -> 0x0104 }
        r2 = r1;
    L_0x00f2:
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0104 }
    L_0x00f6:
        r7 = r3.read(r1);	 Catch:{ Exception -> 0x0104 }
        if (r7 <= 0) goto L_0x01a8;
    L_0x00fc:
        r8 = 0;
        r2.write(r1, r8, r7);	 Catch:{ Exception -> 0x0104 }
        r2.flush();	 Catch:{ Exception -> 0x0104 }
        goto L_0x00f6;
    L_0x0104:
        r1 = move-exception;
        r6 = "MicroMsg.HttpURLConnectionWrapper";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r1, r7, r8);	 Catch:{ all -> 0x01fe }
        if (r4 != 0) goto L_0x01fa;
    L_0x0113:
        r1 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x0115:
        r15.status = r1;	 Catch:{ all -> 0x01fe }
        if (r2 == 0) goto L_0x011f;
    L_0x0119:
        r2.flush();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2.close();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
    L_0x011f:
        r1 = "MicroMsg.HttpURLConnectionWrapper";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r6 = "Response: %s";
        r2.<init>(r6);	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = r2.append(r15);	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        if (r5 == 0) goto L_0x013a;
    L_0x0137:
        r5.close();	 Catch:{ IOException -> 0x021e }
    L_0x013a:
        if (r3 == 0) goto L_0x013f;
    L_0x013c:
        r3.close();	 Catch:{ IOException -> 0x022d }
    L_0x013f:
        r1 = r13.jHJ;
        if (r1 == 0) goto L_0x0148;
    L_0x0143:
        r1 = r13.jHJ;
        r1.disconnect();
    L_0x0148:
        return;
    L_0x0149:
        r1 = "POST";
        goto L_0x0022;
    L_0x014e:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x027d }
        r9.<init>();	 Catch:{ Exception -> 0x027d }
        r1 = 0;
        r5 = r8.keySet();	 Catch:{ Exception -> 0x027d }
        r10 = r5.iterator();	 Catch:{ Exception -> 0x027d }
        r5 = r1;
    L_0x015d:
        r1 = r10.hasNext();	 Catch:{ Exception -> 0x027d }
        if (r1 == 0) goto L_0x019a;
    L_0x0163:
        r1 = r10.next();	 Catch:{ Exception -> 0x027d }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x027d }
        r11 = "utf-8";
        r11 = java.net.URLEncoder.encode(r1, r11);	 Catch:{ Exception -> 0x027d }
        r11 = r9.append(r11);	 Catch:{ Exception -> 0x027d }
        r12 = 61;
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x027d }
        r1 = r8.get(r1);	 Catch:{ Exception -> 0x027d }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x027d }
        r12 = "utf-8";
        r1 = java.net.URLEncoder.encode(r1, r12);	 Catch:{ Exception -> 0x027d }
        r11.append(r1);	 Catch:{ Exception -> 0x027d }
        r1 = r5 + 1;
        r5 = r8.size();	 Catch:{ Exception -> 0x027d }
        if (r5 <= r1) goto L_0x0198;
    L_0x0192:
        r5 = "; ";
        r9.append(r5);	 Catch:{ Exception -> 0x027d }
    L_0x0198:
        r5 = r1;
        goto L_0x015d;
    L_0x019a:
        r1 = r9.toString();	 Catch:{ Exception -> 0x027d }
        goto L_0x0082;
    L_0x01a0:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0104 }
        r1.<init>();	 Catch:{ Exception -> 0x0104 }
        r2 = r1;
        goto L_0x00f2;
    L_0x01a8:
        r15.status = r4;	 Catch:{ Exception -> 0x0104 }
        r1 = com.tencent.mm.sdk.c.b.In(r6);	 Catch:{ Exception -> 0x0104 }
        r15.puh = r1;	 Catch:{ Exception -> 0x0104 }
        r1 = r2 instanceof java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0104 }
        if (r1 == 0) goto L_0x01f6;
    L_0x01b4:
        r6 = new java.lang.String;	 Catch:{ Exception -> 0x0104 }
        r0 = r2;
        r0 = (java.io.ByteArrayOutputStream) r0;	 Catch:{ Exception -> 0x0104 }
        r1 = r0;
        r1 = r1.toByteArray();	 Catch:{ Exception -> 0x0104 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0104 }
        r1 = r6;
    L_0x01c2:
        r15.content = r1;	 Catch:{ Exception -> 0x0104 }
        r2.flush();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2.close();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        goto L_0x011f;
    L_0x01cc:
        r1 = move-exception;
        r2 = r4;
        r4 = r5;
    L_0x01cf:
        r5 = "MicroMsg.HttpURLConnectionWrapper";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0277 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r1, r6, r7);	 Catch:{ all -> 0x0277 }
        if (r2 != 0) goto L_0x023c;
    L_0x01dd:
        r1 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x01df:
        r15.status = r1;	 Catch:{ all -> 0x0277 }
        if (r4 == 0) goto L_0x01e6;
    L_0x01e3:
        r4.close();	 Catch:{ IOException -> 0x023f }
    L_0x01e6:
        if (r3 == 0) goto L_0x01eb;
    L_0x01e8:
        r3.close();	 Catch:{ IOException -> 0x024d }
    L_0x01eb:
        r1 = r13.jHJ;
        if (r1 == 0) goto L_0x0148;
    L_0x01ef:
        r1 = r13.jHJ;
        r1.disconnect();
        goto L_0x0148;
    L_0x01f6:
        r1 = "";
        goto L_0x01c2;
    L_0x01fa:
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x0115;
    L_0x01fe:
        r1 = move-exception;
        if (r2 == 0) goto L_0x0207;
    L_0x0201:
        r2.flush();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
        r2.close();	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
    L_0x0207:
        throw r1;	 Catch:{ Exception -> 0x01cc, all -> 0x0208 }
    L_0x0208:
        r1 = move-exception;
        r4 = r5;
    L_0x020a:
        if (r4 == 0) goto L_0x020f;
    L_0x020c:
        r4.close();	 Catch:{ IOException -> 0x025b }
    L_0x020f:
        if (r3 == 0) goto L_0x0214;
    L_0x0211:
        r3.close();	 Catch:{ IOException -> 0x0269 }
    L_0x0214:
        r2 = r13.jHJ;
        if (r2 == 0) goto L_0x021d;
    L_0x0218:
        r2 = r13.jHJ;
        r2.disconnect();
    L_0x021d:
        throw r1;
    L_0x021e:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r4, r5);
        goto L_0x013a;
    L_0x022d:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x013f;
    L_0x023c:
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x01df;
    L_0x023f:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r4, r5);
        goto L_0x01e6;
    L_0x024d:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x01eb;
    L_0x025b:
        r2 = move-exception;
        r4 = "MicroMsg.HttpURLConnectionWrapper";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r2, r5, r6);
        goto L_0x020f;
    L_0x0269:
        r2 = move-exception;
        r3 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0214;
    L_0x0277:
        r1 = move-exception;
        goto L_0x020a;
    L_0x0279:
        r1 = move-exception;
        r3 = r2;
        r4 = r5;
        goto L_0x020a;
    L_0x027d:
        r1 = move-exception;
        goto L_0x01cf;
    L_0x0280:
        r1 = move-exception;
        r4 = r5;
        goto L_0x01cf;
    L_0x0284:
        r1 = move-exception;
        r3 = r2;
        r2 = r4;
        r4 = r5;
        goto L_0x01cf;
    L_0x028a:
        r3 = r2;
        goto L_0x00d3;
    L_0x028d:
        r5 = r4;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.c.a.a(com.tencent.mm.sdk.c.b$b, com.tencent.mm.sdk.c.b$c):void");
    }

    private static void a(b bVar, OutputStream outputStream) {
        if (bVar.pug != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            Iterator it = bVar.pug.keySet().iterator();
            while (true) {
                Object obj2 = obj;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) bVar.pug.get(str), ProtocolPackage.ServerEncoding));
                    obj = null;
                } else {
                    outputStream.write(stringBuilder.toString().getBytes());
                    return;
                }
            }
        }
    }
}
