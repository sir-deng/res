package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.j;

public class MMVisiblePasswordEditText extends EditText {
    public String khu = "";
    final Drawable ynx = getResources().getDrawable(j.hab);
    final Drawable yny = getResources().getDrawable(j.hac);
    private boolean ynz = false;

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cpK();
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cpK();
    }

    private void cpK() {
        this.ynx.setBounds(0, 0, this.ynx.getIntrinsicWidth(), this.ynx.getIntrinsicHeight());
        this.yny.setBounds(0, 0, this.yny.getIntrinsicWidth(), this.yny.getIntrinsicHeight());
        x.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", Integer.valueOf(this.ynx.getIntrinsicWidth()), Integer.valueOf(this.ynx.getIntrinsicHeight()));
        cqC();
        setHeight(this.ynx.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.bvM) * 5));
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z = true;
                MMVisiblePasswordEditText mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
                if (mMVisiblePasswordEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - MMVisiblePasswordEditText.this.ynx.getIntrinsicWidth()))) {
                    mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
                    if (MMVisiblePasswordEditText.this.ynz) {
                        z = false;
                    }
                    mMVisiblePasswordEditText.ynz = z;
                    MMVisiblePasswordEditText.this.cqC();
                }
                return false;
            }
        });
    }

    private void cqC() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.ynz) {
            setInputType(1);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yny, getCompoundDrawables()[3]);
        } else {
            setInputType(129);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.ynx, getCompoundDrawables()[3]);
        }
        setSelection(selectionStart, selectionEnd);
    }
}
