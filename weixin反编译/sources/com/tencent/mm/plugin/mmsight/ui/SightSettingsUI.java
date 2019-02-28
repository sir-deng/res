package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private ListView ipH;
    private d mlo = new d(this);
    private a oIP;
    private LinkedList<b> oIQ = new LinkedList();
    private CaptureMMProxy owG;

    class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            return SightSettingsUI.this.oIQ.size();
        }

        public final Object getItem(int i) {
            return SightSettingsUI.this.oIQ.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View textView = new TextView(SightSettingsUI.this);
            final b bVar = (b) getItem(i);
            textView.setText(bVar.oIU + "->:" + bVar.tu(((Integer) bVar.oIR.owG.get(bVar.oIX, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    b bVar = bVar;
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    for (int i = 0; i < bVar.oIV.length; i++) {
                        linkedList.add(bVar.oIV[i]);
                        linkedList2.add(Integer.valueOf(i));
                    }
                    h.a(bVar.oIR, "", linkedList, linkedList2, "", new h.d() {
                        public final void cr(int i, int i2) {
                            SightSettingsUI.this.owG.set(b.this.oIX, Integer.valueOf(b.this.oIW[i]));
                            SightSettingsUI.this.oIP.notifyDataSetChanged();
                        }
                    });
                }
            });
            return textView;
        }
    }

    class b {
        public String oIU;
        String[] oIV;
        int[] oIW;
        com.tencent.mm.storage.w.a oIX;

        public b(String str, com.tencent.mm.storage.w.a aVar, String[] strArr, int[] iArr) {
            this.oIU = str;
            this.oIV = strArr;
            this.oIX = aVar;
            this.oIW = iArr;
        }

        final String tu(int i) {
            int i2 = 0;
            while (i2 < this.oIW.length) {
                if (i == this.oIW[i2] && i2 < this.oIV.length) {
                    return this.oIV[i2];
                }
                i2++;
            }
            return this.oIV[0];
        }
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("打开测试信息", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("对焦方案", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("裁剪方案", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("是否把双通音频压成单通道", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("Thread", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("裁剪预览MediaPlayer", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, new String[]{"default", "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("音频录制方案", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oIQ.add(new b("预设配置", com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转", "MediaCodec+1080p双倍码率+后压+实时压缩"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        sightSettingsUI.ipH = (ListView) sightSettingsUI.findViewById(com.tencent.mm.plugin.u.a.d.ctk);
        sightSettingsUI.oIP = new a();
        sightSettingsUI.ipH.setAdapter(sightSettingsUI.oIP);
    }

    protected final int getLayoutId() {
        return e.oKF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.owG = new CaptureMMProxy(this.mlo);
        this.mlo.I(new Runnable() {
            public final void run() {
                x.i("MicroMsg.SightSettingsUI", "has connect");
                SightSettingsUI.a(SightSettingsUI.this);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SightSettingsUI.this.finish();
                return false;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.mlo.release();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
