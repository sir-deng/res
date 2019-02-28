package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class vt extends a {
    public String appId;
    public String fAJ;
    public String fEE;
    public String fJM;
    public String foe;
    public int fqY;
    public boolean hBU = false;
    public String hPT;
    public long hXs;
    public String toUser;
    public boolean wlA = false;
    public boolean wlB = false;
    public boolean wlC = false;
    public String wlD;
    public boolean wlE = false;
    public boolean wlF = false;
    public boolean wls = false;
    public boolean wlt = false;
    public boolean wlu = false;
    public String wlx;
    public boolean wly = false;
    public boolean wlz = false;
    public String wmg;
    public boolean wmh = false;

    public final vt Dl(int i) {
        this.fqY = i;
        this.wls = true;
        return this;
    }

    public final vt UN(String str) {
        this.fAJ = str;
        this.wlt = true;
        return this;
    }

    public final vt UO(String str) {
        this.toUser = str;
        this.wlu = true;
        return this;
    }

    public final vt UP(String str) {
        this.wmg = str;
        this.wmh = true;
        return this;
    }

    public final vt UQ(String str) {
        this.wlx = str;
        this.wly = true;
        return this;
    }

    public final vt fD(long j) {
        this.hXs = j;
        this.hBU = true;
        return this;
    }

    public final vt UR(String str) {
        this.fEE = str;
        this.wlz = true;
        return this;
    }

    public final vt US(String str) {
        this.fJM = str;
        this.wlA = true;
        return this;
    }

    public final vt UT(String str) {
        this.appId = str;
        this.wlB = true;
        return this;
    }

    public final vt UU(String str) {
        this.hPT = str;
        this.wlC = true;
        return this;
    }

    public final vt UV(String str) {
        this.foe = str;
        this.wlF = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wls) {
                if (this.wls) {
                    aVar.fX(1, this.fqY);
                }
                if (this.fAJ != null) {
                    aVar.g(2, this.fAJ);
                }
                if (this.toUser != null) {
                    aVar.g(3, this.toUser);
                }
                if (this.wmg != null) {
                    aVar.g(4, this.wmg);
                }
                if (this.wlx != null) {
                    aVar.g(5, this.wlx);
                }
                if (this.hBU) {
                    aVar.S(6, this.hXs);
                }
                if (this.fEE != null) {
                    aVar.g(7, this.fEE);
                }
                if (this.fJM != null) {
                    aVar.g(8, this.fJM);
                }
                if (this.appId != null) {
                    aVar.g(9, this.appId);
                }
                if (this.hPT != null) {
                    aVar.g(10, this.hPT);
                }
                if (this.wlD != null) {
                    aVar.g(11, this.wlD);
                }
                if (this.foe == null) {
                    return 0;
                }
                aVar.g(12, this.foe);
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i == 1) {
            if (this.wls) {
                fU = e.a.a.a.fU(1, this.fqY) + 0;
            } else {
                fU = 0;
            }
            if (this.fAJ != null) {
                fU += e.a.a.b.b.a.h(2, this.fAJ);
            }
            if (this.toUser != null) {
                fU += e.a.a.b.b.a.h(3, this.toUser);
            }
            if (this.wmg != null) {
                fU += e.a.a.b.b.a.h(4, this.wmg);
            }
            if (this.wlx != null) {
                fU += e.a.a.b.b.a.h(5, this.wlx);
            }
            if (this.hBU) {
                fU += e.a.a.a.R(6, this.hXs);
            }
            if (this.fEE != null) {
                fU += e.a.a.b.b.a.h(7, this.fEE);
            }
            if (this.fJM != null) {
                fU += e.a.a.b.b.a.h(8, this.fJM);
            }
            if (this.appId != null) {
                fU += e.a.a.b.b.a.h(9, this.appId);
            }
            if (this.hPT != null) {
                fU += e.a.a.b.b.a.h(10, this.hPT);
            }
            if (this.wlD != null) {
                fU += e.a.a.b.b.a.h(11, this.wlD);
            }
            if (this.foe != null) {
                fU += e.a.a.b.b.a.h(12, this.foe);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wls) {
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vt vtVar = (vt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vtVar.fqY = aVar3.AEQ.rz();
                    vtVar.wls = true;
                    return 0;
                case 2:
                    vtVar.fAJ = aVar3.AEQ.readString();
                    vtVar.wlt = true;
                    return 0;
                case 3:
                    vtVar.toUser = aVar3.AEQ.readString();
                    vtVar.wlu = true;
                    return 0;
                case 4:
                    vtVar.wmg = aVar3.AEQ.readString();
                    vtVar.wmh = true;
                    return 0;
                case 5:
                    vtVar.wlx = aVar3.AEQ.readString();
                    vtVar.wly = true;
                    return 0;
                case 6:
                    vtVar.hXs = aVar3.AEQ.rA();
                    vtVar.hBU = true;
                    return 0;
                case 7:
                    vtVar.fEE = aVar3.AEQ.readString();
                    vtVar.wlz = true;
                    return 0;
                case 8:
                    vtVar.fJM = aVar3.AEQ.readString();
                    vtVar.wlA = true;
                    return 0;
                case 9:
                    vtVar.appId = aVar3.AEQ.readString();
                    vtVar.wlB = true;
                    return 0;
                case 10:
                    vtVar.hPT = aVar3.AEQ.readString();
                    vtVar.wlC = true;
                    return 0;
                case 11:
                    vtVar.wlD = aVar3.AEQ.readString();
                    vtVar.wlE = true;
                    return 0;
                case 12:
                    vtVar.foe = aVar3.AEQ.readString();
                    vtVar.wlF = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
