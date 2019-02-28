package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m extends h {
    public ImageView ufa;
    public MMPinProgressBtn ufb;
    public ImageView ufc;
    private ImageView ufd;

    public m(View view, k kVar) {
        super(view, kVar);
        this.ufa = (ImageView) view.findViewById(R.h.cPs);
        this.ufb = (MMPinProgressBtn) view.findViewById(R.h.cVq);
        this.ufc = (ImageView) view.findViewById(R.h.cVD);
        this.ufa.setImageResource(R.k.dAT);
        this.ufd = (ImageView) view.findViewById(R.h.cVl);
        this.ueF.setVisibility(8);
        this.ueA.setVisibility(8);
        this.ufd.setVisibility(8);
        this.ueE.setTag(this);
        this.ueE.setOnClickListener(this.nvF);
    }

    public final void a(b bVar, int i, int i2) {
        Bitmap bitmap;
        LayoutParams layoutParams;
        DisplayMetrics displayMetrics;
        float f;
        LayoutParams layoutParams2;
        j jVar = (j) bVar;
        Bitmap Rz = c.Rz(jVar.fwx);
        if (Rz == null && e.bO(jVar.fCV)) {
            Rz = com.tencent.mm.pluginsdk.model.c.RX(jVar.fCV);
            if (Rz != null) {
                try {
                    if (e.bO(jVar.fwx)) {
                        com.tencent.mm.loader.stub.b.deleteFile(jVar.fwx);
                    }
                    com.tencent.mm.pluginsdk.k.e.a(Rz, CompressFormat.JPEG, jVar.fwx);
                    bitmap = Rz;
                } catch (Exception e) {
                }
                if (bitmap == null) {
                    layoutParams = this.ufc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.ufc.setLayoutParams(layoutParams);
                    this.ufc.setImageBitmap(bitmap);
                    this.ufc.setBackground(null);
                } else {
                    displayMetrics = this.ufc.getResources().getDisplayMetrics();
                    f = (displayMetrics.density * 40.0f) + 0.5f;
                    layoutParams2 = this.ufc.getLayoutParams();
                    layoutParams2.width = displayMetrics.widthPixels - ((int) f);
                    layoutParams2.height = (layoutParams2.width * 52) / 68;
                    this.ufc.setLayoutParams(layoutParams2);
                }
                if (bVar.tXY) {
                    this.ufd.setVisibility(8);
                } else {
                    this.ufd.setVisibility(0);
                }
                super.a(bVar, i, i2);
            }
        }
        bitmap = Rz;
        if (bitmap == null) {
            displayMetrics = this.ufc.getResources().getDisplayMetrics();
            f = (displayMetrics.density * 40.0f) + 0.5f;
            layoutParams2 = this.ufc.getLayoutParams();
            layoutParams2.width = displayMetrics.widthPixels - ((int) f);
            layoutParams2.height = (layoutParams2.width * 52) / 68;
            this.ufc.setLayoutParams(layoutParams2);
        } else {
            layoutParams = this.ufc.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.ufc.setLayoutParams(layoutParams);
            this.ufc.setImageBitmap(bitmap);
            this.ufc.setBackground(null);
        }
        if (bVar.tXY) {
            this.ufd.setVisibility(8);
        } else {
            this.ufd.setVisibility(0);
        }
        super.a(bVar, i, i2);
    }

    public final int bYB() {
        return 6;
    }
}
