package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private static boolean yvK = false;
    private ListView kLX;
    private q lfE;
    private String liI;
    private String liJ;
    private p liK;
    private String mTitle;
    private String talker;
    private a yyQ;

    private static class b {
        public TextView kKL;
        public MaskLayout lji;
        public ImageView yvO;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class a extends o<x> {
        private List<String> koG;
        private q lfE;
        String liS;
        private String[] yvM;
        private Bitmap yvN;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            as.Hm();
            Object Xq = c.Ff().Xq(x.k(cursor));
            if (Xq != null) {
                return Xq;
            }
            x xVar = new x();
            xVar.b(cursor);
            as.Hm();
            c.Ff().P(xVar);
            return xVar;
        }

        protected final /* bridge */ /* synthetic */ Object aSn() {
            return null;
        }

        public a(Context context, x xVar, q qVar, String[] strArr, List<String> list) {
            super(context, xVar);
            this.lfE = qVar;
            this.yvM = strArr;
            this.koG = list;
            this.yvN = d.u(context.getResources().getDrawable(R.k.dvY));
        }

        protected final int aSm() {
            return AtSomeoneUI.yvK ? 1 : 0;
        }

        public final boolean rq(int i) {
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            if (view == null) {
                view = View.inflate(this.context, R.i.daH, null);
                b bVar2 = new b();
                bVar2.lji = (MaskLayout) view.findViewById(R.h.bLl);
                bVar2.kKL = (TextView) view.findViewById(R.h.bLm);
                bVar2.yvO = (ImageView) view.findViewById(R.h.content);
                view.setTag(bVar2);
                bVar = bVar2;
                view2 = view;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && AtSomeoneUI.yvK) {
                bVar.yvO.setImageBitmap(this.yvN);
                bVar.kKL.setText(this.context.getResources().getString(R.l.dHv, new Object[]{"@"}));
                return view2;
            }
            CharSequence a;
            x xVar = (x) getItem(i - (AtSomeoneUI.yvK ? 1 : 0));
            bVar.kKL.setTextColor(com.tencent.mm.bu.a.Z(this.context, !s.hq(xVar.field_username) ? R.e.bth : R.e.bti));
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) bVar.lji.view, xVar.field_username);
            if (xVar.field_verifyFlag == 0) {
                bVar.lji.cqE();
            } else if (com.tencent.mm.y.ak.a.hhx != null) {
                String gQ = com.tencent.mm.y.ak.a.hhx.gQ(xVar.field_verifyFlag);
                if (gQ != null) {
                    bVar.lji.d(m.ki(gQ), com.tencent.mm.ui.base.MaskLayout.a.ynF);
                } else {
                    bVar.lji.cqE();
                }
            } else {
                bVar.lji.cqE();
            }
            if (t.oN(xVar.field_conRemark)) {
                a = AtSomeoneUI.a(this.lfE, xVar.field_username);
            } else {
                a = xVar.field_conRemark;
            }
            if (t.oN(a)) {
                a = xVar.AW();
            }
            bVar.kKL.setText(i.b(this.context, a, bVar.kKL.getTextSize()));
            return view2;
        }

        public final void XH() {
            List list;
            as.Hm();
            ar Ff = c.Ff();
            String[] strArr = this.yvM;
            String str = "@all.chatroom";
            String str2 = this.liS;
            CharSequence charSequence = this.liS;
            if (this.lfE == null || charSequence == null || this.yvM == null) {
                list = null;
            } else {
                list = new ArrayList();
                for (String str3 : this.yvM) {
                    String gw = this.lfE.gw(str3);
                    if (gw != null && gw.contains(charSequence)) {
                        list.add(str3);
                    }
                }
            }
            setCursor(Ff.a(strArr, str, str2, list, this.koG));
            super.notifyDataSetChanged();
        }

        protected final void XI() {
            aUU();
            XH();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.liI = getIntent().getStringExtra("Block_list");
        this.liJ = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        as.Hm();
        this.lfE = c.Fo().hG(this.talker);
        if (this.lfE != null && this.lfE.field_roomowner.equals(com.tencent.mm.y.q.FY())) {
            yvK = false;
        }
        initView();
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(this.mTitle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AtSomeoneUI.this.setResult(0);
                AtSomeoneUI.this.finish();
                return true;
            }
        });
        this.liK = new p(true, true);
        this.liK.zvw = new com.tencent.mm.ui.tools.p.b() {
            public final void pd(String str) {
                a a = AtSomeoneUI.this.yyQ;
                a.liS = str;
                a.a(null, null);
            }

            public final boolean pc(String str) {
                return false;
            }

            public final void XA() {
            }

            public final void XB() {
            }

            public final void XC() {
            }

            public final void XD() {
            }
        };
        a(this.liK);
        this.kLX = (ListView) findViewById(R.h.bSL);
        x xVar = new x();
        q qVar = this.lfE;
        String[] strArr = null;
        if (!t.oN(this.liJ)) {
            strArr = this.liJ.split(",");
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        if (strArr == null && this.lfE != null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = t.d(this.lfE.My(), ",").split(",");
        }
        if (strArr == null) {
            String str = "MicroMsg.AtSomeoneUI";
            String str2 = "WTF! member is null? %s";
            Object[] objArr = new Object[1];
            if (this.lfE != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
        }
        List linkedList = new LinkedList();
        if (!t.oN(this.liI)) {
            linkedList = t.g(this.liI.split(","));
        }
        as.Hm();
        bc FE = c.Fn().FE("@t.qq.com");
        if (FE != null) {
            linkedList.add(FE.name);
        }
        this.yyQ = new a(this, xVar, qVar, strArr, linkedList);
        this.kLX.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                Intent intent = new Intent();
                if (i == 0 && AtSomeoneUI.yvK) {
                    intent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(R.l.dHv, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                } else {
                    a a = AtSomeoneUI.this.yyQ;
                    if (!AtSomeoneUI.yvK) {
                        i2 = 0;
                    }
                    x xVar = (x) a.getItem(i - i2);
                    String a2 = AtSomeoneUI.a(AtSomeoneUI.this.lfE, xVar.field_username);
                    if (t.oN(a2)) {
                        a2 = xVar.AW();
                    }
                    intent.putExtra("select_raw_user_name", xVar.field_username);
                    intent.putExtra("Select_Conv_User", a2);
                }
                AtSomeoneUI.this.setResult(-1, intent);
                AtSomeoneUI.this.finish();
            }
        });
        this.kLX.setAdapter(this.yyQ);
    }

    protected void onPause() {
        super.onPause();
        if (this.liK != null) {
            this.liK.cyP();
        }
    }

    protected void onDestroy() {
        this.yyQ.aUU();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daI;
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.gw(str);
    }
}
