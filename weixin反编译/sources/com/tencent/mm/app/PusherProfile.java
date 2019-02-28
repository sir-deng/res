package com.tencent.mm.app;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.console.Shell;
import com.tencent.mm.f.a.gl;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;

public final class PusherProfile extends e {
    public static final String ffs = (ad.getPackageName() + ":push");
    private Shell ffW = new Shell();

    public final void onCreate() {
        Context context = ad.getContext();
        AppLogic.setCallBack(new AppCallBack(ad.getContext()));
        k.b(a.xmn, PusherProfile.class.getClassLoader());
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        q tVar = new t(c.aA(context));
        tVar.eg("PUSH");
        r.ifb = bi.a(tVar.eh(".com.tencent.mm.debug.test.display_errcode"), false);
        r.ifc = bi.a(tVar.eh(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.ifd = bi.a(tVar.eh(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.ife = bi.a(tVar.eh(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.iff = bi.a(tVar.eh(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.ifg = bi.a(tVar.eh(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.ifk = bi.a(tVar.eh(".com.tencent.mm.debug.test.album_show_info"), false);
        r.ifl = bi.a(tVar.eh(".com.tencent.mm.debug.test.location_help"), false);
        r.ifo = bi.a(tVar.eh(".com.tencent.mm.debug.test.force_soso"), false);
        r.ifp = bi.a(tVar.eh(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.ifq = bi.a(tVar.eh(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.ifr = bi.a(tVar.eh(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.ifu = bi.a(tVar.eh(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.ifv = bi.a(tVar.eh(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(tVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.ifs = a;
        if (a != 4 && r.ifs > 0) {
            v.xuZ = r.ifs;
            x.e("MicroMsg.PushDebugger", "cdn thread num " + r.ifs);
        }
        r.ift = bi.a(tVar.eh(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        r.ify = bi.a(tVar.eh(".com.tencent.mm.debug.test.skip_getdns"), false);
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CX(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oN(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vHg = "android-" + string;
                d.vHi = string;
                b.Vn(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.cfy());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vHk).append(" new: ").append(a);
            d.vHk = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            tVar.gAA.gzJ = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(tVar.eh(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(tVar.eh(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(tVar.eh(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(tVar.eh(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        a.cl(ffs);
        o.onCreate(false);
        com.tencent.mm.bl.d.a("gcm", null, null);
        com.tencent.mm.bl.d.TI("gcm");
        com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<gl>() {
            {
                this.xmG = gl.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                String str = "gcm";
                String str2 = "GCMDoSyncEvent Notify Now Always should be MM_NEWSYNC_DEFAULT_SELECTOR  & SCENE_SYNC_GCM  atapter == null[%b]";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aa.VZ() == null);
                x.i(str, str2, objArr);
                if (aa.VZ() != null) {
                    aa.VZ().onPush(2147480001, new byte[0]);
                } else {
                    aa.ch(true);
                }
                return true;
            }
        });
        bi.initLanguage(ad.getContext());
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ffs;
    }
}
