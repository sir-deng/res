package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.List;

public abstract class a<T> {
    protected String fEe;
    protected int ttH;

    public abstract void cm(List<j> list);

    public a(String str, int i) {
        this.fEe = str;
        this.ttH = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean z;
        if (this.fEe == aVar.fEe || (this.fEe != null && this.fEe.equalsIgnoreCase(aVar.fEe))) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.ttH == this.ttH && z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
