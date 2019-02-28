package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.report.service.g;

public final class m {
    public static void tn(int i) {
        g.pWK.a(440, 165, 1, false);
        if (i == 1) {
            g.pWK.a(440, 166, 1, false);
        } else if (i == 2) {
            g.pWK.a(440, 167, 1, false);
        } else if (i == 3) {
            g.pWK.a(440, 168, 1, false);
        }
    }

    public static void to(int i) {
        g.pWK.a(440, 169, 1, false);
        if (i == 1) {
            g.pWK.a(440, 170, 1, false);
        } else if (i == 2) {
            g.pWK.a(440, 171, 1, false);
        } else if (i == 3) {
            g.pWK.a(440, 172, 1, false);
        }
    }

    public static void B(int i, long j) {
        if (i == 1) {
            g.pWK.a(440, 150, 1, false);
            g.pWK.a(440, 151, j, false);
        } else if (i == 2) {
            g.pWK.a(440, 155, 1, false);
            g.pWK.a(440, 156, j, false);
        } else if (i == 3) {
            g.pWK.a(440, 159, 1, false);
            g.pWK.a(440, 160, j, false);
        }
    }
}
