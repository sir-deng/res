package com.tencent.mm.r;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public final class b {
    SparseArray<a> gNo = new SparseArray();
    HashMap<com.tencent.mm.storage.w.a, a> gNp = new HashMap();
    SparseArray<b> gNq = new SparseArray();
    HashMap<com.tencent.mm.storage.w.a, b> gNr = new HashMap();
    private Random gNs = new Random();
    t gNt = null;

    public class a {
        String fsK;
        int gNk;
        com.tencent.mm.storage.w.a gNl;
        int type;
        public String value;
    }

    public class b {
        com.tencent.mm.storage.w.a gNn;
        int gNv;
        SparseArray<String> gNw = new SparseArray();
        HashMap<String, String> gNx = new HashMap();
    }

    private static String fg(String str) {
        return str.replaceAll("\\|", "%7C");
    }

    private static String unescape(String str) {
        return str.replaceAll("%7C", "|");
    }

    final void a(a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(fg(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(fg(aVar.fsK));
        if (aVar.gNl != null) {
            this.gNt.a(aVar.gNl, stringBuffer.toString());
        } else {
            this.gNt.set(aVar.gNk, stringBuffer.toString());
        }
    }

    final void a(b bVar) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int i2;
        String str;
        if (bVar.gNn != null) {
            Iterator it = bVar.gNx.entrySet().iterator();
            while (true) {
                i2 = i;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str2 = (String) entry.getKey();
                    str = (String) entry.getValue();
                    if (i2 != 0) {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(str2);
                    stringBuffer.append("|");
                    stringBuffer.append(fg(str));
                    i = i2 + 1;
                } else {
                    this.gNt.a(bVar.gNn, stringBuffer.toString());
                    return;
                }
            }
        }
        while (true) {
            int i3 = i;
            if (i3 < bVar.gNw.size()) {
                i2 = bVar.gNw.keyAt(i3);
                str = (String) bVar.gNw.get(i2);
                if (i3 != 0) {
                    stringBuffer.append("|");
                }
                stringBuffer.append(i2);
                stringBuffer.append("|");
                stringBuffer.append(fg(str));
                i = i3 + 1;
            } else {
                this.gNt.set(bVar.gNv, stringBuffer.toString());
                return;
            }
        }
    }

    private a gh(int i) {
        String str = (String) this.gNt.get(i, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(i, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bi.i(e));
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private a c(com.tencent.mm.storage.w.a aVar) {
        String str = (String) this.gNt.get(aVar, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bi.i(e));
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private b gi(int i) {
        String str = (String) this.gNt.get(i, null);
        if (str == null) {
            return gj(i);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b gj = gj(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                gj.gNw.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
            }
            return gj;
        } catch (Throwable e) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bi.i(e));
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    private b d(com.tencent.mm.storage.w.a aVar) {
        String str = (String) this.gNt.get(aVar, null);
        if (str == null) {
            return e(aVar);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b e = e(aVar);
            for (int i = 0; i < split.length; i += 2) {
                e.gNx.put(split[i], unescape(split[i + 1]));
            }
            return e;
        } catch (Throwable e2) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bi.i(e2));
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    final String Bw() {
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.gNs.nextInt(Math.abs(this.gNs.nextInt(Integer.MAX_VALUE))) % 10000;
        return String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
    }

    final b gj(int i) {
        b bVar = new b();
        bVar.gNv = i;
        return bVar;
    }

    final b e(com.tencent.mm.storage.w.a aVar) {
        b bVar = new b();
        bVar.gNn = aVar;
        return bVar;
    }

    final a a(int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.gNk = i;
        aVar.type = i2;
        aVar.value = str;
        aVar.fsK = str2;
        return aVar;
    }

    final a a(com.tencent.mm.storage.w.a aVar, int i, String str, String str2) {
        a aVar2 = new a();
        aVar2.gNl = aVar;
        aVar2.type = i;
        aVar2.value = str;
        aVar2.fsK = str2;
        return aVar2;
    }

    public final a gk(int i) {
        a aVar = (a) this.gNo.get(i);
        if (aVar == null) {
            aVar = gh(i);
            if (aVar != null) {
                this.gNo.put(i, aVar);
            }
        }
        return aVar;
    }

    public final a f(com.tencent.mm.storage.w.a aVar) {
        a aVar2 = (a) this.gNp.get(aVar);
        if (aVar2 == null) {
            aVar2 = c(aVar);
            if (aVar2 != null) {
                this.gNp.put(aVar, aVar2);
            }
        }
        return aVar2;
    }

    final b gl(int i) {
        b bVar = (b) this.gNq.get(i);
        if (bVar != null) {
            return bVar;
        }
        bVar = gi(i);
        if (bVar == null) {
            x.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.gNq.put(i, bVar);
        return bVar;
    }

    final b g(com.tencent.mm.storage.w.a aVar) {
        b bVar = (b) this.gNr.get(aVar);
        if (bVar != null) {
            return bVar;
        }
        bVar = d(aVar);
        if (bVar == null) {
            x.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.gNr.put(aVar, bVar);
        return bVar;
    }

    public final a x(int i, int i2, int i3) {
        x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a gk = gk(i);
        if (gk == null) {
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((gk.type & i3) == 0) {
            x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b gl = gl(i2);
            if (gl != null) {
                String str = (String) gl.gNw.get(i);
                if (str != null && str.equals(gk.fsK)) {
                    return null;
                }
                if (str == null) {
                    gl.gNw.put(i, Bw());
                    a(gl);
                }
                return gk;
            }
            x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }

    public final a a(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2, int i) {
        x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", aVar, aVar2, Integer.valueOf(i));
        a f = f(aVar);
        if (f == null) {
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((f.type & i) == 0) {
            x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b g = g(aVar2);
            if (g != null) {
                String str = (String) g.gNx.get(aVar.name());
                if (str != null && str.equals(f.fsK)) {
                    return null;
                }
                if (str == null) {
                    g.gNx.put(aVar.name(), Bw());
                    a(g);
                }
                return f;
            }
            x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }
}
