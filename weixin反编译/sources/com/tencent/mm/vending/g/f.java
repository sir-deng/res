package com.tencent.mm.vending.g;

import java.util.Stack;

final class f {
    private static f zLU;
    ThreadLocal<Stack<c>> zLV = new ThreadLocal();

    private f() {
    }

    static {
        zLU = null;
        zLU = new f();
    }

    public static f cAM() {
        return zLU;
    }
}
