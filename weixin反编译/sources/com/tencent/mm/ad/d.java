package com.tencent.mm.ad;

import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.concurrent.ConcurrentHashMap;

public interface d {

    public static class a {
        public bx hoa;
        public boolean hob = false;
        public boolean hoc = false;
        public boolean hod = false;

        public a(bx bxVar, boolean z, boolean z2, boolean z3) {
            this.hoa = bxVar;
            this.hob = z;
            this.hoc = z2;
            this.hod = z3;
        }

        public final String toString() {
            return String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.hob), Boolean.valueOf(this.hoc), Boolean.valueOf(this.hod)});
        }
    }

    public static class b {
        public au fou;
        public boolean hoe;

        public b(au auVar, boolean z) {
            this.fou = auVar;
            this.hoe = z;
        }
    }

    public static class c {
        private static ConcurrentHashMap<Object, d> hof = new ConcurrentHashMap();

        public static void a(Object obj, d dVar) {
            x.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", obj, dVar);
            hof.put(obj, dVar);
        }

        public static void b(Object obj, d dVar) {
            x.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", obj, dVar);
            hof.remove(obj);
        }

        public static d aU(Object obj) {
            return (d) hof.get(obj);
        }
    }

    b b(a aVar);

    void h(au auVar);
}
