package com.tencent.mm.ad;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.g.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class r extends a {
    private static e hpk;
    private d hog;
    private byte[] hpl;
    private int type;

    public static void a(e eVar) {
        hpk = eVar;
    }

    public r(d dVar, int i) {
        this.hog = dVar;
        this.type = i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, d dVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        if (bi.by(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            x.e(str, str2, objArr);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            b bVar = (b) dVar;
            byte[] Hw = bVar.Hw();
            if (Hw == null) {
                return false;
            }
            if (bVar.cev()) {
                byteArrayOutputStream.write(Hw);
                return true;
            }
            ac cey = ac.cey();
            int i = 6;
            if (z) {
                i = 7;
            }
            if (!MMProtocalJni.pack(Hw, pByteArray, bArr, bArr2, dVar.vHU, dVar.vHR, bVar.Hx(), cey.ver, cey.vIK.getBytes(), cey.vIL.getBytes(), bArr3, i)) {
                return false;
            }
            x.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i));
            byteArrayOutputStream.write(pByteArray.value);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            x.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
        PByteArray pByteArray = new PByteArray();
        x.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), bi.chl());
        switch (i) {
            case 268369922:
                try {
                    this.hpl = ((b) this.hog).Hw();
                    this.hog.vIa = (long) this.hpl.length;
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
                    return false;
                }
            default:
                if (this.hog instanceof b) {
                    try {
                        b bVar = (b) this.hog;
                        byte[] Hw = bVar.Hw();
                        if (Hw == null) {
                            return false;
                        }
                        if (bVar.cev()) {
                            this.hpl = Hw;
                            this.hog.vIa = (long) this.hpl.length;
                            return true;
                        }
                        long j;
                        int i3;
                        int i4;
                        Object obj;
                        long j2 = (long) this.hog.vHR;
                        if (com.tencent.mm.sdk.a.b.cfx() && j2 == 0) {
                            j = com.tencent.mm.protocal.d.vHk;
                        } else {
                            j = j2;
                        }
                        ac acVar = this.hog.vHZ;
                        if (!acVar.ceB()) {
                            bArr = new byte[0];
                        }
                        byte[][] bArr4 = null;
                        int obj2;
                        switch (i) {
                            case 701:
                                aqr aqr = ((i.d) this.hog).vHI;
                                bArr4 = a(j, aqr.wEj, aqr.wEk);
                                obj2 = 1;
                                break;
                            case 702:
                                x.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j));
                                if (j == 0) {
                                    if (c.a.vHH == null) {
                                        i3 = -1;
                                    } else {
                                        i3 = c.a.vHH.Hs();
                                    }
                                    g.Dr();
                                    g.Do();
                                    x.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.kernel.a.Cn()));
                                    com.tencent.mm.plugin.report.d.pVE.a(148, 54, 1, true);
                                    if (i3 != 0) {
                                        com.tencent.mm.plugin.report.d.pVE.a(148, 55, 1, true);
                                    }
                                    if (i4 != 0) {
                                        com.tencent.mm.plugin.report.d.pVE.a(148, 56, 1, true);
                                    }
                                }
                                ek ekVar = ((i.a) this.hog).vHG;
                                bArr4 = a(j, ekVar.vQu, ekVar.vQv);
                                obj2 = 1;
                                break;
                            default:
                                obj2 = null;
                                break;
                        }
                        i3 = 6;
                        if (z) {
                            i3 = 7;
                        }
                        if (obj2 != null) {
                            if (acVar.ceB() && bi.by(bArr)) {
                                x.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                return false;
                            } else if (bArr4 == null) {
                                return false;
                            } else {
                                byte[] bArr5 = bArr4[0];
                                byte[] bArr6 = bArr4[1];
                                switch (i) {
                                    case 702:
                                        if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.hog.vHU, (int) j, bVar.Hx(), acVar.ver, bArr5, bArr6, acVar.vIK.getBytes(), acVar.vIL.getBytes(), KL(), i3)) {
                                            x.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.hpl = pByteArray.value;
                                            break;
                                        }
                                        break;
                                    default:
                                        if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.hog.vHU, (int) j, bVar.Hx(), acVar.ver, bArr5, bArr6, acVar.vIK.getBytes(), acVar.vIL.getBytes(), KL(), i3)) {
                                            x.d("MicroMsg.RemoteReq", "MMEncryptCheckResUpdate reqToBuf packHybrid EncryptCheckResUpdate using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.hpl = pByteArray.value;
                                            break;
                                        }
                                        break;
                                }
                                this.hog.vIa = (long) this.hpl.length;
                            }
                        } else if (this.hog.vHX != null) {
                            int i5 = 6;
                            if (z) {
                                i5 = 7;
                            }
                            if (this.hog.vHX.a(pByteArray, i, bArr2, bArr3, i5)) {
                                this.hpl = pByteArray.value;
                                this.hog.vIa = (long) this.hpl.length;
                                x.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                            }
                            return true;
                        } else if (i != 775 && acVar.ceB() && bi.by(bArr)) {
                            x.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                            return false;
                        } else {
                            if (i == 775) {
                                i4 = (i3 & -3) & -5;
                            } else {
                                i4 = i3;
                            }
                            x.d("MicroMsg.RemoteReq", "dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s]", bArr, Integer.valueOf(i), Integer.valueOf(i4), bi.bx(bArr3));
                            if (MMProtocalJni.pack(Hw, pByteArray, bArr, bArr2, this.hog.vHU, (int) j, bVar.Hx(), acVar.ver, acVar.vIK.getBytes(), acVar.vIL.getBytes(), bArr3, i4)) {
                                x.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                this.hpl = pByteArray.value;
                            }
                            this.hog.vIa = (long) this.hpl.length;
                        }
                        return true;
                    } catch (Throwable e2) {
                        x.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                        return false;
                    }
                }
                x.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
                return false;
        }
    }

    public static byte[][] a(long j, com.tencent.mm.bp.a aVar, com.tencent.mm.bp.a aVar2) {
        byte[] toByteArray;
        if (j == 0) {
            x.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = aVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", bi.i(e));
            toByteArray = null;
        }
        if (bi.by(toByteArray)) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = aVar2.toByteArray();
        } catch (Throwable e2) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", bi.i(e2));
            toByteArray2 = null;
        }
        if (bi.by(toByteArray2)) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            return null;
        }
        return new byte[][]{toByteArray, toByteArray2};
    }

    public final byte[] KH() {
        return this.hpl;
    }

    public final void H(byte[] bArr) {
        d dVar = this.hog;
        if (bArr == null) {
            bArr = new byte[0];
        }
        dVar.bjP = bArr;
    }

    public final byte[] CM() {
        return this.hog.bjP;
    }

    public final void eE(int i) {
        this.hog.eE(i);
    }

    public final int Cn() {
        return this.hog.vHR;
    }

    public final void hn(int i) {
        this.hog.vHS = i;
    }

    public final int getClientVersion() {
        return this.hog.vHS;
    }

    public final void jv(String str) {
        this.hog.vHT = str;
    }

    public final String KI() {
        return this.hog.vHT;
    }

    public final String KJ() {
        return this.hog.vHU;
    }

    public final void jw(String str) {
        this.hog.vHU = str;
    }

    public final void ho(int i) {
        this.hog.vHV = i;
    }

    public final int KK() {
        return this.hog.vHV;
    }

    public final byte[] KL() {
        x.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        switch (this.type) {
            case 126:
                return ((y.a) this.hog).vIE.vSZ.wRm.toByteArray();
            case 381:
                return ((com.tencent.mm.protocal.r.a) this.hog).vIu.vSZ.wRm.toByteArray();
            case 701:
                return ((i.d) this.hog).vHI.wEj.vSZ.wRm.toByteArray();
            case 702:
                return ((i.a) this.hog).vHG.vQu.vQw.wRm.toByteArray();
            default:
                if (hpk != null) {
                    byte[] a = hpk.a(this.hog, this.type);
                    if (a != null) {
                        return a;
                    }
                }
                if (this.hog.vHY != null) {
                    return this.hog.vHY;
                }
                return CM();
        }
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
                return ((y.a) this.hog).vIE.vTg;
            case 701:
                return ((i.d) this.hog).vHI.wEj.vTg;
            default:
                return "";
        }
    }

    public final String KM() {
        switch (this.type) {
            case 701:
                return ((i.d) this.hog).vHI.wEj.vTs;
            default:
                return "";
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
                return ((y.a) this.hog).vIE.kyG;
            case 701:
                return ((i.d) this.hog).vHI.wEj.kyG;
            case 702:
                return ((i.a) this.hog).username;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.hog.getCmdId();
    }

    public final boolean KN() {
        return this.hog.KN();
    }
}
