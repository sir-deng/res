package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.game.c.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bd;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements e {
    private View klP;
    private Dialog lTm;
    private boolean mSY = false;
    private int niV = 0;
    private int nja = 0;
    private l nrD = new l();
    private ListView nrJ;
    private m nrK;
    private boolean nrL = false;
    private boolean nrM = true;
    private a nrP = new a() {
        public final void ri(int i) {
            int firstVisiblePosition = GameLibraryUI.this.nrJ.getFirstVisiblePosition() - GameLibraryUI.this.nya;
            int lastVisiblePosition = GameLibraryUI.this.nrJ.getLastVisiblePosition() - GameLibraryUI.this.nya;
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                GameLibraryUI.this.nrK.x(GameLibraryUI.this.nrJ.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private OnScrollListener nrQ = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameLibraryUI.this.nrM && !GameLibraryUI.this.nrL) {
                GameLibraryUI.this.klP.setVisibility(0);
                GameLibraryUI.this.aSl();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private boolean nsJ = true;
    private OnClickListener nsM = new OnClickListener() {
        public final void onClick(View view) {
            int i = 6;
            if (view.getTag() instanceof String) {
                c.a(view, GameLibraryUI.this);
                i = 7;
            } else {
                Intent intent = new Intent(GameLibraryUI.this, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", GameLibraryUI.this.getString(R.l.emC));
                intent.putExtra("game_report_from_scene", 1113);
                GameLibraryUI.this.startActivity(intent);
            }
            ap.a(GameLibraryUI.this, 11, 1113, 1, i, GameLibraryUI.this.niV, null);
        }
    };
    private GameBannerView nxO;
    private GameLibraryCategoriesView nxP;
    private View nxQ;
    private TextView nxR;
    private View nxS;
    private GameDropdownView nxT;
    private HashMap<Integer, String> nxU;
    private int nxV = 0;
    private View nxW;
    private Button nxX;
    private boolean nxY = false;
    private int nxZ = 990;
    private int nya = 0;
    private OnClickListener nyb = new OnClickListener() {
        public final void onClick(View view) {
            c.a(view, GameLibraryUI.this);
            ap.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.this.niV, null);
        }
    };
    private GameDropdownView.a nyc = new GameDropdownView.a() {
        public final void rn(int i) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(GameLibraryUI.this.nxU.keySet());
            if (i <= linkedList.size() - 1) {
                GameLibraryUI.this.nxV = ((Integer) linkedList.get(i)).intValue();
                x.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", Integer.valueOf(GameLibraryUI.this.nxV));
                GameLibraryUI.this.nja = 0;
                GameLibraryUI.this.aSl();
                ap.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.this.nxV + GameLibraryUI.this.nxZ, 2, GameLibraryUI.this.niV, null);
            }
        }
    };

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, al alVar, boolean z) {
        Pair pair = null;
        gameLibraryUI.nrM = alVar.njD.noq;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.nrK.P(alVar.njF);
            x.i("MicroMsg.GameLibraryUI", "Appending list size: %d", Integer.valueOf(linkedList.size()));
        } else {
            LinkedList linkedList2;
            GameBannerView gameBannerView = gameLibraryUI.nxO;
            if (alVar.njD.noo == null || alVar.njD.noo.npb == null) {
                x.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < alVar.njD.noo.npb.size(); i++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    b bVar = (b) alVar.njD.noo.npb.get(i);
                    f a = ad.a(bVar.nkO);
                    if (a != null) {
                        d.a(a);
                        aVar.index = i;
                        aVar.nrn = a;
                        aVar.hlQ = bVar.nkP;
                        aVar.ngB = bVar.nkQ;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.R(linkedList);
            gameLibraryUI.nxP.I(alVar.aRA());
            gameLibraryUI.nxP.niV = gameLibraryUI.niV;
            linkedList = new LinkedList();
            linkedList2 = alVar.njE;
            Object obj = alVar.njF;
            linkedList.addAll(linkedList2);
            linkedList.addAll(obj);
            gameLibraryUI.nrK.Q(linkedList);
            x.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", Integer.valueOf(linkedList2.size()), Integer.valueOf(obj.size()));
            gameLibraryUI.nxU = alVar.aRz();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.nxU.values());
            GameDropdownView gameDropdownView = gameLibraryUI.nxT;
            LinkedList linkedList3 = new LinkedList();
            linkedList3.addAll(gameLibraryUI.nxU.keySet());
            gameDropdownView.c(linkedList, linkedList3.indexOf(Integer.valueOf(gameLibraryUI.nxV)));
            Pair pair2 = (alVar.njD.noo == null || alVar.njD.noo.npc == null) ? null : new Pair(alVar.njD.noo.npc.npx, alVar.njD.noo.npc.noz);
            if (pair2 == null || bi.oN((String) pair2.first) || bi.oN((String) pair2.second)) {
                gameLibraryUI.nxQ.setTag(null);
                gameLibraryUI.nxR.setVisibility(8);
            } else {
                gameLibraryUI.nxQ.setTag(pair2.second);
                gameLibraryUI.nxR.setVisibility(0);
                gameLibraryUI.nxR.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList2.size() != 0) {
                sparseArray.put(0, gameLibraryUI.nxQ);
            }
            sparseArray.put(linkedList2.size(), gameLibraryUI.nxS);
            gameLibraryUI.nrK.b(sparseArray);
            if (!(alVar.njD.noo == null || alVar.njD.noo.npe == null)) {
                pair = new Pair(alVar.njD.noo.npe.npl, alVar.njD.noo.npe.nkQ);
            }
            if (pair != null) {
                gameLibraryUI.nxX.setText((CharSequence) pair.first);
                gameLibraryUI.nxX.setTag(pair.second);
                gameLibraryUI.nxY = true;
            }
        }
        if (!gameLibraryUI.nrM && gameLibraryUI.nxY) {
            gameLibraryUI.nxW.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (as.Hp()) {
            int i;
            this.niV = getIntent().getIntExtra("game_report_from_scene", 0);
            as.CN().a(1218, (e) this);
            initView();
            final byte[] CC = SubCoreGameCenter.aRO().CC("pb_library");
            if (CC == null) {
                x.i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        final al alVar = new al(CC);
                        ah.y(new Runnable() {
                            public final void run() {
                                GameLibraryUI.a(GameLibraryUI.this, alVar, false);
                            }
                        });
                    }
                });
                i = 1;
            }
            if (i == 0) {
                this.lTm = c.cS(this);
                this.lTm.show();
            }
            aSl();
            ap.a((Context) this, 11, 1100, 0, 1, this.niV, null);
            return;
        }
        x.e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (as.Hp()) {
            this.nrK.refresh();
            if (!(this.nsJ || this.nxO == null)) {
                GameBannerView gameBannerView = this.nxO;
                if (gameBannerView.nrk != null && gameBannerView.nrk.cgx() && gameBannerView.nrj.size() > 1) {
                    gameBannerView.nrk.K(5000, 5000);
                    x.i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.nsJ) {
                this.nsJ = false;
                return;
            }
            return;
        }
        x.e("MicroMsg.GameLibraryUI", "account not ready");
    }

    protected void onPause() {
        super.onPause();
        if (this.nxO != null) {
            GameBannerView gameBannerView = this.nxO;
            if (gameBannerView.nrk != null) {
                gameBannerView.nrk.TN();
                x.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        as.CN().b(1218, (e) this);
        this.nrK.clear();
        if (this.nxO != null) {
            this.nxO.nrk.TN();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dkH;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setMMTitle(R.l.dkH);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameLibraryUI.this.goBack();
                return true;
            }
        });
        if (!bi.oN(SubCoreGameCenter.aRI())) {
            addIconOptionMenu(0, R.l.eRz, R.k.dvm, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(GameLibraryUI.this, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1109);
                    GameLibraryUI.this.startActivity(intent);
                    return true;
                }
            });
        }
        this.nrJ = (ListView) findViewById(R.h.cmF);
        this.nrJ.setOnItemClickListener(this.nrD);
        this.nrD.rg(this.niV);
        this.nrJ.setOnScrollListener(this.nrQ);
        this.nrK = new m(this);
        this.nrK.rg(this.niV);
        this.nrK.a(this.nrP);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.xRr.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.cmI, this.nrJ, false);
        this.nxO = (GameBannerView) inflate.findViewById(R.h.cmI);
        this.nxO.niV = this.niV;
        this.nrJ.addHeaderView(inflate);
        this.nya++;
        this.nxP = (GameLibraryCategoriesView) layoutInflater.inflate(R.i.dkJ, this.nrJ, false);
        View linearLayout = new LinearLayout(this);
        linearLayout.addView(this.nxP);
        this.nrJ.addHeaderView(linearLayout);
        this.nya++;
        this.nxQ = layoutInflater.inflate(R.i.dkN, this.nrJ, false);
        this.nxQ.setOnClickListener(this.nyb);
        this.nxR = (TextView) this.nxQ.findViewById(R.h.cmH);
        this.nxS = layoutInflater.inflate(R.i.dkI, this.nrJ, false);
        this.nxS.setOnClickListener(null);
        this.nxT = (GameDropdownView) this.nxS.findViewById(R.h.cmD);
        this.nxT.nvE = this.nxS;
        this.nxT.nvD = this.nyc;
        this.klP = layoutInflater.inflate(R.i.dkO, this.nrJ, false);
        this.klP.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.klP);
        this.nrJ.addFooterView(linearLayout);
        this.nxW = layoutInflater.inflate(R.i.dkM, this.nrJ, false);
        this.nxW.setVisibility(8);
        this.nxX = (Button) this.nxW.findViewById(R.h.cmG);
        this.nxX.setOnClickListener(this.nsM);
        this.nrJ.addFooterView(this.nxW);
        this.nrJ.setAdapter(this.nrK);
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bi.oN(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    private void aSl() {
        as.CN().a(new bd(this.nja, g.aQE(), this.nxV, this.nja == 0), 0);
        this.nrL = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1218:
                    final com.tencent.mm.bp.a aVar = ((bd) kVar).lSH.hnR.hnY;
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            com.tencent.mm.bp.a aVar = aVar;
                            boolean z = GameLibraryUI.this.nja == 0 && !GameLibraryUI.this.mSY;
                            final al alVar = new al(aVar, z, GameLibraryUI.this.nja);
                            GameLibraryUI.this.mSY = true;
                            ah.y(new Runnable() {
                                public final void run() {
                                    GameLibraryUI.a(GameLibraryUI.this, alVar, GameLibraryUI.this.nja != 0);
                                    GameLibraryUI.this.nrL = false;
                                    GameLibraryUI.this.klP.setVisibility(8);
                                    GameLibraryUI.this.nja = GameLibraryUI.this.nja + 15;
                                    if (GameLibraryUI.this.lTm != null) {
                                        GameLibraryUI.this.lTm.dismiss();
                                    }
                                }
                            });
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.ihO.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.emK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lTm != null) {
            this.lTm.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            x.e("MicroMsg.GameLibraryUI", "error request code");
        }
    }
}
