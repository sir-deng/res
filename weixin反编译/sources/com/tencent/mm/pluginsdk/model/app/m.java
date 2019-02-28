package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class m implements t {
    private List<String> vkK = new ArrayList();
    public Vector<String> vlg = new Vector();
    private volatile boolean vlh = false;

    public m() {
        a.aRP().a(1, (t) this);
    }

    public final void Pm(String str) {
        x.d("MicroMsg.AppSettingService", "appId = " + str);
        if (bi.oN(str)) {
            x.e("MicroMsg.AppSettingService", "add appId is null");
            return;
        }
        if (!this.vlg.contains(str)) {
            this.vlg.add(str);
        }
        aRB();
    }

    public final void cx(List<String> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.AppSettingService", "addAll list is null");
            return;
        }
        for (String str : list) {
            if (!(bi.oN(str) || this.vlg.contains(str))) {
                this.vlg.add(str);
            }
        }
        aRB();
    }

    private void aRB() {
        int i = 20;
        if (this.vlh) {
            x.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
        } else if (this.vlg.size() <= 0) {
            x.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
        } else {
            x.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.vlg.size());
            int size = this.vlg.size();
            if (size <= 20) {
                i = size;
            }
            this.vlh = true;
            this.vkK.addAll(this.vlg.subList(0, i));
            g.Dp().gRu.a(new x(1, new ae(this.vkK)), 0);
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (wVar.getType() == 1) {
            this.vlh = false;
            x.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((ae) wVar).vly.size());
            this.vlg.removeAll(this.vkK);
            this.vkK.clear();
            aRB();
        }
    }
}
