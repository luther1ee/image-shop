package com.payup.imageshop.service;

import com.payup.imageshop.domain.CodeGroup;
import com.payup.imageshop.dto.CodeLabelValue;
import com.payup.imageshop.repository.CodeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeService {
    @Autowired
    private CodeGroupRepository repository;

    public List<CodeLabelValue> getCodeGroupList() throws Exception {
        List<CodeGroup> codeGroups = repository.findAll(Sort.by(Sort.Direction.ASC, "groupCode"));
        List<CodeLabelValue> codeGroupList = new ArrayList<CodeLabelValue>();

        for(CodeGroup codeGroup : codeGroups) {
            codeGroupList.add(new CodeLabelValue(codeGroup.getGroupCode(), codeGroup.getGroupName()));
        }

        return codeGroupList;

    }

    public List<CodeLabelValue> getCodeList(String classCode) {
        return null;
    }
}
