package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public final class v {
    private static v lWb = null;
    public ah hPO = new ah();
    final HashMap<Long, Integer> lWc = new HashMap();

    private v() {
    }

    public static v aFu() {
        if (lWb == null) {
            lWb = new v();
        }
        return lWb;
    }
}
