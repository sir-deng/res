package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasterEditText extends EditText {
    private Context context;
    private ClipboardManager rHA = null;
    private int rHB = 0;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int bBC() {
        return this.rHB;
    }

    private void init() {
        this.rHA = (ClipboardManager) this.context.getSystemService("clipboard");
    }

    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        if (!(this.rHA == null || this.rHA.getText() == null || !(this.rHA.getText() instanceof String) || this.rHA.getText() == null || this.rHA.getText().length() <= 0)) {
            this.rHB += this.rHA.getText().length();
        }
        return super.onTextContextMenuItem(i);
    }
}
