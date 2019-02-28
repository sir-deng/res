package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.cc.k;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.e;
import com.tencent.mm.ui.v;

public final class f extends d {
    private static boolean ffp = true;
    private k ffn = new k();
    private volatile boolean ffo = false;

    public final void tO() {
        super.tO();
        a.a("Hello WeChat, DefaultBootStep load debugger and init xlog...", new Object[0]);
        ad.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        i.cq(((h) g.Dn().CU()).gQd);
        m.d(com.tencent.mm.boot.a.a.class);
        m.cu("com.tencent.mm.boot");
        m.a(((h) g.Dn().CU()).gUt, ((h) g.Dn().CU()).gUt.getResources());
    }

    public final void tP() {
        g.Dm().gRL = com.tencent.mm.plugin.zero.a.d.class;
        d.o(PluginZero.class);
        d.o(PluginMessengerFoundation.class);
        d.o(PluginReport.class);
        d.o(PluginAuth.class);
        d.o(PluginBigBallOfMud.class);
        d.o(PluginRecovery.class);
        d.fR("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
        d.fR("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
        d.fR("com.tencent.mm.plugin.comm.PluginComm");
        d.fR("com.tencent.mm.plugin.audio.PluginVoice");
        d.fR("com.tencent.mm.plugin.biz.PluginBiz");
        d.fR("com.tencent.mm.plugin.notification.PluginNotification");
        d.fR("com.tencent.mm.plugin.messenger.PluginMessenger");
        d.fR("com.tencent.mm.plugin.welab.PluginWelab");
        d.fR("com.tencent.mm.plugin.sport.PluginSport");
        d.fR("com.tencent.mm.plugin.fts.PluginFTS");
        d.fR("com.tencent.mm.openim.PluginOpenIM");
        fS("com.tencent.mm.plugin.performance.PluginPerformance");
        fS("com.tencent.mm.plugin.chatroom.PluginChatroom");
        fS("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
        fS("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
        fS("com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat");
        fS("com.tencent.mm.plugin.uishow.PluginUIShow");
        fS("com.tencent.mm.plugin.emoji.PluginEmoji");
        fS("com.tencent.mm.plugin.video.PluginVideo");
        fS("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
        fS("com.tencent.mm.plugin.sns.PluginSns");
        fS("com.tencent.mm.plugin.downloader.PluginDownloader");
        fS("com.tencent.mm.plugin.fav.PluginFav");
        fS("com.tencent.mm.plugin.record.PluginRecord");
        fS("com.tencent.mm.plugin.music.PluginMusic");
        fS("com.tencent.mm.plugin.MMPhotoEditPlugin");
        fS("com.tencent.mm.plugin.facedetect.PluginFace");
        fS("com.tencent.mm.plugin.soter.PluginSoter");
        fS("com.tencent.mm.plugin.walletlock.PluginWalletLock");
        fS("com.tencent.mm.plugin.wxpay.PluginWxPay");
        fS("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
        fS("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
        fS("com.tencent.mm.plugin.radar.PluginRadar");
        fS("com.tencent.mm.plugin.topstory.PluginTopStory");
        fS("com.tencent.mm.plugin.mmsight.PluginMMSight");
        fS("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
        fS("com.tencent.mm.plugin.normsg.PluginNormsg");
        fS("com.tencent.mm.plugin.netmock.PluginNetMock");
        com.tencent.mm.kernel.a.b.g gVar = c.DA().gSY;
        com.tencent.mm.kernel.b.a k = g.k(n.class);
        gVar.gUm.put(com.tencent.mm.kernel.api.c.class, k);
    }

    public final void a(final com.tencent.mm.kernel.b.g gVar) {
        if (((h) g.Dn().CU()).DZ()) {
            tQ();
            new ah("Startup-SideWork").F(new Runnable() {
                public final void run() {
                    try {
                        k a = f.this.ffn;
                        synchronized (a.gPR) {
                            a.gPR[0] = (byte) -1;
                            j.i("MicroMsg.WxWaitingLock", "markUse %s", a);
                        }
                        f.this.ffn.done();
                        Context contextWrapper = new ContextWrapper(gVar.gUt);
                        b Ef = b.Ef();
                        Looper looper = com.tencent.mm.kiss.a.a.Ee().gUC.getLooper();
                        LayoutInflater fw = v.fw(contextWrapper);
                        if (!Ef.gUI) {
                            Ef.gUI = true;
                            Ef.DF = fw;
                            Ef.gUG = looper;
                            Ef.mMode = 2;
                            Ef.gUH = new com.tencent.mm.kiss.a.b.AnonymousClass1(Ef.gUG);
                        }
                        com.tencent.mm.blink.a.wo();
                        Context baseContext = ((h) g.Dn().CU()).gUt.getBaseContext();
                        boolean a2 = b.Ef().a("R.layout.actionbar_title_launcher", 1, R.i.dad, new LinearLayout(baseContext), new int[0]);
                        b.Ef().a("R.layout.main_tab", 1, R.i.dnb, new int[0]);
                        if (com.tencent.mm.bu.a.ez(baseContext)) {
                            b.Ef().a("R.layout.mm_bottom_tabitem_large", 4, R.i.dnx, new LinearLayout(baseContext), new int[0]);
                        } else {
                            b.Ef().a("R.layout.mm_bottom_tabitem", 4, R.i.dnw, new LinearLayout(baseContext), new int[0]);
                        }
                        b.Ef().a("R.layout.mm_activity", 4, R.i.dnq, new int[0]);
                        if (!(Build.BRAND.equals("vivo") && com.tencent.mm.compatible.util.d.fO(20))) {
                            b.Ef().a("R.layout.main", 1, R.i.cuP, new int[0]);
                            b.Ef().a("R.layout.address", 1, R.i.dag, new int[0]);
                            b.Ef().a("R.layout.mm_preference_fragment_list_content", 2, R.i.dnZ, new int[0]);
                        }
                        b.Ef().a("R.layout.actionview_with_dot_tips", 1, R.i.dae, new int[0]);
                        if (com.tencent.mm.bu.a.ez(baseContext)) {
                            b.Ef().a("R.layout.conversation_item_with_cache_large", 8, R.i.dfk, null);
                        } else if (com.tencent.mm.bu.a.eA(baseContext)) {
                            b.Ef().a("R.layout.conversation_item_with_cache_small", 8, R.i.dfl, null);
                        } else {
                            b.Ef().a("R.layout.conversation_item_with_cache", 8, R.i.dfj, null);
                        }
                        if (a2) {
                            b Ef2 = b.Ef();
                            Ef2.gUH.post(new com.tencent.mm.blink.c.AnonymousClass1());
                        }
                        f.this.ffn.done();
                    } catch (Throwable e) {
                        try {
                            x.printErrStackTrace("MicroMsg.DefaultBootStep", e, "", new Object[0]);
                            com.tencent.mm.blink.a.j(10, 1);
                            x.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", ad.getResources(), gVar.gUt.getResources(), gVar.gUt.getResources().getAssets());
                            new bd(gVar) {
                                protected final Object run() {
                                    f.tQ();
                                    return null;
                                }
                            }.b(new ag(Looper.getMainLooper()));
                            f.this.ffo = true;
                        } finally {
                            f.this.ffn.done();
                        }
                    }
                }
            });
        }
        super.a(gVar);
    }

    private static void tQ() {
        long currentTimeMillis = System.currentTimeMillis();
        m.ua();
        com.tencent.mm.blink.a.j(4, System.currentTimeMillis() - currentTimeMillis);
        com.tencent.mm.blink.a.j(5, 1);
        x.i("MicroMsg.DefaultBootStep", "SVG init done, spent %s", Long.valueOf(currentTimeMillis));
    }

    public final void b(com.tencent.mm.kernel.b.g gVar) {
        if (((h) g.Dn().CU()).DZ()) {
            k kVar = this.ffn;
            synchronized (kVar.gPR) {
                try {
                    if (kVar.gPR[0] == (byte) -1) {
                        j.i("MicroMsg.WxWaitingLock", "waiting %s", kVar);
                        kVar.gPR.wait();
                        j.i("MicroMsg.WxWaitingLock", "after waiting %s", kVar);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WxWaitingLock", e, "", new Object[0]);
                }
            }
            if (this.ffo) {
                x.e("MicroMsg.DefaultBootStep", "SVG still failed!");
            }
        }
        super.b(gVar);
    }

    public final boolean tR() {
        if (ffp) {
            return true;
        }
        if (!((h) g.Dn().CU()).DZ()) {
            return true;
        }
        g.Do();
        if (!com.tencent.mm.kernel.a.CE() || !g.Do().CF()) {
            return true;
        }
        if (e.xtQ.size() == 1) {
            if (ad.cgd().equals(e.U((Activity) e.xtQ.get(0)))) {
                x.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
                return false;
            }
        }
        return true;
    }
}
