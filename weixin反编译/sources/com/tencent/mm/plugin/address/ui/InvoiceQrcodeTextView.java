package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class InvoiceQrcodeTextView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    public boolean ipA;
    private int ipC;
    public boolean ipD;
    TextView ipT;
    private OnFocusChangeListener ipj;
    private TextView ipk;
    private ImageView ipm;
    private String ipn;
    private String ipo;
    private int ipp;
    private int ipq;
    public boolean ipr;
    private int ips;
    public boolean ipt;
    private int ipu;
    private int ipv;
    private boolean ipw;
    private OnClickListener ipx;
    private String ipy;

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.ipA = false;
        this.ipn = "";
        this.ipo = "";
        this.inputType = 1;
        this.ipC = 0;
        this.gravity = 19;
        this.ipp = -1;
        this.background = -1;
        this.ipq = -1;
        this.ipr = true;
        this.ipD = true;
        this.ipt = false;
        this.ipu = 0;
        this.ipv = 100;
        this.ipw = true;
        this.ipx = new OnClickListener() {
            public final void onClick(View view) {
                if (InvoiceQrcodeTextView.this.ipm.getVisibility() == 0 && InvoiceQrcodeTextView.this.ipr && InvoiceQrcodeTextView.this.ipp != 2 && !bi.oN(InvoiceQrcodeTextView.this.getText())) {
                    InvoiceQrcodeTextView.this.ipT.setText("");
                    InvoiceQrcodeTextView.this.cl(InvoiceQrcodeTextView.this.ipT.isFocused());
                }
            }
        };
        this.ipy = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.faF, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.faK, 0);
        if (resourceId != 0) {
            this.ipn = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.faL, 0);
        if (resourceId != 0) {
            this.ipo = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.faI, 1);
        this.ipp = obtainStyledAttributes.getInteger(R.n.faM, 0);
        this.ipr = obtainStyledAttributes.getBoolean(R.n.faO, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.faG, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.faJ, 5);
        this.background = obtainStyledAttributes.getResourceId(R.n.faH, R.g.bHc);
        this.ips = obtainStyledAttributes.getResourceId(R.n.faP, -1);
        this.ipq = obtainStyledAttributes.getResourceId(R.n.faN, R.g.bHc);
        this.ipw = obtainStyledAttributes.getBoolean(R.n.faQ, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.dlY, this, true);
        this.ipT = (TextView) inflate.findViewById(R.h.coC);
        this.ipT.setTextSize(0, (float) a.aa(context, R.f.bvL));
        this.ipk = (TextView) inflate.findViewById(R.h.cSc);
        this.ipm = (ImageView) inflate.findViewById(R.h.cpP);
        this.ipm.setOnClickListener(this.ipx);
        this.ipT.setImeOptions(this.imeOptions);
        if (!bi.oN(this.ipn)) {
            this.ipT.setHint(this.ipn);
        }
        if (!bi.oN(this.ipo)) {
            this.ipk.setText(this.ipo);
        }
        Rect rect = new Rect();
        b(this.ipT, rect);
        c(this.ipT, rect);
        setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        if (this.ips != -1) {
            this.ipm.setImageResource(this.ips);
        }
        if (!this.ipw) {
            this.ipT.setSingleLine(false);
        }
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void Ya() {
        setBackgroundResource(0);
        this.ipk.setTextColor(getResources().getColor(R.e.btL));
        this.ipT.setTextColor(getResources().getColor(R.e.black));
        this.ipT.setInputType(0);
        this.ipT.clearFocus();
        this.ipT.setSingleLine(false);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.ipT.getWindowToken(), 0);
    }

    public final String getText() {
        return this.ipT.getText().toString();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.ipr = z;
        this.ipm.setEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.ipr) {
            boolean z;
            if (this.ipm.getVisibility() == 0) {
                Rect rect = new Rect();
                this.ipm.getHitRect(rect);
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
                z = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    private void cl(boolean z) {
        if (!this.ipr || bi.oN(getText())) {
            switch (this.ipp) {
                case 0:
                case 1:
                case 4:
                    this.ipm.setVisibility(8);
                    return;
                case 2:
                    this.ipm.setVisibility(0);
                    this.ipm.setContentDescription(getContext().getString(R.l.dCZ));
                    return;
                case 3:
                    this.ipm.setVisibility(0);
                    this.ipm.setContentDescription(getContext().getString(R.l.dDj));
                    return;
                default:
                    this.ipm.setVisibility(8);
                    return;
            }
        }
        this.ipm.setImageResource(R.g.bDp);
        this.ipm.setContentDescription(getContext().getString(R.l.bWi));
        switch (this.ipp) {
            case 0:
            case 1:
            case 4:
            case 5:
                if (z) {
                    this.ipm.setVisibility(0);
                    return;
                } else {
                    this.ipm.setVisibility(8);
                    return;
                }
            case 2:
                this.ipm.setVisibility(0);
                this.ipm.setContentDescription(getContext().getString(R.l.dCZ));
                return;
            case 3:
                this.ipm.setVisibility(0);
                this.ipm.setContentDescription(getContext().getString(R.l.dDj));
                return;
            default:
                this.ipm.setVisibility(8);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ipj = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.ipj != null) {
            this.ipj.onFocusChange(this, z);
        }
        x.d("MicroMsg.InvoiceEditView", "View:" + this.ipo + ", editType:" + this.ipp + " onFocusChange to " + z);
        if (this.ipt) {
            this.ipk.setEnabled(true);
        } else {
            this.ipk.setEnabled(false);
        }
        if (view == this.ipT) {
            Rect rect = new Rect();
            b(this, rect);
            if (z) {
                setBackgroundResource(R.g.bDg);
            } else {
                setBackgroundResource(R.g.bDh);
            }
            c(this, rect);
        }
        cl(z);
    }

    public final void pg(String str) {
        this.ipT.setText(str);
        this.ipy = str;
    }

    private static void b(View view, Rect rect) {
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
    }

    private static void c(View view, Rect rect) {
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
