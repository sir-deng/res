package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class QrRewardSelectMoneyUI extends QrRewardBaseUI {
    private int fDM;
    private String jhS;
    private String lpC;
    private String lpE;
    private String lpG;
    private String lpH;
    private String lpI;
    private String lpJ;
    private String lpK;
    private int lpL;
    private a lqA;
    private String lqB;
    private String lqC;
    private List<Integer> lqs = new ArrayList();
    private ImageView lqt;
    private TextView lqu;
    private TextView lqv;
    private TextView lqw;
    private TextView lqx;
    private MMGridView lqy;
    private TextView lqz;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, byte b) {
            this();
        }

        public final int getCount() {
            return QrRewardSelectMoneyUI.this.lqs.size();
        }

        public final Object getItem(int i) {
            return QrRewardSelectMoneyUI.this.lqs.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(QrRewardSelectMoneyUI.this.mController.xRr).inflate(g.uKm, viewGroup, false);
            }
            int intValue = ((Integer) getItem(i)).intValue();
            TextView textView = (TextView) view.findViewById(f.uAG);
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                textView.setText(String.format("%.2f", new Object[]{Double.valueOf(r4)}) + QrRewardSelectMoneyUI.this.getString(i.uTp));
            } else {
                textView.setText(String.format("%d", new Object[]{Integer.valueOf(r2)}) + QrRewardSelectMoneyUI.this.getString(i.uTp));
            }
            return view;
        }
    }

    static /* synthetic */ void a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, int i, int i2) {
        x.i("MicroMsg.QrRewardSelectMoneyUI", "go to grant ui");
        Intent intent = new Intent(qrRewardSelectMoneyUI.mController.xRr, QrRewardGrantUI.class);
        intent.putExtra("key_amt_type", i2);
        if (i2 == 1) {
            intent.putExtra("key_money_amt", i);
        }
        intent.putExtra("key_rcvr_name", qrRewardSelectMoneyUI.lpG);
        intent.putExtra("key_rcvr_true_name", qrRewardSelectMoneyUI.lpH);
        intent.putExtra("key_rcvr_open_id", qrRewardSelectMoneyUI.lpE);
        intent.putExtra("key_qrcode_desc", qrRewardSelectMoneyUI.lpC);
        intent.putExtra("key_channel", qrRewardSelectMoneyUI.fDM);
        intent.putExtra("key_web_url", qrRewardSelectMoneyUI.jhS);
        intent.putExtra("key_scan_id", qrRewardSelectMoneyUI.lpI);
        intent.putExtra("key_sxtend_1", qrRewardSelectMoneyUI.lpJ);
        intent.putExtra("key_sxtend_2", qrRewardSelectMoneyUI.lpK);
        intent.putExtra("key_max_amt", qrRewardSelectMoneyUI.lpL);
        qrRewardSelectMoneyUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void b(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
        String str = qrRewardSelectMoneyUI.lpG;
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.k.a Xu = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xu(str);
        if (Xu == null || ((int) Xu.gKO) <= 0) {
            x.d("MicroMsg.QrRewardSelectMoneyUI", "Receiver in contactStg and try to get contact");
            final long Wy = bi.Wy();
            com.tencent.mm.y.ak.a.hhv.a(str, "", new com.tencent.mm.y.ak.b.a() {
                public final void v(String str, boolean z) {
                    if (z) {
                        x.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bi.Wy() - Wy) + " ms");
                        b.I(str, 3);
                        n.JY().jb(str);
                    } else {
                        x.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
                    }
                    com.tencent.mm.pluginsdk.ui.a.b.a(QrRewardSelectMoneyUI.this.lqt, str, 0.03f, false);
                    QrRewardSelectMoneyUI.this.lqv.setText(com.tencent.mm.pluginsdk.ui.d.i.a(QrRewardSelectMoneyUI.this.mController.xRr, e.gw(str)));
                }
            });
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(qrRewardSelectMoneyUI.lqt, str, 0.03f, false);
            qrRewardSelectMoneyUI.lqv.setText(com.tencent.mm.pluginsdk.ui.d.i.a(qrRewardSelectMoneyUI.mController.xRr, e.gw(str)));
        }
        if (!bi.oN(qrRewardSelectMoneyUI.lpC)) {
            qrRewardSelectMoneyUI.lqw.setText(com.tencent.mm.pluginsdk.ui.d.i.b(qrRewardSelectMoneyUI, qrRewardSelectMoneyUI.getString(i.uTo, new Object[]{qrRewardSelectMoneyUI.lpC}), qrRewardSelectMoneyUI.lqw.getTextSize()));
        }
        if (bi.oN(qrRewardSelectMoneyUI.lqC)) {
            qrRewardSelectMoneyUI.lqu.setVisibility(8);
        } else {
            qrRewardSelectMoneyUI.lqu.setText(qrRewardSelectMoneyUI.lqC);
        }
        qrRewardSelectMoneyUI.lqA.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1516);
        setMMTitle(i.uTf);
        uV(4);
        this.lqB = getIntent().getStringExtra("key_qrcode_url");
        this.fDM = getIntent().getIntExtra("key_channel", 0);
        this.jhS = getIntent().getStringExtra("key_web_url");
        x.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
        l(new com.tencent.mm.plugin.collect.reward.a.f(this.lqB, this.fDM, this.jhS));
        initView();
        int intExtra = getIntent().getIntExtra("key_scene", 0);
        x.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", Integer.valueOf(intExtra));
        com.tencent.mm.plugin.report.service.g.pWK.h(14721, Integer.valueOf(2), Integer.valueOf(intExtra));
    }

    protected final void azD() {
    }

    protected final void initView() {
        this.lqt = (ImageView) findViewById(f.uAH);
        this.lqu = (TextView) findViewById(f.uAM);
        this.lqv = (TextView) findViewById(f.uAK);
        this.lqw = (TextView) findViewById(f.uAI);
        this.lqx = (TextView) findViewById(f.uAN);
        this.lqy = (MMGridView) findViewById(f.uAJ);
        this.lqz = (TextView) findViewById(f.uAL);
        this.lqA = new a();
        this.lqy.setAdapter(this.lqA);
        this.lqy.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, ((Integer) adapterView.getAdapter().getItem(i)).intValue(), 1);
            }
        });
        this.lqz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.collect.reward.a.f) {
            final com.tencent.mm.plugin.collect.reward.a.f fVar = (com.tencent.mm.plugin.collect.reward.a.f) kVar;
            fVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(k kVar) {
                    x.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
                    QrRewardSelectMoneyUI.this.lpG = fVar.lpj.wbs;
                    QrRewardSelectMoneyUI.this.lpH = fVar.lpj.pQF;
                    QrRewardSelectMoneyUI.this.lpL = fVar.lpj.wbe;
                    QrRewardSelectMoneyUI.this.lpE = fVar.lpj.wbp;
                    QrRewardSelectMoneyUI.this.lpC = fVar.lpj.desc;
                    QrRewardSelectMoneyUI.this.lpJ = fVar.lpj.wbx;
                    QrRewardSelectMoneyUI.this.lpK = fVar.lpj.wby;
                    QrRewardSelectMoneyUI.this.lpI = fVar.lpj.wbv;
                    QrRewardSelectMoneyUI.this.lqC = fVar.lpj.wbA;
                    QrRewardSelectMoneyUI.this.lqs = fVar.lpj.wbc;
                    if (QrRewardSelectMoneyUI.this.lqs == null) {
                        x.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
                        QrRewardSelectMoneyUI.this.lqs = new LinkedList();
                    }
                    QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this);
                }
            }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
                    if (!bi.oN(fVar.lpj.lou)) {
                        Toast.makeText(QrRewardSelectMoneyUI.this, fVar.lpj.lou, 1).show();
                    }
                    QrRewardSelectMoneyUI.this.finish();
                }
            }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", fVar);
                    com.tencent.mm.ui.base.h.a(QrRewardSelectMoneyUI.this.mController.xRr, QrRewardSelectMoneyUI.this.getString(i.vdG), null, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            QrRewardSelectMoneyUI.this.finish();
                        }
                    });
                }
            });
            super.azD();
            uV(0);
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.uKn;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1516);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            x.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
            finish();
        }
    }
}
