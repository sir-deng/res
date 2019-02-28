package oicq.wlogin_sdk.request;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.AFz = 2064;
        this.AFA = 9;
        this.AFC = iVar;
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        Object bZ;
        int i4 = this.AFC.AFM;
        this.AFC._uin = j2;
        util.gp("IMEI", util.ch(this.AFC.AFN));
        byte[] bArr5 = this.AFC.AFE;
        byte[] bArr6 = this.AFC.AFN;
        byte[] cKI = this.AFC.AFH.cKI();
        byte[] bArr7 = this.AFC.AFR;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object g = bVar.g(j2, bArr);
        Object a2 = hVar.a(522017402, i4, j2, bArr2, bArr, bArr3, bArr5, this.AFC.AFZ, this.AFC.AFN);
        this.AFC.AGd = super.bW(hVar.cKI());
        Object a3 = cVar.a(522017402, 1, i4, 8256);
        Object A = iVar.A(0, 1, 102400, 1);
        Object a4 = rVar.a(i, i2, null);
        Object cd = ahVar.cd(this.AFC.AFN);
        int i5 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            obj = jVar.ca(bArr4);
            i5 = 8;
        }
        if (bArr6.length > 0) {
            bArr8 = kVar.cb(bArr6);
        }
        Object a5 = agVar.a(bArr8, yVar.a(util.cKN(), util.cKO(), this.AFC.AFQ, this.AFC.AFP, new byte[0], this.AFC.AFS), aaVar.a(this.AFC.AFY, this.AFC.AFZ, this.AFC.AGa, this.AFC.AFW, this.AFC.AFN), ajVar.a(522017402, this.AFC.AFU, this.AFC.AFV), this.AFC.AFE);
        i5++;
        Object cc = aeVar.cc(bArr7);
        int i6 = i5 + 1;
        if (cKI.length > 0) {
            bZ = fVar.bZ(cKI);
            i6++;
        } else {
            bZ = obj2;
        }
        Object obj4 = new byte[(((((((((((a.length + g.length) + a2.length) + a4.length) + a3.length) + A.length) + obj.length) + a5.length) + bZ.length) + cc.length) + 0) + cd.length)];
        System.arraycopy(a, 0, obj4, 0, a.length);
        int length = a.length + 0;
        System.arraycopy(g, 0, obj4, length, g.length);
        length += g.length;
        System.arraycopy(a2, 0, obj4, length, a2.length);
        length += a2.length;
        System.arraycopy(a4, 0, obj4, length, a4.length);
        length += a4.length;
        System.arraycopy(a3, 0, obj4, length, a3.length);
        length += a3.length;
        System.arraycopy(A, 0, obj4, length, A.length);
        length += A.length;
        System.arraycopy(obj, 0, obj4, length, obj.length);
        int length2 = obj.length + length;
        System.arraycopy(a5, 0, obj4, length2, a5.length);
        length2 += a5.length;
        System.arraycopy(cc, 0, obj4, length2, cc.length);
        length2 += cc.length;
        System.arraycopy(obj3, 0, obj4, length2, 0);
        length2 += 0;
        System.arraycopy(bZ, 0, obj4, length2, bZ.length);
        System.arraycopy(cd, 0, obj4, bZ.length + length2, cd.length);
        long j3 = j2;
        int i7 = i4;
        a(this.AFu, this.AFz, AFv, j3, this.AFw, this.AFx, i7, this.AFy, super.u(obj4, this.AFA, i6));
        return super.cKF();
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        int i4 = this.AFC.AFM;
        this.AFC._uin = j2;
        Object bX = super.bX(bArr2);
        if (bX == null) {
            return null;
        }
        Object obj;
        byte[] bArr4 = this.AFC.AFN;
        byte[] cKI = this.AFC.AFH.cKI();
        byte[] bArr5 = this.AFC.AFR;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object g = bVar.g(j2, bArr);
        this.AFC.AGd = super.bW(bX);
        int length = bX.length;
        if (hVar.AGi + length > hVar.AFn) {
            hVar.AFn = (hVar.AGi + length) + FileUtils.S_IWUSR;
            obj = new byte[hVar.AFn];
            System.arraycopy(hVar.AFt, 0, obj, 0, hVar.AGi);
            hVar.AFt = obj;
        }
        hVar.AFo = hVar.AGi + length;
        System.arraycopy(bX, 0, hVar.AFt, hVar.AGi, length);
        hVar.AGj = length;
        util.A(hVar.AFt, 0, hVar.AFz);
        util.A(hVar.AFt, 2, hVar.AGj);
        Object cKF = hVar.cKF();
        util.gp("req2 a1:", util.ch(cKF));
        Object a2 = cVar.a(522017402, 1, i4, 8256);
        Object A = iVar.A(0, 1, 102400, 1);
        Object a3 = rVar.a(i, i2, null);
        Object cd = ahVar.cd(this.AFC.AFN);
        int i5 = 7;
        Object obj2 = new byte[0];
        byte[] bArr6 = new byte[0];
        Object obj3 = new byte[0];
        Object obj4 = new byte[0];
        if (bArr3.length > 0) {
            obj2 = jVar.ca(bArr3);
            i5 = 8;
        }
        if (bArr4.length > 0) {
            bArr6 = kVar.cb(bArr4);
        }
        Object a4 = agVar.a(bArr6, yVar.a(util.cKN(), util.cKO(), this.AFC.AFQ, this.AFC.AFP, new byte[0], this.AFC.AFS), aaVar.a(this.AFC.AFY, this.AFC.AFZ, this.AFC.AGa, this.AFC.AFW, this.AFC.AFN), ajVar.a(522017402, this.AFC.AFU, this.AFC.AFV), this.AFC.AFE);
        i5++;
        Object cc = aeVar.cc(bArr5);
        int i6 = i5 + 1;
        if (cKI.length > 0) {
            obj = fVar.bZ(cKI);
            i6++;
        } else {
            obj = obj3;
        }
        Object obj5 = new byte[(((((((((((a.length + g.length) + cKF.length) + a3.length) + a2.length) + A.length) + obj2.length) + a4.length) + obj.length) + cc.length) + 0) + cd.length)];
        System.arraycopy(a, 0, obj5, 0, a.length);
        int length2 = a.length + 0;
        System.arraycopy(g, 0, obj5, length2, g.length);
        length2 += g.length;
        System.arraycopy(cKF, 0, obj5, length2, cKF.length);
        length2 += cKF.length;
        System.arraycopy(a3, 0, obj5, length2, a3.length);
        length2 += a3.length;
        System.arraycopy(a2, 0, obj5, length2, a2.length);
        length2 += a2.length;
        System.arraycopy(A, 0, obj5, length2, A.length);
        length2 += A.length;
        System.arraycopy(obj2, 0, obj5, length2, obj2.length);
        length = obj2.length + length2;
        System.arraycopy(a4, 0, obj5, length, a4.length);
        length += a4.length;
        System.arraycopy(cc, 0, obj5, length, cc.length);
        length += cc.length;
        System.arraycopy(obj4, 0, obj5, length, 0);
        length += 0;
        System.arraycopy(obj, 0, obj5, length, obj.length);
        System.arraycopy(cd, 0, obj5, length + obj.length, cd.length);
        long j3 = j2;
        int i7 = i4;
        a(this.AFu, this.AFz, AFv, j3, this.AFw, this.AFx, i7, this.AFy, super.u(obj5, this.AFA, i6));
        return super.cKF();
    }
}
