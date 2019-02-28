package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.ii;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.a.d;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;

public class IPCallAddressUI extends MMActivity implements e {
    private View nNQ;
    private ListView nOc;
    private e nOd = null;
    private int nOe = 0;
    private boolean nOf = false;
    private boolean nOg = true;
    private boolean nOh = false;
    private c nOi = new c<ii>() {
        {
            this.xmG = ii.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (IPCallAddressUI.this.nOd != null) {
                IPCallAddressUI.this.nOd.aUV();
            }
            return true;
        }
    };
    private Runnable nOj = new Runnable() {
        public final void run() {
            a.aTP().a(null, true);
        }
    };

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.Hm();
        if (((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.valueOf(false));
            Intent intent = new Intent();
            intent.setClass(this.mController.xRr, IPCallAcitivityUI.class);
            this.mController.xRr.startActivity(intent);
            overridePendingTransition(R.a.bqB, R.a.bqA);
            this.nOg = false;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (IPCallAddressUI.this.nOe == 1) {
                    com.tencent.mm.plugin.ipcall.b.ihN.s(new Intent(), IPCallAddressUI.this);
                } else {
                    IPCallAddressUI.this.finish();
                }
                return true;
            }
        });
        if (this.nOg) {
            this.nOh = true;
            aUY();
        }
        as.Hm();
        this.nOf = ((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue();
        setMMTitle(R.l.eqV);
        this.nOc = (ListView) findViewById(R.h.bJe);
        this.nNQ = findViewById(R.h.bJq);
        this.nOd = new e(this, this.nOc, this.nNQ);
        e eVar = this.nOd;
        eVar.nNP = new h(eVar.nNR);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.nNR, R.i.dmm, null);
        eVar.nNO.addHeaderView(viewGroup, null, false);
        eVar.nNO.setAdapter(eVar.nNP);
        eVar.nNT = (TextView) viewGroup.findViewById(R.h.bIu);
        eVar.nNU = (TextView) viewGroup.findViewById(R.h.bIy);
        eVar.nNV = (LinearLayout) viewGroup.findViewById(R.h.bIr);
        eVar.nNW = (TextView) viewGroup.findViewById(R.h.bIs);
        eVar.nNX = (ImageView) viewGroup.findViewById(R.h.cTT);
        viewGroup.findViewById(R.h.bIz).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Object obj;
                boolean z;
                as.Hm();
                boolean booleanValue = ((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue();
                if (booleanValue) {
                    as.Hm();
                    i.N(2, ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1))).intValue(), -1);
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1));
                    x.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", Integer.valueOf(r0));
                }
                if (booleanValue) {
                    obj = "true";
                } else {
                    String obj2 = "false";
                }
                as.Hm();
                String str = (String) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
                x.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", obj2, str);
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
                as.Hm();
                if (((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(0))).intValue() == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    as.Hm();
                    x.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", (String) com.tencent.mm.y.c.Db().get(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) ""));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) "");
                }
                g.pWK.h(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                e.this.aUV();
                Intent intent = new Intent();
                intent.setClass(e.this.nNR, IPCallShareCouponUI.class);
                e.this.nNR.startActivity(intent);
            }
        });
        viewGroup.findViewById(R.h.bYs).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(e.this.nNR, IPCallContactUI.class);
                e.this.nNR.startActivity(intent);
            }
        });
        viewGroup.findViewById(R.h.cbW).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(e.this.nNR, IPCallDialUI.class);
                intent.putExtra("IPCallTalkUI_dialScene", 1);
                e.this.nNR.startActivityForResult(intent, 1001);
            }
        });
        eVar.nNO.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!e.this.nNP.rq(i) && (adapterView instanceof ListView)) {
                    k rV = e.this.nNP.rV(i - ((ListView) adapterView).getHeaderViewsCount());
                    if (rV != null) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = null;
                        if (rV.field_addressId > 0) {
                            cVar = com.tencent.mm.plugin.ipcall.a.i.aUk().dz(rV.field_addressId);
                        }
                        Intent intent = new Intent(e.this.nNR, IPCallUserProfileUI.class);
                        if (cVar != null) {
                            intent.putExtra("IPCallProfileUI_contactid", cVar.field_contactId);
                            intent.putExtra("IPCallProfileUI_systemUsername", cVar.field_systemAddressBookUsername);
                            intent.putExtra("IPCallProfileUI_wechatUsername", cVar.field_wechatUsername);
                        } else {
                            intent.putExtra("IPCallProfileUI_phonenumber", rV.field_phonenumber);
                        }
                        intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                        e.this.nNR.startActivity(intent);
                    }
                }
            }
        });
        eVar.nNO.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = e.this.nNP;
                if (hVar.nQX == null) {
                    hVar.nQX = m.aUO();
                }
                k rV = e.this.nNP.rV(i - ((ListView) adapterView).getHeaderViewsCount());
                e eVar = e.this;
                int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
                if (rV != null) {
                    l lVar = new l(eVar.nNR);
                    lVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            nVar.add(R.l.dEH);
                        }
                    };
                    lVar.rQG = new AnonymousClass9(rV, headerViewsCount);
                    lVar.bCH();
                }
                return true;
            }
        });
        as.Hm();
        if (((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
            d.aTU().fU(true);
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.valueOf(false));
        } else {
            d.aTU().fU(false);
        }
        if (eVar.nNP.getCount() > 0) {
            eVar.nNQ.setVisibility(8);
        } else {
            eVar.nNQ.setVisibility(0);
        }
        eVar.aUW();
        eVar.aUV();
        eVar.nNS = true;
        as.CN().a(257, (e) this);
        com.tencent.mm.sdk.b.a.xmy.b(this.nOi);
        this.nOe = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        g.pWK.a(257, 0, 1, true);
    }

    protected final int getLayoutId() {
        return R.i.dma;
    }

    private void aUY() {
        x.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            com.tencent.mm.sdk.f.e.post(this.nOj, "IPCallAddressUI_LoadSystemAddressBook");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nOd != null) {
            e eVar = this.nOd;
            eVar.nNO.setOnItemClickListener(null);
            eVar.nNO.setOnItemLongClickListener(null);
            com.tencent.mm.ac.n.JF().b(eVar.nNP);
        }
        as.CN().b(257, (e) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.nOi);
    }

    protected void onResume() {
        super.onResume();
        if (this.nOd != null) {
            e eVar = this.nOd;
            if (!(eVar.nNP == null || eVar.nNS)) {
                eVar.nNP.notifyDataSetChanged();
                if (eVar.nNP.getCount() > 0) {
                    eVar.nNQ.setVisibility(8);
                } else {
                    eVar.nNQ.setVisibility(0);
                }
            }
            eVar.nNS = false;
        }
        supportInvalidateOptionsMenu();
        com.tencent.mm.plugin.ipcall.a.f.b.aUJ().gf(true);
        if (!this.nOh) {
            this.nOh = true;
            aUY();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g) && i == 0 && i2 == 0 && this.nOd != null) {
            this.nOd.aUW();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        if (this.nOe == 1) {
            com.tencent.mm.plugin.ipcall.b.ihN.s(new Intent(), this);
        } else {
            super.onBackPressed();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.IPCallAddressUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] != 0 && this.nOf) {
                    this.nOf = false;
                    h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
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
