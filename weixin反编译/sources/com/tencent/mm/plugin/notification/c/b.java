package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b {
    int currentIndex;
    public ArrayList<Long> oZO;

    public b() {
        this.currentIndex = 0;
        this.oZO = new ArrayList();
        this.currentIndex = 0;
    }

    public final void dW(long j) {
        x.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oZO.size()));
        this.oZO.add(Long.valueOf(j));
    }

    public final long bhh() {
        long j = -1;
        if (this.oZO.size() > 0 && this.currentIndex < this.oZO.size()) {
            j = ((Long) this.oZO.get(this.currentIndex)).longValue();
        }
        x.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oZO.size()));
        this.currentIndex++;
        return j;
    }

    public final boolean dX(long j) {
        return this.oZO.contains(Long.valueOf(j));
    }

    public final void clear() {
        this.oZO.clear();
        this.currentIndex = 0;
    }

    public final long get(int i) {
        return ((Long) this.oZO.get(i)).longValue();
    }

    public final void remove(long j) {
        this.oZO.remove(Long.valueOf(j));
    }
}
