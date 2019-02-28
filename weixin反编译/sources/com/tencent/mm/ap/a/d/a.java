package com.tencent.mm.ap.a.d;

import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V> {
    private f<K, V> hFS;

    public a(int i) {
        this.hFS = new f(i);
    }

    public final void clear() {
        if (this.hFS == null) {
            throw new NullPointerException("mData == null");
        }
        this.hFS.trimToSize(-1);
    }

    public final V get(K k) {
        if (this.hFS != null) {
            return this.hFS.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.hFS != null) {
            return this.hFS.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized Map<K, V> snapshot() {
        if (this.hFS == null) {
            throw new NullPointerException("mData == null");
        }
        return this.hFS.snapshot();
    }

    public final synchronized String toString() {
        if (this.hFS == null) {
            throw new NullPointerException("mData == null");
        }
        return this.hFS.toString();
    }
}
