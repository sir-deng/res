package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.HashMap;
import java.util.Map;

public final class g extends i<y> {
    public static final String[] gLy = new String[]{i.a(y.gKN, "WalletLuckyMoney")};
    public static Map<String, y> ijA = new HashMap();
    private e gLA;

    public g(e eVar) {
        super(eVar, y.gKN, "WalletLuckyMoney", null);
        this.gLA = eVar;
    }

    public final y NK(String str) {
        Cursor rawQuery = this.gLA.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[]{str});
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        y yVar = new y();
        yVar.b(rawQuery);
        rawQuery.close();
        return yVar;
    }

    public final boolean a(y yVar) {
        if (yVar != null && ijA.containsKey(yVar.field_mNativeUrl)) {
            ijA.put(yVar.field_mNativeUrl, yVar);
        }
        return super.a(yVar);
    }
}
