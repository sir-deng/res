package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.jw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.t.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private ProgressDialog inI;
    private int scene;
    private b yHM = new b() {
        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            int i3 = 0;
            if (bVar instanceof jw) {
                jw jwVar = (jw) bVar;
                if (MMCreateChatroomUI.this.zdt != null) {
                    if (MMCreateChatroomUI.this.inI != null) {
                        MMCreateChatroomUI.this.inI.dismiss();
                        MMCreateChatroomUI.this.inI = null;
                    }
                    MMCreateChatroomUI.this.zdt = null;
                    MMCreateChatroomUI.this.zds = false;
                    MMCreateChatroomUI.this.chatroomName = jwVar.fBG.fBK;
                    if (!a.a(MMCreateChatroomUI.this, i, i2, str, 4)) {
                        String i4;
                        if (i == 0 && i2 == 0 && !bi.oN(MMCreateChatroomUI.this.chatroomName)) {
                            l.a(MMCreateChatroomUI.this.chatroomName, jwVar.fBG.fBP, MMCreateChatroomUI.this.getString(R.l.dQI), false, "");
                            List list = jwVar.fBG.fBO;
                            if (list != null && list.size() > 0) {
                                List linkedList = new LinkedList();
                                while (i3 < list.size()) {
                                    linkedList.add(list.get(i3));
                                    i3++;
                                }
                                l.a(MMCreateChatroomUI.this.chatroomName, linkedList, MMCreateChatroomUI.this.getString(R.l.dQJ), true, "weixin://findfriend/verifycontact/" + MMCreateChatroomUI.this.chatroomName + "/");
                            }
                            i4 = MMCreateChatroomUI.this.chatroomName;
                            Intent intent = new Intent();
                            if (MMCreateChatroomUI.this.zxf) {
                                intent.putExtra("Chat_User", i4);
                                d.a(MMCreateChatroomUI.this, ".ui.chatting.ChattingUI", intent);
                            } else {
                                intent.putExtra("Select_Contact", i4);
                                intent.putExtra("Select_Conv_User", i4);
                                intent.putExtra("Select_Contact", i4);
                                intent.putExtra("need_delete_chatroom_when_cancel", true);
                                MMCreateChatroomUI.this.setResult(-1, intent);
                            }
                            MMCreateChatroomUI.this.finish();
                            return;
                        }
                        String str2 = "";
                        i4 = "";
                        String string = ad.getContext().getString(R.l.dQK);
                        if (i2 == -23) {
                            str2 = MMCreateChatroomUI.this.getString(R.l.eFX);
                            i4 = MMCreateChatroomUI.this.getString(R.l.eFW);
                        }
                        List list2 = jwVar.fBG.fBO;
                        List list3 = jwVar.fBG.fBM;
                        if (list2 == null || list2.size() <= 0 || (list2.size() != jwVar.fBG.fBJ && (list3 == null || list3.size() <= 0 || jwVar.fBG.fBJ != list2.size() + list3.size()))) {
                            String str3;
                            list2 = jwVar.fBG.fBM;
                            if (list2 == null || list2.size() <= 0 || jwVar.fBG.fBJ != list2.size()) {
                                str3 = str2;
                                str2 = i4;
                            } else {
                                str2 = MMCreateChatroomUI.this.getString(R.l.esV);
                                Object[] objArr = new Object[]{bi.d(MMCreateChatroomUI.at(list2), string)};
                                str3 = str2;
                                str2 = i4 + MMCreateChatroomUI.this.getString(R.l.eiS, objArr);
                            }
                            List<String> list32 = jwVar.fBG.fBL;
                            if (list32 != null && list32.size() > 0) {
                                boolean z;
                                for (String i42 : list32) {
                                    if (x.Xg(i42)) {
                                        str3 = MMCreateChatroomUI.this.getString(R.l.esV);
                                        str2 = MMCreateChatroomUI.this.getString(R.l.fXC);
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                                if (!z) {
                                    str3 = MMCreateChatroomUI.this.getString(R.l.esV);
                                    str2 = str2 + MMCreateChatroomUI.this.getString(R.l.eiV, new Object[]{bi.d(MMCreateChatroomUI.at(list32), string)});
                                }
                            }
                            if (str3 == null || str3.length() <= 0) {
                                Toast.makeText(MMCreateChatroomUI.this, MMCreateChatroomUI.this.getString(R.l.eiI, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                                return;
                            }
                            h.b(MMCreateChatroomUI.this, str2, str3, true);
                            return;
                        }
                        LinkedList linkedList2 = new LinkedList();
                        for (int i5 = 0; i5 < list2.size(); i5++) {
                            linkedList2.add(list2.get(i5));
                        }
                        MMCreateChatroomUI.a(MMCreateChatroomUI.this, linkedList2, list32);
                    }
                }
            }
        }
    };
    private boolean zds;
    private jw zdt;
    private List<String> zwW;
    private boolean zxf;
    a zxg;
    private b zxh;
    private boolean zxi;

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new q(mMCreateChatroomUI, new q.a() {
            public final void ep(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, final LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ad.getContext().getString(R.l.dQK);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        Object[] objArr = new Object[]{bi.d(at(arrayList), string)};
        h.a((Context) mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.ejb, objArr), mMCreateChatroomUI.getString(R.l.esV), mMCreateChatroomUI.getString(R.l.eja), mMCreateChatroomUI.getString(R.l.eiZ), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                MMCreateChatroomUI.a(MMCreateChatroomUI.this, linkedList);
            }
        }, null);
    }

    static /* synthetic */ void b(MMCreateChatroomUI mMCreateChatroomUI) {
        mMCreateChatroomUI.zdt = new jw();
        mMCreateChatroomUI.zdt.fBF.fBH = "";
        mMCreateChatroomUI.zdt.fBF.fBI = mMCreateChatroomUI.zxg.cyZ();
        com.tencent.mm.sdk.b.a.xmy.m(mMCreateChatroomUI.zdt);
        mMCreateChatroomUI.getString(R.l.dGZ);
        mMCreateChatroomUI.inI = h.a((Context) mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.esW), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                MMCreateChatroomUI.this.zds = false;
                if (MMCreateChatroomUI.this.zdt != null) {
                    MMCreateChatroomUI.this.zdt.fBF.fBE = true;
                    com.tencent.mm.sdk.b.a.xmy.m(MMCreateChatroomUI.this.zdt);
                }
            }
        });
    }

    public final /* bridge */ /* synthetic */ o cwQ() {
        return this.zxg;
    }

    protected final void Xc() {
        super.Xc();
        this.zwW = getIntent().getStringArrayListExtra("query_phrase_list");
        this.zxf = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
    }

    protected final void initView() {
        super.initView();
        a aVar = this.zxg;
        for (String str : aVar.zwW) {
            g gVar = new g();
            gVar.handler = aVar.handler;
            gVar.mRK = aVar.pni;
            gVar.fEe = str;
            gVar.mRJ = com.tencent.mm.plugin.fts.a.c.b.mSk;
            gVar.mRF = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            gVar.mRI.add("filehelper");
            gVar.mRI.add(com.tencent.mm.y.q.FY());
            com.tencent.mm.plugin.fts.a.a.a search = ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
            aVar.zwX = new ArrayList();
            aVar.zwX.add(search);
        }
        a(1, getString(R.l.dGf), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!MMCreateChatroomUI.this.zds) {
                    MMCreateChatroomUI.this.zds = true;
                    MMCreateChatroomUI.b(MMCreateChatroomUI.this);
                    if (MMCreateChatroomUI.this.scene == 3) {
                        MMCreateChatroomUI.this.zxi = true;
                        e.bT(true);
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
                return true;
            }
        }, p.b.xSe);
        Xi();
        b.a(jw.class.getName(), this.yHM);
    }

    public final void Xi() {
        List cyZ = this.zxg.cyZ();
        if (cyZ.size() > 0) {
            updateOptionMenuText(1, getString(R.l.dGf) + "(" + cyZ.size() + ")");
            if (cyZ.size() > 1) {
                enableOptionMenu(1, true);
                return;
            } else {
                enableOptionMenu(1, false);
                return;
            }
        }
        updateOptionMenuText(1, getString(R.l.dGf));
        enableOptionMenu(1, false);
    }

    protected void onDestroy() {
        this.zxg.finish();
        b.b(jw.class.getName(), this.yHM);
        if (!this.zxi && this.scene == 3) {
            e.bT(false);
        }
        super.onDestroy();
    }

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return false;
    }

    protected final String Xf() {
        return getString(R.l.eJD);
    }

    protected final o Xg() {
        if (this.zxg == null) {
            this.zxg = new a(this, this.zwW, this.scene);
        }
        return this.zxg;
    }

    protected final com.tencent.mm.ui.contact.m Xh() {
        if (this.zxh == null) {
            this.zxh = new b(this, this.scene);
        }
        return this.zxh;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof com.tencent.mm.ui.contact.a.d)) {
            return false;
        }
        com.tencent.mm.ui.contact.a.d dVar = (com.tencent.mm.ui.contact.a.d) aVar;
        a aVar2 = this.zxg;
        String str = dVar.iZi.mRd;
        int i = aVar.position;
        if (aVar2.ikQ.contains(str)) {
            a aVar3;
            for (int size = aVar2.zwY.size() - 1; size >= 0; size--) {
                aVar3 = (a) aVar2.zwY.get(size);
                if (i >= aVar3.mUE) {
                    break;
                }
            }
            aVar3 = null;
            if (aVar3 == null) {
                return false;
            }
            if (!str.equals(aVar3.zxb)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof com.tencent.mm.ui.contact.a.d)) {
            return false;
        }
        com.tencent.mm.ui.contact.a.d dVar = (com.tencent.mm.ui.contact.a.d) aVar;
        a aVar2 = this.zxg;
        if (aVar2.ikQ.contains(dVar.iZi.mRd)) {
            return true;
        }
        return false;
    }

    private static List<String> at(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!as.Hp()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            as.Hm();
            com.tencent.mm.k.a Xv = c.Ff().Xv(obj2);
            if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                obj2 = Xv.AX();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final boolean cwX() {
        return true;
    }

    public final void jd(int i) {
        n nVar = this.zxg;
        com.tencent.mm.plugin.fts.a.a.h hVar = this.zxh.mRz;
        String str = this.zxh.fEe;
        if (!(hVar.mRN.size() == 1 && ((j) hVar.mRN.get(0)).mRd.equals("no_result​"))) {
            a aVar = new a(nVar, (byte) 0);
            aVar.mRN = hVar.mRN;
            aVar.mRM = hVar.mRM;
            aVar.fEe = str;
            nVar.zwY.add(aVar);
            int headerViewsCount = i - nVar.zbQ.buq().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                hVar.mRN.add(0, (j) hVar.mRN.remove(headerViewsCount));
                i = nVar.zbQ.buq().getHeaderViewsCount();
            }
            nVar.cyY();
            nVar.zbQ.buq().post(new com.tencent.mm.ui.transmit.a.AnonymousClass2((aVar.mUE + i) + 1));
        }
        cwV();
        cwW();
        aWY();
    }

    public final void oW(String str) {
        a aVar = this.zxg;
        aVar.ikQ.remove(str);
        for (a aVar2 : aVar.zwY) {
            if (str.equals(aVar2.zxb)) {
                aVar2.zxb = null;
            }
        }
        aVar.notifyDataSetChanged();
        Xi();
    }
}
