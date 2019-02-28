package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class sh extends a {
    public int kzz;
    public String npV;
    public String vNR;
    public int vPs;
    public int vPt;
    public String wgY;
    public bes wgZ;
    public String wha;
    public String whb;
    public String whc;
    public int whd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgZ == null) {
                throw new b("Not all required fields were included: EmojiBuffer");
            }
            if (this.wgY != null) {
                aVar.g(1, this.wgY);
            }
            aVar.fX(2, this.vPt);
            aVar.fX(3, this.vPs);
            if (this.wgZ != null) {
                aVar.fZ(4, this.wgZ.bkL());
                this.wgZ.a(aVar);
            }
            aVar.fX(5, this.kzz);
            if (this.npV != null) {
                aVar.g(6, this.npV);
            }
            if (this.wha != null) {
                aVar.g(7, this.wha);
            }
            if (this.whb != null) {
                aVar.g(8, this.whb);
            }
            if (this.whc != null) {
                aVar.g(9, this.whc);
            }
            if (this.vNR != null) {
                aVar.g(10, this.vNR);
            }
            aVar.fX(11, this.whd);
            return 0;
        } else if (i == 1) {
            if (this.wgY != null) {
                h = e.a.a.b.b.a.h(1, this.wgY) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.vPt)) + e.a.a.a.fU(3, this.vPs);
            if (this.wgZ != null) {
                h += e.a.a.a.fW(4, this.wgZ.bkL());
            }
            h += e.a.a.a.fU(5, this.kzz);
            if (this.npV != null) {
                h += e.a.a.b.b.a.h(6, this.npV);
            }
            if (this.wha != null) {
                h += e.a.a.b.b.a.h(7, this.wha);
            }
            if (this.whb != null) {
                h += e.a.a.b.b.a.h(8, this.whb);
            }
            if (this.whc != null) {
                h += e.a.a.b.b.a.h(9, this.whc);
            }
            if (this.vNR != null) {
                h += e.a.a.b.b.a.h(10, this.vNR);
            }
            return h + e.a.a.a.fU(11, this.whd);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wgZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sh shVar = (sh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    shVar.wgY = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    shVar.vPt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    shVar.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        shVar.wgZ = bes;
                    }
                    return 0;
                case 5:
                    shVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    shVar.npV = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    shVar.wha = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    shVar.whb = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    shVar.whc = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    shVar.vNR = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    shVar.whd = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
