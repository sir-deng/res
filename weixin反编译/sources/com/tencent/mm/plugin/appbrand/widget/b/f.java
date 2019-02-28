package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;

public final class f {
    public final ViewGroup kbR;
    public final LinkedList<View> kbS = new LinkedList();
    public a kbT;

    private static final class a {
        public final long kbU;
        public final long kbV;

        public /* synthetic */ a(long j, long j2, byte b) {
            this(j, j2);
        }

        private a(long j, long j2) {
            this.kbU = j;
            this.kbV = j2;
        }
    }

    public f(ViewGroup viewGroup) {
        this.kbR = viewGroup;
    }
}
