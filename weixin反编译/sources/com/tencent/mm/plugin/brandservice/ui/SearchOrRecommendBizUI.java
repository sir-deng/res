package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.y;
import com.tencent.mm.plugin.brandservice.a.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import com.tencent.mm.y.as;
import java.util.List;

public class SearchOrRecommendBizUI extends MMActivity implements b {
    private int kKB = 0;
    private BizSearchResultItemContainer kKV;
    private int kKY = 0;
    private ProgressDialog kMF = null;
    private SearchViewNotRealTimeHelper kMG;

    protected final int getLayoutId() {
        return R.i.dff;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kKB = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.kKY = getIntent().getIntExtra("fromScene", 0);
        initView();
        if (g.asQ()) {
            as.CN().a(456, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    if (kVar == null) {
                        x.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
                    } else if (kVar.getType() != 456) {
                        x.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
                    } else {
                        as.CN().b(456, (e) this);
                        x.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            List asR = g.asR();
                            final f fVar = SearchOrRecommendBizUI.this.kKV == null ? null : (f) SearchOrRecommendBizUI.this.kKV.kLq;
                            if (fVar != null && asR != null && asR.size() > 0) {
                                int i3;
                                if (fVar.getCount() == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                fVar.kMB = asR;
                                if (i3 != 0) {
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            x.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                            fVar.notifyDataSetChanged();
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
            as.CN().a(new g(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!bi.oN(stringExtra)) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    SearchOrRecommendBizUI.this.kMG.aay(stringExtra);
                    SearchOrRecommendBizUI.this.kMG.zvI.performClick();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        y.Mt().Mf();
    }

    protected final void initView() {
        setMMTitle(R.l.dXz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SearchOrRecommendBizUI.this.aWY();
                SearchOrRecommendBizUI.this.finish();
                return true;
            }
        });
        this.kMG = (SearchViewNotRealTimeHelper) findViewById(R.h.cKl);
        SearchViewNotRealTimeHelper searchViewNotRealTimeHelper = this.kMG;
        searchViewNotRealTimeHelper.yqL.setTextColor(getResources().getColor(R.e.btv));
        this.kMG.V(getString(R.l.dXz));
        searchViewNotRealTimeHelper = this.kMG;
        searchViewNotRealTimeHelper.yqL.setHintTextColor(getResources().getColor(R.e.bsN));
        this.kMG.yqL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        searchViewNotRealTimeHelper = this.kMG;
        if (searchViewNotRealTimeHelper.zpo != null) {
            searchViewNotRealTimeHelper.zpo.setVisibility(8);
        }
        this.kMG.zvJ = new a() {
            public final boolean pc(String str) {
                wx(str);
                return true;
            }

            public final void wx(String str) {
                if (bi.oN(str)) {
                    h.bu(SearchOrRecommendBizUI.this.mController.xRr, SearchOrRecommendBizUI.this.getString(R.l.dXx));
                    return;
                }
                SearchOrRecommendBizUI.this.aWY();
                SearchOrRecommendBizUI.this.kKV.aW(str, 0);
            }

            public final void ati() {
                SearchOrRecommendBizUI.this.showVKB();
            }
        };
        this.kKV = (BizSearchResultItemContainer) findViewById(R.h.cJt);
        this.kKV.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SearchOrRecommendBizUI.this.kMG.clearFocus();
                SearchOrRecommendBizUI.this.aWY();
                return false;
            }
        });
        c fVar = new f(this);
        fVar.kMB = g.asR();
        this.kKV.a(fVar);
        this.kKV.d(1);
        this.kKV.ea(false);
        this.kKV.kLz = 1;
        this.kKV.lO(this.kKY);
        this.kKV.kLv = this;
    }

    public final void asX() {
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.kMF = h.a(context, getString(R.l.dXy), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                BizSearchResultItemContainer a = SearchOrRecommendBizUI.this.kKV;
                as.CN().c(a.kLu);
                a.kLs.kLF = false;
            }
        });
    }

    public final void asY() {
        if (this.kMF != null) {
            this.kMF.dismiss();
            this.kMF = null;
        }
    }
}
