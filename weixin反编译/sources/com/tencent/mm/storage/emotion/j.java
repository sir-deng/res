package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends i<i> implements a {
    public static final String[] gLy = new String[]{i.a(i.gKN, "EmotionDetailInfo")};
    public e gLA;

    public j(e eVar) {
        super(eVar, i.gKN, "EmotionDetailInfo", null);
        this.gLA = eVar;
    }

    public final String getTableName() {
        return "EmotionDetailInfo";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final i YH(String str) {
        i iVar = null;
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content", "lan"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.gLA.a("EmotionDetailInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                iVar = new i();
                iVar.field_content = a.getBlob(0);
                iVar.field_lan = a.getString(1);
                iVar.field_productID = str;
            }
            if (a != null) {
                a.close();
            }
        }
        return iVar;
    }
}
