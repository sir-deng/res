package com.tencent.mm.plugin.hp.d;

public final class a implements Runnable {
    public String frM;
    public boolean hmT = true;
    public boolean iaK = true;
    public String ieO;
    public String url;

    public a(String str, String str2, String str3) {
        this.url = str;
        this.ieO = str2;
        this.frM = str3;
        this.iaK = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r12.url;	 Catch:{ InterruptedException -> 0x0299, UnknownHostException -> 0x0101, SSLHandshakeException -> 0x0129, SocketException -> 0x0151, SocketTimeoutException -> 0x0179, IOException -> 0x01a1, Exception -> 0x01c9 }
        r4 = 0;
        r3 = com.tencent.mm.network.b.a(r0, r4);	 Catch:{ InterruptedException -> 0x0299, UnknownHostException -> 0x0101, SSLHandshakeException -> 0x0129, SocketException -> 0x0151, SocketTimeoutException -> 0x0179, IOException -> 0x01a1, Exception -> 0x01c9 }
        r0 = "GET";
        r3.setRequestMethod(r0);	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r3.setConnectTimeout(r0);	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        r0 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r3.setReadTimeout(r0);	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        r0 = com.tencent.mm.network.b.a(r3);	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        if (r0 == 0) goto L_0x0032;
    L_0x0020:
        r0 = "Tinker.TinkerDownloadTask";
        r4 = "checkHttpConnection failed! url:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        r6 = 0;
        r7 = r12.url;	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        r5[r6] = r7;	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        com.tencent.mm.sdk.platformtools.x.e(r0, r4, r5);	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
    L_0x0031:
        return;
    L_0x0032:
        r1 = r3.getInputStream();	 Catch:{ InterruptedException -> 0x029f, UnknownHostException -> 0x027b, SSLHandshakeException -> 0x025d, SocketException -> 0x023f, SocketTimeoutException -> 0x0221, IOException -> 0x0209, Exception -> 0x01f1 }
        if (r1 != 0) goto L_0x00aa;
    L_0x0038:
        r0 = "Tinker.TinkerDownloadTask";
        r4 = "getInputStream failed. url:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
        r6 = 0;
        r7 = r12.url;	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
        r5[r6] = r7;	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r4, r5);	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
        goto L_0x0031;
    L_0x004a:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x004e:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 32;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "[cpan] get image data failed.:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
    L_0x0070:
        if (r11 == 0) goto L_0x0077;
    L_0x0072:
        r0 = r11.aBw;	 Catch:{ Exception -> 0x0082 }
        r0.disconnect();	 Catch:{ Exception -> 0x0082 }
    L_0x0077:
        if (r9 == 0) goto L_0x007c;
    L_0x0079:
        r9.close();	 Catch:{ Exception -> 0x0082 }
    L_0x007c:
        if (r10 == 0) goto L_0x0031;
    L_0x007e:
        r10.close();	 Catch:{ Exception -> 0x0082 }
        goto L_0x0031;
    L_0x0082:
        r0 = move-exception;
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "exception:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "close conn failed : %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r0.getMessage();
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0031;
    L_0x00aa:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
        r4 = r12.ieO;	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
        r2 = com.tencent.mm.modelsfs.FileOp.iH(r4);	 Catch:{ InterruptedException -> 0x004a, UnknownHostException -> 0x0281, SSLHandshakeException -> 0x0263, SocketException -> 0x0245, SocketTimeoutException -> 0x0227, IOException -> 0x020e, Exception -> 0x01f6 }
    L_0x00b4:
        r4 = r1.read(r0);	 Catch:{ InterruptedException -> 0x00c0, UnknownHostException -> 0x0287, SSLHandshakeException -> 0x0269, SocketException -> 0x024b, SocketTimeoutException -> 0x022d, IOException -> 0x0213, Exception -> 0x01fb }
        r5 = -1;
        if (r4 == r5) goto L_0x00c5;
    L_0x00bb:
        r5 = 0;
        r2.write(r0, r5, r4);	 Catch:{ InterruptedException -> 0x00c0, UnknownHostException -> 0x0287, SSLHandshakeException -> 0x0269, SocketException -> 0x024b, SocketTimeoutException -> 0x022d, IOException -> 0x0213, Exception -> 0x01fb }
        goto L_0x00b4;
    L_0x00c0:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x004e;
    L_0x00c5:
        r0 = 0;
        r12.hmT = r0;	 Catch:{ InterruptedException -> 0x00c0, UnknownHostException -> 0x0287, SSLHandshakeException -> 0x0269, SocketException -> 0x024b, SocketTimeoutException -> 0x022d, IOException -> 0x0213, Exception -> 0x01fb }
        r2.close();	 Catch:{ InterruptedException -> 0x00c0, UnknownHostException -> 0x0287, SSLHandshakeException -> 0x0269, SocketException -> 0x024b, SocketTimeoutException -> 0x022d, IOException -> 0x0213, Exception -> 0x01fb }
        r10 = 0;
        r0 = r3.aBw;	 Catch:{ InterruptedException -> 0x02a5, UnknownHostException -> 0x028d, SSLHandshakeException -> 0x026f, SocketException -> 0x0251, SocketTimeoutException -> 0x0233, IOException -> 0x0218, Exception -> 0x0200 }
        r0.disconnect();	 Catch:{ InterruptedException -> 0x02a5, UnknownHostException -> 0x028d, SSLHandshakeException -> 0x026f, SocketException -> 0x0251, SocketTimeoutException -> 0x0233, IOException -> 0x0218, Exception -> 0x0200 }
        r11 = 0;
        r1.close();	 Catch:{ InterruptedException -> 0x02aa, UnknownHostException -> 0x0292, SSLHandshakeException -> 0x0274, SocketException -> 0x0256, SocketTimeoutException -> 0x0238, IOException -> 0x021c, Exception -> 0x0204 }
        r9 = 0;
        r0 = r12.ieO;	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        r0 = com.tencent.mm.a.g.bV(r0);	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        r1 = r12.frM;	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        if (r0 != 0) goto L_0x0070;
    L_0x00e4:
        r0 = "Tinker.TinkerDownloadTask";
        r1 = "hp_apply md5 mismatched, ignored";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 30;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        r0 = 1;
        r12.hmT = r0;	 Catch:{ InterruptedException -> 0x00fe, UnknownHostException -> 0x0296, SSLHandshakeException -> 0x0278, SocketException -> 0x025a, SocketTimeoutException -> 0x023c, IOException -> 0x021f, Exception -> 0x0207 }
        goto L_0x0070;
    L_0x00fe:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0101:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x0105:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 33;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "[cpan] get image data failed.:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0070;
    L_0x0129:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x012d:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 34;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "[cpan] get image data failed.:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0070;
    L_0x0151:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x0155:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 35;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "[cpan] get image data failed.:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0070;
    L_0x0179:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x017d:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 36;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "[cpan] get image data failed.:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0070;
    L_0x01a1:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x01a5:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 37;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "[cpan] get image data failed.:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0070;
    L_0x01c9:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
    L_0x01cd:
        r1 = 1;
        r12.hmT = r1;
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 614; // 0x266 float:8.6E-43 double:3.034E-321;
        r4 = 38;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "Tinker.TinkerDownloadTask";
        r2 = "exception:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0070;
    L_0x01f1:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x01cd;
    L_0x01f6:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x01cd;
    L_0x01fb:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x01cd;
    L_0x0200:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x01cd;
    L_0x0204:
        r0 = move-exception;
        r9 = r1;
        goto L_0x01cd;
    L_0x0207:
        r0 = move-exception;
        goto L_0x01cd;
    L_0x0209:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x01a5;
    L_0x020e:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x01a5;
    L_0x0213:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x01a5;
    L_0x0218:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x01a5;
    L_0x021c:
        r0 = move-exception;
        r9 = r1;
        goto L_0x01a5;
    L_0x021f:
        r0 = move-exception;
        goto L_0x01a5;
    L_0x0221:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x017d;
    L_0x0227:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x017d;
    L_0x022d:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x017d;
    L_0x0233:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x017d;
    L_0x0238:
        r0 = move-exception;
        r9 = r1;
        goto L_0x017d;
    L_0x023c:
        r0 = move-exception;
        goto L_0x017d;
    L_0x023f:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x0155;
    L_0x0245:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x0155;
    L_0x024b:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x0155;
    L_0x0251:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x0155;
    L_0x0256:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0155;
    L_0x025a:
        r0 = move-exception;
        goto L_0x0155;
    L_0x025d:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x012d;
    L_0x0263:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x012d;
    L_0x0269:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x012d;
    L_0x026f:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x012d;
    L_0x0274:
        r0 = move-exception;
        r9 = r1;
        goto L_0x012d;
    L_0x0278:
        r0 = move-exception;
        goto L_0x012d;
    L_0x027b:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x0105;
    L_0x0281:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x0105;
    L_0x0287:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x0105;
    L_0x028d:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x0105;
    L_0x0292:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0105;
    L_0x0296:
        r0 = move-exception;
        goto L_0x0105;
    L_0x0299:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x004e;
    L_0x029f:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        r11 = r3;
        goto L_0x004e;
    L_0x02a5:
        r0 = move-exception;
        r9 = r1;
        r11 = r3;
        goto L_0x004e;
    L_0x02aa:
        r0 = move-exception;
        r9 = r1;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.d.a.run():void");
    }
}
