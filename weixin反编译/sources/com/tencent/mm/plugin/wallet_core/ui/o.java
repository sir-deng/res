package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

public final class o extends BaseAdapter {
    private Context mContext;
    ArrayList<x> mData = null;
    x tcU = null;

    private class a {
        TextView jtn;
        ImageView tcV;

        private a() {
        }

        /* synthetic */ a(o oVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return zK(i);
    }

    public o(Context context, ArrayList<x> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    public final x zK(int i) {
        if (this.mData == null || getCount() <= i) {
            return null;
        }
        return (x) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, g.uMz, null);
            a aVar2 = new a();
            aVar2.jtn = (TextView) view.findViewById(f.title);
            aVar2.tcV = (ImageView) view.findViewById(f.uCR);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x zK = zK(i);
        if (zK != null) {
            aVar.jtn.setText(zK.field_wallet_name);
            if (zK.field_wallet_selected == 1) {
                this.tcU = zK;
                aVar.tcV.setImageResource(h.dAC);
            } else {
                aVar.tcV.setImageResource(h.dAB);
            }
        }
        return view;
    }
}
