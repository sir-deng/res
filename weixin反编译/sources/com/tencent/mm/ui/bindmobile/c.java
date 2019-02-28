package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindmobile.a.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.q;
import java.util.LinkedList;

public final class c extends a {
    private int[] hxD;
    private String inS;
    private com.tencent.mm.ui.bindmobile.a.a yuV;
    private b yuW = new b() {
        public final void h(int i, String str, int i2) {
            x.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            final com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) c.this.getItem(i);
            if (bVar == null) {
                x.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                return;
            }
            x.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", bVar.toString());
            if (bVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(c.this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        x.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.modelfriend.b kV = af.OJ().kV(str2);
                        if (kV == null) {
                            x.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", str2);
                        } else if (z) {
                            kV.username = str;
                            kV.status = 2;
                            kV.hnf = 2;
                            x.d("MicroMsg.MobileFriendAdapter", "f :%s", kV.toString());
                            af.OJ().a(str2, kV);
                            c.this.XH();
                            bp.HY().c(26, new Object[0]);
                        }
                    }
                });
                aVar.vtw = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                    public final boolean DD(String str) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", bVar.getUsername());
                        intent.putExtra("Contact_Nick", bVar.NC());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        intent.putExtra(com.tencent.mm.ui.e.a.xML, str);
                        d.b(c.this.context, "profile", ".ui.SayHiWithSnsPermissionUI", intent, 1);
                        return true;
                    }
                };
                if (c.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) c.this.context).jCj = new com.tencent.mm.ui.MMActivity.a() {
                        public final void b(int i, int i2, Intent intent) {
                            if (i == 1 && i == -1) {
                                ((MobileFriendUI) c.this.context).b(bVar);
                            }
                        }
                    };
                }
                aVar.vtE = bVar.Nx();
                aVar.vtD = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                aVar.b(bVar.getUsername(), linkedList, false);
            }
        }
    };

    class a {
        String hPj;
        ImageView ikl;
        TextView ikq;
        TextView jQN;
        ProgressBar pzF;
        int status;
        int xfR;
        View yva;
        TextView yvg;
        TextView yvh;

        public a(View view) {
            this.yvg = (TextView) view.findViewById(R.h.cjZ);
            this.ikl = (ImageView) view.findViewById(R.h.cjY);
            this.jQN = (TextView) view.findViewById(R.h.cka);
            this.yvh = (TextView) view.findViewById(R.h.ckd);
            this.yva = view.findViewById(R.h.cjX);
            this.ikq = (TextView) view.findViewById(R.h.ckc);
            this.pzF = (ProgressBar) view.findViewById(R.h.ckb);
            this.yva.setOnClickListener(new OnClickListener(c.this) {
                public final void onClick(View view) {
                    if (c.this.yuW != null) {
                        c.this.yuW.h(a.this.xfR, a.this.hPj, a.this.status);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.ui.bindmobile.a.a aVar) {
        this.yuV = aVar;
    }

    public c(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new com.tencent.mm.modelfriend.b());
        this.xQN = aVar;
        this.context = context;
        mb(true);
    }

    public final void Ds(String str) {
        this.inS = bi.oL(str.trim());
        aUU();
        XH();
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        aUU();
        com.tencent.mm.modelfriend.c OJ = af.OJ();
        String str = this.inS;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        as.Hm();
        str = (String) com.tencent.mm.y.c.Db().get(6, null);
        Cursor a = (str == null || str.equals("")) ? OJ.hiZ.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by showhead", null, 0) : OJ.hiZ.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by showhead", null, 0);
        setCursor(a);
        this.hxD = new int[getCount()];
        if (!(this.yuV == null || this.inS == null)) {
            this.yuV.Ey(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.diP, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.xfR = i;
        aVar.hPj = bVar.Nx();
        aVar.status = bVar.status;
        aVar.jQN.setText(bVar.Nz());
        aVar.yvh.setText(this.context.getString(R.l.eky) + bVar.NC());
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ikl, bVar.getUsername());
        switch (bVar.status) {
            case 0:
                if (bVar.hnf != 2) {
                    aVar.yva.setClickable(true);
                    aVar.yva.setBackgroundResource(R.g.bAc);
                    aVar.ikq.setText(R.l.eku);
                    aVar.ikq.setTextColor(this.context.getResources().getColor(R.e.white));
                    break;
                }
                aVar.yva.setClickable(false);
                aVar.yva.setBackgroundDrawable(null);
                aVar.ikq.setText(R.l.ekv);
                aVar.ikq.setTextColor(this.context.getResources().getColor(R.e.btc));
                break;
            case 1:
            case 2:
                as.Hm();
                if (!com.tencent.mm.y.c.Ff().Xr(bVar.getUsername()) && !q.FY().equals(bVar.getUsername())) {
                    if (bVar.hnf != 2) {
                        aVar.yva.setClickable(true);
                        aVar.yva.setBackgroundResource(R.g.bAc);
                        aVar.ikq.setText(R.l.eks);
                        aVar.ikq.setTextColor(this.context.getResources().getColor(R.e.white));
                        break;
                    }
                    aVar.yva.setClickable(false);
                    aVar.yva.setBackgroundDrawable(null);
                    aVar.ikq.setText(R.l.ekx);
                    aVar.ikq.setTextColor(this.context.getResources().getColor(R.e.btc));
                    break;
                }
                aVar.yva.setClickable(false);
                aVar.yva.setBackgroundDrawable(null);
                aVar.ikq.setText(R.l.ekt);
                aVar.ikq.setTextColor(this.context.getResources().getColor(R.e.btc));
                break;
                break;
        }
        switch (bVar.hnf) {
            case 0:
            case 2:
                aVar.ikq.setVisibility(0);
                aVar.pzF.setVisibility(4);
                break;
            case 1:
                aVar.ikq.setVisibility(4);
                aVar.pzF.setVisibility(0);
                break;
        }
        com.tencent.mm.modelfriend.b bVar2 = (com.tencent.mm.modelfriend.b) getItem(i - 1);
        int i2 = bVar2 == null ? -1 : bVar2.hxc;
        if (i == 0) {
            CharSequence a = a(bVar);
            if (bi.oN(a)) {
                x.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", bVar.getUsername(), Integer.valueOf(i));
                aVar.yvg.setVisibility(8);
            } else {
                aVar.yvg.setVisibility(0);
                aVar.yvg.setText(a);
                aVar.yvg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (bVar.hxc != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence a2 = a(bVar);
            if (bi.oN(a2) || !z) {
                x.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", bVar.getUsername(), Integer.valueOf(i));
                aVar.yvg.setVisibility(8);
            } else {
                aVar.yvg.setVisibility(0);
                aVar.yvg.setText(a2);
                aVar.yvg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static com.tencent.mm.modelfriend.b a(com.tencent.mm.modelfriend.b bVar, Cursor cursor) {
        if (bVar == null) {
            bVar = new com.tencent.mm.modelfriend.b();
        }
        bVar.b(cursor);
        return bVar;
    }

    private static String a(com.tencent.mm.modelfriend.b bVar) {
        if (bVar.hxc == 123) {
            return "#";
        }
        return String.valueOf((char) bVar.hxc);
    }
}
