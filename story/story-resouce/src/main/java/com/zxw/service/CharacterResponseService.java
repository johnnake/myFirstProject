package com.zxw.service;

import com.zxw.domain.CharacterResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CharacterResponseService {


    List<CharacterResponse> queryAllRole();

    void addRole(CharacterResponse characterResponse);

    void delete(String id);

    List<CharacterResponse> queryAllIdNameStoryId();

    int updateCharacterStoryId(CharacterResponse characterResponse);

}
