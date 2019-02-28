package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ci extends a {
    public String nnm;
    public dt vOo;
    public LinkedList<ajv> vOp = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOo == null) {
                throw new b("Not all required fields were included: ArtisAuthor");
            }
            if (this.vOo != null) {
                aVar.fZ(1, this.vOo.bkL());
                this.vOo.a(aVar);
            }
            aVar.d(2, 8, this.vOp);
            if (this.nnm == null) {
                return 0;
            }
            aVar.g(3, this.nnm);
            return 0;
        } else if (i == 1) {
            if (this.vOo != null) {
                fW = e.a.a.a.fW(1, this.vOo.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.c(2, 8, this.vOp);
            if (this.nnm != null) {
                fW += e.a.a.b.b.a.h(3, this.nnm);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vOp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vOo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisAuthor");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ci ciVar = (ci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a dtVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dtVar = new dt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dtVar.a(aVar4, dtVar, a.a(aVar4))) {
                        }
                        ciVar.vOo = dtVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dtVar = new ajv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dtVar.a(aVar4, dtVar, a.a(aVar4))) {
                        }
                        ciVar.vOp.add(dtVar);
                    }
                    return 0;
                case 3:
                    ciVar.nnm = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
