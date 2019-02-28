package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {

    static class a implements d {
        c ooR;

        a() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ah ahVar) {
            if (bi.oN(ahVar.name)) {
                x.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
                viewGroup.setVisibility(8);
                return;
            }
            View imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.FIT_XY);
            n.h(imageView, ahVar.name);
            if (!bi.oN(ahVar.content)) {
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(ahVar.ojk));
                        if (a.this.ooR != null) {
                            f.eE(a.this.ooR.ooX, 1);
                        }
                        com.tencent.mm.wallet_core.ui.e.l(context, ahVar.content, true);
                    }
                });
            }
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            viewGroup.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ahVar.ojk));
            if (this.ooR != null) {
                f.eE(this.ooR.ooX, 0);
            }
        }
    }

    static class b implements d {
        c ooR;

        b() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ah ahVar) {
            if (!bi.oN(ahVar.name)) {
                View textView = new TextView(context);
                if (this.ooR == null || this.ooR.textColor == Integer.MIN_VALUE) {
                    textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhY));
                } else {
                    textView.setTextColor(this.ooR.textColor);
                }
                if (this.ooR == null || this.ooR.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bvt));
                } else {
                    textView.setTextSize(0, (float) this.ooR.textSize);
                }
                textView.setGravity(17);
                textView.setText(ahVar.name);
                if (!bi.oN(ahVar.content)) {
                    textView.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(ahVar.ojk));
                            if (ahVar.ojl != 1) {
                                ((com.tencent.mm.pluginsdk.g) com.tencent.mm.kernel.g.h(com.tencent.mm.pluginsdk.g.class)).a(context, ahVar.content, new l() {
                                    public final void ks(int i) {
                                        switch (i) {
                                            case -2:
                                            case 1:
                                                com.tencent.mm.wallet_core.ui.e.bx(context, ahVar.content);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                }).show();
                            } else {
                                com.tencent.mm.wallet_core.ui.e.S(context, ahVar.content);
                            }
                        }
                    });
                }
                viewGroup.addView(textView, new LayoutParams(-2, -2));
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ahVar.ojk));
            }
        }
    }

    public static final class c {
        public boolean ooW = false;
        public int ooX = 0;
        public int resourceId = 0;
        public int textColor = Integer.MIN_VALUE;
        public int textSize = Integer.MIN_VALUE;
    }

    static class e implements d {
        c ooR;

        e() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ah ahVar) {
            if (!bi.oN(ahVar.name)) {
                View inflate = LayoutInflater.from(context).inflate(com.tencent.mm.plugin.wxpay.a.g.uJj, viewGroup, true);
                TextView textView = (TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.uwg);
                ImageView imageView = (ImageView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.uwf);
                if (bi.oN(ahVar.iconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    n.h(imageView, ahVar.iconUrl);
                    imageView.setVisibility(0);
                }
                if (!(this.ooR == null || this.ooR.textColor == Integer.MIN_VALUE)) {
                    textView.setTextColor(this.ooR.textColor);
                }
                if (this.ooR == null || this.ooR.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bvt));
                } else {
                    textView.setTextSize(0, (float) this.ooR.textSize);
                }
                textView.setGravity(17);
                textView.setText(ahVar.name);
                if (!bi.oN(ahVar.content)) {
                    textView.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(ahVar.ojk));
                            if (e.this.ooR != null) {
                                f.eE(e.this.ooR.ooX, 1);
                            }
                            if (e.this.ooR != null && e.this.ooR.ooW) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(13051, Integer.valueOf(e.this.ooR.ooX), Integer.valueOf(2), "", "", "", ahVar.content, ahVar.type, "", "", Integer.valueOf(e.this.ooR.resourceId));
                            }
                            if (ahVar.type.equals("Native")) {
                                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + ahVar.content);
                                if ("weixin://festival/gotoshake".equalsIgnoreCase(ahVar.content)) {
                                    x.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                                    return;
                                }
                                return;
                            }
                            com.tencent.mm.wallet_core.ui.e.l(context, ahVar.content, true);
                        }
                    });
                }
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ahVar.ojk));
                if (this.ooR != null) {
                    f.eE(this.ooR.ooX, 0);
                }
            }
        }
    }

    interface d {
        void a(Context context, ViewGroup viewGroup, ah ahVar);
    }

    public static void a(Context context, ViewGroup viewGroup, ah ahVar, c cVar) {
        if (ahVar != null) {
            a(context, viewGroup, ahVar, cVar, ahVar.type);
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ah ahVar, c cVar, String str) {
        if (viewGroup != null && ahVar != null) {
            d eVar;
            if (ahVar.gGi == 0) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + ahVar.gGi);
                viewGroup.setVisibility(8);
            } else if (!ahVar.type.equalsIgnoreCase(str)) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + ahVar.type + ", " + str);
                viewGroup.setVisibility(8);
            } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
                eVar = new e();
                eVar.ooR = cVar;
                eVar.a(context, viewGroup, ahVar);
            } else if (str.equalsIgnoreCase("Pic")) {
                eVar = new a();
                eVar.ooR = cVar;
                eVar.a(context, viewGroup, ahVar);
            } else if (str.equalsIgnoreCase("Appid")) {
                eVar = new b();
                eVar.ooR = cVar;
                eVar.a(context, viewGroup, ahVar);
            }
        }
    }
}
