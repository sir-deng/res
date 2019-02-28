package com.tencent.mm.storage;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

final class ah {
    protected final long xGW = 86400;
    private ag xGX = new ag();

    public ah() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        byte[] e = e.e(stringBuilder.append(g.Dq().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!bi.by(e)) {
            try {
                this.xGX.aH(e);
                if (cjB()) {
                    cjA();
                }
            } catch (Throwable e2) {
                x.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                x.e("MicroMsg.DelSvrIdMgr", "exception:%s", bi.i(e2));
            }
        }
    }

    private void cjA() {
        x.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.xGX.xGT.size()), Integer.valueOf(this.xGX.xGU.size()), Integer.valueOf(this.xGX.xGV.size()), bi.chl());
        try {
            this.xGX.xGS.clear();
            this.xGX.xGR.clear();
            this.xGX.xGQ.clear();
            ag agVar = new ag();
            agVar.xGT.addAll(this.xGX.xGT);
            agVar.xGU.addAll(this.xGX.xGU);
            agVar.xGV.addAll(this.xGX.xGV);
            byte[] toByteArray = agVar.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dr();
            e.b(stringBuilder.append(g.Dq().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
            String str = "MicroMsg.DelSvrIdMgr";
            String str2 = "summerdel toFile done [%d, %d, %d] data len[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(agVar.xGT.size());
            objArr[1] = Integer.valueOf(agVar.xGU.size());
            objArr[2] = Integer.valueOf(agVar.xGV.size());
            objArr[3] = Integer.valueOf(toByteArray == null ? -1 : toByteArray.length);
            x.i(str, str2, objArr);
        } catch (Throwable e) {
            d.pVE.a(111, 168, 1, false);
            x.printErrStackTrace("MicroMsg.DelSvrIdMgr", e, "summerdel ", new Object[0]);
        }
    }

    protected final boolean fQ(long j) {
        if (cjB()) {
            cjA();
        }
        return this.xGX.xGT.contains(Long.valueOf(j)) || this.xGX.xGU.contains(Long.valueOf(j)) || this.xGX.xGV.contains(Long.valueOf(j));
    }

    protected final void j(int i, long j, long j2) {
        a(i, j, j2, true);
    }

    protected final void a(int i, long j, long j2, boolean z) {
        if (j != 0) {
            if (z) {
                cjB();
            }
            switch (i - ((int) (j2 / 86400))) {
                case 0:
                    this.xGX.xGT.add(Long.valueOf(j));
                    break;
                case 1:
                    this.xGX.xGU.add(Long.valueOf(j));
                    break;
                case 2:
                    this.xGX.xGV.add(Long.valueOf(j));
                    break;
                default:
                    x.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / 86400))));
                    break;
            }
            if (z) {
                cjA();
            }
        }
    }

    protected final void i(List<Integer> list, List<Long> list2) {
        x.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        cjB();
        int Wx = (int) (bi.Wx() / 86400);
        for (int i = 0; i < list.size(); i++) {
            a(Wx, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        cjA();
    }

    private boolean cjB() {
        x.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.xGX.xGP), Integer.valueOf(this.xGX.xGT.size()), Integer.valueOf(this.xGX.xGU.size()), Integer.valueOf(this.xGX.xGV.size()));
        int Wx = (int) (bi.Wx() / 86400);
        int i = Wx - this.xGX.xGP;
        this.xGX.xGP = Wx;
        switch (i) {
            case 0:
                return false;
            case 1:
                this.xGX.xGV = this.xGX.xGU;
                this.xGX.xGU = this.xGX.xGT;
                this.xGX.xGT.clear();
                return true;
            case 2:
                this.xGX.xGV = this.xGX.xGT;
                this.xGX.xGU.clear();
                this.xGX.xGT.clear();
                return true;
            default:
                this.xGX.xGV.clear();
                this.xGX.xGU.clear();
                this.xGX.xGT.clear();
                return true;
        }
    }
}
