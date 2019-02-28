package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.y;
import com.tencent.mm.be.l;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public class AddressUI extends FragmentActivity {
    public u yEn;

    public static class a extends com.tencent.mm.ui.AbstractTabChildActivity.a implements e {
        private final long hUT = 180000;
        private ProgressDialog inI = null;
        private int kMb;
        private int kMc;
        private i kMf;
        List<String> koG = new LinkedList();
        d lfI = new d(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                x.i("MicroMsg.AddressUI", "[onScroll] firstVisibleItem:%s", Integer.valueOf(i));
                if (i >= 2 && !a.this.yZi) {
                    a.this.yZi = true;
                }
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                x.i("MicroMsg.AddressUI", "[onScrollStateChanged] scrollState:%s", Integer.valueOf(i));
                if (i == 2) {
                    com.tencent.mm.bz.d.cmf().dh(AddressUI.class.getName() + ".Listview", 4);
                }
            }
        });
        private p.d mbC = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        a.a(a.this, a.this.yZe);
                        return;
                    case 7:
                        a.c(a.this, a.this.yZe);
                        return;
                    default:
                        return;
                }
            }
        };
        private Animation mnN;
        private ListView nVe;
        private boolean odb = false;
        private TextView xWD;
        private String yYA;
        private String yYB;
        private TextView yYZ;
        private TextView yZa;
        private a yZb;
        private b yZc;
        private String yZd;
        private String yZe = "";
        private int yZf;
        private AlphabetScrollBar yZg;
        private LinearLayout yZh = null;
        private boolean yZi = false;
        private boolean yZj = false;
        private k yZk;
        private BizContactEntranceView yZl;
        private b yZm;
        private b yZn;
        private b yZo;
        private ContactCountView yZp;
        private u yZq;
        private i yZr;
        boolean yZs;
        private boolean yZt = true;
        private LinearLayout yZu;
        private Animation yZv;
        private com.tencent.mm.ui.base.VerticalScrollBar.a yZw = new com.tencent.mm.ui.base.VerticalScrollBar.a() {
            public final void xN(String str) {
                int i = 0;
                if (a.this.getString(R.l.eID).equals(str)) {
                    a.this.nVe.setSelection(0);
                    return;
                }
                a a = a.this.yZb;
                x.v("MicroMsg.AddressAdapter", "getSections");
                String[] strArr = a.yYG;
                if (strArr == null) {
                    return;
                }
                if ("↑".equals(str)) {
                    a.this.nVe.setSelection(0);
                } else if ("☆".equals(str)) {
                    a.this.nVe.setSelection(a.this.nVe.getHeaderViewsCount());
                } else {
                    while (i < strArr.length && strArr[i] != null) {
                        if (strArr[i].equals(str)) {
                            a.this.nVe.setSelection(a.this.yZb.getPositionForSection(i) + a.this.nVe.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        List<String> yZx = new LinkedList();
        private Runnable yZy = new Runnable() {
            public final void run() {
                a.p(a.this);
            }
        };

        static /* synthetic */ void a(a aVar, String str) {
            as.Hm();
            c.Ff().b(aVar.yZb);
            as.Hm();
            com.tencent.mm.storage.x Xv = c.Ff().Xv(str);
            Xv.Ao();
            s.t(Xv);
            if (s.eX(str)) {
                as.Hm();
                c.Ff().XB(str);
                as.Hm();
                c.Fo().hM(str);
            } else {
                as.Hm();
                c.Ff().a(str, Xv);
            }
            aVar.yZb.dt(str, 5);
            as.Hm();
            c.Ff().a(aVar.yZb);
        }

        static /* synthetic */ void b(a aVar) {
            aVar.yYZ.setVisibility(8);
            aVar.nVe.setVisibility(0);
        }

        static /* synthetic */ void c(a aVar, String str) {
            as.Hm();
            ag Xv = c.Ff().Xv(str);
            if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                Intent intent = new Intent();
                intent.setClass(aVar.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", Xv.field_username);
                intent.putExtra("view_mode", true);
                aVar.getContext().startActivity(intent);
            }
        }

        static /* synthetic */ void p(a aVar) {
            LauncherUI launcherUI = (LauncherUI) aVar.getContext();
            if (launcherUI == null || launcherUI.xPu.xOK.msV == 1) {
                BackwardSupportUtil.c.a(aVar.nVe);
                new com.tencent.mm.sdk.platformtools.ag().postDelayed(new Runnable() {
                    public final void run() {
                        a.this.nVe.setSelection(0);
                    }
                }, 300);
            }
        }

        protected int getLayoutId() {
            return R.i.dag;
        }

        protected View getLayoutView() {
            return com.tencent.mm.kiss.a.b.Ef().a(getContext(), "R.layout.address", R.i.dag);
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }

        public boolean noActionBar() {
            return true;
        }

        public final void nf(boolean z) {
            if (this.yZg != null) {
                if (this.mnN == null) {
                    this.mnN = AnimationUtils.loadAnimation(getContext(), R.a.bpX);
                    this.mnN.setDuration(200);
                }
                if (this.yZv == null) {
                    this.yZv = AnimationUtils.loadAnimation(getContext(), R.a.bpX);
                    this.yZv.setDuration(200);
                }
                if (z) {
                    if (this.yZg.getVisibility() != 0) {
                        this.yZg.setVisibility(0);
                        this.yZg.startAnimation(this.mnN);
                    }
                } else if (4 != this.yZg.getVisibility()) {
                    this.yZg.setVisibility(8);
                    this.yZg.startAnimation(this.yZv);
                }
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            as.Hm();
            ag Xv = c.Ff().Xv(this.yZe);
            if (Xv == null) {
                x.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.yZe);
            } else if (!q.FY().equals(Xv.field_username)) {
                if (s.gF(this.yZe)) {
                    contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), Xv.AX()));
                    contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.dDc);
                } else if (!s.gU(this.yZe) && !s.hj(this.yZe)) {
                    contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), Xv.AX()));
                    if (com.tencent.mm.k.a.ga(Xv.field_type) && Xv.field_deleteFlag != 1) {
                        contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.dVQ);
                    }
                }
            }
        }

        public final void a(int r3, int r4, java.lang.String r5, com.tencent.mm.ad.k r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.inI;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            r0 = r2.inI;
            r0.dismiss();
            r0 = 0;
            r2.inI = r0;
        L_0x000c:
            r0 = r2.getContext();
            r0 = com.tencent.mm.platformtools.t.bF(r0);
            if (r0 != 0) goto L_0x0017;
        L_0x0016:
            return;
        L_0x0017:
            r0 = r2.getContext();
            r1 = 4;
            r0 = com.tencent.mm.ui.t.a.a(r0, r3, r4, r5, r1);
            if (r0 != 0) goto L_0x0016;
        L_0x0022:
            if (r3 != 0) goto L_0x0016;
        L_0x0024:
            if (r4 == 0) goto L_0x0016;
        L_0x0026:
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.AddressUI.a.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
        }

        private void cwy() {
            this.koG = new LinkedList();
            this.yZx = new LinkedList();
            com.tencent.mm.bl.d.cdJ();
            this.koG.add("tmessage");
            this.yZx.addAll(this.koG);
            if (!this.koG.contains("officialaccounts")) {
                this.koG.add("officialaccounts");
            }
            this.koG.add("helper_entry");
            if (this.yZb != null) {
                this.yZb.dv(this.koG);
            }
            if (this.yZc != null) {
                this.yZc.dv(this.yZx);
            }
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            x.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                setResult(-1);
                finish();
            } else if (i2 == -1) {
                switch (i) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        return;
                    default:
                        return;
                }
            }
        }

        protected final void cmi() {
            x.v("MicroMsg.AddressUI", "address ui on create");
            x.v("MicroMsg.AddressUI", "on address ui create");
            this.yZi = false;
            this.odb = false;
            this.yZj = false;
            this.yYA = null;
            this.yYB = null;
            this.yZd = null;
            as.CN().a(138, (e) this);
            this.yYA = "@all.contact.without.chatroom";
            this.yYB = getStringExtra("Contact_GroupFilter_Str");
            this.yZd = getString(R.l.enV);
            this.yZf = getIntExtra("List_Type", 2);
            x.v("MicroMsg.AddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            if (this.nVe != null) {
                if (this.yZk != null) {
                    this.nVe.removeHeaderView(this.yZk);
                }
                if (this.yZl != null) {
                    this.nVe.removeHeaderView(this.yZl);
                }
                if (this.yZm != null) {
                    this.nVe.removeHeaderView(this.yZm);
                }
                if (this.yZo != null) {
                    this.nVe.removeHeaderView(this.yZo);
                }
            }
            this.nVe = (ListView) findViewById(R.h.bJf);
            this.nVe.setScrollingCacheEnabled(false);
            this.yYZ = (TextView) findViewById(R.h.ceg);
            this.yYZ.setText(R.l.dDd);
            this.xWD = (TextView) findViewById(R.h.cez);
            this.xWD.setText(R.l.dDf);
            this.yZa = (TextView) findViewById(R.h.ceC);
            this.yZa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            this.yZb = new a(getContext(), this.yYA, this.yYB, this.yZf, true);
            this.nVe.setAdapter(null);
            this.yZb.a(new com.tencent.mm.ui.f.a() {
                public final void XE() {
                    a aVar = a.this;
                    a.this.yZb.getCount();
                    a.b(aVar);
                    a.this.yZb.cwv();
                }

                public final void XF() {
                }
            });
            this.yZb.yYN = true;
            this.yZb.l(this);
            this.yZb.a(new MMSlideDelView.c() {
                public final int ci(View view) {
                    return a.this.nVe.getPositionForView(view);
                }
            });
            this.yZb.a(new f() {
                public final void t(View view, int i) {
                    a.this.nVe.performItemClick(view, i, 0);
                }
            });
            this.yZb.a(new MMSlideDelView.e() {
                public final void bp(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.AddressUI", "onItemDel object null");
                    } else {
                        a.a(a.this, obj.toString());
                    }
                }
            });
            this.yZc = new b(getContext(), 1);
            this.yZc.nH(true);
            this.yZu = new LinearLayout(getContext());
            this.yZu.setOrientation(1);
            this.nVe.addHeaderView(this.yZu);
            this.yZn = new b(getContext(), com.tencent.mm.ui.contact.b.a.ContactIpCall);
            this.yZu.addView(this.yZn);
            as.Hm();
            ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
            this.yZn.setVisible(false);
            this.yZk = new k(getContext());
            this.yZu.addView(this.yZk);
            this.yZm = new b(getContext(), com.tencent.mm.ui.contact.b.a.Chatromm);
            this.yZu.addView(this.yZm);
            this.yZm.setVisible(true);
            this.yZo = new b(getContext(), com.tencent.mm.ui.contact.b.a.ContactLabel);
            this.yZu.addView(this.yZo);
            this.yZo.setVisible(true);
            ListView listView = this.nVe;
            View contactCountView = new ContactCountView(getContext());
            this.yZp = contactCountView;
            listView.addFooterView(contactCountView, null, false);
            if (com.tencent.mm.bl.d.Pu("brandservice")) {
                this.yZl = new BizContactEntranceView(getContext());
                this.yZu.addView(this.yZl);
                this.yZl.setVisible(true);
            }
            u.b anonymousClass20 = new u.b() {
                public final void ng(boolean z) {
                    if (a.this.yZl != null) {
                        BizContactEntranceView d = a.this.yZl;
                        if (d.zab == null) {
                            return;
                        }
                        if (z) {
                            d.zab.setBackgroundResource(R.g.bDq);
                        } else {
                            d.zab.setBackground(null);
                        }
                    }
                }
            };
            this.yZq = new u(getContext(), new com.tencent.mm.ui.contact.u.a() {
            });
            this.yZq.zcX = anonymousClass20;
            if (this.yZq.cxb() <= 0) {
                anonymousClass20.ng(false);
                this.yZq.setVisibility(8);
            } else {
                anonymousClass20.ng(true);
            }
            this.yZu.addView(this.yZq);
            if (com.tencent.mm.bl.d.Pu("brandservice")) {
                this.yZr = new i(getContext(), new com.tencent.mm.ui.contact.i.a() {
                    public final void GE(int i) {
                        if (a.this.yZr != null) {
                            if (i <= 0) {
                                a.this.yZr.setVisibility(8);
                            } else {
                                a.this.yZr.setVisibility(0);
                            }
                        }
                    }
                });
                if (this.yZr.cwJ() <= 0) {
                    this.yZr.setVisibility(8);
                }
                this.yZu.addView(this.yZr);
            }
            this.kMf = new i(getContext());
            this.yZb.yYL = new com.tencent.mm.ui.contact.a.a() {
            };
            this.nVe.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    x.i("MicroMsg.AddressUI", "onItemClick " + i + (a.this.yZc == null ? a.this.yZc : Boolean.valueOf(a.this.yZc.zzG)));
                    if ((i != 0 || "@biz.contact".equals(a.this.yYA)) && i >= a.this.nVe.getHeaderViewsCount()) {
                        int headerViewsCount = i - a.this.nVe.getHeaderViewsCount();
                        String str;
                        if (a.this.yZc == null || !a.this.yZc.zzG) {
                            com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) a.this.yZb.DV(headerViewsCount);
                            if (fVar != null) {
                                str = fVar.field_username;
                                a aVar = a.this;
                                if (str != null && str.length() > 0) {
                                    if (s.hg(str)) {
                                        x.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", str);
                                        return;
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", str);
                                    if (s.gF(str)) {
                                        intent.putExtra("Is_group_card", true);
                                    }
                                    if (str != null && str.length() > 0) {
                                        e.a(intent, str);
                                        com.tencent.mm.bl.d.b(aVar.getContext(), "profile", ".ui.ContactInfoUI", intent);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        boolean rq = a.this.yZc.rq(headerViewsCount);
                        boolean Hj = a.this.yZc.Hj(headerViewsCount);
                        x.i("MicroMsg.AddressUI", "onItemClick " + Hj);
                        Intent intent2;
                        if (Hj) {
                            a.this.yZc.aaQ("");
                        } else if (rq) {
                            bfp Hi = a.this.yZc.Hi(headerViewsCount);
                            String str2 = Hi.wfM.wRo;
                            as.Hm();
                            ag Xv = c.Ff().Xv(str2);
                            if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                                intent2 = new Intent();
                                intent2.putExtra("Contact_User", str2);
                                intent2.putExtra("Contact_Scene", 3);
                                if (str2 != null && str2.length() > 0) {
                                    if (Xv.ciN()) {
                                        g.pWK.k(10298, str2 + ",3");
                                    }
                                    e.a(intent2, str2);
                                    com.tencent.mm.bl.d.b(a.this.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                                    return;
                                }
                                return;
                            }
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", Hi.wfM.wRo);
                            intent3.putExtra("Contact_Alias", Hi.hxj);
                            intent3.putExtra("Contact_Nick", Hi.wzM.wRo);
                            intent3.putExtra("Contact_Signature", Hi.hxh);
                            intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(Hi.hxn, Hi.hxf, Hi.hxg));
                            intent3.putExtra("Contact_Sex", Hi.hxe);
                            intent3.putExtra("Contact_VUser_Info", Hi.wCr);
                            intent3.putExtra("Contact_VUser_Info_Flag", Hi.wCq);
                            intent3.putExtra("Contact_KWeibo_flag", Hi.wCu);
                            intent3.putExtra("Contact_KWeibo", Hi.wCs);
                            intent3.putExtra("Contact_KWeiboNick", Hi.wCt);
                            intent3.putExtra("Contact_KSnsIFlag", Hi.wCw.hxp);
                            intent3.putExtra("Contact_KSnsBgId", Hi.wCw.hxr);
                            intent3.putExtra("Contact_KSnsBgUrl", Hi.wCw.hxq);
                            if (Hi.wCx != null) {
                                try {
                                    intent3.putExtra("Contact_customInfo", Hi.wCx.toByteArray());
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.AddressUI", e, "", new Object[0]);
                                }
                            }
                            if ((Hi.wCq & 8) > 0) {
                                g.pWK.k(10298, str2 + ",3");
                            }
                            com.tencent.mm.bl.d.b(a.this.getContext(), "profile", ".ui.ContactInfoUI", intent3);
                        } else {
                            ag oz = a.this.yZc.oz(headerViewsCount);
                            if (oz == null) {
                                x.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(a.this.yZc.getCount()), Integer.valueOf(headerViewsCount));
                                return;
                            }
                            str = oz.field_username;
                            if (s.hg(str)) {
                                Intent intent4 = new Intent(a.this.getContext(), AddressUI.class);
                                intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                                a.this.startActivity(intent4);
                                return;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", str);
                            intent2.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                com.tencent.mm.bl.d.b(a.this.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                            }
                        }
                    }
                }
            });
            this.nVe.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    x.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                    if (i < a.this.nVe.getHeaderViewsCount()) {
                        x.w("MicroMsg.AddressUI", "on item long click, but match header view");
                        return true;
                    } else if (a.this.yZc != null && a.this.yZc.zzG) {
                        return true;
                    } else {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) a.this.yZb.DV(i - a.this.nVe.getHeaderViewsCount());
                        if (fVar == null) {
                            x.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(a.this.nVe.getHeaderViewsCount()));
                            return true;
                        }
                        String str = fVar.field_username;
                        if (s.hg(str) || s.hh(str)) {
                            return true;
                        }
                        a.this.yZe = str;
                        a.this.kMf.a(view, i, j, a.this, a.this.mbC, a.this.kMb, a.this.kMc);
                        return true;
                    }
                }
            });
            this.nVe.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            a.this.hideVKB();
                            a.this.kMb = (int) motionEvent.getRawX();
                            a.this.kMc = (int) motionEvent.getRawY();
                            break;
                    }
                    return false;
                }
            });
            this.nVe.setOnScrollListener(this.lfI);
            this.nVe.setDrawingCacheEnabled(false);
            this.yZg = (AlphabetScrollBar) findViewById(R.h.bJo);
            this.yZg.yqj = this.yZw;
            as.Hm();
            c.Ff().a(this.yZb);
            if (this.yZr != null) {
                y.Ml().a(this.yZr, null);
            }
        }

        protected final void cmj() {
            x.v("MicroMsg.AddressUI", "address ui on resume");
            long currentTimeMillis = System.currentTimeMillis();
            as.Hm();
            if (currentTimeMillis - t.d((Long) c.Db().get(340226, null)) >= 180000) {
                cwA();
            }
            if (this.yZt) {
                this.yZt = false;
                this.yZs = false;
                cwy();
                this.nVe.setAdapter(this.yZb);
                this.nVe.post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.AddressUI", "post to first init finish");
                        View findViewById = a.this.findViewById(R.h.ctH);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                            findViewById.startAnimation(AnimationUtils.loadAnimation(a.this.getContext(), R.a.bqa));
                        }
                    }
                });
                this.yZc.nG(false);
            } else if (this.yZs) {
                this.yZs = false;
                com.tencent.mm.sdk.f.e.b(new Runnable() {
                    public final void run() {
                        Process.setThreadPriority(10);
                        a.this.cwz();
                    }
                }, "AddressUI_updateUIData", 4);
                this.yZp.cwC();
            }
            if (this.yZl != null) {
                BizContactEntranceView bizContactEntranceView = this.yZl;
                bizContactEntranceView.cwB();
                bizContactEntranceView.setVisible(true);
            }
            if (this.yZr != null) {
                if (this.yZr.cwJ() <= 0) {
                    this.yZr.setVisibility(8);
                } else {
                    this.yZr.setVisibility(0);
                }
            }
            as.Hm();
            this.yZi = ((Boolean) c.Db().get(12296, Boolean.valueOf(false))).booleanValue();
            if (this.yZf == 2) {
                as.Hm();
                ag Xv = c.Ff().Xv(q.FY());
                if (!(Xv == null || (com.tencent.mm.k.a.ga(Xv.field_type) && t.oN(Xv.field_conRemark) && t.oN(Xv.field_conRemarkPYFull) && t.oN(Xv.field_conRemarkPYShort)))) {
                    Xv.An();
                    Xv.da("");
                    Xv.dg("");
                    Xv.dh("");
                    as.Hm();
                    c.Ff().a(q.FY(), Xv);
                }
            }
            if (this.yZc != null) {
                this.yZc.onResume();
            }
            this.yZb.xNa = false;
            ah.y(new Runnable() {
                public final void run() {
                    a.this.yZb.resume();
                }
            });
            if (this.yZk != null) {
                this.yZk.zbv = true;
                k.cwL();
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.xPu.setTitleBarDoubleClickListener(this.yZy);
            }
        }

        private synchronized void cwz() {
            long currentTimeMillis = System.currentTimeMillis();
            cwy();
            x.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.yZb != null) {
                x.v("MicroMsg.AddressUI", "post to do refresh");
                ah.y(new Runnable() {
                    public final void run() {
                        a.this.yZb.cwx();
                        if (a.this.yZq != null) {
                            a.this.yZq.reset();
                            if (a.this.yZq.cxb() <= 0) {
                                a.this.yZq.setVisibility(8);
                            } else {
                                a.this.yZq.setVisibility(0);
                            }
                        }
                    }
                });
            }
            if (this.yZc != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        x.v("MicroMsg.AddressUI", "post search adapter to do refresh");
                        a.this.yZc.a(null, null);
                    }
                });
            }
            x.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
        }

        protected final void cmk() {
        }

        protected final void cml() {
            x.i("MicroMsg.AddressUI", "AddressUI on Pause");
            as.Hm();
            c.Db().set(340226, Long.valueOf(System.currentTimeMillis()));
            as.Hm();
            c.Db().set(12296, Boolean.valueOf(this.yZi));
            if (this.yZc != null) {
                this.yZc.onPause();
            }
            this.yZb.cww();
            ah.y(new Runnable() {
                public final void run() {
                    a.this.yZb.pause();
                }
            });
            if (this.yZk != null) {
                this.yZk.zbv = false;
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.xPu.aa(this.yZy);
            }
        }

        protected final void cmm() {
        }

        protected final void cmn() {
            x.v("MicroMsg.AddressUI", "onDestory");
            if (this.yZg != null) {
                this.yZg.yqj = null;
            }
            as.CN().b(138, (e) this);
            if (this.yZb != null) {
                this.yZb.lW(true);
                this.yZb.detach();
                this.yZb.cmJ();
            }
            if (this.yZc != null) {
                this.yZc.detach();
                this.yZc.aUU();
            }
            if (as.Hp() && this.yZb != null) {
                as.Hm();
                c.Ff().b(this.yZb);
            }
            if (as.Hp() && this.yZr != null) {
                y.Ml().a(this.yZr);
            }
            if (this.yZk != null) {
                k kVar = this.yZk;
                if (as.Hp()) {
                    l.TE().j(kVar.zbu);
                }
                this.yZk = null;
            }
            if (this.yZl != null) {
                this.yZl = null;
            }
            if (this.yZm != null) {
                this.yZm = null;
            }
            if (this.yZo != null) {
                this.yZo = null;
            }
        }

        public final void cmp() {
            if (this.yZb != null) {
                a aVar = this.yZb;
                aVar.yYR.clear();
                aVar.yYP.clear();
                aVar.yYQ = false;
            }
            x.i("MicroMsg.INIT", "KEVIN Address turnTobg");
            if (this.yZl != null) {
                this.yZl.destroyDrawingCache();
            }
            if (this.yZm != null) {
                this.yZm.destroyDrawingCache();
            }
            if (this.yZo != null) {
                this.yZo.destroyDrawingCache();
            }
            if (this.yZp != null) {
                this.yZp.destroyDrawingCache();
            }
            if (this.yZk != null) {
                this.yZk.destroyDrawingCache();
            }
        }

        public final void cmq() {
            x.v("MicroMsg.INIT", "KEVIN Address turnTofg");
        }

        public final void cmo() {
            x.v("MicroMsg.AddressUI", "request to top");
            if (this.nVe != null) {
                BackwardSupportUtil.c.a(this.nVe);
            }
        }

        public final void cng() {
            if (this.yZk != null) {
                k.cwL();
            }
        }

        public final void cnh() {
        }

        public final void cwA() {
            if (this.nVe != null) {
                this.nVe.setSelection(0);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.N(16908290) == null) {
            this.yEn = new a();
            this.yEn.setArguments(getIntent().getExtras());
            supportFragmentManager.aT().a(16908290, this.yEn).commit();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }
}
