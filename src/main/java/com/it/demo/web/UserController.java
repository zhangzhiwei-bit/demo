package com.it.demo.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.it.demo.model.Comments;
import com.it.demo.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
    @Autowired
    private CommentService commentService;

    // @Autowired
    // private RestTemplate restTemplate;


    @RequestMapping(value = "/upimages")
    @ResponseBody
    public Object addComment(MultipartFile file,HttpServletRequest request){
        if (file.isEmpty()) {
            System.out.println("文件为h空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        // String filePath = "D://Desktop//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        // String  path=request.getServletContext().getRealPath("/image");
        String path="/home/images";
        File dest = new File(path,fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(path+File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // String filename = path + fileName;
        // System.out.println(request.getParameter("username"));
        Map<String,String> map=new HashMap<>();
        map.put("url", fileName);
        return map;
    }
    
    @RequestMapping("/addcomments")
    @ResponseBody
    public Object addcomment(Comments comments,HttpServletRequest request){
        // Date time=new Date(System.currentTimeMillis());
        // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm");
        // String current=sdf.format(time);
        // System.out.println(current);
        comments.setTime(new Date());
        System.out.println(comments);
        System.out.println(commentService.addComment(comments));
        return "success";
    }

    @RequestMapping("/getAllcomments")
    @ResponseBody
    public Object getAllcomments() {
        List<Comments> comments= commentService.getAllComments();
        return comments;
    }

    // @RequestMapping("/wxUserInfo")
    // @ResponseBody
    // public Object getUserInfo(HttpServletRequest request){
    //     String code=request.getParameter("code");
    //     String appid="wxb5ce73ff5e3739a3";
    //     String secret="7db4076da6c99e28e8ef44730c9828ac";
    //     String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code=" + code+"&grant_type=authorization_code";
    //     ResponseEntity <String> responseEntity=restTemplate.getForEntity(url, String.class);
    //     System.out.println(responseEntity.getBody());
    //     return responseEntity.getBody();
    // }
    
}
