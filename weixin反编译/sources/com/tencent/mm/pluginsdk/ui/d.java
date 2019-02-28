package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d implements OnScrollListener {
    private OnScrollListener vpW;
    private ArrayList<WeakReference<a>> vpX;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public d() {
        this(null);
    }

    public d(OnScrollListener onScrollListener) {
        this.vpX = new ArrayList();
        this.vpW = onScrollListener;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.vpW != null) {
            this.vpW.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            kZ(true);
        } else {
            kZ(false);
        }
        if (this.vpW != null) {
            this.vpW.onScrollStateChanged(absListView, i);
        }
    }

    public final void a(a aVar) {
        this.vpX.add(new WeakReference(aVar));
    }

    private void kZ(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.vpX.size()) {
                WeakReference weakReference = (WeakReference) this.vpX.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onScrollStateChanged(z);
                    } else {
                        this.vpX.remove(i2);
                    }
                } else {
                    this.vpX.remove(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
