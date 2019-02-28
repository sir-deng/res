package com.tencent.mm.plugin.appbrand.q;

import android.support.v4.e.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class g<K, V> {
    private final Map<K, Set<V>> jXu = new a();

    public final void n(K k, V v) {
        if (k != null && v != null) {
            Set bh = bh(k);
            synchronized (bh) {
                bh.add(v);
            }
        }
    }

    private Set<V> bh(K k) {
        Set<V> set;
        synchronized (this.jXu) {
            set = (Set) this.jXu.get(k);
            if (set == null) {
                set = new HashSet();
                this.jXu.put(k, set);
            }
        }
        return set;
    }

    public final Set<V> bi(K k) {
        if (k == null) {
            return null;
        }
        Set<V> set;
        synchronized (this.jXu) {
            set = (Set) this.jXu.remove(k);
        }
        return set;
    }
}
