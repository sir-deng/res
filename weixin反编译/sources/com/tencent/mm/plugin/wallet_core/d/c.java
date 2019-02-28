package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends i<Bankcard> {
    public static final String[] gLy = new String[]{i.a(Bankcard.gKN, "WalletBankcard")};
    private List<Object> avD = new LinkedList();
    public e gLA;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        if (!super.a((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        return e((Bankcard) cVar);
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        if (!super.c((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public c(e eVar) {
        super(eVar, Bankcard.gKN, "WalletBankcard", null);
        this.gLA = eVar;
    }

    public final ArrayList<Bankcard> bMJ() {
        ArrayList<Bankcard> arrayList = null;
        Cursor a = this.gLA.a("select * from WalletBankcard where cardType <= 7", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.b(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bMX() {
        ArrayList<Bankcard> arrayList = null;
        Cursor a = this.gLA.a("select * from WalletBankcard where cardType & " + Bankcard.sRd + " != 0 ", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.b(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final boolean ci(List<Bankcard> list) {
        for (com.tencent.mm.sdk.e.c b : list) {
            super.b(b);
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final boolean e(Bankcard bankcard) {
        if (!super.b((com.tencent.mm.sdk.e.c) bankcard)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
