package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;

final class ah {
    static int a(q qVar, ab abVar, View view, View view2, h hVar, boolean z, boolean z2) {
        if (hVar.getChildCount() == 0 || qVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (qVar.getItemCount() - Math.max(h.bd(view), h.bd(view2))) - 1) : Math.max(0, Math.min(h.bd(view), h.bd(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(abVar.aV(view2) - abVar.aU(view))) / ((float) (Math.abs(h.bd(view) - h.bd(view2)) + 1)))) + ((float) (abVar.fj() - abVar.aU(view))));
    }

    static int a(q qVar, ab abVar, View view, View view2, h hVar, boolean z) {
        if (hVar.getChildCount() == 0 || qVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(h.bd(view) - h.bd(view2)) + 1;
        }
        return Math.min(abVar.fl(), abVar.aV(view2) - abVar.aU(view));
    }

    static int b(q qVar, ab abVar, View view, View view2, h hVar, boolean z) {
        if (hVar.getChildCount() == 0 || qVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return qVar.getItemCount();
        }
        return (int) ((((float) (abVar.aV(view2) - abVar.aU(view))) / ((float) (Math.abs(h.bd(view) - h.bd(view2)) + 1))) * ((float) qVar.getItemCount()));
    }
}
