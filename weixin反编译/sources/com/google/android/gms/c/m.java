package com.google.android.gms.c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V> extends q<K, V> implements Map<K, V> {
    p<K, V> aXA;

    private p<K, V> pG() {
        if (this.aXA == null) {
            this.aXA = new p<K, V>() {
                protected final void X(int i) {
                    m.this.removeAt(i);
                }

                protected final V a(int i, V v) {
                    q qVar = m.this;
                    int i2 = (i << 1) + 1;
                    V v2 = qVar.wz[i2];
                    qVar.wz[i2] = v;
                    return v2;
                }

                protected final void a(K k, V v) {
                    m.this.put(k, v);
                }

                protected final int bC() {
                    return m.this.hX;
                }

                protected final Map<K, V> bD() {
                    return m.this;
                }

                protected final void bE() {
                    m.this.clear();
                }

                protected final int h(Object obj) {
                    return obj == null ? m.this.bI() : m.this.indexOf(obj, obj.hashCode());
                }

                protected final int i(Object obj) {
                    return m.this.indexOfValue(obj);
                }

                protected final Object n(int i, int i2) {
                    return m.this.wz[(i << 1) + i2];
                }
            };
        }
        return this.aXA;
    }

    public Set<Entry<K, V>> entrySet() {
        p pG = pG();
        if (pG.aXI == null) {
            pG.aXI = new b();
        }
        return pG.aXI;
    }

    public Set<K> keySet() {
        p pG = pG();
        if (pG.aXJ == null) {
            pG.aXJ = new c();
        }
        return pG.aXJ;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hX + map.size();
        if (this.wy.length < size) {
            Object obj = this.wy;
            Object obj2 = this.wz;
            super.dp(size);
            if (this.hX > 0) {
                System.arraycopy(obj, 0, this.wy, 0, this.hX);
                System.arraycopy(obj2, 0, this.wz, 0, this.hX << 1);
            }
            q.b(obj, obj2, this.hX);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        p pG = pG();
        if (pG.aXK == null) {
            pG.aXK = new e();
        }
        return pG.aXK;
    }
}
