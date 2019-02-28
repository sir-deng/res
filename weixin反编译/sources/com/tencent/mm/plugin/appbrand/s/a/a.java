package com.tencent.mm.plugin.appbrand.s.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.s.e.d;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLException;

public abstract class a extends b implements com.tencent.mm.plugin.appbrand.s.a, Runnable {
    public Timer bnp = null;
    private com.tencent.mm.plugin.appbrand.s.b.a jYS;
    protected URI jZb = null;
    public c jZc = null;
    private Socket jZd = null;
    private InputStream jZe;
    OutputStream jZf;
    private Proxy jZg = Proxy.NO_PROXY;
    public Runnable jZh;
    private Map<String, String> jZi;
    private CountDownLatch jZj = new CountDownLatch(1);
    private CountDownLatch jZk = new CountDownLatch(1);
    private int jZl = 0;
    public String jeC;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void run() {
            while (!Thread.interrupted()) {
                ByteBuffer byteBuffer;
                try {
                    byteBuffer = (ByteBuffer) a.this.jZc.jYM.take();
                    a.this.jZf.write(byteBuffer.array(), 0, byteBuffer.limit());
                    a.this.jZf.flush();
                } catch (InterruptedException e) {
                    try {
                        for (ByteBuffer byteBuffer2 : a.this.jZc.jYM) {
                            a.this.jZf.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                            a.this.jZf.flush();
                        }
                    } catch (Exception e2) {
                        a aVar = a.this;
                        if (e2 instanceof SSLException) {
                            aVar.b(e2);
                        }
                        aVar.jZc.amw();
                        return;
                    } finally {
                        a.d(a.this);
                    }
                }
            }
            a.d(a.this);
        }
    }

    public abstract void F(int i, String str);

    public abstract void b(h hVar);

    public abstract void b(Exception exception);

    public abstract void rE(String str);

    static /* synthetic */ void d(a aVar) {
        try {
            if (aVar.jZd != null) {
                aVar.jZd.close();
            }
        } catch (Exception e) {
            aVar.b(e);
        }
    }

    public a(URI uri, com.tencent.mm.plugin.appbrand.s.b.a aVar, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.jZb = uri;
            this.jYS = aVar;
            this.jZi = map;
            this.jZl = i;
            this.jZc = new c(this, aVar);
        }
    }

    public final void connect() {
        if (this.jZh != null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.jZh = this;
        e.post(this.jZh, "WebsocketWriteThread");
    }

    public final void close() {
        if (this.jZh != null) {
            this.jZc.d(1000, "", false);
        }
    }

    public final void vo(String str) {
        c cVar = this.jZc;
        if (str == null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            cVar.d(cVar.jYS.Z(str, cVar.jYT == com.tencent.mm.plugin.appbrand.s.a.b.jYF));
        }
    }

    public void run() {
        try {
            if (this.jZd == null) {
                this.jZd = new Socket(this.jZg);
            } else if (this.jZd.isClosed()) {
                throw new IOException();
            }
            if (!this.jZd.isBound()) {
                this.jZd.connect(new InetSocketAddress(this.jZb.getHost(), getPort()), this.jZl);
            }
            this.jZe = this.jZd.getInputStream();
            this.jZf = this.jZd.getOutputStream();
            amy();
            this.jZh = new a();
            e.post(this.jZh, "WebsocketWriteThread");
            byte[] bArr = new byte[c.jYI];
            while (!this.jZc.amx() && !this.jZc.isClosed()) {
                try {
                    int read = this.jZe.read(bArr);
                    if (read != -1) {
                        this.jZc.k(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException e) {
                    this.jZc.amw();
                    return;
                } catch (Exception e2) {
                    b(e2);
                    this.jZc.e(1006, e2.getMessage(), false);
                    return;
                }
            }
            this.jZc.amw();
        } catch (Exception e22) {
            this.jZc.e(-1, e22.getMessage(), false);
        }
    }

    private int getPort() {
        int port = this.jZb.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.jZb.getScheme();
        if (scheme.equals("wss")) {
            return JsApiPauseDownloadTask.CTRL_INDEX;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void amy() {
        String path = this.jZb.getPath();
        String query = this.jZb.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        query = this.jZb.getHost() + (port != 80 ? ":" + port : "");
        com.tencent.mm.plugin.appbrand.s.e.b dVar = new d();
        dVar.vq(path);
        dVar.put("Host", query);
        if (this.jZi != null) {
            for (Entry entry : this.jZi.entrySet()) {
                dVar.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        c cVar = this.jZc;
        cVar.jYW = cVar.jYS.a(dVar);
        cVar.jZa = dVar.amG();
        if (cVar.jZa != null) {
            com.tencent.mm.plugin.appbrand.s.b.a aVar = cVar.jYS;
            f fVar = cVar.jYW;
            int i = cVar.jYT;
            cVar.ag(com.tencent.mm.plugin.appbrand.s.b.a.c(fVar));
        }
    }

    public final void vn(String str) {
        rE(str);
    }

    public final void o(ByteBuffer byteBuffer) {
        f(byteBuffer);
    }

    public final void c(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
        a(dVar);
    }

    public final void b(f fVar) {
        this.jZj.countDown();
        b((h) fVar);
    }

    public final void U(int i, String str) {
        this.jZj.countDown();
        this.jZk.countDown();
        if (this.jZh != null) {
            e.Q(this.jZh);
        }
        try {
            if (this.jZd != null) {
                this.jZd.close();
            }
        } catch (Exception e) {
            b(e);
        }
        F(i, str);
    }

    public final void d(Exception exception) {
        b(exception);
    }

    public void f(ByteBuffer byteBuffer) {
    }

    public void a(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
    }

    public final void a(Socket socket) {
        if (this.jZd != null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.jZd = socket;
        }
    }

    public final void V(int i, String str) {
        this.jZc.d(i, str, false);
    }

    public final void p(ByteBuffer byteBuffer) {
        c cVar = this.jZc;
        if (byteBuffer == null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            cVar.d(cVar.jYS.a(byteBuffer, cVar.jYT == com.tencent.mm.plugin.appbrand.s.a.b.jYF));
        }
    }

    public final void b(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
        this.jZc.b(dVar);
    }
}
