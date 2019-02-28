package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.e.a;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class s {
    public static void g(e eVar) {
        if (eVar == null) {
            x.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
        } else if (eVar.gUI) {
            h(eVar);
        } else {
            x.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", eVar.mAppId);
        }
    }

    static void h(final e eVar) {
        if (ah.isMainThread()) {
            e.post(new Runnable() {
                public final void run() {
                    s.h(eVar);
                }
            }, String.format("performRestart$%s", new Object[]{eVar.mAppId}));
            return;
        }
        Bitmap bitmap;
        if (eVar.YI()) {
            MBCanvasContentHolder afg = a.jdv.afg();
            bitmap = afg == null ? null : afg.content;
        } else {
            bitmap = (Bitmap) new bd<Bitmap>() {
                protected final /* synthetic */ Object run() {
                    View ajy = eVar.isX.ajy();
                    if (ajy.getWidth() == 0 || ajy.getHeight() == 0) {
                        return null;
                    }
                    Object createBitmap = Bitmap.createBitmap(ajy.getWidth(), ajy.getHeight(), Config.ARGB_8888);
                    d.a(new Canvas(createBitmap), ajy);
                    return createBitmap;
                }
            }.b(new ag(Looper.getMainLooper()));
        }
        ah.y(new Runnable() {
            public final void run() {
                l.a.a(eVar, bitmap);
                e eVar = eVar;
                eVar.isR.acj();
                eVar.reload();
            }
        });
    }
}
