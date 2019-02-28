package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public int mState;
    public Map<Integer, Map<Integer, Integer>> syK;

    public c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void Z(int i, int i2, int i3) {
        Map map;
        if (this.syK == null) {
            this.syK = new HashMap();
        }
        if (this.syK.containsKey(Integer.valueOf(i))) {
            map = (Map) this.syK.get(Integer.valueOf(i));
        } else {
            map = new HashMap();
            this.syK.put(Integer.valueOf(i), map);
        }
        map.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final boolean zm(int i) {
        if (this.syK == null || !this.syK.containsKey(Integer.valueOf(this.mState))) {
            x.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", b.zg(this.mState));
            return false;
        } else if (((Map) this.syK.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            return true;
        } else {
            x.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", b.zg(this.mState), b.zg(i));
            return false;
        }
    }
}
