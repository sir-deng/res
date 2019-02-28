package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public String gQA = "";
    public View kTo;
    public String lXl = "";
    public Context mContext;
    public String mTitle = "";
    public c rpr;
    private int rps = -1;
    private int rpt = -1;
    private boolean rpu = false;
    private boolean rpv = false;
    public a rpw;

    public interface a {
        void bxS();

        void bxT();
    }

    public j(Context context, i iVar, String str, String str2, String str3, boolean z, boolean z2) {
        this.gQA = str;
        this.mTitle = str2;
        this.lXl = str3;
        this.mContext = context;
        this.rpu = z;
        this.rpv = z2;
        if (iVar != null && iVar.getView() != null) {
            this.rpr = new c(context);
            this.rpr.setCanceledOnTouchOutside(true);
            this.kTo = View.inflate(context, g.qMO, null);
            if (this.kTo == null) {
                x.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.kTo.findViewById(f.qHM);
            View view = iVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.rps = (int) iVar.bxO().rmT;
            this.rpt = (int) iVar.bxO().rmU;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            Object obj = (this.rps == Integer.MAX_VALUE || this.rpt == Integer.MAX_VALUE) ? null : 1;
            if (obj != null) {
                layoutParams.width = this.rps;
                layoutParams.height = this.rpt;
            }
            linearLayout.addView(view, layoutParams);
            ((TextView) this.kTo.findViewById(f.qHz)).setText(str2);
            View findViewById = this.kTo.findViewById(f.qHH);
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    j.this.rpr.cancel();
                }
            });
            View findViewById2 = this.kTo.findViewById(f.qHy);
            findViewById2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    j.this.rpr.cancel();
                }
            });
            if (!this.rpv) {
                findViewById2.setVisibility(8);
            }
            if (this.rpu) {
                findViewById.setVisibility(8);
            }
            final ImageView imageView = (ImageView) this.kTo.findViewById(f.mjl);
            imageView.setVisibility(8);
            if (!bi.oN(str3)) {
                Bitmap er = d.er("adId", str3);
                if (er != null) {
                    imageView.setImageBitmap(er);
                    imageView.setVisibility(0);
                    return;
                }
                d.a(str3, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                    }

                    public final void LD(String str) {
                        try {
                            imageView.setImageBitmap(BitmapFactory.decodeFile(str));
                            imageView.setVisibility(0);
                        } catch (Throwable e) {
                            x.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bi.i(e));
                        }
                    }
                });
            }
        }
    }

    public final void bxR() {
        if (this.rpr != null) {
            this.rpr.dismiss();
        }
    }
}
