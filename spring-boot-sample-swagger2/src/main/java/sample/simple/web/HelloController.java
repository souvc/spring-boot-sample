package sample.simple.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="用户界面类",description = "界面类描述", position = 100, protocols = "http")
@RestController
public class HelloController {

    @ApiIgnore
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }
    
    
    @ApiOperation(value="欢迎界面", notes="欢迎界面描述")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello swagger World";
    }
    

}