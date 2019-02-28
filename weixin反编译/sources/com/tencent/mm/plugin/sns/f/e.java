package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class e {
    public static void Lt(String str) {
        x.i("MicroMsg.SnsABTestStrategy", "dump id " + str);
        c fp = com.tencent.mm.y.c.c.IL().fp(str);
        if (!fp.isValid()) {
            x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (fp.civ() != null) {
            x.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + fp.field_rawXML);
        }
    }
}
