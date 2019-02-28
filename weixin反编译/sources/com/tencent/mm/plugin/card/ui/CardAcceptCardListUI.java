package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI extends DrawStatusBarActivity implements e, a {
    int fHR = 8;
    private String hdN = "";
    private r jqf = null;
    protected ListView kNP = null;
    protected RelativeLayout kNR = null;
    private boolean kPK = false;
    private String kRJ = "";
    private int kRK;
    private String kRL;
    private int kRM;
    private String kRN;
    private Button kTY;
    public int kUf = 0;
    private String kUg = "";
    private String kUh = "";
    public ArrayList<String> kUi = new ArrayList();
    public ArrayList<String> kUj = new ArrayList();
    private View kVB;
    private View kVC;
    private View kVD;
    protected a kVE = null;
    private View kVF;
    private View kVG;
    private TextView kVH;
    private Button kVI;
    LinkedList<kp> kVJ = new LinkedList();
    int kVK = 7;
    String kVL = "";
    String kVM = "";
    private String kVN = "";
    LinkedList<kp> kVO = new LinkedList();
    LinkedList<String> kVP = new LinkedList();
    HashMap<String, Integer> kVv = new HashMap();

    static /* synthetic */ void a(CardAcceptCardListUI cardAcceptCardListUI, LinkedList linkedList) {
        cardAcceptCardListUI.ec(true);
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            kp kpVar = (kp) linkedList.get(i);
            bjk bjk = new bjk();
            bjk.kPy = kpVar.kPy;
            bjk.fHQ = kpVar.fHQ;
            bjk.vLt = cardAcceptCardListUI.kVL;
            bjk.vLs = cardAcceptCardListUI.kVM;
            bjk.vLu = cardAcceptCardListUI.kVK;
            linkedList2.add(bjk);
        }
        bjs a = l.a(cardAcceptCardListUI.kUf, cardAcceptCardListUI.kUi, cardAcceptCardListUI.kUj);
        bmz bmz = new bmz();
        bmz.wWW = cardAcceptCardListUI.hdN;
        as.CN().a(new g(0, linkedList2, "", cardAcceptCardListUI.kVN, a, cardAcceptCardListUI.fHR, bmz), 0);
    }

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.kVJ.size(); i++) {
            linkedList.add(cardAcceptCardListUI.kVJ.get(i));
        }
        return linkedList;
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        x.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OpenShareUserSelectView", Integer.valueOf(0), "", "", "", "");
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.kUf);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.kUg);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.kUh);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(R.l.dPw));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("KLabel_is_filter_private", true);
        d.b(cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.jCj = cardAcceptCardListUI;
    }

    protected final int getLayoutId() {
        return R.i.bPv;
    }

    protected final void initView() {
        setMMTitle(R.l.dNF);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
                CardAcceptCardListUI.this.oi(1);
                return true;
            }
        });
        this.kVB = findViewById(R.h.bPv);
        this.kVC = findViewById(R.h.cSJ);
        this.kVD = findViewById(R.h.ctg);
        this.kVC.setVisibility(4);
        this.kNP = (ListView) findViewById(16908298);
        this.kNR = (RelativeLayout) findViewById(R.h.bYT);
        this.kNP.setEmptyView(this.kNR);
        this.kVE = new a(this);
        this.kNP.setAdapter(this.kVE);
        this.kNP.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.kVF = findViewById(R.h.bPz);
        this.kTY = (Button) findViewById(R.h.bPq);
        this.kTY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (CardAcceptCardListUI.this.kPK) {
                    CardAcceptCardListUI.a(CardAcceptCardListUI.this, CardAcceptCardListUI.b(CardAcceptCardListUI.this));
                    return;
                }
                CardAcceptCardListUI cardAcceptCardListUI = CardAcceptCardListUI.this;
                LinkedList b = CardAcceptCardListUI.b(CardAcceptCardListUI.this);
                cardAcceptCardListUI.ec(true);
                as.CN().a(new p(b, cardAcceptCardListUI.fHR, cardAcceptCardListUI.kVL, cardAcceptCardListUI.kVM, cardAcceptCardListUI.kVK), 0);
            }
        });
        this.kTY.setEnabled(false);
        this.kVG = findViewById(R.h.bRL);
        this.kVH = (TextView) findViewById(R.h.bRM);
        this.kVI = (Button) findViewById(R.h.bRK);
        this.kVI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                CardAcceptCardListUI.c(CardAcceptCardListUI.this);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            oi(2);
            return;
        }
        x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.fHR = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.kVK = getIntent().getIntExtra("key_stastic_scene", 7);
        this.kVL = getIntent().getStringExtra("src_username");
        this.kVM = getIntent().getStringExtra("js_url");
        this.kVN = getIntent().getStringExtra("key_consumed_card_id");
        this.hdN = getIntent().getStringExtra("key_template_id");
        Collection aZ = h.aZ(stringExtra, this.fHR);
        if (aZ == null || aZ.size() == 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            oi(2);
            return;
        }
        this.kVJ.clear();
        this.kVJ.addAll(aZ);
        this.kVO.clear();
        this.kVP.clear();
        this.kVv.clear();
        LinkedList linkedList = this.kVJ;
        ec(true);
        as.CN().a(new ab(linkedList, this.fHR, stringExtra2, stringExtra3, this.kVL, this.kVM, this.kVN, this.kVK), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(690, (e) this);
        as.CN().a(687, (e) this);
        as.CN().a(902, (e) this);
        initView();
    }

    protected void onDestroy() {
        as.CN().b(690, (e) this);
        as.CN().b(687, (e) this);
        as.CN().b(902, (e) this);
        this.kVJ.clear();
        a aVar = this.kVE;
        aVar.kUx.clear();
        aVar.mContext = null;
        super.onDestroy();
    }

    void ec(boolean z) {
        if (z) {
            this.jqf = r.b(this, getString(R.l.ctG), false, 0, null);
        } else if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
            this.jqf = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        int dimensionPixelOffset;
        Intent intent;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + kVar.getType() + "errType = " + i + " errCode = " + i2);
            ec(false);
            com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            if (kVar instanceof p) {
                this.kRJ = str;
            } else if (kVar instanceof g) {
                this.kRJ = "";
            }
        } else if (kVar instanceof ab) {
            ec(false);
            ab abVar = (ab) kVar;
            str2 = abVar.kRy;
            this.kRK = abVar.kRK;
            this.kRL = abVar.kRL;
            this.kRM = abVar.kRM;
            this.kRN = abVar.kRN;
            x.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.kRK + "  accept_button_wording: " + this.kRL);
            x.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.kRM + "  private_wording: " + this.kRN);
            List xn = f.xn(str2);
            Collection an = an(xn);
            if (xn == null || xn.size() <= 0) {
                x.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                x.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + xn.size());
                if (an != null && an.size() > 0) {
                    a aVar = this.kVE;
                    Map map = this.kVv;
                    if (an != null) {
                        aVar.kUx.clear();
                        aVar.kUx.addAll(an);
                        aVar.kVv.putAll(map);
                    }
                }
                this.kVE.notifyDataSetChanged();
                if (((CardInfo) xn.get(0)).atO()) {
                    this.kPK = true;
                }
            }
            this.kVC.setVisibility(0);
            if (this.kVE.getCount() > 0) {
                Drawable cm;
                b oh = this.kVE.oh(0);
                m.a((MMActivity) this, oh);
                this.kVB.setBackgroundColor(l.xu(oh.aui().hdx));
                com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, l.xu(oh.aui().hdx), true);
                this.kVF.setVisibility(0);
                Drawable stateListDrawable = new StateListDrawable();
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.bwz);
                if (this.kRK == 1) {
                    this.kTY.setEnabled(true);
                    cm = l.cm(l.xu(oh.aui().hdx), dimensionPixelOffset);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, l.cm(l.bc(oh.aui().hdx, ac.CTRL_BYTE), dimensionPixelOffset));
                    stateListDrawable.addState(new int[0], cm);
                } else {
                    this.kTY.setEnabled(false);
                    stateListDrawable.addState(new int[0], l.cm(l.bc(oh.aui().hdx, ac.CTRL_BYTE), dimensionPixelOffset));
                }
                this.kTY.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.kRL)) {
                    this.kTY.setText(this.kRL);
                }
                if (this.kRM == 1) {
                    int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.f.bvK);
                    Drawable d = l.d(this, getResources().getColor(R.e.white), dimensionPixelOffset2);
                    stateListDrawable = l.cm(getResources().getColor(R.e.white), dimensionPixelOffset2);
                    cm = new StateListDrawable();
                    cm.addState(new int[]{16842919}, stateListDrawable);
                    cm.addState(new int[0], d);
                    this.kVI.setBackgroundDrawable(cm);
                    int[] iArr2 = new int[]{l.xu(oh.aui().hdx), getResources().getColor(R.e.white)};
                    this.kVI.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.kVG.setVisibility(0);
                    if (TextUtils.isEmpty(this.kRN)) {
                        this.kVH.setText(R.l.dPt);
                        return;
                    } else {
                        this.kVH.setText(this.kRN);
                        return;
                    }
                }
                this.kVG.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.kVC.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.bvT);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.f.bvy);
                this.kVC.setLayoutParams(layoutParams);
                this.kVC.invalidate();
                layoutParams = (LayoutParams) this.kVF.getLayoutParams();
                layoutParams.addRule(8, R.h.ctg);
                this.kVF.setLayoutParams(layoutParams);
                this.kVF.invalidate();
                return;
            }
            this.kVF.setVisibility(8);
            this.kVG.setVisibility(8);
            this.kVB.setBackgroundColor(getResources().getColor(R.e.brI));
        } else if (kVar instanceof p) {
            ec(false);
            p pVar = (p) kVar;
            if (pVar.kRz != 0) {
                str2 = pVar.kRA;
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.l.dNT);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str2, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.this.oi(2);
                    }
                });
                this.kRJ = pVar.kRy;
                return;
            }
            com.tencent.mm.ui.base.h.bu(this, getResources().getString(R.l.dOy));
            intent = new Intent();
            intent.putExtra("card_list", pVar.kRy);
            setResult(-1, intent);
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            l.axL();
            finish();
        } else if (kVar instanceof g) {
            ec(false);
            String str3 = ((g) kVar).kRy;
            dimensionPixelOffset = ((g) kVar).kRz;
            str2 = ((g) kVar).kRA;
            this.kRJ = str3;
            if (dimensionPixelOffset != 0) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.l.dPC);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str2, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.this.oi(2);
                    }
                });
                return;
            }
            com.tencent.mm.ui.base.h.bu(this, getResources().getString(R.l.dNK));
            intent = new Intent();
            intent.putExtra("card_list", this.kRJ);
            setResult(-1, intent);
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            l.axN();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            f.a(shareCardInfo, str3);
            l.a(shareCardInfo);
            am.avo().asP();
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            oi(1);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void oi(int i) {
        x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:" + i);
        Intent intent = new Intent();
        intent.putExtra("card_list", this.kRJ);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
    }

    public final void b(int i, int i2, Intent intent) {
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.kUf = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", Integer.valueOf(this.kUf));
                    if (this.kUf >= 2) {
                        this.kUg = intent.getStringExtra("Klabel_name_list");
                        this.kUh = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kUf), this.kUg);
                        if (TextUtils.isEmpty(this.kUg) && TextUtils.isEmpty(this.kUh)) {
                            x.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                            avX();
                            return;
                        }
                        List asList = Arrays.asList(this.kUg.split(","));
                        this.kUj = l.aq(asList);
                        this.kUi = l.ap(asList);
                        if (this.kUh != null && this.kUh.length() > 0) {
                            this.kUi.addAll(Arrays.asList(this.kUh.split(",")));
                        }
                        if (this.kUj != null) {
                            x.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.kUj.size());
                        }
                        if (this.kUi != null) {
                            x.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.kUi.size());
                            Iterator it = this.kUi.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardAcceptCardListUI", "username : %s", (String) it.next());
                            }
                        }
                        if (TextUtils.isEmpty(this.kUg)) {
                            avX();
                            return;
                        } else if (this.kUf == 2) {
                            this.kVH.setText(getString(R.l.dPv, new Object[]{avJ()}));
                            return;
                        } else if (this.kUf == 3) {
                            this.kVH.setText(getString(R.l.dPu, new Object[]{avJ()}));
                            return;
                        } else {
                            return;
                        }
                    }
                    avX();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String avJ() {
        if (!TextUtils.isEmpty(this.kUg) && !TextUtils.isEmpty(this.kUh)) {
            return this.kUg + "," + l.xy(this.kUh);
        }
        if (!TextUtils.isEmpty(this.kUg)) {
            return this.kUg;
        }
        if (TextUtils.isEmpty(this.kUh)) {
            return "";
        }
        return l.xy(this.kUh);
    }

    private void avX() {
        if (TextUtils.isEmpty(this.kRN)) {
            this.kVH.setText(R.l.dPt);
        } else {
            this.kVH.setText(this.kRN);
        }
    }

    private ArrayList<CardInfo> an(List<CardInfo> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            return null;
        }
        this.kVO.clear();
        this.kVP.clear();
        this.kVv.clear();
        ArrayList<CardInfo> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            CardInfo cardInfo = (CardInfo) list.get(i2);
            if (this.kVP.contains(cardInfo.field_card_tp_id)) {
                this.kVv.put(cardInfo.field_card_tp_id, Integer.valueOf(((Integer) this.kVv.get(cardInfo.field_card_tp_id)).intValue() + 1));
            } else {
                arrayList.add(cardInfo);
                this.kVv.put(cardInfo.field_card_tp_id, Integer.valueOf(1));
                this.kVP.add(cardInfo.field_card_tp_id);
            }
            i = i2 + 1;
        }
    }
}
