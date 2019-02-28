package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LoadMoreRecyclerView extends MRecyclerView {
    private View klP;
    public a klQ;
    boolean klR;

    public interface a {
        void alD();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LinearLayoutManager alX() {
        getContext();
        return new LinearLayoutManager();
    }

    private void init() {
        final h alX = alX();
        super.a(alX);
        a(new k() {
            int klS = 0;

            public final void e(RecyclerView recyclerView, int i) {
                super.e(recyclerView, i);
                if (i == 0 && LoadMoreRecyclerView.this.klR && this.klS == LoadMoreRecyclerView.this.klV.getItemCount() - 1 && LoadMoreRecyclerView.this.klQ != null) {
                    a a = LoadMoreRecyclerView.this.klQ;
                    android.support.v7.widget.RecyclerView.a aVar = LoadMoreRecyclerView.this.klV.TU;
                    a.alD();
                }
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                this.klS = alX.fb();
            }
        });
        this.klV.a(new c() {
            public final void aa(int i, int i2) {
                super.aa(i, i2);
                if (LoadMoreRecyclerView.this.klR && alX.fb() == LoadMoreRecyclerView.this.klV.getItemCount() - 1 && LoadMoreRecyclerView.this.klQ != null) {
                    a a = LoadMoreRecyclerView.this.klQ;
                    android.support.v7.widget.RecyclerView.a aVar = LoadMoreRecyclerView.this.klV.TU;
                    a.alD();
                }
            }
        });
    }

    public final void addFooterView(View view) {
        int aoG = this.klV.aoG() - 1;
        if (this.klP == null || aoG < 0) {
            super.addFooterView(view);
        } else {
            super.c(aoG, view);
        }
    }

    public final void a(h hVar) {
    }

    public final void cg(View view) {
        if (this.klP != view) {
            if (!(this.klP == null || this.klP.equals(view))) {
                cf(this.klP);
            }
            this.klP = view;
            if (this.klP != null) {
                addFooterView(this.klP);
                this.klP.setVisibility(this.klR ? 0 : 8);
            }
        }
    }

    public final void mM(int i) {
        cg(LayoutInflater.from(getContext()).inflate(i, this, false));
    }

    public final void dF(boolean z) {
        if (this.klR != z) {
            this.klR = z;
            if (this.klP != null) {
                this.klP.setVisibility(this.klR ? 0 : 8);
            }
        }
    }

    protected final boolean aoH() {
        if (this.klP == null) {
            return super.aoH();
        }
        if (this.klV.getItemCount() == 1 && this.klV.aoG() == 1) {
            return true;
        }
        return false;
    }
}
