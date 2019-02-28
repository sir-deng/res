package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.b;

public class MultiTalkAddMembersUI extends MultiTalkSelectContactUI {
    protected final void initView() {
        super.initView();
        this.otF.setBackgroundResource(R.e.brX);
        this.otF.setPadding(b.oNB, b.oNB, b.oNB, 0);
    }
}
