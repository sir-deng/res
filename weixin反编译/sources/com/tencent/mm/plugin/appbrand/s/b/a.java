package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.e.c;
import com.tencent.mm.plugin.appbrand.s.e.e;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.e.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static int jZn = 1000;
    public static int jZo = 64;
    public static final byte[] jZp = com.tencent.mm.plugin.appbrand.s.f.b.vu("<policy-file-request/>\u0000");
    protected int jYT = 0;
    protected com.tencent.mm.plugin.appbrand.s.d.d.a jZq = null;

    public enum b {
        ;

        static {
            jZv = 1;
            jZw = 2;
            jZx = new int[]{jZv, jZw};
        }
    }

    public enum a {
        ;

        static {
            jZr = 1;
            jZs = 2;
            jZt = 3;
            jZu = new int[]{jZr, jZs, jZt};
        }
    }

    public abstract List<d> Z(String str, boolean z);

    public abstract int a(com.tencent.mm.plugin.appbrand.s.e.a aVar);

    public abstract int a(com.tencent.mm.plugin.appbrand.s.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.s.e.b a(com.tencent.mm.plugin.appbrand.s.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.s.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract a amA();

    public abstract int amz();

    public abstract ByteBuffer d(d dVar);

    public abstract List<d> r(ByteBuffer byteBuffer);

    public abstract void reset();

    private static String q(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        return byteBuffer2 == null ? null : com.tencent.mm.plugin.appbrand.s.f.b.D(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static com.tencent.mm.plugin.appbrand.s.a.b<List> c(f fVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.s.e.a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.s.e.a) fVar).amG());
            stringBuilder.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            stringBuilder.append("HTTP/1.1 101 " + ((h) fVar).amH());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.s.e.a) fVar).amG());
            stringBuilder.append(" HTTP/1.1");
            x.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator amI = fVar.amI();
        while (amI.hasNext()) {
            String str = (String) amI.next();
            String vs = fVar.vs(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(vs);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] vv = com.tencent.mm.plugin.appbrand.s.f.b.vv(stringBuilder.toString());
        byte[] amJ = fVar.amJ();
        ByteBuffer allocate = ByteBuffer.allocate((amJ == null ? 0 : amJ.length) + vv.length);
        allocate.put(vv);
        if (amJ != null) {
            allocate.put(amJ);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public final f s(ByteBuffer byteBuffer) {
        int i = this.jYT;
        String q = q(byteBuffer);
        if (q == null) {
            throw new com.tencent.mm.plugin.appbrand.s.c.a(byteBuffer.capacity() + FileUtils.S_IWUSR);
        }
        String[] split = q.split(" ", 3);
        if (split.length != 3) {
            throw new com.tencent.mm.plugin.appbrand.s.c.d();
        }
        f eVar;
        String q2;
        if (i == com.tencent.mm.plugin.appbrand.s.a.b.jYF) {
            eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.vr(split[2]);
        } else {
            eVar = new com.tencent.mm.plugin.appbrand.s.e.d();
            eVar.vq(split[1]);
        }
        while (true) {
            q2 = q(byteBuffer);
            if (q2 != null && q2.length() > 0) {
                String[] split2 = q2.split(":", 2);
                if (split2.length != 2) {
                    throw new com.tencent.mm.plugin.appbrand.s.c.d("not an http header");
                }
                eVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (q2 == null) {
                return eVar;
            } else {
                throw new com.tencent.mm.plugin.appbrand.s.c.a();
            }
        }
        if (q2 == null) {
            return eVar;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.a();
    }

    public static int md(int i) {
        if (i >= 0) {
            return i;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.b("Negative count");
    }

    public final void me(int i) {
        this.jYT = i;
    }
}
