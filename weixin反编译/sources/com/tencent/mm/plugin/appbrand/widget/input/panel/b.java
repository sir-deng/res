package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b extends a {
    private static final int kgA = a.fromDPToPix(ad.getContext(), 48);
    private static final int kgB = a.fromDPToPix(ad.getContext(), 43);

    public final View mB(int i) {
        View view = null;
        Context context = this.kgx;
        c cVar = this.kgy;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.kgU = this;
        dVar.mContext = context;
        dVar.kgy = cVar;
        if (!(dVar.mContext == null || dVar.kgU == null)) {
            view = View.inflate(dVar.mContext, h.iAa, null);
            if (view instanceof AppBrandSmileyGrid) {
                ((AppBrandSmileyGrid) view).kgy = dVar.kgy;
                AppBrandSmileyGrid appBrandSmileyGrid = (AppBrandSmileyGrid) view;
                int i2 = dVar.mIndex;
                int anZ = dVar.kgU.anZ();
                int aoa = dVar.kgU.aoa();
                int aob = dVar.kgU.aob();
                int rowCount = dVar.kgU.getRowCount();
                int aoc = dVar.kgU.aoc();
                appBrandSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                appBrandSmileyGrid.setBackgroundResource(0);
                appBrandSmileyGrid.setStretchMode(2);
                appBrandSmileyGrid.setOnItemClickListener(appBrandSmileyGrid.XC);
                appBrandSmileyGrid.kgF = i2;
                appBrandSmileyGrid.kgD = anZ;
                appBrandSmileyGrid.kgE = aoa;
                appBrandSmileyGrid.kgG = aoc;
                appBrandSmileyGrid.kgH = aob;
                appBrandSmileyGrid.kgI = rowCount;
                appBrandSmileyGrid.setNumColumns(aob);
                i2 = appBrandSmileyGrid.kgG;
                aoc = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                anZ = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                }
                appBrandSmileyGrid.setPadding(aoc, i2, anZ, 0);
                appBrandSmileyGrid.kgC = new a(appBrandSmileyGrid, (byte) 0);
                appBrandSmileyGrid.setAdapter(appBrandSmileyGrid.kgC);
                appBrandSmileyGrid.kgC.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int anZ() {
        return this.kgy.anR().anT();
    }

    public final int aoa() {
        return aob() * getRowCount();
    }

    public final int getPageCount() {
        if (aoa() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) anZ()) / ((double) aoa()));
    }

    public final int aob() {
        if (this.kgy.kgO) {
            return 7;
        }
        c cVar = this.kgy;
        if (cVar.kgT <= 1) {
            cVar.kgT = c.alC()[0];
        }
        return cVar.kgT / kgB;
    }

    public final int aoc() {
        return (this.kgy.kgS - (kgA * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.kgy.kgS / kgA;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
