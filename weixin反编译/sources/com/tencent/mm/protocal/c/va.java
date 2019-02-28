package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class va extends a {
    public String desc;
    public String iLo;
    public String title;
    public vh vJG;
    public long vJH;
    public boolean wjG = false;
    public boolean wjH = false;
    public vb wlb;
    public boolean wlc = false;
    public vg wld;
    public boolean wle = false;
    public wc wlf;
    public boolean wlg = false;
    public vm wlh;
    public boolean wli = false;
    public vw wlj;
    public boolean wlk = false;
    public boolean wll = false;
    public long wlm;
    public boolean wln = false;
    public int wlo = -1;
    public boolean wlp = false;
    public boolean wlq = false;
    public boolean wlr = false;

    public final va c(vb vbVar) {
        this.wlb = vbVar;
        this.wlc = true;
        return this;
    }

    public final va a(vg vgVar) {
        this.wld = vgVar;
        this.wle = true;
        return this;
    }

    public final va a(wc wcVar) {
        this.wlf = wcVar;
        this.wlg = true;
        return this;
    }

    public final va a(vm vmVar) {
        this.wlh = vmVar;
        this.wli = true;
        return this;
    }

    public final va a(vw vwVar) {
        this.wlj = vwVar;
        this.wlk = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wlb != null) {
                aVar.fZ(1, this.wlb.bkL());
                this.wlb.a(aVar);
            }
            if (this.wld != null) {
                aVar.fZ(2, this.wld.bkL());
                this.wld.a(aVar);
            }
            if (this.wlf != null) {
                aVar.fZ(3, this.wlf.bkL());
                this.wlf.a(aVar);
            }
            if (this.wlh != null) {
                aVar.fZ(4, this.wlh.bkL());
                this.wlh.a(aVar);
            }
            if (this.wlj != null) {
                aVar.fZ(5, this.wlj.bkL());
                this.wlj.a(aVar);
            }
            if (this.iLo != null) {
                aVar.g(6, this.iLo);
            }
            if (this.title != null) {
                aVar.g(7, this.title);
            }
            if (this.desc != null) {
                aVar.g(8, this.desc);
            }
            if (this.wln) {
                aVar.S(9, this.wlm);
            }
            if (this.wlp) {
                aVar.fX(101, this.wlo);
            }
            if (this.wlq) {
                aVar.S(11, this.vJH);
            }
            if (this.vJG == null) {
                return 0;
            }
            aVar.fZ(12, this.vJG.bkL());
            this.vJG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wlb != null) {
                fW = e.a.a.a.fW(1, this.wlb.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wld != null) {
                fW += e.a.a.a.fW(2, this.wld.bkL());
            }
            if (this.wlf != null) {
                fW += e.a.a.a.fW(3, this.wlf.bkL());
            }
            if (this.wlh != null) {
                fW += e.a.a.a.fW(4, this.wlh.bkL());
            }
            if (this.wlj != null) {
                fW += e.a.a.a.fW(5, this.wlj.bkL());
            }
            if (this.iLo != null) {
                fW += e.a.a.b.b.a.h(6, this.iLo);
            }
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(7, this.title);
            }
            if (this.desc != null) {
                fW += e.a.a.b.b.a.h(8, this.desc);
            }
            if (this.wln) {
                fW += e.a.a.a.R(9, this.wlm);
            }
            if (this.wlp) {
                fW += e.a.a.a.fU(101, this.wlo);
            }
            if (this.wlq) {
                fW += e.a.a.a.R(11, this.vJH);
            }
            if (this.vJG != null) {
                fW += e.a.a.a.fW(12, this.vJG.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            va vaVar = (va) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a vbVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vbVar = new vb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.a(aVar4, vbVar, a.a(aVar4))) {
                        }
                        vaVar.wlb = vbVar;
                    }
                    vaVar.wlc = true;
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vbVar = new vg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.a(aVar4, vbVar, a.a(aVar4))) {
                        }
                        vaVar.wld = vbVar;
                    }
                    vaVar.wle = true;
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vbVar = new wc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.a(aVar4, vbVar, a.a(aVar4))) {
                        }
                        vaVar.wlf = vbVar;
                    }
                    vaVar.wlg = true;
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vbVar = new vm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.a(aVar4, vbVar, a.a(aVar4))) {
                        }
                        vaVar.wlh = vbVar;
                    }
                    vaVar.wli = true;
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vbVar = new vw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.a(aVar4, vbVar, a.a(aVar4))) {
                        }
                        vaVar.wlj = vbVar;
                    }
                    vaVar.wlk = true;
                    return 0;
                case 6:
                    vaVar.iLo = aVar3.AEQ.readString();
                    vaVar.wll = true;
                    return 0;
                case 7:
                    vaVar.title = aVar3.AEQ.readString();
                    vaVar.wjG = true;
                    return 0;
                case 8:
                    vaVar.desc = aVar3.AEQ.readString();
                    vaVar.wjH = true;
                    return 0;
                case 9:
                    vaVar.wlm = aVar3.AEQ.rA();
                    vaVar.wln = true;
                    return 0;
                case 11:
                    vaVar.vJH = aVar3.AEQ.rA();
                    vaVar.wlq = true;
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vbVar = new vh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.a(aVar4, vbVar, a.a(aVar4))) {
                        }
                        vaVar.vJG = vbVar;
                    }
                    vaVar.wlr = true;
                    return 0;
                case 101:
                    vaVar.wlo = aVar3.AEQ.rz();
                    vaVar.wlp = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
