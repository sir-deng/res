package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.u;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;

public final class x extends h {
    private u pvH;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.qqmail.b.h.c a(java.lang.String r15, java.lang.String r16, com.tencent.mm.plugin.qqmail.b.h.b r17, com.tencent.mm.plugin.qqmail.b.h.a r18) {
        /*
        r14 = this;
        r2 = "MicroMsg.URLConnectionUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "uri=";
        r3.<init>(r4);
        r0 = r16;
        r3 = r3.append(r0);
        r4 = ", ";
        r3 = r3.append(r4);
        r0 = r17;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r0 = r17;
        r2 = r0.puf;	 Catch:{ Exception -> 0x02df }
        if (r2 != 0) goto L_0x018f;
    L_0x002e:
        r0 = r17;
        r2 = r0.pug;	 Catch:{ Exception -> 0x02df }
    L_0x0032:
        r0 = r16;
        r2 = com.tencent.mm.plugin.qqmail.b.h.b(r15, r0, r2);	 Catch:{ Exception -> 0x02df }
        r6 = 0;
        r2 = com.tencent.mm.network.b.a(r2, r6);	 Catch:{ Exception -> 0x02df }
        r14.pvH = r2;	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = gLT;	 Catch:{ Exception -> 0x02df }
        r2.setConnectTimeout(r6);	 Catch:{ Exception -> 0x02df }
        r6 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r0 = r17;
        r2 = r0.puf;	 Catch:{ Exception -> 0x02df }
        if (r2 != 0) goto L_0x0192;
    L_0x004e:
        r2 = "GET";
    L_0x0051:
        r6.setRequestMethod(r2);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r2.VG();	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r2.VH();	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = 0;
        r2.setUseCaches(r6);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = "User-Agent";
        r7 = aBs;	 Catch:{ Exception -> 0x02df }
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = "Host";
        r7 = host;	 Catch:{ Exception -> 0x02df }
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x02df }
        r2 = "http.keepAlive";
        r6 = "false";
        java.lang.System.setProperty(r2, r6);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = "Accept-Charset";
        r7 = "utf-8";
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = "Accept-Encoding";
        r7 = "compress;q=0.5, gzip;q=1.0";
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r6 = "Cookie";
        r0 = r17;
        r7 = r0.puh;	 Catch:{ Exception -> 0x02df }
        r7 = com.tencent.mm.plugin.qqmail.b.h.M(r7);	 Catch:{ Exception -> 0x02df }
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r2.connect();	 Catch:{ Exception -> 0x02df }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02df }
        r7 = r2.getOutputStream();	 Catch:{ Exception -> 0x02df }
        r0 = r17;
        r2 = r0.puf;	 Catch:{ Exception -> 0x02e2, all -> 0x02d8 }
        r5 = 1;
        if (r2 != r5) goto L_0x00be;
    L_0x00b9:
        r0 = r17;
        a(r0, r7);	 Catch:{ Exception -> 0x02e2, all -> 0x02d8 }
    L_0x00be:
        r7.flush();	 Catch:{ Exception -> 0x02e2, all -> 0x02d8 }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x02e2, all -> 0x02d8 }
        r6 = r2.getResponseCode();	 Catch:{ Exception -> 0x02e2, all -> 0x02d8 }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3 = "set-cookie";
        r9 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3 = "Content-Encoding";
        r5 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r2 = r14.pvH;	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3 = "Content-Disposition";
        r2 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        if (r2 == 0) goto L_0x0197;
    L_0x00e4:
        r3 = "attachment;";
        r2 = r2.contains(r3);	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        if (r2 == 0) goto L_0x0197;
    L_0x00ed:
        r2 = "download";
        r0 = r16;
        r2 = r0.contains(r2);	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        if (r2 == 0) goto L_0x0197;
    L_0x00f8:
        r2 = 1;
        r8 = r2;
    L_0x00fa:
        r2 = r14.pvH;	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3 = r2.getInputStream();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        if (r5 == 0) goto L_0x02ec;
    L_0x0102:
        r2 = "gzip";
        r2 = r5.contains(r2);	 Catch:{ Exception -> 0x02e6, all -> 0x02db }
        if (r2 == 0) goto L_0x02ec;
    L_0x010b:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x02e6, all -> 0x02db }
        r2.<init>(r3);	 Catch:{ Exception -> 0x02e6, all -> 0x02db }
        r4 = r2;
    L_0x0111:
        r3 = 0;
        if (r8 == 0) goto L_0x01a9;
    L_0x0114:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0159 }
        r10 = pue;	 Catch:{ Exception -> 0x0159 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0159 }
        r11.<init>();	 Catch:{ Exception -> 0x0159 }
        r0 = r17;
        r2 = r0.pug;	 Catch:{ Exception -> 0x0159 }
        r12 = "default_attach_name";
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0159 }
        if (r2 != 0) goto L_0x019b;
    L_0x012a:
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0159 }
        r2 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x0159 }
    L_0x0132:
        r2 = r11.append(r2);	 Catch:{ Exception -> 0x0159 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0159 }
        r5.<init>(r10, r2);	 Catch:{ Exception -> 0x0159 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0159 }
        r10 = 1;
        r2.<init>(r5, r10);	 Catch:{ Exception -> 0x0159 }
        r3 = r2;
    L_0x0144:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0159 }
    L_0x0148:
        r5 = r4.read(r2);	 Catch:{ Exception -> 0x0159 }
        if (r5 <= 0) goto L_0x01b0;
    L_0x014e:
        r10 = 0;
        r3.write(r2, r10, r5);	 Catch:{ Exception -> 0x0159 }
        r3.flush();	 Catch:{ Exception -> 0x0159 }
        r18.bkO();	 Catch:{ Exception -> 0x0159 }
        goto L_0x0148;
    L_0x0159:
        r2 = move-exception;
        r5 = "MicroMsg.URLConnectionUtil";
        r8 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x024b }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r2, r8, r9);	 Catch:{ all -> 0x024b }
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x024b }
        if (r6 != 0) goto L_0x0229;
    L_0x016a:
        r5 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x016c:
        r8 = 0;
        r9 = 0;
        r2.<init>(r5, r8, r9);	 Catch:{ all -> 0x024b }
        if (r3 == 0) goto L_0x0179;
    L_0x0173:
        r3.flush();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3.close();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
    L_0x0179:
        if (r7 == 0) goto L_0x017e;
    L_0x017b:
        r7.close();	 Catch:{ IOException -> 0x022d }
    L_0x017e:
        if (r4 == 0) goto L_0x0183;
    L_0x0180:
        r4.close();	 Catch:{ IOException -> 0x023c }
    L_0x0183:
        r3 = r14.pvH;
        if (r3 == 0) goto L_0x018e;
    L_0x0187:
        r3 = r14.pvH;
        r3 = r3.aBw;
        r3.disconnect();
    L_0x018e:
        return r2;
    L_0x018f:
        r2 = 0;
        goto L_0x0032;
    L_0x0192:
        r2 = "POST";
        goto L_0x0051;
    L_0x0197:
        r2 = 0;
        r8 = r2;
        goto L_0x00fa;
    L_0x019b:
        r0 = r17;
        r2 = r0.pug;	 Catch:{ Exception -> 0x0159 }
        r12 = "default_attach_name";
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0159 }
        r2 = (java.io.Serializable) r2;	 Catch:{ Exception -> 0x0159 }
        goto L_0x0132;
    L_0x01a9:
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0159 }
        r2.<init>();	 Catch:{ Exception -> 0x0159 }
        r3 = r2;
        goto L_0x0144;
    L_0x01b0:
        r5 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ Exception -> 0x0159 }
        r9 = com.tencent.mm.plugin.qqmail.b.h.In(r9);	 Catch:{ Exception -> 0x0159 }
        if (r8 == 0) goto L_0x01fe;
    L_0x01b8:
        r2 = "";
    L_0x01bb:
        r5.<init>(r6, r9, r2);	 Catch:{ Exception -> 0x0159 }
        r2 = "MicroMsg.URLConnectionUtil";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0159 }
        r9 = "uri=";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0159 }
        r0 = r16;
        r8 = r8.append(r0);	 Catch:{ Exception -> 0x0159 }
        r9 = ", ";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0159 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0159 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0159 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r8);	 Catch:{ Exception -> 0x0159 }
        r3.flush();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3.close();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        if (r7 == 0) goto L_0x01ec;
    L_0x01e9:
        r7.close();	 Catch:{ IOException -> 0x020d }
    L_0x01ec:
        if (r4 == 0) goto L_0x01f1;
    L_0x01ee:
        r4.close();	 Catch:{ IOException -> 0x021b }
    L_0x01f1:
        r2 = r14.pvH;
        if (r2 == 0) goto L_0x01fc;
    L_0x01f5:
        r2 = r14.pvH;
        r2 = r2.aBw;
        r2.disconnect();
    L_0x01fc:
        r2 = r5;
        goto L_0x018e;
    L_0x01fe:
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x0159 }
        r0 = r3;
        r0 = (java.io.ByteArrayOutputStream) r0;	 Catch:{ Exception -> 0x0159 }
        r2 = r0;
        r2 = r2.toByteArray();	 Catch:{ Exception -> 0x0159 }
        r8.<init>(r2);	 Catch:{ Exception -> 0x0159 }
        r2 = r8;
        goto L_0x01bb;
    L_0x020d:
        r2 = move-exception;
        r3 = "MicroMsg.URLConnectionUtil";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r6, r7);
        goto L_0x01ec;
    L_0x021b:
        r2 = move-exception;
        r3 = "MicroMsg.URLConnectionUtil";
        r4 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r6);
        goto L_0x01f1;
    L_0x0229:
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x016c;
    L_0x022d:
        r3 = move-exception;
        r5 = "MicroMsg.URLConnectionUtil";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r3, r6, r7);
        goto L_0x017e;
    L_0x023c:
        r3 = move-exception;
        r4 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);
        goto L_0x0183;
    L_0x024b:
        r2 = move-exception;
        if (r3 == 0) goto L_0x0254;
    L_0x024e:
        r3.flush();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
        r3.close();	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
    L_0x0254:
        throw r2;	 Catch:{ Exception -> 0x0255, all -> 0x02d8 }
    L_0x0255:
        r2 = move-exception;
        r3 = r6;
        r5 = r7;
    L_0x0258:
        r6 = "MicroMsg.URLConnectionUtil";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x02a5 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r2, r7, r8);	 Catch:{ all -> 0x02a5 }
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x02a5 }
        if (r3 != 0) goto L_0x0286;
    L_0x0268:
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x026a:
        r6 = 0;
        r7 = 0;
        r2.<init>(r3, r6, r7);	 Catch:{ all -> 0x02a5 }
        if (r5 == 0) goto L_0x0274;
    L_0x0271:
        r5.close();	 Catch:{ IOException -> 0x0289 }
    L_0x0274:
        if (r4 == 0) goto L_0x0279;
    L_0x0276:
        r4.close();	 Catch:{ IOException -> 0x0297 }
    L_0x0279:
        r3 = r14.pvH;
        if (r3 == 0) goto L_0x018e;
    L_0x027d:
        r3 = r14.pvH;
        r3 = r3.aBw;
        r3.disconnect();
        goto L_0x018e;
    L_0x0286:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x026a;
    L_0x0289:
        r3 = move-exception;
        r5 = "MicroMsg.URLConnectionUtil";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r3, r6, r7);
        goto L_0x0274;
    L_0x0297:
        r3 = move-exception;
        r4 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);
        goto L_0x0279;
    L_0x02a5:
        r2 = move-exception;
    L_0x02a6:
        if (r5 == 0) goto L_0x02ab;
    L_0x02a8:
        r5.close();	 Catch:{ IOException -> 0x02bc }
    L_0x02ab:
        if (r4 == 0) goto L_0x02b0;
    L_0x02ad:
        r4.close();	 Catch:{ IOException -> 0x02ca }
    L_0x02b0:
        r3 = r14.pvH;
        if (r3 == 0) goto L_0x02bb;
    L_0x02b4:
        r3 = r14.pvH;
        r3 = r3.aBw;
        r3.disconnect();
    L_0x02bb:
        throw r2;
    L_0x02bc:
        r3 = move-exception;
        r5 = "MicroMsg.URLConnectionUtil";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r3, r6, r7);
        goto L_0x02ab;
    L_0x02ca:
        r3 = move-exception;
        r4 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);
        goto L_0x02b0;
    L_0x02d8:
        r2 = move-exception;
        r5 = r7;
        goto L_0x02a6;
    L_0x02db:
        r2 = move-exception;
        r4 = r3;
        r5 = r7;
        goto L_0x02a6;
    L_0x02df:
        r2 = move-exception;
        goto L_0x0258;
    L_0x02e2:
        r2 = move-exception;
        r5 = r7;
        goto L_0x0258;
    L_0x02e6:
        r2 = move-exception;
        r4 = r3;
        r5 = r7;
        r3 = r6;
        goto L_0x0258;
    L_0x02ec:
        r4 = r3;
        goto L_0x0111;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.x.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.qqmail.b.h$b, com.tencent.mm.plugin.qqmail.b.h$a):com.tencent.mm.plugin.qqmail.b.h$c");
    }

    public final void cancel() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "cancel conection.");
        if (this.pvH != null) {
            this.pvH.aBw.disconnect();
        }
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
