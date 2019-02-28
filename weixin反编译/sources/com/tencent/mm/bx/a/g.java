package com.tencent.mm.bx.a;

import android.util.SparseArray;
import com.tencent.mm.bx.a.f.a;
import java.util.ArrayList;

public abstract class g<K, T extends a> {
    public d xKD;

    public abstract ArrayList<T> ah(ArrayList<Object> arrayList);

    public abstract T clO();

    public g(d dVar, int i) {
        this.xKD = dVar;
        this.xKD.lQ(true);
        this.xKD.a(new a() {
            public final a clM() {
                return g.this.clO();
            }

            public final ArrayList<a> ah(ArrayList<Object> arrayList) {
                return g.this.ah(arrayList);
            }
        });
        if (i != 0) {
            this.xKD.DW(i);
        }
        getCount();
    }

    public final void close() {
        this.xKD.close();
        this.xKD = null;
    }

    public final int getCount() {
        return this.xKD.getCount();
    }

    public final boolean isClosed() {
        return this.xKD.isClosed();
    }

    public final boolean clE() {
        return this.xKD.clE();
    }

    public final void c(Object obj, T t) {
        this.xKD.a(obj, t);
    }

    public final SparseArray<K>[] clC() {
        return this.xKD.clC();
    }

    public final boolean ce(Object obj) {
        return this.xKD.ce(obj);
    }
}
