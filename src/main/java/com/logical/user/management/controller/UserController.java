package com.logical.user.management.controller;

import com.logical.user.management.classes.MyOrder;
import com.logical.user.management.classes.ProductData;
import com.logical.user.management.entity.UserData;
import com.logical.user.management.service.FileService;
import com.logical.user.management.service.UserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserInterface userInterface;
    @Autowired
    FileService fileService;
    @Autowired
    RestTemplate restTemplate;
    @Value("${project.image}")
    String path;

    MyOrder myOrder;
//    @Autowired
//    private ObjectMapper objectMapper;

    private Logger logger= LoggerFactory.getLogger(UserController.class);

    @PostMapping("/save")
    public ResponseEntity<?>addUser(@RequestBody UserData userData){
        return ResponseEntity.ok(userInterface.addNewUser(userData));
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?>getAllUsers(@RequestParam(name="pageNumber",defaultValue="1",required = false)int pageNumber,@RequestParam(name="pageSize",defaultValue = "4",required = false)int pageSize){
        return ResponseEntity.ok(userInterface.getAllUser(pageNumber,pageSize));
    }

    @GetMapping("/getUserByKeyWord/{keyword}")
    public ResponseEntity<?> getUserByKeyword(@PathVariable String keyword){
        return ResponseEntity.ok(userInterface.getUserByKeyword(keyword));
    }
    @PostMapping("/upload/{userId}")
    public ResponseEntity<?>uploadImage(@RequestParam(name="file",required = false)MultipartFile multipartFile,@PathVariable int userId) throws IOException {
        UserData userData=userInterface.getUserById(userId);
        userData.setImg(this.fileService.uploadFile(path,multipartFile));
       // userData=this.userInterface.updateUser(userData,userId);
       return ResponseEntity.ok(userData);
    }
    @GetMapping("/getById/{userId}")
    public UserData getUserById(@PathVariable int userId){
        //convert string into json
        //UserData userData=objectMapper.readValue(userDataparam,UserData.class);
        return userInterface.getUserById(userId);
    }
    @PostMapping("/upload/manyimg")
    public ResponseEntity<?> uploadMultipleFiles(@RequestParam("files")MultipartFile[] files){
           this.logger.info("Number of files uploaded - "+files.length);
        Arrays.stream(files).forEach(multipartFile -> {
                 logger.info("file name : {} "+multipartFile.getOriginalFilename());
                 logger.info("file type : {} "+multipartFile.getContentType());
            }
        );
        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/getMyorders/{userId}")
    public ResponseEntity<MyOrder>getMyOrders(@PathVariable int userId){
       UserData userData= userInterface.getUserById(userId);
       int productId=userData.getProductId();
       ProductData productData=restTemplate.getForObject("http://PRODUCT:9091/getProductById/"+productId,ProductData.class);
       myOrder.setUserData(userData);
       myOrder.setProductData(productData);
        return ResponseEntity.ok(myOrder);
    }

}
