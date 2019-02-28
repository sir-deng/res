package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j lSF;
    private SparseArray<List<a>> lSG = new SparseArray();

    public interface a {
        void e(int i, Object... objArr);
    }

    private j() {
    }

    public static j aEI() {
        if (lSF == null) {
            lSF = new j();
        }
        return lSF;
    }

    public final boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        List list = (List) this.lSG.get(i);
        if (list == null) {
            list = new LinkedList();
            this.lSG.put(i, list);
        } else if (list.contains(aVar)) {
            return false;
        }
        return list.add(aVar);
    }

    public final boolean b(int i, a aVar) {
        List list = (List) this.lSG.get(i);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.lSG.remove(i);
            }
        }
        return false;
    }

    public final void f(int i, Object... objArr) {
        List list = (List) this.lSG.get(i);
        if (list != null && list.size() != 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    ((a) list.get(i3)).e(i, objArr);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
