package com.tencent.mm.plugin.clean.c;

import android.os.Looper;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.util.ArrayList;

public final class e extends Thread implements com.tencent.mm.plugin.clean.c.a.a.a {
    private long endTime = 0;
    private ag hbP = new ag(Looper.getMainLooper());
    private boolean isStop;
    private b lkT;
    private int lkV = 0;
    private int lkW = 0;
    private h lll;
    private ArrayList<a> llm;
    private int lln = 0;
    private long startTime = 0;

    class a extends com.tencent.mm.plugin.clean.c.a.a {
        private a llp;

        public a(a aVar) {
            super(e.this);
            this.llp = aVar;
        }

        public final void execute() {
            as.Hm();
            au dI = c.Fh().dI(this.llp.fqB);
            if (dI.field_msgId != 0) {
                dI.cki();
                as.Hm();
                c.Fh().a(this.llp.fqB, dI);
            }
            File file = new File(this.llp.filePath);
            e.this.lln = (int) (((long) e.this.lln) + file.length());
            file.delete();
        }
    }

    public e(b bVar, h hVar, ArrayList<a> arrayList) {
        this.lkT = bVar;
        this.lll = hVar;
        this.llm = arrayList;
    }

    public final void run() {
        this.startTime = System.currentTimeMillis();
        this.lkV = this.llm.size();
        x.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", Integer.valueOf(this.lkV));
        if (this.lkV == 0) {
            ayI();
            return;
        }
        int i = 0;
        while (!this.isStop && i < this.llm.size()) {
            x.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", Integer.valueOf(i), ((a) this.llm.get(i)).filePath);
            com.tencent.mm.plugin.clean.c.a.a aVar = new a(r0);
            while (!this.lkT.b(aVar)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            x.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", r0.filePath);
            i++;
        }
    }

    private void ayI() {
        this.endTime = System.currentTimeMillis();
        x.i("MicroMsg.DeleteFileController", "totalUserTime:%d", Long.valueOf(this.endTime - this.startTime));
        if (this.lll != null && !this.isStop) {
            this.hbP.post(new Runnable() {
                public final void run() {
                    e.this.lll.bX((long) e.this.lln);
                }
            });
        }
    }

    public final void aza() {
        x.i("MicroMsg.DeleteFileController", "stop analyseController");
        this.isStop = true;
        interrupt();
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        interrupt();
        this.lkW++;
        if (!(this.lll == null || this.isStop)) {
            this.hbP.post(new Runnable() {
                public final void run() {
                    e.this.lll.cp(e.this.lkW, e.this.lkV);
                }
            });
        }
        if (this.lkW == this.lkV) {
            ayI();
        }
    }
}
