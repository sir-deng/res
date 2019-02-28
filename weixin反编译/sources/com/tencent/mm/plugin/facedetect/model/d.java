package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {
    public static final Object mLock = new Object();
    private static volatile d mlI = null;
    public List<a> mlJ = null;

    private class a {
        public byte[] data;
        public b mlK;

        a(b bVar) {
            this.mlK = bVar;
        }
    }

    public interface b {
        com.tencent.mm.memory.a<byte[]> aGZ();

        void aw(byte[] bArr);
    }

    public static final d aGY() {
        if (mlI != null) {
            return mlI;
        }
        d dVar;
        synchronized (mLock) {
            if (mlI == null) {
                mlI = new d();
            }
            dVar = mlI;
        }
        return dVar;
    }

    public final synchronized void a(b bVar) {
        if (bVar == null) {
            x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
        } else {
            synchronized (mLock) {
                if (this.mlJ == null) {
                    this.mlJ = Collections.synchronizedList(new ArrayList(5));
                }
                this.mlJ.add(new a(bVar));
            }
        }
    }

    public final void b(b bVar) {
        synchronized (mLock) {
            if (this.mlJ != null) {
                this.mlJ.remove(bVar);
            }
        }
    }
}
