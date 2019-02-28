package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.b.b;
import com.tencent.mm.plugin.emoji.sync.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public final class a<T extends d> {
    public BKGLoaderManager lFb;

    public enum a {
        Default,
        Syncing,
        PauseSync,
        PauseSyncOffline,
        PauseSyncSDCardFull,
        FinishSync
    }

    public a() {
        com.tencent.mm.plugin.emoji.sync.b.a aVar = new com.tencent.mm.plugin.emoji.sync.b.a();
        aVar.lFl = new b(aVar.lFj, aVar.lFj, TimeUnit.MILLISECONDS, new com.tencent.mm.ap.a.e.a(), new c(aVar.hEQ, "bkg_loader_"));
        a(new b(aVar));
    }

    private synchronized void a(b bVar) {
        if (this.lFb == null) {
            this.lFb = new BKGLoaderManager(bVar);
        } else {
            x.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
        }
    }

    public final void s(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.lFb;
        bKGLoaderManager.lFo = false;
        if (bKGLoaderManager.lFy == null) {
            bKGLoaderManager.lFy = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                if (dVar == null || bKGLoaderManager.lFy.contains(dVar)) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", dVar.getKey());
                } else {
                    bKGLoaderManager.lFy.add(dVar);
                }
            }
        }
    }

    public final void t(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.lFb;
        if (bKGLoaderManager.lFA == null) {
            bKGLoaderManager.lFA = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (bKGLoaderManager.lFw != null && bKGLoaderManager.lFw.equals(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    x.i(str, str2, objArr);
                } else if (dVar == null || bKGLoaderManager.lFA.contains(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    x.i(str, str2, objArr);
                } else {
                    bKGLoaderManager.lFA.add(dVar);
                }
            }
        }
    }

    public final a aCF() {
        BKGLoaderManager bKGLoaderManager = this.lFb;
        if (bKGLoaderManager.lFp && bKGLoaderManager.lFu) {
            return a.PauseSyncSDCardFull;
        }
        if (BKGLoaderManager.aBw() && !bKGLoaderManager.lFp && i.aCl().lCw.clv() > 0) {
            return a.PauseSync;
        }
        if (!ao.isConnected(ad.getContext()) && !bKGLoaderManager.lFp && i.aCl().lCw.clv() > 0) {
            return a.PauseSyncOffline;
        }
        if (ao.isConnected(ad.getContext())) {
            if (bKGLoaderManager.lFp && bKGLoaderManager.lFv) {
                return a.Syncing;
            }
            if (bKGLoaderManager.lFs) {
                return a.FinishSync;
            }
        }
        return a.Default;
    }

    public final void ey(boolean z) {
        this.lFb.lFv = z;
    }
}
