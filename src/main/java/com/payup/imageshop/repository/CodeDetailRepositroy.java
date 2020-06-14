package com.payup.imageshop.repository;

import com.payup.imageshop.domain.CodeDetail;
import com.payup.imageshop.domain.CodeDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeDetailRepositroy extends JpaRepository<CodeDetail, CodeDetailId> {
    @Query("SELECT max(cd.sortSeq) FROM CodeDetail cd WHERE cd.groupCode = ?1")
    public List<Object[]> getMaxSortSeq(String groupCode);
}
