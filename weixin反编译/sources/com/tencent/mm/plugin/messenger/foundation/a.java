package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.s;

public final class a implements p {
    private static final a otU = new a();

    private static final class a extends com.tencent.mm.cc.a<b> implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(x xVar, x xVar2, asc asc, byte[] bArr, boolean z) {
            final x xVar3 = xVar;
            final x xVar4 = xVar2;
            final asc asc2 = asc;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.cc.a.a<b>() {
                public final /* synthetic */ void az(Object obj) {
                    ((b) obj).a(xVar3, xVar4, asc2, bArr2, z2);
                }
            });
        }

        public final void b(x xVar, x xVar2, asc asc, byte[] bArr, boolean z) {
            final x xVar3 = xVar;
            final x xVar4 = xVar2;
            final asc asc2 = asc;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.cc.a.a<b>() {
                public final /* synthetic */ void az(Object obj) {
                    ((b) obj).b(xVar3, xVar4, asc2, bArr2, z2);
                }
            });
        }
    }

    public static com.tencent.mm.vending.b.b a(b bVar) {
        return otU.aE(bVar);
    }

    public final void a(ot otVar, byte[] bArr, boolean z, r rVar) {
        switch (otVar.wet) {
            case 2:
            case 17:
                asc asc = (asc) new asc().aH(bArr);
                String str = "";
                if (!z) {
                    bArr = null;
                }
                a(asc, str, bArr, false, z);
                return;
            case 4:
                qf qfVar = (qf) new qf().aH(bArr);
                String a = n.a(qfVar.wfM);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", a);
                ((h) g.h(h.class)).Fk().XE(a);
                s.gK(a);
                com.tencent.mm.plugin.messenger.foundation.a.s.b(4, qfVar);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.c.asc r10, java.lang.String r11, byte[] r12, boolean r13, boolean r14) {
        /*
        if (r10 != 0) goto L_0x000c;
    L_0x0002:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "unable to parse mod contact";
        com.tencent.mm.sdk.platformtools.x.f(r0, r1);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r10.wfM;
        r3 = com.tencent.mm.platformtools.n.a(r0);
        r0 = r10.wGt;
        r6 = com.tencent.mm.sdk.platformtools.bi.oM(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r0 == 0) goto L_0x0037;
    L_0x001e:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r0 == 0) goto L_0x0037;
    L_0x0024:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "processModContact user is null user:%s enuser:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r3 = 1;
        r2[r3] = r6;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
        goto L_0x000b;
    L_0x0037:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "username %s mobileHash %s mobileFullHash %s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r5 = r10.wfM;
        r2[r4] = r5;
        r4 = 1;
        r5 = r10.wGw;
        r2[r4] = r5;
        r4 = 2;
        r5 = r10.wGx;
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r1 = r0.Xv(r3);
        if (r1 == 0) goto L_0x007c;
    L_0x0064:
        r0 = r1.field_encryptUsername;
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x007c;
    L_0x006c:
        r0 = "MicroMsg.ContactSyncExtension";
        r1 = "cat's replace user with stranger  user:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
        goto L_0x000b;
    L_0x007c:
        r0 = 0;
        if (r1 == 0) goto L_0x035c;
    L_0x007f:
        r2 = r1.ciT();
        if (r2 == 0) goto L_0x035c;
    L_0x0085:
        if (r1 != 0) goto L_0x008c;
    L_0x0087:
        r1 = new com.tencent.mm.storage.x;
        r1.<init>(r3);
    L_0x008c:
        r1.setUsername(r3);
        r0 = r10.hxj;
        r1.cZ(r0);
        r0 = r10.weQ;
        r4 = r10.weR;
        r0 = r0 & r4;
        r1.setType(r0);
        if (r13 == 0) goto L_0x00ce;
    L_0x009e:
        if (r2 == 0) goto L_0x00ce;
    L_0x00a0:
        r4 = r2.gKO;
        r0 = (int) r4;
        if (r0 <= 0) goto L_0x00ce;
    L_0x00a5:
        r0 = "MicroMsg.ContactSyncExtension";
        r4 = "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r7 = 0;
        r5[r7] = r3;
        r7 = 1;
        r8 = r2.field_type;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r7] = r8;
        r7 = 2;
        r8 = r1.field_type;
        r8 = java.lang.Integer.valueOf(r8);
        r5[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.w(r0, r4, r5);
        r0 = r1.field_type;
        r4 = r2.field_type;
        r0 = r0 | r4;
        r1.setType(r0);
    L_0x00ce:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r0 != 0) goto L_0x02f5;
    L_0x00d4:
        r1.di(r6);
    L_0x00d7:
        if (r2 != 0) goto L_0x0303;
    L_0x00d9:
        r4 = 0;
    L_0x00db:
        r1.gKO = r4;
        r0 = r10.wzM;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.dc(r0);
        r0 = r10.wfA;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.dd(r0);
        r0 = r10.wfB;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.de(r0);
        r0 = r10.hxe;
        r1.eD(r0);
        r0 = r10.weW;
        r1.eG(r0);
        r0 = r10.wGn;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.db(r0);
        r0 = r10.wfa;
        r1.eH(r0);
        r0 = r10.hxi;
        r1.eI(r0);
        r0 = r10.hxn;
        r4 = r10.hxf;
        r5 = r10.hxg;
        r0 = com.tencent.mm.storage.RegionCodeDecoder.ai(r0, r4, r5);
        r1.dv(r0);
        r0 = r10.hxh;
        r1.dp(r0);
        r0 = r10.wCq;
        r1.ez(r0);
        r0 = r10.wCr;
        r1.du(r0);
        r0 = r10.vON;
        r1.setSource(r0);
        r0 = r10.wCu;
        r1.ey(r0);
        r0 = r10.wCt;
        r1.df(r0);
        r0 = r10.wCs;
        r0 = com.tencent.mm.y.s.hw(r0);
        if (r0 == 0) goto L_0x014d;
    L_0x0148:
        r0 = r10.wCs;
        r1.dt(r0);
    L_0x014d:
        r0 = r1.ciQ();
        if (r0 == 0) goto L_0x015b;
    L_0x0153:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wx();
        r0 = (int) r4;
        r1.eK(r0);
    L_0x015b:
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 != 0) goto L_0x0164;
    L_0x0161:
        r1.dD(r11);
    L_0x0164:
        r0 = r10.wFS;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.da(r0);
        r0 = r10.wFU;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.dg(r0);
        r0 = r10.wFT;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        r1.dh(r0);
        r0 = r10.wfP;
        r1.dj(r0);
        r0 = r10.vPF;
        r1.dw(r0);
        r0 = r10.wGD;
        r1.dx(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.by(r12);
        if (r0 != 0) goto L_0x0309;
    L_0x0194:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r0.w(r3, r12);
    L_0x01a3:
        r0 = r10.wGC;
        r1.eB(r0);
        r0 = r10.wGy;
        if (r0 == 0) goto L_0x01cd;
    L_0x01ac:
        r0 = r10.wGy;
        r0 = r0.vOb;
        if (r0 == 0) goto L_0x01cd;
    L_0x01b2:
        r0 = r10.wGy;
        r0 = r0.vOb;
        r0 = r0.vSL;
        r1.dy(r0);
        r0 = r10.wGy;
        r0 = r0.vOb;
        r0 = r0.vSM;
        r1.dz(r0);
        r0 = r10.wGy;
        r0 = r0.vOb;
        r0 = r0.vSN;
        r1.dA(r0);
    L_0x01cd:
        if (r2 == 0) goto L_0x01dc;
    L_0x01cf:
        r0 = r2.field_type;
        r0 = com.tencent.mm.k.a.ga(r0);
        if (r0 != 0) goto L_0x01dc;
    L_0x01d7:
        r0 = r1.field_type;
        com.tencent.mm.k.a.ga(r0);
    L_0x01dc:
        r0 = com.tencent.mm.y.s.hq(r3);
        if (r0 == 0) goto L_0x01e5;
    L_0x01e2:
        r1.Aw();
    L_0x01e5:
        r0 = r1.ciN();
        if (r0 == 0) goto L_0x01ee;
    L_0x01eb:
        r1.Az();
    L_0x01ee:
        r0 = r10.fXy;
        r1.dB(r0);
        r0 = r10.wGH;
        r1.eM(r0);
        r4 = "MicroMsg.ContactSyncExtension";
        r5 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
        r0 = 20;
        r7 = new java.lang.Object[r0];
        r0 = 0;
        r7[r0] = r3;
        r0 = 1;
        r7[r0] = r6;
        r0 = 2;
        r8 = r1.gKO;
        r3 = (int) r8;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 3;
        r3 = r1.field_nickname;
        r7[r0] = r3;
        r0 = 4;
        r3 = r1.vY();
        r7[r0] = r3;
        r0 = 5;
        r3 = r1.field_deleteFlag;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 6;
        r3 = r1.field_type;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 7;
        r3 = r10.weQ;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 8;
        r3 = r10.weR;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 9;
        r3 = r1.fXf;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 10;
        r3 = r1.fXi;
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 11;
        r3 = r10.hxn;
        r7[r0] = r3;
        r0 = 12;
        r3 = r10.hxf;
        r7[r0] = r3;
        r0 = 13;
        r3 = r10.hxg;
        r7[r0] = r3;
        r0 = 14;
        r3 = r1.getSource();
        r3 = java.lang.Integer.valueOf(r3);
        r7[r0] = r3;
        r0 = 15;
        r3 = r1.field_contactLabelIds;
        r7[r0] = r3;
        r0 = 16;
        r3 = java.lang.Boolean.valueOf(r13);
        r7[r0] = r3;
        r3 = 17;
        r0 = r10.vPF;
        if (r0 != 0) goto L_0x031a;
    L_0x0289:
        r0 = 1;
    L_0x028a:
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r3] = r0;
        r3 = 18;
        r0 = r10.vPF;
        if (r0 != 0) goto L_0x031d;
    L_0x0296:
        r0 = 0;
    L_0x0297:
        r0 = java.lang.Integer.valueOf(r0);
        r7[r3] = r0;
        r3 = 19;
        r0 = r10.vPF;
        if (r0 != 0) goto L_0x0325;
    L_0x02a3:
        r0 = "";
    L_0x02a6:
        r7[r3] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r7);
        r0 = otU;
        r3 = r10;
        r4 = r12;
        r5 = r14;
        r0.a(r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r0 != 0) goto L_0x032d;
    L_0x02b9:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r0.b(r6, r1);
    L_0x02c8:
        r0 = otU;
        r3 = r10;
        r4 = r12;
        r5 = r14;
        r0.b(r1, r2, r3, r4, r5);
        r0 = r1.field_type;
        r0 = r0 & 2048;
        if (r0 == 0) goto L_0x033d;
    L_0x02d6:
        if (r2 == 0) goto L_0x02e2;
    L_0x02d8:
        r0 = r2.field_type;
        r0 = r0 & 2048;
        r2 = r1.field_type;
        r2 = r2 & 2048;
        if (r0 == r2) goto L_0x000b;
    L_0x02e2:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Fk();
        r1 = r1.field_username;
        r0.XK(r1);
        goto L_0x000b;
    L_0x02f5:
        if (r2 == 0) goto L_0x00d7;
    L_0x02f7:
        r4 = r2.gKO;
        r0 = (int) r4;
        if (r0 <= 0) goto L_0x00d7;
    L_0x02fc:
        r0 = r2.field_encryptUsername;
        r1.di(r0);
        goto L_0x00d7;
    L_0x0303:
        r4 = r2.gKO;
        r0 = (int) r4;
        r4 = (long) r0;
        goto L_0x00db;
    L_0x0309:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r0.XA(r3);
        goto L_0x01a3;
    L_0x031a:
        r0 = 0;
        goto L_0x028a;
    L_0x031d:
        r0 = r10.vPF;
        r0 = r0.length();
        goto L_0x0297;
    L_0x0325:
        r0 = r10.vPF;
        r0 = com.tencent.mm.sdk.platformtools.bi.Wz(r0);
        goto L_0x02a6;
    L_0x032d:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r0.R(r1);
        goto L_0x02c8;
    L_0x033d:
        if (r2 == 0) goto L_0x0349;
    L_0x033f:
        r0 = r2.field_type;
        r0 = r0 & 2048;
        r2 = r1.field_type;
        r2 = r2 & 2048;
        if (r0 == r2) goto L_0x000b;
    L_0x0349:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Fk();
        r1 = r1.field_username;
        r0.XL(r1);
        goto L_0x000b;
    L_0x035c:
        r2 = r1;
        r1 = r0;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.messenger.foundation.a.a(com.tencent.mm.protocal.c.asc, java.lang.String, byte[], boolean, boolean):void");
    }
}
