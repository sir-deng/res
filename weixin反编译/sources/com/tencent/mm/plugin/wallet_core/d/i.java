package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends com.tencent.mm.sdk.e.i<ac> {
    public static final String[] gLy = new String[]{com.tencent.mm.sdk.e.i.a(ac.gKN, "WalletRegionGreyAreaList")};
    private e gLA;

    public i(e eVar) {
        super(eVar, ac.gKN, "WalletRegionGreyAreaList", null);
        this.gLA = eVar;
    }

    public final void a(int i, axe axe) {
        c acVar = new ac();
        acVar.field_wallet_region = i;
        try {
            acVar.field_wallet_grey_item_buf = axe.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.a(acVar);
    }

    public final ac zD(int i) {
        String str = "select * from WalletRegionGreyAreaList where wallet_region = " + i;
        Cursor a = this.gLA.a(str, null, 2);
        x.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem " + str);
        if (a == null) {
            return new ac();
        }
        ac acVar = new ac();
        if (a.moveToNext()) {
            acVar = new ac();
            acVar.b(a);
        }
        x.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        a.close();
        return acVar;
    }
}
