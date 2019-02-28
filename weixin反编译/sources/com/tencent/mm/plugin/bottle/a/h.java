package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Map;
import junit.framework.Assert;

public final class h {

    public static class d extends com.tencent.mm.audio.b.h implements e {
        public a kGB = null;
        private int kGE = 0;

        public d(Context context, a aVar) {
            boolean z = false;
            super(context, false);
            String str = "must call back onFin";
            if (aVar != null) {
                z = true;
            }
            Assert.assertTrue(str, z);
            as.CN().a((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
            this.kGB = aVar;
        }

        public final boolean vp() {
            String fileName = super.getFileName();
            boolean vp = super.vp();
            super.reset();
            if (!vp) {
                as.CN().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
                this.kGB = null;
                return false;
            } else if (c.asf() > 0) {
                as.CN().a(new g(fileName, this.flV), 0);
                return true;
            } else {
                as.CN().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
                if (this.kGB == null) {
                    return false;
                }
                this.kGB.ci(1, 16);
                return false;
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
                if (this.kGB != null) {
                    this.kGE = ((g) kVar).asl();
                    this.kGB.ci(i, i2);
                }
                this.kGB = null;
                as.CN().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
            }
        }
    }

    public static class b implements e {
        public String iconUrl = "";
        private a kGB = null;
        public String kGC = "";
        public final f kGD = new f();
        public int kGr = -10001;
        public String kGw;

        public final boolean a(a aVar) {
            x.d("MicroMsg.PickBottle", "bottle pick:" + c.asg() + " throw:" + c.asf());
            Assert.assertTrue("renew this class", this.kGB == null);
            Assert.assertTrue("must call back onFin", true);
            if (c.asg() <= 0) {
                aVar.ci(1, 16);
                return false;
            }
            as.CN().a(155, (e) this);
            as.CN().a(156, (e) this);
            this.kGB = aVar;
            return as.CN().a(this.kGD, 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.d("MicroMsg.PickBottle", "type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            if (kVar.getType() == 155) {
                f fVar = (f) kVar;
                if (fVar.kGz) {
                    as.CN().b(155, (e) this);
                    com.tencent.mm.plugin.bottle.a.ihO.un();
                    this.kGw = fVar.ask().wJH == null ? "" : fVar.ask().wJH;
                    this.kGr = fVar.ask().nlX;
                    Map y = bj.y(fVar.ask().wsn == null ? "" : fVar.ask().wsn, "branduser");
                    if (y != null) {
                        this.kGC = (String) y.get(".branduser.$username");
                        this.iconUrl = (String) y.get(".branduser.$iconurl");
                        if (this.kGC != null) {
                            this.kGr = 19990;
                            if (this.kGB != null) {
                                if (i == 0 && i2 == 0) {
                                    this.kGB.ci(i, i2);
                                } else {
                                    this.kGB.ci(i, i2);
                                }
                            }
                            this.kGB = null;
                            return;
                        }
                    }
                    as.CN().a(new e(this.kGw, this.kGr), 0);
                    return;
                }
                if (this.kGB != null) {
                    this.kGB.ci(i, i2);
                }
                this.kGB = null;
                as.CN().b(155, (e) this);
                as.CN().b(156, (e) this);
            } else if (kVar.getType() == 156) {
                as.CN().b(156, (e) this);
                if (this.kGB != null) {
                    if (i == 0 && i2 == 0) {
                        this.kGB.ci(i, i2);
                    } else {
                        this.kGB.ci(i, i2);
                    }
                }
                this.kGB = null;
            }
        }
    }

    public static class c implements e {
        private a kGB = null;
        private int kGE = 0;

        public c(String str, a aVar) {
            boolean z;
            Assert.assertTrue("emtpy input text", !bi.oN(str));
            String str2 = "must call back onFin";
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(str2, z);
            if (c.asf() > 0) {
                as.CN().a((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
                this.kGB = aVar;
                as.CN().a(new g(str), 0);
            } else if (aVar != null) {
                aVar.ci(1, 16);
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
                if (this.kGB != null) {
                    this.kGE = ((g) kVar).asl();
                    this.kGB.ci(i, i2);
                }
                this.kGB = null;
                as.CN().b((int) JsApiMakeVoIPCall.CTRL_INDEX, (e) this);
            }
        }
    }

    public interface a {
        void ci(int i, int i2);
    }
}
