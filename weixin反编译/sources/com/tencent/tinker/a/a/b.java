package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class b extends a<b> {
    public int[] Ant;

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        int length = this.Ant.length;
        int length2 = bVar.Ant.length;
        if (length != length2) {
            return c.fL(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.Ant[length2] != bVar.Ant[length2]) {
                return c.fL(this.Ant[length2], bVar.Ant[length2]);
            }
        }
        return 0;
    }

    public b(int i, int[] iArr) {
        super(i);
        this.Ant = iArr;
    }
}
