package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import java.util.ArrayList;
import java.util.Iterator;

public final class p {
    final ArrayList<a> ucm = new ArrayList();

    private static class a {
        final f ucn;
        final n uco;
        final boolean ucp;

        a(Object obj, n nVar, boolean z) {
            this.ucn = (f) obj;
            this.uco = nVar;
            this.ucp = z;
        }
    }

    public final void a(ArrayList<Object> arrayList, n nVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof f) {
                this.ucm.add(new a(next, nVar, true));
            }
        }
    }

    public final void a(Object obj, n nVar) {
        this.ucm.add(new a(obj, nVar, false));
    }

    public final void c(Spannable spannable) {
        Iterator it = this.ucm.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            f fVar = aVar.ucn;
            int i = aVar.uco.Ww;
            int spanStart;
            if (aVar.ucp) {
                spanStart = spannable.getSpanStart(fVar);
                if (spanStart >= 0 && spanStart < i) {
                    spannable.setSpan(fVar.bYj(), spanStart, i, 34);
                }
                spannable.removeSpan(fVar);
            } else {
                n nVar = aVar.uco;
                int i2 = aVar.uco.wq;
                spanStart = (nVar.ucf && nVar.isEmpty()) ? 34 : (nVar.ucf && nVar.uce) ? 18 : nVar.ucf ? 34 : 33;
                if (i2 > spannable.length()) {
                    i2 = spannable.length();
                }
                spannable.setSpan(fVar, i, i2, spanStart);
            }
        }
    }
}
