package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.v;

public class AppBrandSmileyGrid extends GridView {
    OnItemClickListener XC = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == AppBrandSmileyGrid.this.kgC.getCount() - 1) {
                if (AppBrandSmileyGrid.this.kgy.kgR != null) {
                    AppBrandSmileyGrid.this.kgy.kgR.anG();
                }
            } else if ((AppBrandSmileyGrid.this.kgF * (AppBrandSmileyGrid.this.kgE - 1)) + i < AppBrandSmileyGrid.this.kgD) {
                int c = (AppBrandSmileyGrid.this.kgF * (AppBrandSmileyGrid.this.kgE - 1)) + i;
                if (AppBrandSmileyGrid.this.kgy.kgR != null) {
                    AppBrandSmileyGrid.this.kgy.kgR.append(AppBrandSmileyGrid.this.kgy.anR().mz(c));
                }
            }
        }
    };
    a kgC;
    int kgD;
    int kgE = 0;
    int kgF;
    int kgG = 0;
    int kgH = 0;
    int kgI = 0;
    c kgy;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(AppBrandSmileyGrid appBrandSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            return AppBrandSmileyGrid.this.kgE;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = v.fw(AppBrandSmileyGrid.this.getContext()).inflate(h.izY, null);
                view.setLayoutParams(new LayoutParams(-1, ((AppBrandSmileyGrid.this.kgy.kgS - com.tencent.mm.bu.a.aa(AppBrandSmileyGrid.this.getContext(), e.bvA)) - com.tencent.mm.bu.a.aa(AppBrandSmileyGrid.this.getContext(), e.bxi)) / AppBrandSmileyGrid.this.kgI));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.jIs.setImageResource(f.bBF);
                bVar.jIs.setContentDescription(AppBrandSmileyGrid.this.getContext().getString(j.dYD));
            } else {
                int d = ((AppBrandSmileyGrid.this.kgE - 1) * AppBrandSmileyGrid.this.kgF) + i;
                if (d > AppBrandSmileyGrid.this.kgD - 1) {
                    bVar.jIs.setImageDrawable(null);
                } else {
                    bVar.jIs.setImageDrawable(AppBrandSmileyGrid.this.kgy.anR().mx(d));
                }
            }
            return view;
        }
    }

    private static final class b {
        ImageView jIs;

        public b(View view) {
            this.jIs = (ImageView) view.findViewById(g.bLk);
        }
    }

    public AppBrandSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
