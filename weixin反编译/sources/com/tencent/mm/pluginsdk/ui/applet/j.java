package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class j extends BaseAdapter {
    private List<String> ikZ;
    private Context mContext;
    private List<String> vuZ;

    private static class a {
        public ImageView ikK;
        public TextView lmk;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public j(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.ikZ = list2;
        this.vuZ = list;
    }

    public final int getCount() {
        return this.ikZ.size();
    }

    public final Object getItem(int i) {
        return this.ikZ.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a dc;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dcV, null);
            dc = dc(view);
        } else {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                dc = dc(view);
            } else {
                dc = aVar;
            }
        }
        int size = this.ikZ.size() % 4;
        if (i >= 0 && i < this.ikZ.size() && i < this.vuZ.size()) {
            dc.ikK.setVisibility(0);
            dc.lmk.setVisibility(0);
            b.a(dc.ikK, (String) this.vuZ.get(i));
            dc.lmk.setText((CharSequence) this.ikZ.get(i));
            dc.lmk.setText(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence) this.ikZ.get(i), dc.lmk.getTextSize()));
            if (this.ikZ.size() <= 12 || i < this.ikZ.size() - size) {
                dc.lmk.setPadding(0, 0, 0, 0);
            } else {
                dc.lmk.setPadding(0, 0, 0, com.tencent.mm.bu.a.aa(this.mContext, R.f.buJ));
            }
        }
        return view;
    }

    private static a dc(View view) {
        a aVar = new a();
        aVar.ikK = (ImageView) view.findViewById(R.h.bSJ);
        aVar.lmk = (TextView) view.findViewById(R.h.bSM);
        view.setTag(aVar);
        return aVar;
    }
}
