package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;

public final class h implements Comparator<j> {
    public static final h jbn = new h();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        if (e.ZG() != null) {
            b sd = e.ZG().sd(jVar.mRd);
            if (sd != null && sd.field_isSync) {
                return 1;
            }
        }
        return -1;
    }
}
