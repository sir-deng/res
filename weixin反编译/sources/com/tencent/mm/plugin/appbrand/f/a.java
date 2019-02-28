package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

final class a implements com.tencent.mm.sdk.e.j.a {
    a() {
    }

    public final void a(String str, l lVar) {
        if (e.Zx() == null) {
            x.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
            return;
        }
        List linkedList;
        switch (lVar.jcn) {
            case 2:
            case 3:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(e.Zx().qy(lVar.obj.toString()));
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String qy : (List) lVar.obj) {
                        linkedList.addAll(e.Zx().qy(qy));
                    }
                } else {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    e.Zx().b("batch", 3, linkedList);
                    return;
                }
                return;
            case 5:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(e.Zx().qy(lVar.obj.toString()));
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String qy2 : (List) lVar.obj) {
                        linkedList.addAll(e.Zx().qy(qy2));
                    }
                } else {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    e.Zx().b("batch", 5, linkedList);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
