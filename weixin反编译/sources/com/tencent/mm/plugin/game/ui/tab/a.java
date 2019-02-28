package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends BaseAdapter {
    private Context mContext;
    private GameTabData nCp;
    private String nCq;

    public class a {
        ImageView jSg;
        TextView jtn;

        public a(View view) {
            this.jtn = (TextView) view.findViewById(R.h.bOU);
            this.jSg = (ImageView) view.findViewById(R.h.bOT);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return (TabItem) this.nCp.aRD().get(i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final void a(GameTabData gameTabData, String str) {
        this.nCp = gameTabData;
        this.nCq = str;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.nCp == null ? 0 : this.nCp.aRD().size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dlu, viewGroup, false);
        a aVar = new a(inflate);
        TabItem tabItem = (TabItem) this.nCp.aRD().get(i);
        if (tabItem != null) {
            aVar.jtn.setText(tabItem.title);
            String str;
            com.tencent.mm.ap.a.a.c.a aVar2;
            if (bi.oM(this.nCq).equalsIgnoreCase(tabItem.njQ)) {
                if (!bi.oN(tabItem.njW)) {
                    str = as.nkb + g.s(tabItem.njW.getBytes());
                    aVar2 = new com.tencent.mm.ap.a.a.c.a();
                    aVar2.hFl = true;
                    aVar2.hFn = str;
                    com.tencent.mm.ap.a.a.PN().a(tabItem.njW, aVar.jSg, aVar2.PQ());
                }
            } else if (!bi.oN(tabItem.njV)) {
                str = as.nkb + g.s(tabItem.njV.getBytes());
                aVar2 = new com.tencent.mm.ap.a.a.c.a();
                aVar2.hFl = true;
                aVar2.hFn = str;
                com.tencent.mm.ap.a.a.PN().a(tabItem.njV, aVar.jSg, aVar2.PQ());
            }
        }
        inflate.setTag(tabItem);
        return inflate;
    }
}
