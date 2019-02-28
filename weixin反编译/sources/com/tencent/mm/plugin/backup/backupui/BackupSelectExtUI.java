package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.DatePicker;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.widget.h;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI extends MMPreference {
    private int afu = 0;
    private long endTime = 0;
    private f inW;
    private int kor;
    private long kqo = 0;
    private int ksb = 0;
    private SimpleDateFormat ksc = new SimpleDateFormat("yyyy.MM.dd");
    private CheckPreference kvP;
    private CheckPreference kvQ;
    private Preference kvR;
    private Preference kvS;
    private boolean kvT = false;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.inW = this.yrJ;
        initView();
    }

    public final int XK() {
        return R.o.fbx;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.idX.equals("backup_select_ext_time")) {
            this.ksb = this.ksb == 0 ? 1 : 0;
            switch (this.ksb) {
                case 0:
                    this.kvP.tYU = false;
                    fVar.c(this.kvS);
                    fVar.c(this.kvR);
                    enableOptionMenu(true);
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    av();
                    return true;
                default:
                    return true;
            }
        } else if (preference.idX.equals("backup_select_ext_content")) {
            if (!this.kvT) {
                return true;
            }
            int i;
            if (this.afu == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.afu = i;
            switch (this.afu) {
                case 0:
                    this.kvQ.tYU = false;
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    this.kvQ.tYU = true;
                    fVar.notifyDataSetChanged();
                    return true;
                default:
                    return true;
            }
        } else if (preference.idX.equals("backup_select_begin_time")) {
            showDialog(1);
            return true;
        } else if (!preference.idX.equals("backup_select_end_time")) {
            return false;
        } else {
            showDialog(2);
            return true;
        }
    }

    protected Dialog onCreateDialog(final int i) {
        Calendar instance = Calendar.getInstance();
        switch (i) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? bi.Wy() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? bi.Wy() : this.endTime - 86400000);
                break;
        }
        Dialog hVar = new h(this.mController.xRr, new OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                StringBuffer append = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)}));
                long vW;
                BackupSelectExtUI backupSelectExtUI;
                boolean z;
                switch (i) {
                    case 1:
                        vW = g.vW(append.append("000000").toString());
                        BackupSelectExtUI.this.startTime = (vW / 1000) * 1000;
                        BackupSelectExtUI.this.kvS.setSummary(BackupSelectExtUI.this.ksc.format(new Date(vW)));
                        BackupSelectExtUI.this.inW.notifyDataSetChanged();
                        backupSelectExtUI = BackupSelectExtUI.this;
                        z = (BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true;
                        backupSelectExtUI.enableOptionMenu(z);
                        return;
                    case 2:
                        vW = g.vW(append.append("000000").toString());
                        BackupSelectExtUI.this.endTime = ((vW / 1000) * 1000) + 86400000;
                        BackupSelectExtUI.this.kvR.setSummary(BackupSelectExtUI.this.ksc.format(new Date(vW)));
                        BackupSelectExtUI.this.inW.notifyDataSetChanged();
                        backupSelectExtUI = BackupSelectExtUI.this;
                        z = (BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true;
                        backupSelectExtUI.enableOptionMenu(z);
                        return;
                    default:
                        return;
                }
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        hVar.setCanceledOnTouchOutside(false);
        long Wy = (((bi.Wy() / 86400000) * 86400000) + 57600000) - 1;
        if (Wy > this.kqo) {
            hVar.getDatePicker().setMaxDate(Wy);
            hVar.getDatePicker().setMinDate(this.kqo);
        }
        return hVar;
    }

    protected final void initView() {
        this.kor = getIntent().getIntExtra("BACKUP_MODE", 0);
        setMMTitle(R.l.dJW);
        this.ksb = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.kvT = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.afu = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.kqo = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        av();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BackupSelectExtUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.dKi), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (BackupSelectExtUI.this.ksb != 1 || BackupSelectExtUI.this.startTime < BackupSelectExtUI.this.endTime) {
                    Intent intent = new Intent();
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.this.ksb);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.this.afu);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.this.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.this.endTime);
                    BackupSelectExtUI.this.setResult(-1, intent);
                    BackupSelectExtUI.this.finish();
                } else if (BackupSelectExtUI.this.kor == 1) {
                    com.tencent.mm.ui.base.h.b(BackupSelectExtUI.this.mController.xRr, BackupSelectExtUI.this.getString(R.l.dIQ), "", true);
                } else if (BackupSelectExtUI.this.kor == 2) {
                    com.tencent.mm.ui.base.h.b(BackupSelectExtUI.this.mController.xRr, BackupSelectExtUI.this.getString(R.l.dHG), "", true);
                }
                return true;
            }
        }, b.xSe);
    }

    private void av() {
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fbx);
        this.kvP = (CheckPreference) this.inW.Zu("backup_select_ext_time");
        this.kvS = this.inW.Zu("backup_select_begin_time");
        this.kvR = this.inW.Zu("backup_select_end_time");
        this.kvQ = (CheckPreference) this.inW.Zu("backup_select_ext_content");
        if (!this.kvT) {
            this.inW.c(this.inW.Zu("backup_select_ext_content_title"));
            this.inW.c(this.kvQ);
        }
        if (this.kor == 1) {
            this.inW.Zu("backup_select_ext_time_title").setTitle(R.l.dJI);
            this.kvP.setTitle(R.l.dJH);
            if (this.kvT) {
                this.inW.Zu("backup_select_ext_content_title").setTitle(R.l.dJG);
                this.kvQ.setTitle(R.l.dJE);
            }
        } else if (this.kor == 2) {
            this.inW.Zu("backup_select_ext_time_title").setTitle(R.l.dIJ);
            this.kvP.setTitle(R.l.dII);
            if (this.kvT) {
                this.inW.Zu("backup_select_ext_content_title").setTitle(R.l.dIH);
                this.kvQ.setTitle(R.l.dIF);
            }
        }
        switch (this.ksb) {
            case 0:
                this.kvS.setEnabled(false);
                this.kvR.setEnabled(false);
                this.kvP.tYU = false;
                this.inW.c(this.kvS);
                this.inW.c(this.kvR);
                enableOptionMenu(true);
                break;
            case 1:
                boolean z;
                BackupSelectExtUI backupSelectExtUI;
                BackupSelectExtUI backupSelectExtUI2;
                if (this.startTime != 0 && this.endTime != 0) {
                    this.kvS.setSummary(this.ksc.format(new Date(this.startTime)));
                    this.kvR.setSummary(this.ksc.format(new Date(this.endTime - 86400000)));
                    if (this.startTime != 0 && this.endTime != 0) {
                        z = true;
                        backupSelectExtUI = this;
                        backupSelectExtUI.enableOptionMenu(z);
                        this.kvS.setEnabled(true);
                        this.kvR.setEnabled(true);
                        this.kvP.tYU = true;
                        break;
                    }
                    backupSelectExtUI2 = this;
                } else {
                    this.kvS.setSummary(R.l.dJX);
                    this.kvR.setSummary(R.l.dJX);
                    backupSelectExtUI2 = this;
                }
                backupSelectExtUI = backupSelectExtUI2;
                z = false;
                backupSelectExtUI.enableOptionMenu(z);
                this.kvS.setEnabled(true);
                this.kvR.setEnabled(true);
                this.kvP.tYU = true;
                break;
        }
        if (this.kvT) {
            switch (this.afu) {
                case 0:
                    this.kvQ.tYU = false;
                    break;
                case 1:
                    this.kvQ.tYU = true;
                    break;
            }
        }
        this.inW.notifyDataSetChanged();
    }
}
