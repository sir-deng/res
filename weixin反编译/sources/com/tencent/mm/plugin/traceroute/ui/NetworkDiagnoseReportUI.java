package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String skU;
    private boolean slI = false;
    private Button slJ;
    private Button slK;
    private ImageView slL;
    private TextView slM;
    private TextView slN;
    private TextView slO;

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        String string = networkDiagnoseReportUI.getString(R.l.eEM);
        File file = new File(skU);
        if (!file.exists()) {
            return string;
        }
        String name = file.getName();
        if (bi.oN(name)) {
            return string;
        }
        int indexOf = name.indexOf(".");
        StringBuilder append = new StringBuilder().append(string).append("_");
        if (indexOf <= 0) {
            indexOf = name.length();
        }
        return append.append(name.substring(0, indexOf)).toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        this.slL = (ImageView) findViewById(R.h.cHL);
        this.slM = (TextView) findViewById(R.h.cHO);
        this.slN = (TextView) findViewById(R.h.cHN);
        this.slI = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.slI) {
            this.slL.setImageResource(R.g.bEf);
            this.slM.setText(getString(R.l.eSy));
            this.slN.setVisibility(0);
            addTextOptionMenu(0, getString(R.l.dYQ), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    NetworkDiagnoseReportUI.this.finish();
                    return false;
                }
            });
            return;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NetworkDiagnoseReportUI.this.finish();
                return true;
            }
        });
        skU = getIntent().getStringExtra("diagnose_log_file_path");
        this.slL.setImageResource(R.g.bEe);
        this.slM.setText(getString(R.l.eSx));
        if (skU != null && e.bN(skU) > 0) {
            this.slO = (TextView) findViewById(R.h.cHM);
            this.slO.setText(getString(R.l.eEN, new Object[]{skU.replace("mnt/", "")}));
            findViewById(R.h.cHM).setVisibility(0);
            findViewById(R.h.cLA).setVisibility(0);
            this.slJ = (Button) findViewById(R.h.cLB);
            this.slJ.setVisibility(0);
            this.slJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
                    intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(NetworkDiagnoseReportUI.skU)));
                    intent.setType("text/plain");
                    NetworkDiagnoseReportUI.this.startActivity(intent);
                }
            });
            this.slK = (Button) findViewById(R.h.cVT);
            this.slK.setVisibility(0);
            this.slK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!bi.oN(NetworkDiagnoseReportUI.skU)) {
                        File file = new File(NetworkDiagnoseReportUI.skU);
                        if (file.exists()) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(file), "text/plain");
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            NetworkDiagnoseReportUI.this.startActivity(intent);
                        }
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dpa;
    }
}
