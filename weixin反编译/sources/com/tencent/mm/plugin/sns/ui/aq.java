package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq extends com.tencent.mm.ui.base.AnimatedExpandableListView.a {
    public static int[] rIQ = new int[]{j.qRu, j.qRs, j.qRo, j.qRh};
    public static int[] rJm = new int[]{j.qRv, j.qRt, j.qRp, j.qRi};
    private LayoutInflater DF;
    private Context mContext;
    ArrayList<String> rJn;
    public int rJo = 0;
    public boolean rJp = false;
    public ArrayList<String> rJq = new ArrayList();
    public ArrayList<String> rJr = new ArrayList();
    public ArrayList<String> rJs = new ArrayList();
    public ArrayList<String> rJt = new ArrayList();
    public int style;

    private class a {
        TextView odc;
        ImageView ori;
        TextView rJu;
        TextView rJv;
        TextView titleView;

        private a() {
        }

        /* synthetic */ a(aq aqVar, byte b) {
            this();
        }
    }

    public aq(Context context) {
        this.mContext = context;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final Object getChild(int i, int i2) {
        return this.rJn.get(i2);
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    public final void Q(ArrayList<String> arrayList) {
        List<String> bBW = bBW();
        Object arrayList2 = new ArrayList();
        if (!(bBW == null || arrayList == null)) {
            for (String str : bBW) {
                if (j(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            String str2 = bi.d(arrayList2, ",");
            g.Dr();
            g.Dq().Db().set(335875, str2);
        }
        this.rJn = arrayList;
    }

    private static List<String> bBW() {
        g.Dr();
        String str = (String) g.Dq().Db().get(335875, null);
        x.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", str);
        if (bi.oN(str)) {
            return null;
        }
        return bi.F(str.split(","));
    }

    public static void MC(String str) {
        x.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", str);
        if (bBW() != null) {
            List arrayList = new ArrayList(bBW());
            if (!j(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                String d = bi.d(arrayList, ",");
                g.Dr();
                g.Dq().Db().set(335875, d);
                return;
            }
            return;
        }
        g.Dr();
        g.Dq().Db().set(335875, str);
    }

    private CharSequence MD(String str) {
        List<String> DX = com.tencent.mm.plugin.label.a.a.aVD().DX(com.tencent.mm.plugin.label.a.a.aVD().DU(str));
        if (DX == null || DX.size() == 0) {
            return "";
        }
        List arrayList = new ArrayList(DX.size());
        for (String gw : DX) {
            arrayList.add(((b) g.h(b.class)).gw(gw));
        }
        return i.a(this.mContext, bi.d(arrayList, ","));
    }

    private static boolean j(List<String> list, String str) {
        for (String equals : list) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean aM(int i, String str) {
        if (i == 1) {
            return j(this.rJq, str);
        }
        return j(this.rJr, str);
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qNA, null);
            } else {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qNz, null);
            }
            a aVar2 = new a();
            aVar2.titleView = (TextView) inflate.findViewById(f.qKK);
            aVar2.ori = (ImageView) inflate.findViewById(f.qKG);
            aVar2.odc = (TextView) inflate.findViewById(f.qKJ);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(rIQ[i]);
        aVar.odc.setText(rJm[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.rJo == i) {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAC);
                    aVar.ori.setContentDescription(this.mContext.getString(j.qPN));
                    break;
                }
                aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAB);
                break;
            case 2:
                if (this.rJo == i) {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAC);
                    aVar.ori.setContentDescription(this.mContext.getString(j.qPN));
                    break;
                }
                aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAB);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.rJo == i) {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qOT);
                        aVar.ori.setContentDescription(this.mContext.getString(j.qPN));
                        break;
                    }
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAB);
                    break;
                } else if (this.rJo == i) {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qOU);
                    aVar.ori.setContentDescription(this.mContext.getString(j.qPN));
                    break;
                } else {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAB);
                    break;
                }
        }
        if (!this.rJp || i != 1) {
            return view;
        }
        view = new View(this.mContext);
        view.setVisibility(8);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private static List<String> at(List<String> list) {
        List<String> linkedList = new LinkedList();
        g.Dr();
        if (!g.Do().CF()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            g.Dr();
            com.tencent.mm.k.a Xv = ((h) g.h(h.class)).Ff().Xv(obj2);
            if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                obj2 = Xv.AX();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final View d(int i, int i2, View view) {
        a aVar;
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qNy, null);
            } else {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qNx, null);
            }
            a aVar2 = new a();
            aVar2.titleView = (TextView) inflate.findViewById(f.qKK);
            aVar2.odc = (TextView) inflate.findViewById(f.qKJ);
            aVar2.rJu = (TextView) inflate.findViewById(f.qKI);
            aVar2.rJv = (TextView) inflate.findViewById(f.qKH);
            aVar2.ori = (ImageView) inflate.findViewById(f.qKG);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (i2 == this.rJn.size()) {
            aVar.titleView.setVisibility(8);
            aVar.odc.setVisibility(8);
            aVar.ori.setVisibility(8);
            aVar.rJu.setVisibility(0);
            aVar.rJv.setVisibility(0);
            if (i == 3) {
                if (this.rJt.size() > 0) {
                    aVar.rJv.setText("√" + bi.d(at(this.rJt), ","));
                    aVar.rJv.setVisibility(0);
                    aVar.rJv.setTextColor(this.mContext.getResources().getColor(c.qEF));
                } else {
                    aVar.rJv.setText("");
                    aVar.rJv.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.rJs.size() > 0) {
                    aVar.rJv.setText("√" + bi.d(at(this.rJs), ","));
                    aVar.rJv.setVisibility(0);
                    aVar.rJv.setTextColor(this.mContext.getResources().getColor(c.qEE));
                } else {
                    aVar.rJv.setText("");
                    aVar.rJv.setVisibility(8);
                }
            }
        } else {
            aVar.titleView.setVisibility(0);
            aVar.odc.setVisibility(0);
            aVar.ori.setVisibility(0);
            aVar.rJu.setVisibility(8);
            aVar.rJv.setVisibility(8);
            CharSequence charSequence = (String) this.rJn.get(i2);
            aVar.titleView.setText(i.a(this.mContext, charSequence));
            aVar.odc.setText(MD(charSequence));
            aVar.ori.setVisibility(0);
            if (this.style == 1) {
                if (i == 2) {
                    if (aM(1, charSequence)) {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAW);
                    } else {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dAX);
                    }
                } else if (i == 3) {
                    if (this.rJo != i) {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qPc);
                    } else {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qPb);
                    }
                    if (aM(2, charSequence)) {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qPb);
                    } else {
                        aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qPc);
                    }
                }
            } else if (i == 2) {
                if (aM(1, charSequence)) {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dxZ);
                } else {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dya);
                }
            } else if (i == 3) {
                if (aM(2, charSequence)) {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.qOH);
                } else {
                    aVar.ori.setImageResource(com.tencent.mm.plugin.sns.i.i.dya);
                }
            }
        }
        return view;
    }

    public final int ya(int i) {
        if (i <= 1 || this.rJn == null) {
            return 0;
        }
        return this.rJn.size() + 1;
    }
}
