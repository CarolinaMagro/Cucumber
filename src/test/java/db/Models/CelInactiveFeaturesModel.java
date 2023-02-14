package db.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cel_inactive_features")
public class CelInactiveFeaturesModel {

    @Id
    @Column(name = "PIF_CLU_CELLULAR_NUMBER")
    private String pif_clu_cellular_number;
    @Column(name = "PIF_FTR_ID")
    private String pif_ftr_id;
    @Column(name = "PIF_START_DATE")
    private String pif_start_date;
    @Column(name = "PIF_END_DATE")
    private String pif_end_date;

}
