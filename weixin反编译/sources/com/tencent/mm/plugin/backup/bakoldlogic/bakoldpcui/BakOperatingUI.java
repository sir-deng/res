package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public class BakOperatingUI extends MMWizardActivity implements d {
    private ag handler = new ag(Looper.getMainLooper());
    private boolean kxA = false;
    private ProgressBar kxB = null;
    private TextView kxC = null;
    private TextView kxD = null;
    private TextView kxE = null;
    private boolean kxF = false;
    private int kxG = 0;
    private boolean kxH = false;
    private int kxw = -1;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", Integer.valueOf(this.kxw));
            return;
        }
        a.aqS().aqT().a((d) this);
        a.aqS().aqT().dQ(true);
        this.kxF = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.kxF) {
            int i = a.aqS().aqT().kwP;
            if (2 == i || a.aqS().aqT().kwO == 2) {
                this.kxw = 1;
                this.kxG = a.aqS().aqT().ard();
            } else if (4 == i) {
                this.kxw = 6;
                this.kxG = a.aqS().aqT().ard();
            } else if (5 == i) {
                this.kxw = 6;
                this.kxA = true;
                com.tencent.mm.plugin.backup.a.ihN.uq();
                a.aqS().aqT().apj();
            }
        } else {
            this.kxw = getIntent().getIntExtra("cmd", 6);
        }
        if (this.kxw == 6 && a.aqS().aqT().kwI.kwZ) {
            this.kxA = true;
            com.tencent.mm.plugin.backup.a.ihN.uq();
            a.aqS().aqT().apj();
        }
        x.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", Integer.valueOf(this.kxw), Boolean.valueOf(this.kxF), Integer.valueOf(a.aqS().aqT().kwP), Integer.valueOf(this.kxG));
        initView();
        if (a.aqS().aqT().kwO == 2) {
            this.kxD.setText(getString(R.l.dKu));
            this.kxC.setText(getString(R.l.dKl) + this.kxG + "%");
            this.kxE.setText(getString(R.l.dKt));
        } else if (6 == this.kxw) {
            if (this.kxA) {
                this.kxD.setText(getString(R.l.dKs));
                this.kxE.setText(getString(R.l.dKr));
                this.kxC.setText(getString(R.l.dKk) + this.kxG + "%");
                return;
            }
            this.kxD.setText(getString(R.l.dKv));
            this.kxC.setText(getString(R.l.dKm) + this.kxG + "%");
            this.kxE.setText(getString(R.l.dKt));
        } else if (1 == this.kxw) {
            this.kxD.setText(getString(R.l.dKq));
            this.kxC.setText(getString(R.l.dKj) + this.kxG + "%");
            this.kxE.setText(getString(R.l.dKt));
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKx);
        if (!this.kxA) {
            if (6 == this.kxw) {
                addTextOptionMenu(0, getString(R.l.dKn), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (!BakOperatingUI.this.kxA) {
                            BakOperatingUI.this.kxH = true;
                            BakOperatingUI.this.En(1);
                        }
                        return true;
                    }
                });
            } else if (1 == this.kxw) {
                addTextOptionMenu(0, getString(R.l.dKc), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (!BakOperatingUI.this.kxA) {
                            BakOperatingUI.this.kxH = true;
                            BakOperatingUI.this.En(1);
                        }
                        return true;
                    }
                });
            } else {
                x.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (BakOperatingUI.this.kxA) {
                    BakOperatingUI.this.arn();
                    return false;
                }
                BakOperatingUI.this.kxH = true;
                BakOperatingUI.this.En(1);
                return true;
            }
        });
        this.kxB = (ProgressBar) findViewById(R.h.bMs);
        this.kxB.setProgress(this.kxG);
        this.kxD = (TextView) findViewById(R.h.bMx);
        this.kxE = (TextView) findViewById(R.h.bMy);
        this.kxC = (TextView) findViewById(R.h.bMt);
    }

    protected final int getLayoutId() {
        return R.i.dbc;
    }

    private void arn() {
        a.aqS().aqT().pause();
        i a = h.a((Context) this, R.l.dKo, 0, R.l.dHo, R.l.dGc, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                e aqT = a.aqS().aqT();
                aqT.kwH.cancel();
                aqT.kwI.cancel();
                if (aqT.kwL == 1 || aqT.kwP == 2) {
                    e.nk(4);
                } else if (aqT.kwL == 6 || aqT.kwP == 4 || aqT.kwP == 6) {
                    e.nk(7);
                }
                a.aqS().aqT().kwO = -1;
                c aqU = a.aqS().aqU();
                aqU.kwt++;
                BakOperatingUI.this.kxH = true;
                BakOperatingUI.this.En(1);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                e aqT = a.aqS().aqT();
                if (aqT.kwL == 1) {
                    aqT.kwH.resume();
                } else if (aqT.kwL == 6) {
                    aqT.kwI.resume();
                } else {
                    x.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", Integer.valueOf(aqT.kwL));
                }
            }
        });
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
    }

    public void onDestroy() {
        super.onDestroy();
        a.aqS().aqT().a(null);
        a.aqS().aqT().dQ(false);
        x.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", Integer.valueOf(this.kxw));
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        a.aqS().aqT().dQ(true);
        a.aqS().aqT().a((d) this);
        x.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", Integer.valueOf(this.kxw));
        super.onResume();
    }

    protected void onPause() {
        a.aqS().aqT().dQ(false);
        super.onPause();
        x.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", Integer.valueOf(this.kxw));
    }

    public final synchronized void no(final int i) {
        x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", Integer.valueOf(i), Boolean.valueOf(this.kxH));
        if (!this.kxH) {
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BakOperatingUI.this.kxB != null) {
                        BakOperatingUI.this.kxB.setProgress(i);
                    }
                    if (BakOperatingUI.this.kxC != null) {
                        int i = R.l.dKj;
                        int i2 = R.l.dKq;
                        if (6 == BakOperatingUI.this.kxw) {
                            i = R.l.dKm;
                            i2 = R.l.dKv;
                        }
                        BakOperatingUI.this.kxC.setText(BakOperatingUI.this.getString(i) + i + "%");
                        BakOperatingUI.this.kxD.setText(BakOperatingUI.this.getString(i2));
                    }
                }
            });
        }
    }

    public final synchronized void np(final int i) {
        if (!this.kxH) {
            x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", Integer.valueOf(i));
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BakOperatingUI.this.kxB != null) {
                        BakOperatingUI.this.kxB.setProgress(i);
                    }
                    if (BakOperatingUI.this.kxC != null && BakOperatingUI.this.kxD != null) {
                        BakOperatingUI.this.kxC.setText(BakOperatingUI.this.getString(R.l.dKk) + i + "%");
                        BakOperatingUI.this.kxD.setText(BakOperatingUI.this.getString(R.l.dKs));
                    }
                }
            });
        }
    }

    public final synchronized void arg() {
        x.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.kxw));
        if (!this.kxH) {
            if (6 == this.kxw || 5 == a.aqS().aqT().kwP) {
                this.kxw = 6;
                this.kxA = true;
                com.tencent.mm.plugin.backup.a.ihN.uq();
                a.aqS().aqT().apj();
            } else {
                x.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.kxw));
            }
            this.handler.post(new Runnable() {
                public final void run() {
                    if (6 == BakOperatingUI.this.kxw) {
                        BakOperatingUI.this.handler.post(new Runnable() {
                            public final void run() {
                                BakOperatingUI.this.showOptionMenu(false);
                                if (BakOperatingUI.this.kxB != null) {
                                    BakOperatingUI.this.kxB.setProgress(0);
                                }
                                if (BakOperatingUI.this.kxD != null) {
                                    BakOperatingUI.this.kxD.setText(BakOperatingUI.this.getString(R.l.dKs));
                                }
                                if (BakOperatingUI.this.kxE != null) {
                                    BakOperatingUI.this.kxE.setText(BakOperatingUI.this.getString(R.l.dKr));
                                }
                                if (BakOperatingUI.this.kxC != null) {
                                    BakOperatingUI.this.kxC.setText(BakOperatingUI.this.getString(R.l.dKk) + "0%");
                                }
                            }
                        });
                    } else if (1 == BakOperatingUI.this.kxw) {
                        Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                        intent.putExtra("cmd", BakOperatingUI.this.kxw);
                        MMWizardActivity.A(BakOperatingUI.this, intent);
                    }
                }
            });
        }
    }

    public final synchronized void aoR() {
        if (!this.kxH) {
            this.kxA = false;
            x.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", Integer.valueOf(this.kxw));
            this.handler.post(new Runnable() {
                public final void run() {
                    Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                    intent.putExtra("cmd", BakOperatingUI.this.kxw);
                    MMWizardActivity.A(BakOperatingUI.this, intent);
                }
            });
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
            } else if (this.kxA) {
                arn();
                a.aqS().aqT().pause();
            } else {
                x.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", Integer.valueOf(this.kxw));
                this.kxH = true;
                a.aqS().aqT().dQ(false);
                En(1);
            }
        }
        return z;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", Integer.valueOf(i));
                if (i == 15) {
                    BakOperatingUI.this.En(1);
                    return;
                }
                MMWizardActivity.A(BakOperatingUI.this, new Intent(BakOperatingUI.this, BakConnErrorUI.class));
            }
        });
    }

    public final void arh() {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
                BakOperatingUI.this.En(1);
            }
        });
    }
}
