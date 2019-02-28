package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ui.v;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import java.util.HashMap;
import junit.framework.Assert;

final class d extends BaseAdapter {
    private final Context context;
    protected int plh = -1;
    private final int style;
    protected String value;
    protected final HashMap<CharSequence, c> values = new HashMap();
    protected CharSequence[] yqD;
    protected CharSequence[] yqE;

    static class a {
        TextView pli;
        CheckBox plj;
        RadioButton plk;

        a() {
        }
    }

    public d(Context context) {
        this.context = context;
        this.style = 1;
    }

    protected final void cqZ() {
        boolean z;
        int i = 0;
        if (this.yqD == null) {
            this.yqD = new CharSequence[0];
        }
        if (this.yqE == null) {
            this.yqE = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.yqD.length == this.yqE.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.yqE.length) {
            this.values.put(this.yqE[i], new c(this.yqD[i], 1048576 + i));
            i++;
        }
    }

    public final int getCount() {
        return this.yqE.length;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fw(this.context).inflate(h.gZv, null);
            a aVar = new a();
            aVar.pli = (TextView) view.findViewById(g.text);
            aVar.plj = (CheckBox) view.findViewById(g.gXa);
            aVar.plk = (RadioButton) view.findViewById(g.radio);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.pli.setText(this.yqD[i]);
        switch (this.style) {
            case 1:
                aVar2.plj.setVisibility(8);
                aVar2.plk.setVisibility(0);
                aVar2.plk.setChecked(this.yqE[i].equals(this.value));
                break;
            case 2:
                aVar2.plj.setVisibility(0);
                aVar2.plk.setVisibility(8);
                aVar2.plj.setChecked(this.yqE[i].equals(this.value));
                break;
            default:
                aVar2.plj.setVisibility(8);
                aVar2.plk.setVisibility(8);
                break;
        }
        return view;
    }
}
