package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.tencent.mm.bm.d;
import com.tencent.mm.booter.g;
import com.tencent.mm.booter.h;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.j;
import com.tencent.mm.booter.l;
import com.tencent.mm.booter.n;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.f.a.ny;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.ao;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.ard;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ak.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.List;

public final class p extends c<lw> {
    public p() {
        this.xmG = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int e;
        long Wx;
        long c;
        if (a.hhx != null) {
            a.hhx.GX();
        }
        Object obj = (as.Hp() && !as.Cz() && (q.Gj() & 16) == 0) ? 1 : null;
        if (obj != null && h.wU()) {
            ard ard;
            as.Hm();
            t Db = com.tencent.mm.y.c.Db();
            int e2 = com.tencent.mm.platformtools.t.e((Integer) Db.get(67073, null));
            int e3 = com.tencent.mm.platformtools.t.e((Integer) Db.get(67074, null));
            int e4 = com.tencent.mm.platformtools.t.e((Integer) Db.get(67075, null));
            e = com.tencent.mm.platformtools.t.e((Integer) Db.get(67076, null));
            as.Hm();
            com.tencent.mm.plugin.messenger.foundation.a.a.c Fh = com.tencent.mm.y.c.Fh();
            int bF = Fh.bF("medianote", 1);
            int bF2 = Fh.bF("medianote", 3);
            int bF3 = Fh.bF("medianote", 34);
            int bF4 = Fh.bF("medianote", 43);
            if (bF - e2 > 0) {
                ard ard2 = new ard();
                ard2.wEM = bF - e2;
                ard2.wEN = 1;
                Db.set(67073, Integer.valueOf(bF));
            }
            if (bF2 - e3 > 0) {
                ard = new ard();
                ard.wEM = bF2 - e3;
                ard.wEN = 3;
                Db.set(67074, Integer.valueOf(bF2));
            }
            if (bF3 - e4 > 0) {
                ard = new ard();
                ard.wEM = bF3 - e4;
                ard.wEN = 34;
                Db.set(67075, Integer.valueOf(bF3));
            }
            if (bF4 - e > 0) {
                ard = new ard();
                ard.wEM = bF4 - e;
                ard.wEN = 43;
                Db.set(67076, Integer.valueOf(bF4));
            }
            as.Hm();
            com.tencent.mm.y.c.Db().set(66817, Long.valueOf(com.tencent.mm.platformtools.t.Wx()));
        }
        com.tencent.mm.bm.a.run();
        as.Hm();
        boolean d = com.tencent.mm.platformtools.t.d((Boolean) com.tencent.mm.y.c.Db().get(67841, null));
        if (!(m.NT() == m.a.SUCC || m.NT() == m.a.SUCC_UNLOAD)) {
            d = false;
        }
        if (d) {
            x.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List kW = af.OJ().kW("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + bi.oL("") + "\" )");
            x.d("MicroMsg.PostTaskUpdateCtRemark", "list " + kW.size());
            e = 0;
            while (true) {
                int i = e;
                if (i >= kW.size()) {
                    break;
                }
                String username = ((com.tencent.mm.modelfriend.b) kW.get(i)).getUsername();
                String trim = ((com.tencent.mm.modelfriend.b) kW.get(i)).Nz().trim();
                if (!(username == null || username.equals("") || trim == null || trim.equals(""))) {
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(username);
                    if (com.tencent.mm.k.a.ga(Xv.field_type) && (Xv.field_conRemark == null || Xv.field_conRemark.equals(""))) {
                        x.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        s.b(Xv, trim);
                    }
                }
                e = i + 1;
            }
            as.Hm();
            com.tencent.mm.y.c.Db().set(67841, Boolean.valueOf(false));
        }
        x.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        bp.HY().HZ();
        i.run();
        if (d.wU()) {
            d.cdQ();
        }
        n.run();
        g.run();
        if (as.Hp() && !as.Cz()) {
            if (bi.oN(com.tencent.mm.bm.c.cdP())) {
                bd.hY("ver" + com.tencent.mm.protocal.d.vHl);
            } else {
                as.Hm();
                if (bi.bz(bi.a((Long) com.tencent.mm.y.c.Db().get(77833, null), 0)) * 1000 >= 604800000) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(10719, com.tencent.mm.bm.c.cdL(), com.tencent.mm.bm.c.cdM(), com.tencent.mm.bm.c.cdN(), com.tencent.mm.bm.c.getRomInfo(), com.tencent.mm.bm.c.cdO(), "", com.tencent.mm.bm.c.cdP());
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(77833, Long.valueOf(bi.Wx()));
                    x.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (as.Hp() && !as.Cz()) {
            Wx = bi.Wx();
            as.Hm();
            if (bi.a((Long) com.tencent.mm.y.c.Db().get(331777, null), 0) < Wx) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(331777, Long.valueOf(Wx + 259200));
                com.tencent.mm.plugin.report.b.d.boK();
            }
            com.tencent.mm.plugin.report.b.d.n(3, 0, "");
        }
        com.tencent.mm.bm.b.run();
        if (as.Hp()) {
            as.Hm();
            c = bi.c((Long) com.tencent.mm.y.c.Db().get(74, null));
            if (10010 == r.ifN && r.ifO > 0) {
                c = bi.Wx() - ((long) r.ifO);
                x.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", Integer.valueOf(r.ifO), Long.valueOf(c));
                r.ifO = 0;
            }
            Wx = bi.Wx();
            x.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", Long.valueOf(Wx), Long.valueOf(c), Long.valueOf(Wx - c));
            if ((Wx - c) * 1000 >= 86400000) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(74, Long.valueOf(Wx));
                if (com.tencent.mm.modelstat.q.Tn() == null) {
                    x.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    Wx = (bi.Wy() / 86400000) - 1;
                    k iC = com.tencent.mm.modelstat.q.Tn().iC((int) Wx);
                    if (iC == null || iC.hTq != ((int) Wx)) {
                        String str = "MicroMsg.PostTaskReportDataFlow";
                        String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(iC == null ? -1 : iC.hTq);
                        objArr[1] = Long.valueOf(Wx);
                        x.e(str, str2, objArr);
                    } else if (com.tencent.mm.modelstat.q.Tl() == null) {
                        x.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        com.tencent.mm.modelstat.g.a Tc = com.tencent.mm.modelstat.q.Tl().Tc();
                        if (Tc == null) {
                            x.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            Tc = new com.tencent.mm.modelstat.g.a();
                        }
                        x.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", Long.valueOf(Wx), Integer.valueOf(iC.hTq), Integer.valueOf(iC.hTC), Integer.valueOf(iC.hTO), Integer.valueOf(iC.hTB), Integer.valueOf(iC.hTN), Integer.valueOf(iC.hTA), Integer.valueOf(iC.hTM), Integer.valueOf(iC.hTz), Integer.valueOf(iC.hTL), Integer.valueOf(Tc.hTk), Integer.valueOf(Tc.fqh), Tc.ispName, Tc.extraInfo);
                        com.tencent.mm.plugin.report.service.g.pWK.h(10900, Long.valueOf((Wx * 86400000) / 1000), Integer.valueOf(iC.hTC), Integer.valueOf(iC.hTO), Integer.valueOf(iC.hTB), Integer.valueOf(iC.hTN), Integer.valueOf(iC.hTA), Integer.valueOf(iC.hTM), Integer.valueOf(iC.hTz), Integer.valueOf(iC.hTL), Integer.valueOf(Tc.hTk), Integer.valueOf(Tc.fqh), Tc.ispName, Tc.extraInfo);
                    }
                }
            }
        } else {
            x.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        }
        ao.run();
        as.Hm();
        if ((com.tencent.mm.platformtools.t.bA(com.tencent.mm.platformtools.t.c((Long) com.tencent.mm.y.c.Db().get(282881, null))) > 172800000 ? 1 : null) != null) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(282881, Long.valueOf(com.tencent.mm.platformtools.t.Wy()));
            com.tencent.mm.sdk.b.a.xmy.m(new ny());
        }
        if (as.Hp() && !as.Cz()) {
            Wx = bi.Wx();
            as.Hm();
            if (bi.a((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, null), 0) < Wx) {
                c = 604800 + Wx;
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, Long.valueOf(c));
                obj = q.FY();
                if (!TextUtils.isEmpty(obj)) {
                    as.CN().a(new com.tencent.mm.modelsimple.r(obj), 0);
                }
            }
        }
        if (as.Hp() && !as.Cz()) {
            Wx = bi.Wx();
            as.Hm();
            if (bi.a((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, null), 0) < Wx) {
                c = (bi.chg() / 1000) + 86400;
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, Long.valueOf(c));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11921, Integer.valueOf(1));
                    } else if (defaultAdapter.getState() == 10) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11921, Integer.valueOf(0));
                    }
                }
            }
        }
        com.tencent.mm.booter.k.run();
        l.run();
        com.tencent.mm.booter.m.run();
        j.run();
        return false;
    }
}
