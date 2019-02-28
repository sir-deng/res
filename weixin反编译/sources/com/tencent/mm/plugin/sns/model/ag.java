package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag implements g {
    HashMap<String, k> rcX = new HashMap();

    static /* synthetic */ void a(ag agVar, int i) {
        if (agVar.rcX == null || agVar.rcX.size() == 0) {
            x.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            return;
        }
        Object obj;
        long dA;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (ae.Fc() != null) {
            obj = 1;
            dA = ae.Fc().dA(Thread.currentThread().getId());
        } else {
            obj = null;
            dA = 0;
        }
        x.d("MicroMsg.SnsExtCache", "writeNums " + i + " " + dA);
        LinkedList linkedList = new LinkedList();
        for (String str2 : agVar.rcX.keySet()) {
            linkedList.add(str2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (agVar.rcX.containsKey(str2) && !ae.bvO()) {
                ae.bwj().b((k) agVar.rcX.get(str2));
                agVar.rcX.remove(str2);
            }
        }
        if (obj != null) {
            ae.Fc().fT(dA);
        }
        x.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final k KP(String str) {
        return (k) this.rcX.get(str);
    }

    public final boolean bww() {
        ae.bvP().post(new Runnable() {
            public final void run() {
                if (ag.this.rcX.size() > 50) {
                    ag.a(ag.this, 10);
                }
            }
        });
        return true;
    }

    public final boolean bwx() {
        ae.bvP().post(new Runnable() {
            public final void run() {
                ag.a(ag.this, ag.this.rcX.size());
            }
        });
        return true;
    }

    public final boolean a(final k kVar) {
        if (kVar == null || bi.oN(kVar.field_userName)) {
            return false;
        }
        ae.bvP().post(new Runnable() {
            public final void run() {
                ag.this.rcX.put(kVar.field_userName, kVar);
            }
        });
        return true;
    }
}
