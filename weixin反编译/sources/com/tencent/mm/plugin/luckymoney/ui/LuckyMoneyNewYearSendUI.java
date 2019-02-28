package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private Dialog ion = null;
    private OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == f.uvd) {
                g.pWK.h(13079, Integer.valueOf(5), Integer.valueOf(1));
                if (LuckyMoneyNewYearSendUI.this.oiQ == 1 && LuckyMoneyNewYearSendUI.this.ook && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.ooF) && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.ool) && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.oom) && LuckyMoneyNewYearSendUI.this.oon > 0) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with last post image data!");
                    LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
                } else if (LuckyMoneyNewYearSendUI.this.oiQ == 1 && LuckyMoneyNewYearSendUI.this.ook && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.ooF)) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with new image data!");
                    LuckyMoneyNewYearSendUI.this.aYs();
                    if (LuckyMoneyNewYearSendUI.this.ooo == null) {
                        LuckyMoneyNewYearSendUI.this.ooo = new j();
                    }
                    i.a i = LuckyMoneyNewYearSendUI.this.ooo;
                    String c = LuckyMoneyNewYearSendUI.this.ooF;
                    j.a anonymousClass1 = new j.a() {
                        public final void a(keep_SceneResult keep_sceneresult, String str, boolean z) {
                            if (z) {
                                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image success, to send HB");
                                LuckyMoneyNewYearSendUI.this.ool = keep_sceneresult.field_fileId;
                                LuckyMoneyNewYearSendUI.this.oom = keep_sceneresult.field_aesKey;
                                LuckyMoneyNewYearSendUI.this.oon = keep_sceneresult.field_fileLength;
                                LuckyMoneyNewYearSendUI.this.mHandler.post(new Runnable() {
                                    public final void run() {
                                        LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
                                    }
                                });
                                return;
                            }
                            LuckyMoneyNewYearSendUI.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image fail!");
                                    if (LuckyMoneyNewYearSendUI.this.ion != null && LuckyMoneyNewYearSendUI.this.ion.isShowing()) {
                                        LuckyMoneyNewYearSendUI.this.ion.hide();
                                    }
                                    h.bu(LuckyMoneyNewYearSendUI.this, LuckyMoneyNewYearSendUI.this.getString(com.tencent.mm.plugin.wxpay.a.i.uRD));
                                }
                            });
                        }
                    };
                    i.lUy = j.aXL();
                    i.oie = anonymousClass1;
                    i.oif = c;
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: sendImg. imageId:%s", i.lUy);
                    i iVar = new i();
                    iVar.fMC = true;
                    iVar.hve = i;
                    iVar.field_mediaId = r2;
                    iVar.field_fullpath = c;
                    iVar.field_thumbpath = "";
                    iVar.field_fileType = b.MediaType_FILE;
                    iVar.field_talker = "";
                    iVar.field_priority = b.htu;
                    iVar.field_needStorage = false;
                    iVar.field_isStreamMedia = false;
                    iVar.field_appType = 0;
                    iVar.field_bzScene = 0;
                    if (!com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                        x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. clientid:%s", r2);
                    }
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with not image data!");
                    LuckyMoneyNewYearSendUI.this.ooF = "";
                    LuckyMoneyNewYearSendUI.this.ool = "";
                    LuckyMoneyNewYearSendUI.this.oom = "";
                    LuckyMoneyNewYearSendUI.this.oon = 0;
                    LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
                }
            } else if (view.getId() == f.uuY) {
                LuckyMoneyNewYearSendUI.this.finish();
                g.pWK.h(13079, Integer.valueOf(6), Integer.valueOf(1));
            } else if (view.getId() == f.uuV || view.getId() == f.uuX) {
                LuckyMoneyNewYearSendUI.l(LuckyMoneyNewYearSendUI.this);
                g.pWK.h(13079, Integer.valueOf(2), Integer.valueOf(1));
            } else if (view.getId() == f.uuZ) {
                LuckyMoneyNewYearSendUI.this.ool = "";
                LuckyMoneyNewYearSendUI.this.oom = "";
                LuckyMoneyNewYearSendUI.this.oon = 0;
                LuckyMoneyNewYearSendUI.m(LuckyMoneyNewYearSendUI.this);
                g.pWK.h(13079, Integer.valueOf(3), Integer.valueOf(1));
            } else if (view.getId() == f.uvc) {
                LuckyMoneyAutoScrollView n = LuckyMoneyNewYearSendUI.this.oob;
                n.olR = false;
                n.olI.setVisibility(0);
                n.olJ.setVisibility(0);
                n.olK.setVisibility(0);
                n.olL.setVisibility(4);
                n.olM.setVisibility(4);
                n.olN.setVisibility(4);
                LuckyMoneyNewYearSendUI.this.aYt();
                g.pWK.h(13079, Integer.valueOf(4), Integer.valueOf(1));
            } else if (view.getId() == f.uva) {
                LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this);
            }
        }
    };
    private Button lMM;
    private Bitmap mBitmap;
    private ag mHandler = new ag();
    private String oiJ;
    private int oiL;
    private int oiQ = 0;
    private LinkedList<k> oiR;
    private TextView olZ;
    private int old;
    private String olh;
    private int oli;
    private TextView ooA;
    private ImageView ooB;
    private LinearLayout ooC;
    private String ooD;
    private boolean ooE = true;
    private String ooF = "";
    private int ooG = 0;
    private LuckyMoneyAutoScrollView oob;
    private TextView ooc;
    private ImageView oog;
    private View ooh;
    private ImageView ooi;
    private boolean ook = false;
    private String ool = "";
    private String oom = "";
    private int oon;
    private j ooo;
    private View oox;
    private View ooy;
    private ImageView ooz;

    static /* synthetic */ void g(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        g.pWK.h(11701, Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
        String FY = q.FY();
        luckyMoneyNewYearSendUI.b(new ae(luckyMoneyNewYearSendUI.oiL, luckyMoneyNewYearSendUI.oiJ, n.EB(FY), luckyMoneyNewYearSendUI.ooD, FY, q.Ga(), luckyMoneyNewYearSendUI.old, luckyMoneyNewYearSendUI.ool, luckyMoneyNewYearSendUI.oom, luckyMoneyNewYearSendUI.oon), false);
        luckyMoneyNewYearSendUI.aYs();
    }

    static /* synthetic */ void l(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSelectPicture");
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "galleryMode %s", luckyMoneyNewYearSendUI.mController.xRr.getSharedPreferences(ad.cgf(), 0).getString("gallery", "1"));
        if (luckyMoneyNewYearSendUI.mController.xRr.getSharedPreferences(ad.cgf(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) luckyMoneyNewYearSendUI, 2, null);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.k.S(luckyMoneyNewYearSendUI);
        }
    }

    static /* synthetic */ void m(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doDeletePic");
        luckyMoneyNewYearSendUI.ook = false;
        luckyMoneyNewYearSendUI.ooF = "";
        luckyMoneyNewYearSendUI.ool = "";
        luckyMoneyNewYearSendUI.oom = "";
        luckyMoneyNewYearSendUI.oon = 0;
        luckyMoneyNewYearSendUI.av();
    }

    static /* synthetic */ void p(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearSendUI.ooF)) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "image path is empty!");
            return;
        }
        g.pWK.h(13079, Integer.valueOf(7), Integer.valueOf(1));
        new h(luckyMoneyNewYearSendUI, q.FY(), luckyMoneyNewYearSendUI.ooF).n(false, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.ooD = getIntent().getStringExtra("key_username");
        this.old = getIntent().getIntExtra("key_way", 0);
        this.oli = getIntent().getIntExtra("pay_channel", -1);
        if (bi.oN(this.ooD)) {
            x.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        initView();
        l(new w("v1.0"));
        g.pWK.h(13079, Integer.valueOf(1), Integer.valueOf(1));
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PATH_STRING_SYNC, this.ooF);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_ID_STRING_SYNC, this.ool);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_AES_KEY_STRING_SYNC, this.oom);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_LENGTH_INT_SYNC, Integer.valueOf(this.oon));
        super.onDestroy();
        if (this.ion != null && this.ion.isShowing()) {
            this.ion.dismiss();
        }
    }

    protected final void initView() {
        uV(8);
        this.oox = findViewById(f.uvs);
        this.ooc = (TextView) findViewById(f.ute);
        this.oob = (LuckyMoneyAutoScrollView) findViewById(f.uuU);
        this.olZ = (TextView) findViewById(f.uve);
        this.lMM = (Button) findViewById(f.uvd);
        this.lMM.setOnClickListener(this.iqi);
        ((ImageView) findViewById(f.uuY)).setOnClickListener(this.iqi);
        this.ooy = findViewById(f.uuW);
        this.ooz = (ImageView) findViewById(f.uuV);
        this.ooz.setOnClickListener(this.iqi);
        this.oog = (ImageView) findViewById(f.uvf);
        this.ooA = (TextView) findViewById(f.uuX);
        this.ooA.setOnClickListener(this.iqi);
        this.ooh = findViewById(f.uvb);
        this.ooi = (ImageView) findViewById(f.uva);
        this.ooi.setOnClickListener(this.iqi);
        this.ooB = (ImageView) findViewById(f.uuZ);
        this.ooB.setOnClickListener(this.iqi);
        this.ooC = (LinearLayout) findViewById(f.uvc);
        this.ooC.setOnClickListener(this.iqi);
        com.tencent.mm.kernel.g.Dr();
        this.ooF = (String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PATH_STRING_SYNC, (Object) "");
        com.tencent.mm.kernel.g.Dr();
        this.ool = (String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_ID_STRING_SYNC, (Object) "");
        com.tencent.mm.kernel.g.Dr();
        this.oom = (String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_AES_KEY_STRING_SYNC, (Object) "");
        com.tencent.mm.kernel.g.Dr();
        this.oon = ((Integer) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_LENGTH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (TextUtils.isEmpty(this.ooF) || TextUtils.isEmpty(this.ool) || TextUtils.isEmpty(this.oom) || this.oon <= 0) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "count not fetch last post image data!");
        } else {
            this.ook = true;
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "last post image data is valid");
        }
        if (!this.ook || TextUtils.isEmpty(this.ooF)) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:initPictureImage() mIsShowPic:" + this.ook + ", mImagePath:" + this.ooF);
            return;
        }
        Bitmap aq = n.aq(this.ooF, false);
        if (aq != null) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
            Bitmap bitmap = this.mBitmap;
            this.mBitmap = aq;
            this.ooi.setImageBitmap(this.mBitmap);
            if (bitmap != null && bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
    }

    private void av() {
        LayoutParams layoutParams;
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if (this.ook && this.oiQ == 1) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the picture!");
            this.ooy.setVisibility(8);
            this.ooh.setVisibility(0);
            this.oog.setVisibility(8);
        } else if (this.oiQ == 1) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the camera btn!");
            this.ooy.setVisibility(0);
            this.ooh.setVisibility(8);
            this.oog.setVisibility(0);
        } else {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the new year wording!");
            this.ooy.setVisibility(8);
            this.ooh.setVisibility(8);
            this.oog.setVisibility(0);
        }
        if (this.oiR == null || this.oiR.size() <= 0) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
            this.ooC.setVisibility(8);
        } else {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
            this.ooC.setVisibility(0);
        }
        if (this.oiQ == 1) {
            layoutParams = (LayoutParams) this.oog.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiK);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.uiI);
            this.oog.setLayoutParams(layoutParams);
            this.oog.invalidate();
        } else {
            layoutParams = (LayoutParams) this.oog.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiJ);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.uiH);
            this.oog.setLayoutParams(layoutParams);
            this.oog.invalidate();
        }
        if (this.ook) {
            layoutParams = (LayoutParams) this.olZ.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.uiG);
            this.olZ.setLayoutParams(layoutParams);
            this.olZ.invalidate();
            this.olZ.setTextSize(1, 17.0f);
            this.ooc.setTextSize(1, 16.0f);
            this.oob.cP(getResources().getDimensionPixelOffset(d.uiO), getResources().getDimensionPixelOffset(d.uiM));
            layoutParams = (LayoutParams) this.oob.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiC);
            this.oob.setLayoutParams(layoutParams);
            this.oob.invalidate();
            layoutParams = (LayoutParams) this.ooC.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiE);
            this.ooC.setLayoutParams(layoutParams);
            this.ooC.invalidate();
            return;
        }
        layoutParams = (LayoutParams) this.olZ.getLayoutParams();
        layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.uiF);
        this.olZ.setLayoutParams(layoutParams);
        this.olZ.invalidate();
        this.olZ.setTextSize(1, 20.0f);
        this.ooc.setTextSize(1, 18.0f);
        this.oob.cP(getResources().getDimensionPixelOffset(d.uiN), getResources().getDimensionPixelOffset(d.uiL));
        layoutParams = (LayoutParams) this.oob.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiB);
        this.oob.setLayoutParams(layoutParams);
        this.oob.invalidate();
        layoutParams = (LayoutParams) this.ooC.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiD);
        this.ooC.setLayoutParams(layoutParams);
        this.ooC.invalidate();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uJc;
    }

    private void aYs() {
        if (this.ion == null) {
            this.ion = com.tencent.mm.wallet_core.ui.g.a(this.mController.xRr, true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (LuckyMoneyNewYearSendUI.this.ion != null && LuckyMoneyNewYearSendUI.this.ion.isShowing()) {
                        LuckyMoneyNewYearSendUI.this.ion.hide();
                    }
                    if (LuckyMoneyNewYearSendUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNewYearSendUI.this.mController.contentView.getVisibility() == 4) {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                        LuckyMoneyNewYearSendUI.this.finish();
                    }
                    LuckyMoneyNewYearSendUI.this.olU.aXI();
                }
            });
        } else if (!this.ion.isShowing()) {
            this.ion.show();
        }
    }

    private void aYt() {
        int i;
        if (this.oiR == null || this.oiR.size() <= 0) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Do();
            i = com.tencent.mm.kernel.a.Cn();
            int size = this.oiR.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:" + i);
        }
        this.ooG = i;
        if (this.ooG >= 0 && this.ooG < this.oiR.size()) {
            this.oiL = ((k) this.oiR.get(this.ooG)).oig;
            this.oiJ = ((k) this.oiR.get(this.ooG)).oih;
        }
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.ooG + " randomAmount:" + this.oiL + " randomWishing:" + this.oiJ);
        this.oob.ED(e.t(((double) this.oiL) / 100.0d));
        this.oob.a(new LuckyMoneyAutoScrollView.a() {
            public final void aYd() {
                if (LuckyMoneyNewYearSendUI.this.ooE) {
                    LuckyMoneyNewYearSendUI.this.olZ.setVisibility(4);
                    n.a(LuckyMoneyNewYearSendUI.this.mController.xRr, LuckyMoneyNewYearSendUI.this.olZ, LuckyMoneyNewYearSendUI.this.oiJ);
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                            LuckyMoneyNewYearSendUI.this.olZ.setVisibility(0);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                        }
                    });
                    LuckyMoneyNewYearSendUI.this.olZ.startAnimation(alphaAnimation);
                    LuckyMoneyNewYearSendUI.this.ooE = false;
                    return;
                }
                n.a(LuckyMoneyNewYearSendUI.this.mController.xRr, LuckyMoneyNewYearSendUI.this.olZ, LuckyMoneyNewYearSendUI.this.oiJ);
                LuckyMoneyNewYearSendUI.this.olZ.invalidate();
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + kVar.getType());
        PayInfo payInfo;
        if (kVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) kVar;
                this.oiL = wVar.oiL;
                this.oiJ = wVar.oiJ;
                this.oiQ = wVar.oiQ;
                this.oiR = wVar.oiR;
                if (this.oiQ == 0) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "scenePicSwitch is 0, clear local picture data!");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "cans how picture!");
                }
                aYt();
                av();
                uV(0);
                n.a(this.oox, null);
                return true;
            }
            finish();
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.ad) {
            if (this.ion != null && this.ion.isShowing()) {
                this.ion.hide();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                com.tencent.mm.plugin.luckymoney.b.ad adVar = (com.tencent.mm.plugin.luckymoney.b.ad) kVar;
                this.olh = adVar.oiY;
                payInfo = new PayInfo();
                payInfo.fvC = adVar.oiX;
                payInfo.fDQ = 37;
                payInfo.fDM = this.oli;
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 1);
                return true;
            }
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (kVar instanceof ae) {
            if (this.ion != null && this.ion.isShowing()) {
                this.ion.hide();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ae aeVar = (ae) kVar;
                this.olh = aeVar.oiY;
                payInfo = new PayInfo();
                payInfo.fvC = aeVar.oiX;
                payInfo.fDQ = 37;
                payInfo.fDM = this.oli;
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 1);
                return true;
            }
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    g.pWK.h(11701, Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2));
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            boolean z2;
                            if (realnameGuideHelper.b(this, null, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LuckyMoneyNewYearSendUI.this.finish();
                                }
                            })) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            z = z2;
                        }
                    }
                    h.bu(this, getString(com.tencent.mm.plugin.wxpay.a.i.epo));
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb!");
                    n.B(this.olh, this.ooD, 3);
                    if (!z) {
                        finish();
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                return;
            case 2:
                if (intent == null) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_PIC");
                    return;
                } else if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    CharSequence stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (!TextUtils.isEmpty(stringExtra) || (stringArrayListExtra != null && stringArrayListExtra.size() > 0)) {
                        if (TextUtils.isEmpty(stringExtra)) {
                            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePathList is valid!");
                            str = (String) stringArrayListExtra.get(0);
                        } else {
                            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePath is valid!");
                            str = stringExtra;
                        }
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "REQUEST_CODE_FROM_PIC filePath %s", stringExtra);
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gJo + "temp.avatar");
                        intent2.putExtra("CropImage_ImgPath", str);
                        intent2.putExtra("CropImage_Filter", false);
                        intent2.putExtra("CropImage_from_scene", 1);
                        com.tencent.mm.plugin.luckymoney.a.ihN.a((Activity) this, intent2, 3);
                        return;
                    }
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture failed, imagePath and imagePathList is null!");
                    return;
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture cancel or failed!");
                    return;
                }
            case 3:
                if (intent == null) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_CROP");
                    return;
                } else if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    str = intent.getStringExtra("CropImage_OutputPath");
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "new crop image path:" + str);
                    if (TextUtils.isEmpty(str) || !str.equals(this.ooF)) {
                        this.ool = "";
                        this.oom = "";
                        this.oon = 0;
                    } else {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "the path is same as last image");
                    }
                    this.ooF = str;
                    Bitmap aq = n.aq(this.ooF, false);
                    if (aq != null) {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
                        Bitmap bitmap = this.mBitmap;
                        this.mBitmap = aq;
                        this.ooi.setImageBitmap(this.mBitmap);
                        this.ook = true;
                        av();
                        if (bitmap != null && bitmap.isRecycled()) {
                            bitmap.recycle();
                            return;
                        }
                        return;
                    }
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
                    return;
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:do crop image fail for REQUEST_CODE_FROM_CROP");
                    return;
                }
            default:
                return;
        }
    }
}
