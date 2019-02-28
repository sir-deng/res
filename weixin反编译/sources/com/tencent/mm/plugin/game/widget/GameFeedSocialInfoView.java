package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class GameFeedSocialInfoView extends LinearLayout {
    public TextView lpZ;
    public LinearLayout nDE;
    public GameSmallAvatarList nDF;
    public TextView nDG;
    public LinearLayout nDH;

    public GameFeedSocialInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nDE = (LinearLayout) findViewById(R.h.bLN);
        this.nDF = (GameSmallAvatarList) findViewById(R.h.bLO);
        this.nDG = (TextView) findViewById(R.h.bLJ);
        this.nDH = (LinearLayout) findViewById(R.h.caR);
        this.lpZ = (TextView) findViewById(R.h.caT);
    }
}
