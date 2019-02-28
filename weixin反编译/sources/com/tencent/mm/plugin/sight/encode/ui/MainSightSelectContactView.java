package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.sight.encode.ui.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, a, l {
    public ListView Fv;
    boolean qCG = false;
    public MMFragmentActivity qCL;
    public int qDk;
    public d qDl;
    Animation qDm;
    public c qDn;
    public View qDo;
    public a qDp;
    public LinearLayout qDq;
    private View qDr;
    private int qDs = -1;
    private int qDt = -1;
    public HashSet<String> qDu;
    public HashSet<String> qDv;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void buo() {
        if (this.qDq != null) {
            this.qDq.getChildAt(0).setVisibility(0);
            this.qDo.setVisibility(8);
            z(true, false);
            this.qDp.bue();
        }
    }

    public final void bun() {
        if (this.qDq != null) {
            this.qDq.getChildAt(0).setVisibility(8);
            this.qDo.setVisibility(0);
            List list = this.qDn.qCT;
            list.remove("@search.tencent");
            list.remove("@sns.tencent");
            list.remove("@draft.tencent");
            b(list, false, true);
            this.qDp.buf();
            if (!this.qDp.AP()) {
                this.qDp.bug();
            }
            this.qDp.buh();
        }
    }

    public final void bup() {
        this.Fv.post(new Runnable() {
            public final void run() {
                if (MainSightSelectContactView.this.qDs != MainSightSelectContactView.this.qDn.getCount() || MainSightSelectContactView.this.qDp.bud() < MainSightSelectContactView.this.qDt) {
                    if (MainSightSelectContactView.this.qDr != null) {
                        MainSightSelectContactView.this.Fv.removeFooterView(MainSightSelectContactView.this.qDr);
                    }
                    int d = MainSightSelectContactView.this.qDt;
                    if (MainSightSelectContactView.this.qDt < 0 || MainSightSelectContactView.this.qDt > MainSightSelectContactView.this.qDp.bud()) {
                        d = MainSightSelectContactView.this.qDp.bud();
                    }
                    MainSightSelectContactView.this.qDs = MainSightSelectContactView.this.qDn.getCount();
                    MainSightSelectContactView.this.qDt = d;
                    int i = 0;
                    int i2 = 0;
                    while (i < MainSightSelectContactView.this.qDn.getCount()) {
                        View view = MainSightSelectContactView.this.qDn.getView(i, null, MainSightSelectContactView.this.Fv);
                        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        i2 += view.getMeasuredHeight();
                        if (i2 < d) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    d -= i2;
                    if (d > 0) {
                        MainSightSelectContactView.this.qDr = new View(MainSightSelectContactView.this.getContext());
                        MainSightSelectContactView.this.qDr.setLayoutParams(new LayoutParams(-1, d));
                        MainSightSelectContactView.this.qDr.setBackgroundResource(R.e.black);
                        MainSightSelectContactView.this.Fv.addFooterView(MainSightSelectContactView.this.qDr);
                    }
                }
            }
        });
    }

    private void b(List<String> list, boolean z, boolean z2) {
        if (!this.qCG && list != null) {
            if (z) {
                this.qDv.clear();
                this.qDu.clear();
                c.qCV = true;
                c.qCW = false;
            }
            if (this.qDn != null) {
                c cVar = this.qDn;
                cVar.clearCache();
                cVar.qCT = list;
                cVar.notifyDataSetChanged();
            }
            if (z2) {
                bup();
            } else if (this.qDr != null) {
                this.Fv.removeFooterView(this.qDr);
            }
        }
    }

    public final void z(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        Collection<String> arrayList2 = new ArrayList();
        as.Hm();
        Collection cjt = c.Fk().cjt();
        cjt.remove(q.FY());
        arrayList2.addAll(cjt);
        if (z) {
            arrayList.addAll(this.qDv);
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(arrayList2);
        }
        b(arrayList, z2, true);
    }

    public final Activity getActivity() {
        return this.qCL;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.zbR || aVar.jQP == null) {
            return false;
        }
        return this.qDu.contains(aVar.jQP.field_username);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.zbR || aVar.jQP == null) {
            return false;
        }
        return this.qDv.contains(aVar.jQP.field_username);
    }

    public final ListView buq() {
        return this.Fv;
    }

    public final LinkedList<String> bur() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(this.qDv);
        return linkedList;
    }

    public final boolean bus() {
        return this.qDv == null ? true : this.qDv.isEmpty();
    }

    final String hF(int i) {
        com.tencent.mm.ui.contact.a.a GF = this.qDn.GF(i);
        if (GF == null) {
            return null;
        }
        ag agVar = GF.jQP;
        if (agVar != null) {
            return agVar.field_username;
        }
        return null;
    }

    public static boolean wG(int i) {
        return i == -1;
    }

    public final void bK(List<String> list) {
        b(list, false, false);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            bi.hideVKB(absListView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.qDq != null && absListView != null && this.qDq.getHeight() > 0 && this.qCL != null) {
            int height = this.qDq.getHeight() - this.qCL.getSupportActionBar().getHeight();
            int i4 = -this.qDq.getTop();
            if (i4 >= 0) {
                this.qDp.as(((float) i4) / ((float) height));
                boolean z = this.qDq.getTop() < 0 && this.qDq.getTop() <= (-height);
                this.qDp.ik(z);
            }
        }
    }
}
