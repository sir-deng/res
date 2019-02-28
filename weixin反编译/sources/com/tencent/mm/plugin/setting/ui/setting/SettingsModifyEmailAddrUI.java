package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class SettingsModifyEmailAddrUI extends MMActivity implements e, b {
    private ProgressDialog inI;
    private EditText qpP;
    private String qpQ;
    private String qpR;
    private TextView qpS;
    private TextView qpT;
    private String qpU = null;
    private String qpV = null;
    private boolean qpW;
    private boolean qpX;
    private boolean qpY;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        as.CN().a(138, (e) this);
        as.CN().a((int) i.CTRL_BYTE, (e) this);
        as.CN().a(256, (e) this);
        as.CN().a(108, (e) this);
        as.CN().a(255, (e) this);
        as.Hm();
        c.Db().a(this);
    }

    protected final int getLayoutId() {
        return R.i.dsn;
    }

    public void onDestroy() {
        as.CN().b(138, (e) this);
        as.CN().b((int) i.CTRL_BYTE, (e) this);
        as.CN().b(256, (e) this);
        as.CN().b(108, (e) this);
        as.CN().b(255, (e) this);
        as.Hm();
        c.Db().b(this);
        super.onDestroy();
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(t.aV(obj)), mVar);
        as.Hm();
        if (mVar != c.Db() || r0 <= 0) {
            x.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(r0), mVar);
            return;
        }
        boolean z;
        as.Hm();
        Integer num = (Integer) c.Db().get(7, null);
        as.Hm();
        this.qpQ = (String) c.Db().get(5, null);
        if (num == null || (num.intValue() & 2) == 0) {
            z = false;
        } else {
            z = true;
        }
        this.qpW = z;
        this.qpY = this.qpW;
        if (this.qpX) {
            brt();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dsn);
        this.qpP = (EditText) findViewById(R.h.cMC);
        this.qpS = (TextView) findViewById(R.h.cTK);
        this.qpT = (TextView) findViewById(R.h.cxf);
        as.Hm();
        this.qpQ = (String) c.Db().get(5, null);
        this.qpP.setText(this.qpQ);
        as.Hm();
        Integer num = (Integer) c.Db().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.qpW = z;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsModifyEmailAddrUI.this.goBack();
                return true;
            }
        });
        this.qpX = true;
        brt();
    }

    private void brt() {
        if (this.qpW) {
            this.qpS.setVisibility(0);
            this.qpS.setText(getString(R.l.eNT));
            this.qpT.setText(getString(R.l.eMd));
            this.qpT.setTextColor(getResources().getColor(R.e.brd));
            this.qpP.setEnabled(false);
            this.qpP.setFilters(new InputFilter[]{new InputFilter() {
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
                }
            }});
            this.qpS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    as.CN().a(new h(h.hOx), 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    Context context = SettingsModifyEmailAddrUI.this;
                    SettingsModifyEmailAddrUI.this.getString(R.l.dGZ);
                    settingsModifyEmailAddrUI.inI = com.tencent.mm.ui.base.h.a(context, SettingsModifyEmailAddrUI.this.getString(R.l.eNY), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    SettingsModifyEmailAddrUI.this.aWY();
                }
            });
            df(this.qpP);
        } else if (bi.oN(this.qpQ)) {
            bru();
        } else {
            this.qpS.setVisibility(0);
            this.qpS.setText(getString(R.l.eKz));
            this.qpT.setText(getString(R.l.eKy));
            this.qpT.setTextColor(getResources().getColor(R.e.btC));
            this.qpP.setEnabled(false);
            this.qpP.setFilters(new InputFilter[]{new InputFilter() {
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
                }
            }});
            this.qpS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    as.Hm();
                    final k afVar = new af((String) c.Db().get(2, null));
                    as.CN().a(afVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    Context context = SettingsModifyEmailAddrUI.this.mController.xRr;
                    SettingsModifyEmailAddrUI.this.getString(R.l.dGZ);
                    settingsModifyEmailAddrUI.inI = com.tencent.mm.ui.base.h.a(context, SettingsModifyEmailAddrUI.this.getString(R.l.eLu), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(afVar);
                        }
                    });
                    SettingsModifyEmailAddrUI.this.aWY();
                }
            });
            addTextOptionMenu(0, getString(R.l.dEQ), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    SettingsModifyEmailAddrUI.this.bru();
                    return true;
                }
            });
            df(this.qpP);
        }
    }

    private void bru() {
        this.qpS.setVisibility(8);
        this.qpS.setText(getString(R.l.eNT));
        this.qpT.setText(getString(R.l.eMd));
        this.qpT.setTextColor(getResources().getColor(R.e.brd));
        this.qpP.setEnabled(true);
        this.qpP.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return null;
            }
        }});
        addTextOptionMenu(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsModifyEmailAddrUI.this.qpR = SettingsModifyEmailAddrUI.this.qpP.getText().toString().trim();
                if (bi.VZ(SettingsModifyEmailAddrUI.this.qpR)) {
                    as.Hm();
                    Integer num = (Integer) c.Db().get(7, null);
                    boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
                    Boolean valueOf = Boolean.valueOf(z);
                    if (SettingsModifyEmailAddrUI.this.qpR.equals(SettingsModifyEmailAddrUI.this.qpQ) && valueOf.booleanValue()) {
                        SettingsModifyEmailAddrUI.this.finish();
                    } else {
                        final k aVar = new a(a.hlf, SettingsModifyEmailAddrUI.this.qpR);
                        as.CN().a(aVar, 0);
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                        Context context = SettingsModifyEmailAddrUI.this;
                        SettingsModifyEmailAddrUI.this.getString(R.l.dGZ);
                        settingsModifyEmailAddrUI.inI = com.tencent.mm.ui.base.h.a(context, SettingsModifyEmailAddrUI.this.getString(R.l.eLn), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(aVar);
                            }
                        });
                        SettingsModifyEmailAddrUI.this.aWY();
                    }
                } else {
                    com.tencent.mm.ui.base.h.h(SettingsModifyEmailAddrUI.this.mController.xRr, R.l.eSZ, R.l.dGZ);
                }
                return true;
            }
        });
    }

    private void goBack() {
        aWY();
        finish();
        if (this.qpY) {
            setResult(-1);
        } else {
            setResult(0);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (!com.tencent.mm.plugin.setting.a.ihO.a(this.mController.xRr, i, i2, str)) {
            if (kVar.getType() == i.CTRL_BYTE) {
                if (i == 0 && i2 == 0) {
                    this.qpV = ((h) kVar).RK().wdC;
                    this.qpU = ((h) kVar).RJ();
                    if (bi.oN(this.qpV)) {
                        as.CN().a(new com.tencent.mm.modelsimple.x(2), 0);
                        return;
                    }
                    as.CN().a(new a(a.hlg, this.qpP.getText().toString().trim()), 0);
                    return;
                }
                if (this.inI != null) {
                    this.inI.dismiss();
                    this.inI = null;
                }
                if (i2 == -3) {
                    x.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eNW), null, getString(R.l.eNX), getString(R.l.eNV), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.l.eNU));
                            intent.putExtra("from_unbind", true);
                            d.b(SettingsModifyEmailAddrUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKO, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKL, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKM, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKH, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            } else if (kVar.getType() == 256) {
                com.tencent.mm.plugin.setting.a.ihO.un();
                if (((a) kVar).IY() == a.hlf) {
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.ui.base.h.a(this.mController.xRr, R.l.eLt, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    if (this.inI != null) {
                        this.inI.dismiss();
                        this.inI = null;
                    }
                    if (i2 == -82) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKO, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -83) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKL, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -84) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKM, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -85) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKH, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -86) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKP, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eLs, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                } else if (((a) kVar).IY() == a.hlg) {
                    if (this.inI != null) {
                        this.inI.dismiss();
                        this.inI = null;
                    }
                    if (i == 0 && i2 == 0) {
                        as.Hm();
                        Integer valueOf = Integer.valueOf(((Integer) c.Db().get(7, null)).intValue() | 2);
                        as.Hm();
                        c.Db().set(7, valueOf);
                        if (bi.oN(this.qpV)) {
                            com.tencent.mm.ui.base.h.a(this.mController.xRr, R.l.eKI, R.l.dGZ, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            com.tencent.mm.ui.base.h.a(this.mController.xRr, this.qpV, "", getString(R.l.dCa), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                }
            } else if (kVar.getType() == 138) {
            } else {
                if (kVar.getType() == 108) {
                    if (this.inI != null) {
                        this.inI.dismiss();
                        this.inI = null;
                    }
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.ui.base.h.a(this.mController.xRr, R.l.eLt, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eLs, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (kVar.getType() != 255) {
                } else {
                    if (i2 == 0) {
                        as.CN().a(new a(a.hlg, this.qpP.getText().toString().trim()), 0);
                        return;
                    }
                    if (this.inI != null) {
                        this.inI.dismiss();
                        this.inI = null;
                    }
                    com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eNW), null, getString(R.l.eNX), getString(R.l.eNV), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.l.eNU));
                            intent.putExtra("from_unbind", true);
                            d.b(SettingsModifyEmailAddrUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.qpQ + " newEmail: " + this.qpR);
                    as.CN().a(new h(h.hOx), 0);
                    getString(R.l.dGZ);
                    this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eLT), true, new OnCancelListener() {
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
