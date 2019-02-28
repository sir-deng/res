package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private String jPV = q.FY();
    private Context mContext;
    List<e> mbX;
    Map<String, String> mbY;
    String mbZ;
    d mca;
    private String mcb;
    private boolean mcc = false;
    private a mcd = new a();
    private OnClickListener mce = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
            b.this.mca.zY(b.this.pG(((Integer) view.getTag()).intValue()).meX.field_username);
        }
    };
    private OnClickListener mcf = new OnClickListener() {
        public final void onClick(View view) {
            b.this.mca.zY(b.this.jPV);
        }
    };
    private OnClickListener mcg = new OnClickListener() {
        public final void onClick(View view) {
            b.this.mca.aFX();
        }
    };

    static final class b {
        public TextView lTg;
        public View mcj;
        public View mck;
        public ImageView mcl;
        public NoMeasuredTextView mcm;
        public TextView mcn;
        public TextView mco;
        public ExdeviceLikeView mcp;
        public View mcq;
        public View mcr;
        public View mcs;
        public TextView mct;

        b() {
        }
    }

    static final class a {
        public View iln;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pG(i);
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.mcb = str;
    }

    private static void c(LinkedList<c> linkedList, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                x.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", ((c) it.next()).toString());
                it.remove();
            }
        }
    }

    private static boolean d(LinkedList<c> linkedList, String str) {
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            x.d("MicroMsg.ExdeviceRankAdapter", e.toString());
            return false;
        }
    }

    private List<e> a(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        a aVar;
        LinkedList linkedList = new LinkedList(arrayList);
        List arrayList3 = new ArrayList();
        d f = f(this.jPV, arrayList2);
        if (f != null) {
            a aVar2 = this.mcd;
            aVar2.meX = f;
            aVar2.meY = 3;
            if (f.field_score == 0) {
                ((com.tencent.mm.plugin.sport.b.b) g.h(com.tencent.mm.plugin.sport.b.b.class)).d((Activity) this.mContext, this.jPV);
            }
        } else {
            aVar = this.mcd;
            aVar.meX = null;
            aVar.mcb = this.mcb;
            aVar.username = this.jPV;
            aVar.meY = 7;
        }
        if (z) {
            this.mcd.aac = 2;
        } else {
            this.mcd.aac = 1;
        }
        arrayList3.add(this.mcd.aGd());
        aVar = this.mcd;
        aVar.aac = 0;
        arrayList3.add(aVar.aGd());
        c(linkedList, this.jPV);
        Collection arrayList4 = new ArrayList();
        x.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            f = (d) it.next();
            a aVar3 = this.mcd;
            aVar3.meX = f;
            aVar3.aac = 1;
            aVar3.meY = 4;
            arrayList4.add(aVar3.aGd());
            if (linkedList.size() > 0 && d(linkedList, f.field_username)) {
                aVar3 = this.mcd;
                aVar3.meX = f;
                aVar3.aac = 1;
                aVar3.meY = 2;
                arrayList3.add(aVar3.aGd());
                c(linkedList, f.field_username);
            }
        }
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                a aVar4 = this.mcd;
                aVar4.username = cVar.field_username;
                aVar4.mcb = this.mcb;
                aVar4.meX = null;
                aVar4.aac = 1;
                aVar4.meY = 6;
                arrayList3.add(aVar4.aGd());
            }
        }
        if (arrayList3.size() > 2) {
            ((e) arrayList3.get(arrayList3.size() - 1)).meY = (((e) arrayList3.get(arrayList3.size() - 1)).meY | 2) | 1;
            aVar = this.mcd;
            aVar.aac = 0;
            aVar.meX = null;
            arrayList3.add(aVar.aGd());
        }
        if (arrayList4.size() > 1) {
            ((e) arrayList4.get(arrayList4.size() - 1)).meY = 5;
        }
        arrayList3.addAll(arrayList4);
        x.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", Integer.valueOf(arrayList2.size()), arrayList2.toString());
        x.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", Integer.valueOf(arrayList3.size()), arrayList3.toString());
        return arrayList3;
    }

    public final List<e> b(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        ArrayList arrayList3;
        ArrayList arrayList22;
        if (arrayList3 == null) {
            try {
                arrayList3 = new ArrayList();
            } catch (Exception e) {
                x.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                return new ArrayList();
            }
        }
        if (arrayList22 == null) {
            arrayList22 = new ArrayList();
        }
        return a(arrayList3, arrayList22, z);
    }

    public static d f(String str, ArrayList<d> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equalsIgnoreCase(dVar.field_username)) {
                return dVar;
            }
        }
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        return this.mbX == null ? 0 : this.mbX.size();
    }

    public final e pG(int i) {
        return (e) this.mbX.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return pG(i).aac;
    }

    public static void finish() {
        ((com.tencent.mm.plugin.sport.b.b) g.h(com.tencent.mm.plugin.sport.b.b.class)).bDP();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        final d dVar = pG(i).meX;
        e pG = pG(i);
        int itemViewType = getItemViewType(i);
        int i2 = pG.meY;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                case 2:
                    bVar = (b) view.getTag();
                    break;
                default:
                    bVar = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(R.i.dhn, viewGroup, false);
                a aVar = new a();
                aVar.iln = view.findViewById(R.h.cck);
                view.setTag(aVar);
                bVar = null;
                break;
            case 1:
                view = from.inflate(R.i.dhm, viewGroup, false);
                bVar = new b();
                bVar.mcn = (TextView) view.findViewById(R.h.cfE);
                break;
            case 2:
                view = from.inflate(R.i.dho, viewGroup, false);
                bVar = new b();
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.mcj = view.findViewById(R.h.bYH);
            bVar.mck = view.findViewById(R.h.crv);
            bVar.lTg = (TextView) view.findViewById(R.h.cfy);
            bVar.mcl = (ImageView) view.findViewById(R.h.cfC);
            bVar.mcm = (NoMeasuredTextView) view.findViewById(R.h.cfD);
            bVar.mco = (TextView) view.findViewById(R.h.ceT);
            bVar.mcp = (ExdeviceLikeView) view.findViewById(R.h.cfe);
            bVar.mcq = view.findViewById(R.h.cck);
            bVar.mcs = view.findViewById(R.h.cfF);
            bVar.mcr = view.findViewById(R.h.ceX);
            bVar.mct = (TextView) view.findViewById(R.h.cNV);
            if (bVar.mcm != null) {
                bVar.mcm.O(this.mContext.getResources().getDimension(R.f.buS));
                bVar.mcm.setTextColor(this.mContext.getResources().getColor(R.e.bsk));
                bVar.mcm.cqk();
                bVar.mcm.yoG = true;
            }
            view.setTag(bVar);
        }
        if (!(dVar == null || bVar == null)) {
            if (this.jPV.equalsIgnoreCase(dVar.field_username)) {
                this.mcc = true;
            } else {
                this.mcc = false;
            }
            if (itemViewType == 2) {
                bVar.lTg.setText(String.valueOf(dVar.field_ranknum));
                bVar.mco.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.o(bVar.mcl, dVar.field_username);
                bVar.mcj.setOnClickListener(this.mcf);
                bVar.mct.setOnClickListener(this.mcg);
            } else {
                ExdeviceLikeView exdeviceLikeView;
                CharSequence charSequence;
                if (bVar.mcn != null) {
                    if ((i2 & 4) != 4) {
                        bVar.mcn.setVisibility(0);
                        bVar.mcn.setText(this.mContext.getResources().getString(R.l.edT, new Object[]{Integer.valueOf(dVar.field_ranknum)}));
                    } else {
                        bVar.mcn.setVisibility(8);
                    }
                }
                if ((i2 & 2) == 2 || !dVar.field_username.equalsIgnoreCase(this.mbZ) || this.jPV.equalsIgnoreCase(this.mbZ)) {
                    bVar.mck.setBackgroundColor(this.mContext.getResources().getColor(R.e.bsg));
                } else {
                    bVar.mck.setBackgroundColor(this.mContext.getResources().getColor(R.e.bsh));
                }
                if ((i2 & 1) == 1) {
                    bVar.mcq.setVisibility(8);
                } else {
                    bVar.mcq.setVisibility(0);
                }
                if (dVar.field_ranknum >= 100) {
                    bVar.lTg.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.buU));
                } else {
                    bVar.lTg.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.buT));
                }
                if ((i2 & 2) == 2) {
                    bVar.lTg.setText("");
                } else {
                    bVar.lTg.setText(dVar.field_ranknum);
                }
                if (dVar.field_score >= 10000) {
                    bVar.mco.setTextColor(this.mContext.getResources().getColor(R.e.bsj));
                } else {
                    bVar.mco.setTextColor(this.mContext.getResources().getColor(R.e.bsi));
                }
                bVar.mco.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.o(bVar.mcl, dVar.field_username);
                if (!this.mcc) {
                    as.Hm();
                    if (!(com.tencent.mm.y.c.Ff().Xr(dVar.field_username) || this.mbY == null || bi.oN((String) this.mbY.get(dVar.field_username)))) {
                        bVar.mcm.setText(i.b(this.mContext, (CharSequence) this.mbY.get(dVar.field_username), bVar.mcm.gu.getTextSize()));
                        exdeviceLikeView = bVar.mcp;
                        i2 = dVar.field_likecount;
                        exdeviceLikeView.mas = i2;
                        charSequence = exdeviceLikeView.mas;
                        if (exdeviceLikeView.mas < 0) {
                            x.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                            charSequence = "0";
                        } else if (i2 > 999) {
                            x.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                            charSequence = "999+";
                        }
                        if (exdeviceLikeView.mas > 0) {
                            exdeviceLikeView.mav.setVisibility(8);
                        } else {
                            exdeviceLikeView.mav.setVisibility(0);
                        }
                        exdeviceLikeView.mav.setText(charSequence);
                        if (this.mcc) {
                            bVar.mcp.pD(dVar.field_selfLikeState);
                        } else if (dVar.field_likecount == 0) {
                            bVar.mcp.pD(1);
                        } else {
                            bVar.mcp.pD(0);
                        }
                        if (dVar.field_score <= 0 || this.mcc) {
                            bVar.mcp.setClickable(true);
                            bVar.mcp.mat = new com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.a() {
                                public final void jo(int i) {
                                    x.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", Integer.valueOf(i));
                                    if (b.this.mca != null) {
                                        b.this.mca.bj(dVar.field_username, i);
                                    }
                                }

                                public final boolean aFH() {
                                    if (b.this.mca != null) {
                                        return b.this.mca.zZ(dVar.field_username);
                                    }
                                    return true;
                                }
                            };
                        } else {
                            bVar.mcp.setClickable(false);
                        }
                        bVar.mcr.setTag(Integer.valueOf(i));
                        bVar.mcr.setOnClickListener(this.mce);
                        bVar.mcs.setTag(Integer.valueOf(i));
                        bVar.mcs.setOnClickListener(this.mce);
                    }
                }
                bVar.mcm.setText(i.b(this.mContext, r.gw(dVar.field_username), bVar.mcm.gu.getTextSize()));
                exdeviceLikeView = bVar.mcp;
                i2 = dVar.field_likecount;
                exdeviceLikeView.mas = i2;
                charSequence = exdeviceLikeView.mas;
                if (exdeviceLikeView.mas < 0) {
                    x.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                    charSequence = "0";
                } else if (i2 > 999) {
                    x.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                    charSequence = "999+";
                }
                if (exdeviceLikeView.mas > 0) {
                    exdeviceLikeView.mav.setVisibility(0);
                } else {
                    exdeviceLikeView.mav.setVisibility(8);
                }
                exdeviceLikeView.mav.setText(charSequence);
                if (this.mcc) {
                    bVar.mcp.pD(dVar.field_selfLikeState);
                } else if (dVar.field_likecount == 0) {
                    bVar.mcp.pD(0);
                } else {
                    bVar.mcp.pD(1);
                }
                if (dVar.field_score <= 0) {
                }
                bVar.mcp.setClickable(true);
                bVar.mcp.mat = /* anonymous class already generated */;
                bVar.mcr.setTag(Integer.valueOf(i));
                bVar.mcr.setOnClickListener(this.mce);
                bVar.mcs.setTag(Integer.valueOf(i));
                bVar.mcs.setOnClickListener(this.mce);
            }
        }
        return view;
    }
}
