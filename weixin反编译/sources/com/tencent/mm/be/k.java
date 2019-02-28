package com.tencent.mm.be;

import android.database.Cursor;
import com.tencent.mm.ac.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import java.util.ArrayList;

public final class k extends i<j> {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] gLy = new String[]{i.a(j.gKN, "shakeverifymessage")};
    public e gLA;

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(e eVar) {
        super(eVar, j.gKN, "shakeverifymessage", fNF);
        this.gLA = eVar;
    }

    public final int Tx() {
        Cursor a = this.gLA.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        a.close();
        return 0;
    }

    public final int getCount() {
        Cursor a = this.gLA.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        a.close();
        return 0;
    }

    public final j TB() {
        Cursor a = this.gLA.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            j jVar = new j();
            jVar.b(a);
            a.close();
            return jVar;
        }
        a.close();
        return null;
    }

    public final void nc(String str) {
        int delete = this.gLA.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void TA() {
        this.gLA.delete(getTableName(), null, null);
    }

    public final void a(bx bxVar, d dVar) {
        x.d("MicroMsg.ShakeVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + bxVar.kyY + ", id = " + bxVar.vNT);
        j jVar = new j();
        jVar.field_content = n.a(bxVar.vNO);
        jVar.field_createtime = bi.Wx();
        jVar.field_imgpath = "";
        jVar.field_sayhicontent = dVar.content;
        jVar.field_sayhiuser = dVar.sfb;
        jVar.field_scene = dVar.scene;
        jVar.field_status = bxVar.kyY > 3 ? bxVar.kyY : 3;
        jVar.field_svrid = bxVar.vNT;
        jVar.field_talker = n.a(bxVar.vNM);
        jVar.field_type = bxVar.nlX;
        jVar.field_isSend = 0;
        a(jVar);
        b.I(jVar.field_sayhiuser, 3);
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b((c) jVar)) {
            return false;
        } else {
            WI(jVar.xrR);
            return true;
        }
    }

    public final j ni(String str) {
        j[] W = W(str, 1);
        if (W != null) {
            return W[0];
        }
        return null;
    }

    public final j[] W(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gLA.a("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bi.oL(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            j jVar = new j();
            jVar.b(a);
            arrayList.add(jVar);
        }
        a.close();
        if (arrayList.size() != 0) {
            return (j[]) arrayList.toArray(new j[arrayList.size()]);
        }
        return null;
    }

    public final j[] nj(String str) {
        x.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor a = this.gLA.a("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bi.oL(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            j jVar = new j();
            jVar.b(a);
            arrayList.add(jVar);
        }
        a.close();
        if (arrayList.size() == 0) {
            return null;
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    public static long nh(String str) {
        long j = 0;
        if (str != null) {
            j TB = l.TG().TB();
            if (TB != null) {
                j = TB.field_createtime + 1;
            }
        }
        long Wx = bi.Wx();
        return j > Wx ? j : Wx;
    }
}
