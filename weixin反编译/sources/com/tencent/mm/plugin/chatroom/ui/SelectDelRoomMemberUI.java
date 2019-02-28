package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectDelRoomMemberUI extends MMActivity {
    private ListView Fv;
    private boolean fAu;
    public HashSet<String> ikQ;
    private q lfE;
    private boolean lfm;
    private String lgQ;
    private String lhf;
    private int lhg;
    private String lhh;
    private boolean lhi;
    private String liI;
    private String liJ;
    private String liL;
    private int ljb;
    private a ljc;
    private EditText ljd;
    private String username;

    private static class a extends BaseAdapter {
        static List<x> fBI = new ArrayList();
        static List<x> liV;
        private String iTE;
        private List<String> koG;
        q lfE;
        String liS;
        private String liU = null;
        private c lil;
        a ljg = null;
        private Context mContext;

        private static class a {
            public TextView kKL;
            public MaskLayout lji;
            public TextView ljj;
            public ImageView ljk;
            public ImageButton ljl;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return oz(i);
        }

        public a(Context context, q qVar, String str, List<String> list, String str2) {
            this.lfE = qVar;
            this.iTE = str;
            this.koG = list;
            this.mContext = context;
            this.liU = str2;
            this.lil = as.Hm();
            av(m.gl(str));
        }

        public final void av(List<String> list) {
            if (list != null) {
                fBI.clear();
                for (int i = 0; i < list.size(); i++) {
                    ag Xv = c.Ff().Xv((String) list.get(i));
                    if (Xv == null || !Xv.field_username.equals(this.liU)) {
                        fBI.add(Xv);
                    } else {
                        fBI.add(0, Xv);
                    }
                }
                liV = fBI;
                notifyDataSetChanged();
            }
        }

        public static x oz(int i) {
            return (x) fBI.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            x xVar = (x) fBI.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dfw, null);
                this.ljg = new a();
                this.ljg.lji = (MaskLayout) view.findViewById(R.h.cKF);
                this.ljg.kKL = (TextView) view.findViewById(R.h.cKH);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                this.ljg.kKL.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                this.ljg.ljj = (TextView) view.findViewById(R.h.cKG);
                this.ljg.ljj.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                this.ljg.ljk = (ImageView) view.findViewById(R.h.cIr);
                this.ljg.ljl = (ImageButton) view.findViewById(R.h.bPh);
                view.setTag(this.ljg);
                view2 = view;
            } else {
                this.ljg = (a) view.getTag();
                view2 = view;
            }
            if (xVar != null) {
                final String str;
                CharSequence charSequence;
                CharSequence charSequence2;
                this.ljg.kKL.setTextColor(com.tencent.mm.bu.a.Z(this.mContext, !s.hq(xVar.field_username) ? R.e.bth : R.e.bti));
                if (this.lfE.field_roomowner.equals(xVar.field_username)) {
                    this.ljg.ljl.setVisibility(8);
                    ((LargeTouchableAreasItemView) view2).lgJ = null;
                } else {
                    if (((SelectDelRoomMemberUI) this.mContext).ikQ.contains(xVar.field_username)) {
                        ((LargeTouchableAreasItemView) view2).en(true);
                    } else {
                        ((LargeTouchableAreasItemView) view2).en(false);
                    }
                    this.ljg.ljl.setVisibility(0);
                    str = xVar.field_username;
                    ((LargeTouchableAreasItemView) view2).lgJ = new com.tencent.mm.plugin.chatroom.ui.LargeTouchableAreasItemView.a() {
                        public final void eo(boolean z) {
                            if (z) {
                                ((SelectDelRoomMemberUI) a.this.mContext).ikQ.add(str);
                            } else {
                                ((SelectDelRoomMemberUI) a.this.mContext).ikQ.remove(str);
                            }
                            ((SelectDelRoomMemberUI) a.this.mContext).Xi();
                        }
                    };
                }
                b.a((ImageView) this.ljg.lji.view, xVar.field_username);
                if (xVar.field_verifyFlag == 0) {
                    this.ljg.lji.cqE();
                } else if (com.tencent.mm.y.ak.a.hhx != null) {
                    String gQ = com.tencent.mm.y.ak.a.hhx.gQ(xVar.field_verifyFlag);
                    if (gQ != null) {
                        this.ljg.lji.d(com.tencent.mm.af.m.ki(gQ), com.tencent.mm.ui.base.MaskLayout.a.ynF);
                    } else {
                        this.ljg.lji.cqE();
                    }
                } else {
                    this.ljg.lji.cqE();
                }
                str = SelectDelRoomMemberUI.b(this.lfE, xVar.field_username);
                if (bi.oN(xVar.field_conRemark)) {
                    Object charSequence3 = str;
                } else {
                    charSequence3 = xVar.field_conRemark;
                }
                if (bi.oN(charSequence3)) {
                    charSequence3 = xVar.AW();
                }
                if (!(str == null || str.equals("") || charSequence3.equals(str))) {
                    charSequence3 = str + "( " + charSequence3 + " )";
                }
                str = "";
                if (com.tencent.mm.k.a.ga(xVar.field_type)) {
                    charSequence2 = xVar.fXt;
                } else {
                    as.Hm();
                    bf FF = c.Fg().FF(xVar.field_username);
                    if (FF != null) {
                        charSequence2 = FF.field_conDescription;
                        if (!bi.oN(FF.field_conRemark)) {
                            charSequence3 = FF.field_conRemark;
                        }
                    } else {
                        Object charSequence22 = str;
                    }
                }
                if (bi.oN(charSequence22)) {
                    this.ljg.ljj.setText("");
                } else {
                    this.ljg.ljj.setText(i.b(this.mContext, charSequence22, this.ljg.ljj.getTextSize()));
                }
                this.ljg.kKL.setText(i.b(this.mContext, charSequence3, this.ljg.kKL.getTextSize()));
            }
            return view2;
        }

        public final int getCount() {
            return fBI.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ ArrayList a(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        ArrayList arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = selectDelRoomMemberUI.ikQ.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    static /* synthetic */ void a(SelectDelRoomMemberUI selectDelRoomMemberUI, String str, String str2, String str3) {
        if (bi.oN(str2)) {
            as.Hm();
            bf FF = c.Fg().FF(str);
            if (!(FF == null || bi.oN(FF.field_encryptUsername))) {
                str2 = FF.field_conRemark;
            }
        }
        if (!bi.oN(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (selectDelRoomMemberUI.fAu && selectDelRoomMemberUI.lfE != null) {
                intent.putExtra("Contact_RoomNickname", selectDelRoomMemberUI.lfE.gw(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", selectDelRoomMemberUI.lhf);
            as.Hm();
            ag Xv = c.Ff().Xv(str);
            if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                com.tencent.mm.sdk.b.b ozVar = new oz();
                ozVar.fHJ.intent = intent;
                ozVar.fHJ.username = str;
                com.tencent.mm.sdk.b.a.xmy.m(ozVar);
            }
            if (selectDelRoomMemberUI.fAu) {
                if (Xv != null && Xv.ciN()) {
                    g.pWK.k(10298, Xv.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (selectDelRoomMemberUI.lfm) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.y.q.gt(Xv.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Contact_ChatRoomId", selectDelRoomMemberUI.lgQ);
            com.tencent.mm.plugin.chatroom.a.ihN.d(intent, (Context) selectDelRoomMemberUI);
        }
    }

    static /* synthetic */ String b(q qVar, String str) {
        return qVar == null ? null : qVar.gw(str);
    }

    protected final int getLayoutId() {
        return R.i.dfx;
    }

    protected final void initView() {
        super.initView();
        this.lgQ = getIntent().getStringExtra("RoomInfo_Id");
        this.liJ = getIntent().getStringExtra("Chatroom_member_list");
        this.fAu = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.lfm = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.lhi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.lhh = getIntent().getStringExtra("room_owner_name");
        as.Hm();
        this.lfE = c.Fo().hG(this.lgQ);
        this.lhg = getIntent().getIntExtra("room_member_count", 0);
        this.ljb = getIntent().getIntExtra("list_attr", com.tencent.mm.ui.contact.s.zcy);
        this.lhf = getIntent().getStringExtra("room_name");
        setMMTitle(getString(R.l.eGp) + "(" + this.lhg + ")");
        a(1, getString(R.l.dYH), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(SelectDelRoomMemberUI.this, SelectDelRoomMemberUI.this.getString(R.l.eFo), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Contact", bi.d(SelectDelRoomMemberUI.a(SelectDelRoomMemberUI.this), ","));
                        SelectDelRoomMemberUI.this.setResult(-1, intent);
                        SelectDelRoomMemberUI.this.finish();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return false;
            }
        }, p.b.xSf);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelectDelRoomMemberUI.this.finish();
                return false;
            }
        });
        this.ljd = (EditText) findViewById(R.h.cyy);
        this.ljd.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                a b = SelectDelRoomMemberUI.this.ljc;
                Object charSequence2 = charSequence.toString();
                b.liS = charSequence2;
                List arrayList = new ArrayList();
                if (bi.oN(charSequence2)) {
                    a.fBI = a.liV;
                } else {
                    for (x xVar : a.liV) {
                        if (xVar != null) {
                            if (xVar.field_conRemark != null && xVar.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(xVar);
                            } else if (!bi.oN(SelectDelRoomMemberUI.b(b.lfE, xVar.field_username)) && SelectDelRoomMemberUI.b(b.lfE, xVar.field_username).contains(charSequence2)) {
                                arrayList.add(xVar);
                            } else if (xVar.AW() != null && xVar.AW().toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(xVar);
                            } else if (xVar.vX() != null && xVar.vX().toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(xVar);
                            } else if (xVar.vU() != null && xVar.vU().contains(charSequence2)) {
                                arrayList.add(xVar);
                            } else if (xVar.field_username != null && xVar.field_username.contains(charSequence2)) {
                                arrayList.add(xVar);
                            } else if (!com.tencent.mm.k.a.ga(xVar.field_type)) {
                                as.Hm();
                                bf FF = c.Fg().FF(xVar.field_username);
                                if (!(FF == null || FF.field_conRemark == null || !FF.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase()))) {
                                    arrayList.add(xVar);
                                }
                            }
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SelectDelRoomMemberUI", "--->setMemberListBySearch:search");
                    a.fBI = arrayList;
                }
                b.notifyDataSetChanged();
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.Fv = (ListView) findViewById(R.h.bSL);
        x xVar = new x();
        q qVar = this.lfE;
        String str = this.lgQ;
        List linkedList = new LinkedList();
        if (!bi.oN(this.liI)) {
            linkedList = bi.F(this.liI.split(","));
        }
        as.Hm();
        bc FE = c.Fn().FE("@t.qq.com");
        if (FE != null) {
            linkedList.add(FE.name);
        }
        this.ljc = new a(this, qVar, str, linkedList, this.lhh);
        this.Fv.setAdapter(this.ljc);
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SelectDelRoomMemberUI.this.ljc;
                ag oz = a.oz(i);
                if (oz != null) {
                    SelectDelRoomMemberUI.this.username = oz.field_username;
                    String str = oz.field_nickname;
                    String b = SelectDelRoomMemberUI.b(SelectDelRoomMemberUI.this.lfE, SelectDelRoomMemberUI.this.username);
                    if (bi.oN(b)) {
                        SelectDelRoomMemberUI.this.liL = oz.AX();
                    } else {
                        SelectDelRoomMemberUI.this.liL = b;
                    }
                    SelectDelRoomMemberUI.a(SelectDelRoomMemberUI.this, SelectDelRoomMemberUI.this.username, SelectDelRoomMemberUI.this.liL, str);
                }
            }
        });
        Xi();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ikQ = new HashSet();
        initView();
    }

    public void onResume() {
        super.onResume();
        if (this.ljc != null) {
            as.Hm();
            this.lfE = c.Fo().hG(this.lgQ);
            List gl = m.gl(this.lgQ);
            if (this.ljc != null) {
                this.ljc.av(gl);
            }
        }
    }

    private void Xi() {
        if (!com.tencent.mm.ui.contact.s.fd(this.ljb, 64) || this.ikQ.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.dYH));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.dYH) + "(" + this.ikQ.size() + ")");
        enableOptionMenu(1, true);
    }
}
