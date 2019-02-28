package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.fh;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bg extends bea {
    public String hxn;
    public String nkU;
    public String nnm;
    public boolean nnw;
    public boolean nnx;
    public boolean nny;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nnm == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.nkU == null) {
                throw new b("Not all required fields were included: AppID");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.nnm != null) {
                    aVar.g(2, this.nnm);
                }
                if (this.nkU != null) {
                    aVar.g(3, this.nkU);
                }
                aVar.am(4, this.nnw);
                if (this.hxn != null) {
                    aVar.g(5, this.hxn);
                }
                aVar.am(6, this.nnx);
                aVar.am(7, this.nny);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nnm != null) {
                fW += e.a.a.b.b.a.h(2, this.nnm);
            }
            if (this.nkU != null) {
                fW += e.a.a.b.b.a.h(3, this.nkU);
            }
            fW += e.a.a.b.b.a.dX(4) + 1;
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(5, this.hxn);
            }
            return (fW + (e.a.a.b.b.a.dX(6) + 1)) + (e.a.a.b.b.a.dX(7) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nnm == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.nkU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bg bgVar = (bg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bgVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bgVar.nnm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bgVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bgVar.nnw = aVar3.cKv();
                    return 0;
                case 5:
                    bgVar.hxn = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bgVar.nnx = aVar3.cKv();
                    return 0;
                case 7:
                    bgVar.nny = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
