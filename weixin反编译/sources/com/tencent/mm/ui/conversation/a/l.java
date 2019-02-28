package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.m.AnonymousClass5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l extends com.tencent.mm.pluginsdk.ui.b.b implements com.tencent.mm.modelvideo.s.a {
    ViewGroup mContainer;
    Map<String, Long> zjZ = new HashMap();
    Map<Long, b> zka = new HashMap();

    private static final class a implements Runnable {
        WeakReference<l> zkb;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            List Us = o.Ub().Us();
            List Ut = o.Ub().Ut();
            l lVar = (l) this.zkb.get();
            if (lVar == null) {
                x.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
                return;
            }
            x.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", Integer.valueOf(lVar.mContainer.getChildCount()), Integer.valueOf(Us.size()), Integer.valueOf(Ut.size()));
            if (lVar.mContainer.getChildCount() != 0 || !Us.isEmpty() || !Ut.isEmpty()) {
                Runnable cVar = new c();
                cVar.zkb = new WeakReference(this.zkb.get());
                cVar.zkk = Us;
                cVar.zkl = Ut;
                ah.y(cVar);
            }
        }
    }

    private static final class b {
        ProgressBar lvk;
        long zkc;
        boolean zkd;
        View zke;
        com.tencent.mm.plugin.sight.decode.a.a zkf;
        ImageView zkg;
        TextView zkh;
        ImageButton zki;

        private b() {
            this.zkc = 0;
            this.zkd = false;
            this.zke = null;
            this.zkf = null;
            this.zkg = null;
            this.zkh = null;
            this.lvk = null;
            this.zki = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class c implements Runnable {
        WeakReference<l> zkb;
        List<r> zkk;
        List<r> zkl;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        private static int a(String str, l lVar, List<r> list, int i, int i2, int i3) {
            for (r rVar : list) {
                lVar.zjZ.put(rVar.getFileName(), Long.valueOf(rVar.hVO));
                if (lVar.zka.containsKey(Long.valueOf(rVar.hVO))) {
                    x.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", str, Long.valueOf(rVar.hVO), rVar.getFileName());
                } else {
                    View view;
                    b bVar;
                    View inflate;
                    if (i < i2) {
                        x.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(lVar.mContainer.getChildAt(i).hashCode()), Long.valueOf(rVar.hVO));
                        i = r2;
                        view = inflate;
                    } else {
                        inflate = LayoutInflater.from(lVar.mContainer.getContext()).inflate(R.i.dnn, lVar.mContainer, false);
                        lVar.mContainer.addView(inflate);
                        x.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(rVar.hVO));
                        view = inflate;
                    }
                    b bVar2 = (b) view.getTag();
                    if (bVar2 == null) {
                        bVar = new b();
                    } else {
                        bVar = bVar2;
                    }
                    if (bVar.zkc != rVar.hVO) {
                        x.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", Long.valueOf(bVar.zkc), Long.valueOf(rVar.hVO), Integer.valueOf(i3));
                        bVar.zkc = rVar.hVO;
                        bVar.zke = view;
                        bVar.zkf = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.h.cpC);
                        bVar.zkg = (ImageView) view.findViewById(R.h.cPy);
                        bVar.lvk = (ProgressBar) view.findViewById(R.h.progress);
                        bVar.zki = (ImageButton) view.findViewById(R.h.bPp);
                        bVar.zkh = (TextView) view.findViewById(R.h.cpQ);
                        bVar.zkf.wB(view.getResources().getDimensionPixelSize(R.f.bvE));
                        bVar.zke.setTag(bVar);
                        bVar.zki.setTag(Long.valueOf(bVar.zkc));
                        bVar.zke.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                b bVar = (b) view.getTag();
                                x.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", Long.valueOf(bVar.zkc), Boolean.valueOf(bVar.zkd));
                                if (bVar.zkd) {
                                    t.bv(bVar.zkc);
                                }
                            }
                        });
                        bVar.zki.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                x.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", Long.valueOf(((Long) view.getTag()).longValue()));
                                g.Dt().F(new AnonymousClass5(r0));
                            }
                        });
                    } else {
                        x.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", Long.valueOf(bVar.zkc), Integer.valueOf(i3));
                    }
                    o.Ub();
                    String nx = s.nx(rVar.getFileName());
                    o.Ub();
                    bVar.zkf.B(com.tencent.mm.ap.o.PC().a(s.ny(rVar.getFileName()), com.tencent.mm.bu.a.getDensity(view.getContext()), view.getContext()));
                    if (i3 > 3) {
                        bVar.zkf.clear();
                        bVar.zkg.setVisibility(0);
                    } else {
                        bVar.zkf.aA(nx, false);
                        bVar.zkg.setVisibility(8);
                    }
                    a(bVar, rVar);
                    lVar.zka.put(Long.valueOf(rVar.hVO), bVar);
                }
            }
            return i;
        }

        public static void a(b bVar, r rVar) {
            boolean z = true;
            x.v("MicroMsg.MassSightBanner", "info status %d", Integer.valueOf(rVar.status));
            if (rVar.status == bc.CTRL_INDEX || rVar.status == 197 || rVar.status == 196) {
                bVar.lvk.setVisibility(4);
                bVar.zkh.setVisibility(0);
                bVar.zki.setEnabled(true);
                bVar.zkd = true;
                return;
            }
            float f = ((float) rVar.hWd) / ((float) rVar.hmZ);
            bVar.lvk.setVisibility(0);
            bVar.zkh.setVisibility(4);
            bVar.lvk.setProgress((int) (((float) bVar.lvk.getMax()) * f));
            ImageButton imageButton = bVar.zki;
            if (Float.compare(0.99f, f) <= 0) {
                z = false;
            }
            imageButton.setEnabled(z);
            bVar.zkd = false;
        }

        public final void run() {
            l lVar = (l) this.zkb.get();
            if (lVar == null) {
                x.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
                return;
            }
            int childCount = lVar.mContainer.getChildCount();
            lVar.zka.clear();
            Set hashSet = new HashSet();
            for (r rVar : this.zkk) {
                hashSet.add(Long.valueOf(rVar.hVO));
            }
            for (r rVar2 : this.zkl) {
                hashSet.add(Long.valueOf(rVar2.hVO));
            }
            int size = hashSet.size();
            int a = a("update fail", lVar, this.zkl, a("update unfinish", lVar, this.zkk, 0, childCount, size), childCount, size);
            for (int i = a; i < childCount; i++) {
                lVar.mContainer.removeViewAt(a);
            }
        }
    }

    public l(Context context) {
        super(context);
        o.Ub().a(this, Looper.getMainLooper());
        this.mContainer = (ViewGroup) this.view;
    }

    public final int getLayoutId() {
        return R.i.dnm;
    }

    public final void destroy() {
        o.Ub().a((com.tencent.mm.modelvideo.s.a) this);
    }

    private void alq() {
        x.i("MicroMsg.MassSightBanner", "call update status");
        Runnable aVar = new a();
        aVar.zkb = new WeakReference(this);
        as.Dt().F(aVar);
    }

    public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
        String str = aVar.fileName;
        Long l = (Long) this.zjZ.get(str);
        if (l == null) {
            x.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", str);
            if (bi.aD(str, "").startsWith("DELETE_")) {
                alq();
                return;
            }
            return;
        }
        b bVar = (b) this.zka.get(l);
        if (bVar == null) {
            x.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", l);
            return;
        }
        r nJ = t.nJ(str);
        if (nJ == null) {
            x.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", str, l);
        } else if (nJ.status == 199) {
            x.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", str, l);
            alq();
        } else {
            c.a(bVar, nJ);
        }
    }
}
