package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f extends Thread {
    private boolean isStop = false;
    private int lkV = 0;
    private int lkW = 0;
    private h lll;
    private HashSet<String> llq;

    public f(HashSet<String> hashSet, h hVar) {
        this.llq = hashSet;
        this.lll = hVar;
    }

    public final void run() {
        if (this.llq == null || this.llq.isEmpty()) {
            x.w("MicroMsg.DeleteOtherAccController", "delete paths is null.");
            bW(0);
            return;
        }
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Dr();
        g.Do();
        String s = com.tencent.mm.a.g.s(stringBuilder.append(a.Cn()).toString().getBytes());
        Iterator it = this.llq.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            x.i("MicroMsg.DeleteOtherAccController", "uinPath[%s] path[%s]", s, str);
            if (!bi.fA(s, str)) {
                c(g.Dq().gRS + str, arrayList);
                c(w.hbv + str, arrayList2);
            }
        }
        this.lkV = arrayList.size() + arrayList2.size();
        this.lkW = 0;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        int size = arrayList.size();
        PInt pInt = new PInt();
        int i = 0;
        while (!this.isStop && i < size) {
            pInt.value = 0;
            str = (String) arrayList.get(i);
            i++;
            x.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", Integer.valueOf(i), str, Integer.valueOf(pInt.value));
            if (a(new File(str), pInt, pLong) == -1) {
                break;
            }
            this.lkW++;
            azb();
        }
        int size2 = arrayList2.size();
        PInt pInt2 = new PInt();
        i = 0;
        while (!this.isStop && i < size2) {
            pInt2.value = 0;
            str = (String) arrayList2.get(i);
            i++;
            x.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", Integer.valueOf(i), str, Integer.valueOf(pInt2.value));
            if (a(new File(str), pInt2, pLong2) == -1) {
                break;
            }
            this.lkW++;
            azb();
        }
        x.i("MicroMsg.DeleteOtherAccController", "delete finish sd[%d] data[%d]", Long.valueOf(pLong.value), Long.valueOf(pLong2.value));
        bW(pLong.value);
    }

    private static void c(String str, ArrayList<String> arrayList) {
        if (!bi.oN(str)) {
            x.i("MicroMsg.DeleteOtherAccController", "check paths [%s]", str);
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    for (String str2 : list) {
                        x.d("MicroMsg.DeleteOtherAccController", "check add path[%s]", str + File.separator + str2);
                        arrayList.add(str2);
                    }
                }
            }
        }
    }

    private void azb() {
        if (!this.isStop) {
            ah.y(new Runnable() {
                public final void run() {
                    if (f.this.lll != null) {
                        f.this.lll.cp(f.this.lkW, f.this.lkV);
                    }
                }
            });
        }
    }

    private void bW(final long j) {
        if (!this.isStop) {
            ah.y(new Runnable() {
                public final void run() {
                    if (f.this.lll != null) {
                        f.this.lll.bX(j);
                    }
                }
            });
        }
    }

    private int a(File file, PInt pInt, PLong pLong) {
        String str = "MicroMsg.DeleteOtherAccController";
        String str2 = "delete [%d] [%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = file != null ? file.getAbsolutePath() : "null";
        x.d(str, str2, objArr);
        if (pInt.value >= 10) {
            if (this.isStop) {
                return -1;
            }
            pInt.value = 0;
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    if (a(a, pInt, pLong) == -1) {
                        return -1;
                    }
                }
            }
            FileOp.deleteFile(file.getAbsolutePath());
        } else {
            pLong.value += file.length();
            FileOp.deleteFile(file.getAbsolutePath());
            pInt.value++;
        }
        return 1;
    }
}
