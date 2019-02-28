package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class b {
    private static b nEf;
    public f<String, WeakReference<d>> nEg = new f(10);
    f<String, WeakReference<a>> nEh = new f(10, new com.tencent.mm.a.f.b<String, WeakReference<a>>() {
        public final /* synthetic */ void m(Object obj, Object obj2) {
            WeakReference weakReference = (WeakReference) obj2;
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null && (aVar instanceof c)) {
                    x.i("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "recycle bitmap:%s", aVar.toString());
                    aVar.recycle();
                }
            }
        }
    });

    public static synchronized b aSR() {
        b bVar;
        synchronized (b.class) {
            if (nEf == null) {
                synchronized (b.class) {
                    if (nEf == null) {
                        nEf = new b();
                    }
                }
            }
            bVar = nEf;
        }
        return bVar;
    }

    public final a CU(String str) {
        if (this.nEh.get(str) != null) {
            return (a) ((WeakReference) this.nEh.get(str)).get();
        }
        return null;
    }

    public final a cW(String str, String str2) {
        a aVar = null;
        if (this.nEh.get(str) != null) {
            aVar = (a) ((WeakReference) this.nEh.get(str)).get();
        }
        if (aVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (p.Vx(str2)) {
                aVar = new f(str2);
            } else {
                aVar = new c(str2);
            }
            x.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.nEh.put(str, new WeakReference(aVar));
        }
        return aVar;
    }

    public final a o(String str, byte[] bArr) {
        a aVar = null;
        if (bArr != null) {
            if (this.nEh.get(str) != null) {
                aVar = (a) ((WeakReference) this.nEh.get(str)).get();
            }
            if (aVar == null) {
                if (p.bs(bArr) && ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aBM()) {
                    aVar = new f(bArr);
                } else {
                    aVar = new c(bArr);
                }
                this.nEh.put(str, new WeakReference(aVar));
            }
            if (!aVar.isRunning()) {
                aVar.reset();
            }
        }
        return aVar;
    }
}
