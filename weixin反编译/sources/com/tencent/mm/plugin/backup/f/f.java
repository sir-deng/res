package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static int kuP = 10000;
    public static int kuQ = 5000;
    a krh;
    private int kuR = 0;
    private long kuS = 0;
    private long kuT = 0;
    private boolean kuU = false;
    Boolean kuV = null;

    public interface a {
        void mX(int i);
    }

    public f(a aVar) {
        this.krh = aVar;
    }

    public final void aqG() {
        this.kuS = bi.Wy();
        x.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", Long.valueOf(this.kuS));
        this.kuU = false;
        if (this.kuR != 0) {
            this.kuR = 0;
            this.krh.mX(0);
        }
    }

    public final void aqH() {
        this.kuT = this.kuT == Long.MAX_VALUE ? 0 : this.kuT + 1;
        e eVar = new e();
        eVar.kuT = this.kuT;
        try {
            x.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", Long.valueOf(eVar.kuT));
            b.G(eVar.toByteArray(), 9);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
        }
    }
}
