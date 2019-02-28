package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import junit.framework.Assert;

public final class e extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private h hiZ;

    public e(h hVar) {
        this.hiZ = hVar;
    }

    public final boolean a(d dVar) {
        dVar.fEo = -1;
        return ((int) this.hiZ.insert("qcontact", "username", dVar.vP())) != -1;
    }

    public final boolean a(String str, d dVar) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (dVar == null) {
            return false;
        }
        if (this.hiZ.update("qcontact", dVar.vP(), "username=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final d Ii(String str) {
        d dVar = null;
        Cursor a = this.hiZ.a("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bi.oL(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                dVar = new d();
                dVar.username = a.getString(0);
                dVar.hyC = a.getLong(1);
                dVar.extInfo = a.getString(2);
                dVar.ptd = a.getInt(3);
                dVar.pte = a.getLong(4);
                dVar.ptf = a.getLong(5);
                dVar.hiV = a.getInt(6);
                dVar.hxZ = a.getInt(7);
                dVar.hne = a.getInt(8);
                dVar.hnf = a.getInt(9);
                dVar.ptg = a.getString(10);
                dVar.pth = a.getString(11);
                dVar.pti = a.getString(12);
                dVar.ptj = a.getString(13);
            }
            a.close();
        }
        return dVar;
    }
}
