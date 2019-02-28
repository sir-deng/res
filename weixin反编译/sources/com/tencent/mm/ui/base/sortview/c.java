package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends BaseAdapter {
    public List<d> ysI = null;
    private Map<String, Integer> ysN;
    private a ysO;
    public Runnable ysP = new Runnable() {
        public final void run() {
            c.this.dd(c.this.ysI);
        }
    };

    public interface a {
        View a(d dVar, View view, int i, boolean z, boolean z2);
    }

    public c(a aVar) {
        if (aVar == null) {
            throw new RuntimeException("ViewCreator can not be null.");
        }
        this.ysO = aVar;
        this.ysI = new ArrayList();
        this.ysN = new HashMap();
    }

    public final void dd(List<d> list) {
        if (this.ysI != list) {
            this.ysI.clear();
            if (list != null) {
                this.ysI.addAll(list);
            }
        }
        this.ysN.clear();
        int i = 0;
        String str = null;
        while (i < this.ysI.size()) {
            d dVar = (d) this.ysI.get(i);
            String str2 = (dVar == null || dVar.ysR == null) ? null : dVar.ysR;
            if (str2 == null || str2.equalsIgnoreCase(str)) {
                str2 = str;
            } else {
                this.ysN.put(str2, Integer.valueOf(i));
            }
            i++;
            str = str2;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.ysI.size();
    }

    public final Object getItem(int i) {
        return this.ysI.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        d dVar = (d) getItem(i);
        String FA = FA(i);
        String FA2 = FA(i + 1);
        boolean z2 = i == Zz(FA);
        if (FA == null || FA.equalsIgnoreCase(FA2)) {
            z = false;
        }
        a aVar = this.ysO;
        getCount();
        return aVar.a(dVar, view, i, z2, z);
    }

    private String FA(int i) {
        if (i < 0 || i >= this.ysI.size()) {
            return null;
        }
        return ((d) this.ysI.get(i)).ysR;
    }

    public final int Zz(String str) {
        return bi.a((Integer) this.ysN.get(str), -1);
    }
}
