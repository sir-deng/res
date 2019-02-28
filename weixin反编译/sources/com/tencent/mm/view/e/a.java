package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.f.a.na;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.m.a.i;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.MMRadioGroupView.c;
import com.tencent.mm.view.SmileyPanelScrollView;
import com.tencent.mm.view.SmileyPanelScrollView.b;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.a.d;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a implements e, OnClickListener, c, b, com.tencent.mm.view.SmileyPanelViewPager.a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    public Context kgx;
    public final com.tencent.mm.sdk.e.j.a lCP = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    a.this.cBH();
                } else if (g.Do().CF()) {
                    EmojiInfo yI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(str);
                    if (yI != null && yI.field_catalog == EmojiInfo.xIN) {
                        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBK();
                        a.this.cBH();
                    }
                }
            }
        }
    };
    public final com.tencent.mm.sdk.b.c lCQ = new com.tencent.mm.sdk.b.c<na>() {
        {
            this.xmG = na.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            a.this.cBH();
            return false;
        }
    };
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case TXLiveConstants.PUSH_WARNING_RECONNECT /*1102*/:
                    a.this.cBB();
                    a.this.zPw = true;
                    if (a.this.zPx != null && a.this.zPi != null) {
                        int i = a.this.zMB.zPO;
                        if (i < 0 || i > a.this.zMB.abc(a.this.zPx).cBA()) {
                            i = a.this.zMB.abc(a.this.zPx).cBA() - 1;
                        }
                        a.this.zPu = i + a.this.zMB.abc(a.this.zPx).kgz;
                        a.this.zPi.ah(a.this.zPu);
                        a.this.zPx = null;
                        return;
                    }
                    return;
                case TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL /*1103*/:
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                    a aVar = a.this;
                    int i2 = message.arg1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    aVar.c(i2, z, false);
                    return;
                default:
                    return;
            }
        }
    };
    public View mView;
    public Context tI = ad.getContext();
    public com.tencent.mm.view.f.a zMB;
    private final int zPe = 100;
    private final int zPf = TXLiveConstants.PUSH_WARNING_RECONNECT;
    private final int zPg = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
    private final int zPh = 100;
    public SmileyPanelViewPager zPi;
    private d zPj;
    public SmileyPanelScrollView zPk;
    public HorizontalListViewV2 zPl;
    public com.tencent.mm.view.a.e zPm;
    public View zPn;
    public ImageView zPo;
    public ImageView zPp;
    private ImageButton zPq;
    public ImageButton zPr;
    public TextView zPs;
    public a zPt;
    private int zPu = -1;
    private boolean zPv = false;
    public boolean zPw = true;
    public String zPx;
    public final com.tencent.mm.sdk.e.j.a zPy = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                    a.this.cBH();
                }
            }
        }
    };
    public OnItemClickListener zPz = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EmojiGroupInfo HK = a.this.zPm.HK(i);
            if (HK == null) {
                x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
            } else if (HK.field_productID.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
                com.tencent.mm.bl.d.b(a.this.tI, "emoji", ".ui.EmojiMineUI", new Intent());
            } else {
                a.this.c(a.this.zMB.HR(a.this.zPu), false, true);
                com.tencent.mm.view.c.a abc = a.this.zMB.abc(HK.field_productID);
                a.this.zPu = abc.kgz;
                int cBA = abc.zPd > abc.cBA() + -1 ? abc.cBA() - 1 : abc.zPd;
                if (a.this.zPi != null) {
                    a.this.zPi.d(a.this.zPu + cBA, false);
                }
                a.this.t(abc.cBA(), cBA, true);
                a.this.zMB.zPO = cBA;
                a.this.zMB.abb(HK.field_productID);
                if (HK.equals(String.valueOf(EmojiGroupInfo.xIF))) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(11594, Integer.valueOf(0));
                }
            }
        }
    };

    /* renamed from: com.tencent.mm.view.e.a$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String lCi;

        public AnonymousClass3(String str) {
            this.lCi = str;
        }

        public final void run() {
            if (a.this.zPi != null && a.this.zMB != null && a.this.zMB.abc(this.lCi) != null) {
                a.this.zPu = a.this.zMB.abc(this.lCi).kgz;
                a.this.zPi.ah(a.this.zPu);
                a.this.zMB.zPO = 0;
            }
        }
    }

    public interface a {
        com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a cBe();

        j cBf();
    }

    public a(Context context, com.tencent.mm.view.f.a aVar, a aVar2) {
        this.kgx = context;
        this.zMB = aVar;
        this.zPt = aVar2;
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().i(this.zPy);
        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().g(this.lCP);
        com.tencent.mm.sdk.b.a.xmy.b(this.lCQ);
    }

    public final synchronized void cBB() {
        if (this.mView == null || !this.zMB.zQe) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
        } else {
            Object obj;
            ArrayList aBI;
            int i;
            Collection arrayList;
            Iterator it;
            int i2;
            EmojiGroupInfo emojiGroupInfo;
            com.tencent.mm.view.a.e eVar;
            long currentTimeMillis = System.currentTimeMillis();
            this.zMB.zPT = false;
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.view.f.a aVar = this.zMB;
            if (aVar.zQb != null) {
                Iterator it2 = aVar.zQb.iterator();
                while (it2.hasNext()) {
                    if (((com.tencent.mm.view.c.a) it2.next()) != null) {
                        x.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", ((com.tencent.mm.view.c.a) it2.next()).lEs);
                    } else {
                        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                    }
                }
            }
            if (aVar.zQb != null) {
                aVar.zQb.clear();
            }
            if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBH() <= 2) {
                com.tencent.mm.bt.a.ceF();
                com.tencent.mm.bt.a.b bVar = com.tencent.mm.bt.a.xjH;
                if (!com.tencent.mm.bt.a.b.Dq(208912)) {
                    obj = null;
                    aBI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBI();
                    com.tencent.mm.bt.a.ceF();
                    i = ((h) g.Dn().CU()).DZ() ? com.tencent.mm.j.g.Af().getInt("EmotionRecommandCount", 3) : com.tencent.mm.bt.a.xjI.getInt("EmotionRecommandCount", 3);
                    x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", Integer.valueOf(i), Integer.valueOf(i - ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBJ()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBJ()));
                    arrayList = new ArrayList();
                    if (!this.zMB.zPQ) {
                        arrayList.add(com.tencent.mm.view.f.a.cBN());
                        a(com.tencent.mm.view.f.a.cBN(), true);
                    }
                    if (!this.zMB.zPP) {
                        if (obj != null) {
                            arrayList.add(com.tencent.mm.view.f.a.cBO());
                            a(com.tencent.mm.view.f.a.cBO(), true);
                        }
                        if (aBI != null) {
                            it = aBI.iterator();
                            i2 = 0;
                            while (it.hasNext()) {
                                emojiGroupInfo = (EmojiGroupInfo) it.next();
                                if (!(emojiGroupInfo == null || bi.oN(emojiGroupInfo.field_productID))) {
                                    if (emojiGroupInfo.field_recommand != 1) {
                                        if (i2 < r6 && i2 < i) {
                                            i2++;
                                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                                            arrayList.add(emojiGroupInfo);
                                        }
                                    } else if (!(emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.xIF)) || emojiGroupInfo.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB"))) {
                                        a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                                        arrayList.add(emojiGroupInfo);
                                    }
                                }
                            }
                        }
                        if (obj == null) {
                            arrayList.add(com.tencent.mm.view.f.a.cBO());
                            a(com.tencent.mm.view.f.a.cBO(), true);
                        }
                        if (!this.zMB.zPQ) {
                            emojiGroupInfo = new EmojiGroupInfo();
                            emojiGroupInfo.field_productID = "TAG_STORE_MANEGER_TAB";
                            arrayList.add(emojiGroupInfo);
                        }
                    }
                    eVar = this.zPm;
                    eVar.mData.clear();
                    eVar.mData.addAll(arrayList);
                    eVar.notifyDataSetChanged();
                    cBE();
                    this.zMB.cBS();
                    x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                    if (this.zPi == null) {
                        x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                    } else if (this.zPj != null) {
                        cBD();
                        this.zPj = new d(this.zMB, this.kgx);
                        this.zMB.cBR();
                        this.zPi.a(this.zPj);
                        this.zPi.xw(1);
                    } else {
                        this.zPj.zNC = true;
                        this.zPj.cBi();
                        this.zPj.notifyDataSetChanged();
                        this.zPj.zNC = false;
                    }
                    cBC();
                    this.zMB.zPT = true;
                    this.zMB.zPW = true;
                    if (!this.zMB.zPU) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(406, 6, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                    }
                }
            }
            obj = 1;
            aBI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBI();
            com.tencent.mm.bt.a.ceF();
            if (((h) g.Dn().CU()).DZ()) {
            }
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", Integer.valueOf(i), Integer.valueOf(i - ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBJ()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBJ()));
            arrayList = new ArrayList();
            if (this.zMB.zPQ) {
                arrayList.add(com.tencent.mm.view.f.a.cBN());
                a(com.tencent.mm.view.f.a.cBN(), true);
            }
            if (this.zMB.zPP) {
                if (obj != null) {
                    arrayList.add(com.tencent.mm.view.f.a.cBO());
                    a(com.tencent.mm.view.f.a.cBO(), true);
                }
                if (aBI != null) {
                    it = aBI.iterator();
                    i2 = 0;
                    while (it.hasNext()) {
                        emojiGroupInfo = (EmojiGroupInfo) it.next();
                        if (emojiGroupInfo.field_recommand != 1) {
                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                            arrayList.add(emojiGroupInfo);
                        } else {
                            i2++;
                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                            arrayList.add(emojiGroupInfo);
                        }
                    }
                }
                if (obj == null) {
                    arrayList.add(com.tencent.mm.view.f.a.cBO());
                    a(com.tencent.mm.view.f.a.cBO(), true);
                }
                if (this.zMB.zPQ) {
                    emojiGroupInfo = new EmojiGroupInfo();
                    emojiGroupInfo.field_productID = "TAG_STORE_MANEGER_TAB";
                    arrayList.add(emojiGroupInfo);
                }
            }
            eVar = this.zPm;
            eVar.mData.clear();
            eVar.mData.addAll(arrayList);
            eVar.notifyDataSetChanged();
            cBE();
            this.zMB.cBS();
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
            if (this.zPi == null) {
                x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
            } else if (this.zPj != null) {
                this.zPj.zNC = true;
                this.zPj.cBi();
                this.zPj.notifyDataSetChanged();
                this.zPj.zNC = false;
            } else {
                cBD();
                this.zPj = new d(this.zMB, this.kgx);
                this.zMB.cBR();
                this.zPi.a(this.zPj);
                this.zPi.xw(1);
            }
            cBC();
            this.zMB.zPT = true;
            this.zMB.zPW = true;
            if (this.zMB.zPU) {
                com.tencent.mm.plugin.report.service.g.pWK.a(406, 6, 1, false);
                com.tencent.mm.plugin.report.service.g.pWK.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
            }
        }
    }

    public final void cBC() {
        com.tencent.mm.view.c.a cBR = this.zMB.cBR();
        if (cBR == null) {
            this.zMB.abb("TAG_DEFAULT_TAB");
            cBR = this.zMB.cBR();
        }
        cBG();
        if (cBR != null && this.zPi != null) {
            int i = this.zMB.zPO;
            if (i < 0 || i > cBR.cBA() - 1) {
                i = cBR.cBA() - 1;
            }
            this.zPu = cBR.kgz + i;
            this.zPi.ah(this.zPu);
            if (!cBR.lEs.equals("TAG_STORE_TAB")) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
            }
            t(cBR.cBA(), i + 0, false);
        }
    }

    private void t(int i, int i2, boolean z) {
        if (i <= 1) {
            this.zPk.setVisibility(4);
            return;
        }
        this.zPk.setVisibility(0);
        SmileyPanelScrollView smileyPanelScrollView = this.zPk;
        x.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        smileyPanelScrollView.zMH = i;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > smileyPanelScrollView.zMH) {
            i2 = smileyPanelScrollView.zMH;
        }
        smileyPanelScrollView.zMI = i2;
        if (smileyPanelScrollView.zMV == -1 || z) {
            smileyPanelScrollView.zMV = smileyPanelScrollView.zMI;
        }
        if (smileyPanelScrollView.zMU == -1 || z) {
            smileyPanelScrollView.zMU = smileyPanelScrollView.zMI;
            smileyPanelScrollView.zMW = 0.0f;
        }
        smileyPanelScrollView.invalidate();
    }

    public final void cBD() {
        if (this.zPj != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.zPj.mCount = 0;
        }
    }

    private void a(EmojiGroupInfo emojiGroupInfo, boolean z) {
        int i = 0;
        com.tencent.mm.view.f.a aVar = this.zMB;
        if (aVar.zQb == null) {
            aVar.zQb = new ArrayList();
        }
        int size = aVar.zQb.size();
        com.tencent.mm.view.c.a aVar2 = size <= 0 ? null : (com.tencent.mm.view.c.a) aVar.zQb.get(size - 1);
        int a = bi.a((Integer) aVar.zQc.get(emojiGroupInfo.field_productID), 0);
        if (aVar2 != null) {
            i = aVar2.kgz + aVar2.cBA();
        }
        aVar.zQb.add(new com.tencent.mm.view.c.a(emojiGroupInfo, i, a, aVar, this, z));
    }

    public final void cBE() {
        if (this.zPo != null) {
            if (!com.tencent.mm.view.f.a.cBJ() || this.zMB.zPN.equalsIgnoreCase("TAG_STORE_TAB")) {
                this.zPp.setVisibility(8);
            } else {
                this.zPp.setVisibility(0);
            }
            this.zPo.setContentDescription(this.tI.getString(com.tencent.mm.plugin.m.a.h.lPA));
        }
    }

    private ImageButton cBF() {
        if (this.zPq == null) {
            this.zPq = new ImageButton(this.kgx, null, i.lPC);
            this.zPq.setMaxHeight(this.zMB.zPB);
            this.zPq.setMinimumHeight(this.zMB.zPB);
            this.zPq.setMaxWidth(this.zMB.lNH);
            this.zPq.setMinimumWidth(this.zMB.lNH);
            this.zPq.setScaleType(ScaleType.CENTER);
            this.zPq.setPadding(this.zMB.zPD, this.zMB.zPD, this.zMB.zPD, this.zMB.zPD);
            this.zPq.setClickable(false);
            this.zPq.setVisibility(8);
        }
        return this.zPq;
    }

    public final void onClick(View view) {
        if (view == this.zPo) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (com.tencent.mm.view.f.a.cBI()) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!bi.oN(this.zMB.vwC)) {
                intent.putExtra("to_talker_name", this.zMB.vwC);
            }
            com.tencent.mm.bl.d.b(this.tI, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            com.tencent.mm.plugin.report.service.g.pWK.h(11594, Integer.valueOf(2));
        } else if (view == this.zPs) {
            if (this.zPt != null && this.zPt.cBe() != null) {
                this.zPt.cBe().aYA();
            }
        } else if (view == this.zPr && this.zPt.cBf() != null) {
            this.zPt.cBf().aZL();
        }
    }

    public final View findViewById(int i) {
        return this.mView.findViewById(i);
    }

    public final void nQ(boolean z) {
        cBF().setVisibility(8);
        if (this.zPs != null && this.zPs.getVisibility() == 0) {
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.zPs.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(250);
                this.zPs.startAnimation(translateAnimation);
            }
            this.zPs.setVisibility(8);
        }
    }

    public final void HI(int i) {
        if (this.zPi != null) {
            int i2 = this.zPi.yF;
            int i3 = this.zMB.HQ(i2).kgz + i;
            if (i3 != i2) {
                Math.abs(i3 - i2);
                this.zPi.ah(i3);
            }
            this.zPu = i3;
        }
    }

    public final void af(int i) {
        if (this.zPk != null) {
            SmileyPanelScrollView smileyPanelScrollView = this.zPk;
            if (i == 0) {
                smileyPanelScrollView.zMV = smileyPanelScrollView.zMI;
                smileyPanelScrollView.zMU = smileyPanelScrollView.zMI;
                smileyPanelScrollView.zMW = 0.0f;
                smileyPanelScrollView.invalidate();
                if (smileyPanelScrollView.zMX) {
                    smileyPanelScrollView.zMX = false;
                }
            } else if (i == 1) {
                smileyPanelScrollView.zMV = smileyPanelScrollView.zMI;
                smileyPanelScrollView.zMU = smileyPanelScrollView.zMI;
                smileyPanelScrollView.zMW = 0.0f;
            }
        }
        if (i == 0 || i == 1) {
            this.zPu = this.zPi.yF;
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.zPk != null && f != 0.0f) {
            if (this.zPu == -1) {
                this.zPu = this.zPi.yF;
            }
            int i3 = this.zPu;
            if (i == this.zPu) {
                i3 = this.zPu + 1;
            }
            com.tencent.mm.view.c.a HQ = this.zMB.HQ(i3);
            com.tencent.mm.view.c.a HQ2 = this.zMB.HQ(i);
            if (HQ == HQ2) {
                SmileyPanelScrollView smileyPanelScrollView = this.zPk;
                int i4 = i - HQ2.kgz;
                smileyPanelScrollView.zMW = f;
                if (smileyPanelScrollView.zMV != i4) {
                    smileyPanelScrollView.zMV = i4;
                }
                smileyPanelScrollView.invalidate();
                this.zPv = true;
                return;
            }
            this.zPv = false;
        }
    }

    private void c(int i, boolean z, boolean z2) {
        int i2 = 1;
        if (this.zPl != null) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab index:%d selected:%b listView child count:%d", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.zPl.getChildCount()));
            this.zPl.setSelection(i);
            View selectedView = this.zPl.getSelectedView();
            if (selectedView != null) {
                selectedView.setSelected(z);
                return;
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "list item view is null. refreshable:%b", Boolean.valueOf(z2));
            if (z2) {
                Message message = new Message();
                message.what = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
                message.arg1 = i;
                if (!z) {
                    i2 = 0;
                }
                message.arg2 = i2;
                this.mHandler.sendMessageDelayed(message, 100);
            }
        }
    }

    public final void ae(int i) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", Integer.valueOf(i));
        if (this.zMB != null && this.zMB.zQe) {
            boolean z;
            com.tencent.mm.view.c.a HQ = this.zMB.HQ(i);
            if (HQ.lEs.equals("TAG_STORE_TAB")) {
                this.zPo.setSelected(true);
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", Integer.valueOf(this.zPo.getId()), "TAG_STORE_TAB");
                this.zMB.abb("TAG_STORE_TAB");
                com.tencent.mm.plugin.report.service.g.pWK.h(11594, Integer.valueOf(5));
                com.tencent.mm.r.c.Bx().aS(262147, 266244);
                com.tencent.mm.r.c.Bx().aS(262149, 266244);
                cBE();
            } else {
                this.zPo.setSelected(false);
            }
            int i2 = i - HQ.kgz;
            int cBA = HQ.cBA();
            int i3 = i - HQ.kgz;
            if (this.zPv) {
                z = false;
            } else {
                z = true;
            }
            t(cBA, i3, z);
            this.zMB.zPO = i2;
            this.zMB.abb(HQ.lEs);
            HQ.zPd = i2;
            com.tencent.mm.view.f.a aVar = this.zMB;
            aVar.zQc.put(HQ.lEs, Integer.valueOf(HQ.zPd));
            HO(this.zMB.HR(i));
            c(this.zMB.HR(i) - 1, false, true);
            c(this.zMB.HR(i) + 1, false, true);
            cBG();
        }
    }

    private void HO(int i) {
        int i2 = this.zMB.lNH;
        int width = this.zPl.getWidth();
        int firstVisiblePosition = this.zPl.getFirstVisiblePosition();
        if (i > this.zPl.getLastVisiblePosition()) {
            this.zPl.EL((i2 * (i + 1)) - width);
        } else if (i < firstVisiblePosition) {
            this.zPl.EL(i2 * i);
        }
        c(i, true, true);
    }

    public final void cBG() {
        if (this.zMB.zPN.equals("TAG_DEFAULT_TAB")) {
            if (!(this.zPt == null || this.zPt.cBe() == null)) {
                this.zPt.cBe().gA(true);
            }
            if (this.zMB.cBP()) {
                this.zMB.zPV = false;
                cBF().setVisibility(0);
                if (this.zPs != null && this.zPs.getVisibility() != 0) {
                    Animation translateAnimation = new TranslateAnimation((float) this.zPs.getWidth(), 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(250);
                    this.zPs.startAnimation(translateAnimation);
                    this.zPs.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (!(this.zPt == null || this.zPt.cBe() == null)) {
            this.zPt.cBe().gA(false);
        }
        nQ(true);
    }

    public final synchronized void HJ(int i) {
        com.tencent.mm.view.f.a aVar;
        if (this.zMB.cBT()) {
            if (!this.zMB.zPZ) {
                aVar = this.zMB;
                aVar.zPZ = true;
                aVar.zQa = false;
            }
        } else if (!this.zMB.zQa) {
            aVar = this.zMB;
            aVar.zQa = true;
            aVar.zPZ = false;
        }
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new Runnable() {
                public final void run() {
                    x.v("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onLayoutChange handle");
                    a.this.cBB();
                }
            });
        }
    }

    public final void Fh(int i) {
        if (i > 0) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            HO(this.zMB.cBQ());
        }
    }

    public final void cBH() {
        this.zPw = false;
        this.mHandler.removeMessages(TXLiveConstants.PUSH_WARNING_RECONNECT);
        this.mHandler.sendEmptyMessageDelayed(TXLiveConstants.PUSH_WARNING_RECONNECT, 100);
    }
}
