package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static volatile a iXO;
    public Map<String, List<IPCDynamicPageView>> iXP = new ConcurrentHashMap();
    public Map<String, a> iXQ = new ConcurrentHashMap();

    public interface a {
        void a(String str, IPCDynamicPageView iPCDynamicPageView);
    }

    private a() {
    }

    public static a adv() {
        if (iXO == null) {
            synchronized (a.class) {
                if (iXO == null) {
                    iXO = new a();
                }
            }
        }
        return iXO;
    }

    public final IPCDynamicPageView rR(String str) {
        if (str == null) {
            return null;
        }
        for (Entry entry : this.iXP.entrySet()) {
            if (entry.getValue() != null) {
                for (IPCDynamicPageView iPCDynamicPageView : (List) entry.getValue()) {
                    if (iPCDynamicPageView.gQA != null && iPCDynamicPageView.gQA.equals(str)) {
                        return iPCDynamicPageView;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final boolean b(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list = (List) this.iXP.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(iPCDynamicPageView);
        }
        if (list.isEmpty()) {
            this.iXP.remove(str);
        }
        return remove;
    }

    public final boolean c(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list;
        List list2 = (List) this.iXP.get(str);
        if (list2 == null) {
            LinkedList linkedList = new LinkedList();
            this.iXP.put(str, linkedList);
            list = linkedList;
        } else {
            list = list2;
        }
        if (list.contains(iPCDynamicPageView)) {
            synchronized (list) {
                list.remove(iPCDynamicPageView);
                list.add(iPCDynamicPageView);
            }
            return true;
        }
        boolean add = list.add(iPCDynamicPageView);
        if (list.size() > 4) {
            synchronized (list) {
                if (list.size() > 4) {
                    IPCDynamicPageView ac = ac(list);
                    if (ac != null) {
                        a aVar = (a) this.iXQ.get(str);
                        if (aVar != null) {
                            aVar.a(str, ac);
                        }
                    }
                }
            }
        }
        return add;
    }

    private static IPCDynamicPageView ac(List<IPCDynamicPageView> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            if (((IPCDynamicPageView) list.get(i2)).isPaused()) {
                return (IPCDynamicPageView) list.remove(i2);
            }
            i = i2 + 1;
        }
    }
}
