package com.tencent.mm.plugin.fts.a.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public final class b {
    private HashSet<String> mSf = new HashSet();
    public c mSg = new c(' ');

    public final void BN(String str) {
        if (this.mSf.add(str)) {
            c cVar = this.mSg;
            char[] toCharArray = str.toLowerCase().toCharArray();
            for (int i = 0; i < toCharArray.length; i++) {
                int i2 = toCharArray[i] - 97;
                if (cVar.mSh[i2] == null) {
                    cVar.mSh[i2] = new c(toCharArray[i]);
                }
                cVar = cVar.mSh[i2];
            }
            cVar.mSe = true;
        }
    }

    public final List<List<String>> BO(String str) {
        Queue arrayDeque = new ArrayDeque();
        arrayDeque.offer(new a(0, 0, null));
        char[] toCharArray = str.toLowerCase().toCharArray();
        List<List<String>> arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            a aVar = (a) arrayDeque.poll();
            if (aVar == null) {
                break;
            }
            int i = aVar.end;
            c cVar = this.mSg;
            while (i < toCharArray.length) {
                int i2 = toCharArray[i] - 97;
                if (cVar.mSh[i2] == null) {
                    break;
                }
                cVar = cVar.mSh[i2];
                if (cVar.mSe || i == toCharArray.length - 1) {
                    if (aVar.ayR == null) {
                        aVar.ayR = new ArrayList();
                    }
                    a aVar2 = new a(aVar.end, i + 1, aVar);
                    aVar.ayR.add(aVar2);
                    if (aVar2.end == toCharArray.length) {
                        aVar2.mSe = true;
                    }
                    arrayDeque.offer(aVar2);
                }
                i++;
            }
            if (aVar.mSe) {
                List arrayList2 = new ArrayList();
                while (aVar != null) {
                    if (aVar.end > aVar.start) {
                        arrayList2.add(str.substring(aVar.start, aVar.end));
                    }
                    aVar = aVar.mSd;
                }
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }
}
