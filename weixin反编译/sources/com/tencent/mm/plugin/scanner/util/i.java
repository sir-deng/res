package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class i {
    public static boolean bqt() {
        c fp = com.tencent.mm.y.c.c.IL().fp("100027");
        if (fp.isValid()) {
            Map civ = fp.civ();
            if (civ == null) {
                x.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                return false;
            } else if (civ.containsKey("showEntrance") && "1".equals(civ.get("showEntrance"))) {
                return true;
            } else {
                x.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                return false;
            }
        }
        x.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        return false;
    }
}
