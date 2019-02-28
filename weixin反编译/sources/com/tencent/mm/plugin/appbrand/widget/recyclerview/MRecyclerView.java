package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;

public class MRecyclerView extends RecyclerView {
    protected a klV;
    private a klW;
    private View klX;

    public interface a {
        void lT(int i);
    }

    public MRecyclerView(Context context) {
        super(context);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.klV = new a();
        this.klV.fQ();
        super.a(this.klV);
        this.klV.a(new c() {
            public final void onChanged() {
                if (MRecyclerView.this.klX != null) {
                    MRecyclerView.this.klX.setVisibility(MRecyclerView.this.aoH() ? 0 : 8);
                }
            }
        });
    }

    public final int G(t tVar) {
        if (this.klV == null) {
            return -1;
        }
        a aVar = this.klV;
        if (tVar == null || tVar.gf() == -1) {
            return -1;
        }
        return tVar.gf() - (aVar.klI.isEmpty() ? 0 : 1);
    }

    public final void a(android.support.v7.widget.RecyclerView.a aVar) {
        a aVar2 = this.klV;
        if (aVar2.TU != null) {
            if (!aVar2.TU.equals(aVar)) {
                aVar2.TU.b(aVar2.klM);
            } else {
                return;
            }
        }
        aVar2.TU = aVar;
        if (aVar2.TU != null) {
            aVar2.TU.a(aVar2.klM);
        }
    }

    public final android.support.v7.widget.RecyclerView.a fn() {
        return this.klV;
    }

    public final void be(int i) {
        super.be(i);
    }

    public final void addHeaderView(View view) {
        a aVar = this.klV;
        aVar.klI.add(view);
        aVar.U(0, 1);
    }

    public void addFooterView(View view) {
        this.klV.addFooterView(view);
    }

    public final void c(int i, View view) {
        this.klV.c(i, view);
    }

    public final void cf(View view) {
        this.klV.cf(view);
    }

    public final void a(a aVar) {
        this.klW = aVar;
        this.klV.klK = new b() {
            public final void mN(int i) {
                if (MRecyclerView.this.klW != null) {
                    MRecyclerView.this.klW.lT(i);
                }
            }
        };
    }

    protected boolean aoH() {
        return this.klV.getItemCount() == 0;
    }
}
