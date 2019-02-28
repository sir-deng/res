package com.tencent.mm.plugin.appbrand.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.ui.base.n;

final class c extends a {
    c() {
        super(m.jGt - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (b.cfx()) {
            nVar.f(this.jGz, "appId: " + str);
        }
    }

    public final void a(Context context, final p pVar, String str, l lVar) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str));
            Toast.makeText(context, "copied appId: " + str, 1).show();
            pVar.getContentView().postDelayed(new Runnable() {
                public final void run() {
                    try {
                        if (pVar.jJw != null) {
                            a.a.cD(pVar.jJw.getX5WebViewExtension()).n("notifyMemoryPressure", Integer.valueOf(80));
                        }
                    } catch (Exception e) {
                    }
                }
            }, 1000);
        }
    }
}
