package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private Context context;
    private boolean nWD = false;
    private ClipboardManager rHA = null;
    int rHB = 0;
    private int rHC = 0;
    private int rHD = 0;
    private int rHE = 10;
    private float y;

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rHA = (ClipboardManager) this.context.getSystemService("clipboard");
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SnsEditText.this.rHD = charSequence.length();
                if (i2 <= 0) {
                    try {
                        if (SnsEditText.this.rHD > SnsEditText.this.rHC && i3 > 30) {
                            String substring = charSequence.toString().substring(i, i + i3);
                            if ((substring.indexOf("\n") >= 0 && i3 > 30) || i3 > 100) {
                                SnsEditText.this.rHB = SnsEditText.this.rHB + substring.length();
                                x.d("MicroMsg.SnsEditText", "parsterLen: %d %d", Integer.valueOf(substring.length()), Integer.valueOf(SnsEditText.this.rHB));
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SnsEditText", e, "", new Object[0]);
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    SnsEditText.this.rHC = charSequence.length();
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
    }

    public final int bBC() {
        return this.rHB;
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.rHE)) {
                this.nWD = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.nWD = false;
        } else if (this.nWD) {
            this.nWD = false;
            return true;
        }
        this.y = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }
}
