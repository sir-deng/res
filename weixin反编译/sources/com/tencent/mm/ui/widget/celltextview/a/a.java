package com.tencent.mm.ui.widget.celltextview.a;

import android.graphics.Paint;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static Paint zGf = new Paint();
    public String kav;
    public float nDj;
    public ArrayList<d> zFX;
    public ArrayList<c> zGd;
    public float zGe;

    public a(String str, float f, float f2) {
        this.kav = str;
        this.nDj = f;
        this.zGe = f2;
    }

    public final void am(ArrayList<d> arrayList) {
        if (arrayList != null) {
            if (this.zFX == null) {
                this.zFX = new ArrayList(arrayList.size());
            }
            this.zFX.addAll(arrayList);
        }
    }

    public final int hashCode() {
        int i = 0;
        Iterator it = this.zFX.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((d) it.next()).cAe() + i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        zGf.setTextSize(this.nDj);
        if (this.zGe == aVar.zGe && this.nDj == aVar.nDj && this.kav.equals(aVar.kav) && ((int) zGf.measureText(this.kav)) == ((int) zGf.measureText(aVar.kav))) {
            return true;
        }
        return false;
    }
}
