package com.tencent.mm.plugin.fps_lighter.d;

import com.tencent.gmtrace.Constants;
import com.tencent.mm.plugin.fps_lighter.c.b;
import com.tencent.mm.plugin.fps_lighter.c.c;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public final class a implements Runnable {
    private com.tencent.mm.plugin.fps_lighter.c.a mHr;
    private long[] mHs;
    int mHt;
    public a mHu;
    int msV;

    public interface a {
        void L(LinkedList<d> linkedList);
    }

    public a(long[] jArr, int i, int i2, long j, long j2, long j3, int i3, int i4, boolean z, long j4, boolean z2) {
        this.mHs = jArr;
        this.msV = i;
        this.mHt = i2;
        com.tencent.mm.plugin.fps_lighter.c.a aVar = new com.tencent.mm.plugin.fps_lighter.c.a();
        aVar.scene = i4;
        aVar.mGZ = j3;
        aVar.mHa = j2;
        aVar.mHb = z;
        aVar.mHd = i3;
        aVar.mHc = (int) j;
        aVar.mHf = j4;
        aVar.mHg = z2;
        x.i("MicroMsg.AsyncAnalyseTask", "[generateFpsInfoItem] %s", aVar.toString());
        this.mHr = aVar;
    }

    private List<b> a(List<com.tencent.mm.plugin.fps_lighter.c.b.a> list, com.tencent.mm.plugin.fps_lighter.c.a aVar) {
        x.i("MicroMsg.AsyncAnalyseTask", "[parseTrace] size:%s fpsInfoItem:%s", Integer.valueOf(list.size()), aVar);
        long currentTimeMillis = System.currentTimeMillis();
        List<b> linkedList = new LinkedList();
        Stack stack = new Stack();
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        for (com.tencent.mm.plugin.fps_lighter.c.b.a aVar2 : list) {
            int i5;
            int i6;
            if (aVar2.mHk) {
                aVar2.mHj = i3;
                i5 = i4 + 1;
                i3++;
                stack.push(aVar2);
                i6 = i3;
            } else if (stack.size() <= 0) {
                x.w("MicroMsg.AsyncAnalyseTask", "Empty stack, item:%s", aVar2);
            } else {
                com.tencent.mm.plugin.fps_lighter.c.b.a aVar3 = (com.tencent.mm.plugin.fps_lighter.c.b.a) stack.peek();
                if (aVar3.mHi != aVar2.mHi) {
                    x.w("MicroMsg.AsyncAnalyseTask", "No match in rawItem:%s topRawItem:%s", aVar2, aVar3);
                    stack.pop();
                    while (true) {
                        i4--;
                        if (stack.size() <= 0) {
                            break;
                        }
                        aVar3 = (com.tencent.mm.plugin.fps_lighter.c.b.a) stack.peek();
                        if (aVar2.mHi == aVar3.mHi) {
                            x.w("MicroMsg.AsyncAnalyseTask", "Find it");
                            break;
                        }
                        stack.pop();
                    }
                    if (stack.size() == 0) {
                        x.w("MicroMsg.AsyncAnalyseTask", "Still can't find it, ignore this out %s", aVar2);
                    }
                }
                com.tencent.mm.plugin.fps_lighter.c.b.a aVar4 = aVar3;
                i5 = i4;
                com.tencent.mm.plugin.fps_lighter.c.b.a aVar5 = aVar4;
                stack.pop();
                i = i5 - 1;
                b bVar = new b();
                bVar.axZ = i;
                if (stack.size() == 0) {
                    bVar.mHh = -1;
                } else {
                    bVar.mHh = ((com.tencent.mm.plugin.fps_lighter.c.b.a) stack.peek()).mHi;
                }
                bVar.beginTime = aVar5.hQu;
                bVar.mHi = aVar5.mHi;
                bVar.jNF = aVar2.hQu - aVar5.hQu;
                bVar.mHj = aVar5.mHj;
                if (bVar.beginTime >= aVar.mHa && bVar.beginTime <= aVar.mGZ) {
                    linkedList.add(bVar);
                    i6 = i3;
                    i5 = i;
                } else if (bVar.beginTime <= aVar.mHa) {
                    i2++;
                    i6 = i3;
                    i5 = i;
                } else {
                    i6 = i3;
                    i5 = i;
                }
            }
            i4 = i2;
            i = linkedList.size() + i4;
            i2 = i4;
            i3 = i6;
            i4 = i5;
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceItem] startIndex:%s endIndex:%s pre:%s cur:%s", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(aVar.mHa), Long.valueOf(aVar.mGZ));
        Collections.sort(linkedList, new Comparator<b>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((b) obj).mHj - ((b) obj2).mHj;
            }
        });
        x.i("MicroMsg.AsyncAnalyseTask", "[parseTrace]result size:%s rawItemList:%s costTime:%s", Integer.valueOf(linkedList.size()), Integer.valueOf(list.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        list.clear();
        return linkedList;
    }

    private List<c> aQ(List<b> list) {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.AsyncAnalyseTask", "[sortBySameMethod] list size:%s", Integer.valueOf(list.size()));
        List<c> linkedList = new LinkedList();
        HashMap aR = aR(list);
        HashMap hashMap = new HashMap(600);
        for (Entry value : aR.entrySet()) {
            a(hashMap, (List) value.getValue());
        }
        for (Entry value2 : hashMap.entrySet()) {
            linkedList.add(value2.getValue());
        }
        Collections.sort(linkedList, new Comparator<c>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                c cVar = (c) obj;
                c cVar2 = (c) obj2;
                return cVar.axZ - cVar2.axZ == 0 ? (int) (cVar2.mHo - cVar.mHo) : cVar.axZ - cVar2.axZ;
            }
        });
        hashMap.clear();
        list.clear();
        x.i("MicroMsg.AsyncAnalyseTask", "[sortBySameMethod] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return linkedList;
    }

    private static void a(HashMap<String, c> hashMap, List<b> list) {
        for (b bVar : list) {
            if (hashMap.containsKey(bVar.getKey())) {
                c cVar = (c) hashMap.get(bVar.getKey());
                cVar.hUW++;
                cVar.mHm.add(bVar.jNF);
                cVar.mHn.add(bVar.beginTime);
                cVar.mHo += bVar.jNF;
            } else {
                hashMap.put(bVar.getKey(), new c(bVar));
            }
        }
    }

    private static HashMap<Integer, List<b>> aR(List<b> list) {
        HashMap<Integer, List<b>> hashMap = new HashMap();
        for (b bVar : list) {
            if (!hashMap.containsKey(Integer.valueOf(bVar.axZ))) {
                hashMap.put(Integer.valueOf(bVar.axZ), new ArrayList());
            }
            ((List) hashMap.get(Integer.valueOf(bVar.axZ))).add(bVar);
        }
        return hashMap;
    }

    private LinkedList<d> a(com.tencent.mm.plugin.fps_lighter.c.a aVar, List<c> list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        LinkedList<d> linkedList = new LinkedList();
        for (c cVar : list) {
            d dVar = new d(aVar, cVar);
            hashMap2.put(cVar.getKey(), cVar);
            if (((float) cVar.mHo) >= ((float) aVar.aLw()) * 0.4f && cVar.axZ == 0) {
                dVar.du(cVar.mHh);
                hashMap.put(Long.valueOf(cVar.mHi), dVar);
            } else if (((float) cVar.mHo) < ((float) aVar.aLw()) * 0.4f && cVar.axZ == 0 && hashMap.size() == 0) {
                if (((double) cVar.mHo) >= 16.6d && hashMap3.size() <= 6) {
                    dVar.du(cVar.mHh);
                }
            } else if (hashMap.containsKey(Long.valueOf(cVar.mHh))) {
                dVar.a(((d) hashMap.get(Long.valueOf(cVar.mHh))).mHq);
                dVar.du(cVar.mHh);
                if (((float) cVar.mHo) >= ((float) aVar.aLw()) * 0.4f) {
                    hashMap.remove(Long.valueOf(cVar.mHh));
                    hashMap.put(Long.valueOf(cVar.mHi), dVar);
                } else {
                    if (!hashMap4.containsKey(cVar.aLx())) {
                        hashMap4.put(cVar.aLx(), new ArrayList());
                    }
                    List<d> list2 = (List) hashMap4.get(cVar.aLx());
                    list2.add(dVar);
                    if (6 >= list2.size() && list2.size() >= 2) {
                        Collections.sort(list2, new Comparator<d>() {
                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                return (int) (((d) obj2).mHo - ((d) obj).mHo);
                            }
                        });
                        long j = 0;
                        for (d dVar2 : list2) {
                            long j2 = dVar2.mHo + j;
                            if (!hashMap2.containsKey(cVar.aLx()) || ((float) j2) < ((float) ((c) hashMap2.get(cVar.aLx())).mHo) * 0.8f) {
                                j = j2;
                            } else {
                                if (((float) dVar2.mHo) >= 1.0f) {
                                    if (hashMap.containsKey(Long.valueOf(cVar.mHh))) {
                                        hashMap.remove(Long.valueOf(cVar.mHh));
                                    }
                                    hashMap3.put(dVar2.mHi + ">" + dVar2.axZ, dVar2);
                                }
                                hashMap4.remove(cVar.aLx());
                            }
                        }
                        hashMap4.remove(cVar.aLx());
                    }
                }
            }
            if (hashMap3.containsKey(cVar.aLx()) && ((float) ((d) hashMap3.get(cVar.aLx())).mHo) * 0.9f <= ((float) cVar.mHo)) {
                dVar.a(((d) hashMap3.get(cVar.aLx())).mHq);
                dVar.du(cVar.mHi);
                hashMap3.remove(cVar.getKey());
                hashMap3.put(cVar.getKey(), dVar);
            }
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] root size:%s", Integer.valueOf(hashMap.size()));
        for (Entry value : hashMap.entrySet()) {
            linkedList.add(value.getValue());
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] nextHashMap size:%s", Integer.valueOf(hashMap3.size()));
        for (Entry value2 : hashMap3.entrySet()) {
            linkedList.add(value2.getValue());
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[findEvilMethod] reportList size:%s", Integer.valueOf(linkedList.size()));
        hashMap.clear();
        hashMap3.clear();
        hashMap2.clear();
        return linkedList;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = this.mHs;
        int i = this.mHt;
        int i2 = this.msV;
        x.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceRawData] start:%s, end:%s", Integer.valueOf(i), Integer.valueOf(i2));
        long currentTimeMillis2 = System.currentTimeMillis();
        List linkedList = new LinkedList();
        if (i2 < i) {
            i = jArr.length - i;
            x.d("MicroMsg.AsyncAnalyseTask", "end < start start:%s", Integer.valueOf(i));
        }
        long j;
        com.tencent.mm.plugin.fps_lighter.c.b.a aVar;
        int i3;
        if (i < 0) {
            for (i += jArr.length; i < jArr.length; i++) {
                if (jArr[i] != 0) {
                    j = jArr[i];
                    aVar = new com.tencent.mm.plugin.fps_lighter.c.b.a();
                    aVar.mHk = ((j >> 63) & 1) == 1;
                    aVar.mHl = (j >> 46) & Constants.MAX_THREAD_ID;
                    aVar.mHi = (j >> 27) & Constants.MAX_METHOD_ID;
                    aVar.hQu = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(aVar);
                }
            }
            for (i3 = 0; i3 < i2; i3++) {
                if (jArr[i3] != 0) {
                    j = jArr[i3];
                    aVar = new com.tencent.mm.plugin.fps_lighter.c.b.a();
                    aVar.mHk = ((j >> 63) & 1) == 1;
                    aVar.mHl = (j >> 46) & Constants.MAX_THREAD_ID;
                    aVar.mHi = (j >> 27) & Constants.MAX_METHOD_ID;
                    aVar.hQu = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(aVar);
                }
            }
        } else {
            for (i3 = i; i3 < i2; i3++) {
                if (jArr[i3] != 0) {
                    j = jArr[i3];
                    aVar = new com.tencent.mm.plugin.fps_lighter.c.b.a();
                    aVar.mHk = ((j >> 63) & 1) == 1;
                    aVar.mHl = (j >> 46) & Constants.MAX_THREAD_ID;
                    aVar.mHi = (j >> 27) & Constants.MAX_METHOD_ID;
                    aVar.hQu = j & Constants.MAX_TIME_DIFF;
                    linkedList.add(aVar);
                }
            }
        }
        x.i("MicroMsg.AsyncAnalyseTask", "[parseGmTraceRawData] size:%s costTime:%s", Integer.valueOf(linkedList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        List a = a(linkedList, this.mHr);
        List aQ = aQ(a);
        LinkedList a2 = a(this.mHr, aQ);
        if (this.mHu != null) {
            this.mHu.L(a2);
        } else {
            x.e("MicroMsg.AsyncAnalyseTask", "mIFPSAnalyse is null!");
            a2.clear();
        }
        a.clear();
        aQ.clear();
        x.i("MicroMsg.AsyncAnalyseTask", "cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
