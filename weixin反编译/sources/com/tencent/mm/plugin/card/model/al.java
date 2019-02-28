package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class al extends i<ak> {
    public static final String[] gLy = new String[]{i.a(ak.gKN, "PendingCardId")};
    e gLA;

    public al(e eVar) {
        super(eVar, ak.gKN, "PendingCardId", null);
        this.gLA = eVar;
    }

    public final List<ak> ave() {
        List<ak> arrayList = new ArrayList();
        Cursor a = this.gLA.a("select * from PendingCardId where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            ak akVar = new ak();
            akVar.b(a);
            arrayList.add(akVar);
        }
        a.close();
        x.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
