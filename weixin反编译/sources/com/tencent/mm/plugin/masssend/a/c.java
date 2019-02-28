package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> osz;

    public final void aZf() {
        a aVar = null;
        boolean aZh = aZh();
        as.Hm();
        boolean booleanValue = ((Boolean) com.tencent.mm.y.c.Db().get(102408, Boolean.valueOf(false))).booleanValue();
        boolean z = (q.Gj() & 65536) == 0;
        x.d("MicroMsg.MassSendService", "hadSetTop is %B", Boolean.valueOf(booleanValue));
        if (z && !booleanValue && aZh) {
            x.d("MicroMsg.MassSendService", "set top conversation");
            as.Hm();
            if (com.tencent.mm.y.c.Fk().XF("masssendapp") == null) {
                as.Hm();
                if (com.tencent.mm.y.c.Fk().XF("masssendapp") == null) {
                    ae aeVar = new ae();
                    aeVar.setUsername("masssendapp");
                    aeVar.setContent(ad.getContext().getResources().getString(R.l.dVM));
                    aeVar.aj(bi.Wy() + 2000);
                    aeVar.eS(0);
                    aeVar.eP(0);
                    as.Hm();
                    com.tencent.mm.y.c.Fk().d(aeVar);
                }
            } else {
                String string;
                Cursor a = h.aZj().hiZ.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
                if (a != null) {
                    a aVar2;
                    if (a.moveToFirst()) {
                        aVar2 = new a();
                        aVar2.b(a);
                    } else {
                        aVar2 = null;
                    }
                    a.close();
                    aVar = aVar2;
                }
                if (aVar == null) {
                    string = ad.getContext().getResources().getString(R.l.dVM);
                } else {
                    h.aZj();
                    string = b.a(aVar);
                }
                ae aeVar2 = new ae();
                aeVar2.setUsername("masssendapp");
                aeVar2.setContent(string);
                aeVar2.aj(bi.Wy() + 2000);
                aeVar2.eS(0);
                aeVar2.eP(0);
                as.Hm();
                com.tencent.mm.y.c.Fk().a(aeVar2, "masssendapp");
            }
            g.pWK.k(10425, "");
            as.Hm();
            com.tencent.mm.y.c.Db().set(102409, Long.valueOf(bi.Wy()));
            as.Hm();
            com.tencent.mm.y.c.Db().set(102408, Boolean.valueOf(true));
        } else if (!aZh) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(102408, Boolean.valueOf(false));
        }
    }

    public static void dH(long j) {
        as.Hm();
        com.tencent.mm.y.c.Db().set(102409, Long.valueOf(j));
    }

    private static String aZg() {
        if (!as.Hp()) {
            return "";
        }
        r1 = new Object[2];
        as.Hm();
        r1[0] = com.tencent.mm.y.c.FI();
        r1[1] = w.cfV();
        x.d("MicroMsg.MassSendService", "config file path is %s", String.format("%s/masssend_%s.ini", r1));
        return String.format("%s/masssend_%s.ini", r1);
    }

    private boolean aZh() {
        if (this.osz == null) {
            String aZg = aZg();
            byte[] e = e.e(aZg, 0, -1);
            if (e == null) {
                return false;
            }
            try {
                this.osz = ((e) new e().aH(e)).osA;
            } catch (Exception e2) {
                b.deleteFile(aZg);
                return false;
            }
        }
        if (this.osz == null) {
            x.w("MicroMsg.MassSendService", "info list is empty");
            return false;
        }
        x.i("MicroMsg.MassSendService", "info list[%s]", this.osz.toString());
        long Wx = bi.Wx();
        Iterator it = this.osz.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (((long) dVar.fdc) <= Wx && Wx <= ((long) dVar.end)) {
                return true;
            }
        }
        return false;
    }

    public final void EL(String str) {
        if (!bi.oN(str)) {
            Map y = bj.y(str, "Festivals");
            if (y != null) {
                e eVar = new e();
                int i = 0;
                while (true) {
                    String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
                    if (!y.containsKey(str2)) {
                        break;
                    }
                    d dVar = new d();
                    dVar.fdc = bi.Wf((String) y.get(str2 + ".StartTime"));
                    dVar.end = bi.Wf((String) y.get(str2 + ".EndTime")) + Downloads.MAX_RETYR_AFTER;
                    eVar.osA.add(dVar);
                    i++;
                }
                eVar.count = eVar.osA.size();
                this.osz = eVar.osA;
                try {
                    byte[] toByteArray = eVar.toByteArray();
                    String aZg = aZg();
                    if (bi.oN(aZg)) {
                        x.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                        return;
                    }
                    File file = new File(aZg);
                    if (file.exists()) {
                        int i2;
                        if (com.tencent.mm.a.g.i(file).equals(com.tencent.mm.a.g.s(toByteArray))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            as.Hm();
                            com.tencent.mm.y.c.Db().set(102408, Boolean.valueOf(false));
                        }
                    } else {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(102408, Boolean.valueOf(false));
                    }
                    x.d("MicroMsg.MassSendService", "save to config file : %s", eVar.toString());
                    e.b(aZg, toByteArray, toByteArray.length);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MassSendService", e, "", new Object[0]);
                }
            }
        }
    }
}
