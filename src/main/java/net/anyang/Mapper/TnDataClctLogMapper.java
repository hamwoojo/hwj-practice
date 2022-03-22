package net.anyang.Mapper;

import net.anyang.Model.Tn_data_clct_log;
import net.anyang.dto.Tn_data_clct_log_Dto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TnDataClctLogMapper extends EntityMapper<Tn_data_clct_log_Dto, Tn_data_clct_log> {
    TnDataClctLogMapper Mapper = Mappers.getMapper(TnDataClctLogMapper.class);

    @Mapping(source = "clct_log_sn", target = "clctLogSn")
    Tn_data_clct_log toEntity(final Tn_data_clct_log_Dto dto);

    @Mapping(source = "clctLogSn" , target = "clct_log_sn")
    Tn_data_clct_log_Dto toDto(final Tn_data_clct_log entity);

    
}
