package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements com.tencent.mm.ui.base.VerticalScrollBar.a {
    private OnItemSelectedListener Gu;
    public OnItemClickListener XC;
    private ListView kMW;
    public int mMode;
    private VerticalScrollBar ysE;
    private View ysF;
    public c ysG = new c(atf());
    public OnItemLongClickListener ysH;
    private List<d> ysI = new ArrayList();
    public boolean ysJ;
    public boolean ysK;
    public a ysL;

    public interface a {
        void ak(List<d> list);
    }

    public abstract boolean a(String str, d dVar);

    public abstract VerticalScrollBar atd();

    public abstract View ate();

    public abstract com.tencent.mm.ui.base.sortview.c.a atf();

    public abstract ListView getListView();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.ysE = atd();
        this.kMW = getListView();
        this.ysF = ate();
        this.ysJ = true;
        mF(true);
        this.kMW.setAdapter(this.ysG);
        if (this.ysE != null) {
            this.ysE.yqj = this;
        }
        this.ysG.registerDataSetObserver(new DataSetObserver() {
            public final void onChanged() {
                if (BaseSortView.this.ysL != null) {
                    BaseSortView.this.ysL.ak(BaseSortView.this.ysG.ysI);
                }
            }
        });
        this.kMW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BaseSortView.this.XC != null) {
                    BaseSortView.this.XC.onItemClick(adapterView, view, i, j);
                }
            }
        });
        this.kMW.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BaseSortView.this.ysH != null) {
                    return BaseSortView.this.ysH.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
        this.kMW.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (BaseSortView.this.Gu != null) {
                    BaseSortView.this.Gu.onItemSelected(adapterView, view, i, j);
                }
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
                if (BaseSortView.this.Gu != null) {
                    BaseSortView.this.Gu.onNothingSelected(adapterView);
                }
            }
        });
    }

    public void refresh() {
        ah.y(this.ysG.ysP);
    }

    public final void dd(List<d> list) {
        if (this.mMode == 0 && this.ysI != list) {
            this.ysI.clear();
            if (list != null) {
                this.ysI.addAll(list);
            }
        }
        this.ysG.dd(list);
    }

    public final void Zy(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            x.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        List arrayList = new ArrayList();
        if (bi.oN(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (d dVar : this.ysI) {
                if (a(str, dVar)) {
                    arrayList.add(dVar);
                }
            }
            z2 = true;
        }
        View view = this.kMW;
        if (!z2 || arrayList.size() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        n(view, z3);
        View view2 = this.ysF;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        n(view2, z);
        dd(arrayList);
    }

    public final void xN(String str) {
        int Zz = this.ysG.Zz(str);
        if (Zz >= 0) {
            this.kMW.setSelection(Zz);
        }
    }

    public final void crf() {
        this.mMode = 1;
        Zy("");
    }

    public static void n(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void mF(boolean z) {
        this.ysK = z;
        if (this.ysE != null) {
            this.ysE.setVisibility(z ? 0 : 8);
        }
    }

    public final void crg() {
        this.ysJ = false;
        ah.y(this.ysG.ysP);
    }
}
