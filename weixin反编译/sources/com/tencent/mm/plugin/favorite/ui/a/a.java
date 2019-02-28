package com.tencent.mm.plugin.favorite.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.n;
import java.util.Set;

public abstract class a extends BaseAdapter implements OnItemClickListener {
    protected long lastUpdateTime;
    protected Set<Integer> mzS;
    protected n mzT;
    protected a mzU;
    protected int type;

    public interface a {
        void aJX();
    }

    public abstract void aKa();

    public abstract void aKb();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long aJY() {
        return this.lastUpdateTime;
    }

    public final void a(a aVar) {
        this.mzU = aVar;
    }

    public final void aJZ() {
        if (this.mzU != null) {
            this.mzU.aJX();
        }
    }

    public final void e(Set<Integer> set) {
        this.mzS = set;
    }

    public final void a(n nVar) {
        this.mzT = nVar;
    }
}
