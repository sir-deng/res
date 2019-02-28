package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public final class bg {
    private boolean jKc = false;
    private String mTag;
    private String xqG;
    ArrayList<Long> xqH;
    ArrayList<String> xqI;

    public bg(String str, String str2) {
        this.mTag = str;
        this.xqG = str2;
        if (!this.jKc) {
            if (this.xqH == null) {
                this.xqH = new ArrayList();
                this.xqI = new ArrayList();
            } else {
                this.xqH.clear();
                this.xqI.clear();
            }
            addSplit(null);
        }
    }

    public final void addSplit(String str) {
        if (!this.jKc) {
            this.xqH.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.xqI.add(str);
        }
    }

    public final void dumpToLog() {
        if (!this.jKc) {
            x.d(this.mTag, this.xqG + ": begin");
            long longValue = ((Long) this.xqH.get(0)).longValue();
            int i = 1;
            long j = longValue;
            while (i < this.xqH.size()) {
                long longValue2 = ((Long) this.xqH.get(i)).longValue();
                x.d(this.mTag, this.xqG + ":      " + (longValue2 - ((Long) this.xqH.get(i - 1)).longValue()) + " ms, " + ((String) this.xqI.get(i)));
                i++;
                j = longValue2;
            }
            x.d(this.mTag, this.xqG + ": end, " + (j - longValue) + " ms");
        }
    }
}
