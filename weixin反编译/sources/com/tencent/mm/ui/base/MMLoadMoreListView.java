package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class MMLoadMoreListView extends ListView {
    public View lHm = null;
    public a ykC = null;
    private boolean ykD = false;
    public TextView ykE;
    public boolean ykF = false;

    public interface a {
        void ayD();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void cqc() {
        this.lHm = View.inflate(getContext(), h.dny, null);
        this.ykE = (TextView) this.lHm.findViewById(g.gXh);
        this.lHm.setVisibility(8);
    }

    private void init() {
        if (this.lHm == null) {
            cqc();
            addFooterView(this.lHm);
            this.lHm.setVisibility(8);
        }
    }

    public final void cqd() {
        this.ykD = true;
        setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && MMLoadMoreListView.this.ykC != null) {
                    MMLoadMoreListView.this.ykC.ayD();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0 && MMLoadMoreListView.this.getChildAt(0) != null && MMLoadMoreListView.this.getChildAt(0).getTop() == MMLoadMoreListView.this.getPaddingTop()) {
                    MMLoadMoreListView.this.ykF = true;
                } else {
                    MMLoadMoreListView.this.ykF = false;
                }
                x.d("MMLoadMoreListView", "newpoi scroll2Top %s", MMLoadMoreListView.this.ykF);
            }
        });
    }

    public final void cqe() {
        if (this.lHm != null) {
            this.ykE.setVisibility(8);
            this.lHm.setVisibility(8);
        }
    }

    public final void cqf() {
        this.ykE.setVisibility(0);
        this.lHm.setVisibility(0);
    }
}
