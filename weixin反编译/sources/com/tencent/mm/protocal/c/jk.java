package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jk extends a {
    public String fpg;
    public String nkL;
    public String phv;
    public jn vWo;
    public jo vWp;
    public jh vWq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.phv == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.vWo == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.vWq == null) {
                throw new b("Not all required fields were included: ActionInfo");
            } else {
                if (this.fpg != null) {
                    aVar.g(1, this.fpg);
                }
                if (this.nkL != null) {
                    aVar.g(2, this.nkL);
                }
                if (this.phv != null) {
                    aVar.g(3, this.phv);
                }
                if (this.vWo != null) {
                    aVar.fZ(4, this.vWo.bkL());
                    this.vWo.a(aVar);
                }
                if (this.vWp != null) {
                    aVar.fZ(5, this.vWp.bkL());
                    this.vWp.a(aVar);
                }
                if (this.vWq == null) {
                    return 0;
                }
                aVar.fZ(6, this.vWq.bkL());
                this.vWq.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(2, this.nkL);
            }
            if (this.phv != null) {
                h += e.a.a.b.b.a.h(3, this.phv);
            }
            if (this.vWo != null) {
                h += e.a.a.a.fW(4, this.vWo.bkL());
            }
            if (this.vWp != null) {
                h += e.a.a.a.fW(5, this.vWp.bkL());
            }
            if (this.vWq != null) {
                h += e.a.a.a.fW(6, this.vWq.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.phv == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.vWo == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.vWq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActionInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jk jkVar = (jk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a jnVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jkVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    jkVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    jkVar.phv = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jnVar = new jn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jnVar.a(aVar4, jnVar, a.a(aVar4))) {
                        }
                        jkVar.vWo = jnVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jnVar = new jo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jnVar.a(aVar4, jnVar, a.a(aVar4))) {
                        }
                        jkVar.vWp = jnVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jnVar = new jh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jnVar.a(aVar4, jnVar, a.a(aVar4))) {
                        }
                        jkVar.vWq = jnVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
