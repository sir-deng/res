package com.tencent.d.a.c;

import junit.framework.Assert;

public final class g {
    private static volatile a Alz = new a() {
        private boolean AlA = false;

        public final void cGO() {
            c.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.AlA = true;
        }

        public final boolean cGN() {
            return this.AlA;
        }
    };

    public interface a {
        boolean cGN();

        void cGO();
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        Alz = aVar;
    }

    public static void cGM() {
        Alz.cGO();
    }

    public static boolean cGN() {
        return Alz.cGN();
    }
}
