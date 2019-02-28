package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.bqc;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public final class c implements a {
    public ArrayList<a> gNg;
    public int kOD;
    public final d[] smi;
    public Queue<c> smj;
    public HashMap<String, Integer> smk;

    public static class c {
        private static int smo = 0;
        public String bhd;
        public String fIQ;
        public String fKl;
        public String fKr;
        public String id;
        public int ret;
        public int smm;
        public String smn;
        public int type;

        public c(String str, String str2, int i, String str3) {
            this.fKl = str;
            this.id = str2;
            this.type = i;
            this.bhd = str3;
            if (smo == Integer.MAX_VALUE) {
                smo = 0;
            }
            int i2 = smo + 1;
            smo = i2;
            this.smm = i2;
            if (i == 1) {
                i2 = bb.hR(str);
                if (i2 != -1) {
                    String trim = str.substring(0, i2).trim();
                    if (trim != null && trim.length() > 0) {
                        this.smn = trim;
                        this.fKl = str.substring(i2 + 1).trim();
                    }
                }
            }
        }
    }

    public interface a {
        void a(int i, SparseArray<c> sparseArray);
    }

    private static final class b {
        public static final c sml = new c();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.kOD = 0;
        this.gNg = new ArrayList(1);
        this.smj = new LinkedList();
        this.smk = new HashMap();
        this.smi = new d[1];
    }

    private void b(int i, SparseArray<c> sparseArray) {
        Iterator it = this.gNg.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, sparseArray);
        }
    }

    public final void bGk() {
        x.d("MicroMsg.TranslateServiceManager", "current waitings : %s", Integer.valueOf(this.smj.size()));
        if (this.smj.size() != 0 && this.kOD <= this.smi.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.smi.length) {
                    if (this.smi[i2] == null) {
                        this.smi[i2] = new d(i2, this);
                        as.CN().a(631, this.smi[i2]);
                    }
                    if (!this.smi[i2].smq) {
                        Object obj;
                        d dVar = this.smi[i2];
                        Queue queue = this.smj;
                        if (dVar.smq) {
                            obj = null;
                        } else {
                            dVar.smp = new SparseArray();
                            if (queue.size() == 0) {
                                obj = null;
                            } else {
                                dVar.smq = true;
                                LinkedList linkedList = new LinkedList();
                                i = 0;
                                while (true) {
                                    int i3 = i;
                                    if (i3 >= WXMediaMessage.TITLE_LENGTH_LIMIT || queue.size() <= 0) {
                                        dVar.smr = new b(linkedList);
                                        as.CN().a(dVar.smr, 0);
                                        dVar.start = System.currentTimeMillis();
                                        dVar.smt.K(60000, 60000);
                                        obj = 1;
                                    } else {
                                        c cVar = (c) queue.peek();
                                        int length = cVar.fKl.getBytes().length;
                                        if (i3 == 0 || i3 + length <= WXMediaMessage.TITLE_LENGTH_LIMIT) {
                                            queue.poll();
                                            bqc bqc = new bqc();
                                            bqc.wYU = cVar.smm;
                                            bqc.wYV = cVar.fKl;
                                            if (cVar.type == 1 || s.eX(cVar.bhd)) {
                                                bqc.wYW = cVar.bhd;
                                            }
                                            switch (cVar.type) {
                                                case 0:
                                                    bqc.sfa = 1;
                                                    break;
                                                case 1:
                                                    bqc.sfa = 4;
                                                    break;
                                                case 2:
                                                    bqc.sfa = 2;
                                                    break;
                                                case 3:
                                                    bqc.sfa = 3;
                                                    break;
                                            }
                                            x.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", Integer.valueOf(cVar.type), Integer.valueOf(bqc.sfa), cVar.id);
                                            linkedList.add(bqc);
                                            dVar.smp.put(cVar.smm, cVar);
                                        }
                                        i = i3 + length;
                                    }
                                }
                                dVar.smr = new b(linkedList);
                                as.CN().a(dVar.smr, 0);
                                dVar.start = System.currentTimeMillis();
                                dVar.smt.K(60000, 60000);
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            this.kOD++;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean Nc(String str) {
        return this.smk.containsKey(str);
    }

    public final void a(int i, SparseArray<c> sparseArray, LinkedList<bqd> linkedList) {
        int i2;
        HashMap hashMap;
        this.kOD--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            x.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((c) sparseArray.valueAt(i2)).id, Integer.valueOf(((c) sparseArray.valueAt(i2)).smm));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        c cVar;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bqd bqd = (bqd) it.next();
                cVar = (c) sparseArray.get(bqd.wYU);
                String str = bqd.wYX;
                if (cVar.type == 1) {
                    str = bb.T(str, cVar.smn);
                    cVar.fKl = bb.T(cVar.fKl, cVar.smn);
                }
                cVar.fKr = str;
                cVar.ret = bqd.vQL;
                cVar.fIQ = bqd.wYY;
                this.smk.remove(cVar.id);
                if (hashMap != null) {
                    hashMap.remove(cVar.id);
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                cVar = (c) sparseArray.valueAt(i2);
                if (cVar.type == 1) {
                    cVar.fKl = bb.T(cVar.fKl, cVar.smn);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.smk.remove(key.getKey());
                x.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", key.getKey(), key.getValue());
            }
        }
        b(i, sparseArray);
        bGk();
    }
}
