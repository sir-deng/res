package com.tencent.mm.ax;

import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;

public final class j extends com.tencent.mm.sdk.e.j implements e {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    h hiZ;

    public j(h hVar) {
        this.hiZ = hVar;
    }

    public final boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        if (this.hiZ.delete("oplog2", "id= ? AND inserTime= ?", new String[]{bVar.id, bVar.hAf}) < 0) {
            return false;
        }
        return true;
    }
}
