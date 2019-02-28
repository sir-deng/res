package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class vd extends a {
    public LinkedList<ash> mwB = new LinkedList();
    public LinkedList<ask> wlH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.mwB);
            aVar.d(2, 8, this.wlH);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.mwB) + 0) + e.a.a.a.c(2, 8, this.wlH);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.mwB.clear();
                this.wlH.clear();
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
                vd vdVar = (vd) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList JD;
                int size;
                a ash;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            ash = new ash();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = ash.a(aVar4, ash, a.a(aVar4))) {
                            }
                            vdVar.mwB.add(ash);
                        }
                        return 0;
                    case 2:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            ash = new ask();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = ash.a(aVar4, ash, a.a(aVar4))) {
                            }
                            vdVar.wlH.add(ash);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
