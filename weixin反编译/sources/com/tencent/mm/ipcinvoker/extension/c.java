package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static List<a> gOH = new LinkedList();
    private static Map<String, a> gOI = new HashMap();

    public static a fo(String str) {
        return (a) gOI.get(str);
    }

    public static a av(Object obj) {
        for (a aVar : gOH) {
            if (aVar.au(obj)) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(Object obj, Parcel parcel) {
        a av = av(obj);
        if (av != null) {
            av.a(obj, parcel);
        }
    }

    public static Object a(String str, Parcel parcel) {
        a fo = fo(str);
        if (fo != null) {
            return fo.d(parcel);
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !gOH.contains(aVar)) {
            gOI.put(aVar.getClass().getName(), aVar);
            gOH.add(aVar);
        }
    }
}
