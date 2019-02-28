package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.c;
import com.tencent.mm.plugin.address.model.h;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.plugin.address.ui.AddrEditView.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import java.util.List;

public class WalletAddAddressUI extends MMActivity implements e, b {
    private String fER = "";
    private int ioN = 0;
    private Dialog ion = null;
    private AddrEditView iqm;
    private AddrEditView iqn;
    private AddrEditView iqo;
    private AddrEditView iqp;
    private AddrEditView iqq;
    private com.tencent.mm.plugin.address.d.b iqr = null;
    private com.tencent.mm.plugin.address.d.b iqs = new com.tencent.mm.plugin.address.d.b();

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        if (walletAddAddressUI.ioN != 0) {
            x.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.iqs.toString());
            a.XP().XR();
            as.CN().a(new h(walletAddAddressUI.iqs), 0);
            walletAddAddressUI.ion = com.tencent.mm.ui.base.h.a((Context) walletAddAddressUI, "", true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            return;
        }
        x.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.iqs.toString());
        as.CN().a(new c(walletAddAddressUI.iqs), 0);
        walletAddAddressUI.ion = com.tencent.mm.ui.base.h.a((Context) walletAddAddressUI, "", true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(415, (e) this);
        as.CN().a(418, (e) this);
        x.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        x.Dx(0);
        this.ioN = getIntent().getIntExtra("address_id", 0);
        if (this.ioN == 0) {
            setMMTitle(R.l.dCT);
        } else {
            setMMTitle(R.l.dDk);
        }
        initView();
    }

    public final void initView() {
        a.XP().XQ();
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.cYF);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.iqm = (AddrEditView) findViewById(R.h.bJl);
        this.iqn = (AddrEditView) findViewById(R.h.bJh);
        this.iqo = (AddrEditView) findViewById(R.h.bJi);
        this.iqp = (AddrEditView) findViewById(R.h.bJs);
        this.iqq = (AddrEditView) findViewById(R.h.bJn);
        this.iqm.ipi = this;
        this.iqn.ipi = this;
        this.iqo.ipi = this;
        this.iqp.ipi = this;
        this.iqq.ipi = this;
        this.iqm.iph = new AddrEditView.a() {
            public final void onClick() {
                x.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
                if (com.tencent.mm.pluginsdk.g.a.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    WalletAddAddressUI.this.Yb();
                }
            }
        };
        this.iqn.iph = new AddrEditView.a() {
            public final void onClick() {
                x.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                if (com.tencent.mm.pluginsdk.g.a.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    WalletAddAddressUI.this.Yc();
                }
            }
        };
        this.iqn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletAddAddressUI.this.startActivityForResult(new Intent(WalletAddAddressUI.this, WalletMultiRcptSelectUI.class), 1);
            }
        });
        if (this.ioN != 0) {
            this.iqr = a.XP().jk(this.ioN);
            this.iqm.pg(this.iqr.ioK);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.iqr.ioF)) {
                stringBuilder.append(this.iqr.ioF);
            }
            if (!TextUtils.isEmpty(this.iqr.ioG)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.iqr.ioG);
            }
            if (!TextUtils.isEmpty(this.iqr.ioH)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.iqr.ioH);
            }
            this.iqn.pg(stringBuilder.toString());
            this.iqo.pg(this.iqr.ioJ);
            this.iqp.pg(this.iqr.ioI);
            this.iqq.pg(this.iqr.ioL);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletAddAddressUI.this.XV();
                return true;
            }
        });
        a(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (WalletAddAddressUI.this.XT()) {
                    if (WalletAddAddressUI.this.ioN != 0) {
                        WalletAddAddressUI.this.iqr = a.XP().jk(WalletAddAddressUI.this.ioN);
                        x.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.this.iqr.toString());
                        WalletAddAddressUI.a(WalletAddAddressUI.this.iqr, WalletAddAddressUI.this.iqs);
                    } else {
                        WalletAddAddressUI.this.iqr = new com.tencent.mm.plugin.address.d.b();
                    }
                    String text = WalletAddAddressUI.this.iqm.getText();
                    String text2 = WalletAddAddressUI.this.iqn.getText();
                    String text3 = WalletAddAddressUI.this.iqo.getText();
                    String text4 = WalletAddAddressUI.this.iqp.getText();
                    String text5 = WalletAddAddressUI.this.iqq.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        WalletAddAddressUI.this.iqs.ioF = split[0];
                    }
                    if (split.length >= 2) {
                        WalletAddAddressUI.this.iqs.ioG = split[1];
                    }
                    if (split.length >= 3) {
                        WalletAddAddressUI.this.iqs.ioH = split[2];
                    } else {
                        WalletAddAddressUI.this.iqs.ioH = "";
                    }
                    WalletAddAddressUI.this.iqs.ioJ = text3;
                    WalletAddAddressUI.this.iqs.ioK = text;
                    WalletAddAddressUI.this.iqs.ioL = text5;
                    WalletAddAddressUI.this.iqs.ioI = text4;
                    if (!bi.oN(WalletAddAddressUI.this.fER)) {
                        WalletAddAddressUI.this.iqs.ioM = WalletAddAddressUI.this.fER;
                    }
                    WalletAddAddressUI.o(WalletAddAddressUI.this);
                }
                return true;
            }
        }, p.b.xSe);
        XT();
    }

    public void onDestroy() {
        super.onDestroy();
        as.CN().b(415, (e) this);
        as.CN().b(418, (e) this);
        l XP = a.XP();
        x.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : XP.iox.values()) {
            clear.clear();
        }
        for (List clear2 : XP.ioy.values()) {
            clear2.clear();
        }
        XP.iow.clear();
        XP.iox.clear();
        XP.ioy.clear();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    str = intent.getStringExtra("karea_result");
                    if (!bi.oN(str)) {
                        x.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:" + str);
                        this.iqn.pg(str);
                    }
                    str = intent.getStringExtra("kpost_code");
                    if (!bi.oN(str)) {
                        x.d("MicroMsg.WalletAddAddressUI", "post:" + str);
                        this.iqp.pg(str);
                    }
                    this.fER = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        x.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        return;
                    }
                    String str2;
                    String[] b = com.tencent.mm.pluginsdk.a.b(getBaseContext(), data);
                    if (b == null || b.length != 2) {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.dDG), "", true);
                        str2 = null;
                    } else {
                        str = b[0];
                        str2 = b[1];
                    }
                    this.iqm.pg(str);
                    this.iqq.pg(str2);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                        XT();
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.dDG), "", true);
                        return;
                    }
                }
                return;
            case 3:
                if (i2 == -1) {
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    if (addr != null) {
                        x.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                        if (addr != null) {
                            StringBuilder stringBuilder;
                            if (a.XP().w(addr.hzg, addr.hzi, addr.hzj)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(addr.hzg);
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.hzi);
                                if (!TextUtils.isEmpty(addr.hzj)) {
                                    stringBuilder.append(" ");
                                    stringBuilder.append(addr.hzj);
                                }
                                this.iqn.pg(stringBuilder.toString());
                            } else {
                                this.iqn.pg("");
                            }
                            stringBuilder = new StringBuilder();
                            if (!TextUtils.isEmpty(addr.hzk)) {
                                stringBuilder.append(addr.hzk);
                            }
                            if (!TextUtils.isEmpty(addr.hzl)) {
                                stringBuilder.append(addr.hzl);
                            }
                            if (!TextUtils.isEmpty(addr.hzm)) {
                                stringBuilder.append(addr.hzm);
                            }
                            if (!TextUtils.isEmpty(addr.hzo)) {
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.hzo);
                            }
                            if (!bi.oN(addr.hzo) || bi.oN(addr.hzf)) {
                                this.iqo.pg(stringBuilder.toString());
                            } else {
                                this.iqo.pg(addr.hzf);
                            }
                            RcptItem v = a.XP().v(addr.hzg, addr.hzi, addr.hzj);
                            if (v != null) {
                                this.iqp.pg(v.iot);
                                this.fER = v.code;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.duc;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.ion != null) {
            this.ion.dismiss();
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.address.d.a aVar = a.XP().iov;
            if (aVar.ioD.size() > 0) {
                a(this.iqs, this.iqr);
                com.tencent.mm.plugin.address.d.b bVar = (com.tencent.mm.plugin.address.d.b) aVar.ioD.getFirst();
                if (bVar != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                com.tencent.mm.ui.base.h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case -3100:
                com.tencent.mm.ui.base.h.a((Context) this, R.l.dCS, 0, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletAddAddressUI.this.finish();
                    }
                });
                return;
            default:
                com.tencent.mm.ui.base.h.a((Context) this, R.l.dCQ, 0, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
        }
    }

    private boolean XT() {
        boolean z = false;
        boolean z2 = true;
        if (!this.iqm.XX()) {
            z2 = false;
        }
        if (!this.iqo.XX()) {
            z2 = false;
        }
        if (!this.iqn.XX()) {
            z2 = false;
        }
        if (!this.iqp.XX()) {
            z2 = false;
        }
        if (this.iqq.XX()) {
            z = z2;
        }
        enableOptionMenu(z);
        return z;
    }

    public final void XU() {
        XT();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        XV();
        return true;
    }

    private void XV() {
        int i;
        int i2 = 1;
        int i3 = R.l.dCW;
        if (this.ioN == 0) {
            i3 = R.l.dCV;
        }
        if (this.iqm.XY()) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.iqo.XY()) {
            i = 1;
        }
        if (this.iqn.XY()) {
            i = 1;
        }
        if (this.iqp.XY()) {
            i = 1;
        }
        if (!this.iqq.XY()) {
            i2 = i;
        }
        if (i2 != 0) {
            com.tencent.mm.ui.base.h.a((Context) this, i3, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletAddAddressUI.this.setResult(0);
                    WalletAddAddressUI.this.finish();
                }
            }, null);
            return;
        }
        setResult(0);
        finish();
    }

    private void Yb() {
        startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 2);
    }

    private void Yc() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.iqn.getText())) {
            stringBuilder.append(this.iqn.getText());
        }
        if (!TextUtils.isEmpty(this.iqo.getText())) {
            stringBuilder.append(this.iqo.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", stringBuilder.toString());
        intent.putExtra("map_view_type", 8);
        d.b(this, "location", ".ui.RedirectUI", intent, 3);
    }

    private static void a(com.tencent.mm.plugin.address.d.b bVar, com.tencent.mm.plugin.address.d.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.ioF = bVar.ioF;
            bVar2.ioG = bVar.ioG;
            bVar2.ioH = bVar.ioH;
            bVar2.ioJ = bVar.ioJ;
            bVar2.ioK = bVar.ioK;
            bVar2.ioL = bVar.ioL;
            bVar2.ioI = bVar.ioI;
            bVar2.ioM = bVar.ioM;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.WalletAddAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    Yb();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            WalletAddAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            case 64:
                if (iArr[0] == 0) {
                    Yc();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            WalletAddAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
