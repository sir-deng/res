package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class BindQQUI extends MMWizardActivity implements e {
    private String qpU = null;
    private String qpV = null;
    r tipDialog;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        as.CN().a((int) i.CTRL_BYTE, (e) this);
        as.CN().a(255, (e) this);
    }

    public void onDestroy() {
        as.CN().b((int) i.CTRL_BYTE, (e) this);
        as.CN().b(255, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dbr;
    }

    protected final void initView() {
        as.Hm();
        long longValue = new o(bi.e((Integer) c.Db().get(9, null))).longValue();
        TextView textView;
        Button button;
        if (longValue == 0) {
            setMMTitle(R.l.dMb);
            textView = (TextView) findViewById(R.h.cMi);
            textView.setVisibility(8);
            textView.setText(R.l.dMa);
            ((TextView) findViewById(R.h.cMj)).setVisibility(8);
            button = (Button) findViewById(R.h.bNF);
            button.setVisibility(0);
            button.setText(R.l.bNF);
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    MMWizardActivity.A(BindQQUI.this, new Intent(BindQQUI.this, VerifyQQUI.class));
                }
            });
            removeOptionMenu(1);
        } else {
            setMMTitle(R.l.dLZ);
            textView = (TextView) findViewById(R.h.cMi);
            textView.setVisibility(8);
            textView.setText(R.l.dLX);
            textView = (TextView) findViewById(R.h.cMj);
            textView.setVisibility(0);
            textView.setText(getString(R.l.dLY) + longValue);
            button = (Button) findViewById(R.h.bNF);
            button.setVisibility(8);
            button.setText(R.l.eoM);
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            addIconOptionMenu(1, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    l lVar = new l(BindQQUI.this.mController.xRr);
                    lVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            nVar.setHeaderTitle(R.l.dLq);
                            nVar.eT(0, R.l.eNT);
                        }
                    };
                    lVar.rQG = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Context context = BindQQUI.this;
                                    as.CN().a(new h(h.hOu), 0);
                                    context.getString(R.l.dGZ);
                                    context.tipDialog = com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eLT), true, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    lVar.bCH();
                    return false;
                }
            });
        }
        if (this.type == 1) {
            addTextOptionMenu(0, getString(R.l.dFF), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BindQQUI.this.En(1);
                    return true;
                }
            });
        } else {
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BindQQUI.this.aWY();
                    BindQQUI.this.finish();
                    return true;
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (kVar.getType() == i.CTRL_BYTE) {
            if (i == 0 && i2 == 0) {
                this.qpU = ((h) kVar).RJ();
                if (this.qpU != null && this.qpU.length() > 0) {
                    as.Hm();
                    c.Db().set(102407, this.qpU);
                }
                if (bi.oN(this.qpV)) {
                    as.CN().a(new com.tencent.mm.modelsimple.x(2), 0);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.qpV);
                MMWizardActivity.A(this, intent);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == -3) {
                x.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eNW), null, getString(R.l.eNX), getString(R.l.eNV), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindQQUI.this.getString(R.l.eNU));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bl.d.b(BindQQUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -81) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.eKN, R.l.dGZ, null);
            } else if (i2 == -82) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.eKO, R.l.dGZ, null);
            } else if (i2 == -83) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.eKL, R.l.dGZ, null);
            } else if (i2 == -84) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.eKM, R.l.dGZ, null);
            } else if (i2 == -85) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.eKK, R.l.dGZ, null);
            } else if (i2 == -86) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.eKP, R.l.dGZ, null);
            }
        } else if (kVar.getType() != 255) {
        } else {
            if (i2 == 0) {
                MMWizardActivity.A(this, new Intent(this, StartUnbindQQ.class));
            } else {
                com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eNW), null, getString(R.l.eNX), getString(R.l.eNV), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindQQUI.this.getString(R.l.eNU));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bl.d.b(BindQQUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    as.CN().a(new h(h.hOu), 0);
                    getString(R.l.dGZ);
                    this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eLT), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
