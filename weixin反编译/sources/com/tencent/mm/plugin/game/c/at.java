package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.b;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.fh;
import e.a.a.c.a;
import java.util.LinkedList;

public final class at extends bea {
    public String nkU;
    public String nme;
    public b nmg;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nkU == null) {
                throw new e.a.a.b("Not all required fields were included: AppID");
            } else if (this.nme == null) {
                throw new e.a.a.b("Not all required fields were included: GroupID");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.nkU != null) {
                    aVar.g(2, this.nkU);
                }
                if (this.nme != null) {
                    aVar.g(3, this.nme);
                }
                if (this.nmg == null) {
                    return 0;
                }
                aVar.b(4, this.nmg);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nkU != null) {
                fW += e.a.a.b.b.a.h(2, this.nkU);
            }
            if (this.nme != null) {
                fW += e.a.a.b.b.a.h(3, this.nme);
            }
            if (this.nmg != null) {
                fW += e.a.a.a.a(4, this.nmg);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nkU == null) {
                throw new e.a.a.b("Not all required fields were included: AppID");
            } else if (this.nme != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: GroupID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            at atVar = (at) objArr[1];
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
                        atVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    atVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    atVar.nme = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    atVar.nmg = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
