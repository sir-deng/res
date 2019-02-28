package oicq.wlogin_sdk.request;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int AFv = 0;
    protected int AFA = 0;
    byte AFB;
    protected i AFC;
    int AFn = Downloads.RECV_BUFFER_SIZE;
    int AFo = 0;
    int AFp = 27;
    int AFq = 0;
    public int AFr = 15;
    protected int AFs = 0;
    protected byte[] AFt = new byte[this.AFn];
    protected int AFu = 8001;
    protected int AFw = 0;
    protected int AFx = 0;
    protected int AFy = 0;
    protected int AFz = 0;

    public final void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr) {
        int length = bArr.length;
        int i8 = AFv + 1;
        AFv = i8;
        this.AFo = 0;
        util.z(this.AFt, this.AFo, 2);
        this.AFo++;
        util.A(this.AFt, this.AFo, (this.AFp + 2) + length);
        this.AFo += 2;
        util.A(this.AFt, this.AFo, i);
        this.AFo += 2;
        util.A(this.AFt, this.AFo, i2);
        this.AFo += 2;
        util.A(this.AFt, this.AFo, i8);
        this.AFo += 2;
        util.B(this.AFt, this.AFo, (int) j);
        this.AFo += 4;
        util.z(this.AFt, this.AFo, 3);
        this.AFo++;
        util.z(this.AFt, this.AFo, 0);
        this.AFo++;
        util.z(this.AFt, this.AFo, i4);
        this.AFo++;
        util.B(this.AFt, this.AFo, i5);
        this.AFo += 4;
        util.B(this.AFt, this.AFo, i6);
        this.AFo += 4;
        util.B(this.AFt, this.AFo, i7);
        this.AFo += 4;
        if ((this.AFo + length) + 1 > this.AFn) {
            this.AFn = ((this.AFo + length) + 1) + FileUtils.S_IWUSR;
            Object obj = new byte[this.AFn];
            System.arraycopy(this.AFt, 0, obj, 0, this.AFo);
            this.AFt = obj;
        }
        System.arraycopy(bArr, 0, this.AFt, this.AFo, length);
        this.AFo = length + this.AFo;
        util.z(this.AFt, this.AFo, 3);
        this.AFo++;
    }

    public final int T(byte[] bArr, int i) {
        int i2 = 0;
        if (i <= this.AFr + 2) {
            return -1009;
        }
        this.AFs = (i - this.AFr) - 2;
        if (i > this.AFn) {
            this.AFn = i + FileUtils.S_IWUSR;
            this.AFt = new byte[this.AFn];
        }
        this.AFo = i;
        System.arraycopy(bArr, 0, this.AFt, 0, i);
        int i3 = this.AFr + 1;
        Object decrypt = oicq.wlogin_sdk.tools.d.decrypt(this.AFt, i3, this.AFs, this.AFC.AFG);
        if (decrypt == null) {
            i2 = -1002;
        } else {
            this.AFs = decrypt.length;
            if ((decrypt.length + this.AFr) + 2 > this.AFn) {
                this.AFn = (decrypt.length + this.AFr) + 2;
                Object obj = new byte[this.AFn];
                System.arraycopy(this.AFt, 0, obj, 0, this.AFo);
                this.AFt = obj;
            }
            this.AFo = 0;
            System.arraycopy(decrypt, 0, this.AFt, i3, decrypt.length);
            this.AFo = (decrypt.length + (this.AFr + 2)) + this.AFo;
        }
        if (i2 >= 0) {
            return w(this.AFt, this.AFr + 1, this.AFs);
        }
        return -1002;
    }

    public final byte[] cKF() {
        Object obj = new byte[this.AFo];
        System.arraycopy(this.AFt, 0, obj, 0, this.AFo);
        return obj;
    }

    final byte[] u(byte[] bArr, int i, int i2) {
        Object obj = new byte[(bArr.length + 4)];
        util.A(obj, 0, i);
        util.A(obj, 2, i2);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        obj = oicq.wlogin_sdk.tools.d.b(obj, obj.length, this.AFC.AFG);
        Object obj2 = new byte[(obj.length + this.AFC.AFG.length)];
        System.arraycopy(this.AFC.AFG, 0, obj2, 0, this.AFC.AFG.length);
        System.arraycopy(obj, 0, obj2, this.AFC.AFG.length, obj.length);
        return obj2;
    }

    public final int U(byte[] bArr, int i) {
        this.AFB = bArr[i];
        return bArr[i] & 255;
    }

    public final void v(byte[] bArr, int i, int i2) {
        a aiVar = new ai();
        if (aiVar.y(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.AFC.AGc;
            Object obj = new byte[aiVar.AGR];
            System.arraycopy(aiVar.AFt, aiVar.AGi + 6, obj, 0, aiVar.AGR);
            errMsg.title = new String(obj);
            errMsg = this.AFC.AGc;
            obj = new byte[aiVar.AGS];
            System.arraycopy(aiVar.AFt, (aiVar.AGi + 8) + aiVar.AGR, obj, 0, aiVar.AGS);
            errMsg.message = new String(obj);
            errMsg = this.AFC.AGc;
            obj = new byte[aiVar.AGT];
            System.arraycopy(aiVar.AFt, ((aiVar.AGi + 12) + aiVar.AGR) + aiVar.AGS, obj, 0, aiVar.AGT);
            errMsg.AHa = new String(obj);
            return;
        }
        this.AFC.AGc.cKM();
    }

    public final void cKG() {
        this.AFC.AGc.cKM();
    }

    public final byte[] bW(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.AFC.AFE.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.AFC.AFE, 0, bArr2, bArr.length, this.AFC.AFE.length);
        return bArr2;
    }

    public final byte[] bX(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        Object obj = new byte[length];
        System.arraycopy(bArr2, 0, obj, 0, length);
        this.AFC.AFE = new byte[16];
        System.arraycopy(bArr2, length, this.AFC.AFE, 0, 16);
        return obj;
    }

    private int a(s sVar) {
        long j = 4294967295L;
        a oVar = new o();
        a pVar = new p();
        a lVar = new l();
        a qVar = new q();
        a eVar = new e();
        a tVar = new t();
        a dVar = new oicq.wlogin_sdk.a.d();
        a mVar = new m();
        a uVar = new u();
        a wVar = new w();
        a xVar = new x();
        a jVar = new j();
        a hVar = new h();
        a nVar = new n();
        a zVar = new z();
        a vVar = new v();
        a adVar = new ad();
        a abVar = new ab();
        a afVar = new af();
        a apVar = new ap();
        a akVar = new ak();
        a alVar = new al();
        a amVar = new am();
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        a acVar = new ac();
        byte[] cKI = sVar.cKI();
        int length = cKI.length;
        oVar.y(cKI, 2, length);
        pVar.y(cKI, 2, length);
        lVar.y(cKI, 2, length);
        qVar.y(cKI, 2, length);
        int y = tVar.y(cKI, 2, length);
        if (y < 0) {
            return y;
        }
        Object obj;
        long Z;
        long j2;
        long j3;
        if (eVar.y(cKI, 2, length) >= 0) {
            bArr6 = eVar.cKI();
        }
        if (jVar.y(cKI, 2, length) >= 0) {
            util.a(this.AFC._context, jVar.cKI());
        }
        if (dVar.y(cKI, 2, length) >= 0) {
            bArr = dVar.cKI();
        }
        if (mVar.y(cKI, 2, length) >= 0) {
            bArr2 = mVar.cKI();
        }
        if (uVar.y(cKI, 2, length) >= 0) {
            bArr3 = uVar.cKI();
        }
        if (wVar.y(cKI, 2, length) >= 0) {
            bArr4 = wVar.cKI();
        }
        if (xVar.y(cKI, 2, length) >= 0) {
            bArr5 = xVar.cKI();
        }
        if (zVar.y(cKI, 2, length) >= 0) {
            bArr7 = new byte[zVar.AGH];
            System.arraycopy(zVar.AFt, zVar.AGi + 2, bArr7, 0, bArr7.length);
            bArr8 = new byte[zVar.AGI];
            System.arraycopy(zVar.AFt, ((zVar.AGi + 2) + zVar.AGH) + 2, bArr8, 0, bArr8.length);
        }
        if (alVar.y(cKI, 2, length) >= 0) {
            a hVar2 = new h();
            eVar = new n();
            dVar = new am();
            ah ahVar = new ah();
            byte[] cKI2 = alVar.cKI();
            int length2 = cKI2.length;
            if (hVar2.y(cKI2, 2, length2) < 0) {
                obj = null;
            } else if (eVar.y(cKI2, 2, length2) < 0) {
                obj = null;
            } else if (dVar.y(cKI2, 2, length2) < 0) {
                obj = null;
            } else {
                Object cKF = hVar2.cKF();
                obj = eVar.cKF();
                Object cKF2 = dVar.cKF();
                Object cd = ahVar.cd(this.AFC.AFN);
                Object obj2 = new byte[((((cKF.length + 3) + obj.length) + cKF2.length) + cd.length)];
                obj2[0] = (byte) 64;
                util.A(obj2, 1, 4);
                System.arraycopy(cKF, 0, obj2, 3, cKF.length);
                int length3 = cKF.length + 3;
                System.arraycopy(obj, 0, obj2, length3, obj.length);
                int length4 = obj.length + length3;
                System.arraycopy(cKF2, 0, obj2, length4, cKF2.length);
                System.arraycopy(cd, 0, obj2, length4 + cKF2.length, cd.length);
                obj = obj2;
            }
            if (obj == null || obj.length <= 0) {
                this.AFC.AGf = new byte[0];
            } else {
                this.AFC.AGf = (byte[]) obj.clone();
                util.gp("fast data:", util.ch(obj));
            }
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
        if (acVar.y(cKI, 2, length) >= 0) {
            bArr9[0] = acVar.cKI();
        }
        y = nVar.y(cKI, 2, length);
        if (hVar.y(cKI, 2, length) >= 0 && y >= 0) {
            this.AFC.AFE = nVar.cKI();
            this.AFC.AGd = bW(hVar.cKI());
            bArr9[1] = (byte[]) this.AFC.AGd.clone();
        }
        if (abVar.y(cKI, 2, length) >= 0) {
            obj = new byte[abVar.AGK];
            System.arraycopy(abVar.AFt, abVar.AGi + 2, obj, 0, obj.length);
            bArr9[2] = obj;
        }
        if (afVar.y(cKI, 2, length) >= 0) {
            bArr9[3] = afVar.cKI();
        }
        if (apVar.y(cKI, 2, length) >= 0) {
            bArr9[4] = apVar.cKI();
        }
        if (akVar.y(cKI, 2, length) >= 0) {
            bArr9[5] = akVar.cKI();
        }
        if (amVar.y(cKI, 2, length) >= 0) {
            bArr9[6] = amVar.cKI();
        }
        if (vVar.y(cKI, 2, length) >= 0) {
            if (this.AFC.AFL == -1) {
                Z = (long) util.Z(vVar.AFt, vVar.AGi);
            } else {
                Z = this.AFC.AFL;
            }
            j = 4294967295L & ((long) util.Z(vVar.AFt, vVar.AGi + 4));
            j2 = Z;
        } else {
            j2 = 3600;
        }
        if (adVar.y(cKI, 2, length) < 0 || adVar.cKL() == 0) {
            Z = 2160000;
        } else {
            Z = (long) adVar.cKL();
        }
        if (Z < j2) {
            j3 = j2;
        } else {
            j3 = Z;
        }
        i iVar = this.AFC;
        long j4 = this.AFC._uin;
        long j5 = this.AFC.AFJ;
        long cKH = i.cKH();
        j2 += i.cKH();
        j3 += i.cKH();
        Object obj3 = new byte[2];
        System.arraycopy(tVar.AFt, tVar.AGi, obj3, 0, 2);
        Object obj4 = new byte[1];
        System.arraycopy(tVar.AFt, tVar.AGi + 2, obj4, 0, 1);
        Object obj5 = new byte[1];
        System.arraycopy(tVar.AFt, (tVar.AGi + 2) + 1, obj5, 0, 1);
        Object obj6 = new byte[tVar.AGF];
        System.arraycopy(tVar.AFt, (((tVar.AGi + 2) + 1) + 1) + 1, obj6, 0, tVar.AGF);
        iVar.a(j4, j5, j, cKH, j2, j3, obj3, obj4, obj5, obj6, lVar.cKI(), oVar.cKI(), qVar.cKI(), pVar.cKI(), bArr6, bArr2, bArr, bArr3, bArr4, bArr5, bArr7, bArr8, bArr9);
        return 0;
    }

    public int w(byte[] bArr, int i, int i2) {
        Object obj;
        a fVar = new f();
        a gVar = new g();
        a sVar = new s();
        int obj2;
        if (this.AFz == 2064 && this.AFA == 9) {
            obj2 = null;
        } else if (this.AFz == 2064 && this.AFA == 10) {
            obj2 = 1;
        } else if (this.AFz == 2064 && this.AFA == 2) {
            obj2 = 2;
        } else if (this.AFz != 2064 || this.AFA != 13) {
            return -1012;
        } else {
            obj2 = 4;
        }
        if (i2 < 5) {
            return -1009;
        }
        int U = U(bArr, i + 2);
        cKG();
        int i3 = i + 5;
        switch (U) {
            case 0:
                if (obj2 != 1) {
                    U = sVar.b(bArr, i3, (this.AFo - i3) - 1, this.AFC.AFE);
                } else if (this.AFC.AFF == null) {
                    return -1006;
                } else {
                    U = sVar.b(bArr, i3, (this.AFo - i3) - 1, this.AFC.AFF);
                }
                if (U < 0) {
                    util.adi("119 can not decrypt, ret=" + U);
                    return U;
                }
                U = a(sVar);
                if (U >= 0) {
                    return 0;
                }
                util.adi("parse 119 failed, ret=" + U);
                return U;
            case 1:
                v(bArr, i3, (this.AFo - i3) - 1);
                return U;
            case 2:
                int y = fVar.y(bArr, i3, (this.AFo - i3) - 1);
                if (y >= 0) {
                    this.AFC.AFH = fVar;
                    y = gVar.y(bArr, i3, (this.AFo - i3) - 1);
                    if (y >= 0) {
                        this.AFC.AFI = gVar;
                        return U;
                    }
                }
                return y;
            default:
                v(bArr, i3, (this.AFo - i3) - 1);
                return U;
        }
    }
}
