package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;

public final class d implements Comparator<j> {
    public static final d mSm = new d();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        if (jVar.timestamp > jVar2.timestamp) {
            return -1;
        }
        if (jVar.timestamp < jVar2.timestamp) {
            return 1;
        }
        if (jVar.mRc < jVar2.mRc) {
            return 1;
        }
        return jVar.mRc <= jVar2.mRc ? 0 : -1;
    }
}
