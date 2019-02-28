package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xXt) {
            this.jjv = 2;
            this.xXs.setVisibility(0);
            this.xWW.setVisibility(0);
            this.lYV.setTypeface(Typeface.DEFAULT);
            this.lYV.setTransformationMethod(new PasswordTransformationMethod());
            this.lYV.setOnEditorActionListener(new OnEditorActionListener() {
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 6 && i != 5) {
                        return false;
                    }
                    LoginPasswordUI.this.afV();
                    return true;
                }
            });
            this.lYV.setOnKeyListener(new OnKeyListener() {
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (66 != i || keyEvent.getAction() != 0) {
                        return false;
                    }
                    LoginPasswordUI.this.afV();
                    return true;
                }
            });
            this.lYV.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    if (LoginPasswordUI.this.lYV.getText().toString().length() > 0) {
                        LoginPasswordUI.this.xWW.setEnabled(true);
                    } else {
                        LoginPasswordUI.this.xWW.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.lYV.getText().toString().length() > 0) {
                this.xWW.setEnabled(true);
            } else {
                this.xWW.setEnabled(false);
            }
            this.xWW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LoginPasswordUI.this.afV();
                }
            });
            this.pXJ = getIntent().getStringExtra("auth_ticket");
            if (!bi.oN(this.pXJ)) {
                this.xWV.setText(bi.oM(f.coH()));
                this.lYV.setText(bi.oM(f.coI()));
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        LoginPasswordUI.this.afV();
                    }
                }, 500);
            }
        }
    }

    protected final void afV() {
        super.afV();
        if (isFinishing() || getWindow() == null) {
            x.e(TAG, "LoginHistoryUI is finishing");
            return;
        }
        this.xXf.xXT = this.lYV.getText().toString();
        if (this.xXf.hPj.equals("")) {
            h.h(this, R.l.eTf, R.l.etJ);
        } else if (this.xXf.xXT.equals("")) {
            h.h(this, R.l.eTc, R.l.etJ);
        } else {
            aWY();
            coB();
            final k vVar = new v(this.xXf.hPj, this.xXf.xXT, this.pXJ, 0);
            as.CN().a(vVar, 0);
            getString(R.l.dGZ);
            this.inI = h.a((Context) this, getString(R.l.etS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(vVar);
                    LoginPasswordUI.this.coC();
                }
            });
        }
    }
}
