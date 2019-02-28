package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

public final class a {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public int jGH;
    public String jGI = (e.gJd + "appbrand/");
    public SSLContext jGJ;
    public final String jGK;
    protected final ArrayList<String> jGL = new ArrayList();
    public final ArrayList<b> jGM = new ArrayList();
    public String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.j.a$1 */
    class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.j.a.a {
        final /* synthetic */ a jGN;
        final /* synthetic */ String jex;

        public AnonymousClass1(String str, a aVar) {
            this.jex = str;
            this.jGN = aVar;
        }

        public final void a(String str, String str2, String str3, int i) {
            a.this.tR(this.jex);
            this.jGN.c(a.SUCCESS, str2, str, i);
            x.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", str, str3);
        }

        public final void g(int i, long j, long j2) {
            this.jGN.f(i, j, j2);
        }

        public final void D(String str, String str2, String str3) {
            x.e("MicroMsg.AppBrandNetworkDownload", "download error! filename %s, url %s", str, str2);
            this.jGN.sW(str3);
            a.this.tR(this.jex);
        }

        public final void bC(String str, String str2) {
            x.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", str, str2);
        }

        public final void tU(String str) {
            a.this.jGL.remove(str);
        }
    }

    public interface a {
        void c(int i, String str, String str2, int i2);

        void f(int i, long j, long j2);

        void sW(String str);
    }

    public a(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.jGH = appBrandSysConfig.iRE;
        this.jGJ = i.uc(this.mAppId);
        this.jGK = str2;
    }

    private void tR(String str) {
        if (str != null) {
            synchronized (this.jGM) {
                Iterator it = this.jGM.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (str.equals(bVar.jeC)) {
                        this.jGM.remove(bVar);
                        break;
                    }
                }
            }
        }
    }

    public final b tS(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jGM) {
            Iterator it = this.jGM.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (str.equals(bVar.jeC)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.jGL.add(bVar.jeC);
            tR(bVar.jeC);
            bVar.ajo();
        }
    }

    public final boolean tT(String str) {
        return this.jGL.contains(str);
    }
}
