package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bhl extends a {
    public String frM;
    public int hWg;
    public int hXv;
    public int hcY;
    public int hcZ;
    public String hda;
    public String rgT;
    public String url;
    public int wSA;
    public LinkedList<bpj> wSz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.rgT == null) {
                throw new b("Not all required fields were included: clientID");
            }
            aVar.d(1, 8, this.wSz);
            if (this.rgT != null) {
                aVar.g(2, this.rgT);
            }
            if (this.frM != null) {
                aVar.g(3, this.frM);
            }
            if (this.hda != null) {
                aVar.g(4, this.hda);
            }
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            aVar.fX(6, this.hXv);
            aVar.fX(7, this.hWg);
            aVar.fX(8, this.wSA);
            aVar.fX(9, this.hcY);
            aVar.fX(10, this.hcZ);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wSz) + 0;
            if (this.rgT != null) {
                c += e.a.a.b.b.a.h(2, this.rgT);
            }
            if (this.frM != null) {
                c += e.a.a.b.b.a.h(3, this.frM);
            }
            if (this.hda != null) {
                c += e.a.a.b.b.a.h(4, this.hda);
            }
            if (this.url != null) {
                c += e.a.a.b.b.a.h(5, this.url);
            }
            return ((((c + e.a.a.a.fU(6, this.hXv)) + e.a.a.a.fU(7, this.hWg)) + e.a.a.a.fU(8, this.wSA)) + e.a.a.a.fU(9, this.hcY)) + e.a.a.a.fU(10, this.hcZ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            if (this.rgT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: clientID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhl bhl = (bhl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bpj = new bpj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bpj.a(aVar4, bpj, a.a(aVar4))) {
                        }
                        bhl.wSz.add(bpj);
                    }
                    return 0;
                case 2:
                    bhl.rgT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bhl.frM = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bhl.hda = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bhl.url = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bhl.hXv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bhl.hWg = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bhl.wSA = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bhl.hcY = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bhl.hcZ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
