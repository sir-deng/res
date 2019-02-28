package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class GameFeedModuleTitle extends LinearLayout {
    TextView jOY;

    public GameFeedModuleTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jOY = (TextView) findViewById(R.h.cmc);
    }
}
