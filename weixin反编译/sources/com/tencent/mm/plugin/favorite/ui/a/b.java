package com.tencent.mm.plugin.favorite.ui.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a;
import com.tencent.mm.plugin.favorite.ui.b.d;
import com.tencent.mm.plugin.favorite.ui.b.g;
import com.tencent.mm.plugin.favorite.ui.b.i;
import com.tencent.mm.plugin.favorite.ui.b.j;
import com.tencent.mm.plugin.favorite.ui.b.k;
import com.tencent.mm.plugin.favorite.ui.b.l;
import com.tencent.mm.plugin.favorite.ui.b.m;
import com.tencent.mm.plugin.favorite.ui.b.n;
import com.tencent.mm.plugin.favorite.ui.b.o;
import com.tencent.mm.plugin.favorite.ui.b.p;
import com.tencent.mm.plugin.favorite.ui.b.q;
import com.tencent.mm.plugin.favorite.ui.b.r;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    private c jil;
    public boolean mAa;
    private Map<Long, f> mAb;
    private List<Integer> mAc;
    private List<String> mAd;
    private List<String> mAe;
    private SparseArray<a> mAf;
    private boolean mAg;
    public a.c mAh;
    public boolean mAi;
    public boolean mAj;
    public ListView mAk;
    private int mtU;
    private boolean mzV;
    public List<f> mzW;
    private List<f> mzX;
    private List<f> mzY;
    public List<Long> mzZ;
    public int scene;

    public final /* synthetic */ Object getItem(int i) {
        return qe(i);
    }

    public b(h hVar, boolean z) {
        this.mzV = false;
        this.mzW = new ArrayList();
        this.mzX = new ArrayList();
        this.mzY = new LinkedList();
        this.mzZ = new ArrayList();
        this.mAa = false;
        this.mAb = new TreeMap();
        this.mAc = new ArrayList();
        this.mAd = new LinkedList();
        this.mAe = new LinkedList();
        this.mAf = new SparseArray();
        this.mAg = false;
        this.mAi = false;
        this.mAj = false;
        this.jil = new c<jt>() {
            {
                this.xmG = jt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jt jtVar = (jt) bVar;
                if (jtVar instanceof jt) {
                    switch (jtVar.fBu.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            b.this.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.type = -1;
        this.mAf.put(1, new n(hVar));
        this.mAf.put(2, new d(hVar));
        this.mAf.put(3, new r(hVar));
        this.mAf.put(4, new q(hVar));
        this.mAf.put(5, new p(hVar));
        this.mAf.put(6, new com.tencent.mm.plugin.favorite.ui.b.f(hVar));
        this.mAf.put(7, new com.tencent.mm.plugin.favorite.ui.b.h(hVar));
        this.mAf.put(8, new com.tencent.mm.plugin.favorite.ui.b.c(hVar));
        this.mAf.put(10, new j(hVar));
        this.mAf.put(12, new m(hVar));
        this.mAf.put(15, new m(hVar));
        this.mAf.put(11, new g(hVar));
        this.mAf.put(14, new k(hVar));
        this.mAf.put(16, new l(hVar));
        this.mAf.put(17, new com.tencent.mm.plugin.favorite.ui.b.b(hVar));
        this.mAf.put(18, new i(hVar));
        this.mAf.put(-2, new o(hVar));
        if (z != this.mAi) {
            this.mAi = z;
            if (z) {
                this.mAb.clear();
            }
        }
        if (!this.mAi) {
            aKa();
        }
        aKb();
        notifyDataSetChanged();
        com.tencent.mm.sdk.b.a.xmy.c(this.jil);
        com.tencent.mm.sdk.b.a.xmy.b(this.jil);
    }

    public final void finish() {
        com.tencent.mm.sdk.b.a.xmy.c(this.jil);
    }

    private void qd(int i) {
        int i2 = this.mtU;
        if (i == 0) {
            this.mtU = 0;
        } else if (i2 == 0) {
            this.mtU = i;
        } else if (i2 != i) {
            this.mtU = 4;
        }
    }

    public final void aKa() {
        if (aKc()) {
            x.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
        } else if (com.tencent.mm.plugin.favorite.a.j.aJo()) {
            x.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
        } else if (this.mAi) {
            this.mzX = com.tencent.mm.plugin.favorite.a.j.f(this.mzW, this.mzZ);
            this.mzV = true;
        } else {
            try {
                this.lastUpdateTime = com.tencent.mm.plugin.favorite.a.j.s(this.lastUpdateTime, this.type);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FavoriteAdapter", e, "", new Object[0]);
            }
        }
    }

    private boolean aKc() {
        return (this.mAd.isEmpty() && this.mAe.isEmpty() && this.mAc.isEmpty()) ? false : true;
    }

    public final void a(boolean z, f fVar) {
        if (z != this.mAa) {
            this.mAa = z;
            if (z) {
                this.mAb.clear();
                if (fVar != null) {
                    f dc = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().dc(fVar.field_localId);
                    if (dc != null) {
                        this.mAb.put(Long.valueOf(dc.field_localId), dc);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public final List<f> fg(boolean z) {
        List<f> linkedList = new LinkedList();
        for (f fVar : this.mAb.values()) {
            if (fVar != null) {
                linkedList.add(fVar);
            }
        }
        if (z) {
            this.mAb.clear();
        }
        return linkedList;
    }

    public final int aKd() {
        return this.mAb.size();
    }

    public final long aKe() {
        long j = 0;
        Iterator it = this.mAb.values().iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            f fVar = (f) it.next();
            if (fVar != null) {
                j = fVar.field_datatotalsize + j2;
            } else {
                j = j2;
            }
        }
    }

    public final void c(List<Integer> list, List<String> list2, List<String> list3) {
        qd(0);
        this.mAc.clear();
        if (list != null) {
            this.mAc.addAll(list);
            if (!list.isEmpty()) {
                qd(2);
            }
        }
        this.mAd.clear();
        if (list2 != null) {
            this.mAd.addAll(list2);
            if (!list2.isEmpty()) {
                qd(3);
            }
        }
        this.mAe.clear();
        if (list3 != null) {
            this.mAe.addAll(list3);
            if (!list3.isEmpty()) {
                qd(1);
            }
        }
        this.mAg = true;
        aKb();
        this.mAg = false;
    }

    public final void aKb() {
        x.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.mzV = false;
        List list = this.mzX;
        if (list != null) {
            x.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", Integer.valueOf(list.size()));
            x.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", Integer.valueOf(this.mzY.size()));
            list.clear();
        }
        if (aKc()) {
            x.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", this.mAd, this.mAe, this.mAc);
            this.mzX = com.tencent.mm.plugin.favorite.a.j.a(this.mAd, this.mAe, this.mAc, this.mzY, this.mzS, this.mzT);
            int size = this.mzX == null ? 0 : this.mzX.size();
            com.tencent.mm.plugin.report.service.g.pWK.h(10649, Integer.valueOf(size));
        } else {
            x.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type));
            if (this.mAi) {
                qd(0);
                this.mzZ = com.tencent.mm.plugin.favorite.a.j.aJx();
                this.mzX = com.tencent.mm.plugin.favorite.a.j.f(null, this.mzZ);
            } else {
                this.mzX = com.tencent.mm.plugin.favorite.a.j.b(this.lastUpdateTime, this.type, this.mzS, this.mzT);
                if (this.mzX != null && this.lastUpdateTime == 0 && this.mzX.size() > 0) {
                    this.lastUpdateTime = ((f) this.mzX.get(this.mzX.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.mzX == null) {
            x.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.mzX = new ArrayList();
        }
        if (!(this.mAi || aKc() || this.mzX.size() >= 20 || com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().q(this.lastUpdateTime, this.type))) {
            x.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            aKa();
        }
        this.mzV = true;
        x.v("MicroMsg.FavoriteAdapter", "reset data list end");
    }

    public final boolean isEmpty() {
        return this.mzW.isEmpty();
    }

    public final void notifyDataSetChanged() {
        x.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", Boolean.valueOf(this.mzV));
        if (this.mzV) {
            if (this.mAi && this.mzX != null && this.mzW != null && this.mzX.size() == this.mzW.size()) {
                this.mAj = true;
            }
            List list = this.mzW;
            this.mzW = this.mzX;
            this.mzX = list;
            this.mzV = false;
        }
        x.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        f qe = qe(i - 1);
        switch (qe.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return qe.field_type;
            default:
                x.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", Integer.valueOf(qe.field_type));
                return -2;
        }
    }

    public final int getViewTypeCount() {
        return this.mAf.size() + 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(R.e.bsl);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            return view2;
        }
        f qe = qe(i - 1);
        a aVar = (a) this.mAf.get(qe.field_type);
        if (aVar == null) {
            x.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", Integer.valueOf(qe.field_type));
            aVar = (a) this.mAf.get(-2);
            aJZ();
            return aVar.a(view, viewGroup, qe);
        }
        aVar.mDy.kLF = aKc();
        aVar.mDy.lastUpdateTime = this.lastUpdateTime;
        aVar.mDy.mAa = this.mAa;
        aVar.mDy.mAb = this.mAb;
        aVar.mDy.mDA = this.mAh;
        aVar.mDy.mAi = this.mAi;
        return aVar.a(view, viewGroup, qe);
    }

    public final f qe(int i) {
        if (i >= 0 && i < this.mzW.size()) {
            return (f) this.mzW.get(i);
        }
        x.e("MicroMsg.FavoriteAdapter", "get item, but position error");
        return new f();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        return this.mzW.size() + 1;
    }

    public final int ds(long j) {
        int i = 0;
        f dc = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().dc(j);
        if (dc == null) {
            return -1;
        }
        if (this.mAb.size() >= 30) {
            x.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", Integer.valueOf(30));
            com.tencent.mm.ui.base.h.bu(ad.getContext(), ad.getContext().getResources().getString(R.l.egc, new Object[]{Integer.valueOf(30)}));
            return -1;
        }
        this.mAb.put(Long.valueOf(j), dc);
        Iterator it;
        int i2;
        if (dc.field_updateTime >= this.lastUpdateTime) {
            it = this.mzW.iterator();
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    break;
                } else if (((f) it.next()).field_localId == j) {
                    notifyDataSetChanged();
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
        } else {
            this.lastUpdateTime = dc.field_updateTime;
            aKb();
            it = this.mzX.iterator();
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    notifyDataSetChanged();
                    break;
                } else if (((f) it.next()).field_localId == j) {
                    notifyDataSetChanged();
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return -1;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.plugin.favorite.ui.b.a.b bVar = (com.tencent.mm.plugin.favorite.ui.b.a.b) view.getTag();
        if (bVar == null) {
            x.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
        } else if (bVar.mwn == null) {
            x.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
        } else if (!this.mAa && !this.mAi) {
            a aVar = (a) this.mAf.get(bVar.mwn.field_type);
            if (aVar != null) {
                vp vpVar = new vp();
                vpVar.scene = this.scene;
                vpVar.mtU = this.mtU;
                if (this.mAk != null) {
                    vpVar.index = i - this.mAk.getHeaderViewsCount();
                } else {
                    vpVar.index = i;
                }
                aVar.a(view, vpVar);
                x.d("MicroMsg.FavoriteAdapter", "item click type %s", Integer.valueOf(bVar.mwn.field_type));
            }
        } else if (bVar.ikN.isChecked() || this.mAb.size() < 30) {
            bVar.ikN.setChecked(!bVar.ikN.isChecked());
        } else {
            x.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", Integer.valueOf(30));
            com.tencent.mm.ui.base.h.bu(ad.getContext(), ad.getContext().getResources().getString(R.l.egc, new Object[]{Integer.valueOf(30)}));
        }
    }
}
