package com.tencent.mm.plugin.appbrand.s;

import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.b.b;
import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int jYI = 16384;
    public static final List<a> jYJ;
    public SelectionKey jYK;
    public ByteChannel jYL;
    public final BlockingQueue<ByteBuffer> jYM;
    public final BlockingQueue<ByteBuffer> jYN;
    private volatile boolean jYO = false;
    private int jYP = a.a.jYz;
    public final d jYQ;
    private List<a> jYR;
    public a jYS = null;
    public int jYT;
    private d.a jYU = null;
    private ByteBuffer jYV = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.s.e.a jYW = null;
    private String jYX = null;
    private Integer jYY = null;
    private Boolean jYZ = null;
    public String jZa = null;

    static {
        List arrayList = new ArrayList(4);
        jYJ = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.s.b.c());
        jYJ.add(new b());
        jYJ.add(new com.tencent.mm.plugin.appbrand.s.b.d());
    }

    public c(d dVar, a aVar) {
        if (dVar == null || (aVar == null && this.jYT == a.b.jYG)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.jYM = new LinkedBlockingQueue();
        this.jYN = new LinkedBlockingQueue();
        this.jYQ = dVar;
        this.jYT = a.b.jYF;
        if (aVar != null) {
            this.jYS = aVar.amA();
        }
    }

    public final void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.jYP != a.a.jYz) {
            if (this.jYP == a.a.jYB) {
                m(byteBuffer);
            }
        } else if (l(byteBuffer) && !amx() && !isClosed()) {
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.jYV.hasRemaining()) {
                m(this.jYV);
            }
        }
    }

    private boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.jYV.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.jYV.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.jYV.capacity() + byteBuffer.remaining());
                this.jYV.flip();
                allocate.put(this.jYV);
                this.jYV = allocate;
            }
            this.jYV.put(byteBuffer);
            this.jYV.flip();
            byteBuffer2 = this.jYV;
        }
        byteBuffer2.mark();
        try {
            f s;
            if (this.jYT != a.b.jYG) {
                if (this.jYT == a.b.jYF) {
                    this.jYS.me(this.jYT);
                    s = this.jYS.s(byteBuffer2);
                    if (s instanceof h) {
                        s = (h) s;
                        if (this.jYS.a(this.jYW, (h) s) == a.b.jZv) {
                            a(s);
                            return true;
                        }
                        d(1002, "draft refuses handshake" + s.amH(), false);
                    } else {
                        f(1002, "wrong http function", false);
                        return false;
                    }
                }
                return false;
            } else if (this.jYS == null) {
                for (a amA : this.jYR) {
                    a amA2 = amA.amA();
                    try {
                        amA2.me(this.jYT);
                        byteBuffer2.reset();
                        s = amA2.s(byteBuffer2);
                        if (s instanceof com.tencent.mm.plugin.appbrand.s.e.a) {
                            s = (com.tencent.mm.plugin.appbrand.s.e.a) s;
                            if (amA2.a((com.tencent.mm.plugin.appbrand.s.e.a) s) == a.b.jZv) {
                                this.jZa = s.amG();
                                try {
                                    ag(a.c(amA2.a((com.tencent.mm.plugin.appbrand.s.e.a) s, this.jYQ.amv())));
                                    this.jYS = amA2;
                                    a(s);
                                    return true;
                                } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
                                    f(e.jZE, e.getMessage(), false);
                                    return false;
                                } catch (Exception e2) {
                                    this.jYQ.d(e2);
                                    f(-1, e2.getMessage(), false);
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            f(1002, "wrong http function", false);
                            return false;
                        }
                    } catch (com.tencent.mm.plugin.appbrand.s.c.d e3) {
                        x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e3.toString());
                    }
                }
                if (this.jYS == null) {
                    d(1002, "no draft matches", false);
                }
                return false;
            } else {
                s = this.jYS.s(byteBuffer2);
                if (s instanceof com.tencent.mm.plugin.appbrand.s.e.a) {
                    s = (com.tencent.mm.plugin.appbrand.s.e.a) s;
                    if (this.jYS.a((com.tencent.mm.plugin.appbrand.s.e.a) s) == a.b.jZv) {
                        a(s);
                        return true;
                    }
                    d(1002, "the handshake did finaly not match", false);
                    return false;
                }
                f(1002, "wrong http function", false);
                return false;
            }
        } catch (com.tencent.mm.plugin.appbrand.s.c.b e4) {
            try {
                x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e4.toString());
                a(e4);
            } catch (com.tencent.mm.plugin.appbrand.s.c.a e5) {
                x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e5.toString());
                if (this.jYV.capacity() == 0) {
                    byteBuffer2.reset();
                    int i = e5.jZD;
                    if (i == 0) {
                        i = byteBuffer2.capacity() + 16;
                    }
                    this.jYV = ByteBuffer.allocate(i);
                    this.jYV.put(byteBuffer);
                } else {
                    this.jYV.position(this.jYV.limit());
                    this.jYV.limit(this.jYV.capacity());
                }
            }
        }
    }

    private void m(ByteBuffer byteBuffer) {
        try {
            for (d dVar : this.jYS.r(byteBuffer)) {
                if (DEBUG) {
                    x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + dVar);
                }
                d.a amF = dVar.amF();
                boolean amD = dVar.amD();
                if (amF == d.a.CLOSING) {
                    int amB;
                    String message;
                    String str = "";
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.s.d.a) {
                        com.tencent.mm.plugin.appbrand.s.d.a aVar = (com.tencent.mm.plugin.appbrand.s.d.a) dVar;
                        amB = aVar.amB();
                        message = aVar.getMessage();
                    } else {
                        message = str;
                        amB = 1005;
                    }
                    if (this.jYP == a.a.jYC) {
                        e(amB, message, true);
                    } else if (this.jYS.amz() == a.a.jZt) {
                        d(amB, message, true);
                    } else {
                        f(amB, message, false);
                    }
                } else if (amF == d.a.PING) {
                    this.jYQ.a(this, dVar);
                } else if (amF == d.a.PONG) {
                    continue;
                } else if (!amD || amF == d.a.CONTINUOUS) {
                    if (amF != d.a.CONTINUOUS) {
                        if (this.jYU != null) {
                            throw new com.tencent.mm.plugin.appbrand.s.c.b("Previous continuous frame sequence not completed.");
                        }
                        this.jYU = amF;
                    } else if (amD) {
                        if (this.jYU == null) {
                            throw new com.tencent.mm.plugin.appbrand.s.c.b("Continuous frame sequence was not started.");
                        }
                        this.jYU = null;
                    } else if (this.jYU == null) {
                        throw new com.tencent.mm.plugin.appbrand.s.c.b("Continuous frame sequence was not started.");
                    }
                    try {
                        this.jYQ.c(dVar);
                    } catch (Exception e) {
                        this.jYQ.d(e);
                    }
                } else if (this.jYU != null) {
                    throw new com.tencent.mm.plugin.appbrand.s.c.b("Continuous frame sequence not completed.");
                } else if (amF == d.a.TEXT) {
                    try {
                        this.jYQ.vn(com.tencent.mm.plugin.appbrand.s.f.b.v(dVar.amC()));
                    } catch (Exception e2) {
                        this.jYQ.d(e2);
                    }
                } else if (amF == d.a.BINARY) {
                    try {
                        this.jYQ.o(dVar.amC());
                    } catch (Exception e22) {
                        this.jYQ.d(e22);
                    }
                } else {
                    throw new com.tencent.mm.plugin.appbrand.s.c.b("non control or continious frame expected");
                }
            }
        } catch (com.tencent.mm.plugin.appbrand.s.c.b e3) {
            x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e3.toString());
            this.jYQ.d(e3);
            a(e3);
        }
    }

    public void d(int i, String str, boolean z) {
        if (this.jYP != a.a.jYC && this.jYP != a.a.jYD) {
            if (this.jYP == a.a.jYB) {
                if (i == 1006) {
                    this.jYP = a.a.jYC;
                    f(i, str, false);
                    return;
                }
                if (this.jYS.amz() != a.a.jZr) {
                    try {
                        b(new com.tencent.mm.plugin.appbrand.s.d.b(i, str));
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                        this.jYQ.d(e);
                        f(1006, "generated frame is invalid", false);
                    }
                }
                f(i, str, z);
            } else if (i == -3) {
                f(-3, str, true);
            } else {
                f(-1, str, false);
            }
            if (i == 1002) {
                f(i, str, z);
            }
            this.jYP = a.a.jYC;
            this.jYV = null;
        }
    }

    public synchronized void e(int i, String str, boolean z) {
        if (this.jYP != a.a.jYD) {
            if (this.jYK != null) {
                this.jYK.cancel();
            }
            if (this.jYL != null) {
                try {
                    this.jYL.close();
                } catch (Exception e) {
                    this.jYQ.d(e);
                }
            }
            try {
                this.jYQ.U(i, str);
            } catch (Exception e2) {
                this.jYQ.d(e2);
            }
            if (this.jYS != null) {
                this.jYS.reset();
            }
            this.jYW = null;
            this.jYP = a.a.jYD;
            this.jYM.clear();
        }
    }

    private void mc(int i) {
        e(i, "", true);
    }

    private synchronized void f(int i, String str, boolean z) {
        if (!this.jYO) {
            this.jYY = Integer.valueOf(i);
            this.jYX = str;
            this.jYZ = Boolean.valueOf(z);
            this.jYO = true;
            if (this.jYS != null) {
                this.jYS.reset();
            }
            this.jYW = null;
        }
    }

    public final void amw() {
        if (this.jYP == a.a.jYz) {
            mc(-1);
        } else if (this.jYO) {
            e(this.jYY.intValue(), this.jYX, this.jYZ.booleanValue());
        } else if (this.jYS.amz() == a.a.jZr) {
            mc(1000);
        } else if (this.jYS.amz() != a.a.jZs || this.jYT == a.b.jYG) {
            mc(1006);
        } else {
            mc(1000);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.s.c.b bVar) {
        d(bVar.jZE, bVar.getMessage(), false);
    }

    public final void d(Collection<d> collection) {
        if (isOpen()) {
            for (d b : collection) {
                b(b);
            }
            return;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.f();
    }

    public final void b(d dVar) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        n(this.jYS.d(dVar));
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.jYM.add(byteBuffer);
    }

    public final void ag(List<ByteBuffer> list) {
        for (ByteBuffer n : list) {
            n(n);
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.jYS.getClass().getSimpleName());
        }
        this.jYP = a.a.jYB;
        try {
            this.jYQ.b(fVar);
        } catch (Exception e) {
            this.jYQ.d(e);
        }
    }

    public final boolean isOpen() {
        return this.jYP == a.a.jYB;
    }

    public final boolean amx() {
        return this.jYP == a.a.jYC;
    }

    public final boolean isClosed() {
        return this.jYP == a.a.jYD;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return super.toString();
    }
}
