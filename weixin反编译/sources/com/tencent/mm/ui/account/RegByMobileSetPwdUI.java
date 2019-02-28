package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class RegByMobileSetPwdUI extends SetPwdUI {
    private TextView qpb;
    private TextView sej;
    private String vAe = null;
    private View xZM;
    private TextView xZN;
    private boolean xZO = false;

    /* renamed from: com.tencent.mm.ui.account.RegByMobileSetPwdUI$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xYH = new int[a.cpd().length];

        static {
            try {
                xYH[a.ybe - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xYH[a.ybf - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                xYH[a.ybh - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                xYH[a.ybg - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vAe = getIntent().getStringExtra("kintent_hint");
        this.qva = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.xZO = getIntent().getBooleanExtra("from_unbind", false);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dqQ;
    }

    protected final void initView() {
        if (!this.qva) {
            cnK();
        }
        setMMTitle(R.l.eEh);
        this.qpb = (TextView) findViewById(R.h.cUx);
        this.xZM = findViewById(R.h.bIv);
        this.sej = (TextView) findViewById(R.h.cHx);
        this.xZN = (TextView) findViewById(R.h.bIB);
        if (this.vAe != null && this.vAe.length() > 0) {
            this.sej.setText(this.vAe);
        }
        if (this.xZO || !g.Do().CF()) {
            this.xZM.setVisibility(8);
        } else {
            this.xZM.setVisibility(0);
            CharSequence FZ = q.FZ();
            if (bi.oN(FZ)) {
                FZ = q.FY();
                if (x.Xi(FZ)) {
                    FZ = null;
                }
            }
            if (bi.oN(FZ)) {
                as.Hm();
                String str = (String) c.Db().get(6, null);
                as.Hm();
                String str2 = (String) c.Db().get(5, null);
                if (!bi.oN(str)) {
                    if (bi.Wx(str).booleanValue()) {
                        ap apVar = new ap();
                        str2 = "86";
                        if (str.startsWith("+")) {
                            str2 = str.replace("+", "");
                            str = ap.DK(str2);
                            if (str != null) {
                                str2 = str2.substring(str.length());
                            }
                        } else {
                            String str3 = str2;
                            str2 = str;
                            str = str3;
                        }
                        FZ = ap.formatNumber(str, str2);
                        this.xZN.setText(R.l.eMb);
                        this.qpb.setText(FZ);
                    }
                    this.sej.setText(R.l.eEj);
                } else if (bi.oN(str2)) {
                    this.xZM.setVisibility(8);
                } else {
                    this.qpb.setText(str2);
                    this.xZN.setText(R.l.eLx);
                    this.sej.setText(R.l.eEi);
                }
            } else {
                this.xZN.setText(R.l.eOd);
                this.qpb.setText(FZ);
            }
        }
        TextView textView = (TextView) findViewById(R.h.cCu);
        TextView textView2 = (TextView) findViewById(R.h.bWZ);
        EditText editText = (EditText) findViewById(R.h.cHB);
        EditText editText2 = (EditText) findViewById(R.h.cHA);
        if (!w.cfR()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        float measureText = this.xZN.getPaint().measureText(this.xZN.getText().toString());
        float measureText2 = textView.getPaint().measureText(textView.getText().toString());
        float max = Math.max(Math.max(measureText, measureText2), textView2.getPaint().measureText(textView2.getText().toString()));
        this.xZN.setWidth((int) max);
        textView.setWidth((int) max);
        textView.setWidth((int) max);
    }

    protected final String coK() {
        return ((EditText) findViewById(R.h.cHB)).getText().toString();
    }

    protected final String coL() {
        return ((EditText) findViewById(R.h.cHA)).getText().toString();
    }

    protected final void Ez(int i) {
        switch (AnonymousClass1.xYH[i - 1]) {
            case 1:
                h.h(this, R.l.eEc, R.l.eEe);
                return;
            case 2:
                h.h(this, R.l.eEd, R.l.eEe);
                return;
            case 3:
                h.h(this, R.l.eTb, R.l.eEe);
                return;
            case 4:
                h.h(this, R.l.eTd, R.l.eEe);
                return;
            default:
                return;
        }
    }

    protected final boolean s(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return o(i, i2, str);
        }
        finish();
        return true;
    }

    public final boolean coR() {
        return true;
    }
}
