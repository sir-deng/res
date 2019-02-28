package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray leM;
    private a leN;
    protected b lgq;
    protected int lgr;
    protected long lgs;
    protected int lgt;
    private k lgu;
    private Collection<com.tencent.mm.plugin.chatroom.d.a> lgv;
    long lgw;
    protected Context mContext;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lgr = 0;
        this.lgt = 0;
        this.lgw = -1;
        if (!isInEditMode()) {
            this.leM = context.obtainStyledAttributes(attributeSet, R.n.eZV);
            setLayoutParams(new LayoutParams(-1, -1));
            a(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            this.UC = this.lgu;
            setFadingEdgeLength(0);
            this.lgu = new k() {
                public final void c(RecyclerView recyclerView, int i, int i2) {
                    super.c(recyclerView, i, i2);
                    if (((b) recyclerView.getChildAt(0)) != null) {
                        DayPickerView.this.lgs = (long) i2;
                        DayPickerView.this.lgt = DayPickerView.this.lgr;
                    }
                }
            };
        }
    }

    public final void a(a aVar, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.lgv = collection;
        this.leN = aVar;
        if (this.lgq == null) {
            this.lgq = new b(getContext(), this.leN, this.leM, this.lgw, collection);
        }
        a(this.lgq);
        be(this.lgq.getItemCount() - 1);
        this.lgq.UR.notifyChanged();
    }
}
