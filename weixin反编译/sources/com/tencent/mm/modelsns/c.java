package com.tencent.mm.modelsns;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static int hQE = 0;
    public static c hQF = new c();

    public static void SF() {
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100024");
        x.i("MicroMsg.StatisticsOplogAbTest", "test " + fp.field_rawXML + " " + fp.isValid());
        if (fp.isValid()) {
            hQE = bi.Wo((String) fp.civ().get("Switch"));
            x.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + hQE);
        }
    }
}
