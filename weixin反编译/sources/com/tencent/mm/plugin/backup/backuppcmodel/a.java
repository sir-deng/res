package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements com.tencent.mm.plugin.backup.b.b.a {
    public long kqo;
    private LinkedList<b> kqp = null;
    private LinkedList<b> kqq = null;
    private LinkedList<b> kqr = null;
    public boolean kqs = false;
    com.tencent.mm.plugin.backup.b.b krn;
    public boolean ktg = false;
    public com.tencent.mm.plugin.backup.b.b.a kth;
    private Object lock = new Object();

    private static long z(LinkedList<b> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((b) linkedList.get(0)).koC;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                if (j > bVar.koC) {
                    j2 = bVar.koC;
                } else {
                    j2 = j;
                }
            }
        }
        return j;
    }

    public final LinkedList<b> apt() {
        if (this.kqp == null) {
            this.kqp = new LinkedList();
        }
        return this.kqp;
    }

    public final LinkedList<b> apu() {
        if (this.kqq == null) {
            this.kqq = new LinkedList();
        }
        return this.kqq;
    }

    public final void a(int i, long j, long j2, LinkedList<b> linkedList) {
        if (i == 0) {
            this.kqq = new LinkedList(linkedList);
            return;
        }
        if (this.kqq == null) {
            this.kqq = new LinkedList();
        } else {
            this.kqq.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (d.aqL().aqM().Fh().p(bVar.koB, j, j2) > 0) {
                this.kqq.add(bVar);
            }
        }
    }

    public final void A(LinkedList<b> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            this.kqr = new LinkedList();
            return;
        }
        this.kqr = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.kqr.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
    }

    private LinkedList<b> apv() {
        if (this.kqr == null) {
            this.kqr = new LinkedList();
        }
        return this.kqr;
    }

    public final void dL(boolean z) {
        x.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", Boolean.valueOf(z));
        this.ktg = z;
        d.aqL().aqO();
        e.post(new Runnable() {
            public final void run() {
                if (a.this.krn != null) {
                    a.this.krn.cancel();
                }
                a.this.krn = new com.tencent.mm.plugin.backup.b.b();
                a.this.krn.a(a.this);
            }
        }, "BackupPcChooseServer.calculateToChoose");
    }

    public final void w(LinkedList<b> linkedList) {
        String str = "MicroMsg.BackupPcChooseServer";
        String str2 = "onCalcuConvFinish, conv size[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        x.i(str, str2, objArr);
        this.kqs = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.kth != null) {
                this.kth.w(linkedList);
            }
            if (this.ktg) {
                e aqb = b.apZ().aqb();
                e.ktJ = true;
                aqb.kro.apg();
                b.apZ().apz().stop();
                b.apZ().aoS().kov = -23;
                b.apZ().aqb().nc(-23);
                return;
            }
            return;
        }
        this.kqp = new LinkedList(linkedList);
        this.kqo = z(this.kqp);
        b.apZ();
        SharedPreferences aoX = com.tencent.mm.plugin.backup.a.d.aoX();
        a(aoX.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), aoX.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), aoX.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), apt());
        x.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(linkedList.size()), Integer.valueOf(apu().size()));
        if (this.ktg) {
            A(apu());
            b.apZ().aqb().B(g.v(apv()));
            b.apZ().aqb().bJ((long) apv().size());
        }
        if (this.kth != null) {
            this.kth.w(apu());
        }
    }

    public final void apw() {
        this.kqp = null;
        this.kqr = null;
        this.kqq = null;
        this.kqs = false;
    }

    public final void cancel() {
        x.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", bi.chl());
        synchronized (this.lock) {
            if (this.krn != null) {
                this.krn.cancel();
                this.krn = null;
            }
            this.kqs = false;
        }
    }
}
