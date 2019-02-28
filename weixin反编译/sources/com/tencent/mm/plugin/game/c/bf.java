package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fi;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bf extends bek {
    public boolean nnp;
    public ap nnq;
    public String nnr;
    public f nns;
    public af nnt;
    public g nnu;
    public dw nnv;

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
            aVar.am(2, this.nnp);
            if (this.nnq != null) {
                aVar.fZ(3, this.nnq.bkL());
                this.nnq.a(aVar);
            }
            if (this.nnr != null) {
                aVar.g(4, this.nnr);
            }
            if (this.nns != null) {
                aVar.fZ(5, this.nns.bkL());
                this.nns.a(aVar);
            }
            if (this.nnt != null) {
                aVar.fZ(6, this.nnt.bkL());
                this.nnt.a(aVar);
            }
            if (this.nnu != null) {
                aVar.fZ(7, this.nnu.bkL());
                this.nnu.a(aVar);
            }
            if (this.nnv == null) {
                return 0;
            }
            aVar.fZ(8, this.nnv.bkL());
            this.nnv.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.b.b.a.dX(2) + 1;
            if (this.nnq != null) {
                fW += e.a.a.a.fW(3, this.nnq.bkL());
            }
            if (this.nnr != null) {
                fW += e.a.a.b.b.a.h(4, this.nnr);
            }
            if (this.nns != null) {
                fW += e.a.a.a.fW(5, this.nns.bkL());
            }
            if (this.nnt != null) {
                fW += e.a.a.a.fW(6, this.nnt.bkL());
            }
            if (this.nnu != null) {
                fW += e.a.a.a.fW(7, this.nnu.bkL());
            }
            if (this.nnv != null) {
                fW += e.a.a.a.fW(8, this.nnv.bkL());
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
            bf bfVar = (bf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        bfVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bfVar.nnp = aVar3.cKv();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.nnq = fiVar;
                    }
                    return 0;
                case 4:
                    bfVar.nnr = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.nns = fiVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new af();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.nnt = fiVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.nnu = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new dw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.nnv = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
