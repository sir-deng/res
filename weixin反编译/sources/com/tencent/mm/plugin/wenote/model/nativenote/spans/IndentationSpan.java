package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan extends Standard implements f<Integer>, g<Integer> {
    private final boolean ucb;
    private final int ucc;

    public final /* synthetic */ f bYj() {
        return new IndentationSpan(this.ucc, this.ucb);
    }

    public final /* synthetic */ Object getValue() {
        return Integer.valueOf(this.ucc);
    }

    private IndentationSpan(int i, boolean z) {
        super(i);
        this.ucc = i;
        this.ucb = z;
    }

    public int getLeadingMargin(boolean z) {
        return this.ucb ? 0 : this.ucc;
    }
}
