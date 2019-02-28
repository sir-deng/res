package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.v;

public abstract class CardDetailBaseUI extends DrawStatusBarActivity {
    private TextView jOY;
    private View jTg;
    private ImageView kVY;
    private TextView kVZ;
    ImageView kWa;
    private View kWb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTg = v.fw(this.mController.xRr).inflate(R.i.dca, null);
        this.jTg.setBackgroundColor(getResources().getColor(R.e.bre));
        this.jOY = (TextView) this.jTg.findViewById(R.h.cSp);
        this.kVZ = (TextView) this.jTg.findViewById(R.h.cPI);
        this.kVY = (ImageView) this.jTg.findViewById(R.h.bLj);
        this.kWa = (ImageView) this.jTg.findViewById(R.h.cvT);
        this.kWb = this.jTg.findViewById(R.h.divider);
        if (this.mController.contentView != null && ((ViewGroup) this.mController.contentView).getChildCount() > 0) {
            View childAt = ((ViewGroup) this.mController.contentView).getChildAt(0);
            ((ViewGroup) this.mController.contentView).removeView(childAt);
            View linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            linearLayout.addView(this.jTg, new LinearLayout.LayoutParams(-1, displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(R.f.buG) : getResources().getDimensionPixelSize(R.f.buH)));
            linearLayout.addView(childAt);
            ((ViewGroup) this.mController.contentView).addView(linearLayout);
        }
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener) {
        this.kVY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (onMenuItemClickListener != null) {
                    onMenuItemClickListener.onMenuItemClick(null);
                }
            }
        });
    }

    public final void setMMTitle(String str) {
        this.jOY.setText(str);
    }

    public final void oj(int i) {
        this.jOY.setTextColor(i);
    }

    public final void setMMSubTitle(String str) {
        this.kVZ.setText(str);
    }

    public final void B(int i, boolean z) {
        this.jTg.setBackgroundColor(i);
        if (z) {
            this.jOY.setTextColor(getResources().getColor(R.e.black));
            this.kVZ.setTextColor(getResources().getColor(R.e.black));
            this.kVY.setImageResource(R.g.bAl);
            this.kWa.setImageResource(R.g.bAs);
            this.kWb.setBackgroundColor(getResources().getColor(R.e.brh));
            return;
        }
        this.jOY.setTextColor(getResources().getColor(R.e.white));
        this.kVZ.setTextColor(getResources().getColor(R.e.white));
        this.kVY.setImageResource(R.g.byz);
        this.kWa.setImageResource(R.g.bDJ);
        this.kWb.setBackgroundColor(getResources().getColor(R.e.bsL));
    }

    public final void ee(boolean z) {
        this.kWa.setVisibility(z ? 0 : 8);
    }

    public final boolean noActionBar() {
        return false;
    }
}
