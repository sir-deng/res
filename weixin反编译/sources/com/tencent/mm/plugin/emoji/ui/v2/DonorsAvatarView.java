package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int lKL;
    private int lKM;
    private int lKN;
    private int lKO;
    private LayoutParams lKP;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(0);
        this.lKL = a.eB(getContext());
        this.lKM = a.aa(getContext(), R.f.bxa);
        this.lKN = a.aa(getContext(), R.f.bup);
        this.lKO = a.aa(getContext(), R.f.bvK);
        this.lKP = new LayoutParams(this.lKM, this.lKM);
        this.lKP.leftMargin = this.lKN;
        this.lKP.rightMargin = this.lKN;
        this.mMaxCount = (this.lKL - (this.lKO * 2)) / (this.lKM + (this.lKN * 2));
        x.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", Integer.valueOf(this.mMaxCount));
    }

    public final void b(String str, LinkedList<su> linkedList) {
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                su suVar = (su) linkedList.get(i);
                if (suVar != null) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.lKP);
                    if (bi.oN(suVar.whR)) {
                        try {
                            imageView.setImageBitmap(b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        o.PG().a(suVar.whR, imageView, f.h(str, suVar.whR, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
    }
}
