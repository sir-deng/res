package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class amp extends bea {
    public String fGh;
    public String fry;
    public String signature;
    public String url;
    public String wzP;
    public String wzR;
    public String wzS;
    public b wzT;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.fGh != null) {
                aVar.g(3, this.fGh);
            }
            if (this.wzP != null) {
                aVar.g(4, this.wzP);
            }
            if (this.fry != null) {
                aVar.g(5, this.fry);
            }
            if (this.wzR != null) {
                aVar.g(6, this.wzR);
            }
            if (this.signature != null) {
                aVar.g(7, this.signature);
            }
            if (this.wzS != null) {
                aVar.g(8, this.wzS);
            }
            if (this.wzT == null) {
                return 0;
            }
            aVar.b(9, this.wzT);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.url != null) {
                fW += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(3, this.fGh);
            }
            if (this.wzP != null) {
                fW += e.a.a.b.b.a.h(4, this.wzP);
            }
            if (this.fry != null) {
                fW += e.a.a.b.b.a.h(5, this.fry);
            }
            if (this.wzR != null) {
                fW += e.a.a.b.b.a.h(6, this.wzR);
            }
            if (this.signature != null) {
                fW += e.a.a.b.b.a.h(7, this.signature);
            }
            if (this.wzS != null) {
                fW += e.a.a.b.b.a.h(8, this.wzS);
            }
            if (this.wzT != null) {
                fW += e.a.a.a.a(9, this.wzT);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            amp amp = (amp) objArr[1];
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
                        amp.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    amp.url = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    amp.fGh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    amp.wzP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    amp.fry = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    amp.wzR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    amp.signature = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    amp.wzS = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    amp.wzT = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
