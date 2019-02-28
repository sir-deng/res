package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.j.j;
import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.plugin.appbrand.s.b.d;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.f.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class n {
    a iUl;
    private SSLSocketFactory iUm;

    public n(String str) {
        SSLContext uc = i.uc(str);
        if (uc != null) {
            this.iUm = uc.getSocketFactory();
        }
    }

    public final void a(String str, j.a aVar) {
        x.i("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", str);
        try {
            URI uri = new URI(str);
            Map hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                final j.a aVar2 = aVar;
                this.iUl = new a(uri, new d(), hashMap) {
                    private com.tencent.mm.plugin.appbrand.s.d.d iUn = null;

                    public final void b(h hVar) {
                        x.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
                        aVar2.a(hVar);
                    }

                    public final void rE(String str) {
                        n.this.iUl.vo(str);
                        x.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", str);
                        aVar2.rB(str);
                    }

                    public final void F(int i, String str) {
                        x.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", str, Integer.valueOf(i));
                        if (i == -1 || i == -2 || i == -3) {
                            if (ao.isConnected(ad.getContext())) {
                                aVar2.rA(str);
                            } else {
                                aVar2.rA("network is down");
                                i = 1006;
                            }
                            aVar2.C(i, str);
                            return;
                        }
                        aVar2.C(i, str);
                    }

                    public final void b(Exception exception) {
                        x.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exception.toString());
                    }

                    public final void f(ByteBuffer byteBuffer) {
                        aVar2.e(byteBuffer);
                    }

                    public final void a(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
                        if (dVar.amF() != com.tencent.mm.plugin.appbrand.s.d.d.a.CONTINUOUS && !dVar.amD()) {
                            this.iUn = dVar;
                        } else if (dVar.amF() == com.tencent.mm.plugin.appbrand.s.d.d.a.CONTINUOUS && this.iUn != null) {
                            if (this.iUn.amC().position() > 10485760) {
                                x.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                                this.iUn = null;
                                return;
                            }
                            try {
                                this.iUn.e(dVar);
                            } catch (Exception e) {
                                x.e("MicroMsg.RemoteDebugSocket", e.getMessage());
                            }
                            if (dVar.amD()) {
                                if (this.iUn.amF() == com.tencent.mm.plugin.appbrand.s.d.d.a.BINARY) {
                                    f(this.iUn.amC());
                                } else if (this.iUn.amF() == com.tencent.mm.plugin.appbrand.s.d.d.a.TEXT) {
                                    try {
                                        rE(bi.oM(b.v(this.iUn.amC())));
                                    } catch (Exception e2) {
                                        x.e("MicroMsg.RemoteDebugSocket", e2.getMessage());
                                    }
                                }
                                this.iUn = null;
                            }
                        }
                    }
                };
                if (s.eL(str, "ws://")) {
                    this.iUl.a(new Socket(Proxy.NO_PROXY));
                    this.iUl.connect();
                    return;
                }
                SSLSocketFactory sSLSocketFactory;
                if (this.iUm != null) {
                    sSLSocketFactory = this.iUm;
                } else {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.iUl.a(sSLSocketFactory.createSocket());
                this.iUl.connect();
            } catch (Throwable e) {
                x.e("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", Log.getStackTraceString(e));
            }
        } catch (Exception e2) {
            x.e("MicroMsg.RemoteDebugSocket", "connect fail : %s ", e2.toString());
            aVar.rC("url not well format");
        }
    }

    public final boolean isOpen() {
        if (this.iUl == null) {
            return false;
        }
        return this.iUl.jZc.isOpen();
    }

    public final boolean a(bxb bxb) {
        x.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!isOpen()) {
            x.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            return false;
        } else if (bxb == null) {
            x.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            return false;
        } else {
            this.iUl.p(o.c(bxb));
            return true;
        }
    }
}
