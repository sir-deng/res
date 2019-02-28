package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final Map<String, List<a>> gOD = new ConcurrentHashMap();
    private static List<a> kng = new LinkedList();
    private static final e knh = new e() {
        public final /* synthetic */ void as(Object obj) {
            Bundle bundle = (Bundle) obj;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("logList");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                x.i("MicroMsg.ConsoleLogger", "logList is null or nil.");
            } else {
                d.b(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), parcelableArrayList);
            }
        }
    };

    static /* synthetic */ void b(String str, ArrayList arrayList) {
        if (!bi.oN(str) && arrayList != null && !arrayList.isEmpty()) {
            for (a ai : new LinkedList(kng)) {
                ai.ai(arrayList);
            }
            List list = (List) gOD.get(str);
            if (list != null) {
                for (a ai2 : new LinkedList(list)) {
                    ai2.ai(arrayList);
                }
            }
        }
    }

    public static boolean a(a aVar) {
        if (kng.contains(aVar)) {
            return false;
        }
        if (gOD.isEmpty() && kng.isEmpty()) {
            com.tencent.mm.ipcinvoker.d.d dVar = c.knf;
            i iVar = knh;
            com.tencent.mm.ipcinvoker.d dVar2 = dVar.gOG;
            String str = dVar.fpd;
            if (!(str == null || str.length() == 0 || iVar == null)) {
                Parcelable bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.ar(iVar));
                bundle.putString("Event", str);
                f.a(dVar2.process, bundle, a.class, iVar);
            }
        }
        return kng.add(aVar);
    }

    public static boolean b(a aVar) {
        boolean remove = kng.remove(aVar);
        if (gOD.isEmpty() && kng.isEmpty()) {
            com.tencent.mm.ipcinvoker.d.d dVar = c.knf;
            e eVar = knh;
            com.tencent.mm.ipcinvoker.d dVar2 = dVar.gOG;
            String str = dVar.fpd;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Parcelable bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.ar(eVar));
                bundle.putString("Event", str);
                f.a(dVar2.process, bundle, b.class, null);
            }
        }
        return remove;
    }
}
