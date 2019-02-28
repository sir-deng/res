package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class d extends a {
    private static String TAG = "MicroMsg.BackupStorageModel";
    private static d kvI;
    private b kvJ;
    private a kvK;

    public static d aqL() {
        if (kvI == null) {
            a dVar = new d();
            kvI = dVar;
            a.a(dVar);
        }
        return kvI;
    }

    public final void aoN() {
        kvI = null;
    }

    public final b aqM() {
        if (this.kvJ == null) {
            this.kvJ = new b();
        }
        return this.kvJ;
    }

    public final a aqN() {
        if (this.kvK == null) {
            this.kvK = new a();
        }
        return this.kvK;
    }

    public final void aqO() {
        x.i(TAG, "backupInitStorage");
        b aqM = aqM();
        as.Hm();
        String FJ = c.FJ();
        as.Hm();
        x.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", FJ, Integer.valueOf(c.Cn()), bi.chl());
        aqM.uin = r2;
        aqM.gRT = FJ;
        as.Hm();
        aqM.gRU = c.Fc();
        as.Hm();
        aqM.kvw = c.Db();
        as.Hm();
        aqM.kvx = c.Ff();
        as.Hm();
        aqM.kvz = c.Fk();
        as.Hm();
        aqM.kvy = c.Fh();
        as.Hm();
        aqM.kvC = c.Fn();
        aqM.kvA = o.PC();
        aqM.kvB = i.aCl().lCw;
        aqM.kvE = ((b) g.h(b.class)).Fo();
        aqM.kvD = com.tencent.mm.modelvideo.o.Ub();
        aqM.kvF = com.tencent.mm.plugin.y.a.biU();
        aqM.kvG = com.tencent.mm.plugin.y.a.biT();
        aqM.kvH = com.tencent.mm.plugin.y.a.aqK();
    }
}
