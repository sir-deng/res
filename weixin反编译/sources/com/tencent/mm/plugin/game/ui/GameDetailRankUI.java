package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.u;
import com.tencent.mm.y.u.b;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String nuf = "gameDetailRankDataKey";
    private String appId;
    private ListView nuc;
    private GameRankHeadView nud;
    private j nue;

    public static class a {
        public String nuh;
        public String nui;
        d nuj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b hB = u.GQ().hB(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (hB == null) {
            finish();
            return;
        }
        a aVar = (a) hB.get(nuf);
        this.nuc = (ListView) findViewById(R.h.clQ);
        if (!(bi.oN(aVar.nuh) || bi.oN(aVar.nui))) {
            View inflate = ((LayoutInflater) this.mController.xRr.getSystemService("layout_inflater")).inflate(R.i.dkk, this.nuc, false);
            this.nud = (GameRankHeadView) inflate.findViewById(R.h.cne);
            this.nuc.addHeaderView(inflate);
            GameRankHeadView gameRankHeadView = this.nud;
            gameRankHeadView.jtn.setText(aVar.nuh);
            gameRankHeadView.nzX.setText(aVar.nui);
            gameRankHeadView.njs = aVar.nuj;
            gameRankHeadView.njs.fGe = 1203;
            gameRankHeadView.njs.position = 2;
            if (gameRankHeadView.nuq == null) {
                gameRankHeadView.nuq = new o(gameRankHeadView.njs);
            }
            gameRankHeadView.nuq.cQ(gameRankHeadView.getContext());
            gameRankHeadView.nuq.aQQ();
            gameRankHeadView.aSg();
            if (gameRankHeadView.nuo != null) {
                n.a(gameRankHeadView.nuo);
            } else {
                gameRankHeadView.nuo = new n.b() {
                    public final void h(int i, String str, boolean z) {
                        if (GameRankHeadView.this.njs != null) {
                            GameRankHeadView.this.nuq.cQ(GameRankHeadView.this.getContext());
                            GameRankHeadView.this.nuq.aQQ();
                            if (z) {
                                GameRankHeadView.this.aSg();
                            }
                        }
                    }
                };
                n.a(gameRankHeadView.nuo);
            }
            gameRankHeadView.ntM.setOnClickListener(gameRankHeadView);
        }
        this.nue = new j(this);
        this.nue.DD = R.i.dke;
        this.nuc.setAdapter(this.nue);
        this.appId = aVar.nuj.field_appId;
        if (bi.oN(this.appId)) {
            finish();
            return;
        }
        initView();
        as.Dt().F(new Runnable() {
            public final void run() {
                GameDetailRankUI.this.nue.a(new ag(GameDetailRankUI.this.appId));
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        n.b(this.nud.nuo);
    }

    protected final int getLayoutId() {
        return R.i.dkd;
    }

    protected final void initView() {
        setMMTitle(g.l(this.mController.xRr, this.appId));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameDetailRankUI.this.finish();
                return true;
            }
        });
    }
}
