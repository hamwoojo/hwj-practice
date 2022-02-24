package net.hwj.practice.repository;

import net.hwj.practice.model.Tn_data_bass_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TnDataBassInfoRepository extends JpaRepository<Tn_data_bass_info,String> , JpaSpecificationExecutor<Tn_data_bass_info> {

    Tn_data_bass_info findOneByInnerClctTblPhysiclNm(String tb_nm);

//    @Query
//    List<String> findUrlByTb_nm(String tb_nm);

    List<Tn_data_bass_info> findAllByInnerClctTblPhysiclNm(String tb_nm);

}
