package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean ylI;
    private boolean ylJ;
    private boolean ylK;
    private a ylL;
    a ylM;

    public interface a {
        void a(MMRadioImageButton mMRadioImageButton);

        void b(MMRadioImageButton mMRadioImageButton);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ylJ = true;
    }

    public void toggle() {
        if (!this.ylJ) {
            if (this.ylL != null) {
                this.ylL.b(this);
            }
            if (this.ylM != null) {
                this.ylM.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.ylK);
        }
    }

    public boolean performClick() {
        toggle();
        return false;
    }

    public boolean isChecked() {
        return this.ylK;
    }

    public void setChecked(boolean z) {
        if (this.ylK != z) {
            this.ylK = z;
            setSelected(this.ylK);
            refreshDrawableState();
            if (!this.ylI) {
                this.ylI = true;
                if (this.ylL != null) {
                    this.ylL.a(this);
                }
                if (this.ylM != null) {
                    this.ylM.a(this);
                }
                this.ylI = false;
            }
        }
    }
}
