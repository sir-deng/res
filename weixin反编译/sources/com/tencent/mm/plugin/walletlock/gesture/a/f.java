package com.tencent.mm.plugin.walletlock.gesture.a;

import java.lang.reflect.Array;

public final class f {
    private static f[][] tmw = ((f[][]) Array.newInstance(f.class, new int[]{3, 3}));
    public int tmu = 0;
    public int tmv = 0;

    static {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                tmw[i][i2] = new f(i, i2);
            }
        }
    }

    private f(int i, int i2) {
        this.tmu = i;
        this.tmv = i2;
    }

    public static synchronized f ef(int i, int i2) {
        f fVar;
        synchronized (f.class) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row id should be in range [0..2]");
            } else if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("col id should be in range [0..2]");
            } else {
                fVar = tmw[i][i2];
            }
        }
        return fVar;
    }

    public final String toString() {
        return String.format("{row: %d, col: %d}", new Object[]{Integer.valueOf(this.tmu), Integer.valueOf(this.tmv)});
    }
}
