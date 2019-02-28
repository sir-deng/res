package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.cai;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private boolean tb = true;
    private ArrayList<Integer> tpG;

    public i(ArrayList<Integer> arrayList) {
        this.tpG = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    protected final void send() {
        x.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", this.tpG);
        cai cai = new cai();
        if (this.tpG != null) {
            cai.xgL.addAll(this.tpG);
        }
        cai.xgM = this.tb;
        try {
            a.bPh();
            r.a(20004, cai.toByteArray(), false);
        } catch (IOException e) {
        }
    }
}
