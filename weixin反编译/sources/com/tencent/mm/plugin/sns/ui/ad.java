package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ad implements z {
    private String appId;
    private String appName;
    String desc = "";
    MMActivity fnF;
    String frM = "";
    private boolean fsk = false;
    String fwx = "";
    String hcU;
    private String iNG;
    ProgressDialog inI = null;
    private View kvL = null;
    String nGV;
    private Bitmap rAA = null;
    private aqp rAB = new aqp();
    private boolean rAC = false;
    private c rAD = new c<pk>() {
        {
            this.xmG = pk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pk pkVar = (pk) bVar;
            x.i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(pkVar.fIc.type));
            switch (pkVar.fIc.type) {
                case 1:
                    x.i("MicroMsg.SightWidget", "come event done");
                    ad.this.videoPath = pkVar.fIc.videoPath;
                    ad.this.frM = pkVar.fIc.fIf;
                    if (ad.this.inI != null) {
                        ad.this.inI.dismiss();
                    }
                    if (pkVar.fIc.fIe && ad.this.rAE != null) {
                        ad.a(ad.this);
                    }
                    x.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(pkVar.fIc.fIe), pkVar.fIc.videoPath, Long.valueOf(FileOp.mi(pkVar.fIc.videoPath)), ad.this.frM);
                    break;
            }
            return false;
        }
    };
    aw rAE = null;
    private int rAF = 0;
    Runnable rAG = new Runnable() {
        public final void run() {
            ad.a(ad.this);
        }
    };
    Runnable rAH = new Runnable() {
        public final void run() {
            x.i("MicroMsg.SightWidget", "showProgress");
            ad adVar = ad.this;
            Context context = ad.this.fnF;
            ad.this.fnF.getString(j.dGZ);
            adVar.inI = h.a(context, ad.this.fnF.getString(j.qSk), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ad.this.rAE = null;
                    ad.this.rAz = false;
                    ah.K(ad.this.rAG);
                }
            });
        }
    };
    SightPlayImageView rAy;
    boolean rAz = false;
    private int rym;
    private com.tencent.mm.modelsns.b rys = null;
    private boolean rzG = false;
    private boolean rzH = false;
    private WXMediaMessage rzI = null;
    String videoPath = "";

    static /* synthetic */ void a(ad adVar) {
        if (adVar.rAE != null) {
            if (adVar.inI != null) {
                adVar.inI.dismiss();
            }
            x.i("MicroMsg.SightWidget", "commitDone");
            b pkVar = new pk();
            pkVar.fIc.type = 0;
            pkVar.fIc.fIe = true;
            a.xmy.m(pkVar);
            adVar.rAz = true;
            int commit = adVar.rAE.commit();
            if (adVar.rys != null) {
                adVar.rys.iz(commit);
                e.rjJ.c(adVar.rys);
            }
            ae.bwm().rCB = 0;
            if (adVar.fnF.getIntent() != null && adVar.fnF.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(adVar.fnF, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                adVar.fnF.startActivity(intent);
            }
            adVar.fnF.setResult(-1);
            adVar.fnF.finish();
            ae.bwb().buT();
        }
    }

    public ad(MMActivity mMActivity) {
        this.fnF = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rys = com.tencent.mm.modelsns.b.q(this.fnF.getIntent());
        this.nGV = bi.aD(this.fnF.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.hcU = bi.aD(this.fnF.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rzG = this.fnF.getIntent().getBooleanExtra("KThrid_app", false);
        this.rzH = this.fnF.getIntent().getBooleanExtra("KSnsAction", false);
        this.rAC = this.fnF.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rym = this.fnF.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.iNG = bi.aD(this.fnF.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.fnF.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rzI = new Req(bundleExtra).message;
        }
        this.fwx = this.fnF.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.fnF.getIntent().getStringExtra("KSightPath");
        this.frM = this.fnF.getIntent().getStringExtra("sight_md5");
        byte[] byteArrayExtra = this.fnF.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.rAB.aH(byteArrayExtra);
            } catch (Exception e) {
                x.i("MicroMsg.SightWidget", "error %s", e.getMessage());
            }
        }
        if (this.rAB == null) {
            this.rAB = new aqp();
            this.rAB.wEa = this.rAC;
        }
        b pkVar = new pk();
        pkVar.fIc.type = 2;
        a.xmy.m(pkVar);
        if (bi.oN(this.videoPath)) {
            this.videoPath = bi.aD(pkVar.fId.fIh, "");
            x.e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.frM = bi.oN(this.frM) ? bi.aD(pkVar.fId.fIf, "") : this.frM;
        x.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.fwx, this.videoPath, this.frM);
        a.xmy.b(this.rAD);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzT() {
        return true;
    }

    public final View bzU() {
        this.kvL = View.inflate(this.fnF, g.qOu, null);
        this.rAy = (SightPlayImageView) this.kvL.findViewById(f.cRp);
        this.fnF.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.rAy.dx(com.tencent.mm.bu.a.fromDPToPix(this.fnF, 64), com.tencent.mm.bu.a.fromDPToPix(this.fnF, 64));
        this.rAy.a(QImageView.a.CENTER_CROP);
        this.rAy.qAM = true;
        this.rAy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (FileOp.bO(ad.this.videoPath)) {
                    int width;
                    int height;
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationInWindow(iArr);
                        width = view.getWidth();
                        height = view.getHeight();
                    } else {
                        height = 0;
                        width = 0;
                    }
                    Intent intent = new Intent(ad.this.fnF, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", ad.this.videoPath);
                    intent.putExtra("intent_thumbpath", ad.this.fwx);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_ispreview", true);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    ad.this.fnF.startActivity(intent);
                    ad.this.fnF.overridePendingTransition(0, 0);
                    return;
                }
                x.i("MicroMsg.SightWidget", "click videopath is not exist " + ad.this.videoPath);
            }
        });
        x.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.fwx + " " + FileOp.mi(this.videoPath) + " " + FileOp.mi(this.fwx));
        if (FileOp.bO(this.videoPath)) {
            x.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.frM);
        }
        this.rAy.if(false);
        this.rAy.aA(this.videoPath, false);
        return this.kvL;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, apl apl, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.rAE != null) {
            return false;
        }
        if (this.rAz) {
            return true;
        }
        this.rAz = true;
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List GO = s.GO();
            for (String str3 : list) {
                if (!GO.contains(str3)) {
                    bmn bmn = new bmn();
                    bmn.kyG = str3;
                    linkedList.add(bmn);
                }
            }
        }
        this.rAE = new aw(15);
        pInt.value = this.rAE.afu;
        if (i3 > com.tencent.mm.plugin.sns.c.a.qWI) {
            this.rAE.xe(3);
        }
        aw Le = this.rAE.Le(str);
        LinkedList linkedList3 = new LinkedList();
        Le.a(apl).aj(linkedList).xg(i).xh(i2).bO(list2);
        if (z) {
            this.rAE.xj(1);
        } else {
            this.rAE.xj(0);
        }
        this.rAE.bO(list2);
        this.rAE.xi(this.rym);
        this.rAE.fIK = this.rAB;
        this.rAE.e(null, null, null, i4, i5);
        if (!bi.oN(this.appId)) {
            this.rAE.Lk(this.appId);
        }
        if (!bi.oN(this.appName)) {
            this.rAE.Ll(bi.aD(this.appName, ""));
        }
        if (this.rzG) {
            this.rAE.xi(5);
        }
        if (this.rzH && this.rzI != null) {
            this.rAE.Lf(this.rzI.mediaTagName);
            this.rAE.V(this.appId, this.rzI.messageExt, this.rzI.messageAction);
        }
        ah.h(this.rAH, 700);
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                ad adVar = ad.this;
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(adVar.nGV) || TextUtils.isEmpty(adVar.hcU)) {
                    if (!adVar.rAE.l(adVar.videoPath, adVar.fwx, adVar.desc, adVar.frM)) {
                        x.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.mi(adVar.videoPath) + " thumb: " + FileOp.mi(adVar.fwx));
                        ah.y(new Runnable() {
                            public final void run() {
                                u.makeText(ad.this.fnF, j.eKq, 0).show();
                            }
                        });
                    }
                    x.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    int i;
                    aw awVar = adVar.rAE;
                    String str = adVar.videoPath;
                    String str2 = adVar.fwx;
                    String str3 = adVar.desc;
                    String str4 = adVar.frM;
                    String str5 = adVar.nGV;
                    String str6 = adVar.hcU;
                    String str7 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.s(str.getBytes());
                    aw.Lo(str7);
                    FileOp.x(str, str7);
                    String str8 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.s(str2.getBytes());
                    FileOp.x(str2, str8);
                    are a = aw.a("", 6, str7, str8, str4, str5, str6);
                    if (a == null) {
                        x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                        i = 0;
                    } else {
                        a.nkL = str3;
                        if (bi.oN(a.fpg)) {
                            a.fpg = str3;
                        }
                        awVar.reu.wYj.wfh.add(a);
                        apk apk = new apk();
                        apk.wCR = a.qXb;
                        awVar.rev.wFn.add(apk);
                        i = 1;
                    }
                    if (i == 0) {
                        x.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.mi(adVar.videoPath) + " thumb: " + FileOp.mi(adVar.fwx) + ",cdnUrl " + adVar.nGV + "cdnThubmUrl " + adVar.hcU);
                        ah.y(new Runnable() {
                            public final void run() {
                                u.makeText(ad.this.fnF, j.eKq, 0).show();
                            }
                        });
                    }
                    x.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                x.i("MicroMsg.SightWidget", "removeRunnable showProgress");
                ah.K(ad.this.rAH);
                if (ad.this.rAE != null) {
                    ah.y(ad.this.rAG);
                }
            }
        }, "sight_send_ready");
        return true;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzV() {
        if (this.inI != null) {
            this.inI.dismiss();
        }
        this.rAy.aA(this.videoPath, true);
        a.xmy.c(this.rAD);
        if (com.tencent.mm.plugin.sns.data.i.m(this.rAA)) {
            this.rAA.recycle();
        }
        return false;
    }
}
