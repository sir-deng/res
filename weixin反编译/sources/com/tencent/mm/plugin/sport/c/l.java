package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class l {
    public e hpx = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof d) {
                g.CN().b(1734, l.this.hpx);
                d dVar = (d) kVar;
                if (i == 0 && i2 == 0) {
                    agr agr = dVar.rZT;
                    Collections.sort(agr.wuO, new Comparator<bnl>() {
                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((bnl) obj).cRQ - ((bnl) obj2).cRQ;
                        }
                    });
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(((long) ((bnl) agr.wuO.get(0)).cRQ) * 1000);
                    instance.set(10, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    long timeInMillis = instance.getTimeInMillis();
                    ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
                    m.F((long) dVar.rZS.wgn, (long) dVar.rZS.wgo);
                    x.i("MicroMsg.Sport.SportStepManager", "delete step item after %s", l.this.saj.format(new Date(timeInMillis)));
                    List arrayList = new ArrayList();
                    Iterator it = agr.wuO.iterator();
                    while (it.hasNext()) {
                        bnl bnl = (bnl) it.next();
                        com.tencent.mm.plugin.sport.b.e eVar = new com.tencent.mm.plugin.sport.b.e();
                        eVar.field_step = bnl.jhF;
                        eVar.field_timestamp = ((long) bnl.cRQ) * 1000;
                        eVar.field_date = l.this.saj.format(new Date(eVar.field_timestamp));
                        arrayList.add(eVar);
                    }
                    ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
                    m.cd(arrayList);
                    if (dVar.rZU != null) {
                        dVar.rZU.aFQ();
                    }
                }
            }
        }
    };
    public SimpleDateFormat saj = new SimpleDateFormat("yyyy-MM-dd");
}
