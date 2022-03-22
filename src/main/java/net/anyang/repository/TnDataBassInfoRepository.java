package net.anyang.repository;

import net.anyang.Model.Tn_data_bass_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TnDataBassInfoRepository extends JpaRepository<Tn_data_bass_info,Long>, JpaSpecificationExecutor<Tn_data_bass_info> {
    Tn_data_bass_info findOneByDtstsn(Long dtst_sn);

//    Tn_data_bass_info findOneBy

}
