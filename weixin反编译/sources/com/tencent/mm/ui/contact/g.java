package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.List;

public final class g {
    static final List<String> dw(List<String> list) {
        List<String> arrayList = new ArrayList();
        Cursor b = ((h) com.tencent.mm.kernel.g.h(h.class)).Fk().b(s.hgU, list, true, null);
        if (b.moveToFirst()) {
            int i = 0;
            do {
                ak aeVar = new ae();
                aeVar.b(b);
                if (MF(aeVar.field_username)) {
                    arrayList.add(aeVar.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (b.moveToNext());
        }
        b.close();
        return arrayList;
    }

    private static final boolean MF(String str) {
        for (Object equals : s.hhb) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (s.eX(str) || s.gI(str)) {
            return false;
        }
        return true;
    }
}
