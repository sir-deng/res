package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.y.as;

public class GameMessageUI extends GameCenterActivity implements OnItemClickListener, e {
    private int gBL = 0;
    private int kKY;
    private OnScrollListener nrQ = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !GameMessageUI.this.nzi.awL()) {
                o b = GameMessageUI.this.nzi;
                if (!b.awL()) {
                    b.las += 15;
                    if (b.las > b.hLP) {
                        b.las = b.hLP;
                    }
                } else if (b.xQN != null) {
                    b.xQN.XE();
                }
                GameMessageUI.this.nzi.a(null, null);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ListView nzh;
    private o nzi;
    private TextView nzj;
    private View nzk;
    private int nzl = 1;
    private boolean nzm = false;
    private boolean nzn = false;
    private String nzo = "";
    private OnClickListener nzp;
    private OnClickListener nzq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(573, (e) this);
        this.gBL = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.nzo = getIntent().getStringExtra("game_manage_url");
        initView();
        SubCoreGameCenter.aRL();
        w.aQZ();
    }

    protected void onResume() {
        super.onResume();
        this.nzi.notifyDataSetChanged();
        if (this.nzn && this.nzk != null) {
            this.nzh.removeHeaderView(this.nzk);
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dkY);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameMessageUI.this.goBack();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dEz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameMessageUI.this.nzp = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SubCoreGameCenter.aRK().fD("GameRawMessage", "delete from GameRawMessage");
                        GameMessageUI.this.nzi.XI();
                        GameMessageUI.this.nzi.notifyDataSetChanged();
                    }
                };
                GameMessageUI.this.nzq = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                };
                h.a(GameMessageUI.this.mController.xRr, R.l.emf, 0, GameMessageUI.this.nzp, GameMessageUI.this.nzq);
                return false;
            }
        });
        this.kKY = getIntent().getIntExtra("game_report_from_scene", 0);
        this.nzh = (ListView) findViewById(R.h.cmV);
        this.nzh.setOnItemClickListener(this);
        if (this.gBL > 20) {
            if (getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true)) {
                this.nzk = View.inflate(this, R.i.dlb, null);
                this.nzk.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (!bi.oN(GameMessageUI.this.nzo)) {
                            ap.a(GameMessageUI.this.mController.xRr, 13, 1302, 1, c.ac(GameMessageUI.this.mController.xRr, GameMessageUI.this.nzo), GameMessageUI.this.kKY, null);
                        }
                        GameMessageUI.this.nzn = true;
                    }
                });
                this.nzh.addHeaderView(this.nzk);
                this.nzk.setVisibility(0);
                getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
            } else if (this.nzk != null) {
                this.nzk.setVisibility(8);
            }
        }
        t tVar = new t();
        tVar.niE = true;
        this.nzi = new o(this, tVar, this.kKY);
        this.nzi.mb(true);
        rs(8);
        this.nzi.xQN = new a() {
            public final void XF() {
            }

            public final void XE() {
                if (GameMessageUI.this.nzi.getCount() == 0) {
                    GameMessageUI.this.nzh.setVisibility(8);
                    GameMessageUI.this.rs(0);
                    GameMessageUI.this.enableOptionMenu(false);
                    return;
                }
                GameMessageUI.this.nzh.setVisibility(0);
                GameMessageUI.this.rs(8);
                GameMessageUI.this.enableOptionMenu(true);
            }
        };
        this.nzh.setOnScrollListener(this.nrQ);
        this.nzh.setAdapter(this.nzi);
        ap.a(this.mController.xRr, 13, 1300, 0, 1, 0, null, this.kKY, 0, null, null, null);
    }

    private void rs(int i) {
        if (this.nzj == null) {
            this.nzj = (TextView) findViewById(R.h.cmT);
        }
        this.nzj.setVisibility(i);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        SubCoreGameCenter.aRK().aRd();
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dkY;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nzi != null) {
            this.nzi.aUU();
        }
        as.CN().b(573, (e) this);
        boolean fD = SubCoreGameCenter.aRK().fD("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        x.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", Boolean.valueOf(fD), r1);
        SubCoreGameCenter.aRK().aRd();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar = (t) adapterView.getAdapter().getItem(i);
        if (tVar == null) {
            x.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", Integer.valueOf(i));
            return;
        }
        tVar.aQT();
        int a;
        Bundle bundle;
        if (tVar.field_msgType == 100) {
            if (!bi.oN(tVar.nir)) {
                d dVar = (d) tVar.nhX.get(tVar.nir);
                if (dVar != null) {
                    a = u.a(this, tVar, dVar, tVar.field_appId, 1301);
                    if (a != 0) {
                        ap.a(this.mController.xRr, 13, 1301, 4, a, 0, tVar.field_appId, this.kKY, tVar.niA, tVar.field_gameMsgId, tVar.niB, null);
                    }
                }
            }
        } else if (tVar.niC == 0) {
            switch (tVar.field_msgType) {
                case 2:
                case 5:
                    if (!g.m((Context) this, tVar.field_appId)) {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", tVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = c.a(this, tVar.field_appId, null, bundle);
                        break;
                    }
                    com.tencent.mm.plugin.game.model.g.Y(this, tVar.field_appId);
                    a = 3;
                    break;
                case 6:
                    if (!bi.oN(tVar.nim)) {
                        a = c.ac(this, tVar.nim);
                        break;
                    }
                    return;
                case 10:
                case 11:
                    if (!bi.oN(tVar.nhK)) {
                        a = c.ac(this, tVar.nhK);
                        break;
                    }
                    return;
                default:
                    return;
            }
            ap.a(this.mController.xRr, 13, 1301, 4, a, 0, tVar.field_appId, this.kKY, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
        } else {
            switch (tVar.niC) {
                case 1:
                    if (bi.oN(tVar.field_appId)) {
                        x.e("MicroMsg.GameMessageUI", "appid is null");
                        return;
                    }
                    bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", tVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    ap.a(this.mController.xRr, 13, 1301, 4, c.a(this, tVar.field_appId, null, bundle), 0, tVar.field_appId, this.kKY, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
                case 2:
                    if (g.m((Context) this, tVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.g.Y(this, tVar.field_appId);
                        a = 3;
                    } else {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", tVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = c.a(this, tVar.field_appId, null, bundle);
                    }
                    ap.a(this.mController.xRr, 13, 1301, 4, a, 0, tVar.field_appId, this.kKY, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
                case 3:
                    if (bi.oN(tVar.niD)) {
                        x.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        return;
                    }
                    ap.a(this.mController.xRr, 13, 1301, 4, c.ac(this, tVar.niD), 0, tVar.field_appId, this.kKY, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
                default:
                    x.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + tVar.niC);
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()));
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 573) {
                rs(8);
                this.nzi.a(null, null);
            }
        } else if (this.nzi.getCount() > 0) {
            x.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        } else if (!com.tencent.mm.plugin.game.a.a.ihO.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.emy, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public final int aRY() {
        return 13;
    }

    public final int aRZ() {
        return 1300;
    }

    public final int aSa() {
        return this.kKY;
    }
}
