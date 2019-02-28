package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aio extends bek {
    public int wrR;
    public LinkedList<bya> wrS = new LinkedList();
    public String wws;
    public String wwu;
    public int wwv;
    public String www;
    public String wwx;
    public String wwy;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.wrR);
            aVar.d(3, 8, this.wrS);
            if (this.wwu != null) {
                aVar.g(4, this.wwu);
            }
            if (this.wws != null) {
                aVar.g(5, this.wws);
            }
            aVar.fX(6, this.wwv);
            if (this.www != null) {
                aVar.g(7, this.www);
            }
            if (this.wwx != null) {
                aVar.g(8, this.wwx);
            }
            if (this.wwy == null) {
                return 0;
            }
            aVar.g(9, this.wwy);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.wrR)) + e.a.a.a.c(3, 8, this.wrS);
            if (this.wwu != null) {
                fW += e.a.a.b.b.a.h(4, this.wwu);
            }
            if (this.wws != null) {
                fW += e.a.a.b.b.a.h(5, this.wws);
            }
            fW += e.a.a.a.fU(6, this.wwv);
            if (this.www != null) {
                fW += e.a.a.b.b.a.h(7, this.www);
            }
            if (this.wwx != null) {
                fW += e.a.a.b.b.a.h(8, this.wwx);
            }
            if (this.wwy != null) {
                fW += e.a.a.b.b.a.h(9, this.wwy);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wrS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aio aio = (aio) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        aio.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aio.wrR = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bya();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aio.wrS.add(fiVar);
                    }
                    return 0;
                case 4:
                    aio.wwu = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aio.wws = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aio.wwv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aio.www = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aio.wwx = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    aio.wwy = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
