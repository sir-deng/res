package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.adx;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import d.a.a.a;
import d.a.a.c;
import d.a.a.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget extends FrameLayout {
    private static final String teQ = (e.bnF + "wallet/images/");
    private TextView ipR;
    private TextView jbl;
    private Button kHH;
    private String lnQ;
    private c pSQ;
    private boolean qeI = true;
    private boolean sOy;
    private CdnImageView tbn;
    private ViewGroup teC;
    private ImageView teG;
    private ImageView teH;
    private WalletScratchShakeView teI;
    private WalletAwardShakeAnimView teJ;
    private g teK;
    private WalletBaseUI teL;
    private boolean teM = false;
    private boolean teN = false;
    private boolean teO = false;
    private a teP = null;

    static /* synthetic */ byte[] L(Bitmap bitmap) {
        int i = 0;
        int[] iArr = new int[]{(bitmap.getWidth() / 2) - 3, (bitmap.getWidth() / 2) + 3};
        int[] iArr2 = new int[]{(bitmap.getHeight() / 2) - 3, (bitmap.getHeight() / 2) + 3};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        return order.array();
    }

    static /* synthetic */ void a(WalletSuccPageAwardWidget walletSuccPageAwardWidget, int i, boolean z) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "doDrawLottery, is_query_other: %s", Integer.valueOf(walletSuccPageAwardWidget.pSQ.AEw));
        if (walletSuccPageAwardWidget.pSQ.AEw != 0) {
            walletSuccPageAwardWidget.teL.b(new com.tencent.mm.plugin.wallet_core.c.g(walletSuccPageAwardWidget.pSQ.wgE, i, walletSuccPageAwardWidget.sOy), z);
        }
    }

    static /* synthetic */ void bNU() {
    }

    static /* synthetic */ void c(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        boolean z = walletSuccPageAwardWidget.pSQ.AEx == 1 || walletSuccPageAwardWidget.pSQ.AEx == 3;
        boolean z2 = walletSuccPageAwardWidget.pSQ.AEx == 2 || walletSuccPageAwardWidget.pSQ.AEx == 3;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "initScratchShakeView, canScratch: %s, canShrake: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(walletSuccPageAwardWidget.getContext(), 50);
        WalletScratchShakeView walletScratchShakeView = walletSuccPageAwardWidget.teI;
        float f = (float) fromDPToPix;
        fromDPToPix /= 2;
        x.i("MicroMsg.WalletScratchShakeView", "init canShake: %s, canScratch: %s", Boolean.valueOf(z2), Boolean.valueOf(z));
        walletScratchShakeView.tef = z;
        walletScratchShakeView.tee = z2;
        if (walletScratchShakeView.ted != null) {
            walletScratchShakeView.removeView(walletScratchShakeView.ted);
            walletScratchShakeView.ted = null;
        }
        walletScratchShakeView.ted = new b(walletScratchShakeView.getContext());
        walletScratchShakeView.addView(walletScratchShakeView.ted, new LayoutParams(-1, -1));
        b bVar = walletScratchShakeView.ted;
        x.i("MicroMsg.WalletScratchShakeView", "init inner view");
        bVar.tei = new Paint();
        bVar.tei.setAntiAlias(true);
        bVar.tei.setDither(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(bVar.getResources(), com.tencent.mm.plugin.wxpay.a.e.ukx);
        bVar.tej = new NinePatchDrawable(bVar.getResources(), new NinePatch(decodeResource, b.K(decodeResource), "shake_bg"));
        bVar.tek = new Paint();
        bVar.tek.setAntiAlias(true);
        bVar.tek.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.tek.setStyle(Style.STROKE);
        bVar.tek.setStrokeCap(Cap.ROUND);
        bVar.tek.setStrokeWidth(f);
        bVar.tel = new Paint();
        bVar.tel.setAntiAlias(true);
        bVar.tel.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.tel.setStyle(Style.FILL);
        bVar.tel.setStrokeCap(Cap.ROUND);
        bVar.tem = new Path();
        bVar.ten = new Path();
        bVar.tev = 0.0f;
        bVar.teu = 0.0f;
        bVar.nsl = ViewConfiguration.get(bVar.getContext()).getScaledTouchSlop();
        bVar.tes = false;
        bVar.tet = false;
        bVar.tew = fromDPToPix;
        if (bVar.teA.tee) {
            bVar.oTo = new com.tencent.mm.pluginsdk.k.c(bVar.getContext());
            bVar.oTo.a(new com.tencent.mm.pluginsdk.k.c.a() {
                public final void bfv() {
                    long bB = bi.bB(b.this.kIG);
                    if (b.this.tdS) {
                        if (bB < 80) {
                            return;
                        }
                    } else if (bB < 1200) {
                        return;
                    }
                    b.this.kIG = bi.Wz();
                    b.this.tdS = true;
                    b.d(b.this);
                }

                public final void onRelease() {
                }
            });
            bVar.kIG = bi.Wz();
        }
        bVar.invalidate();
        walletScratchShakeView.setClipChildren(false);
        walletSuccPageAwardWidget.teI.teg = new WalletScratchShakeView.a() {
            public final void ka(boolean z) {
                int i = 2;
                x.i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", Boolean.valueOf(z));
                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, z ? 1 : 2, false);
                com.tencent.mm.plugin.report.service.g gVar;
                Object[] objArr;
                if (z) {
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(5);
                    if (!WalletSuccPageAwardWidget.this.teM) {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    gVar.h(15225, objArr);
                } else {
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4);
                    if (!WalletSuccPageAwardWidget.this.teM) {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    gVar.h(15225, objArr);
                }
                WalletSuccPageAwardWidget.this.teN = true;
            }

            public final void bNO() {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
                if (WalletSuccPageAwardWidget.this.pSQ.AEy != 0) {
                    WalletSuccPageAwardWidget.bNU();
                }
            }
        };
    }

    public static boolean a(c cVar) {
        return cVar != null && ((cVar.wix != null && cVar.wix.size() > 0) || cVar.AEB != null);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        v.fw(context).inflate(com.tencent.mm.plugin.wxpay.a.g.uMu, this, true);
        this.teC = (ViewGroup) findViewById(f.bYQ);
        this.tbn = (CdnImageView) findViewById(f.usu);
        this.ipR = (TextView) findViewById(f.cyG);
        this.jbl = (TextView) findViewById(f.caU);
        this.kHH = (Button) findViewById(f.button);
        this.teI = (WalletScratchShakeView) findViewById(f.uCO);
        this.teG = (ImageView) findViewById(f.background);
        this.teJ = (WalletAwardShakeAnimView) findViewById(f.uCY);
        this.tbn.vtN = true;
        this.tbn.vtO = true;
    }

    public final void a(WalletBaseUI walletBaseUI, c cVar, String str, boolean z, ImageView imageView) {
        boolean z2 = true;
        String str2 = "MicroMsg.WalletSuccPageAwardWidget";
        String str3 = "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s";
        Object[] objArr = new Object[5];
        objArr[0] = b(cVar);
        boolean z3 = cVar == null || cVar.AEz == null;
        objArr[1] = Boolean.valueOf(z3);
        if (imageView != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(this.teM);
        objArr[4] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        this.teL = walletBaseUI;
        this.pSQ = cVar;
        this.sOy = z;
        this.lnQ = str;
        this.teH = imageView;
        bNR();
    }

    private void bNR() {
        int i = 2;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", b(this.pSQ), Boolean.valueOf(this.qeI));
        if (this.pSQ == null) {
            x.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
            return;
        }
        x.k("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", Integer.valueOf(this.pSQ.AEx), Integer.valueOf(this.pSQ.wix.size()), Boolean.valueOf(this.teM));
        if (this.pSQ.AEx > 0 && this.pSQ.AEx <= 5 && a(this.pSQ)) {
            if (this.pSQ.AEx == 4) {
                bNT();
                if (this.teI.getVisibility() != 8) {
                    this.teI.setVisibility(8);
                    this.teI.onDestroy();
                }
                if (this.teJ.getVisibility() != 8) {
                    this.teJ.setVisibility(8);
                    this.teJ.destroy();
                }
            } else if (this.pSQ.AEx == 1 || this.pSQ.AEx == 2 || this.pSQ.AEx == 3) {
                bNT();
                if (this.teJ.getVisibility() != 8) {
                    this.teJ.setVisibility(8);
                    this.teJ.destroy();
                }
                if (this.teI.getVisibility() != 0) {
                    this.teI.setVisibility(0);
                    this.teI.post(new Runnable() {
                        public final void run() {
                            if (WalletSuccPageAwardWidget.this.teI.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletSuccPageAwardWidget.this.teI.getLayoutParams();
                                layoutParams.width = WalletSuccPageAwardWidget.this.teC.getWidth();
                                layoutParams.height = WalletSuccPageAwardWidget.this.teC.getHeight();
                                WalletSuccPageAwardWidget.this.teI.setLayoutParams(layoutParams);
                            }
                            WalletSuccPageAwardWidget.c(WalletSuccPageAwardWidget.this);
                        }
                    });
                }
            } else if (this.pSQ.AEx == 5) {
                bNT();
                if (this.teI.getVisibility() != 8) {
                    this.teI.setVisibility(8);
                    this.teI.onDestroy();
                }
                if (this.pSQ.AEB != null) {
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", Integer.valueOf(this.pSQ.AEB.wZw));
                    switch (this.pSQ.AEB.wZw) {
                        case 1:
                            if (this.teJ.getVisibility() != 0) {
                                this.teJ.setVisibility(0);
                                this.teJ.post(new Runnable() {
                                    public final void run() {
                                        if (WalletSuccPageAwardWidget.this.teJ.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletSuccPageAwardWidget.this.teJ.getLayoutParams();
                                            layoutParams.width = WalletSuccPageAwardWidget.this.teC.getWidth();
                                            layoutParams.height = WalletSuccPageAwardWidget.this.teC.getHeight() - com.tencent.mm.bu.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2);
                                            layoutParams.topMargin = com.tencent.mm.bu.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                                            layoutParams.bottomMargin = com.tencent.mm.bu.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                                            WalletSuccPageAwardWidget.this.teJ.setLayoutParams(layoutParams);
                                        }
                                    }
                                });
                            }
                            this.teJ.destroy();
                            if (!bi.oN(this.pSQ.AEB.AEs)) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", this.pSQ.AEB.AEs);
                                this.teJ.NZ(this.pSQ.AEB.AEs);
                            }
                            if (!bi.oN(this.pSQ.AEB.AEt)) {
                                try {
                                    x.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", this.pSQ.AEB.AEt);
                                    this.teJ.zL(Color.parseColor(this.pSQ.AEB.AEt));
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse animation_wording_color %s error %s", this.pSQ.AEB.AEt, e.getMessage());
                                }
                            }
                            if (!bi.oN(this.pSQ.AEB.AEu)) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", this.pSQ.AEB.AEu);
                                this.teJ.tdW = this.pSQ.AEB.AEu;
                            }
                            if (!bi.oN(this.pSQ.AEB.AEv)) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", this.pSQ.AEB.AEv);
                                try {
                                    this.teJ.tdX = Color.parseColor(this.pSQ.AEB.AEv);
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse after_animation_wording_color %s error %s", this.pSQ.AEB.AEv, e2.getMessage());
                                }
                            }
                            this.teJ.tdZ = new WalletAwardShakeAnimView.a() {
                                public final void jZ(boolean z) {
                                    x.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", Boolean.valueOf(z), Boolean.valueOf(WalletSuccPageAwardWidget.this.teM));
                                    com.tencent.mm.plugin.report.service.g gVar;
                                    Object[] objArr;
                                    if (z) {
                                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                        objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(4);
                                        objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.teM ? 2 : 1);
                                        gVar.h(15225, objArr);
                                    } else {
                                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                        objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(7);
                                        objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.teM ? 2 : 1);
                                        gVar.h(15225, objArr);
                                    }
                                    WalletSuccPageAwardWidget.this.teJ.NZ(WalletSuccPageAwardWidget.this.getContext().getString(i.vdx));
                                    WalletSuccPageAwardWidget.this.teJ.zL(Color.parseColor("#9C9C9C"));
                                    WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                                    WalletSuccPageAwardWidget.this.teN = true;
                                }
                            };
                            WalletAwardShakeAnimView walletAwardShakeAnimView = this.teJ;
                            x.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
                            walletAwardShakeAnimView.oTo = new com.tencent.mm.pluginsdk.k.c(walletAwardShakeAnimView.getContext());
                            walletAwardShakeAnimView.oTo.a(new com.tencent.mm.pluginsdk.k.c.a() {
                                public final void bfv() {
                                    x.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
                                    long bB = bi.bB(WalletAwardShakeAnimView.this.kIG);
                                    if (WalletAwardShakeAnimView.this.tdS) {
                                        if (bB < 80) {
                                            return;
                                        }
                                    } else if (bB < 1200) {
                                        return;
                                    }
                                    WalletAwardShakeAnimView.this.kIG = bi.Wz();
                                    WalletAwardShakeAnimView.this.tdS = true;
                                    if (!WalletAwardShakeAnimView.this.tdT) {
                                        WalletAwardShakeAnimView.this.tdT = true;
                                        WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
                                    }
                                }

                                public final void onRelease() {
                                }
                            });
                            walletAwardShakeAnimView.kIG = bi.Wz();
                            walletAwardShakeAnimView.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    if (!WalletAwardShakeAnimView.this.tdT) {
                                        WalletAwardShakeAnimView.this.tdT = true;
                                        as.H(WalletAwardShakeAnimView.this.getContext(), i.ePm);
                                        WalletAwardShakeAnimView.this.bNN();
                                        if (WalletAwardShakeAnimView.this.tdZ != null) {
                                            WalletAwardShakeAnimView.this.tdZ.jZ(false);
                                        }
                                    }
                                }
                            });
                            ah.K(walletAwardShakeAnimView.tea);
                            ah.h(walletAwardShakeAnimView.tea, 3000);
                            break;
                        case 2:
                            d.a.a.f fVar = this.pSQ.AEB.AEr;
                            if (fVar != null) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", fVar.wKS, fVar.wKT, Integer.valueOf(fVar.wKU));
                                b qrVar = new qr();
                                qrVar.fJd.userName = fVar.wKS;
                                qrVar.fJd.fJf = bi.aD(fVar.wKT, "");
                                qrVar.fJd.scene = 1060;
                                qrVar.fJd.foi = this.lnQ;
                                qrVar.fJd.fJg = 0;
                                if (fVar.wKU > 0) {
                                    qrVar.fJd.fJh = fVar.wKU;
                                }
                                qrVar.fJd.context = this.teL;
                                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                                this.teM = true;
                                break;
                            }
                            break;
                        case 3:
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", this.pSQ.AEB.url);
                            com.tencent.mm.wallet_core.ui.e.l(this.teL, this.pSQ.AEB.url, false);
                            this.teM = true;
                            break;
                        case 4:
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
                            this.teI.setVisibility(8);
                            this.teI.onDestroy();
                            break;
                        default:
                            this.teJ.setVisibility(8);
                            this.teJ.destroy();
                            break;
                    }
                }
                this.teJ.setVisibility(8);
                this.teJ.destroy();
            }
            if (this.qeI || this.teM) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(3);
                if (!this.teM) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                gVar.h(15225, objArr);
            }
            this.qeI = false;
        }
    }

    private void bNS() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ipR.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jbl.getLayoutParams();
        layoutParams.addRule(15, -1);
        layoutParams2.addRule(15, 0);
        this.ipR.setLayoutParams(layoutParams);
        this.jbl.setLayoutParams(layoutParams2);
        this.ipR.setVisibility(0);
        this.jbl.setVisibility(8);
        this.ipR.setText(i.vdw);
        this.ipR.setTextColor(Color.parseColor("#353535"));
        this.jbl.setTextColor(Color.parseColor("#B2B2B2"));
        this.teG.setVisibility(8);
        findViewById(f.uyI).setVisibility(0);
        findViewById(f.uyJ).setVisibility(0);
        this.kHH.setVisibility(8);
        this.tbn.setVisibility(0);
        this.tbn.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ukv);
        this.teI.setVisibility(8);
        this.teI.onDestroy();
        this.teJ.setVisibility(8);
        this.teJ.destroy();
    }

    public final void init() {
        if (this.teL != null) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "init");
            this.teL.jl(1859);
            this.teL.jl(2547);
            this.teL.jl(2803);
            this.teL.jl(2508);
            this.teL.jl(2529);
            this.teL.jl(2888);
        }
    }

    public final void onDestroy() {
        int i = 2;
        if (this.teL != null) {
            this.teL.jm(1859);
            this.teL.jm(2547);
            this.teL.jm(2803);
            this.teL.jm(2508);
            this.teL.jm(2529);
            this.teL.jm(2888);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", Boolean.valueOf(this.teN), Boolean.valueOf(this.teO));
            if (!(this.teN || this.teO)) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(6);
                if (!this.teM) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                gVar.h(15225, objArr);
                x.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
                this.teL.b(new com.tencent.mm.plugin.wallet_core.c.g(this.pSQ.wgE, 4, this.sOy), false);
            }
        }
        if (this.teI != null) {
            this.teI.onDestroy();
        }
        if (this.teJ != null) {
            this.teJ.destroy();
        }
    }

    public final void onResume() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s", Boolean.valueOf(this.teM), b(this.pSQ));
        if (!(this.pSQ.AEB == null || this.pSQ.AEB.wZw == 1)) {
            this.teI.setVisibility(8);
            this.teI.onDestroy();
            this.teJ.setVisibility(8);
            this.teJ.destroy();
        }
        x.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", Boolean.valueOf(this.teM));
        if (this.teM) {
            this.teL.b(new j(this.pSQ.wiw, this.sOy), false);
        }
    }

    private static String Oa(String str) {
        if (bi.G(new String[0])) {
            return null;
        }
        FileOp.ml(teQ);
        x.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", str, teQ + com.tencent.xweb.util.c.s(str.getBytes()));
        return teQ + com.tencent.xweb.util.c.s(str.getBytes());
    }

    private void bNT() {
        com.tencent.mm.ap.a.a.c.a aVar;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
        List list = this.pSQ.wix;
        String str = "MicroMsg.WalletSuccPageAwardWidget";
        String str2 = "singleExposureInfoList %s, size: %s";
        Object[] objArr = new Object[2];
        objArr[0] = list;
        objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
        x.i(str, str2, objArr);
        if (list != null && list.size() > 0) {
            boolean z;
            this.teK = (g) list.get(0);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", Integer.valueOf(0), this.teK.AEL, this.teK.AEM, this.teK.pkG);
            this.tbn.setUrl(this.teK.pkG);
            if (!bi.oN(this.teK.pkG)) {
                this.tbn.setVisibility(0);
            }
            if (bi.oN(this.teK.AEL)) {
                z = false;
            } else {
                this.ipR.setText(this.teK.AEL);
                this.ipR.setVisibility(0);
                try {
                    if (!bi.oN(this.teK.AEO)) {
                        this.ipR.setTextColor(Color.parseColor(this.teK.AEO));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse award_name_color error: %s", e.getMessage());
                }
                z = true;
            }
            if (!bi.oN(this.teK.AEM)) {
                this.jbl.setText(this.teK.AEM);
                this.jbl.setVisibility(0);
                try {
                    if (!bi.oN(this.teK.AEP)) {
                        this.jbl.setTextColor(Color.parseColor(this.teK.AEP));
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse award_description_color error: %s", e2.getMessage());
                }
                z = true;
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ipR.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jbl.getLayoutParams();
                if (!bi.oN(this.teK.AEL) && bi.oN(this.teK.AEM)) {
                    layoutParams.addRule(15, -1);
                    layoutParams2.addRule(15, 0);
                    this.ipR.setLayoutParams(layoutParams);
                    this.jbl.setLayoutParams(layoutParams2);
                    this.ipR.setVisibility(0);
                    this.jbl.setVisibility(8);
                } else if (!bi.oN(this.teK.AEL) || bi.oN(this.teK.AEM)) {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, 0);
                    this.ipR.setLayoutParams(layoutParams);
                    this.jbl.setLayoutParams(layoutParams2);
                    this.ipR.setVisibility(0);
                    this.jbl.setVisibility(0);
                } else {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, -1);
                    this.ipR.setLayoutParams(layoutParams);
                    this.jbl.setLayoutParams(layoutParams2);
                    this.ipR.setVisibility(8);
                    this.jbl.setVisibility(0);
                }
            }
            if (bi.oN(this.teK.AEN)) {
                this.teG.setVisibility(8);
                findViewById(f.uyI).setVisibility(0);
                findViewById(f.uyJ).setVisibility(0);
            } else {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", this.teK.AEN);
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFl = true;
                aVar.hFk = true;
                aVar.hFn = Oa(this.teK.AEN);
                o.PG().a(this.teK.AEN, null, aVar.PQ(), new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", str, bitmap);
                        if (bitmap != null && WalletSuccPageAwardWidget.this.teK != null && !bi.oN(WalletSuccPageAwardWidget.this.teK.AEN) && WalletSuccPageAwardWidget.this.teK.AEN.equals(str)) {
                            final NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(WalletSuccPageAwardWidget.this.getResources(), new NinePatch(bitmap, WalletSuccPageAwardWidget.L(bitmap), "widget_bg"));
                            ah.y(new Runnable() {
                                public final void run() {
                                    WalletSuccPageAwardWidget.this.teG.setImageDrawable(ninePatchDrawable);
                                    WalletSuccPageAwardWidget.this.teG.setVisibility(0);
                                    WalletSuccPageAwardWidget.this.teG.post(new Runnable() {
                                        public final void run() {
                                            LayoutParams layoutParams = WalletSuccPageAwardWidget.this.teG.getLayoutParams();
                                            layoutParams.height = WalletSuccPageAwardWidget.this.teC.getHeight();
                                            layoutParams.width = WalletSuccPageAwardWidget.this.teC.getWidth();
                                            WalletSuccPageAwardWidget.this.teG.setLayoutParams(layoutParams);
                                            WalletSuccPageAwardWidget.this.findViewById(f.uyI).setVisibility(8);
                                            WalletSuccPageAwardWidget.this.findViewById(f.uyJ).setVisibility(8);
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        }
        String str3 = "MicroMsg.WalletSuccPageAwardWidget";
        str = "is_show_btn: %s, btn_info: %s, btn_words: %s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.pSQ.wiy);
        objArr2[1] = this.pSQ.wiz;
        objArr2[2] = this.pSQ.wiz != null ? this.pSQ.wiz.AEo : "";
        x.i(str3, str, objArr2);
        if (this.pSQ.wiy == 0 || this.pSQ.wiz == null || bi.oN(this.pSQ.wiz.AEo)) {
            this.kHH.setVisibility(8);
        } else {
            a aVar2 = this.pSQ.wiz;
            if (aVar2 != null) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", aVar2.AEo, Integer.valueOf(aVar2.AEq), aVar2.AEp, aVar2.url);
                this.kHH.setText(aVar2.AEo);
                if (!bi.oN(aVar2.AEp)) {
                    Drawable drawable = getContext().getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.bAc);
                    drawable.setColorFilter(Color.parseColor(aVar2.AEp), Mode.SRC);
                    this.kHH.setBackground(drawable);
                }
                this.kHH.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        int i = 2;
                        if (WalletSuccPageAwardWidget.this.pSQ != null && WalletSuccPageAwardWidget.this.pSQ.wiz != null) {
                            WalletSuccPageAwardWidget.this.teP = WalletSuccPageAwardWidget.this.pSQ.wiz;
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.teP.AEq));
                            if (WalletSuccPageAwardWidget.this.teP.AEq == 1) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.teP.AEq), WalletSuccPageAwardWidget.this.teP.url);
                                com.tencent.mm.wallet_core.ui.e.l(WalletSuccPageAwardWidget.this.teL, WalletSuccPageAwardWidget.this.teP.url, false);
                                WalletSuccPageAwardWidget.this.teM = true;
                                WalletSuccPageAwardWidget.this.teO = true;
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 2) {
                                d.a.a.f fVar = WalletSuccPageAwardWidget.this.teP.AEr;
                                if (fVar != null) {
                                    x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", fVar.wKS, fVar.wKT, Integer.valueOf(fVar.wKU));
                                    b qrVar = new qr();
                                    qrVar.fJd.userName = fVar.wKS;
                                    qrVar.fJd.fJf = bi.aD(fVar.wKT, "");
                                    qrVar.fJd.scene = 1060;
                                    qrVar.fJd.foi = WalletSuccPageAwardWidget.this.lnQ;
                                    qrVar.fJd.fJg = 0;
                                    if (fVar.wKU > 0) {
                                        qrVar.fJd.fJh = fVar.wKU;
                                    }
                                    qrVar.fJd.context = WalletSuccPageAwardWidget.this.teL;
                                    com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                                    WalletSuccPageAwardWidget.this.teM = true;
                                }
                                WalletSuccPageAwardWidget.this.teO = true;
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 3) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                                WalletSuccPageAwardWidget.this.teL.l(new com.tencent.mm.plugin.wallet_core.c.i(WalletSuccPageAwardWidget.this.pSQ.wiz.wtj, WalletSuccPageAwardWidget.this.sOy));
                                WalletSuccPageAwardWidget.this.teO = true;
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 5) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 6) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                                WalletSuccPageAwardWidget.this.teO = true;
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 7) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                                WalletSuccPageAwardWidget.this.teO = true;
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 8) {
                                WalletSuccPageAwardWidget.this.teL.l(new com.tencent.mm.plugin.wallet_core.c.i(WalletSuccPageAwardWidget.this.pSQ.wiz.wtj, WalletSuccPageAwardWidget.this.sOy));
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.teP.AEq), WalletSuccPageAwardWidget.this.teP.url);
                                WalletSuccPageAwardWidget.this.teO = true;
                            } else if (WalletSuccPageAwardWidget.this.teP.AEq == 9) {
                                WalletSuccPageAwardWidget.this.teL.l(new com.tencent.mm.plugin.wallet_core.c.i(WalletSuccPageAwardWidget.this.pSQ.wiz.wtj, WalletSuccPageAwardWidget.this.sOy));
                                WalletSuccPageAwardWidget.this.teO = true;
                            }
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(2);
                            if (!WalletSuccPageAwardWidget.this.teM) {
                                i = 1;
                            }
                            objArr[1] = Integer.valueOf(i);
                            gVar.h(15225, objArr);
                        }
                    }
                });
                this.kHH.setVisibility(0);
                if (this.qeI || this.teM) {
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(1);
                    objArr2[1] = Integer.valueOf(this.teM ? 2 : 1);
                    gVar.h(15225, objArr2);
                }
            }
        }
        if (this.ipR.getVisibility() == 0) {
            this.ipR.setSingleLine();
            this.ipR.post(new Runnable() {
                public final void run() {
                    try {
                        if (WalletSuccPageAwardWidget.this.kHH.getVisibility() == 0 && WalletSuccPageAwardWidget.this.ipR.getRight() > 0 && WalletSuccPageAwardWidget.this.kHH.getLeft() > 0 && WalletSuccPageAwardWidget.this.ipR.getRight() >= WalletSuccPageAwardWidget.this.kHH.getLeft() && !bi.N(WalletSuccPageAwardWidget.this.ipR.getText())) {
                            float textSize = WalletSuccPageAwardWidget.this.ipR.getTextSize();
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", Integer.valueOf(WalletSuccPageAwardWidget.this.ipR.getRight()), Integer.valueOf(WalletSuccPageAwardWidget.this.kHH.getLeft()));
                            Paint paint = new Paint();
                            paint.setTextSize(textSize);
                            String charSequence = WalletSuccPageAwardWidget.this.ipR.getText().toString();
                            float left = (float) (WalletSuccPageAwardWidget.this.kHH.getLeft() - WalletSuccPageAwardWidget.this.ipR.getLeft());
                            int i = 1;
                            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                                i++;
                            }
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                            CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                            if (charSequence.length() > 9 && substring.length() < 9) {
                                substring = charSequence.substring(0, 9);
                            }
                            WalletSuccPageAwardWidget.this.ipR.setText(substring);
                            WalletSuccPageAwardWidget.this.ipR.append("...");
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "calc nameTv len error: %s", e.getMessage());
                    }
                }
            });
        }
        if (this.kHH.getVisibility() != 0) {
            this.ipR.setEllipsize(TruncateAt.END);
        }
        if (this.pSQ.AEy != 0) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", Integer.valueOf(this.pSQ.AEy));
        }
        if (!bi.oN(this.pSQ.AEA)) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", this.pSQ.AEA);
            if (this.teH != null) {
                this.teH.setVisibility(0);
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFl = true;
                aVar.hFk = true;
                aVar.hFn = Oa(this.pSQ.AEA);
                o.PG().a(this.pSQ.AEA, null, aVar.PQ(), new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, final Bitmap bitmap, Object... objArr) {
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", str, bitmap);
                        if (bitmap != null && WalletSuccPageAwardWidget.this.pSQ != null && !bi.oN(WalletSuccPageAwardWidget.this.pSQ.AEA) && WalletSuccPageAwardWidget.this.pSQ.AEA.equals(str)) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    WalletSuccPageAwardWidget.this.teH.setScaleType(ScaleType.CENTER_CROP);
                                    WalletSuccPageAwardWidget.this.teH.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        int i4;
        String str2;
        String str3;
        Object[] objArr;
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.i) {
            com.tencent.mm.plugin.wallet_core.c.i iVar = (com.tencent.mm.plugin.wallet_core.c.i) kVar;
            if (i == 0 && i2 == 0) {
                adx adx = iVar.sOD;
                if (adx == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
                    return true;
                }
                x.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", Integer.valueOf(adx.kRz), adx.kRA, adx.wpK, adx.sUS);
                if (adx.kRz != 0) {
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
                } else if (bi.oN(adx.wpK)) {
                    if (adx.sUS != null) {
                        i4 = this.pSQ.wiz != null ? this.pSQ.wiz.AEq : 0;
                        this.pSQ = adx.sUS;
                        if (!(adx.sUS.wiz == null || this.pSQ.wiz == null)) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", Integer.valueOf(adx.sUS.wiz.AEq));
                            if (adx.sUS.wiz.AEq == 4) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                                this.pSQ.wiz.AEq = i4;
                            }
                        }
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
                        bNR();
                    }
                    if (this.teP != null && this.teO) {
                        if (this.teP.AEq == 8) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
                            com.tencent.mm.wallet_core.ui.e.l(this.teL, this.teP.url, false);
                            this.teM = true;
                        } else if (this.teP.AEq == 9) {
                            d.a.a.f fVar = this.teP.AEr;
                            if (fVar != null) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", fVar.wKS, fVar.wKT, Integer.valueOf(fVar.wKU));
                                b qrVar = new qr();
                                qrVar.fJd.userName = fVar.wKS;
                                qrVar.fJd.fJf = bi.aD(fVar.wKT, "");
                                qrVar.fJd.scene = 1060;
                                qrVar.fJd.foi = this.lnQ;
                                qrVar.fJd.fJg = 0;
                                if (fVar.wKU > 0) {
                                    qrVar.fJd.fJh = fVar.wKU;
                                }
                                qrVar.fJd.context = this.teL;
                                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                                this.teM = true;
                            }
                        }
                    }
                    this.teP = null;
                    return true;
                } else {
                    Toast.makeText(getContext(), adx.wpK, 1).show();
                    return true;
                }
            }
            bNS();
            return true;
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (i == 0 && i2 == 0) {
                tq tqVar = jVar.sOF;
                if (tqVar == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s";
                objArr = new Object[6];
                objArr[0] = Integer.valueOf(tqVar.kRz);
                objArr[1] = tqVar.kRA;
                objArr[2] = tqVar.wix;
                objArr[3] = Integer.valueOf(tqVar.wiy);
                objArr[4] = tqVar.wiz;
                objArr[5] = Integer.valueOf(tqVar.wiz != null ? tqVar.wiz.AEq : 0);
                x.i(str2, str3, objArr);
                if (tqVar.kRz == 0) {
                    this.pSQ.wix = tqVar.wix;
                    this.pSQ.wiy = tqVar.wiy;
                    if (this.pSQ.wiz != null) {
                        i4 = this.pSQ.wiz.AEq;
                    } else {
                        i4 = 0;
                    }
                    if (tqVar.wiz != null) {
                        this.pSQ.wiz = tqVar.wiz;
                        if (this.pSQ.wiz != null && tqVar.wiz.AEq == 4) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                            this.pSQ.wiz.AEq = i4;
                        }
                    }
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", b(this.pSQ));
                    bNT();
                }
            }
            this.teM = false;
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.g)) {
            return false;
        } else {
            com.tencent.mm.plugin.wallet_core.c.g gVar = (com.tencent.mm.plugin.wallet_core.c.g) kVar;
            if (i == 0 && i2 == 0) {
                ry ryVar = gVar.sOx;
                if (ryVar == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(ryVar.kRz);
                objArr[1] = ryVar.kRA;
                objArr[2] = ryVar.sUS;
                objArr[3] = ryVar.sUS != null ? ryVar.sUS.wix : "";
                x.i(str2, str3, objArr);
                if (ryVar.sUS == null || ryVar.sUS.wix == null || ryVar.sUS.wix.size() <= 0) {
                    bNS();
                } else {
                    str2 = "MicroMsg.WalletSuccPageAwardWidget";
                    str3 = "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s";
                    objArr = new Object[3];
                    objArr[0] = ryVar.sUS;
                    objArr[1] = ryVar.sUS.wiz;
                    if (ryVar.sUS.wiz != null) {
                        i4 = ryVar.sUS.wiz.AEq;
                    } else {
                        i4 = 0;
                    }
                    objArr[2] = Integer.valueOf(i4);
                    x.i(str2, str3, objArr);
                    if (this.pSQ.wiz != null) {
                        i3 = this.pSQ.wiz.AEq;
                    }
                    this.pSQ = ryVar.sUS;
                    if (!(this.pSQ.wiz == null || ryVar.sUS.wiz == null || ryVar.sUS.wiz.AEq != 4)) {
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                        this.pSQ.wiz.AEq = i3;
                    }
                    bNR();
                }
            } else {
                bNS();
            }
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.teI.getVisibility() == 0) {
            if (this.teI != null) {
                WalletScratchShakeView walletScratchShakeView = this.teI;
                if (walletScratchShakeView.ted != null ? walletScratchShakeView.ted.E(motionEvent) : false) {
                    walletScratchShakeView = this.teI;
                } else {
                    walletScratchShakeView = this.teI;
                }
                if (!(walletScratchShakeView.ted != null ? walletScratchShakeView.ted.tey : true)) {
                    z = this.teI.dispatchTouchEvent(motionEvent);
                }
            }
            if (!(this.teC == null || z)) {
                return this.teC.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private static String b(c cVar) {
        if (cVar == null) {
            return "";
        }
        try {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (cVar.wix != null && cVar.wix.size() > 0) {
                Iterator it = cVar.wix.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("logo", gVar.pkG);
                    jSONObject3.put("award_name", gVar.AEL);
                    jSONObject3.put("award_description", gVar.AEM);
                    jSONObject3.put("background_img", gVar.AEN);
                    jSONObject3.put("award_name_color", gVar.AEO);
                    jSONObject3.put("award_description_color", gVar.AEP);
                    jSONArray.put(jSONObject3);
                }
            }
            jSONObject2.put("single_exposure_info_list", jSONArray);
            jSONObject2.put("is_query_others", cVar.AEw);
            jSONObject2.put("draw_lottery_params", cVar.wgE);
            jSONObject2.put("is_show_btn", cVar.wiy);
            JSONObject jSONObject4 = new JSONObject();
            if (cVar.wiz != null) {
                jSONObject4.put("btn_words", cVar.wiz.AEo);
                jSONObject4.put("btn_color", cVar.wiz.AEp);
                jSONObject4.put("btn_op_type", cVar.wiz.AEq);
                jSONObject4.put(SlookSmartClipMetaTag.TAG_TYPE_URL, cVar.wiz.url);
                jSONObject = new JSONObject();
                if (cVar.wiz.AEr != null) {
                    jSONObject.put("activity_tinyapp_username", cVar.wiz.AEr.wKS);
                    jSONObject.put("activity_tinyapp_path", cVar.wiz.AEr.wKT);
                    jSONObject.put("activity_tinyapp_version", cVar.wiz.AEr.wKU);
                }
                jSONObject4.put("mini_app_info", jSONObject);
                jSONObject4.put("get_lottery_params", cVar.wiz.wtj);
            }
            jSONObject2.put("btn_info", jSONObject4);
            jSONObject2.put("exposure_info_modify_params", cVar.wiw);
            jSONObject2.put("user_opertaion_type", cVar.AEx);
            jSONObject2.put("is_show_layer", cVar.AEy);
            jSONObject2.put("background_img_whole", cVar.AEA);
            if (cVar.AEB != null) {
                jSONObject4 = new JSONObject();
                jSONObject4.put("animation_wording", cVar.AEB.AEs);
                jSONObject4.put("animation_wording_color", cVar.AEB.AEt);
                jSONObject4.put(SlookSmartClipMetaTag.TAG_TYPE_URL, cVar.AEB.url);
                jSONObject4.put("op_type", cVar.AEB.wZw);
                jSONObject4.put("after_animation_wording", cVar.AEB.AEu);
                jSONObject4.put("after_animation_wording_color", cVar.AEB.AEv);
                jSONObject = new JSONObject();
                if (cVar.AEB.AEr != null) {
                    jSONObject.put("activity_tinyapp_username", cVar.AEB.AEr.wKS);
                    jSONObject.put("activity_tinyapp_path", cVar.AEB.AEr.wKT);
                    jSONObject.put("activity_tinyapp_version", cVar.AEB.AEr.wKU);
                }
                jSONObject4.put("mini_app_info", jSONObject);
                jSONObject2.put("draw_lottery_info", jSONObject4);
            }
            return jSONObject2.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
