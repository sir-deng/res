package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bd extends j implements a, f {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private e gLA = null;

    public bd(h hVar) {
        this.gLA = hVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    public final bc FE(String str) {
        bc bcVar = null;
        if (str != null && str.length() > 0) {
            bc bcVar2 = new bc();
            Cursor a = this.gLA.a("role_info", null, "name LIKE ?", new String[]{"%" + str}, null, null, null, 2);
            if (a.moveToFirst()) {
                bcVar2.b(a);
                bcVar = bcVar2;
            }
            a.close();
        }
        return bcVar;
    }

    private bc Yp(String str) {
        bc bcVar = null;
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        bc bcVar2 = new bc();
        Cursor a = this.gLA.a("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bcVar2.b(a);
            bcVar = bcVar2;
        }
        a.close();
        return bcVar;
    }

    public final List<bc> bad() {
        List<bc> linkedList = new LinkedList();
        Cursor a = this.gLA.a("role_info", null, new StringBuilder("int_reserved1=1").toString(), null, null, null, null, 2);
        while (a.moveToNext()) {
            bc bcVar = new bc();
            bcVar.b(a);
            linkedList.add(bcVar);
        }
        a.close();
        return linkedList;
    }

    private void a(bc bcVar) {
        bcVar.fEo = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        ContentValues vP = bcVar.vP();
        if (vP.size() > 0 && this.gLA.insert("role_info", SlookAirButtonFrequentContactAdapter.ID, vP) != 0) {
            doNotify();
        }
    }

    public final boolean has(String str) {
        bc FE = FE(new bc.a(str).Yo(""));
        return FE != null && str.equals(FE.name);
    }

    public final void bJ(String str, int i) {
        if (bi.oN(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
        } else if (Yp(str) == null) {
            a(new bc(str, true, i));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
        }
    }

    public final void ar(String str, boolean z) {
        if (bi.oN(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        bc Yp = Yp(str);
        if (Yp == null) {
            a(new bc(str, z, 2));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        Yp.gi(z);
        Yp.fEo = 4;
        b(Yp);
    }

    public final void c(String str, boolean z, boolean z2) {
        int i = 2;
        if (bi.oN(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        bc Yp = Yp(str);
        if (Yp == null) {
            a(new bc(str, z, 2));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        Yp.gi(z);
        if (z2) {
            int i2 = Yp.status;
            if (!z2) {
                i = 0;
            }
            Yp.status = i | i2;
        } else {
            Yp.status &= -3;
        }
        Yp.fEo = 4;
        b(Yp);
    }

    private void b(bc bcVar) {
        ContentValues vP = bcVar.vP();
        if (vP.size() > 0) {
            int update = this.gLA.update("role_info", vP, "name like ?", new String[]{bcVar.name});
            x.d("MicroMsg.RoleStorage", "update role info, name=" + bcVar.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
    }

    public final void jO(String str) {
        Assert.assertTrue(str.length() > 0);
        int delete = this.gLA.delete("role_info", "name=?", new String[]{str});
        x.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
    }
}
