package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class GameMenuImageButton extends LinearLayout {
    private ImageView fwa;
    public boolean tMk;

    public interface a {
        void aQf();
    }

    public GameMenuImageButton(Context context) {
        super(context);
        ce(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ce(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ce(context);
    }

    private void ce(Context context) {
        this.fwa = new ImageView(context);
        this.fwa.setLayoutParams(new LayoutParams(com.tencent.mm.bu.a.ab(context, R.f.bxx), com.tencent.mm.bu.a.ab(context, R.f.bxx)));
        this.fwa.setScaleType(ScaleType.FIT_CENTER);
        this.fwa.setImageResource(R.g.bCG);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.tencent.mm.bu.a.ab(context, R.f.bxw), com.tencent.mm.bu.a.ab(context, R.f.bxw), 0);
        addView(this.fwa, layoutParams);
    }

    public final void a(FrameLayout frameLayout, final a aVar) {
        if (getParent() == null && frameLayout != null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.fwa != null) {
            this.fwa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.aQf();
                    }
                }
            });
        }
        this.tMk = true;
    }
}
