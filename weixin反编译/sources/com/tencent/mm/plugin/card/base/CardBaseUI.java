package com.tencent.mm.plugin.card.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.model.b;
import com.tencent.mm.plugin.card.sharecard.ui.g;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.d;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends DrawStatusBarActivity implements e, a {
    private float gAh = -85.0f;
    private float gAi = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                if (!(f2 == -85.0f || f == -1000.0f)) {
                    CardBaseUI.this.gAh = f2;
                    CardBaseUI.this.gAi = f;
                    am.avn().u(CardBaseUI.this.gAh, CardBaseUI.this.gAi);
                    CardBaseUI.this.atI();
                }
                if (!CardBaseUI.this.hrB) {
                    CardBaseUI.this.hrB = true;
                    o.a(2010, f, f2, (int) d2);
                }
                return false;
            }
            CardBaseUI.this.atJ();
            return true;
        }
    };
    private boolean hrB = false;
    public c hry;
    private r jqf = null;
    public ListView kNP = null;
    public BaseAdapter kNQ = null;
    public RelativeLayout kNR = null;
    public LinearLayout kNS;
    public LinearLayout kNT;
    public boolean kNU = false;
    public boolean kNV = true;
    public a kNW = null;
    public CardInfo kNX;

    public abstract void atz();

    static /* synthetic */ void a(CardBaseUI cardBaseUI, String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        cardBaseUI.kNU = false;
        cardBaseUI.C(linkedList);
    }

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.ec(true);
        as.CN().a(new af(cardBaseUI.kNX.field_card_id, str, 17), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.kNV = true;
        as.CN().a(652, (e) this);
    }

    public void onPause() {
        super.onPause();
        this.kNV = false;
        as.CN().b(652, (e) this);
    }

    public void initView() {
        a dVar;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardBaseUI.this.finish();
                return true;
            }
        });
        this.kNP = (ListView) findViewById(16908298);
        this.kNR = (RelativeLayout) findViewById(R.h.bYT);
        if (this.kNR != null) {
            this.kNP.setEmptyView(this.kNR);
        }
        this.kNS = (LinearLayout) View.inflate(getBaseContext(), R.i.dct, null);
        this.kNT = (LinearLayout) View.inflate(getBaseContext(), R.i.dcq, null);
        this.kNP.addHeaderView(this.kNS);
        this.kNP.addFooterView(this.kNT);
        this.kNQ = atB();
        this.kNP.setAdapter(this.kNQ);
        this.kNP.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    x.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
                    CardBaseUI.this.atE();
                    return;
                }
                if (i > 0) {
                    i--;
                }
                if (i < CardBaseUI.this.kNQ.getCount()) {
                    CardBaseUI.this.b(CardBaseUI.this.kNW.nV(i));
                }
            }
        });
        this.kNP.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    x.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i < CardBaseUI.this.kNQ.getCount()) {
                        CardBaseUI.this.c(CardBaseUI.this.kNW.nV(i));
                    }
                }
                return true;
            }
        });
        as.CN().a(560, (e) this);
        as.CN().a(692, (e) this);
        BaseAdapter baseAdapter = this.kNQ;
        if (baseAdapter instanceof com.tencent.mm.plugin.card.ui.c) {
            dVar = new d((com.tencent.mm.plugin.card.ui.c) baseAdapter);
        } else {
            Object dVar2 = baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c ? new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter) : baseAdapter instanceof g ? new h((g) baseAdapter) : new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g) baseAdapter);
        }
        this.kNW = dVar2;
        this.kNW.onCreate();
        atz();
    }

    public int getLayoutId() {
        return R.i.dcm;
    }

    public void onDestroy() {
        as.CN().b(560, (e) this);
        as.CN().b(692, (e) this);
        if (this.kNW != null) {
            this.kNW.onDestroy();
        }
        super.onDestroy();
    }

    public void a(b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.aum());
        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (atA() == n.a.kRw) {
            com.tencent.mm.plugin.report.service.g.pWK.h(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
        } else if (atA() == n.a.kRv) {
            com.tencent.mm.plugin.report.service.g.pWK.h(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
        }
    }

    public final void ec(boolean z) {
        if (z) {
            this.jqf = r.b(this, getString(R.l.dHn), true, 0, null);
        } else if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
            this.jqf = null;
        }
    }

    public final void C(LinkedList<String> linkedList) {
        ec(true);
        as.CN().a(new com.tencent.mm.plugin.card.model.r(linkedList), 0);
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3;
        if (i != 0 || i2 != 0) {
            ec(false);
            if (kVar instanceof af) {
                i3 = ((af) kVar).kRz;
                CharSequence charSequence = ((af) kVar).kRA;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(R.l.dOu);
                    }
                    str = charSequence;
                }
            }
            if (!(kVar instanceof com.tencent.mm.plugin.card.model.x) && !(kVar instanceof ad) && !(kVar instanceof b) && this.kNV) {
                com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.model.r) {
            ec(false);
            com.tencent.mm.ui.base.h.bu(this, getResources().getString(R.l.dOj));
            am.avg();
            com.tencent.mm.plugin.card.a.b.nX(4);
            this.kNW.HB();
            atL();
        } else if (kVar instanceof af) {
            ec(false);
            i3 = ((af) kVar).kRz;
            String str2 = ((af) kVar).kRA;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.l.dOu);
                }
                com.tencent.mm.plugin.card.b.d.b(this, str2, i3);
                return;
            }
            if (this.kNX != null) {
                ko auj = this.kNX.auj();
                auj.status = 3;
                this.kNX.a(auj);
                if (!am.avh().c(this.kNX, new String[0])) {
                    x.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", this.kNX.field_card_id);
                }
            }
            this.kNW.HB();
            atL();
        }
    }

    public int atA() {
        return n.a.kRr;
    }

    public BaseAdapter atB() {
        return new com.tencent.mm.plugin.card.ui.c(this, atA());
    }

    public boolean atC() {
        return true;
    }

    public boolean atD() {
        return true;
    }

    public void atE() {
    }

    public void b(b bVar) {
        if (!atC()) {
            x.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            x.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (!bVar.aum().equals("PRIVATE_TICKET_TITLE") && !bVar.aum().equals("PRIVATE_INVOICE_TITLE")) {
            if (bVar.atU()) {
                a(bVar);
            } else if (!TextUtils.isEmpty(bVar.aui().vYS)) {
                com.tencent.mm.plugin.card.b.b.a((MMActivity) this, bVar.aui().vYS, 0);
            }
        }
    }

    public void c(final b bVar) {
        if (!atD()) {
            x.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            x.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.atV()) {
                arrayList.add(getResources().getString(R.l.dOW));
            }
            arrayList.add(getResources().getString(R.l.dEH));
            final String aum = bVar.aum();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.aui().kQK);
            com.tencent.mm.ui.base.h.a((Context) this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    if (bVar.atV()) {
                        switch (i) {
                            case 0:
                                CardBaseUI.this.a((CardInfo) bVar);
                                return;
                            case 1:
                                com.tencent.mm.plugin.card.b.d.a(CardBaseUI.this, aum, "", new com.tencent.mm.plugin.card.b.d.a(aum) {
                                    public final void atM() {
                                        CardBaseUI.a(CardBaseUI.this, r3);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                    switch (i) {
                        case 0:
                            com.tencent.mm.plugin.card.b.d.a(CardBaseUI.this, aum, "", /* anonymous class already generated */);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            j(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    public void a(CardInfo cardInfo) {
        this.kNX = cardInfo;
        com.tencent.mm.plugin.card.b.b.a((MMActivity) this, 0, (a) this);
    }

    public final void j(final String str, int i, final boolean z) {
        if (this.kNX == null) {
            x.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.kNX.aui() == null) {
            x.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.kNX.auk().wTA)) {
                    stringBuilder.append(getString(R.l.eQm));
                } else {
                    stringBuilder.append(this.kNX.auk().wTA);
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperGift", Integer.valueOf(2), Integer.valueOf(this.kNX.aui().kPz), this.kNX.field_card_tp_id, this.kNX.field_card_id, str);
            } else if (i == 1) {
                stringBuilder.append(getString(R.l.dOt, new Object[]{this.kNX.aui().kQK}));
                com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperGift", Integer.valueOf(3), Integer.valueOf(this.kNX.aui().kPz), this.kNX.field_card_tp_id, this.kNX.field_card_id, str);
            }
            com.tencent.mm.pluginsdk.ui.applet.e.a(this.mController, stringBuilder.toString(), this.kNX.aui().kPA, this.kNX.aui().title + "\n" + this.kNX.aui().kQL, null, false, getResources().getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                public final void a(boolean z, String str, int i) {
                    if (z) {
                        CardBaseUI.c(CardBaseUI.this, str);
                        com.tencent.mm.ui.base.h.bu(CardBaseUI.this, CardBaseUI.this.getResources().getString(R.l.dOz));
                        if (z) {
                            Context context = CardBaseUI.this;
                            String str2 = str;
                            Intent intent = new Intent();
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", str2);
                            com.tencent.mm.plugin.card.a.ihN.e(intent, context);
                        }
                    }
                }
            });
        }
    }

    public final void atF() {
        if (this.hry == null) {
            this.hry = c.OV();
        }
        if (this.hry != null) {
            this.hry.a(this.gAn, true);
        }
    }

    public final void atG() {
        if (this.hry != null) {
            this.hry.a(this.gAn, true);
        }
    }

    public final void atH() {
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
    }

    public void atI() {
    }

    public void atJ() {
    }

    public void atK() {
    }

    public void atL() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardBaseUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    atK();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            CardBaseUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
