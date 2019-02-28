package com.tencent.mm.ad;

import android.os.Looper;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bgt;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.at;

public final class s extends a {
    ag handler;
    private q hoZ;
    g hpm;
    h hpn;

    public s(q qVar) {
        this(qVar, Looper.myLooper() == null ? new ag(Looper.getMainLooper()) : new ag());
    }

    public s(q qVar, ag agVar) {
        this.hoZ = qVar;
        this.hpm = new r(qVar.Kh(), qVar.getType());
        this.hpn = new t(qVar.Hv(), qVar.getType());
        this.handler = agVar;
    }

    public final boolean Ki() {
        return this.hoZ.Ki();
    }

    public final int Kn() {
        return this.hoZ.hashCode();
    }

    public final int Ke() {
        return this.hoZ.Ke();
    }

    public final g KO() {
        return this.hpm;
    }

    public final h KP() {
        return this.hpn;
    }

    public final int getType() {
        return this.hoZ.getType();
    }

    public final String getUri() {
        return this.hoZ.getUri();
    }

    public final void jx(String str) {
    }

    public final void a(j jVar, final int i, final int i2, final String str) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(s.this.hoZ.getType()), bi.chl());
                f fVar = (f) s.this.hoZ.Kh();
                i.g gVar = (i.g) s.this.hoZ.Hv();
                if (gVar == null) {
                    x.f("MicroMsg.RemoteReqResp", "null auth.resp");
                } else {
                    c.a.vHH.a(fVar, gVar, i, i2, str);
                }
            }
        });
    }

    public final void a(final j jVar, final int i, final int i2) {
        this.handler.post(new Runnable() {
            public final void run() {
                int i;
                int i2 = at.Ht().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? 701 : 702;
                if (i2 == 0) {
                    if (bi.oN(ad.getContext().getSharedPreferences("ticket_prefs", 4).getString("_auth_ticket", ""))) {
                        x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        d.pVE.a(148, 50, 1, true);
                        i3 = 702;
                    } else {
                        d.pVE.a(148, 49, 1, true);
                        x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", bi.Wz(r13.getString("_auth_ticket", "")));
                    }
                }
                x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vHl), Integer.valueOf(637665332), Integer.valueOf(i3));
                if (i3 == 701) {
                    d.pVE.a(148, 48, 1, true);
                }
                if ((s.this.hoZ.getType() == 702 || s.this.hoZ.getType() == 701) && ((i.g) s.this.hoZ.Hv()).vHN == 2) {
                    i = 1;
                } else {
                    i = 0;
                }
                x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(s.this.hoZ.getType()), Integer.valueOf(i3), Integer.valueOf(i));
                q aW = c.a.vHH.aW(i3, i);
                try {
                    jVar.a(aW == null ? null : new s(aW, s.this.handler), i, i2, "");
                } catch (Throwable e) {
                    x.e("MicroMsg.RemoteReqResp", "exception:%s", bi.i(e));
                }
            }
        });
    }

    public final void a(com.tencent.mm.network.d dVar, final j jVar, final int i, final int i2) {
        this.handler.post(new Runnable() {
            public final void run() {
                try {
                    jVar.a(new s(new j(), s.this.handler), i, i2, "");
                } catch (Throwable e) {
                    x.e("MicroMsg.RemoteReqResp", "exception:%s", bi.i(e));
                }
            }
        });
    }

    public final int KQ() {
        int i = -1;
        x.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                q qVar = this.hoZ;
                y.a aVar = (y.a) qVar.Kh();
                b bVar = (b) qVar.Hv();
                x.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), bi.chl());
                if (bVar.vHN != 0) {
                    x.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.vHN));
                } else {
                    bgt bgt = bVar.vIF.wIy;
                    if (bgt != null) {
                        int i2 = bgt.vQf;
                        sc scVar = bgt.vPP;
                        byte[] a = n.a(bgt.vPQ);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(scVar.vQt.wRk);
                        objArr[1] = Integer.valueOf(scVar.wgK);
                        objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
                        objArr[3] = bi.Wz(bi.bx(a));
                        x.d(str, str2, objArr);
                        byte[] a2 = n.a(scVar.vQt);
                        byte[] bArr = aVar.vHK;
                        byte[] bArr2 = null;
                        if (bi.by(a2)) {
                            x.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a2.length);
                            objArr2[1] = bi.Wz(bi.bx(a2));
                            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr2[3] = bi.Wz(bi.bx(bArr));
                            x.d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(scVar.wgK, a2, bArr, pByteArray, 0);
                            bArr2 = pByteArray.value;
                            str = "MicroMsg.MMReqRespReg2";
                            str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                            objArr[1] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr[2] = bi.Wz(bi.bx(bArr2));
                            x.i(str, str2, objArr);
                        }
                        bVar.vHM = bArr2 != null ? bArr2 : new byte[0];
                        if ((i2 & 4) != 0) {
                            x.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (bi.by(bArr2)) {
                                x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.bg(new byte[0]);
                                bVar.vHN = 2;
                            } else {
                                bArr2 = MMProtocalJni.aesDecrypt(a, bArr2);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                                objArr3[1] = bi.bx(a);
                                if (bArr2 != null) {
                                    i = bArr2.length;
                                }
                                objArr3[2] = Integer.valueOf(i);
                                objArr3[3] = bi.Wz(bi.bx(bArr2));
                                x.d(str5, str6, objArr3);
                                if (bi.by(bArr2)) {
                                    x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.bg(new byte[0]);
                                    bVar.vHN = 2;
                                } else {
                                    x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", bi.Wz(bi.bx(bArr2)));
                                    bVar.bg(bArr2);
                                    bVar.vHN = 1;
                                }
                            }
                        } else {
                            x.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.bg(a);
                            bVar.vHN = 1;
                        }
                    } else {
                        x.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.bg(new byte[0]);
                        bVar.vHN = 2;
                    }
                }
                return bVar.vHN;
            case 701:
            case 702:
                return at.b(this.hoZ);
            default:
                return -1;
        }
    }
}
