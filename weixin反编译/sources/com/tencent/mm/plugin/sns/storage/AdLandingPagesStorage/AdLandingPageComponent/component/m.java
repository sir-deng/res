package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends a {
    CircularImageView rpC;

    public m(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final View bxL() {
        return new CircularImageView(this.context);
    }

    public final View bxG() {
        this.rpC = (CircularImageView) this.contentView;
        return this.contentView;
    }

    protected final void bxK() {
        if (this.contentView != null && this.rpC != null) {
            p pVar = (p) this.rpm;
            if (pVar != null) {
                d.a(pVar.rmC, pVar.rmO, new a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                    }

                    public final void LD(String str) {
                        try {
                            Bitmap decodeFile = BitmapFactory.decodeFile(str);
                            m mVar = m.this;
                            if (decodeFile == null) {
                                x.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                            } else if (mVar.rpC == null) {
                                x.e("AdLandingPageCircleImgComp", "when set image the img is null!");
                            } else if (decodeFile.getWidth() == 0) {
                                x.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                            } else {
                                mVar.rpC.setImageBitmap(decodeFile);
                            }
                        } catch (Throwable e) {
                            x.e("AdLandingPageCircleImgComp", "%s" + bi.i(e));
                        }
                    }
                });
            }
        }
    }
}
