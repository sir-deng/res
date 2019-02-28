package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import java.util.List;

public final class m {
    g jIJ;
    List<l> jIK;
    p jfF;
    String mAppId;

    public m(final Context context, String str, p pVar, List<l> list) {
        this.mAppId = str;
        this.jfF = pVar;
        this.jIK = list;
        this.jIJ = new g(context, g.zCt);
        View afd = this.jfF.afd();
        if (afd != null) {
            this.jIJ.dO(afd);
        }
        this.jIJ.rQF = new c() {
            public final void a(n nVar) {
                for (l lVar : m.this.jIK) {
                    if (!(lVar == null || lVar.jGh)) {
                        Context context = m.this.jfF.mContext;
                        p pVar = m.this.jfF;
                        String str = m.this.mAppId;
                        m.this.jIJ.zCj.booleanValue();
                        if (lVar != null) {
                            a aVar = (a) a.jGy.jGx.get(Integer.valueOf(lVar.id));
                            if (aVar != null) {
                                aVar.a(context, pVar, nVar, str);
                            }
                        }
                    }
                }
            }
        };
        this.jIJ.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int lq = com.tencent.mm.plugin.appbrand.menu.m.lq(menuItem.getItemId());
                if (lq != 0) {
                    Object obj;
                    l d = com.tencent.mm.plugin.appbrand.menu.n.d(m.this.jIK, lq - 1);
                    Context context = m.this.jfF.mContext;
                    p pVar = m.this.jfF;
                    String str = m.this.mAppId;
                    if (d == null) {
                        obj = null;
                    } else {
                        a aVar = (a) a.jGy.jGx.get(Integer.valueOf(d.id));
                        if (aVar == null) {
                            obj = null;
                        } else {
                            aVar.a(context, pVar, str, d);
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        m.this.jIJ.bxR();
                    }
                }
            }
        };
        if (this.jfF.jJD) {
            g gVar = this.jIJ;
            int parseColor = Color.parseColor("#000000");
            if (gVar.lHV != null) {
                gVar.lHV.setBackgroundColor(parseColor);
            }
            gVar.zCj = Boolean.valueOf((((0.299d * ((double) Color.red(parseColor))) + (0.587d * ((double) Color.green(parseColor)))) + (0.114d * ((double) Color.blue(parseColor)))) / 255.0d <= 0.7d);
            if (gVar.zCj.booleanValue() && gVar.zCr != null) {
                gVar.zCr.setImageDrawable(gVar.mContext.getResources().getDrawable(b.zHU));
            }
        }
        this.jIJ.tMI = this.jfF.jJy;
        if (this.jfF.iuk.YI()) {
            this.jIJ.tMJ = this.jfF.jJy;
        }
        this.jIJ.bUX();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.q.a() {
                public final void onActivityPaused(Activity activity) {
                    if (activity == context) {
                        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                        if (m.this.jIJ != null && m.this.jIJ.isShowing()) {
                            m.this.jIJ.bxR();
                        }
                    }
                }
            });
        }
    }
}
