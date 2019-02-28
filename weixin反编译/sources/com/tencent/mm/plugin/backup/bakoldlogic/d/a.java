package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;

public final class a {
    ag handler = new ag(Looper.getMainLooper());
    public LinkedList<a> kvt = new LinkedList();

    class a {
        public Object obj;
        public int type;

        public a(int i, Object obj) {
            this.type = i;
            this.obj = obj;
        }
    }

    public final boolean e(final int i, final Object obj) {
        this.handler.post(new Runnable() {
            public final void run() {
                a.this.kvt.add(new a(i, obj));
            }
        });
        return true;
    }
}
