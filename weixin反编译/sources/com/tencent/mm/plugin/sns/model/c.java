package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public static void d(String str, long j, long j2, int i) {
        if (j2 != 0) {
            wt wtVar;
            wt LT = ae.bwj().LT(str);
            if (LT == null) {
                wtVar = new wt();
            } else {
                wtVar = LT;
            }
            if (j != 0 || !wtVar.wnO.isEmpty()) {
                ux uxVar;
                if (j == 0) {
                    j = ((ux) wtVar.wnO.getFirst()).wjA;
                }
                ux uxVar2 = new ux();
                uxVar2.wjA = j;
                uxVar2.wjB = j2;
                bpc bpc = new bpc();
                bpc.wYr = j;
                bpc.wYs = j2;
                bpc.wYt = i;
                uxVar2.wjC.add(bpc);
                while (true) {
                    uxVar = uxVar2;
                    if (wtVar.wnO.isEmpty()) {
                        break;
                    }
                    uxVar2 = (ux) wtVar.wnO.getFirst();
                    if (C(uxVar.wjB, uxVar2.wjA) > 0) {
                        x.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + uxVar.wjB + " fault.Max" + uxVar2.wjA);
                        break;
                    } else {
                        wtVar.wnO.removeFirst();
                        uxVar2 = a(uxVar2, uxVar);
                    }
                }
                wtVar.wnO.addFirst(uxVar);
                while (wtVar.wnO.size() > 100) {
                    wtVar.wnO.removeLast();
                }
                if (wtVar.wnO.size() > 0) {
                    x.d("MicroMsg.FaultLogic", "min " + ((ux) wtVar.wnO.get(0)).wjB + " max " + ((ux) wtVar.wnO.get(0)).wjA);
                }
                k LV = ae.bwj().LV(str);
                try {
                    LV.field_userName = str;
                    LV.field_faultS = wtVar.toByteArray();
                    ae.bwj().c(LV);
                } catch (Exception e) {
                }
                if (wtVar.wnO.size() > 1) {
                    x.d("MicroMsg.FaultLogic", "fault size : " + wtVar.wnO.size());
                    Iterator it = wtVar.wnO.iterator();
                    while (it.hasNext()) {
                        uxVar2 = (ux) it.next();
                        x.d("MicroMsg.FaultLogic", "min - max " + uxVar2.wjB + " " + uxVar2.wjA);
                    }
                }
            }
        }
    }

    private static ux a(ux uxVar, ux uxVar2) {
        ux uxVar3 = new ux();
        if (C(uxVar.wjA, uxVar2.wjA) > 0) {
            uxVar3.wjA = uxVar.wjA;
        } else {
            uxVar3.wjA = uxVar2.wjA;
        }
        if (C(uxVar.wjB, uxVar2.wjB) < 0) {
            uxVar3.wjB = uxVar.wjB;
        } else {
            uxVar3.wjB = uxVar2.wjB;
        }
        LinkedList linkedList = uxVar.wjC;
        Iterator it = uxVar2.wjC.iterator();
        while (it.hasNext()) {
            bpc bpc = (bpc) it.next();
            if (linkedList.isEmpty()) {
                x.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
                linkedList.addFirst(bpc);
            } else {
                int i;
                long j = bpc.wYs;
                int size = linkedList.size() - 1;
                while (size >= 0) {
                    if (C(j, ((bpc) linkedList.get(size)).wYr) <= 0) {
                        break;
                    }
                    size--;
                }
                size = -1;
                j = bpc.wYr;
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= linkedList.size()) {
                        i = linkedList.size();
                        break;
                    } else if (C(j, ((bpc) linkedList.get(i)).wYs) >= 0) {
                        break;
                    } else {
                        i2 = i + 1;
                    }
                }
                if (size == -1) {
                    linkedList.addFirst(bpc);
                } else if (i == linkedList.size()) {
                    linkedList.addLast(bpc);
                } else {
                    bpc bpc2 = (bpc) linkedList.get(i);
                    if (C(bpc.wYr, bpc2.wYr) < 0) {
                        bpc bpc3 = new bpc();
                        bpc3.wYr = bpc2.wYr;
                        j = bpc.wYr;
                        bpc3.wYs = j == Long.MAX_VALUE ? Long.MIN_VALUE : j + 1;
                        bpc3.wYt = bpc2.wYt;
                        linkedList.add(i, bpc3);
                        i2 = i + 1;
                        i = size + 1;
                        size = i2;
                    } else {
                        int i3 = i;
                        i = size;
                        size = i3;
                    }
                    bpc2 = (bpc) linkedList.get(i);
                    if (C(bpc.wYs, bpc2.wYs) > 0) {
                        bpc bpc4 = new bpc();
                        bpc4.wYs = bpc2.wYs;
                        bpc4.wYr = ev(bpc.wYs);
                        bpc4.wYt = bpc2.wYt;
                        linkedList.add(i + 1, bpc4);
                    }
                    while (i >= size) {
                        linkedList.remove(i);
                        i--;
                    }
                    linkedList.add(size, bpc);
                    if (linkedList.size() > 100) {
                        int i4;
                        long j2;
                        long j3 = ((bpc) linkedList.getLast()).wYs;
                        long j4 = ((bpc) linkedList.getLast()).wYr;
                        int i5 = ((bpc) linkedList.getLast()).wYt;
                        while (true) {
                            i4 = i5;
                            j2 = j4;
                            if (linkedList.size() < 100) {
                                break;
                            }
                            bpc = (bpc) linkedList.removeLast();
                            j4 = bpc.wYr;
                            if (bpc.wYt < i4) {
                                i5 = bpc.wYt;
                            } else {
                                i5 = i4;
                            }
                        }
                        bpc bpc5 = new bpc();
                        bpc5.wYr = j2;
                        bpc5.wYs = j3;
                        bpc5.wYt = i4;
                        linkedList.addLast(bpc5);
                    }
                }
            }
        }
        uxVar3.wjC = linkedList;
        return uxVar3;
    }

    private static long C(long j, long j2) {
        if ((j <= 0 || j2 <= 0) && (j >= 0 || j2 >= 0)) {
            return j < 0 ? 1 : -1;
        } else {
            return j - j2;
        }
    }

    public static long ev(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j - 1;
    }

    public static int a(long j, long j2, String str) {
        LinkedList linkedList = ae.bwj().LT(str).wnO;
        x.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", Integer.valueOf(r0.wnO.size()));
        if (linkedList.isEmpty()) {
            return 0;
        }
        ux uxVar = (ux) linkedList.getFirst();
        if (j == 0 || C(uxVar.wjB, j) > 0) {
            x.e("MicroMsg.FaultLogic", "has a fault  minId:" + j2 + " fault.min:" + uxVar.wjB);
            return 0;
        } else if (j2 == 0 || C(uxVar.wjA, j2) >= 0) {
            LinkedList linkedList2 = uxVar.wjC;
            if (linkedList2.isEmpty()) {
                return 0;
            }
            Iterator it = linkedList2.iterator();
            int i = Integer.MAX_VALUE;
            while (it.hasNext()) {
                bpc bpc = (bpc) it.next();
                if (j2 == 0 || C(j2, bpc.wYs) >= 0) {
                    if (bpc.wYt < i) {
                        i = bpc.wYt;
                    }
                    if (C(j, bpc.wYs) >= 0) {
                        if (i == Integer.MAX_VALUE) {
                            return 0;
                        }
                        return i;
                    }
                }
            }
            x.i("MicroMsg.FaultLogic", "should not to hear  minId:" + j);
            return 0;
        } else {
            x.e("MicroMsg.FaultLogic", ":" + j2 + " fault.max:" + uxVar.wjA);
            return 0;
        }
    }
}
