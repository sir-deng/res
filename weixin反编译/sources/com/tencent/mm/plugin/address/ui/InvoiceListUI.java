package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI extends MMActivity implements e {
    private TextView ioT = null;
    private b ipF;
    private a ipG;
    private ListView ipH;
    private com.tencent.mm.plugin.address.b.b.a ipI = null;
    private TextView ipJ = null;
    private LinkedList<b> ipK = new LinkedList();
    private boolean ipL = false;
    private boolean ipM = false;
    private boolean ipe = false;
    private Object lockObj = new Object();

    public class a extends BaseAdapter {
        private final Context context;
        List<b> hkf = new ArrayList();

        class a {
            TextView ipP;
            ImageView ipQ;
            TextView ipR;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return jp(i);
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
            b jp = jp(i);
            if (jp.type != null && jp.type.equals("0")) {
                aVar.ipP.setText(R.l.eqt);
                aVar.ipR.setText(jp.title);
            } else if (jp.type != null && jp.type.equals("1")) {
                aVar.ipP.setText(R.l.eqv);
                aVar.ipR.setText(jp.nHq);
            }
            if (InvoiceListUI.this.ipe && InvoiceListUI.this.ipF != null && InvoiceListUI.this.ipF.nHp == jp.nHp) {
                aVar.ipQ.setImageResource(R.k.dAC);
            } else {
                aVar.ipQ.setImageBitmap(null);
            }
            return view;
        }

        public final int getCount() {
            return this.hkf.size();
        }

        private b jp(int i) {
            return (b) this.hkf.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void a(InvoiceListUI invoiceListUI) {
        g.pWK.h(14199, Integer.valueOf(2));
        invoiceListUI.jn(0);
    }

    static /* synthetic */ void b(InvoiceListUI invoiceListUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (bVar.type != null && bVar.type.equals("0")) {
                if (!TextUtils.isEmpty(bVar.title)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqM));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.title);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nHr)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqL));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nHr);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nHx)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqy));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nHx);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nHv)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqD));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nHv);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nHt)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqv));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nHt);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nHs)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqw));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nHs);
                    stringBuilder.append(" \n");
                }
            } else if (!(bVar.type == null || !bVar.type.equals("1") || TextUtils.isEmpty(bVar.nHq))) {
                stringBuilder.append(invoiceListUI.getString(R.l.cqM));
                stringBuilder.append("：");
                stringBuilder.append(bVar.nHq);
                stringBuilder.append(" \n");
            }
            try {
                d.I(invoiceListUI.mController.xRr, stringBuilder.toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.InvoiceListUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.ipe = intent.getBooleanExtra("launch_from_webview", false);
        this.ipL = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.ipe || this.ipL) {
            this.ipe = true;
        }
        if (this.ipe) {
            as.Hm();
            boolean booleanValue = ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true))).booleanValue();
            x.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog " + booleanValue);
            if (booleanValue) {
                x.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                h.a((Context) this, getString(R.l.eqA), getString(R.l.eqB), getString(R.l.dCa), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
                        dialogInterface.dismiss();
                    }
                });
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
            }
        }
        setMMTitle(R.l.eMm);
        as.CN().a(1194, (e) this);
        as.CN().a(1191, (e) this);
        initView();
        XZ();
    }

    public void onDestroy() {
        as.CN().b(1194, (e) this);
        as.CN().b(1191, (e) this);
        super.onDestroy();
    }

    public void onResume() {
        as.CN().a(new com.tencent.mm.plugin.address.model.b(), 0);
        super.onResume();
    }

    private void XZ() {
        synchronized (this.lockObj) {
            com.tencent.mm.plugin.address.a.a.XN();
            this.ipK = com.tencent.mm.plugin.address.a.a.XO().iok.nHo;
            this.ipG.hkf = this.ipK;
            this.ipK.size();
            this.ipG.notifyDataSetChanged();
        }
    }

    public final void initView() {
        this.ipJ = (TextView) findViewById(R.h.cpK);
        if (this.ipJ != null) {
            this.ipJ.setVisibility(8);
        }
        if (this.ipe) {
            this.ioT = (TextView) findViewById(R.h.csi);
            if (this.ioT != null) {
                this.ioT.setVisibility(0);
            }
        } else {
            this.ioT = (TextView) findViewById(R.h.csi);
            if (this.ioT != null) {
                this.ioT.setVisibility(8);
            }
        }
        this.ipJ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InvoiceListUI.a(InvoiceListUI.this);
            }
        });
        this.ipH = (ListView) findViewById(R.h.cMB);
        this.ipG = new a(this);
        this.ipH.setAdapter(this.ipG);
        this.ipH.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.InvoiceListUI", "select pos " + i);
                synchronized (InvoiceListUI.this.lockObj) {
                    if (i < InvoiceListUI.this.ipK.size()) {
                        InvoiceListUI.this.ipF = (b) InvoiceListUI.this.ipK.get(i);
                        if (!InvoiceListUI.this.ipe && InvoiceListUI.this.ipF != null) {
                            InvoiceListUI.this.jn(InvoiceListUI.this.ipF.nHp);
                        } else if (!(InvoiceListUI.this.ipF == null || InvoiceListUI.this.ipF.nHp == 0)) {
                            Intent intent = new Intent();
                            intent.putExtra("choose_invoice_title_info", com.tencent.mm.plugin.address.e.e.a(InvoiceListUI.this.ipF));
                            InvoiceListUI.this.setResult(-1, intent);
                            InvoiceListUI.this.finish();
                        }
                    }
                }
                InvoiceListUI.this.ipG.notifyDataSetChanged();
            }
        });
        this.ipH.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                h.a(InvoiceListUI.this.mController.xRr, null, InvoiceListUI.this.getResources().getStringArray(R.c.bqR), null, new h.c() {
                    public final void jo(int i) {
                        b bVar;
                        synchronized (InvoiceListUI.this.lockObj) {
                            if (i < InvoiceListUI.this.ipK.size()) {
                                bVar = (b) InvoiceListUI.this.ipK.get(i);
                            } else {
                                bVar = null;
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    InvoiceListUI.this.jn(bVar.nHp);
                                    return;
                                case 1:
                                    k aVar = new com.tencent.mm.plugin.address.model.a(bVar.nHp);
                                    InvoiceListUI.this.ipF = null;
                                    as.CN().a(aVar, 0);
                                    return;
                                case 2:
                                    InvoiceListUI.b(InvoiceListUI.this, bVar);
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
        this.ipG.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InvoiceListUI.this.setResult(0);
                InvoiceListUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.eLg, R.k.duZ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InvoiceListUI.a(InvoiceListUI.this);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dlW;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar.getType() == 1191) {
            XZ();
            if (this.ipe) {
                com.tencent.mm.plugin.address.a.a.XN();
                if (com.tencent.mm.plugin.address.a.a.XO().iok.nHo.size() == 0 && !this.ipM) {
                    Intent intent = new Intent();
                    intent.setClass(this, AddInvoiceUI.class);
                    intent.putExtra("launch_from_webview", true);
                    startActivityForResult(intent, 1);
                }
            }
        } else if (kVar.getType() == 1194) {
            as.CN().a(new com.tencent.mm.plugin.address.model.b(), 0);
            this.ipM = true;
        }
    }

    private void jn(int i) {
        Intent intent = new Intent();
        if (i != 0) {
            intent.setClass(this, QrcodeInvoiceUI.class);
            intent.putExtra("invoice_id", i);
        } else {
            intent.setClass(this, AddInvoiceUI.class);
            intent.putExtra("launch_from_invoicelist_webview", this.ipe);
            intent.putExtra("invoice_id", i);
        }
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    x.e("MicroMsg.InvoiceUtil", "intent is null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.type = intent.getStringExtra(Columns.TYPE);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        bVar.title = intent.getStringExtra("title");
                        bVar.nHr = intent.getStringExtra("tax_number");
                        bVar.nHx = intent.getStringExtra("company_address");
                        bVar.nHv = intent.getStringExtra("telephone");
                        bVar.nHt = intent.getStringExtra("bank_name");
                        bVar.nHs = intent.getStringExtra("bank_account");
                    } else {
                        bVar.nHq = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", com.tencent.mm.plugin.address.e.e.a(bVar));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
