package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i<d> {
    public static final String[] gLy = new String[]{i.a(d.gKN, "shakeitem1")};
    public com.tencent.mm.sdk.e.e gLA;

    public final /* synthetic */ boolean b(c cVar) {
        return a((d) cVar, false);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gKN, "shakeitem1", null);
        this.gLA = eVar;
        x.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        eVar.fD("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        eVar.fD("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
    }

    public final Cursor bsb() {
        return rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", "4");
    }

    public final d bsc() {
        d dVar = new d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            dVar.b(rawQuery);
        }
        rawQuery.close();
        return dVar;
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == null) {
            return false;
        }
        if (!(z || bi.oN(dVar.field_username))) {
            JJ(dVar.field_username);
        }
        dVar.fEo = -1;
        return super.b((c) dVar);
    }

    public final int wr(int i) {
        int delete = this.gLA.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i)});
        doNotify();
        x.i("MicroMsg.NewShakeItemStorage", "delById id:" + i + " result:" + delete);
        return delete;
    }

    public final int JJ(String str) {
        int delete = this.gLA.delete("shakeitem1", "(username=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        return delete;
    }

    public final boolean ws(int i) {
        boolean fD;
        if (i == 0) {
            fD = this.gLA.fD("shakeitem1", "delete from shakeitem1 where type = " + i + " or type is null");
        } else {
            fD = this.gLA.fD("shakeitem1", "delete from shakeitem1 where type = " + i);
        }
        doNotify();
        return fD;
    }

    public final boolean bsd() {
        boolean fD = this.gLA.fD("shakeitem1", "delete from shakeitem1");
        doNotify();
        return fD;
    }

    public final void bse() {
        x.i("MicroMsg.NewShakeItemStorage", "setAllOld");
        d dVar = new d();
        dVar.field_insertBatch = 0;
        dVar.fEo = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (-1 != this.gLA.update("shakeitem1", dVar.vP(), "insertBatch!=?", new String[]{"0"})) {
            doNotify();
        }
    }
}
