package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class c {
    private static volatile c tZb = null;
    public ArrayList<b> jXe = null;
    public a tZc = null;
    public uz tZd = null;
    public int tZe = 0;
    public int tZf = 0;
    public int tZg = 0;
    public boolean tZh = false;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ArrayList tZj;

        public AnonymousClass2(ArrayList arrayList) {
            this.tZj = arrayList;
        }

        public final void run() {
            ArrayList a = h.a(c.this.jXe, this.tZj, false);
            x.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
            c.this.tZc.l(a, true);
        }
    }

    private c() {
    }

    public static c bXc() {
        if (tZb == null) {
            synchronized (c.class) {
                if (tZb == null) {
                    tZb = new c();
                }
            }
        }
        return tZb;
    }

    public final int size() {
        return this.jXe != null ? this.jXe.size() : 0;
    }

    public final b BL(int i) {
        if (this.jXe == null || i < 0 || i >= this.jXe.size()) {
            return null;
        }
        return (b) this.jXe.get(i);
    }

    public final boolean a(b bVar) {
        boolean z = true;
        synchronized (this) {
            if (bVar != null) {
                if (this.jXe != null) {
                    this.jXe.add(bVar);
                    a(bVar, true);
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean a(int i, ArrayList<b> arrayList) {
        boolean z = false;
        if (arrayList != null && arrayList.size() > 0) {
            int i2;
            int i3;
            synchronized (this) {
                if (this.jXe != null) {
                    int i4 = 0;
                    i2 = 0;
                    i3 = i;
                    while (i4 < arrayList.size() && i3 >= 0 && i3 <= this.jXe.size()) {
                        b bVar = (b) arrayList.get(i4);
                        if (bVar != null) {
                            b(bVar);
                            this.jXe.add(i3, bVar);
                            i2++;
                            i3++;
                            a(bVar, true);
                        }
                        int i5 = i2;
                        i4++;
                        i3 = i3;
                        i2 = i5;
                    }
                    z = true;
                } else {
                    i2 = 0;
                    i3 = i;
                }
            }
            if (z && this.tZc != null) {
                this.tZc.eq(i3 - i2, i2);
            }
        }
        return z;
    }

    public final boolean a(int i, b bVar) {
        boolean z = true;
        synchronized (this) {
            if (this.jXe == null || i < 0 || i > this.jXe.size()) {
                z = false;
            } else {
                this.jXe.add(i, bVar);
                a(bVar, true);
            }
        }
        if (z && this.tZc != null) {
            this.tZc.BF(i);
            if (i > 0) {
                this.tZc.er(i - 1, this.jXe.size() - (i - 1));
            } else {
                this.tZc.er(i, this.jXe.size() - i);
            }
        }
        return z;
    }

    private boolean b(int i, b bVar) {
        if (bVar == null || this.jXe == null || i < 0 || i > this.jXe.size()) {
            return false;
        }
        this.jXe.add(i, bVar);
        a(bVar, true);
        return true;
    }

    public final boolean W(int i, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.jXe != null && i >= 0 && i < this.jXe.size()) {
                a((b) this.jXe.get(i), false);
                this.jXe.remove(i);
                z2 = true;
            }
        }
        if (z2 && z && this.tZc != null) {
            this.tZc.BG(i);
            if (i > 0) {
                this.tZc.er(i - 1, this.jXe.size() - (i - 1));
            } else {
                this.tZc.er(i, this.jXe.size() - i);
            }
        }
        return z2;
    }

    private boolean BM(int i) {
        if (this.jXe == null || i < 0 || i >= this.jXe.size()) {
            return false;
        }
        a((b) this.jXe.get(i), false);
        this.jXe.remove(i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, com.tencent.mm.plugin.wenote.model.a.b r6) {
        /*
        r4 = this;
        r1 = 0;
        r2 = -1;
        monitor-enter(r4);
        r0 = r4.jXe;	 Catch:{ all -> 0x0048 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
    L_0x0008:
        return;
    L_0x0009:
        r1 = r1 + 1;
    L_0x000b:
        r0 = r4.jXe;	 Catch:{ all -> 0x0048 }
        r0 = r0.size();	 Catch:{ all -> 0x0048 }
        if (r1 >= r0) goto L_0x004b;
    L_0x0013:
        r0 = r4.jXe;	 Catch:{ all -> 0x0048 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0048 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0048 }
        r0 = r0.bWF();	 Catch:{ all -> 0x0048 }
        r0 = r0.equals(r5);	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0009;
    L_0x0025:
        r0 = r4.jXe;	 Catch:{ all -> 0x0048 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0048 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0048 }
        r3 = 0;
        r4.a(r0, r3);	 Catch:{ all -> 0x0048 }
        r0 = r4.jXe;	 Catch:{ all -> 0x0048 }
        r0.set(r1, r6);	 Catch:{ all -> 0x0048 }
        r0 = 1;
        r4.a(r6, r0);	 Catch:{ all -> 0x0048 }
        r0 = r1;
    L_0x003b:
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        if (r0 == r2) goto L_0x0008;
    L_0x003e:
        r1 = r4.tZc;
        if (r1 == 0) goto L_0x0008;
    L_0x0042:
        r1 = r4.tZc;
        r1.BE(r0);
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        throw r0;
    L_0x004b:
        r0 = r2;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.lang.String, com.tencent.mm.plugin.wenote.model.a.b):void");
    }

    public final void bXd() {
        String str = "MicroMsg.Note.NoteDataManager";
        String str2 = "clear mDataList, size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.jXe != null ? this.jXe.size() : 0);
        x.i(str, str2, objArr);
        synchronized (this) {
            if (this.jXe != null) {
                this.jXe.clear();
            }
        }
        this.tZg = 0;
        this.tZf = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void X(int r4, boolean r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.jXe;	 Catch:{ all -> 0x002c }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
    L_0x0006:
        return;
    L_0x0007:
        if (r4 < 0) goto L_0x002f;
    L_0x0009:
        r0 = r3.jXe;	 Catch:{ all -> 0x002c }
        r0 = r0.size();	 Catch:{ all -> 0x002c }
        if (r4 >= r0) goto L_0x002f;
    L_0x0011:
        r0 = r3.jXe;	 Catch:{ all -> 0x002c }
        r0 = r0.get(r4);	 Catch:{ all -> 0x002c }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x002a;
    L_0x001b:
        r1 = r0.tXY;	 Catch:{ all -> 0x002c }
        if (r1 == r5) goto L_0x002a;
    L_0x001f:
        r0.tXY = r5;	 Catch:{ all -> 0x002c }
        r0 = r3.tZc;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x002a;
    L_0x0025:
        r0 = r3.tZc;	 Catch:{ all -> 0x002c }
        r0.BE(r4);	 Catch:{ all -> 0x002c }
    L_0x002a:
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
        goto L_0x0006;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = -1;
        if (r4 != r0) goto L_0x002a;
    L_0x0032:
        r0 = 0;
        r1 = r0;
    L_0x0034:
        r0 = r3.jXe;	 Catch:{ all -> 0x002c }
        r0 = r0.size();	 Catch:{ all -> 0x002c }
        if (r1 >= r0) goto L_0x002a;
    L_0x003c:
        r0 = r3.jXe;	 Catch:{ all -> 0x002c }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002c }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0055;
    L_0x0046:
        r2 = r0.tXY;	 Catch:{ all -> 0x002c }
        if (r2 == r5) goto L_0x0055;
    L_0x004a:
        r0.tXY = r5;	 Catch:{ all -> 0x002c }
        r0 = r3.tZc;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0055;
    L_0x0050:
        r0 = r3.tZc;	 Catch:{ all -> 0x002c }
        r0.BE(r1);	 Catch:{ all -> 0x002c }
    L_0x0055:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.X(int, boolean):void");
    }

    public final int bXe() {
        int i;
        synchronized (this) {
            if (this.jXe != null) {
                for (int i2 = 0; i2 < this.jXe.size(); i2++) {
                    if (((b) this.jXe.get(i2)).tXR) {
                        i = i2;
                        break;
                    }
                }
            }
            i = -1;
        }
        return i;
    }

    public final void bXf() {
        synchronized (this) {
            if (this.jXe != null) {
                Iterator it = this.jXe.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    bVar.tXR = false;
                    bVar.tXX = false;
                }
            }
        }
    }

    private void bXg() {
        if (this.jXe != null) {
            Iterator it = this.jXe.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                bVar.tXR = false;
                bVar.tXX = false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y(int r4, boolean r5) {
        /*
        r3 = this;
        r0 = 0;
        monitor-enter(r3);
        r1 = r3.jXe;	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x0010;
    L_0x0006:
        if (r4 < 0) goto L_0x0010;
    L_0x0008:
        r1 = r3.jXe;	 Catch:{ all -> 0x004d }
        r1 = r1.size();	 Catch:{ all -> 0x004d }
        if (r4 < r1) goto L_0x0012;
    L_0x0010:
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
    L_0x0011:
        return;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        r0 = r3.jXe;	 Catch:{ all -> 0x004d }
        r0 = r0.size();	 Catch:{ all -> 0x004d }
        if (r1 >= r0) goto L_0x0050;
    L_0x001b:
        if (r1 != r4) goto L_0x0036;
    L_0x001d:
        r0 = r3.jXe;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r2 = 1;
        r0.tXR = r2;	 Catch:{ all -> 0x004d }
        r0 = r3.jXe;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r0.tXX = r5;	 Catch:{ all -> 0x004d }
    L_0x0032:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0013;
    L_0x0036:
        r0 = r3.jXe;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r2 = 0;
        r0.tXR = r2;	 Catch:{ all -> 0x004d }
        r0 = r3.jXe;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r2 = 0;
        r0.tXX = r2;	 Catch:{ all -> 0x004d }
        goto L_0x0032;
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
        throw r0;
    L_0x0050:
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.Y(int, boolean):void");
    }

    public final int bXh() {
        int i;
        synchronized (this) {
            if (this.jXe != null) {
                int i2 = 0;
                while (i2 < this.jXe.size()) {
                    if (((b) this.jXe.get(i2)).getType() == 4 && ((k) this.jXe.get(i2)).tYf.booleanValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            i = -1;
        }
        return i;
    }

    public final String bXi() {
        String stringBuilder;
        synchronized (this) {
            if (this.tZe == 0 && this.jXe != null) {
                Iterator it = this.jXe.iterator();
                while (it.hasNext()) {
                    n nVar = (n) ((b) it.next());
                    if (nVar.tYn.startsWith("WeNote_")) {
                        int i = bi.getInt(nVar.tYn.substring(7), -1);
                        if (i <= this.tZe) {
                            i = this.tZe;
                        }
                        this.tZe = i;
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("WeNote_");
            int i2 = this.tZe + 1;
            this.tZe = i2;
            stringBuilder = stringBuilder2.append(i2).toString();
        }
        return stringBuilder;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String bXj() {
        /*
        r4 = this;
        r1 = "";
        monitor-enter(r4);
        r0 = r4.jXe;	 Catch:{ all -> 0x0157 }
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r4.jXe;	 Catch:{ all -> 0x0157 }
        r0 = r0.size();	 Catch:{ all -> 0x0157 }
        if (r0 > 0) goto L_0x0015;
    L_0x0010:
        r0 = "";
        monitor-exit(r4);	 Catch:{ all -> 0x0157 }
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = 0;
        r2 = r0;
    L_0x0017:
        r0 = r4.jXe;	 Catch:{ all -> 0x0157 }
        r0 = r0.size();	 Catch:{ all -> 0x0157 }
        if (r2 >= r0) goto L_0x014a;
    L_0x001f:
        r0 = r4.jXe;	 Catch:{ all -> 0x0157 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0157 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0157 }
        r3 = r0.getType();	 Catch:{ all -> 0x0157 }
        switch(r3) {
            case -1: goto L_0x0134;
            case 0: goto L_0x002e;
            case 1: goto L_0x0034;
            case 2: goto L_0x00a8;
            case 3: goto L_0x00fc;
            case 4: goto L_0x00e0;
            case 5: goto L_0x0118;
            case 6: goto L_0x00c4;
            default: goto L_0x002e;
        };	 Catch:{ all -> 0x0157 }
    L_0x002e:
        r0 = r1;
    L_0x002f:
        r1 = r2 + 1;
        r2 = r1;
        r1 = r0;
        goto L_0x0017;
    L_0x0034:
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x0157 }
        r3 = r0.content;	 Catch:{ all -> 0x0157 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);	 Catch:{ all -> 0x0157 }
        if (r3 == 0) goto L_0x0053;
    L_0x003e:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r0.<init>();	 Catch:{ all -> 0x0157 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0157 }
        r1 = "<br/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x0053:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r3.<init>();	 Catch:{ all -> 0x0157 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.content;	 Catch:{ all -> 0x0157 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0157 }
        r1 = r0.toString();	 Catch:{ all -> 0x0157 }
        r0 = r2 + 1;
        r3 = r4.jXe;	 Catch:{ all -> 0x0157 }
        r3 = r3.size();	 Catch:{ all -> 0x0157 }
        if (r0 >= r3) goto L_0x002e;
    L_0x0070:
        r0 = r4.jXe;	 Catch:{ all -> 0x0157 }
        r3 = r2 + 1;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0157 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0157 }
        r0 = r0.getType();	 Catch:{ all -> 0x0157 }
        r3 = 1;
        if (r0 != r3) goto L_0x002e;
    L_0x0081:
        r0 = r4.jXe;	 Catch:{ all -> 0x0157 }
        r3 = r2 + 1;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0157 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x0157 }
        r0 = r0.content;	 Catch:{ all -> 0x0157 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);	 Catch:{ all -> 0x0157 }
        if (r0 != 0) goto L_0x002e;
    L_0x0093:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r0.<init>();	 Catch:{ all -> 0x0157 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0157 }
        r1 = "<br/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x00a8:
        r0 = (com.tencent.mm.plugin.wenote.model.a.e) r0;	 Catch:{ all -> 0x0157 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r3.<init>();	 Catch:{ all -> 0x0157 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.tYn;	 Catch:{ all -> 0x0157 }
        r3 = 2;
        r0 = cO(r0, r3);	 Catch:{ all -> 0x0157 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x00c4:
        r0 = (com.tencent.mm.plugin.wenote.model.a.j) r0;	 Catch:{ all -> 0x0157 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r3.<init>();	 Catch:{ all -> 0x0157 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.tYn;	 Catch:{ all -> 0x0157 }
        r3 = 6;
        r0 = cO(r0, r3);	 Catch:{ all -> 0x0157 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x00e0:
        r0 = (com.tencent.mm.plugin.wenote.model.a.k) r0;	 Catch:{ all -> 0x0157 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r3.<init>();	 Catch:{ all -> 0x0157 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.tYn;	 Catch:{ all -> 0x0157 }
        r3 = 4;
        r0 = cO(r0, r3);	 Catch:{ all -> 0x0157 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x00fc:
        r0 = (com.tencent.mm.plugin.wenote.model.a.f) r0;	 Catch:{ all -> 0x0157 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r3.<init>();	 Catch:{ all -> 0x0157 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.tYn;	 Catch:{ all -> 0x0157 }
        r3 = 3;
        r0 = cO(r0, r3);	 Catch:{ all -> 0x0157 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x0118:
        r0 = (com.tencent.mm.plugin.wenote.model.a.c) r0;	 Catch:{ all -> 0x0157 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r3.<init>();	 Catch:{ all -> 0x0157 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.tYn;	 Catch:{ all -> 0x0157 }
        r3 = 5;
        r0 = cO(r0, r3);	 Catch:{ all -> 0x0157 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x0134:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r0.<init>();	 Catch:{ all -> 0x0157 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0157 }
        r1 = "<hr/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0157 }
        r0 = r0.toString();	 Catch:{ all -> 0x0157 }
        goto L_0x002f;
    L_0x014a:
        r0 = "\n";
        r2 = "<br/>";
        r0 = r1.replaceAll(r0, r2);	 Catch:{ all -> 0x0157 }
        monitor-exit(r4);	 Catch:{ all -> 0x0157 }
        goto L_0x0014;
    L_0x0157:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0157 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXj():java.lang.String");
    }

    private static String cO(String str, int i) {
        return String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[]{Integer.valueOf(i), str, str});
    }

    public final vn Ru(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            return null;
        }
        String o;
        int i;
        List arrayList = new ArrayList();
        synchronized (this) {
            int i2 = 0;
            while (i2 < this.jXe.size()) {
                b bVar = (b) this.jXe.get(i2);
                if (bi.oN(bVar.mBr)) {
                    bVar.mBr = f.Rn(bVar.toString());
                }
                com.tencent.mm.plugin.wenote.model.a.h hVar;
                com.tencent.mm.plugin.wenote.model.a.h hVar2;
                if (bVar.getType() == -1) {
                    if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).type != 1) {
                        hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                        hVar.content = "\n";
                        hVar.mBr = bVar.mBr;
                        hVar.tYn = "-1";
                        hVar.type = 1;
                        hVar.tYm = null;
                        arrayList.add(hVar);
                    } else {
                        hVar2 = (com.tencent.mm.plugin.wenote.model.a.h) arrayList.get(arrayList.size() - 1);
                        hVar2.content += "\n";
                    }
                } else if (bVar.getType() >= -1) {
                    if ((bVar.getType() == 6 || bVar.getType() == 4) && bi.oN(((n) bVar).fCV)) {
                        uz uzVar = new uz();
                        uzVar.Ui(bVar.mBr);
                        uzVar.Uf(bVar.bWG());
                        o = f.o(uzVar);
                        if (FileOp.bO(o)) {
                            x.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", Integer.valueOf(bVar.getType()));
                            ((n) bVar).fCV = o;
                        }
                    }
                    if (bVar.getType() != 1) {
                        arrayList.add((n) bVar);
                    } else {
                        hVar2 = (com.tencent.mm.plugin.wenote.model.a.h) bVar;
                        if (!bi.oN(hVar2.content)) {
                            if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                                hVar.content = hVar2.content;
                                hVar.mBr = hVar2.mBr;
                                hVar.tYn = hVar2.tYn;
                                hVar.type = hVar2.type;
                                hVar.tYm = null;
                                arrayList.add(hVar);
                            } else {
                                hVar = (com.tencent.mm.plugin.wenote.model.a.h) arrayList.get(arrayList.size() - 1);
                                hVar.content += hVar2.content;
                            }
                            if (i2 + 1 < this.jXe.size() && ((b) this.jXe.get(i2 + 1)).getType() == 1 && !bi.oN(((com.tencent.mm.plugin.wenote.model.a.h) this.jXe.get(i2 + 1)).content)) {
                                hVar2 = (com.tencent.mm.plugin.wenote.model.a.h) arrayList.get(arrayList.size() - 1);
                                hVar2.content += "<br/>";
                            }
                        } else if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                            hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                            hVar.content = "<br/>";
                            hVar.mBr = hVar2.mBr;
                            hVar.tYn = hVar2.tYn;
                            hVar.type = hVar2.type;
                            hVar.tYm = null;
                            arrayList.add(hVar);
                        } else {
                            hVar2 = (com.tencent.mm.plugin.wenote.model.a.h) arrayList.get(arrayList.size() - 1);
                            hVar2.content += "<br/>";
                        }
                    }
                }
                i2++;
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        byte[] bytes;
        try {
            bytes = replaceAll.getBytes("UTF-8");
            i = 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteDataManager", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
            boolean i3 = true;
            bytes = null;
        }
        this.tZd.Dc(8);
        this.tZd.Us("WeNoteHtmlFile");
        this.tZd.lA(true);
        this.tZd.Uf(".htm");
        this.tZd.Ui(f.Rn(this.tZd.toString()));
        o = f.o(this.tZd);
        x.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", o);
        File file = new File(o);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Note.NoteDataManager", e2, "", new Object[0]);
                return null;
            }
        }
        if (i3 == 0 && e.b(o, bytes, bytes.length) == 0) {
            this.tZd.Uj(o);
            x.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
            return d.a(replaceAll, arrayList, this.tZd);
        }
        x.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.egG), 1).show();
        return null;
    }

    public final int a(b bVar, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        if (bVar == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        return a(arrayList, wXRTEditText, true, true, z, z2, z3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.b> r10, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        /*
        r9 = this;
        r7 = 5;
        r4 = 2;
        r2 = -1;
        r6 = 1;
        r5 = 0;
        if (r10 == 0) goto L_0x0011;
    L_0x0007:
        r1 = r10.size();
        if (r1 <= 0) goto L_0x0011;
    L_0x000d:
        r1 = r9.jXe;
        if (r1 != 0) goto L_0x001c;
    L_0x0011:
        r1 = "MicroMsg.Note.NoteDataManager";
        r3 = "insertItemList,error,return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
        r1 = r2;
    L_0x001b:
        return r1;
    L_0x001c:
        r1 = com.tencent.mm.plugin.wenote.model.c.bWA();
        r1 = r1.tWL;
        if (r1 != 0) goto L_0x002f;
    L_0x0024:
        r1 = "MicroMsg.Note.NoteDataManager";
        r3 = "insertItemList, but get wnnote base is null, return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
        r1 = r2;
        goto L_0x001b;
    L_0x002f:
        if (r14 == 0) goto L_0x0042;
    L_0x0031:
        r1 = r9.ab(r10);
        if (r1 == 0) goto L_0x0042;
    L_0x0037:
        r1 = r9.tZc;
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r1 = r9.tZc;
        r1.bWM();
        r1 = r2;
        goto L_0x001b;
    L_0x0042:
        if (r12 == 0) goto L_0x006a;
    L_0x0044:
        r1 = r10.size();
        r1 = r1 + -1;
        r1 = r10.get(r1);
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;
        r1.tXT = r2;
        r1.tXR = r6;
        r1.tXX = r5;
        if (r11 == 0) goto L_0x006a;
    L_0x0058:
        r3 = r11.uag;
        if (r3 == 0) goto L_0x006a;
    L_0x005c:
        r3 = r11.tZU;
        if (r3 != r4) goto L_0x00a6;
    L_0x0060:
        r1.tYa = r4;
    L_0x0062:
        r11.uag = r5;
        r3 = r11.tYb;
        r1.tYb = r3;
        r11.tYb = r5;
    L_0x006a:
        if (r11 == 0) goto L_0x0072;
    L_0x006c:
        r1 = r11.bXB();
        if (r1 == 0) goto L_0x00ad;
    L_0x0072:
        monitor-enter(r9);
        if (r11 != 0) goto L_0x0157;
    L_0x0075:
        r3 = r9.size();	 Catch:{ all -> 0x025d }
        r9.bXg();	 Catch:{ all -> 0x025d }
        r4 = r10.iterator();	 Catch:{ all -> 0x025d }
        r2 = r3;
    L_0x0081:
        r1 = r4.hasNext();	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x00e8;
    L_0x0087:
        r1 = r4.next();	 Catch:{ all -> 0x025d }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x025d }
        r9.b(r1);	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x029f;
    L_0x0092:
        r7 = r9.jXe;	 Catch:{ all -> 0x025d }
        if (r7 == 0) goto L_0x029f;
    L_0x0096:
        r7 = r9.jXe;	 Catch:{ all -> 0x025d }
        r7.add(r1);	 Catch:{ all -> 0x025d }
        r7 = 1;
        r9.a(r1, r7);	 Catch:{ all -> 0x025d }
        r1 = r6;
    L_0x00a0:
        if (r1 == 0) goto L_0x02a2;
    L_0x00a2:
        r1 = r2 + 1;
    L_0x00a4:
        r2 = r1;
        goto L_0x0081;
    L_0x00a6:
        r3 = r11.tZU;
        if (r3 != r6) goto L_0x0062;
    L_0x00aa:
        r1.tYa = r6;
        goto L_0x0062;
    L_0x00ad:
        r1 = r11.tZU;
        if (r1 == r4) goto L_0x0072;
    L_0x00b1:
        r1 = r11.getSelectionStart();
        if (r1 != 0) goto L_0x0072;
    L_0x00b7:
        if (r10 == 0) goto L_0x0072;
    L_0x00b9:
        r1 = r10.size();
        if (r1 <= 0) goto L_0x0072;
    L_0x00bf:
        r1 = r10.get(r5);
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;
        r1 = r1.getType();
        if (r1 == r4) goto L_0x00d6;
    L_0x00cb:
        r3 = 6;
        if (r1 == r3) goto L_0x00d6;
    L_0x00ce:
        if (r1 == r7) goto L_0x00d6;
    L_0x00d0:
        r3 = 3;
        if (r1 == r3) goto L_0x00d6;
    L_0x00d3:
        r3 = 4;
        if (r1 != r3) goto L_0x0072;
    L_0x00d6:
        r1 = new com.tencent.mm.plugin.wenote.model.a.h;
        r1.<init>();
        r3 = "";
        r1.content = r3;
        r1.tXR = r5;
        r1.tXX = r5;
        r10.add(r5, r1);
        goto L_0x0072;
    L_0x00e8:
        r4 = r5;
    L_0x00e9:
        monitor-exit(r9);	 Catch:{ all -> 0x025d }
        r1 = r2 + -1;
        if (r1 < 0) goto L_0x0260;
    L_0x00ee:
        r1 = r2 + -1;
        r7 = bXc();
        r7 = r7.size();
        if (r1 >= r7) goto L_0x0260;
    L_0x00fa:
        r1 = r2 + -1;
    L_0x00fc:
        if (r16 == 0) goto L_0x011f;
    L_0x00fe:
        r1 = r1 + 1;
        r2 = r2 + 1;
        r9.bXg();
        r7 = bXc();
        r7 = r7.size();
        if (r1 >= r7) goto L_0x026c;
    L_0x010f:
        r7 = bXc();
        r7 = r7.BL(r1);
        if (r7 == 0) goto L_0x011f;
    L_0x0119:
        r7.tXT = r5;
        r7.tXR = r6;
        r7.tXX = r5;
    L_0x011f:
        r5 = r9.tZc;
        if (r5 == 0) goto L_0x0152;
    L_0x0123:
        r2 = r2 - r3;
        if (r4 == 0) goto L_0x0128;
    L_0x0126:
        r2 = r2 + 1;
    L_0x0128:
        if (r3 < 0) goto L_0x0131;
    L_0x012a:
        if (r2 <= 0) goto L_0x0131;
    L_0x012c:
        r4 = r9.tZc;
        r4.eq(r3, r2);
    L_0x0131:
        if (r3 <= 0) goto L_0x0283;
    L_0x0133:
        r2 = r9.tZc;
        r4 = r3 + -1;
        r5 = bXc();
        r5 = r5.size();
        r3 = r3 + -1;
        r3 = r5 - r3;
        r2.er(r4, r3);
    L_0x0146:
        if (r15 == 0) goto L_0x014d;
    L_0x0148:
        r2 = r9.tZc;
        r2.bWL();
    L_0x014d:
        r2 = r9.tZc;
        r2.BH(r1);
    L_0x0152:
        r9.bXl();
        goto L_0x001b;
    L_0x0157:
        r4 = r11.bXB();	 Catch:{ all -> 0x025d }
        r3 = r9.BL(r4);	 Catch:{ all -> 0x025d }
        if (r3 != 0) goto L_0x0165;
    L_0x0161:
        monitor-exit(r9);	 Catch:{ all -> 0x025d }
        r1 = r2;
        goto L_0x001b;
    L_0x0165:
        r9.bXg();	 Catch:{ all -> 0x025d }
        r1 = r11.tZU;	 Catch:{ all -> 0x025d }
        if (r1 != 0) goto L_0x0239;
    L_0x016c:
        r1 = r3.getType();	 Catch:{ all -> 0x025d }
        if (r1 != r6) goto L_0x0239;
    L_0x0172:
        r2 = r11.bXA();	 Catch:{ all -> 0x025d }
        r7 = r11.getText();	 Catch:{ all -> 0x025d }
        r1 = 0;
        r8 = r2.Ww;	 Catch:{ all -> 0x025d }
        r1 = r7.subSequence(r1, r8);	 Catch:{ all -> 0x025d }
        r2 = r2.wq;	 Catch:{ all -> 0x025d }
        r8 = r7.length();	 Catch:{ all -> 0x025d }
        r2 = r7.subSequence(r2, r8);	 Catch:{ all -> 0x025d }
        r1 = (android.text.Spanned) r1;	 Catch:{ all -> 0x025d }
        r7 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x025d }
        r0 = r2;
        r0 = (android.text.Spanned) r0;	 Catch:{ all -> 0x025d }
        r1 = r0;
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x025d }
        r0 = r3;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x025d }
        r1 = r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r7);	 Catch:{ all -> 0x025d }
        if (r3 != 0) goto L_0x020b;
    L_0x01a3:
        r3 = "<br/>";
        r3 = r7.endsWith(r3);	 Catch:{ all -> 0x025d }
        if (r3 == 0) goto L_0x0209;
    L_0x01ac:
        r3 = 0;
        r8 = r7.length();	 Catch:{ all -> 0x025d }
        r8 = r8 + -5;
        r3 = r7.substring(r3, r8);	 Catch:{ all -> 0x025d }
    L_0x01b7:
        r1.content = r3;	 Catch:{ all -> 0x025d }
        r4 = r4 + 1;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r2);	 Catch:{ all -> 0x025d }
        if (r1 != 0) goto L_0x0235;
    L_0x01c1:
        r1 = new com.tencent.mm.plugin.wenote.model.a.h;	 Catch:{ all -> 0x025d }
        r1.<init>();	 Catch:{ all -> 0x025d }
        r3 = 1;
        r1.type = r3;	 Catch:{ all -> 0x025d }
        r3 = "<br/>";
        r3 = r2.startsWith(r3);	 Catch:{ all -> 0x025d }
        if (r3 == 0) goto L_0x01db;
    L_0x01d2:
        r3 = 5;
        r7 = r2.length();	 Catch:{ all -> 0x025d }
        r2 = r2.substring(r3, r7);	 Catch:{ all -> 0x025d }
    L_0x01db:
        r1.content = r2;	 Catch:{ all -> 0x025d }
        r2 = 0;
        r1.tXT = r2;	 Catch:{ all -> 0x025d }
        r2 = 0;
        r1.tXR = r2;	 Catch:{ all -> 0x025d }
        r2 = 0;
        r1.tXX = r2;	 Catch:{ all -> 0x025d }
        r9.b(r4, r1);	 Catch:{ all -> 0x025d }
        r3 = r4;
        r2 = r4;
        r4 = r6;
    L_0x01ec:
        r7 = r10.iterator();	 Catch:{ all -> 0x025d }
    L_0x01f0:
        r1 = r7.hasNext();	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x00e9;
    L_0x01f6:
        r1 = r7.next();	 Catch:{ all -> 0x025d }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x025d }
        r9.b(r1);	 Catch:{ all -> 0x025d }
        r1 = r9.b(r2, r1);	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x029c;
    L_0x0205:
        r1 = r2 + 1;
    L_0x0207:
        r2 = r1;
        goto L_0x01f0;
    L_0x0209:
        r3 = r7;
        goto L_0x01b7;
    L_0x020b:
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r2);	 Catch:{ all -> 0x025d }
        if (r3 != 0) goto L_0x0229;
    L_0x0211:
        r3 = "<br/>";
        r3 = r2.startsWith(r3);	 Catch:{ all -> 0x025d }
        if (r3 == 0) goto L_0x0223;
    L_0x021a:
        r3 = 5;
        r7 = r2.length();	 Catch:{ all -> 0x025d }
        r2 = r2.substring(r3, r7);	 Catch:{ all -> 0x025d }
    L_0x0223:
        r1.content = r2;	 Catch:{ all -> 0x025d }
        r3 = r4;
        r2 = r4;
        r4 = r5;
        goto L_0x01ec;
    L_0x0229:
        r9.BM(r4);	 Catch:{ all -> 0x025d }
        r1 = r9.tZc;	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x0235;
    L_0x0230:
        r1 = r9.tZc;	 Catch:{ all -> 0x025d }
        r1.BG(r4);	 Catch:{ all -> 0x025d }
    L_0x0235:
        r3 = r4;
        r2 = r4;
        r4 = r5;
        goto L_0x01ec;
    L_0x0239:
        r1 = r11.tZU;	 Catch:{ all -> 0x025d }
        if (r1 == r6) goto L_0x029a;
    L_0x023d:
        r3 = r4 + 1;
    L_0x023f:
        r4 = r10.iterator();	 Catch:{ all -> 0x025d }
        r2 = r3;
    L_0x0244:
        r1 = r4.hasNext();	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x0295;
    L_0x024a:
        r1 = r4.next();	 Catch:{ all -> 0x025d }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x025d }
        r9.b(r1);	 Catch:{ all -> 0x025d }
        r1 = r9.b(r2, r1);	 Catch:{ all -> 0x025d }
        if (r1 == 0) goto L_0x0298;
    L_0x0259:
        r1 = r2 + 1;
    L_0x025b:
        r2 = r1;
        goto L_0x0244;
    L_0x025d:
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x025d }
        throw r1;
    L_0x0260:
        r1 = bXc();
        r1 = r1.size();
        r1 = r1 + -1;
        goto L_0x00fc;
    L_0x026c:
        r7 = new com.tencent.mm.plugin.wenote.model.a.h;
        r7.<init>();
        r7.type = r6;
        r8 = "";
        r7.content = r8;
        r7.tXT = r5;
        r7.tXR = r6;
        r7.tXX = r5;
        r9.b(r1, r7);
        goto L_0x011f;
    L_0x0283:
        if (r3 != 0) goto L_0x0146;
    L_0x0285:
        r2 = r9.tZc;
        r4 = bXc();
        r4 = r4.size();
        r4 = r4 - r3;
        r2.er(r3, r4);
        goto L_0x0146;
    L_0x0295:
        r4 = r5;
        goto L_0x00e9;
    L_0x0298:
        r1 = r2;
        goto L_0x025b;
    L_0x029a:
        r3 = r4;
        goto L_0x023f;
    L_0x029c:
        r1 = r2;
        goto L_0x0207;
    L_0x029f:
        r1 = r5;
        goto L_0x00a0;
    L_0x02a2:
        r1 = r2;
        goto L_0x00a4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, boolean, boolean, boolean, boolean, boolean):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.b> r10, int r11, int r12, int r13, int r14) {
        /*
        r9 = this;
        r5 = 1;
        r3 = -1;
        r4 = 0;
        if (r10 == 0) goto L_0x0017;
    L_0x0005:
        r1 = r10.size();
        if (r1 <= 0) goto L_0x0017;
    L_0x000b:
        r1 = r9.jXe;
        if (r1 == 0) goto L_0x0017;
    L_0x000f:
        if (r12 < 0) goto L_0x0017;
    L_0x0011:
        if (r13 < 0) goto L_0x0017;
    L_0x0013:
        if (r14 < 0) goto L_0x0017;
    L_0x0015:
        if (r14 >= r13) goto L_0x0022;
    L_0x0017:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList,error,return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
    L_0x0021:
        return r1;
    L_0x0022:
        r1 = com.tencent.mm.plugin.wenote.model.c.bWA();
        r1 = r1.tWL;
        if (r1 != 0) goto L_0x0035;
    L_0x002a:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList, but get wnnote base is null, return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
        goto L_0x0021;
    L_0x0035:
        r1 = r10.size();
        r1 = r1 + -1;
        r1 = r10.get(r1);
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;
        if (r1 != 0) goto L_0x004e;
    L_0x0043:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList, lastInsertItem is null";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
        goto L_0x0021;
    L_0x004e:
        r1.tXT = r3;
        r1.tXR = r5;
        r1.tXX = r4;
        r2 = r9.BL(r12);
        if (r2 != 0) goto L_0x0065;
    L_0x005a:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList, item is null";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
        goto L_0x0021;
    L_0x0065:
        monitor-enter(r9);
        r9.bXg();	 Catch:{ all -> 0x01d8 }
        if (r11 != 0) goto L_0x016f;
    L_0x006b:
        r1 = r2.getType();	 Catch:{ all -> 0x01d8 }
        if (r1 != r5) goto L_0x016f;
    L_0x0071:
        r0 = r2;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x01d8 }
        r1 = r0;
        r1 = r1.content;	 Catch:{ all -> 0x01d8 }
        r6 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(r1);	 Catch:{ all -> 0x01d8 }
        if (r6 == 0) goto L_0x0089;
    L_0x007d:
        r1 = r6.length();	 Catch:{ all -> 0x01d8 }
        if (r13 > r1) goto L_0x0089;
    L_0x0083:
        r1 = r6.length();	 Catch:{ all -> 0x01d8 }
        if (r14 <= r1) goto L_0x00b6;
    L_0x0089:
        r2 = "MicroMsg.Note.NoteDataManager";
        r4 = "pasteItemList error, oriText:%d  startOff:%d  endOff:%d";
        r1 = 3;
        r5 = new java.lang.Object[r1];	 Catch:{ all -> 0x01d8 }
        r7 = 0;
        if (r6 != 0) goto L_0x00b1;
    L_0x0095:
        r1 = r3;
    L_0x0096:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x01d8 }
        r5[r7] = r1;	 Catch:{ all -> 0x01d8 }
        r1 = 1;
        r6 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x01d8 }
        r5[r1] = r6;	 Catch:{ all -> 0x01d8 }
        r1 = 2;
        r6 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x01d8 }
        r5[r1] = r6;	 Catch:{ all -> 0x01d8 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r4, r5);	 Catch:{ all -> 0x01d8 }
        monitor-exit(r9);	 Catch:{ all -> 0x01d8 }
        r1 = r3;
        goto L_0x0021;
    L_0x00b1:
        r1 = r6.length();	 Catch:{ all -> 0x01d8 }
        goto L_0x0096;
    L_0x00b6:
        r1 = 0;
        r1 = r6.subSequence(r1, r13);	 Catch:{ all -> 0x01d8 }
        r3 = r6.length();	 Catch:{ all -> 0x01d8 }
        r3 = r6.subSequence(r14, r3);	 Catch:{ all -> 0x01d8 }
        r1 = (android.text.Spanned) r1;	 Catch:{ all -> 0x01d8 }
        r6 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x01d8 }
        r0 = r3;
        r0 = (android.text.Spanned) r0;	 Catch:{ all -> 0x01d8 }
        r1 = r0;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x01d8 }
        r2 = (com.tencent.mm.plugin.wenote.model.a.h) r2;	 Catch:{ all -> 0x01d8 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r6);	 Catch:{ all -> 0x01d8 }
        if (r3 != 0) goto L_0x0141;
    L_0x00d9:
        r3 = "<br/>";
        r3 = r6.endsWith(r3);	 Catch:{ all -> 0x01d8 }
        if (r3 == 0) goto L_0x013f;
    L_0x00e2:
        r3 = 0;
        r7 = r6.length();	 Catch:{ all -> 0x01d8 }
        r7 = r7 + -5;
        r3 = r6.substring(r3, r7);	 Catch:{ all -> 0x01d8 }
    L_0x00ed:
        r2.content = r3;	 Catch:{ all -> 0x01d8 }
        r12 = r12 + 1;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);	 Catch:{ all -> 0x01d8 }
        if (r2 != 0) goto L_0x016b;
    L_0x00f7:
        r2 = new com.tencent.mm.plugin.wenote.model.a.h;	 Catch:{ all -> 0x01d8 }
        r2.<init>();	 Catch:{ all -> 0x01d8 }
        r3 = 1;
        r2.type = r3;	 Catch:{ all -> 0x01d8 }
        r3 = "<br/>";
        r3 = r1.startsWith(r3);	 Catch:{ all -> 0x01d8 }
        if (r3 == 0) goto L_0x0111;
    L_0x0108:
        r3 = 5;
        r4 = r1.length();	 Catch:{ all -> 0x01d8 }
        r1 = r1.substring(r3, r4);	 Catch:{ all -> 0x01d8 }
    L_0x0111:
        r2.content = r1;	 Catch:{ all -> 0x01d8 }
        r1 = 0;
        r2.tXT = r1;	 Catch:{ all -> 0x01d8 }
        r1 = 0;
        r2.tXR = r1;	 Catch:{ all -> 0x01d8 }
        r1 = 0;
        r2.tXX = r1;	 Catch:{ all -> 0x01d8 }
        r9.b(r12, r2);	 Catch:{ all -> 0x01d8 }
        r3 = r5;
        r4 = r12;
        r2 = r12;
    L_0x0122:
        r5 = r10.iterator();	 Catch:{ all -> 0x01d8 }
    L_0x0126:
        r1 = r5.hasNext();	 Catch:{ all -> 0x01d8 }
        if (r1 == 0) goto L_0x0194;
    L_0x012c:
        r1 = r5.next();	 Catch:{ all -> 0x01d8 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x01d8 }
        r9.b(r1);	 Catch:{ all -> 0x01d8 }
        r1 = r9.b(r2, r1);	 Catch:{ all -> 0x01d8 }
        if (r1 == 0) goto L_0x01fc;
    L_0x013b:
        r1 = r2 + 1;
    L_0x013d:
        r2 = r1;
        goto L_0x0126;
    L_0x013f:
        r3 = r6;
        goto L_0x00ed;
    L_0x0141:
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r1);	 Catch:{ all -> 0x01d8 }
        if (r3 != 0) goto L_0x015f;
    L_0x0147:
        r3 = "<br/>";
        r3 = r1.startsWith(r3);	 Catch:{ all -> 0x01d8 }
        if (r3 == 0) goto L_0x0159;
    L_0x0150:
        r3 = 5;
        r5 = r1.length();	 Catch:{ all -> 0x01d8 }
        r1 = r1.substring(r3, r5);	 Catch:{ all -> 0x01d8 }
    L_0x0159:
        r2.content = r1;	 Catch:{ all -> 0x01d8 }
        r3 = r4;
        r2 = r12;
        r4 = r12;
        goto L_0x0122;
    L_0x015f:
        r9.BM(r12);	 Catch:{ all -> 0x01d8 }
        r1 = r9.tZc;	 Catch:{ all -> 0x01d8 }
        if (r1 == 0) goto L_0x016b;
    L_0x0166:
        r1 = r9.tZc;	 Catch:{ all -> 0x01d8 }
        r1.BG(r12);	 Catch:{ all -> 0x01d8 }
    L_0x016b:
        r3 = r4;
        r2 = r12;
        r4 = r12;
        goto L_0x0122;
    L_0x016f:
        if (r11 == r5) goto L_0x01f9;
    L_0x0171:
        r3 = r12 + 1;
    L_0x0173:
        r5 = r10.iterator();	 Catch:{ all -> 0x01d8 }
        r2 = r3;
    L_0x0178:
        r1 = r5.hasNext();	 Catch:{ all -> 0x01d8 }
        if (r1 == 0) goto L_0x0191;
    L_0x017e:
        r1 = r5.next();	 Catch:{ all -> 0x01d8 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x01d8 }
        r9.b(r1);	 Catch:{ all -> 0x01d8 }
        r1 = r9.b(r2, r1);	 Catch:{ all -> 0x01d8 }
        if (r1 == 0) goto L_0x01f7;
    L_0x018d:
        r1 = r2 + 1;
    L_0x018f:
        r2 = r1;
        goto L_0x0178;
    L_0x0191:
        r8 = r4;
        r4 = r3;
        r3 = r8;
    L_0x0194:
        monitor-exit(r9);	 Catch:{ all -> 0x01d8 }
        r1 = r2 + -1;
        if (r1 < 0) goto L_0x01db;
    L_0x0199:
        r1 = r2 + -1;
        r5 = bXc();
        r5 = r5.size();
        if (r1 >= r5) goto L_0x01db;
    L_0x01a5:
        r1 = r2 + -1;
    L_0x01a7:
        r5 = r9.tZc;
        if (r5 == 0) goto L_0x01d3;
    L_0x01ab:
        r2 = r2 - r4;
        if (r3 == 0) goto L_0x01b0;
    L_0x01ae:
        r2 = r2 + 1;
    L_0x01b0:
        if (r4 < 0) goto L_0x01b9;
    L_0x01b2:
        if (r2 <= 0) goto L_0x01b9;
    L_0x01b4:
        r3 = r9.tZc;
        r3.eq(r4, r2);
    L_0x01b9:
        if (r4 <= 0) goto L_0x01e6;
    L_0x01bb:
        r2 = r9.tZc;
        r3 = r4 + -1;
        r5 = bXc();
        r5 = r5.size();
        r4 = r4 + -1;
        r4 = r5 - r4;
        r2.er(r3, r4);
    L_0x01ce:
        r2 = r9.tZc;
        r2.BH(r1);
    L_0x01d3:
        r9.bXl();
        goto L_0x0021;
    L_0x01d8:
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x01d8 }
        throw r1;
    L_0x01db:
        r1 = bXc();
        r1 = r1.size();
        r1 = r1 + -1;
        goto L_0x01a7;
    L_0x01e6:
        if (r4 != 0) goto L_0x01ce;
    L_0x01e8:
        r2 = r9.tZc;
        r3 = bXc();
        r3 = r3.size();
        r3 = r3 - r4;
        r2.er(r4, r3);
        goto L_0x01ce;
    L_0x01f7:
        r1 = r2;
        goto L_0x018f;
    L_0x01f9:
        r3 = r12;
        goto L_0x0173;
    L_0x01fc:
        r1 = r2;
        goto L_0x013d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, int, int, int, int):int");
    }

    private void b(b bVar) {
        if (bVar != null) {
            n nVar = (n) bVar;
            if (nVar.getType() > 1) {
                if (bi.oN(nVar.tYn)) {
                    if (this.tZe == 0 && this.jXe != null) {
                        Iterator it = this.jXe.iterator();
                        while (it.hasNext()) {
                            n nVar2 = (n) ((b) it.next());
                            if (nVar2.tYn.startsWith("WeNote_")) {
                                int i = bi.getInt(nVar2.tYn.substring(7), -1);
                                if (i <= this.tZe) {
                                    i = this.tZe;
                                }
                                this.tZe = i;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("WeNote_");
                    int i2 = this.tZe + 1;
                    this.tZe = i2;
                    nVar.tYn = stringBuilder.append(i2).toString();
                }
                d dVar = com.tencent.mm.plugin.wenote.model.c.bWA().tWL;
                if (dVar == null) {
                    x.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", bVar.toString());
                } else if (dVar.tWR == null) {
                    x.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", bVar.toString());
                } else {
                    dVar.tWR.put(nVar.tYn, nVar);
                }
            }
            if (bi.oN(bVar.mBr)) {
                bVar.mBr = f.Rn(bVar.toString());
            }
        }
    }

    public final ArrayList<b> bXk() {
        if (this.jXe == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.jXe.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mm.plugin.wenote.b.c.c((b) it.next()));
            }
        }
        return arrayList;
    }

    public final boolean ab(ArrayList<b> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.getType() != 1) {
                i++;
            } else {
                stringBuilder.append(((com.tencent.mm.plugin.wenote.model.a.h) bVar).content);
            }
        }
        return et(com.tencent.mm.plugin.wenote.b.c.RA(stringBuilder.toString()), i);
    }

    public final boolean et(int i, int i2) {
        boolean z;
        boolean z2;
        if (i < 0) {
            z = false;
        } else {
            z = true;
        }
        if (i2 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && this.tZf + i > 16384) {
            return true;
        }
        if (!z2 || this.tZg + i2 <= 30) {
            return false;
        }
        return true;
    }

    public final void bXl() {
        as.Dt().F(new Runnable() {
            public final void run() {
                synchronized (this) {
                    if (c.this.jXe == null) {
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = c.this.jXe.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        if (bVar.getType() != 1) {
                            i++;
                        } else {
                            stringBuilder.append(((com.tencent.mm.plugin.wenote.model.a.h) bVar).content);
                        }
                    }
                    c.this.tZf = com.tencent.mm.plugin.wenote.b.c.RA(stringBuilder.toString());
                    c.this.tZg = i;
                }
            }
        });
    }

    private void a(b bVar, boolean z) {
        if (bVar != null) {
            if (bVar.getType() == 1) {
                int RA = com.tencent.mm.plugin.wenote.b.c.RA(((com.tencent.mm.plugin.wenote.model.a.h) bVar).content);
                if (z) {
                    this.tZf = RA + this.tZf;
                } else {
                    this.tZf -= RA;
                }
            } else if (z) {
                this.tZg++;
            } else {
                this.tZg--;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eu(int r10, int r11) {
        /*
        r9 = this;
        r0 = 0;
        r3 = -1;
        r8 = 1;
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r10);
        r4[r0] = r5;
        r5 = java.lang.Integer.valueOf(r11);
        r4[r8] = r5;
        r5 = 2;
        r6 = java.lang.Boolean.valueOf(r8);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r4);
        monitor-enter(r9);
        r1 = r9.jXe;	 Catch:{ all -> 0x00e3 }
        if (r1 != 0) goto L_0x0029;
    L_0x0027:
        monitor-exit(r9);	 Catch:{ all -> 0x00e3 }
    L_0x0028:
        return;
    L_0x0029:
        if (r10 > 0) goto L_0x002c;
    L_0x002b:
        r10 = r0;
    L_0x002c:
        r0 = r9.jXe;	 Catch:{ all -> 0x00e3 }
        r0 = r0.size();	 Catch:{ all -> 0x00e3 }
        if (r11 < r0) goto L_0x011b;
    L_0x0034:
        r0 = r9.jXe;	 Catch:{ all -> 0x00e3 }
        r0 = r0.size();	 Catch:{ all -> 0x00e3 }
        r11 = r0 + -1;
        r2 = r3;
    L_0x003d:
        if (r11 <= r10) goto L_0x0103;
    L_0x003f:
        r0 = r9.jXe;	 Catch:{ all -> 0x00e3 }
        r0 = r0.get(r11);	 Catch:{ all -> 0x00e3 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x00e3 }
        r1 = r9.jXe;	 Catch:{ all -> 0x00e3 }
        r4 = r11 + -1;
        r1 = r1.get(r4);	 Catch:{ all -> 0x00e3 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00d1;
    L_0x0053:
        r4 = r0.getType();	 Catch:{ all -> 0x00e3 }
        if (r4 != r8) goto L_0x00d1;
    L_0x0059:
        if (r1 == 0) goto L_0x00d1;
    L_0x005b:
        r4 = r1.getType();	 Catch:{ all -> 0x00e3 }
        if (r4 != r8) goto L_0x00d1;
    L_0x0061:
        r2 = r11 + -1;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x00e3 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.h) r1;	 Catch:{ all -> 0x00e3 }
        r4 = r0.content;	 Catch:{ all -> 0x00e3 }
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);	 Catch:{ all -> 0x00e3 }
        if (r4 != 0) goto L_0x00f5;
    L_0x006f:
        r4 = r0.content;	 Catch:{ all -> 0x00e3 }
        r4 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(r4);	 Catch:{ all -> 0x00e3 }
        r5 = r1.content;	 Catch:{ all -> 0x00e3 }
        r5 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(r5);	 Catch:{ all -> 0x00e3 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e3 }
        r6.<init>();	 Catch:{ all -> 0x00e3 }
        r7 = r1.content;	 Catch:{ all -> 0x00e3 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e3 }
        r7 = "<br/>";
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e3 }
        r7 = r0.content;	 Catch:{ all -> 0x00e3 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e3 }
        r6 = r6.toString();	 Catch:{ all -> 0x00e3 }
        r1.content = r6;	 Catch:{ all -> 0x00e3 }
        r6 = r0.tXR;	 Catch:{ all -> 0x00e3 }
        if (r6 == 0) goto L_0x00e6;
    L_0x009d:
        r6 = 1;
        r1.tXR = r6;	 Catch:{ all -> 0x00e3 }
        r6 = 0;
        r1.tXX = r6;	 Catch:{ all -> 0x00e3 }
        r6 = r0.tXT;	 Catch:{ all -> 0x00e3 }
        if (r6 == r3) goto L_0x00af;
    L_0x00a7:
        r6 = r0.tXT;	 Catch:{ all -> 0x00e3 }
        r4 = r4.length();	 Catch:{ all -> 0x00e3 }
        if (r6 < r4) goto L_0x00d7;
    L_0x00af:
        r0 = -1;
        r1.tXT = r0;	 Catch:{ all -> 0x00e3 }
    L_0x00b2:
        r0 = "MicroMsg.Note.NoteDataManager";
        r1 = "checkMergeTextDataItem remove position: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e3 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00e3 }
        r4[r5] = r6;	 Catch:{ all -> 0x00e3 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);	 Catch:{ all -> 0x00e3 }
        r9.BM(r11);	 Catch:{ all -> 0x00e3 }
        r0 = r9.tZc;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00d1;
    L_0x00cc:
        r0 = r9.tZc;	 Catch:{ all -> 0x00e3 }
        r0.BG(r11);	 Catch:{ all -> 0x00e3 }
    L_0x00d1:
        r0 = r2;
        r11 = r11 + -1;
        r2 = r0;
        goto L_0x003d;
    L_0x00d7:
        r4 = r5.length();	 Catch:{ all -> 0x00e3 }
        r4 = r4 + 1;
        r0 = r0.tXT;	 Catch:{ all -> 0x00e3 }
        r0 = r0 + r4;
        r1.tXT = r0;	 Catch:{ all -> 0x00e3 }
        goto L_0x00b2;
    L_0x00e3:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00e3 }
        throw r0;
    L_0x00e6:
        r0 = r1.tXR;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00b2;
    L_0x00ea:
        r0 = r1.tXT;	 Catch:{ all -> 0x00e3 }
        if (r0 != r3) goto L_0x00b2;
    L_0x00ee:
        r0 = r5.length();	 Catch:{ all -> 0x00e3 }
        r1.tXT = r0;	 Catch:{ all -> 0x00e3 }
        goto L_0x00b2;
    L_0x00f5:
        r0 = r0.tXR;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00b2;
    L_0x00f9:
        r0 = 1;
        r1.tXR = r0;	 Catch:{ all -> 0x00e3 }
        r0 = 0;
        r1.tXX = r0;	 Catch:{ all -> 0x00e3 }
        r0 = -1;
        r1.tXT = r0;	 Catch:{ all -> 0x00e3 }
        goto L_0x00b2;
    L_0x0103:
        monitor-exit(r9);	 Catch:{ all -> 0x00e3 }
        if (r2 == r3) goto L_0x0116;
    L_0x0106:
        r0 = r9.tZc;
        if (r0 == 0) goto L_0x0116;
    L_0x010a:
        r0 = r9.tZc;
        r1 = r9.jXe;
        r1 = r1.size();
        r1 = r1 - r2;
        r0.er(r2, r1);
    L_0x0116:
        r9.bXl();
        goto L_0x0028;
    L_0x011b:
        r2 = r3;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eu(int, int):void");
    }

    public final String Rv(String str) {
        String replace;
        synchronized (this) {
            if (this.jXe != null) {
                int i = 0;
                String str2 = str;
                while (i < this.jXe.size()) {
                    if (((b) this.jXe.get(i)).getType() == 1) {
                        replace = com.tencent.mm.plugin.wenote.b.b.Ry(((com.tencent.mm.plugin.wenote.model.a.h) this.jXe.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
                        if (!bi.oN(replace)) {
                            int i2;
                            String[] split = replace.split("\n");
                            for (int i3 = 0; i3 < split.length; i3++) {
                                if (!bi.oN(split[i3].trim())) {
                                    replace = split[i3];
                                    i2 = 1;
                                    break;
                                }
                            }
                            replace = str2;
                            i2 = 0;
                            if (i2 != 0) {
                                break;
                            }
                            i++;
                            str2 = replace;
                        }
                    }
                    replace = str2;
                    i++;
                    str2 = replace;
                }
                replace = str2;
            } else {
                replace = str;
            }
        }
        if (replace.length() > 1000) {
            return replace.substring(0, 1000);
        }
        return replace;
    }

    public final int bXm() {
        synchronized (this) {
            if (this.jXe == null) {
                return -1;
            }
            int i = 0;
            while (i < this.jXe.size()) {
                b bVar = (b) this.jXe.get(i);
                if (bVar == null || bVar.getType() == -3 || bVar.getType() == -2) {
                    i++;
                } else {
                    return i;
                }
            }
            return -1;
        }
    }

    public final int bXn() {
        synchronized (this) {
            if (this.jXe == null) {
                return -1;
            }
            int size = this.jXe.size() - 1;
            while (size >= 0) {
                b bVar = (b) this.jXe.get(size);
                if (bVar == null || bVar.getType() == -3 || bVar.getType() == -2) {
                    size--;
                } else {
                    return size;
                }
            }
            return -1;
        }
    }
}
