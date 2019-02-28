package com.tencent.mm.ay;

import com.tencent.mm.f.a.cd;
import com.tencent.mm.f.a.sd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    Map<Integer, Object<?>> hLv = new ConcurrentHashMap();
    public c hLw = new c<sd>() {
        {
            this.xmG = sd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            l.this.hLv.get(Integer.valueOf(((sd) bVar).fKI.frj));
            return false;
        }
    };
    public c hLx = new c<cd>() {
        {
            this.xmG = cd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            l.this.hLv.get(Integer.valueOf(((cd) bVar).fri.frj));
            return false;
        }
    };
}
