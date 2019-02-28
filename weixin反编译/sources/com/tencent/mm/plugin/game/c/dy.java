package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fi;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class dy extends bek {
    public String fpg;
    public String nlB;
    public boolean nlc;
    public m npT;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nlB == null) {
                throw new b("Not all required fields were included: Message");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.am(2, this.nlc);
                if (this.fpg != null) {
                    aVar.g(3, this.fpg);
                }
                if (this.nlB != null) {
                    aVar.g(4, this.nlB);
                }
                if (this.npT == null) {
                    return 0;
                }
                aVar.fZ(5, this.npT.bkL());
                this.npT.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.b.b.a.dX(2) + 1;
            if (this.fpg != null) {
                fW += e.a.a.b.b.a.h(3, this.fpg);
            }
            if (this.nlB != null) {
                fW += e.a.a.b.b.a.h(4, this.nlB);
            }
            if (this.npT != null) {
                fW += e.a.a.a.fW(5, this.npT.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nlB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Message");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dy dyVar = (dy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        dyVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    dyVar.nlc = aVar3.cKv();
                    return 0;
                case 3:
                    dyVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    dyVar.nlB = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new m();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        dyVar.npT = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
