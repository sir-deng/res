package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import java.util.ArrayList;

public class GameDetailAutoScrollView extends LinearLayout {
    int lNI = 0;
    al nrk = new al(new a() {
        public final boolean uG() {
            GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
            return true;
        }
    }, true);
    ViewGroup ntA;
    TextView ntB;
    TextView ntC;
    ViewGroup ntD;
    private TextView ntE;
    private TextView ntF;
    private Animation ntG;
    private Animation ntH;
    ArrayList<String> ntz = new ArrayList();

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        if (gameDetailAutoScrollView.lNI < (gameDetailAutoScrollView.ntz.size() / 2) - 1) {
            gameDetailAutoScrollView.lNI++;
        } else {
            gameDetailAutoScrollView.lNI = 0;
        }
        String str = (String) gameDetailAutoScrollView.ntz.get((gameDetailAutoScrollView.lNI * 2) + 1);
        gameDetailAutoScrollView.ntE.setText(i.b(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.ntz.get(gameDetailAutoScrollView.lNI * 2), gameDetailAutoScrollView.ntE.getTextSize()));
        gameDetailAutoScrollView.ntF.setText(str);
        gameDetailAutoScrollView.ntA.startAnimation(gameDetailAutoScrollView.ntH);
        gameDetailAutoScrollView.ntA.setVisibility(8);
        gameDetailAutoScrollView.ntD.startAnimation(gameDetailAutoScrollView.ntG);
        gameDetailAutoScrollView.ntD.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.ntA;
        gameDetailAutoScrollView.ntA = gameDetailAutoScrollView.ntD;
        gameDetailAutoScrollView.ntD = viewGroup;
        TextView textView = gameDetailAutoScrollView.ntB;
        gameDetailAutoScrollView.ntB = gameDetailAutoScrollView.ntE;
        gameDetailAutoScrollView.ntE = textView;
        textView = gameDetailAutoScrollView.ntC;
        gameDetailAutoScrollView.ntC = gameDetailAutoScrollView.ntF;
        gameDetailAutoScrollView.ntF = textView;
    }

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ntA = (ViewGroup) LayoutInflater.from(context).inflate(R.i.djZ, this, false);
        this.ntB = (TextView) this.ntA.findViewById(R.h.ckZ);
        this.ntC = (TextView) this.ntA.findViewById(R.h.cla);
        addView(this.ntA);
        this.ntA.setVisibility(8);
        this.ntD = (ViewGroup) LayoutInflater.from(context).inflate(R.i.djZ, this, false);
        this.ntE = (TextView) this.ntD.findViewById(R.h.ckZ);
        this.ntF = (TextView) this.ntD.findViewById(R.h.cla);
        addView(this.ntD);
        this.ntD.setVisibility(8);
        this.ntG = AnimationUtils.loadAnimation(context, R.a.bqy);
        this.ntH = AnimationUtils.loadAnimation(context, R.a.bqE);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nrk.TN();
    }
}
