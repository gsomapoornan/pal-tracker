package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    Map<String,String> envVariables=new HashMap(0);
    String PORT,MEMORY_LIMIT,CF_INSTANCE_INDEX,CF_INSTANCE_ADDR; 

    @GetMapping("/env")
    public Map<String, String> getEnv()
    {
        envVariables.put("PORT",PORT);
        envVariables.put("MEMORY_LIMIT",MEMORY_LIMIT);
        envVariables.put("CF_INSTANCE_INDEX",CF_INSTANCE_INDEX);
        envVariables.put("CF_INSTANCE_ADDR",CF_INSTANCE_ADDR);
        return envVariables;

    }

    public EnvController(@Value("${PORT:NOT SET}")String port, @Value("${MEMORY_LIMIT:NOT SET}")String memoeryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String index, @Value("${CF_INSTANCE_ADDR:NOT SET}")String addr) {

this.PORT=port;
this.MEMORY_LIMIT=memoeryLimit;
this.CF_INSTANCE_INDEX=index;
this.CF_INSTANCE_ADDR=addr;
    }
}
