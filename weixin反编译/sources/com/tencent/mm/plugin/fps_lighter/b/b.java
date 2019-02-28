package com.tencent.mm.plugin.fps_lighter.b;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.plugin.fps_lighter.d.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class b implements a {
    boolean isInit = false;
    Timer jBG = new Timer();
    HashMap<String, LinkedList<d>> mGp = new HashMap();

    public final void L(LinkedList<d> linkedList) {
        synchronized (this.mGp) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                x.i("MicroMsg.FPSAnalyser.result", dVar.toString());
                String aLy = dVar.aLy();
                if (!this.mGp.containsKey(aLy)) {
                    this.mGp.put(aLy, new LinkedList());
                }
                ((LinkedList) this.mGp.get(aLy)).add(dVar);
            }
        }
        linkedList.clear();
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                GMTrace.releaseBuffer();
            }
        });
    }
}
