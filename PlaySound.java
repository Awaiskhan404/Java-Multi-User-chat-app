package client;
import java.io.*;
import sun.audio.*;

public class PlaySound {

//public static void main(String[] args) throws IOException {
//	PlaySound obj = new PlaySound("MsgReceived_tone.wav");
//}
	
	@SuppressWarnings("restriction")
	
	public PlaySound(String path) throws IOException {// open the sound file as a Java input stream
    String gongFile = path;
    InputStream in = new FileInputStream(gongFile);

    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
}
}