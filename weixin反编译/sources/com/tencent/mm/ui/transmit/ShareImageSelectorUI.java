package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int zyM = 1;
    private ListView Fv;
    private View lIB;
    private ImageView lNZ;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            ShareImageSelectorUI.this.finish();
        }
    };
    private String ooF;
    private int zdc = 2;
    private a zyN;
    private Dialog zyO;
    private OnClickListener zyP = new OnClickListener() {
        public final void onClick(View view) {
            ShareImageSelectorUI.a(ShareImageSelectorUI.this);
        }
    };

    class a extends BaseAdapter {
        public a[] zyR = new a[]{new a(R.l.dYj, R.k.dAQ), new a(R.l.dYk, R.k.dyM), new a(R.l.dYi, R.k.dzm)};

        class a {
            int zyS;
            int zyT;

            public a(int i, int i2) {
                this.zyS = i;
                this.zyT = i2;
            }
        }

        a() {
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.zyR[i];
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ShareImageSelectorUI.this.mController.xRr).inflate(R.i.dsI, null);
                bVar = new b(view);
            } else {
                bVar = (b) view.getTag();
            }
            a aVar = this.zyR[i];
            if (aVar != null) {
                bVar.zyV.setText(aVar.zyS);
                bVar.mBK.setImageResource(aVar.zyT);
            }
            return view;
        }
    }

    class b {
        MMImageView mBK;
        TextView zyV;

        public b(View view) {
            this.mBK = (MMImageView) view.findViewById(R.h.crC);
            this.zyV = (TextView) view.findViewById(R.h.crU);
        }
    }

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.ooF);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.dsH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.Hm();
        Object obj = c.Db().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                zyM = intValue;
            }
        }
        setMMTitle(R.l.evi);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShareImageSelectorUI.this.aWN();
                return false;
            }
        });
        this.zdc = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.ooF = getIntent().getStringExtra("intent_extra_image_path");
        this.lIB = findViewById(R.h.cuP);
        this.lNZ = (ImageView) findViewById(R.h.image);
        this.lNZ.setOnClickListener(this.zyP);
        this.Fv = (ListView) findViewById(R.h.list);
        this.zyN = new a();
        this.Fv.setAdapter(this.zyN);
        this.Fv.setOnItemClickListener(this);
        x.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", this.zdc, this.ooF);
        if (zyM == 1) {
            setTitleVisibility(8);
            this.Fv.setVisibility(8);
            this.lNZ.setLayoutParams(new LayoutParams(-1, -1));
            this.lNZ.setPadding(0, 0, 0, 0);
            this.lNZ.setOnClickListener(null);
            this.lIB.setBackgroundColor(getResources().getColor(R.e.brV));
            czj();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap oH = j.oH(this.ooF);
        x.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", Integer.valueOf(ExifHelper.Vo(this.ooF)));
        oH = d.b(oH, (float) r3);
        if (!(oH == null || oH.isRecycled())) {
            this.lNZ.setImageBitmap(oH);
        }
        x.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", (System.currentTimeMillis() - currentTimeMillis) + "'");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (zyM != 1) {
            return;
        }
        if (this.zyO == null || !this.zyO.isShowing()) {
            czj();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                czk();
                return;
            case 1:
                czl();
                return;
            case 2:
                czm();
                return;
            default:
                x.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1001:
                if (i2 == -1) {
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, ChattingUI.class);
                        intent2.putExtra("Chat_User", (String) arrayList.get(0));
                        startActivity(intent2);
                    }
                    finish();
                    return;
                }
                x.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            case 1002:
                if (i2 == -1) {
                    Toast.makeText(this.mController.xRr, R.l.dUo, 0).show();
                    finish();
                    return;
                }
                x.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            default:
                x.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                return;
        }
    }

    public void onBackPressed() {
        aWN();
    }

    private void aWN() {
        h.a(this.mController.xRr, getString(R.l.dYf), getString(R.l.dYh), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                ShareImageSelectorUI.this.finish();
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (ShareImageSelectorUI.zyM == 1) {
                    ShareImageSelectorUI.this.czj();
                }
            }
        });
    }

    private void czj() {
        if (this.zyO == null || !this.zyO.isShowing()) {
            this.zyO = h.a(this.mController.xRr, getString(R.l.evi), new String[]{getString(R.l.dYj), getString(R.l.dYk), getString(R.l.dYi)}, null, new h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            ShareImageSelectorUI.this.czk();
                            return;
                        case 1:
                            ShareImageSelectorUI.this.czl();
                            return;
                        case 2:
                            ShareImageSelectorUI.this.czm();
                            return;
                        default:
                            return;
                    }
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ShareImageSelectorUI.this.aWN();
                }
            });
        }
    }

    private void czk() {
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.zcF);
        intent.putExtra("titile", getString(R.l.dDw));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.ooF);
        startActivityForResult(intent, 1001);
    }

    private void czl() {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.ooF);
        intent.putExtra("need_result", true);
        com.tencent.mm.bl.d.b(this.mController.xRr, "sns", ".ui.SnsUploadUI", intent, 1002);
    }

    private void czm() {
        cg cgVar = new cg();
        f.a(cgVar, 6, this.ooF);
        cgVar.frk.activity = this;
        cgVar.frk.frr = 52;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        g.pWK.h(11048, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
    }
}
