package com.tencent.mm.plugin.order.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> pfO = new HashSet();

    public b() {
        aJO();
    }

    private void aJO() {
        this.pfO.clear();
        g.Dr();
        for (String str : bi.F(((String) g.Dq().Db().get(204803, (Object) "")).split(";"))) {
            if (!(bi.oN(str) || this.pfO.contains(str))) {
                this.pfO.add(str);
            }
        }
        g.Dr();
        g.Dq().Db().set(204817, Integer.valueOf(this.pfO.size()));
        x.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.pfO.size());
    }

    public final void bjd() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.pfO.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bi.oN(str)) {
                stringBuffer.append(str + ";");
            }
        }
        g.Dr();
        g.Dq().Db().set(204803, stringBuffer.toString());
    }
}
