package com.tencent.mm.plugin.appbrand.q;

import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;

public final class i {
    public static <T extends a> boolean a(T t, T t2) {
        boolean z = false;
        if (t == null && t2 == null) {
            throw new IllegalArgumentException("both null!!!");
        } else if (t == null || t2 == null) {
            return z;
        } else {
            try {
                return bi.isEqual(t.toByteArray(), t2.toByteArray());
            } catch (Exception e) {
                return z;
            }
        }
    }
}
