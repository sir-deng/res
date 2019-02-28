package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.messenger.foundation.a.m;

public final class c implements m {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, com.tencent.mm.ad.d.a r11) {
        /*
        r8 = this;
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: received template msg!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        if (r11 == 0) goto L_0x0023;
    L_0x000b:
        r0 = r11.hoa;
        if (r0 == 0) goto L_0x0023;
    L_0x000f:
        r0 = r11.hoa;
        r0 = r0.vNO;
        if (r0 == 0) goto L_0x0023;
    L_0x0015:
        r0 = r11.hoa;
        r0 = r0.vNO;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0050;
    L_0x0023:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: received msg is null!!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 836; // 0x344 float:1.171E-42 double:4.13E-321;
        r4 = 3;
        r0.h(r2, r4);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 15240; // 0x3b88 float:2.1356E-41 double:7.5296E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
    L_0x004f:
        return;
    L_0x0050:
        r0 = r11.hoa;
        r0 = r0.vNO;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x00c3;
    L_0x005e:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: raw msg is null or nil! direct return";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = 0;
    L_0x0068:
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x0120;
    L_0x006e:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: can not retrieve msg info from real content!!";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = 0;
    L_0x0078:
        if (r0 == 0) goto L_0x01d6;
    L_0x007a:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 836; // 0x344 float:1.171E-42 double:4.13E-321;
        r4 = 2;
        r0.h(r2, r4);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 15240; // 0x3b88 float:2.1356E-41 double:7.5296E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = com.tencent.mm.plugin.appbrand.l.b.akm();
        r1 = r0.jMz;
        monitor-enter(r1);
        r0 = com.tencent.mm.kernel.g.Dq();	 Catch:{ all -> 0x00c0 }
        r0 = r0.Db();	 Catch:{ all -> 0x00c0 }
        r2 = com.tencent.mm.storage.w.a.USERINFO_V8_ATTENDED_FLAG_BOOLEAN_SYNC;	 Catch:{ all -> 0x00c0 }
        r3 = 0;
        r0 = r0.getBoolean(r2, r3);	 Catch:{ all -> 0x00c0 }
        if (r0 != 0) goto L_0x013c;
    L_0x00b5:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r2 = "hy: received template msg but no flag msg received! ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x00c0 }
        monitor-exit(r1);	 Catch:{ all -> 0x00c0 }
        goto L_0x004f;
    L_0x00c0:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00c0 }
        throw r0;
    L_0x00c3:
        r1 = "<msg>";
        r1 = r0.indexOf(r1);
        r2 = "</msg>";
        r2 = r0.lastIndexOf(r2);
        r2 = r2 + 6;
        r3 = "MicroMsg.P8TemplateMsgHandler";
        r4 = "hy: start pos: %d, end pos: %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r2);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.v(r3, r4, r5);
        if (r1 < 0) goto L_0x00f1;
    L_0x00ef:
        if (r2 >= 0) goto L_0x00fd;
    L_0x00f1:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: not contain template msg!!";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = 0;
        goto L_0x0068;
    L_0x00fd:
        r0 = r0.substring(r1, r2);
        r1 = "<msg>";
        r1 = java.util.regex.Pattern.quote(r1);
        r2 = "<msg><fromP8>1</fromP8>";
        r0 = r0.replaceFirst(r1, r2);
        r1 = "MicroMsg.P8TemplateMsgHandler";
        r2 = "hy: real msg is %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.v(r1, r2, r3);
        goto L_0x0068;
    L_0x0120:
        r1 = "notifymessage";
        r2 = r11.hoa;
        r0 = com.tencent.mm.platformtools.n.oK(r0);
        r2.vNO = r0;
        r0 = r11.hoa;
        r1 = com.tencent.mm.platformtools.n.oK(r1);
        r0.vNM = r1;
        r0 = r11.hoa;
        r1 = 49;
        r0.nlX = r1;
        r0 = 1;
        goto L_0x0078;
    L_0x013c:
        monitor-exit(r1);	 Catch:{ all -> 0x00c0 }
        if (r11 == 0) goto L_0x0143;
    L_0x013f:
        r0 = r11.hoa;
        if (r0 != 0) goto L_0x01ab;
    L_0x0143:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: addMsgInfo or addMsgInfo.addMsg is null! should not happen";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = 0;
    L_0x014d:
        if (r0 == 0) goto L_0x01cb;
    L_0x014f:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: add success!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 836; // 0x344 float:1.171E-42 double:4.13E-321;
        r4 = 4;
        r0.h(r2, r4);
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.aZO();
        r1 = "notifymessage";
        r2 = r11.hoa;
        r2 = r2.vNU;
        r2 = (long) r2;
        r0 = r0.H(r1, r2);
        r1 = "MicroMsg.P8TemplateMsgHandler";
        r2 = "hy: msgid is %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r6 = r0.field_msgId;
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.v(r1, r2, r3);
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 15241; // 0x3b89 float:2.1357E-41 double:7.53E-320;
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r6 = r0.field_msgId;
        r0 = java.lang.Long.valueOf(r6);
        r3[r4] = r0;
        r1.h(r2, r3);
        goto L_0x004f;
    L_0x01ab:
        r0 = 0;
        r1 = com.tencent.mm.plugin.messenger.foundation.a.s.aZP();
        if (r1 == 0) goto L_0x0204;
    L_0x01b2:
        r0 = r1.get();
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.r) r0;
        r1 = r0;
    L_0x01b9:
        r0 = r11.hoa;
        r2 = 0;
        r0.vNL = r2;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.g.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.g) r0;
        r0.a(r11, r1);
        r0 = 1;
        goto L_0x014d;
    L_0x01cb:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: add failed!";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x004f;
    L_0x01d6:
        r0 = "MicroMsg.P8TemplateMsgHandler";
        r1 = "hy: replace msg failed!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 836; // 0x344 float:1.171E-42 double:4.13E-321;
        r4 = 3;
        r0.h(r2, r4);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 15240; // 0x3b88 float:2.1356E-41 double:7.5296E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x004f;
    L_0x0204:
        r1 = r0;
        goto L_0x01b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.l.c.b(java.lang.String, java.util.Map, com.tencent.mm.ad.d$a):void");
    }
}
