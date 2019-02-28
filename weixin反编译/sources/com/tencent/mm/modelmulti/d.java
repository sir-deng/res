package com.tencent.mm.modelmulti;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;

public final class d extends k implements com.tencent.mm.network.k {
    protected static int cLs = 7;
    private int errCode;
    private int errType;
    private String foE;
    private e gLE;
    private int hGL;
    private com.tencent.mm.compatible.util.g.a hGM;
    private StringBuilder hGN;
    private long hGO;
    private boolean hGP;
    private al hmy;

    public static class a implements q {
        private final com.tencent.mm.protocal.w.a hGS;
        private final b hGT;
        private final boolean hGU;
        int uin;

        public a() {
            this.hGS = new com.tencent.mm.protocal.w.a();
            this.hGT = new b();
            this.hGU = false;
        }

        public a(b bVar) {
            this.hGS = new com.tencent.mm.protocal.w.a();
            this.hGT = bVar;
            this.hGU = true;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hGT;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        public final com.tencent.mm.protocal.k.d Kh() {
            this.hGS.vHU = com.tencent.mm.compatible.e.q.yM();
            this.hGS.vHT = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.hGS.vHS = com.tencent.mm.protocal.d.vHl;
            this.hGS.eE(this.uin);
            return this.hGS;
        }

        public final boolean Ki() {
            return false;
        }

        public final int Ke() {
            return 0;
        }
    }

    public d() {
        this.errType = 0;
        this.errCode = 0;
        this.foE = "";
        this.hGL = 0;
        this.hGN = new StringBuilder();
        this.hGO = -1;
        this.hGP = false;
        x.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", Integer.valueOf(hashCode()), bi.chl());
        this.hGM = new com.tencent.mm.compatible.util.g.a();
        this.hGN.append("stack:" + bi.chl() + " time:" + bi.Wx());
    }

    public d(final b bVar, int i, long j) {
        this();
        this.hGL = i;
        this.hGO = j;
        x.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.hmy = new al(aa.Wa(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                d.this.hGP = true;
                int i = 0;
                d.this.a(-1, 0, i, "", new a(bVar), null);
                return false;
            }
        }, false);
    }

    public final String getInfo() {
        return this.hGN.toString();
    }

