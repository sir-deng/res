package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class vr extends a {
    public int nne;
    public String wmc;
    public LinkedList<vl> wmd = new LinkedList();
    public vl wme;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.nne);
            if (this.wmc != null) {
                aVar.g(2, this.wmc);
            }
            aVar.d(3, 8, this.wmd);
            if (this.wme != null) {
                aVar.fZ(4, this.wme.bkL());
                this.wme.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.nne) + 0;
            if (this.wmc != null) {
                fU += e.a.a.b.b.a.h(2, this.wmc);
            }
            fU += e.a.a.a.c(3, 8, this.wmd);
            if (this.wme != null) {
                return fU + e.a.a.a.fW(4, this.wme.bkL());
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vr vrVar = (vr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a vlVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    vrVar.nne = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    vrVar.wmc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vlVar = new vl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vlVar.a(aVar4, vlVar, a.a(aVar4))) {
                        }
                        vrVar.wmd.add(vlVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vlVar = new vl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vlVar.a(aVar4, vlVar, a.a(aVar4))) {
                        }
                        vrVar.wme = vlVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
