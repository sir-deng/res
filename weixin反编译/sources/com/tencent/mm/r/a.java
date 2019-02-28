package com.tencent.mm.r;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a gNe;
    public b gNf = new b();
    ArrayList<WeakReference<a>> gNg = new ArrayList();
    private final int gNh = 0;
    private final int gNi = 1;
    private ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what == 0 && (message.obj instanceof b)) {
                b bVar = (b) message.obj;
                if (bVar.gNl != null) {
                    a aVar = a.this;
                    com.tencent.mm.storage.w.a aVar2 = bVar.gNl;
                    ArrayList arrayList = null;
                    Iterator it = aVar.gNg.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference == null || weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        } else {
                            ((a) weakReference.get()).b(aVar2);
                        }
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            aVar.gNg.remove((WeakReference) it2.next());
                        }
                        arrayList.clear();
                    }
                } else {
                    a.a(a.this, bVar.gNk, bVar.type, bVar.value);
                }
            }
            if (message.what == 1 && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.gNl != null) {
                    a.a(a.this, cVar.gNn, cVar.gNl);
                } else {
                    a.a(a.this, cVar.gNm, cVar.gNk);
                }
            }
        }
    };
    public boolean initialized = false;

    class c {
        int gNk;
        com.tencent.mm.storage.w.a gNl;
        int gNm;
        com.tencent.mm.storage.w.a gNn;

        public c(int i, int i2) {
            this.gNm = i;
            this.gNk = i2;
        }

        public c(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
            this.gNn = aVar;
            this.gNl = aVar2;
        }

        public c(int i, com.tencent.mm.storage.w.a aVar) {
            this.gNm = i;
            this.gNl = aVar;
        }
    }

    public interface a {
        void b(com.tencent.mm.storage.w.a aVar);

        void gf(int i);

        void gg(int i);
    }

    class b {
        int gNk;
        com.tencent.mm.storage.w.a gNl;
        int type;
        String value;

        public b(int i, int i2, String str) {
            this.gNk = i;
            this.type = i2;
            this.value = str;
        }

        public b(com.tencent.mm.storage.w.a aVar, int i, String str) {
            this.gNl = aVar;
            this.type = i;
            this.value = str;
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        ArrayList arrayList = null;
        Iterator it = aVar.gNg.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).gg(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.gNg.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2, String str) {
        ArrayList arrayList = null;
        Iterator it = aVar.gNg.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).gf(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.gNg.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.storage.w.a aVar2, com.tencent.mm.storage.w.a aVar3) {
        ArrayList arrayList = null;
        Iterator it = aVar.gNg.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                weakReference.get();
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.gNg.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    public final void init() {
        this.initialized = true;
        this.gNf.gNt = g.Dq().Db();
    }

    public final void o(int i, boolean z) {
        a(i, 1, !z ? "0" : "1");
    }

    public final void a(com.tencent.mm.storage.w.a aVar, boolean z) {
        a(aVar, 1, !z ? "0" : "1");
    }

    public final void p(int i, boolean z) {
        a(i, 2, !z ? "0" : "1");
    }

    public final void b(com.tencent.mm.storage.w.a aVar, boolean z) {
        a(aVar, 2, !z ? "0" : "1");
    }

    private void a(int i, int i2, String str) {
        if (this.initialized) {
            b bVar = this.gNf;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            com.tencent.mm.r.b.a gk = bVar.gk(i);
            if (gk == null) {
                gk = bVar.a(i, i2, "", "");
                bVar.gNo.put(i, gk);
                bVar.a(gk);
            }
            gk.value = str;
            gk.type = i2;
            gk.fsK = bVar.Bw();
            bVar.a(gk);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(i, i2, str)));
            return;
        }
        x.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    private void a(com.tencent.mm.storage.w.a aVar, int i, String str) {
        if (this.initialized) {
            b bVar = this.gNf;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", aVar, Integer.valueOf(i), str);
            com.tencent.mm.r.b.a f = bVar.f(aVar);
            if (f == null) {
                f = bVar.a(aVar, i, "", "");
                bVar.gNp.put(aVar, f);
                bVar.a(f);
            }
            f.value = str;
            f.type = i;
            f.fsK = bVar.Bw();
            bVar.a(f);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(aVar, i, str)));
            return;
        }
        x.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    public final boolean aQ(int i, int i2) {
        if (this.initialized) {
            com.tencent.mm.r.b.a x = this.gNf.x(i, i2, 1);
            if (x == null || parseInt(x.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.initialized) {
            com.tencent.mm.r.b.a a = this.gNf.a(aVar, aVar2, 1);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean aR(int i, int i2) {
        if (this.initialized) {
            com.tencent.mm.r.b.a x = this.gNf.x(i, i2, 2);
            if (x == null || parseInt(x.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean b(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.initialized) {
            com.tencent.mm.r.b.a a = this.gNf.a(aVar, aVar2, 2);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar, int i) {
        if (this.initialized) {
            com.tencent.mm.r.b.a aVar2;
            b bVar = this.gNf;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", aVar, Integer.valueOf(i), Integer.valueOf(2));
            com.tencent.mm.r.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
                aVar2 = null;
            } else if ((f.type & 2) == 0) {
                x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
                aVar2 = null;
            } else {
                com.tencent.mm.r.b.b gl = bVar.gl(i);
                if (gl != null) {
                    String str = (String) gl.gNx.get(aVar.name());
                    if (str == null || !str.equals(f.fsK)) {
                        if (str == null) {
                            gl.gNx.put(aVar.name(), bVar.Bw());
                            bVar.a(gl);
                        }
                        aVar2 = f;
                    } else {
                        aVar2 = null;
                    }
                } else {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
                    aVar2 = null;
                }
            }
            if (aVar2 == null) {
                return false;
            }
            if (parseInt(aVar2.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final void aS(int i, int i2) {
        if (this.initialized) {
            b bVar = this.gNf;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", Integer.valueOf(i), Integer.valueOf(i2));
            com.tencent.mm.r.b.a gk = bVar.gk(i);
            if (gk == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.r.b.b gl = bVar.gl(i2);
                if (gl == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    gl = bVar.gj(i2);
                    bVar.gNq.put(i2, gl);
                }
                gl.gNw.put(i, gk.fsK);
                bVar.a(gl);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(i2, i)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void c(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.initialized) {
            b bVar = this.gNf;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", aVar, aVar2);
            com.tencent.mm.r.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.r.b.b g = bVar.g(aVar2);
                if (g == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    g = bVar.e(aVar2);
                    bVar.gNr.put(aVar2, g);
                }
                g.gNx.put(aVar.name(), f.fsK);
                bVar.a(g);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(aVar2, aVar)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void b(com.tencent.mm.storage.w.a aVar, int i) {
        if (this.initialized) {
            b bVar = this.gNf;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", aVar, Integer.valueOf(i));
            com.tencent.mm.r.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.r.b.b gl = bVar.gl(i);
                if (gl == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    gl = bVar.gj(i);
                    bVar.gNq.put(i, gl);
                }
                gl.gNx.put(aVar.name(), f.fsK);
                bVar.a(gl);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(i, aVar)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar) {
        if (this.initialized) {
            com.tencent.mm.r.b.a f = this.gNf.f(aVar);
            if (f == null || parseInt(f.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
        return false;
    }

    public static int parseInt(String str) {
        if (bi.oN(str)) {
            return 0;
        }
        return bi.Wo(str);
    }

    public final void a(a aVar) {
        if (this.initialized) {
            this.gNg.add(new WeakReference(aVar));
        } else {
            x.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
        }
    }

    public final void b(a aVar) {
        if (this.initialized) {
            ArrayList arrayList = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gNg.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) this.gNg.get(i2);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(weakReference);
                }
                i = i2 + 1;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.gNg.remove((WeakReference) it.next());
                }
                arrayList.clear();
                return;
            }
            return;
        }
        x.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
    }
}
