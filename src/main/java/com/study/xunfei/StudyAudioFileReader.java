package com.study.xunfei;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.InputStream;

public class StudyAudioFileReader extends MpegAudioFileReader {

    @Override
    public AudioFileFormat getAudioFileFormat(InputStream inputStream, long mediaLength) throws UnsupportedAudioFileException, IOException {
        return super.getAudioFileFormat(inputStream, inputStream.available() - 1);
    }

    @Override
    protected AudioInputStream getAudioInputStream(InputStream inputStream, long lFileLengthInBytes) throws UnsupportedAudioFileException, IOException {
        return super.getAudioInputStream(inputStream, inputStream.available());
    }
}
