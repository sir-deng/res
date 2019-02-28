package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import java.util.HashMap;

public final class ba implements OnItemClickListener {
    private LayoutInflater DF;
    private Context mContext;
    private m rQE;
    c rQF;
    d rQG;
    private n rQH;
    private a rQI;
    private HashMap<Integer, CharSequence> rQJ = new HashMap();
    private HashMap<Integer, Integer> rQK = new HashMap();

    private class a extends BaseAdapter {

        private class a {
            TextView jtn;
            TextView rQM;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(ba baVar, byte b) {
            this();
        }

        public final int getCount() {
            return ba.this.rQH.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ba.this.DF.inflate(g.qOg, viewGroup, false);
                aVar = new a();
                aVar.jtn = (TextView) view.findViewById(f.title);
                aVar.rQM = (TextView) view.findViewById(f.qJl);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = ba.this.rQH.getItem(i);
            aVar.jtn.setText(item.getTitle());
            if (ba.this.rQJ.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.rQM.setText((CharSequence) ba.this.rQJ.get(Integer.valueOf(item.getItemId())));
                aVar.rQM.setVisibility(0);
            } else {
                aVar.rQM.setVisibility(4);
            }
            if (ba.this.rQK.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.rQM.setTextColor(((Integer) ba.this.rQK.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            return view;
        }
    }

    public ba(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
        this.rQE = new m(context);
        this.rQH = new n();
    }

    public final void d(int i, CharSequence charSequence) {
        this.rQJ.put(Integer.valueOf(i), charSequence);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar = (o) this.rQH.ykH.get(i);
        if (oVar.performClick()) {
            x.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.rQG != null) {
            this.rQG.onMMMenuItemSelected(oVar, i);
        }
        dismiss();
    }

    private void dismiss() {
        if (this.rQE.isShowing()) {
            this.rQE.dismiss();
        }
    }

    public final Dialog bCH() {
        if (this.rQF != null) {
            this.rQH.clear();
            this.rQH = new n();
            this.rQF.a(this.rQH);
        }
        if (this.rQH.cqg()) {
            x.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            return null;
        }
        if (this.rQI == null) {
            this.rQI = new a();
        }
        this.rQE.kUZ = this.rQI;
        this.rQE.vDf = this;
        this.rQE.setTitle(this.rQH.Lp);
        this.rQE.show();
        return this.rQE;
    }
}
