package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.AnonymousClass2;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAppBrandRecentView extends AppBrandRecentView implements com.tencent.mm.sdk.e.j.a {
    private float YR;
    private float YS;
    protected float kkZ;
    com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a kla;
    private List<a> klb;
    private c klc;
    private a kld;
    e kle = new e();
    private float klf = 1.0f;
    private boolean klg = false;
    private Context mContext;

    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(BaseAppBrandRecentView baseAppBrandRecentView, byte b) {
            this();
        }

        public final void run() {
            u uVar = (u) g.h(u.class);
            BaseAppBrandRecentView.this.aoE();
            List<LocalUsageInfo> jH = uVar.jH(12);
            BaseAppBrandRecentView.this.aoF().clear();
            if (jH != null) {
                LocalUsageInfo ajJ = BaseAppBrandRecentView.this.kkP != null ? BaseAppBrandRecentView.this.kkP.ajJ() : null;
                for (LocalUsageInfo localUsageInfo : jH) {
                    if (ajJ == null || !localUsageInfo.username.equals(ajJ.username) || localUsageInfo.iNi != ajJ.iNi) {
                        BaseAppBrandRecentView.this.aoF().add(new a(localUsageInfo));
                        if (BaseAppBrandRecentView.this.aoF().size() > BaseAppBrandRecentView.this.aoE()) {
                            break;
                        }
                    }
                }
            }
            BaseAppBrandRecentView.this.ah(BaseAppBrandRecentView.this.aoF());
            x.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s data size:%s", BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.this.aoF().size()));
            ah.y(new Runnable() {
                public final void run() {
                    if (BaseAppBrandRecentView.this.kkO != null) {
                        BaseAppBrandRecentView.this.kkO.mK(BaseAppBrandRecentView.this.aoF().size());
                    }
                    BaseAppBrandRecentView.this.fn().UR.notifyChanged();
                }
            });
        }
    }

    protected class a extends android.support.v7.widget.RecyclerView.a<b> {
        com.tencent.mm.ap.a.a.c.a klh;

        /* synthetic */ a(BaseAppBrandRecentView baseAppBrandRecentView, byte b) {
            this();
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            return new b(v.fw(BaseAppBrandRecentView.this.mContext).inflate(com.tencent.mm.plugin.appbrand.widget.k.c.kaT, viewGroup, false));
        }

        public final /* synthetic */ void a(t tVar, int i) {
            b bVar = (b) tVar;
            bVar.klk.setVisibility(8);
            if (i < BaseAppBrandRecentView.this.aoF().size()) {
                bVar.VU.setVisibility(0);
                a aVar = (a) BaseAppBrandRecentView.this.aoF().get(i);
                aVar.position = i;
                bVar.VU.setTag(aVar);
                if (!(aVar.kkN == null || bi.oN(com.tencent.mm.plugin.appbrand.appcache.a.jx(aVar.kkN.iNi)))) {
                    bVar.klk.setVisibility(0);
                    bVar.klk.setText(com.tencent.mm.plugin.appbrand.appcache.a.jx(aVar.kkN.iNi));
                }
                BaseAppBrandRecentView.this.a(bVar, aVar);
                return;
            }
            bVar.VU.setVisibility(4);
        }

        private a() {
            this.klh = new com.tencent.mm.ap.a.a.c.a();
            this.klh.hFA = d.bBC;
        }

        public final int getItemCount() {
            if (BaseAppBrandRecentView.this.aoF().size() % 4 != 0) {
                return BaseAppBrandRecentView.this.aoF().size() + (4 - (BaseAppBrandRecentView.this.aoF().size() % 4));
            }
            return BaseAppBrandRecentView.this.aoF().size();
        }
    }

    protected class b extends t {
        protected View VU;
        protected TextView ikn;
        protected ImageView jIs;
        protected ImageView klj;
        protected TextView klk;

        public b(View view) {
            super(view);
            this.VU = view;
            view.setOnClickListener(new OnClickListener(BaseAppBrandRecentView.this) {
                public final void onClick(View view) {
                    a aVar = (a) view.getTag();
                    aVar.position = b.this.gf();
                    if (BaseAppBrandRecentView.this.kla != null) {
                        BaseAppBrandRecentView.this.kla.a(view, aVar, BaseAppBrandRecentView.this.YR, BaseAppBrandRecentView.this.YS);
                    }
                    BaseAppBrandRecentView.this.fn().UR.notifyChanged();
                }
            });
            view.setOnLongClickListener(new OnLongClickListener(BaseAppBrandRecentView.this) {
                public final boolean onLongClick(View view) {
                    a aVar = (a) view.getTag();
                    aVar.position = b.this.gf();
                    if (BaseAppBrandRecentView.this.kla != null) {
                        BaseAppBrandRecentView.this.kla.b(view, aVar, BaseAppBrandRecentView.this.YR, BaseAppBrandRecentView.this.YS);
                    }
                    BaseAppBrandRecentView.this.klg = true;
                    return true;
                }
            });
            view.getLayoutParams().width = BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.jIs = (ImageView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.icon);
            this.klj = (ImageView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.kaR);
            this.ikn = (TextView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.title);
            this.klk = (TextView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.kaS);
        }
    }

    protected abstract int aoE();

    protected abstract String getType();

    public BaseAppBrandRecentView(Context context) {
        super(context);
        init(context);
    }

    public BaseAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    protected void init(Context context) {
        this.mContext = context;
        this.kkZ = context.getResources().getDimension(com.tencent.mm.plugin.appbrand.widget.k.a.buJ);
        if (g.h(u.class) != null) {
            ((u) g.h(u.class)).c(this);
        } else {
            x.e("MicroMsg.BaseAppBrandRecentView", "[init] IAppBrandLocalUsageStorage get null!");
        }
        h linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        a(linearLayoutManager);
        android.support.v7.widget.RecyclerView.a aVar = new a();
        this.kld = aVar;
        a(aVar);
        k kVar = this.kle;
        kVar.Va = this;
        kVar.klA = 4;
        kVar.Va.a(kVar);
        kVar.Vb = new AnonymousClass1(kVar.Va.getContext());
        kVar.klz = new AnonymousClass2(kVar.Va.getContext());
    }

    public final boolean Q(int i, int i2) {
        e eVar = this.kle;
        int mL = eVar.mL(eVar.klx + i);
        if (eVar.Va != null && eVar.klD) {
            eVar.klz.Vv = mL;
            eVar.Va.TV.a(eVar.klz);
        }
        return super.Q(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.YR = motionEvent.getRawX();
            this.YS = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2 && this.klg) {
            return true;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.klg = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean canScrollHorizontally(int i) {
        return true;
    }

    public void a(com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a aVar) {
        this.kla = aVar;
    }

    public final void refresh() {
        if (this.klc != null) {
            e.remove(this.klc);
        }
        Runnable cVar = new c();
        this.klc = cVar;
        e.post(cVar, "MicroMsg.BaseAppBrandRecentView");
    }

    public final void release() {
        if (g.h(u.class) != null) {
            ((u) g.h(u.class)).j(this);
        } else {
            x.e("MicroMsg.BaseAppBrandRecentView", "[release] IAppBrandLocalUsageStorage get null!");
        }
        if (this.klc != null) {
            e.remove(this.klc);
        }
        aoF().clear();
    }

    public void ah(List<a> list) {
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s", ((com.tencent.mm.kernel.b.h) g.Dn().CU()).toString(), Integer.valueOf(lVar.jcn));
        if (lVar.jcn == 5 && aoD()) {
            x.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
        } else {
            refresh();
        }
    }

    protected boolean aoD() {
        return false;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.BaseAppBrandRecentView", "[onConfigurationChanged] orientation:%s", Integer.valueOf(configuration.orientation));
        if (this.klf != ((float) configuration.orientation)) {
            this.kld.UR.notifyChanged();
        }
        this.klf = (float) configuration.orientation;
    }

    public final android.support.v7.widget.RecyclerView.a fn() {
        return this.kld;
    }

    protected void a(b bVar, a aVar) {
        int width = getWidth() / 4;
        if (width <= 0) {
            width = getResources().getDisplayMetrics().widthPixels / 4;
        }
        bVar.VU.getLayoutParams().width = width;
        if (aVar.kkN != null && aVar.type == 1) {
            if (bi.oN(aVar.kkN.fqG)) {
                bVar.jIs.setImageResource(d.bBC);
                return;
            }
            bVar.klj.setVisibility(0);
            bVar.ikn.setVisibility(0);
            bVar.ikn.setText(vO(aVar.kkN.fqG));
            com.tencent.mm.modelappbrand.a.b.Jp().a(bVar.jIs, aVar.kkN.iNr, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
        }
    }

    private static String vO(String str) {
        int i = 0;
        if (str == null) {
            return str;
        }
        try {
            if (com.tencent.mm.ui.tools.h.aaF(str) <= 12) {
                return str;
            }
            char[] toCharArray = str.toCharArray();
            int length = toCharArray.length;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                i3 += com.tencent.mm.ui.tools.h.aaF(String.valueOf(toCharArray[i]));
                if (i3 >= 12) {
                    return str.substring(0, i2) + 8230;
                }
                i2++;
                i++;
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    public final int getCount() {
        return aoF().size();
    }

    protected final List<a> aoF() {
        if (this.klb == null) {
            this.klb = new ArrayList();
        }
        return this.klb;
    }
}
