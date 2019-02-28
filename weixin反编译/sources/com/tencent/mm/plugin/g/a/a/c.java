package com.tencent.mm.plugin.g.a.a;

import java.util.Arrays;

public final class c {
    public String bpq = "";
    String kBF = null;
    public e kBG = null;
    public double kBH = 0.0d;

    public final int hashCode() {
        if (this.kBG == null) {
            return 0;
        }
        return Arrays.hashCode(this.kBG.kBK.kCl);
    }

    public final boolean equals(Object obj) {
        if (this.kBG == null || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Arrays.equals(((c) obj).kBG.kBK.kCl, this.kBG.kBK.kCl);
    }
}
