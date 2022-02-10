package net.hwj.practice.repository;

import net.hwj.practice.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiRepository extends JpaRepository<Api,String> , JpaSpecificationExecutor<Api> {

    Api findOneByTbnm(String tb_nm);

//    @Query
//    List<String> findUrlByTb_nm(String tb_nm);

}
