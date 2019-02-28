package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i {
    List<o> gzt = new LinkedList();
    ag handler = new ag(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String nXJ;
        final /* synthetic */ String nXK;

        AnonymousClass10(String str, String str2) {
            this.nXJ = str;
            this.nXK = str2;
        }

        public final void run() {
            synchronized (i.this.gzt) {
                for (o dm : i.this.gzt) {
                    dm.dm(this.nXJ, this.nXK);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String lgX;

        AnonymousClass11(String str) {
            this.lgX = str;
        }

        public final void run() {
            synchronized (i.this.gzt) {
                Iterator it = i.this.gzt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public final void aWH() {
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o aWH : i.this.gzt) {
                        aWH.aWH();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass1.run();
        } else {
            this.handler.post(anonymousClass1);
        }
    }

    public final void M(final String str, final int i, final int i2) {
        Runnable anonymousClass5 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o M : i.this.gzt) {
                        M.M(str, i, i2);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass5.run();
        } else {
            this.handler.post(anonymousClass5);
        }
    }

    public final void sf(final int i) {
        Runnable anonymousClass7 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o sf : i.this.gzt) {
                        sf.sf(i);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass7.run();
        } else {
            this.handler.post(anonymousClass7);
        }
    }

    public final void Es(final String str) {
        Runnable anonymousClass8 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o Es : i.this.gzt) {
                        Es.Es(str);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass8.run();
        } else {
            this.handler.post(anonymousClass8);
        }
    }

    public final void j(final int i, final int i2, final String str) {
        Runnable anonymousClass9 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o j : i.this.gzt) {
                        j.j(i, i2, str);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass9.run();
        } else {
            this.handler.post(anonymousClass9);
        }
    }
}
