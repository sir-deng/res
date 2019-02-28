package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> rgN = new LinkedList();
    public LinkedList<e> rgO = new LinkedList();
    public LinkedList<e> rgP = new LinkedList();
    public LinkedList<e> rgQ = new LinkedList();
    public LinkedList<f> rgR = new LinkedList();
    public LinkedList<f> rgS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rgN);
            aVar.d(2, 8, this.rgO);
            aVar.d(3, 8, this.rgP);
            aVar.d(4, 8, this.rgQ);
            aVar.d(5, 8, this.rgR);
            aVar.d(6, 8, this.rgS);
            return 0;
        } else if (i == 1) {
            return (((((e.a.a.a.c(1, 8, this.rgN) + 0) + e.a.a.a.c(2, 8, this.rgO)) + e.a.a.a.c(3, 8, this.rgP)) + e.a.a.a.c(4, 8, this.rgQ)) + e.a.a.a.c(5, 8, this.rgR)) + e.a.a.a.c(6, 8, this.rgS);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.rgN.clear();
                this.rgO.clear();
                this.rgP.clear();
                this.rgQ.clear();
                this.rgR.clear();
                this.rgS.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                d dVar = (d) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList JD;
                int size;
                a eVar;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.rgN.add(eVar);
                        }
                        return 0;
                    case 2:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.rgO.add(eVar);
                        }
                        return 0;
                    case 3:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.rgP.add(eVar);
                        }
                        return 0;
                    case 4:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.rgQ.add(eVar);
                        }
                        return 0;
                    case 5:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            eVar = new f();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.rgR.add(eVar);
                        }
                        return 0;
                    case 6:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            eVar = new f();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.rgS.add(eVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
