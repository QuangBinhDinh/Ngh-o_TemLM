/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;
import java.io.IOException;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
/**
 *
 * @author Win10
 */
public class VoiceSpeak {
    SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	
	public VoiceSpeak(String s) {
		//Let's speak in English
		speak(s);

	}
	public void speak(String text) {
		System.out.println(text);
		
		//Create a new Thread because JLayer is running on the current Thread and will make the application to lag
		Thread thread = new Thread(() -> {
			try {
				
				//Create a JLayer instance
				AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text));
				player.play();
				
				System.out.println("Successfully got back synthesizer data");
				
			} catch (IOException | JavaLayerException e) {
				System.out.println(e.getMessage()); //Print the exception s
			}
		});
		
		//We don't want the application to terminate before this Thread terminates
		thread.setDaemon(false);	
		//Start the Thread
		thread.start();	
	}
  
}
