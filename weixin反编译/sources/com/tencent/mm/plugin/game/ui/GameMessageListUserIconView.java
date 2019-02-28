package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.u.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    Context mContext;
    u nyK;
    private f<String, Bitmap> nyL;

    public GameMessageListUserIconView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        if (this.nyK == null) {
            this.nyK = new u(this.mContext);
        }
    }

    public final void a(t tVar, LinkedList<h> linkedList, f<String, Bitmap> fVar) {
        if (tVar == null || bi.cC(linkedList)) {
            setVisibility(8);
            return;
        }
        this.nyL = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bvs);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.bup);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setOnClickListener(this.nyK);
            addView(imageView);
        }
        for (int i = 0; i < getChildCount(); i++) {
            ImageView imageView2 = (ImageView) getChildAt(i);
            if (i < linkedList.size()) {
                imageView2.setVisibility(0);
                h hVar = (h) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (bi.oN(hVar.niP)) {
                    str = hVar.userName;
                    if (bi.oN(str)) {
                        b.a(imageView2, str);
                    } else if (this.nyL.bu(str)) {
                        bitmap = (Bitmap) this.nyL.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            d(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        d(imageView2, str);
                    }
                } else {
                    str = hVar.niP;
                    if (this.nyL.bu(str)) {
                        bitmap = (Bitmap) this.nyL.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            f(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        f(imageView2, str);
                    }
                }
                if (bi.oN(hVar.niS)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new a(tVar, hVar.niS, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    private void f(ImageView imageView, final String str) {
        e.a.a aVar = new e.a.a();
        aVar.hFj = false;
        e.aSC().a(imageView, str, aVar.aSD(), new e.b() {
            public final void a(View view, Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    GameMessageListUserIconView.this.nyL.put(str, bitmap);
                }
            }
        });
    }

    private void d(ImageView imageView, String str) {
        Bitmap i = e.aSC().i(imageView, str);
        if (i != null) {
            this.nyL.put(str, i);
        }
    }
}
