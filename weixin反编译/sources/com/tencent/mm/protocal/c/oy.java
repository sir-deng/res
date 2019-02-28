package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class oy extends a {
    public String kPB;
    public String kPC;
    public String pfi;
    public String title;
    public String url;
    public String vYB;
    public String vYC;
    public long vZQ;
    public String vZR;
    public String vZS;
    public ajn weA;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.kPB != null) {
                aVar.g(2, this.kPB);
            }
            if (this.kPC != null) {
                aVar.g(3, this.kPC);
            }
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            aVar.S(5, this.vZQ);
            if (this.vZR != null) {
                aVar.g(6, this.vZR);
            }
            if (this.vZS != null) {
                aVar.g(7, this.vZS);
            }
            if (this.pfi != null) {
                aVar.g(8, this.pfi);
            }
            if (this.weA != null) {
                aVar.fZ(9, this.weA.bkL());
                this.weA.a(aVar);
            }
            if (this.vYB != null) {
                aVar.g(10, this.vYB);
            }
            if (this.vYC == null) {
                return 0;
            }
            aVar.g(11, this.vYC);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.kPB != null) {
                h += e.a.a.b.b.a.h(2, this.kPB);
            }
            if (this.kPC != null) {
                h += e.a.a.b.b.a.h(3, this.kPC);
            }
            if (this.url != null) {
                h += e.a.a.b.b.a.h(4, this.url);
            }
            h += e.a.a.a.R(5, this.vZQ);
            if (this.vZR != null) {
                h += e.a.a.b.b.a.h(6, this.vZR);
            }
            if (this.vZS != null) {
                h += e.a.a.b.b.a.h(7, this.vZS);
            }
            if (this.pfi != null) {
                h += e.a.a.b.b.a.h(8, this.pfi);
            }
            if (this.weA != null) {
                h += e.a.a.a.fW(9, this.weA.bkL());
            }
            if (this.vYB != null) {
                h += e.a.a.b.b.a.h(10, this.vYB);
            }
            if (this.vYC != null) {
                h += e.a.a.b.b.a.h(11, this.vYC);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            oy oyVar = (oy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oyVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    oyVar.kPB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    oyVar.kPC = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    oyVar.url = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    oyVar.vZQ = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    oyVar.vZR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    oyVar.vZS = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    oyVar.pfi = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ajn = new ajn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ajn.a(aVar4, ajn, a.a(aVar4))) {
                        }
                        oyVar.weA = ajn;
                    }
                    return 0;
                case 10:
                    oyVar.vYB = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    oyVar.vYC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
