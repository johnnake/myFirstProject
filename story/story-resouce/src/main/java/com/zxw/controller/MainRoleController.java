package com.zxw.controller;


import com.zxw.domain.MainRole;
import com.zxw.service.MainRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MainRole")
public class MainRoleController {

    @Autowired
    private MainRoleService mainRoleService;

    @GetMapping("/findByNovelId/{novelId}")
    public ResponseEntity<List<MainRole>> findByNovelId(@PathVariable int novelId) {
        List<MainRole> mainRole =mainRoleService.findMainRoleByNovelId(novelId);
        System.out.println(mainRole);
        return mainRole != null ? ResponseEntity.ok(mainRole) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStory(@PathVariable int id, @RequestBody MainRole mainRole) {
        mainRole.setId(id); // 确保ID与路径中的ID一致
        int rowsAffected = mainRoleService.updateMainRole(mainRole);

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Story updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Story not found.");
        }
    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody MainRole mainRole){
        mainRoleService.insertMainRole(mainRole);
        return "success";

    }

}
