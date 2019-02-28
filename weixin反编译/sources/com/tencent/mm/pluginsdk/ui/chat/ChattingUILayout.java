package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom vxY;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ChatFooterBottom i(ViewGroup viewGroup) {
        if (this.vxY != null) {
            return this.vxY;
        }
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return this.vxY;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return this.vxY;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ChatFooterBottom) {
                this.vxY = (ChatFooterBottom) childAt;
                return this.vxY;
            } else if ((childAt instanceof ViewGroup) && i((ViewGroup) childAt) != null) {
                return this.vxY;
            } else {
                i = i2 + 1;
            }
        }
    }

    protected final List<View> aYz() {
        List<View> arrayList = new ArrayList();
        arrayList.add(i(this));
        return arrayList;
    }
}
