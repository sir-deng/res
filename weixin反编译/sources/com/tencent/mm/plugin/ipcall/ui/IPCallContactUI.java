package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.p;

public class IPCallContactUI extends MMActivity {
    private ag hbP = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (IPCallContactUI.this.nOr != null) {
                    IPCallContactUI.this.nOr.dismiss();
                }
                IPCallContactUI.this.nOt.setVisibility(0);
                IPCallContactUI.this.nOs;
                c.nMn = b.aUL();
                IPCallContactUI.this.nOs.XH();
                IPCallContactUI.this.nOs.notifyDataSetChanged();
                IPCallContactUI.this.nOc.invalidateViews();
                IPCallContactUI.this.nOv.rP(IPCallContactUI.this.nOs.getCount());
                a.aTu().Wj();
            } else if (message.what == 2) {
                if (IPCallContactUI.this.nOs.getCount() == 0) {
                    IPCallContactUI.this.nOx.setVisibility(0);
                } else {
                    IPCallContactUI.this.nOx.setVisibility(8);
                }
                if (IPCallContactUI.this.nOs.getCount() != 0 && IPCallContactUI.this.nOC) {
                    IPCallContactUI.this.nOs.notifyDataSetChanged();
                }
            }
        }
    };
    private String inJ;
    private p liK = new p(true, true);
    private com.tencent.mm.plugin.ipcall.a.a.a nOA = new com.tencent.mm.plugin.ipcall.a.a.a() {
        public final void akx() {
            IPCallContactUI.this.hbP.sendEmptyMessage(1);
        }
    };
    private Runnable nOB = new Runnable() {
        public final void run() {
            if (IPCallContactUI.this.nOs != null && IPCallContactUI.this.nOc != null && !IPCallContactUI.this.nOs.kLF) {
                IPCallContactUI.this.nOs.Ds(IPCallContactUI.this.inJ);
                IPCallContactUI.this.hbP.sendEmptyMessage(2);
                IPCallContactUI.this.nOc.invalidateViews();
            }
        }
    };
    private boolean nOC = true;
    private ListView nOc;
    private Runnable nOj = new Runnable() {
        public final void run() {
            com.tencent.mm.plugin.ipcall.a.a.aTP().a(IPCallContactUI.this.nOA, false);
        }
    };
    private ProgressDialog nOr = null;
    private c nOs;
    private RelativeLayout nOt;
    private LinearLayout nOu;
    private IPCallAddressCountView nOv = null;
    private VerticalScrollBar nOw;
    private LinearLayout nOx;
    private int nOy = -1;
    private int nOz = -1;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eqG);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallContactUI.this.finish();
                return true;
            }
        });
        x.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.nOt = (RelativeLayout) findViewById(R.h.layout);
            this.nOu = (LinearLayout) findViewById(R.h.bJr);
            this.nOc = (ListView) findViewById(R.h.bJe);
            this.nOw = (VerticalScrollBar) findViewById(R.h.bJo);
            this.nOx = (LinearLayout) findViewById(R.h.bJq);
            this.liK.zvw = new p.b() {
                public final void XB() {
                    x.d("MicroMsg.IPCallContactUI", "onEnterSearch");
                    g.pWK.h(12767, Integer.valueOf(1));
                    IPCallContactUI.this.nOu.setVisibility(0);
                    IPCallContactUI.this.nOc.setVisibility(8);
                    IPCallContactUI.this.nOv.setVisibility(8);
                    IPCallContactUI.this.gh(false);
                }

                public final void XA() {
                    x.d("MicroMsg.IPCallContactUI", "onQuitSearch");
                    IPCallContactUI.this.Ds("");
                    IPCallContactUI.this.gh(true);
                    IPCallContactUI.this.nOu.setVisibility(8);
                    IPCallContactUI.this.nOc.setVisibility(0);
                    IPCallContactUI.this.nOv.setVisibility(0);
                }

                public final void pd(String str) {
                    x.d("MicroMsg.IPCallContactUI", "onSearchChange");
                    IPCallContactUI.this.Ds(str);
                    if (!bi.oN(str)) {
                        IPCallContactUI.this.nOu.setVisibility(8);
                        IPCallContactUI.this.nOc.setVisibility(0);
                        IPCallContactUI.this.nOv.setVisibility(8);
                    }
                }

                public final boolean pc(String str) {
                    x.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
                    return false;
                }

                public final void XC() {
                    IPCallContactUI.this.nOu.setVisibility(0);
                    IPCallContactUI.this.nOc.setVisibility(8);
                    IPCallContactUI.this.nOv.setVisibility(8);
                }

                public final void XD() {
                }
            };
            this.liK.zvB = R.l.dGK;
            a(this.liK);
            this.nOs = new c(this.mController.xRr);
            c.nMn = b.aUL();
            this.nOv = new IPCallAddressCountView(this.mController.xRr, this.nOs.aUT());
            this.nOc.addFooterView(this.nOv, null, false);
            this.nOc.setAdapter(this.nOs);
            this.nOc.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!IPCallContactUI.this.nOs.rq(i)) {
                        c rO = IPCallContactUI.this.nOs.rO(i);
                        if (rO != null) {
                            if (!IPCallContactUI.this.nOC) {
                                g.pWK.h(12767, Integer.valueOf(2));
                            }
                            Intent intent = new Intent(IPCallContactUI.this.mController.xRr, IPCallUserProfileUI.class);
                            intent.putExtra("IPCallProfileUI_contactid", rO.field_contactId);
                            intent.putExtra("IPCallProfileUI_systemUsername", rO.field_systemAddressBookUsername);
                            intent.putExtra("IPCallProfileUI_wechatUsername", rO.field_wechatUsername);
                            IPCallContactUI.this.mController.xRr.startActivity(intent);
                        }
                    }
                }
            });
            this.nOw.setVisibility(0);
            this.nOc.setOnScrollListener(new OnScrollListener() {
                private int nOE = 0;

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    this.nOE = i;
                    IPCallContactUI.this.aWY();
                }

                @TargetApi(11)
                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (IPCallContactUI.this.nOy == -1) {
                        IPCallContactUI.this.nOy = i;
                    } else if (IPCallContactUI.this.nOz == -1) {
                        IPCallContactUI.this.nOz = i;
                    }
                }
            });
            this.nOw.yqj = new VerticalScrollBar.a() {
                public final void xN(String str) {
                    if ("↑".equals(str)) {
                        IPCallContactUI.this.nOc.setSelection(0);
                        return;
                    }
                    int intValue;
                    c d = IPCallContactUI.this.nOs;
                    if (d.ljE.containsKey(str)) {
                        intValue = ((Integer) d.ljE.get(str)).intValue();
                    } else {
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        IPCallContactUI.this.nOc.setSelection(intValue);
                    }
                }
            };
            if (this.nOs.aUT() <= 0) {
                this.nOt.setVisibility(8);
                Context context = this.mController.xRr;
                this.mController.xRr.getString(R.l.dGZ);
                this.nOr = h.a(context, this.mController.xRr.getString(R.l.eqU), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        IPCallContactUI.this.finish();
                    }
                });
                e.post(this.nOj, "IPCall_LoadSystemAddressBook");
                return;
            }
            a.aTu().Wj();
        }
    }

    public final void Ds(String str) {
        this.inJ = str;
        this.hbP.removeCallbacks(this.nOB);
        this.hbP.postDelayed(this.nOB, 200);
    }

    public final void gh(boolean z) {
        this.nOC = z;
        if (this.nOC) {
            this.nOs.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.dmc;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.a.a aTP = com.tencent.mm.plugin.ipcall.a.a.aTP();
        com.tencent.mm.plugin.ipcall.a.a.a aVar = this.nOA;
        if (aTP.nHS.contains(aVar)) {
            aTP.nHS.remove(aVar);
        }
        this.hbP.removeMessages(1);
    }

    protected void onResume() {
        super.onResume();
        supportInvalidateOptionsMenu();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                            IPCallContactUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
