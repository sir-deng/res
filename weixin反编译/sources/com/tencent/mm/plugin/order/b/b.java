package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gLy = new String[]{i.a(a.gKN, "OrderCommonMsgXml")};
    private e gLA;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((a) cVar);
    }

    public final /* bridge */ /* synthetic */ boolean c(c cVar, String[] strArr) {
        return super.c((a) cVar, strArr);
    }

    public b(e eVar) {
        super(eVar, a.gKN, "OrderCommonMsgXml", null);
        this.gLA = eVar;
    }

    public final Cursor Tq() {
        return this.gLA.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
    }

    public final boolean a(a aVar) {
        return super.b((c) aVar);
    }
}
