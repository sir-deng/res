package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.q;
import java.io.File;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private String imagePath = "";
    private TextView jIe;
    private ImageView lpW;
    private ag mHandler = new ag();
    private int oiQ = 0;
    private TextView olZ;
    private View omE;
    private String omj;
    private LuckyMoneyAutoScrollView oob;
    private TextView ooc;
    private TextView ood;
    private LinearLayout ooe;
    private ImageView oof;
    private ImageView oog;
    private View ooh;
    private ImageView ooi;
    private boolean ooj = false;
    private boolean ook = false;
    private String ool = "";
    private String oom = "";
    private int oon;
    private j ooo;
    private boolean oop = false;
    private r tipDialog = null;

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearReceiveUI.imagePath)) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "image path is empty!");
            return;
        }
        g.pWK.h(13079, Integer.valueOf(7), Integer.valueOf(2));
        new h(luckyMoneyNewYearReceiveUI, q.FY(), luckyMoneyNewYearReceiveUI.imagePath).n(true, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_native_url");
        this.ool = getIntent().getStringExtra("key_image_id");
        this.oom = getIntent().getStringExtra("key_image_aes_key");
        this.oon = getIntent().getIntExtra("key_image_length", 0);
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageId:" + this.ool + ", imageLength:" + this.oon);
        Uri parse = Uri.parse(bi.oM(stringExtra));
        try {
            this.omj = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        initView();
        if (bi.oN(this.omj)) {
            finish();
            x.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            return;
        }
        b(new af(bi.getInt(parse.getQueryParameter("channelid"), 1), this.omj, stringExtra, 1, "v1.0"), false);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.oop) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    protected final void initView() {
        this.omE = findViewById(f.uvl);
        this.oob = (LuckyMoneyAutoScrollView) findViewById(f.uvg);
        this.ooc = (TextView) findViewById(f.ute);
        this.olZ = (TextView) findViewById(f.uvr);
        this.lpW = (ImageView) findViewById(f.uvh);
        this.ooe = (LinearLayout) findViewById(f.uvp);
        this.jIe = (TextView) findViewById(f.uvn);
        this.oof = (ImageView) findViewById(f.uvo);
        this.ood = (TextView) findViewById(f.uvq);
        this.oog = (ImageView) findViewById(f.uvf);
        this.ooh = findViewById(f.uvb);
        this.ooi = (ImageView) findViewById(f.uva);
        this.ooi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this);
            }
        });
        ((ImageView) findViewById(f.uvi)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyNewYearReceiveUI.this.finish();
                g.pWK.h(13079, Integer.valueOf(6), Integer.valueOf(2));
            }
        });
        uV(8);
        this.tipDialog = h.a(this.mController.xRr, getString(i.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (LuckyMoneyNewYearReceiveUI.this.tipDialog != null && LuckyMoneyNewYearReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyNewYearReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyNewYearReceiveUI.this.olU.aXI();
                if (LuckyMoneyNewYearReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNewYearReceiveUI.this.mController.contentView.getVisibility() == 4) {
                    x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
                    LuckyMoneyNewYearReceiveUI.this.finish();
                }
            }
        });
    }

    private void aYr() {
        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
            public final void run() {
                if (new File(LuckyMoneyNewYearReceiveUI.this.imagePath).exists()) {
                    final Bitmap aq = n.aq(LuckyMoneyNewYearReceiveUI.this.imagePath, true);
                    ah.y(new Runnable() {
                        public final void run() {
                            LuckyMoneyNewYearReceiveUI.this.ooi.setImageBitmap(aq);
                        }

                        public final String toString() {
                            return super.toString() + "|renderView";
                        }
                    });
                    return;
                }
                x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + LuckyMoneyNewYearReceiveUI.this.imagePath + " is not exist!");
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof af)) {
            if (kVar instanceof ac) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    final ac acVar = (ac) kVar;
                    e eVar = acVar.oiv;
                    this.jIe.setText(acVar.oiv.ohr);
                    this.oob.ED(com.tencent.mm.wallet_core.ui.e.t(((double) acVar.oiv.fMM) / 100.0d));
                    this.oob.a(new LuckyMoneyAutoScrollView.a() {
                        public final void aYd() {
                            LuckyMoneyNewYearReceiveUI.this.olZ.setVisibility(4);
                            n.a(LuckyMoneyNewYearReceiveUI.this.mController.xRr, LuckyMoneyNewYearReceiveUI.this.olZ, acVar.oiv.oht);
                            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(500);
                            alphaAnimation.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                    LuckyMoneyNewYearReceiveUI.this.olZ.setVisibility(0);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    if (com.tencent.mm.j.g.Af().getInt("PlayCoinSound", 0) > 0) {
                                        k.H(LuckyMoneyNewYearReceiveUI.this, i.uQk);
                                    }
                                    if (acVar.oiw != null) {
                                        acVar.oiw.b(LuckyMoneyNewYearReceiveUI.this, null, null);
                                    }
                                }
                            });
                            LuckyMoneyNewYearReceiveUI.this.olZ.startAnimation(alphaAnimation);
                        }
                    });
                    if (eVar.fMy == 4 && !TextUtils.isEmpty(acVar.oiv.ohr)) {
                        this.oof.setVisibility(8);
                    }
                    uV(0);
                    n.a(this.omE, null);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    this.oop = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    return n.a(this, i2, kVar, bundle, true, null, null, 1004);
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            LayoutParams layoutParams;
            final af afVar = (af) kVar;
            this.oiQ = afVar.oiQ;
            if (this.oiQ == 1) {
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image data!");
                if (TextUtils.isEmpty(this.oom)) {
                    x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageaeskey is empty!");
                }
                if (TextUtils.isEmpty(this.ool) || TextUtils.isEmpty(this.oom) || this.oon <= 0) {
                    x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage() the parameter is illegeal!");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage()!");
                    if (this.ooo == null) {
                        this.ooo = new j();
                    }
                    this.imagePath = n.EC(this.ool) + ".temp";
                    if (new File(this.imagePath).exists()) {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:imagePath file is exist! update image");
                        aYr();
                    } else {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.imagePath + " is not exist!");
                        this.ooo.a(this.ool, this.oom, this.oon, this.imagePath, new j.a() {
                            public final void a(final keep_SceneResult keep_sceneresult, String str, final boolean z) {
                                LuckyMoneyNewYearReceiveUI.this.mHandler.post(new Runnable() {
                                    public final void run() {
                                        if (z) {
                                            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "the download image data is success!");
                                            if (!TextUtils.isEmpty(keep_sceneresult.field_fileId) && keep_sceneresult.field_fileId.equals(LuckyMoneyNewYearReceiveUI.this.ool)) {
                                                LuckyMoneyNewYearReceiveUI.this.aYr();
                                                return;
                                            }
                                            return;
                                        }
                                        x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image fail!");
                                        h.bu(LuckyMoneyNewYearReceiveUI.this, LuckyMoneyNewYearReceiveUI.this.getString(i.uQt));
                                    }
                                });
                            }
                        });
                    }
                }
            } else {
                x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "not to download image data!");
            }
            if (afVar.aXP()) {
                this.ooj = true;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                b.o(this.lpW, q.FY());
                findViewById(f.uvm).setVisibility(8);
                findViewById(f.uvf).setVisibility(0);
            } else {
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    b.o(this.lpW, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(afVar.ohv)) {
                    n.a(this.lpW, afVar.ohv, afVar.ohP);
                }
                n.a(this.mController.xRr, this.ood, afVar.ojf);
                this.ooj = false;
            }
            if (afVar.aXP() || afVar.fMz != 0 || afVar.fMy == 4 || afVar.fMy == 5 || afVar.fMy == 1) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (afVar.fMy != 5) {
                    this.oob.ED(com.tencent.mm.wallet_core.ui.e.t(((double) afVar.ojg) / 100.0d));
                    LuckyMoneyAutoScrollView luckyMoneyAutoScrollView = this.oob;
                    luckyMoneyAutoScrollView.olI.setVisibility(8);
                    luckyMoneyAutoScrollView.olJ.setVisibility(8);
                    luckyMoneyAutoScrollView.olK.setVisibility(8);
                    luckyMoneyAutoScrollView.olL.setVisibility(0);
                    luckyMoneyAutoScrollView.olM.setVisibility(0);
                    luckyMoneyAutoScrollView.olN.setVisibility(0);
                    n.a(this.mController.xRr, this.olZ, afVar.oht);
                    this.jIe.setText(afVar.ohr);
                    if (afVar.fMy == 4 && !TextUtils.isEmpty(afVar.ohr)) {
                        this.oof.setVisibility(8);
                    }
                } else {
                    findViewById(f.uvj).setVisibility(8);
                    ((TextView) findViewById(f.uvk)).setText(afVar.ohr);
                    ((TextView) findViewById(f.uvk)).setVisibility(0);
                }
                uV(0);
                n.a(this.omE, null);
            } else if ("0".equals(afVar.oiB)) {
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, this.olU, afVar.oiC, afVar.oiD, afVar.oiE, afVar.oiF, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a() {
                    public final boolean b(int i, int i2, String str, boolean z) {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                        if (i == 1) {
                            LuckyMoneyNewYearReceiveUI.this.finish();
                        } else if (i == 2) {
                            LuckyMoneyNewYearReceiveUI.this.a(afVar.msgType, afVar.fei, afVar.oeH, afVar.fMx, afVar.ojj);
                        } else if (i == 0 && z) {
                            LuckyMoneyNewYearReceiveUI.this.a(afVar.msgType, afVar.fei, afVar.oeH, afVar.fMx, afVar.ojj);
                        }
                        return true;
                    }
                }, true, 1005);
            } else {
                a(afVar.msgType, afVar.fei, afVar.oeH, afVar.fMx, afVar.ojj);
            }
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "scenePicSwitch:" + this.oiQ + ", imageId:" + this.ool + ", imageLength:" + this.oon);
            if (this.oiQ != 1 || TextUtils.isEmpty(this.ool) || TextUtils.isEmpty(this.oom) || this.oon <= 0) {
                this.ook = false;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "don't show the picture!");
            } else {
                this.ook = true;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "show the picture!");
            }
            boolean z = true;
            if (afVar.fMy == 5 || afVar.fMy == 1) {
                z = false;
            }
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + afVar.fMy + ", isValidStatus is " + z);
            if (this.ook && z) {
                this.ooh.setVisibility(0);
                this.oog.setVisibility(8);
            } else {
                this.ooh.setVisibility(8);
                this.oog.setVisibility(0);
            }
            if (this.ook && z) {
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
            } else {
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
            }
            if (this.ooj) {
                layoutParams = (LayoutParams) this.ooe.getLayoutParams();
                if (this.ook) {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiQ);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiR);
                }
                this.ooe.setLayoutParams(layoutParams);
                this.ooe.invalidate();
                this.jIe.setTextSize(1, 18.0f);
            } else {
                layoutParams = (LayoutParams) this.ooe.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uiP);
                this.ooe.setLayoutParams(layoutParams);
                this.ooe.invalidate();
                this.jIe.setTextSize(1, 12.0f);
            }
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            return false;
        }
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        b(new ac(i, i2, str, str2, n.aXM(), q.Ga(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uJd;
    }
}
