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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.m;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.chatroom.d.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SelectMemberUI extends MMActivity implements e {
    private ListView Fv;
    private r jqf;
    private int kKY;
    private View klP;
    private q lfE;
    private String lgQ;
    private String liI;
    private MMEditText liM;
    private View ljn;
    SelectMemberScrollBar ljw;
    private b ljx;
    private boolean ljy;
    private boolean ljz;
    private String mTitle;

    public class b extends BaseAdapter {
        volatile boolean acS = false;
        List<a> fBI = new ArrayList();
        private q lfE;
        private String lgQ;
        public String liS;
        String liU = null;
        List<a> liV = new ArrayList(0);
        private com.tencent.mm.y.c lil;
        public final String ljD = new String(Character.toChars(91));
        HashMap<String, Integer> ljE = new HashMap();
        private Context mContext;

        static /* synthetic */ void b(b bVar) {
            if (bVar.fBI != null) {
                Object obj = null;
                int i = 0;
                for (a aVar : bVar.fBI) {
                    String oD;
                    if (aVar.jQP != null) {
                        oD = com.tencent.mm.platformtools.c.oD(bVar.c(aVar.jQP));
                        oD = bi.oN(oD) ? "" : oD.startsWith(bVar.ljD) ? "#" : oD.toUpperCase().substring(0, 1);
                        if (i == 0) {
                            bVar.ljE.put(oD, Integer.valueOf(i));
                        } else if (!(obj == null || oD.equals(obj))) {
                            bVar.ljE.put(oD, Integer.valueOf(i));
                        }
                    } else {
                        oD = null;
                    }
                    i++;
                    String obj2 = oD;
                }
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return oA(i);
        }

        public b(Context context, q qVar, String str, String str2) {
            this.lfE = qVar;
            this.lgQ = str;
            this.liU = str2;
            this.mContext = context;
            this.lil = as.Hm();
        }

        public final void xO(String str) {
            x.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            List arrayList = new ArrayList();
            if (bi.oN(str)) {
                this.fBI = this.liV;
                return;
            }
            for (a aVar : this.liV) {
                if (!(aVar == null || aVar.jQP == null || aVar.type != 1)) {
                    ag agVar = aVar.jQP;
                    if (agVar.field_conRemark != null && agVar.field_conRemark.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!bi.oN(SeeRoomMemberUI.a(this.lfE, agVar.field_username)) && SeeRoomMemberUI.a(this.lfE, agVar.field_username).contains(str)) {
                        arrayList.add(aVar);
                    } else if (agVar.AW() != null && agVar.AW().contains(str)) {
                        arrayList.add(aVar);
                    } else if (agVar.vX() != null && agVar.vX().contains(str)) {
                        arrayList.add(aVar);
                    } else if (agVar.vU() != null && agVar.vU().contains(str)) {
                        arrayList.add(aVar);
                    } else if (agVar.field_username != null && agVar.field_username.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!com.tencent.mm.k.a.ga(agVar.field_type)) {
                        as.Hm();
                        bf FF = com.tencent.mm.y.c.Fg().FF(agVar.field_username);
                        if (!(FF == null || FF.field_conRemark == null || !FF.field_conRemark.contains(str))) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            this.fBI = arrayList;
        }

        public final int getCount() {
            if (this.fBI == null || this.acS) {
                return 0;
            }
            return this.fBI.size();
        }

        public final a oA(int i) {
            if (this.fBI.size() > i) {
                return (a) this.fBI.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.drQ, null);
                c cVar2 = new c();
                cVar2.lji = (MaskLayout) view.findViewById(R.h.cLg);
                cVar2.kKL = (TextView) view.findViewById(R.h.cLi);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                cVar2.kKL.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                cVar2.ljj = (TextView) view.findViewById(R.h.cLh);
                cVar2.ljj.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            com.tencent.mm.storage.x xVar = oA(i).jQP;
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) cVar.lji.view, xVar.field_username);
            if (xVar.field_verifyFlag == 0) {
                cVar.lji.cqE();
            } else if (com.tencent.mm.y.ak.a.hhx != null) {
                String gQ = com.tencent.mm.y.ak.a.hhx.gQ(xVar.field_verifyFlag);
                if (gQ != null) {
                    cVar.lji.d(m.ki(gQ), com.tencent.mm.ui.base.MaskLayout.a.ynF);
                } else {
                    cVar.lji.cqE();
                }
            } else {
                cVar.lji.cqE();
            }
            CharSequence c = c(xVar);
            CharSequence charSequence = "";
            if (com.tencent.mm.k.a.ga(xVar.field_type)) {
                charSequence = xVar.fXt;
            }
            if (bi.oN(charSequence)) {
                cVar.ljj.setVisibility(8);
                cVar.ljj.setText("");
            } else {
                cVar.ljj.setVisibility(0);
                cVar.ljj.setText(i.b(this.mContext, charSequence, cVar.ljj.getTextSize()));
            }
            cVar.kKL.setText(i.b(this.mContext, c, cVar.kKL.getTextSize()));
            return view;
        }

        private String c(com.tencent.mm.storage.x xVar) {
            String a;
            if (bi.oN(xVar.field_conRemark)) {
                a = SelectMemberUI.a(this.lfE, xVar.field_username);
            } else {
                a = xVar.field_conRemark;
            }
            if (bi.oN(a)) {
                a = xVar.AW();
            }
            if (com.tencent.mm.k.a.ga(xVar.field_type)) {
                return a;
            }
            as.Hm();
            bf FF = com.tencent.mm.y.c.Fg().FF(xVar.field_username);
            if (FF == null || bi.oN(FF.field_conRemark)) {
                return a;
            }
            return FF.field_conRemark;
        }
    }

    public class a {
        public com.tencent.mm.storage.x jQP;
        public int type = 1;

        public a(com.tencent.mm.storage.x xVar) {
            this.jQP = xVar;
        }
    }

    private static class c {
        public TextView kKL;
        public MaskLayout lji;
        public TextView ljj;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, int i) {
        a oA = selectMemberUI.ljx.oA(i);
        if (oA == null || oA.jQP == null) {
            x.e("MicroMsg.SelectMemberUI", "null == item || null == item.contact");
            return;
        }
        ag agVar = oA.jQP;
        final String str = agVar.field_username;
        String a = !bi.oN(agVar.field_conRemark) ? agVar.field_conRemark : a(selectMemberUI.lfE, agVar.field_username);
        if (bi.oN(a)) {
            a = agVar.AW();
        }
        if (!com.tencent.mm.k.a.ga(agVar.field_type)) {
            as.Hm();
            bf FF = com.tencent.mm.y.c.Fg().FF(agVar.field_username);
            if (!(FF == null || bi.oN(FF.field_conRemark))) {
                a = FF.field_conRemark;
            }
        }
        h.a((Context) selectMemberUI, !selectMemberUI.ljy ? selectMemberUI.getString(R.l.eGw, new Object[]{a}) : selectMemberUI.getString(R.l.eGd, new Object[]{a}), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                as.CN().a(new n(SelectMemberUI.this.lgQ, str), 0);
                SelectMemberUI selectMemberUI = SelectMemberUI.this;
                Context context = SelectMemberUI.this;
                SelectMemberUI.this.getString(R.l.dGZ);
                selectMemberUI.jqf = h.a(context, SelectMemberUI.this.getString(R.l.eGx), false, null);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, String str) {
        selectMemberUI.aWY();
        Intent intent = new Intent(selectMemberUI, SelectMemberChattingRecordUI.class);
        intent.putExtra("RoomInfo_Id", selectMemberUI.lgQ);
        intent.putExtra("room_member", str);
        intent.putExtra("title", selectMemberUI.getString(R.l.eJt));
        selectMemberUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SelectMemberUI", "[onCreate]");
        this.lgQ = getIntent().getStringExtra("RoomInfo_Id");
        x.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", this.lgQ);
        as.Hm();
        this.lfE = com.tencent.mm.y.c.Fo().hH(this.lgQ);
        this.liI = getIntent().getStringExtra("Block_list");
        this.kKY = getIntent().getIntExtra("frome_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.ljy = getIntent().getBooleanExtra("quit_room", false);
        this.ljz = getIntent().getBooleanExtra("is_show_owner", true);
        initView();
        if (this.kKY == 2) {
            as.CN().a(990, (e) this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kKY == 2) {
            as.CN().b(990, (e) this);
        }
        if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
        }
    }

    protected final void initView() {
        setMMTitle(bi.oM(this.mTitle));
        this.Fv = (ListView) findViewById(R.h.cvM);
        this.ljn = findViewById(R.h.cLd);
        this.klP = findViewById(R.h.cLe);
        this.ljx = new b(this, this.lfE, this.lgQ, this.lfE.field_roomowner);
        this.Fv.setAdapter(this.ljx);
        this.ljw = (SelectMemberScrollBar) findViewById(R.h.cvO);
        this.ljw.setVisibility(0);
        this.ljw.yqj = new com.tencent.mm.ui.base.VerticalScrollBar.a() {
            public final void xN(String str) {
                if ("↑".equals(str)) {
                    SelectMemberUI.this.Fv.setSelection(0);
                    return;
                }
                int intValue;
                b b = SelectMemberUI.this.ljx;
                if (b.ljE.containsKey(str)) {
                    intValue = ((Integer) b.ljE.get(str)).intValue();
                } else {
                    intValue = -1;
                }
                if (intValue != -1) {
                    SelectMemberUI.this.Fv.setSelection(intValue);
                }
            }
        };
        this.liM = (MMEditText) findViewById(R.h.cLc);
        this.liM.addTextChangedListener(new TextWatcher() {
            private al ljB = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    x.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
                    b b = SelectMemberUI.this.ljx;
                    String obj = SelectMemberUI.this.liM.getText().toString();
                    x.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", bi.Wz(obj), Boolean.valueOf(b.acS));
                    if (!b.acS) {
                        b.liS = obj;
                        b.xO(obj);
                        ah.y(new Runnable() {
                            public final void run() {
                                b.this.notifyDataSetChanged();
                                if (b.this.fBI == null || b.this.fBI.size() != 0) {
                                    SelectMemberUI.this.Fv.setVisibility(0);
                                    SelectMemberUI.this.ljn.setVisibility(8);
                                    return;
                                }
                                SelectMemberUI.this.Fv.setVisibility(8);
                                SelectMemberUI.this.ljn.setVisibility(0);
                            }
                        });
                    }
                    return false;
                }
            }, false);

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.ljB.TN();
                this.ljB.K(500, 500);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                switch (SelectMemberUI.this.kKY) {
                    case 1:
                        SelectMemberUI.a(SelectMemberUI.this, SelectMemberUI.this.ljx.oA(i).jQP.field_username);
                        return;
                    case 2:
                        SelectMemberUI.a(SelectMemberUI.this, i);
                        return;
                    default:
                        x.w("MicroMsg.SelectMemberUI", "mFromScene is default");
                        return;
                }
            }
        });
        b bVar = this.ljx;
        bVar.ljA.klP.setVisibility(0);
        as.Dt().F(new Runnable() {
            public final void run() {
                b.this.acS = true;
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = b.this;
                List My = b.this.lfE.My();
                if (My != null) {
                    bVar.fBI.clear();
                    for (int i = 0; i < My.size(); i++) {
                        ag Xv = com.tencent.mm.y.c.Ff().Xv((String) My.get(i));
                        boolean equals = Xv.field_username.equals(bVar.liU);
                        if (!equals || SelectMemberUI.this.ljz) {
                            if (equals && SelectMemberUI.this.ljz) {
                                bVar.fBI.add(0, new a(Xv));
                            } else {
                                bVar.fBI.add(new a(Xv));
                            }
                        }
                    }
                    Collections.sort(bVar.fBI, new Comparator<a>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return com.tencent.mm.platformtools.c.oD(b.this.c(((a) obj).jQP)).compareToIgnoreCase(com.tencent.mm.platformtools.c.oD(b.this.c(((a) obj2).jQP)));
                        }
                    });
                    bVar.liV = bVar.fBI;
                }
                b.b(b.this);
                x.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                ah.y(new Runnable() {
                    public final void run() {
                        b.this.acS = false;
                        SelectMemberUI.this.klP.setVisibility(8);
                        b.this.notifyDataSetChanged();
                    }
                });
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelectMemberUI.this.setResult(0);
                SelectMemberUI.this.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
        }
        if (kVar.getType() != 990) {
            return;
        }
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((n) kVar).username);
            u.makeText(this, R.l.eGv, 1).show();
            Intent intent = new Intent();
            intent.putExtra("RoomInfo_Id", this.lgQ);
            intent.putExtra("Chat_User", this.lgQ);
            intent.putExtra("Is_Chatroom", true);
            intent.setFlags(67108864);
            d.b(this.mController.xRr, "chatroom", ".ui.ChatroomInfoUI", intent);
            finish();
            return;
        }
        u.makeText(this, R.l.eGu, 1).show();
        x.w("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer failed: %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.gw(str);
    }

    protected final int getLayoutId() {
        return R.i.drR;
    }
}
