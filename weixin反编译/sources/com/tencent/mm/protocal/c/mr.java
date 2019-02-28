package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class mr extends bek {
    public String hxh;
    public int wch;
    public String wci;
    public String wcj;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.hxh != null) {
                aVar.g(2, this.hxh);
            }
            aVar.fX(3, this.wch);
            if (this.wci != null) {
                aVar.g(4, this.wci);
            }
            if (this.wcj == null) {
                return 0;
            }
            aVar.g(5, this.wcj);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(2, this.hxh);
            }
            fW += e.a.a.a.fU(3, this.wch);
            if (this.wci != null) {
                fW += e.a.a.b.b.a.h(4, this.wci);
            }
            if (this.wcj != null) {
                fW += e.a.a.b.b.a.h(5, this.wcj);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            mr mrVar = (mr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        mrVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    mrVar.hxh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    mrVar.wch = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    mrVar.wci = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    mrVar.wcj = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
