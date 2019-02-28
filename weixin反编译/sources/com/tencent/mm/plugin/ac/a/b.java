package com.tencent.mm.plugin.ac.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b implements com.tencent.mm.plugin.ac.a.a.a {
    public List<String> hEv = new LinkedList();
    public ag jQE = new ag(Looper.getMainLooper());
    public Map<String, List<a>> pAD = new HashMap();
    public Map<String, Set<Integer>> pAE = new HashMap();
    String pAF;
    a pAG;

    public interface a {
        void IC(String str);

        void k(String str, String str2, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.ac.a.b$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String pAH;
        final /* synthetic */ a pAI;

        public AnonymousClass2(String str, a aVar) {
            this.pAH = str;
            this.pAI = aVar;
        }

        public final void run() {
            b bVar = b.this;
            String str = this.pAH;
            a aVar = this.pAI;
            List<a> list = (List) bVar.pAD.get(str);
            if (list != null) {
                for (a aVar2 : list) {
                    if (aVar2 != null && aVar2 == aVar) {
                        list.remove(aVar2);
                        break;
                    }
                }
            } else {
                x.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
            }
            if (list != null && list.isEmpty()) {
                bVar.pAD.remove(str);
                bVar.hEv.remove(str);
                bVar.pAE.remove(str);
                if (bVar.pAF != null && bVar.pAF.equals(str)) {
                    a aVar3 = bVar.pAG;
                    x.i("MicroMsg.scanner.DecodeFile", "cancelled");
                    aVar3.iu = true;
                    bVar.pAG = null;
                }
                bVar.blW();
            }
        }
    }

    public final void a(final String str, final a aVar, final Set<Integer> set) {
        x.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", str, Integer.valueOf(aVar.hashCode()));
        if (bi.oN(str)) {
            x.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
        } else {
            this.jQE.post(new Runnable() {
                public final void run() {
                    b bVar = b.this;
                    String str = str;
                    a aVar = aVar;
                    bVar.pAE.put(str, set);
                    if (bVar.pAD.containsKey(str)) {
                        List<a> list = (List) bVar.pAD.get(str);
                        if (list != null) {
                            if (list != null) {
                                Object obj;
                                if (list != null && list.size() != 0) {
                                    for (a aVar2 : list) {
                                        if (aVar2 != null && aVar2 == aVar) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    x.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                                }
                                obj = null;
                                if (obj == null) {
                                    list.add(aVar);
                                }
                            }
                            x.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                        }
                        bVar.blW();
                        return;
                    }
                    List linkedList = new LinkedList();
                    linkedList.add(aVar);
                    bVar.pAD.put(str, linkedList);
                    bVar.hEv.add(str);
                    bVar.blW();
                }
            });
        }
    }

    final void blW() {
        if (this.pAG != null) {
            x.d("MicroMsg.FileScanQueueService", "it is scanning");
        } else if (this.pAD.isEmpty()) {
            x.d("MicroMsg.FileScanQueueService", "queue is empty");
        } else {
            this.pAF = (String) this.hEv.get(0);
            this.hEv.remove(0);
            this.pAG = new a();
            this.pAG.fFw = (Set) this.pAE.get(this.pAF);
            a aVar = this.pAG;
            String str = this.pAF;
            x.i("MicroMsg.scanner.DecodeFile", "start decode file: " + str);
            aVar.pAA = this;
            ah.y(new com.tencent.mm.plugin.ac.a.a.AnonymousClass1(str));
        }
    }

    public final int a(final d dVar) {
        this.jQE.post(new Runnable() {
            public final void run() {
                b bVar = b.this;
                d dVar = dVar;
                x.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", bVar.pAF, dVar);
                List<a> list = (List) bVar.pAD.get(bVar.pAF);
                if (list != null && dVar != null) {
                    x.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", Integer.valueOf(list.size()));
                    for (a k : list) {
                        k.k(bVar.pAF, dVar.result, dVar.fqW, dVar.fqX);
                    }
                } else if (list != null) {
                    for (a k2 : list) {
                        k2.IC(bVar.pAF);
                    }
                }
                bVar.pAD.remove(bVar.pAF);
                bVar.pAE.remove(bVar.pAF);
                bVar.pAF = null;
                bVar.pAG = null;
                bVar.blW();
            }
        });
        return 0;
    }
}
