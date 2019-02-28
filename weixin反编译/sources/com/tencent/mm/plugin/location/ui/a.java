package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends l {
    private int nXS = 8;
    private ArrayList<String> nXT = new ArrayList();

    class a {
        ImageView hxJ;
        TextView nXU;

        a() {
        }
    }

    public final void D(ArrayList<String> arrayList) {
        boolean z;
        this.nXT.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.nXT.add((String) it.next());
        }
        String str = "MicroMsg.MMGridPaperAdapter";
        String str2 = "notifyDataSetChange, notifier is null ? %B";
        Object[] objArr = new Object[1];
        if (this.yjP == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.yjP != null) {
            this.yjP.cpZ();
        }
    }

    public final int getCount() {
        return this.nXT.size();
    }

    public final View d(int i, View view) {
        a aVar = new a();
        if (view == null) {
            view = View.inflate(ad.getContext(), R.i.daQ, null);
            aVar.hxJ = (ImageView) view.findViewById(R.h.bLL);
            aVar.nXU = (TextView) view.findViewById(R.h.cUw);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) this.nXT.get(i);
        b.a(aVar.hxJ, str);
        CharSequence gw = r.gw(str);
        if (gw.length() > this.nXS) {
            gw = gw.subSequence(0, this.nXS + 1) + "...";
        }
        aVar.nXU.setText(gw);
        return view;
    }

    public final Object getItem(int i) {
        return this.nXT.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
