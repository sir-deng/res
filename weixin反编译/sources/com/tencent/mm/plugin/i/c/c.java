package com.tencent.mm.plugin.i.c;

import android.database.Cursor;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;

public final class c implements Runnable {
    private int asN;
    public boolean isStop;
    private String kNM;
    private long kNN;
    private a kNO;

    public interface a {
        void finish();
    }

    public c(String str, long j, int i, a aVar) {
        this.kNM = str;
        this.kNN = j;
        this.asN = i;
        this.kNO = aVar;
        x.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", Integer.valueOf(hashCode()), Long.valueOf(this.kNN), Integer.valueOf(this.asN));
    }

    public final void run() {
        int i = 0;
        if (!this.isStop) {
            long Wz = bi.Wz();
            Cursor cursor = null;
            try {
                as.Hm();
                cursor = com.tencent.mm.y.c.Fh().d(this.kNM, this.kNN, this.asN);
                Wz = bi.bB(Wz);
                b.atn();
                b.p(this.asN, Wz);
                while (cursor.moveToNext()) {
                    i++;
                    cg auVar = new au();
                    auVar.b(cursor);
                    b.atn().H(auVar);
                    b.atn().bP(auVar.field_msgId);
                    if (this.isStop) {
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                x.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.asN));
                if (i < this.asN) {
                    b atn = b.atn();
                    b.atn();
                    atn.bP(b.atp());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ScanMsgTask", e, "", new Object[0]);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (this.kNO != null) {
                this.kNO.finish();
            }
        }
    }
}
