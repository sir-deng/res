package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class SelectScanModeGrid extends GridView {

    public static class a extends BaseAdapter {
        private Context context;
        private List<b> qeK;
        int qeL = -1;

        static class a {
            public TextView pli;
            public TextView qeM;

            a() {
            }
        }

        public a(Context context, List<b> list) {
            this.context = context;
            this.qeK = list;
            x.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.qeK.size());
        }

        public final int getCount() {
            return this.qeK.size();
        }

        public final Object getItem(int i) {
            if (i >= 0 && i < this.qeK.size()) {
                return this.qeK.get(i);
            }
            x.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = " + i);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.drU, null);
                aVar = new a();
                aVar.qeM = (TextView) view.findViewById(R.h.cLk);
                aVar.pli = (TextView) view.findViewById(R.h.cLo);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i);
                if (bVar == null) {
                    x.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                } else {
                    if (bVar.qeN == R.l.eHJ) {
                        aVar.pli.setText(p.ec(p.qhg, this.context.getString(R.l.eHJ)));
                    } else {
                        aVar.pli.setText(bVar.qeN);
                    }
                    if (i == this.qeL) {
                        aVar.qeM.setBackgroundResource(bVar.qeP);
                    } else {
                        aVar.qeM.setBackgroundResource(bVar.qeO);
                    }
                    bVar.qeR = aVar.qeM;
                }
            }
            return view;
        }
    }

    public static class b {
        public int qeN;
        public int qeO;
        public int qeP;
        public int qeQ;
        public TextView qeR;

        public b(int i, int i2, int i3, int i4) {
            this.qeN = i;
            this.qeO = i2;
            this.qeP = i3;
            this.qeQ = i4;
        }
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
