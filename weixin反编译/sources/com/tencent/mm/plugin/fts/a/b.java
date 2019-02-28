package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public abstract class b implements j {
    private boolean fis;
    public boolean mPA;

    public abstract boolean Bg();

    public abstract boolean onCreate();

    public b() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", getName());
    }

    public final boolean aNB() {
        return this.fis;
    }

    public final synchronized void create() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.fis));
        if (!this.fis && onCreate()) {
            x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.fis = true;
        }
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.mPA), Boolean.valueOf(this.fis));
        if (!this.mPA && this.fis && Bg()) {
            x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.mPA = true;
        }
    }

    public void a(String str, j jVar, int i, HashMap<String, String> hashMap) {
    }

    public void addSOSHistory(String str) {
    }

    public void deleteSOSHistory(String str) {
    }

    public void deleteSOSHistory() {
    }

    public a a(g gVar) {
        return null;
    }
}
