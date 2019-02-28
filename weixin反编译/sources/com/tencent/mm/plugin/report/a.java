package com.tencent.mm.plugin.report;

import java.util.HashMap;
import java.util.Map.Entry;

public final class a {
    private int mID = 463;
    private long mInterval = 300000;
    private long pVB;
    private HashMap<Integer, Long> pVC = new HashMap();

    public final void f(int i, int i2, long j) {
        synchronized (this) {
            D(i, j);
            D(i2, 1);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.pVB > this.mInterval) {
                for (Entry entry : this.pVC.entrySet()) {
                    d.pVE.a((long) this.mID, (long) ((Integer) entry.getKey()).intValue(), ((Long) entry.getValue()).longValue(), false);
                }
                this.pVB = currentTimeMillis;
            }
        }
    }

    private void D(int i, long j) {
        Long l = (Long) this.pVC.get(Integer.valueOf(i));
        if (l != null) {
            j += l.longValue();
        }
        this.pVC.put(Integer.valueOf(i), Long.valueOf(j));
    }
}
