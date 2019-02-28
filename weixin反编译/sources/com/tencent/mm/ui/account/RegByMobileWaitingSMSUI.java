package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String fBa;
    private ListView kLX;
    private ProgressBar lFV;
    private String pXN;
    private TextView xZW;
    private CountDownTimer xZX;
    private int xZY = 30;
    private a xZZ;
    private j xZh;
    private boolean xZi;
    private com.tencent.mm.ui.account.j.a xZj = new com.tencent.mm.ui.account.j.a() {
        public final void Zf(String str) {
            RegByMobileWaitingSMSUI.this.Ze(str.trim());
        }

        public final void coQ() {
            RegByMobileWaitingSMSUI.this.Ze(null);
        }
    };
    private List<Integer> yaa = new ArrayList();
    String[] yab = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable yac;
    private List<Drawable> yad = new ArrayList();
    private boolean yae = false;

    private class a extends ArrayAdapter<String> {
        private final LayoutInflater ntf;
        final /* synthetic */ RegByMobileWaitingSMSUI yaf;
        private final ArrayList<String> yah;

        public final /* synthetic */ void add(Object obj) {
            Pm((String) obj);
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                View inflate;
                b bVar2 = new b(this.yaf, (byte) 0);
                switch (itemViewType) {
                    case 0:
                        inflate = this.ntf.inflate(R.i.dam, null);
                        break;
                    case 1:
                        inflate = this.ntf.inflate(R.i.dan, null);
                        break;
                    default:
                        throw new IllegalArgumentException("UNIMPLEMENT TYPE");
                }
                bVar2.yai = (TextView) inflate.findViewById(R.h.bTJ);
                bVar2.hxJ = (ImageView) inflate.findViewById(R.h.bTw);
                inflate.setTag(bVar2);
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            int intValue = ((Integer) this.yaf.yaa.get(i % this.yaf.yaa.size())).intValue();
            switch (itemViewType) {
                case 0:
                    bVar.hxJ.setImageDrawable((Drawable) this.yaf.yad.get(intValue % this.yaf.yad.size()));
                    break;
                case 1:
                    bVar.hxJ.setImageDrawable(this.yaf.yac);
                    break;
            }
            bVar.yai.setText(kF(i));
            return view;
        }

        public final int getCount() {
            return this.yah.size();
        }

        private String kF(int i) {
            return (String) this.yah.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((Integer) this.yaf.yaa.get(i % this.yaf.yaa.size())).intValue() % 4 == 0) {
                return 1;
            }
            return 0;
        }

        public final void Pm(String str) {
            this.yah.add(str);
            notifyDataSetChanged();
        }
    }

    private class b {
        public ImageView hxJ;
        public TextView yai;

        private b() {
        }

        /* synthetic */ b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI, byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yad.add(getResources().getDrawable(R.g.bCT));
        this.yad.add(getResources().getDrawable(R.g.bCU));
        this.yad.add(getResources().getDrawable(R.g.bCV));
        this.yad.add(getResources().getDrawable(R.g.bCW));
        this.yad.add(getResources().getDrawable(R.g.bCX));
        this.yad.add(getResources().getDrawable(R.g.bCY));
        initView();
        this.xZh = new j(this, this.xZj);
        this.xZh.cpe();
        this.pXN = com.tencent.mm.plugin.c.b.Xw();
    }

    protected void onDestroy() {
        if (this.xZh != null) {
            this.xZh.cpf();
            this.xZh = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",RE200_250," + as.fJ("RE200_250") + ",1");
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.c.b.oY("RE200_250");
        if (this.yae) {
            com.tencent.mm.plugin.c.b.oZ(this.pXN);
        } else {
            com.tencent.mm.plugin.c.b.oZ("RE200_300");
        }
        com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",RE200_250," + as.fJ("RE200_250") + ",2");
    }

    protected final void initView() {
        this.xZW = (TextView) findViewById(R.h.cYC);
        this.lFV = (ProgressBar) findViewById(R.h.cYE);
        this.kLX = (ListView) findViewById(R.h.cYD);
        this.xZi = false;
        String string = getString(R.l.dLy);
        if (d.vHo) {
            string = getString(R.l.app_name) + getString(R.l.dDO);
        }
        setMMTitle(string);
        this.fBa = getIntent().getExtras().getString("bindmcontact_mobile");
        this.fBa = ap.VQ(this.fBa);
        this.xZY = getIntent().getIntExtra("mobileverify_countdownsec", this.xZY);
        Random random = new Random();
        for (int i = 0; i < this.xZY; i++) {
            this.yaa.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.yad.size();
        this.yac = (Drawable) this.yad.get(nextInt);
        this.yad.remove(nextInt);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByMobileWaitingSMSUI.this.goBack();
                return true;
            }
        });
        ap apVar = new ap();
        string = "86";
        if (this.fBa.startsWith("+")) {
            this.fBa = this.fBa.replace("+", "");
            string = ap.DK(this.fBa);
            if (string != null) {
                this.fBa = this.fBa.substring(string.length());
            }
        }
        CharSequence formatNumber = ap.formatNumber(string, this.fBa);
        if (string == null || string.length() <= 0) {
            this.xZW.setText(formatNumber);
        } else {
            this.xZW.setText("+" + string + " " + formatNumber);
        }
        this.kLX.setVisibility(4);
        if (this.xZX == null) {
            this.xZX = new CountDownTimer((long) (this.xZY * 1000)) {
                public final void onFinish() {
                    RegByMobileWaitingSMSUI.this.Ze(null);
                }

                public final void onTick(long j) {
                    int c = (int) (((long) RegByMobileWaitingSMSUI.this.xZY) - (j / 1000));
                    RegByMobileWaitingSMSUI.this.lFV.setProgress(c);
                    if (c % 2 == 0 && RegByMobileWaitingSMSUI.this.xZZ != null) {
                        RegByMobileWaitingSMSUI.this.xZZ.Pm(RegByMobileWaitingSMSUI.this.yab[(c / 2) % RegByMobileWaitingSMSUI.this.yab.length]);
                        RegByMobileWaitingSMSUI.this.kLX.post(new Runnable() {
                            public final void run() {
                                if (VERSION.SDK_INT >= 8) {
                                    RegByMobileWaitingSMSUI.this.kLX.smoothScrollToPosition(RegByMobileWaitingSMSUI.this.xZZ.getCount() - 1);
                                } else {
                                    RegByMobileWaitingSMSUI.this.kLX.setSelection(RegByMobileWaitingSMSUI.this.xZZ.getCount() - 1);
                                }
                            }
                        });
                    }
                }
            };
            this.lFV.setMax(this.xZY);
            this.xZX.start();
        }
    }

    protected final int getLayoutId() {
        return R.i.dov;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        h.a((Context) this, getString(R.l.evC), "", getString(R.l.evD), getString(R.l.evE), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RegByMobileWaitingSMSUI.this.yae = true;
                RegByMobileWaitingSMSUI.this.finish();
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private synchronized void Ze(String str) {
        if (this.xZh != null) {
            this.xZh.cpf();
            this.xZh = null;
        }
        if (!(this.xZX == null || this.xZX == null)) {
            this.xZX.cancel();
            this.xZX = null;
        }
        if (!this.xZi) {
            this.xZi = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileWaitingSMSUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.RegByMobileWaitingSMSUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.xZh != null) {
                    this.xZh.cpg();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