    protected final int Bo() {
        return 500;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final boolean Kk() {
        return super.Kk();
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.gLE = eVar2;
        this.hGN.append(" lastd:" + this.hol + " dotime:" + bi.Wx() + " net:" + ao.getNetType(ad.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(cLs);
        if (this.hmy != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.hmy != null) {
            c(eVar);
            this.hmy.K(0, 0);
            this.hmy = null;
            return -1;
        }
        q aVar = new a();
        aVar.uin = aa.VX().iby.Cn();
        atv atv = ((com.tencent.mm.protocal.w.a) aVar.Kh()).vIC;
        atv.vYD = cLs;
        atv.vYE = n.N(bi.Wj(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", "")));
        atv.sfa = 1;
        atv.wIF = new ou();
        atv.vQr = com.tencent.mm.protocal.d.DEVICE_TYPE;
        return a(eVar, aVar, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        String str2;
        String str3;
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            str2 = "MicroMsg.NetPushSync";
            str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            x.e(str2, str3, objArr);
            return;
        }
        Object obj;
        this.hGN.append(" endtime:" + bi.Wx());
        x.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.hGP), Long.valueOf(this.hGM.zp()), this.hGN);
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] Wj;
            int size;
            int i5;
            b bVar = (b) qVar.Hv();
            if (obj == null) {
                byte[] a = n.a(((com.tencent.mm.protocal.w.a) qVar.Kh()).vIC.vYE);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = bi.bx(a);
                x.d(str4, str5, objArr2);
                if (bi.by(a)) {
                    Wj = bi.Wj(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                    x.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", Integer.valueOf(Wj.length), bi.bx(Wj));
                } else {
                    Wj = a;
                }
                a = n.a(bVar.vID.vYE);
                Wj = com.tencent.mm.protocal.ad.g(Wj, a);
                if (Wj == null || Wj.length <= 0) {
                    x.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    Wj = a;
                }
                bVar.vID.vYE = n.N(Wj);
                size = (bVar.vID.vYH == null || bVar.vID.vYH.kyB == null) ? 0 : bVar.vID.vYH.kyB.size();
                x.i("MicroMsg.NetPushSync", "newMsgSize:%d", Integer.valueOf(size));
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(Wj == null ? -1 : Wj.length);
                objArr2[2] = bi.bx(Wj);
                x.d(str4, str5, objArr2);
            }
            Iterator it = bVar.vID.vYH.kyB.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                ot otVar = (ot) it.next();
                if (otVar.wet == 5) {
                    Wj = n.a(otVar.weu);
                    try {
                        bx bxVar = new bx();
                        bxVar.aH(Wj);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(bxVar.nlX);
                        objArr3[1] = bxVar.vNM.wRo;
                        objArr3[2] = Long.valueOf(bxVar.vNT);
                        objArr3[3] = Integer.valueOf(bxVar.vNS == null ? 0 : bxVar.vNS.length());
                        objArr3[4] = Integer.valueOf(bxVar.vNO.wRo == null ? 0 : bxVar.vNO.wRo.length());
                        x.i(str3, str4, objArr3);
                        i5 = bxVar.nlX;
                        str3 = bxVar.vNM.wRo;
                        str4 = bxVar.vNO.wRo;
                        if (i5 == 50) {
                            x.i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else {
                            if (bi.oN(str4) || bi.oN(str3)) {
                                x.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
                            } else if (i5 == 9998 && str3.equalsIgnoreCase("weixin")) {
                                x.i("MicroMsg.NetPushSync", "hit ipxx");
                                obj = 1;
                            } else if (i5 == 10002 && str4.contains("revokemsg")) {
                                x.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = bxVar.vNT;
                            str5 = bxVar.vNM.wRo;
                            str2 = bxVar.vNS;
                            int i6 = bxVar.nlX;
                            if (bi.oN(str2)) {
                                x.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = bi.Wn(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map y = bj.y(str2, "pushcontent");
                                if (y == null) {
                                    x.e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) y.get(".pushcontent.$content");
                                    pString2.value = (String) y.get(".pushcontent.$nickname");
                                }
                                PluginZero pluginZero = (PluginZero) g.k(PluginZero.class);
                                if (pluginZero.vhm != null) {
                                    pluginZero.vhm.a(j, str5, pString2.value, pString.value, (com.tencent.mm.compatible.util.e.bnF + com.tencent.mm.a.g.s(("mm" + aa.VX().iby.Cn()).getBytes())) + "/avatar/", i6);
                                }
                            }
                            if ((bxVar.nlX == 10002 ? 1 : null) != null) {
                                x.i("MicroMsg.NetPushSync", "need remove pushContent");
                                bxVar.vNS = null;
                                otVar.weu = n.N(bxVar.toByteArray());
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.NetPushSync", e, "", new Object[0]);
                    }
                }
            }
            try {
                Wj = bVar.vID.toByteArray();
                size = aa.VX().iby.Cn();
                str4 = f.fk(size);
                int ej = f.ej(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + ej;
                byte[] b = com.tencent.mm.a.k.b(Wj, com.tencent.mm.a.g.s((com.tencent.mm.compatible.e.q.yL() + size).getBytes()).getBytes());
                x.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", Integer.valueOf(ej), Integer.valueOf(Wj.length), Integer.valueOf(b.length), str6, f.B(Wj), f.B(b), f.B(str3.getBytes()));
                if (bi.by(b)) {
                    x.e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i5 = com.tencent.mm.a.e.b(str6, b, b.length);
                    boolean bO = com.tencent.mm.a.e.bO(str6);
                    if (i5 == 0 && bO) {
                        Wj = String.valueOf(ej).getBytes();
                        com.tencent.mm.a.e.b(str4 + "/syncResp.ini", Wj, Wj.length);
                    } else {
                        x.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", Integer.valueOf(i5), Boolean.valueOf(bO));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", e2);
                x.printErrStackTrace("MicroMsg.NetPushSync", e2, "", new Object[0]);
            }
            x.d("MicroMsg.NetPushSync", "onRespHandled sync");
            ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bi.bA(n.a(bVar.vID.vYE))).commit();
            x.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", Integer.valueOf(this.hGL));
            if (obj2 == null) {
                obj = ((bVar.vID.vWu & cLs) == 0 || super.Kk()) ? null : 1;
                x.i("MicroMsg.NetPushSync", "continue flag=" + bVar.vID.vWu + ", selector=" + cLs + ", limit reach=" + super.Kk());
                if (obj != null) {
                    a(this.hok, this.gLE);
                    if (obj2 != null) {
                        CoreService.wJ();
                        return;
                    }
                    return;
                }
            }
            if ((this.hGL & 1) > 0) {
                x.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new h(this.hGO, n.a(bVar.vID.vYE), aa.VX().iby.Cn()).a(aa.VX(), new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        x.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        kVar.hop = true;
                    }
                });
            }
            this.gLE.a(this.errType, this.errCode, this.foE, this);
            if (obj2 != null) {
                CoreService.wJ();
                return;
            }
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
