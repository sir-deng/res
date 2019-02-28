package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class dm extends a {
    public dn vPk;
    public do vPq;
    public b vPr;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPq == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.vPk == null) {
                throw new e.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.vPr == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.vPq != null) {
                    aVar.fZ(1, this.vPq.bkL());
                    this.vPq.a(aVar);
                }
                if (this.vPk != null) {
                    aVar.fZ(2, this.vPk.bkL());
                    this.vPk.a(aVar);
                }
                if (this.vPr == null) {
                    return 0;
                }
                aVar.b(3, this.vPr);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPq != null) {
                fW = e.a.a.a.fW(1, this.vPq.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vPk != null) {
                fW += e.a.a.a.fW(2, this.vPk.bkL());
            }
            if (this.vPr != null) {
                fW += e.a.a.a.a(3, this.vPr);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vPq == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.vPk == null) {
                throw new e.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.vPr != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dm dmVar = (dm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a doVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        doVar = new do();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = doVar.a(aVar4, doVar, a.a(aVar4))) {
                        }
                        dmVar.vPq = doVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        doVar = new dn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = doVar.a(aVar4, doVar, a.a(aVar4))) {
                        }
                        dmVar.vPk = doVar;
                    }
                    return 0;
                case 3:
                    dmVar.vPr = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
