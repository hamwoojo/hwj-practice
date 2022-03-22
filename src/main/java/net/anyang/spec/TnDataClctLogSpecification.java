package net.anyang.spec;

import lombok.extern.slf4j.Slf4j;
import net.anyang.Model.Params.LogParams;
import net.anyang.Model.Tn_data_clct_log;
import net.anyang.Model.Tn_data_clct_log_;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Slf4j
public class TnDataClctLogSpecification {
    public static Specification<Tn_data_clct_log> searchByDtstsn(LogParams searchParam) {
        return ((root, query, cb) -> {

            Predicate result = null;
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(searchParam.getDtst_sn()) && searchParam.getDtst_sn() > 0) {
                predicates.add(
                        cb.equal(root.get(Tn_data_clct_log_.dtst_sn),searchParam.getDtst_sn())
                );
            }
            if (StringUtils.isNotBlank(searchParam.getClct_data_nm())) {
                predicates.add(
                        cb.like(root.get(Tn_data_clct_log_.clct_data_nm),"%" + searchParam.getClct_data_nm() + "%")
                );
            }
            if (StringUtils.isNotBlank(searchParam.getAdminist_realm_cd())) {
                predicates.add(
                        cb.equal(root.get(Tn_data_clct_log_.administ_realm_cd),searchParam.getAdminist_realm_cd())
                );
            }
            if (StringUtils.isNotBlank(searchParam.getClct_ymd())) {
                predicates.add(
                        cb.equal(root.get(Tn_data_clct_log_.clct_ymd),searchParam.getClct_ymd())
                );
            }
            if (StringUtils.isNotBlank(searchParam.getFile_clct_sttus_cd())) {
                predicates.add(
                        cb.equal(root.get(Tn_data_clct_log_.file_clct_sttus_cd),searchParam.getFile_clct_sttus_cd())
                );
            }
            for(Predicate p : predicates) {
                if (result == null) {
                    result = cb.and(p);
                } else {
                    result = cb.and(result, p);
                }
            }

            query.distinct(true);
            query.orderBy(cb.desc(root.get(Tn_data_clct_log_.dtst_sn)));

            return result;
        });

    }


    public static Specification<Tn_data_clct_log> searchByClctLogSn(Long clct_log_sn) {
        return ((root, query, cb) -> {

            Predicate result = null;
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(clct_log_sn) && clct_log_sn > 0) {
                predicates.add(
                        cb.equal(root.get(Tn_data_clct_log_.clctLogSn),clct_log_sn)
                );
            }

            for(Predicate p : predicates) {
                if (result == null) {
                    result = cb.and(p);
                } else {
                    result = cb.and(result, p);
                }
            }

            query.distinct(true);
            query.orderBy(cb.desc(root.get(Tn_data_clct_log_.dtst_sn)));

            return result;
        });

    }

}
