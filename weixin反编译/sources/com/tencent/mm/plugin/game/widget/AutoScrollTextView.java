package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import java.util.ArrayList;

public class AutoScrollTextView extends LinearLayout {
    private int lNI = 0;
    private TextView nDg;
    private TextView nDh;
    private al nrk = new al(new a() {
        public final boolean uG() {
            AutoScrollTextView.a(AutoScrollTextView.this);
            return true;
        }
    }, true);
    private Animation ntG;
    private Animation ntH;
    private ArrayList<String> ntz = new ArrayList();

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        if (autoScrollTextView.ntz.size() >= 2) {
            CharSequence charSequence;
            if (autoScrollTextView.lNI < autoScrollTextView.ntz.size() - 1) {
                autoScrollTextView.lNI++;
                charSequence = (String) autoScrollTextView.ntz.get(autoScrollTextView.lNI);
            } else {
                autoScrollTextView.lNI = 0;
                String charSequence2 = (String) autoScrollTextView.ntz.get(autoScrollTextView.lNI);
            }
            TextView textView = autoScrollTextView.nDh;
            textView.setText(new SpannableString(i.b(autoScrollTextView.getContext(), charSequence2, textView.getTextSize())));
            autoScrollTextView.nDg.startAnimation(autoScrollTextView.ntH);
            autoScrollTextView.nDg.setVisibility(8);
            autoScrollTextView.nDh.startAnimation(autoScrollTextView.ntG);
            autoScrollTextView.nDh.setVisibility(0);
            TextView textView2 = autoScrollTextView.nDg;
            autoScrollTextView.nDg = autoScrollTextView.nDh;
            autoScrollTextView.nDh = textView2;
        }
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nDg = new TextView(context, attributeSet);
        this.nDg.setVisibility(8);
        this.nDh = new TextView(context, attributeSet);
        this.nDh.setVisibility(8);
        addView(this.nDg);
        addView(this.nDh);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.ntG = AnimationUtils.loadAnimation(context, R.a.bqy);
        this.ntH = AnimationUtils.loadAnimation(context, R.a.bqE);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nrk.TN();
    }
}
