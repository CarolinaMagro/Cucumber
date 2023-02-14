package db.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticklers")
public class TicklersModel {

    @Id
    @Column(name = "TCK_ID")
    private String tck_id;

    @Column(name = "TCK_OPENED_DATE")
    private String tck_opened_date;

    @Column(name = "TCK_CLOSED_DATE")
    private String tck_closed_date;

    @Column(name = "TCK_DESCRIPTION")
    private String tck_description;

    @Column(name = "TCK_FOLLOW_UP_DATE")
    private String tck_follow_up_date;

    @Column(name = "TCK_PRIORITY")
    private String tck_priority;

    @Column(name = "TCK_USR_ID")
    private String tck_usr_id;

    @Column(name = "TCK_AR_RSN_ID")
    private String tck_ar_rsn_id;

    @Column(name = "TCK_AR_ACT_ID")
    private String tck_ar_act_id;

    @Column(name = "TCK_STT_ID")
    private String tck_stt_id;

    @Column(name = "TCK_USR_ID_MADE_BY")
    private String tck_usr_id_made_by;


    @Column(name = "TCK_TCK_ID")
    private String tck_tck_id;

    @Column(name = "TCK_UGR_ID")
    private String tck_ugr_id;

    @Column(name = "TCK_ACC_ID")
    private String tck_acc_id;

    @Column(name = "TCK_ACT_ID")
    private String tck_act_id;

    @Column(name = "TCK_CLU_CELLULAR_NUMBER")
    private String tck_clu_cellular_number;

    @Column(name = "TCK_MAIL_FLAG")
    private String tck_mail_flag;

    @Column(name = "TCK_LAST_UPDATED_DATE")
    private String tck_last_updated_date;

    @Column(name = "TCK_TICKET_NUMBER")
    private String tck_ticket_number;

    @Column(name = "TCK_NCL_IDENTIFICATION_TYPE")
    private String tck_ncl_identification_type;

    @Column(name = "TCK_NCL_IDENTIFICATION_NUMBER")
    private String tck_ncl_identification_number;

    @Column(name = "TCK_PROCESS_DATE")
    private String tck_process_date;

    @Column(name = "TCK_INPUT_DATE")
    private String tck_input_date;

    @Column(name = "TCK_NCL_ID")
    private String tck_ncl_id;

    @Column(name = "TCK_AUD_DATE")
    private String tck_aud_date;


}

