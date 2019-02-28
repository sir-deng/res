package com.tencent.mm.svg;

import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;

final class a<T> {
    private HashMap<Looper, LinkedList<T>> xKF = new HashMap();
    private LinkedList<T> xKG = new LinkedList();

    a() {
    }

    protected final synchronized T clP() {
        T t;
        t = null;
        if (this.xKG.size() != 0) {
            t = this.xKG.poll();
        }
        return t;
    }

    protected final synchronized void a(Looper looper, T t) {
        LinkedList linkedList;
        if (this.xKF.containsKey(looper)) {
            linkedList = (LinkedList) this.xKF.get(looper);
        } else {
            linkedList = new LinkedList();
            this.xKF.put(looper, linkedList);
        }
        linkedList.add(t);
    }

    protected final synchronized void c(Looper looper) {
        if (this.xKF.containsKey(looper)) {
            this.xKG.addAll((LinkedList) this.xKF.remove(looper));
        }
    }
}
