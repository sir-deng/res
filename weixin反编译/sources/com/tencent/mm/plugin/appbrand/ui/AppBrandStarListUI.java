package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppBrandStarListUI extends DrawStatusBarActivity {
    private Dialog jRG = null;

    public static final class a extends Fragment {
        private View jRH;
        private RecyclerView jRI;
        private e jRJ;
        private GridLayoutManager jRK;
        private View jRL;
        private TextView jRM;
        boolean jRN = false;
        final ArrayList<k> jRO = new ArrayList(10);
        private final com.tencent.mm.sdk.e.j.a jRP = new com.tencent.mm.sdk.e.j.a() {
            public final void a(String str, l lVar) {
                if (2 == lVar.jcn || 3 == lVar.jcn) {
                    final List jI = com.tencent.mm.plugin.appbrand.app.e.Zy().jI(com.tencent.mm.plugin.appbrand.appusage.l.b.iMX);
                    if (a.this.getActivity() != null) {
                        a.this.getActivity().runOnUiThread(new Runnable() {
                            public final void run() {
                                if (a.this.getActivity() != null) {
                                    if (bi.cC(jI)) {
                                        AppBrandStarListUI.a((AppBrandStarListUI) a.this.getActivity());
                                        return;
                                    }
                                    a aVar = a.this;
                                    Collection collection = jI;
                                    aVar.jRO.clear();
                                    aVar.jRO.addAll(collection);
                                    aVar.a(c.NEW_DATA);
                                    aVar.alv();
                                }
                            }
                        });
                    }
                }
            }
        };
        private c jRQ = c.NEW_DATA;

        private static final class a extends android.support.v7.widget.RecyclerView.e.c {
            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        private enum c {
            SWITCH_TO_DELETE("enter_delete_mode_tag"),
            SWITCH_TO_NORMAL("exit_delete_mode_tag"),
            NEW_DATA(null);
            
            final Object tag;

            private c(Object obj) {
                this.tag = obj;
            }
        }

        final class f extends t implements OnClickListener, OnLongClickListener {
            k jSf;
            ImageView jSg;
            TextView jSh;
            TextView jSi;
            View jSj;

            f(View view) {
                super(view);
                this.jSg = (ImageView) view.findViewById(g.icon);
                this.jSh = (TextView) view.findViewById(g.name);
                this.jSi = (TextView) view.findViewById(g.iyW);
                this.jSj = view.findViewById(g.ixE);
                this.jSj.setOnClickListener(this);
                this.VU.setOnClickListener(this);
                this.VU.setOnLongClickListener(this);
            }

            public final void onClick(View view) {
                if (this.jSf != null) {
                    if (a.this.jRN && view == this.jSj) {
                        final String str = this.jSf.foe;
                        final int i = this.jSf.iIZ;
                        final int gf = gf();
                        com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                            public final void run() {
                                com.tencent.mm.plugin.appbrand.app.e.Zy().h(str, i, true);
                                if (a.this.getActivity() != null) {
                                    a.this.getActivity().runOnUiThread(new Runnable() {
                                        public final void run() {
                                            a.this.jRO.remove(gf);
                                            if (a.this.jRJ != null) {
                                                a.this.jRJ.bl(gf);
                                                a.this.alv();
                                                if (bi.cC(a.this.jRO)) {
                                                    AppBrandStarListUI.a((AppBrandStarListUI) a.this.getActivity());
                                                }
                                            }
                                        }
                                    });
                                }
                                com.tencent.mm.plugin.appbrand.report.a.a(f.this.jSf.appId, f.this.jSf.iIZ + 1, 4, 2, "");
                            }
                        });
                    }
                    if (!a.this.jRN && view == this.VU) {
                        k kVar = this.jSf;
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1003;
                        AppBrandLaunchProxyUI.a(a.this.getActivity(), kVar.foe, null, kVar.iIZ, -1, appBrandStatObject, null);
                    }
                }
            }

            public final boolean onLongClick(View view) {
                if (a.this.jRN) {
                    return false;
                }
                a.g(a.this);
                return true;
            }
        }

        private static final class b extends android.support.v7.widget.RecyclerView.e.c {
            private b() {
            }

            /* synthetic */ b(byte b) {
                this();
            }
        }

        final class d extends RecyclerView.g {
            d() {
            }

            public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
                rect.top = 0;
                rect.right = 0;
                rect.left = 0;
                if (recyclerView.aP(view).gf() >= (a.this.jRJ.getItemCount() / a.this.jRK.Rw) * a.this.jRK.Rw) {
                    rect.bottom = 0;
                } else {
                    rect.bottom = a.this.getResources().getDimensionPixelSize(com.tencent.mm.plugin.appbrand.q.e.ivk);
                }
            }
        }

        final class e extends android.support.v7.widget.RecyclerView.a<f> {
            e() {
            }

            public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
                return new f(LayoutInflater.from(viewGroup.getContext()).inflate(h.izM, viewGroup, false));
            }

            public final /* synthetic */ void a(t tVar, int i) {
                float f = 1.0f;
                f fVar = (f) tVar;
                k kVar = (k) a.this.jRO.get(i);
                fVar.jSf = kVar;
                fVar.jSh.setText(kVar.appName);
                com.tencent.mm.modelappbrand.a.b.Jp().a(fVar.jSg, kVar.iMO, com.tencent.mm.modelappbrand.a.a.Jo(), com.tencent.mm.modelappbrand.a.f.hmb);
                fVar.jSj.setVisibility(fVar.jRR.jRN ? 0 : 8);
                fVar.jSg.setScaleX(fVar.jRR.jRN ? 1.0f : 0.9f);
                ImageView imageView = fVar.jSg;
                if (!fVar.jRR.jRN) {
                    f = 0.9f;
                }
                imageView.setScaleY(f);
                CharSequence jx = com.tencent.mm.plugin.appbrand.appcache.a.jx(kVar.iIZ);
                if (bi.oN(jx)) {
                    fVar.jSi.setVisibility(8);
                    return;
                }
                fVar.jSi.setText(jx);
                fVar.jSi.setVisibility(0);
            }

            public final /* synthetic */ void a(t tVar, int i, List list) {
                f fVar = (f) tVar;
                if (list == null || list.size() != 1 || (!"enter_delete_mode_tag".equals(list.get(0)) && !"exit_delete_mode_tag".equals(list.get(0)))) {
                    super.a(fVar, i, list);
                }
            }

            public final int getItemCount() {
                return a.this.jRO.size();
            }
        }

        static /* synthetic */ void b(a aVar) {
            if (aVar.jRH != null && aVar.jRK != null) {
                int width = aVar.jRH.getWidth() / com.tencent.mm.bu.a.aa(aVar.getActivity(), com.tencent.mm.plugin.appbrand.q.e.ivj);
                if (width != aVar.jRK.Rw) {
                    aVar.jRK.aZ(width);
                    aVar.jRK.requestLayout();
                }
            }
        }

        static /* synthetic */ void g(a aVar) {
            aVar.jRN = true;
            aVar.jRH.post(new Runnable() {
                public final void run() {
                    a.this.a(c.SWITCH_TO_DELETE);
                }
            });
        }

        final void a(c cVar) {
            this.jRQ = cVar;
            if (this.jRJ != null) {
                this.jRJ.b(0, this.jRO.size(), cVar.tag);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.jRH = layoutInflater.inflate(h.izN, null);
            this.jRI = (RecyclerView) this.jRH.findViewById(g.iyV);
            getActivity();
            this.jRK = new GridLayoutManager();
            this.jRJ = new e();
            this.jRI.a(new d());
            this.jRI.a(new v() {
                final Map<t, ViewPropertyAnimator> jRU = new HashMap();
                final Map<t, ViewPropertyAnimator> jRV = new HashMap();

                static /* synthetic */ void a(AnonymousClass3 anonymousClass3, t tVar) {
                    if (!anonymousClass3.jRU.containsKey(tVar) && !anonymousClass3.jRV.containsKey(tVar)) {
                        anonymousClass3.k(tVar);
                    }
                }

                public final boolean a(t tVar, final t tVar2, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
                    if (tVar2 != null) {
                        if (this.jRU.containsKey(tVar2)) {
                            ((ViewPropertyAnimator) this.jRU.remove(tVar2)).cancel();
                        }
                        if (this.jRV.containsKey(tVar2)) {
                            ((ViewPropertyAnimator) this.jRV.remove(tVar2)).cancel();
                        }
                    }
                    f fVar;
                    ViewPropertyAnimator withEndAction;
                    ViewPropertyAnimator withEndAction2;
                    if (cVar instanceof a) {
                        fVar = (f) tVar2;
                        fVar.jSj.setAlpha(0.0f);
                        fVar.jSj.setVisibility(0);
                        withEndAction = fVar.jSj.animate().setDuration(200).alpha(1.0f).withEndAction(new Runnable() {
                            public final void run() {
                                AnonymousClass3.this.jRU.remove(tVar2);
                                AnonymousClass3.a(AnonymousClass3.this, tVar2);
                            }
                        });
                        this.jRU.put(tVar2, withEndAction);
                        withEndAction.start();
                        withEndAction2 = fVar.jSg.animate().setDuration(200).scaleX(1.0f).scaleY(1.0f).withEndAction(new Runnable() {
                            public final void run() {
                                AnonymousClass3.this.jRV.remove(tVar2);
                                AnonymousClass3.a(AnonymousClass3.this, tVar2);
                            }
                        });
                        this.jRV.put(tVar2, withEndAction2);
                        withEndAction2.start();
                        return false;
                    } else if (!(cVar instanceof b)) {
                        return super.a(tVar, tVar2, cVar, cVar2);
                    } else {
                        fVar = (f) tVar2;
                        withEndAction = fVar.jSj.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                            public final void run() {
                                fVar.jSj.setVisibility(8);
                                AnonymousClass3.this.jRU.remove(tVar2);
                                AnonymousClass3.a(AnonymousClass3.this, tVar2);
                            }
                        });
                        this.jRU.put(tVar2, withEndAction);
                        withEndAction.start();
                        withEndAction2 = fVar.jSg.animate().setDuration(200).scaleX(0.9f).scaleY(0.9f).withEndAction(new Runnable() {
                            public final void run() {
                                AnonymousClass3.this.jRV.remove(tVar2);
                                AnonymousClass3.a(AnonymousClass3.this, tVar2);
                            }
                        });
                        this.jRV.put(tVar2, withEndAction2);
                        withEndAction2.start();
                        return false;
                    }
                }

                public final android.support.v7.widget.RecyclerView.e.c a(q qVar, t tVar, int i, List<Object> list) {
                    if (2 == i) {
                        for (Object next : list) {
                            if ("enter_delete_mode_tag".equals(next)) {
                                return new a().b(tVar, 0);
                            }
                            if ("exit_delete_mode_tag".equals(next)) {
                                return new b().b(tVar, 0);
                            }
                        }
                    }
                    return super.a(qVar, tVar, i, (List) list);
                }

                public final boolean a(t tVar, List<Object> list) {
                    return true;
                }
            });
            this.jRI.a(this.jRK);
            this.jRI.a(this.jRJ);
            this.jRL = this.jRH.findViewById(g.iyT);
            this.jRM = (TextView) this.jRH.findViewById(g.iyU);
            this.jRH.post(new Runnable() {
                public final void run() {
                    a.this.alv();
                    a.b(a.this);
                }
            });
            com.tencent.mm.plugin.appbrand.app.e.Zy().a(this.jRP, com.tencent.mm.plugin.appbrand.r.c.Dt().oFY.getLooper());
            return this.jRH;
        }

        public final void onDestroyView() {
            super.onDestroyView();
            com.tencent.mm.plugin.appbrand.app.e.Zy().j(this.jRP);
            try {
                for (Field field : getClass().getFields()) {
                    if (field.isAccessible()) {
                        field.set(this, null);
                    }
                }
            } catch (Exception e) {
            }
        }

        public final void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            if (this.jRH != null) {
                final ViewTreeObserver viewTreeObserver = this.jRH.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                        int jRZ = 0;

                        public final void onGlobalLayout() {
                            int i = this.jRZ + 1;
                            this.jRZ = i;
                            if (i >= 2) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                                a.b(a.this);
                            }
                        }
                    });
                }
            }
        }

        void alv() {
            if (this.jRM != null && this.jRL != null) {
                if (this.jRO.size() >= 10) {
                    this.jRL.setVisibility(0);
                    this.jRM.setText(getResources().getString(j.iDN, new Object[]{Integer.valueOf(10)}));
                    return;
                }
                this.jRL.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void a(AppBrandStarListUI appBrandStarListUI) {
        Fragment N = appBrandStarListUI.getSupportFragmentManager().N(16908290);
        if (N == null || !(N instanceof c)) {
            appBrandStarListUI.getSupportFragmentManager().aT().b(16908290, c.bI(appBrandStarListUI.getString(j.iDO), appBrandStarListUI.getString(j.iDM))).commit();
            if (appBrandStarListUI.jRG != null) {
                appBrandStarListUI.jRG.dismiss();
            }
            appBrandStarListUI.jRG = null;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -1052684;
        }
        if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jQu;
        }
        return super.getStatusBarColor();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onBackPressed() {
        Fragment N = getSupportFragmentManager().N(16908290);
        if (N != null && (N instanceof a)) {
            boolean z;
            a aVar = (a) N;
            if (aVar.jRN) {
                aVar.jRN = false;
                aVar.a(c.SWITCH_TO_NORMAL);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
        super.onBackPressed();
    }
}
