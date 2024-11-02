package com.zxw.controller;


import com.zxw.domain.StoryResouce;
import com.zxw.service.StoryResouceService;

import com.zxw.util.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryResouceController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StoryResouceController.class);

    private final StoryResouceService storyResouceService;

    @Autowired
    public StoryResouceController(StoryResouceService storyResouceService) {
        this.storyResouceService = storyResouceService;
    }
    @GetMapping(value = "/findAllWithPagination")
    public ResponseEntity<PageResult<StoryResouce>> findAllWithPagination(
            @RequestParam(defaultValue = "1",value = "currentPage") int currentPage,
            @RequestParam(defaultValue = "10",value = "pageSize") int pageSize) {

        PageResult<StoryResouce> pageResult = storyResouceService.findStoryResourcesWithPagination(currentPage, pageSize);
        return ResponseEntity.ok(pageResult);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStory(@PathVariable String id, @RequestBody StoryResouce storyResouce) {
        storyResouce.setId(id); // 确保ID与路径中的ID一致
        int rowsAffected = storyResouceService.updateStory(storyResouce);

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Story updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Story not found.");
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<StoryResouce> findById(@PathVariable String id) {
        StoryResouce storyResouce = storyResouceService.findById(id);
        return storyResouce != null ? ResponseEntity.ok(storyResouce) : ResponseEntity.notFound().build();
    }

    @RequestMapping( value = "/findAll" ,method =RequestMethod.GET)
    public List<StoryResouce> findAll(){
        List<StoryResouce> all= storyResouceService.findAll();
        return all;

    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody StoryResouce storyResouce){
            storyResouceService.insert(storyResouce);
            return "sucess";

    }

    @GetMapping(value = "/delete")
    public String delete(String id){
        storyResouceService.delete(id);
        return "success";

    }

    @GetMapping("/findAllById/{imageId}")
    public List<StoryResouce> getStoriesByImageId(@PathVariable Integer imageId) {
        return storyResouceService.findStoriesByImageId(imageId);
    }

    @GetMapping("/findStoriesByImageIdWithPagination/{imageId}")
    public ResponseEntity<PageResult<StoryResouce>> findStoriesByImageIdWithPagination(
            @PathVariable("imageId") int imageId,
            @RequestParam(defaultValue = "1") int currentPage,
            @RequestParam(defaultValue = "10") int pageSize) {
        // 调用Service方法获取分页故事列表
        PageResult<StoryResouce> pageResult = storyResouceService.findStoriesByImageIdWithPagination(imageId, currentPage, pageSize);
        return ResponseEntity.ok(pageResult);

    }

}
