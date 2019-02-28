package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements l {
    byte[] ksL = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] ksM = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public final int a(com.tencent.mm.protocal.c.ev r10, boolean r11, com.tencent.mm.storage.au r12, java.lang.String r13, java.util.LinkedList<com.tencent.mm.plugin.backup.h.u> r14, java.util.HashMap<java.lang.Long, com.tencent.mm.plugin.backup.e.h.a> r15, boolean r16, long r17) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r12.field_imgPath;
        r1 = com.tencent.mm.plugin.backup.g.c.we(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r0 == 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = new java.io.File;
        r0.<init>(r1);
        r2 = r0.exists();
        if (r2 != 0) goto L_0x001b;
    L_0x0019:
        r0 = 0;
        goto L_0x000d;
    L_0x001b:
        r2 = r0.length();
        r8 = (int) r2;
        if (r11 == 0) goto L_0x0024;
    L_0x0022:
        r0 = r8;
        goto L_0x000d;
    L_0x0024:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 9;
        r7 = 0;
        r2 = r10;
        r3 = r14;
        r5 = r16;
        r6 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r1 = d(r12, r8);
        if (r1 != 0) goto L_0x003e;
    L_0x003c:
        r0 = 0;
        goto L_0x000d;
    L_0x003e:
        r2 = new com.tencent.mm.protocal.c.bet;
        r2.<init>();
        r2 = r2.Vf(r1);
        r10.vNO = r2;
        r1 = r1.length();
        r0 = r0 + r1;
        if (r8 != 0) goto L_0x000d;
    L_0x0050:
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.e.g.a(com.tencent.mm.protocal.c.ev, boolean, com.tencent.mm.storage.au, java.lang.String, java.util.LinkedList, java.util.HashMap, boolean, long):int");
    }

    public final int a(String str, ev evVar, au auVar) {
        String str2 = evVar.vNO.wRo;
        if (c.eX(evVar.vNM.wRo)) {
            int hR = c.hR(str2);
            if (hR != -1 && hR + 2 < str2.length()) {
                str2 = str2.substring(hR + 2);
            }
            x.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", str2);
        }
        Map y = bj.y(str2, "msg");
        if (y != null) {
            try {
                auVar.setContent(n.b((String) y.get(".msg.voicemsg.$fromusername"), (long) com.tencent.mm.plugin.backup.a.g.aS((String) y.get(".msg.voicemsg.$voicelength"), 0), com.tencent.mm.plugin.backup.a.g.aS((String) y.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Throwable e) {
                x.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BackupItemVoice", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", evVar.vNO.wRo);
            auVar.setContent(evVar.vNO.wRo);
        }
        str2 = u.oi(evVar.vNM.wRo);
        auVar.dV(str2);
        c.i(auVar);
        str2 = c.we(str2);
        String a = com.tencent.mm.plugin.backup.a.g.a(evVar, 9);
        if (!bi.oN(a)) {
            a = com.tencent.mm.plugin.backup.a.g.vS(a) + a;
            if (e.bO(a)) {
                byte[] e2 = e.e(a, 0, 9);
                if (d(this.ksL, e2)) {
                    e2 = e.e(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, e2, e2.length);
                } else if (d(this.ksM, e2)) {
                    e2 = e.e(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, e2, e2.length);
                }
            }
        }
        if (!(str2 == null || com.tencent.mm.plugin.backup.a.g.b(evVar, 9, str2))) {
            a = com.tencent.mm.plugin.backup.a.g.a(evVar, 9);
            if (a != null) {
                x.d("MicroMsg.BackupItemVoice", "recover from path:%s", com.tencent.mm.plugin.backup.a.g.vS(a) + a);
                k.r(a, str2, false);
            }
        }
        return 0;
    }

    private static boolean d(byte[] bArr, byte[] bArr2) {
        if (bi.by(bArr2)) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String d(au auVar, int i) {
        String str = null;
        if (!bi.oN(auVar.field_content)) {
            n nVar = new n(auVar.field_content);
            Writer stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", "0");
                newSerializer.attribute(null, "voicelength", nVar.time);
                if (!bi.oN(nVar.hXn)) {
                    newSerializer.attribute(null, "fromusername", nVar.hXn);
                }
                newSerializer.attribute(null, "isPlayed", nVar.hXo ? "1" : "0");
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (c.eX(auVar.field_talker)) {
                    str = nVar.hXn + ":\n" + str;
                }
                x.i("MicroMsg.BackupItemVoice", "parseContent xml:%s", str);
            } catch (Exception e) {
                x.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + e.toString());
            }
        }
        return str;
    }
}
