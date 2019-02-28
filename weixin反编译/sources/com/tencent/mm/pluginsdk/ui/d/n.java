package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;

public class n extends m {
    private Object tag;
    private a vBU;

    public interface a {
        void bK(Object obj);
    }

    public n(Object obj, a aVar) {
        super(2, null);
        this.vBU = aVar;
        this.tag = obj;
    }

    public n(Object obj, a aVar, int i) {
        super(2, null);
        this.vBU = aVar;
        this.tag = obj;
        zJ(i);
    }

    public void onClick(View view) {
        if (this.vBU != null) {
            this.vBU.bK(this.tag);
        }
    }
}
