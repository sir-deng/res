package com.tencent.mm.plugin.traceroute.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.c;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.q;

public class NetworkDiagnoseUI extends MMActivity {
    private ag handler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
                    if (NetworkDiagnoseUI.this.slR < 95) {
                        NetworkDiagnoseUI.this.slT.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.slS.bGe();
                    return;
                case 2:
                    if (NetworkDiagnoseUI.this.slR < 95) {
                        NetworkDiagnoseUI.this.slT.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.slS.bGe();
                    return;
                case 3:
                    NetworkDiagnoseUI.this.slT.setProgress(100);
                    NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, false);
                    return;
                case 4:
                    NetworkDiagnoseUI.this.slT.setProgress(100);
                    NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, true);
                    return;
                default:
                    return;
            }
        }
    };
    private TextView muJ;
    private int oGs = 0;
    private final int slQ = 100;
    private int slR = 0;
    private a slS;
    private MMProgressBar slT;
    private al slU = new al(new al.a() {
        public final boolean uG() {
            NetworkDiagnoseUI.this.slR = NetworkDiagnoseUI.this.oGs + 1;
            NetworkDiagnoseUI.this.oGs = NetworkDiagnoseUI.this.slR;
            if (NetworkDiagnoseUI.this.slR < 100) {
                NetworkDiagnoseUI.this.slT.setProgress(NetworkDiagnoseUI.this.slR);
                return true;
            }
            NetworkDiagnoseUI.this.slT.setProgress(100);
            return false;
        }
    }, true);

    static /* synthetic */ void a(NetworkDiagnoseUI networkDiagnoseUI, boolean z) {
        Intent intent = new Intent(networkDiagnoseUI, NetworkDiagnoseReportUI.class);
        intent.putExtra("diagnose_result", z);
        if (!z) {
            intent.putExtra("diagnose_log_file_path", a.skU);
        }
        networkDiagnoseUI.startActivity(intent);
        networkDiagnoseUI.finish();
    }

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        networkDiagnoseUI.slU.TN();
        if (networkDiagnoseUI.slS != null) {
            networkDiagnoseUI.slS.stop();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.muJ = (TextView) findViewById(R.h.cHP);
        this.slT = (MMProgressBar) findViewById(R.h.cbC);
        this.slT.ykS = new MMProgressBar.a() {
            public final void yH(int i) {
                if (i < 5) {
                    NetworkDiagnoseUI.this.muJ.setText(NetworkDiagnoseUI.this.getString(R.l.dUB));
                } else if (i < 5 || i >= 95) {
                    NetworkDiagnoseUI.this.muJ.setText(NetworkDiagnoseUI.this.getString(R.l.eSA));
                } else {
                    NetworkDiagnoseUI.this.muJ.setText(NetworkDiagnoseUI.this.getString(R.l.enO));
                }
            }
        };
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NetworkDiagnoseUI.this.bGj();
                return true;
            }
        });
        new ag().postDelayed(new Runnable() {
            public final void run() {
                as.CN().a(new be(new be.a() {
                    public final void a(e eVar) {
                        if (eVar != null) {
                            NetworkDiagnoseUI.this.slS = new a(q.FY());
                            NetworkDiagnoseUI.this.slS.b(eVar.getIPsString(true), true);
                            NetworkDiagnoseUI.this.slS.b(eVar.getIPsString(false), false);
                            NetworkDiagnoseUI.this.slS.slb = new d() {
                                public final void bGh() {
                                    NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(2, 500);
                                }
                            };
                            NetworkDiagnoseUI.this.slS.sla = new a.e() {
                                public final void bGi() {
                                    NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(1, 500);
                                }
                            };
                            NetworkDiagnoseUI.this.slS.sld = new b() {
                                public final void bGf() {
                                    NetworkDiagnoseUI.this.handler.sendEmptyMessage(3);
                                }
                            };
                            NetworkDiagnoseUI.this.slS.slc = new c() {
                                public final void bGg() {
                                    NetworkDiagnoseUI.this.handler.sendEmptyMessage(4);
                                }
                            };
                            a d = NetworkDiagnoseUI.this.slS;
                            if (d.skZ == null || d.skZ.size() == 0) {
                                x.e("MicroMsg.MMTraceRoute", "no iplist");
                            } else {
                                if (a.skV == null) {
                                    a.skV = new com.tencent.mm.plugin.traceroute.b.c();
                                }
                                com.tencent.mm.sdk.f.e.post(new j(d, (byte) 0), "MMTraceRoute_start");
                            }
                            NetworkDiagnoseUI.this.slU.K(1200, 1200);
                        }
                    }
                }), 0);
            }
        }, 200);
    }

    protected final int getLayoutId() {
        return R.i.dpb;
    }

    protected void onPause() {
        this.slT.ms(false);
        super.onPause();
    }

    protected void onResume() {
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            this.slT.ms(true);
            super.onResume();
            return;
        }
        u.fJ(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bGj();
        return true;
    }

    private void bGj() {
        h.a((Context) this, R.l.dUf, R.l.dYL, R.l.dHo, R.l.dGc, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
                NetworkDiagnoseUI.this.finish();
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
