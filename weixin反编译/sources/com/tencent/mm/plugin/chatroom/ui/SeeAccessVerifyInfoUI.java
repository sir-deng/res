package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI extends MMActivity {
    private long hBu;
    private q lfE;
    private GridView liA;
    private com.tencent.mm.y.c lil;
    private b lim;
    private String lin;
    private String lio;
    private String lip;
    private String liq;
    private String lir;
    private String lis;
    private String lit;
    private String liu;
    private TextView liv;
    private TextView liw;
    private ImageView lix;
    private TextView liy;
    private TextView liz;
    private r tipDialog;

    public class a {
        String fqG;
        String liD;
        String username;

        a(String str, String str2, String str3) {
            this.username = str;
            this.fqG = str2;
            this.liD = str3;
        }
    }

    public class b extends BaseAdapter {
        List<a> kLl = new ArrayList();
        private com.tencent.mm.ap.a.a.c liE = null;
        Context mContext;

        public b(Context context) {
            this.mContext = context;
            ayB();
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFl = true;
            aVar.hFI = true;
            aVar.hFA = R.k.bBC;
            this.liE = aVar.PQ();
        }

        private void ayB() {
            String[] strArr = null;
            if (bi.oN(SeeAccessVerifyInfoUI.this.lio)) {
                x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
                return;
            }
            String[] split = SeeAccessVerifyInfoUI.this.lio.split(",");
            if (bi.oN(SeeAccessVerifyInfoUI.this.lin)) {
                x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
                return;
            }
            String[] split2 = SeeAccessVerifyInfoUI.this.lin.split(",");
            if (bi.oN(SeeAccessVerifyInfoUI.this.lip)) {
                x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
            } else {
                strArr = SeeAccessVerifyInfoUI.this.lip.split(",");
            }
            this.kLl.clear();
            int i = 0;
            while (i < split.length) {
                List list = this.kLl;
                SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
                String str = split[i];
                String str2 = (split2.length <= i || bi.oN(split2[i])) ? split[i] : split2[i];
                String str3 = (strArr == null || strArr.length <= i || bi.oN(strArr[i])) ? "" : strArr[i];
                list.add(new a(str, str2, str3));
                i++;
            }
        }

        public final int getCount() {
            return this.kLl.size();
        }

        public final Object getItem(int i) {
            return this.kLl.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            c ck;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dra, null);
                ck = SeeAccessVerifyInfoUI.this.ck(view);
            } else {
                c cVar = (c) view.getTag();
                ck = cVar == null ? SeeAccessVerifyInfoUI.this.ck(view) : cVar;
            }
            ck.ikK.setVisibility(0);
            ck.liG.setVisibility(0);
            o.PG().a(((a) this.kLl.get(i)).liD, ck.ikK, this.liE);
            ck.liG.setText(i.b(this.mContext, bi.oM(((a) this.kLl.get(i)).fqG), ck.liG.getTextSize()));
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String AX;
                    String str = ((a) b.this.kLl.get(i)).fqG;
                    String str2 = null;
                    if (SeeAccessVerifyInfoUI.this.lfE != null) {
                        str2 = SeeAccessVerifyInfoUI.this.lfE.gw(((a) b.this.kLl.get(i)).username);
                    }
                    if (bi.oN(str2)) {
                        SeeAccessVerifyInfoUI.this.lil;
                        AX = com.tencent.mm.y.c.Ff().Xv(bi.oM(((a) b.this.kLl.get(i)).username)).AX();
                    } else {
                        AX = str2;
                    }
                    SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((a) b.this.kLl.get(i)).username, AX, str, true);
                }
            });
            return view;
        }
    }

    class c {
        public ImageView ikK;
        public TextView liG;

        c() {
        }
    }

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        if (bi.oN(str2)) {
            as.Hm();
            bf FF = com.tencent.mm.y.c.Fg().FF(str);
            if (!(FF == null || bi.oN(FF.field_encryptUsername))) {
                str2 = FF.field_conRemark;
            }
        }
        if (!bi.oN(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            x.i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", seeAccessVerifyInfoUI.liu);
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.liu);
            if (seeAccessVerifyInfoUI.lfE != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.lfE.gw(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.lis);
            as.Hm();
            ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
            if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                com.tencent.mm.sdk.b.b ozVar = new oz();
                ozVar.fHJ.intent = intent;
                ozVar.fHJ.username = str;
                com.tencent.mm.sdk.b.a.xmy.m(ozVar);
            }
            if (Xv != null && Xv.ciN()) {
                g.pWK.k(10298, Xv.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 96);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.lis);
            com.tencent.mm.plugin.chatroom.a.ihN.d(intent, (Context) seeAccessVerifyInfoUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        setMMTitle(getString(R.l.dCq));
        this.hBu = getIntent().getLongExtra("msgLocalId", 0);
        this.liq = getIntent().getStringExtra("invitertitle");
        this.lir = getIntent().getStringExtra("inviterusername");
        this.lis = getIntent().getStringExtra("chatroom");
        this.lit = getIntent().getStringExtra("invitationreason");
        this.liu = getIntent().getStringExtra("ticket");
        this.lio = getIntent().getStringExtra("username");
        this.lin = getIntent().getStringExtra("nickname");
        this.lip = getIntent().getStringExtra("headimgurl");
        this.lil = as.Hm();
        this.lfE = com.tencent.mm.y.c.Fo().hG(bi.oM(this.lis));
        this.lim = new b(this);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SeeAccessVerifyInfoUI.this.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        x.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.drJ;
    }

    protected final void initView() {
        CharSequence charSequence = null;
        this.liv = (TextView) findViewById(R.h.cqq);
        this.liw = (TextView) findViewById(R.h.cqp);
        this.liy = (TextView) findViewById(R.h.cIz);
        this.lix = (ImageView) findViewById(R.h.cIA);
        this.liz = (TextView) findViewById(R.h.bIq);
        this.liA = (GridView) findViewById(R.h.bML);
        this.liA.setAdapter(this.lim);
        if (this.lix != null) {
            this.lix.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SeeAccessVerifyInfoUI.this.lil;
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(bi.oM(SeeAccessVerifyInfoUI.this.lir));
                    String str = Xv.field_nickname;
                    String str2 = null;
                    if (SeeAccessVerifyInfoUI.this.lfE != null) {
                        str2 = SeeAccessVerifyInfoUI.this.lfE.gw(SeeAccessVerifyInfoUI.this.lir);
                    }
                    if (bi.oN(str2)) {
                        str2 = Xv.AX();
                    }
                    SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.this.lir, str2, str, false);
                }
            });
        }
        this.liA.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.liA.postDelayed(new Runnable() {
            public final void run() {
                int i = 0;
                if (SeeAccessVerifyInfoUI.this.liy != null) {
                    i = (int) ((((float) SeeAccessVerifyInfoUI.this.liy.getHeight()) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.f.bus)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.f.bvE));
                }
                if (SeeAccessVerifyInfoUI.this.lim.getCount() / 4 > 0) {
                    i *= (SeeAccessVerifyInfoUI.this.lim.getCount() / 4) + 1;
                }
                SeeAccessVerifyInfoUI.this.liA.setLayoutParams(new LayoutParams(SeeAccessVerifyInfoUI.this.liA.getWidth(), i));
            }
        }, 100);
        if (this.lix != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(this.lix, bi.oM(this.lir));
        }
        if (this.liy != null) {
            TextView textView = this.liy;
            String oM = bi.oM(this.lir);
            TextView textView2 = this.liy;
            if (textView2 != null) {
                ag Xv = com.tencent.mm.y.c.Ff().Xv(bi.oM(oM));
                if (Xv == null) {
                    x.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
                } else {
                    oM = !bi.oN(Xv.field_conRemark) ? Xv.field_conRemark : this.lfE != null ? this.lfE.gw(oM) : null;
                    if (bi.oN(oM)) {
                        oM = Xv.field_conRemark;
                    }
                    if (bi.oN(oM)) {
                        oM = Xv.AW();
                    }
                    charSequence = i.b(this, bi.oM(oM), textView2.getTextSize());
                }
            }
            textView.setText(charSequence);
        }
        if (this.liv != null) {
            this.liv.setText(i.a((Context) this, bi.oM(this.liq)));
        }
        if (!(this.liw == null || bi.oN(this.lit))) {
            this.liw.setText(i.a((Context) this, "\"" + bi.oM(this.lit) + "\""));
        }
        if (this.liz != null) {
            this.liz.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
                    Context context = SeeAccessVerifyInfoUI.this.mController.xRr;
                    SeeAccessVerifyInfoUI.this.getString(R.l.dGZ);
                    seeAccessVerifyInfoUI.tipDialog = h.a(context, SeeAccessVerifyInfoUI.this.getString(R.l.dCr), false, null);
                    new com.tencent.mm.plugin.chatroom.d.b(SeeAccessVerifyInfoUI.this.lir, SeeAccessVerifyInfoUI.this.lis, SeeAccessVerifyInfoUI.this.liu, new LinkedList(bi.F(SeeAccessVerifyInfoUI.this.lio.split(",")))).Kb().c(SeeAccessVerifyInfoUI.this).i(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<ds>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
                            if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                                SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                            }
                            com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(aVar.foE);
                            if (eC != null) {
                                eC.a(SeeAccessVerifyInfoUI.this, null, null);
                            } else if (aVar.errType == 0 && aVar.errCode == 0) {
                                if (aVar.frW.getType() == 774) {
                                    as.Hm();
                                    au dI = com.tencent.mm.y.c.Fh().dI(SeeAccessVerifyInfoUI.this.hBu);
                                    dI.ckn();
                                    as.Hm();
                                    com.tencent.mm.y.c.Fh().b(dI.field_msgSvrId, dI);
                                    SeeAccessVerifyInfoUI.this.liz.setBackgroundResource(R.g.bAd);
                                    SeeAccessVerifyInfoUI.this.liz.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(R.e.bsH));
                                    SeeAccessVerifyInfoUI.this.liz.setText(SeeAccessVerifyInfoUI.this.getString(R.l.epm));
                                    SeeAccessVerifyInfoUI.this.liz.setEnabled(false);
                                    g.pWK.a(219, 23, 1, true);
                                }
                            } else if (aVar.frW.getType() == 774) {
                                x.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bi.oM(aVar.foE));
                                h.b(SeeAccessVerifyInfoUI.this.mController.xRr, SeeAccessVerifyInfoUI.this.getString(R.l.dCp), SeeAccessVerifyInfoUI.this.getString(R.l.dGZ), true);
                            }
                            return zLb;
                        }
                    });
                }
            });
        }
        if (this.liz != null) {
            as.Hm();
            if (com.tencent.mm.y.c.Fh().dI(this.hBu).cko()) {
                this.liz.setBackgroundResource(R.g.bAd);
                this.liz.setTextColor(getResources().getColor(R.e.bsH));
                this.liz.setText(getString(R.l.epm));
                this.liz.setEnabled(false);
            }
        }
    }

    protected final c ck(View view) {
        c cVar = new c();
        cVar.ikK = (ImageView) view.findViewById(R.h.cIA);
        cVar.liG = (TextView) view.findViewById(R.h.cIz);
        return cVar;
    }
}
