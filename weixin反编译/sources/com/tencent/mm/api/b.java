package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends FrameLayout {
    public l fdI = new l() {
        public final void a(d dVar) {
            x.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", dVar.name());
        }

        public final void a(d dVar, int i) {
            x.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", dVar.name(), Integer.valueOf(i));
        }

        public final void aF(boolean z) {
        }
    };

    public abstract void a(e eVar);

    public abstract void aC(boolean z);

    public abstract void aD(boolean z);

    public abstract void aE(boolean z);

    public b(Context context) {
        super(context);
    }
}
