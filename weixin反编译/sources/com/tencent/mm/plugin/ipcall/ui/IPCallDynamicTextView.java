package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ag;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView extends TextView {
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if ((IPCallDynamicTextView.this.nPs <= 0.0d || IPCallDynamicTextView.this.nPt >= IPCallDynamicTextView.this.nPu) && (IPCallDynamicTextView.this.nPs >= 0.0d || IPCallDynamicTextView.this.nPt <= IPCallDynamicTextView.this.nPu)) {
                        IPCallDynamicTextView.this.nPv = false;
                        IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.this.nPu);
                        return;
                    }
                    IPCallDynamicTextView.this.nPv = true;
                    IPCallDynamicTextView.a(IPCallDynamicTextView.this, IPCallDynamicTextView.this.nPt);
                    IPCallDynamicTextView.this.nPt = IPCallDynamicTextView.this.nPt + IPCallDynamicTextView.this.nPs;
                    IPCallDynamicTextView.this.mHandler.sendEmptyMessageDelayed(1, (long) IPCallDynamicTextView.this.nPx);
                    return;
                default:
                    return;
            }
        }
    };
    private int mHeight;
    private String mValue;
    private String nPA = "";
    private double nPs;
    private double nPt;
    private double nPu;
    private boolean nPv;
    private int nPw = 4000;
    private int nPx = 50;
    DecimalFormat nPy = new DecimalFormat("0.00");
    private String nPz = "";

    static /* synthetic */ void a(IPCallDynamicTextView iPCallDynamicTextView, double d) {
        if (d == iPCallDynamicTextView.nPu) {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.mValue);
        } else {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.nPz + iPCallDynamicTextView.nPy.format(d) + iPCallDynamicTextView.nPA);
        }
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (IPCallDynamicTextView.this.nPt != IPCallDynamicTextView.this.nPu) {
                    IPCallDynamicTextView.this.mHandler.sendEmptyMessage(1);
                }
            }
        });
    }

    public final void setValue(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            setText(str2);
            return;
        }
        try {
            this.nPt = Double.parseDouble(Dx(str));
            this.nPz = "";
            int i = 0;
            while (i < str2.length() && !Character.isDigit(str2.charAt(i))) {
                this.nPz += str2.charAt(i);
                i++;
            }
            this.nPA = "";
            i = str2.length() - 1;
            while (i > 0 && !Character.isDigit(str2.charAt(i))) {
                this.nPA += str2.charAt(i);
                i--;
            }
            try {
                this.nPu = Double.parseDouble(str2.substring(this.nPz.length(), str2.length() - this.nPA.length()));
                this.mValue = str2;
                this.nPs = (this.nPu - this.nPt) / ((double) (this.nPw / this.nPx));
                if (this.nPs == 0.0d) {
                    setText(str2);
                    return;
                }
                this.nPs = new BigDecimal(this.nPs).setScale(2, 4).doubleValue();
                if (isShown()) {
                    this.mHandler.sendEmptyMessage(1);
                }
            } catch (NumberFormatException e) {
                setText(str2);
            }
        } catch (NumberFormatException e2) {
            setText(str2);
        }
    }

    public static String Dx(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            str2 = str2 + str.charAt(i);
            i++;
        }
        String str3 = "";
        i = str.length() - 1;
        while (i > 0 && !Character.isDigit(str.charAt(i))) {
            str3 = str3 + str.charAt(i);
            i--;
        }
        return str.substring(str2.length(), str.length() - str3.length());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
    }
}
