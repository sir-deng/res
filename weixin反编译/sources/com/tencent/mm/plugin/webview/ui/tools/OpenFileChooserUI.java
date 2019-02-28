package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class OpenFileChooserUI extends MMActivity {
    private int count;
    private ProgressDialog inI = null;
    private String jlF;
    private String jlG;
    private int mYR;
    private int mYq;
    private int rSU;
    private boolean tDn;
    private int tDo;
    private int tDp;
    private boolean tDq = false;
    private OnCancelListener tDr = null;

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        String str2 = null;
        if (openFileChooserUI.tDp == 0) {
            x.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.jlG)) {
            x.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.jlG);
        }
        if (file == null || !file.exists()) {
            x.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", openFileChooserUI.jlG);
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                openFileChooserUI.jlG = e.gJf + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.gJf == null || !e.gJf.endsWith("/")) {
                openFileChooserUI.jlG = e.gJf + "/" + str2 + ".jpeg";
            } else {
                openFileChooserUI.jlG = e.gJf + str2 + ".jpeg";
            }
            if (new File(openFileChooserUI.jlG).exists()) {
                x.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", openFileChooserUI.jlG);
                return;
            }
            x.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", openFileChooserUI.jlG);
            x.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", openFileChooserUI.jlG);
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                x.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", openFileChooserUI.jlG);
                return;
            }
            try {
                d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.jlG, true);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", openFileChooserUI.jlG);
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        if (TextUtils.isEmpty(openFileChooserUI.jlG)) {
            return "";
        }
        WebViewJSSDKFileItem OP = WebViewJSSDKFileItem.OP(openFileChooserUI.jlG);
        OP.jlG = openFileChooserUI.jlG;
        OP.iOD = true;
        OP.fuz = 1;
        f.bSo().b(OP);
        return OP.fvn;
    }

    static /* synthetic */ String m(String str, List list) {
        int[] iArr = new int[2];
        k.d(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        com.tencent.mm.plugin.sight.base.d.a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = e.gJf + "microMsg." + System.currentTimeMillis() + ".mp4";
        x.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, b.qzb, b.qza, 8, 2, 25.0f, (float) pInt4.value, null, 0, false)), Integer.valueOf(i), Integer.valueOf(i2));
        WebViewJSSDKFileItem OR = WebViewJSSDKFileItem.OR(str2);
        OR.width = i;
        OR.height = i2;
        OR.duration = r2;
        OR.size = com.tencent.mm.a.e.bN(str2);
        list.add(OR.fvn);
        f.bSo().b(OR);
        return OR.fvn;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        Intent intent;
        super.onCreate(bundle);
        this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
        if (this.count <= 0 || this.count > 9) {
            this.count = 9;
        }
        this.rSU = this.count;
        this.mYq = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
        this.mYR = getIntent().getIntExtra("query_media_type", 1);
        this.tDn = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
        this.tDo = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
        this.tDp = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
        if ((this.mYq == 7 && this.mYR == 2) || this.mYR == 3) {
            if (!bSY()) {
                u.makeText(this, getString(R.l.eXo), 1).show();
                this.tDq = true;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("key_send_raw_image", this.tDn);
            intent2.putExtra("query_media_type", this.mYR);
            int intExtra;
            int intExtra2;
            int i;
            if (this.tDp == 1) {
                if (this.tDo != Downloads.RECV_BUFFER_SIZE && (this.tDo & Downloads.RECV_BUFFER_SIZE) > 0) {
                    intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                    intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                    intent2.putExtra("KEY_SIGHT_PARAMS", AT(1));
                    intent2.putExtra("record_video_force_sys_camera", false);
                    intent2.putExtra("show_header_view", true);
                    intent2.putExtra("record_video_is_sight_capture", true);
                    intent2.putExtra("record_video_quality", intExtra);
                    intent2.putExtra("record_video_time_limit", intExtra2);
                    intent2.putExtra("video_full_path", this.jlF);
                    com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rSU, this.mYq, intent2);
                } else if (this.tDo == 16 || this.tDo == 256) {
                    intent2.putExtra("KEY_SIGHT_PARAMS", AT(1));
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Context) this, 6, intent2, 3, 1);
                } else if (this.tDo == Downloads.RECV_BUFFER_SIZE) {
                    intent2.putExtra("show_header_view", false);
                    com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rSU, this.mYq, intent2);
                }
            } else if (this.tDp == 2) {
                String oM = bi.oM(getIntent().getStringExtra("key_pick_local_media_sight_type"));
                if (this.tDo != Downloads.RECV_BUFFER_SIZE && (this.tDo & Downloads.RECV_BUFFER_SIZE) > 0) {
                    x.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                    setResult(1);
                    finish();
                } else if (this.tDo == 16 || this.tDo == 256) {
                    intExtra = 0;
                    if (oM.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE) && oM.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        intExtra = 0;
                    } else if (oM.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        intExtra = 1;
                    } else if (oM.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        intExtra = 2;
                    }
                    intent2.putExtra("KEY_SIGHT_PARAMS", AT(intExtra));
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Context) this, 7, intent2, 3, intExtra);
                } else if (this.tDo == Downloads.RECV_BUFFER_SIZE) {
                    i = 3;
                    if (oM.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE) && oM.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        i = 3;
                    } else if (oM.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        i = 1;
                    } else if (oM.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        i = 2;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_can_select_video_and_pic", true);
                    intent3.putExtra("key_send_raw_image", this.tDn);
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 8, this.rSU, this.mYq, i, false, intent3);
                }
            } else if (this.tDo != Downloads.RECV_BUFFER_SIZE && (this.tDo & Downloads.RECV_BUFFER_SIZE) > 0) {
                this.jlF = e.gJf + "microMsg." + System.currentTimeMillis() + ".mp4";
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent2.putExtra("record_video_force_sys_camera", true);
                intent2.putExtra("record_video_quality", intExtra);
                intent2.putExtra("record_video_time_limit", intExtra2);
                intent2.putExtra("video_full_path", this.jlF);
                com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rSU, this.mYq, intent2);
            } else if (this.tDo == 16 || this.tDo == 256) {
                this.jlF = e.gJf + "microMsg." + System.currentTimeMillis() + ".mp4";
                i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, this.jlF, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), i, this.tDo == 16);
            } else if (this.tDo == Downloads.RECV_BUFFER_SIZE) {
                intent2.putExtra("show_header_view", false);
                com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rSU, this.mYq, intent2);
            }
            if (this.tDo != Downloads.RECV_BUFFER_SIZE && (this.tDo & Downloads.RECV_BUFFER_SIZE) > 0) {
                obj = 1;
                if (obj == null) {
                    if (!bSY()) {
                        u.makeText(this, getString(R.l.eXo), 1).show();
                        this.tDq = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.tDn);
                    intent.putExtra("query_media_type", this.mYR);
                    switch (this.tDo) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rSU, this.mYq, intent);
                            return;
                        case 2:
                            h.a((Context) this, "", new String[]{getString(R.l.eXi)}, "", true, new c() {
                                public final void jo(int i) {
                                    x.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(OpenFileChooserUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")), bi.chl(), OpenFileChooserUI.this.mController.xRr);
                                    if (com.tencent.mm.pluginsdk.g.a.a(OpenFileChooserUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")) {
                                        com.tencent.mm.pluginsdk.ui.tools.k.c(OpenFileChooserUI.this.mController.xRr, e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                                    }
                                }
                            }, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    OpenFileChooserUI.this.setResult(0);
                                    OpenFileChooserUI.this.finish();
                                }
                            });
                            return;
                        case 3:
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mYq, intent);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            } else if (this.tDo == 16 || this.tDo == 256) {
                obj = 1;
                if (obj == null) {
                    if (bSY()) {
                        u.makeText(this, getString(R.l.eXo), 1).show();
                        this.tDq = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.tDn);
                    intent.putExtra("query_media_type", this.mYR);
                    switch (this.tDo) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rSU, this.mYq, intent);
                            return;
                        case 2:
                            h.a((Context) this, "", new String[]{getString(R.l.eXi)}, "", true, /* anonymous class already generated */, /* anonymous class already generated */);
                            return;
                        case 3:
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mYq, intent);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            } else if (this.tDo == Downloads.RECV_BUFFER_SIZE) {
                obj = 1;
                if (obj == null) {
                    if (bSY()) {
                        u.makeText(this, getString(R.l.eXo), 1).show();
                        this.tDq = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.tDn);
                    intent.putExtra("query_media_type", this.mYR);
                    switch (this.tDo) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rSU, this.mYq, intent);
                            return;
                        case 2:
                            h.a((Context) this, "", new String[]{getString(R.l.eXi)}, "", true, /* anonymous class already generated */, /* anonymous class already generated */);
                            return;
                        case 3:
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mYq, intent);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            }
        }
        obj = null;
        if (obj == null) {
            if (bSY()) {
                u.makeText(this, getString(R.l.eXo), 1).show();
                this.tDq = true;
            }
            intent = new Intent();
            intent.putExtra("key_send_raw_image", this.tDn);
            intent.putExtra("query_media_type", this.mYR);
            switch (this.tDo) {
                case 1:
                    intent.putExtra("show_header_view", false);
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rSU, this.mYq, intent);
                    return;
                case 2:
                    h.a((Context) this, "", new String[]{getString(R.l.eXi)}, "", true, /* anonymous class already generated */, /* anonymous class already generated */);
                    return;
                case 3:
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mYq, intent);
                    return;
                default:
                    x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                    setResult(0);
                    finish();
                    return;
            }
        }
    }

    private boolean bSY() {
        x.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", Long.valueOf(bi.eZ(this)));
        if (bi.eZ(this) <= 200) {
            return false;
        }
        return true;
    }

    private SightParams AT(int i) {
        String str = "microMsg_" + System.currentTimeMillis();
        this.jlF = e.gJf + str + ".mp4";
        this.jlG = e.gJf + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.owo = this.tDo == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.owp == null) {
            sightParams.owp = new VideoTransPara();
        }
        sightParams.owp.duration = intExtra;
        sightParams.j(str, this.jlF, this.jlG, e.gJf + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.OpenFileChooserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    com.tencent.mm.pluginsdk.ui.tools.k.c(this.mController.xRr, e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            OpenFileChooserUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, final int i2, final Intent intent) {
        File file = null;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.tDq);
            setResult(i2, intent2);
            finish();
            return;
        }
        String b;
        Intent intent3;
        ArrayList arrayList;
        SightCaptureResult sightCaptureResult;
        switch (i) {
            case 1:
            case 3:
                as.Dt().F(new Runnable() {
                    public final void run() {
                        List<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        ArrayList arrayList = new ArrayList();
                        for (String OP : stringArrayListExtra) {
                            WebViewJSSDKFileItem OP2 = WebViewJSSDKFileItem.OP(OP);
                            String str = OP2.fvn;
                            OP2.iOD = booleanExtra2;
                            f.bSo().b(OP2);
                            x.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", OP, str);
                            arrayList.add(str);
                        }
                        x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ai.X(arrayList));
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_pic_callback_local_ids", OP);
                        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                        intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.this.tDq);
                        OpenFileChooserUI.this.setResult(i2, intent);
                        OpenFileChooserUI.this.finish();
                    }
                });
                return;
            case 2:
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(this.mController.xRr.getApplicationContext(), intent, e.gJf);
                if (bi.oN(b)) {
                    x.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    return;
                }
                x.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", b);
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.tDn);
                intent3.putExtra("max_select_count", this.rSU);
                intent3.putExtra("query_source_type", this.mYq);
                arrayList = new ArrayList(1);
                arrayList.add(b);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                com.tencent.mm.bl.d.b(this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                return;
            case 4:
                List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    x.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    return;
                }
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", stringArrayListExtra.get(0));
                if (this.tDp == 1 && !sU(this.jlG)) {
                    x.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                PE((String) stringArrayListExtra.get(0));
                return;
            case 5:
                if (new File(this.jlF).exists()) {
                    PE(this.jlF);
                    return;
                }
                x.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", this.jlF);
                setResult(1);
                finish();
                return;
            case 6:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    x.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    }
                    this.jlF = sightCaptureResult.owh;
                    x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.jlF);
                    if (!sU(this.jlG) && sU(sightCaptureResult.owi)) {
                        this.jlG = sightCaptureResult.owi;
                    }
                    if (!TextUtils.isEmpty(this.jlF)) {
                        file = new File(this.jlF);
                    }
                    if (file == null || !file.exists()) {
                        x.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.jlF);
                    } else {
                        x.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.jlF);
                        PE(this.jlF);
                        return;
                    }
                }
                x.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 7:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    x.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    } else if (sightCaptureResult.owf) {
                        b = sightCaptureResult.own;
                        if (bi.oN(b)) {
                            x.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", b);
                            setResult(1);
                            finish();
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem OP = WebViewJSSDKFileItem.OP(b);
                        OP.iOD = true;
                        OP.fuz = 1;
                        f.bSo().b(OP);
                        arrayList2.add(OP.fvn);
                        x.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", b, OP.fvn);
                        x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ai.Y(arrayList2));
                        intent3 = new Intent();
                        intent3.putExtra("key_pick_local_media_local_ids", b);
                        intent3.putExtra("key_pick_local_media_callback_type", 2);
                        setResult(i2, intent3);
                        finish();
                        return;
                    } else {
                        File file2;
                        this.jlF = sightCaptureResult.owh;
                        x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.jlF);
                        if (!sU(this.jlG) && sU(sightCaptureResult.owi)) {
                            this.jlG = sightCaptureResult.owi;
                        }
                        if (TextUtils.isEmpty(this.jlF)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.jlF);
                        }
                        if (file2 == null || !file2.exists()) {
                            x.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.jlF);
                        } else {
                            x.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.jlF);
                            PE(this.jlF);
                            return;
                        }
                    }
                }
                x.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 8:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    List<String> stringArrayListExtra3 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra3 == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        finish();
                        return;
                    }
                    arrayList = new ArrayList();
                    for (String b2 : stringArrayListExtra3) {
                        WebViewJSSDKFileItem OP2 = WebViewJSSDKFileItem.OP(b2);
                        String str = OP2.fvn;
                        OP2.iOD = booleanExtra;
                        f.bSo().b(OP2);
                        x.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", b2, str);
                        arrayList.add(str);
                    }
                    x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ai.Y(arrayList));
                    intent3 = new Intent();
                    intent3.putExtra("key_pick_local_media_local_ids", b2);
                    intent3.putExtra("key_pick_local_media_show_memory_warning", this.tDq);
                    intent3.putExtra("key_pick_local_media_callback_type", 2);
                    setResult(i2, intent3);
                    finish();
                    return;
                }
                PE((String) stringArrayListExtra2.get(0));
                return;
            default:
                x.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", Integer.valueOf(i));
                setResult(1);
                finish();
                return;
        }
    }

    private void PE(final String str) {
        this.tDr = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                OpenFileChooserUI.this.setResult(0);
                OpenFileChooserUI.this.finish();
            }
        };
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.eXf), true, this.tDr);
        as.Dt().F(new Runnable() {
            public final void run() {
                List arrayList = new ArrayList();
                int a = OpenFileChooserUI.this.PG(str);
                if (a == -50002) {
                    ah.y(new Runnable() {
                        public final void run() {
                            if (OpenFileChooserUI.this.mYq == 7 && OpenFileChooserUI.this.mYR == 2) {
                                h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.l.eXg), OpenFileChooserUI.this.getString(R.l.dGZ), OpenFileChooserUI.this.getString(R.l.dFD), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        OpenFileChooserUI.this.setResult(1);
                                        OpenFileChooserUI.this.finish();
                                    }
                                });
                                return;
                            }
                            Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.l.eTo), 0).show();
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                        }
                    });
                    return;
                }
                String m;
                String d;
                if (a == -50006) {
                    m = OpenFileChooserUI.m(str, arrayList);
                    OpenFileChooserUI.b(OpenFileChooserUI.this, str);
                    d = OpenFileChooserUI.d(OpenFileChooserUI.this);
                } else if (a == 1) {
                    m = OpenFileChooserUI.this.PF(str);
                    OpenFileChooserUI.b(OpenFileChooserUI.this, str);
                    d = OpenFileChooserUI.d(OpenFileChooserUI.this);
                    if (bi.oN(m) && OpenFileChooserUI.this.mYq == 7 && OpenFileChooserUI.this.mYR == 2) {
                        ah.y(new Runnable() {
                            public final void run() {
                                h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.l.eXh), OpenFileChooserUI.this.getString(R.l.dGZ), OpenFileChooserUI.this.getString(R.l.dFD), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        OpenFileChooserUI.this.setResult(1);
                                        OpenFileChooserUI.this.finish();
                                    }
                                });
                            }
                        });
                        return;
                    }
                } else {
                    ah.y(new Runnable() {
                        public final void run() {
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                        }
                    });
                    return;
                }
                if (bi.oN(m)) {
                    ah.y(new Runnable() {
                        public final void run() {
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                        }
                    });
                } else {
                    ah.y(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("key_pick_local_media_callback_type", 1);
                            intent.putExtra("key_pick_local_media_local_id", m);
                            intent.putExtra("key_pick_local_media_thumb_local_id", d);
                            x.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", d);
                            OpenFileChooserUI.this.setResult(-1, intent);
                            OpenFileChooserUI.this.finish();
                        }
                    });
                }
            }
        });
    }

    private String PF(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            x.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e);
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            return null;
        }
        int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        mediaMetadataRetriever.release();
        WebViewJSSDKFileItem OR = WebViewJSSDKFileItem.OR(str);
        OR.duration = (i3 + 500) / 1000;
        OR.width = i;
        OR.height = i2;
        OR.size = com.tencent.mm.a.e.bN(str);
        if (this.tDp == 1) {
            OR.jlG = this.jlG;
        }
        f.bSo().b(OR);
        return OR.fvn;
    }

    private int PG(String str) {
        com.tencent.mm.compatible.j.a.a j;
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://" + str));
        com.tencent.mm.compatible.j.a.a aVar = null;
        ao.is2G(this);
        try {
            j = com.tencent.mm.compatible.j.a.j(this, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            x.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            return -50005;
        }
        int i;
        String str2 = j.filename;
        boolean oQ = com.tencent.mm.plugin.a.c.oQ(str2);
        x.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", Boolean.valueOf(oQ));
        int i2 = -10000;
        if (oQ) {
            i2 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 26214400, 300000.0d, Constants.MAX_BUFFER_SIZE);
            x.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", Integer.valueOf(i2));
        }
        if (i2 == -1 || !oQ) {
            x.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", Integer.valueOf(com.tencent.mm.a.e.bN(str2)));
            if (com.tencent.mm.a.e.bN(str2) > 26214400) {
                i2 = -1;
            } else {
                i2 = 1;
            }
        }
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return -50002;
            case 0:
                i = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i = 0;
                i2 = 1;
                break;
            default:
                x.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                return -50001;
        }
        if (i != 0) {
            i2 = -50006;
        }
        i = j.duration / 1000;
        x.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", str2, Integer.valueOf(i2), Integer.valueOf(i));
        return i2;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
    }

    private static boolean sU(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        x.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", str);
        if (file.exists()) {
            x.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            return true;
        }
        x.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        return false;
    }
}
