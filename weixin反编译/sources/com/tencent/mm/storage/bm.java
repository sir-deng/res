package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class bm extends i<bl> implements a {
    public static final String[] gLy = new String[]{i.a(bl.gKN, "VoiceTransText")};
    public e gLA;

    public final /* synthetic */ boolean b(c cVar) {
        return a((bl) cVar);
    }

    public bm(e eVar) {
        this(eVar, bl.gKN, "VoiceTransText");
    }

    private bm(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final boolean a(bl blVar) {
        if (blVar == null) {
            return false;
        }
        if (this.gLA.replace("VoiceTransText", "msgId", blVar.vP()) >= 0) {
            return true;
        }
        return false;
    }

    public final bl Yv(String str) {
        if (bi.oN(str)) {
            return null;
        }
        bl blVar = new bl();
        Cursor a = this.gLA.a("VoiceTransText", null, "cmsgId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            blVar.b(a);
        }
        a.close();
        return blVar;
    }
}
