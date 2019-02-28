package com.tencent.mm.plugin.r;

import com.tencent.mm.bx.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.at;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.r.a.a {
    private at otH;

    public final at Fm() {
        g.Dr();
        g.Do().CA();
        return this.otH;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.otH = new at(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new h.d() {
            public final String[] wn() {
                return at.gLy;
            }
        });
        return hashMap;
    }
}
