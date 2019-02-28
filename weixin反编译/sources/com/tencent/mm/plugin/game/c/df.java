package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class df extends a {
    public String nlY;
    public dh nps;
    public dh npt;
    public dh npu;
    public dh npv;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nps != null) {
                aVar.fZ(1, this.nps.bkL());
                this.nps.a(aVar);
            }
            if (this.npt != null) {
                aVar.fZ(2, this.npt.bkL());
                this.npt.a(aVar);
            }
            if (this.npu != null) {
                aVar.fZ(3, this.npu.bkL());
                this.npu.a(aVar);
            }
            if (this.npv != null) {
                aVar.fZ(4, this.npv.bkL());
                this.npv.a(aVar);
            }
            if (this.nlY == null) {
                return 0;
            }
            aVar.g(5, this.nlY);
            return 0;
        } else if (i == 1) {
            if (this.nps != null) {
                fW = e.a.a.a.fW(1, this.nps.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.npt != null) {
                fW += e.a.a.a.fW(2, this.npt.bkL());
            }
            if (this.npu != null) {
                fW += e.a.a.a.fW(3, this.npu.bkL());
            }
            if (this.npv != null) {
                fW += e.a.a.a.fW(4, this.npv.bkL());
            }
            if (this.nlY != null) {
                fW += e.a.a.b.b.a.h(5, this.nlY);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            df dfVar = (df) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a dhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.nps = dhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.npt = dhVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.npu = dhVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.a(aVar4, dhVar, a.a(aVar4))) {
                        }
                        dfVar.npv = dhVar;
                    }
                    return 0;
                case 5:
                    dfVar.nlY = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
