package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.i;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.favorite.ui.base.FavVoiceBaseView;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;

public class FavoriteVoiceDetailUI extends BaseFavDetailReportUI implements a {
    private long mCL;
    private FavDetailTitleView mCm;
    private FavDetailFooterView mCn;
    private FavTagEntrance mCo;
    private FavVoiceBaseView mDr;
    private i mwG;
    private f mwn;

    protected final int getLayoutId() {
        return R.i.die;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.eeX));
        this.mCL = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mwn = h.getFavItemInfoStorage().dc(this.mCL);
        if (this.mwn == null) {
            x.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            h(this.mwn);
            this.mCm = (FavDetailTitleView) findViewById(R.h.cgB);
            this.mCm.F(this.mwn);
            this.mCn = (FavDetailFooterView) findViewById(R.h.cgA);
            this.mCn.F(this.mwn);
            this.mwG = new i();
            this.mDr = (FavVoiceBaseView) findViewById(R.h.cWE);
            i.a aVar = this.mDr;
            aVar.mwG = this.mwG;
            aVar.mwG.a(aVar);
            uz p = j.p(this.mwn);
            String h = j.h(p);
            int AJ = j.AJ(p.wkc);
            if (!e.bO(h)) {
                j.o(this.mwn);
            }
            this.mDr.K(h, AJ, p.duration);
            this.mCo = (FavTagEntrance) findViewById(R.h.chk);
            this.mCo.dt(this.mwn.field_localId);
            this.mCo.aP(this.mwn.field_tagProto.wmn);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    FavoriteVoiceDetailUI.this.finish();
                    return true;
                }
            });
            addIconOptionMenu(0, R.l.eRy, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    g gVar = new g(FavoriteVoiceDetailUI.this.mController.xRr, g.zCt, false);
                    gVar.rQF = new c() {
                        public final void a(n nVar) {
                            nVar.f(0, FavoriteVoiceDetailUI.this.getString(R.l.efl));
                            nVar.f(1, FavoriteVoiceDetailUI.this.mController.xRr.getString(R.l.dEH));
                        }
                    };
                    gVar.rQG = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent(FavoriteVoiceDetailUI.this.mController.xRr, FavTagEditUI.class);
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.this.mwn.field_localId);
                                    FavoriteVoiceDetailUI.this.mController.xRr.startActivity(intent);
                                    com.tencent.mm.plugin.fav.a.g.a b = FavoriteVoiceDetailUI.this.muu;
                                    b.mtR++;
                                    return;
                                case 1:
                                    com.tencent.mm.ui.base.h.a(FavoriteVoiceDetailUI.this.mController.xRr, FavoriteVoiceDetailUI.this.getString(R.l.dEI), "", new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            final r a = com.tencent.mm.ui.base.h.a(FavoriteVoiceDetailUI.this.mController.xRr, FavoriteVoiceDetailUI.this.getString(R.l.dEI), false, null);
                                            final long j = FavoriteVoiceDetailUI.this.mwn.field_localId;
                                            final long j2 = (long) FavoriteVoiceDetailUI.this.mwn.field_id;
                                            j.a(FavoriteVoiceDetailUI.this.mwn.field_localId, new Runnable() {
                                                public final void run() {
                                                    FavoriteVoiceDetailUI.this.muu.mtS = true;
                                                    a.dismiss();
                                                    x.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", Long.valueOf(j), Long.valueOf(j2));
                                                    FavoriteVoiceDetailUI.this.finish();
                                                }
                                            });
                                        }
                                    }, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    gVar.bUX();
                    return true;
                }
            });
        }
        h.getFavItemInfoStorage().c(this);
        if (this.mCo != null) {
            h.getFavItemInfoStorage().c(this.mCo);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mDr.stopPlay();
        this.mwG.destroy();
        h.getFavItemInfoStorage().j(this);
        if (this.mCo != null) {
            h.getFavItemInfoStorage().j(this.mCo);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.mDr.aJj();
        this.mwG.pause();
    }

    public final void a(String str, l lVar) {
        this.mwn = h.getFavItemInfoStorage().dc(this.mCL);
        if (this.mwn == null) {
            x.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
        } else if (this.mwn.field_itemStatus == 10 && lVar != null && lVar.xsg != null && this.mwn.field_favProto.wlY.size() > 0) {
            uz p = j.p(this.mwn);
            String h = j.h(p);
            int AJ = j.AJ(p.wkc);
            x.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
            this.mDr.K(h, AJ, p.duration);
        }
    }

    protected final String i(f fVar) {
        if (this.mwn.field_favProto.wlY.size() > 0) {
            return String.valueOf(j.p(this.mwn).duration);
        }
        return "0";
    }
}
