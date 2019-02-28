package com.tencent.mm.y;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ad;

public final class d {
    private com.tencent.mm.compatible.util.b flO;
    private com.tencent.mm.compatible.util.b.a hgv;
    a hgw;
    private boolean hgx = false;
    private Context tI = ad.getContext();

    public interface a {
    }

    private class b implements com.tencent.mm.compatible.util.b.a {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        public final void es(int r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            switch(r3) {
                case -3: goto L_0x003d;
                case -2: goto L_0x002d;
                case -1: goto L_0x001d;
                case 0: goto L_0x0003;
                case 1: goto L_0x000d;
                default: goto L_0x0003;
            };
        L_0x0003:
            r0 = "MicroMsg.AudioHelperTool";
            r1 = "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT";
            com.tencent.mm.sdk.platformtools.x.v(r0, r1);
        L_0x000c:
            return;
        L_0x000d:
            r0 = "MicroMsg.AudioHelperTool";
            r1 = "jacks AUDIOFOCUS_GAIN";
            com.tencent.mm.sdk.platformtools.x.v(r0, r1);
            r0 = com.tencent.mm.y.d.this;
            r0 = r0.hgw;
            if (r0 == 0) goto L_0x000c;
        L_0x001c:
            goto L_0x000c;
        L_0x001d:
            r0 = "MicroMsg.AudioHelperTool";
            r1 = "jacks AUDIOFOCUS_LOSS";
            com.tencent.mm.sdk.platformtools.x.v(r0, r1);
            r0 = com.tencent.mm.y.d.this;
            r0 = r0.hgw;
            if (r0 == 0) goto L_0x000c;
        L_0x002c:
            goto L_0x000c;
        L_0x002d:
            r0 = "MicroMsg.AudioHelperTool";
            r1 = "jacks AUDIOFOCUS_LOSS_TRANSIENT";
            com.tencent.mm.sdk.platformtools.x.v(r0, r1);
            r0 = com.tencent.mm.y.d.this;
            r0 = r0.hgw;
            if (r0 == 0) goto L_0x000c;
        L_0x003c:
            goto L_0x000c;
        L_0x003d:
            r0 = "MicroMsg.AudioHelperTool";
            r1 = "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK";
            com.tencent.mm.sdk.platformtools.x.v(r0, r1);
            r0 = com.tencent.mm.y.d.this;
            r0 = r0.hgw;
            if (r0 == 0) goto L_0x000c;
        L_0x004c:
            goto L_0x000c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.y.d.b.es(int):void");
        }
    }

    public final boolean a(a aVar) {
        this.hgw = aVar;
        com.tencent.mm.compatible.util.b.a bVar = new b();
        if (this.flO == null) {
            this.flO = new com.tencent.mm.compatible.util.b(this.tI);
        }
        if (this.hgv != bVar) {
            this.hgv = bVar;
        }
        this.flO.a(this.hgv);
        if (this.flO == null || this.hgx) {
            return false;
        }
        this.flO.requestFocus();
        this.hgx = true;
        return this.hgx;
    }

    public final boolean bz(boolean z) {
        boolean zk;
        if (this.flO != null) {
            zk = this.flO.zk();
        } else {
            zk = false;
        }
        this.hgx = false;
        if (z) {
            this.flO = null;
            this.hgv = null;
            this.hgw = null;
        }
        return zk;
    }
}
