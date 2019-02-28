package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import java.util.List;

public abstract class c<T extends b> {
    private boolean pKJ = false;
    final int pKK = 3;
    private final int pKL = 300000;
    private SparseArray<a> pKM = new SparseArray();
    private LinkedList<T> pKN = new LinkedList();
    private long pKO = 0;

    private final class a {
        int ieM;
        long pKQ;

        private a() {
            this.pKQ = SystemClock.elapsedRealtime();
            this.ieM = c.this.pKK;
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    protected abstract void a(T t);

    protected abstract List<T> bnv();

    static /* synthetic */ void a(c cVar) {
        if (!cVar.pKJ || System.currentTimeMillis() - cVar.pKO >= 60000) {
            a aVar;
            b bVar;
            cVar.pKO = System.currentTimeMillis();
            if (cVar.pKN.isEmpty()) {
                for (b bVar2 : cVar.bnv()) {
                    aVar = (a) cVar.pKM.get(bVar2.bnr());
                    if (aVar == null) {
                        cVar.pKM.put(bVar2.bnr(), new a(cVar, (byte) 0));
                    } else if (aVar.ieM >= 0 || SystemClock.elapsedRealtime() - aVar.pKQ >= ((long) cVar.pKL)) {
                        if (aVar.ieM < 0) {
                            aVar.ieM = cVar.pKK;
                        }
                    }
                    x.d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", Integer.valueOf(bVar2.bnr()));
                    if (!cVar.pKN.contains(bVar2)) {
                        cVar.pKN.add(bVar2);
                    }
                }
                x.i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", Integer.valueOf(cVar.pKN.size()));
            }
            if (cVar.pKN.isEmpty()) {
                x.i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
                cVar.finish();
                return;
            }
            byte b;
            bVar2 = (b) cVar.pKN.removeFirst();
            aVar = (a) cVar.pKM.get(bVar2.bnr());
            if (aVar == null) {
                aVar = new a(cVar, (byte) 0);
                cVar.pKM.put(bVar2.bnr(), aVar);
            }
            aVar.ieM--;
            if (aVar.ieM < 0) {
                if (((long) cVar.pKL) > SystemClock.elapsedRealtime() - aVar.pKQ) {
                    b = (byte) 0;
                    if (b == (byte) 0) {
                        cVar.a(bVar2);
                        cVar.pKJ = true;
                        return;
                    }
                    cVar.run();
                    return;
                }
                aVar.ieM = cVar.pKK - 1;
            }
            aVar.pKQ = SystemClock.elapsedRealtime();
            boolean b2 = true;
            if (b2 == (byte) 0) {
                cVar.run();
                return;
            }
            cVar.a(bVar2);
            cVar.pKJ = true;
            return;
        }
        x.d("MicroMsg.RecordMsgBaseService", "is working, return");
    }

    public final void run() {
        as.Dt().F(new Runnable() {
            public final void run() {
                c.a(c.this);
            }

            public final String toString() {
                return super.toString() + "|tryDoJob";
            }
        });
    }

    protected final void bnw() {
        this.pKJ = false;
        run();
    }

    final void finish() {
        this.pKN.clear();
        this.pKM.clear();
        this.pKJ = false;
    }
}
