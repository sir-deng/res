package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ay.k;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.plugin.address.c.b;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements com.tencent.mm.plugin.address.c.a {
    private ListView ipH;
    private boolean ipe = false;
    private a iqA;
    private b iqB = null;
    private View iqC;
    private TextView iqD = null;
    private o iqE;
    private boolean iqF = false;
    private i iqG = null;
    private List<com.tencent.mm.plugin.address.d.b> iqy = new LinkedList();
    private com.tencent.mm.plugin.address.d.b iqz;
    private Object lockObj = new Object();

    public class a extends BaseAdapter {
        private final Context context;
        List<com.tencent.mm.plugin.address.d.b> hkf = new ArrayList();

        class a {
            TextView ipP;
            ImageView ipQ;
            TextView ipR;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return jr(i);
        }

        public a(Context context) {
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a aVar2 = new a();
            if (view == null) {
                view = View.inflate(this.context, R.i.dud, null);
                aVar2.ipQ = (ImageView) view.findViewById(R.h.bVY);
                aVar2.ipP = (TextView) view.findViewById(R.h.bJg);
                aVar2.ipR = (TextView) view.findViewById(R.h.bJm);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            com.tencent.mm.plugin.address.d.b jr = jr(i);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(jr.ioF)) {
                stringBuilder.append(jr.ioF);
            }
            if (!TextUtils.isEmpty(jr.ioG)) {
                stringBuilder.append(" ");
                stringBuilder.append(jr.ioG);
            }
            if (!TextUtils.isEmpty(jr.ioH)) {
                stringBuilder.append(" ");
                stringBuilder.append(jr.ioH);
            }
            if (!TextUtils.isEmpty(jr.ioJ)) {
                stringBuilder.append(" ");
                stringBuilder.append(jr.ioJ);
            }
            aVar.ipP.setText(stringBuilder.toString());
            aVar.ipR.setText(jr.ioK + "，" + jr.ioL);
            if (WalletSelectAddrUI.this.ipe && WalletSelectAddrUI.this.iqz != null && WalletSelectAddrUI.this.iqz.id == jr.id) {
                aVar.ipQ.setImageResource(R.k.dAC);
            } else {
                aVar.ipQ.setImageBitmap(null);
            }
            return view;
        }

        public final int getCount() {
            return this.hkf.size();
        }

        private com.tencent.mm.plugin.address.d.b jr(int i) {
            return (com.tencent.mm.plugin.address.d.b) this.hkf.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        as.Hm();
        String oM = bi.oM((String) c.Db().get(46, null));
        as.Hm();
        String oM2 = bi.oM((String) c.Db().get(72, null));
        if (bi.oN(oM) && bi.oN(oM2)) {
            walletSelectAddrUI.Ye();
        } else {
            walletSelectAddrUI.aL(oM, oM2);
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, com.tencent.mm.plugin.address.d.b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.ioK)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.bJl));
                stringBuilder.append("：");
                stringBuilder.append(bVar.ioK);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.ioL)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.bJn));
                stringBuilder.append("：");
                stringBuilder.append(bVar.ioL);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(R.l.dDt));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(bVar.ioF)) {
                stringBuilder.append(bVar.ioF);
            }
            if (!TextUtils.isEmpty(bVar.ioG)) {
                stringBuilder.append(bVar.ioG);
            }
            if (!TextUtils.isEmpty(bVar.ioH)) {
                stringBuilder.append(bVar.ioH);
            }
            if (!TextUtils.isEmpty(bVar.ioJ)) {
                stringBuilder.append(bVar.ioJ);
            }
            if (!TextUtils.isEmpty(bVar.ioI)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(R.l.dDq));
                stringBuilder.append("：");
                stringBuilder.append(bVar.ioI);
            }
            try {
                d.I(walletSelectAddrUI.mController.xRr, stringBuilder.toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iqB = new b(this, this);
        Intent intent = getIntent();
        this.iqF = intent.getBooleanExtra("launch_from_appbrand", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.iqF) {
            this.ipe = true;
            this.mController.contentView.setVisibility(8);
            if (this.iqF) {
                getWindow().setBackgroundDrawableResource(R.e.btq);
            }
            x.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            as.Hm();
            if (((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true))).booleanValue()) {
                x.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                h.a((Context) this, getString(R.l.dDu), getString(R.l.dDv), getString(R.l.dCa), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
            }
        }
        setMMTitle(R.l.dDt);
        this.iqB.jl(417);
        this.iqB.jl(416);
        this.iqB.jl(419);
        this.iqB.jl(582);
        this.iqB.g(new e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        as.Hm();
        this.iqE = new o(bi.a((Integer) c.Db().get(9, null), 0));
        initView();
        as.Hm();
        if (c.isSDCardAvailable()) {
            as.CN().a(new k(12), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.iqB.jm(417);
        this.iqB.jm(416);
        this.iqB.jm(419);
        this.iqB.jm(582);
    }

    public void onResume() {
        super.onResume();
        XZ();
    }

    private void XZ() {
        synchronized (this.lockObj) {
            com.tencent.mm.plugin.address.a.a.XN();
            this.iqy = com.tencent.mm.plugin.address.a.a.XP().iov.ioD;
            this.iqA.hkf = this.iqy;
            this.iqy.size();
            this.iqC.setVisibility(8);
            this.iqA.notifyDataSetChanged();
        }
    }

    public final void initView() {
        this.iqD = (TextView) findViewById(R.h.cpJ);
        this.iqD.setVisibility(8);
        this.iqD.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(R.l.dDB, new Object[]{WalletSelectAddrUI.this.iqE.toString()}), "", WalletSelectAddrUI.this.getString(R.l.dDC), WalletSelectAddrUI.this.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletSelectAddrUI.b(WalletSelectAddrUI.this);
                    }
                }, null);
            }
        });
        this.ipH = (ListView) findViewById(R.h.cMA);
        this.iqA = new a(this);
        this.iqC = findViewById(R.h.bJa);
        this.iqC.findViewById(R.h.bJg).setVisibility(8);
        ((TextView) this.iqC.findViewById(R.h.bJm)).setText(R.l.dCR);
        this.ipH.setAdapter(this.iqA);
        this.ipH.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.WalletSelectAddrUI", "select pos " + i);
                synchronized (WalletSelectAddrUI.this.lockObj) {
                    if (i < WalletSelectAddrUI.this.iqy.size()) {
                        WalletSelectAddrUI.this.iqz = (com.tencent.mm.plugin.address.d.b) WalletSelectAddrUI.this.iqy.get(i);
                        if (!WalletSelectAddrUI.this.ipe && WalletSelectAddrUI.this.iqz != null) {
                            WalletSelectAddrUI.this.jq(WalletSelectAddrUI.this.iqz.id);
                        } else if (!(WalletSelectAddrUI.this.iqz == null || WalletSelectAddrUI.this.iqz.id == 0)) {
                            WalletSelectAddrUI.this.iqB.g(new g(WalletSelectAddrUI.this.iqz.id));
                        }
                    }
                }
                WalletSelectAddrUI.this.iqA.notifyDataSetChanged();
            }
        });
        this.ipH.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                h.a(WalletSelectAddrUI.this.mController.xRr, null, WalletSelectAddrUI.this.getResources().getStringArray(R.c.brc), null, new h.c() {
                    public final void jo(int i) {
                        com.tencent.mm.plugin.address.d.b bVar;
                        synchronized (WalletSelectAddrUI.this.lockObj) {
                            if (i < WalletSelectAddrUI.this.iqy.size()) {
                                bVar = (com.tencent.mm.plugin.address.d.b) WalletSelectAddrUI.this.iqy.get(i);
                            } else {
                                bVar = null;
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    WalletSelectAddrUI.this.jq(bVar.id);
                                    return;
                                case 1:
                                    com.tencent.mm.ad.k fVar = new f(bVar.id);
                                    WalletSelectAddrUI.this.iqz = null;
                                    WalletSelectAddrUI.this.iqB.g(fVar);
                                    return;
                                case 2:
                                    WalletSelectAddrUI.b(WalletSelectAddrUI.this, bVar);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                return true;
            }
        });
        XZ();
        this.iqC.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletSelectAddrUI.this.jq(0);
            }
        });
        this.iqA.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletSelectAddrUI.this.setResult(0);
                WalletSelectAddrUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.dCT, R.k.duZ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletSelectAddrUI.this.jq(0);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.due;
    }

    public final void e(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        this.iqB.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 417) {
                if (((e) kVar).ioo) {
                    XZ();
                    this.mController.contentView.setVisibility(0);
                    if (this.ipe && this.iqy.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
            } else if (kVar.getType() == 416) {
                f fVar = (f) kVar;
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.d.b jk = com.tencent.mm.plugin.address.a.a.XP().jk(fVar.iop);
                if (jk != null) {
                    com.tencent.mm.plugin.address.a.a.XN();
                    x.d("MicroMsg.WalletSelectAddrUI", "delte addr " + com.tencent.mm.plugin.address.a.a.XP().a(jk));
                }
                XZ();
            } else if (kVar.getType() == 419) {
                if (this.iqz != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.iqz));
                    finish();
                }
            } else if (kVar.getType() == 582) {
                String string = getString(R.l.dDD);
                switch (((com.tencent.mm.plugin.address.model.d) kVar).status) {
                    case 0:
                        as.Hm();
                        c.Db().set(196657, Boolean.valueOf(true));
                        this.iqD.setVisibility(8);
                        XZ();
                        this.mController.contentView.setVisibility(0);
                        string = getString(R.l.dDF);
                        break;
                    case 1:
                    case 2:
                        as.Hm();
                        c.Db().set(196657, Boolean.valueOf(true));
                        this.iqD.setVisibility(8);
                        string = getString(R.l.dDE);
                        break;
                    case 3:
                        Ye();
                        return;
                }
                if (this.iqG != null) {
                    this.iqG.dismiss();
                }
                this.iqG = h.a((Context) this, string, null, true, null);
            }
        } else if (kVar.getType() == 419 && i2 == -3103) {
            h.a((Context) this, true, str, "", getString(R.l.dCX), getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    WalletSelectAddrUI.this.jq(WalletSelectAddrUI.this.iqz.id);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void aL(String str, String str2) {
        this.iqB.g(new com.tencent.mm.plugin.address.model.d(str, str2, this.iqE));
    }

    private void Ye() {
        final com.tencent.mm.sdk.b.b juVar = new ju();
        juVar.fBy.fBA = this;
        juVar.fBy.fBB = new Runnable() {
            public final void run() {
                WalletSelectAddrUI.this.ipH.post(new Runnable() {
                    public final void run() {
                        if (juVar.fBz.fqR) {
                            as.Hm();
                            String oM = bi.oM((String) c.Db().get(46, null));
                            as.Hm();
                            WalletSelectAddrUI.this.aL(oM, bi.oM((String) c.Db().get(72, null)));
                        }
                    }
                });
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(juVar, Looper.myLooper());
    }

    private void jq(int i) {
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                com.tencent.mm.plugin.address.d.b bVar;
                if (intent == null) {
                    x.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new com.tencent.mm.plugin.address.d.b();
                    bVar.ioM = intent.getStringExtra("nationalCode");
                    bVar.ioK = intent.getStringExtra("userName");
                    bVar.ioL = intent.getStringExtra("telNumber");
                    bVar.ioI = intent.getStringExtra("addressPostalCode");
                    bVar.ioF = intent.getStringExtra("proviceFirstStageName");
                    bVar.ioG = intent.getStringExtra("addressCitySecondStageName");
                    bVar.ioH = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.ioJ = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
