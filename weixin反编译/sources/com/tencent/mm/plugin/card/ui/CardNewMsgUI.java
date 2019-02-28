package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements com.tencent.mm.plugin.card.a.l.a {
    private ListView Fv;
    OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            g gVar;
            if (view.getId() == R.h.cfN) {
                gVar = (g) view.getTag();
                if (gVar != null && gVar.auX() != null) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, "");
                    if (gVar.auX().kRj == 0) {
                        x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                        if (TextUtils.isEmpty(gVar.auX().url)) {
                            x.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(CardNewMsgUI.this, gVar.auX().url, 2);
                        }
                    } else if (gVar.auX().kRj == 1) {
                        x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                        Intent intent = new Intent();
                        intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                        intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                        intent.setClass(CardNewMsgUI.this, CardShopUI.class);
                        CardNewMsgUI.this.startActivity(intent);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11324, "UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
                    }
                }
            } else if (view.getId() == R.h.cBR) {
                gVar = (g) view.getTag();
                if (gVar != null && gVar.auY() != null) {
                    if (gVar.auY().type == 0) {
                        x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                        if (TextUtils.isEmpty(gVar.auY().url)) {
                            x.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(CardNewMsgUI.this, gVar.auY().url, 2);
                        }
                    } else if (gVar.auY().type == 1) {
                        x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                    }
                }
            }
        }
    };
    private View jRL;
    private View klX;
    private a lao;
    private View lap = null;
    private boolean laq = false;

    class a extends o<g> {
        private int hLP = this.las;
        private int las = 10;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            g gVar = (g) obj;
            if (gVar == null) {
                gVar = new g();
            }
            gVar.b(cursor);
            return gVar;
        }

        public a() {
            super(CardNewMsgUI.this, new g());
            mb(true);
        }

        public final void XH() {
            if (am.avj().Tx() > 0) {
                setCursor(am.avj().gLA.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.hLP = am.avj().getCount();
                h avj = am.avj();
                setCursor(avj.gLA.rawQuery("select * from CardMsgInfo order by time desc LIMIT " + this.las, null));
            }
            notifyDataSetChanged();
        }

        protected final void XI() {
            aUU();
            XH();
        }

        public final boolean awL() {
            return this.las >= this.hLP;
        }

        public final int awM() {
            if (awL()) {
                if (CardNewMsgUI.this.lap.getParent() != null) {
                    CardNewMsgUI.this.Fv.removeFooterView(CardNewMsgUI.this.lap);
                }
                return 0;
            }
            this.las += 10;
            if (this.las <= this.hLP) {
                return 10;
            }
            this.las = this.hLP;
            return this.hLP % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            g gVar = (g) getItem(i);
            if (view == null) {
                view = View.inflate(CardNewMsgUI.this.mController.xRr, R.i.dcy, null);
                b bVar2 = new b(CardNewMsgUI.this, (byte) 0);
                bVar2.lay = (ImageView) view.findViewById(R.h.logo);
                bVar2.laz = view.findViewById(R.h.bSs);
                bVar2.laA = (ImageView) view.findViewById(R.h.bSr);
                bVar2.laB = (TextView) view.findViewById(R.h.cSB);
                bVar2.laC = (TextView) view.findViewById(R.h.cRz);
                bVar2.laD = (TextView) view.findViewById(R.h.caV);
                bVar2.laE = (TextView) view.findViewById(R.h.cfN);
                bVar2.laF = (TextView) view.findViewById(R.h.cPk);
                bVar2.laG = view.findViewById(R.h.cBR);
                bVar2.laH = (TextView) view.findViewById(R.h.cBS);
                bVar2.laI = (LinearLayout) view.findViewById(R.h.bIh);
                bVar2.laJ = (LinearLayout) view.findViewById(R.h.bIi);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.laB.setText(gVar.field_title);
            bVar.laC.setText(n.c(CardNewMsgUI.this, ((long) gVar.field_time) * 1000, true));
            bVar.laD.setText(gVar.field_description);
            int dimensionPixelSize = CardNewMsgUI.this.getResources().getDimensionPixelSize(R.f.bwC);
            x.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.laz.setVisibility(8);
                bVar.lay.setVisibility(0);
                bVar.lay.setImageResource(R.g.bDU);
                m.a(bVar.lay, gVar.field_logo_url, dimensionPixelSize, R.g.bDU, true);
            } else {
                x.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + gVar.field_logo_color);
                bVar.laz.setVisibility(0);
                bVar.lay.setVisibility(8);
                if (TextUtils.isEmpty(gVar.field_logo_url)) {
                    m.a(bVar.laA, R.g.bAw, l.xu(gVar.field_logo_color));
                } else {
                    m.a(CardNewMsgUI.this, bVar.laA, gVar.field_logo_url, dimensionPixelSize, R.g.bAw, l.xu(gVar.field_logo_color));
                }
            }
            km auX = gVar.auX();
            if (auX == null || TextUtils.isEmpty(auX.text)) {
                bVar.laE.setVisibility(8);
            } else {
                bVar.laE.setText(auX.text);
                bVar.laE.setTag(gVar);
                bVar.laE.setVisibility(0);
                bVar.laE.setOnClickListener(CardNewMsgUI.this.iqi);
            }
            kq auY = gVar.auY();
            if (auY == null || TextUtils.isEmpty(auY.text)) {
                bVar.laG.setVisibility(8);
                bVar.laF.setVisibility(8);
            } else {
                bVar.laH.setText(auY.text);
                bVar.laG.setVisibility(0);
                bVar.laG.setOnClickListener(CardNewMsgUI.this.iqi);
                bVar.laG.setTag(gVar);
                bVar.laF.setVisibility(0);
            }
            gVar.auZ();
            gVar.ava();
            a(gVar.kRa, gVar.kRb, bVar, gVar);
            return view;
        }

        private void a(List<com.tencent.mm.plugin.card.model.g.a> list, List<com.tencent.mm.plugin.card.model.g.b> list2, b bVar, final g gVar) {
            bVar.laI.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.laJ.setVisibility(8);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!bi.cC(list)) {
                for (i = 0; i < list.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.a aVar = (com.tencent.mm.plugin.card.model.g.a) list.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.xRr, R.i.dbL, null);
                    if (i == 0) {
                        inflate.findViewById(R.h.bPs).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.h.bPu)).setText(aVar.title);
                    ((TextView) inflate.findViewById(R.h.bPt)).setText(aVar.kRg);
                    button = (Button) inflate.findViewById(R.h.bPr);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            if (aVar.kRj == 0) {
                                intent.setClass(CardNewMsgUI.this.mController.xRr, CardDetailUI.class);
                                intent.putExtra("key_card_id", aVar.cardId);
                                intent.putExtra("key_card_ext", aVar.kRh);
                                intent.putExtra("key_from_scene", 17);
                                CardNewMsgUI.this.startActivity(intent);
                            } else if (aVar.kRj == 1) {
                                intent.setClass(CardNewMsgUI.this.mController.xRr, CardConsumeSuccessUI.class);
                                intent.putExtra("key_card_id", gVar.field_card_id);
                                intent.putExtra("key_from_scene", 2);
                                CardNewMsgUI.this.startActivity(intent);
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(8), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, aVar.cardId);
                        }
                    });
                    if (aVar.kRj == 0) {
                        button.setText(R.l.bPu);
                    } else if (aVar.kRj == 1) {
                        button.setText(R.l.dND);
                    }
                    bVar.laI.addView(inflate);
                }
            }
            if (!bi.cC(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.b bVar2 = (com.tencent.mm.plugin.card.model.g.b) list2.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.xRr, R.i.dbL, null);
                    if (i == 0 && bi.cC(list)) {
                        inflate.findViewById(R.h.bPs).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.h.bPu)).setText(bVar2.title);
                    ((TextView) inflate.findViewById(R.h.bPt)).setText(bVar2.description);
                    button = (Button) inflate.findViewById(R.h.bPr);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (TextUtils.isEmpty(bVar2.kRm)) {
                                x.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(CardNewMsgUI.this, bVar2.kRm, 2);
                            }
                        }
                    });
                    button.setText(bVar2.kRl);
                    bVar.laI.addView(inflate);
                }
            }
            bVar.laJ.setVisibility(0);
        }
    }

    private class b {
        ImageView laA;
        TextView laB;
        TextView laC;
        TextView laD;
        TextView laE;
        TextView laF;
        View laG;
        TextView laH;
        LinearLayout laI;
        LinearLayout laJ;
        ImageView lay;
        View laz;

        private b() {
        }

        /* synthetic */ b(CardNewMsgUI cardNewMsgUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i) {
        g gVar = (g) cardNewMsgUI.lao.getItem(i);
        if (gVar != null) {
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.ab(gVar.field_card_id, false);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.ab(gVar.field_card_tp_id, false);
                }
            } else if (gVar.field_jump_type == 2) {
                if (TextUtils.isEmpty(gVar.field_url)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) cardNewMsgUI, gVar.field_url, 4);
                }
            } else if (gVar.field_jump_type == 1) {
                x.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.ab(gVar.field_card_id, true);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.ab(gVar.field_card_tp_id, true);
                }
            }
            int i2 = cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false) ? 7 : 1;
            com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(i2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, "");
        }
    }

    protected final int getLayoutId() {
        return R.i.dcA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        am.avl().a((com.tencent.mm.plugin.card.a.l.a) this);
        am.avl().auU();
    }

    protected void onDestroy() {
        this.lao.aUU();
        am.avl().b(this);
        if (am.avj().Tx() > 0) {
            am.avj().avc();
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.dOY);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardNewMsgUI.this.finish();
                return true;
            }
        });
        this.Fv = (ListView) findViewById(R.h.bRx);
        this.lao = new a();
        this.Fv.setAdapter(this.lao);
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == CardNewMsgUI.this.lao.getCount()) {
                    int i2 = 1;
                    if (am.avj().Tx() > 0) {
                        am.avj().avc();
                    } else {
                        i2 = CardNewMsgUI.this.lao.awM();
                    }
                    CardNewMsgUI.this.lao.a(null, null);
                    if (!CardNewMsgUI.this.laq) {
                        if (CardNewMsgUI.this.jRL.getParent() != null) {
                            x.d("MicroMsg.CardNewMsgUI", "remove footer");
                            CardNewMsgUI.this.Fv.removeFooterView(CardNewMsgUI.this.jRL);
                        }
                        if (!CardNewMsgUI.this.lao.awL() && CardNewMsgUI.this.lap.getParent() == null && i2 > 0) {
                            CardNewMsgUI.this.Fv.addFooterView(CardNewMsgUI.this.lap);
                            x.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    CardNewMsgUI.this.laq = true;
                    CardNewMsgUI.this.jRL.setVisibility(8);
                    return;
                }
                CardNewMsgUI.a(CardNewMsgUI.this, i);
            }
        });
        this.Fv.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.ui.base.h.a((Context) CardNewMsgUI.this, CardNewMsgUI.this.getResources().getString(R.l.dOZ), null, CardNewMsgUI.this.getResources().getString(R.l.dEH), new c(i) {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                g gVar = (g) CardNewMsgUI.this.lao.getItem(r5);
                                if (gVar != null) {
                                    am.avl().wI(gVar.field_msg_id);
                                    CardNewMsgUI.this.avH();
                                    CardNewMsgUI.this.lao.a(null, null);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.Fv.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (CardNewMsgUI.this.laq && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (am.avj().Tx() > 0) {
                        am.avj().avc();
                    } else {
                        CardNewMsgUI.this.lao.awM();
                    }
                    CardNewMsgUI.this.lao.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.lao.xQN = new com.tencent.mm.ui.o.a() {
            public final void XF() {
            }

            public final void XE() {
                CardNewMsgUI.this.avH();
                if (CardNewMsgUI.this.lao.awL() && am.avj().Tx() == 0) {
                    CardNewMsgUI.this.jRL.setVisibility(8);
                }
            }
        };
        addTextOptionMenu(0, getString(R.l.dNX), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11582, "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "");
                d.a(CardNewMsgUI.this, new com.tencent.mm.plugin.card.b.d.a() {
                    public final void awH() {
                        com.tencent.mm.plugin.card.a.l avl = am.avl();
                        if (avl.kPq.size() != 0) {
                            List arrayList = new ArrayList();
                            arrayList.addAll(avl.kPq);
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= arrayList.size()) {
                                    break;
                                }
                                g gVar = (g) arrayList.get(i2);
                                if (gVar != null) {
                                    avl.kPq.remove(gVar);
                                    com.tencent.mm.plugin.card.a.l.d(gVar);
                                }
                                i = i2 + 1;
                            }
                            arrayList.clear();
                        }
                        CardNewMsgUI.this.avH();
                        CardNewMsgUI.this.lao.a(null, null);
                    }
                });
                return true;
            }
        });
        this.klX = findViewById(R.h.bYT);
        avH();
        this.jRL = v.fw(this).inflate(R.i.dcx, null);
        this.lap = v.fw(this).inflate(R.i.dny, null);
        int Tx = am.avj().Tx();
        if (Tx > 0) {
            this.Fv.addFooterView(this.jRL);
        } else if (!this.lao.awL() && Tx == 0 && am.avj().getCount() > 0) {
            this.Fv.addFooterView(this.lap);
            this.laq = true;
        } else if (this.lao.awL() && Tx == 0) {
            am.avj().getCount();
        }
    }

    private void avH() {
        com.tencent.mm.plugin.card.a.l avl = am.avl();
        int size = (avl.kPq == null || avl.kPq.isEmpty()) ? 0 : avl.kPq.size();
        if (size > 0) {
            this.Fv.setVisibility(0);
            this.klX.setVisibility(8);
            enableOptionMenu(true);
        } else {
            this.Fv.setVisibility(8);
            this.klX.setVisibility(0);
            enableOptionMenu(false);
        }
        this.lao.notifyDataSetChanged();
    }

    private void ab(String str, boolean z) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
    }

    public final void a(g gVar) {
        if ((gVar.field_msg_type & 1) != 0 && (gVar.field_msg_type & 3) != 0) {
            avH();
            this.lao.a(null, null);
        }
    }

    public final void asP() {
    }
}
