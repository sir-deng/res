package com.tencent.mm.y;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class bw {
    public boolean bgH = false;
    public Set<a> hjG = new HashSet();

    public interface a {
        boolean Il();
    }

    public final boolean a(a aVar) {
        if (!this.bgH) {
            return this.hjG.add(aVar);
        }
        x.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
        return false;
    }

    public final boolean b(a aVar) {
        if (!this.bgH) {
            return this.hjG.remove(aVar);
        }
        x.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
        return false;
    }
}
