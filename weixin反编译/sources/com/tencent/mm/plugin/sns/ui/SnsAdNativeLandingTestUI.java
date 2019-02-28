package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private int duration = 0;
    private ag hbP = new ag();
    private double qBh = 0.0d;
    private VideoSightView rEJ;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar rEK;
    private int rqU;
    private int videoHeight;
    private int videoWidth;

    private static class a extends AsyncTask<String, Void, Void> {
        private static Set<String> rrP = new HashSet();
        private static byte[] rrQ = new byte[0];
        final String fileName;
        final String filePath;
        final ag handler;
        final a rEP;
        final String rrR;
        final String rrS;
        final String rrT;
        final int rrV;

        interface a {
            void LE(String str);

            void LF(String str);

            void ci(String str, int i);
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return y((String[]) objArr);
        }

        public a(String str, String str2, ag agVar, a aVar) {
            this(str, str2, agVar, aVar, 0);
        }

        public a(String str, String str2, final ag agVar, final a aVar, int i) {
            FileOp.ml(str);
            this.rrT = str;
            this.fileName = str2;
            this.filePath = str + "/" + str2;
            this.rrS = "temp_" + str2;
            this.rrR = str + "/" + this.rrS;
            this.handler = agVar;
            this.rrV = i;
            this.rEP = new a() {
                public final void ci(final String str, final int i) {
                    agVar.post(new Runnable() {
                        public final void run() {
                            aVar.ci(str, i);
                        }
                    });
                }

                public final void LE(final String str) {
                    agVar.post(new Runnable() {
                        public final void run() {
                            aVar.LE(str);
                        }
                    });
                }

                public final void LF(final String str) {
                    agVar.post(new Runnable() {
                        public final void run() {
                            aVar.LF(str);
                        }
                    });
                }
            };
        }

        private Void y(String... strArr) {
            InputStream inputStream;
            OutputStream fileOutputStream;
            Exception e;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Exception exception;
            HttpURLConnection httpURLConnection2 = null;
            int i = 0;
            synchronized (rrQ) {
                if (rrP.contains(strArr[0])) {
                } else {
                    rrP.add(strArr[0]);
                    try {
                        if (FileOp.bO(this.filePath)) {
                            this.rEP.LF(this.filePath);
                            synchronized (rrQ) {
                                rrP.remove(strArr[0]);
                            }
                        } else {
                            if (FileOp.bO(this.rrR)) {
                                FileOp.deleteFile(this.rrR);
                            }
                            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                            try {
                                httpURLConnection3.connect();
                                if (httpURLConnection3.getResponseCode() != 200) {
                                    this.rEP.LE("Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    synchronized (rrQ) {
                                        rrP.remove(strArr[0]);
                                    }
                                } else {
                                    httpURLConnection3.getContentLength();
                                    inputStream = httpURLConnection3.getInputStream();
                                    try {
                                        fileOutputStream = new FileOutputStream(this.rrR);
                                    } catch (Exception e2) {
                                        fileOutputStream = null;
                                        HttpURLConnection httpURLConnection4 = httpURLConnection3;
                                        e = e2;
                                        httpURLConnection = httpURLConnection4;
                                        try {
                                            this.rEP.LE(e.getMessage());
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e3) {
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                    synchronized (rrQ) {
                                                        rrP.remove(strArr[0]);
                                                    }
                                                    return null;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (rrQ) {
                                                rrP.remove(strArr[0]);
                                            }
                                            return null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            httpURLConnection2 = httpURLConnection;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e4) {
                                                    if (httpURLConnection2 != null) {
                                                        httpURLConnection2.disconnect();
                                                    }
                                                    synchronized (rrQ) {
                                                        rrP.remove(strArr[0]);
                                                    }
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                            synchronized (rrQ) {
                                                rrP.remove(strArr[0]);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        fileOutputStream = null;
                                        httpURLConnection2 = httpURLConnection3;
                                        th = th3;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (rrQ) {
                                            rrP.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                    try {
                                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                        int i2 = 0;
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                            i2 += read;
                                            if (this.rrV != 0 && i2 - i >= this.rrV) {
                                                this.rEP.ci(this.rrR, i2);
                                                i = i2;
                                            }
                                        }
                                        FileOp.at(this.rrR, this.filePath);
                                        this.rEP.LF(this.filePath);
                                        try {
                                            fileOutputStream.close();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (IOException e5) {
                                        }
                                        if (httpURLConnection3 != null) {
                                            httpURLConnection3.disconnect();
                                        }
                                        synchronized (rrQ) {
                                            rrP.remove(strArr[0]);
                                        }
                                    } catch (Exception e22) {
                                        exception = e22;
                                        httpURLConnection = httpURLConnection3;
                                        e = exception;
                                        this.rEP.LE(e.getMessage());
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        synchronized (rrQ) {
                                            rrP.remove(strArr[0]);
                                        }
                                        return null;
                                    } catch (Throwable th32) {
                                        httpURLConnection2 = httpURLConnection3;
                                        th = th32;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (rrQ) {
                                            rrP.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e222) {
                                fileOutputStream = null;
                                inputStream = null;
                                exception = e222;
                                httpURLConnection = httpURLConnection3;
                                e = exception;
                            } catch (Throwable th322) {
                                fileOutputStream = null;
                                inputStream = null;
                                httpURLConnection2 = httpURLConnection3;
                                th = th322;
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                synchronized (rrQ) {
                                    rrP.remove(strArr[0]);
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        httpURLConnection = null;
                        fileOutputStream = null;
                        inputStream = null;
                        this.rEP.LE(e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        synchronized (rrQ) {
                            rrP.remove(strArr[0]);
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = null;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        synchronized (rrQ) {
                            rrP.remove(strArr[0]);
                        }
                        throw th;
                    }
                }
            }
            return null;
        }
    }

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.qBh = snsAdNativeLandingTestUI.rEJ.btQ();
        snsAdNativeLandingTestUI.rEJ.pause();
        snsAdNativeLandingTestUI.hbP.post(new Runnable() {
            public final void run() {
                SnsAdNativeLandingTestUI.this.rEK.dd(false);
            }
        });
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.rEJ.q(snsAdNativeLandingTestUI.qBh);
        snsAdNativeLandingTestUI.rEJ.start();
        snsAdNativeLandingTestUI.hbP.post(new Runnable() {
            public final void run() {
                SnsAdNativeLandingTestUI.this.rEK.dd(true);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ((Button) findViewById(f.qKd)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 259);
                intent.putExtra("select_is_ret", true);
                d.a(SnsAdNativeLandingTestUI.this, ".ui.transmit.SelectConversationUI", intent, 0, new com.tencent.mm.ui.MMActivity.a() {
                    public final void b(int i, int i2, Intent intent) {
                        if (i2 == -1) {
                            String str;
                            if (intent == null) {
                                str = null;
                            } else {
                                str = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str == null || str.length() == 0) {
                                x.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                                return;
                            }
                            final Context context = SnsAdNativeLandingTestUI.this;
                            com.tencent.mm.pluginsdk.ui.applet.r.a.vvh.a(((MMActivity) context).mController, "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", context.getResources().getString(j.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.title = "test title";
                                        wXMediaMessage.description = "test desc";
                                        IMediaObject wXWebpageObject = new WXWebpageObject();
                                        wXWebpageObject.canvasPageXml = "<xml></xml>";
                                        wXWebpageObject.webpageUrl = "http://www.baidu.com/";
                                        wXMediaMessage.mediaObject = wXWebpageObject;
                                        Bitmap bitmap = ac.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
                                        if (!(bitmap == null || bitmap.isRecycled())) {
                                            x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        b orVar = new or();
                                        orVar.fHs.fzX = wXMediaMessage;
                                        orVar.fHs.toUser = str;
                                        orVar.fHs.fHt = 49;
                                        orVar.fHs.fHu = "";
                                        orVar.fHs.fHv = "";
                                        com.tencent.mm.sdk.b.a.xmy.m(orVar);
                                        if (!TextUtils.isEmpty(str)) {
                                            b otVar = new ot();
                                            otVar.fHD.fHE = str;
                                            otVar.fHD.content = str;
                                            otVar.fHD.type = s.hs(str);
                                            otVar.fHD.flags = 0;
                                            com.tencent.mm.sdk.b.a.xmy.m(otVar);
                                        }
                                        h.bu(context, context.getString(j.dGR));
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(f.qKc);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.xRr.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.mController.xRr.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + com.tencent.mm.sdk.platformtools.ac.VF("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + com.tencent.mm.sdk.platformtools.ac.VF("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(g.qMW, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(f.qJN);
        this.rEJ = new VideoSightView(this.mController.xRr);
        this.rEJ.cR(false);
        viewGroup2.addView(this.rEJ, 0, new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BackwardSupportUtil.b.b(this.mController.xRr, this.mController.xRr.getResources().getDimension(i.d.qEM));
        this.rEK = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.mController.xRr);
        this.rEK.setVisibility(0);
        this.rEJ.ii(true);
        ((ViewGroup) inflate).addView(this.rEK, layoutParams);
        this.rEK.qAn = new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void ahn() {
            }

            public final void kK(int i) {
                x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time " + i);
                SnsAdNativeLandingTestUI.this.qBh = (double) i;
                SnsAdNativeLandingTestUI.this.rEJ.q((double) i);
            }
        };
        this.rEK.h(new OnClickListener() {
            public final void onClick(View view) {
                if (SnsAdNativeLandingTestUI.this.rEJ.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
                } else {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
            }
        });
        this.rEK.dd(this.rEJ.isPlaying());
        this.rEK.setVisibility(0);
        this.rEK.seek(0);
        this.rEJ.qAJ = new com.tencent.mm.pluginsdk.ui.tools.f.a() {
            public final void hY() {
                if (SnsAdNativeLandingTestUI.this.rEK.fwB) {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
            }

            public final void onError(int i, int i2) {
                SnsAdNativeLandingTestUI.this.rEJ.stop();
            }

            public final void vi() {
            }

            public final int ck(final int i, final int i2) {
                ah.y(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            SnsAdNativeLandingTestUI.this.duration = i2;
                            SnsAdNativeLandingTestUI.this.rqU = i2;
                        }
                        if (SnsAdNativeLandingTestUI.this.rEK.qAu != i2) {
                            SnsAdNativeLandingTestUI.this.rEK.wD(i2);
                        }
                        SnsAdNativeLandingTestUI.this.rEK.seek(i);
                    }
                });
                return 0;
            }

            public final void cl(int i, int i2) {
                SnsAdNativeLandingTestUI.this.videoWidth = i;
                SnsAdNativeLandingTestUI.this.videoHeight = i2;
            }
        };
        this.rEJ.rsy = false;
        this.rEJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!"".equals(SnsAdNativeLandingTestUI.this.rEJ.qAD.qzp) && SnsAdNativeLandingTestUI.this.rEJ.qAD.qzp != null) {
                    if (SnsAdNativeLandingTestUI.this.rEK.getVisibility() == 0) {
                        SnsAdNativeLandingTestUI.this.rEK.setVisibility(4);
                    } else {
                        SnsAdNativeLandingTestUI.this.rEK.setVisibility(0);
                    }
                }
            }
        });
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.rEJ.post(new Runnable() {
            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (SnsAdNativeLandingTestUI.this.mController.xRr instanceof MMActivity) {
                    ((MMActivity) SnsAdNativeLandingTestUI.this.mController.xRr).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    SnsAdNativeLandingTestUI.this.rEJ.wB(displayMetrics.widthPixels);
                }
                SnsAdNativeLandingTestUI.this.rEJ.requestLayout();
                SnsAdNativeLandingTestUI.this.rEJ.postInvalidate();
            }
        });
        new a(str2, str3, ae.aOA(), new a() {
            public final void ci(String str, int i) {
            }

            public final void LE(String str) {
            }

            public final void LF(String str) {
                SnsAdNativeLandingTestUI.this.rEJ.E(BitmapFactory.decodeFile(str));
            }
        }).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new a(str2, str, ae.aOA(), new a() {
            public final void ci(String str, int i) {
                if (!SnsAdNativeLandingTestUI.this.rEJ.isPlaying()) {
                    SnsAdNativeLandingTestUI.this.rEJ.cR(false);
                    if (!str.equals(SnsAdNativeLandingTestUI.this.rEJ.qAD.qzp)) {
                        SnsAdNativeLandingTestUI.this.rEJ.setVideoPath(str);
                    }
                    if (SnsAdNativeLandingTestUI.this.rEK.fwB) {
                        SnsAdNativeLandingTestUI.this.rEJ.q(SnsAdNativeLandingTestUI.this.qBh);
                        SnsAdNativeLandingTestUI.this.rEJ.start();
                    }
                }
            }

            public final void LE(String str) {
                x.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
            }

            public final void LF(String str) {
                SnsAdNativeLandingTestUI.this.rEJ.setVideoPath(str);
                SnsAdNativeLandingTestUI.this.rEJ.cR(true);
                if (SnsAdNativeLandingTestUI.this.rEK.fwB) {
                    SnsAdNativeLandingTestUI.this.rEJ.q(SnsAdNativeLandingTestUI.this.qBh);
                    SnsAdNativeLandingTestUI.this.rEJ.start();
                }
            }
        }, Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
    }

    protected final int getLayoutId() {
        return g.qNb;
    }
}
