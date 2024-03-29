package poly.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.com.custom_interface.Speech;

@Controller
public class SpeechController {
	
    @Autowired
    @Qualifier("ENSpeech")
    Speech enSpeech;


    @Autowired
    @Qualifier("VNSpeech")
    Speech vnSpeech;

    @ResponseBody
    @GetMapping("/speak")
    public String speak() {
        return enSpeech.sayGreeString();
    }
	
	
}
