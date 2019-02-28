package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class g {
    private static final AtomicInteger mRB = new AtomicInteger(0);
    public String fEe = null;
    public ag handler = null;
    public final int id = mRB.incrementAndGet();
    public int mRC = 0;
    public String mRD = null;
    public String mRE = null;
    public int[] mRF = null;
    public int[] mRG = null;
    public int mRH = Integer.MAX_VALUE;
    public HashSet<String> mRI = new HashSet();
    public Comparator<j> mRJ = null;
    public k mRK = null;
    public int scene = -1;
    public String talker = null;

    public static g a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<j> comparator, k kVar, ag agVar) {
        g gVar = new g();
        gVar.fEe = str;
        gVar.mRD = null;
        gVar.mRF = iArr;
        gVar.mRG = iArr2;
        gVar.mRH = i;
        gVar.mRI = hashSet;
        gVar.mRJ = comparator;
        gVar.mRK = kVar;
        gVar.handler = agVar;
        return gVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.id != ((g) obj).id) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("{id: %d, query: %s}", new Object[]{Integer.valueOf(this.id), this.fEe});
    }
}
