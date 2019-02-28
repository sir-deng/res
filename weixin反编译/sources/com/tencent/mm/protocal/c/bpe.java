package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class bpe extends a {
    public String feB;
    public String fpV;
    public int jOx;
    public String nBJ;
    public String nGV;
    public String nGX;
    public String nGY;
    public String nGZ;
    public String title;
    public int versionCode;
    public String wYv;
    public String wYw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nGX == null) {
                throw new b("Not all required fields were included: patchId");
            } else if (this.nGY == null) {
                throw new b("Not all required fields were included: newApkMd5");
            } else if (this.nGZ == null) {
                throw new b("Not all required fields were included: oldApkMd5");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else if (this.wYw == null) {
                throw new b("Not all required fields were included: okBtn");
            } else if (this.nBJ == null) {
                throw new b("Not all required fields were included: cancelBtn");
            } else if (this.feB == null) {
                throw new b("Not all required fields were included: patchMd5");
            } else {
                if (this.nGX != null) {
                    aVar.g(1, this.nGX);
                }
                if (this.wYv != null) {
                    aVar.g(2, this.wYv);
                }
                aVar.fX(3, this.jOx);
                if (this.nGY != null) {
                    aVar.g(4, this.nGY);
                }
                if (this.nGZ != null) {
                    aVar.g(5, this.nGZ);
                }
                if (this.title != null) {
                    aVar.g(6, this.title);
                }
                if (this.fpV != null) {
                    aVar.g(7, this.fpV);
                }
                if (this.wYw != null) {
                    aVar.g(8, this.wYw);
                }
                if (this.nBJ != null) {
                    aVar.g(9, this.nBJ);
                }
                if (this.nGV != null) {
                    aVar.g(10, this.nGV);
                }
                if (this.feB != null) {
                    aVar.g(11, this.feB);
                }
                aVar.fX(12, this.versionCode);
                return 0;
            }
        } else if (i == 1) {
            if (this.nGX != null) {
                h = e.a.a.b.b.a.h(1, this.nGX) + 0;
            } else {
                h = 0;
            }
            if (this.wYv != null) {
                h += e.a.a.b.b.a.h(2, this.wYv);
            }
            h += e.a.a.a.fU(3, this.jOx);
            if (this.nGY != null) {
                h += e.a.a.b.b.a.h(4, this.nGY);
            }
            if (this.nGZ != null) {
                h += e.a.a.b.b.a.h(5, this.nGZ);
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(6, this.title);
            }
            if (this.fpV != null) {
                h += e.a.a.b.b.a.h(7, this.fpV);
            }
            if (this.wYw != null) {
                h += e.a.a.b.b.a.h(8, this.wYw);
            }
            if (this.nBJ != null) {
                h += e.a.a.b.b.a.h(9, this.nBJ);
            }
            if (this.nGV != null) {
                h += e.a.a.b.b.a.h(10, this.nGV);
            }
            if (this.feB != null) {
                h += e.a.a.b.b.a.h(11, this.feB);
            }
            return h + e.a.a.a.fU(12, this.versionCode);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nGX == null) {
                throw new b("Not all required fields were included: patchId");
            } else if (this.nGY == null) {
                throw new b("Not all required fields were included: newApkMd5");
            } else if (this.nGZ == null) {
                throw new b("Not all required fields were included: oldApkMd5");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else if (this.wYw == null) {
                throw new b("Not all required fields were included: okBtn");
            } else if (this.nBJ == null) {
                throw new b("Not all required fields were included: cancelBtn");
            } else if (this.feB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: patchMd5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpe bpe = (bpe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpe.nGX = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bpe.wYv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bpe.jOx = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bpe.nGY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bpe.nGZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bpe.title = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bpe.fpV = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bpe.wYw = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bpe.nBJ = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bpe.nGV = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bpe.feB = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    bpe.versionCode = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
