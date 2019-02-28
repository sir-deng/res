package com.google.android.gms.signin;

import com.google.android.gms.common.api.c.d;

public final class e {
    public static final e bbc = new a().qw();
    public final String aJx;
    public final boolean bbd;
    public final boolean bbe;
    public final d bbf;

    public static final class a {
        private boolean bbg;
        private boolean bbh;
        private String bbi;
        private d bbj;

        public final e qw() {
            return new e(this.bbg, this.bbh, this.bbi, this.bbj, (byte) 0);
        }
    }

    private e(boolean z, boolean z2, String str, d dVar) {
        this.bbd = z;
        this.bbe = z2;
        this.aJx = str;
        this.bbf = dVar;
    }

    /* synthetic */ e(boolean z, boolean z2, String str, d dVar, byte b) {
        this(z, z2, str, dVar);
    }
}
