package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";

    static /* synthetic */ void a(LoginSmsUI loginSmsUI, String str) {
        if (!bi.oN(str)) {
            final k sVar = new s(str, 16, "", 0, "");
            as.CN().a(sVar, 0);
            loginSmsUI.getString(R.l.dGZ);
            loginSmsUI.inI = h.a((Context) loginSmsUI, loginSmsUI.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(sVar);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xXt) {
            this.jjv = 3;
            if (!bi.Wx(this.xXn).booleanValue() && bi.Wx(this.xXh).booleanValue()) {
                this.xWV.setText(II(this.xXh));
            }
            this.jTI.setVisibility(0);
            this.jTI.cpO();
            this.jTI.yjj = new OnClickListener() {
                public final void onClick(View view) {
                    h.a(LoginSmsUI.this, LoginSmsUI.this.getString(R.l.eEk) + LoginSmsUI.this.xXh, LoginSmsUI.this.getString(R.l.eEl), LoginSmsUI.this.getString(R.l.dGf), LoginSmsUI.this.getString(R.l.dEy), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LoginSmsUI.this.jTI.cpN();
                            LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.xXh);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LoginSmsUI.this.jTI.reset();
                        }
                    });
                }
            };
            this.jTI.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    if (LoginSmsUI.this.jTI.getText().toString().length() > 0) {
                        LoginSmsUI.this.xWW.setEnabled(true);
                    } else {
                        LoginSmsUI.this.xWW.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.jTI.getText().toString().length() > 0) {
                this.xWW.setEnabled(true);
            } else {
                this.xWW.setEnabled(false);
            }
            this.xWW.setVisibility(0);
            this.xWW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LoginSmsUI.this.afV();
                }
            });
        }
    }

    protected final void afV() {
        super.afV();
        if (isFinishing() || getWindow() == null) {
            x.e(TAG, "LoginHistoryUI is finishing");
        } else if (!bi.oN(this.xXh)) {
            this.xXf.hPj = this.xXh;
            aWY();
            coB();
            final k sVar = new s(this.xXh, 17, this.jTI.getText().toString().trim(), 0, "");
            as.CN().a(sVar, 0);
            getString(R.l.dGZ);
            this.inI = h.a((Context) this, getString(R.l.etS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(sVar);
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        as.CN().a((int) c.CTRL_INDEX, (e) this);
    }

    protected void onStop() {
        super.onStop();
        as.CN().b((int) c.CTRL_INDEX, (e) this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.jTI.reset();
    }
}
