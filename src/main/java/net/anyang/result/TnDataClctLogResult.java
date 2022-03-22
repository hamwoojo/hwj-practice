package net.anyang.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.anyang.Model.Tn_data_clct_log;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TnDataClctLogResult {

    Page<Tn_data_clct_log> page;
    List<Tn_data_clct_log> tn_data_clct_logs;
}
