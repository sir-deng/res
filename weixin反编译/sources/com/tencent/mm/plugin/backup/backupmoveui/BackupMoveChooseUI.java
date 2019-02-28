package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.b.b.AnonymousClass3;
import com.tencent.mm.plugin.backup.b.b.AnonymousClass4;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class BackupMoveChooseUI extends MMWizardActivity implements b {
    private static int afu = 0;
    private static long endTime;
    private static int ksb = 0;
    private static long startTime;
    private a krR = new a(this);
    private ListView krS;
    private View krT;
    private TextView krU;
    private CheckBox krV;
    private TextView krW;
    private TextView krX;
    private RelativeLayout krY;
    private TextView krZ;
    private ProgressBar ksa;
    private SimpleDateFormat ksc = new SimpleDateFormat("yyyy.MM.dd");

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.c.b.apy().apC().kqn = this;
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.plugin.backup.c.b.apy().apC().kqn = null;
    }

    public final void initView() {
        setMMTitle(R.l.dJY);
        this.krS = (ListView) findViewById(R.h.bLY);
        this.krS.setAdapter(this.krR);
        this.krS.setEmptyView(findViewById(R.h.bMa));
        this.krT = findViewById(R.h.bMf);
        this.krU = (TextView) findViewById(R.h.bMh);
        this.krV = (CheckBox) findViewById(R.h.bMe);
        this.krW = (TextView) findViewById(R.h.bMg);
        this.krX = (TextView) findViewById(R.h.bLZ);
        this.ksa = (ProgressBar) findViewById(R.h.bMd);
        this.krY = (RelativeLayout) findViewById(R.h.bMc);
        this.krZ = (TextView) findViewById(R.h.bMb);
        if (!w.cfR()) {
            this.krU.setTextSize(1, 14.0f);
            this.krW.setTextSize(1, 14.0f);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BackupMoveChooseUI.this.finish();
                return false;
            }
        });
        a(0, getString(R.l.dKi), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LinkedList linkedList;
                PLong pLong = new PLong();
                PInt pInt = new PInt();
                a a = BackupMoveChooseUI.this.krR;
                LinkedList linkedList2 = new LinkedList();
                if (a.krN.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    pLong.value = 0;
                    pInt.value = 0;
                    LinkedList apu = com.tencent.mm.plugin.backup.c.b.apy().apC().apu();
                    if (apu != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= a.getCount()) {
                                break;
                            }
                            if (a.krN.contains(Integer.valueOf(i2))) {
                                linkedList2.add(apu.get(i2));
                                pLong.value += ((f.b) apu.get(i2)).koE;
                                pInt.value = (int) (((long) pInt.value) + ((f.b) apu.get(i2)).koF);
                            }
                            i = i2 + 1;
                        }
                    }
                    x.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                    linkedList = linkedList2;
                }
                LinkedList v = g.v(linkedList);
                a apC = com.tencent.mm.plugin.backup.c.b.apy().apC();
                if (linkedList.size() == 0) {
                    apC.kqr = new LinkedList();
                } else {
                    apC.kqr = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
                    apC.kqr.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
                }
                d apA = com.tencent.mm.plugin.backup.c.b.apy().apA();
                apA.krm = v;
                com.tencent.mm.plugin.backup.c.b.apy();
                if (com.tencent.mm.plugin.backup.a.d.aoX().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
                    d.krt = true;
                } else {
                    d.krt = false;
                }
                com.tencent.mm.plugin.backup.c.b.apy();
                apA.krp = com.tencent.mm.plugin.backup.a.d.aoX().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                com.tencent.mm.plugin.backup.c.b.apy();
                apA.krq = com.tencent.mm.plugin.backup.a.d.aoX().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
                com.tencent.mm.plugin.backup.c.b.apy();
                if (com.tencent.mm.plugin.backup.a.d.aoX().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
                    d.kpU = true;
                } else {
                    d.kpU = false;
                }
                x.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", Integer.valueOf(v.size()), Long.valueOf(apA.krp), Long.valueOf(apA.krq), Boolean.valueOf(d.kpU));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.valueOf(true));
                a apC2 = com.tencent.mm.plugin.backup.c.b.apy().apC();
                if (apC2.kqm != null) {
                    apC2.kqm.cancel();
                }
                e.post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
                        a.this.kqm = new com.tencent.mm.plugin.backup.b.b();
                        com.tencent.mm.plugin.backup.b.b bVar = a.this.kqm;
                        LinkedList apv = a.this.apv();
                        b bVar2 = a.this;
                        long j = b.apy().aoS().koy;
                        long Wy = bi.Wy();
                        String str = (String) com.tencent.mm.plugin.backup.g.d.aqL().aqM().Db().get(2, null);
                        int i = 0;
                        Iterator it = apv.iterator();
                        while (it.hasNext()) {
                            f.b bVar3 = (f.b) it.next();
                            if (bVar3.koE >= 0) {
                                i++;
                            } else if (!bVar.a(bVar3, str, j)) {
                                i++;
                                if (!(bVar.koR || bVar2 == null)) {
                                    ah.y(new AnonymousClass3(bVar2, apv, bVar3.apb(), i));
                                }
                            } else {
                                return;
                            }
                        }
                        x.i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", Integer.valueOf(apv.size()));
                        if (!(bVar.koR || bVar2 == null)) {
                            ah.y(new AnonymousClass4(bVar2, apv));
                        }
                        x.d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", Long.valueOf(bi.bA(Wy)));
                    }
                }, "BakMoveChooseServer.calculateChooseConvSize");
                if (BackupMoveChooseUI.this.krR.krO) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(485, 22, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(4));
                }
                if (BackupMoveChooseUI.ksb == 1 && BackupMoveChooseUI.afu == 1) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(485, 26, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(485, 27, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(7));
                } else if (BackupMoveChooseUI.ksb == 1) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(485, 26, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(5));
                } else if (BackupMoveChooseUI.afu == 1) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(485, 27, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(6));
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(8));
                MMWizardActivity.A(BackupMoveChooseUI.this, new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class));
                com.tencent.mm.plugin.report.service.g.pWK.a(485, 23, 1, false);
                return true;
            }
        }, p.b.xSe);
        enableOptionMenu(false);
        dK(true);
        this.krY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
                intent.putExtra("BACKUP_MODE", 2);
                intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.ksb);
                intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
                intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.afu);
                intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
                intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
                intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.c.b.apy().apC().kqo);
                BackupMoveChooseUI.this.startActivityForResult(intent, 0);
            }
        });
        this.krT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                if (com.tencent.mm.plugin.backup.c.b.apy().apC().kqs) {
                    a a = BackupMoveChooseUI.this.krR;
                    if (a.krN.size() == a.getCount()) {
                        a.krN.clear();
                        a.krO = false;
                    } else {
                        while (i < a.getCount()) {
                            a.krN.add(Integer.valueOf(i));
                            i++;
                        }
                        a.krO = true;
                    }
                    a.notifyDataSetChanged();
                    a.krM.a(a.krN);
                }
            }
        });
        if (com.tencent.mm.plugin.backup.c.b.apy().apC().kqs) {
            if (com.tencent.mm.plugin.backup.c.b.apy().apC().apu() == null || com.tencent.mm.plugin.backup.c.b.apy().apC().apu().size() == 0) {
                switch (ksb) {
                    case 0:
                        this.krX.setText(R.l.dHF);
                        break;
                    case 1:
                        this.krX.setText(R.l.dJV);
                        break;
                }
                this.krX.setVisibility(0);
            }
            this.ksa.setVisibility(4);
        } else if (com.tencent.mm.plugin.backup.c.b.apy().apC().kqs) {
            this.ksa.setVisibility(4);
        } else {
            this.krV.setClickable(false);
            this.krV.setVisibility(4);
            this.krW.setVisibility(4);
            this.ksa.setVisibility(0);
        }
    }

    private void dK(boolean z) {
        if (z) {
            com.tencent.mm.plugin.backup.c.b.apy();
            SharedPreferences aoX = com.tencent.mm.plugin.backup.a.d.aoX();
            ksb = aoX.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            afu = aoX.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aoX.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            endTime = aoX.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        }
        switch (ksb) {
            case 0:
                this.krZ.setText("");
                break;
            case 1:
                this.krZ.setText(this.ksc.format(new Date(startTime)) + "~" + this.ksc.format(new Date(endTime - 86400000)));
                break;
        }
        if (afu == 1) {
            this.krZ.setText(this.krZ.getText() + (ksb == 1 ? ";" : "") + this.mController.xRr.getResources().getString(R.l.dIG));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        LinkedList apu = com.tencent.mm.plugin.backup.c.b.apy().apC().apu();
        if (apu == null) {
            x.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < apu.size()) {
                j = ((f.b) apu.get(intValue)).koE + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            enableOptionMenu(true);
            if (hashSet.size() == this.krR.getCount()) {
                this.krV.setChecked(true);
            } else {
                this.krV.setChecked(false);
            }
            this.krU.setText(getString(R.l.dHA, new Object[]{Integer.valueOf(hashSet.size())}));
            return;
        }
        enableOptionMenu(false);
        this.krV.setChecked(false);
        this.krU.setText("");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            x.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", Integer.valueOf(i2));
            return;
        }
        int i3 = ksb;
        long j = startTime;
        long j2 = endTime;
        ksb = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", ksb);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        afu = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", afu);
        x.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(ksb), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(afu));
        com.tencent.mm.plugin.backup.c.b.apy().apA();
        d.c(ksb, startTime, endTime, afu);
        dK(false);
        if (i3 == ksb) {
            if (ksb == 0) {
                return;
            }
            if (ksb == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        com.tencent.mm.plugin.backup.c.b.apy().apC().a(ksb, startTime, endTime, com.tencent.mm.plugin.backup.c.b.apy().apC().apt());
        a aVar = this.krR;
        aVar.krN.clear();
        aVar.krM.a(aVar.krN);
        if (com.tencent.mm.plugin.backup.c.b.apy().apC().apu() == null || com.tencent.mm.plugin.backup.c.b.apy().apC().apu().size() == 0) {
            switch (ksb) {
                case 0:
                    this.krX.setText(R.l.dHF);
                    break;
                case 1:
                    this.krX.setText(R.l.dJV);
                    break;
            }
            this.krX.setVisibility(0);
        } else {
            this.krX.setVisibility(4);
        }
        this.krR.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.daT;
    }

    public final void w(LinkedList<f.b> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                this.ksa.setVisibility(8);
                this.krX.setVisibility(0);
                switch (ksb) {
                    case 0:
                        this.krX.setText(R.l.dHF);
                        return;
                    case 1:
                        this.krX.setText(R.l.dJV);
                        return;
                    default:
                        return;
                }
            }
            this.krV.setClickable(true);
            this.krV.setVisibility(0);
            this.krW.setVisibility(0);
            this.ksa.setVisibility(8);
            this.krR.notifyDataSetChanged();
        }
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
    }

    public final void x(LinkedList<f.b> linkedList) {
    }
}
