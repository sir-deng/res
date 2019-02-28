package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class l extends k {
    RelativeLayout nZt;
    View rpA;
    Button rpz;

    static /* synthetic */ void a(l lVar) {
        if (lVar.context instanceof SnsAdNativeLandingPagesUI) {
            ((SnsAdNativeLandingPagesUI) lVar.context).a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rmx, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rmu, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rmv, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rmw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rms == 1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rmt == 1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rpm).rmr == 1);
        }
        lVar.rpA.setPressed(false);
    }

    public l(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l bxV() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm;
    }

    protected final int bkr() {
        return g.qMP;
    }

    @TargetApi(17)
    protected final void bxK() {
        int i;
        this.rpa = 0;
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmT <= 0.0f || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmT >= ((float) (width * 2))) {
            i = width;
        } else {
            i = ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmS) + (((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmT) + ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmR));
        }
        this.nZt.setBackgroundColor(this.backgroundColor);
        if (bi.oN(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmp)) {
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (bi.oN(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmo) || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmm <= 0.0f) {
                boolean z = false;
            } else {
                try {
                    width = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmo);
                } catch (Throwable e) {
                    x.e("MicroMsg.Sns.AdLandingPageBtnComponent", bi.i(e));
                    width = 0;
                }
                gradientDrawable.setStroke((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmm, width);
                width = 1;
            }
            if (!bi.oN(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmn)) {
                int parseColor;
                try {
                    parseColor = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmn);
                } catch (Throwable e2) {
                    x.e("MicroMsg.Sns.AdLandingPageBtnComponent", bi.i(e2));
                    parseColor = 0;
                }
                gradientDrawable.setColor(parseColor);
                width = 1;
            }
            if (width != 0) {
                this.rpz.setBackgroundDrawable(gradientDrawable);
            }
        } else {
            d.a("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmp, false, 0, 0, new a() {
                public final void bxM() {
                }

                public final void bxN() {
                }

                @TargetApi(16)
                public final void LD(String str) {
                    try {
                        Drawable createFromPath = Drawable.createFromPath(str);
                        l.this.rpz.setBackground(createFromPath);
                        if (createFromPath != null && l.this.bxV().height > 0.0f && createFromPath.getIntrinsicHeight() > 0) {
                            l.this.rpz.setLayoutParams(new LayoutParams((int) ((l.this.bxV().height * ((float) createFromPath.getIntrinsicWidth())) / ((float) createFromPath.getIntrinsicHeight())), (int) l.this.bxV().height));
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                    }
                }
            });
        }
        this.rpz.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).title);
        d(this.rpz);
        this.rpz.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).azb);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rml != null && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rml.length() > 0) {
            try {
                this.rpz.setTextColor(Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rml));
            } catch (Exception e3) {
                x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rml);
            }
        }
        try {
            this.rpz.setTextAlignment(4);
        } catch (Exception e4) {
            x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).height > 0.0f) {
            this.rpz.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmR)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmS), (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).height));
        } else {
            this.rpz.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmR)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmS), this.rpz.getLayoutParams().height));
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmq == 1) {
            this.rpA.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmR)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmS), this.rpA.getLayoutParams().height));
            this.rpA.setVisibility(0);
            this.rpA.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    l.a(l.this);
                    return true;
                }
            });
            this.rpA.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    l.this.bxU();
                    l.this.bxW();
                }
            });
            return;
        }
        this.rpA.setVisibility(8);
    }

    protected void d(Button button) {
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                l.this.bxU();
                l.this.bxW();
            }
        });
    }

    protected final void bxW() {
        int intExtra;
        String str;
        int intExtra2;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm;
        String str2 = "";
        if (this.context instanceof Activity) {
            str2 = ac.LG(((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_rawSnsId"));
            intExtra = ((Activity) this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
            str = str2;
            intExtra2 = ((Activity) this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
        } else {
            str = str2;
            intExtra2 = 0;
            intExtra = 0;
        }
        String str3;
        SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI;
        String str4;
        String str5;
        if (lVar.fqh == 4) {
            f fVar = (f) lVar;
            str3 = fVar.kRh;
            if (this.context instanceof SnsAdNativeLandingPagesUI) {
                snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                str2 = fVar.kQr;
                str4 = (str2 == null || !snsAdNativeLandingPagesUI.rDV.containsKey(str2)) ? str3 : (String) snsAdNativeLandingPagesUI.rDV.get(str2);
            } else {
                str4 = str3;
            }
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "ext is " + str4);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", fVar.kQr);
            intent.putExtra("key_card_ext", str4);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            com.tencent.mm.bl.d.b(this.context, "card", ".ui.CardDetailUI", intent);
        } else if (lVar.fqh == 8) {
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm) instanceof j) {
                Object str52;
                Object stringExtra;
                str2 = "";
                str4 = "";
                if ((this.context instanceof Activity) && bxO().rnd == 2) {
                    str52 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                    stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                } else {
                    str52 = str2;
                    str2 = str4;
                }
                str4 = ((j) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm)).rmN;
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                j jVar = (j) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm);
                AdLandingPagesProxy.getInstance().doOpenAppBrand(jVar.username, jVar.fJf, String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[]{str52, stringExtra, str4, valueOf, Integer.valueOf(lVar.rnd), lVar.rfQ, str, Integer.valueOf(intExtra)}));
            }
        } else if (lVar.fqh == 9) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g gVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g) lVar;
            Intent intent2 = new Intent();
            intent2.putExtra("map_view_type", 1);
            intent2.putExtra("kwebmap_slat", gVar.rmb.nWe);
            intent2.putExtra("kwebmap_lng", gVar.rmb.nWf);
            intent2.putExtra("kwebmap_scale", gVar.rmb.fAq);
            intent2.putExtra("kPoiName", gVar.rmb.fEp);
            intent2.putExtra("Kwebmap_locaion", gVar.rmb.nWg);
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + gVar.rmb.nWe + ", slong " + gVar.rmb.nWf + ", " + gVar.rmb.fEp);
            com.tencent.mm.bl.d.b(this.context, "location", ".ui.RedirectUI", intent2, 2);
        } else if (lVar.fqh == 10) {
            if (c.a.vBa != null) {
                i iVar = (i) lVar;
                if (iVar.rma.size() > 1) {
                    c.a.vBa.a(this.context, iVar.rma, new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            ac.dx(l.this.context);
                        }
                    });
                } else if (iVar.rma.size() > 0) {
                    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.context, (String) iVar.rma.get(0));
                }
            }
        } else if (lVar.fqh != 11) {
            Intent intent3 = new Intent();
            str4 = lVar.rmj;
            if (!(TextUtils.isEmpty(lVar.rke) || TextUtils.isEmpty(lVar.rkf))) {
                str4 = ac.m(str4, "traceid=" + lVar.rke + "&aid=" + lVar.rkf);
            }
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", str4);
            intent3.putExtra("rawUrl", str4);
            intent3.putExtra("useJs", true);
            intent3.putExtra(Columns.TYPE, -255);
            intent3.putExtra("geta8key_scene", 2);
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rnd == 0) {
                Parcelable snsAdClick = new SnsAdClick(str, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rfQ, intExtra2, intExtra);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                intent3.putExtra("jsapiargs", bundle);
            }
            if ((this.context instanceof Activity) && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rnd == 2) {
                str3 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                str4 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                if (!bi.oN(str3)) {
                    str2 = String.valueOf(System.currentTimeMillis() / 1000);
                    str = "official_mall_%s_%s_%s_%s";
                    Object[] objArr = new Object[4];
                    if (bi.oN(str4)) {
                        str4 = "";
                    }
                    objArr[0] = str4;
                    objArr[1] = str3;
                    objArr[2] = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmN;
                    objArr[3] = str2;
                    str4 = String.format(str, objArr);
                    intent3.putExtra("prePublishId", str4);
                    intent3.putExtra("KPublisherId", str4);
                    intent3.putExtra("pay_channel", 47);
                }
            }
            com.tencent.mm.bl.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent3);
        } else if (this.context instanceof SnsAdNativeLandingPagesUI) {
            boolean z;
            snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
            s sVar = lVar.rmx;
            str2 = lVar.rmu;
            str = lVar.rmv;
            str52 = lVar.rmw;
            boolean z2 = lVar.rms == 1;
            boolean z3 = lVar.rmt == 1;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rpm).rmr == 1) {
                z = true;
            } else {
                z = false;
            }
            snsAdNativeLandingPagesUI.a(sVar, str2, str, str52, z2, z3, z);
        }
    }

    @TargetApi(17)
    public final View bxG() {
        View view = this.contentView;
        this.nZt = (RelativeLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qJK);
        this.rpz = (Button) view.findViewById(com.tencent.mm.plugin.sns.i.f.qJJ);
        this.rpA = view.findViewById(com.tencent.mm.plugin.sns.i.f.qJL);
        return view;
    }
}
