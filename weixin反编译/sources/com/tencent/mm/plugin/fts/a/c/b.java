package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

public final class b implements Comparator<j> {
    public static final b mSk = new b();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        int i = jVar2.mRi - jVar.mRi;
        if (i != 0) {
            return i;
        }
        i = d.a(c.mPZ, jVar.type, jVar2.type);
        if (i != 0) {
            return i;
        }
        i = d.c(c.mQe, jVar.mRc, jVar2.mRc);
        if (i != 0) {
            return i;
        }
        i = jVar.mRT - jVar2.mRT;
        if (i != 0) {
            return i;
        }
        if (jVar.mRc != 11 && jVar.mRc != 17 && jVar.mRc != 18) {
            return bi.aD(jVar.mRU, "").compareToIgnoreCase(jVar2.mRU);
        }
        if (bi.oN(jVar.mSb)) {
            jVar.mSb = d.BG(jVar.mRd);
            jVar.mSb = jVar.mSb.toLowerCase();
            if (!f.j(jVar.mSb.charAt(0))) {
                jVar.mSb = "~" + jVar.mSb;
            }
        }
        if (bi.oN(jVar2.mSb)) {
            jVar2.mSb = d.BG(jVar2.mRd);
            jVar2.mSb = jVar2.mSb.toLowerCase();
            if (!f.j(jVar2.mSb.charAt(0))) {
                jVar2.mSb = "~" + jVar2.mSb;
            }
        }
        return jVar.mSb.compareToIgnoreCase(jVar2.mSb);
    }
}
