package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class v extends a {
    private ImageView fwa;
    private int kJB;
    private int kJC;
    ProgressBar lFV;
    boolean rmz;
    boolean rpf = true;
    private WindowManager rqO;

    public v(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final int bkr() {
        return g.qMV;
    }

    public final View bxG() {
        this.fwa = (ImageView) this.contentView.findViewById(f.qJV);
        this.lFV = (ProgressBar) this.contentView.findViewById(f.cEk);
        return this.contentView;
    }

    protected final void bxK() {
        if (this.contentView != null && this.fwa != null && this.lFV != null && ((p) this.rpm) != null) {
            if (this.rqO == null) {
                this.rqO = (WindowManager) this.context.getSystemService("window");
                this.kJB = this.rqO.getDefaultDisplay().getWidth();
                this.kJC = this.rqO.getDefaultDisplay().getHeight();
            }
            String str = ((p) this.rpm).rmC;
            String str2 = ((p) this.rpm).rmD;
            float f = ((p) this.rpm).height;
            float f2 = ((p) this.rpm).width;
            this.rmz = ((p) this.rpm).rmz;
            if (f != 0.0f && f2 != 0.0f && !this.rmz) {
                this.fwa.setLayoutParams(new LayoutParams((int) f2, (int) f));
            } else if (!this.rmz || f == 0.0f || f2 == 0.0f) {
                this.fwa.setLayoutParams(new LayoutParams(this.kJB, this.kJC));
            } else {
                this.fwa.setLayoutParams(new LayoutParams(this.kJB, this.kJC));
            }
            if (str2 != null && str2.length() > 0) {
                try {
                    this.fwa.setBackgroundColor(Color.parseColor(str2));
                } catch (Exception e) {
                }
            }
            if (str == null || str.length() <= 0) {
                x.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
                return;
            }
            Bitmap er = d.er("adId", str);
            if (er == null || !I(er)) {
                this.rpf = false;
                startLoading();
                d.a(str, ((p) this.rpm).rmO, new a() {
                    public final void bxM() {
                        v.this.startLoading();
                    }

                    public final void bxN() {
                        v.this.lFV.setVisibility(8);
                    }

                    public final void LD(String str) {
                        try {
                            v.this.I(BitmapFactory.decodeFile(str));
                        } catch (Throwable e) {
                            x.e("AdLandingPagePureImageComponet", "%s" + bi.i(e));
                        }
                    }
                });
                return;
            }
            x.i("AdLandingPagePureImageComponet", "loaded cached image with  " + str);
            this.rpf = true;
        }
    }

    public final void startLoading() {
        this.lFV.setVisibility(0);
    }

    public final boolean I(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            return false;
        } else if (this.fwa == null) {
            x.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            return false;
        } else if (bitmap.getWidth() == 0) {
            x.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            return false;
        } else {
            this.fwa.setImageBitmap(bitmap);
            this.lFV.setVisibility(8);
            return true;
        }
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
            x.printErrStackTrace("AdLandingPagePureImageComponet", e, "", new Object[0]);
            return false;
        }
    }
}
