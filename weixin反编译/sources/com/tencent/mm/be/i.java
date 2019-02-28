package com.tencent.mm.be;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.ac.b;
import com.tencent.mm.f.b.cb;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class i extends com.tencent.mm.sdk.e.i<h> {
    public static final String[] gLy = new String[]{com.tencent.mm.sdk.e.i.a(h.gKN, "LBSVerifyMessage")};
    public e gLA;

    public final /* synthetic */ boolean b(c cVar) {
        return a((h) cVar);
    }

    public i(e eVar) {
        super(eVar, h.gKN, "LBSVerifyMessage", cb.fNF);
        this.gLA = eVar;
    }

    public final int Tx() {
        Cursor a = this.gLA.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            return i;
        }
        a.close();
        return 0;
    }

    public final int getCount() {
        int i = 0;
        Cursor a = this.gLA.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final h Ty() {
        Cursor a = this.gLA.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            h hVar = new h();
            hVar.b(a);
            a.close();
            return hVar;
        }
        a.close();
        return null;
    }

    public final void Tz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        if (this.gLA.update(getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            doNotify();
        }
    }

    public final void nc(String str) {
        int delete = this.gLA.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void nd(String str) {
        int delete = this.gLA.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + delete);
    }

    public final void TA() {
        this.gLA.delete(getTableName(), null, null);
    }

    public final void a(bx bxVar, d dVar) {
        x.d("MicroMsg.LBSVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + bxVar.kyY + ", id = " + bxVar.vNT);
        h hVar = new h();
        hVar.field_content = n.a(bxVar.vNO);
        hVar.field_createtime = bi.Wx();
        hVar.field_imgpath = "";
        hVar.field_sayhicontent = dVar.content;
        hVar.field_sayhiuser = dVar.sfb;
        hVar.field_scene = dVar.scene;
        hVar.field_status = bxVar.kyY > 3 ? bxVar.kyY : 3;
        hVar.field_svrid = bxVar.vNT;
        hVar.field_talker = n.a(bxVar.vNM);
        hVar.field_type = bxVar.nlX;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = dVar.xHX;
        hVar.field_ticket = dVar.mTU;
        hVar.field_flag = 1;
        a(hVar);
        b.I(hVar.field_sayhiencryptuser, 3);
    }

    public final boolean a(h hVar) {
        if (hVar == null) {
            x.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            return false;
        } else if (!super.b((c) hVar)) {
            return false;
        } else {
            WI(hVar.xrR);
            return true;
        }
    }

    public final h[] ne(String str) {
        x.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor a = this.gLA.a("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bi.oL(str) + "' or sayhiencryptuser = '" + bi.oL(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            h hVar = new h();
            hVar.b(a);
            arrayList.add(hVar);
        }
        a.close();
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public final h nf(String str) {
        h hVar = null;
        x.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor a = this.gLA.a("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bi.oL(str) + "' or sayhiencryptuser = '" + bi.oL(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            hVar = new h();
            hVar.b(a);
        } else {
            x.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        a.close();
        return hVar;
    }

    public final h ng(String str) {
        h[] V = V(str, 1);
        if (V != null) {
            return V[0];
        }
        return null;
    }

    public final h[] V(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gLA.a("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bi.oL(str) + "' or sayhiencryptuser = '" + bi.oL(str) + "') order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            h hVar = new h();
            hVar.b(a);
            arrayList.add(hVar);
        }
        a.close();
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public static long nh(String str) {
        h hVar = null;
        long j = 0;
        if (str != null) {
            i TF = l.TF();
            Cursor a = TF.gLA.a("SELECT * FROM " + TF.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    hVar = new h();
                    hVar.b(a);
                    a.close();
                } else {
                    a.close();
                }
            }
            if (hVar != null) {
                j = hVar.field_createtime + 1;
            }
        }
        long Wx = bi.Wx();
        return j > Wx ? j : Wx;
    }
}
