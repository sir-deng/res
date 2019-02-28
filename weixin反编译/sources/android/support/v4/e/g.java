package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class g<K, V> {
    b wk;
    c wl;
    e wm;

    final class a<T> implements Iterator<T> {
        int hX;
        int mIndex;
        final int wn;
        boolean wo = false;

        a(int i) {
            this.wn = i;
            this.hX = g.this.bC();
        }

        public final boolean hasNext() {
            return this.mIndex < this.hX;
        }

        public final T next() {
            T n = g.this.n(this.mIndex, this.wn);
            this.mIndex++;
            this.wo = true;
            return n;
        }

        public final void remove() {
            if (this.wo) {
                this.mIndex--;
                this.hX--;
                this.wo = false;
                g.this.X(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        b() {
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bC = g.this.bC();
            for (Entry entry : collection) {
                g.this.a(entry.getKey(), entry.getValue());
            }
            return bC != g.this.bC();
        }

        public final void clear() {
            g.this.bE();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int h = g.this.h(entry.getKey());
            if (h >= 0) {
                return b.b(g.this.n(h, 1), entry.getValue());
            }
            return false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return g.this.bC() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return g.this.bC();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int bC = g.this.bC() - 1;
            int i = 0;
            while (bC >= 0) {
                Object n = g.this.n(bC, 0);
                Object n2 = g.this.n(bC, 1);
                bC--;
                i += (n2 == null ? 0 : n2.hashCode()) ^ (n == null ? 0 : n.hashCode());
            }
            return i;
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            g.this.bE();
        }

        public final boolean contains(Object obj) {
            return g.this.h(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bD = g.this.bD();
            for (Object containsKey : collection) {
                if (!bD.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return g.this.bC() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            int h = g.this.h(obj);
            if (h < 0) {
                return false;
            }
            g.this.X(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bD = g.this.bD();
            int size = bD.size();
            for (Object remove : collection) {
                bD.remove(remove);
            }
            return size != bD.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return g.a(g.this.bD(), (Collection) collection);
        }

        public final int size() {
            return g.this.bC();
        }

        public final Object[] toArray() {
            return g.this.ab(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return g.this.a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bC = g.this.bC() - 1; bC >= 0; bC--) {
                Object n = g.this.n(bC, 0);
                i += n == null ? 0 : n.hashCode();
            }
            return i;
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mIndex;
        int wq;
        boolean wr = false;

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.wr = true;
            return this;
        }

        d() {
            this.wq = g.this.bC() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.wq;
        }

        public final void remove() {
            if (this.wr) {
                g.this.X(this.mIndex);
                this.mIndex--;
                this.wq--;
                this.wr = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.wr) {
                return g.this.n(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.wr) {
                return g.this.n(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.wr) {
                return g.this.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.wr) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (b.b(entry.getKey(), g.this.n(this.mIndex, 0)) && b.b(entry.getValue(), g.this.n(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.wr) {
                Object n = g.this.n(this.mIndex, 0);
                Object n2 = g.this.n(this.mIndex, 1);
                int hashCode = n == null ? 0 : n.hashCode();
                if (n2 != null) {
                    i = n2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            g.this.bE();
        }

        public final boolean contains(Object obj) {
            return g.this.i(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return g.this.bC() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            int i = g.this.i(obj);
            if (i < 0) {
                return false;
            }
            g.this.X(i);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int bC = g.this.bC();
            boolean z = false;
            while (i < bC) {
                if (collection.contains(g.this.n(i, 1))) {
                    g.this.X(i);
                    i--;
                    bC--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int i = 0;
            int bC = g.this.bC();
            boolean z = false;
            while (i < bC) {
                if (!collection.contains(g.this.n(i, 1))) {
                    g.this.X(i);
                    i--;
                    bC--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return g.this.bC();
        }

        public final Object[] toArray() {
            return g.this.ab(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return g.this.a((Object[]) tArr, 1);
        }
    }

    protected abstract void X(int i);

    protected abstract V a(int i, V v);

    protected abstract void a(K k, V v);

    protected abstract int bC();

    protected abstract Map<K, V> bD();

    protected abstract void bE();

    protected abstract int h(Object obj);

    protected abstract int i(Object obj);

    protected abstract Object n(int i, int i2);

    g() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] ab(int i) {
        int bC = bC();
        Object[] objArr = new Object[bC];
        for (int i2 = 0; i2 < bC; i2++) {
            objArr[i2] = n(i2, i);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i) {
        T[] tArr2;
        int bC = bC();
        if (tArr.length < bC) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bC);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < bC; i2++) {
            tArr2[i2] = n(i2, i);
        }
        if (tArr2.length > bC) {
            tArr2[bC] = null;
        }
        return tArr2;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }
}
