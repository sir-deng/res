package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    public com.tencent.mm.plugin.backup.b.b kqm;
    public b kqn;
    public long kqo;
    private LinkedList<f.b> kqp = null;
    private LinkedList<f.b> kqq = null;
    public LinkedList<f.b> kqr = null;
    public boolean kqs = false;
    boolean kqt = false;
    private Object lock = new Object();

    public final LinkedList<f.b> apt() {
        if (this.kqp == null) {
            this.kqp = new LinkedList();
        }
        return this.kqp;
    }

    private static long z(LinkedList<f.b> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((f.b) linkedList.get(0)).koC;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                f.b bVar = (f.b) it.next();
                if (j > bVar.koC) {
                    j2 = bVar.koC;
                } else {
                    j2 = j;
                }
            }
        }
        return j;
    }

    public final LinkedList<f.b> apu() {
        if (this.kqq == null) {
            this.kqq = new LinkedList();
        }
        return this.kqq;
    }

    public final void a(int i, long j, long j2, LinkedList<f.b> linkedList) {
        if (i == 0) {
            this.kqq = new LinkedList(linkedList);
            return;
        }
        this.kqq = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f.b bVar = (f.b) it.next();
            if (d.aqL().aqM().Fh().p(bVar.koB, j, j2) > 0) {
                this.kqq.add(bVar);
            }
        }
    }

    public final LinkedList<f.b> apv() {
        if (this.kqr == null) {
            this.kqr = new LinkedList();
        }
        return this.kqr;
    }

    public final void apw() {
        this.kqp = null;
        this.kqr = null;
        this.kqq = null;
        this.kqt = false;
        this.kqs = false;
    }

    public final void cancel() {
        synchronized (this.lock) {
            if (this.kqm != null) {
                this.kqm.cancel();
                this.kqm = null;
            }
        }
    }

    public final void apx() {
        b.apy();
        SharedPreferences aoX = com.tencent.mm.plugin.backup.a.d.aoX();
        a(aoX.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), aoX.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), aoX.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), apt());
    }

    public final void w(LinkedList<f.b> linkedList) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.kqs = true;
        this.kqp = new LinkedList(linkedList);
        this.kqo = z(this.kqp);
        apx();
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(apt().size()), Integer.valueOf(apu().size()));
        if (this.kqn != null) {
            this.kqn.w(apu());
        }
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.kqp = linkedList;
        if (this.kqq != null) {
            Iterator it = this.kqq.iterator();
            while (it.hasNext()) {
                f.b bVar2 = (f.b) it.next();
                if (bVar2.koB.equals(bVar.koB)) {
                    bVar2.koE = bVar.koE;
                    bVar2.koF = bVar.koF;
                    break;
                }
            }
        }
        if (b.apy().apA().krr) {
            x.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.apy().aoS().F(13, i, linkedList.size());
            b.apy().apA().mR(13);
        }
        if (this.kqn != null) {
            this.kqn.a(apu(), bVar, i);
        }
    }

    public final void x(LinkedList<f.b> linkedList) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.kqt = true;
        this.kqp = (LinkedList) linkedList.clone();
        apx();
        if (b.apy().apA().krr) {
            x.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.apy().apA().apN();
        } else if (this.kqn != null) {
            this.kqn.x(linkedList);
        }
    }
}
