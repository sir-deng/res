package com.tencent.mm.plugin.appbrand.widget.e;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class a extends c {
    private static final LinkedList<Runnable> kid = new LinkedList();
    private static boolean kie = false;
    private static a kif = new a() {
        public final void aok() {
            com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                public final void run() {
                    synchronized (this) {
                        Runnable runnable = (Runnable) a.kid.pollFirst();
                        if (runnable != null) {
                            runnable.run();
                        } else {
                            x.i("MicroMsg.BaseMarkerAnimatorJsApi", "markerAnimatorJsApi processed!");
                            a.kie = false;
                        }
                    }
                }
            });
        }
    };

    public interface a {
        void aok();
    }

    public abstract boolean a(p pVar, int i, View view, JSONObject jSONObject, a aVar, f fVar);

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        final p pVar2 = pVar;
        final int i2 = i;
        final View view2 = view;
        final JSONObject jSONObject2 = jSONObject;
        final f fVar2 = fVar;
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                a.this.a(pVar2, i2, view2, jSONObject2, a.kif, fVar2);
            }
        };
        if (kie) {
            kid.add(anonymousClass2);
            x.i("MicroMsg.BaseMarkerAnimatorJsApi", "add to MarkerAnimator!");
        } else {
            kie = true;
            anonymousClass2.run();
        }
        return true;
    }
}
