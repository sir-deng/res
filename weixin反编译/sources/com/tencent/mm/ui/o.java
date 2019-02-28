package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class o<T> extends BaseAdapter implements com.tencent.mm.sdk.e.j.a, b {
    public Context context;
    public int count;
    private ag pLF = new ag(Looper.getMainLooper());
    private Cursor xJZ = null;
    public T xQL;
    public Map<Integer, T> xQM = null;
    public a xQN;
    private int xQO = 0;
    private int xQP = 0;
    private int xQQ = 0;
    private Runnable xQR = new Runnable() {
        public final void run() {
            if (o.this.xQO != 0) {
                x.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", Integer.valueOf(o.this.xQO), Integer.valueOf(o.b(o.this)));
                o.this.pLF.removeCallbacks(o.this.xQR);
                if (20 > o.this.xQQ) {
                    o.this.pLF.postDelayed(o.this.xQR, 100);
                    return;
                } else {
                    x.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", Integer.valueOf(o.this.xQO), Integer.valueOf(o.this.xQQ));
                }
            }
            x.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
            o.this.xQQ = 0;
            o.this.cnC();
        }
    };

    public interface a {
        void XE();

        void XF();
    }

    public abstract void XH();

    public abstract void XI();

    public abstract T a(T t, Cursor cursor);

    static /* synthetic */ int b(o oVar) {
        int i = oVar.xQQ + 1;
        oVar.xQQ = i;
        return i;
    }

    public o(Context context, T t) {
        this.xQL = t;
        this.context = context;
        this.count = -1;
    }

    public final Cursor getCursor() {
        if (this.xJZ == null || this.xJZ.isClosed()) {
            XI();
            Assert.assertNotNull(this.xJZ);
        }
        return this.xJZ;
    }

    public final void setCursor(Cursor cursor) {
        this.xJZ = cursor;
        this.count = -1;
    }

    public final void mb(boolean z) {
        if (z) {
            if (this.xQM == null) {
                this.xQM = new HashMap();
            }
        } else if (this.xQM != null) {
            this.xQM.clear();
            this.xQM = null;
        }
    }

    public void aUU() {
        if (this.xQM != null) {
            this.xQM.clear();
        }
        if (this.xJZ != null) {
            this.xJZ.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + aSm();
    }

    public final int aDx() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i) {
        return 0;
    }

    public void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public void a(String str, l lVar) {
        cnC();
    }

    private void cnC() {
        x.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        if (this.xQN != null) {
            this.xQN.XF();
        }
        aUU();
        XH();
        if (this.xQN != null) {
            this.xQN.XE();
        }
    }

    public T getItem(int i) {
        if (rq(i)) {
            return aSn();
        }
        T t;
        if (this.xQM != null) {
            t = this.xQM.get(Integer.valueOf(i));
            if (t != null) {
                return t;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.xQM == null) {
            return a(this.xQL, getCursor());
        }
        t = a(null, getCursor());
        this.xQM.put(Integer.valueOf(i), t);
        return t;
    }

    public boolean rq(int i) {
        return i >= this.count && i < this.count + aSm();
    }

    public int aSm() {
        return 0;
    }

    public T aSn() {
        return this.xQL;
    }
}
