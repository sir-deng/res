package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    static int index = 0;
    private a kty;
    int[] kuX = new int[]{1000, 1000, 1000, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, 5000, 9000, 13000, 26000, 26000, 26000};
    int kuY = 0;
    boolean kuZ = false;
    al kva = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (g.this.kuZ) {
                x.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", Integer.valueOf(g.index));
                g.this.kuY = 0;
            } else {
                x.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", Integer.valueOf(g.index));
                if (g.index < g.this.kuX.length) {
                    g.this.kty.aqg();
                    g.this.kva.K((long) g.this.kuX[g.index], (long) g.this.kuX[g.index]);
                    g.JU();
                } else {
                    g.this.kuZ = true;
                    g.this.kuY = 0;
                    g.this.kty.aqh();
                }
            }
            return false;
        }
    }, false);

    public interface a {
        void aqg();

        void aqh();
    }

    static /* synthetic */ int JU() {
        int i = index;
        index = i + 1;
        return i;
    }

    public g(a aVar) {
        this.kty = aVar;
    }
}
