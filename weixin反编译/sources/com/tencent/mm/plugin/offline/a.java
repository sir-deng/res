package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> paM = new ArrayList();

    public final void bG(T t) {
        if (this.paM != null) {
            this.paM = new ArrayList();
        }
        if (t != null) {
            this.paM.add(new WeakReference(t));
        }
    }

    public final void bH(T t) {
        if (this.paM != null && t != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.paM.size()) {
                    WeakReference weakReference = (WeakReference) this.paM.get(i2);
                    if (weakReference != null) {
                        Object obj = weakReference.get();
                        if (obj != null && obj.equals(t)) {
                            weakReference.clear();
                            this.paM.remove(weakReference);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
