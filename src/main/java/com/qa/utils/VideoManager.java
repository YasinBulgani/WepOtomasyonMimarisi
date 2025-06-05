package com.qa.utils;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/**
 * Utility to record the desktop during test execution using
 * <a href="https://github.com/MonteMedia/MonteMedia">Monte Media</a>.
 */
public class VideoManager {

    private ScreenRecorder screenRecorder;

    /**
     * Starts capturing the entire screen to an AVI file under
     * <code>target/videos</code>.
     *
     * @param fileName base name of the video file (without extension)
     */
    public void startRecording(String fileName) throws IOException, AWTException {
        File outputDir = new File("target/videos");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, outputDir, fileName);
        screenRecorder.start();
    }

    /**
     * Stops the recording if it is running.
     */
    public void stopRecording() throws IOException {
        if (screenRecorder != null) {
            screenRecorder.stop();
        }
    }
}
