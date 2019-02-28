package com.tencent.mm.ap;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d implements e, f {
    List<b> hBo = new LinkedList();
    private HashSet<b> hBp = new HashSet();
    b hBq = null;
    private k hBr = null;
    public boolean hBs = false;

    private static class b {
        private int aen = 0;
        public long hBt;
        public long hBu;
        public int hBv;
        public int hBw;
        public List<c> hBx;

        public b(long j, long j2, int i) {
            this.hBt = j;
            this.hBu = j2;
            this.hBv = i;
            this.hBw = 0;
        }

        public final boolean a(a aVar, Object obj) {
            if (this.hBx == null) {
                this.hBx = new LinkedList();
            }
            c cVar = new c(aVar, obj);
            if (this.hBx.contains(cVar)) {
                x.d("ModelImage.DownloadImgService.Task", "task item already exists");
                return false;
            }
            this.hBx.add(cVar);
            return true;
        }

        public final boolean b(a aVar) {
            c cVar = new c(aVar, null);
            if (!this.hBx.contains(cVar)) {
                return false;
            }
            this.hBx.remove(cVar);
            return true;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.hBt == this.hBt && bVar.hBu == this.hBu && bVar.hBv == this.hBv) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.aen == 0) {
                this.aen = (this.hBt + "_" + this.hBu + "_" + this.hBv).hashCode();
            }
            return this.aen;
        }
    }

    private static class c {
        a hBy;
        Object hBz;

        public c(a aVar, Object obj) {
            this.hBy = aVar;
            this.hBz = obj;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            if (this.hBy == ((c) obj).hBy) {
                return true;
            }
            return false;
        }
    }

    public interface a {
        void a(long j, long j2, int i, int i2, Object obj);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar);
    }

    public d() {
        g.Dp().gRu.a(109, (e) this);
    }

    public final boolean a(long j, long j2, int i, Object obj, int i2, a aVar) {
        return a(j, j2, i, obj, i2, aVar, -1) >= 0;
    }

    public final int a(long j, long j2, int i, Object obj, int i2, a aVar, int i3) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return -1;
        }
        b bVar = new b(j, j2, i);
        bVar.hBw = i2;
        if (this.hBp.contains(bVar)) {
            x.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            return -2;
        } else if (this.hBq != null && bVar.equals(this.hBq)) {
            return this.hBq.a(aVar, obj) ? 0 : -3;
        } else {
            int indexOf = this.hBo.indexOf(bVar);
            if (indexOf >= 0 && indexOf < this.hBo.size()) {
                return ((b) this.hBo.get(indexOf)).a(aVar, obj) ? 0 : -4;
            } else {
                x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ")");
                bVar.a(aVar, obj);
                this.hBo.add(bVar);
                hL(i3);
                return 0;
            }
        }
    }

    public final boolean a(long j, long j2, int i) {
        b bVar = new b(j, j2, i);
        if ((this.hBq == null || !this.hBq.equals(bVar)) && this.hBo.indexOf(bVar) < 0) {
            return false;
        }
        return true;
    }

    public final boolean a(long j, long j2, a aVar) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return false;
        }
        b bVar = new b(j, j2, 1);
        b bVar2 = null;
        if (this.hBq == null || !this.hBq.equals(bVar)) {
            int indexOf = this.hBo.indexOf(bVar);
            if (-1 != indexOf) {
                bVar2 = (b) this.hBo.get(indexOf);
            }
        } else {
            bVar2 = this.hBq;
        }
        if (bVar2 != null) {
            bVar2.b(aVar);
            a(bVar2);
            x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
            return true;
        }
        x.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
        return false;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return;
        }
        x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.hBs = true;
        if (this.hBq != null) {
            this.hBq.b(aVar);
            a(this.hBq);
        }
        List<b> linkedList = new LinkedList();
        for (b add : this.hBo) {
            linkedList.add(add);
        }
        for (b add2 : linkedList) {
            add2.b(aVar);
            a(add2);
        }
        Pi();
    }

    private boolean a(b bVar) {
        if (bVar == null || bVar.hBx.size() > 0) {
            return false;
        }
        return b(bVar);
    }

    public final boolean m(long j, long j2) {
        return b(new b(j, j2, 1));
    }

    final boolean b(b bVar) {
        if (bVar == null) {
            x.e("ModelImage.DownloadImgService", "task is null");
            return false;
        }
        x.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.hBt + ", " + bVar.hBu + ", " + bVar.hBv + ")");
        if (this.hBq != null && this.hBq.equals(bVar)) {
            g.Dp().gRu.c(this.hBr);
            this.hBr = null;
            c(this.hBq);
            this.hBq = null;
            hL(-1);
            return true;
        } else if (!this.hBo.contains(bVar)) {
            return false;
        } else {
            b bVar2 = (b) this.hBo.get(this.hBo.indexOf(bVar));
            if (bVar2 != null) {
                this.hBo.remove(bVar2);
                c(bVar2);
            }
            return true;
        }
    }

    private static void c(b bVar) {
        if (bVar == null) {
            x.e("ModelImage.DownloadImgService", "task is null");
        } else if (bVar.hBx == null) {
            x.e("ModelImage.DownloadImgService", "task callback list is null");
        } else {
            for (c cVar : bVar.hBx) {
                if (cVar.hBy != null) {
                    cVar.hBy.a(bVar.hBt, bVar.hBu, bVar.hBv, bVar.hBw, cVar.hBz);
                }
            }
        }
    }

    public final void Pi() {
        this.hBs = false;
        hL(-1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.hBr != kVar) {
            x.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        this.hBp.add(new b(this.hBq.hBt, this.hBq.hBu, this.hBq.hBv));
        x.i("ModelImage.DownloadImgService", "scene end, (" + this.hBq.hBt + ", " + this.hBq.hBu + ", " + this.hBq.hBv + ")");
        for (c cVar : this.hBq.hBx) {
            if (cVar.hBy != null) {
                cVar.hBy.a(this.hBq.hBt, this.hBq.hBu, this.hBq.hBv, this.hBq.hBw, cVar.hBz, i, i2, str, kVar);
            }
        }
        this.hBq = null;
        this.hBr = null;
        hL(-1);
    }

    public final void a(int i, int i2, k kVar) {
        if (this.hBr != kVar) {
            x.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        for (c cVar : this.hBq.hBx) {
            if (cVar.hBy != null) {
                cVar.hBy.a(this.hBq.hBt, this.hBq.hBu, this.hBq.hBv, this.hBq.hBw, cVar.hBz, i, i2, kVar);
            }
        }
    }

    private void hL(int i) {
        if (this.hBq == null && this.hBo.size() > 0 && true != this.hBs) {
            this.hBq = (b) this.hBo.get(0);
            this.hBo.remove(0);
            this.hBr = new k(this.hBq.hBt, this.hBq.hBu, this.hBq.hBv, this, i);
            this.hBr.hDc = this.hBq.hBw;
            x.i("ModelImage.DownloadImgService", "do scene, (" + this.hBq.hBt + ", " + this.hBq.hBu + ", " + this.hBq.hBv + ")");
            g.Dp().gRu.a(this.hBr, 0);
        }
    }
}
