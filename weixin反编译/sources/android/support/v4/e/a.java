package android.support.v4.e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends j<K, V> implements Map<K, V> {
    g<K, V> wb;

    public a(int i) {
        super(i);
    }

    private g<K, V> bB() {
        if (this.wb == null) {
            this.wb = new g<K, V>() {
                protected final int bC() {
                    return a.this.hX;
                }

                protected final Object n(int i, int i2) {
                    return a.this.wz[(i << 1) + i2];
                }

                protected final int h(Object obj) {
                    return a.this.indexOfKey(obj);
                }

                protected final int i(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                protected final Map<K, V> bD() {
                    return a.this;
                }

                protected final void a(K k, V v) {
                    a.this.put(k, v);
                }

                protected final V a(int i, V v) {
                    return a.this.setValueAt(i, v);
                }

                protected final void X(int i) {
                    a.this.removeAt(i);
                }

                protected final void bE() {
                    a.this.clear();
                }
            };
        }
        return this.wb;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hX + map.size();
        if (this.wy.length < size) {
            Object obj = this.wy;
            Object obj2 = this.wz;
            super.ac(size);
            if (this.hX > 0) {
                System.arraycopy(obj, 0, this.wy, 0, this.hX);
                System.arraycopy(obj2, 0, this.wz, 0, this.hX << 1);
            }
            j.a(obj, obj2, this.hX);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        g bB = bB();
        if (bB.wk == null) {
            bB.wk = new b();
        }
        return bB.wk;
    }

    public Set<K> keySet() {
        g bB = bB();
        if (bB.wl == null) {
            bB.wl = new c();
        }
        return bB.wl;
    }

    public Collection<V> values() {
        g bB = bB();
        if (bB.wm == null) {
            bB.wm = new e();
        }
        return bB.wm;
    }
}
