package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.ui.b.a;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.LinkedList;

public class AuthorizedGameListUI extends MMActivity implements OnItemClickListener, t {
    public static int nqv = 1;
    public static int nqw = 2;
    public static int nqx = 4;
    public static int nqy = 5;
    public static int nqz = 6;
    private ProgressDialog inI = null;
    private int niV = 0;
    private ListView nqr;
    private a nqs;
    private View nqt;
    private int nqu = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.niV = getIntent().getIntExtra("game_report_from_scene", 0);
        SubCoreGameCenter.aRP().a(3, (t) this);
        initView();
        final k xVar = new x(3, new aw(w.d(getSharedPreferences(ad.cgf(), 0))));
        as.CN().a(xVar, 0);
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(xVar);
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.cmJ;
    }

    protected final void initView() {
        this.nqr = (ListView) findViewById(R.h.cmK);
        this.nqt = findViewById(R.h.cel);
        this.nqs = new a(this);
        this.nqs.nqC = new a() {
            public final void rf(int i) {
                if (i <= 0) {
                    AuthorizedGameListUI.this.nqr.setVisibility(8);
                    AuthorizedGameListUI.this.nqt.setVisibility(0);
                    return;
                }
                AuthorizedGameListUI.this.nqr.setVisibility(0);
                AuthorizedGameListUI.this.nqt.setVisibility(8);
            }
        };
        this.nqr.setVerticalScrollBarEnabled(false);
        this.nqr.setOnItemClickListener(this);
        this.nqr.setAdapter(this.nqs);
        setMMTitle(R.l.emM);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AuthorizedGameListUI.this.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        SubCoreGameCenter.aRP().b(3, this);
        if (this.nqs != null) {
            this.nqs.clear();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, GameSettingsUI.class);
        this.nqu = i;
        intent.putExtra("game_app_id", ((dx) this.nqs.getItem(i)).nkU);
        intent.putExtra("game_report_from_scene", this.niV);
        startActivityForResult(intent, 0);
        ap.a((Context) this, 10, 1008, nqw, 6, this.niV, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AuthorizedGameListUI", "invaild requestcode" + i);
            return;
        }
        if (i2 == -1) {
            this.nqs.remove(this.nqu);
            ap.a(this.mController.xRr, 10, 1008, nqx, 21, 1, intent.getStringExtra("game_app_id"), this.niV, 0, null, null, null);
        }
        if (this.nqs != null) {
            this.nqs.notifyDataSetChanged();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.w wVar) {
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (i == 0 && i2 == 0) {
            LinkedList linkedList = ((yp) ((aw) wVar).lSH.hnR.hnY).wpF;
            if (linkedList == null || linkedList.size() == 0) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AuthorizedGameListUI", "no authapp");
            }
            this.nqs.P(linkedList);
            return;
        }
        Toast.makeText(this, getString(R.l.emK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
