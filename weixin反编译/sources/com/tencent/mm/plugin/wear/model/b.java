package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.tn;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    com.tencent.mm.sdk.e.m.b mSw = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                x.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                return;
            }
            String str = (String) obj;
            if (str != null && str.equals("gh_43f2581f6fd6")) {
                if (!b.bPi() && b.this.tov) {
                    b.this.tov = false;
                } else if (b.bPi() && !b.this.tov) {
                    b.this.connect();
                }
            }
        }
    };
    boolean tov;
    c tow = new c<tn>() {
        {
            this.xmG = tn.class.getName().hashCode();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r10) {
            /*
            r9 = this;
            r8 = 2;
            r7 = 1;
            r6 = 0;
            r10 = (com.tencent.mm.f.a.tn) r10;
            r0 = r10 instanceof com.tencent.mm.f.a.tn;
            if (r0 == 0) goto L_0x0010;
        L_0x0009:
            r0 = r10.fMV;
            r0 = r0.fql;
            switch(r0) {
                case 2: goto L_0x0011;
                case 3: goto L_0x0010;
                case 4: goto L_0x0010;
                case 5: goto L_0x0062;
                case 6: goto L_0x007e;
                case 7: goto L_0x0010;
                case 8: goto L_0x0038;
                case 9: goto L_0x0032;
                default: goto L_0x0010;
            };
        L_0x0010:
            return r6;
        L_0x0011:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive register response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.fMV;
            r3 = r3.ffG;
            r2[r6] = r3;
            r3 = r10.fMV;
            r3 = r3.ftC;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
            r0 = r10.fMV;
            r0 = r0.ftC;
            if (r0 == 0) goto L_0x0010;
        L_0x0032:
            r0 = com.tencent.mm.plugin.wear.model.b.this;
            r0.connect();
            goto L_0x0010;
        L_0x0038:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive auth response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.fMV;
            r3 = r3.ffG;
            r2[r6] = r3;
            r3 = r10.fMV;
            r3 = r3.ftC;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
            r0 = com.tencent.mm.plugin.wear.model.b.this;
            r1 = r10.fMV;
            r1 = r1.ftC;
            r0.tov = r1;
            r0 = com.tencent.mm.plugin.wear.model.b.this;
            r0 = r0.tov;
            if (r0 == 0) goto L_0x0010;
        L_0x0061:
            goto L_0x0032;
        L_0x0062:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "receive send response, deviceId=%s | isSuccess=%b";
            r2 = new java.lang.Object[r8];
            r3 = r10.fMV;
            r3 = r3.ffG;
            r2[r6] = r3;
            r3 = r10.fMV;
            r3 = r3.ftC;
            r3 = java.lang.Boolean.valueOf(r3);
            r2[r7] = r3;
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
            goto L_0x0010;
        L_0x007e:
            r0 = com.tencent.mm.plugin.wear.model.a.bPh();
            r0 = r0.tok;
            r0 = r0.toC;
            r0 = r0.tps;
            if (r0 == 0) goto L_0x0096;
        L_0x008a:
            r0 = r0.xgu;
            r1 = r10.fMV;
            r1 = r1.ffG;
            r0 = r0.equals(r1);
            if (r0 != 0) goto L_0x00a1;
        L_0x0096:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "request is null or request.LocalNodeId is not same!";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            goto L_0x0010;
        L_0x00a1:
            r0 = "MicroMsg.Wear.WearBizLogic";
            r1 = "request step count deviceId=%s";
            r2 = new java.lang.Object[r7];
            r3 = r10.fMV;
            r3 = r3.ffG;
            r2[r6] = r3;
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
            r0 = com.tencent.mm.plugin.wear.model.b.this;
            r1 = r10.fMV;
            r1 = r1.ffG;
            r1 = com.tencent.mm.plugin.wear.model.b.Ol(r1);
            r2 = com.tencent.mm.plugin.wear.model.b.bPi();
            if (r1 == 0) goto L_0x00d8;
        L_0x00c2:
            r3 = r0.tov;
            if (r3 == 0) goto L_0x00d8;
        L_0x00c6:
            if (r2 == 0) goto L_0x00d8;
        L_0x00c8:
            r1 = com.tencent.mm.plugin.wear.model.a.bPh();
            r1 = r1.tor;
            r2 = new com.tencent.mm.plugin.wear.model.b$2;
            r2.<init>();
            r1.a(r2);
            goto L_0x0010;
        L_0x00d8:
            r3 = "MicroMsg.Wear.WearBizLogic";
            r4 = "isRegister=%b | isFocus=%b | isAuth=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r1 = java.lang.Boolean.valueOf(r1);
            r5[r6] = r1;
            r1 = java.lang.Boolean.valueOf(r2);
            r5[r7] = r1;
            r0 = r0.tov;
            r0 = java.lang.Boolean.valueOf(r0);
            r5[r8] = r0;
            com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
            goto L_0x0010;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.b.1.a(com.tencent.mm.sdk.b.b):boolean");
        }
    };
    al tox = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            b.a(a.bPh().tok.toC.tps);
            return true;
        }
    }, true);

    private class a extends d {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void execute() {
            as.CN().a(30, b.this);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            as.CN().a(new o(1, linkedList, linkedList2, "", ""), 0);
        }

        public final String getName() {
            return "AddContactTask";
        }
    }

    private class b extends d {
        private bzy toz;

        public b(bzy bzy) {
            this.toz = bzy;
        }

        public final void execute() {
            as.CN().a(1091, b.this);
            as.CN().a(new com.tencent.mm.plugin.wear.model.d.a(this.toz.xgu, "gh_43f2581f6fd6"), 0);
        }

        public final String getName() {
            return "RegisterDeviceTask";
        }
    }

    public b() {
        com.tencent.mm.sdk.b.a.xmy.b(this.tow);
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this.mSw);
    }

    public final void connect() {
        bzy bzy = a.bPh().tok.toC.tps;
        if (bzy == null) {
            x.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
        } else if (!bPi()) {
            as.Hm();
            x.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", Boolean.valueOf(((Boolean) com.tencent.mm.y.c.Db().get(327825, Boolean.valueOf(false))).booleanValue()));
            if (!((Boolean) com.tencent.mm.y.c.Db().get(327825, Boolean.valueOf(false))).booleanValue()) {
                if (bi.PZ()) {
                    x.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    return;
                }
                a.bPh().tor.a(new a());
                a.bPh().tor.a(new b(bzy));
            }
        } else if (!Ol(bzy.xgu)) {
            x.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", bzy.xgu);
            a.bPh().tor.a(new b(bzy));
        } else if (this.tov) {
            if (this.tox.cgx()) {
                x.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.tox.K(3600000, 3600000);
            } else {
                x.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.tox.TN();
                this.tox.K(3600000, 3600000);
            }
            a(bzy);
        } else {
            x.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", bzy.xgu);
            String str = bzy.xgu;
            String str2 = "gh_43f2581f6fd6";
            if (!this.tov && Ol(str)) {
                x.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", str, str2);
                com.tencent.mm.sdk.b.b tnVar = new tn();
                tnVar.fMV.fql = 7;
                tnVar.fMV.ffG = str;
                tnVar.fMV.fsb = str2;
                com.tencent.mm.sdk.b.a.xmy.m(tnVar);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        if (kVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            as.CN().b(1091, (e) this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) kVar;
                String str3 = aVar.ffG;
                str2 = aVar.fsb;
                com.tencent.mm.sdk.b.b tnVar = new tn();
                tnVar.fMV.fql = 1;
                tnVar.fMV.ffG = str3;
                tnVar.fMV.fsb = str2;
                com.tencent.mm.sdk.b.a.xmy.m(tnVar);
                return;
            }
            x.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        } else if (kVar instanceof o) {
            as.CN().b(30, (e) this);
            if (i == 0 && i2 == 0) {
                str2 = ((o) kVar).bZf();
                x.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", str2);
                as.Hm();
                ag Xv = com.tencent.mm.y.c.Ff().Xv("gh_43f2581f6fd6");
                if (Xv == null || bi.oN(str2)) {
                    x.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + Xv);
                } else {
                    com.tencent.mm.af.d dVar = null;
                    if (s.gG(Xv.field_username)) {
                        String oM = bi.oM(Xv.field_username);
                        dVar = f.jV(oM);
                        if (dVar != null) {
                            dVar.field_username = str2;
                        }
                        y.Ml().jO(oM);
                        Xv.di(oM);
                    }
                    Xv.setUsername(str2);
                    if (((int) Xv.gKO) == 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Ff().T(Xv);
                    }
                    if (((int) Xv.gKO) <= 0) {
                        x.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        s.p(Xv);
                        as.Hm();
                        ag Xv2 = com.tencent.mm.y.c.Ff().Xv(Xv.field_username);
                        if (dVar != null) {
                            y.Ml().d(dVar);
                        } else {
                            dVar = f.jV(Xv2.field_username);
                            if (dVar == null || dVar.Le()) {
                                x.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                com.tencent.mm.y.ak.a.hhv.Q(Xv2.field_username, "");
                                com.tencent.mm.ac.b.ja(Xv2.field_username);
                            } else if (Xv2.ciQ()) {
                                x.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", Integer.valueOf(Xv2.fXr));
                                com.tencent.mm.y.ak.a.hhv.Q(Xv2.field_username, "");
                                com.tencent.mm.ac.b.ja(Xv2.field_username);
                            }
                        }
                    }
                }
                y.Ml().e(y.Ml().jN(Xv.field_username));
                as.Hm();
                com.tencent.mm.y.c.Db().set(327825, Boolean.valueOf(true));
                connect();
                return;
            }
            x.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 4 && i2 == -24 && !bi.oN(str)) {
                Toast.makeText(ad.getContext(), str, 1).show();
            }
        }
    }

    static boolean Ol(String str) {
        com.tencent.mm.sdk.b.b tnVar = new tn();
        tnVar.fMV.fql = 3;
        tnVar.fMV.ffG = str;
        tnVar.fMV.fsb = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.xmy.m(tnVar);
        x.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", Boolean.valueOf(tnVar.fMV.ftC));
        return tnVar.fMV.ftC;
    }

    static boolean bPi() {
        as.Hm();
        return com.tencent.mm.k.a.ga(com.tencent.mm.y.c.Ff().Xv("gh_43f2581f6fd6").field_type);
    }

    public static void a(bzy bzy) {
        if (bzy != null) {
            com.tencent.mm.sdk.b.b tnVar = new tn();
            tnVar.fMV.fql = 6;
            tnVar.fMV.ffG = bzy.xgu;
            com.tencent.mm.sdk.b.a.xmy.m(tnVar);
            return;
        }
        x.i("MicroMsg.Wear.WearBizLogic", "request is null");
    }
}
