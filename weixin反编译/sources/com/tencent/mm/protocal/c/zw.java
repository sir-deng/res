package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zw extends bea {
    public String kZQ;
    public String sSA;
    public String signature;
    public String vVt;
    public String wfm;
    public String wqn;
    public String wqo;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wqn == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.sSA == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.kZQ == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.vVt == null) {
                throw new b("Not all required fields were included: from_url");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wfm != null) {
                    aVar.g(2, this.wfm);
                }
                if (this.wqn != null) {
                    aVar.g(3, this.wqn);
                }
                if (this.sSA != null) {
                    aVar.g(4, this.sSA);
                }
                if (this.kZQ != null) {
                    aVar.g(5, this.kZQ);
                }
                if (this.signature != null) {
                    aVar.g(6, this.signature);
                }
                if (this.vVt != null) {
                    aVar.g(7, this.vVt);
                }
                if (this.wqo == null) {
                    return 0;
                }
                aVar.g(8, this.wqo);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wfm != null) {
                fW += e.a.a.b.b.a.h(2, this.wfm);
            }
            if (this.wqn != null) {
                fW += e.a.a.b.b.a.h(3, this.wqn);
            }
            if (this.sSA != null) {
                fW += e.a.a.b.b.a.h(4, this.sSA);
            }
            if (this.kZQ != null) {
                fW += e.a.a.b.b.a.h(5, this.kZQ);
            }
            if (this.signature != null) {
                fW += e.a.a.b.b.a.h(6, this.signature);
            }
            if (this.vVt != null) {
                fW += e.a.a.b.b.a.h(7, this.vVt);
            }
            if (this.wqo != null) {
                fW += e.a.a.b.b.a.h(8, this.wqo);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wqn == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.sSA == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.kZQ == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.vVt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: from_url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zw zwVar = (zw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        zwVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    zwVar.wfm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    zwVar.wqn = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    zwVar.sSA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    zwVar.kZQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    zwVar.signature = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    zwVar.vVt = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    zwVar.wqo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
