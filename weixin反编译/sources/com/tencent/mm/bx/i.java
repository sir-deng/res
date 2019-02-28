package com.tencent.mm.bx;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i {
    private al fia = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (i.this.xJL.isOpen()) {
                i.this.clL();
            }
            return false;
        }
    }, false);
    h xJL;
    private BlockingQueue<a> xKf = new LinkedBlockingQueue();
    private String xrW = null;

    public static class a {
        public ContentValues values;
        public String xKh;
        public String[] xKi;
        public int xpW;
        public String xrS;
        public String xrU;

        public final void J(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                this.xKi = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.xKi[i] = new String(strArr[i]);
                }
            }
        }
    }

    public i(h hVar, String str) {
        this.xJL = hVar;
        this.xrW = str;
    }

    public final int clL() {
        x.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.xrW, Boolean.valueOf(this.xJL.inTransaction()), Integer.valueOf(this.xKf.size()));
        if (!this.xKf.isEmpty()) {
            long j;
            if (this.xJL.inTransaction()) {
                j = 0;
            } else {
                j = this.xJL.dA(Thread.currentThread().getId());
            }
            while (!this.xKf.isEmpty()) {
                a aVar = (a) this.xKf.poll();
                if (aVar == null) {
                    x.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.xrW);
                } else if (this.xJL == null || !this.xJL.isOpen()) {
                    x.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.xrW);
                } else if (aVar.xpW == 2) {
                    this.xJL.insert(this.xrW, aVar.xrS, aVar.values);
                } else if (aVar.xpW == 5) {
                    this.xJL.delete(this.xrW, aVar.xKh, aVar.xKi);
                } else if (aVar.xpW == 1) {
                    this.xJL.fD(this.xrW, aVar.xrU);
                } else if (aVar.xpW == 4) {
                    this.xJL.replace(this.xrW, aVar.xrS, aVar.values);
                } else if (aVar.xpW == 3) {
                    this.xJL.update(this.xrW, aVar.values, aVar.xKh, aVar.xKi);
                }
            }
            if (j > 0) {
                this.xJL.fT(j);
            }
        }
        return 0;
    }

    final int a(a aVar) {
        this.xKf.add(aVar);
        if (this.xKf.size() >= 40) {
            clL();
        }
        if (this.fia.cgx()) {
            this.fia.K(60000, 60000);
        }
        return 0;
    }
}
