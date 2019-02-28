package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class vg extends a {
    public int fAq;
    public String fEp;
    public String label;
    public double lat;
    public double lng;
    public boolean wlK = false;
    public boolean wlL = false;
    public boolean wlM = false;
    public boolean wlN = false;
    public boolean wlO = false;

    public final vg r(double d) {
        this.lng = d;
        this.wlK = true;
        return this;
    }

    public final vg s(double d) {
        this.lat = d;
        this.wlL = true;
        return this;
    }

    public final vg Dh(int i) {
        this.fAq = i;
        this.wlM = true;
        return this;
    }

    public final vg UE(String str) {
        this.label = str;
        this.wlN = true;
        return this;
    }

    public final vg UF(String str) {
        this.fEp = str;
        this.wlO = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wlK) {
                aVar.b(1, this.lng);
            }
            if (this.wlL) {
                aVar.b(2, this.lat);
            }
            if (this.wlM) {
                aVar.fX(3, this.fAq);
            }
            if (this.label != null) {
                aVar.g(4, this.label);
            }
            if (this.fEp == null) {
                return 0;
            }
            aVar.g(5, this.fEp);
            return 0;
        } else if (i == 1) {
            if (this.wlK) {
                dX = (e.a.a.b.b.a.dX(1) + 8) + 0;
            } else {
                dX = 0;
            }
            if (this.wlL) {
                dX += e.a.a.b.b.a.dX(2) + 8;
            }
            if (this.wlM) {
                dX += e.a.a.a.fU(3, this.fAq);
            }
            if (this.label != null) {
                dX += e.a.a.b.b.a.h(4, this.label);
            }
            if (this.fEp != null) {
                dX += e.a.a.b.b.a.h(5, this.fEp);
            }
            return dX;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (dX = a.a(aVar2); dX > 0; dX = a.a(aVar2)) {
                if (!super.a(aVar2, this, dX)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vg vgVar = (vg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vgVar.lng = aVar3.AEQ.readDouble();
                    vgVar.wlK = true;
                    return 0;
                case 2:
                    vgVar.lat = aVar3.AEQ.readDouble();
                    vgVar.wlL = true;
                    return 0;
                case 3:
                    vgVar.fAq = aVar3.AEQ.rz();
                    vgVar.wlM = true;
                    return 0;
                case 4:
                    vgVar.label = aVar3.AEQ.readString();
                    vgVar.wlN = true;
                    return 0;
                case 5:
                    vgVar.fEp = aVar3.AEQ.readString();
                    vgVar.wlO = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
