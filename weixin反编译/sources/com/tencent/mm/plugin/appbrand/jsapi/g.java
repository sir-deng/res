package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateRecorder;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument;
import com.tencent.mm.plugin.appbrand.jsapi.file.aa;
import com.tencent.mm.plugin.appbrand.jsapi.file.ab;
import com.tencent.mm.plugin.appbrand.jsapi.file.ac;
import com.tencent.mm.plugin.appbrand.jsapi.file.ad;
import com.tencent.mm.plugin.appbrand.jsapi.file.ae;
import com.tencent.mm.plugin.appbrand.jsapi.file.af;
import com.tencent.mm.plugin.appbrand.jsapi.file.ag;
import com.tencent.mm.plugin.appbrand.jsapi.file.ah;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.q;
import com.tencent.mm.plugin.appbrand.jsapi.file.r;
import com.tencent.mm.plugin.appbrand.jsapi.file.s;
import com.tencent.mm.plugin.appbrand.jsapi.file.t;
import com.tencent.mm.plugin.appbrand.jsapi.file.u;
import com.tencent.mm.plugin.appbrand.jsapi.file.v;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsapi.file.x;
import com.tencent.mm.plugin.appbrand.jsapi.file.y;
import com.tencent.mm.plugin.appbrand.jsapi.file.z;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.media.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.storage.a;
import com.tencent.mm.plugin.appbrand.jsapi.storage.b;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.plugin.appbrand.jsapi.storage.f;
import com.tencent.mm.plugin.appbrand.jsapi.storage.h;
import com.tencent.mm.plugin.appbrand.jsapi.storage.i;
import com.tencent.mm.plugin.appbrand.jsapi.storage.j;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiDownloadSilkVoice;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiGetResPath;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiUploadSilkVoice;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiVoiceSplitJoint;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static Map<String, e> jfp;
    private static Map<String, e> jfq;

    public static Map<String, e> afJ() {
        jfp = new HashMap();
        a(new a());
        a(new c());
        a(new i());
        a(new b());
        a(new f());
        a(new j());
        a(new JsApiLogin());
        a(new JsApiAuthorize());
        a(new JsApiOperateWXData());
        a(new bd());
        a(new ak());
        a(new ax());
        a(new aj());
        a(new at());
        a(new JsApiChooseImage());
        a(new d());
        a(new JsApiChooseVideo());
        a(new JsApiStartRecordVoice());
        a(new JsApiStopRecordVoice());
        a(new JsApiStartPlayVoice());
        a(new JsApiPausePlayVoice());
        a(new JsApiStopPlayVoice());
        a(new JsApiGetLocation());
        a(new e());
        a(new aa());
        a(new JsApiGetMusicPlayerState());
        a(new JsApiOperateMusicPlayer());
        a(new JsApiScanCode());
        a(new aq());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.e());
        a(new al());
        a(new com.tencent.mm.plugin.appbrand.jsapi.j.a());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.i());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.contact.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.contact.e());
        a(new bl());
        a(new bi());
        a(new ae());
        a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.e());
        a(new ad());
        a(new com.tencent.mm.plugin.appbrand.jsapi.j.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.j.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.j.c());
        a(new bn());
        a(new com.tencent.mm.plugin.appbrand.jsapi.e.e());
        a(new ab());
        a(new com.tencent.mm.plugin.appbrand.jsapi.e.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.k.a());
        a(new com.tencent.mm.plugin.appbrand.jsapi.k.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.g());
        a(new h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.c.a());
        a(new s());
        a(new com.tencent.mm.plugin.appbrand.jsapi.i.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.i.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.i.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.i.a());
        a(new w());
        a(new ai());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.lbs.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.media.c());
        a(new JsApiRefreshSession());
        a(new bm());
        a(new com.tencent.mm.plugin.appbrand.jsapi.map.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.map.j());
        a(new m());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.f());
        a(new o());
        a(new am());
        a(new JsApiMakeVoIPCall());
        a(new y());
        a(new JsApiSetClipboardData());
        a(new l());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.h());
        a(new n());
        a(new o());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.i());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.m());
        a(new p());
        a(new k());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.j());
        a(new JsApiLaunchMiniProgram());
        a(new aw());
        a(new JsApiChooseWeChatContact());
        a(new JsApiChooseMedia());
        a(new JsApiUploadEncryptedFileToCDN());
        a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b());
        a(new ar());
        a(new bp());
        a(new JsApiGetBackgroundAudioState());
        a(new JsApiSetBackgroundAudioState());
        a(new JsApiOperateBackgroundAudio());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.b());
        a(new as());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.contact.a());
        a(new JsApiOpenWeRunSetting());
        a(new JsApiUploadWeRunData());
        a(new p());
        a(new ac());
        a(new be());
        a(new br());
        a(new bs());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.i());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.d.d());
        a(new JsApiCheckIsSupportFaceDetect());
        a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.video.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.live.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.media.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.media.f());
        a(new JsApiGetSetting());
        a(new an());
        a(new com.tencent.mm.plugin.appbrand.jsapi.share.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
        a(new ba());
        a(new t());
        a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.map.g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.map.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.op_report.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
        a(new az());
        a(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
        a(new bo());
        a(new bc());
        a(new JsApiCheckIsSupportSoterAuthentication());
        a(new com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b());
        a(new u());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.i());
        a(new bq());
        a(new JsApiBatchGetContact());
        a(new com.tencent.mm.plugin.appbrand.jsapi.camera.h());
        a(new bk());
        a(new JsApiOperateRecorder());
        a(new JsApiCreateAudioInstance());
        a(new JsApiSetAudioState());
        a(new JsApiGetAudioState());
        a(new JsApiOperateAudio());
        a(new JsApiDestroyInstanceAudio());
        a(new JsApiNavigateBackApplication());
        a(new com.tencent.mm.plugin.appbrand.jsapi.lbs.d());
        a(new JsApiCheckBioEnrollment());
        a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.a());
        a(new JsApiNavigateToDevMiniProgram());
        a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.b());
        a(new bf());
        a(new bh());
        a(new bg());
        a(new af());
        a(new bj());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.f.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.g());
        a(new bb());
        a(new JsApiVoiceSplitJoint());
        a(new JsApiUploadSilkVoice());
        a(new JsApiDownloadSilkVoice());
        a(new JsApiGetResPath());
        a(new com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a());
        a(new ac());
        a(new ad());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.m());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.n());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.o());
        a(new x());
        a(new w());
        a(new ai());
        a(new s());
        a(new u());
        a(new ab());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.h());
        a(new af());
        a(new q());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.l());
        a(new JsApiOpenDocument());
        a(new v());
        a(new ah());
        a(new r());
        a(new t());
        a(new aa());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.g());
        a(new ae());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.p());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.k());
        a(new ag());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.i());
        a(new com.tencent.mm.plugin.appbrand.jsapi.file.j());
        a(new y());
        a(new z());
        a(new JsApiUpdateApp());
        a(new q());
        a(new r());
        a(new ap());
        a(new x());
        a(new JsApiLaunchApplication());
        a(new JsApiAddNativeDownloadTask());
        a(new com.tencent.mm.plugin.appbrand.jsapi.g.d());
        a(new JsApiAddDownloadTaskStraight());
        a(new JsApiQueryDownloadTask());
        a(new JsApiInstallDownloadTask());
        a(new JsApiPauseDownloadTask());
        a(new JsApiResumeDownloadTask());
        a(new JsApiGetInstallState());
        a(new JsApiWriteCommData());
        return jfp;
    }

    public static Map<String, e> afK() {
        jfq = new HashMap();
        b(new ao());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.i());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.k());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.n());
        b(new com.tencent.mm.plugin.appbrand.jsapi.e.f());
        b(new com.tencent.mm.plugin.appbrand.jsapi.e.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.e.g());
        b(new com.tencent.mm.plugin.appbrand.jsapi.e.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.e.h());
        b(new com.tencent.mm.plugin.appbrand.jsapi.e.d());
        b(new ag());
        b(new com.tencent.mm.plugin.appbrand.jsapi.j.a());
        b(new com.tencent.mm.plugin.appbrand.jsapi.j.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.j.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.j.c());
        b(new ay());
        b(new bn());
        b(new com.tencent.mm.plugin.appbrand.jsapi.h.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.h.f());
        b(new z());
        b(new ab());
        b(new com.tencent.mm.plugin.appbrand.jsapi.video.a());
        b(new com.tencent.mm.plugin.appbrand.jsapi.video.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.video.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.video.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.i());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.g());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.e());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.h());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.f());
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.c.e());
        b(new com.tencent.mm.plugin.appbrand.jsapi.c.f());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.a());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.l());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.h());
        b(new com.tencent.mm.plugin.appbrand.jsapi.map.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.contact.c());
        b(new JsApiPrivateAddContact());
        b(new av());
        b(new v());
        b(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
        b(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
        b(new bp());
        b(new bs());
        b(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
        b(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.a.e());
        b(new com.tencent.mm.plugin.appbrand.jsapi.h.e());
        b(new com.tencent.mm.plugin.appbrand.jsapi.h.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.h.g());
        b(new bo());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.b());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
        b(new com.tencent.mm.plugin.appbrand.jsapi.camera.f());
        b(new com.tencent.mm.plugin.appbrand.jsapi.camera.j());
        b(new com.tencent.mm.plugin.appbrand.jsapi.camera.i());
        b(new com.tencent.mm.plugin.appbrand.debugger.d());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.a());
        b(new com.tencent.mm.plugin.appbrand.jsapi.n.f());
        b(new com.tencent.mm.plugin.appbrand.jsapi.n.h());
        b(new com.tencent.mm.plugin.appbrand.jsapi.n.g());
        b(new com.tencent.mm.plugin.appbrand.jsapi.l.b());
        b(new au());
        b(new JsApiAdDataReport());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
        b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
        return jfq;
    }

    private static void a(e eVar) {
        if (!bi.oN(eVar.getName())) {
            jfp.put(eVar.getName(), eVar);
        }
    }

    private static void b(e eVar) {
        if (!bi.oN(eVar.getName())) {
            jfq.put(eVar.getName(), eVar);
        }
    }
}
