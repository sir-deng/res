package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.c.h;
import com.tencent.d.a.c.i;
import com.tencent.mm.plugin.ag.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.security.Signature;
import java.security.SignatureException;

public class SoterTestUI extends MMActivity {
    private Button rYA = null;
    private Button rYB = null;
    private Button rYC = null;
    private Button rYD = null;
    private Button rYE = null;
    private Button rYF = null;
    private TextView rYG = null;
    private Button rYx = null;
    private Button rYy = null;
    private Button rYz = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rYx = (Button) findViewById(a.rYT);
        this.rYy = (Button) findViewById(a.rYO);
        this.rYz = (Button) findViewById(a.rYS);
        this.rYA = (Button) findViewById(a.rYQ);
        this.rYB = (Button) findViewById(a.rYN);
        this.rYC = (Button) findViewById(a.rYR);
        this.rYD = (Button) findViewById(a.rYP);
        this.rYE = (Button) findViewById(a.rYM);
        this.rYF = (Button) findViewById(a.rYL);
        this.rYG = (TextView) findViewById(a.rYK);
        this.rYx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.rYG.setText(com.tencent.d.b.a.cGP() ? "passed" : "not support");
            }
        });
        this.rYy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.rYG.setText(com.tencent.d.a.a.cGC().isSuccess() ? "passed" : "not support");
            }
        });
        this.rYz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.rYG.setText(com.tencent.d.a.a.cGD().isSuccess() ? "passed" : "not passed");
            }
        });
        this.rYA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h cGG = com.tencent.d.a.a.cGG();
                if (cGG == null) {
                    SoterTestUI.this.rYG.setText("not passed: no certificate");
                } else {
                    SoterTestUI.this.rYG.setText("model available: " + cGG.toString());
                }
            }
        });
        this.rYB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.rYG.setText(com.tencent.d.a.a.acc("sample_auth_key_name").isSuccess() ? "pass" : "not passed");
            }
        });
        this.rYC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SoterTestUI.this.rYG.setText(com.tencent.d.a.a.bt("sample_auth_key_name", false).isSuccess() ? "pass" : "not passed");
            }
        });
        this.rYD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h acf = com.tencent.d.a.a.acf("sample_auth_key_name");
                if (acf == null) {
                    SoterTestUI.this.rYG.setText("not passed: no certificate");
                } else {
                    SoterTestUI.this.rYG.setText("model available: " + acf.toString());
                }
            }
        });
        this.rYE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                final Signature acg = com.tencent.d.a.a.acg("sample_auth_key_name");
                if (acg != null) {
                    try {
                        acg.update("challenge".getBytes());
                        acg.sign();
                        x.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                        SoterTestUI.this.rYG.setText("not passed: signature success without fingerprint authentication");
                        return;
                    } catch (SignatureException e) {
                        x.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                        com.tencent.d.a.a.a ih = com.tencent.d.a.a.a.ih(SoterTestUI.this);
                        if (ih.isHardwareDetected() && ih.hasEnrolledFingerprints()) {
                            ih.a(new d(acg), null, new b() {
                                public final void onAuthenticationError(int i, CharSequence charSequence) {
                                    x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                                }

                                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                                    x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                                }

                                public final void bDE() {
                                    x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                                    try {
                                        acg.update("challenge".getBytes());
                                        i bP = com.tencent.d.a.a.bP(acg.sign());
                                        SoterTestUI.this.rYG.setText(bP == null ? "not pass: exception occurs" : bP.toString());
                                    } catch (SignatureException e) {
                                        x.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                                    }
                                }

                                public final void onAuthenticationFailed() {
                                    x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                                }

                                public final void aLk() {
                                    super.aLk();
                                }
                            });
                            return;
                        } else {
                            x.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                            return;
                        }
                    }
                }
                x.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.ag.a.b.rYU;
    }
}
