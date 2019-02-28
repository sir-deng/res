package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ap.o;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements a {
    int h = 300;
    HashMap<Long, WeakReference<ImageView>> nWF = new HashMap();
    HashMap<Long, b> nWG = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> nWH = new HashMap();
    HashMap<Long, WeakReference<ImageView>> nWI = new HashMap();
    HashMap<b, au> nWJ = new HashMap();
    HashMap<Long, Integer> nWK = new HashMap();
    HashSet<Long> nWL = new HashSet();
    int w = 300;

    public j() {
        start();
    }

    public final void start() {
        k aVY = l.aVY();
        if (this != null) {
            for (a equals : aVY.gzt) {
                if (equals(equals)) {
                    return;
                }
            }
            aVY.gzt.add(this);
            x.i("MicroMsg.StaticMapServer", "addMapCallBack " + aVY.gzt.size());
            if (aVY.gzt.size() == 1) {
                aVY.start();
            }
        }
    }

    public final void a(String str, com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.nWG.containsKey(Long.valueOf(bVar.vjD))) {
            au auVar = (au) this.nWJ.remove((b) this.nWG.get(Long.valueOf(bVar.vjD)));
            if (auVar != null) {
                WeakReference weakReference = (WeakReference) this.nWF.get(Long.valueOf(auVar.field_msgId));
                if (weakReference != null && weakReference.get() != null && this.nWK.containsKey(Long.valueOf(auVar.field_msgId))) {
                    ((ImageView) weakReference.get()).setImageBitmap(o.PC().a(auVar.field_msgId, str, ((Integer) this.nWK.remove(Long.valueOf(auVar.field_msgId))).intValue(), this.w, this.h, auVar.field_isSend == 0));
                    weakReference = (WeakReference) this.nWH.remove(Long.valueOf(auVar.field_msgId));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((ProgressBar) weakReference.get()).setVisibility(8);
                    }
                    WeakReference weakReference2 = (WeakReference) this.nWI.remove(Long.valueOf(auVar.field_msgId));
                    if (weakReference2 != null && weakReference2.get() != null) {
                        ((ImageView) weakReference2.get()).setVisibility(0);
                    }
                }
            }
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.nWG.containsKey(Long.valueOf(bVar.vjD))) {
            au auVar = (au) this.nWJ.remove((b) this.nWG.get(Long.valueOf(bVar.vjD)));
            if (auVar != null) {
                this.nWF.get(Long.valueOf(auVar.field_msgId));
                if (auVar == null) {
                    return;
                }
                if (auVar.gkJ < 0 || auVar.gkJ > 5) {
                    auVar.ff(0);
                    auVar.ff(auVar.gkJ + 1);
                    if (as.Hp()) {
                        as.Hm();
                        c.Fh().a(auVar.field_msgId, auVar);
                        x.i("MicroMsg.StaticMapMsgLogic", "on error count %d", Integer.valueOf(auVar.gkJ));
                    }
                }
            }
        }
    }
}
