package syn.study.Lesson4_1_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import syn.study.Lesson4_1_2.services.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService service;

    @GetMapping()
    public Boolean getRootTest() {
        return true;
    }

    @GetMapping("/getApple/{count}")
    public List<String> getApple(@PathVariable("count") int count) {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ret.add(service.appleName + i);
        }
        return ret;
    }

    @PostMapping("/setAppleName")
    public boolean setAppleName(@RequestBody() Map<String, Object> body) {
        try {
            if (body.containsKey("name")) {
               return service.setAppleName((String) body.get("name"));

            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}