package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.au;

public abstract class a {
    protected b yLG;

    public a(b bVar) {
        this.yLG = bVar;
    }

    public void detach() {
        this.yLG = null;
    }

    public boolean a(j jVar, au auVar, int i) {
        return false;
    }

    public final j Gc(int i) {
        if (this.yLG == null) {
            return null;
        }
        View Fj = this.yLG.Fj(i);
        return Fj == null ? null : (j) Fj.getTag();
    }

    public final void Gd(int i) {
        if (this.yLG != null) {
            View Fj = this.yLG.Fj(i);
            if (Fj != null && Fj.getTag() != null) {
                a((j) Fj.getTag(), this.yLG.Ge(i), i);
            }
        }
    }
}
