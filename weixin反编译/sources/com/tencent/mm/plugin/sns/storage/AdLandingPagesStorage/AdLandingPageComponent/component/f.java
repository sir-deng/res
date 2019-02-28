package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends i {
    ImageView fwa;
    ProgressBar lFV;
    boolean rpf;

    public f(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private f(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.rpf = true;
    }

    public final View bxG() {
        View view = this.contentView;
        this.fwa = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qJV);
        this.lFV = (ProgressBar) view.findViewById(com.tencent.mm.plugin.sns.i.f.cEk);
        return view;
    }

    protected final int bkr() {
        return g.qMR;
    }

    protected final void bxK() {
        if (this.contentView != null && this.fwa != null && this.lFV != null && ((p) this.rpm) != null) {
            float f = ((p) this.rpm).rmP;
            float f2 = ((p) this.rpm).rmQ;
            float f3 = ((p) this.rpm).rmR;
            float f4 = ((p) this.rpm).rmS;
            String str = ((p) this.rpm).rmC;
            float f5 = ((p) this.rpm).height;
            LayoutParams layoutParams = (LayoutParams) this.fwa.getLayoutParams();
            layoutParams.width = (int) ((p) this.rpm).width;
            layoutParams.height = (int) f5;
            this.fwa.setLayoutParams(layoutParams);
            this.rpf = false;
            startLoading();
            d.a(str, ((p) this.rpm).rmO, new a() {
                public final void bxM() {
                    f.this.startLoading();
                }

                public final void bxN() {
                    f.this.lFV.setVisibility(8);
                }

                public final void LD(String str) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        f fVar = f.this;
                        if (decodeFile == null) {
                            x.e("AdLandingImageComp", "when set image the bmp is null!");
                        } else if (fVar.fwa == null) {
                            x.e("AdLandingImageComp", "when set image the imageView is null!");
                        } else if (decodeFile.getWidth() == 0) {
                            x.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                        } else {
                            fVar.fwa.setImageBitmap(decodeFile);
                            fVar.lFV.setVisibility(8);
                        }
                    } catch (Throwable e) {
                        x.e("AdLandingImageComp", "%s" + bi.i(e));
                    }
                }
            });
            this.contentView.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            iH(false);
        }
    }

    public final void startLoading() {
        this.lFV.setVisibility(0);
    }

    public final boolean T(JSONObject jSONObject) {
        if (!super.T(jSONObject)) {
            return false;
        }
        try {
            if (!this.rpf) {
                String VF = ac.VF(((p) this.rpm).rmC);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", VF);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("AdLandingImageComp", e, "", new Object[0]);
            return false;
        }
    }
}
