package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater DF;
    private Context mContext;
    private final int oqO = 3;
    private final int oqP = 9;
    List<ArrayList<c>> oqQ = new ArrayList();
    d oqR;
    private boolean oqS = true;
    int oqT = 0;
    int oqU = 0;
    boolean oqV = false;
    private boolean oqW = false;
    SparseArray<String> oqu = null;
    int oqv;

    class a {
        public View ora = null;
        public ImageView orb = null;
        public ImageView orc = null;
        public TextView ord = null;
        public TextView ore = null;
        public String orf = null;
        public String org = null;
        public ImageView orh = null;
        public ImageView ori = null;
        public ImageView orj = null;
        public ImageView ork = null;

        a() {
        }
    }

    class c {
        MallFunction ort;
        int oru;

        c() {
        }
    }

    public interface d {
        void a(int i, MallFunction mallFunction);
    }

    class b {
        LinearLayout orl;
        TextView orm;
        View orn;
        View oro;
        View orp;
        ImageView orq;
        TextView orr;
        View ors = null;

        b() {
        }
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.oqv = i;
        this.DF = LayoutInflater.from(this.mContext);
    }

    public final int getCount() {
        return this.oqQ.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        Object obj;
        b bVar;
        b bVar2;
        List list;
        int i3;
        int i4;
        Object obj2;
        CharSequence obj22;
        Object obj3;
        ViewGroup viewGroup2;
        a aVar;
        View inflate;
        a aVar2;
        if (this.oqT > 9) {
            int i5 = 0;
            for (i2 = 0; i2 <= i; i2++) {
                i5 += ((ArrayList) this.oqQ.get(i2)).size();
            }
            if (i <= this.oqU) {
                if (i5 > 9 && this.oqS) {
                    obj = 1;
                    if (view == null) {
                        bVar = (b) view.getTag();
                    } else {
                        bVar2 = new b();
                        view = this.DF.inflate(g.uJm, viewGroup, false);
                        bVar2.orl = (LinearLayout) view.findViewById(f.uws);
                        bVar2.orm = (TextView) view.findViewById(f.uwr);
                        bVar2.orn = view.findViewById(f.divider);
                        bVar2.oro = view.findViewById(f.usr);
                        bVar2.orp = view.findViewById(f.uxW);
                        bVar2.orr = (TextView) view.findViewById(f.uxX);
                        bVar2.orq = (ImageView) view.findViewById(f.uxV);
                        bVar2.ors = view.findViewById(f.uyi);
                        bVar2.orp.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                b.this.oqS = !b.this.oqS;
                                b.this.oqW = true;
                                b.this.notifyDataSetChanged();
                            }
                        });
                        view.setTag(bVar2);
                        bVar = bVar2;
                    }
                    if (obj == null) {
                    }
                    bVar.orl.setVisibility(0);
                    list = (List) this.oqQ.get(i);
                    i3 = ((c) list.get(0)).ort.type;
                    if (list.size() > 0) {
                        bVar.orm.setVisibility(8);
                        bVar.orn.setVisibility(8);
                        bVar.oro.setVisibility(8);
                    } else {
                        i4 = ((c) list.get(0)).ort.type;
                        if (this.oqu == null) {
                            obj22 = (String) this.oqu.get(i4);
                        } else {
                            obj22 = null;
                        }
                        if (!bi.oN(obj22)) {
                            obj3 = i != 0 ? 1 : 1;
                            if (obj3 == null) {
                                bVar.orm.setText(obj22);
                                bVar.orm.setVisibility(0);
                                bVar.orn.setVisibility(0);
                                bVar.oro.setVisibility(0);
                            } else {
                                bVar.orm.setVisibility(8);
                                bVar.orn.setVisibility(8);
                                bVar.oro.setVisibility(8);
                            }
                        }
                        obj3 = null;
                        if (obj3 == null) {
                            bVar.orm.setVisibility(8);
                            bVar.orn.setVisibility(8);
                            bVar.oro.setVisibility(8);
                        } else {
                            bVar.orm.setText(obj22);
                            bVar.orm.setVisibility(0);
                            bVar.orn.setVisibility(0);
                            bVar.oro.setVisibility(0);
                        }
                    }
                    viewGroup2 = bVar.orl;
                    viewGroup2.setFocusable(true);
                    i3 = 0;
                    while (true) {
                        i2 = i3;
                        if (i2 < 3) {
                            break;
                        }
                        if (i2 < viewGroup2.getChildCount()) {
                        }
                        aVar = new a();
                        inflate = this.DF.inflate(g.uJo, viewGroup2, false);
                        aVar.ora = inflate.findViewById(f.uww);
                        aVar.orb = (ImageView) inflate.findViewById(f.uwv);
                        aVar.ord = (TextView) inflate.findViewById(f.uwy);
                        aVar.ore = (TextView) inflate.findViewById(f.uwu);
                        aVar.orc = (ImageView) inflate.findViewById(f.uyn);
                        aVar.orh = (ImageView) inflate.findViewById(f.uqj);
                        aVar.ori = (ImageView) inflate.findViewById(f.uqi);
                        aVar.orj = (ImageView) inflate.findViewById(f.ccn);
                        aVar.ork = (ImageView) inflate.findViewById(f.uqg);
                        inflate.setTag(aVar);
                        if (i2 < list.size()) {
                            inflate.setFocusable(true);
                            aVar2 = (a) inflate.getTag();
                            aVar2.ora.setVisibility(4);
                            inflate.setOnClickListener(null);
                            inflate.setEnabled(false);
                            inflate.setClickable(false);
                            a(aVar2);
                        } else {
                            a(inflate, (c) list.get(i2));
                        }
                        viewGroup2.addView(inflate, new LayoutParams(-2, a.aYE(), 1.0f));
                        i3 = i2 + 1;
                    }
                    if (obj != null) {
                        bVar.orp.setVisibility(8);
                    } else {
                        bVar.orm.setVisibility(8);
                        bVar.orn.setVisibility(8);
                        bVar.oro.setVisibility(8);
                        bVar.orp.setVisibility(0);
                        bVar.orq.setImageResource(h.uNl);
                        if (this.oqS) {
                            bVar.orr.setText(this.mContext.getString(i.uRE));
                        } else {
                            bVar.orr.setText(this.mContext.getString(i.uRF));
                        }
                    }
                    bVar.ors.setVisibility(8);
                    return view;
                } else if (i == this.oqU && !this.oqS) {
                    int obj4 = 1;
                    if (view == null) {
                        bVar2 = new b();
                        view = this.DF.inflate(g.uJm, viewGroup, false);
                        bVar2.orl = (LinearLayout) view.findViewById(f.uws);
                        bVar2.orm = (TextView) view.findViewById(f.uwr);
                        bVar2.orn = view.findViewById(f.divider);
                        bVar2.oro = view.findViewById(f.usr);
                        bVar2.orp = view.findViewById(f.uxW);
                        bVar2.orr = (TextView) view.findViewById(f.uxX);
                        bVar2.orq = (ImageView) view.findViewById(f.uxV);
                        bVar2.ors = view.findViewById(f.uyi);
                        bVar2.orp.setOnClickListener(/* anonymous class already generated */);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    if (obj4 == null && this.oqS) {
                        bVar.orm.setVisibility(8);
                        bVar.orn.setVisibility(8);
                        bVar.oro.setVisibility(8);
                        bVar.orp.setVisibility(0);
                        bVar.orq.setImageResource(h.uNk);
                        bVar.orr.setText(this.mContext.getString(i.uRF));
                        bVar.orl.setVisibility(8);
                        if (!this.oqV || this.oqW) {
                            bVar.ors.setVisibility(8);
                        } else {
                            bVar.ors.setVisibility(0);
                        }
                    } else {
                        bVar.orl.setVisibility(0);
                        list = (List) this.oqQ.get(i);
                        i3 = ((c) list.get(0)).ort.type;
                        if (list.size() > 0) {
                            i4 = ((c) list.get(0)).ort.type;
                            if (this.oqu == null) {
                                obj22 = null;
                            } else {
                                obj22 = (String) this.oqu.get(i4);
                            }
                            if (bi.oN(obj22)) {
                                if (i != 0) {
                                    if (((ArrayList) this.oqQ.get(i - 1)).size() > 0 && i4 != ((c) ((ArrayList) this.oqQ.get(i - 1)).get(0)).ort.type) {
                                    }
                                }
                                if (obj3 == null) {
                                    bVar.orm.setText(obj22);
                                    bVar.orm.setVisibility(0);
                                    bVar.orn.setVisibility(0);
                                    bVar.oro.setVisibility(0);
                                } else {
                                    bVar.orm.setVisibility(8);
                                    bVar.orn.setVisibility(8);
                                    bVar.oro.setVisibility(8);
                                }
                            }
                            obj3 = null;
                            if (obj3 == null) {
                                bVar.orm.setVisibility(8);
                                bVar.orn.setVisibility(8);
                                bVar.oro.setVisibility(8);
                            } else {
                                bVar.orm.setText(obj22);
                                bVar.orm.setVisibility(0);
                                bVar.orn.setVisibility(0);
                                bVar.oro.setVisibility(0);
                            }
                        } else {
                            bVar.orm.setVisibility(8);
                            bVar.orn.setVisibility(8);
                            bVar.oro.setVisibility(8);
                        }
                        viewGroup2 = bVar.orl;
                        viewGroup2.setFocusable(true);
                        i3 = 0;
                        while (true) {
                            i2 = i3;
                            if (i2 < 3) {
                                break;
                            }
                            if (i2 < viewGroup2.getChildCount() || viewGroup2.getChildAt(i2) == null) {
                                aVar = new a();
                                inflate = this.DF.inflate(g.uJo, viewGroup2, false);
                                aVar.ora = inflate.findViewById(f.uww);
                                aVar.orb = (ImageView) inflate.findViewById(f.uwv);
                                aVar.ord = (TextView) inflate.findViewById(f.uwy);
                                aVar.ore = (TextView) inflate.findViewById(f.uwu);
                                aVar.orc = (ImageView) inflate.findViewById(f.uyn);
                                aVar.orh = (ImageView) inflate.findViewById(f.uqj);
                                aVar.ori = (ImageView) inflate.findViewById(f.uqi);
                                aVar.orj = (ImageView) inflate.findViewById(f.ccn);
                                aVar.ork = (ImageView) inflate.findViewById(f.uqg);
                                inflate.setTag(aVar);
                                if (i2 < list.size()) {
                                    a(inflate, (c) list.get(i2));
                                } else {
                                    inflate.setFocusable(true);
                                    aVar2 = (a) inflate.getTag();
                                    aVar2.ora.setVisibility(4);
                                    inflate.setOnClickListener(null);
                                    inflate.setEnabled(false);
                                    inflate.setClickable(false);
                                    a(aVar2);
                                }
                                viewGroup2.addView(inflate, new LayoutParams(-2, a.aYE(), 1.0f));
                            } else {
                                View childAt = viewGroup2.getChildAt(i2);
                                childAt.setVisibility(0);
                                if (i2 < list.size()) {
                                    a(childAt, (c) list.get(i2));
                                } else {
                                    viewGroup2.getChildAt(i2).setFocusable(true);
                                    viewGroup2.getChildAt(i2).setOnClickListener(null);
                                    aVar2 = (a) viewGroup2.getChildAt(i2).getTag();
                                    aVar2.ora.setVisibility(4);
                                    childAt.setEnabled(false);
                                    childAt.setClickable(false);
                                    a(aVar2);
                                }
                            }
                            i3 = i2 + 1;
                        }
                        if (obj4 != null) {
                            bVar.orm.setVisibility(8);
                            bVar.orn.setVisibility(8);
                            bVar.oro.setVisibility(8);
                            bVar.orp.setVisibility(0);
                            bVar.orq.setImageResource(h.uNl);
                            if (this.oqS) {
                                bVar.orr.setText(this.mContext.getString(i.uRF));
                            } else {
                                bVar.orr.setText(this.mContext.getString(i.uRE));
                            }
                        } else {
                            bVar.orp.setVisibility(8);
                        }
                        bVar.ors.setVisibility(8);
                    }
                    return view;
                }
            }
        }
        obj4 = null;
        if (view == null) {
            bVar2 = new b();
            view = this.DF.inflate(g.uJm, viewGroup, false);
            bVar2.orl = (LinearLayout) view.findViewById(f.uws);
            bVar2.orm = (TextView) view.findViewById(f.uwr);
            bVar2.orn = view.findViewById(f.divider);
            bVar2.oro = view.findViewById(f.usr);
            bVar2.orp = view.findViewById(f.uxW);
            bVar2.orr = (TextView) view.findViewById(f.uxX);
            bVar2.orq = (ImageView) view.findViewById(f.uxV);
            bVar2.ors = view.findViewById(f.uyi);
            bVar2.orp.setOnClickListener(/* anonymous class already generated */);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (obj4 == null) {
        }
        bVar.orl.setVisibility(0);
        list = (List) this.oqQ.get(i);
        i3 = ((c) list.get(0)).ort.type;
        if (list.size() > 0) {
            i4 = ((c) list.get(0)).ort.type;
            if (this.oqu == null) {
                obj22 = null;
            } else {
                obj22 = (String) this.oqu.get(i4);
            }
            if (bi.oN(obj22)) {
                if (i != 0) {
                }
                if (obj3 == null) {
                    bVar.orm.setText(obj22);
                    bVar.orm.setVisibility(0);
                    bVar.orn.setVisibility(0);
                    bVar.oro.setVisibility(0);
                } else {
                    bVar.orm.setVisibility(8);
                    bVar.orn.setVisibility(8);
                    bVar.oro.setVisibility(8);
                }
            }
            obj3 = null;
            if (obj3 == null) {
                bVar.orm.setVisibility(8);
                bVar.orn.setVisibility(8);
                bVar.oro.setVisibility(8);
            } else {
                bVar.orm.setText(obj22);
                bVar.orm.setVisibility(0);
                bVar.orn.setVisibility(0);
                bVar.oro.setVisibility(0);
            }
        } else {
            bVar.orm.setVisibility(8);
            bVar.orn.setVisibility(8);
            bVar.oro.setVisibility(8);
        }
        viewGroup2 = bVar.orl;
        viewGroup2.setFocusable(true);
        i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 < 3) {
                break;
            }
            if (i2 < viewGroup2.getChildCount()) {
            }
            aVar = new a();
            inflate = this.DF.inflate(g.uJo, viewGroup2, false);
            aVar.ora = inflate.findViewById(f.uww);
            aVar.orb = (ImageView) inflate.findViewById(f.uwv);
            aVar.ord = (TextView) inflate.findViewById(f.uwy);
            aVar.ore = (TextView) inflate.findViewById(f.uwu);
            aVar.orc = (ImageView) inflate.findViewById(f.uyn);
            aVar.orh = (ImageView) inflate.findViewById(f.uqj);
            aVar.ori = (ImageView) inflate.findViewById(f.uqi);
            aVar.orj = (ImageView) inflate.findViewById(f.ccn);
            aVar.ork = (ImageView) inflate.findViewById(f.uqg);
            inflate.setTag(aVar);
            if (i2 < list.size()) {
                a(inflate, (c) list.get(i2));
            } else {
                inflate.setFocusable(true);
                aVar2 = (a) inflate.getTag();
                aVar2.ora.setVisibility(4);
                inflate.setOnClickListener(null);
                inflate.setEnabled(false);
                inflate.setClickable(false);
                a(aVar2);
            }
            viewGroup2.addView(inflate, new LayoutParams(-2, a.aYE(), 1.0f));
            i3 = i2 + 1;
        }
        if (obj4 != null) {
            bVar.orm.setVisibility(8);
            bVar.orn.setVisibility(8);
            bVar.oro.setVisibility(8);
            bVar.orp.setVisibility(0);
            bVar.orq.setImageResource(h.uNl);
            if (this.oqS) {
                bVar.orr.setText(this.mContext.getString(i.uRF));
            } else {
                bVar.orr.setText(this.mContext.getString(i.uRE));
            }
        } else {
            bVar.orp.setVisibility(8);
        }
        bVar.ors.setVisibility(8);
        return view;
    }

    private static void a(a aVar) {
        aVar.ori.setVisibility(4);
    }

    final boolean aYH() {
        if (this.oqQ.size() > 3) {
            ArrayList arrayList = (ArrayList) this.oqQ.get(3);
            if (arrayList != null && arrayList.size() > 0) {
                int i = ((c) arrayList.get(0)).ort.type;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.ort.type != i) {
                        break;
                    } else if (a(cVar.ort)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(MallFunction mallFunction) {
        if (mallFunction.sWC == null || bi.oN(mallFunction.sWC.sWL) || !b(mallFunction) || com.tencent.mm.plugin.wallet_core.model.mall.d.bMU().NI(mallFunction.pHt) == null) {
            return false;
        }
        return true;
    }

    private void a(View view, c cVar) {
        if (view != null) {
            a aVar = (a) view.getTag();
            final MallFunction mallFunction = cVar.ort;
            final int i = cVar.oru;
            aVar.org = mallFunction.org;
            aVar.orf = mallFunction.orf;
            com.tencent.mm.plugin.mall.b.a.f(aVar.orb, aVar.orf, h.uNa);
            aVar.ord.setText(mallFunction.fJD);
            aVar.orc.setVisibility(8);
            if (mallFunction.sWC == null || bi.oN(mallFunction.sWC.sWL) || !b(mallFunction)) {
                if (mallFunction.sWC == null || mallFunction.sWC.sWQ != 1) {
                    aVar.ore.setText("");
                    aVar.ore.setVisibility(4);
                } else {
                    aVar.ore.setText(mallFunction.sWC.sWL);
                    aVar.ore.setVisibility(0);
                }
                aVar.orc.setImageBitmap(null);
                aVar.orc.setVisibility(8);
            } else {
                if (com.tencent.mm.plugin.wallet_core.model.mall.d.bMU().NI(mallFunction.pHt) != null) {
                    x.w("MicroMsg.FunctionListAdapter", "show the news : " + com.tencent.mm.plugin.wallet_core.model.mall.d.bMU().NI(mallFunction.pHt).sWL);
                    aVar.ore.setText(mallFunction.sWC.sWL);
                    aVar.ore.setVisibility(0);
                } else {
                    aVar.ore.setVisibility(4);
                }
                com.tencent.mm.plugin.mall.b.a.k(aVar.orc, aVar.org);
                aVar.orc.setVisibility(0);
                String str = mallFunction.pHt;
            }
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.v("MicroMsg.FunctionListAdapter", "on Click");
                    if (b.this.oqR != null) {
                        b.this.oqR.a(i, mallFunction);
                    }
                }
            });
            aVar.ora.setVisibility(0);
            view.setEnabled(true);
            view.setClickable(true);
            aVar.ori.setVisibility(0);
            aVar.orj.setVisibility(0);
        }
    }

    private static boolean b(MallFunction mallFunction) {
        MallNews NI = com.tencent.mm.plugin.wallet_core.model.mall.d.bMU().NI(mallFunction.pHt);
        if (NI == null || bi.oN(NI.sbN) || !NI.sbN.equals(mallFunction.sWC.sbN)) {
            x.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", mallFunction.sWC.sbN, mallFunction.fJD);
            com.tencent.mm.plugin.wallet_core.model.mall.d bMU = com.tencent.mm.plugin.wallet_core.model.mall.d.bMU();
            NI = mallFunction.sWC;
            if (NI == null) {
                x.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            } else {
                NI.sWR = "<sysmsg><mallactivitynew><functionid>" + NI.sWK + "</functionid><activityid>" + NI.sbN + "</activityid><type>" + NI.type + "</type><showflag>" + NI.sWI + "</showflag><newsTipFlag>" + NI.sWJ + "</newsTipFlag></mallactivitynew></sysmsg>;";
                bMU.sWU.put(NI.sWK, NI);
                bMU.bjN();
            }
            return true;
        } else if (NI == null) {
            return false;
        } else {
            if ("0".equals(NI.sWI)) {
                x.d("MicroMsg.FunctionListAdapter", "still old news and should show");
                return true;
            }
            x.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            return false;
        }
    }
}
