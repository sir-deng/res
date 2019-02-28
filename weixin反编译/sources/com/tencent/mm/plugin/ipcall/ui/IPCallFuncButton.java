package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;

public class IPCallFuncButton extends LinearLayout {
    private boolean kPO = false;
    private boolean mGx = true;
    private ImageView nQe;
    private TextView nQf;
    private Drawable nQg;
    private Drawable nQh;
    private Drawable nQi;
    private boolean nQj;
    a nQk;
    private OnTouchListener nQl = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (IPCallFuncButton.this.mGx) {
                if (motionEvent.getAction() == 0) {
                    if (IPCallFuncButton.this.nQj) {
                        if (IPCallFuncButton.this.kPO) {
                            IPCallFuncButton.this.nQe.setImageDrawable(IPCallFuncButton.this.nQg);
                            IPCallFuncButton.this.kPO = false;
                        } else {
                            IPCallFuncButton.this.nQe.setImageDrawable(IPCallFuncButton.this.nQh);
                            IPCallFuncButton.this.kPO = true;
                        }
                        if (IPCallFuncButton.this.nQk != null) {
                            IPCallFuncButton.this.nQk.gj(IPCallFuncButton.this.kPO);
                        }
                    } else if (IPCallFuncButton.this.nQh != null) {
                        IPCallFuncButton.this.nQe.setImageDrawable(IPCallFuncButton.this.nQh);
                    }
                } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !IPCallFuncButton.this.nQj) {
                    if (IPCallFuncButton.this.nQg != null) {
                        IPCallFuncButton.this.nQe.setImageDrawable(IPCallFuncButton.this.nQg);
                    }
                    if (IPCallFuncButton.this.nQk != null) {
                        IPCallFuncButton.this.nQk.gj(false);
                    }
                }
            }
            return false;
        }
    };
    private String text;

    public interface a {
        void gj(boolean z);
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.dmi, this);
        this.nQe = (ImageView) findViewById(R.h.button);
        this.nQf = (TextView) findViewById(R.h.text);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.n.fax, 0, 0);
        this.nQg = obtainStyledAttributes.getDrawable(R.n.fay);
        this.nQh = obtainStyledAttributes.getDrawable(R.n.faz);
        this.nQj = obtainStyledAttributes.getBoolean(R.n.faC, false);
        this.nQi = obtainStyledAttributes.getDrawable(R.n.faA);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.faB, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (bi.oN(this.text)) {
            this.nQf.setVisibility(8);
        } else {
            this.nQf.setText(this.text);
        }
        if (this.nQg != null) {
            this.nQe.setImageDrawable(this.nQg);
        }
        this.nQe.setClickable(true);
        this.nQe.setOnTouchListener(this.nQl);
    }

    public final boolean isChecked() {
        if (this.nQj) {
            return this.kPO;
        }
        return false;
    }

    public final void gi(boolean z) {
        if (z != this.mGx) {
            this.mGx = z;
            if (this.mGx || this.nQi == null) {
                this.nQe.setImageDrawable(this.nQg);
            } else {
                this.nQe.setImageDrawable(this.nQi);
            }
            this.kPO = false;
        }
    }

    public final void setChecked(boolean z) {
        if (z != this.kPO && this.nQj) {
            this.kPO = z;
            if (this.kPO) {
                this.nQe.setImageDrawable(this.nQh);
            } else {
                this.nQe.setImageDrawable(this.nQg);
            }
        }
    }
}
