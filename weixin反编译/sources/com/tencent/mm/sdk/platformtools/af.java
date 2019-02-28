package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class af {
    private static Set<String> xnP = new HashSet();

    public static boolean VI(String str) {
        if (VK(str)) {
            x.d("MicroMsg.MMEntryLock", "locked-" + str);
            return false;
        }
        x.d("MicroMsg.MMEntryLock", "lock-" + str);
        return xnP.add(str);
    }

    public static void VJ(String str) {
        xnP.remove(str);
        x.d("MicroMsg.MMEntryLock", "unlock-" + str);
    }

    public static boolean VK(String str) {
        return xnP.contains(str);
    }
}
