package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class y extends u {
    private final x ypq;

    public abstract View d(int i, View view);

    public y() {
        this(new x());
    }

    private y(x xVar) {
        this.ypq = xVar;
        SparseArray[] sparseArrayArr = new SparseArray[1];
        for (int i = 0; i <= 0; i++) {
            sparseArrayArr[0] = new SparseArray();
        }
        xVar.ypo = 1;
        xVar.ypp = sparseArrayArr[0];
        xVar.ypn = sparseArrayArr;
    }

    public void notifyDataSetChanged() {
        int length;
        x xVar = this.ypq;
        View[] viewArr = xVar.ypl;
        int[] iArr = xVar.ypm;
        Object obj = xVar.ypo > 1 ? 1 : null;
        SparseArray sparseArray = xVar.ypp;
        for (length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int i = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if ((i >= 0 ? 1 : null) != null) {
                    if (obj != null) {
                        sparseArray = xVar.ypn[i];
                    }
                    sparseArray.put(length, view);
                    if (VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        length = xVar.ypl.length;
        int i2 = xVar.ypo;
        SparseArray[] sparseArrayArr = xVar.ypn;
        for (int i3 = 0; i3 < i2; i3++) {
            SparseArray sparseArray2 = sparseArrayArr[i3];
            int size = sparseArray2.size();
            int i4 = size - length;
            size--;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = size - 1;
                sparseArray2.remove(sparseArray2.keyAt(size));
                i5++;
                size = i6;
            }
        }
        super.notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        x xVar = this.ypq;
        View a = xVar.ypo == 1 ? x.a(xVar.ypp, i) : xVar.ypn.length > 0 ? x.a(xVar.ypn[0], i) : null;
        a = d(i, a);
        viewGroup.addView(a);
        return a;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        x xVar = this.ypq;
        if (xVar.ypo == 1) {
            xVar.ypp.put(i, view);
        } else {
            xVar.ypn[0].put(i, view);
        }
        if (VERSION.SDK_INT >= 14) {
            view.setAccessibilityDelegate(null);
        }
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }
}
