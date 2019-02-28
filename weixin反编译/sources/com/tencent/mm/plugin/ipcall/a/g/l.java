package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class l extends i<k> {
    public static final String[] gLy = new String[]{i.a(k.gKN, "IPCallRecord")};
    public static final String[] nMx = new String[]{"*", "rowid"};
    public e gLA;

    public l(e eVar) {
        super(eVar, k.gKN, "IPCallRecord", null);
        this.gLA = eVar;
    }

    public final Cursor Dm(String str) {
        return this.gLA.query("IPCallRecord", nMx, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
    }

    public final Cursor dC(long j) {
        return this.gLA.query("IPCallRecord", nMx, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
    }

    public final void a(k kVar) {
        if (kVar != null) {
            a(kVar.xrR, (c) kVar);
        }
    }
}
