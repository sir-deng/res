package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements e {
    private TextWatcher XD = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (NearLifeCreatePoiUI.this.oWw.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.oWx.getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.this.oWy.getText().toString().trim().length() == 0) {
                NearLifeCreatePoiUI.this.enableOptionMenu(0, false);
            } else {
                NearLifeCreatePoiUI.this.enableOptionMenu(0, true);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private String iVa;
    private r jqf;
    private b oWA;
    private com.tencent.mm.plugin.nearlife.b.b oWB;
    private OnClickListener oWC = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("ui_title", R.l.eyl);
            if (NearLifeCreatePoiUI.this.oWu != null) {
                intent.putExtra("extra_province", NearLifeCreatePoiUI.this.oWu.hzg);
                intent.putExtra("extra_city", NearLifeCreatePoiUI.this.oWu.hzh);
            }
            d.b(NearLifeCreatePoiUI.this.mController.xRr, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
        }
    };
    private OnClickListener oWD = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(NearLifeCreatePoiUI.this.mController.xRr, SelectPoiCategoryUI.class);
            NearLifeCreatePoiUI.this.startActivityForResult(intent, 2);
        }
    };
    private OnClickListener oWE = new OnClickListener() {
        public final void onClick(View view) {
            NearLifeCreatePoiUI.this.findViewById(R.h.cTu).setVisibility(8);
            NearLifeCreatePoiUI.this.findViewById(R.h.ctm).setVisibility(0);
            NearLifeCreatePoiUI.this.findViewById(R.h.cto).setVisibility(0);
        }
    };
    private OnMenuItemClickListener oWF = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            g.pWK.h(11138, "2", "0", NearLifeCreatePoiUI.this.iVa);
            NearLifeCreatePoiUI nearLifeCreatePoiUI = NearLifeCreatePoiUI.this;
            Context context = NearLifeCreatePoiUI.this.mController.xRr;
            NearLifeCreatePoiUI.this.getString(R.l.eyj);
            nearLifeCreatePoiUI.jqf = h.a(context, NearLifeCreatePoiUI.this.getString(R.l.eyk), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(NearLifeCreatePoiUI.this.oWB);
                }
            });
            NearLifeCreatePoiUI.this.oWs = NearLifeCreatePoiUI.this.oWw.getText().toString();
            NearLifeCreatePoiUI.this.oWt = NearLifeCreatePoiUI.this.oWy.getText().toString();
            NearLifeCreatePoiUI.this.oWv = NearLifeCreatePoiUI.this.oWx.getText().toString();
            String obj = ((EditText) NearLifeCreatePoiUI.this.findViewById(R.h.ceS)).getText().toString();
            LinkedList g = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
            NearLifeCreatePoiUI.this.oWB = new com.tencent.mm.plugin.nearlife.b.b(NearLifeCreatePoiUI.this.oWs, NearLifeCreatePoiUI.this.oWt, NearLifeCreatePoiUI.this.oWv, NearLifeCreatePoiUI.this.oWr, g.size(), g, obj);
            as.CN().a(NearLifeCreatePoiUI.this.oWB, 0);
            x.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
            return true;
        }
    };
    private a oWG = new a() {
        public final void b(Addr addr) {
            CharSequence charSequence = bi.oM(addr.hzh) + bi.oM(addr.hzj);
            CharSequence charSequence2 = bi.oM(addr.hzk) + bi.oM(addr.hzl);
            x.d("MicroMsg.NearLifeCreatePoiUI", "get address:" + charSequence);
            if (bi.oN(NearLifeCreatePoiUI.this.oWy.getText().toString())) {
                NearLifeCreatePoiUI.this.oWy.setText(charSequence);
            }
            if (bi.oN(NearLifeCreatePoiUI.this.oWx.getText().toString()) && !bi.oN(charSequence2)) {
                NearLifeCreatePoiUI.this.oWx.setText(charSequence2);
            }
            NearLifeCreatePoiUI.this.oWu = addr;
        }
    };
    private OnMenuItemClickListener oWH = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            NearLifeCreatePoiUI.this.bfP();
            return true;
        }
    };
    private aot oWr;
    private String oWs;
    private String oWt;
    private Addr oWu;
    private String oWv;
    private EditText oWw;
    private EditText oWx;
    private TextView oWy;
    private TextView oWz;

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(R.h.cTx)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new bet().Vf(charSequence));
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(650, (e) this);
        this.oWr = new aot();
        this.oWr.vXy = getIntent().getFloatExtra("get_lat", -85.0f);
        this.oWr.vXx = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.oWr.wjv = getIntent().getIntExtra("get_preci", 0);
        this.oWr.wjx = "";
        this.oWr.wjy = 0;
        this.oWr.wjw = "";
        this.oWA = b.OT();
        if (this.oWA != null) {
            this.oWA.a((double) this.oWr.vXy, (double) this.oWr.vXx, this.oWG);
        }
        this.iVa = getIntent().getStringExtra("search_id");
        x.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", this.iVa);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.doK;
    }

    protected final void initView() {
        setMMTitle(R.l.eyj);
        ((ViewGroup) findViewById(R.h.ctn)).setOnClickListener(this.oWC);
        ((ViewGroup) findViewById(R.h.ctm)).setOnClickListener(this.oWD);
        ((TextView) findViewById(R.h.cTu)).setOnClickListener(this.oWE);
        findViewById(R.h.cTu).setVisibility(8);
        findViewById(R.h.ctm).setVisibility(0);
        findViewById(R.h.cto).setVisibility(0);
        this.oWw = (EditText) findViewById(R.h.ceR);
        this.oWx = (EditText) findViewById(R.h.ceQ);
        this.oWy = (TextView) findViewById(R.h.cTy);
        this.oWz = (TextView) findViewById(R.h.cTx);
        this.oWw.addTextChangedListener(this.XD);
        this.oWx.addTextChangedListener(this.XD);
        this.oWy.addTextChangedListener(this.XD);
        Object aD = bi.aD(getIntent().getStringExtra("get_poi_name"), "");
        if (aD.length() != 0) {
            this.oWw.setText(aD);
            this.oWw.setSelection(aD.length());
        }
        c.d(this.oWw).Hg(100).a(null);
        c.d(this.oWx).Hg(400).a(null);
        c.d((EditText) findViewById(R.h.ceS)).Hg(100).a(null);
        a(0, getString(R.l.dFw), this.oWF, p.b.xSe);
        enableOptionMenu(0, false);
        setBackBtn(this.oWH);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!bi.oN(stringExtra)) {
                    ((TextView) findViewById(R.h.cTy)).setText(stringExtra.replace(" ", ""));
                    return;
                }
                return;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.oWz.setText(bi.oM(intent.getStringExtra("poi_category")));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(650, (e) this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != keyEvent.getKeyCode()) {
            return super.onKeyDown(i, keyEvent);
        }
        bfP();
        return true;
    }

    private void bfP() {
        h.a((Context) this, R.l.eyg, R.l.eyj, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.pWK.h(11138, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "0", NearLifeCreatePoiUI.this.iVa);
                NearLifeCreatePoiUI.this.setResult(0, new Intent());
                NearLifeCreatePoiUI.this.finish();
            }
        }, null);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            this.jqf.dismiss();
            com.tencent.mm.plugin.nearlife.b.b bVar = (com.tencent.mm.plugin.nearlife.b.b) kVar;
            Intent intent = new Intent();
            if (this.oWr != null) {
                intent.putExtra("get_lat", this.oWr.vXy);
                intent.putExtra("get_lng", this.oWr.vXx);
            }
            if (this.oWu != null) {
                intent.putExtra("get_city", this.oWu.hzh);
            }
            intent.putExtra("get_poi_address", this.oWt);
            intent.putExtra("get_poi_classify_id", bVar.oVi);
            intent.putExtra("get_poi_name", this.oWs);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            return;
        }
        this.jqf.dismiss();
        Toast.makeText(this.mController.xRr, getString(R.l.eyh), 1).show();
        this.oWB = null;
    }
}
