package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.cb;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TVInfoUI extends MMPreference implements e, a {
    private long frh;
    private TextView ikn;
    protected ProgressDialog inI = null;
    protected f inW;
    private ImageView kYJ;
    private boolean qcb = false;
    private boolean qeC = false;
    private String qyD = "";
    private TextView qyE;
    private c.a qyF;
    private b qyG;

    static /* synthetic */ void a(TVInfoUI tVInfoUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(tVInfoUI.getString(R.l.eYt));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(tVInfoUI.getString(R.l.eYu));
        linkedList2.add(Integer.valueOf(1));
        if (tVInfoUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            str = tVInfoUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true) ? tVInfoUI.getString(R.l.dEH) : "";
        } else {
            linkedList.add(tVInfoUI.getString(R.l.eAq));
            linkedList2.add(Integer.valueOf(2));
        }
        h.a((Context) tVInfoUI, "", linkedList, linkedList2, str, false, new d() {
            public final void cr(int i, int i2) {
                switch (i2) {
                    case -1:
                        h.a(TVInfoUI.this.mController.xRr, TVInfoUI.this.mController.xRr.getString(R.l.dEI), null, null, TVInfoUI.this.mController.xRr.getString(R.l.dEH), new d() {
                            public final void cr(int i, int i2) {
                                switch (i2) {
                                    case -1:
                                        com.tencent.mm.sdk.b.b cbVar = new cb();
                                        cbVar.frd.frf = TVInfoUI.this.getIntent().getLongExtra("key_favorite_local_id", -1);
                                        com.tencent.mm.sdk.b.a.xmy.m(cbVar);
                                        x.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", Long.valueOf(cbVar.frd.frf), Boolean.valueOf(cbVar.fre.fqR));
                                        if (cbVar.fre.fqR) {
                                            TVInfoUI.this.finish();
                                            return;
                                        }
                                        return;
                                    default:
                                        x.d("MicroMsg.TVInfoUI", "do del cancel");
                                        return;
                                }
                            }
                        });
                        return;
                    case 0:
                        TVInfoUI.b(TVInfoUI.this);
                        return;
                    case 1:
                        TVInfoUI.c(TVInfoUI.this);
                        return;
                    case 2:
                        TVInfoUI.d(TVInfoUI.this);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && aVar.qha != null && aVar.qha.size() != 0 && tVInfoUI.inW != null) {
            tVInfoUI.inW.removeAll();
            for (int i = 0; i < aVar.qha.size(); i++) {
                com.tencent.mm.plugin.shake.e.a aVar2 = (com.tencent.mm.plugin.shake.e.a) aVar.qha.get(i);
                if (!(aVar2 == null || aVar2.hPU == null || aVar2.hPU.size() == 0)) {
                    for (int i2 = 0; i2 < aVar2.hPU.size(); i2++) {
                        String str = ((i * 100) + i2);
                        com.tencent.mm.plugin.shake.e.a.a aVar3 = (com.tencent.mm.plugin.shake.e.a.a) aVar2.hPU.get(i2);
                        Preference preference;
                        if (aVar3.type == 2) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(R.i.dtw);
                            preference.setTitle(bi.oN(aVar3.title) ? tVInfoUI.getResources().getString(R.l.ePt) : aVar3.title);
                            preference.setSummary(String.format(tVInfoUI.getResources().getString(R.l.ePs), new Object[]{Integer.valueOf(108)}));
                        } else if (aVar3.qyQ == null || aVar3.qyQ.size() <= 0) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(R.i.dtw);
                            preference.setTitle(aVar3.title);
                            preference.setSummary(aVar3.now);
                            tVInfoUI.inW.a(preference);
                        } else {
                            List arrayList = new ArrayList();
                            int i3 = 0;
                            while (i3 < aVar3.qyQ.size() && i3 < 3 && (i3 != 2 || aVar3.title.length() <= 4)) {
                                arrayList.add(aVar3.qyQ.get(i3));
                                i3++;
                            }
                            preference = new TVThumbPreference(tVInfoUI);
                            preference.setKey(str);
                            preference.qyN = arrayList;
                            preference.setTitle(aVar3.title);
                            preference.jPY = tVInfoUI.inW;
                            tVInfoUI.inW.a(preference);
                        }
                    }
                }
            }
            tVInfoUI.inW.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 10);
        com.tencent.mm.plugin.shake.a.ihN.j(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        if (tVInfoUI.qyF == null) {
            x.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            return;
        }
        g.pWK.h(10987, Integer.valueOf(4), "", "", "");
        String a = c.a(tVInfoUI.mController.xRr, tVInfoUI.qyF);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.qyG != null && tVInfoUI.qcb) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.qyG.Wo());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.ihN.l(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && !bi.oN(aVar.field_thumburl)) {
            tVInfoUI.qyG = new b(aVar);
            tVInfoUI.qyD = tVInfoUI.qyG.Wq();
            Bitmap a = j.a(tVInfoUI.qyG);
            x.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", a);
            if (a != null) {
                tVInfoUI.kYJ.setImageBitmap(a);
                tVInfoUI.qcb = true;
                tVInfoUI.bpP();
                return;
            }
            tVInfoUI.kYJ.setImageDrawable(tVInfoUI.getResources().getDrawable(R.k.dBx));
        }
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        if (tVInfoUI.qyF == null) {
            x.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            return;
        }
        g.pWK.h(10987, Integer.valueOf(3), "", "", "");
        Intent intent = new Intent();
        if (bi.oN(tVInfoUI.qyF.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.qyF.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.qyF.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.qyF.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.qyF.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(R.l.eIB));
        if (k.bsk()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.qyF.field_thumburl);
        if (tVInfoUI.qyG != null && tVInfoUI.qcb) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.qyG.Wo());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.qyF));
        String hC = u.hC("shake_tv");
        u.GQ().t(hC, true).o("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", hC);
        com.tencent.mm.bl.d.b(tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        if (tVInfoUI.qyF == null) {
            x.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            return;
        }
        g.pWK.h(10987, Integer.valueOf(5), "", "", "");
        com.tencent.mm.sdk.b.b cgVar = new cg();
        vn vnVar = new vn();
        vt vtVar = new vt();
        vw vwVar = new vw();
        vtVar.UN(q.FY());
        vtVar.UO(q.FY());
        vtVar.Dl(8);
        vtVar.fD(bi.Wy());
        if (k.bsk()) {
            vtVar.UT("wxaf060266bfa9a35c");
        }
        vwVar.UW(tVInfoUI.qyF.field_title);
        if (bi.oN(tVInfoUI.qyF.field_topic)) {
            vwVar.UX(tVInfoUI.qyF.field_subtitle);
        } else {
            vwVar.UX(tVInfoUI.qyF.field_topic);
        }
        vwVar.UZ(c.b(tVInfoUI.qyF));
        vwVar.UY(tVInfoUI.qyF.field_thumburl);
        cgVar.frk.title = tVInfoUI.qyF.field_title;
        cgVar.frk.desc = tVInfoUI.qyF.field_topic;
        cgVar.frk.frm = vnVar;
        cgVar.frk.type = 15;
        vnVar.a(vtVar);
        vnVar.b(vwVar);
        cgVar.frk.frr = 12;
        cgVar.frk.activity = tVInfoUI;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
    }

    protected final int getLayoutId() {
        return R.i.dtu;
    }

    public final int XK() {
        return R.o.fcQ;
    }

    public final int atg() {
        return R.i.dtv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j.b((a) this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(552, (e) this);
    }

    protected void onPause() {
        as.CN().b(552, (e) this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c((a) this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eIy);
        this.inW = this.yrJ;
        this.ikn = (TextView) findViewById(R.h.cTH);
        this.qyE = (TextView) findViewById(R.h.cTI);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (bi.oN(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        x.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", stringExtra);
        this.qyF = c.JT(stringExtra);
        if (this.qyF == null) {
            x.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            return;
        }
        a(this.qyF);
    }

    private void a(final c.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        this.ikn.setText(aVar.field_title);
        if (bi.oN(aVar.field_topic)) {
            this.qyE.setVisibility(8);
        } else {
            this.qyE.setText(aVar.field_topic);
        }
        this.kYJ = (ImageView) findViewById(R.h.cTG);
        if (!bi.oN(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(R.h.cTF);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.h(10987, Integer.valueOf(2), aVar.field_playstatid, "", "");
                    TVInfoUI.a(TVInfoUI.this, aVar.field_playurl);
                }
            });
            this.kYJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.h(10987, Integer.valueOf(2), aVar.field_playstatid, "", "");
                    TVInfoUI.a(TVInfoUI.this, aVar.field_playurl);
                }
            });
        }
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                TVInfoUI.a(TVInfoUI.this);
                return true;
            }
        });
        if (!(bi.oN(aVar.field_id) || this.qeC || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            x.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", aVar.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0)));
            as.CN().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, r0), 0);
            this.qeC = true;
        }
        this.kYJ.setVisibility(0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                TVInfoUI.this.finish();
                return true;
            }
        });
        x.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        ah.y(new Runnable() {
            public final void run() {
                TVInfoUI.a(TVInfoUI.this, aVar);
                TVInfoUI.b(TVInfoUI.this, aVar);
            }
        });
    }

    private void bpP() {
        this.frh = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.frh > 0 && as.Hp()) {
            as.Hm();
            au dI = com.tencent.mm.y.c.Fh().dI(this.frh);
            if (dI.field_msgId > 0) {
                dI.dV(this.qyG.Wo());
                as.Hm();
                com.tencent.mm.y.c.Fh().a(this.frh, dI);
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", preference.idX);
        if (this.qyF == null || this.qyF.qha == null) {
            x.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.idX).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            x.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2));
            if (i < 0 || i >= this.qyF.qha.size()) {
                x.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i), Integer.valueOf(this.qyF.qha.size()));
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = (com.tencent.mm.plugin.shake.e.a) this.qyF.qha.get(i);
            if (aVar == null) {
                x.w("MicroMsg.TVInfoUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.hPU.size()) {
                x.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i2), Integer.valueOf(aVar.hPU.size()));
                return false;
            } else {
                com.tencent.mm.plugin.shake.e.a.a aVar2 = (com.tencent.mm.plugin.shake.e.a.a) aVar.hPU.get(i2);
                if (aVar2 == null) {
                    x.w("MicroMsg.TVInfoUI", "action == null");
                    return false;
                }
                x.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.qyP + ", targetDesc:" + aVar2.qyR + ", targetDesc2:" + aVar2.qyS);
                Intent intent;
                if (aVar2.type == 3) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", aVar2.qyP);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("geta8key_scene", 10);
                    intent.putExtra("srcUsername", aVar2.qyS);
                    com.tencent.mm.plugin.shake.a.ihN.j(intent, this);
                } else if (aVar2.type == 4) {
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(aVar2.qyP);
                    if (Xv != null) {
                        Intent intent2 = new Intent();
                        if (com.tencent.mm.k.a.ga(Xv.field_type) && Xv.ciN()) {
                            y.Ml().jN(aVar2.qyP);
                            if (aVar2.qyR.equals("1")) {
                                intent2.putExtra("Chat_User", aVar2.qyP);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.ihN.e(intent2, (Context) this);
                            }
                        }
                        intent2.putExtra("Contact_User", aVar2.qyP);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.bl.d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    }
                } else if (aVar2.type == 5) {
                    com.tencent.mm.sdk.b.b gxVar = new gx();
                    gxVar.fxW.actionCode = 11;
                    gxVar.fxW.result = aVar2.qyP;
                    gxVar.fxW.context = this;
                    gxVar.frD = null;
                    com.tencent.mm.sdk.b.a.xmy.a(gxVar, Looper.myLooper());
                } else if (aVar2.type == 6) {
                    intent = new Intent();
                    intent.putExtra("key_product_id", aVar2.qyP);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.bl.d.b(this, "product", ".ui.MallProductUI", intent);
                }
                return true;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            x.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
            return false;
        }
    }

    public final void l(final String str, final Bitmap bitmap) {
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            x.d(str2, str3, objArr);
            try {
                ah.y(new Runnable() {
                    public final void run() {
                        if (TVInfoUI.this.qyD != null && TVInfoUI.this.qyD.equals(str)) {
                            if (!(TVInfoUI.this.kYJ == null || bitmap == null)) {
                                TVInfoUI.this.kYJ.setImageBitmap(bitmap);
                                TVInfoUI.this.bpP();
                            }
                            TVInfoUI.this.qcb = true;
                        }
                        f fVar = TVInfoUI.this.inW;
                    }
                });
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", e.getLocalizedMessage());
                x.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (kVar == null) {
            x.w("MicroMsg.TVInfoUI", "scene == null");
        } else if (kVar.getType() != 552) {
        } else {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                Toast.makeText(this, R.l.eIz, 0).show();
            } else if (this.qyF == null) {
                x.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
            } else {
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) kVar;
                agz agz = (bVar.gLB == null || bVar.gLB.hnR.hnY == null) ? null : (agz) bVar.gLB.hnR.hnY;
                if (agz == null) {
                    x.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                } else if (agz.vUQ != null) {
                    x.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + agz.vUQ);
                    c.a JT = c.JT(agz.vUQ);
                    if (this.qyF != null && this.qyF.field_xml != null && JT != null && JT.field_xml != null && !this.qyF.field_xml.equals(JT.field_xml)) {
                        this.qyF = JT;
                        a(this.qyF);
                    }
                }
            }
        }
    }
}
