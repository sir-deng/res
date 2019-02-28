package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class e<T> {
    private ag handler;
    List<Integer> rwn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.e$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean rwr;

        AnonymousClass3(boolean z) {
            this.rwr = z;
        }

        public final void run() {
            if (this.rwr) {
                e eVar = e.this;
                if (eVar.rwn.size() > 1) {
                    eVar.rwn.remove(0);
                }
            }
        }
    }

    public abstract void bV(List<T> list);

    public abstract List<T> bzD();

    public e() {
        this.handler = null;
        this.rwn = new LinkedList();
        this.handler = ae.aOA();
        this.rwn.clear();
    }

    protected final void fG(final boolean z) {
        int i = z ? 0 : 1;
        if (i == 1) {
            boolean z2;
            for (Integer intValue : this.rwn) {
                if (intValue.intValue() == 1) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (z2) {
                x.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            x.d("MicroMsg.AdapterLoader", "thread load" + this.rwn.size());
        } else {
            x.d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.rwn.size() <= 1) {
            this.rwn.add(Integer.valueOf(i));
            if (z) {
                ae.bvP().post(new Runnable() {
                    public final void run() {
                        e.this.b(true, e.this.bzD());
                    }
                });
            } else {
                b(true, bzD());
            }
        }
    }

    final void b(boolean z, final List<T> list) {
        this.handler.post(new Runnable(true) {
            public final void run() {
                e.this.bV(list);
                ae.bvP().post(new AnonymousClass3(true));
            }
        });
    }
}
