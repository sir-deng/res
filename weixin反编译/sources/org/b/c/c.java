package org.b.c;

import java.util.Collections;
import org.b.d.e;
import org.b.g.d;

public final class c implements b {
    public final String a(org.b.d.c cVar) {
        d.j(cVar, "Cannot extract base string from null object");
        if (cVar.AHI == null || cVar.AHI.size() <= 0) {
            throw new org.b.b.c(cVar);
        }
        String encode = org.b.g.c.encode(cVar.cKX().name());
        String encode2 = org.b.g.c.encode(cVar.cLc());
        e eVar = new e();
        eVar.a(cVar.cKW());
        eVar.a(cVar.cLb());
        eVar.a(new e(cVar.AHI));
        e eVar2 = new e(eVar.AHJ);
        Collections.sort(eVar2.AHJ);
        String encode3 = org.b.g.c.encode(eVar2.cLd());
        return String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
    }
}
