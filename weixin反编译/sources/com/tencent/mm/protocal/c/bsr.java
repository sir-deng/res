package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsr extends bea {
    public String npV;
    public String npW;
    public int sfa;
    public String wdG;
    public bum wdH;
    public bsq wdJ;
    public bes weD;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wdH == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.wdJ == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wdG != null) {
                    aVar.g(2, this.wdG);
                }
                if (this.wdH != null) {
                    aVar.fZ(3, this.wdH.bkL());
                    this.wdH.a(aVar);
                }
                if (this.wdJ != null) {
                    aVar.fZ(4, this.wdJ.bkL());
                    this.wdJ.a(aVar);
                }
                if (this.weD != null) {
                    aVar.fZ(5, this.weD.bkL());
                    this.weD.a(aVar);
                }
                aVar.fX(6, this.sfa);
                if (this.npW != null) {
                    aVar.g(7, this.npW);
                }
                if (this.npV == null) {
                    return 0;
                }
                aVar.g(8, this.npV);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wdG != null) {
                fW += e.a.a.b.b.a.h(2, this.wdG);
            }
            if (this.wdH != null) {
                fW += e.a.a.a.fW(3, this.wdH.bkL());
            }
            if (this.wdJ != null) {
                fW += e.a.a.a.fW(4, this.wdJ.bkL());
            }
            if (this.weD != null) {
                fW += e.a.a.a.fW(5, this.weD.bkL());
            }
            fW += e.a.a.a.fU(6, this.sfa);
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(7, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(8, this.npV);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wdH == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.wdJ == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.weD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsr bsr = (bsr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsr.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bsr.wdG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bum();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsr.wdH = fhVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bsq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsr.wdJ = fhVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsr.weD = fhVar;
                    }
                    return 0;
                case 6:
                    bsr.sfa = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bsr.npW = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bsr.npV = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
