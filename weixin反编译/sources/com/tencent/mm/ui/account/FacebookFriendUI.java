package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

@Deprecated
public class FacebookFriendUI extends MMActivity implements a, e {
    private ListView inF;
    private View inH;
    private ProgressDialog inI = null;
    String inJ;
    private boolean odb = false;
    d xWC;
    private TextView xWD = null;

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        x.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.aJ(facebookFriendUI.getString(R.l.dGZ), facebookFriendUI.getString(R.l.eey));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehC);
        as.CN().a(32, (e) this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        n.JF().d(this);
        this.xWC.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
        n.JF().e(this);
    }

    public void onDestroy() {
        as.CN().b(32, (e) this);
        this.xWC.aUU();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dif;
    }

    protected final void initView() {
        this.inF = (ListView) findViewById(R.h.cwF);
        this.xWD = (TextView) findViewById(R.h.cej);
        this.xWD.setText(R.l.eez);
        final TextView textView = (TextView) findViewById(R.h.ceo);
        textView.setText(R.l.eex);
        p pVar = new p(true, true);
        pVar.zvw = new b() {
            public final boolean pc(String str) {
                return false;
            }

            public final void pd(String str) {
                FacebookFriendUI.this.inJ = bi.oL(str);
                FacebookFriendUI facebookFriendUI = FacebookFriendUI.this;
                if (facebookFriendUI.xWC != null) {
                    facebookFriendUI.xWC.Ds(facebookFriendUI.inJ);
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
        this.xWC = new d(this, new o.a() {
            public final void XE() {
                if (q.Gz() && FacebookFriendUI.this.odb) {
                    if (FacebookFriendUI.this.xWC.getCount() == 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                FacebookFriendUI.this.odb = false;
            }

            public final void XF() {
            }
        });
        this.xWC.xWy = new d.a() {
            public final void Ey(int i) {
                if (i > 0) {
                    FacebookFriendUI.this.xWD.setVisibility(8);
                } else {
                    FacebookFriendUI.this.xWD.setVisibility(0);
                }
            }
        };
        this.inF.setAdapter(this.xWC);
        this.inH = findViewById(R.h.cwG);
        this.inF.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = (h) FacebookFriendUI.this.xWC.getItem(i - FacebookFriendUI.this.inF.getHeaderViewsCount());
                if (hVar.status == 100 || hVar.status == 101) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", hVar.getUsername());
                    intent.putExtra("Contact_Nick", hVar.NC());
                    intent.putExtra("Contact_KFacebookId", hVar.fXc);
                    intent.putExtra("Contact_KFacebookName", hVar.NL());
                    intent.putExtra("Contact_Scene", 31);
                    com.tencent.mm.plugin.c.a.ihN.d(intent, FacebookFriendUI.this);
                }
                if (hVar.status != 102) {
                }
            }
        });
        x.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + q.Gz());
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
                new h(cVar, new com.tencent.mm.z.a() {
                    public final void k(Bundle bundle) {
                        super.k(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            FacebookFriendUI.f(FacebookFriendUI.this);
                        }
                    }
                }).coJ();
            }
            final k vVar = new v();
            vVar.Ot();
            final al alVar = new al(new al.a() {
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
            addTextOptionMenu(0, getString(R.l.ehD), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class));
                    return true;
                }
            });
        } else {
            this.inF.setVisibility(8);
            this.inH.setVisibility(0);
            ((TextView) findViewById(R.h.cwH)).setText(R.l.eho);
            this.inH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, FacebookAuthUI.class));
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FacebookFriendUI.this.aWY();
                FacebookFriendUI.this.finish();
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(FacebookFriendUI.this.inF);
            }
        };
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
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
                this.xWC.a(null, null);
            } else {
                Toast.makeText(this, R.l.evx, 0).show();
            }
        }
    }

    private void aJ(String str, String str2) {
        com.tencent.mm.ui.base.h.a((Context) this, str2, str, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(FacebookFriendUI.this.mController.xRr, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                FacebookFriendUI.this.mController.xRr.startActivity(intent);
                FacebookFriendUI.this.finish();
            }
        }, null);
    }

    public final void jk(String str) {
        this.xWC.notifyDataSetChanged();
    }
}
