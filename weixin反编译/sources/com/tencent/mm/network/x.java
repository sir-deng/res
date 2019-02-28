package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.o.a;

public final class x extends a {
    public final void reportKV(long j, String str, boolean z, boolean z2) {
        final boolean z3 = z;
        final long j2 = j;
        final String str2 = str;
        final boolean z4 = z2;
        g.Dt().F(new Runnable() {
            public final void run() {
                if (z3) {
                    SmcLogic.writeImportKvData(j2, str2, z4);
                } else {
                    SmcLogic.writeKvData(j2, str2, z4);
                }
            }

            public final String toString() {
                return super.toString() + "|reportKV";
            }
        });
    }
}
