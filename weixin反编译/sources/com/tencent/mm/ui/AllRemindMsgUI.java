package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.protocal.c.bip;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllRemindMsgUI extends MMActivity implements e {
    private static final f<Integer, com.tencent.mm.protocal.b.a.c> hfz = new f(32);
    private RecyclerView Va;
    private LinkedList<d> kVJ;
    private ProgressBar lvk;
    private View xMg;
    private b xMh;
    private a xMi = new a();

    class b extends android.support.v7.widget.RecyclerView.a {
        b() {
        }

        public final t a(ViewGroup viewGroup, int i) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dqV, viewGroup, false));
        }

        public final void a(t tVar, int i) {
            d dVar = (d) AllRemindMsgUI.this.kVJ.get(i);
            ((c) tVar).VU.setTag(dVar);
            ((c) tVar).qsj.setText(i.b(AllRemindMsgUI.this.mController.xRr, dVar.fqG, ((c) tVar).qsj.getTextSize()));
            ((c) tVar).ikn.setText(i.b(AllRemindMsgUI.this.mController.xRr, dVar.title, ((c) tVar).ikn.getTextSize()));
            long currentTimeMillis = System.currentTimeMillis();
            if (dVar.timestamp - currentTimeMillis < 60000) {
                ((c) tVar).tLu.setText(AllRemindMsgUI.this.mController.xRr.getString(R.l.eiU, new Object[]{Integer.valueOf(1)}));
            } else if (dVar.timestamp - currentTimeMillis < 3600000) {
                ((c) tVar).tLu.setText(AllRemindMsgUI.this.mController.xRr.getString(R.l.eiU, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 60000)}));
            } else if (dVar.timestamp - currentTimeMillis < 10800000) {
                ((c) tVar).tLu.setText(AllRemindMsgUI.this.mController.xRr.getString(R.l.eiT, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 3600000), Long.valueOf(((dVar.timestamp - currentTimeMillis) - (((dVar.timestamp - currentTimeMillis) / 3600000) * 3600000)) / 60000)}));
            } else {
                ((c) tVar).tLu.setText(n.c(AllRemindMsgUI.this.mController.xRr, dVar.timestamp, true));
            }
            if (dVar.fqh == 2) {
                ((c) tVar).hxJ.setImageDrawable(AllRemindMsgUI.this.mController.xRr.getResources().getDrawable(R.g.byV));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(((c) tVar).hxJ, dVar.username);
            }
        }

        public final int getItemCount() {
            return AllRemindMsgUI.this.kVJ == null ? 0 : AllRemindMsgUI.this.kVJ.size();
        }
    }

    class c extends t {
        View VU;
        ImageView hxJ;
        TextView ikn;
        TextView qsj;
        TextView tLu;

        static /* synthetic */ void a(Context context, String str, long j) {
            if (str == null) {
                x.e("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] username is null");
                return;
            }
            as.Hm();
            x.i("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(com.tencent.mm.y.c.Fh().G(str, j).field_msgId));
            if (str.contains("@")) {
                as.Hm();
                if (com.tencent.mm.y.c.Fo().hG(str) == null) {
                    x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                    h.a(context, context.getString(R.l.eEI), context.getString(R.l.cSb), null);
                    return;
                }
            }
            as.Hm();
            ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
            if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                if (Xv == null) {
                    x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                } else {
                    x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                }
                h.a(context, context.getString(R.l.eEI), context.getString(R.l.cSb), null);
                return;
            }
            com.tencent.mm.plugin.chatroom.a.ihN.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), context);
        }

        public c(View view) {
            super(view);
            this.VU = view;
            this.ikn = (TextView) view.findViewById(R.h.title);
            this.tLu = (TextView) view.findViewById(R.h.cRQ);
            this.qsj = (TextView) view.findViewById(R.h.cAq);
            this.hxJ = (ImageView) view.findViewById(R.h.bLD);
            this.VU.setOnClickListener(new OnClickListener(AllRemindMsgUI.this) {
                public final void onClick(View view) {
                    d dVar = (d) view.getTag();
                    x.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", dVar);
                    c.a(AllRemindMsgUI.this, dVar.username, dVar.frh);
                }
            });
            this.VU.setOnTouchListener(new OnTouchListener(AllRemindMsgUI.this) {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    view.setTag(R.h.cSM, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    return false;
                }
            });
            this.VU.setOnLongClickListener(new OnLongClickListener(AllRemindMsgUI.this) {
                public final boolean onLongClick(final View view) {
                    com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(AllRemindMsgUI.this.mController.xRr);
                    int[] iArr = new int[2];
                    if (view.getTag(R.h.cSM) instanceof int[]) {
                        iArr = (int[]) view.getTag(R.h.cSM);
                    }
                    iVar.a(view, new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 0, 0, AllRemindMsgUI.this.mController.xRr.getString(R.l.dRS));
                        }
                    }, new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            x.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", (d) view.getTag());
                            as.CN().a(new ah(2, r0.xMp), 0);
                        }
                    }, iArr[0], iArr[1]);
                    return true;
                }
            });
        }
    }

    class a implements e, Runnable {
        a() {
        }

        public final void run() {
            as.CN().a(new s(), 0);
        }

        public final void a(int i, int i2, String str, final k kVar) {
            x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AllRemindMsgUI.this.Va.setVisibility(0);
                AllRemindMsgUI.this.lvk.setVisibility(8);
            } else if (kVar.getType() == 866) {
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        List<bdd> list = ((afx) ((s) kVar).hGV.hnR.hnY).wuF;
                        LinkedList linkedList = new LinkedList();
                        if (list != null) {
                            for (bdd bdd : list) {
                                d dVar = new d();
                                dVar.xMp = bdd;
                                dVar.timestamp = ((long) bdd.lUo) * 1000;
                                dVar.fqh = bdd.wMK;
                                dVar.xMq = bdd.wPP;
                                if (bdd.wMK == 1) {
                                    ate ate = new ate();
                                    try {
                                        ate.aH(bdd.wfV.oz);
                                    } catch (IOException e) {
                                        x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e.toString());
                                    }
                                    dVar.title = ate.fpg;
                                    dVar.username = ate.kyG;
                                    dVar.frh = ate.vNT;
                                    if (dVar.username != null) {
                                        com.tencent.mm.storage.x Xv;
                                        if (com.tencent.mm.y.s.eX(dVar.username)) {
                                            String string;
                                            as.Hm();
                                            Xv = com.tencent.mm.y.c.Ff().Xv(dVar.username);
                                            if (Xv != null) {
                                                dVar.fqG = Xv.AX() == null ? Xv.AW() : Xv.AX();
                                            }
                                            if (bi.oN(dVar.fqG)) {
                                                string = AllRemindMsgUI.this.getString(R.l.dSY);
                                            } else {
                                                string = dVar.fqG;
                                            }
                                            dVar.fqG = string;
                                        } else {
                                            as.Hm();
                                            Xv = com.tencent.mm.y.c.Ff().Xv(dVar.username);
                                            dVar.fqG = Xv.AX() == null ? Xv.AW() : Xv.AX();
                                        }
                                    }
                                } else if (bdd.wMK == 2) {
                                    vo voVar = new vo();
                                    try {
                                        voVar.aH(bdd.wfV.oz);
                                    } catch (IOException e2) {
                                        x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e2.toString());
                                    }
                                    dVar.title = voVar.fpg;
                                    dVar.fqY = voVar.vNG;
                                    dVar.wlv = voVar.vNH;
                                }
                                x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", dVar);
                                linkedList.add(dVar);
                            }
                            AllRemindMsgUI.this.kVJ = linkedList;
                        }
                        com.tencent.mm.sdk.platformtools.ah.y(new Runnable() {
                            public final void run() {
                                AllRemindMsgUI.this.Va.setVisibility(0);
                                AllRemindMsgUI.this.lvk.setVisibility(8);
                                AllRemindMsgUI.this.xMh.UR.notifyChanged();
                            }
                        });
                    }
                }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
            }
        }
    }

    class d {
        String fqG;
        int fqY;
        int fqh;
        long frh;
        long timestamp;
        String title;
        String username;
        String wlv;
        bdd xMp;
        String xMq;

        d() {
        }

        public final String toString() {
            return "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.fqG + '\'' + ", title='" + bi.Wz(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.fqh + ", msgId=" + this.frh + ", sourceType=" + this.fqY + ", sourceId='" + this.wlv + '\'' + '}';
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(866, this.xMi);
        as.CN().a(525, (e) this);
        g.pWK.a(795, 3, 1, false);
        initView();
        com.tencent.mm.sdk.f.e.post(new a(), "load remind data!");
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(866, this.xMi);
        as.CN().b(525, (e) this);
    }

    protected final void initView() {
        setMMTitle(R.l.eEL);
        this.Va = (RecyclerView) findViewById(R.h.bKb);
        this.lvk = (ProgressBar) findViewById(R.h.cEf);
        this.xMg = findViewById(R.h.coD);
        this.Va.setVisibility(8);
        RecyclerView recyclerView = this.Va;
        ActionBarActivity actionBarActivity = this.mController.xRr;
        recyclerView.a(new LinearLayoutManager());
        this.xMh = new b();
        this.Va.a(this.xMh);
        this.xMh.a(new android.support.v7.widget.RecyclerView.c() {
            public final void onChanged() {
                super.onChanged();
                x.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", Integer.valueOf(AllRemindMsgUI.this.xMh.getItemCount()));
                if (AllRemindMsgUI.this.xMh.getItemCount() == 0) {
                    AllRemindMsgUI.this.xMg.setVisibility(0);
                    AllRemindMsgUI.this.Va.setVisibility(8);
                    return;
                }
                AllRemindMsgUI.this.xMg.setVisibility(8);
                AllRemindMsgUI.this.Va.setVisibility(0);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AllRemindMsgUI.this.onBackPressed();
                return true;
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dal;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            Toast.makeText(this.mController.xRr, bi.aD(str, getString(R.l.ezH)), 0).show();
        } else if (kVar.getType() == 525) {
            bip bip = (bip) ((ah) kVar).hGV.hnQ.hnY;
            Iterator listIterator = this.kVJ.listIterator();
            while (listIterator.hasNext()) {
                if (((d) listIterator.next()).xMq == bip.wST.wPP) {
                    listIterator.remove();
                }
            }
            this.xMh.UR.notifyChanged();
        }
    }

    public static String a(Context context, int i, String str, int i2) {
        String str2 = "";
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
        switch (i) {
            case -1879048186:
                return context.getString(R.l.eCU, new Object[]{""});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(R.l.eCK, new Object[]{""});
            case 1:
                return context.getString(R.l.dEc);
            case 3:
            case 23:
            case 33:
                return context.getString(R.l.dGu);
            case 34:
                com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(str);
                return context.getString(R.l.eCX, new Object[]{Integer.valueOf((int) q.bw(nVar.time))});
            case 37:
                if (str == null || str.length() <= 0) {
                    return str2;
                }
                com.tencent.mm.storage.au.d Yb = com.tencent.mm.storage.au.d.Yb(str);
                if (Yb.sfb == null || Yb.sfb.length() <= 0) {
                    return str2;
                }
                switch (Yb.scene) {
                    case 18:
                        return context.getString(R.l.ejq, new Object[]{Yb.getDisplayName()});
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        return context.getString(R.l.ejA, new Object[]{Yb.getDisplayName()});
                    case 25:
                        return context.getString(R.l.eiC, new Object[]{Yb.getDisplayName()});
                    default:
                        return context.getString(R.l.ejG, new Object[]{Yb.getDisplayName()});
                }
            case org.xwalk.core.R.styleable.AppCompatTheme_dialogTheme /*42*/:
            case 66:
                return context.getString(R.l.dFy);
            case org.xwalk.core.R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case 62:
                return context.getString(62 == i ? R.l.dGS : R.l.dHi);
            case 47:
                return context.getString(R.l.dER);
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                as.Hm();
                com.tencent.mm.y.c.Fh().Fr(str);
                return context.getString(R.l.eCP, new Object[]{""});
            case org.xwalk.core.R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                if (fV != null) {
                    switch (fV.type) {
                        case 2:
                            return context.getString(R.l.dGu);
                        case 3:
                            return context.getString(R.l.eCQ, new Object[]{""});
                        case 4:
                            return context.getString(R.l.eCW, new Object[]{""});
                        case 5:
                        case 7:
                            return context.getString(R.l.eCV, new Object[]{""});
                        case 6:
                            return context.getString(R.l.eCO, new Object[]{fV.title});
                        case 8:
                            return context.getString(R.l.dES);
                        case 15:
                        case 26:
                        case 27:
                            return context.getString(R.l.dER);
                        case 17:
                            return context.getString(R.l.eCP, new Object[]{""});
                        case 19:
                            return context.getString(R.l.eCS, new Object[]{""});
                        case 24:
                            return context.getString(R.l.eCR, new Object[]{""});
                        case 25:
                            return context.getString(R.l.dEJ);
                        case 33:
                            return context.getString(R.l.dEc);
                        default:
                            x.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", Integer.valueOf(fV.type));
                            break;
                    }
                }
                x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                return "";
            case 369098801:
            case 452984881:
                return context.getString(R.l.eCM, new Object[]{""});
            case 419430449:
                return context.getString(R.l.eCT);
            case 436207665:
            case 469762097:
                if (fV == null) {
                    x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.eCL, new Object[]{fV.hep, ""});
                } else {
                    return context.getString(R.l.eCL, new Object[]{fV.hep, ""});
                }
            case 503316529:
                if (fV == null) {
                    x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    return "";
                }
                return context.getString(R.l.eCL, new Object[]{fV.hep, ""});
            case 520093745:
                return context.getString(R.l.eCM, new Object[]{""});
        }
        return context.getString(R.l.eyr);
    }
}
