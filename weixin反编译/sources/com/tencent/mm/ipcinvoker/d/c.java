package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static volatile c gOE;
    Map<String, List<e>> gOF = new ConcurrentHashMap();

    public static c BG() {
        if (gOE == null) {
            synchronized (c.class) {
                if (gOE == null) {
                    gOE = new c();
                }
            }
        }
        return gOE;
    }

    private c() {
    }

    public final boolean b(String str, Bundle bundle) {
        if (str == null || str.length() == 0 || bundle == null) {
            return false;
        }
        List list = (List) this.gOF.get(str);
        if (list == null || list.isEmpty()) {
            return true;
        }
        synchronized (list) {
            List<e> arrayList = new ArrayList(list);
        }
        for (e as : arrayList) {
            as.as(bundle);
        }
        return true;
    }

    public final boolean a(String str, e eVar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.gOF.get(str);
        if (list == null) {
            list = new LinkedList();
            this.gOF.put(str, list);
        }
        if (list.contains(eVar)) {
            return false;
        }
        boolean add;
        synchronized (list) {
            add = list.add(eVar);
        }
        return add;
    }

    public final boolean b(String str, e eVar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.gOF.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(eVar);
        }
        if (list.isEmpty()) {
            this.gOF.remove(str);
        }
        return remove;
    }
}
