package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ast extends bea {
    public String fGh;
    public int fHR;
    public String wGW;
    public int wGX;
    public int wGY;
    public int wGZ;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.fGh != null) {
                aVar.g(2, this.fGh);
            }
            if (this.wGW != null) {
                aVar.g(3, this.wGW);
            }
            aVar.fX(4, this.wGX);
            aVar.fX(5, this.wGY);
            aVar.fX(6, this.wGZ);
            aVar.fX(7, this.fHR);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(2, this.fGh);
            }
            if (this.wGW != null) {
                fW += e.a.a.b.b.a.h(3, this.wGW);
            }
            return (((fW + e.a.a.a.fU(4, this.wGX)) + e.a.a.a.fU(5, this.wGY)) + e.a.a.a.fU(6, this.wGZ)) + e.a.a.a.fU(7, this.fHR);
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
            ast ast = (ast) objArr[1];
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
                        ast.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ast.fGh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ast.wGW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ast.wGX = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ast.wGY = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ast.wGZ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ast.fHR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
