package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class RTChattingEmojiViewTo extends RTChattingEmojiView {
    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public final void initView() {
        super.initView();
        this.vzB.gravity = 5;
        addView(this.vzy, this.vzB);
    }
}
