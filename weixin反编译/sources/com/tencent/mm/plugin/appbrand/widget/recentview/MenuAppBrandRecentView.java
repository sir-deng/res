package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.k.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;

public class MenuAppBrandRecentView extends BaseAppBrandRecentView {
    private a klo;

    public MenuAppBrandRecentView(Context context) {
        super(context);
    }

    public MenuAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final String getType() {
        return MenuAppBrandRecentView.class.getSimpleName();
    }

    public final void a(a aVar) {
        this.klo = aVar;
    }

    protected final void a(b bVar, a aVar) {
        super.a(bVar, aVar);
        bVar.ikn.setTextColor(-1728053248);
        if (aVar.type == 2) {
            bVar.ikn.setVisibility(0);
            bVar.klj.setVisibility(8);
            bVar.ikn.setText(e.kaY);
            bVar.jIs.setImageResource(d.kaV);
        } else if (aVar.type == -1) {
            bVar.jIs.setImageResource(d.bBC);
        }
    }

    protected final int aoE() {
        return 11;
    }

    protected final void init(Context context) {
        super.init(context);
        super.a(new a() {
            public final boolean a(View view, a aVar, float f, float f2) {
                boolean a;
                if (MenuAppBrandRecentView.this.klo != null) {
                    a = MenuAppBrandRecentView.this.klo.a(view, aVar, f, f2);
                } else {
                    a = false;
                }
                if (a) {
                    return true;
                }
                if (aVar.type == 2) {
                    ((d) g.h(d.class)).ck(MenuAppBrandRecentView.this.getContext());
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1090;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(MenuAppBrandRecentView.this.getContext(), aVar.kkN.username, null, aVar.kkN.iNi, -1, null, appBrandStatObject);
                }
                return false;
            }

            public final boolean b(View view, a aVar, float f, float f2) {
                if (MenuAppBrandRecentView.this.klo != null) {
                    return MenuAppBrandRecentView.this.klo.b(view, aVar, f, f2);
                }
                return false;
            }
        });
    }
}
