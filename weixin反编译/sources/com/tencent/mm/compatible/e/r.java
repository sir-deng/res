package com.tencent.mm.compatible.e;

import com.tencent.mm.compatible.i.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class r {
    r() {
    }

    public static boolean a(String str, o oVar, c cVar, b bVar, k kVar, v vVar, z zVar, s sVar, u uVar, x xVar, t tVar, a aVar) {
        try {
            x.d("MicroMsg.DeviceInfoParser", "xml: " + str);
            Map y = bj.y(str, "deviceinfoconfig");
            if (y == null) {
                x.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                return false;
            }
            if (y.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                oVar.gHs = bi.getInt((String) y.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                oVar.gHr = true;
            }
            if (y.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                oVar.gHt = bi.getInt((String) y.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                oVar.gHr = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.num") != null) {
                cVar.gFB = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.num"), 0);
                cVar.gFC = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.surface") != null) {
                cVar.gFD = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.surface"), 0);
                cVar.gFE = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.format") != null) {
                cVar.gFF = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.format"), 0);
                cVar.ana = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                cVar.gFI.gGi = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                cVar.gFI.fps = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                cVar.gFI.gGj = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                cVar.gFI.fGt = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                cVar.gFI.gGk = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                cVar.gFI.width = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                cVar.gFI.height = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                cVar.gFJ = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                cVar.gFG.gGi = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                cVar.gFG.fps = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                cVar.gFG.gGj = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                cVar.gFG.fGt = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                cVar.gFG.gGk = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                cVar.gFG.width = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                cVar.gFG.height = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                cVar.gFH = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                cVar.gFL = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                cVar.gFK = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                cVar.gFM = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                cVar.gFK = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                cVar.gFN = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                cVar.gFK = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                cVar.gFO = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                cVar.gFK = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.gFP = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.gFQ = true;
                cVar.gFK = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.gFS = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.gFR = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                cVar.gFT = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                cVar.gFU = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                cVar.gGg = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                cVar.gGh = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.gFP = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.gFQ = true;
                cVar.gFK = true;
            }
            if (y.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.gFS = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.gFR = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                cVar.gFV = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                cVar.gFW = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                cVar.gFX = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                cVar.gFY = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                cVar.gFZ = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                cVar.gGa = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                cVar.gGc = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                cVar.gGd = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                cVar.gGe = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                cVar.gGf = bi.getInt((String) y.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                bVar.gEs = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.smode") != null) {
                bVar.gEt = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.smode"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.omode") != null) {
                bVar.gEu = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.omode"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                bVar.gEv = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.operating") != null) {
                bVar.gEw = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.operating"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                bVar.gEx = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                bVar.gEy = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                bVar.gEr = true;
            }
            if (y.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                bVar.gEz = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.gEA = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                bVar.gEB = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                bVar.gEC = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                bVar.gED = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                bVar.gEQ = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                bVar.gEP = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                bVar.gER = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                bVar.gES = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                bVar.gET = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                bVar.gEU = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                bVar.gEV = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                bVar.gEX = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                bVar.gEY = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                bVar.gEZ = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                bVar.gFa = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                bVar.gFb = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                bVar.gFc = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                bVar.gFd = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                bVar.gFe = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                bVar.gFf = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                bVar.gFg = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                bVar.gFh = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                bVar.gFi = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                bVar.gEE = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                bVar.gEF = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                bVar.gEG = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                bVar.gEH = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                bVar.gEK = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                bVar.gEL = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                bVar.gEM = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                bVar.gEN = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                bVar.gFj = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                bVar.gFk = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                bVar.gFm[0] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                bVar.gFm[1] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                bVar.gFm[2] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                bVar.gFm[3] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                bVar.gFm[4] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                bVar.gFm[5] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                bVar.gFm[6] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                bVar.gFm[7] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                bVar.gFm[8] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                bVar.gFm[9] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                bVar.gFm[10] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                bVar.gFm[11] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                bVar.gFm[12] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                bVar.gFm[13] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                bVar.gFm[14] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                bVar.gFl = 1;
            }
            if (y.get(".deviceinfoconfig.voip.audio.correctoff") != null && bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                bVar.gFl = 0;
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                bVar.gEI = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                bVar.gEJ = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                bVar.gFn[0] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                bVar.gFn[1] = (short) bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                bVar.gFx = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                bVar.gFy = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                bVar.gFz = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                bVar.gFA = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                bVar.gFp = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                bVar.gEO = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.gEA = bi.getInt((String) y.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                bVar.gFr = bi.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                bVar.gFq = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                bVar.gFs = bi.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                bVar.gFq = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                bVar.gFt = bi.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                bVar.gFq = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                bVar.gFu = bi.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                bVar.gFq = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                bVar.gFv = bi.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                bVar.gFq = true;
            }
            if (y.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                bVar.gFw = bi.getInt((String) y.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                bVar.gFq = true;
            }
            if (y.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.gGv = true;
                kVar.gGw = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.gGn = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                kVar.gGo = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                kVar.gGp = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                kVar.gGr = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                kVar.gGq = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                kVar.gGs = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                kVar.gGu = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                kVar.gGt = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.app") != null) {
                kVar.gGx = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                kVar.gGQ = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                kVar.gGR = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                kVar.gGS = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                kVar.gGT = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                kVar.gGy = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                kVar.gGz = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                kVar.gGA = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                kVar.gGB = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.linespe") != null) {
                kVar.gGC = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                kVar.gGN = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                kVar.gGD = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                kVar.gGE = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                kVar.gGF = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                kVar.gGI = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                kVar.gGH = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.gGJ = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.gGK = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                kVar.gGG = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.gGJ = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.gGK = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.base") != null) {
                kVar.gGU = (String) y.get(".deviceinfoconfig.voip.common.base");
            }
            if (y.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                kVar.gGV = (String) y.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (y.get(".deviceinfoconfig.voip.common.classloader") != null) {
                kVar.gGW = (String) y.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (y.get(".deviceinfoconfig.voip.common.resources") != null) {
                kVar.gGX = (String) y.get(".deviceinfoconfig.voip.common.resources");
            }
            if (y.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                kVar.gGL = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                kVar.gGY = (String) y.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                kVar.gGZ = (String) y.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                kVar.gHa = (String) y.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                kVar.gHb = (String) y.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                kVar.gHc = (String) y.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (y.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                kVar.gHd = (String) y.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (y.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                kVar.gGM = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                kVar.gHe = (String) y.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (y.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                kVar.gHf = (String) y.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (y.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == bi.getInt((String) y.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.xqx = true;
            }
            if (y.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.xqy = bi.getDouble((String) y.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (y.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                kVar.gHg = (String) y.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (y.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                kVar.gHh = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                kVar.gHi = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (y.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                kVar.gHj = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                a.bk(kVar.gHj == 1);
            }
            if (y.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                kVar.gHk = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (y.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                kVar.gGO = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                kVar.gGP = bi.getDouble((String) y.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (y.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                kVar.gHl = bi.getInt((String) y.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                vVar.gIj = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                vVar.mVideoWidth = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                vVar.mVideoHeight = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                vVar.gIk = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                vVar.gIl = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                vVar.gIm = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                vVar.gIn = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                vVar.gIo = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                vVar.gIp = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                vVar.gIq = bi.getInt((String) y.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (y.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                zVar.gIv = bi.getInt((String) y.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (y.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                zVar.gIw = bi.getInt((String) y.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                x.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(zVar.gIw));
                ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", zVar.gIw).commit();
            }
            kVar.dump();
            int i = bi.getInt((String) y.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = bi.getInt((String) y.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            x.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (sVar != null) {
                sVar.fK(i);
                sVar.fJ(i2);
            }
            x.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(bi.getInt((String) y.get(".deviceinfoconfig.soter.isSupport"), 0)));
            if (xVar != null) {
                xVar.bi(i2 == 1);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) y.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (uVar != null) {
                uVar.eL(r2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", bj.y(str, "manufacturerName"));
            if (uVar != null) {
                uVar.i(r2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(bi.getInt((String) y.get(".deviceinfoconfig.style.swipback"), 0)));
            if (uVar != null) {
                uVar.fL(i2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", Integer.valueOf(bi.getInt((String) y.get(".deviceinfoconfig.game.isLimit"), 0)), (String) y.get(".deviceinfoconfig.game.limitPrompt"));
            if (aVar != null) {
                aVar.bg(i == 1);
                aVar.eH(r2);
            }
            i = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            int i3 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            int i4 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i5 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i6 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i7 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i8 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            int i9 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            int i10 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.useMetering"), -1);
            int i11 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
            i2 = bi.getInt((String) y.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
            if (tVar != null) {
                tVar.gHU = i;
                tVar.gHV = i3;
                tVar.gHW = i4;
                tVar.gHX = i5;
                tVar.gHY = i6;
                tVar.gHZ = i7;
                tVar.gIa = i8;
                tVar.gIb = i9;
                tVar.gIc = i10;
                tVar.gId = i11;
                tVar.gIe = i2;
                x.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", tVar.toString());
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfoParser", e, "", new Object[0]);
            return false;
        }
    }
}
