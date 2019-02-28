package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.bw.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class b extends a {
    private static final int kgA = a.fromDPToPix(ad.getContext(), 48);
    private static final int kgB = a.fromDPToPix(ad.getContext(), 43);

    public final View mB(int i) {
        View view = null;
        Context context = this.kgx;
        c cVar = this.tRD;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.tRL = this;
        dVar.mContext = context;
        dVar.tRD = cVar;
        if (!(dVar.mContext == null || dVar.tRL == null)) {
            view = View.inflate(dVar.mContext, R.i.dus, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).tRD = dVar.tRD;
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = dVar.mIndex;
                int anZ = dVar.tRL.anZ();
                int aoa = dVar.tRL.aoa();
                int aob = dVar.tRL.aob();
                int rowCount = dVar.tRL.getRowCount();
                int aoc = dVar.tRL.aoc();
                webViewSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.XC);
                webViewSmileyGrid.kgF = i2;
                webViewSmileyGrid.kgD = anZ;
                webViewSmileyGrid.kgE = aoa;
                webViewSmileyGrid.kgG = aoc;
                webViewSmileyGrid.kgH = aob;
                webViewSmileyGrid.kgI = rowCount;
                webViewSmileyGrid.setNumColumns(aob);
                i2 = webViewSmileyGrid.kgG;
                aoc = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                anZ = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(aoc, i2, anZ, 0);
                webViewSmileyGrid.tRE = new a(webViewSmileyGrid, (byte) 0);
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.tRE);
                webViewSmileyGrid.tRE.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int anZ() {
        return e.chP().anT();
    }

    public final int aoa() {
        return aob() * getRowCount();
    }

    public final int getPageCount() {
        if (aoa() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) e.chP().anT()) / ((double) aoa()));
    }

    public final int aob() {
        if (this.tRD.kgO) {
            return 7;
        }
        c cVar = this.tRD;
        if (cVar.kgT <= 1) {
            r2 = new int[2];
            Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
            r2[0] = defaultDisplay.getWidth();
            r2[1] = defaultDisplay.getHeight();
            cVar.kgT = r2[0];
        }
        return cVar.kgT / kgB;
    }

    public final int aoc() {
        return (this.tRD.kgS - (kgA * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.tRD.kgS / kgA;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
