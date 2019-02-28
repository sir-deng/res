package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g extends com.tencent.mm.ui.base.sortview.a {
    private static b kKR;

    public static class a implements com.tencent.mm.ui.base.sortview.a.a {
    }

    public g(Object obj) {
        super(0, obj);
        this.ysA = true;
    }

    public final b asT() {
        if (kKR == null) {
            kKR = new b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return new View(context);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                }
            };
        }
        return kKR;
    }

    public final com.tencent.mm.ui.base.sortview.a.a asU() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
    }
}
