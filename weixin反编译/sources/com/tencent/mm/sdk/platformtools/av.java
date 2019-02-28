package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class av<K, V> {
    private final long aJe;
    public final al fia;
    public volatile boolean fid = false;
    public final aa<K, a<V>> nNK;
    protected Object tag;
    private final long threshold;
    public final LinkedHashMap<K, b<K, V>> xpP = new LinkedHashMap();
    private final c<K, V> xpQ;
    public final al xpR;
    private final long xpS;
    private boolean xpT = true;

    static class a<V> {
        final V xpV;

        a(V v) {
            this.xpV = v;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.xpV != null) {
                return this.xpV.equals(aVar.xpV);
            }
            if (aVar.xpV == null) {
                return true;
            }
            return false;
        }
    }

    public static class b<K, V> {
        public K vEp;
        public V values;
        public int xpW;
    }

    public interface c<K, V> {
        boolean Tf();

        void Tg();

        void a(av<K, V> avVar, b<K, V> bVar);
    }

    public av(c<K, V> cVar, Looper looper, int i, int i2, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("arg appender can not be null!");
        } else if (looper == null) {
            throw new IllegalArgumentException("arg looper can not be null!");
        } else if (i <= 0) {
            throw new IllegalArgumentException("arg size can not be <= 0!");
        } else {
            this.xpQ = cVar;
            this.nNK = new aa(i);
            this.threshold = i2 > 0 ? (long) i2 : 40;
            if (j <= 0) {
                j = 60000;
            }
            this.xpS = j;
            if (j2 <= 0) {
                j2 = 60000;
            }
            this.aJe = j2;
            this.fia = new al(looper, new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    long currentTimeMillis = System.currentTimeMillis();
                    av.this.lL(false);
                    x.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    return false;
                }
            }, false);
            this.xpR = new al(new ah("RWCache_timeoutChecker").oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    av.this.fid = true;
                    return false;
                }
            }, false);
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.nNK.get(k);
        if (aVar != null) {
            return aVar.xpV;
        }
        this.nNK.put(k, new a(null));
        return null;
    }

    public final boolean r(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.nNK.get(k);
        a aVar2 = new a(v);
        if (aVar2.equals(aVar)) {
            return false;
        }
        int i;
        this.nNK.put(k, aVar2);
        b bVar = new b();
        bVar.vEp = k;
        bVar.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        bVar.xpW = i;
        synchronized (this) {
            this.xpP.put(k, bVar);
            if (this.xpT && ((long) this.xpP.size()) > this.threshold) {
                this.fia.K(0, 0);
                this.xpT = false;
            } else if (this.fia.cgx()) {
                al alVar = this.fia;
                long j = this.xpS;
                alVar.K(j, j);
            }
        }
        return true;
    }

    public final void lL(boolean z) {
        x.i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.xpP.size());
        synchronized (this) {
            this.xpT = true;
            if (this.xpP.isEmpty()) {
            } else if (this.xpQ.Tf()) {
                Iterator it = this.xpP.entrySet().iterator();
                if (z) {
                    while (it.hasNext()) {
                        this.xpQ.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                } else {
                    this.fid = false;
                    al alVar = this.xpR;
                    long j = this.aJe;
                    alVar.K(j, j);
                    while (!this.fid && it.hasNext()) {
                        this.xpQ.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                    if (this.fid) {
                        x.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.xpP.size()), Boolean.valueOf(it.hasNext()));
                    }
                    this.xpR.TN();
                }
                this.xpQ.Tg();
            }
        }
    }
}
