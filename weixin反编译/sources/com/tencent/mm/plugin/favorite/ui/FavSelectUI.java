package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.s;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private String mzb;
    private b mzc = null;
    private Set<Integer> mzd = new HashSet();
    private d mze = new d();
    private String toUser;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.mzb = getIntent().getStringExtra("key_fav_item_id");
        if (this.mzb != null) {
            for (String str : this.mzb.split(",")) {
                int i = bi.getInt(str, Integer.MAX_VALUE);
                if (Integer.MAX_VALUE != i) {
                    this.mzd.add(Integer.valueOf(i));
                }
            }
        }
        this.mzd.remove(Integer.valueOf(3));
        this.mzc.e(this.mzd);
        this.mze.mvk = false;
        this.mzc.a(this.mze);
        this.mxw.post(new Runnable() {
            public final void run() {
                FavSelectUI.this.mzc.aKb();
                FavSelectUI.this.aJM();
            }
        });
        addIconOptionMenu(0, R.k.dvm, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(FavSelectUI.this.mController.xRr, FavSearchUI.class);
                intent.putExtra("key_to_user", FavSelectUI.this.toUser);
                intent.putExtra("key_fav_item_id", FavSelectUI.this.mzb);
                intent.putExtra("key_search_type", 1);
                intent.putExtra("key_enter_fav_search_from", 1);
                FavSelectUI.this.startActivityForResult(intent, 0);
                return true;
            }
        });
        setMMTitle(R.l.egJ);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavSelectUI.this.finish();
                return true;
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final a.b bVar = (a.b) view.getTag();
        if (bVar == null) {
            x.w("MicroMsg.FavSelectUI", "on item click, holder is null");
        } else if (bVar.mwn == null) {
            x.w("MicroMsg.FavSelectUI", "on item click, info is null");
        } else {
            f fVar = bVar.mwn;
            g.pWK.h(10651, Integer.valueOf(fVar.field_type), Integer.valueOf(1), Integer.valueOf(1));
            if (fVar.field_type == 3) {
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.dBZ));
            } else if (fVar.field_type == 8 && s.gI(this.toUser)) {
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.dBX));
            } else {
                e.a aVar = new e.a(this.mController.xRr);
                aVar.bT(this.toUser);
                com.tencent.mm.plugin.favorite.ui.b.e.a(aVar, this.mController.xRr, bVar.mwn);
                com.tencent.mm.plugin.favorite.ui.b.e.b(aVar, this.mController.xRr, bVar.mwn);
                aVar.f(Boolean.valueOf(true)).Co(R.l.dGL).a(new o.a() {
                    public final void a(boolean z, String str, int i) {
                        FavSelectUI.this.aWY();
                        if (z) {
                            final Dialog a = h.a(FavSelectUI.this.mController.xRr, FavSelectUI.this.getString(R.l.efM), false, null);
                            com.tencent.mm.plugin.favorite.a.e.a(FavSelectUI.this.mController.xRr, FavSelectUI.this.toUser, str, bVar.mwn, new Runnable() {
                                public final void run() {
                                    if (a != null) {
                                        a.dismiss();
                                    }
                                    com.tencent.mm.ui.snackbar.a.h(FavSelectUI.this, FavSelectUI.this.getString(R.l.eip));
                                    ah.h(new Runnable() {
                                        public final void run() {
                                            FavSelectUI.this.finish();
                                        }
                                    }, 1800);
                                }
                            });
                        }
                    }
                }).pDT.show();
            }
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a aJI() {
        if (this.mzc == null) {
            ActionBarActivity actionBarActivity = this.mController.xRr;
            this.mzc = new b(this.muM, false);
        }
        return this.mzc;
    }

    protected final void aJJ() {
    }

    protected final boolean aJK() {
        return com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().getCount() > 0;
    }

    protected final void aJL() {
        this.mxu.setCompoundDrawablesWithIntrinsicBounds(0, R.g.bCf, 0, 0);
        this.mxu.setCompoundDrawablePadding(com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 10));
        this.mxu.setText(R.l.efn);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && -1 == i2) {
            finish();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mzc != null) {
            this.mzc.finish();
        }
    }
}
