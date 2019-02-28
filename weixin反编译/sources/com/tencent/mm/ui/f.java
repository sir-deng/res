package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mm.bx.a.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class f<K, T extends com.tencent.mm.bx.a.a> extends BaseAdapter {
    public String TAG = "MicroMsg.ConversationWithCacheAdapter";
    public Context context;
    private int nXQ;
    private int pageSize;
    public boolean xMU;
    public c xMV;
    private HashMap<K, b<K, T>> xMW;
    protected a xMX;
    public int xMY;
    public int xMZ;
    public boolean xNa;
    int xNb;
    private boolean xNc;
    private boolean xNd;
    private e xNe;
    public K xNf;

    public static class b<K, T> {
        public K object;
        public int xNi;
        public T xNj = null;

        public b(K k, int i, T t) {
            this.object = k;
            this.xNi = i;
        }

        public final int hashCode() {
            int i;
            int i2 = (this.xNi + 31) * 31;
            if (this.object == null) {
                i = 0;
            } else {
                i = this.object.hashCode();
            }
            return i + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.xNi != bVar.xNi) {
                return false;
            }
            if (this.object == null) {
                if (bVar.object != null) {
                    return false;
                }
                return true;
            } else if (this.object.equals(bVar.object)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private interface d {
        void cmR();
    }

    private class e {
        com.tencent.mm.ui.f$e.b xNk;
        private com.tencent.mm.ui.f$e.c xNl;
        LinkedList<Integer> xNm;
        int xNn;

        private class a {
            int xNo;

            public a(int i) {
                this.xNo = i;
            }
        }

        class c extends ag {
            long lastUpdateTime;
            long xNt;
            final int xNu = (hashCode() | 1910);
            final int xNv = (hashCode() | 1914);

            public c(Looper looper) {
                super(looper);
                e.this.xNm = new LinkedList();
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == this.xNv) {
                    removeMessages(this.xNu);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.xNt > ((long) f.this.xMY) || currentTimeMillis - this.xNt < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) f.this.xMZ)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                        e.a(e.this);
                    } else {
                        sendEmptyMessageDelayed(this.xNu, (long) f.this.xMY);
                    }
                    this.xNt = currentTimeMillis;
                } else if (message.what == this.xNu) {
                    e.a(e.this);
                }
            }
        }

        class b extends ag {
            boolean xNq;
            public final int xNr = 1;
            public final int xNs = 2;

            public b(Looper looper) {
                super(looper);
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (!this.xNq) {
                    synchronized (e.this) {
                        e.this.xNn = e.this.cmV();
                        x.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", Integer.valueOf(e.this.xNn));
                    }
                    if (message.what == 1) {
                        f.this.cmQ();
                    } else if (message.what == 2) {
                        f.this.a((c) message.obj, false, true);
                    }
                }
            }
        }

        static /* synthetic */ void a(e eVar) {
            int cmV;
            synchronized (eVar) {
                cmV = eVar.cmV();
                eVar.xNm.clear();
            }
            a aVar = new a(cmV);
            if (aVar.xNo == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                c cVar = new c(f.this.cmM());
                cmV = cVar.getCount();
                x.i(f.this.TAG, "newcursor fillCursor last : %d  count %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(cmV));
                b bVar = aVar.xNp.xNk;
                Message obtain = Message.obtain();
                obtain.obj = cVar;
                obtain.what = 2;
                bVar.sendMessage(obtain);
                return;
            }
            aVar.xNp.xNk.sendEmptyMessage(1);
        }

        public e() {
            cmS();
        }

        private void cmS() {
            this.xNk = new b(Looper.getMainLooper());
            this.xNl = new c(as.Dt().oFY.getLooper());
        }

        private void cmT() {
            c cVar = this.xNl;
            cVar.removeMessages(cVar.xNu);
            cVar.removeMessages(cVar.xNv);
            b bVar = this.xNk;
            bVar.xNq = true;
            bVar.removeMessages(1);
            bVar.removeMessages(2);
            this.xNm.clear();
            this.xNn = 0;
        }

        public final synchronized void cmU() {
            x.i(f.this.TAG, "newcursor resetQueue ");
            cmT();
            cmS();
        }

        public final synchronized void quit() {
            x.i(f.this.TAG, "newcursor quit ");
            cmT();
        }

        final int cmV() {
            if (this.xNm.size() > 1) {
                return 2;
            }
            if (this.xNm.size() == 1) {
                return ((Integer) this.xNm.get(0)).intValue();
            }
            return 0;
        }

        public final synchronized boolean cmW() {
            return this.xNn != 0;
        }

        final synchronized void cmX() {
            this.xNl.lastUpdateTime = System.currentTimeMillis();
        }

        final synchronized int cmY() {
            return this.xNn;
        }

        final synchronized void Ee(int i) {
            if (!this.xNm.contains(Integer.valueOf(i))) {
                this.xNm.add(Integer.valueOf(i));
            }
            this.xNn = cmV();
            c cVar = this.xNl;
            cVar.sendEmptyMessage(cVar.xNv);
        }
    }

    public interface a {
        void XE();

        void XF();
    }

    class c extends g<K, T> {
        public c(com.tencent.mm.bx.a.d<K> dVar) {
            super(dVar, f.this.pageSize);
        }

        public final T clO() {
            return f.this.clM();
        }

        public final ArrayList<T> ah(ArrayList arrayList) {
            return f.this.ah(arrayList);
        }
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract ArrayList<T> ah(ArrayList<K> arrayList);

    public abstract T clM();

    public abstract com.tencent.mm.bx.a.d<K> cmM();

    static /* synthetic */ boolean a(f fVar, HashMap hashMap) {
        for (b bVar : hashMap.values()) {
            if (bVar == null || bVar.xNi == 5) {
                if (bVar == fVar.xNf) {
                }
            }
            return false;
        }
        return true;
    }

    public /* synthetic */ Object getItem(int i) {
        return DV(i);
    }

    public final void a(a aVar) {
        this.xMX = aVar;
    }

    public final void cmJ() {
        this.xMX = null;
    }

    public f(Context context) {
        this(true, context);
        this.pageSize = 5000;
        x.i(this.TAG, "newCursor setPageSize %d", Integer.valueOf(5000));
    }

    private f(boolean z, Context context) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.xMU = true;
        this.xMY = 1000;
        this.xMZ = 3000;
        this.xNa = true;
        this.nXQ = 0;
        this.xNb = 0;
        this.xNf = null;
        this.context = context;
        this.xNc = true;
    }

    private f(Context context, int i, int i2) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.xMU = true;
        this.xMY = 1000;
        this.xMZ = 3000;
        this.xNa = true;
        this.nXQ = 0;
        this.xNb = 0;
        this.xNf = null;
        this.context = context;
        this.xNc = true;
        this.xNd = false;
        this.xMY = 800;
        this.xMZ = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    }

    public f(Context context, byte b) {
        this(context, 800, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
    }

    private void a(c cVar) {
        lW(false);
        this.xMV = cVar;
        this.xMV.getCount();
        cmK();
    }

    private void a(com.tencent.mm.bx.a.d<K> dVar) {
        lW(true);
        if (this.xMV == null || this.xMV.xKD != dVar) {
            if (!(this.xMV == null || this.xMV.isClosed())) {
                this.xMV.close();
                this.xMV = null;
            }
            this.xMV = new c(dVar);
            this.xMV.getCount();
            cmK();
            notifyDataSetChanged();
        }
    }

    private void cmK() {
        if (this.xNc) {
            int i = this.xMV.clE() ? 1 : 2;
            if (!(i == this.xNb || this.xNb == 0)) {
                if (this.xNe != null && this.xNe.cmW()) {
                    a(new c(cmM()), true, false);
                }
                x.i(this.TAG, "newcursor change update stats  %d ", Integer.valueOf(i));
            }
            this.xNb = i;
        }
    }

    public boolean clE() {
        if (this.xMV == null) {
            return false;
        }
        return this.xMV.clE();
    }

    public int getCount() {
        if (this.xMV == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(cmM());
            x.i(this.TAG, "newcursor createCursor last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        bi("getcount", false);
        return this.xMV.getCount();
    }

    public final int cmL() {
        if (this.xMV == null) {
            return 0;
        }
        com.tencent.mm.bx.a.d dVar = this.xMV.xKD;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof com.tencent.mm.bx.a.e) {
            return ((com.tencent.mm.bx.a.e) dVar).xKu[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    private void bi(String str, boolean z) {
        int i;
        if (this.nXQ == 0) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 == 0 && (this.xNa | z) != 0) {
            if (!z) {
                x.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", Boolean.valueOf(this.xNa), str, bi.chl());
            }
            lV(false);
        }
    }

    public final T DV(int i) {
        if (this.xMV == null) {
            a(cmM());
        }
        bi("getItem", false);
        this.xMV.xKD.moveToPosition(i);
        T DV = this.xMV.xKD.DV(i);
        if (DV != null) {
            DV.cix();
        } else {
            x.e(this.TAG, "newcursor getItem error %d", Integer.valueOf(i));
        }
        return DV;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final T cf(K k) {
        if (this.xMV == null) {
            return null;
        }
        return this.xMV.xKD.cf(k);
    }

    public final SparseArray<K>[] cmN() {
        if (this.xMV == null) {
            return null;
        }
        SparseArray[] clC = this.xMV.clC();
        SparseArray<K>[] sparseArrayArr = new SparseArray[clC.length];
        for (int i = 0; i < sparseArrayArr.length; i++) {
            sparseArrayArr[i] = new SparseArray();
            for (int i2 = 0; i2 < clC[i].size(); i2++) {
                sparseArrayArr[i].put(i2, clC[i].get(i2));
            }
        }
        return sparseArrayArr;
    }

    private void cmO() {
        this.xMW.clear();
        this.xMW.put(this.xNf, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lV(boolean r10) {
        /*
        r9 = this;
        r8 = 2;
        r3 = 1;
        r2 = 0;
        r0 = r9.xNd;
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        if (r10 == 0) goto L_0x006e;
    L_0x0009:
        r0 = r9.xNe;
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r9.xNe;
        r0 = r0.cmW();
        if (r0 != 0) goto L_0x001b;
    L_0x0015:
        r0 = r9.cmP();
        if (r0 == 0) goto L_0x0068;
    L_0x001b:
        r0 = r3;
    L_0x001c:
        if (r0 == 0) goto L_0x0065;
    L_0x001e:
        r1 = r9.cmP();
        r0 = r9.xNe;
        if (r0 == 0) goto L_0x009d;
    L_0x0026:
        r0 = r9.xNe;
        r0 = r0.cmY();
        r4 = r9.TAG;
        r5 = "newcursor mWorkerHandler.isHandingMsg,type is %d ";
        r6 = new java.lang.Object[r3];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        if (r0 == 0) goto L_0x0043;
    L_0x003e:
        r4 = r9.xNe;
        r4.cmU();
    L_0x0043:
        if (r1 == r8) goto L_0x009d;
    L_0x0045:
        r1 = r9.TAG;
        r4 = "newcursor ensureNewState  refreshstatus is %d ";
        r5 = new java.lang.Object[r3];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r9.nXQ = r2;
        if (r0 != r8) goto L_0x006a;
    L_0x0059:
        r0 = new com.tencent.mm.ui.f$c;
        r1 = r9.cmM();
        r0.<init>(r1);
        r9.a(r0, r3, r3);
    L_0x0065:
        r9.nXQ = r2;
    L_0x0067:
        return;
    L_0x0068:
        r0 = r2;
        goto L_0x001c;
    L_0x006a:
        r9.cmQ();
        goto L_0x0065;
    L_0x006e:
        r0 = r9.cmP();
        if (r0 != 0) goto L_0x007d;
    L_0x0074:
        r0 = r9.TAG;
        r1 = "newcursor need not change ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0067;
    L_0x007d:
        if (r0 != r8) goto L_0x008c;
    L_0x007f:
        r1 = r9.TAG;
        r3 = "newcursor enqueueMessage resetcursor ";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        r1 = r9.xMW;
        r1.clear();
    L_0x008c:
        r1 = r9.xNe;
        if (r1 != 0) goto L_0x0097;
    L_0x0090:
        r1 = new com.tencent.mm.ui.f$e;
        r1.<init>();
        r9.xNe = r1;
    L_0x0097:
        r1 = r9.xNe;
        r1.Ee(r0);
        goto L_0x0065;
    L_0x009d:
        r0 = r1;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.f.lV(boolean):void");
    }

    private int cmP() {
        if (this.xMW == null || this.xMW.size() == 0) {
            return 0;
        }
        if (this.xMW.containsKey(this.xNf)) {
            return 2;
        }
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(K r10, int r11) {
        /*
        r9 = this;
        r6 = 5;
        r8 = 3;
        r7 = 2;
        r1 = 0;
        r2 = 1;
        r0 = r9.xMV;
        if (r0 == 0) goto L_0x0070;
    L_0x0009:
        r0 = r9.xMW;
        if (r0 != 0) goto L_0x0014;
    L_0x000d:
        r0 = new java.util.HashMap;
        r0.<init>();
        r9.xMW = r0;
    L_0x0014:
        r0 = r9.xMW;
        r3 = r9.xNf;
        r0 = r0.containsKey(r3);
        if (r11 == r6) goto L_0x0024;
    L_0x001e:
        r3 = r9.xNc;
        if (r3 == 0) goto L_0x0024;
    L_0x0022:
        if (r11 != r2) goto L_0x007f;
    L_0x0024:
        if (r11 == r6) goto L_0x0071;
    L_0x0026:
        r9.cmO();
    L_0x0029:
        r0 = r9.TAG;
        r3 = "newcursor syncHandle is true ,changeType is %d  ";
        r4 = new java.lang.Object[r2];
        r5 = java.lang.Integer.valueOf(r11);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r0 = r2;
    L_0x003a:
        r3 = r9.cmP();
        r9.nXQ = r3;
        r4 = r9.TAG;
        r5 = "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ";
        r6 = new java.lang.Object[r8];
        r3 = r9.nXQ;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r1] = r3;
        r3 = r9.xNb;
        if (r3 != r2) goto L_0x0168;
    L_0x0053:
        r3 = r2;
    L_0x0054:
        r3 = java.lang.Boolean.valueOf(r3);
        r6[r2] = r3;
        r3 = java.lang.Integer.valueOf(r11);
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        if (r0 == 0) goto L_0x016b;
    L_0x0065:
        r0 = r9.TAG;
        r1 = "newcursor event is refresh sync ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r9.lV(r2);
    L_0x0070:
        return;
    L_0x0071:
        if (r0 != 0) goto L_0x0029;
    L_0x0073:
        r0 = r9.xMW;
        r3 = new com.tencent.mm.ui.f$b;
        r4 = 0;
        r3.<init>(r10, r11, r4);
        r0.put(r10, r3);
        goto L_0x0029;
    L_0x007f:
        if (r0 == 0) goto L_0x008a;
    L_0x0081:
        r0 = r9.TAG;
        r1 = "newcursor need reset ,return ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0070;
    L_0x008a:
        r0 = r9.xNb;
        if (r0 != r2) goto L_0x0162;
    L_0x008e:
        r0 = r9.xMV;
        r0 = r0.ce(r10);
        if (r0 != 0) goto L_0x0098;
    L_0x0096:
        if (r11 != r7) goto L_0x0157;
    L_0x0098:
        r4 = r9.xMW;
        r5 = new com.tencent.mm.ui.f$b;
        r0 = 0;
        r5.<init>(r10, r11, r0);
        r0 = r5.xNi;
        if (r0 != r7) goto L_0x00b0;
    L_0x00a4:
        r0 = r9.xMV;
        r3 = r5.object;
        r0 = r0.ce(r3);
        if (r0 == 0) goto L_0x00b0;
    L_0x00ae:
        r5.xNi = r8;
    L_0x00b0:
        r0 = r4.get(r10);
        r0 = (com.tencent.mm.ui.f.b) r0;
        if (r0 == 0) goto L_0x0111;
    L_0x00b8:
        r3 = r2;
    L_0x00b9:
        if (r3 == 0) goto L_0x0152;
    L_0x00bb:
        r4.remove(r0);
        r3 = r5.xNi;
        switch(r3) {
            case 2: goto L_0x0126;
            case 3: goto L_0x00c3;
            case 4: goto L_0x00c3;
            case 5: goto L_0x0113;
            default: goto L_0x00c3;
        };
    L_0x00c3:
        r0 = r0.xNi;
        switch(r0) {
            case 2: goto L_0x014e;
            case 3: goto L_0x00c8;
            case 4: goto L_0x00c8;
            case 5: goto L_0x0144;
            default: goto L_0x00c8;
        };
    L_0x00c8:
        r5.xNi = r8;
    L_0x00ca:
        r4.put(r10, r5);
    L_0x00cd:
        r0 = r9.xMV;
        r3 = r4.size();
        r0 = r0.xKD;
        r0 = r0.DU(r3);
        if (r0 != 0) goto L_0x00f8;
    L_0x00db:
        r0 = r9.TAG;
        r3 = "newcursor events size exceed limit :size is :  %d";
        r5 = new java.lang.Object[r2];
        r6 = r4.size();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r5);
        r4.clear();
        r0 = r9.xNf;
        r3 = 0;
        r4.put(r0, r3);
    L_0x00f8:
        r0 = r9.TAG;
        r3 = "newcursor add event events size %d";
        r4 = new java.lang.Object[r2];
        r5 = r9.xMW;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r0 = r1;
        goto L_0x003a;
    L_0x0111:
        r3 = r1;
        goto L_0x00b9;
    L_0x0113:
        r0 = r0.xNi;
        switch(r0) {
            case 2: goto L_0x00f8;
            case 3: goto L_0x0118;
            case 4: goto L_0x0118;
            case 5: goto L_0x011b;
            default: goto L_0x0118;
        };
    L_0x0118:
        r5.xNi = r6;
        goto L_0x00ca;
    L_0x011b:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now delete, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r5.xNi = r6;
        goto L_0x00ca;
    L_0x0126:
        r0 = r0.xNi;
        switch(r0) {
            case 2: goto L_0x0139;
            case 3: goto L_0x012b;
            case 4: goto L_0x012b;
            case 5: goto L_0x0136;
            default: goto L_0x012b;
        };
    L_0x012b:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last update, now insert, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r5.xNi = r7;
        goto L_0x00ca;
    L_0x0136:
        r5.xNi = r8;
        goto L_0x00ca;
    L_0x0139:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last insert, now insert, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r5.xNi = r7;
        goto L_0x00ca;
    L_0x0144:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now update, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x00c8;
    L_0x014e:
        r5.xNi = r7;
        goto L_0x00ca;
    L_0x0152:
        r4.put(r10, r5);
        goto L_0x00cd;
    L_0x0157:
        r0 = r9.TAG;
        r3 = "newcursor event pass ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r0 = r1;
        goto L_0x003a;
    L_0x0162:
        r9.cmO();
        r0 = r1;
        goto L_0x003a;
    L_0x0168:
        r3 = r1;
        goto L_0x0054;
    L_0x016b:
        r0 = r9.xMU;
        if (r0 == 0) goto L_0x0070;
    L_0x016f:
        r0 = r9.xNa;
        if (r0 == 0) goto L_0x0070;
    L_0x0173:
        r9.lV(r1);
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.f.q(java.lang.Object, int):void");
    }

    public final void resume() {
        x.i(this.TAG, "newcursor resume ");
        this.xMU = true;
        bi("resume", true);
    }

    public void pause() {
        this.xMU = false;
        x.i(this.TAG, "new cursor pasue");
    }

    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.xMX != null) {
            this.xMX.XF();
        }
        dVar.cmR();
        notifyDataSetChanged();
        if (this.xMX != null) {
            this.xMX.XE();
        }
        if (this.xNe != null) {
            this.xNe.cmX();
        }
        x.i(this.TAG, "newcursor update callback last :%d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void cmQ() {
        if (this.xMV == null || this.xMV.isClosed() || this.xMW.size() != 0) {
            a(new d() {
                public final void cmR() {
                    long currentTimeMillis;
                    if (f.a(f.this, f.this.xMW)) {
                        HashSet hashSet = new HashSet(f.this.xMW.size());
                        for (b bVar : f.this.xMW.values()) {
                            hashSet.add(bVar.object);
                        }
                        x.i(f.this.TAG, "newcursor all event is delete");
                        f.this.xMV.c(hashSet.toArray(), null);
                    } else if (f.this.xMW.containsKey(f.this.xNf)) {
                        currentTimeMillis = System.currentTimeMillis();
                        f.this.a(new c(f.this.cmM()), true, false);
                        x.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        currentTimeMillis = System.currentTimeMillis();
                        SparseArray[] cmN = f.this.cmN();
                        SparseArray[] a = f.this.a(new HashSet(f.this.xMW.values()), cmN);
                        int length = cmN.length;
                        if (length > 1) {
                            for (int i = 0; i < length; i++) {
                                x.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(cmN[i].size()), Integer.valueOf(a[i].size()));
                            }
                        } else {
                            x.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(cmN[0].size()), Integer.valueOf(a[0].size()));
                        }
                        for (b bVar2 : f.this.xMW.values()) {
                            if (bVar2 != null) {
                                if (bVar2.xNj != null) {
                                    x.i(f.this.TAG, "newcursor notify cache update : key : %s ", bVar2.object);
                                }
                                f.this.xMV.c(bVar2.object, (com.tencent.mm.bx.a.a) bVar2.xNj);
                            } else {
                                x.e(f.this.TAG, "newcursor event is null ! ");
                            }
                        }
                        f.this.a(a);
                        x.i(f.this.TAG, "newcursor after resort new pos size :%d  ", Integer.valueOf(f.this.xMV.clC()[0].size()));
                    }
                    f.this.xMW.clear();
                }
            });
        } else {
            x.i(this.TAG, "events size is 0  ");
        }
    }

    private void a(final c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.xNe != null && this.xNe.cmW()) {
                this.xNe.cmU();
            }
            if (this.xMW != null) {
                this.xMW.clear();
            }
        }
        if (z2) {
            a(new d() {
                public final void cmR() {
                    f.this.a(cVar);
                }
            });
        } else {
            a((c) cVar);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] clC = this.xMV.clC();
        for (int i = 0; i < clC.length; i++) {
            clC[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                clC[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    public final void lW(boolean z) {
        if (this.xMV != null) {
            this.xMV.close();
            this.xMV = null;
        }
        if (z && this.xNe != null) {
            this.xNe.quit();
            this.xNe = null;
            if (this.xMW != null) {
                this.xMW.clear();
                x.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.nXQ = 0;
        this.xNb = 0;
    }
}
