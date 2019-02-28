package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends i<e> {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    public static final String[] gLy = new String[]{i.a(e.gKN, "adsnsinfo")};
    private static final String ruP = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[]{"snsId", "createTime"});
    public e gLA;

    public final /* synthetic */ boolean a(long j, c cVar) {
        return b(j, (e) cVar);
    }

    public f(e eVar) {
        super(eVar, e.gKN, "adsnsinfo", fNF);
        this.gLA = eVar;
    }

    public final e eL(long j) {
        e eVar = new e();
        Cursor a = this.gLA.a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null, 2);
        if (a.moveToFirst()) {
            eVar.b(a);
            a.close();
            return eVar;
        }
        a.close();
        return null;
    }

    public final e xC(int i) {
        e eVar = new e();
        Cursor a = this.gLA.a("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=" + i, null, 2);
        if (a.moveToFirst()) {
            eVar.b(a);
            a.close();
            return eVar;
        }
        a.close();
        return null;
    }

    public final boolean a(long j, e eVar) {
        if (eM(j)) {
            return b(j, eVar);
        }
        int i;
        x.d("MicroMsg.AdSnsInfoStorage", "added PcId " + j);
        x.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (eVar == null) {
            i = -1;
        } else {
            i = (int) this.gLA.insert("AdSnsInfo", "", eVar.vP());
            x.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result" + i);
        }
        return i != -1;
    }

    public final boolean b(long j, e eVar) {
        ContentValues vP = eVar.vP();
        vP.remove("rowid");
        if (this.gLA.update("AdSnsInfo", vP, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean eM(long j) {
        Cursor a = this.gLA.a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    public final boolean delete(long j) {
        int delete = this.gLA.delete("AdSnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        x.i("MicroMsg.AdSnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }
}
