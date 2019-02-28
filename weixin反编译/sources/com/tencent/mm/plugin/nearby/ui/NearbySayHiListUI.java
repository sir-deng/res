package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.be.h;
import com.tencent.mm.be.i;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.j;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;

public class NearbySayHiListUI extends MMActivity implements e {
    private int asN = 0;
    private int gDq = 0;
    private ListView inF;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            l.TF().nc(String.valueOf(NearbySayHiListUI.this.oUQ));
            NearbySayHiListUI.this.oUM.a(null, null);
            if (NearbySayHiListUI.this.oUN > 0) {
                NearbySayHiListUI.this.oUN = NearbySayHiListUI.this.oUN - 1;
            }
            NearbySayHiListUI.j(NearbySayHiListUI.this);
        }
    };
    private c oTT;
    private i oUL = null;
    private a oUM;
    private int oUN = 0;
    private int oUO = 0;
    private boolean oUP;
    private long oUQ;
    private View onR;
    private r tipDialog = null;

    class a extends o<h> {
        int asN = -1;
        private MMActivity fnF;
        protected f kHo;
        protected MMSlideDelView.c kHp;
        protected MMSlideDelView.d kHr = MMSlideDelView.cql();
        private i oUL;
        protected MMSlideDelView.e oUV;

        class a {
            TextView hxK;
            ImageView ikl;
            View kHy;
            TextView kHz;
            TextView otc;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            h hVar = (h) obj;
            if (hVar == null) {
                hVar = new h();
            }
            hVar.b(cursor);
            return hVar;
        }

        public a(Context context, i iVar, int i) {
            super(context, new h());
            this.fnF = (MMActivity) context;
            this.asN = i;
            this.oUL = iVar;
        }

        public final void a(f fVar) {
            this.kHo = fVar;
        }

        public final void a(MMSlideDelView.e eVar) {
            this.oUV = eVar;
        }

        public final void a(MMSlideDelView.c cVar) {
            this.kHp = cVar;
        }

        protected final void XI() {
            XH();
        }

        public final void XH() {
            i iVar;
            if (com.tencent.mm.bj.a.bYH()) {
                iVar = this.oUL;
                int i = this.asN;
                setCursor(iVar.gLA.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + iVar.getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + iVar.getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null));
            } else {
                iVar = this.oUL;
                setCursor(iVar.gLA.rawQuery("SELECT * FROM " + iVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.asN, null));
            }
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            h hVar = (h) getItem(i);
            if (view == null) {
                a aVar2 = new a();
                View view2 = (MMSlideDelView) View.inflate(this.fnF, R.i.dbe, null);
                View inflate = View.inflate(this.fnF, R.i.drc, null);
                aVar2.ikl = (ImageView) inflate.findViewById(R.h.bYA);
                aVar2.hxK = (TextView) inflate.findViewById(R.h.cci);
                aVar2.otc = (TextView) inflate.findViewById(R.h.cIR);
                aVar2.kHy = view2.findViewById(R.h.cOJ);
                aVar2.kHz = (TextView) view2.findViewById(R.h.cOK);
                view2.setView(inflate);
                view2.kHo = this.kHo;
                view2.kHp = this.kHp;
                view2.kHr = this.kHr;
                view2.mGx = false;
                view2.setTag(aVar2);
                view = view2;
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (hVar.field_flag != 0) {
                charSequence = au.d.Yb(hVar.field_content).fqG;
            } else {
                charSequence = hVar.field_talker;
            }
            aVar.hxK.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fnF, charSequence, aVar.hxK.getTextSize()));
            aVar.otc.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fnF, hVar.field_sayhicontent, aVar.otc.getTextSize()));
            aVar.kHy.setTag(Long.valueOf(hVar.field_svrid));
            aVar.kHy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.v("MicroMsg.SayHiAdapter", "on delView clicked");
                    a.this.kHr.aVg();
                    if (a.this.oUV != null) {
                        a.this.oUV.bp(view.getTag());
                    }
                }
            });
            b.a(aVar.ikl, hVar.field_sayhiuser);
            return view;
        }
    }

    static /* synthetic */ void j(NearbySayHiListUI nearbySayHiListUI) {
        if (nearbySayHiListUI.oUN == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(R.h.ceo);
            textView.setText(R.l.eHz);
            textView.setVisibility(0);
            nearbySayHiListUI.enableOptionMenu(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        super.onCreate(bundle);
        this.gDq = bi.Wo(g.Af().getValue("ThresholdToCleanLocation"));
        this.oUP = getIntent().getBooleanExtra("show_clear_header", false);
        this.oUL = l.TF();
        setMMTitle(R.l.eHx);
        this.oUO = this.oUL.Tx();
        this.oUN = this.oUL.getCount();
        if (com.tencent.mm.bj.a.bYH()) {
            i = this.oUN;
            nearbySayHiListUI = this;
        } else if (this.oUO == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.oUO;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.asN = i;
        this.oUL.Tz();
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.oUN != this.oUL.getCount()) {
            this.oUN = this.oUL.getCount();
            if (this.oUN == 0) {
                TextView textView = (TextView) findViewById(R.h.ceo);
                textView.setText(R.l.eHz);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.oUM.XH();
        }
        this.oUM.notifyDataSetChanged();
        as.CN().a((int) JsApiScanCode.CTRL_INDEX, (e) this);
    }

    public void onDestroy() {
        this.oUM.aUU();
        super.onDestroy();
    }

    public void onPause() {
        as.CN().b((int) JsApiScanCode.CTRL_INDEX, (e) this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dmI;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        this.inF = (ListView) findViewById(R.h.cIP);
        if (!com.tencent.mm.bj.a.bYH()) {
            final View inflate = getLayoutInflater().inflate(R.i.drd, null);
            inflate.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    NearbySayHiListUI.this.asN = NearbySayHiListUI.this.asN + 8;
                    x.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.this.asN);
                    a b = NearbySayHiListUI.this.oUM;
                    int a = NearbySayHiListUI.this.asN;
                    b.aUU();
                    b.asN = a;
                    b.XH();
                    if (NearbySayHiListUI.this.oUN <= NearbySayHiListUI.this.asN) {
                        NearbySayHiListUI.this.inF.removeFooterView(inflate);
                        x.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.this.asN);
                    }
                }
            });
            if (this.oUN > 0 && this.asN < this.oUN) {
                this.inF.addFooterView(inflate);
            }
        }
        addTextOptionMenu(0, getString(R.l.dEz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.h.a(NearbySayHiListUI.this.mController.xRr, true, NearbySayHiListUI.this.getResources().getString(R.l.eHw), "", NearbySayHiListUI.this.getResources().getString(R.l.eHv), NearbySayHiListUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        NearbySayHiListUI.this.oUL.TA();
                        NearbySayHiListUI.this.oUM.XH();
                        TextView textView = (TextView) NearbySayHiListUI.this.findViewById(R.h.ceo);
                        textView.setText(R.l.eHz);
                        textView.setVisibility(0);
                        NearbySayHiListUI.this.enableOptionMenu(false);
                    }
                }, null);
                return true;
            }
        });
        if (this.oUN == 0) {
            TextView textView = (TextView) findViewById(R.h.ceo);
            textView.setText(R.l.eHz);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oUP && this.gDq != 0 && this.oUO >= this.gDq && bi.PZ()) {
            this.onR = new CleanLocationHeaderView(this);
            this.onR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    NearbySayHiListUI.this.oTT = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    as.CN().a(NearbySayHiListUI.this.oTT, 0);
                    NearbySayHiListUI nearbySayHiListUI = NearbySayHiListUI.this;
                    Context context = NearbySayHiListUI.this.mController.xRr;
                    NearbySayHiListUI.this.getString(R.l.dGZ);
                    nearbySayHiListUI.tipDialog = com.tencent.mm.ui.base.h.a(context, NearbySayHiListUI.this.getString(R.l.exp), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(NearbySayHiListUI.this.oTT);
                        }
                    });
                    com.tencent.mm.plugin.report.service.g.pWK.k(11429, "0");
                }
            });
            this.inF.addHeaderView(this.onR);
        }
        this.oUM = new a(this, this.oUL, this.asN);
        this.oUM.a(new MMSlideDelView.c() {
            public final int ci(View view) {
                return NearbySayHiListUI.this.inF.getPositionForView(view);
            }
        });
        this.oUM.a(new f() {
            public final void t(View view, int i) {
                NearbySayHiListUI.this.inF.performItemClick(view, i, 0);
            }
        });
        this.oUM.a(new MMSlideDelView.e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    return;
                }
                l.TF().nc(obj.toString());
                NearbySayHiListUI.this.oUM.a(null, null);
            }
        });
        this.inF.setAdapter(this.oUM);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.inF.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < NearbySayHiListUI.this.inF.getHeaderViewsCount()) {
                    x.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, NearbySayHiListUI.this, NearbySayHiListUI.this.kHD);
                }
                return true;
            }
        });
        this.inF.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (NearbySayHiListUI.this.inF.getHeaderViewsCount() > 0) {
                    i -= NearbySayHiListUI.this.inF.getHeaderViewsCount();
                }
                h hVar = (h) NearbySayHiListUI.this.oUM.getItem(i);
                if (hVar != null && hVar.field_content != null) {
                    au.d Yb = au.d.Yb(hVar.field_content);
                    Intent intent = new Intent();
                    if (com.tencent.mm.bj.a.bYH()) {
                        intent.putExtra("Chat_User", hVar.field_sayhiencryptuser);
                        intent.putExtra("lbs_mode", true);
                        intent.putExtra("add_scene", 18);
                        com.tencent.mm.plugin.nearby.a.ihN.e(intent, NearbySayHiListUI.this);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", bi.oN(Yb.sfb) ? hVar.field_sayhiuser : Yb.sfb);
                        intent2.putExtra("Contact_Alias", Yb.ggL);
                        intent2.putExtra("Contact_Nick", Yb.fqG);
                        intent2.putExtra("Contact_QuanPin", Yb.hyG);
                        intent2.putExtra("Contact_PyInitial", Yb.hyF);
                        intent2.putExtra("Contact_Sex", Yb.fXa);
                        intent2.putExtra("Contact_Signature", Yb.signature);
                        intent2.putExtra("Contact_Scene", Yb.scene);
                        intent2.putExtra("Contact_FMessageCard", true);
                        intent2.putExtra("Contact_City", Yb.getCity());
                        intent2.putExtra("Contact_Province", Yb.getProvince());
                        intent2.putExtra("Contact_Content", bi.oN(hVar.field_sayhicontent) ? NearbySayHiListUI.this.getString(R.l.dRq) : hVar.field_sayhicontent);
                        intent2.putExtra("Contact_verify_Scene", Yb.scene);
                        intent2.putExtra("Contact_Uin", Yb.ppA);
                        intent2.putExtra("Contact_QQNick", Yb.hyH);
                        intent2.putExtra("Contact_Mobile_MD5", Yb.xHI);
                        intent2.putExtra("User_From_Fmessage", true);
                        intent2.putExtra("Contact_from_msgType", 37);
                        intent2.putExtra("Verify_ticket", Yb.mTU);
                        intent2.putExtra("Contact_Source_FMessage", Yb.scene);
                        intent2.putExtra("Contact_ShowFMessageList", true);
                        as.Hm();
                        ag Xv = com.tencent.mm.y.c.Ff().Xv(Yb.sfb);
                        if (!(Xv == null || ((int) Xv.gKO) < 0 || com.tencent.mm.k.a.ga(Xv.field_type))) {
                            int i2 = Yb.fvG;
                            if (i2 == 0 || i2 == 2 || i2 == 5) {
                                intent2.putExtra("User_Verify", true);
                            }
                            intent2.putExtra("Contact_IsLBSFriend", true);
                            intent2.putExtra("Sns_from_Scene", 18);
                        }
                        com.tencent.mm.plugin.nearby.a.ihN.d(intent2, NearbySayHiListUI.this);
                    }
                    com.tencent.mm.sdk.b.b jVar = new j();
                    jVar.fnT.scene = Yb.scene;
                    com.tencent.mm.sdk.b.a.xmy.m(jVar);
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NearbySayHiListUI.this.aWY();
                NearbySayHiListUI.this.setResult(0);
                NearbySayHiListUI.this.finish();
                return true;
            }
        });
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(NearbySayHiListUI.this.inF);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        h hVar = (h) this.oUM.getItem(adapterContextMenuInfo.position);
        if (hVar == null) {
            x.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        contextMenu.add(0, 0, 0, R.l.dEH);
        this.oUQ = hVar.field_svrid;
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((c) kVar).IY() == 2) {
            com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.exo), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    NearbySayHiListUI.this.setResult(-1);
                    NearbySayHiListUI.this.finish();
                }
            });
            this.oTT = null;
        }
    }
}
