package com.tencent.mm.plugin.product.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> pjK = new ArrayList();

    public d() {
        Xc();
    }

    private void Xc() {
        this.pjK.clear();
        g.Dr();
        String str = (String) g.Dq().Db().get(270340, (Object) "");
        x.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bi.F(str2.split(";"))) {
            if (!bi.oN(str2)) {
                this.pjK.add(str2);
            }
        }
    }

    public final boolean bjN() {
        x.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.pjK.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.pjK) {
            if (!(bi.oN(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        x.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.Dr();
        g.Dq().Db().set(270340, stringBuffer.toString());
        return true;
    }
}
