package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.Comparator;

public final class a implements Comparator<j> {
    public static final a mSj = new a();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        int i = jVar2.mRi - jVar.mRi;
        if (i != 0) {
            return i;
        }
        if (jVar2.mRi >= 50 && jVar.mRi >= 50) {
            i = d.c(c.mQe, jVar.mRc, jVar2.mRc);
            if (i != 0) {
                return i;
            }
        }
        i = jVar2.mSc - jVar.mSc;
        if (i != 0) {
            return i;
        }
        if (jVar2.timestamp > jVar.timestamp) {
            return 1;
        }
        return jVar2.timestamp < jVar.timestamp ? -1 : 0;
    }
}
