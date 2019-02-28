package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jm extends a {
    public String fpg;
    public int kza;
    public LinkedList<jr> nmz = new LinkedList();
    public int vUN;
    public long vWt;
    public int vWu;
    public LinkedList<String> vWv = new LinkedList();
    public String vWw;

    protected final int a(int i, Object... objArr) {
        int R;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWw == null) {
                throw new b("Not all required fields were included: SearchID");
            }
            aVar.S(1, this.vWt);
            aVar.fX(2, this.vWu);
            if (this.fpg != null) {
                aVar.g(3, this.fpg);
            }
            aVar.d(4, 1, this.vWv);
            aVar.d(5, 8, this.nmz);
            aVar.fX(6, this.kza);
            if (this.vWw != null) {
                aVar.g(7, this.vWw);
            }
            aVar.fX(8, this.vUN);
            return 0;
        } else if (i == 1) {
            R = (e.a.a.a.R(1, this.vWt) + 0) + e.a.a.a.fU(2, this.vWu);
            if (this.fpg != null) {
                R += e.a.a.b.b.a.h(3, this.fpg);
            }
            R = ((R + e.a.a.a.c(4, 1, this.vWv)) + e.a.a.a.c(5, 8, this.nmz)) + e.a.a.a.fU(6, this.kza);
            if (this.vWw != null) {
                R += e.a.a.b.b.a.h(7, this.vWw);
            }
            return R + e.a.a.a.fU(8, this.vUN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWv.clear();
            this.nmz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.vWw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SearchID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jm jmVar = (jm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jmVar.vWt = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    jmVar.vWu = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    jmVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    jmVar.vWv.add(aVar3.AEQ.readString());
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a jrVar = new jr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.a(aVar4, jrVar, a.a(aVar4))) {
                        }
                        jmVar.nmz.add(jrVar);
                    }
                    return 0;
                case 6:
                    jmVar.kza = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    jmVar.vWw = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    jmVar.vUN = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
