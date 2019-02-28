package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cbq extends a {
    public String wnt;
    public String wnv;
    public cbp xhw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wnt == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wnv == null) {
                throw new b("Not all required fields were included: MimeType");
            } else if (this.xhw == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.wnt != null) {
                    aVar.g(1, this.wnt);
                }
                if (this.wnv != null) {
                    aVar.g(2, this.wnv);
                }
                if (this.xhw == null) {
                    return 0;
                }
                aVar.fZ(3, this.xhw.bkL());
                this.xhw.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wnt != null) {
                h = e.a.a.b.b.a.h(1, this.wnt) + 0;
            } else {
                h = 0;
            }
            if (this.wnv != null) {
                h += e.a.a.b.b.a.h(2, this.wnv);
            }
            if (this.xhw != null) {
                h += e.a.a.a.fW(3, this.xhw.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wnt == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wnv == null) {
                throw new b("Not all required fields were included: MimeType");
            } else if (this.xhw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbq cbq = (cbq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbq.wnt = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cbq.wnv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cbp = new cbp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cbp.a(aVar4, cbp, a.a(aVar4))) {
                        }
                        cbq.xhw = cbp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
