package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ul extends bek {
    public int lot;
    public String lou;
    public String oeH;
    public String oiX;
    public String oje;

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
            aVar.fX(2, this.lot);
            if (this.lou != null) {
                aVar.g(3, this.lou);
            }
            if (this.oeH != null) {
                aVar.g(4, this.oeH);
            }
            if (this.oiX != null) {
                aVar.g(5, this.oiX);
            }
            if (this.oje == null) {
                return 0;
            }
            aVar.g(6, this.oje);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.lot);
            if (this.lou != null) {
                fW += e.a.a.b.b.a.h(3, this.lou);
            }
            if (this.oeH != null) {
                fW += e.a.a.b.b.a.h(4, this.oeH);
            }
            if (this.oiX != null) {
                fW += e.a.a.b.b.a.h(5, this.oiX);
            }
            if (this.oje != null) {
                fW += e.a.a.b.b.a.h(6, this.oje);
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
            ul ulVar = (ul) objArr[1];
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
                        ulVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ulVar.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ulVar.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ulVar.oeH = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ulVar.oiX = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ulVar.oje = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
