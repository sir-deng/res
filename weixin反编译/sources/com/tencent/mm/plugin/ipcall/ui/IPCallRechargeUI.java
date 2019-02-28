package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.ipcall.a.d.f;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.y.as;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements e {
    private int lJg = -1;
    private String[] lJi;
    private com.tencent.mm.pluginsdk.model.i.a lJw = new com.tencent.mm.pluginsdk.model.i.a() {
        public final void u(ArrayList<q> arrayList) {
            IPCallRechargeUI.this.nRj.nLZ = System.currentTimeMillis();
            if (arrayList == null || arrayList.size() <= 0) {
                if (IPCallRechargeUI.this.nOr != null && IPCallRechargeUI.this.nOr.isShowing()) {
                    IPCallRechargeUI.this.nOr.dismiss();
                }
                x.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
                IPCallRechargeUI.this.lJg = 10236;
                IPCallRechargeUI.this.aVi();
                return;
            }
            IPCallRechargeUI.this.nRa = new String[arrayList.size()];
            IPCallRechargeUI.this.nRb = new String[arrayList.size()];
            q qVar = (q) arrayList.get(0);
            if (qVar.vkp == 10232) {
                x.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    qVar = (q) it.next();
                    IPCallRechargeUI.this.nRa[i] = new BigDecimal(qVar.vko).divide(new BigDecimal(Constants.MAX_BUFFER_SIZE)).toString();
                    IPCallRechargeUI.this.nRb[i] = qVar.vkn;
                    i++;
                }
                if (IPCallRechargeUI.this.nRf > 0 && IPCallRechargeUI.this.nRb.length > 0) {
                    String str = IPCallRechargeUI.this.nRb[0];
                    if (!(bi.oN(str) || str.equals(IPCallRechargeUI.this.nRd))) {
                        x.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.this.nRd + ",google wallet currency:" + str);
                        IPCallRechargeUI.this.Dy(str);
                        return;
                    }
                }
                if (IPCallRechargeUI.this.nOr != null && IPCallRechargeUI.this.nOr.isShowing()) {
                    IPCallRechargeUI.this.nOr.dismiss();
                }
                IPCallRechargeUI.this.aVi();
                return;
            }
            if (IPCallRechargeUI.this.nOr != null && IPCallRechargeUI.this.nOr.isShowing()) {
                IPCallRechargeUI.this.nOr.dismiss();
            }
            IPCallRechargeUI.this.lJg = qVar.vkp;
            x.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.this.lJg);
            IPCallRechargeUI.this.aVi();
        }
    };
    TextView lpZ;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1002:
                    IPCallRechargeUI.this.nRo.setVisibility(0);
                    IPCallRechargeUI.k(IPCallRechargeUI.this);
                    return;
                default:
                    x.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    ProgressDialog nOr;
    private String[] nRa;
    private String[] nRb;
    private String nRc;
    private String nRd;
    private boolean nRe = false;
    private int nRf;
    private int nRg = -1;
    private String nRh;
    private String nRi;
    private h nRj = new h();
    private g nRk = new g();
    private j nRl = new j();
    RelativeLayout nRm;
    GridView nRn;
    ListView nRo;
    a nRp;
    Button nRq;
    f nRr;

    private static class a extends BaseAdapter {
        private IPCallRechargeUI nRu = null;
        aio nRv = null;
        List<bya> nua = null;

        private class a {
            TextView nQA;
            Button nRA;
            TextView nRx;
            TextView nRy;
            TextView nRz;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(IPCallRechargeUI iPCallRechargeUI) {
            Assert.assertTrue(iPCallRechargeUI != null);
            this.nRu = iPCallRechargeUI;
        }

        public final int getCount() {
            return this.nua == null ? 0 : this.nua.size();
        }

        public final Object getItem(int i) {
            if (this.nua != null) {
                return this.nua.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.nRu.getSystemService("layout_inflater")).inflate(R.i.dmx, viewGroup, false);
                aVar = new a();
                aVar.nQA = (TextView) view.findViewById(R.h.cTd);
                aVar.nRx = (TextView) view.findViewById(R.h.cTc);
                aVar.nRy = (TextView) view.findViewById(R.h.cTb);
                aVar.nRz = (TextView) view.findViewById(R.h.cTa);
                aVar.nRA = (Button) view.findViewById(R.h.bOZ);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            bya bya = (bya) getItem(i);
            if (bya != null) {
                aVar.nQA.setText(bya.wMx);
                aVar.nRx.setText(bya.xfv);
                aVar.nRy.setText(bya.xfw);
                if (bi.oN(bya.xfw)) {
                    aVar.nRy.setVisibility(8);
                } else {
                    aVar.nRy.setVisibility(0);
                }
                if (this.nRv != null) {
                    aVar.nRz.setText(String.format(this.nRu.getString(R.l.ero), new Object[]{com.tencent.mm.plugin.ipcall.b.a.DH(this.nRv.wws), String.valueOf(bya.xft)}));
                }
                aVar.nRA.setTag(Integer.valueOf(i));
                aVar.nRA.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        IPCallRechargeUI.b(a.this.nRu, ((Integer) view.getTag()).intValue());
                    }
                });
            }
            return view;
        }
    }

    static /* synthetic */ void b(IPCallRechargeUI iPCallRechargeUI, int i) {
        String string;
        boolean z;
        if (iPCallRechargeUI.lJg != -1) {
            CharSequence string2;
            switch (iPCallRechargeUI.lJg) {
                case 10233:
                    string2 = iPCallRechargeUI.getString(R.l.erU);
                    if (!iPCallRechargeUI.Dz(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
                case 10234:
                    string = iPCallRechargeUI.getString(R.l.erQ);
                    if (!iPCallRechargeUI.Dz(string)) {
                        com.tencent.mm.ui.base.h.a((Context) iPCallRechargeUI, string, iPCallRechargeUI.getString(R.l.erW), true, null);
                        break;
                    }
                    break;
                case 10235:
                    string2 = iPCallRechargeUI.getString(R.l.esA);
                    if (!iPCallRechargeUI.Dz(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
                default:
                    string2 = iPCallRechargeUI.getString(R.l.era);
                    if (!iPCallRechargeUI.Dz(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            iPCallRechargeUI.nRg = i;
            x.i("MicroMsg.IPCallRechargeUI", "ProductId:%s, PackPrice:%s,Currency:%s, index:%d", iPCallRechargeUI.lJi[i], iPCallRechargeUI.nRa[i], iPCallRechargeUI.nRb[i], Integer.valueOf(i));
            com.tencent.mm.plugin.report.service.g.pWK.a(257, 5, 1, true);
            iPCallRechargeUI.nRk.start();
            if (iPCallRechargeUI.nRp.getItem(i) instanceof bya) {
                iPCallRechargeUI.nRk.nLQ = ((bya) iPCallRechargeUI.nRp.getItem(i)).xfu;
            }
            iPCallRechargeUI.nRk.nLR = iPCallRechargeUI.nRb[i];
            iPCallRechargeUI.nRk.nLP = (long) i;
            iPCallRechargeUI.nRk.nLV = iPCallRechargeUI.lJi[i];
            Intent intent = new Intent();
            intent.putExtra("key_product_id", iPCallRechargeUI.lJi[i]);
            intent.putExtra("key_currency_type", iPCallRechargeUI.nRb[i]);
            intent.putExtra("key_price", iPCallRechargeUI.nRb[i] + iPCallRechargeUI.nRa[i]);
            intent.putExtra("key_force_google", true);
            if (iPCallRechargeUI.nRp.getItem(i) instanceof bya) {
                string = ((bya) iPCallRechargeUI.nRp.getItem(i)).xfx;
                if (!bi.oN(string)) {
                    x.i("md5:%s", string);
                    byf byf = new byf();
                    byf.xfx = string;
                    try {
                        intent.putExtra("key_ext_info", Base64.encodeToString(byf.toByteArray(), 2));
                    } catch (IOException e) {
                        x.e("MicroMsg.IPCallRechargeUI", e.getMessage());
                    }
                }
            }
            d.b(iPCallRechargeUI, "wallet_index", ".ui.WalletIapUI", intent, 2001);
        }
    }

    static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
        if (iPCallRechargeUI.nRp != null) {
            iPCallRechargeUI.nRp.nua = null;
            iPCallRechargeUI.nRp.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.nRo != null) {
            iPCallRechargeUI.nRo.setVisibility(4);
        }
        if (iPCallRechargeUI.nOr != null) {
            iPCallRechargeUI.nOr.show();
        }
        iPCallRechargeUI.Dy("");
    }

    static /* synthetic */ void k(IPCallRechargeUI iPCallRechargeUI) {
        if (!bi.oN(iPCallRechargeUI.nRh) && !bi.oN(iPCallRechargeUI.nRi)) {
            x.i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
            com.tencent.mm.ui.base.h.a((Context) iPCallRechargeUI, iPCallRechargeUI.nRi, iPCallRechargeUI.nRh, iPCallRechargeUI.getString(R.l.erm), iPCallRechargeUI.getString(R.l.ern), false, null, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    IPCallRechargeUI.this.finish();
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", IPCallRechargeUI.this.getString(R.l.eqT));
                    intent.putExtra("showShare", false);
                    d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(929, (e) this);
        setMMTitle(R.l.erl);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallRechargeUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.h.a(IPCallRechargeUI.this.mController.xRr, null, null, IPCallRechargeUI.this.getResources().getString(R.l.esi), false, new c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                x.i("MicroMsg.IPCallRechargeUI", "start restore");
                                IPCallRechargeUI.this.nRl.start();
                                com.tencent.mm.plugin.report.service.g.pWK.a(257, 14, 1, true);
                                Intent intent = new Intent();
                                intent.putExtra("key_action_type", 200002);
                                intent.putExtra("key_force_google", true);
                                d.b(IPCallRechargeUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                                MMActivity mMActivity = IPCallRechargeUI.this;
                                if (mMActivity.isFinishing()) {
                                    x.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                                    return;
                                }
                                Context context = mMActivity.mController.xRr;
                                mMActivity.getString(R.l.dGZ);
                                mMActivity.nOr = com.tencent.mm.ui.base.h.a(context, mMActivity.getString(R.l.erb), false, null);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.nRm = (RelativeLayout) findViewById(R.h.layout);
        this.nRn = (GridView) findViewById(R.h.cGx);
        this.nRo = (ListView) findViewById(R.h.cGz);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.mController.xRr, R.i.dmw, null);
        this.nRo.addFooterView(viewGroup, null, false);
        this.nRp = new a(this);
        this.nRo.setAdapter(this.nRp);
        this.lpZ = (TextView) viewGroup.findViewById(R.h.cSc);
        this.nRq = (Button) findViewById(R.h.bPl);
        Object string = getString(R.l.erq);
        CharSequence newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                ((TextView) view).setHighlightColor(IPCallRechargeUI.this.getResources().getColor(R.e.transparent));
                Intent intent = new Intent();
                String str = IPCallRechargeUI.this.getString(R.l.erp) + "&usedcc=";
                List aTT = com.tencent.mm.plugin.ipcall.a.c.aTQ().aTT();
                if (aTT.size() > 0) {
                    int size = aTT.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String DJ = com.tencent.mm.plugin.ipcall.b.a.DJ(((Integer) aTT.get(i)).toString());
                        if (bi.oN(DJ)) {
                            DJ = str;
                        } else {
                            DJ = str + DJ + "|";
                        }
                        i++;
                        str = DJ;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                } else {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.DJ(com.tencent.mm.plugin.ipcall.b.c.aVu());
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(IPCallRechargeUI.this.getResources().getColor(R.e.btd));
                textPaint.setUnderlineText(false);
            }
        }, 0, string.length(), 33);
        this.lpZ.setText(newSpannable);
        this.lpZ.setMovementMethod(LinkMovementMethod.getInstance());
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.nOr = com.tencent.mm.ui.base.h.a(context, getString(R.l.erb), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (IPCallRechargeUI.this.nRr != null) {
                        as.CN().c(IPCallRechargeUI.this.nRr);
                    }
                    IPCallRechargeUI.this.finish();
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", e.getMessage());
                }
            }
        });
        Dy("");
        this.nRj.start();
        com.tencent.mm.plugin.report.service.g.pWK.a(257, 4, 1, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.nRj.nLB = System.currentTimeMillis();
        this.nRj.finish();
        as.CN().b(929, (e) this);
    }

    protected final int getLayoutId() {
        return R.i.dmy;
    }

    private void Dy(String str) {
        String DJ;
        List aTT = com.tencent.mm.plugin.ipcall.a.c.aTQ().aTT();
        if (aTT.size() == 0) {
            DJ = com.tencent.mm.plugin.ipcall.b.a.DJ(com.tencent.mm.plugin.ipcall.b.c.aVu());
        } else {
            DJ = com.tencent.mm.plugin.ipcall.b.a.DJ(((Integer) aTT.get(0)).toString());
        }
        this.nRr = new f(DJ, str);
        as.CN().a(this.nRr, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        boolean z;
        int i3;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int i4;
            String str;
            String str2 = "";
            z = false;
            if (intent != null) {
                String string;
                int intExtra2 = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                intExtra = intent.getIntExtra("key_gw_error_code", 0);
                int intExtra3 = intent.getIntExtra("key_response_position", 0);
                if (intExtra2 == 100000001) {
                    z = true;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Integer.valueOf(intExtra3), String.valueOf(z));
                if (intExtra2 != 6 || intExtra == 0) {
                    this.nRk.nLT = (long) intExtra2;
                } else {
                    this.nRk.nLT = (long) intExtra;
                }
                if (intExtra3 == 3) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.g.pWK.a(257, 11, 1, true);
                    this.nRk.nLT = 0;
                    this.nRk.nLU = 2;
                    string = getString(R.l.esB);
                } else {
                    if (intExtra3 != 1) {
                        if (i2 == -1 && intExtra2 == 0) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.g.pWK.a(257, 12, 1, true);
                            this.nRk.nLT = 0;
                            this.nRk.nLU = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.nRk.nLS = longExtra;
                this.nRk.nLB = System.currentTimeMillis();
                this.nRk.finish();
                i4 = intExtra3;
                str = string;
                i3 = intExtra;
                intExtra = intExtra2;
            } else {
                i3 = 0;
                i4 = 0;
                intExtra = 0;
                str = str2;
            }
            if (i2 != -1) {
                return;
            }
            CharSequence string2;
            if (intent != null && intExtra == 0) {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                intent.getStringArrayListExtra("key_response_series_ids");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    x.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", bi.oM((String) it.next()));
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(257, 6, 1, true);
                com.tencent.mm.plugin.report.service.g.pWK.a(257, 10, 1, true);
                Toast.makeText(this, R.l.erX, 0).show();
                finish();
            } else if (intent != null && intExtra == 100000002) {
                com.tencent.mm.plugin.report.service.g.pWK.a(257, 6, 1, true);
                ze(str);
            } else if (intent != null && intExtra == 109) {
                ze(str);
            } else if (intent != null && intExtra == 1) {
                string2 = getString(R.l.erV);
                com.tencent.mm.plugin.report.service.g.pWK.a(257, 8, 1, true);
                Toast.makeText(this, string2, 0).show();
            } else if (intent == null || intExtra != 113) {
                com.tencent.mm.plugin.report.service.g.pWK.a(257, 7, 1, true);
                if (i4 == 3) {
                    ze(str);
                } else if (intExtra != 100000001 && intExtra != 6) {
                } else {
                    if (i3 == 0) {
                        Toast.makeText(this, getString(R.l.eqY), 0).show();
                        return;
                    }
                    string2 = getString(R.l.era);
                    if (!Dz(string2)) {
                        Toast.makeText(this, string2, 0).show();
                    }
                }
            } else {
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.erO), getString(R.l.erW), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        IPCallRechargeUI.j(IPCallRechargeUI.this);
                    }
                });
            }
        } else if (i == 2002) {
            if (this.nOr != null && this.nOr.isShowing()) {
                this.nOr.dismiss();
            }
            String str3 = "";
            int i5 = 0;
            int i6 = 0;
            z = false;
            if (intent != null) {
                i5 = intent.getIntExtra("key_err_code", 0);
                str3 = intent.getStringExtra("key_err_msg");
                i6 = intent.getIntExtra("key_response_position", 0);
                if (i5 == 100000001) {
                    z = true;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(i5), str3, Integer.valueOf(i6), String.valueOf(z));
            }
            CharSequence charSequence = str3;
            int i7 = i5;
            boolean z2 = z;
            i3 = i6;
            i6 = i7;
            this.nRl.nMc = (long) i6;
            this.nRl.nMa = 0;
            if (i2 != -1) {
                this.nRl.nMb = 2;
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, R.l.esj, 0).show();
            } else if (intent == null || i6 != 0) {
                if (z2) {
                    this.nRl.nMb = 1;
                    com.tencent.mm.plugin.report.service.g.pWK.a(257, 17, 1, true);
                    charSequence = getString(R.l.esk);
                } else if (i3 == 3) {
                    this.nRl.nMb = 2;
                    com.tencent.mm.plugin.report.service.g.pWK.a(257, 16, 1, true);
                } else {
                    this.nRl.nMb = 2;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.nRl.nMb = 3;
                    x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, R.l.esk, 0).show();
                } else {
                    this.nRl.nMb = 0;
                    com.tencent.mm.plugin.report.service.g.pWK.a(257, 15, 1, true);
                    x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.esl), getString(R.l.esm), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            IPCallRechargeUI.this.finish();
                        }
                    });
                }
            }
            this.nRl.nLB = System.currentTimeMillis();
            this.nRl.finish();
        }
    }

    private void ze(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.erW);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.l.erW), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private boolean Dz(String str) {
        boolean z;
        if (com.tencent.mm.j.g.Af().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.nRg >= 0) {
            Object item = this.nRp.getItem(this.nRg);
            if ((item instanceof bya) && !bi.oN(((bya) item).xfy)) {
                final String str2 = ((bya) item).xfy;
                x.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:" + str2);
                com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.l.erW), getString(R.l.erH), getString(R.l.dEy), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(257, 3, 1, true);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }, null);
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i2), str);
        if (kVar instanceof f) {
            h hVar = this.nRj;
            hVar.nLX = System.currentTimeMillis();
            hVar.nLY = (long) i2;
            if (i == 0 && i2 == 0) {
                aio aio = ((f) kVar).nLg;
                this.nRp.nua = aio.wrS;
                this.nRp.nRv = aio;
                this.nRp.notifyDataSetChanged();
                this.lJi = new String[aio.wrS.size()];
                Iterator it = aio.wrS.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.lJi[i4] = ((bya) it.next()).vPI;
                    i4++;
                }
                this.nRh = aio.wwx;
                this.nRi = aio.wwy;
                this.nRc = aio.wws;
                this.nRd = aio.www;
                this.nRf = aio.wwv;
                if (this.nRe) {
                    this.nRb = new String[aio.wrS.size()];
                    for (int i5 = 0; i5 < this.nRb.length; i5++) {
                        this.nRb[i5] = aio.www;
                    }
                    this.nRa = new String[aio.wrS.size()];
                    while (i3 < this.nRa.length) {
                        this.nRa[i3] = IPCallDynamicTextView.Dx(((bya) aio.wrS.get(i3)).wMx);
                        i3++;
                    }
                }
                if (((f) kVar).nLh) {
                    x.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.lJi != null && this.lJi.length > 0) {
                        x.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        i.a(this, this.lJi, this.lJw);
                        return;
                    }
                    return;
                }
                if (this.nOr != null && this.nOr.isShowing()) {
                    this.nOr.dismiss();
                }
                aVi();
                return;
            }
            if (this.nOr != null && this.nOr.isShowing()) {
                this.nOr.dismiss();
            }
            Toast.makeText(this.mController.xRr, getString(R.l.eqY), 0).show();
            finish();
        }
    }

    public final void aVi() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
    }
}
