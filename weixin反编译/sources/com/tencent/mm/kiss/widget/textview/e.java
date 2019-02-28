package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;

public final class e {
    private final d[] gVv = new d[3];
    private final Object mLock = new Object();
    private int wt;

    public final d Ek() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.wt > 0) {
                int i = this.wt - 1;
                dVar = this.gVv[i];
                this.gVv[i] = null;
                this.wt--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        synchronized (this.mLock) {
            boolean z;
            for (int i = 0; i < this.wt; i++) {
                if (this.gVv[i] == dVar) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            }
            dVar.gVi = null;
            dVar.gVj = null;
            dVar.gVk = 0;
            dVar.gVl = 0;
            dVar.gVm = new TextPaint();
            dVar.width = 0;
            dVar.gVn = Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.gVo = null;
            dVar.gVp = 0;
            dVar.maxLines = Integer.MAX_VALUE;
            dVar.gVq = null;
            dVar.gVr = 0.0f;
            dVar.gVs = 1.0f;
            dVar.gVt = false;
            dVar.maxLength = 0;
            dVar.gVu = null;
            if (this.wt < this.gVv.length) {
                this.gVv[this.wt] = dVar;
                this.wt++;
                return true;
            }
            return false;
        }
    }
}
