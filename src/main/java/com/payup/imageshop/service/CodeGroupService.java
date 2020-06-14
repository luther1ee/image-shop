package com.payup.imageshop.service;

import com.payup.imageshop.domain.CodeGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.payup.imageshop.repository.CodeGroupRepository;

import java.util.List;

@Service
public class CodeGroupService {

    @Autowired
    private CodeGroupRepository repository;

    public void register(CodeGroup codeGroup) throws Exception {
        repository.save(codeGroup);
    }

    public CodeGroup read(String groupCode) throws Exception {
        return repository.getOne(groupCode);
    }

    public void remove(String groupCode) throws Exception {
        repository.deleteById(groupCode);
    }

    public void modify(CodeGroup codeGroup) throws Exception {
        CodeGroup codeGroupEntity = repository.getOne(codeGroup.getGroupCode());

        codeGroupEntity.setGroupName(codeGroup.getGroupName());

        repository.save(codeGroupEntity);
    }

    public List<CodeGroup> list(){

        return repository.findAll(Sort.by(Sort.Direction.DESC, "groupCode"));
    }
}
