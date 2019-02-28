package com.tencent.mm.plugin.card.ui.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.g;

public final class n extends h {
    public n(g gVar, MMActivity mMActivity) {
        super(gVar, mMActivity);
    }

    public final int getLayoutId() {
        return R.i.dbR;
    }

    public final boolean i(b bVar) {
        if (bVar.auj().vYx) {
            oy oyVar = bVar.auj().vYw;
            if (oyVar == null || g.Bf(oyVar.title)) {
                return true;
            }
            x.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
            return false;
        }
        x.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
        return false;
    }

    public final void d(ViewGroup viewGroup) {
        viewGroup.findViewById(R.h.bWy).setVisibility(8);
        viewGroup.findViewById(R.h.bWx).setVisibility(0);
    }

    public final void c(ViewGroup viewGroup, b bVar) {
        super.c(viewGroup, bVar);
        d(viewGroup, bVar);
    }

    final void d(final ViewGroup viewGroup, b bVar) {
        sb sbVar = bVar.aui().vZr;
        View findViewById = viewGroup.findViewById(R.h.bWA);
        if (sbVar == null || !sbVar.wgI) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        if (!g.Bf(sbVar.wgJ)) {
            ((TextView) viewGroup.findViewById(R.h.bWB)).setText(sbVar.wgJ);
            ((ImageView) viewGroup.findViewById(R.h.bWz)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Button button = (Button) viewGroup.findViewById(R.h.bWp);
                    View findViewById = viewGroup.findViewById(R.h.bWy);
                    if (button.getVisibility() != 0 || findViewById.getVisibility() != 0) {
                        if (findViewById.getVisibility() == 0) {
                            if (l.isNetworkAvailable(n.this.kgL.mController.xRr)) {
                                findViewById.setVisibility(8);
                                viewGroup.findViewById(R.h.bWx).setVisibility(0);
                            } else {
                                d.a(n.this.kgL, n.this.kgL.getString(R.l.dOp), false);
                                return;
                            }
                        }
                        n.this.lci.d(c.CARDCODEREFRESHACTION_DOREFRESH);
                    }
                }
            });
        }
    }

    public final boolean axE() {
        return false;
    }

    public final boolean axF() {
        return true;
    }

    public final void a(ViewGroup viewGroup, final b bVar) {
        am.avx().auz();
        viewGroup.findViewById(R.h.bWy).setVisibility(0);
        viewGroup.findViewById(R.h.bWx).setVisibility(8);
        final oy oyVar = bVar.auj().vYw;
        if (oyVar != null) {
            viewGroup.findViewById(R.h.bWD).setVisibility(0);
            if (!g.Bf(oyVar.title)) {
                Button button = (Button) viewGroup.findViewById(R.h.bWp);
                button.setText(oyVar.title);
                button.setVisibility(0);
                a(button, bVar);
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (!g.Bf(oyVar.vYC) && !g.Bf(oyVar.vYB)) {
                            int intExtra;
                            int intExtra2 = n.this.kgL.getIntent() != null ? n.this.kgL.getIntent().getIntExtra("key_from_scene", 3) : 3;
                            if (n.this.kgL.getIntent() != null) {
                                intExtra = n.this.kgL.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra = 0;
                            }
                            com.tencent.mm.plugin.card.b.b.a(bVar.aum(), oyVar, intExtra2, intExtra);
                            com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(20), bVar.aum(), bVar.aun(), "", oyVar.title);
                        } else if (g.Bf(oyVar.url)) {
                            d.a(n.this.kgL, n.this.kgL.getString(R.l.dQc), true);
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(n.this.kgL, l.w(oyVar.url, oyVar.vZQ), 1);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(9);
                            objArr[1] = bVar.aum();
                            objArr[2] = bVar.aun();
                            objArr[3] = "";
                            objArr[4] = oyVar.title != null ? oyVar.title : "";
                            gVar.h(11941, objArr);
                        }
                    }
                });
                if (!g.Bf(oyVar.kPB)) {
                    ((TextView) viewGroup.findViewById(R.h.bWr)).setText(oyVar.kPB);
                }
                TextView textView = (TextView) viewGroup.findViewById(R.h.bWC);
                if (g.Bf(oyVar.kPC)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setText(oyVar.kPC);
                textView.setVisibility(0);
            }
        }
    }

    public final void b(ViewGroup viewGroup, b bVar) {
        x.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        final View findViewById = viewGroup.findViewById(R.h.bWy);
        if (findViewById.getVisibility() == 0) {
            x.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(R.h.bWA);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.h.bWx);
        imageView.setVisibility(8);
        final View findViewById3 = viewGroup.findViewById(R.h.bWD);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(R.h.bWr)).setText(this.kgL.getResources().getString(R.l.dOb));
        final Button button = (Button) viewGroup.findViewById(R.h.bWp);
        button.setVisibility(0);
        a(button, bVar);
        com.tencent.mm.plugin.card.a.g avx = am.avx();
        if (bVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            avx.auz();
            k wP = am.avv().wP(bVar.aum());
            if (wP != null) {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", wP.field_card_id, wP.field_code_id);
                if (am.avv().bW(bVar.aum(), wP.field_code_id)) {
                    avx.a(bVar.aum(), wP.field_code_id, c.CARDCODEREFRESHACTION_SNAPSHOT);
                } else {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", wP.field_card_id, wP.field_code_id);
                }
            } else {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        final ViewGroup viewGroup2 = viewGroup;
        final b bVar2 = bVar;
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                findViewById.setVisibility(8);
                findViewById3.setVisibility(8);
                imageView.setVisibility(0);
                button.setVisibility(8);
                n.this.lci.d(c.CARDCODEREFRESHACTION_SNAPSHOT);
                n.this.d(viewGroup2, bVar2);
            }
        });
    }

    private void a(Button button, b bVar) {
        String str = bVar.aui().hdx;
        if (!g.Bf(str)) {
            int xu = l.xu(str);
            button.setText(this.kgL.getResources().getString(R.l.dOc));
            button.setTextColor(xu);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.kgL.getResources().getColor(R.e.brL));
            gradientDrawable.setStroke(2, xu);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
    }
}
