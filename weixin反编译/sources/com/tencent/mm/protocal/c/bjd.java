package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjd extends bek {
    public int vSa;
    public float wHu;
    public int wTf;
    public bes wTg;
    public bes wTh;
    public bes wTi;
    public bes wTj;
    public bes wTk;
    public int wTl;
    public int wTm;
    public String wTn;
    public bes wuf;
    public bes wug;
    public bes wuh;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wTg == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.wTh == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.wug == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.wuh == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.wTi == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.wTj == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.wTk == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.wuf == null) {
                throw new b("Not all required fields were included: SongLyric");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(2, this.vSa);
                aVar.fX(3, this.wTf);
                aVar.m(4, this.wHu);
                if (this.wTg != null) {
                    aVar.fZ(5, this.wTg.bkL());
                    this.wTg.a(aVar);
                }
                if (this.wTh != null) {
                    aVar.fZ(6, this.wTh.bkL());
                    this.wTh.a(aVar);
                }
                if (this.wug != null) {
                    aVar.fZ(7, this.wug.bkL());
                    this.wug.a(aVar);
                }
                if (this.wuh != null) {
                    aVar.fZ(8, this.wuh.bkL());
                    this.wuh.a(aVar);
                }
                if (this.wTi != null) {
                    aVar.fZ(9, this.wTi.bkL());
                    this.wTi.a(aVar);
                }
                if (this.wTj != null) {
                    aVar.fZ(10, this.wTj.bkL());
                    this.wTj.a(aVar);
                }
                if (this.wTk != null) {
                    aVar.fZ(11, this.wTk.bkL());
                    this.wTk.a(aVar);
                }
                if (this.wuf != null) {
                    aVar.fZ(12, this.wuf.bkL());
                    this.wuf.a(aVar);
                }
                aVar.fX(13, this.wTl);
                aVar.fX(14, this.wTm);
                if (this.wTn == null) {
                    return 0;
                }
                aVar.g(15, this.wTn);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.vSa)) + e.a.a.a.fU(3, this.wTf)) + (e.a.a.b.b.a.dX(4) + 4);
            if (this.wTg != null) {
                fW += e.a.a.a.fW(5, this.wTg.bkL());
            }
            if (this.wTh != null) {
                fW += e.a.a.a.fW(6, this.wTh.bkL());
            }
            if (this.wug != null) {
                fW += e.a.a.a.fW(7, this.wug.bkL());
            }
            if (this.wuh != null) {
                fW += e.a.a.a.fW(8, this.wuh.bkL());
            }
            if (this.wTi != null) {
                fW += e.a.a.a.fW(9, this.wTi.bkL());
            }
            if (this.wTj != null) {
                fW += e.a.a.a.fW(10, this.wTj.bkL());
            }
            if (this.wTk != null) {
                fW += e.a.a.a.fW(11, this.wTk.bkL());
            }
            if (this.wuf != null) {
                fW += e.a.a.a.fW(12, this.wuf.bkL());
            }
            fW = (fW + e.a.a.a.fU(13, this.wTl)) + e.a.a.a.fU(14, this.wTm);
            if (this.wTn != null) {
                fW += e.a.a.b.b.a.h(15, this.wTn);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wTg == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.wTh == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.wug == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.wuh == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.wTi == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.wTj == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.wTk == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.wuf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SongLyric");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjd bjd = (bjd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bjd.vSa = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bjd.wTf = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bjd.wHu = aVar3.AEQ.readFloat();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wTg = fiVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wTh = fiVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wug = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wuh = fiVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wTi = fiVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wTj = fiVar;
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wTk = fiVar;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjd.wuf = fiVar;
                    }
                    return 0;
                case 13:
                    bjd.wTl = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bjd.wTm = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bjd.wTn = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
