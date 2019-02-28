package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public class IMBehavior extends a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.opType);
            if (this.chattingOp != null) {
                aVar.fZ(2, this.chattingOp.bkL());
                this.chattingOp.a(aVar);
            }
            if (this.msgOp != null) {
                aVar.fZ(3, this.msgOp.bkL());
                this.msgOp.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.opType) + 0;
            if (this.chattingOp != null) {
                fU += e.a.a.a.fW(2, this.chattingOp.bkL());
            }
            if (this.msgOp != null) {
                return fU + e.a.a.a.fW(3, this.msgOp.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a iMBehaviorChattingOP;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iMBehavior.opType = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iMBehaviorChattingOP = new IMBehaviorMsgOP();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.msgOp = iMBehaviorChattingOP;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
