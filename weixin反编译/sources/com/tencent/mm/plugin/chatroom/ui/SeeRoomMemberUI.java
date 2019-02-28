package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements e {
    private static int liO = 5;
    private boolean fAu;
    private r jqf;
    private q lfE;
    private boolean lfm;
    private String lgQ;
    private String lhf;
    private int lhg;
    private String lhh;
    private boolean lhi;
    private GridView liA;
    private b liH;
    private String liI;
    private String liJ;
    private p liK;
    private String liL;
    private MMEditText liM;
    private int liN;
    private String mTitle;
    private String talker;
    private String username;
    private int wn;

    private static class a {
        x jQP;
        int type;

        public a(int i, x xVar) {
            this.type = i;
            this.jQP = xVar;
        }
    }

    private static class c {
        public ImageView ikK;
        public TextView kKL;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private class b extends BaseAdapter {
        private List<a> fBI = new ArrayList();
        private String iTE;
        private List<String> koG;
        private q lfE;
        public String liS;
        private boolean liT = false;
        private String liU = null;
        private List<a> liV;
        private com.tencent.mm.y.c lil;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            return oy(i);
        }

        public b(Context context, q qVar, String str, List<String> list, String str2) {
            this.lfE = qVar;
            this.iTE = str;
            this.koG = list;
            this.liU = str2;
            this.mContext = context;
            this.lil = as.Hm();
            av(m.gl(str));
        }

        public final void av(List<String> list) {
            if (list != null) {
                this.fBI.clear();
                for (int i = 0; i < list.size(); i++) {
                    ag Xv = com.tencent.mm.y.c.Ff().Xv((String) list.get(i));
                    if (Xv == null || !Xv.field_username.equals(this.liU)) {
                        this.fBI.add(new a(1, Xv));
                    } else {
                        this.fBI.add(0, new a(1, Xv));
                    }
                }
                this.fBI.add(new a(2, null));
                if (SeeRoomMemberUI.this.lhi) {
                    this.fBI.add(new a(3, null));
                }
                this.liV = this.fBI;
                notifyDataSetChanged();
            }
        }

        public final a oy(int i) {
            return (a) this.fBI.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.drK, null);
                cVar = new c();
                cVar.ikK = (ImageView) view.findViewById(R.h.cKF);
                cVar.kKL = (TextView) view.findViewById(R.h.cKH);
                cVar.kKL.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a aVar = (a) this.fBI.get(i);
            if (aVar != null && aVar.type == 1) {
                CharSequence charSequence;
                ag agVar = aVar.jQP;
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ikK, agVar.field_username);
                String a = SeeRoomMemberUI.a(this.lfE, agVar.field_username);
                if (bi.oN(agVar.field_conRemark)) {
                    Object charSequence2 = a;
                } else {
                    charSequence2 = agVar.field_conRemark;
                }
                if (bi.oN(charSequence2)) {
                    charSequence2 = agVar.AW();
                }
                if (!(a == null || a.equals("") || charSequence2.equals(a))) {
                    charSequence2 = a + "( " + charSequence2 + " )";
                }
                cVar.kKL.setVisibility(0);
                cVar.kKL.setText(i.b(this.mContext, charSequence2, cVar.kKL.getTextSize()));
            } else if (aVar != null && aVar.type == 2) {
                cVar.kKL.setVisibility(4);
                cVar.ikK.setImageResource(R.g.bzl);
            } else if (aVar != null && aVar.type == 3) {
                cVar.kKL.setVisibility(4);
                cVar.ikK.setImageResource(R.g.bzm);
            }
            return view;
        }

        public final void xM(String str) {
            this.liT = true;
            this.liS = str;
            List arrayList = new ArrayList();
            if (bi.oN(str)) {
                this.fBI = this.liV;
            } else {
                for (a aVar : this.liV) {
                    if (!(aVar == null || aVar.jQP == null || aVar.type != 1)) {
                        ag agVar = aVar.jQP;
                        if (agVar.field_conRemark != null && agVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (!bi.oN(SeeRoomMemberUI.a(this.lfE, agVar.field_username)) && SeeRoomMemberUI.a(this.lfE, agVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (agVar.AW() != null && agVar.AW().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (agVar.vX() != null && agVar.vX().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (agVar.vU() != null && agVar.vU().contains(str)) {
                            arrayList.add(aVar);
                        } else if (agVar.field_username != null && agVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.k.a.ga(agVar.field_type)) {
                            as.Hm();
                            bf FF = com.tencent.mm.y.c.Fg().FF(agVar.field_username);
                            if (!(FF == null || FF.field_conRemark == null || !FF.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
                this.fBI = arrayList;
            }
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.fBI.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, int i) {
        if (seeRoomMemberUI.liH.oy(i).type == 1) {
            String str = seeRoomMemberUI.liH.oy(i).jQP.field_username;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SeeRoomMemberUI", "roomPref del " + i + " userName : " + str);
            as.Hm();
            if (bi.aD((String) com.tencent.mm.y.c.Db().get(2, null), "").equals(str)) {
                h.h(seeRoomMemberUI.mController.xRr, R.l.eFC, R.l.dGZ);
            } else {
                seeRoomMemberUI.xK(str);
            }
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, Context context) {
        if (context != null && ayk()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", seeRoomMemberUI.getString(R.l.dQG, new Object[]{w.cfV()}));
            intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
            intent.putExtra("showShare", false);
            d.b(seeRoomMemberUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, String str, String str2, String str3) {
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
            if (seeRoomMemberUI.fAu && seeRoomMemberUI.lfE != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomMemberUI.lfE.gw(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomMemberUI.lhf);
            as.Hm();
            ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
            if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                com.tencent.mm.sdk.b.b ozVar = new oz();
                ozVar.fHJ.intent = intent;
                ozVar.fHJ.username = str;
                com.tencent.mm.sdk.b.a.xmy.m(ozVar);
            }
            if (seeRoomMemberUI.fAu) {
                if (Xv != null && Xv.ciN()) {
                    g.pWK.k(10298, Xv.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (seeRoomMemberUI.lfm) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.y.q.gt(Xv.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Is_RoomOwner", seeRoomMemberUI.lhi);
            intent.putExtra("Contact_ChatRoomId", seeRoomMemberUI.lgQ);
            com.tencent.mm.plugin.chatroom.a.ihN.d(intent, (Context) seeRoomMemberUI);
        }
    }

    static /* synthetic */ void d(SeeRoomMemberUI seeRoomMemberUI) {
        String d = bi.d(m.gl(seeRoomMemberUI.lgQ), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(R.l.dDz));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.zcz);
        intent.putExtra("always_select_contact", d);
        intent.putExtra("scene", 4);
        d.a((Context) seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    static /* synthetic */ void e(SeeRoomMemberUI seeRoomMemberUI) {
        g.pWK.a(219, 8, 1, true);
        List gl = m.gl(seeRoomMemberUI.lgQ);
        String d = bi.d(gl, ",");
        int size = gl.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.lgQ);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", d);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.lhi);
        intent.putExtra("list_attr", s.zcz);
        intent.putExtra("room_name", seeRoomMemberUI.lgQ);
        intent.putExtra("room_owner_name", seeRoomMemberUI.lfE.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelRoomMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pWK.a(219, 2, 1, true);
        as.CN().a(990, (e) this);
        as.CN().a(179, (e) this);
        as.CN().a(120, (e) this);
        as.CN().a(610, (e) this);
        this.lgQ = getIntent().getStringExtra("RoomInfo_Id");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.liJ = getIntent().getStringExtra("Chatroom_member_list");
        this.fAu = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.lfm = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.lhi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.lhh = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        as.Hm();
        this.lfE = com.tencent.mm.y.c.Fo().hG(this.talker == null ? this.lgQ : this.talker);
        this.lhg = getIntent().getIntExtra("room_member_count", 0);
        this.lhf = getIntent().getStringExtra("room_name");
        this.wn = getIntent().getIntExtra("offset", 0);
        this.liN = getIntent().getIntExtra("first_pos", 0);
        initView();
        if (this.liH != null) {
            ayC();
            this.liA.setSelection(this.liN * liO < this.liH.getCount() ? this.liN * liO : this.liH.getCount() - 1);
            this.liA.postDelayed(new Runnable() {
                public final void run() {
                    if (VERSION.SDK_INT >= 19) {
                        SeeRoomMemberUI.this.liA.scrollListBy(SeeRoomMemberUI.this.wn);
                        return;
                    }
                    SeeRoomMemberUI.invokeMethod(SeeRoomMemberUI.this.liA, "trackMotionScroll", new Object[]{Integer.valueOf(-SeeRoomMemberUI.this.wn), Integer.valueOf(-SeeRoomMemberUI.this.wn)}, new Class[]{Integer.TYPE, Integer.TYPE});
                }
            }, 100);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.liH != null) {
            this.liH.xM(this.liM.getText().toString());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.liA.setNumColumns(cr(this));
    }

    private static int cr(Context context) {
        if (context == null) {
            return 0;
        }
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.f.bvz) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.f.bvC) * 2.0f) + context.getResources().getDimension(R.f.bvE)))));
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", Integer.valueOf(width));
        liO = width;
        return width;
    }

    protected final void initView() {
        setMMTitle(this.mTitle + "(" + this.lhg + ")");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SeeRoomMemberUI.this.setResult(0);
                SeeRoomMemberUI.this.finish();
                return true;
            }
        });
        this.liM = (MMEditText) findViewById(R.h.cyy);
        this.liA = (GridView) findViewById(R.h.bSK);
        this.liA.setNumColumns(cr(this));
        this.liA.setColumnWidth(getResources().getDimensionPixelSize(R.f.bvz));
        q qVar = this.lfE;
        String str = this.lgQ;
        List linkedList = new LinkedList();
        if (!bi.oN(this.liI)) {
            linkedList = bi.F(this.liI.split(","));
        }
        as.Hm();
        bc FE = com.tencent.mm.y.c.Fn().FE("@t.qq.com");
        if (FE != null) {
            linkedList.add(FE.name);
        }
        this.liH = new b(this, qVar, str, linkedList, this.lhh);
        this.liM.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SeeRoomMemberUI.this.liH.xM(charSequence.toString());
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.liA.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a oy = SeeRoomMemberUI.this.liH.oy(i);
                if (oy.type == 2) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
                    g.pWK.a(219, 6, 1, true);
                    SeeRoomMemberUI.d(SeeRoomMemberUI.this);
                } else if (oy.type == 3) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
                    SeeRoomMemberUI.e(SeeRoomMemberUI.this);
                } else if (oy.type == 1) {
                    ag agVar = SeeRoomMemberUI.this.liH.oy(i).jQP;
                    if (agVar == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                        return;
                    }
                    SeeRoomMemberUI.this.username = agVar.field_username;
                    String str = agVar.field_nickname;
                    String a = SeeRoomMemberUI.a(SeeRoomMemberUI.this.lfE, SeeRoomMemberUI.this.username);
                    if (bi.oN(a)) {
                        SeeRoomMemberUI.this.liL = agVar.AX();
                    } else {
                        SeeRoomMemberUI.this.liL = a;
                    }
                    com.tencent.mm.ui.contact.x.m(SeeRoomMemberUI.this.liM.getText().toString(), 1, 6, i + 1);
                    SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.username, SeeRoomMemberUI.this.liL, str);
                }
            }
        });
        this.liA.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (SeeRoomMemberUI.this.lhi) {
                    ag agVar = SeeRoomMemberUI.this.liH.oy(i).jQP;
                    if (agVar != null) {
                        if (!SeeRoomMemberUI.this.lfE.field_roomowner.equals(agVar.field_username)) {
                            h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(R.l.eFn), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SeeRoomMemberUI.a(SeeRoomMemberUI.this, i);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
                }
                return true;
            }
        });
        this.liA.setAdapter(this.liH);
    }

    private void ayC() {
        as.Hm();
        this.lfE = com.tencent.mm.y.c.Fo().hG(this.talker == null ? this.lgQ : this.talker);
        List gl = m.gl(this.lgQ);
        if (this.liH != null) {
            this.liH.av(gl);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.liK != null) {
            this.liK.cyP();
        }
    }

    protected void onDestroy() {
        as.CN().b(990, (e) this);
        as.CN().b(179, (e) this);
        as.CN().b(120, (e) this);
        as.CN().b(610, (e) this);
        if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.drL;
    }

    private void xK(String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            final k gVar = new com.tencent.mm.plugin.chatroom.d.g(this.lgQ, linkedList);
            getString(R.l.dGZ);
            this.jqf = h.a((Context) this, getString(R.l.eFl), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(gVar);
                }
            });
            as.CN().a(gVar, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
        }
        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
        if (eC != null) {
            eC.a(this, null, null);
        } else if (i != 0 || i2 != 0) {
            if (kVar.getType() == 179 && i2 == -66) {
                h.b(this, getString(R.l.dYB), getString(R.l.dGZ), true);
            }
            if (kVar.getType() == 120) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
            } else if (kVar.getType() == 610) {
                h.b(this, getString(R.l.eqd), getString(R.l.dGZ), true);
            }
        } else if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 120:
                    a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                    ayC();
                    break;
                case 179:
                    ayC();
                    break;
                case 610:
                    h.b(this, getString(R.l.eqe), null, true);
                    break;
            }
            if (this.lfE != null) {
                setMMTitle(this.mTitle + "(" + this.lfE.My().size() + ")");
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (!com.tencent.mm.y.s.gz(stringExtra)) {
                        h.b(this, getString(R.l.eFU), getString(R.l.dGZ), true);
                        return;
                    } else if (xL(stringExtra)) {
                        h.b(this, getString(R.l.dCL), getString(R.l.dGZ), true);
                        return;
                    } else if (bi.F(stringExtra.split(",")) != null) {
                        final String stringExtra2 = intent.getStringExtra("Select_Contact");
                        as.Hm();
                        q hG = com.tencent.mm.y.c.Fo().hG(this.lgQ);
                        if (hG == null) {
                            return;
                        }
                        if (hG.ciG() == 2) {
                            com.tencent.mm.pluginsdk.ui.applet.e.b(this.mController, getString(R.l.eEO), getString(R.l.eCz), getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        SeeRoomMemberUI.this.p(stringExtra2, str, R.l.eqm);
                                    }
                                }
                            });
                            return;
                        } else {
                            p(stringExtra, null, R.l.dCP);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            case 2:
                if (intent != null) {
                    xK(intent.getStringExtra("Select_Contact"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void p(String str, String str2, int i) {
        if (!com.tencent.mm.y.s.gz(str)) {
            h.b(this, getString(R.l.eFU), getString(R.l.dGZ), true);
        } else if (xL(str)) {
            h.b(this, getString(R.l.dCL), getString(R.l.dGZ), true);
        } else {
            List F = bi.F(str.split(","));
            if (F != null) {
                final k dVar = new com.tencent.mm.plugin.chatroom.d.d(this.lgQ, F, str2);
                getString(R.l.dGZ);
                this.jqf = h.a((Context) this, getString(i), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(dVar);
                    }
                });
                as.CN().a(dVar, 0);
            }
        }
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        String str = "";
        String str2 = "";
        String string = ad.getContext().getString(R.l.dQK);
        final List list = dVar.leX;
        final List list2 = dVar.leZ;
        final List list3 = dVar.fBO;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            Object obj;
            as.Hm();
            q hH = com.tencent.mm.y.c.Fo().hH(this.lgQ);
            if (i == -116 && ayk() && !bi.oN(hH.field_roomowner)) {
                str = getString(R.l.eFR);
                str2 = getString(R.l.eFQ);
                obj = 1;
            } else {
                obj = null;
            }
            if (i == -23) {
                str = getString(R.l.eFX);
                str2 = getString(R.l.eFW);
            }
            if (i == -109) {
                str = getString(R.l.eFT);
                str2 = getString(R.l.eFS);
            }
            if (i == -122) {
                str = getString(R.l.eFX);
                int i2 = R.l.eFV;
                Object[] objArr = new Object[2];
                str2 = null;
                as.Hm();
                ag Xv = com.tencent.mm.y.c.Ff().Xv(this.lfE.field_roomowner);
                if (Xv != null && ((int) Xv.gKO) > 0) {
                    str2 = Xv.field_conRemark;
                }
                if (bi.oN(str2)) {
                    str2 = this.lfE.field_roomowner;
                    if (this.lfE == null) {
                        str2 = null;
                    } else {
                        str2 = this.lfE.gw(str2);
                    }
                }
                if (bi.oN(str2) && Xv != null && ((int) Xv.gKO) > 0) {
                    str2 = Xv.AW();
                }
                if (bi.oN(str2)) {
                    str2 = this.lfE.field_roomowner;
                }
                objArr[0] = str2;
                objArr[1] = Integer.valueOf(hH.ciH());
                str2 = getString(i2, objArr);
            }
            List list4 = dVar.leY;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.fAL && (list4 == null || list4.size() <= 0 || dVar.fAL != list3.size() + list4.size()))) {
                String str3;
                list4 = dVar.leY;
                if (list4 != null && list4.size() > 0) {
                    str2 = str2 + getString(R.l.eiS, new Object[]{bi.d(at(list4), string)});
                }
                list4 = dVar.fBN;
                if (list4 == null || list4.size() <= 0) {
                    str3 = str;
                    str = str2;
                } else {
                    str = getString(R.l.dCJ);
                    Object[] objArr2 = new Object[]{bi.d(at(list4), string)};
                    str3 = str;
                    str = str2 + getString(R.l.ejc, objArr2);
                }
                List<String> list5 = dVar.fBL;
                if (list5 != null && list5.size() > 0) {
                    Object obj2;
                    for (String str22 : list5) {
                        if (x.Xg(str22)) {
                            str3 = getString(R.l.esV);
                            str = getString(R.l.fXC);
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        str3 = getString(R.l.dCJ);
                        str = str + getString(R.l.eiV, new Object[]{bi.d(at(list5), string)});
                    }
                }
                Collection collection = dVar.leZ;
                if (!(list3 == null || list3.isEmpty()) || (collection != null && collection.size() > 0)) {
                    list = new ArrayList();
                    list.addAll(list3);
                    list.addAll(collection);
                    d(dVar.chatroomName, list3);
                    str = str + getString(R.l.eiG, new Object[]{bi.d(at(list), string)});
                    if (list3 != null && list3.isEmpty()) {
                        str = null;
                    }
                }
                if (str != null && str.length() > 0) {
                    if (obj != null) {
                        h.a((Context) this, str, str3, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SeeRoomMemberUI seeRoomMemberUI = SeeRoomMemberUI.this;
                                Context context = SeeRoomMemberUI.this;
                                SeeRoomMemberUI.this.lgQ;
                                SeeRoomMemberUI.a(seeRoomMemberUI, context);
                            }
                        }, null);
                    } else {
                        h.b(this, str, str3, true);
                    }
                }
                hH.ciG();
                return;
            }
            List linkedList = new LinkedList();
            for (int i3 = 0; i3 < list3.size(); i3++) {
                linkedList.add(list3.get(i3));
            }
            str22 = "";
            String string2 = ad.getContext().getString(R.l.dQK);
            if (!(list4 == null || list4.isEmpty())) {
                str22 = getString(R.l.eiF, new Object[]{bi.d(at(list4), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str22 = str22 + getString(R.l.eiG, new Object[]{bi.d(at(linkedList), string2)});
            }
            h.a((Context) this, str22, "", getString(R.l.eiA), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SeeRoomMemberUI.this.ayC();
                }
            });
            d(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.dCK);
        String string3 = getString(R.l.epS);
        String string4 = getString(R.l.dEy);
        final com.tencent.mm.plugin.chatroom.d.d dVar2 = dVar;
        AnonymousClass12 anonymousClass12 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                SeeRoomMemberUI.this.d(dVar2.chatroomName, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                final k kVar = new com.tencent.mm.plugin.chatroom.d.k(SeeRoomMemberUI.this.lgQ, arrayList);
                as.CN().a(kVar, 0);
                SeeRoomMemberUI seeRoomMemberUI = SeeRoomMemberUI.this;
                Context context = SeeRoomMemberUI.this;
                SeeRoomMemberUI.this.getString(R.l.dGZ);
                seeRoomMemberUI.jqf = h.a(context, SeeRoomMemberUI.this.getString(R.l.eFL), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(kVar);
                    }
                });
            }
        };
        h.a((Context) this, string, null, string3, string4, (OnClickListener) anonymousClass12, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            l.a(str, linkedList, getString(R.l.dQJ), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private static boolean ayk() {
        return bi.getInt(com.tencent.mm.j.g.Af().getValue("ChatroomGlobalSwitch"), 1) == 1;
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
            com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(obj2);
            if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                obj2 = Xv.AX();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    private boolean xL(String str) {
        boolean z = false;
        if (bi.oM(com.tencent.mm.y.q.FY()).equals(str)) {
            return true;
        }
        List gl = m.gl(this.lgQ);
        if (gl == null) {
            return false;
        }
        Iterator it = gl.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            if (((String) it.next()).equals(str)) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return "";
        }
        return qVar.gw(str);
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Class cls;
        if (obj == null) {
            return null;
        }
        Method declaredMethod;
        Object invoke;
        cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (Throwable e32) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e32, "", new Object[0]);
                invoke = null;
            } catch (Throwable e322) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e322, "", new Object[0]);
            }
            return invoke;
        }
        invoke = null;
        return invoke;
        cls = cls.getSuperclass();
    }
}
