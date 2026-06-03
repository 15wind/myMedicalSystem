package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.Drug;
import com.example.mymedicalsystem.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("drugs")
public class DrugController {

    @Autowired
    private DrugService drugService;

    private static final String IMAGE_UPLOAD_DIR = "src/main/resources/static/images/drugs/";

    @GetMapping("/getAllDrugs")
    public List<Drug> getAllDrugs() {
        return drugService.list();
    }

    @GetMapping("/searchDrugs")
    public List<Drug> searchDrugs(@RequestParam("keyword") String keyword) {
        return drugService.searchDrugs(keyword);
    }

    @PostMapping("/addDrug")
    public ResponseEntity<String> addDrug(@RequestBody Drug drug) {
        // 调用 service 层 save 方法，内部已处理 ID 生成
        boolean result = drugService.save(drug);
        return result?
                new ResponseEntity<>("药品添加成功", HttpStatus.CREATED) :
                new ResponseEntity<>("药品添加失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updateDrug")
    public ResponseEntity<String> updateDrug(@RequestBody Drug drug) {
        drug.setUpdatetime(new Date());
        boolean result = drugService.updateById(drug);
        return result?
                new ResponseEntity<>("药品更新成功", HttpStatus.OK) :
                new ResponseEntity<>("药品更新失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deleteDrug/{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable Long id) {
        boolean result = drugService.removeById(id);
        return result?
                new ResponseEntity<>("药品删除成功", HttpStatus.OK) :
                new ResponseEntity<>("药品删除失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            // 确保获取到正确的文件后缀
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 生成简短的文件名，使用 UUID 的前 10 位
            String shortUuid = UUID.randomUUID().toString().substring(0, 10);
            // 拼接文件名和后缀
            String fileName = shortUuid + fileExtension;

            File directory = new File(IMAGE_UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Path path = Paths.get(IMAGE_UPLOAD_DIR + fileName);
            Files.write(path, file.getBytes());

            ImageUploadResponse response = new ImageUploadResponse();
            response.setFileName(fileName);
            response.setUrl("/images/drugs/" + fileName);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    static class ImageUploadResponse {
        private String fileName;
        private String url;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}