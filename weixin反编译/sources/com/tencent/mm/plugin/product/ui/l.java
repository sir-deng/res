package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class l extends BaseAdapter {
    private Context mContext;
    List<a> pml;

    public final /* synthetic */ Object getItem(int i) {
        return va(i);
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.pml != null ? this.pml.size() : 0;
    }

    private a va(int i) {
        return (a) this.pml.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        j.a aVar;
        a va = va(i);
        if (view == null || view.getTag() == null) {
            m mVar = new m();
            view = View.inflate(this.mContext, g.uKg, null);
            mVar.ikn = (TextView) view.findViewById(f.uxv);
            mVar.jTd = (ImageView) view.findViewById(f.uxu);
            view.setTag(mVar);
            aVar = mVar;
        } else {
            m aVar2 = (m) view.getTag();
        }
        aVar2.pmm = va;
        aVar2.ikn.setText(va.title);
        aVar2.jTd.setImageBitmap(j.a(new c(va.iconUrl)));
        j.a(aVar2);
        return view;
    }
}
