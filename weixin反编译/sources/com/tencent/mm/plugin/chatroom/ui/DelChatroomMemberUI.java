package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements e {
    private ListView Fv;
    private String chatroomName;
    private q lfE;
    private a lgy;
    private LinkedList<String> lgz = new LinkedList();
    private int scene;
    private r tipDialog;

    class a extends BaseAdapter {
        List<x> lgB = new LinkedList();

        a() {
        }

        public final void au(List<String> list) {
            Object obj;
            Object obj2 = null;
            Iterator it = list.iterator();
            while (true) {
                obj = obj2;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                for (Object obj3 : this.lgB) {
                    if (obj3.field_username.equals(str)) {
                        break;
                    }
                }
                Object obj32 = null;
                if (obj32 != null) {
                    obj2 = 1;
                    this.lgB.remove(obj32);
                } else {
                    obj2 = obj;
                }
            }
            if (obj != null) {
                notifyDataSetChanged();
            }
        }

        public final int getCount() {
            return this.lgB.size();
        }

        public final Object getItem(int i) {
            return this.lgB.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(DelChatroomMemberUI.this, R.i.dcW, null);
                bVar = new b();
                bVar.ikK = (ImageView) view.findViewById(R.h.bSH);
                bVar.kHt = (TextView) view.findViewById(R.h.bSI);
                bVar.lgF = (TextView) view.findViewById(R.h.bSG);
                bVar.lgF.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        final x xVar = (x) a.this.getItem(((Integer) view.getTag()).intValue());
                        h.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(R.l.eFp, new Object[]{a.this.c(xVar)}), null, DelChatroomMemberUI.this.getString(R.l.eFw), DelChatroomMemberUI.this.getString(R.l.dEy), true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                DelChatroomMemberUI.a(DelChatroomMemberUI.this, xVar.field_username);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                });
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.lgF.setTag(Integer.valueOf(i));
            x xVar = (x) getItem(i);
            CharSequence c = c(xVar);
            bVar.kHt.setText(c);
            i.b(DelChatroomMemberUI.this, c, bVar.kHt.getTextSize());
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ikK, xVar.field_username);
            return view;
        }

        public final String c(x xVar) {
            String b;
            if (bi.oN(xVar.field_conRemark)) {
                b = DelChatroomMemberUI.b(DelChatroomMemberUI.this, xVar.field_username);
            } else {
                b = xVar.field_conRemark;
            }
            if (bi.oN(b)) {
                b = xVar.field_conRemark;
            }
            if (bi.oN(b)) {
                return xVar.AW();
            }
            return b;
        }
    }

    class b {
        public ImageView ikK;
        public TextView kHt;
        public TextView lgF;

        b() {
        }
    }

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            final k gVar = new g(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
            delChatroomMemberUI.getString(R.l.dGZ);
            delChatroomMemberUI.tipDialog = h.a((Context) delChatroomMemberUI, delChatroomMemberUI.getString(R.l.eFl), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(gVar);
                }
            });
            as.CN().a(gVar, 0);
        }
    }

    static /* synthetic */ String b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        return delChatroomMemberUI.lfE == null ? null : delChatroomMemberUI.lfE.gw(str);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        as.CN().a(179, (e) this);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.lgz.add(split[i]);
            i++;
        }
        as.Hm();
        this.lfE = c.Fo().hG(this.chatroomName);
        initView();
    }

    public void onDestroy() {
        as.CN().b(179, (e) this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    protected final void initView() {
        setMMTitle(R.l.eFz);
        this.Fv = (ListView) findViewById(R.h.cvR);
        this.lgy = new a();
        a aVar = this.lgy;
        List<String> list = this.lgz;
        if (list != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", Integer.valueOf(list.size()));
            aVar.lgB.clear();
            for (String str : list) {
                as.Hm();
                ag Xv = c.Ff().Xv(str);
                if (!(Xv == null || bi.oN(Xv.field_username) || !Xv.field_username.equals(str))) {
                    aVar.lgB.add(Xv);
                }
            }
        }
        this.Fv.setAdapter(this.lgy);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                DelChatroomMemberUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dcX;
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(R.l.eFx));
                this.lgy.au(((g) kVar).fBI);
                this.Fv.post(new Runnable() {
                    public final void run() {
                        if (DelChatroomMemberUI.this.lgy.getCount() == 0) {
                            DelChatroomMemberUI.this.finish();
                        }
                    }
                });
            }
        } else if (i2 == -2024) {
            com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
            if (eC != null) {
                eC.a(this, null, null);
            } else {
                h.a(this.mController.xRr, getString(R.l.eFu), null, getString(R.l.eFv), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else {
            h.a((Context) this, getString(R.l.eFD), null, getString(R.l.dGf), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
