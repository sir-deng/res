package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.wcdb.FileUtils;

public class BindMContactIntroUI extends MMWizardActivity implements e {
    private String fBa;
    private boolean ksj = false;
    private String qpU = null;
    private String qpV = null;
    private r tipDialog = null;
    private ImageView ybC;
    private i ybT;
    private boolean yci = false;
    private TextView yui;
    private TextView yuj;
    private Button yuk;
    private Button yul;
    private a yum;
    private boolean yun = false;
    private int yuo = 0;

    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = true;
        switch (bindMContactIntroUI.yum) {
            case NO_INIT:
                bindMContactIntroUI.mI(false);
                return;
            case SET_MOBILE:
                final String str = bindMContactIntroUI.fBa;
                if (bindMContactIntroUI.ybT == null) {
                    bindMContactIntroUI.ybT = new i(b.zmQ, bindMContactIntroUI, new i.a() {
                        public final void EA(int i) {
                            Intent intent;
                            if (i == 1) {
                                if (BindMContactIntroUI.this.yci) {
                                    if (!q.Gg()) {
                                        com.tencent.mm.sdk.b.b scVar = new sc();
                                        scVar.fKF.fKG = true;
                                        scVar.fKF.fKH = true;
                                        com.tencent.mm.sdk.b.a.xmy.m(scVar);
                                    }
                                    BindMContactIntroUI.this.En(1);
                                    intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.plugin.c.a.ihN.e(BindMContactIntroUI.this, intent);
                                    return;
                                }
                                MMWizardActivity.A(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class).putExtra("is_bind_for_contact_sync", BindMContactIntroUI.this.yun));
                                if (!BindMContactIntroUI.this.ksj) {
                                    return;
                                }
                                if (BindMContactIntroUI.this.yun) {
                                    g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                                    return;
                                }
                                g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                            } else if (i == 2) {
                                intent = new Intent(BindMContactIntroUI.this, BindMContactVerifyUI.class);
                                intent.putExtra("bindmcontact_mobile", str);
                                intent.putExtra("is_bind_for_safe_device", BindMContactIntroUI.this.yci);
                                intent.putExtra("is_bind_for_contact_sync", BindMContactIntroUI.this.yun);
                                intent.putExtra("KEnterFromBanner", BindMContactIntroUI.this.ksj);
                                MMWizardActivity.A(BindMContactIntroUI.this, intent);
                            }
                        }
                    });
                    bindMContactIntroUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactIntroUI.ybT);
                }
                i iVar = bindMContactIntroUI.ybT;
                if (bindMContactIntroUI.yci || bindMContactIntroUI.yun) {
                    z = false;
                }
                iVar.zmM = z;
                bindMContactIntroUI.ybT.aax(str);
                return;
            case SUCC_UNLOAD:
                as.Hm();
                c.Db().set(12322, Boolean.valueOf(false));
                m.a(bindMContactIntroUI, new Runnable() {
                    public final void run() {
                        if (com.tencent.mm.modelfriend.m.NR()) {
                            BindMContactIntroUI.crn();
                            BindMContactIntroUI.this.yuk.setText(BindMContactIntroUI.this.getString(R.l.dLm));
                            BindMContactIntroUI.this.yum = a.SUCC;
                            as.Hm();
                            boolean a = bi.a((Boolean) c.Db().get(12322, Boolean.valueOf(false)), false);
                            if (BindMContactIntroUI.this.ksj && a) {
                                g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                            }
                        }
                    }
                }, true, bindMContactIntroUI.yuo);
                return;
            case SUCC:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        switch (bindMContactIntroUI.yum) {
            case SET_MOBILE:
                com.tencent.mm.modelfriend.m.NU();
                bindMContactIntroUI.initView();
                return;
            case SUCC_UNLOAD:
                bindMContactIntroUI.mI(true);
                return;
            case SUCC:
                bindMContactIntroUI.mI(true);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void crn() {
        int Gc = q.Gc();
        com.tencent.mm.modelfriend.m.NQ();
        Gc &= -131073;
        as.Hm();
        c.Db().set(7, Integer.valueOf(Gc));
        com.tencent.mm.plugin.c.a.ihO.un();
    }

    protected final int getLayoutId() {
        return R.i.dbm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(132, (e) this);
        as.CN().a(255, (e) this);
        as.CN().a((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
        setMMTitle(R.l.dLx);
    }

    public void onDestroy() {
        as.CN().b(132, (e) this);
        as.CN().b(255, (e) this);
        as.CN().b((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
        if (this.ybT != null) {
            getContentResolver().unregisterContentObserver(this.ybT);
            this.ybT.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final void initView() {
        this.yci = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.yun = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.ksj = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.yuo = getIntent().getIntExtra("key_upload_scene", 0);
        this.yum = com.tencent.mm.modelfriend.m.NT();
        x.d("MicroMsg.BindMContactIntroUI", "state " + this.yum);
        as.Hm();
        this.fBa = (String) c.Db().get(6, null);
        if (this.fBa == null || this.fBa.equals("")) {
            as.Hm();
            this.fBa = (String) c.Db().get(4097, null);
        }
        this.ybC = (ImageView) findViewById(R.h.cMh);
        this.yui = (TextView) findViewById(R.h.cMf);
        this.yuj = (TextView) findViewById(R.h.cMe);
        this.yuk = (Button) findViewById(R.h.cMd);
        this.yul = (Button) findViewById(R.h.cMg);
        this.yuk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMContactIntroUI.a(BindMContactIntroUI.this);
            }
        });
        this.yul.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMContactIntroUI.b(BindMContactIntroUI.this);
            }
        });
        if (getIntent().getBooleanExtra("skip", false)) {
            addTextOptionMenu(0, getString(R.l.dFF), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BindMContactIntroUI.this.bpd();
                    return true;
                }
            });
        } else {
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BindMContactIntroUI.this.bpd();
                    return true;
                }
            });
        }
        if (this.yum == a.SUCC_UNLOAD || this.yum == a.SUCC) {
            String value = com.tencent.mm.j.g.Af().getValue("ShowUnbindPhone");
            int i = 2;
            if (!bi.oN(value)) {
                i = bi.Wo(value);
            }
            if (i != 0) {
                addIconOptionMenu(1, R.g.bDJ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        l lVar = new l(BindMContactIntroUI.this.mController.xRr);
                        lVar.rQF = new p.c() {
                            public final void a(n nVar) {
                                nVar.setHeaderTitle(R.l.dLq);
                                if ((i & 2) != 0) {
                                    nVar.eT(0, R.l.dLD);
                                }
                                if ((i & 1) != 0) {
                                    nVar.eT(1, R.l.dKY);
                                }
                            }
                        };
                        lVar.rQG = new d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        h.a(BindMContactIntroUI.this.mController.xRr, BindMContactIntroUI.this.getString(R.l.dLA), BindMContactIntroUI.this.getString(R.l.dLB), BindMContactIntroUI.this.getString(R.l.dEy), BindMContactIntroUI.this.getString(R.l.dLz), null, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                if (BindMContactIntroUI.this.fBa != null && !BindMContactIntroUI.this.fBa.equals("")) {
                                                    as.CN().a(new com.tencent.mm.modelsimple.h(com.tencent.mm.modelsimple.h.hOv), 0);
                                                    BindMContactIntroUI bindMContactIntroUI = BindMContactIntroUI.this;
                                                    Context context = BindMContactIntroUI.this;
                                                    BindMContactIntroUI.this.getString(R.l.dGZ);
                                                    bindMContactIntroUI.tipDialog = h.a(context, BindMContactIntroUI.this.getString(R.l.eLT), true, new OnCancelListener() {
                                                        public final void onCancel(DialogInterface dialogInterface) {
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                        return;
                                    case 1:
                                        Intent intent = new Intent();
                                        intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                                        com.tencent.mm.bl.d.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", intent);
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
        }
        switch (this.yum) {
            case NO_INIT:
                showOptionMenu(1, false);
                this.ybC.setImageResource(R.k.dzl);
                this.yuj.setVisibility(0);
                this.yul.setVisibility(8);
                this.yui.setText(R.l.dLo);
                this.yuj.setText(R.l.dLn);
                this.yuk.setText(R.l.dKQ);
                return;
            case SET_MOBILE:
                showOptionMenu(1, false);
                this.ybC.setImageResource(R.k.dzl);
                this.yuj.setVisibility(0);
                this.yul.setVisibility(0);
                this.yui.setText(String.format(getString(R.l.dLO), new Object[]{this.fBa}));
                this.yuj.setText(R.l.dLG);
                this.yuk.setText(R.l.dLJ);
                this.yul.setText(R.l.dKZ);
                return;
            case SUCC_UNLOAD:
                showOptionMenu(1, true);
                this.ybC.setImageResource(R.k.dzk);
                this.yuj.setVisibility(0);
                this.yul.setVisibility(0);
                this.yui.setText(String.format(getString(R.l.dLO), new Object[]{this.fBa}));
                this.yuj.setText(R.l.dKV);
                this.yuk.setText(R.l.dLH);
                this.yul.setText(R.l.dKX);
                return;
            case SUCC:
                showOptionMenu(1, true);
                this.ybC.setImageResource(R.k.dzk);
                this.yuj.setVisibility(0);
                this.yul.setVisibility(0);
                this.yui.setText(String.format(getString(R.l.dLO), new Object[]{this.fBa}));
                this.yuj.setText(R.l.dKV);
                this.yuk.setText(R.l.dLm);
                this.yul.setText(R.l.dKX);
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bpd();
        return true;
    }

    private void bpd() {
        aWY();
        if (this.yun) {
            cancel();
            finish();
            return;
        }
        En(1);
    }

    private void mI(boolean z) {
        Intent intent = new Intent(this, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", this.yci);
        intent.putExtra("is_bind_for_contact_sync", this.yun);
        intent.putExtra("is_bind_for_change_mobile", z);
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!bi.oN(simCountryIso)) {
            com.tencent.mm.aq.b.a h = com.tencent.mm.aq.b.h(this, simCountryIso, getString(R.l.bZd));
            if (h != null) {
                intent.putExtra("country_name", h.hGi);
                intent.putExtra("couttry_code", h.hGh);
            }
        }
        MMWizardActivity.A(this, intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 132 && i == 0 && i2 == 0) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((t) kVar).IY() == 3) {
                com.tencent.mm.modelsimple.d.br(this);
                if (bi.oN(this.qpV)) {
                    MMWizardActivity.A(this, new Intent(this, BindMContactStatusUI.class));
                    return;
                } else {
                    h.a((Context) this, this.qpV, "", getString(R.l.dCa), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MMWizardActivity.A(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
                        }
                    });
                    return;
                }
            }
            return;
        }
        Object obj;
        if (!com.tencent.mm.plugin.c.a.ihO.a((Context) this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                    if (eC != null) {
                        eC.a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, R.l.dLb, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, R.l.dLd, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, R.l.dLg, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, R.l.dLc, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, R.l.dLe, 0).show();
                    obj = 1;
                    break;
            }
        }
        obj = 1;
        if (obj == null) {
            final k tVar;
            Context context;
            if (kVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i == 0 && i2 == 0) {
                    this.qpV = ((com.tencent.mm.modelsimple.h) kVar).RK().wdC;
                    this.qpU = ((com.tencent.mm.modelsimple.h) kVar).RJ();
                    if (bi.oN(this.qpV)) {
                        as.CN().a(new com.tencent.mm.modelsimple.x(2), 0);
                        return;
                    }
                    tVar = new t(this.fBa, 3, "", 0, "");
                    as.CN().a(tVar, 0);
                    context = this.mController.xRr;
                    getString(R.l.dGZ);
                    this.tipDialog = h.a(context, getString(R.l.dLF), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(tVar);
                        }
                    });
                    return;
                } else if (i2 == -3) {
                    x.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    h.a(this.mController.xRr, getString(R.l.eNW), null, getString(R.l.eNX), getString(R.l.eNV), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.l.eNU));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.bl.d.b(BindMContactIntroUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -81) {
                    h.a((Context) this, R.l.eKN, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    h.a((Context) this, R.l.eKO, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    h.a((Context) this, R.l.eKL, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    h.a((Context) this, R.l.eKM, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    h.a((Context) this, R.l.eKJ, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -86) {
                    h.a((Context) this, R.l.eKP, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
            if (kVar.getType() == 255) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i2 == 0) {
                    tVar = new t(this.fBa, 3, "", 0, "");
                    as.CN().a(tVar, 0);
                    context = this.mController.xRr;
                    getString(R.l.dGZ);
                    this.tipDialog = h.a(context, getString(R.l.dLF), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(tVar);
                        }
                    });
                } else {
                    x.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                    h.a(this.mController.xRr, getString(R.l.eNW), null, getString(R.l.eNX), getString(R.l.eNV), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.l.eNU));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.bl.d.b(BindMContactIntroUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
            if (kVar.getType() == 132) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (((t) kVar).IY() != 3) {
                    return;
                }
                if (i2 == -82) {
                    h.a((Context) this, R.l.eKO, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    h.a((Context) this, R.l.eKL, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    h.a((Context) this, R.l.eKM, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    h.a((Context) this, R.l.eKJ, R.l.dGZ, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    Toast.makeText(this, getString(R.l.dLC, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.fBa);
                    as.CN().a(new com.tencent.mm.modelsimple.h(com.tencent.mm.modelsimple.h.hOv), 0);
                    getString(R.l.dGZ);
                    this.tipDialog = h.a((Context) this, getString(R.l.eLT), true, new OnCancelListener() {
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

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactIntroUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.ybT != null) {
                    this.ybT.cpg();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
