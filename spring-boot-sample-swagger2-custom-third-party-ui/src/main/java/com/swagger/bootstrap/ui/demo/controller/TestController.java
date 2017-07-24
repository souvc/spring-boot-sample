package com.swagger.bootstrap.ui.demo.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.swagger.bootstrap.ui.demo.common.RestMessage;
import com.swagger.bootstrap.ui.demo.domain.ReqEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/***
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/04/20 14:01
 */
@Api(value = "测试",tags = "测试用例")
@RestController
@RequestMapping("/api/test")
public class TestController {

    /*@ApiOperation(value = "测试接口1",notes = "测试说明1")
    @GetMapping(value = "/xdf_{code}")
    @ApiImplicitParams({@ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "path"),@ApiImplicitParam(name = "st",value = "st",dataType = "boolean")})
    public RestMessage urlpath(@PathVariable(value = "code") String code, Boolean st){
        return new RestMessage(code);
    }

    @ApiOperation(value = "测试接口2",notes = "测试说明2")
    @PostMapping(value = "/gxx_code")
    @ApiImplicitParams({@ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "path"),@ApiImplicitParam(name = "st",value = "st",dataType = "boolean")})
    public RestMessage gxx_code(String code, Boolean st){
        return new RestMessage(code);
    }

*/
    @ApiOperation(value = "puttest",notes = "puttest测试说明2")
    @PutMapping(value = "/puttest")
    @ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "query")
    public RestMessage puttest(String code){
        return new RestMessage(code);
    }

    @ApiOperation(value = "deletetest",notes = "deletetest测试说明2")
    @DeleteMapping(value = "/deletetest")
    @ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "query")
    public RestMessage deletetest(@RequestParam(value = "code") String code){
        return new RestMessage(code);
    }

   @PostMapping("/reqbody")
    @ApiOperation(value = "RequestBody接口类型",notes = "RequestBody测试接口,实体类型")
    public RestMessage reqbody(@RequestBody ReqEntity reqEntity){
        return new RestMessage(reqEntity);
    }
    @PostMapping("/reqbody2")
    @ApiOperation(value = "RequestBody接口类型2",notes = "RequestBody测试接口2-string类型")
    public RestMessage reqbody2(@RequestBody String reqEntity){
        return new RestMessage(reqEntity);
    }

    @PostMapping("/reqbody1")
    @ApiOperation(value = "ModelAttribute",notes = "ModelAttribute类型参数")
    public RestMessage reqbody1(@ModelAttribute ReqEntity reqEntity){
        return new RestMessage(reqEntity);
    }

    @PostMapping("/reqbody3")
    @ApiOperation(value = "header参数",notes = "header参数")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "query"),
            @ApiImplicitParam(value = "headerparam",name = "headerparam",dataType = "string",paramType = "header")
    })
    public RestMessage reqbody3(@RequestHeader(value = "headerparam") String headerparam,@RequestParam(value = "code") String code){
        return new RestMessage(ImmutableMap.of("code",code,"header",headerparam));
    }


    @ApiOperation(value = "文件素材上传接口")
    @ApiImplicitParam(name = "file",value = "文件流对象,接收数组格式",required = true,dataType = "MultipartFile")
    @RequestMapping(value="/uploadMaterial",method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial(@RequestParam(value="file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        String realPath=request.getSession().getServletContext().getRealPath("/upload");
        File realFile=new File(realPath);
        if (!realFile.exists()){
            realFile.mkdirs();
        }
        List<Map> uploadFiles= Lists.newArrayList();
        System.out.println("进入图片上传接口:"+files.length +"张");
        for (MultipartFile file : files) {
            File targetFile=new File(realFile,file.getOriginalFilename());
            FileOutputStream fileOutputStream=null;
            InputStream ins=null;
            try{
                fileOutputStream=new FileOutputStream(targetFile);
                int i=-1;
                byte[] bytes=new byte[1024*1024];
                ins=file.getInputStream();
                while ((i=ins.read(bytes))!=-1){
                    fileOutputStream.write(bytes,0,i);
                }
            }catch (IOException e){
            }finally {
                closeQuilty(ins);
                closeQuilty(fileOutputStream);
            }
            Map fileInfo= Maps.newHashMap();
            fileInfo.put("id", UUID.randomUUID().toString());
            fileInfo.put("url",targetFile.getPath());
            fileInfo.put("original_name",targetFile.getName());
            uploadFiles.add(fileInfo);
        }
        RestMessage rm=new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }


    private void closeQuilty(InputStream ins){
        if (ins!=null){
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private void closeQuilty(OutputStream out){
        if (out!=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
