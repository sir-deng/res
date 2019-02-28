package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ap.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class ImageDownloadUI extends MMActivity implements e, f {
    private long fGj = 0;
    private long frh = 0;
    private int hBE;
    private ProgressBar pzc;
    private TextView pzd;
    private TextView pze;
    private TextView pzf;
    private TextView pzg;
    private com.tencent.mm.ap.e pzi;
    private k pzj;
    private String username;
    private ImageView yFO;

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
            x.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.frh + ", or msgSvrId = " + this.fGj);
            return;
        }
        if (this.frh <= 0 && this.fGj > 0) {
            as.Hm();
            this.frh = c.Fh().G(this.username, this.fGj).field_msgId;
        }
        this.pzj = new k(this.pzi.hBA, this.frh, this.hBE, this);
        as.CN().a(this.pzj, 0);
    }

    protected final int getLayoutId() {
        return R.i.dtC;
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
        this.pze = (TextView) findViewById(R.h.cUW);
        this.pzf = (TextView) findViewById(R.h.cUX);
        this.pzg = (TextView) findViewById(R.h.cUU);
        this.yFO = (ImageView) findViewById(R.h.ccw);
        this.yFO.setImageResource(R.k.dyE);
        this.pzd.setVisibility(0);
        this.pze.setVisibility(8);
        this.pzf.setVisibility(8);
        this.pzg.setVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                as.CN().c(ImageDownloadUI.this.pzj);
                ImageDownloadUI.this.finish();
                return true;
            }
        });
        this.pzc = (ProgressBar) findViewById(R.h.cUV);
    }

    public final void a(int i, int i2, com.tencent.mm.ad.k kVar) {
        x.d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == 109) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            vw(Math.max(0, i3));
        }
    }

    private void vw(int i) {
        this.pzc.setProgress(i);
        this.pzd.setText(getString(R.l.eje, new Object[]{Integer.valueOf(i)}));
        if (i >= this.pzc.getMax()) {
            com.tencent.mm.ap.e b = o.PC().b(Long.valueOf(this.pzj.hCV));
            String str = b.hBB;
            if (this.hBE == 1) {
                str = com.tencent.mm.ap.f.c(b);
            }
            str = o.PC().m(str, null, null);
            if (str == null || str.equals("") || !com.tencent.mm.a.e.bO(str)) {
                x.d("ImageDownloadUI", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_message_id", this.frh);
            intent.putExtra("key_image_path", str);
            intent.putExtra("key_compress_type", this.hBE);
            intent.putExtra("key_favorite", true);
            intent.putExtra("img_gallery_msg_id", this.frh);
            intent.putExtra("img_gallery_talker", this.username);
            finish();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (kVar.getType() == 109) {
            if (i == 0 && i2 == 0) {
                vw(this.pzc.getMax());
                return;
            }
            x.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.epB, 1).show();
        }
    }
}
