package com.tencent.mm.plugin.accountsync.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI extends MMActivity implements e {
    private ListView inF;
    a inG;
    private View inH;
    private ProgressDialog inI = null;
    String inJ;
    private final int inK = 5;

    public static class a extends o<h> {
        private int[] hxD;
        String inS;
        private boolean[] inT;

        public static class a {
            TextView hxK;
            ImageView ikl;
            TextView inU;
            CheckBox inV;
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            h hVar = (h) obj;
            if (hVar == null) {
                hVar = new h();
            }
            hVar.b(cursor);
            return hVar;
        }

        public a(Context context, com.tencent.mm.ui.o.a aVar) {
            super(context, new h());
            this.xQN = aVar;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            h hVar = (h) getItem(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.i.dht, null);
                aVar2.ikl = (ImageView) view.findViewById(R.h.bYA);
                aVar2.hxK = (TextView) view.findViewById(R.h.cEA);
                aVar2.inU = (TextView) view.findViewById(R.h.cqj);
                aVar2.inV = (CheckBox) view.findViewById(R.h.cqu);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hxK.setText(i.b(this.context, hVar.NL(), aVar.hxK.getTextSize()));
            Bitmap iU = b.iU(hVar.fXc);
            if (iU == null) {
                aVar.ikl.setImageDrawable(com.tencent.mm.bu.a.b(this.context, R.k.bBC));
            } else {
                aVar.ikl.setImageBitmap(iU);
            }
            aVar.inV.setChecked(this.inT[i]);
            if (af.ON().ld(Long.toString(hVar.fXc))) {
                aVar.inU.setVisibility(0);
            } else {
                aVar.inU.setVisibility(8);
            }
            return view;
        }

        public final long[] XG() {
            int i;
            int i2 = 0;
            int i3 = 0;
            for (boolean z : this.inT) {
                if (z) {
                    i3++;
                }
            }
            long[] jArr = new long[i3];
            int i4 = 0;
            while (i4 < getCount()) {
                if (this.inT[i4]) {
                    i = i2 + 1;
                    jArr[i2] = ((h) getItem(i4)).fXc;
                    i3 = i;
                } else {
                    i3 = i2;
                }
                i4++;
                i2 = i3;
            }
            return jArr;
        }

        public final void ji(int i) {
            if (i >= 0 && i < this.inT.length) {
                this.inT[i] = !this.inT[i];
                super.notifyDataSetChanged();
            }
        }

        public final void XH() {
            com.tencent.mm.modelfriend.i OK = af.OK();
            String str = this.inS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" where facebookfriend.status = 102 ");
            if (str != null && str.length() > 0) {
                stringBuilder.append(" and ( ");
                stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
            }
            setCursor(OK.hiZ.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
            this.hxD = new int[getCount()];
            this.inT = new boolean[getCount()];
            super.notifyDataSetChanged();
        }

        protected final void XI() {
            XH();
        }
    }

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.aJ(inviteFacebookFriendsUI.getString(R.l.dGZ), inviteFacebookFriendsUI.getString(R.l.eey));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eeE);
        as.CN().a(32, (e) this);
        initView();
    }

    protected void onDestroy() {
        as.CN().b(32, (e) this);
        this.inG.aUU();
        super.onDestroy();
    }

    protected final void initView() {
        this.inF = (ListView) findViewById(R.h.cwF);
        final TextView textView = (TextView) findViewById(R.h.ceo);
        textView.setText(R.l.eex);
        p pVar = new p(true, true);
        pVar.zvw = new p.b() {
            public final boolean pc(String str) {
                return false;
            }

            public final void pd(String str) {
                InviteFacebookFriendsUI.this.inJ = bi.oL(str);
                InviteFacebookFriendsUI inviteFacebookFriendsUI = InviteFacebookFriendsUI.this;
                if (inviteFacebookFriendsUI.inG != null) {
                    a aVar = inviteFacebookFriendsUI.inG;
                    aVar.inS = bi.oL(inviteFacebookFriendsUI.inJ.trim());
                    aVar.aUU();
                    aVar.XH();
                }
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
        a(pVar);
        this.inG = new a(this, new com.tencent.mm.ui.o.a() {
            public final void XE() {
                if (!q.Gz()) {
                    return;
                }
                if (InviteFacebookFriendsUI.this.inG.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }

            public final void XF() {
            }
        });
        this.inF.setAdapter(this.inG);
        this.inH = findViewById(R.h.cwG);
        this.inF.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (InviteFacebookFriendsUI.this.inG.XG().length >= 50) {
                    com.tencent.mm.ui.base.h.h(InviteFacebookFriendsUI.this, R.l.eeD, R.l.dGZ);
                    return;
                }
                InviteFacebookFriendsUI.this.inG.ji(i - InviteFacebookFriendsUI.this.inF.getHeaderViewsCount());
                if (InviteFacebookFriendsUI.this.inG.XG().length > 0) {
                    InviteFacebookFriendsUI.this.showOptionMenu(true);
                } else {
                    InviteFacebookFriendsUI.this.showOptionMenu(false);
                }
            }
        });
        x.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + q.Gz());
        if (q.Gz()) {
            this.inF.setVisibility(0);
            this.inH.setVisibility(8);
            as.Hm();
            long c = bi.c((Long) c.Db().get(65831, null));
            as.Hm();
            String oM = bi.oM((String) c.Db().get(65830, null));
            if (bi.bA(c) > 86400000 && oM.length() > 0) {
                com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
                cVar.aap(oM);
                new com.tencent.mm.ui.account.h(cVar, new com.tencent.mm.z.a() {
                    public final void k(Bundle bundle) {
                        super.k(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            InviteFacebookFriendsUI.c(InviteFacebookFriendsUI.this);
                        }
                    }
                }).coJ();
            }
            final k vVar = new v();
            vVar.Ot();
            final al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    as.Hm();
                    c.Db().set(65829, Integer.valueOf(1));
                    as.CN().a(vVar, 0);
                    return false;
                }
            }, false);
            as.Hm();
            if (bi.e((Integer) c.Db().get(65829, null)) > 0) {
                as.Hm();
                c.Db().set(65829, Integer.valueOf(1));
                as.CN().a(vVar, 0);
            } else {
                alVar.K(5000, 5000);
            }
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = com.tencent.mm.ui.base.h.a(context, getString(R.l.eBz), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    alVar.TN();
                    as.CN().c(vVar);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InviteFacebookFriendsUI.this.aWY();
                InviteFacebookFriendsUI.this.finish();
                return true;
            }
        });
        AnonymousClass9 anonymousClass9 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(InviteFacebookFriendsUI.this.inF);
            }
        };
        addTextOptionMenu(0, getString(R.l.eeB), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", InviteFacebookFriendsUI.this.getString(R.l.eeA));
                final long[] XG = InviteFacebookFriendsUI.this.inG.XG();
                String l = Long.toString(XG[0]);
                for (int i = 1; i < XG.length; i++) {
                    l = (l + ",") + Long.toString(XG[i]);
                }
                bundle.putString("to", l);
                cVar.a(InviteFacebookFriendsUI.this, "apprequests", bundle, new com.tencent.mm.ui.f.a.c.a() {
                    public final void a(d dVar) {
                        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    }

                    public final void a(com.tencent.mm.ui.f.a.b bVar) {
                        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    }

                    public final void k(Bundle bundle) {
                        x.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
                        List arrayList = new ArrayList();
                        arrayList.add(new com.tencent.mm.ax.i.a(33, Integer.toString(XG.length)));
                        as.Hm();
                        c.Fe().b(new com.tencent.mm.ax.i(arrayList));
                        for (long j : XG) {
                            com.tencent.mm.modelfriend.q qVar = new com.tencent.mm.modelfriend.q();
                            qVar.username = Long.toString(j);
                            qVar.hxY = 5;
                            qVar.hqN = (int) bi.Wx();
                            af.ON().a(qVar);
                        }
                        com.tencent.mm.ui.base.h.a(InviteFacebookFriendsUI.this, R.l.eeC, R.l.dGZ, R.l.dHo, R.l.dGc, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                InviteFacebookFriendsUI.this.inG.XH();
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                InviteFacebookFriendsUI.this.finish();
                            }
                        });
                    }

                    public final void onCancel() {
                        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
                    }
                });
                return true;
            }
        });
        showOptionMenu(false);
    }

    private void aJ(String str, String str2) {
        com.tencent.mm.ui.base.h.a((Context) this, str2, str, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(InviteFacebookFriendsUI.this.mController.xRr, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                InviteFacebookFriendsUI.this.mController.xRr.startActivity(intent);
                InviteFacebookFriendsUI.this.finish();
            }
        }, null);
    }

    protected final int getLayoutId() {
        return R.i.dif;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32) {
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            if (i == 4 && i2 == -68) {
                if (bi.oN(str)) {
                    str = "error";
                }
                aJ(getString(R.l.dGZ), str);
            } else if (i == 0 && i2 == 0) {
                this.inG.a(null, null);
            } else {
                Toast.makeText(this, R.l.evx, 0).show();
            }
        }
    }
}
