package com.tencent.mm.ui;

import com.tencent.mm.av.d;
import com.tencent.mm.f.a.in;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.a.rw;
import com.tencent.mm.j.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.r.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;

public final class x implements b {
    c<oq> xNO = new c<oq>() {
        {
            this.xmG = oq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.this.xTv = true;
            ah.K(x.this.xTw);
            ah.y(x.this.xTw);
            return false;
        }
    };
    c xNP = new c<in>() {
        {
            this.xmG = in.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.blink.b.wv().f(new Runnable() {
                public final void run() {
                    x.this.xTv = true;
                    ah.K(x.this.xTw);
                    ah.y(x.this.xTw);
                }
            });
            return true;
        }
    };
    MMFragmentActivity xOh;
    c xTt;
    c xTu;
    boolean xTv;
    Runnable xTw = new Runnable() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r12 = this;
            r6 = 0;
            r10 = 0;
            r5 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
            r1 = 0;
            r3 = 1;
            r0 = com.tencent.mm.kernel.g.Do();
            r0 = r0.CF();
            if (r0 != 0) goto L_0x001c;
        L_0x0012:
            r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
            r1 = "Account not Ready!!!";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        L_0x001b:
            return;
        L_0x001c:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            if (r0 != 0) goto L_0x002c;
        L_0x0022:
            r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
            r1 = "set tag job, but tab view is null";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            goto L_0x001b;
        L_0x002c:
            r0 = com.tencent.mm.y.as.Hp();
            if (r0 != 0) goto L_0x00a1;
        L_0x0032:
            r0 = "MicroMsg.UnreadCountHelper";
            r2 = "getFindTabUnreadCount, but mmcore not ready";
            com.tencent.mm.sdk.platformtools.x.w(r0, r2);
            r2 = r1;
        L_0x003c:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r1);
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.Ec(r2);
            if (r2 > 0) goto L_0x0063;
        L_0x004c:
            r0 = com.tencent.mm.bj.a.bYH();
            if (r0 == 0) goto L_0x0063;
        L_0x0052:
            r0 = com.tencent.mm.be.l.TF();
            r0 = r0.Tx();
            if (r0 <= 0) goto L_0x0063;
        L_0x005c:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
        L_0x0063:
            if (r2 > 0) goto L_0x0123;
        L_0x0065:
            r0 = com.tencent.mm.y.q.Gj();
            r0 = r0 & r5;
            if (r0 != 0) goto L_0x0123;
        L_0x006c:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r4 = 68384; // 0x10b20 float:9.5826E-41 double:3.3786E-319;
            r0 = r0.get(r4, r6);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.platformtools.t.d(r0);
            if (r0 == 0) goto L_0x0123;
        L_0x0082:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r4 = 68377; // 0x10b19 float:9.5817E-41 double:3.37827E-319;
            r0 = r0.get(r4, r6);
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.platformtools.t.oN(r0);
            if (r0 != 0) goto L_0x0100;
        L_0x0098:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
            goto L_0x001b;
        L_0x00a1:
            r0 = com.tencent.mm.y.q.Gc();
            r2 = com.tencent.mm.y.q.Gj();
            r2 = r2 & 64;
            if (r2 != 0) goto L_0x039e;
        L_0x00ad:
            r0 = r0 & r5;
            if (r0 != 0) goto L_0x039e;
        L_0x00b0:
            r0 = com.tencent.mm.y.k.FU();
            r0 = r0 + 0;
        L_0x00b6:
            r2 = com.tencent.mm.y.q.Gj();
            r2 = r2 & 512;
            if (r2 != 0) goto L_0x039b;
        L_0x00be:
            r2 = com.tencent.mm.bj.a.bYH();
            if (r2 != 0) goto L_0x039b;
        L_0x00c4:
            r2 = com.tencent.mm.be.l.TF();
            r2 = r2.Tx();
            r2 = r2 + 0;
        L_0x00ce:
            r4 = com.tencent.mm.y.q.Gj();
            r4 = r4 & 256;
            if (r4 != 0) goto L_0x00ea;
        L_0x00d6:
            r4 = com.tencent.mm.be.l.TG();
            if (r4 == 0) goto L_0x00e1;
        L_0x00dc:
            r4 = r4.Tx();
            r2 = r2 + r4;
        L_0x00e1:
            r4 = com.tencent.mm.pluginsdk.q.a.bYL();
            r4 = r4.bsf();
            r2 = r2 + r4;
        L_0x00ea:
            r0 = r0 + r2;
            r2 = com.tencent.mm.y.q.Gj();
            r2 = r2 & r5;
            if (r2 != 0) goto L_0x00fd;
        L_0x00f2:
            r2 = com.tencent.mm.plugin.sns.b.n.qWD;
            if (r2 == 0) goto L_0x00fd;
        L_0x00f6:
            r2 = com.tencent.mm.plugin.sns.b.n.qWD;
            r2 = r2.Tx();
            r0 = r0 + r2;
        L_0x00fd:
            r2 = r0;
            goto L_0x003c;
        L_0x0100:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r4 = 589825; // 0x90001 float:8.26521E-40 double:2.914123E-318;
            r5 = java.lang.Boolean.valueOf(r1);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x0123;
        L_0x011a:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
            goto L_0x001b;
        L_0x0123:
            if (r2 > 0) goto L_0x01d8;
        L_0x0125:
            r4 = com.tencent.mm.y.q.Gd();
            r6 = 4194304; // 0x400000 float:5.877472E-39 double:2.0722615E-317;
            r4 = r4 & r6;
            r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x01cc;
        L_0x0131:
            r0 = r3;
        L_0x0132:
            r4 = com.tencent.mm.j.g.Af();
            r5 = "JDEntranceConfigName";
            r4 = r4.getValue(r5);
            r5 = com.tencent.mm.j.g.Af();
            r6 = "JDEntranceConfigIconUrl";
            r5 = r5.getValue(r6);
            r6 = com.tencent.mm.j.g.Af();
            r7 = "JDEntranceConfigJumpUrl";
            r6 = r6.getValue(r7);
            r7 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
            r8 = new java.lang.StringBuilder;
            r9 = "jd tryshow configName ";
            r8.<init>(r9);
            r8 = r8.append(r4);
            r9 = " iconUrl ";
            r8 = r8.append(r9);
            r8 = r8.append(r5);
            r9 = " jumpUrl ";
            r8 = r8.append(r9);
            r8 = r8.append(r6);
            r8 = r8.toString();
            com.tencent.mm.sdk.platformtools.x.i(r7, r8);
            if (r0 != 0) goto L_0x01d8;
        L_0x0181:
            r0 = com.tencent.mm.platformtools.t.oN(r4);
            if (r0 != 0) goto L_0x01d8;
        L_0x0187:
            r0 = com.tencent.mm.platformtools.t.oN(r5);
            if (r0 != 0) goto L_0x01d8;
        L_0x018d:
            r0 = com.tencent.mm.platformtools.t.oN(r6);
            if (r0 != 0) goto L_0x01d8;
        L_0x0193:
            r0 = com.tencent.mm.pluginsdk.q.z.vjl;
            if (r0 == 0) goto L_0x01d8;
        L_0x0197:
            r4 = r0.bEA();
            r5 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
            r6 = new java.lang.StringBuilder;
            r7 = "jdshowFriend ";
            r6.<init>(r7);
            r6 = r6.append(r4);
            r6 = r6.toString();
            com.tencent.mm.sdk.platformtools.x.i(r5, r6);
            if (r4 == 0) goto L_0x01d8;
        L_0x01b3:
            r0 = r0.bEI();
            r4 = r0.agz();
            if (r4 == 0) goto L_0x01cf;
        L_0x01bd:
            r0 = r0.bEr();
            if (r0 != 0) goto L_0x01cf;
        L_0x01c3:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
            goto L_0x001b;
        L_0x01cc:
            r0 = r1;
            goto L_0x0132;
        L_0x01cf:
            r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
            r4 = "jd time is not start or jd time isExpire";
            com.tencent.mm.sdk.platformtools.x.i(r0, r4);
        L_0x01d8:
            r4 = com.tencent.mm.y.q.Gd();
            r6 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
            r4 = r4 & r6;
            r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x035b;
        L_0x01e4:
            r0 = r3;
        L_0x01e5:
            r4 = com.tencent.mm.plugin.ipcall.d.aTK();
            if (r4 == 0) goto L_0x035e;
        L_0x01eb:
            if (r0 != 0) goto L_0x023d;
        L_0x01ed:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0 = r0.cmA();
            if (r0 != 0) goto L_0x023d;
        L_0x01f7:
            if (r2 > 0) goto L_0x023d;
        L_0x01f9:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r2 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT;
            r4 = java.lang.Integer.valueOf(r1);
            r0 = r0.get(r2, r4);
            r0 = (java.lang.Integer) r0;
            r0 = r0.intValue();
            r2 = com.tencent.mm.j.g.Af();
            r4 = "WCOEntranceRedDot";
            r2 = r2.getInt(r4, r1);
            if (r0 < r2) goto L_0x0236;
        L_0x021d:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r2 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN;
            r4 = java.lang.Boolean.valueOf(r1);
            r0 = r0.get(r2, r4);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 != r3) goto L_0x023d;
        L_0x0236:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
        L_0x023d:
            r4 = com.tencent.mm.y.q.Gd();
            r6 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
            r4 = r4 & r6;
            r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x0370;
        L_0x0249:
            r0 = r3;
        L_0x024a:
            if (r0 != 0) goto L_0x02a9;
        L_0x024c:
            r0 = com.tencent.mm.bb.k.Rl();
            r2 = r0.hMR;
            if (r2 == 0) goto L_0x037f;
        L_0x0254:
            r2 = r0.hMR;
            r2 = r2.isValid();
            if (r2 == 0) goto L_0x037f;
        L_0x025c:
            r0 = r0.hMR;
            r0 = r0.hMX;
            if (r0 != r3) goto L_0x037f;
        L_0x0262:
            r0 = "discoverSearchEntry";
            r2 = com.tencent.mm.plugin.aj.a.h.Oy(r0);
            r0 = com.tencent.mm.plugin.welab.a.a.a.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r0 = (com.tencent.mm.plugin.welab.a.a.a) r0;
            r4 = "labs1de6f3";
            r0 = r0.Rh(r4);
            if (r0 == 0) goto L_0x0373;
        L_0x027a:
            r0 = com.tencent.mm.plugin.welab.a.a.a.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r0 = (com.tencent.mm.plugin.welab.a.a.a) r0;
            r2 = "labs1de6f3";
            r0 = r0.Rf(r2);
            if (r0 == 0) goto L_0x0398;
        L_0x028b:
            r0 = r3;
        L_0x028c:
            r2 = "SearchRedPointMgr";
            r4 = "search show %b";
            r5 = new java.lang.Object[r3];
            r6 = java.lang.Boolean.valueOf(r0);
            r5[r1] = r6;
            com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
            if (r0 == 0) goto L_0x037f;
        L_0x029f:
            r0 = r3;
        L_0x02a0:
            if (r0 == 0) goto L_0x02a9;
        L_0x02a2:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
        L_0x02a9:
            r0 = com.tencent.mm.bb.k.Rl();
            r2 = r0.hMS;
            if (r2 == 0) goto L_0x038e;
        L_0x02b1:
            r2 = r0.hMS;
            r2 = r2.isValid();
            if (r2 == 0) goto L_0x038e;
        L_0x02b9:
            r0 = r0.hMS;
            r0 = r0.hMX;
            if (r0 != r3) goto L_0x038e;
        L_0x02bf:
            r0 = "discoverRecommendEntry";
            r2 = com.tencent.mm.plugin.aj.a.h.Oy(r0);
            r0 = com.tencent.mm.plugin.welab.a.a.a.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r0 = (com.tencent.mm.plugin.welab.a.a.a) r0;
            r4 = "labs_browse";
            r0 = r0.Rh(r4);
            if (r0 == 0) goto L_0x0382;
        L_0x02d7:
            r0 = com.tencent.mm.plugin.welab.a.a.a.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r0 = (com.tencent.mm.plugin.welab.a.a.a) r0;
            r2 = "labs_browse";
            r0 = r0.Rf(r2);
            if (r0 == 0) goto L_0x0395;
        L_0x02e8:
            r0 = r3;
        L_0x02e9:
            r2 = "SearchRedPointMgr";
            r4 = "recommend show %b";
            r5 = new java.lang.Object[r3];
            r6 = java.lang.Boolean.valueOf(r0);
            r5[r1] = r6;
            com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
            if (r0 == 0) goto L_0x038e;
        L_0x02fc:
            r0 = r3;
        L_0x02fd:
            if (r0 == 0) goto L_0x0306;
        L_0x02ff:
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lT(r3);
        L_0x0306:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r2 = 40;
            r0 = r0.getInt(r2, r1);
            r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
            r0 = r0 & r2;
            if (r0 != 0) goto L_0x0393;
        L_0x0318:
            r2 = r3;
        L_0x0319:
            r0 = com.tencent.mm.j.g.Af();
            r4 = "VoiceprintEntry";
            r0 = r0.getValue(r4);
            r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r1);
            if (r0 != r3) goto L_0x0391;
        L_0x032a:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r4 = com.tencent.mm.storage.w.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r3);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
        L_0x0341:
            if (r0 == 0) goto L_0x0355;
        L_0x0343:
            if (r2 == 0) goto L_0x0355;
        L_0x0345:
            r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
            r2 = "show voiceprint dot";
            com.tencent.mm.sdk.platformtools.x.i(r0, r2);
            r0 = com.tencent.mm.ui.x.this;
            r0 = r0.xTu;
            r0.lU(r3);
        L_0x0355:
            r0 = com.tencent.mm.ui.x.this;
            r0.xTv = r1;
            goto L_0x001b;
        L_0x035b:
            r0 = r1;
            goto L_0x01e5;
        L_0x035e:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r2 = com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN;
            r4 = java.lang.Boolean.valueOf(r1);
            r0.a(r2, r4);
            goto L_0x023d;
        L_0x0370:
            r0 = r1;
            goto L_0x024a;
        L_0x0373:
            r0 = "entrySwitch";
            r0 = r2.optInt(r0);
            if (r0 != r3) goto L_0x0398;
        L_0x037c:
            r0 = r3;
            goto L_0x028c;
        L_0x037f:
            r0 = r1;
            goto L_0x02a0;
        L_0x0382:
            r0 = "entrySwitch";
            r0 = r2.optInt(r0);
            if (r0 != r3) goto L_0x0395;
        L_0x038b:
            r0 = r3;
            goto L_0x02e9;
        L_0x038e:
            r0 = r1;
            goto L_0x02fd;
        L_0x0391:
            r0 = r1;
            goto L_0x0341;
        L_0x0393:
            r2 = r1;
            goto L_0x0319;
        L_0x0395:
            r0 = r1;
            goto L_0x02e9;
        L_0x0398:
            r0 = r1;
            goto L_0x028c;
        L_0x039b:
            r2 = r1;
            goto L_0x00ce;
        L_0x039e:
            r0 = r1;
            goto L_0x00b6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.x.1.run():void");
        }

        public final String toString() {
            return super.toString() + "|setTagRunnable";
        }
    };
    a xTx = new a() {
        public final void gf(int i) {
            if (i == 262145 || i == 262156 || i == 262152 || i == 266260 || i == 266267) {
                x.b(x.this);
            }
            if (i == 262147 || i == 262149) {
                x.b(x.this);
            }
        }

        public final void gg(int i) {
            if (i == 266241) {
                x.b(x.this);
            }
            if (i == 266244) {
                com.tencent.mm.r.c.Bx().aS(262147, 266241);
                com.tencent.mm.r.c.Bx().aS(262149, 266241);
                x.b(x.this);
            }
        }

        public final void b(w.a aVar) {
        }
    };
    b xTy = new b() {
        public final void a(int i, m mVar, Object obj) {
            int aV = t.aV(obj);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(aV), mVar);
            as.Hm();
            if (mVar != com.tencent.mm.y.c.Db() || aV <= 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(aV), mVar);
                return;
            }
            x.this.coa();
            if (aV == 143618) {
                ah.y(new Runnable() {
                    public final void run() {
                        int e;
                        if (as.Hp()) {
                            as.Hm();
                            e = t.e((Integer) com.tencent.mm.y.c.Db().get(143618, null));
                        } else {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
                            e = 0;
                        }
                        if (x.this.xTu != null) {
                            x.this.xTu.Eb(e);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|setAddressTagUnread";
                    }
                });
            } else if (aV == 204817 || aV == 204820) {
                x.b(x.this);
            }
        }
    };
    c xTz = new c<rw>() {
        {
            this.xmG = rw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.LauncherUI.MainTabUnreadMgr", "appTagUnreadChangeListener, event:%s", ((rw) bVar).toString());
            x.this.coa();
            return false;
        }
    };

    static /* synthetic */ void b(x xVar) {
        if (as.Hp()) {
            int parseInt;
            boolean aQ = com.tencent.mm.r.c.Bx().aQ(262156, 266241);
            boolean aR = com.tencent.mm.r.c.Bx().aR(262156, 266241);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(aQ), Boolean.valueOf(aR));
            if (aQ || aR) {
                as.Hm();
                long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
                long oO = t.oO(g.Af().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * oO;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(oO), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
                if (longValue > 0 && oO > 0 && r14 >= ((double) oO)) {
                    com.tencent.mm.r.c.Bx().o(262156, false);
                    aQ = false;
                    aR = false;
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "after check, hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(aQ), Boolean.valueOf(aR));
            boolean aQ2 = com.tencent.mm.r.c.Bx().aQ(262145, 266241);
            boolean aR2 = com.tencent.mm.r.c.Bx().aR(266260, 266241);
            boolean aQ3 = com.tencent.mm.r.c.Bx().aQ(262147, 266241);
            boolean aQ4 = com.tencent.mm.r.c.Bx().aQ(262149, 266241);
            boolean aR3 = com.tencent.mm.r.c.Bx().aR(262152, 266256);
            boolean aQ5 = com.tencent.mm.r.c.Bx().aQ(262152, 266256);
            boolean a = com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
            com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.c.class);
            Object obj = cVar != null ? (cVar.bWm() || cVar.bWn()) ? 1 : null : null;
            com.tencent.mm.r.a Bx = com.tencent.mm.r.c.Bx();
            if (Bx.initialized) {
                com.tencent.mm.r.b.a x = Bx.gNf.x(262152, 266256, 4);
                parseInt = x == null ? 0 : com.tencent.mm.r.a.parseInt(x.value);
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
                parseInt = 0;
            }
            q.c cVar2 = q.a.vjb;
            Object obj2 = (cVar2 == null || !(cVar2.auQ() || cVar2.auR())) ? null : 1;
            Object obj3 = (obj2 == null || !(aR3 || aQ5 || parseInt > 0)) ? null : 1;
            if (aR || aQ || aQ2 || obj3 != null || aQ3 || aQ4 || aR2 || obj != null || a) {
                xVar.xTu.lU(true);
            } else {
                xVar.xTu.lU(false);
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            objArr[1] = Integer.valueOf(aR ? 1 : 0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            gVar.h(14872, objArr);
            ay DK = com.tencent.mm.plugin.x.a.bfT().DK(com.tencent.mm.av.b.hJR);
            if (DK != null && !DK.field_isExit) {
                com.tencent.mm.plugin.x.a.bfS().hKe = new d.a() {
                    public final void c(ay ayVar) {
                        if (ayVar != null && ayVar.field_tipId == com.tencent.mm.av.b.hJR && com.tencent.mm.plugin.x.a.bfU().ij(com.tencent.mm.av.b.hJR)) {
                            x.this.xTu.lU(true);
                        }
                    }
                };
                return;
            } else if (com.tencent.mm.plugin.x.a.bfU().ij(com.tencent.mm.av.b.hJR)) {
                xVar.xTu.lU(true);
                return;
            } else {
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "want update more menu new tips, but mmcore not ready");
    }

    protected final void coc() {
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                x.this.xTv = true;
                ah.K(x.this.xTw);
                ah.y(x.this.xTw);
            }
        });
    }

    protected final void coa() {
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                x.this.xTv = true;
                ah.K(x.this.xTw);
                ah.h(x.this.xTw, 300);
            }
        });
    }

    protected final void cnY() {
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                if (x.this.xTv) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
                    ah.K(x.this.xTw);
                }
            }
        });
    }

    protected final void cnZ() {
        if (this.xTv) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
            coc();
        }
    }

    public final void Er(int i) {
        if (this.xTu != null) {
            this.xTu.Ea(i);
            this.xTt.cnq();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        as.Hm();
        if (mVar == com.tencent.mm.y.c.Fk()) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", Integer.valueOf(i), obj);
            if (com.tencent.mm.storage.x.gB((String) obj)) {
                coa();
            }
        }
    }

    public final void Es(int i) {
        if (this.xTu != null) {
            this.xTu.pn(i);
        }
    }
}
