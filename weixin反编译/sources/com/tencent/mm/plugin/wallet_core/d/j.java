package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends i<af> {
    public static final String[] gLy = new String[]{i.a(af.gKN, "WalletUserInfo")};
    private List<Object> avD = new LinkedList();
    public e gLA;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        if (!super.a((af) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((af) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        if (!super.c((af) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public j(e eVar) {
        super(eVar, af.gKN, "WalletUserInfo", null);
        x.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
        this.gLA = eVar;
    }

    public final af bMZ() {
        af afVar = new af();
        Cursor a = this.gLA.a("select * from WalletUserInfo", null, 2);
        afVar.field_is_reg = -1;
        if (a != null) {
            if (a.moveToNext()) {
                afVar.b(a);
            }
            a.close();
        }
        return afVar;
    }

    public final boolean a(af afVar) {
        if (!super.b((c) afVar)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
