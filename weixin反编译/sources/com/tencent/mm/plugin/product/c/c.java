package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class c extends a {
    public String hfQ;
    public String name;
    public String pgf;
    public LinkedList<d> pkg = new LinkedList();
    public int pkh;
    public int pki;
    public int pkj;
    public LinkedList<String> pkk = new LinkedList();
    public String pkl;
    public LinkedList<String> pkm = new LinkedList();
    public LinkedList<b> pkn = new LinkedList();
    public LinkedList<String> pko = new LinkedList();
    public int pkp;
    public int pkq;
    public LinkedList<m> pkr = new LinkedList();
    public LinkedList<a> pks = new LinkedList();
    public k pkt;
    public int version;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            aVar.d(2, 8, this.pkg);
            aVar.fX(3, this.pkh);
            aVar.fX(4, this.pki);
            aVar.fX(5, this.pkj);
            aVar.d(6, 1, this.pkk);
            if (this.hfQ != null) {
                aVar.g(7, this.hfQ);
            }
            if (this.pkl != null) {
                aVar.g(8, this.pkl);
            }
            aVar.d(9, 1, this.pkm);
            aVar.d(10, 8, this.pkn);
            aVar.d(11, 1, this.pko);
            aVar.fX(12, this.pkp);
            aVar.fX(13, this.pkq);
            aVar.d(14, 8, this.pkr);
            aVar.fX(15, this.version);
            aVar.d(16, 8, this.pks);
            if (this.pgf != null) {
                aVar.g(17, this.pgf);
            }
            if (this.pkt == null) {
                return 0;
            }
            aVar.fZ(18, this.pkt.bkL());
            this.pkt.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = e.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            h = ((((h + e.a.a.a.c(2, 8, this.pkg)) + e.a.a.a.fU(3, this.pkh)) + e.a.a.a.fU(4, this.pki)) + e.a.a.a.fU(5, this.pkj)) + e.a.a.a.c(6, 1, this.pkk);
            if (this.hfQ != null) {
                h += e.a.a.b.b.a.h(7, this.hfQ);
            }
            if (this.pkl != null) {
                h += e.a.a.b.b.a.h(8, this.pkl);
            }
            h = (((((((h + e.a.a.a.c(9, 1, this.pkm)) + e.a.a.a.c(10, 8, this.pkn)) + e.a.a.a.c(11, 1, this.pko)) + e.a.a.a.fU(12, this.pkp)) + e.a.a.a.fU(13, this.pkq)) + e.a.a.a.c(14, 8, this.pkr)) + e.a.a.a.fU(15, this.version)) + e.a.a.a.c(16, 8, this.pks);
            if (this.pgf != null) {
                h += e.a.a.b.b.a.h(17, this.pgf);
            }
            if (this.pkt != null) {
                h += e.a.a.a.fW(18, this.pkt.bkL());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pkg.clear();
            this.pkk.clear();
            this.pkm.clear();
            this.pkn.clear();
            this.pko.clear();
            this.pkr.clear();
            this.pks.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a dVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.name = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.pkg.add(dVar);
                    }
                    return 0;
                case 3:
                    cVar.pkh = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cVar.pki = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cVar.pkj = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    cVar.pkk.add(aVar3.AEQ.readString());
                    return 0;
                case 7:
                    cVar.hfQ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    cVar.pkl = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    cVar.pkm.add(aVar3.AEQ.readString());
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.pkn.add(dVar);
                    }
                    return 0;
                case 11:
                    cVar.pko.add(aVar3.AEQ.readString());
                    return 0;
                case 12:
                    cVar.pkp = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    cVar.pkq = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dVar = new m();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.pkr.add(dVar);
                    }
                    return 0;
                case 15:
                    cVar.version = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dVar = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.pks.add(dVar);
                    }
                    return 0;
                case 17:
                    cVar.pgf = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dVar = new k();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.pkt = dVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
