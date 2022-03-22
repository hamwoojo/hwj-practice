package net.anyang.repository;

import net.anyang.Model.Tn_data_clct_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TnDataClctLogRepository extends JpaRepository<Tn_data_clct_log,Long>, JpaSpecificationExecutor<Tn_data_clct_log> {
    Tn_data_clct_log findByClctLogSn(Long clct_log_sn);

    Tn_data_clct_log findOneByClctLogSn(Long clct_log_sn);

}
