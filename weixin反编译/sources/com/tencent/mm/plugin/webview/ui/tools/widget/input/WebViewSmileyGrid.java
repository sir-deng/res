package com.tencent.mm.plugin.webview.ui.tools.widget.input;

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
import com.tencent.mm.R;
import com.tencent.mm.bw.e;
import com.tencent.mm.ui.v;

public class WebViewSmileyGrid extends GridView {
    OnItemClickListener XC = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == WebViewSmileyGrid.this.tRE.getCount() - 1) {
                if (WebViewSmileyGrid.this.tRD.tRK != null) {
                    WebViewSmileyGrid.this.tRD.tRK.anG();
                }
            } else if ((WebViewSmileyGrid.this.kgF * (WebViewSmileyGrid.this.kgE - 1)) + i < WebViewSmileyGrid.this.kgD) {
                int c = (WebViewSmileyGrid.this.kgF * (WebViewSmileyGrid.this.kgE - 1)) + i;
                if (WebViewSmileyGrid.this.tRD.tRK != null) {
                    WebViewSmileyGrid.this.tRD.tRK.append(e.chP().mz(c));
                }
            }
        }
    };
    int kgD;
    int kgE = 0;
    int kgF;
    int kgG = 0;
    int kgH = 0;
    int kgI = 0;
    c tRD;
    a tRE;

    private static final class b {
        ImageView jIs;

        public b(View view) {
            this.jIs = (ImageView) view.findViewById(R.h.bLk);
        }
    }

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WebViewSmileyGrid webViewSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            return WebViewSmileyGrid.this.kgE;
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
                view = v.fw(WebViewSmileyGrid.this.getContext()).inflate(R.i.duq, null);
                view.setLayoutParams(new LayoutParams(-1, ((WebViewSmileyGrid.this.tRD.kgS - com.tencent.mm.bu.a.aa(WebViewSmileyGrid.this.getContext(), R.f.bvA)) - com.tencent.mm.bu.a.aa(WebViewSmileyGrid.this.getContext(), R.f.bxi)) / WebViewSmileyGrid.this.kgI));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.jIs.setImageResource(R.g.bBF);
                bVar.jIs.setContentDescription(WebViewSmileyGrid.this.getContext().getString(R.l.dYD));
            } else {
                int d = ((WebViewSmileyGrid.this.kgE - 1) * WebViewSmileyGrid.this.kgF) + i;
                if (d > WebViewSmileyGrid.this.kgD - 1) {
                    bVar.jIs.setImageDrawable(null);
                } else {
                    bVar.jIs.setImageDrawable(e.chP().mx(d));
                }
            }
            return view;
        }
    }

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
