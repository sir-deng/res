package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import junit.framework.Assert;

public final class h {
    public static java.lang.String aJ(java.lang.String r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fu();
        r1 = "recbiz_";
        r2 = ".rec";
        r3 = 2;
        r0 = com.tencent.mm.sdk.platformtools.i.a(r0, r1, r4, r2, r3);
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x001a;
    L_0x0018:
        r0 = 0;
    L_0x0019:
        return r0;
    L_0x001a:
        if (r5 != 0) goto L_0x0019;
    L_0x001c:
        r1 = new java.io.File;
        r1.<init>(r0);
        r1 = r1.exists();
        if (r1 == 0) goto L_0x0019;
    L_0x0027:
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.c.h.aJ(java.lang.String, boolean):java.lang.String");
    }

    public static boolean oc(String str) {
        if (str == null) {
            return false;
        }
        g MP = MP(str);
        if (MP == null) {
            x.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + str);
            return true;
        }
        x.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + MP.field_msglocalid);
        if (MP.field_msglocalid != 0) {
            as.Hm();
            c.Fh().dJ((long) MP.field_msglocalid);
        }
        if (str == null) {
            return false;
        }
        d.bEL().iI(str);
        nY(str);
        return new File(aJ(str, false)).delete();
    }

    static void nY(String str) {
        d.bEL().nY(aJ(str, false));
    }

    public static g MP(String str) {
        k bEL = d.bEL();
        g gVar = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor a = bEL.gLA.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            gVar = new g();
            gVar.b(a);
        }
        a.close();
        return gVar;
    }

    public static boolean nC(String str) {
        boolean z = false;
        if (str != null) {
            g MP = MP(str);
            if (MP == null) {
                x.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + str);
            } else {
                MP.field_status = 98;
                MP.field_lastmodifytime = System.currentTimeMillis() / 1000;
                MP.fEo = 320;
                z = a(MP);
                x.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + MP.field_msglocalid + " old stat:" + MP.field_status);
                if (MP.field_msglocalid == 0 || bi.oN(MP.field_user)) {
                    x.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + MP.field_msglocalid + " user:" + MP.field_user);
                } else {
                    as.Hm();
                    au dI = c.Fh().dI((long) MP.field_msglocalid);
                    dI.ao((long) MP.field_msglocalid);
                    dI.eR(5);
                    dI.dU(MP.field_user);
                    dI.setContent(f.b(MP.field_human, -1, true));
                    as.Hm();
                    c.Fh().a(dI.field_msgId, dI);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        if (gVar == null || gVar.fEo == -1) {
            return false;
        }
        k bEL = d.bEL();
        Assert.assertTrue(gVar.field_filename.length() > 0);
        Assert.assertTrue(gVar != null);
        ContentValues vP = gVar.vP();
        if (vP.size() <= 0) {
            x.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
            return false;
        }
        if (bEL.gLA.update("VoiceRemindInfo", vP, "filename= ?", new String[]{r4}) <= 0) {
            return false;
        }
        bEL.doNotify();
        return true;
    }

    public static c MQ(String str) {
        k bEL = d.bEL();
        String aJ = aJ(str, false);
        if (bEL.scL.get(aJ) == null) {
            bEL.scL.put(aJ, new c(aJ));
        }
        return (c) bEL.scL.get(aJ);
    }
}
