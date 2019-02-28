package com.tencent.mm.ui.bindlinkedin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.as.b;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class BindLinkedInUI extends MMActivity implements e {
    private String fXv;
    private String fXw;
    private ProgressDialog laU;
    private String name;
    private boolean ppI = false;
    private TextView qrg;
    private int status;
    private String ytL;
    private boolean ytM = false;
    private boolean ytN = false;
    private boolean ytO = false;
    private Bundle ytP;
    private boolean ytQ = false;
    private boolean ytR = false;
    private TextView ytS;
    private TextView ytT;
    private View ytU;
    private MMSwitchBtn ytV;
    private TextView ytW;
    private TextView ytX;
    private String ytY;
    private String ytZ;
    private String yua;
    private String yub;

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", q.FY());
        if (bindLinkedInUI.ytO) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        d.b(bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(549, (e) this);
        as.CN().a(550, (e) this);
        this.ytP = getIntent().getBundleExtra("qrcode_bundle");
        this.ytN = this.ytP != null;
        if (this.ytP != null) {
            this.fXv = this.ytP.getString("i");
            this.fXw = this.ytP.getString("n");
            this.ytY = this.ytP.getString("t");
            this.ytZ = this.ytP.getString("o");
            this.yua = this.ytP.getString("s");
            this.yub = this.ytP.getString("r");
            if (this.fXv == null || this.fXw == null || this.ytY == null || this.yua == null || this.yub == null) {
                h.a((Context) this, getString(R.l.dVA), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        BindLinkedInUI.this.goBack();
                    }
                });
            }
        }
        this.ytO = getIntent().getBooleanExtra("oversea_entry", false);
        Xc();
        if (this.ytN) {
            this.ytM = true;
        }
        initView();
        if (this.ytP != null && this.ppI && this.ytL.equals(this.fXv)) {
            this.ytQ = true;
            mH(true);
        }
    }

    protected void onDestroy() {
        as.CN().b(550, (e) this);
        as.CN().b(549, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dbk;
    }

    private void Xc() {
        boolean z = true;
        as.Hm();
        this.ytL = (String) c.Db().get(286721, null);
        this.ppI = !bi.oN(this.ytL);
        as.Hm();
        this.name = (String) c.Db().get(286722, null);
        this.status = q.Gc();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.ytM = z;
    }

    protected final void initView() {
        if (this.ytN) {
            setMMTitle(R.l.dVI);
        } else if (this.ytO) {
            setMMTitle(R.l.dVK);
        } else {
            setMMTitle(R.l.dVC);
        }
        this.ytS = (TextView) findViewById(R.h.cLZ);
        this.ytT = (TextView) findViewById(R.h.cMa);
        this.ytU = findViewById(R.h.cOq);
        this.ytV = (MMSwitchBtn) findViewById(R.h.cOp);
        this.ytW = (TextView) findViewById(R.h.bNe);
        this.ytX = (TextView) findViewById(R.h.cTL);
        this.qrg = (TextView) findViewById(R.h.bPo);
        this.ytS.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                String str = (String) c.Db().get(286723, null);
                if (!bi.oN(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", q.FY());
                    d.b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            }
        });
        this.ytW.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!BindLinkedInUI.this.ytN) {
                    BindLinkedInUI.c(BindLinkedInUI.this);
                } else if (BindLinkedInUI.this.ppI) {
                    h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.l.dVz), null, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BindLinkedInUI.this.mH(false);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    BindLinkedInUI.this.mH(false);
                }
            }
        });
        this.ytX.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.l.dVB), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final k bVar = new b();
                        BindLinkedInUI.this.laU = h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.l.ctG), false, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(bVar);
                            }
                        });
                        as.CN().a(bVar, 0);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.qrg.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BindLinkedInUI.this.goBack();
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindLinkedInUI.this.goBack();
                return true;
            }
        });
        av();
    }

    private void goBack() {
        if (!this.ytN) {
            setResult(-1);
            finish();
        } else if (this.ytR) {
            Intent at = a.ihN.at(this);
            at.addFlags(603979776);
            at.putExtra("preferred_tab", 2);
            startActivity(at);
        } else {
            setResult(-1);
            finish();
        }
    }

    private void mH(boolean z) {
        if (this.ytP == null) {
            x.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            return;
        }
        final k aVar = new com.tencent.mm.as.a(this.ytV.zEk ? 1 : 2, this.fXv, this.fXw, "", this.ytY, this.ytZ, this.yua, this.yub);
        if (!z) {
            this.laU = h.a((Context) this, getString(R.l.ctG), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(aVar);
                }
            });
        }
        as.CN().a(aVar, 0);
    }

    private void ZB(String str) {
        int indexOf = getString(R.l.dVx).indexOf("%s");
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(R.l.dVx, new Object[]{str}));
        newSpannable.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(BindLinkedInUI.this.getResources().getColor(R.e.btd));
                textPaint.setUnderlineText(false);
            }
        }, indexOf, str.length() + indexOf, 33);
        this.ytS.setText(newSpannable);
    }

    private void a(boolean z, boolean z2, String str, boolean z3) {
        this.qrg.setVisibility(8);
        if (z) {
            this.ytT.setVisibility(8);
            this.ytS.setVisibility(0);
            ZB(str);
            this.ytU.setVisibility(0);
            this.ytW.setVisibility(8);
            if (z2) {
                this.ytX.setVisibility(0);
            }
            this.ytV.nJ(z3);
            this.ytV.zEt = new MMSwitchBtn.a() {
                public final void cy(boolean z) {
                    BindLinkedInUI.this.V(z, true);
                }
            };
            return;
        }
        this.ytS.setVisibility(8);
        this.ytS.setText(getString(R.l.dVy));
        this.ytT.setVisibility(0);
        this.ytU.setVisibility(8);
        this.ytW.setVisibility(0);
        this.ytX.setVisibility(8);
    }

    private void av() {
        boolean z = true;
        if (this.ytN && this.ytP == null) {
            x.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
        } else if (this.ytO) {
            a(this.ppI, false, this.name, this.ytM);
        } else if (this.ytN) {
            if (!(this.ppI && this.ytL.equals(this.fXv))) {
                z = false;
            }
            String str = this.fXw;
            boolean z2 = this.ytM;
            this.ytS.setVisibility(0);
            ZB(str);
            this.ytU.setVisibility(0);
            this.ytX.setVisibility(8);
            if (z) {
                this.ytT.setVisibility(8);
                this.ytW.setVisibility(8);
                this.qrg.setVisibility(8);
                this.ytV.nJ(z2);
                this.ytV.zEt = new MMSwitchBtn.a() {
                    public final void cy(boolean z) {
                        BindLinkedInUI.this.V(z, true);
                    }
                };
                return;
            }
            this.ytT.setVisibility(0);
            this.ytW.setVisibility(0);
            this.qrg.setVisibility(0);
            this.ytV.nJ(z2);
            this.ytV.zEt = new MMSwitchBtn.a() {
                public final void cy(boolean z) {
                    BindLinkedInUI.this.V(z, false);
                }
            };
        } else {
            a(this.ppI, true, this.name, this.ytM);
        }
    }

    private void V(boolean z, boolean z2) {
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        as.Hm();
        c.Db().set(7, Integer.valueOf(this.status));
        if (z2) {
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = 33;
            wuVar.wnQ = i;
            as.Hm();
            c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wuVar));
            a.ihO.un();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent != null) {
            switch (i) {
                case 100:
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    String string = bundleExtra.getString("ret");
                    String string2 = bundleExtra.getString("limid");
                    String string3 = bundleExtra.getString("liname");
                    String string4 = bundleExtra.getString("liurl");
                    String string5 = bundleExtra.getString("liswitch");
                    if (bi.oN(string)) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
                        return;
                    }
                    int Wo = bi.Wo(string);
                    if (Wo != 0) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", Integer.valueOf(Wo));
                        h.b(this, getString(Wo == 1 ? R.l.dVG : R.l.dVF), null, true);
                        return;
                    } else if (bi.oN(string2)) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
                        return;
                    } else {
                        x.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", string2, string3, string4, string5);
                        as.Hm();
                        c.Db().set(286722, string3);
                        as.Hm();
                        c.Db().set(286721, string2);
                        as.Hm();
                        c.Db().set(286723, string4);
                        if (!bi.oN(string5)) {
                            V(bi.Wo(string5) == 1, false);
                        }
                        Xc();
                        av();
                        string5 = getString(R.l.dVD);
                        AnonymousClass4 anonymousClass4 = new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                            }
                        };
                        h.bu(this, string5);
                        return;
                    }
                default:
                    x.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.laU != null) {
            this.laU.dismiss();
            this.laU = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 549) {
                this.ytR = true;
                if (this.ytQ) {
                    i3 = R.l.dVE;
                } else {
                    i3 = R.l.dVD;
                }
            } else if (kVar.getType() == 550) {
                i3 = R.l.dVL;
            } else {
                return;
            }
            String string = getString(i3);
            AnonymousClass5 anonymousClass5 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.bu(this, string);
            Xc();
            this.ytM = this.ytV.zEk;
            av();
            return;
        }
        if (kVar.getType() == 549) {
            if (i2 == 1) {
                i3 = R.l.dVG;
            } else {
                i3 = R.l.dVF;
            }
        } else if (kVar.getType() == 550) {
            i3 = R.l.dVH;
        } else {
            return;
        }
        h.b(this, getString(i3), null, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
