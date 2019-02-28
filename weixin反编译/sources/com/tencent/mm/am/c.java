package com.tencent.mm.am;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.a.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.protocal.c.abo;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ak.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c implements b {
    private f<String, Integer> hAh = new f(200);
    Map<String, com.tencent.mm.y.ak.b.a> hAi = new HashMap();
    Queue<abn> hAj = new LinkedList();
    Queue<a> hAk = new LinkedList();
    long hAl = 0;
    final int hAm = 500;
    final int hAn = 10000;
    al hAo = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
            c.this.Pc();
            return false;
        }
    }, false);
    final al hAp = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (c.this.hAk.isEmpty()) {
                x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
                return false;
            }
            boolean z;
            int i;
            int intValue;
            long Wy = bi.Wy();
            int i2 = c.this.hmq ? 5 : 15;
            ArrayList arrayList = new ArrayList(i2 * 2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < i2) {
                    a aVar = (a) c.this.hAk.peek();
                    if (aVar == null) {
                        x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                        z = false;
                    } else {
                        LinkedList linkedList = aVar.hAw.wrq;
                        LinkedList linkedList2 = aVar.hAw.wrr;
                        i = aVar.hAx;
                        if (linkedList.size() <= i) {
                            c.this.hAk.poll();
                            if (c.this.hAk.isEmpty()) {
                                x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", Integer.valueOf(i), Integer.valueOf(r8));
                                c.this.hAl = 0;
                                c.this.hAo.K(0, 0);
                                z = false;
                            } else {
                                x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i), Integer.valueOf(r8));
                            }
                        } else {
                            asc asc = (asc) linkedList.get(i);
                            intValue = ((Integer) linkedList2.get(i)).intValue();
                            String aD = bi.aD(n.a(asc.wfM), "");
                            String aD2 = bi.aD(asc.hxj, "");
                            arrayList.add(aD);
                            arrayList.add(aD2);
                            switch (intValue) {
                                case -477:
                                    z = d.Pe().lg(aD);
                                    boolean lg = d.Pe().lg(aD2);
                                    boolean gh = m.gh(aD);
                                    x.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", Integer.valueOf(intValue), aD, aD2, Boolean.valueOf(z), Boolean.valueOf(lg), Boolean.valueOf(gh));
                                    d.pVE.a(832, 1, 1, false);
                                    z = false;
                                    break;
                                case 0:
                                    String aD3;
                                    if (aVar.hAw.wrs != null && aVar.hAw.wrs.size() > i) {
                                        if (aD.equals(((bud) aVar.hAw.wrs.get(i)).username)) {
                                            aD3 = bi.aD(((bud) aVar.hAw.wrs.get(i)).xbN, "");
                                            x.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", aD, aD2, aD3);
                                            com.tencent.mm.plugin.subapp.b.ihO.a(asc, aD3);
                                            d.pVE.a(832, 0, 1, false);
                                            z = true;
                                            break;
                                        }
                                    }
                                    String str = "MicroMsg.GetContactService";
                                    String str2 = "get antispamticket from resp failed: list:%s idx:%d  user:%s";
                                    Object[] objArr = new Object[3];
                                    if (aVar.hAw.wrs == null) {
                                        aD3 = "null";
                                    } else {
                                        aD3 = Integer.valueOf(aVar.hAw.wrs.size());
                                    }
                                    objArr[0] = aD3;
                                    objArr[1] = Integer.valueOf(i);
                                    objArr[2] = aD;
                                    x.w(str, str2, objArr);
                                    aD3 = "";
                                    x.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", aD, aD2, aD3);
                                    com.tencent.mm.plugin.subapp.b.ihO.a(asc, aD3);
                                    d.pVE.a(832, 0, 1, false);
                                    z = true;
                                default:
                                    z = m.gh(aD);
                                    x.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", Integer.valueOf(intValue), aD, aD2, Boolean.valueOf(z));
                                    d.pVE.a(832, 2, 1, false);
                                    z = false;
                                    break;
                            }
                            final String str3 = aD;
                            final String str4 = aD2;
                            new ag(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    com.tencent.mm.y.ak.b.a aVar = (com.tencent.mm.y.ak.b.a) c.this.hAi.remove(str3);
                                    com.tencent.mm.y.ak.b.a aVar2 = bi.oN(str4) ? null : (com.tencent.mm.y.ak.b.a) c.this.hAi.remove(str4);
                                    if (aVar != null) {
                                        aVar.v(str3, z);
                                    }
                                    if (aVar2 != null && !bi.oN(str4)) {
                                        aVar2.v(str4, z);
                                    }
                                }
                            });
                            aVar.hAx++;
                        }
                        i3 = i4 + 1;
                    }
                } else {
                    z = true;
                }
            }
            i = arrayList.size();
            if (i > 0) {
                as.Hm();
                long dA = com.tencent.mm.y.c.Fc().dA(Thread.currentThread().getId());
                b Pe = d.Pe();
                for (intValue = 0; intValue < i; intValue++) {
                    Pe.lg((String) arrayList.get(intValue));
                }
                as.Hm();
                com.tencent.mm.y.c.Fc().fT(dA);
            }
            x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.hmq + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + i + " take: " + (bi.Wy() - Wy) + "ms");
            return z;
        }
    }, true);
    private long hmA = 0;
    boolean hmq = false;

    class a {
        int errCode;
        int errType;
        String foE;
        abo hAw;
        int hAx = 0;

        a() {
        }
    }

    /* renamed from: com.tencent.mm.am.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String hAr;
        final /* synthetic */ boolean hAs = false;

        AnonymousClass2(String str, boolean z) {
            this.hAr = str;
        }

        public final void run() {
            if (c.this.hAi.containsKey(this.hAr)) {
                com.tencent.mm.y.ak.b.a aVar = (com.tencent.mm.y.ak.b.a) c.this.hAi.get(this.hAr);
                if (aVar != null) {
                    aVar.v(this.hAr, this.hAs);
                }
                c.this.hAi.remove(this.hAr);
            }
        }
    }

    c() {
    }

    public final void hN(String str) {
        this.hAi.remove(str);
    }

    public final void Q(String str, String str2) {
        x.i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + bi.chl());
        if (am(str, str2)) {
            this.hAo.K(500, 500);
        }
    }

    public final void R(String str, String str2) {
        boolean z = false;
        if (!bi.oN(str)) {
            String FY = q.FY();
            String FZ = q.FZ();
            if (str.equals(FY) || str.equals(FZ)) {
                x.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + FY + " alias: " + FZ + " ret");
            } else {
                a aVar = new a();
                aVar.username = str;
                aVar.hiY = bi.oM(str2);
                aVar.hxZ = bi.e(Integer.valueOf(1));
                aVar.hAf = bi.Wy();
                z = d.Pe().a(aVar);
            }
        }
        if (z) {
            this.hAo.K(500, 500);
        }
    }

    public final void a(String str, String str2, com.tencent.mm.y.ak.b.a aVar) {
        x.i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + bi.chl());
        if (am(str, str2)) {
            this.hAi.put(str, aVar);
            this.hAo.K(0, 0);
        }
    }

    private static boolean am(String str, String str2) {
        if (bi.oN(str)) {
            return false;
        }
        String FY = q.FY();
        String FZ = q.FZ();
        if (str.equals(FY) || str.equals(FZ)) {
            x.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + FY + " alias: " + FZ + " ret");
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.hiX = bi.oM(str2);
        aVar.hAf = bi.Wy();
        return d.Pe().a(aVar);
    }

    private void Pb() {
        String[] strArr = new String[]{String.valueOf(this.hAl), "80"};
        Cursor a = d.Pe().hiZ.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr, 0);
        if (a != null) {
            x.i("MicroMsg.GetContactService", "getFromDb count:%d", Integer.valueOf(a.getCount()));
            if (a.getCount() <= 0) {
                a.close();
                return;
            }
            int a2;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            while (a.moveToNext()) {
                LinkedList linkedList5;
                a aVar = new a();
                aVar.username = a.getString(0);
                aVar.hAf = a.getLong(1);
                aVar.type = a.getInt(2);
                aVar.hAg = a.getInt(3);
                aVar.hiV = a.getInt(4);
                aVar.hxZ = a.getInt(5);
                aVar.hiX = a.getString(6);
                aVar.hiY = a.getString(7);
                String username = aVar.getUsername();
                String oM = bi.oM(aVar.HT());
                int e = bi.e(Integer.valueOf(aVar.hxZ));
                String oM2 = bi.oM(aVar.Pa());
                this.hAl = aVar.hAf;
                String str = username + "#" + oM;
                a2 = bi.a((Integer) this.hAh.get(str), 0);
                if (a2 < 3) {
                    this.hAh.l(str, Integer.valueOf(a2 + 1));
                    if (e == 1) {
                        linkedList3.add(new Pair(new bet().Vf(username), new bet().Vf(oM2)));
                        x.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", username, Integer.valueOf(e), oM2);
                    } else {
                        linkedList.add(new bet().Vf(username));
                        linkedList2.add(new bet().Vf(oM));
                        x.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", username, oM);
                    }
                } else {
                    linkedList4.add(username);
                    ah.y(new AnonymousClass2(username, false));
                }
                if (linkedList.size() >= 20 || a.isLast()) {
                    abn abn = new abn();
                    abn.vSd = linkedList;
                    abn.wri = linkedList.size();
                    abn.wrm = linkedList2;
                    abn.wrl = linkedList2.size();
                    this.hAj.add(abn);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    x.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", Integer.valueOf(this.hAj.size()), Integer.valueOf(abn.vSd.size()));
                } else {
                    linkedList5 = linkedList2;
                    linkedList2 = linkedList;
                }
                linkedList = linkedList2;
                linkedList2 = linkedList5;
            }
            a.close();
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                abn abn2 = new abn();
                LinkedList linkedList6 = new LinkedList();
                linkedList6.add(pair.first);
                abn2.vSd = linkedList6;
                abn2.wri = linkedList6.size();
                abn2.wrn = 1;
                abn2.wro = (bet) pair.second;
                this.hAj.add(abn2);
            }
            linkedList3.clear();
            a2 = 0;
            while (true) {
                int i = a2;
                if (i < linkedList4.size()) {
                    String str2 = (String) linkedList4.get(i);
                    x.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", str2, Boolean.valueOf(s.eX(str2)));
                    if (s.eX(str2)) {
                        d.Pe().lg(str2);
                    }
                    boolean gA = s.gA(str2);
                    x.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", str2, Boolean.valueOf(r1));
                    if (gA) {
                        d.Pe().lg(str2);
                        d.pVE.a(832, 3, 1, false);
                    }
                    a2 = i + 1;
                } else {
                    return;
                }
            }
        }
    }

    final synchronized void Pc() {
        if (com.tencent.mm.plugin.subapp.b.ihO.uu()) {
            x.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        } else {
            long Wy = bi.Wy();
            if (this.hmq && Wy - this.hmA > 600000) {
                x.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(Wy - this.hmA));
                this.hmq = false;
            }
            if (this.hmq) {
                x.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.hmq + " ret");
            } else {
                com.tencent.mm.bp.a aVar = (abn) this.hAj.poll();
                if (aVar == null) {
                    Pb();
                    aVar = (abn) this.hAj.poll();
                    if (aVar == null || aVar.vSd == null || aVar.vSd.size() == 0) {
                        x.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                    }
                }
                this.hmA = Wy;
                this.hmq = true;
                com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
                aVar2.hnT = aVar;
                aVar2.hnU = new abo();
                aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                aVar2.hnS = au.CTRL_BYTE;
                u.a(aVar2.Kf(), new com.tencent.mm.ad.u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                        if (kVar.getType() == au.CTRL_BYTE) {
                            c.this.hmq = false;
                            if (i == 0 && i2 == 0) {
                                if (!c.this.hAj.isEmpty() && c.this.hAo.cgx()) {
                                    c.this.hAo.K(500, 500);
                                }
                                if (bVar != null) {
                                    a aVar = new a();
                                    aVar.errType = i;
                                    aVar.errCode = i2;
                                    aVar.foE = str;
                                    aVar.hAw = (abo) bVar.hnR.hnY;
                                    c.this.hAk.add(aVar);
                                }
                                if (!c.this.hAk.isEmpty() && c.this.hAp.cgx()) {
                                    c.this.hAp.K(50, 50);
                                }
                            } else {
                                x.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                                c.this.hAo.K(10000, 10000);
                            }
                        }
                        return 0;
                    }
                }, true);
            }
        }
    }
}
