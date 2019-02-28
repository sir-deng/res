package com.tencent.mm.booter;

import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import java.util.LinkedList;

public final class i {
    public static void run() {
        int i;
        aoc aoc;
        LinkedList linkedList = new LinkedList();
        int a = bi.a((Integer) as.Hk().get(19), 0);
        for (i = 0; i < a; i++) {
            aoc = new aoc();
            aoc.pWg = 31;
            aoc.pWq = "0";
            linkedList.add(aoc);
        }
        a = bi.a((Integer) as.Hk().get(20), 0);
        for (i = 0; i < a; i++) {
            aoc = new aoc();
            aoc.pWg = 31;
            aoc.pWq = "1";
            linkedList.add(aoc);
        }
        if (linkedList.size() > 0) {
            bp.a(linkedList);
            as.Hk().set(19, Integer.valueOf(0));
            as.Hk().set(20, Integer.valueOf(0));
        }
    }
}
