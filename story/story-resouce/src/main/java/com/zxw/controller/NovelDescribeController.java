package com.zxw.controller;

import com.zxw.domain.NovelDescribe;
import com.zxw.service.NovelDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NovelDescribe")
public class NovelDescribeController {

    @Autowired
    private NovelDescribeService novelDescribeService;

    @GetMapping("/findByNovelId/{novelId}")
    public ResponseEntity<List<NovelDescribe>> findByNovelId(@PathVariable int novelId) {
        List<NovelDescribe> novelDescribe =novelDescribeService.findNovelDescribeByNovelId(novelId);
        return novelDescribe != null ? ResponseEntity.ok(novelDescribe) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStory(@PathVariable int id, @RequestBody NovelDescribe novelDescribe) {
        novelDescribe.setId(id); // 确保ID与路径中的ID一致
        int rowsAffected = novelDescribeService.updateNovelDescribe(novelDescribe);

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Story updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Story not found.");
        }
    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody NovelDescribe novelDescribe){
        novelDescribeService.insertNovelDescribe(novelDescribe);
        return "success";

    }

}
