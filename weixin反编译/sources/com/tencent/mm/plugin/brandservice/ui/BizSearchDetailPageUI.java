package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI extends MMActivity implements b {
    private p kKU;
    private BizSearchResultItemContainer kKV;
    private long kKW;
    private String kKX;
    private int kKY;
    private int kKZ;
    private Runnable kLa = new Runnable() {
        public final void run() {
            BizSearchDetailPageUI.this.kKV.aW(BizSearchDetailPageUI.this.kKX, BizSearchDetailPageUI.this.wn);
            BizSearchDetailPageUI.this.wn = 0;
        }
    };
    private int wn;

    protected final int getLayoutId() {
        return R.i.dbv;
    }

    public final void XC() {
    }

    public final void XD() {
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BizSearchDetailPageUI.this.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.kKW = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.kKY = intent.getIntExtra("fromScene", 0);
        this.kKZ = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.wn = intent.getIntExtra("offset", 0);
        if (this.kKW == 0 || bi.oN(stringExtra2)) {
            x.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", Long.valueOf(this.kKW));
            finish();
            return;
        }
        boolean z2;
        jm jmVar;
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        if (byteArrayExtra != null) {
            try {
                jm jmVar2 = (jm) new jm().aH(byteArrayExtra);
                z2 = jmVar2 != null;
                jmVar = jmVar2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                return;
            }
        }
        z2 = false;
        jmVar = null;
        this.kKV = (BizSearchResultItemContainer) findViewById(R.h.cJt);
        this.kKV.a(new c(this));
        this.kKV.d(this.kKW);
        this.kKV.kLz = 1;
        this.kKV.ea(booleanExtra2);
        this.kKV.lO(this.kKY);
        BizSearchResultItemContainer bizSearchResultItemContainer = this.kKV;
        int i = this.kKZ;
        bizSearchResultItemContainer.kKZ = i;
        bizSearchResultItemContainer.kLq.nM(i);
        bizSearchResultItemContainer = this.kKV;
        c.b anonymousClass3 = new c.b() {
            public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
                if (BizSearchDetailPageUI.this.kKY == 1 && aVar.type == 5) {
                    jr jrVar = (jr) aVar.data;
                    if (jrVar.vWJ == null || jrVar.vWJ.vWr == null) {
                        x.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                        return;
                    }
                    jm nL = cVar.nL(i3);
                    String str2 = bi.oM(BizSearchDetailPageUI.this.kKX) + "," + i + "," + bi.oM(str) + "," + i2 + "," + cVar.kLh + "," + (nL == null ? "" : nL.vWw + ",1");
                    g.pWK.k(10866, str2);
                    x.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : " + str2);
                    if ((jrVar.vWJ.vWr.wCq & 8) > 0) {
                        g.pWK.k(10298, str + ",35");
                    }
                }
            }
        };
        if (bizSearchResultItemContainer.kLq != null) {
            bizSearchResultItemContainer.kLq.a(anonymousClass3);
        }
        if (booleanExtra) {
            this.kKU = new p();
            a(this.kKU);
            this.kKU.nC(false);
            this.kKU.clearFocus();
            this.kKU.aay(stringExtra2);
            this.kKU.zvw = this;
            this.kKV.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (BizSearchDetailPageUI.this.kKU != null) {
                        BizSearchDetailPageUI.this.kKU.clearFocus();
                    }
                    BizSearchDetailPageUI.this.aWY();
                    return false;
                }
            });
        } else if (!bi.oN(stringExtra)) {
            setMMTitle(stringExtra);
        }
        if (z2) {
            bizSearchResultItemContainer = this.kKV;
            int i2 = this.wn;
            bizSearchResultItemContainer.reset();
            if (jmVar == null) {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                return;
            }
            bizSearchResultItemContainer.kLs.foW = stringExtra2;
            bizSearchResultItemContainer.d(jmVar.vWt);
            bizSearchResultItemContainer.kLs.hGC = jmVar.vWu;
            bizSearchResultItemContainer.kLx = i2;
            List linkedList = new LinkedList();
            linkedList.add(jmVar);
            bizSearchResultItemContainer.kLq.c(stringExtra2, linkedList);
            bizSearchResultItemContainer.kLs.offset = i2 + jmVar.vUN;
            c cVar = bizSearchResultItemContainer.kLs;
            if (bizSearchResultItemContainer.kLq.isEmpty()) {
                z = false;
            }
            cVar.kLG = z;
            return;
        }
        pd(stringExtra2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.kKU != null) {
            this.kKU.a((FragmentActivity) this, menu);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.kKU != null) {
            this.kKU.a((Activity) this, menu);
        }
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (this.kKU != null) {
            this.kKU.clearFocus();
        }
    }

    public final boolean pc(String str) {
        return false;
    }

    public final void pd(String str) {
        if (!bi.oN(str)) {
            String trim = str.trim();
            if (!trim.equals(this.kKX)) {
                ah.K(this.kLa);
                this.kKX = trim;
                ah.h(this.kLa, 400);
            }
        }
    }

    public final void XA() {
        finish();
    }

    public final void XB() {
    }
}
