package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ak<K, O> {
    private int maxSize;
    Map<K, b<O>> rdc = null;
    private a rdd = null;

    public interface a {
        boolean bJ(Object obj);
    }

    public class b<OO> {
        public OO obj;
        public Long rdf;

        public b(OO oo) {
            this.obj = oo;
            bwD();
        }

        public final void bwD() {
            this.rdf = Long.valueOf(System.currentTimeMillis());
        }
    }

    public ak(int i, a aVar) {
        this.maxSize = i;
        this.rdc = new HashMap();
        this.rdd = aVar;
    }

    public final void bwC() {
        if (this.rdc.size() > this.maxSize) {
            Object arrayList = new ArrayList(this.rdc.entrySet());
            Collections.sort(arrayList, new Comparator<Entry<K, b<O>>>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((b) ((Entry) obj).getValue()).rdf.compareTo(((b) ((Entry) obj2).getValue()).rdf);
                }
            });
            int size = this.rdc.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    int i = size;
                    if (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        if (this.rdd.bJ(entry.getKey())) {
                            x.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                            size = i - 1;
                        } else {
                            size = i;
                        }
                        if (size <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
