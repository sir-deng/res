package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class az extends i<ay> {
    public static final String[] gLy = new String[]{i.a(ay.gKN, "NewTipsInfo")};
    public e gLA;

    public final /* synthetic */ boolean b(c cVar) {
        return d((ay) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a((ay) cVar, strArr);
    }

    public az(e eVar) {
        super(eVar, ay.gKN, "NewTipsInfo", null);
        this.gLA = eVar;
    }

    public final boolean d(ay ayVar) {
        boolean z = false;
        if (ayVar == null) {
            x.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
        } else if (ayVar.field_tipId <= 0) {
            x.e("MicroMsg.NewTipsInfoStorage", "newTipsId is error, tipsId = %s", Integer.valueOf(ayVar.field_tipId));
        } else {
            z = a((c) ayVar, false);
            if (z) {
                b(ayVar.field_tipId, 2, Integer.valueOf(ayVar.field_tipId));
            }
        }
        return z;
    }

    public final boolean a(ay ayVar, String... strArr) {
        if (ayVar == null) {
            x.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
            return false;
        }
        boolean b = super.b(ayVar, false, strArr);
        if (b) {
            b(ayVar.field_tipId, 3, Integer.valueOf(ayVar.field_tipId));
        }
        x.d("MicroMsg.NewTipsInfoStorage", "update result[%B]", Boolean.valueOf(b));
        return b;
    }

    public final ay DK(int i) {
        if (this.gLA == null) {
            x.e("MicroMsg.NewTipsInfoStorage", "getByTipsId, but db is null, return");
            return null;
        }
        Cursor a = this.gLA.a("NewTipsInfo", null, "tipId=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a.moveToFirst()) {
            ay ayVar = new ay();
            try {
                ayVar.b(a);
                a.close();
                return ayVar;
            } catch (Exception e) {
                x.e("MicroMsg.NewTipsInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                return null;
            }
        }
        x.w("MicroMsg.NewTipsInfoStorage", "getByTipsId:%d, no data", Integer.valueOf(i));
        a.close();
        return null;
    }
}
