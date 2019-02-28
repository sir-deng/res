package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public class cdv extends a {
    public String kyG;
    public String nlA;
    public String nlV;
    public String nmj;
    public String noG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlV == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.noG == null) {
                throw new b("Not all required fields were included: AppName");
            } else if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.nlA == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else {
                if (this.nlV != null) {
                    aVar.g(1, this.nlV);
                }
                if (this.noG != null) {
                    aVar.g(2, this.noG);
                }
                if (this.kyG != null) {
                    aVar.g(3, this.kyG);
                }
                if (this.nlA != null) {
                    aVar.g(4, this.nlA);
                }
                if (this.nmj == null) {
                    return 0;
                }
                aVar.g(5, this.nmj);
                return 0;
            }
        } else if (i == 1) {
            if (this.nlV != null) {
                h = e.a.a.b.b.a.h(1, this.nlV) + 0;
            } else {
                h = 0;
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(2, this.noG);
            }
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(3, this.kyG);
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(4, this.nlA);
            }
            if (this.nmj != null) {
                h += e.a.a.b.b.a.h(5, this.nmj);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlV == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.noG == null) {
                throw new b("Not all required fields were included: AppName");
            } else if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.nlA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdv cdv = (cdv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdv.nlV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cdv.noG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cdv.kyG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cdv.nlA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cdv.nmj = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
