package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.e.b;
import com.google.android.exoplayer2.source.b.j.a;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class g implements b, a, e {
    private m acV;
    private e.a arJ;
    private final k asY = new k();
    private final com.google.android.exoplayer2.h.b asj;
    private final d atM;
    private final int atN;
    private final com.google.android.exoplayer2.source.a.a atO;
    private final IdentityHashMap<i, Integer> atP = new IdentityHashMap();
    final Handler atQ = new Handler();
    private int atR;
    j[] atS = new j[0];
    private j[] atT = new j[0];
    private d atU;
    final com.google.android.exoplayer2.source.b.a.e ata;

    public g(com.google.android.exoplayer2.source.b.a.e eVar, d dVar, int i, com.google.android.exoplayer2.source.a.a aVar, com.google.android.exoplayer2.h.b bVar) {
        this.ata = eVar;
        this.atM = dVar;
        this.atN = i;
        this.atO = aVar;
        this.asj = bVar;
    }

    public final void a(e.a aVar, long j) {
        int i;
        com.google.android.exoplayer2.source.b.a.a.a aVar2;
        List list;
        int i2;
        int i3;
        this.arJ = aVar;
        this.ata.avD.add(this);
        com.google.android.exoplayer2.source.b.a.a aVar3 = this.ata.atr;
        List arrayList = new ArrayList(aVar3.auC);
        ArrayList arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= arrayList.size()) {
                break;
            }
            aVar2 = (com.google.android.exoplayer2.source.b.a.a.a) arrayList.get(i);
            if (aVar2.aeo.height > 0 || a(aVar2, "avc")) {
                arrayList2.add(aVar2);
            } else if (a(aVar2, "mp4a")) {
                arrayList3.add(aVar2);
            }
            i4 = i + 1;
        }
        if (arrayList2.isEmpty()) {
            if (arrayList3.size() < arrayList.size()) {
                arrayList.removeAll(arrayList3);
            }
            list = arrayList;
        } else {
            list = arrayList2;
        }
        List list2 = aVar3.auD;
        List list3 = aVar3.auE;
        this.atS = new j[((list2.size() + 1) + list3.size())];
        this.atR = this.atS.length;
        com.google.android.exoplayer2.i.a.ao(!list.isEmpty());
        com.google.android.exoplayer2.source.b.a.a.a[] aVarArr = new com.google.android.exoplayer2.source.b.a.a.a[list.size()];
        list.toArray(aVarArr);
        j a = a(0, aVarArr, aVar3.auc, aVar3.atc, j);
        i4 = 1;
        this.atS[0] = a;
        a.ak(true);
        a.kB();
        i = 0;
        while (true) {
            i2 = i4;
            i3 = i;
            if (i3 >= list2.size()) {
                break;
            }
            a = a(1, new com.google.android.exoplayer2.source.b.a.a.a[]{(com.google.android.exoplayer2.source.b.a.a.a) list2.get(i3)}, null, Collections.emptyList(), j);
            i4 = i2 + 1;
            this.atS[i2] = a;
            a.kB();
            i = i3 + 1;
        }
        for (i3 = 0; i3 < list3.size(); i3++) {
            a = a(3, new com.google.android.exoplayer2.source.b.a.a.a[]{(com.google.android.exoplayer2.source.b.a.a.a) list3.get(i3)}, null, Collections.emptyList(), j);
            a.cG(0).f(aVar2.aeo);
            a.auj = true;
            a.kE();
            i4 = i2 + 1;
            this.atS[i2] = a;
            i2 = i4;
        }
        this.atT = this.atS;
    }

    public final void jY() {
        for (j kd : this.atS) {
            kd.kd();
        }
    }

    public final m jZ() {
        return this.acV;
    }

    public final long a(com.google.android.exoplayer2.g.e[] eVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        int i;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= eVarArr.length) {
                break;
            }
            if (iVarArr[i] == null) {
                i2 = -1;
            } else {
                i2 = ((Integer) this.atP.get(iVarArr[i])).intValue();
            }
            iArr[i] = i2;
            iArr2[i] = -1;
            if (eVarArr[i] != null) {
                l lh = eVarArr[i].lh();
                for (i2 = 0; i2 < this.atS.length; i2++) {
                    if (this.atS[i2].acV.a(lh) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                }
            }
            i2 = i + 1;
        }
        this.atP.clear();
        Object obj = new i[eVarArr.length];
        i[] iVarArr2 = new i[eVarArr.length];
        com.google.android.exoplayer2.g.e[] eVarArr2 = new com.google.android.exoplayer2.g.e[eVarArr.length];
        j[] jVarArr = new j[this.atS.length];
        i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            i = i2;
            if (i < this.atS.length) {
                Object obj2;
                i2 = 0;
                while (i2 < eVarArr.length) {
                    iVarArr2[i2] = iArr[i2] == i ? iVarArr[i2] : null;
                    eVarArr2[i2] = iArr2[i2] == i ? eVarArr[i2] : null;
                    i2++;
                }
                j jVar = this.atS[i];
                com.google.android.exoplayer2.i.a.ap(jVar.adD);
                int i4 = jVar.auk;
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= eVarArr2.length) {
                        break;
                    }
                    if (iVarArr2[i5] != null && (eVarArr2[i5] == null || !zArr[i5])) {
                        jVar.k(((i) iVarArr2[i5]).atY, false);
                        iVarArr2[i5] = null;
                    }
                    i2 = i5 + 1;
                }
                Object obj3 = (z || (jVar.auu ? i4 == 0 : j != jVar.aur)) ? 1 : null;
                com.google.android.exoplayer2.g.e eVar = jVar.aub.atk;
                i4 = 0;
                com.google.android.exoplayer2.g.e eVar2 = eVar;
                while (true) {
                    obj2 = obj3;
                    if (i4 >= eVarArr2.length) {
                        break;
                    }
                    if (iVarArr2[i4] == null && eVarArr2[i4] != null) {
                        com.google.android.exoplayer2.g.e eVar3 = eVarArr2[i4];
                        int a = jVar.acV.a(eVar3.lh());
                        jVar.k(a, true);
                        if (a == jVar.aun) {
                            jVar.aub.atk = eVar3;
                            eVar2 = eVar3;
                        }
                        iVarArr2[i4] = new i(jVar, a);
                        zArr2[i4] = true;
                        if (obj2 == null) {
                            h hVar = jVar.auh[a];
                            hVar.rewind();
                            if (!hVar.d(j, true)) {
                                com.google.android.exoplayer2.source.g gVar = hVar.asl;
                                if (gVar.asc + gVar.asa != 0) {
                                    obj3 = 1;
                                    i4++;
                                }
                            }
                            obj3 = null;
                            i4++;
                        }
                    }
                    obj3 = obj2;
                    i4++;
                }
                if (jVar.auk == 0) {
                    jVar.aub.atf = null;
                    jVar.aul = null;
                    jVar.auf.clear();
                    if (jVar.aud.id()) {
                        for (h kn : jVar.auh) {
                            kn.kn();
                        }
                        jVar.aud.lz();
                    } else {
                        jVar.kD();
                    }
                } else {
                    boolean z2;
                    if (!(jVar.auf.isEmpty() || t.h(eVar2, eVar))) {
                        if (jVar.auu) {
                            obj3 = 1;
                        } else {
                            eVar2.kv();
                            obj3 = eVar2.lj() != jVar.aub.atb.j(((f) jVar.auf.getLast()).asI) ? 1 : null;
                        }
                        if (obj3 != null) {
                            z2 = true;
                            obj2 = 1;
                            jVar.aut = true;
                            if (obj2 != null) {
                                jVar.e(j, z2);
                                for (i2 = 0; i2 < iVarArr2.length; i2++) {
                                    if (iVarArr2[i2] != null) {
                                        zArr2[i2] = true;
                                    }
                                }
                            }
                        }
                    }
                    z2 = z;
                    if (obj2 != null) {
                        jVar.e(j, z2);
                        for (i2 = 0; i2 < iVarArr2.length; i2++) {
                            if (iVarArr2[i2] != null) {
                                zArr2[i2] = true;
                            }
                        }
                    }
                }
                jVar.auu = true;
                Object obj4 = null;
                for (i2 = 0; i2 < eVarArr.length; i2++) {
                    if (iArr2[i2] == i) {
                        com.google.android.exoplayer2.i.a.ap(iVarArr2[i2] != null);
                        obj[i2] = iVarArr2[i2];
                        obj4 = 1;
                        this.atP.put(iVarArr2[i2], Integer.valueOf(i));
                    } else if (iArr[i2] == i) {
                        com.google.android.exoplayer2.i.a.ap(iVarArr2[i2] == null);
                    }
                }
                if (obj4 != null) {
                    jVarArr[i3] = jVar;
                    i2 = i3 + 1;
                    if (i3 == 0) {
                        jVar.ak(true);
                        if (!(obj2 == null && this.atT.length != 0 && jVar == this.atT[0])) {
                            this.asY.aux.clear();
                            z = true;
                            i3 = i2;
                        }
                    } else {
                        jVar.ak(false);
                    }
                    i3 = i2;
                }
                i2 = i + 1;
            } else {
                System.arraycopy(obj, 0, iVarArr, 0, obj.length);
                this.atT = (j[]) Arrays.copyOf(jVarArr, i3);
                this.atU = new d(this.atT);
                return j;
            }
        }
    }

    public final void A(long j) {
        for (j jVar : this.atT) {
            int length = jVar.auh.length;
            for (int i = 0; i < length; i++) {
                h hVar = jVar.auh[i];
                hVar.H(hVar.asl.b(j, false, jVar.aup[i]));
            }
        }
    }

    public final boolean C(long j) {
        return this.atU.C(j);
    }

    public final long kc() {
        return this.atU.kc();
    }

    public final long ka() {
        return -9223372036854775807L;
    }

    public final long kb() {
        return this.atU.kb();
    }

    public final long B(long j) {
        if (this.atT.length > 0) {
            boolean e = this.atT[0].e(j, false);
            for (int i = 1; i < this.atT.length; i++) {
                this.atT[i].e(j, e);
            }
            if (e) {
                this.asY.aux.clear();
            }
        }
        return j;
    }

    public final void hY() {
        int i = this.atR - 1;
        this.atR = i;
        if (i <= 0) {
            int i2 = 0;
            for (j jVar : this.atS) {
                i2 += jVar.acV.length;
            }
            l[] lVarArr = new l[i2];
            j[] jVarArr = this.atS;
            int length = jVarArr.length;
            i = 0;
            int i3 = 0;
            while (i3 < length) {
                j jVar2 = jVarArr[i3];
                int i4 = jVar2.acV.length;
                i2 = i;
                i = 0;
                while (i < i4) {
                    int i5 = i2 + 1;
                    lVarArr[i2] = jVar2.acV.asG[i];
                    i++;
                    i2 = i5;
                }
                i3++;
                i = i2;
            }
            this.acV = new m(lVarArr);
            this.arJ.a(this);
        }
    }

    public final void a(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        ((a) this.ata.avA.get(aVar)).kH();
    }

    public final void kz() {
        kA();
    }

    public final void a(com.google.android.exoplayer2.source.b.a.a.a aVar, long j) {
        for (j jVar : this.atS) {
            c cVar = jVar.aub;
            int j2 = cVar.atb.j(aVar.aeo);
            if (j2 != -1) {
                j2 = cVar.atk.indexOf(j2);
                if (j2 != -1) {
                    cVar.atk.f(j2, 60000);
                }
            }
        }
        kA();
    }

    private j a(int i, com.google.android.exoplayer2.source.b.a.a.a[] aVarArr, Format format, List<Format> list, long j) {
        return new j(i, this, new c(this.ata, aVarArr, this.atM, this.asY, list), this.asj, j, format, this.atN, this.atO);
    }

    private void kA() {
        if (this.acV != null) {
            this.arJ.a(this);
            return;
        }
        for (j kB : this.atS) {
            kB.kB();
        }
    }

    private static boolean a(com.google.android.exoplayer2.source.b.a.a.a aVar, String str) {
        Object obj = aVar.aeo.adS;
        if (TextUtils.isEmpty(obj)) {
            return false;
        }
        for (String startsWith : obj.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
