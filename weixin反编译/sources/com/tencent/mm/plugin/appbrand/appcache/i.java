package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

public final class i extends d implements Runnable {
    private final int iGo;
    private final String iGp;
    private final c iGq = new c() {
        public final void enter() {
            super.enter();
            x.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
            String aaf = af.aaf();
            if (bi.oN(aaf)) {
                ah.y(new Runnable("!!MockLibInfo Path Error!!") {
                    public final void run() {
                        Toast.makeText(ad.getContext(), r2, 1).show();
                        i.this.quit();
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", i.this.iGo);
                File file = new File(aaf);
                file.delete();
                file.createNewFile();
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                int b = e.b(file.getAbsolutePath(), bytes, bytes.length);
                if (b != 0) {
                    ah.y(/* anonymous class already generated */);
                } else {
                    i.this.b(i.this.iGr);
                }
            } catch (Exception e) {
                ah.y(/* anonymous class already generated */);
            }
        }
    };
    private final c iGr = new c() {
        public final void enter() {
            super.enter();
            x.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
            cch cch = new cch();
            cch.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[]{Integer.valueOf(i.this.iGo)});
            cch.version = i.this.iGo;
            cch.frM = i.this.iGp;
            cch.wNv = 1;
            com.tencent.mm.plugin.appbrand.app.e.Zz().a(cch, new PInt());
            aq.a(cch.url, cch.version, new a() {
                public final /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
                    x.i("MicroMsg.LibIncrementalTestCase[incremental]", "MockLibInfo Download Result %s", aVar);
                    if (aVar != b.a.a.OK) {
                        ah.y(/* anonymous class already generated */);
                    } else {
                        ah.y(new Runnable() {
                            public final void run() {
                                i.this.b(i.this.iGs);
                                i.this.DA(0);
                            }
                        });
                    }
                }
            });
        }
    };
    final c iGs = new c() {
        public final void enter() {
            super.enter();
            x.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
            ac.cs(true);
            g.Dp().gRu.a(1168, new com.tencent.mm.ad.e() {
                public final void a(int i, int i2, String str, k kVar) {
                    if (kVar != null && (kVar.hoq instanceof com.tencent.mm.ad.b)) {
                        cch cch = (cch) ((com.tencent.mm.ad.b) kVar.hoq).hnR.hnY;
                        int a = i.this.iGo;
                        int i3 = cch.version;
                        aq.b(ae.p("@LibraryAppId", a, i3), new a() {
                            public final /* bridge */ /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
                                if (aVar == b.a.a.OK) {
                                    ah.y(/* anonymous class already generated */);
                                } else {
                                    ah.y(/* anonymous class already generated */);
                                }
                            }
                        });
                    }
                    g.Dp().gRu.b(1168, (com.tencent.mm.ad.e) this);
                }
            });
        }
    };

    public i(int i, String str) {
        super("LibIncrementalTestCase", Looper.getMainLooper());
        this.iGo = i;
        this.iGp = str;
    }

    public final void run() {
        a(this.iGq);
        a(this.iGr);
        a(this.iGs);
        b(this.iGq);
        start();
    }

    protected final void ZQ() {
        super.ZQ();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    }
}
