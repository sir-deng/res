package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.support.v4.view.z;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.collect.b.q;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI extends WalletBaseUI {
    private int asN = 20;
    private Dialog ion;
    private View lap;
    private int loM = 0;
    private ListView lqY;
    private b lqZ;
    private LinearLayout lra;
    private CollectPullDownView lrb;
    private TextView lrc;
    private Dialog lrd;
    private boolean lre = false;
    private boolean lrf = false;
    private boolean lrg = false;
    private boolean lrh = false;
    private boolean lri = false;
    private boolean lrj = false;
    private boolean lrk = true;
    private boolean lrl = false;
    private boolean lrm = false;
    private long lrn = 0;
    private long lro = 0;
    private Calendar lrp;
    private List<h> lrq = new ArrayList();
    private int retryCount = 0;
    private int type = 0;

    static /* synthetic */ void a(CollectBillListUI collectBillListUI) {
        if (collectBillListUI.lrd == null) {
            collectBillListUI.lrd = new c(collectBillListUI);
            final View datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.ltp = collectBillListUI.type;
            datePickerDialogView.aAh();
            collectBillListUI.lrd.setContentView(datePickerDialogView);
            datePickerDialogView.ltn.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    long timeInMillis;
                    if (CollectBillListUI.this.lrp == null) {
                        CollectBillListUI.this.lrp = Calendar.getInstance();
                    }
                    CollectBillListUI.this.lrp.clear();
                    int year = datePickerDialogView.ltm.getYear();
                    int month = datePickerDialogView.ltm.getMonth();
                    int dayOfMonth = datePickerDialogView.ltm.getDayOfMonth();
                    CollectBillListUI.this.type = datePickerDialogView.ltm.zDV;
                    if (CollectBillListUI.this.type == 2) {
                        CollectBillListUI.this.lrp.set(1, year);
                        timeInMillis = CollectBillListUI.this.lrp.getTimeInMillis() / 1000;
                    } else if (CollectBillListUI.this.type == 1) {
                        CollectBillListUI.this.lrp.set(1, year);
                        CollectBillListUI.this.lrp.set(2, month);
                        timeInMillis = CollectBillListUI.this.lrp.getTimeInMillis() / 1000;
                    } else {
                        CollectBillListUI.this.lrp.set(year, month, dayOfMonth);
                        timeInMillis = CollectBillListUI.this.lrp.getTimeInMillis() / 1000;
                    }
                    x.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(CollectBillListUI.this.type), Long.valueOf(timeInMillis));
                    CollectBillListUI.a(CollectBillListUI.this, timeInMillis);
                    CollectBillListUI.this.lrd.dismiss();
                }
            });
            datePickerDialogView.lto.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    CollectBillListUI.this.lrd.dismiss();
                }
            });
            if (VERSION.SDK_INT >= 21) {
                collectBillListUI.lrd.getWindow().addFlags(Integer.MIN_VALUE);
            }
            final BottomSheetBehavior i = BottomSheetBehavior.i((View) datePickerDialogView.getParent());
            i.fj = false;
            if (3 != i.mState) {
                if (i.fq == null) {
                    i.mState = 3;
                } else {
                    View view = (View) i.fq.get();
                    if (view != null) {
                        int i2 = i.fh;
                        i.r(2);
                        if (i.fk.e(view, view.getLeft(), i2)) {
                            z.a(view, new b(view, 3));
                        }
                    }
                }
            }
            ah.h(new Runnable() {
                public final void run() {
                    x.d("MicroMsg.CollectBillListUI", "view height: %d", Integer.valueOf(datePickerDialogView.getHeight()));
                    i.q(datePickerDialogView.getHeight());
                }
            }, 300);
        }
        collectBillListUI.lrd.show();
    }

    static /* synthetic */ void a(CollectBillListUI collectBillListUI, long j) {
        x.i("MicroMsg.CollectBillListUI", "get filter page, type: %d, timestamp: %s", Integer.valueOf(collectBillListUI.type), Long.valueOf(j));
        collectBillListUI.lrf = false;
        collectBillListUI.azO();
        collectBillListUI.zSi.aXI();
        collectBillListUI.lrg = false;
        collectBillListUI.lrh = false;
        collectBillListUI.r(new q(collectBillListUI.type, j, collectBillListUI.asN, 1));
        collectBillListUI.lri = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setMMTitle(i.uOT);
        if (this.lrm) {
            addIconOptionMenu(0, a.h.uMS, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    CollectBillListUI.a(CollectBillListUI.this);
                    return false;
                }
            });
        }
        this.ion = g.a(this, false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        azQ();
        com.tencent.mm.plugin.report.service.g.pWK.h(13944, Integer.valueOf(4));
    }

    protected final void initView() {
        this.lqY = (ListView) findViewById(f.uoH);
        this.lra = (LinearLayout) findViewById(f.uoF);
        this.lrc = (TextView) findViewById(f.uoG);
        this.lap = v.fw(this).inflate(a.g.uHW, this.lqY, false);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(this, 5)));
        this.lqY.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(this, 10)));
        this.lqY.addFooterView(view, null, true);
        this.lqY.setOverScrollMode(2);
        this.lqZ = new b(this);
        this.lqY.setAdapter(this.lqZ);
        this.lqY.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.CollectBillListUI", "click item: %d", Integer.valueOf(i));
                if (i >= 0 && i < adapterView.getAdapter().getCount()) {
                    Intent intent = new Intent(CollectBillListUI.this.mController.xRr, CollectBillUI.class);
                    h hVar = (h) adapterView.getItemAtPosition(i);
                    if (hVar == null) {
                        x.w("MicroMsg.CollectBillListUI", "invaild record: %d", Integer.valueOf(i));
                        return;
                    }
                    intent.putExtra("key_type", hVar.type);
                    intent.putExtra("key_timestamp", hVar.lom);
                    intent.putExtra("key_from_scene", 2);
                    CollectBillListUI.this.startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13944, Integer.valueOf(3));
                }
            }
        });
        this.lqY.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.lrb = (CollectPullDownView) findViewById(f.uoJ);
        this.lrb.mw(false);
        this.lrb.mt(false);
        this.lrb.mv(true);
        this.lrb.mu(false);
        this.lrb.ylo = true;
        this.lrb.ylh = new d() {
            public final boolean azS() {
                int firstVisiblePosition = CollectBillListUI.this.lqY.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = CollectBillListUI.this.lqY.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getX() == 0.0f) {
                        return true;
                    }
                }
                return false;
            }
        };
        this.lrb.ylg = new MMPullDownView.c() {
            public final boolean azT() {
                if (CollectBillListUI.this.lra.getVisibility() == 0) {
                    x.d("MicroMsg.CollectBillListUI", "empty view");
                    return true;
                }
                View childAt = CollectBillListUI.this.lqY.getChildAt(CollectBillListUI.this.lqY.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > CollectBillListUI.this.lqY.getHeight() || CollectBillListUI.this.lqY.getLastVisiblePosition() != CollectBillListUI.this.lqY.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.lrb.ykU = new MMPullDownView.g() {
            public final boolean azU() {
                x.d("MicroMsg.CollectBillListUI", "top load");
                return true;
            }
        };
        this.lrb.ykV = new e() {
            public final boolean azR() {
                x.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", Boolean.valueOf(CollectBillListUI.this.lrg), Boolean.valueOf(CollectBillListUI.this.lrj));
                if (CollectBillListUI.this.lrg || CollectBillListUI.this.lrj) {
                    return true;
                }
                CollectBillListUI.this.lrb.mv(true);
                CollectBillListUI.this.azQ();
                return false;
            }
        };
    }

    protected final int getLayoutId() {
        return a.g.uHU;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof q)) {
            return false;
        }
        q qVar = (q) kVar;
        if (this.ion.isShowing()) {
            this.ion.dismiss();
        }
        this.lrb.ylc = true;
        if (i == 0 && i2 == 0) {
            b bVar;
            if (qVar.loM != 0) {
                this.lrj = qVar.hjU;
                if (qVar.loL) {
                    if (!qVar.loQ.isEmpty()) {
                        this.lrq.addAll(qVar.loQ);
                    }
                    if (qVar.loO != 0 || qVar.loP <= 0) {
                        this.retryCount = 0;
                        this.lrk = true;
                        this.lro = qVar.lom;
                        if (qVar.loO == 0) {
                            this.lrj = false;
                        } else {
                            this.lrj = true;
                        }
                        if (this.lrq.size() > 0) {
                            this.lqZ.az(this.lrq);
                        } else {
                            x.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                            azP();
                            if (!bi.oN(qVar.jgc)) {
                                this.lrc.setText(qVar.jgc);
                                this.lrc.setVisibility(0);
                            }
                            bVar = this.lqZ;
                            bVar.lqU.clear();
                            bVar.notifyDataSetChanged();
                        }
                    } else {
                        x.i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                        a(qVar.loP, qVar.lom, qVar.loN, qVar.loM);
                    }
                    return true;
                }
                if (!qVar.loQ.isEmpty()) {
                    this.lqZ.az(qVar.loQ);
                    this.lrn = ((h) qVar.loQ.get(0)).lom;
                    this.lro = ((h) qVar.loQ.get(qVar.loQ.size() - 1)).lom;
                } else if (qVar.loO != 0 || qVar.loP <= 0) {
                    azP();
                } else {
                    x.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(qVar.loP), Long.valueOf(qVar.lom));
                    a(qVar.loP, qVar.lom, qVar.loN, qVar.loM);
                    this.lrq.clear();
                }
                this.lri = false;
                this.lrk = false;
            } else if (this.lri) {
                x.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                return true;
            } else if (qVar.loN == 1) {
                this.lrk = qVar.hjU;
                if (qVar.loQ.isEmpty()) {
                    this.lrk = true;
                } else {
                    bVar = this.lqZ;
                    bVar.lqU.addAll(0, qVar.loQ);
                    bVar.notifyDataSetChanged();
                    this.lrn = ((h) qVar.loQ.get(0)).lom;
                }
                this.lrh = false;
                this.lrf = false;
            } else {
                this.lrj = qVar.hjU;
                this.lqY.setVisibility(0);
                this.lra.setVisibility(8);
                if (qVar.loL) {
                    if (!qVar.loQ.isEmpty()) {
                        this.lrq.addAll(qVar.loQ);
                    }
                    if (qVar.loO == 0 && qVar.loP > 0 && qVar.loQ.isEmpty()) {
                        x.i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                        a(qVar.loP, qVar.lom, qVar.loN, qVar.loM);
                    } else {
                        this.retryCount = 0;
                        if (this.lrq.size() > 0) {
                            this.lqZ.aA(this.lrq);
                        } else {
                            x.i("MicroMsg.CollectBillListUI", "retry data is empty");
                            xZ(qVar.jgc);
                        }
                        this.lrg = false;
                        this.lro = qVar.lom;
                        azO();
                        er(this.lrj);
                    }
                    return true;
                } else if (!qVar.loQ.isEmpty()) {
                    this.lqZ.aA(qVar.loQ);
                    this.lro = ((h) qVar.loQ.get(qVar.loQ.size() - 1)).lom;
                    if (this.lro > qVar.lom) {
                        x.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                        this.lro = qVar.lom;
                    } else {
                        x.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", Long.valueOf(this.lro), Long.valueOf(qVar.lom));
                    }
                    this.lrg = false;
                    azO();
                    er(this.lrj);
                } else if (qVar.loO != 0 || qVar.loP <= 0) {
                    this.lrg = false;
                    azO();
                    x.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                    xZ(qVar.jgc);
                    er(this.lrj);
                } else {
                    x.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(qVar.loP), Long.valueOf(qVar.lom));
                    a(qVar.loP, qVar.lom, qVar.loN, qVar.loM);
                    this.lrq.clear();
                }
            }
            return true;
        }
        x.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(qVar.loM), Integer.valueOf(qVar.loN));
        if (qVar.loM != 0) {
            this.lri = false;
        } else if (qVar.loN == 0) {
            this.lrg = false;
            azO();
        } else {
            this.lrh = false;
        }
        if (this.lqZ.isEmpty()) {
            azP();
        }
        Toast.makeText(this, i.uOQ, 1).show();
        return true;
    }

    private void azO() {
        this.lrb.scrollTo(0, this.lrb.ykW);
    }

    private void azP() {
        this.lqY.setVisibility(8);
        this.lra.setVisibility(0);
        this.lrc.setVisibility(0);
    }

    private void xZ(String str) {
        if (this.lqZ.getCount() == 0) {
            x.i("MicroMsg.CollectBillListUI", "show empty view");
            if (!bi.oN(str)) {
                this.lrc.setText(str);
            } else if (this.lrj) {
                this.lrc.setText(getString(i.uOR));
            } else {
                this.lrc.setText(getString(i.uOR) + getString(i.uOS));
            }
            azP();
        } else if (!bi.oN(str)) {
            Toast.makeText(this.mController.xRr, str, 1).show();
        }
    }

    private void er(boolean z) {
        this.lrb.mv(!z);
    }

    private void azQ() {
        int count = this.lqZ.getCount();
        if (count > 0) {
            long j = this.lqZ.oJ(count - 1).lom;
            if (j < this.lro) {
                x.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", Long.valueOf(j), Long.valueOf(this.lro));
                this.lro = j;
            }
        }
        x.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", Integer.valueOf(this.type), Long.valueOf(this.lro));
        b(new q(this.type, this.lro, this.asN, 0), false);
        this.lrg = true;
    }

    private void a(int i, long j, int i2, int i3) {
        x.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", Integer.valueOf(this.type), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        b(new q(this.type, j, i2, this.asN, i3, i), false);
        this.retryCount++;
    }
}
