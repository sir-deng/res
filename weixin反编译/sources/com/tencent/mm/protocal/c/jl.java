package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jl extends a {
    public String kzN;
    public String nkN;
    public jn vWo;
    public bgm vWr;
    public js vWs;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kzN == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vWr == null) {
                throw new b("Not all required fields were included: ContactItem");
            } else {
                if (this.kzN != null) {
                    aVar.g(1, this.kzN);
                }
                if (this.vWo != null) {
                    aVar.fZ(2, this.vWo.bkL());
                    this.vWo.a(aVar);
                }
                if (this.vWr != null) {
                    aVar.fZ(3, this.vWr.bkL());
                    this.vWr.a(aVar);
                }
                if (this.vWs != null) {
                    aVar.fZ(4, this.vWs.bkL());
                    this.vWs.a(aVar);
                }
                if (this.nkN == null) {
                    return 0;
                }
                aVar.g(5, this.nkN);
                return 0;
            }
        } else if (i == 1) {
            if (this.kzN != null) {
                h = e.a.a.b.b.a.h(1, this.kzN) + 0;
            } else {
                h = 0;
            }
            if (this.vWo != null) {
                h += e.a.a.a.fW(2, this.vWo.bkL());
            }
            if (this.vWr != null) {
                h += e.a.a.a.fW(3, this.vWr.bkL());
            }
            if (this.vWs != null) {
                h += e.a.a.a.fW(4, this.vWs.bkL());
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(5, this.nkN);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kzN == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vWr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ContactItem");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jl jlVar = (jl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a jnVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jlVar.kzN = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jnVar = new jn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jnVar.a(aVar4, jnVar, a.a(aVar4))) {
                        }
                        jlVar.vWo = jnVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jnVar = new bgm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jnVar.a(aVar4, jnVar, a.a(aVar4))) {
                        }
                        jlVar.vWr = jnVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jnVar = new js();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jnVar.a(aVar4, jnVar, a.a(aVar4))) {
                        }
                        jlVar.vWs = jnVar;
                    }
                    return 0;
                case 5:
                    jlVar.nkN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
