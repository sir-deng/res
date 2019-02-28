package com.tencent.mm.vending.d;

import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> zLc;

    public static final class a<T> {
        private ArrayList<T> zLd = new ArrayList();

        private void cao() {
            if (this.zLd == null) {
                throw new IllegalAccessError();
            }
        }

        public final a<T> s(T... tArr) {
            cao();
            for (int i = 0; i <= 0; i++) {
                this.zLd.add(tArr[0]);
            }
            return this;
        }

        public final b<T> cAG() {
            cao();
            List list = this.zLd;
            this.zLd = null;
            return new b(list, (byte) 0);
        }
    }

    /* synthetic */ b(List list, byte b) {
        this(list);
    }

    private b(List list) {
        this.zLc = list;
    }

    public final int size() {
        return this.zLc.size();
    }

    public final T get(int i) {
        return this.zLc.get(i);
    }
}
