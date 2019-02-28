package com.tencent.mm.ui.bindmobile;

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
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.a.f;
import com.tencent.mm.y.a.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.List;

public class MobileFriendUI extends MMActivity implements e {
    private TextView emptyTipTv = null;
    private ListView inF;
    private View inH;
    private ProgressDialog inI = null;
    String inJ;
    private TextView xWD = null;
    a yvk;
    private aa yvl;

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        if (m.NT() != a.SUCC && m.NT() != a.SUCC_UNLOAD) {
            mobileFriendUI.inH.setVisibility(0);
            mobileFriendUI.inH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    MMWizardActivity.A(MobileFriendUI.this, new Intent(MobileFriendUI.this, BindMContactIntroUI.class));
                }
            });
            mobileFriendUI.inF.setVisibility(8);
            mobileFriendUI.emptyTipTv.setVisibility(8);
        } else if (mobileFriendUI.yvk.getCount() <= 0) {
            mobileFriendUI.emptyTipTv.setVisibility(0);
            mobileFriendUI.inF.setVisibility(8);
            mobileFriendUI.inH.setVisibility(8);
        } else {
            mobileFriendUI.emptyTipTv.setVisibility(8);
            mobileFriendUI.inF.setVisibility(0);
            mobileFriendUI.inH.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.evz);
        af.OJ().hiZ.fD("qqlist", "update addr_upload2 set reserved4=0");
        as.CN().a(32, (e) this);
        as.CN().a((int) d.CTRL_INDEX, (e) this);
        initView();
        x.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)));
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            bfD();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    bfD();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MobileFriendUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            MobileFriendUI.this.finish();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MobileFriendUI.this.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    private void bfD() {
        if (!m.NS()) {
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.evy), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (MobileFriendUI.this.yvl != null) {
                        as.CN().c(MobileFriendUI.this.yvl);
                    }
                }
            });
            if (this.yvk.getCount() != 0) {
                List Oa = m.Oa();
                List NZ = m.NZ();
                if (Oa.size() == 0 && NZ.size() == 0) {
                    as.CN().a(new v(), 0);
                    return;
                }
                this.yvl = new aa(m.Oa(), m.NZ());
                as.CN().a(this.yvl, 0);
            } else if (!com.tencent.mm.modelfriend.a.a(new b() {
                public final void bO(boolean z) {
                    x.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
                    if (z) {
                        System.currentTimeMillis();
                        as.CN().a(new aa(m.Oa(), m.NZ()), 0);
                    } else if (MobileFriendUI.this.inI != null) {
                        MobileFriendUI.this.inI.dismiss();
                        MobileFriendUI.this.inI = null;
                    }
                }
            }) && this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.yvk.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        f.im("2");
        as.CN().b(32, (e) this);
        as.CN().b((int) d.CTRL_INDEX, (e) this);
        this.yvk.aUU();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.doq;
    }

    protected final void initView() {
        boolean z;
        this.emptyTipTv = (TextView) findViewById(R.h.cwD);
        this.emptyTipTv.setText(R.l.evw);
        this.xWD = (TextView) findViewById(R.h.cen);
        this.xWD.setText(R.l.evB);
        this.inH = findViewById(R.h.cwG);
        this.inF = (ListView) findViewById(R.h.cwF);
        p pVar = new p(true, true);
        pVar.zvw = new p.b() {
            public final boolean pc(String str) {
                return false;
            }

            public final void pd(String str) {
                MobileFriendUI.this.inJ = bi.oL(str);
                MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                if (mobileFriendUI.yvk != null) {
                    mobileFriendUI.yvk.Ds(mobileFriendUI.inJ);
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
        if (g.Ip().ih("2") != null) {
            String str = g.Ip().ih("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            f.il("2");
        } else {
            z = true;
        }
        x.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", Boolean.valueOf(z));
        if (z) {
            this.yvk = new c(this, new o.a() {
                public final void XF() {
                }

                public final void XE() {
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    MobileFriendUI.this.yvk.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                }
            });
        } else {
            this.yvk = new b(this, new o.a() {
                public final void XF() {
                }

                public final void XE() {
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    MobileFriendUI.this.yvk.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                }
            });
        }
        this.inF.setAdapter(this.yvk);
        this.inF.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= MobileFriendUI.this.inF.getHeaderViewsCount()) {
                    com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) MobileFriendUI.this.yvk.getItem(i - MobileFriendUI.this.inF.getHeaderViewsCount());
                    if (bVar.status == 1 || bVar.status == 2) {
                        MobileFriendUI.this.b(bVar);
                    }
                    if (bVar.status == 0) {
                        Intent intent = new Intent(MobileFriendUI.this, InviteFriendUI.class);
                        intent.putExtra("friend_type", 1);
                        intent.putExtra("friend_user_name", bVar.getUsername());
                        intent.putExtra("friend_num", bVar.NF());
                        intent.putExtra("friend_nick", bVar.Nz());
                        intent.putExtra("friend_weixin_nick", bVar.NC());
                        intent.putExtra("friend_scene", 13);
                        MobileFriendUI.this.startActivity(intent);
                    }
                }
            }
        });
        this.yvk.a(new a.a() {
            public final void Ey(int i) {
                if (i > 0) {
                    MobileFriendUI.this.xWD.setVisibility(8);
                } else {
                    MobileFriendUI.this.xWD.setVisibility(0);
                }
            }
        });
        if (!(m.NT() == a.SUCC || m.NT() == a.SUCC_UNLOAD)) {
            this.inH = findViewById(R.h.cwG);
            this.inH.setVisibility(0);
            this.inH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent(MobileFriendUI.this.mController.xRr, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 6);
                    MMWizardActivity.A(MobileFriendUI.this, intent);
                }
            });
            this.inF.setVisibility(8);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MobileFriendUI.this.aWY();
                MobileFriendUI.this.finish();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                c.a(MobileFriendUI.this.inF);
            }
        };
        if (!q.GB() || m.NS()) {
            h.a((Context) this, R.l.dKP, R.l.dGZ, R.l.dGf, R.l.dEy, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(11438, Integer.valueOf(6));
                    x.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(6));
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(12322, Boolean.valueOf(true));
                    com.tencent.mm.platformtools.m.k(true, true);
                    MobileFriendUI.this.bfD();
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(12322, Boolean.valueOf(false));
                    com.tencent.mm.platformtools.m.k(false, true);
                    MobileFriendUI.this.finish();
                }
            });
        }
    }

    public final void b(com.tencent.mm.modelfriend.b bVar) {
        if (bi.oN(bVar.getUsername())) {
            x.e("MicroMsg.MobileFriendUI", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", bVar.getUsername());
        intent.putExtra("Contact_Nick", bVar.NC());
        intent.putExtra("Contact_Mobile_MD5", bVar.Nx());
        intent.putExtra("Contact_Alias", bVar.hxj);
        intent.putExtra("Contact_Sex", bVar.hxe);
        intent.putExtra("Contact_Signature", bVar.hxh);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(bVar.hxn, bVar.hxf, bVar.hxg));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        com.tencent.mm.plugin.c.a.ihN.d(intent, (Context) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32 && this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (!(i == 0 && i2 == 0)) {
            x.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (kVar.getType() == d.CTRL_INDEX) {
            as.CN().a(new v(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 32) {
                com.tencent.mm.modelsimple.d.bs(getApplicationContext());
            }
            this.yvk.a(null, null);
        } else if (kVar.getType() == 32) {
            Toast.makeText(this, R.l.evx, 0).show();
        }
    }
}
