package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class vn extends a {
    public String desc;
    public String iLo;
    public String title;
    public vh vJG;
    public long vJH;
    public int version;
    public boolean wjG = false;
    public boolean wjH = false;
    public vt wlW;
    public boolean wlX = false;
    public LinkedList<uz> wlY = new LinkedList();
    public boolean wlZ = false;
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
    public boolean wma = false;

    public final vn a(vt vtVar) {
        this.wlW = vtVar;
        this.wlX = true;
        return this;
    }

    public final vn aw(LinkedList<uz> linkedList) {
        this.wlY = linkedList;
        this.wlZ = true;
        return this;
    }

    public final vn b(vg vgVar) {
        this.wld = vgVar;
        this.wle = true;
        return this;
    }

    public final vn b(wc wcVar) {
        this.wlf = wcVar;
        this.wlg = true;
        return this;
    }

    public final vn UK(String str) {
        this.iLo = str;
        this.wll = true;
        return this;
    }

    public final vn UL(String str) {
        this.title = str;
        this.wjG = true;
        return this;
    }

    public final vn UM(String str) {
        this.desc = str;
        this.wjH = true;
        return this;
    }

    public final vn fB(long j) {
        this.wlm = j;
        this.wln = true;
        return this;
    }

    public final vn Dj(int i) {
        this.wlo = i;
        this.wlp = true;
        return this;
    }

    public final vn b(vm vmVar) {
        this.wlh = vmVar;
        this.wli = true;
        return this;
    }

    public final vn fC(long j) {
        this.vJH = j;
        this.wlq = true;
        return this;
    }

    public final vn b(vw vwVar) {
        this.wlj = vwVar;
        this.wlk = true;
        return this;
    }

    public final vn Dk(int i) {
        this.version = i;
        this.wma = true;
        return this;
    }

    public final vn a(vh vhVar) {
        this.vJG = vhVar;
        this.wlr = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wlW != null) {
                aVar.fZ(1, this.wlW.bkL());
                this.wlW.a(aVar);
            }
            aVar.d(2, 8, this.wlY);
            if (this.wld != null) {
                aVar.fZ(3, this.wld.bkL());
                this.wld.a(aVar);
            }
            if (this.wlf != null) {
                aVar.fZ(4, this.wlf.bkL());
                this.wlf.a(aVar);
            }
            if (this.iLo != null) {
                aVar.g(5, this.iLo);
            }
            if (this.title != null) {
                aVar.g(6, this.title);
            }
            if (this.desc != null) {
                aVar.g(7, this.desc);
            }
            if (this.wln) {
                aVar.S(8, this.wlm);
            }
            if (this.wlp) {
                aVar.fX(91, this.wlo);
            }
            if (this.wlh != null) {
                aVar.fZ(10, this.wlh.bkL());
                this.wlh.a(aVar);
            }
            if (this.wlq) {
                aVar.S(11, this.vJH);
            }
            if (this.wlj != null) {
                aVar.fZ(12, this.wlj.bkL());
                this.wlj.a(aVar);
            }
            if (this.wma) {
                aVar.fX(13, this.version);
            }
            if (this.vJG == null) {
                return 0;
            }
            aVar.fZ(14, this.vJG.bkL());
            this.vJG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wlW != null) {
                fW = e.a.a.a.fW(1, this.wlW.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.c(2, 8, this.wlY);
            if (this.wld != null) {
                fW += e.a.a.a.fW(3, this.wld.bkL());
            }
            if (this.wlf != null) {
                fW += e.a.a.a.fW(4, this.wlf.bkL());
            }
            if (this.iLo != null) {
                fW += e.a.a.b.b.a.h(5, this.iLo);
            }
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(6, this.title);
            }
            if (this.desc != null) {
                fW += e.a.a.b.b.a.h(7, this.desc);
            }
            if (this.wln) {
                fW += e.a.a.a.R(8, this.wlm);
            }
            if (this.wlp) {
                fW += e.a.a.a.fU(91, this.wlo);
            }
            if (this.wlh != null) {
                fW += e.a.a.a.fW(10, this.wlh.bkL());
            }
            if (this.wlq) {
                fW += e.a.a.a.R(11, this.vJH);
            }
            if (this.wlj != null) {
                fW += e.a.a.a.fW(12, this.wlj.bkL());
            }
            if (this.wma) {
                fW += e.a.a.a.fU(13, this.version);
            }
            if (this.vJG != null) {
                fW += e.a.a.a.fW(14, this.vJG.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            vn vnVar = (vn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a vtVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new vt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.wlW = vtVar;
                    }
                    vnVar.wlX = true;
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new uz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.wlY.add(vtVar);
                    }
                    vnVar.wlZ = true;
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new vg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.wld = vtVar;
                    }
                    vnVar.wle = true;
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new wc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.wlf = vtVar;
                    }
                    vnVar.wlg = true;
                    return 0;
                case 5:
                    vnVar.iLo = aVar3.AEQ.readString();
                    vnVar.wll = true;
                    return 0;
                case 6:
                    vnVar.title = aVar3.AEQ.readString();
                    vnVar.wjG = true;
                    return 0;
                case 7:
                    vnVar.desc = aVar3.AEQ.readString();
                    vnVar.wjH = true;
                    return 0;
                case 8:
                    vnVar.wlm = aVar3.AEQ.rA();
                    vnVar.wln = true;
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new vm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.wlh = vtVar;
                    }
                    vnVar.wli = true;
                    return 0;
                case 11:
                    vnVar.vJH = aVar3.AEQ.rA();
                    vnVar.wlq = true;
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new vw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.wlj = vtVar;
                    }
                    vnVar.wlk = true;
                    return 0;
                case 13:
                    vnVar.version = aVar3.AEQ.rz();
                    vnVar.wma = true;
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vtVar = new vh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.a(aVar4, vtVar, a.a(aVar4))) {
                        }
                        vnVar.vJG = vtVar;
                    }
                    vnVar.wlr = true;
                    return 0;
                case 91:
                    vnVar.wlo = aVar3.AEQ.rz();
                    vnVar.wlp = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
