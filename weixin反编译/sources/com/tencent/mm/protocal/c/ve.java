package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ve extends a {
    public String appId;
    public String desc;
    public String fAJ;
    public vn fFC;
    public String foe;
    public String title;
    public int type;
    public String wlI;
    public LinkedList<String> wlJ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.fAJ != null) {
                aVar.g(3, this.fAJ);
            }
            if (this.wlI != null) {
                aVar.g(4, this.wlI);
            }
            if (this.appId != null) {
                aVar.g(5, this.appId);
            }
            if (this.foe != null) {
                aVar.g(6, this.foe);
            }
            aVar.d(7, 1, this.wlJ);
            aVar.fX(8, this.type);
            if (this.fFC == null) {
                return 0;
            }
            aVar.fZ(9, this.fFC.bkL());
            this.fFC.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(2, this.desc);
            }
            if (this.fAJ != null) {
                h += e.a.a.b.b.a.h(3, this.fAJ);
            }
            if (this.wlI != null) {
                h += e.a.a.b.b.a.h(4, this.wlI);
            }
            if (this.appId != null) {
                h += e.a.a.b.b.a.h(5, this.appId);
            }
            if (this.foe != null) {
                h += e.a.a.b.b.a.h(6, this.foe);
            }
            h = (h + e.a.a.a.c(7, 1, this.wlJ)) + e.a.a.a.fU(8, this.type);
            if (this.fFC != null) {
                h += e.a.a.a.fW(9, this.fFC.bkL());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ve veVar = (ve) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    veVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    veVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    veVar.fAJ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    veVar.wlI = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    veVar.appId = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    veVar.foe = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    veVar.wlJ.add(aVar3.AEQ.readString());
                    return 0;
                case 8:
                    veVar.type = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a vnVar = new vn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = vnVar.a(aVar4, vnVar, a.a(aVar4))) {
                        }
                        veVar.fFC = vnVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
