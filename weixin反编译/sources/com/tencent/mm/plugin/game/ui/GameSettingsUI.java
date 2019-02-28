package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.game.c.az;
import com.tencent.mm.plugin.game.c.ba;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.at;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Map;

public class GameSettingsUI extends MMActivity implements e, t {
    private String appId;
    private ProgressDialog inI = null;
    private CheckBox nBA;
    private AuthorizationInfoLayout nBB;
    private ArrayList<String> nBC;
    private boolean nBD;
    private TextView nBv;
    private TextView nBw;
    private CheckBox nBx;
    private View nBy;
    private View nBz;
    private int niV = 0;
    private ImageView nqo;
    private TextView nqp;
    private f nrn;

    static /* synthetic */ void a(GameSettingsUI gameSettingsUI, boolean z) {
        gameSettingsUI.g(new x(2, z ? new aj(gameSettingsUI.appId, 0, "1") : new aj(gameSettingsUI.appId, 0, "0")));
    }

    static /* synthetic */ void b(GameSettingsUI gameSettingsUI, boolean z) {
        int i = 0;
        if (!z) {
            i = 1;
        }
        gameSettingsUI.nBD = z;
        gameSettingsUI.g(new at(gameSettingsUI.appId, 1, i));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.niV = getIntent().getIntExtra("game_report_from_scene", 0);
        SubCoreGameCenter.aRP().a(2, (t) this);
        as.CN().a(1221, (e) this);
        this.appId = getIntent().getStringExtra("game_app_id");
        if (bi.oN(this.appId)) {
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.GameSettingsUI", "appid is null or nill");
        } else {
            this.nrn = g.aZ(this.appId, true);
        }
        initView();
        g(new at(this.appId));
    }

    protected final int getLayoutId() {
        return R.i.daK;
    }

    protected void onDestroy() {
        super.onDestroy();
        SubCoreGameCenter.aRP().b(2, this);
        as.CN().b(1221, (e) this);
    }

    protected final void initView() {
        int i = 0;
        this.nqo = (ImageView) findViewById(R.h.cmn);
        this.nqp = (TextView) findViewById(R.h.cmX);
        this.nBv = (TextView) findViewById(R.h.clY);
        this.nBB = (AuthorizationInfoLayout) findViewById(R.h.ckH);
        if (this.nrn != null) {
            Bitmap b = g.b(this.nrn.field_appId, 1, a.getDensity(this));
            if (b == null) {
                this.nqo.setImageResource(R.g.byY);
            } else {
                this.nqo.setImageBitmap(d.a(b, true, 5.0f));
            }
            if (!bi.oN(this.nrn.field_appName)) {
                this.nqp.setText(g.a((Context) this, this.nrn, null));
            }
            if (!bi.oN(this.nrn.fRw)) {
                this.nBv.setText(this.nrn.fRw);
            }
            String str = this.nrn.fRv;
            if (!bi.oN(str)) {
                Map y = bj.y(str, "ScopeList");
                if (y != null && y.size() > 0) {
                    int i2 = bi.getInt((String) y.get(".ScopeList.Count"), 0);
                    if (i2 > 0) {
                        this.nBC = new ArrayList();
                        while (i < i2) {
                            Object obj;
                            StringBuilder stringBuilder = new StringBuilder(".ScopeList.List.item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            String stringBuilder2 = stringBuilder.append(obj).append(".Scope").toString();
                            if (!bi.oN((String) y.get(stringBuilder2))) {
                                this.nBC.add(y.get(stringBuilder2));
                            }
                            i++;
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GameSettingsUI", "auth info is null :" + this.nrn.field_appName + ", " + this.appId);
                    }
                }
                if (this.nBC == null || this.nBC.size() <= 0) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GameSettingsUI", "this game's authinfo is null " + this.appId);
                    this.nBB.setVisibility(8);
                } else {
                    this.nBB.C(this.nBC);
                }
            }
        }
        this.nBw = (TextView) findViewById(R.h.cch);
        this.nBw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.a(GameSettingsUI.this, R.l.emr, R.l.emq, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        GameSettingsUI.this.g(new x(2, new aj(GameSettingsUI.this.appId, 1, null)));
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.nBx = (CheckBox) findViewById(R.h.bIn);
        this.nBx.setChecked(g.Sf(this.appId));
        this.nBy = findViewById(R.h.bIf);
        this.nBy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (GameSettingsUI.this.nBx.isChecked()) {
                    GameSettingsUI.this.nBx.setChecked(false);
                    GameSettingsUI.a(GameSettingsUI.this, false);
                    return;
                }
                GameSettingsUI.this.nBx.setChecked(true);
                GameSettingsUI.a(GameSettingsUI.this, true);
            }
        });
        this.nBA = (CheckBox) findViewById(R.h.cOm);
        this.nBz = findViewById(R.h.cOl);
        this.nBz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (GameSettingsUI.this.nBA.isChecked()) {
                    GameSettingsUI.this.nBA.setChecked(false);
                    GameSettingsUI.b(GameSettingsUI.this, false);
                    return;
                }
                GameSettingsUI.this.nBA.setChecked(true);
                GameSettingsUI.b(GameSettingsUI.this, true);
            }
        });
        setMMTitle(R.l.enp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameSettingsUI.this.setResult(0);
                GameSettingsUI.this.finish();
                return true;
            }
        });
    }

    private void g(final k kVar) {
        as.CN().a(kVar, 0);
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(kVar);
            }
        });
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (!cJ(i, i2)) {
            aj ajVar = (aj) wVar;
            if (ajVar.cmdId == 0) {
                boolean Sf = g.Sf(this.appId);
                if (this.nBx != null) {
                    this.nBx.setChecked(Sf);
                }
                if (Sf) {
                    ap.a(this.mController.xRr, 10, 1008, AuthorizedGameListUI.nqy, 20, 1, this.appId, this.niV, 0, null, null, null);
                } else {
                    ap.a(this.mController.xRr, 10, 1008, AuthorizedGameListUI.nqy, 21, 1, this.appId, this.niV, 0, null, null, null);
                }
            } else if (ajVar.cmdId == 1) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GameSettingsUI", "relieve app authorization ok");
                Intent intent = new Intent();
                intent.putExtra("game_app_id", this.appId);
                setResult(-1, intent);
                finish();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!cJ(i, i2)) {
            switch (kVar.getType()) {
                case 1221:
                    int i3 = ((az) ((at) kVar).lSH.hnQ.hnY).nnb;
                    ba baVar = (ba) ((at) kVar).lSH.hnR.hnY;
                    Object obj = (baVar == null || (baVar.nnc & 1) <= 0) ? null : 1;
                    switch (i3) {
                        case 0:
                            this.nBA.setChecked(obj == null);
                            return;
                        case 1:
                            ap.a(this.mController.xRr, 10, 1008, AuthorizedGameListUI.nqz, this.nBD ? 20 : 21, 1, this.appId, this.niV, 0, null, null, null);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    private boolean cJ(int i, int i2) {
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        Toast.makeText(this, getString(R.l.emD, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
