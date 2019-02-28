package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g extends BaseAdapter {
    private OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            g gVar = g.this;
            if (((Boolean) gVar.kZz.get(intValue)).booleanValue()) {
                gVar.kZz.set(intValue, Boolean.valueOf(false));
            } else {
                gVar.kZz.set(intValue, Boolean.valueOf(true));
            }
            gVar.notifyDataSetChanged();
        }
    };
    private boolean kQH = true;
    c kUm;
    List<CardInfo> kUx = new ArrayList();
    a kZA;
    private boolean kZy = false;
    List<Boolean> kZz = new ArrayList();
    Context mContext;

    public interface a {
    }

    public final /* synthetic */ Object getItem(int i) {
        return oh(i);
    }

    public g(Context context) {
        this.kUm = new l(context, this);
        this.mContext = context;
    }

    public final int getCount() {
        return this.kUx.size();
    }

    public final CardInfo oh(int i) {
        return (CardInfo) this.kUx.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b oh = oh(i);
        oh.kQH = this.kQH;
        View a = this.kUm.a(i, view, oh);
        if (this.kZy && oh.atU()) {
            this.kUm.v(a, 0);
            if (((Boolean) this.kZz.get(i)).booleanValue()) {
                this.kUm.u(a, R.g.bAm);
            } else {
                this.kUm.u(a, R.g.bAn);
            }
            this.kUm.a(a, i, this.iqi);
        } else {
            this.kUm.v(a, 8);
        }
        return a;
    }
}
