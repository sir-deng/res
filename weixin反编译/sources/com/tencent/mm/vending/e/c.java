package com.tencent.mm.vending.e;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> zLe = new ArrayList();
    private boolean zLf = true;

    public final synchronized void keep(_Target _target) {
        if (this.zLf) {
            this.zLe.add(new WeakReference(_target));
        } else {
            Assert.assertNotNull(_target);
            _target.dead();
        }
    }

    public final synchronized void dead() {
        if (this.zLf) {
            for (WeakReference weakReference : this.zLe) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.dead();
                }
            }
            this.zLe.clear();
            this.zLf = false;
        }
    }
}
