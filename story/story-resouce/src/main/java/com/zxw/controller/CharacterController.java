package com.zxw.controller;
import com.zxw.domain.CharacterResponse;
import com.zxw.domain.MainRole;
import com.zxw.service.CharacterResponseService;
import com.zxw.service.StoryResouceService;
import com.zxw.util.RdName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    private  RdName rdName; // 假设已注入RdName类实例
    @Autowired
    private CharacterResponseService characterResponseService;


    @GetMapping("/characters")
    public List<CharacterResponse> generateCharacters() {
        List<CharacterResponse> characters = new ArrayList<>();

        // 根据需要生成一定数量的人物信息
        int numCharacters = 10; // 可调整为所需数量
        for (int i = 0; i < numCharacters; i++) {
            CharacterResponse character = rdName.generateRandomCharacter();
            characters.add(character);
        }
        return characters;
    }


    @RequestMapping( value = "/queryAllRole" ,method = RequestMethod.GET)
    public List<CharacterResponse> queryAllRole(){
        List<CharacterResponse> all= characterResponseService.queryAllRole();
        return all;

    }

    @PostMapping(value = "/addRole")
    public String addRole(@RequestBody CharacterResponse characterResponse){
        characterResponseService.addRole(characterResponse);
        return "sucess";

    }

    @GetMapping(value = "/deleteRole")
    public String deleteRole(String id){
        characterResponseService.delete(id);
        return "success";

    }

    @RequestMapping( value = "/queryAllIdNameStoryId" ,method = RequestMethod.GET)
    public List<CharacterResponse> queryAllIdNameStoryId(){
        List<CharacterResponse> all= characterResponseService.queryAllIdNameStoryId();
        return all;

    }

    @PutMapping("/updateCharacterResponseStoryId/{id}")
    public ResponseEntity<String> updateCharacterStoryId(@PathVariable int id, @RequestBody CharacterResponse characterResponse) {
        characterResponse.setId(id); // 确保ID与路径中的ID一致
        int rowsAffected = characterResponseService.updateCharacterStoryId(characterResponse);

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Story updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Story not found.");
        }
    }

}



