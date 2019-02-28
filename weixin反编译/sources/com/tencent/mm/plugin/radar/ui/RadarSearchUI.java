package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b.c.b.e;
import b.c.b.i;
import b.c.b.j;
import b.c.b.l;
import b.e.d;
import com.tencent.mm.f.a.rm;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.ui.RadarViewController.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.q;
import java.util.Arrays;

@com.tencent.mm.ui.base.a(19)
public final class RadarSearchUI extends MMBaseActivity {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pDC = new d[]{j.a(new i(j.R(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;"))};
    public static final a pEg = new a();
    private final b.b pEe;
    private boolean pEf = true;

    static final class c implements OnClickListener {
        final /* synthetic */ RadarSearchUI pEh;

        c(RadarSearchUI radarSearchUI) {
            this.pEh = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.pEh.pEf = true;
            this.pEh.finish();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class b implements OnClickListener {
        final /* synthetic */ RadarSearchUI pEh;

        b(RadarSearchUI radarSearchUI) {
            this.pEh = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.pEh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            this.pEh.pEf = true;
            this.pEh.finish();
        }
    }

    private final RadarViewController bmq() {
        return (RadarViewController) this.pEe.getValue();
    }

    public RadarSearchUI() {
        int i = com.tencent.mm.plugin.radar.a.c.pBs;
        e.i(this, "$receiver");
        this.pEe = i.a(new a(this, i));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        requestWindowFeature(1);
        setContentView(com.tencent.mm.plugin.radar.a.d.pBJ);
        RadarViewController bmq = bmq();
        Object findViewById = bmq.findViewById(com.tencent.mm.plugin.radar.a.c.pBk);
        e.h(findViewById, "findViewById(R.id.radar_main_layer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new b.i("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = bmq.getContext();
        if (context == null) {
            throw new b.i("null cannot be cast to non-null type android.app.Activity");
        }
        Object windowManager = ((Activity) context).getWindowManager();
        e.h(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams2);
        RadarTipsView bmJ = bmq.bmJ();
        bmJ.bmA().setOnClickListener(new c(bmJ));
        RadarTipsView bmJ2 = bmq.bmJ();
        com.tencent.mm.plugin.radar.ui.RadarTipsView.a aVar = RadarTipsView.pFi;
        bmJ2.pFc = RadarTipsView.pFf;
        d dVar = d.pEd;
        int bmp = d.bmp();
        bmJ2.pEU.sendEmptyMessageDelayed(bmJ2.pER, (long) bmp);
        bmJ2.pEU.sendEmptyMessageDelayed(bmJ2.pEQ, (long) (bmp + 8000));
        bmJ2 = bmq.bmJ();
        if (bmJ2.pFa != 0) {
            aVar = RadarTipsView.pFi;
            bmJ2.pFc = RadarTipsView.pFe;
            bmJ2.bmD();
            bmJ2.bmC();
            bmJ2.bmz().setVisibility(8);
            bmJ2.bmA().setVisibility(8);
            bmJ2.setVisibility(8);
        }
        bmJ2.pEY = true;
        bmJ2.pFa = bi.Wz();
        bmJ2.pFb = true;
        bmJ2.pEZ++;
        bmq.bmM().setOnClickListener(bmq.pFz);
        RadarWaveView bmG = bmq.bmG();
        bmG.pGb = bmG.findViewById(com.tencent.mm.plugin.radar.a.c.pBy);
        bmG.pGc = AnimationUtils.loadAnimation(bmG.getContext(), com.tencent.mm.plugin.radar.a.a.pBb);
        Animation animation = bmG.pGc;
        if (animation == null) {
            e.cKr();
        }
        animation.setInterpolator(new LinearInterpolator());
        com.tencent.mm.plugin.radar.ui.b.a aVar2 = com.tencent.mm.plugin.radar.ui.b.a.pDB;
        findViewById = bmq.findViewById(com.tencent.mm.plugin.radar.a.c.pBG);
        e.h(findViewById, "findViewById(R.id.self_round_avatar)");
        ImageView imageView = (ImageView) findViewById;
        Object FY = q.FY();
        e.h(FY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        com.tencent.mm.plugin.radar.ui.b.a.a(imageView, FY);
        RadarMemberView bmH = bmq.bmH();
        com.tencent.mm.plugin.radar.ui.RadarMemberView.b eVar = new RadarViewController.e(bmq);
        e.i(eVar, "listener");
        bmH.pDQ = eVar;
        RadarSpecialGridView bmI = bmq.bmI();
        windowManager = bmq.getContext();
        e.h(windowManager, "context");
        bmq.pFw = new com.tencent.mm.plugin.radar.ui.RadarViewController.c(bmq, bmI, windowManager);
        bmq.bmI().pEi = new g(bmq);
        RadarViewController bmq2 = bmq();
        com.tencent.mm.plugin.radar.b.c cVar = bmq2.pFv;
        findViewById = com.tencent.mm.kernel.g.h(h.class);
        e.h(findViewById, "service(IMessengerStorage::class.java)");
        ((h) findViewById).Ff().a(cVar);
        com.tencent.mm.sdk.b.a.xmy.b(cVar.pCi);
        findViewById = com.tencent.mm.kernel.g.k(n.class);
        e.h(findViewById, "plugin(IPluginMessengerFoundation::class.java)");
        ((n) findViewById).getSysCmdMsgExtension().a("addcontact", (com.tencent.mm.y.bt.a) cVar.pCj, true);
        com.tencent.mm.plugin.radar.b.e eVar2 = bmq2.pFu;
        if (eVar2 == null) {
            e.adf("radarManager");
        }
        com.tencent.mm.kernel.g.CN().a((int) x.CTRL_INDEX, (com.tencent.mm.ad.e) eVar2);
        com.tencent.mm.kernel.g.CN().a(602, (com.tencent.mm.ad.e) eVar2);
        findViewById = com.tencent.mm.kernel.g.Dq().Db().get(229377, Integer.valueOf(0));
        if (findViewById == null) {
            throw new b.i("null cannot be cast to non-null type kotlin.Int");
        }
        com.tencent.mm.kernel.g.Dq().Db().set(229377, Integer.valueOf(((Integer) findViewById).intValue() + 1));
    }

    public final void onResume() {
        super.onResume();
        if (this.pEf) {
            com.tencent.mm.sdk.platformtools.x.i(TAG, "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                bmr();
            }
        }
    }

    private final void bmr() {
        hy(true);
        com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.pCM;
        com.tencent.mm.plugin.radar.b.d.fAL = 0;
        com.tencent.mm.plugin.radar.b.d.pCI = 0;
        com.tencent.mm.plugin.radar.b.d.pCI = com.tencent.mm.plugin.radar.b.d.blY();
        dVar = com.tencent.mm.plugin.radar.b.d.pCM;
        com.tencent.mm.plugin.radar.b.d.pCJ = 0;
        com.tencent.mm.plugin.radar.b.d.pCH = 0;
        com.tencent.mm.plugin.radar.b.d.pCF = 0;
        com.tencent.mm.plugin.radar.b.d.pCG = 0;
        com.tencent.mm.plugin.radar.b.d.pCH = com.tencent.mm.plugin.radar.b.d.blY();
        com.tencent.mm.plugin.report.service.g.pWK.a(com.tencent.mm.plugin.radar.b.d.pCK, com.tencent.mm.plugin.radar.b.d.pCL, 1, false);
        if (bmq().pFx == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || bmq().pFx == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
            com.tencent.mm.plugin.radar.b.e eVar = bmq().pFu;
            if (eVar == null) {
                e.adf("radarManager");
            }
            com.tencent.mm.modelgeo.c cVar = eVar.hry;
            if (cVar != null) {
                cVar.b(eVar.gAn);
            }
            eVar = bmq().pFu;
            if (eVar == null) {
                e.adf("radarManager");
            }
            eVar.blZ();
            bmq().bmG().bmQ();
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.i(strArr, "permissions");
        e.i(iArr, "grantResults");
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        Object currentThread = Thread.currentThread();
        e.h(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        com.tencent.mm.sdk.platformtools.x.i(TAG, "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    bmr();
                    return;
                }
                this.pEf = false;
                com.tencent.mm.ui.base.h.a((Context) this, getString(f.eAc), getString(f.eAg), getString(f.esG), getString(f.eAa), false, (OnClickListener) new b(this), (OnClickListener) new c(this));
                return;
            default:
                return;
        }
    }

    public final void onPause() {
        long blY;
        int i;
        String format;
        super.onPause();
        hy(false);
        com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.pCM;
        if (com.tencent.mm.plugin.radar.b.d.pCI != 0) {
            blY = com.tencent.mm.plugin.radar.b.d.blY() - com.tencent.mm.plugin.radar.b.d.pCI;
            d dVar2 = d.pEd;
            if (d.dZ(blY)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                i2 = com.tencent.mm.plugin.radar.b.d.fAL;
                com.tencent.mm.sdk.platformtools.x.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", Integer.valueOf(i2));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                l lVar = l.AEg;
                format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                e.h((Object) format, "java.lang.String.format(format, *args)");
                gVar.k(10679, format);
                com.tencent.mm.plugin.radar.b.d.pCF++;
                com.tencent.mm.plugin.radar.b.d.pCG = blY + com.tencent.mm.plugin.radar.b.d.pCG;
                com.tencent.mm.plugin.radar.b.d.pCI = 0;
            }
        }
        dVar = com.tencent.mm.plugin.radar.b.d.pCM;
        if (com.tencent.mm.plugin.radar.b.d.pCH != 0) {
            blY = System.currentTimeMillis() - com.tencent.mm.plugin.radar.b.d.pCH;
            i2 = com.tencent.mm.plugin.radar.b.d.pCF;
            float f = (((float) com.tencent.mm.plugin.radar.b.d.pCG) * 1.0f) / 1000.0f;
            int i3 = com.tencent.mm.plugin.radar.b.d.pCJ;
            float f2 = (((float) blY) * 1.0f) / 1000.0f;
            com.tencent.mm.sdk.platformtools.x.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2));
            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pWK;
            l lVar2 = l.AEg;
            format = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2)}, 5));
            e.h((Object) format, "java.lang.String.format(format, *args)");
            gVar2.k(10676, format);
        }
        if (bmq().pFx == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || bmq().pFx == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
            com.tencent.mm.plugin.radar.b.e eVar = bmq().pFu;
            if (eVar == null) {
                e.adf("radarManager");
            }
            eVar.bma();
            eVar = bmq().pFu;
            if (eVar == null) {
                e.adf("radarManager");
            }
            com.tencent.mm.modelgeo.c cVar = eVar.hry;
            if (cVar != null) {
                cVar.c(eVar.gAn);
            }
            bmq().bmG().bmR();
        }
    }

    public final void onDestroy() {
        RadarViewController bmq = bmq();
        com.tencent.mm.plugin.radar.b.c cVar = bmq.pFv;
        Object h = com.tencent.mm.kernel.g.h(h.class);
        e.h(h, "service(IMessengerStorage::class.java)");
        ((h) h).Ff().b(cVar);
        com.tencent.mm.sdk.b.a.xmy.c(cVar.pCi);
        h = com.tencent.mm.kernel.g.k(n.class);
        e.h(h, "plugin(IPluginMessengerFoundation::class.java)");
        ((n) h).getSysCmdMsgExtension().b("addcontact", cVar.pCj, true);
        com.tencent.mm.plugin.radar.b.e eVar = bmq.pFu;
        if (eVar == null) {
            e.adf("radarManager");
        }
        com.tencent.mm.kernel.g.CN().b((int) x.CTRL_INDEX, (com.tencent.mm.ad.e) eVar);
        com.tencent.mm.kernel.g.CN().b(602, (com.tencent.mm.ad.e) eVar);
        eVar.stop();
        com.tencent.mm.modelgeo.c cVar2 = eVar.hry;
        if (cVar2 != null) {
            cVar2.c(eVar.gAn);
        }
        RadarWaveView bmG = bmq.bmG();
        try {
            MediaPlayer mediaPlayer = bmG.pGa;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            bmG.pGa = null;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(RadarWaveView.TAG, e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.x.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
            bmG.pGa = null;
        }
        super.onDestroy();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        e.i(keyEvent, "event");
        boolean onKeyDown = bmq().onKeyDown(i, keyEvent);
        if (onKeyDown) {
            return onKeyDown;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void hy(boolean z) {
        rm rmVar = new rm();
        rmVar.fKf.fKg = z;
        com.tencent.mm.sdk.b.a.xmy.m(rmVar);
    }

    public final Object getSystemService(String str) {
        e.i(str, "name");
        Object systemService = super.getSystemService(str);
        if (e.h((Object) "layout_inflater", (Object) str)) {
            if (systemService == null) {
                throw new b.i("null cannot be cast to non-null type android.view.LayoutInflater");
            }
            systemService = v.b((LayoutInflater) systemService);
        }
        e.h(systemService, "if (Context.LAYOUT_INFLA…r)\n        } else service");
        return systemService;
    }
}
