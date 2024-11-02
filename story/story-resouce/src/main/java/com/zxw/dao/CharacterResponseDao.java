package com.zxw.dao;

import com.zxw.domain.CharacterResponse;
import com.zxw.domain.MainRole;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface CharacterResponseDao {

    List<CharacterResponse> queryAllRole();
    void addRole(CharacterResponse characterResponse);
    void deleteRole(String id);
    List<CharacterResponse> queryAllIdNameStoryId();

    int updateCharacterStoryId(CharacterResponse characterResponse);

}
