package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.b;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.v;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.k;

public final class m extends q {
    private LayoutInflater DF;
    private boolean rEZ = true;
    public c rQF;
    public d rQG;
    private n rQH;
    private a zuC;
    private com.tencent.mm.ui.base.p.a zux;
    private b zuy;

    private class a extends BaseAdapter {

        private class a {
            ImageView jSg;
            TextView jtn;
            View rts;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }

        public final int getCount() {
            return m.this.rEZ ? m.this.rQH.size() + 1 : m.this.rQH.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            return (m.this.rEZ && i == 0) ? 0 : 1;
        }

        public final int getViewTypeCount() {
            return m.this.rEZ ? 2 : 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a aVar2;
            if (m.this.rEZ && i == 0) {
                if (view == null) {
                    view = m.this.DF.inflate(h.gZI, viewGroup, false);
                    aVar = new a();
                    aVar.jtn = (TextView) view.findViewById(g.title);
                    aVar.jSg = (ImageView) view.findViewById(g.icon);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.jtn.setText(m.f(m.this));
            } else {
                if (m.this.rEZ) {
                    i--;
                }
                if (view == null) {
                    view = m.this.DF.inflate(h.don, viewGroup, false);
                    aVar = new a();
                    aVar.jtn = (TextView) view.findViewById(g.title);
                    aVar.jSg = (ImageView) view.findViewById(g.icon);
                    aVar.rts = view.findViewById(g.cIB);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                MenuItem item = m.this.rQH.getItem(i);
                aVar2.jtn.setText(item.getTitle());
                if (item.getIcon() != null) {
                    aVar2.jSg.setVisibility(0);
                    aVar2.jSg.setImageDrawable(item.getIcon());
                } else if (m.this.zux != null) {
                    aVar2.jSg.setVisibility(0);
                    m.this.zux.a(aVar2.jSg, item);
                } else {
                    aVar2.jSg.setVisibility(8);
                }
                if (m.this.zuy != null) {
                    m.this.zuy.a(aVar2.jtn, item);
                }
                if (i == m.this.rQH.size() - 1) {
                    aVar2.rts.setBackgroundResource(f.bGB);
                } else {
                    aVar2.rts.setBackgroundResource(f.bGA);
                }
            }
            return view;
        }
    }

    static /* synthetic */ CharSequence f(m mVar) {
        return (mVar.rQH.Lp == null || mVar.rQH.Lp.length() == 0) ? mVar.mContext.getResources().getString(k.hag) : mVar.rQH.Lp;
    }

    public m(Context context) {
        super(context);
        this.DF = v.fw(context);
        this.rQH = new n();
    }

    public final boolean dN() {
        if (this.rQF != null) {
            this.rQF.a(this.rQH);
        }
        boolean z = this.rQH.Lp != null && this.rQH.Lp.length() > 0;
        this.rEZ = z;
        return super.dN();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.rEZ || i != 0) {
            if (this.rEZ) {
                i--;
            }
            if (this.rQG != null) {
                this.rQG.onMMMenuItemSelected(this.rQH.getItem(i), i);
            }
            dismiss();
        }
    }

    protected final BaseAdapter atB() {
        if (this.zuC == null) {
            this.zuC = new a();
        }
        return this.zuC;
    }
}
