package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.mh;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements j.a {
    private Button lXK;
    private TextView lpZ;
    private HtmlTextView pkV;
    private TextView plS;
    private f plY;
    protected c plp;
    private LinearLayout pmA;
    private LinearLayout pmB;
    private ImageView pmC;
    private TextView pmD;
    private HtmlTextView pmE;
    private RelativeLayout pmF;
    private ListView pmG;
    private k pmH = null;
    private Button pmI;
    private ListView pmx;
    private a pmy;

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        List list = mallProductUI.plp.pjt;
        if (list != null && list.size() > 0) {
            mallProductUI.pmH.pmi = list;
        }
    }

    protected final int getLayoutId() {
        return g.uKj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            return;
        }
        initView();
        com.tencent.mm.plugin.product.a.a.bjs();
        this.plp = com.tencent.mm.plugin.product.a.a.bjt();
        this.plY = new f(this.mController.xRr, new f.a() {
            public final void m(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    MallProductUI.this.av();
                    if (MallProductUI.this.lXK != null) {
                        MallProductUI.this.lXK.postDelayed(new Runnable() {
                            public final void run() {
                                ScrollView scrollView = (ScrollView) MallProductUI.this.findViewById(f.uxO);
                                if (scrollView != null) {
                                    scrollView.pageScroll(33);
                                }
                            }
                        }, 200);
                    }
                } else if (i2 == -10010003) {
                    MallProductUI.this.uV(0);
                    MallProductUI.this.pmA.setVisibility(8);
                    MallProductUI.this.pmB.setVisibility(0);
                    MallProductUI.d(MallProductUI.this);
                } else {
                    MallProductUI.this.HY(str);
                }
            }
        });
        f fVar = this.plY;
        com.tencent.mm.kernel.g.Dt().a(new com.tencent.mm.plugin.product.ui.f.AnonymousClass1(getIntent(), new m()));
        fVar.pln = true;
        b mhVar = new mh();
        mhVar.fEP.errCode = -1;
        mhVar.frD = new com.tencent.mm.plugin.product.ui.f.AnonymousClass2(mhVar);
        com.tencent.mm.sdk.b.a.xmy.a(mhVar, Looper.getMainLooper());
    }

    protected void onResume() {
        super.onResume();
        this.plY.onStart();
    }

    protected void onPause() {
        this.plY.onStop();
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(i.uSp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                f e = MallProductUI.this.plY;
                if (!bi.oN(e.plp.pju)) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.plugin.product.b.f(e.plp.bjI(), e.plp.pju), 0);
                }
                e.plp.clear();
                MallProductUI.this.finish();
                return true;
            }
        });
        this.pmA = (LinearLayout) findViewById(f.uxd);
        this.pmB = (LinearLayout) findViewById(f.uxy);
        this.pmC = (ImageView) findViewById(f.uxb);
        this.lpZ = (TextView) findViewById(f.uwX);
        this.plS = (TextView) findViewById(f.uxg);
        this.pmD = (TextView) findViewById(f.uxe);
        this.pmD.getPaint().setFlags(16);
        this.pmF = (RelativeLayout) findViewById(f.uwZ);
        this.pkV = (HtmlTextView) findViewById(f.uwY);
        this.pmE = (HtmlTextView) findViewById(f.uxf);
        this.pmx = (ListView) findViewById(f.uwW);
        this.pmy = new a(this);
        this.pmx.setAdapter(this.pmy);
        this.pmx.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 2:
                        m mVar = MallProductUI.this.plp.pjs;
                        if (mVar.pjW.pkk != null && mVar.pjW.pkk.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = mVar.pjW.pkk.iterator();
                            while (it.hasNext()) {
                                arrayList.add((String) it.next());
                            }
                            bVar.pkW = arrayList;
                            break;
                        }
                }
                MallProductUI.this.pmy.a(MallProductUI.this, view, i);
            }
        });
        this.pmI = (Button) findViewById(f.uxq);
        this.pmI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f e = MallProductUI.this.plY;
                e.T(e.iTL, e.plp.bjB());
            }
        });
        this.pmG = (ListView) findViewById(f.uxz);
        this.pmH = new k(this);
        this.pmH.pmb = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m mVar = (m) view.getTag();
                f e = MallProductUI.this.plY;
                if (mVar != null && mVar.pmm != null) {
                    n.a aVar = mVar.pmm;
                    x.i("MicroMsg.MallProductUI", "goProductUI type : " + aVar.type);
                    Intent intent;
                    switch (aVar.type) {
                        case 0:
                            intent = new Intent();
                            intent.putExtra("rawUrl", aVar.url);
                            d.b(e.iTL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                            return;
                        case 1:
                            String replace = aVar.data.replace("product_id=", "");
                            intent = new Intent();
                            intent.putExtra("key_product_id", replace);
                            intent.putExtra("key_product_scene", 6);
                            d.b(e.iTL, "mall", ".product.ui.MallProductUI", intent);
                            e.iTL.finish();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.pmG.setAdapter(this.pmH);
        this.lXK = (Button) findViewById(f.uxa);
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f e = MallProductUI.this.plY;
                if (e.plp.bjF()) {
                    e.iTL.startActivity(new Intent(e.iTL, MallProductSelectSkuUI.class));
                    com.tencent.mm.plugin.report.service.g.pWK.h(11008, e.plp.bjB(), e.plp.pjs.pjS, Integer.valueOf(f.itU), Integer.valueOf(1));
                    return;
                }
                u.makeText(e.iTL, i.uRY, 1).show();
            }
        });
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray = MallProductUI.this.getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.ugQ);
                List arrayList = new ArrayList();
                for (Object add : stringArray) {
                    arrayList.add(add);
                }
                boolean z = (MallProductUI.this.plp.bjv().pll & 1) > 0;
                x.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = " + z);
                if (z) {
                    arrayList.add(MallProductUI.this.getString(i.uSe));
                }
                h.a(MallProductUI.this.mController.xRr, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new h.c() {
                    public final void jo(int i) {
                        f e;
                        String bjL;
                        Intent intent;
                        switch (i) {
                            case 0:
                                e = MallProductUI.this.plY;
                                bjL = e.plp.bjL();
                                intent = new Intent();
                                intent.putExtra("Retr_Msg_content", bjL);
                                intent.putExtra("Retr_Msg_Type", 2);
                                if (!bi.oN(e.plp.pjs.bjO())) {
                                    intent.putExtra("Retr_Msg_thumb_path", e.plp.bjC());
                                }
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                intent.putExtra("Retr_Msg_Type", 2);
                                d.a(e.iTL, ".ui.transmit.MsgRetransmitUI", intent);
                                if (f.itU == 4) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(10651, Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0));
                                    return;
                                }
                                return;
                            case 1:
                                e = MallProductUI.this.plY;
                                m mVar = e.plp.pjs;
                                intent = new Intent();
                                intent.putExtra("KContentObjDesc", e.plp.bjM());
                                intent.putExtra("Ksnsupload_title", mVar.pjW.name);
                                intent.putExtra("Ksnsupload_link", e.plp.bjD());
                                intent.putExtra("Ksnsupload_imgurl", e.plp.pjs.bjO());
                                if (!bi.oN(e.plp.pjs.bjO())) {
                                    intent.putExtra("KsnsUpload_imgPath", e.plp.bjC());
                                }
                                intent.putExtra("Ksnsupload_type", 6);
                                intent.putExtra("KUploadProduct_UserData", e.plp.a(mVar));
                                intent.putExtra("KUploadProduct_subType", mVar.pjT);
                                bjL = com.tencent.mm.y.u.hC("scan_product");
                                com.tencent.mm.y.u.GQ().t(bjL, true).o("prePublishId", "scan_product");
                                intent.putExtra("reportSessionId", bjL);
                                d.b(e.iTL, "sns", ".ui.SnsUploadUI", intent);
                                if (f.itU == 4) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(10651, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0));
                                    return;
                                }
                                return;
                            case 2:
                                MallProductUI.this.plY.bjS();
                                return;
                            case 3:
                                e = MallProductUI.this.plY;
                                e.S(e.iTL, e.plp.bjB());
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        showOptionMenu(false);
        this.pmC.setFocusable(true);
        this.pmC.setFocusableInTouchMode(true);
        this.pmC.requestFocus();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
    }

    protected final void av() {
        m mVar = this.plp.pjs;
        if (mVar == null) {
            showOptionMenu(false);
            return;
        }
        showOptionMenu(true);
        uV(0);
        this.pmA.setVisibility(0);
        this.pmB.setVisibility(8);
        if (mVar.pjW != null) {
            this.lpZ.setText(mVar.pjW.name);
            this.plS.setText(com.tencent.mm.plugin.product.b.b.l(mVar.pjW.pki, mVar.pjW.pkj, mVar.pjW.pgf));
            this.pmD.setText(com.tencent.mm.plugin.product.b.b.c((double) mVar.pjW.pkh, mVar.pjW.pgf));
        }
        if (this.plp.bjE() <= 0) {
            this.lXK.setEnabled(false);
            this.lXK.setText(i.uSg);
        } else if (this.plp.pjs.pjV <= 0) {
            this.lXK.setEnabled(false);
            this.lXK.setText(i.uSf);
        } else {
            this.lXK.setEnabled(true);
            if (bi.oN(mVar.pkb)) {
                this.lXK.setText(i.uxa);
            } else {
                this.lXK.setText(mVar.pkb);
            }
        }
        if (mVar.pjW == null || mVar.pjW.pks == null || mVar.pjW.pks.size() <= 0) {
            this.pmx.setVisibility(8);
        } else {
            this.pmx.setVisibility(0);
            this.pmy.bp(mVar.pjW.pks);
            this.pmy.notifyDataSetChanged();
        }
        if (mVar.pjW == null || bi.oN(mVar.pjW.pkl)) {
            this.pmF.setVisibility(8);
            this.pkV.setVisibility(8);
        } else {
            this.pmF.setVisibility(0);
            this.pkV.setVisibility(0);
            this.pkV.setText(mVar.pjW.pkl);
        }
        if (bi.oN(mVar.pkc)) {
            this.pmE.setVisibility(8);
        } else {
            this.pmE.setVisibility(0);
            this.pmE.setText(mVar.pkc);
        }
        showOptionMenu(true);
        if (!bi.oN(this.plp.pjA)) {
            this.pmC.setImageBitmap(j.a(new c(this.plp.pjA)));
            j.a((j.a) this);
        }
    }

    public final void l(String str, final Bitmap bitmap) {
        if (str != null && str.equals(this.plp.pjA)) {
            this.pmC.post(new Runnable() {
                public final void run() {
                    MallProductUI.this.pmC.setImageBitmap(bitmap);
                }
            });
        }
    }
}
