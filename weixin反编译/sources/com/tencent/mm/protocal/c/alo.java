package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class alo extends a {
    public String pht;
    public String pjS;
    public String wpq;
    public String wzu;
    public String wzv;
    public String wzw;
    public String wzx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pjS == null) {
                throw new b("Not all required fields were included: product_id");
            } else if (this.pht == null) {
                throw new b("Not all required fields were included: price");
            } else if (this.wpq == null) {
                throw new b("Not all required fields were included: currency_type");
            } else if (this.wzu == null) {
                throw new b("Not all required fields were included: session_data");
            } else {
                if (this.pjS != null) {
                    aVar.g(1, this.pjS);
                }
                if (this.pht != null) {
                    aVar.g(2, this.pht);
                }
                if (this.wpq != null) {
                    aVar.g(3, this.wpq);
                }
                if (this.wzu != null) {
                    aVar.g(4, this.wzu);
                }
                if (this.wzv != null) {
                    aVar.g(5, this.wzv);
                }
                if (this.wzw != null) {
                    aVar.g(6, this.wzw);
                }
                if (this.wzx == null) {
                    return 0;
                }
                aVar.g(7, this.wzx);
                return 0;
            }
        } else if (i == 1) {
            if (this.pjS != null) {
                h = e.a.a.b.b.a.h(1, this.pjS) + 0;
            } else {
                h = 0;
            }
            if (this.pht != null) {
                h += e.a.a.b.b.a.h(2, this.pht);
            }
            if (this.wpq != null) {
                h += e.a.a.b.b.a.h(3, this.wpq);
            }
            if (this.wzu != null) {
                h += e.a.a.b.b.a.h(4, this.wzu);
            }
            if (this.wzv != null) {
                h += e.a.a.b.b.a.h(5, this.wzv);
            }
            if (this.wzw != null) {
                h += e.a.a.b.b.a.h(6, this.wzw);
            }
            if (this.wzx != null) {
                h += e.a.a.b.b.a.h(7, this.wzx);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.pjS == null) {
                throw new b("Not all required fields were included: product_id");
            } else if (this.pht == null) {
                throw new b("Not all required fields were included: price");
            } else if (this.wpq == null) {
                throw new b("Not all required fields were included: currency_type");
            } else if (this.wzu != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: session_data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alo alo = (alo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alo.pjS = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    alo.pht = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    alo.wpq = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    alo.wzu = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    alo.wzv = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    alo.wzw = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    alo.wzx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
