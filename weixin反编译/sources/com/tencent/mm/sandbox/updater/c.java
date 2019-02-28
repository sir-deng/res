package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    private String feB;
    private boolean hGJ = false;
    private int kOD = 0;
    private String nGY;
    private com.tencent.mm.sandbox.b.a xkQ;
    private String[] xkW;
    private a xkX = null;
    private boolean xkY = false;
    private ag xkZ = new ag() {
        public final void handleMessage(Message message) {
            if (1 == message.what && !c.this.hGJ) {
                new File(c.this.bbC()).delete();
                if (message.arg1 == 0) {
                    x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                    c.this.xkQ.a(200, 0, (bek) message.obj);
                } else if (message.arg1 == 3) {
                    c.this.xkQ.a(3, -1, (bek) message.obj);
                } else if (message.arg1 == 4) {
                    c.this.xkQ.a(4, -1, (bek) message.obj);
                }
            }
            super.handleMessage(message);
        }
    };
    private com.tencent.mm.sandbox.b.a xla = new com.tencent.mm.sandbox.b.a() {
        public final void bK(int i, int i2) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
            c.this.xkQ.bK(i, i2);
        }

        public final void a(int i, int i2, bek bek) {
            if (i != 0) {
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + i);
                if (i == -2) {
                    new File(c.this.bbC()).delete();
                }
                c.this.kOD = c.this.kOD + 1;
                c.this.a(c.this.xkQ);
                return;
            }
            x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
            try {
                if (e.bN(c.this.bbC()) < c.this.xkv) {
                    x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                    c.this.a(c.this.xkQ);
                } else if (c.this.xkY) {
                    if (c.this.feB.equalsIgnoreCase(g.bV(c.this.bbC()))) {
                        c.a(c.this, bek);
                        return;
                    }
                    x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                    new File(c.this.bbC()).delete();
                    c.this.xkQ.a(2, -1, bek);
                } else if (c.this.xkx.equalsIgnoreCase(g.bV(c.this.bbC()))) {
                    e.g(com.tencent.mm.sandbox.monitor.c.xkt, c.this.xkx + ".temp", c.this.xkx + ".apk");
                    c.this.xkQ.a(200, 0, bek);
                } else {
                    x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                    new File(c.this.bbC()).delete();
                    c.this.xkQ.a(-1, -1, bek);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                c.this.xkQ.a(-1, -1, bek);
            }
        }

        public final void fE(long j) {
            c.this.xkQ.fE(j);
        }

        public final void fF(long j) {
            c.this.xkQ.fF(j);
        }
    };

    private class a extends AsyncTask<String, Integer, Integer> {
        private int bmD;
        private HttpClient pua = null;
        private int size;
        private com.tencent.mm.sandbox.b.a xkQ;
        private HttpPost xld = null;
        private HttpResponse xle = null;
        private HttpEntity xlf = null;
        private OutputStream xlg = new OutputStream() {
            private ag handler = new ag(Looper.getMainLooper());
            private ByteArrayOutputStream xlh = new ByteArrayOutputStream();

            public final void write(byte[] bArr, int i, int i2) {
                this.xlh.write(bArr, i, i2);
                if (this.xlh.size() >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || a.this.bmD + this.xlh.size() >= a.this.size) {
                    final int size = this.xlh.size();
                    int a = e.a(c.this.bbC(), this.xlh.toByteArray(), size);
                    this.xlh.reset();
                    if (a != 0) {
                        throw new IOException("appendToFile failed :" + a);
                    }
                    a.this.bmD = a.this.bmD + size;
                    this.handler.post(new Runnable() {
                        public final void run() {
                            if (a.this.bmD <= a.this.size) {
                                a.this.xkQ.bK(a.this.size, a.this.bmD);
                            }
                            a.this.xkQ.fF((long) size);
                        }
                    });
                    if (c.this.hGJ) {
                        throw new IOException("manual force cancel!");
                    }
                }
            }

            public final void write(int i) {
                throw new IOException("unexpected operation");
            }
        };

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return E((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            this.xkQ.a(((Integer) obj).intValue(), 0, null);
        }

        public a(int i, int i2, com.tencent.mm.sandbox.b.a aVar) {
            this.size = i;
            this.bmD = i2;
            this.xkQ = aVar;
        }

        private Integer E(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                return Integer.valueOf(-1);
            }
            x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.bmD);
            this.pua = new DefaultHttpClient();
            this.pua.getParams().setIntParameter("http.connection.timeout", 15000);
            this.xld = new HttpPost(str);
            this.xld.addHeader("RANGE", "bytes=" + this.bmD + "-" + (this.size - this.bmD > 1048576 ? Integer.valueOf((this.bmD + 1048576) - 1) : ""));
            this.xkQ.fE(50);
            this.xle = this.pua.execute(this.xld);
            int statusCode = this.xle.getStatusLine().getStatusCode();
            Integer valueOf;
            if (statusCode == 200 || statusCode == b.CTRL_INDEX) {
                try {
                    if (c.this.xkY && r.ifC && Math.random() > 0.2d) {
                        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                        valueOf = Integer.valueOf(-1);
                        if (this.xld != null) {
                            this.xld.abort();
                        }
                        if (this.xlf != null) {
                            try {
                                this.xlf.consumeContent();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                            }
                        }
                        if (this.pua == null) {
                            return valueOf;
                        }
                        this.pua.getConnectionManager().shutdown();
                        return valueOf;
                    }
                    this.xle.getHeaders("Content-Length");
                    if (this.bmD > this.size) {
                        x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                        valueOf = Integer.valueOf(-2);
                        if (this.xld != null) {
                            this.xld.abort();
                        }
                        if (this.xlf != null) {
                            try {
                                this.xlf.consumeContent();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                            }
                        }
                        if (this.pua == null) {
                            return valueOf;
                        }
                        this.pua.getConnectionManager().shutdown();
                        return valueOf;
                    }
                    this.xlf = this.xle.getEntity();
                    this.xlf.writeTo(this.xlg);
                    this.xlf.consumeContent();
                    valueOf = Integer.valueOf(0);
                    if (this.xld != null) {
                        this.xld.abort();
                    }
                    if (this.xlf != null) {
                        try {
                            this.xlf.consumeContent();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, "", new Object[0]);
                        }
                    }
                    if (this.pua == null) {
                        return valueOf;
                    }
                    this.pua.getConnectionManager().shutdown();
                    return valueOf;
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                    if (this.xld != null) {
                        this.xld.abort();
                    }
                    if (this.xlf != null) {
                        try {
                            this.xlf.consumeContent();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e32, "", new Object[0]);
                        }
                    }
                    if (this.pua != null) {
                        this.pua.getConnectionManager().shutdown();
                    }
                    return Integer.valueOf(-1);
                } catch (Throwable th) {
                    if (this.xld != null) {
                        this.xld.abort();
                    }
                    if (this.xlf != null) {
                        try {
                            this.xlf.consumeContent();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, "", new Object[0]);
                        }
                    }
                    if (this.pua != null) {
                        this.pua.getConnectionManager().shutdown();
                    }
                }
            } else {
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + statusCode);
                if (statusCode == 416) {
                    valueOf = Integer.valueOf(-2);
                    if (this.xld != null) {
                        this.xld.abort();
                    }
                    if (this.xlf != null) {
                        try {
                            this.xlf.consumeContent();
                        } catch (Throwable e2222) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, "", new Object[0]);
                        }
                    }
                    if (this.pua == null) {
                        return valueOf;
                    }
                    this.pua.getConnectionManager().shutdown();
                    return valueOf;
                }
                valueOf = Integer.valueOf(-1);
                if (this.xld != null) {
                    this.xld.abort();
                }
                if (this.xlf != null) {
                    try {
                        this.xlf.consumeContent();
                    } catch (Throwable e22222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, "", new Object[0]);
                    }
                }
                if (this.pua == null) {
                    return valueOf;
                }
                this.pua.getConnectionManager().shutdown();
                return valueOf;
            }
        }

        protected final void onCancelled() {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
            if (this.xld != null) {
                this.xld.abort();
            }
            if (this.xlf != null) {
                try {
                    this.xlf.consumeContent();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                }
            }
            if (this.pua != null) {
                x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
                this.pua.getConnectionManager().shutdown();
            }
        }
    }

    static /* synthetic */ void a(c cVar, final bek bek) {
        try {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = bek;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    int e = i.e(ad.getContext(), c.this.bbC(), c.this.ceT(), c.this.nGY);
                    x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
                    if (e == 0) {
                        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
                        obtain.arg1 = 0;
                        c.this.xkZ.sendMessage(obtain);
                        return;
                    }
                    x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
                    File file = new File(c.this.ceT());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (e == -1) {
                        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
                        obtain.arg1 = 3;
                        c.this.xkZ.sendMessage(obtain);
                    } else if (e == -2) {
                        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
                        obtain.arg1 = 4;
                        c.this.xkZ.sendMessage(obtain);
                    }
                }
            }, "NetSceneGetUpdatePackFromCDN_genApk");
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = bek;
            cVar.xkZ.sendMessage(obtain);
        }
    }

    public c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.xkW = strArr;
    }

    public c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        this.xkW = new String[]{str2};
        this.xkY = true;
        this.feB = str3;
        this.nGY = str4;
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        this.xkQ = aVar;
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.a(-1, -1, null);
        } else if (this.hGJ) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.a(-1, -1, null);
        } else if (ceU() || cfb() >= this.xkW.length) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.xkW.length);
            if (this.xkY) {
                aVar.a(1, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        } else if (f.aD((long) this.xkv)) {
            this.xkX = new a(this.xkv, e.bN(bbC()), this.xla);
            this.xkX.execute(new String[]{this.xkW[cfb()]});
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.xkY) {
                aVar.a(13, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        }
    }

    protected final String bbC() {
        if (this.xkY) {
            return xkt + this.feB + ".temp";
        }
        return super.bbC();
    }

    public final String ceT() {
        if (this.xkY) {
            return xkt + this.nGY + ".apk";
        }
        return xkt + this.xkx + ".apk";
    }

    public final void cancel() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.hGJ = true;
        if (this.xkX != null && !this.xkX.isCancelled()) {
            this.xkX.cancel(true);
        }
    }

    private int cfb() {
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.kOD + ", curLinkIdx = " + (this.kOD / 5));
        return this.kOD / 5;
    }
}
