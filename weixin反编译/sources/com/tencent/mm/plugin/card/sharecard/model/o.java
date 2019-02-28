package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class o extends i<n> {
    public static final String[] gLy = new String[]{i.a(n.gKN, "ShareCardSyncItemInfo")};
    private e gLA;

    public o(e eVar) {
        super(eVar, n.gKN, "ShareCardSyncItemInfo", null);
        this.gLA = eVar;
    }

    public final List<n> ave() {
        List<n> arrayList = new ArrayList();
        Cursor a = this.gLA.a("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            n nVar = new n();
            nVar.b(a);
            arrayList.add(nVar);
        }
        a.close();
        x.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
