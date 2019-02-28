package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum m {
    ;
    
    public static final Set<String> kdA = null;
    private static final Map<Integer, WeakReference<y>> kdB = null;
    private static final a<p, z> kdC = null;
    public static final Map<String, Integer> kdz = null;

    static {
        Set hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        kdA = Collections.unmodifiableSet(hashSet);
        Map hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        kdz = Collections.unmodifiableMap(hashMap);
        kdB = new HashMap();
        kdC = new a();
    }

    public static void m(p pVar) {
        if (pVar != null) {
            j jVar = new j(pVar);
        }
    }

    static void a(final int i, final y yVar) {
        if (yVar != null) {
            c.runOnUiThread(new Runnable() {
                public final void run() {
                    m.kdB.put(Integer.valueOf(i), new WeakReference(yVar));
                }
            });
        }
    }

    static y mn(int i) {
        WeakReference weakReference = (WeakReference) kdB.get(Integer.valueOf(i));
        return weakReference == null ? null : (y) weakReference.get();
    }

    public static void a(final p pVar, final String str, final Integer num) {
        if (pVar != null) {
            c.runOnUiThread(new Runnable() {
                public final void run() {
                    z zVar = (z) m.kdC.get(pVar);
                    if (zVar != null) {
                        y mn = m.mn(zVar.getInputId());
                        if (mn != null) {
                            mn.updateValue(str, num);
                        }
                    }
                }
            });
        }
    }

    @Deprecated
    public static boolean a(h hVar, int i) {
        WeakReference weakReference = (WeakReference) kdB.get(Integer.valueOf(i));
        y yVar = weakReference == null ? null : (y) weakReference.get();
        AppBrandInputInvokeHandler appBrandInputInvokeHandler = yVar instanceof AppBrandInputInvokeHandler ? (AppBrandInputInvokeHandler) yVar : null;
        return appBrandInputInvokeHandler != null && appBrandInputInvokeHandler.updateInput(hVar);
    }

    public static boolean n(p pVar) {
        return a(pVar, null);
    }

    public static boolean a(p pVar, Integer num) {
        if (num == null) {
            z zVar = (z) kdC.get(pVar);
            if (zVar == null) {
                return false;
            }
            num = Integer.valueOf(zVar.getInputId());
        }
        y mn = mn(num.intValue());
        return mn != null && mn.hideKeyboard();
    }

    public static boolean a(p pVar, int i, int i2, int i3) {
        y mn = mn(i);
        return mn != null && mn.isAttachedTo(pVar) && mn.showKeyboard(i2, i3);
    }

    public static void o(final p pVar) {
        ah.y(new Runnable() {
            public final void run() {
                m.n(pVar);
            }
        });
    }

    public static boolean mo(int i) {
        y mn = mn(i);
        return mn != null && mn.removeSelf();
    }

    static void a(final p pVar, final z zVar) {
        if (pVar != null) {
            c.runOnUiThread(new Runnable() {
                public final void run() {
                    m.kdC.put(pVar, zVar);
                }
            });
        }
    }

    static void p(final p pVar) {
        if (pVar != null) {
            c.runOnUiThread(new Runnable() {
                public final void run() {
                    m.kdC.remove(pVar);
                }
            });
        }
    }

    static y q(p pVar) {
        if (pVar == null) {
            return null;
        }
        z zVar = (z) kdC.get(pVar);
        if (zVar == null) {
            return null;
        }
        return mn(zVar.getInputId());
    }
}
