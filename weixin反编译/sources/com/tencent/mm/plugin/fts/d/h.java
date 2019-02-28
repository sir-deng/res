package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.util.SparseArray;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private static a mUB = new a();

    public static class a {
        boolean isReady;
        g mUC;
        SparseArray<b> mUD = new SparseArray();

        public final synchronized void a(b bVar) {
            this.mUD.put(bVar.getType(), bVar);
        }

        public final synchronized void qz(int i) {
            this.mUD.remove(i);
        }
    }

    public interface b extends Comparable<b> {
        i a(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i);

        int getPriority();

        int getType();
    }

    public static void a(b bVar) {
        mUB.a(bVar);
    }

    public static void qz(int i) {
        mUB.qz(i);
    }

    public static void a(g gVar) {
        a aVar = mUB;
        aVar.mUC = gVar;
        aVar.isReady = true;
    }

    public static void aOd() {
        a aVar = mUB;
        if (aVar.mUC != null) {
            aVar.mUC.aOc();
            aVar.mUC = null;
        }
        aVar.isReady = false;
    }

    public static g aOe() {
        return mUB.mUC;
    }

    public static LinkedList<i> a(HashSet<Integer> hashSet, Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        LinkedList<i> linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) mUB.mUD.get(((Integer) it.next()).intValue());
            if (bVar2 != null) {
                linkedList2.add(bVar2);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((b) it2.next()).a(context, bVar, i));
        }
        return linkedList;
    }

    public static i a(int i, Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i2) {
        b bVar2 = (b) mUB.mUD.get(i);
        if (bVar2 != null) {
            return bVar2.a(context, bVar, i2);
        }
        return null;
    }
}
