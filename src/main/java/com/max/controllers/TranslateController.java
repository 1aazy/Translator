package com.max.controllers;

import com.max.util.LanguageForm;
import com.max.util.TranslationRequest;
import com.max.util.response.TranslationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/translate")
public class TranslateController {

    @Value("${systran.translation.key}")
    private String key;

    @GetMapping
    public String transaltePage(@ModelAttribute("languages") LanguageForm languageForm) {
        return "/translate";
    }

    @PostMapping
    public String doTranslate(@RequestParam("sourceText") String sourceText,
                              @RequestParam("targetText") String targetText,
                              @ModelAttribute("languages") LanguageForm languageForm,
                              Model model) {

        if (languageForm.getSourceLanguage().equals(languageForm.getTargetLanguage())) {
            targetText = sourceText;
            model.addAttribute("sourceText", sourceText);
            model.addAttribute("targetText", targetText);
            return "/translate";
        }

        String url = "https://api-translate.systran.net/translation/text/translate?key=" + key;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        TranslationRequest translationRequest =
                new TranslationRequest(sourceText, languageForm.getSourceLanguage(), languageForm.getTargetLanguage());

        HttpEntity<TranslationRequest> request = new HttpEntity<>(translationRequest, headers);

        TranslationResponse response = restTemplate.postForObject(url, request, TranslationResponse.class);

        targetText = response.getOutputs().get(0).getOutput();

        model.addAttribute("sourceText", sourceText);
        model.addAttribute("targetText", targetText);

        return "/translate";
    }
}
