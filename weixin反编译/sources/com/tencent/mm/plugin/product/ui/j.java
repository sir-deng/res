package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;

public final class j extends BaseAdapter {
    private Context mContext;
    m pmg;
    String pmh;

    public final /* synthetic */ Object getItem(int i) {
        return uY(i);
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.pmg.pkF != null ? this.pmg.pkF.size() : 0;
    }

    private h uY(int i) {
        return (h) this.pmg.pkF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return uY(i).pkx;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        h uY = uY(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, g.uKd, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(uY.name);
        checkBox.setEnabled(uY.pkx);
        checkBox.setChecked(uY.id.equals(this.pmh));
        if (!uY.pkx) {
            inflate.setBackgroundResource(e.ujZ);
        } else if (uY.id.equals(this.pmh)) {
            inflate.setBackgroundResource(e.ukb);
        } else {
            inflate.setBackgroundResource(e.uka);
        }
        inflate.setTag(new Pair(this.pmg.pkD, uY.id));
        return inflate;
    }
}
