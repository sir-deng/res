package com.tencent.mm.ui.chatting;

import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import java.util.List;

public final class m {
    public static boolean a(a aVar, List<au> list, x xVar) {
        if (aVar == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            return false;
        } else if (list == null || list.isEmpty()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            return false;
        } else if (xVar != null && ((int) xVar.gKO) > 0) {
            return b(aVar, list, xVar);
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(com.tencent.mm.ui.chatting.ChattingUI.a r10, java.util.List<com.tencent.mm.storage.au> r11, com.tencent.mm.storage.x r12) {
        /*
        r9 = 0;
        r8 = 2;
        r4 = 1;
        r5 = 0;
        r0 = r12.field_username;
        r1 = "@chatroom";
        r0 = r0.endsWith(r1);
        if (r0 != 0) goto L_0x00ac;
    L_0x000f:
        r0 = com.tencent.mm.R.l.eKh;
        r0 = r10.getString(r0);
        r1 = new java.lang.Object[r8];
        r2 = r12.AW();
        r1[r5] = r2;
        com.tencent.mm.y.as.Hm();
        r2 = com.tencent.mm.y.c.Db();
        r3 = 4;
        r2 = r2.get(r3, r9);
        r1[r4] = r2;
        r0 = java.lang.String.format(r0, r1);
        r3 = r0;
    L_0x0030:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 10811; // 0x2a3b float:1.515E-41 double:5.3413E-320;
        r2 = new java.lang.Object[r8];
        r6 = 7;
        r6 = java.lang.Integer.valueOf(r6);
        r2[r5] = r6;
        r6 = r11.size();
        r6 = java.lang.Integer.valueOf(r6);
        r2[r4] = r6;
        r0.h(r1, r2);
        r0 = com.tencent.mm.y.q.Gj();
        r0 = r0 & 1;
        if (r0 != 0) goto L_0x0191;
    L_0x0052:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r1 = "use qq mail plugin to send mail";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r6 = r11.iterator();
    L_0x0069:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0148;
    L_0x006f:
        r0 = r6.next();
        r0 = (com.tencent.mm.storage.au) r0;
        r7 = r0.cjW();
        if (r7 == 0) goto L_0x010c;
    L_0x007b:
        com.tencent.mm.modelvideo.o.Ub();
        r0 = r0.field_imgPath;
        r0 = com.tencent.mm.modelvideo.s.nx(r0);
        r1.add(r0);
        r2.add(r9);
    L_0x008a:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r7 = new java.lang.StringBuilder;
        r8 = "file path = ";
        r7.<init>(r8);
        r7 = r7.append(r1);
        r8 = "file name = ";
        r7 = r7.append(r8);
        r7 = r7.append(r2);
        r7 = r7.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r7);
        goto L_0x0069;
    L_0x00ac:
        r0 = r12.field_nickname;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0107;
    L_0x00b4:
        r0 = r12.field_username;
        r1 = com.tencent.mm.y.m.gl(r0);
        r0 = "";
        r2 = r1.iterator();
        r1 = r0;
    L_0x00c2:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00ec;
    L_0x00c8:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.y.r.gw(r0);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r1 = r3.append(r1);
        r0 = r1.append(r0);
        r1 = ", ";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = r0;
        goto L_0x00c2;
    L_0x00ec:
        r0 = r1.length();
        r0 = r0 + -2;
        r0 = r1.substring(r5, r0);
    L_0x00f6:
        r1 = com.tencent.mm.R.l.eKi;
        r1 = r10.getString(r1);
        r2 = new java.lang.Object[r4];
        r2[r5] = r0;
        r0 = java.lang.String.format(r1, r2);
        r3 = r0;
        goto L_0x0030;
    L_0x0107:
        r0 = r12.AW();
        goto L_0x00f6;
    L_0x010c:
        r7 = r0.aNJ();
        if (r7 == 0) goto L_0x008a;
    L_0x0112:
        r0 = r0.field_content;
        r0 = com.tencent.mm.x.g.a.fV(r0);
        if (r0 == 0) goto L_0x0069;
    L_0x011a:
        r7 = r0.type;
        switch(r7) {
            case 4: goto L_0x0121;
            case 5: goto L_0x011f;
            case 6: goto L_0x0121;
            default: goto L_0x011f;
        };
    L_0x011f:
        goto L_0x008a;
    L_0x0121:
        r7 = com.tencent.mm.pluginsdk.model.app.an.aqK();
        r8 = r0.for;
        r7 = r7.Se(r8);
        if (r7 == 0) goto L_0x0069;
    L_0x012d:
        r8 = new java.io.File;
        r7 = r7.field_fileFullPath;
        r8.<init>(r7);
        r7 = r8.exists();
        if (r7 == 0) goto L_0x008a;
    L_0x013a:
        r7 = r8.getAbsolutePath();
        r1.add(r7);
        r0 = r0.title;
        r2.add(r0);
        goto L_0x008a;
    L_0x0148:
        r0 = new com.tencent.mm.ui.chatting.QQMailHistoryExporter;
        r6 = r10.getContext();
        r0.<init>(r6, r11, r12);
        r0 = r0.ctQ();
        r6 = new android.content.Intent;
        r6.<init>();
        r7 = "mail_mode";
        r8 = 6;
        r6.putExtra(r7, r8);
        r7 = "mail_content";
        r6.putExtra(r7, r0);
        r0 = "subject";
        r6.putExtra(r0, r3);
        r0 = "show_qqmail";
        r6.putExtra(r0, r4);
        r3 = "mail_attach";
        r0 = r1;
        r0 = (java.util.ArrayList) r0;
        r6.putStringArrayListExtra(r3, r0);
        r1 = "mail_attach_title";
        r0 = r2;
        r0 = (java.util.ArrayList) r0;
        r6.putStringArrayListExtra(r1, r0);
        r0 = "qqmail";
        r1 = ".ui.ComposeUI";
        r2 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        com.tencent.mm.bl.d.a(r10, r0, r1, r6, r2);
    L_0x0190:
        return r5;
    L_0x0191:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r1 = "use order mail app to send mail";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r1 = new com.tencent.mm.ui.chatting.ae;
        r0 = r10.getContext();
        r1.<init>(r0, r11, r12);
        r0 = r1.ctQ();
        r2 = new android.content.Intent;
        r6 = "android.intent.action.SEND_MULTIPLE";
        r2.<init>(r6);
        r6 = "message/rfc822";
        r2.setType(r6);
        r6 = "android.intent.extra.SUBJECT";
        r2.putExtra(r6, r3);
        r3 = "android.intent.extra.TEXT";
        r2.putExtra(r3, r0);
        r3 = "android.intent.extra.STREAM";
        r6 = "MicroMsg.OtherMailHistoryExporter";
        r7 = "get image attach: history is null? %B, selectItems.size = %d";
        r8 = new java.lang.Object[r8];
        r0 = r1.mTH;
        if (r0 != 0) goto L_0x01fe;
    L_0x01d0:
        r0 = r4;
    L_0x01d1:
        r0 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r0;
        r0 = r1.yAp;
        r0 = r0.size();
        r0 = java.lang.Integer.valueOf(r0);
        r8[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);
        r0 = r1.mTH;
        if (r0 == 0) goto L_0x0200;
    L_0x01ea:
        r0 = r1.yFY;
    L_0x01ec:
        r2.putParcelableArrayListExtra(r3, r0);
        r0 = com.tencent.mm.R.l.eKg;	 Catch:{ ActivityNotFoundException -> 0x020f }
        r0 = r10.getString(r0);	 Catch:{ ActivityNotFoundException -> 0x020f }
        r0 = android.content.Intent.createChooser(r2, r0);	 Catch:{ ActivityNotFoundException -> 0x020f }
        r10.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x020f }
    L_0x01fc:
        r5 = r4;
        goto L_0x0190;
    L_0x01fe:
        r0 = r5;
        goto L_0x01d1;
    L_0x0200:
        r0 = "MicroMsg.OtherMailHistoryExporter";
        r6 = "had not exported, do export first";
        com.tencent.mm.sdk.platformtools.x.w(r0, r6);
        r1.ctQ();
        r0 = r1.yFY;
        goto L_0x01ec;
    L_0x020f:
        r0 = move-exception;
        r0 = r10.getContext();
        r1 = com.tencent.mm.R.l.eKj;
        r0 = android.widget.Toast.makeText(r0, r1, r5);
        r0.show();
        goto L_0x01fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.m.b(com.tencent.mm.ui.chatting.ChattingUI$a, java.util.List, com.tencent.mm.storage.x):boolean");
    }
}
