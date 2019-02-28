package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.du;
import com.tencent.mm.sdk.e.i;
import java.util.concurrent.ConcurrentHashMap;

public final class bi extends i<du> {
    public static final String[] gLy = new String[]{i.a(bh.gKN, "TablesVersion")};
    public h hiZ;

    public bi(h hVar) {
        super(hVar, bh.gKN, "TablesVersion", du.fNF);
        this.hiZ = hVar;
    }

    public final ConcurrentHashMap<Integer, String> ckM() {
        Cursor a = this.hiZ.a("select * from TablesVersion", new String[0], 0);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(a.getInt(0)), a.getString(1));
                } finally {
                    a.close();
                }
            }
        }
        return concurrentHashMap;
    }
}
