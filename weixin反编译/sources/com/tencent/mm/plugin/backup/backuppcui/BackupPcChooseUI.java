package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class BackupPcChooseUI extends MMWizardActivity {
    private static int afu = 0;
    private static long endTime;
    private static int ksb = 0;
    private static long startTime;
    private View krT;
    private TextView krU;
    private CheckBox krV;
    private TextView krW;
    private TextView krX;
    private RelativeLayout krY;
    private TextView krZ;
    private ProgressBar ksa;
    private SimpleDateFormat ksc = new SimpleDateFormat("yyyy.MM.dd");
    private a ktX = new a(this);
    private ListView ktY;
    private b.a ktZ = new b.a() {
        public final void w(LinkedList<f.b> linkedList) {
            if (linkedList != null) {
                if (linkedList.size() == 0) {
                    BackupPcChooseUI.this.ksa.setVisibility(8);
                    BackupPcChooseUI.this.krX.setVisibility(0);
                    switch (BackupPcChooseUI.ksb) {
                        case 0:
                            BackupPcChooseUI.this.krX.setText(R.l.dIP);
                            return;
                        case 1:
                            BackupPcChooseUI.this.krX.setText(R.l.dJV);
                            return;
                        default:
                            return;
                    }
                }
                BackupPcChooseUI.this.krV.setClickable(true);
                BackupPcChooseUI.this.ksa.setVisibility(4);
                BackupPcChooseUI.this.ktX.notifyDataSetChanged();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            initView();
        }
    }

    protected final int getLayoutId() {
        return R.i.daT;
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().kth = this.ktZ;
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().kth = null;
    }

    protected final void initView() {
        setMMTitle(R.l.dJK);
        this.ktY = (ListView) findViewById(R.h.bLY);
        this.ktY.setAdapter(this.ktX);
        this.ktY.setEmptyView(findViewById(R.h.bMa));
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
                BackupPcChooseUI.this.finish();
                return false;
            }
        });
        a(0, getString(R.l.dKi), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LinkedList linkedList;
                a a = BackupPcChooseUI.this.ktX;
                LinkedList linkedList2 = new LinkedList();
                if (a.krN.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    LinkedList apu = com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().apu();
                    if (apu != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.krN.contains(Integer.valueOf(i))) {
                                linkedList2.add(apu.get(i));
                            }
                        }
                    }
                    x.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
                    linkedList = linkedList2;
                }
                final LinkedList v = g.v(linkedList);
                as.Hm();
                x.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()), Integer.valueOf(BackupPcChooseUI.ksb), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.endTime), Integer.valueOf(BackupPcChooseUI.afu));
                if (((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    h.a(BackupPcChooseUI.this, R.l.dJm, 0, R.l.dKb, 0, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().A(linkedList);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().na(2);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aoS().kov = 12;
                            com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().B(v);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().bJ((long) linkedList.size());
                            com.tencent.mm.plugin.report.service.g.pWK.a(400, 8, 1, false);
                            com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                            if (BackupPcChooseUI.ksb == 1 && BackupPcChooseUI.afu == 1) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.a(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                            } else if (BackupPcChooseUI.ksb == 1) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                            } else if (BackupPcChooseUI.afu == 1) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                            }
                            BackupPcChooseUI.this.finish();
                        }
                    }, null, R.e.brv);
                } else {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().A(linkedList);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().na(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aoS().kov = 12;
                    com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().B(v);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().bJ((long) linkedList.size());
                    com.tencent.mm.plugin.report.service.g.pWK.a(400, 8, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                    if (BackupPcChooseUI.ksb == 1 && BackupPcChooseUI.afu == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.a(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                    } else if (BackupPcChooseUI.ksb == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                    } else if (BackupPcChooseUI.afu == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13735, Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqa().ktv));
                    }
                    BackupPcChooseUI.this.finish();
                }
                return true;
            }
        }, p.b.xSe);
        enableOptionMenu(false);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().ktK || com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().ktL) {
            this.krY.setVisibility(0);
            dN(true);
            this.krY.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
                    intent.putExtra("BACKUP_MODE", 1);
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.ksb);
                    intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().ktL);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.afu);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
                    intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().kqo);
                    BackupPcChooseUI.this.startActivityForResult(intent, 0);
                }
            });
        } else {
            this.krY.setVisibility(8);
        }
        this.krT.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().kqs) {
                    a a = BackupPcChooseUI.this.ktX;
                    if (a.krN.size() == a.getCount()) {
                        a.krN.clear();
                        a.ktV = false;
                    } else {
                        while (i < a.getCount()) {
                            a.krN.add(Integer.valueOf(i));
                            i++;
                        }
                        a.ktV = true;
                    }
                    a.notifyDataSetChanged();
                    a.ktU.a(a.krN);
                }
            }
        });
        if (!com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().kqs) {
            this.krV.setClickable(false);
            this.ksa.setVisibility(0);
        } else if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().apu().size() == 0) {
            switch (ksb) {
                case 0:
                    this.krX.setText(R.l.dIP);
                    break;
                case 1:
                    this.krX.setText(R.l.dJV);
                    break;
            }
            this.krX.setVisibility(0);
        }
    }

    private void dN(boolean z) {
        if (z) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.apZ();
            SharedPreferences aoX = d.aoX();
            ksb = aoX.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
            afu = aoX.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aoX.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
            endTime = aoX.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().ktK) {
            switch (ksb) {
                case 0:
                    this.krZ.setText("");
                    break;
                case 1:
                    this.krZ.setText(this.ksc.format(new Date(startTime)) + "~" + this.ksc.format(new Date(endTime - 86400000)));
                    break;
            }
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb().ktL && afu == 1) {
            this.krZ.setText(this.krZ.getText() + (ksb == 1 ? ";" : "") + this.mController.xRr.getResources().getString(R.l.dJF));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        int size = com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().apu().size();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue >= size) {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove(Integer.valueOf(((Integer) it2.next()).intValue()));
        }
        if (hashSet.size() != 0) {
            enableOptionMenu(true);
            if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().kqs && hashSet.size() == this.ktX.getCount()) {
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
            x.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", Integer.valueOf(i2));
            return;
        }
        int i3 = ksb;
        long j = startTime;
        long j2 = endTime;
        ksb = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", ksb);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        afu = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", afu);
        x.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(ksb), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(afu));
        com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqb();
        e.d(ksb, startTime, endTime, afu);
        dN(false);
        if (i3 == ksb) {
            if (ksb == 0) {
                return;
            }
            if (ksb == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().a(ksb, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().apt());
        a aVar = this.ktX;
        aVar.krN.clear();
        aVar.ktU.a(aVar.krN);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().apu() == null || com.tencent.mm.plugin.backup.backuppcmodel.b.apZ().aqd().apu().size() == 0) {
            switch (ksb) {
                case 0:
                    this.krX.setText(R.l.dIP);
                    break;
                case 1:
                    this.krX.setText(R.l.dJV);
                    break;
            }
            this.krX.setVisibility(0);
        } else {
            this.krX.setVisibility(4);
        }
        this.ktX.notifyDataSetChanged();
    }
}
