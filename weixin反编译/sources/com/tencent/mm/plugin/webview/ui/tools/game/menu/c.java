package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class c {
    private static c tMn;

    public enum a {
        HVGAME_MENU_ACTION_DEFAULT(0),
        HVGAME_MENU_ACTION_JUMP_H5(1),
        HVGAME_MENU_ACTION_EXIT(2),
        HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
        HVGAME_MENU_ACTION_COLLECT(4),
        HVGAME_MENU_ACTION_STICK_ON(5),
        HVGAME_MENU_ACTION_STICK_OFF(6),
        HVGAME_MENU_ACTION_REFRESH(7),
        HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
        HVGAME_MENU_ACTION_COMPLAINT(9),
        HVGAME_MENU_ACTION_CUSTOM(10);
        
        private static EnumMap<a, Integer> tMA;
        int code;

        static {
            tMA = new EnumMap(a.class);
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                tMA.put(aVar, Integer.valueOf(aVar.code));
            }
        }

        private a(int i) {
            this.code = i;
        }

        public static boolean Bp(int i) {
            return tMA.containsValue(Integer.valueOf(i));
        }

        public static a Bq(int i) {
            for (Entry entry : tMA.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i) {
                    return (a) entry.getKey();
                }
            }
            return HVGAME_MENU_ACTION_DEFAULT;
        }
    }

    public static c bUW() {
        if (tMn == null) {
            synchronized (c.class) {
                if (tMn == null) {
                    tMn = new c();
                }
            }
        }
        return tMn;
    }

    public final n i(List<arl> list, boolean z) {
        if (bi.cC(list)) {
            return null;
        }
        List<arl> arrayList = new ArrayList();
        for (arl arl : list) {
            if (arl != null && a.Bp(arl.wnV)) {
                arrayList.add(arl);
            }
        }
        if (bi.cC(arrayList)) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<arl>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((arl) obj).wGa - ((arl) obj2).wGa;
            }
        });
        int i = ((arl) arrayList.get(arrayList.size() - 1)).wGa;
        List<arl> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList2.add(null);
        }
        for (arl arl2 : arrayList) {
            if (a.Bq(arl2.wnV) == a.HVGAME_MENU_ACTION_STICK_ON) {
                if (!z && arl2.wGa > 0 && arl2.wGa <= arrayList2.size()) {
                    arrayList2.set(arl2.wGa - 1, arl2);
                }
            } else if (a.Bq(arl2.wnV) == a.HVGAME_MENU_ACTION_STICK_OFF) {
                if (z && arl2.wGa > 0 && arl2.wGa <= arrayList2.size()) {
                    arrayList2.set(arl2.wGa - 1, arl2);
                }
            } else if (arl2.wGa > 0 && arl2.wGa <= arrayList2.size()) {
                arrayList2.set(arl2.wGa - 1, arl2);
            }
        }
        n nVar = new n();
        for (arl arl22 : arrayList2) {
            if (arl22 == null) {
                nVar.f(-1, "");
            } else {
                nVar.f(arl22.wFZ, arl22.fpg + "__" + arl22.phv);
            }
        }
        return nVar;
    }
}
