package com.zxw.service.impl;

import com.zxw.dao.CharacterResponseDao;
import com.zxw.domain.CharacterResponse;
import com.zxw.service.CharacterResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterResponseServiceImpl implements CharacterResponseService {

    @Autowired
    private CharacterResponseDao characterResponseDao;

    @Override
    public List<CharacterResponse> queryAllRole() {
        List<CharacterResponse> AllRole=characterResponseDao.queryAllRole();
        return AllRole;
    }

    @Override
    public void addRole(CharacterResponse characterResponse) {
        characterResponseDao.addRole(characterResponse);
    }

    @Override
    public void delete(String id) {
        characterResponseDao.deleteRole(id);
    }

    @Override
    public List<CharacterResponse> queryAllIdNameStoryId() {
        List<CharacterResponse> AllIdNameStoryId=characterResponseDao.queryAllIdNameStoryId();
        return AllIdNameStoryId;
    }

    @Override
    public int updateCharacterStoryId(CharacterResponse characterResponse) {
        return characterResponseDao.updateCharacterStoryId(characterResponse);
    }
}
