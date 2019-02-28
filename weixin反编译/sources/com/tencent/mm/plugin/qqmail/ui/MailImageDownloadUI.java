package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ap.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class MailImageDownloadUI extends MMActivity implements e, f {
    private long fGj = 0;
    private long frh = 0;
    private int hBE;
    private ag handler = new ag(Looper.getMainLooper());
    private ProgressBar pzc;
    private TextView pzd;
    private TextView pze;
    private TextView pzf;
    private TextView pzg;
    private RelativeLayout pzh;
    private com.tencent.mm.ap.e pzi;
    private k pzj;
    private ImageView pzk;
    private LinearLayout pzl;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.frh = getIntent().getLongExtra("img_msg_id", 0);
        this.fGj = getIntent().getLongExtra("img_server_id", 0);
        this.hBE = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        initView();
        if (this.frh > 0) {
            this.pzi = o.PC().bj(this.frh);
        }
        if ((this.pzi == null || this.pzi.hBA <= 0) && this.fGj > 0) {
            this.pzi = o.PC().bi(this.fGj);
        }
        if (this.pzi == null || this.pzi.hBA <= 0) {
            x.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.frh + ", or msgSvrId = " + this.fGj);
            return;
        }
        if (this.frh <= 0 && this.fGj > 0) {
            as.Hm();
            this.frh = c.Fh().G(this.username, this.fGj).field_msgId;
        }
        String str = this.pzi.hBB;
        String m = o.PC().m(str, null, null);
        if (bi.oN(str) || !com.tencent.mm.a.e.bO(m)) {
            this.pzj = new k(this.pzi.hBA, this.frh, this.hBE, this);
            as.CN().a(this.pzj, 0);
            return;
        }
        x.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", str, Boolean.valueOf(this.pzi.Pk()), m);
        if (m == null || m.equals("") || !com.tencent.mm.a.e.bO(m)) {
            x.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            return;
        }
        this.pzl.setVisibility(8);
        this.pzc.setVisibility(8);
        this.pzk.setVisibility(0);
        this.pzk.setImageBitmap(d.Vs(m));
        this.pzh.invalidate();
    }

    protected final int getLayoutId() {
        return R.i.dmY;
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(109, (e) this);
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(109, (e) this);
    }

    protected final void initView() {
        this.pzd = (TextView) findViewById(R.h.coX);
        this.pze = (TextView) findViewById(R.h.coX);
        this.pzf = (TextView) findViewById(R.h.coY);
        this.pzg = (TextView) findViewById(R.h.coV);
        this.pzk = (ImageView) findViewById(R.h.cuM);
        this.pzd.setVisibility(0);
        this.pzl = (LinearLayout) findViewById(R.h.coU);
        this.pzh = (RelativeLayout) findViewById(R.h.cuN);
        this.pze.setVisibility(8);
        this.pzf.setVisibility(8);
        this.pzg.setVisibility(8);
        setTitleVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                as.CN().c(MailImageDownloadUI.this.pzj);
                MailImageDownloadUI.this.finish();
                return true;
            }
        });
        this.pzc = (ProgressBar) findViewById(R.h.coW);
    }

    private void vw(int i) {
        this.pzd.setText(getString(R.l.eje, new Object[]{Integer.valueOf(i)}));
        if (i >= this.pzc.getMax()) {
            com.tencent.mm.ap.e b = o.PC().b(Long.valueOf(this.pzj.hCV));
            if (this.hBE == 1) {
                com.tencent.mm.ap.f.c(b);
            }
            finish();
            startActivity(getIntent());
        }
    }

    public final void a(int i, int i2, com.tencent.mm.ad.k kVar) {
        x.d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == 109) {
            vw(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (kVar.getType() == 109) {
            if (i == 0 && i2 == 0) {
                vw(this.pzc.getMax());
                return;
            }
            x.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.epB, 1).show();
        }
    }
}
