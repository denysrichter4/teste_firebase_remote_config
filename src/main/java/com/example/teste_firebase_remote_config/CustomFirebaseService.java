package com.example.teste_firebase_remote_config;

import com.google.firebase.remoteconfig.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class CustomFirebaseService {

    private Template template() throws ExecutionException, InterruptedException {
        return FirebaseRemoteConfig.getInstance().getTemplateAsync().get();
    }

    private Map<String, Parameter> getParameters(Template template) throws ExecutionException, InterruptedException {
        System.out.println("ETag from server: " + template.getParameters().toString());
        return template.getParameters();
    }

    private void setParameter(Template template, Map<String, Parameter> map) throws ExecutionException, InterruptedException {
        template.setParameters(map);
        System.out.println("ETag from server: " + template.getParameters().toString());
    }
    private void setConditions() throws ExecutionException, InterruptedException {
        template().getConditions().add(new Condition("android_en",
                "device.os == 'android' && device.country in ['us', 'uk']", TagColor.BLUE));
    }

    private void validateTemplate() throws ExecutionException, InterruptedException {
        FirebaseRemoteConfig.getInstance().validateTemplateAsync(template()).get();
        System.out.println("Template was valid and safe to use");
    }

    private void publishTemplate(Template template) throws ExecutionException, InterruptedException {
        FirebaseRemoteConfig.getInstance().publishTemplateAsync(template).get();
        System.out.println("Template has been published");
    }
    public void init(){
        try{
            var template  = template();
            var parameter = new HashMap<>(getParameters(template));
            //parameter.put("teste3", new Parameter().setDefaultValue(ParameterValue.of("testando")));
            //parameter.replace("teste2", new Parameter().setDefaultValue(ParameterValue.of("testando")));
            //setParameter(template, parameter);
            //publishTemplate(template);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
