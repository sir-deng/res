package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends i<i> implements a {
    public static final String[] gLy = new String[]{i.a(i.gKN, "IPCallPopularCountry")};
    public e gLA;
    public m hxW = new m() {
        protected final boolean NK() {
            if (j.this.gLA != null && !j.this.gLA.chz()) {
                return true;
            }
            String str = "MicroMsg.IPCallPopularCountryStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = j.this.gLA == null ? "null" : Boolean.valueOf(j.this.gLA.chz());
            x.w(str, str2, objArr);
            return false;
        }
    };

    public j(e eVar) {
        super(eVar, i.gKN, "IPCallPopularCountry", null);
        this.gLA = eVar;
    }

    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final void x(int i, long j) {
        boolean a;
        c iVar = new i();
        Cursor a2 = this.gLA.a("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i)}, null, null, null, 2);
        if (a2.moveToFirst()) {
            iVar.b(a2);
            iVar.field_callTimeCount++;
            iVar.field_lastCallTime = j;
            a = super.a(iVar);
            a2.close();
        } else {
            x.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:" + i);
            a2.close();
            iVar.field_countryCode = i;
            iVar.field_lastCallTime = j;
            iVar.field_callTimeCount = 1;
            a = b(iVar);
        }
        x.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:" + a);
    }
}
