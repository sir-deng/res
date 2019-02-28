package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class s {
    public c oBP = c.Stop;
    SparseArray<WeakReference<b>> oBQ = new SparseArray();
    private ag oBR = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            b bVar;
            if (257 == message.what) {
                c cVar = (c) message.obj;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < s.this.oBQ.size()) {
                        if (((b) ((WeakReference) s.this.oBQ.valueAt(i2)).get()) != null) {
                            int[] iArr = AnonymousClass2.oBT;
                            cVar.ordinal();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            } else if (258 == message.what) {
                bVar = (b) message.obj;
                if (bVar != null) {
                    s.this.oBQ.put(bVar.hashCode(), new WeakReference(bVar));
                }
            } else if (259 == message.what) {
                bVar = (b) message.obj;
                if (bVar != null) {
                    s.this.oBQ.remove(bVar.hashCode());
                }
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.s$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] oBT = new int[c.values().length];

        static {
            try {
                oBT[c.Start.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                oBT[c.Stop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                oBT[c.Sent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                oBT[c.Error.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(c cVar) {
        x.i("MicroMsg.SightMediaStatusHandler", "status change to %s", cVar.toString());
        this.oBP = cVar;
        this.oBR.sendMessage(this.oBR.obtainMessage(257, cVar));
    }
}
