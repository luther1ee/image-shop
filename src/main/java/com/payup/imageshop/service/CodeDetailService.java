package com.payup.imageshop.service;

import com.payup.imageshop.domain.CodeDetail;
import com.payup.imageshop.domain.CodeDetailId;
import com.payup.imageshop.repository.CodeDetailRepositroy;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CodeDetailService {

    @Autowired
    private CodeDetailRepositroy repositroy;

    public void register(CodeDetail codeDetail) throws Exception {
        String groupCode = codeDetail.getGroupCode();
        List<Object[]> rsList = repositroy.getMaxSortSeq(groupCode);

        Integer maxSortSeq = 0;

        if (rsList.size() > 0) {
            Object[] maxValues = rsList.get(0);
            log.info(String.valueOf(maxValues));

            if ( maxValues != null && maxValues.length > 0 ) {
                maxSortSeq = (Integer) maxValues[0];
            }
        }

        codeDetail.setSortSeq(maxSortSeq + 1);

        repositroy.save(codeDetail);
    }

    public Object list() throws Exception {
        return repositroy.findAll(Sort.by(Sort.Direction.ASC, "groupCode", "codeValue"));
    }

    public Object read(CodeDetail codeDetail) throws Exception {
        CodeDetailId codeDetailId = new CodeDetailId();

        codeDetailId.setGroupCode(codeDetail.getGroupCode());
        codeDetailId.setCodeValue(codeDetail.getCodeValue());

        return repositroy.getOne(codeDetailId);
    }

    public void remove(CodeDetail codeDetail) throws Exception {
        CodeDetailId codeDetailId = new CodeDetailId();
        codeDetailId.setGroupCode(codeDetail.getGroupCode());
        codeDetailId.setCodeValue(codeDetail.getCodeValue());

        repositroy.deleteById(codeDetailId);
    }

    public void modify(CodeDetail codeDetail) throws Exception {
        CodeDetailId codeDetailId = new CodeDetailId();

        codeDetailId.setGroupCode(codeDetail.getGroupCode());
        codeDetailId.setCodeValue(codeDetail.getCodeValue());

        CodeDetail codeDetail1Entity = repositroy.getOne(codeDetailId);

        codeDetail1Entity.setCodeName(codeDetail.getCodeName());
        codeDetail1Entity.setCodeValue(codeDetail.getCodeValue());

        repositroy.save(codeDetail1Entity);
    }
}
