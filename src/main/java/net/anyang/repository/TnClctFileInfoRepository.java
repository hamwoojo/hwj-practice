package net.anyang.repository;

import net.anyang.Model.Tn_clct_file_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TnClctFileInfoRepository extends JpaRepository<Tn_clct_file_info,Long> , JpaSpecificationExecutor<Tn_clct_file_info> {
    Tn_clct_file_info findByClctFileSn(Long clct_file_sn);
}
