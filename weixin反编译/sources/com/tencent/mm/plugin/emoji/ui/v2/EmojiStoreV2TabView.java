package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private int lNH;
    private int lNI = 0;
    private Bitmap lNJ;
    private LinearLayout lNK;
    private ImageView lNL;
    private MMTabView lNM;
    private MMTabView lNN;
    a lNO;
    protected OnClickListener lNP = new OnClickListener() {
        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (EmojiStoreV2TabView.this.lNO != null) {
                EmojiStoreV2TabView.this.lNO.po(intValue);
            }
        }
    };
    private Matrix mMatrix = new Matrix();

    public interface a {
        void po(int i);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.lNH = (i3 - i) / 2;
        int i5 = this.lNH;
        if (this.lNJ == null || this.lNJ.getWidth() != i5) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.lNJ == null ? -1 : this.lNJ.getWidth());
            objArr[1] = Integer.valueOf(i5);
            x.w(str, str2, objArr);
            this.lNJ = Bitmap.createBitmap(i5, com.tencent.mm.bu.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.lNJ).drawColor(getResources().getColor(R.e.buj));
            h(this.lNI, 0.0f);
            this.lNL.setImageBitmap(this.lNJ);
        }
        pn(this.lNI);
    }

    private void init() {
        this.lNK = new LinearLayout(getContext());
        this.lNK.setBackgroundResource(R.e.white);
        this.lNK.setId(R.h.cdV);
        this.lNK.setOrientation(0);
        addView(this.lNK, new LayoutParams(-1, -2));
        this.lNL = new ImageView(getContext());
        this.lNL.setImageMatrix(this.mMatrix);
        this.lNL.setScaleType(ScaleType.MATRIX);
        this.lNL.setId(R.h.cdW);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.h.cdV);
        addView(this.lNL, layoutParams);
        this.lNM = pm(0);
        this.lNM.setText(R.l.eaM);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byh));
        layoutParams.weight = 1.0f;
        this.lNK.addView(this.lNM, layoutParams);
        this.lNN = pm(1);
        this.lNN.setText(R.l.eaQ);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byh));
        layoutParams.weight = 1.0f;
        this.lNK.addView(this.lNN, layoutParams);
    }

    private MMTabView pm(int i) {
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.lNP);
        return mMTabView;
    }

    public final void h(int i, float f) {
        this.mMatrix.setTranslate(((float) this.lNH) * (((float) i) + f), 0.0f);
        this.lNL.setImageMatrix(this.mMatrix);
    }

    public final void pn(int i) {
        this.lNI = i;
        this.lNM.setTextColor(this.lNI == 0 ? getResources().getColorStateList(R.e.buj) : getResources().getColorStateList(R.e.bsX));
        this.lNN.setTextColor(this.lNI == 1 ? getResources().getColorStateList(R.e.buj) : getResources().getColorStateList(R.e.bsX));
    }

    public final void eJ(boolean z) {
        if (this.lNN != null) {
            this.lNN.me(z);
        }
    }
}
