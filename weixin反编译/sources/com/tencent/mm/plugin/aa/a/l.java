package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class l implements com.tencent.mm.vending.c.b<k> {
    protected k ijj;
    public final a ijk;
    public final b ijl;

    public class a implements e<Boolean, c<Integer, Map<String, Object>>> {
        public final /* synthetic */ Object call(Object obj) {
            c cVar = (c) obj;
            l.this.ijj.d(((Integer) cVar.get(0)).intValue(), (Map) cVar.get(1));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<d<Boolean, String, Long>, Map<String, Object>> {
        public final /* synthetic */ Object call(Object obj) {
            l.this.ijj.t((Map) obj);
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.ijj;
    }

    public l() {
        this(new k());
    }

    private l(k kVar) {
        this.ijk = new a();
        this.ijl = new b();
        this.ijj = kVar;
    }

    public final k WV() {
        return this.ijj;
    }
}
