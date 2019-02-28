package com.tencent.mm.plugin.normsg.a;

import android.view.View;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public enum d implements b {
    ;
    
    private static b oXZ;

    private static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String t(boolean z, boolean z2) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final void T(int i, int i2, int i3) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }

        public final String Hl(String str) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return str;
        }

        public final String a(Object[][] objArr) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String up(int i) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String hg(boolean z) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String bgn() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final boolean bgo() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final boolean b(Object obj, Class cls) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final byte[] bgp() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return new byte[0];
        }

        public final boolean bB(Object obj) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final void a(View view, Class<? extends b> cls) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }

        public final void uq(int i) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }
    }

    private d(String str) {
    }

    static {
        oXZ = new a();
    }

    public static void a(b bVar) {
        if (bVar != null) {
            oXZ = bVar;
        }
    }

    public final String t(boolean z, boolean z2) {
        return oXZ.t(z, z2);
    }

    public final void T(int i, int i2, int i3) {
        oXZ.T(i, i2, i3);
    }

    public final String Hl(String str) {
        return oXZ.Hl(str);
    }

    public final String a(Object[][] objArr) {
        return oXZ.a(objArr);
    }

    public final String up(int i) {
        return oXZ.up(i);
    }

    public final String hg(boolean z) {
        return oXZ.hg(z);
    }

    public final String bgn() {
        return oXZ.bgn();
    }

    public final boolean bgo() {
        return oXZ.bgo();
    }

    public final boolean b(Object obj, Class cls) {
        return oXZ.b(obj, cls);
    }

    public final byte[] bgp() {
        return oXZ.bgp();
    }

    public final boolean bB(Object obj) {
        return oXZ.bB(obj);
    }

    public final void a(View view, Class<? extends b> cls) {
        oXZ.a(view, cls);
    }

    public final void uq(int i) {
        oXZ.uq(i);
    }
}
